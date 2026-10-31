package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_4587;

/**
 * Daamky-style ClickGUI — максимально близкая реализация стиля из rar.
 *
 * Возможности:
 * - Центрированное окно
 * - Левый сайдбар с категориями + иконками
 * - Блок пользователя внизу сайдбара
 * - Поиск
 * - Модули с анимацией включения
 * - ПКМ — раскрытие настроек (полные SettingWidget'ы)
 * - Скролл списка
 * - Запоминание выбранной категории и скролла
 * - Переключение через настройку Design в модуле ClickGUI
 */
public class DaamkyClickGuiScreen extends class_437 implements MinecraftAccess {

   private static DaamkyClickGuiScreen INSTANCE;

   // Сохраняемое состояние между открытиями
   private static ModuleCategory savedCategory = null;
   private static float savedScroll = 0f;

   private final Animation openAnim = new Animation(200L, 1.0, false, EasingCurve.field1011);
   private final Animation scaleAnim = new Animation(230L, 1.0, false, EasingCurve.field0330);

   private ModuleCategory selectedCategory;
   private final List<DaamkyModuleEntry> moduleEntries = new ArrayList<>();
   private String searchQuery = "";
   private boolean searchFocused = false;

   private boolean closing = false;
   private long closeStart = -1L;
   private long lastToggleTime = 0L;

   // Размеры максимально близкие к rar (400×250)
   private float winX, winY;
   private final float winW = 400f;
   private final float winH = 255f;
   private final float sidebarW = 88f;

   private float scrollOffset = 0f;
   private float maxScroll = 0f;

   private static FontSize fontCat;
   private static FontSize fontModule;
   private static FontSize fontSmall;
   private static FontSize fontTiny;
   private static boolean fontsInit = false;

   public DaamkyClickGuiScreen() {
      super(class_2561.method_43470("daamky.menu"));
      INSTANCE = this;
      selectedCategory = savedCategory != null ? savedCategory : ModuleCategory.values()[0];
      DaamkyClient.method2004().method2072().subscribe(this);
      rebuildModules();
   }

   public static DaamkyClickGuiScreen getInstance() {
      if (INSTANCE == null) {
         INSTANCE = new DaamkyClickGuiScreen();
      }
      return INSTANCE;
   }

   private static void initFonts() {
      if (!fontsInit) {
         fontCat = Fonts.field0075.method0654(6.5F);
         fontModule = Fonts.field0075.method0654(6.5F);
         fontSmall = Fonts.field0075.method0654(6.0F);
         fontTiny = Fonts.field0075.method0654(5.5F);
         fontsInit = true;
      }
   }

   public void open() {
      closing = false;
      closeStart = -1L;
      openAnim.method1570(true);
      openAnim.method1634();
      scaleAnim.method1570(true);
      scaleAnim.method1634();
      searchQuery = "";
      searchFocused = false;
      scrollOffset = savedScroll;
      if (savedCategory != null) {
         selectedCategory = savedCategory;
      }
      rebuildModules();
      field0796.method_1507(this);
   }

   private void saveState() {
      savedCategory = selectedCategory;
      savedScroll = scrollOffset;
   }

   private void rebuildModules() {
      moduleEntries.clear();
      List<Module> modules = DaamkyClient.method2004().method1783().method0019().stream()
         .filter(m -> !m.method1891())
         .filter(m -> m.method2220() == selectedCategory)
         .filter(m -> searchQuery.isEmpty()
            || m.method0423().toLowerCase(Locale.ROOT).contains(searchQuery.toLowerCase(Locale.ROOT)))
         .sorted((a, b) -> a.method0423().compareToIgnoreCase(b.method0423()))
         .collect(Collectors.toList());

      for (Module m : modules) {
         moduleEntries.add(new DaamkyModuleEntry(m));
      }
   }

   private String categoryLabel(ModuleCategory cat) {
      String n = cat.name();
      if (n.contains("0661")) return "Combat";
      if (n.contains("0088")) return "Move";
      if (n.contains("1470")) return "Player";
      if (n.contains("1004")) return "Render";
      if (n.contains("0776")) return "Misc";
      return cat.method0557();
   }

   @Override
   public void method_25394(class_332 ctx, int mouseX, int mouseY, float delta) {
      initFonts();

      float alpha = openAnim.method0002();
      if (closing) {
         long t = System.currentTimeMillis() - closeStart;
         if (t > 240L) {
            saveState();
            field0796.method_1507(null);
            closing = false;
            return;
         }
         alpha = 1.0F - Math.min(1.0F, t / 240.0F);
      }

      // Затемнение фона
      int dimA = (int) (145 * alpha);
      ctx.method_25294(0, 0, this.field_22789, this.field_22790, (dimA << 24));

      winX = (this.field_22789 - winW) / 2.0F;
      winY = (this.field_22790 - winH) / 2.0F;

      float scale = 0.86F + 0.14F * scaleAnim.method0002();
      class_4587 matrices = ctx.method_51448();
      matrices.method_22903();
      float cx = winX + winW / 2.0F;
      float cy = winY + winH / 2.0F;
      matrices.method_46416(cx, cy, 0.0F);
      matrices.method_22905(scale, scale, 1.0F);
      matrices.method_46416(-cx, -cy, 0.0F);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, alpha);

      // ===== Главное окно =====
      Color winBg = new Color(29, 30, 38, (int) (252 * alpha));
      Color winBorder = new Color(48, 50, 63, (int) (190 * alpha));
      GuiRenderHelper.method1463(matrices, winX, winY, winW, winH, 8.0F, winBg);
      GuiRenderHelper.method1461(matrices, winX, winY, winW, winH, 8.0F, 1.0F, 1.0F, winBorder);

      // ===== Сайдбар =====
      Color sideBg = new Color(22, 23, 29, (int) (255 * alpha));
      GuiRenderHelper.method1463(matrices, winX, winY, sidebarW, winH, 8.0F, sideBg);
      GuiRenderHelper.method1463(matrices, winX + sidebarW - 8, winY, 8, winH, 0.0F, sideBg);

      // Разделитель
      GuiRenderHelper.method1463(matrices, winX + sidebarW - 1.0F, winY + 8, 1.0F, winH - 16, 0.0F,
         new Color(50, 52, 65, (int) (140 * alpha)));

      // ===== Категории =====
      float catY = winY + 10;
      for (ModuleCategory cat : ModuleCategory.values()) {
         boolean selected = cat == selectedCategory;
         boolean hovered = MathHelper.method0689(winX + 4, catY, sidebarW - 8, 20, mouseX, mouseY);

         if (selected) {
            Color accent = new Color(ThemePalette.field0567);
            GuiRenderHelper.method1463(matrices, winX + 4, catY, sidebarW - 8, 20, 4.5F,
               new Color(accent.getRed(), accent.getGreen(), accent.getBlue(), (int) (185 * alpha)));
         } else if (hovered) {
            GuiRenderHelper.method1463(matrices, winX + 4, catY, sidebarW - 8, 20, 4.5F,
               new Color(40, 42, 53, (int) (160 * alpha)));
         }

         String icon = cat.method0557();
         String label = categoryLabel(cat);
         Color textCol = selected ? Color.WHITE : new Color(170, 174, 190, (int) (255 * alpha));
         GuiRenderHelper.method1491(matrices, fontCat, icon + " " + label, winX + 10, catY + 6, textCol);

         catY += 23;
      }

      // ===== Блок пользователя (внизу сайдбара) =====
      float userH = 38f;
      float userY = winY + winH - userH - 6;
      GuiRenderHelper.method1463(matrices, winX + 5, userY, sidebarW - 10, userH, 5.0F,
         new Color(32, 33, 42, (int) (220 * alpha)));
      GuiRenderHelper.method1461(matrices, winX + 5, userY, sidebarW - 10, userH, 5.0F, 0.6F, 0.6F,
         new Color(55, 57, 70, (int) (120 * alpha)));

      // Круглый аватар-заглушка
      float avSize = 22f;
      float avX = winX + 10;
      float avY = userY + (userH - avSize) / 2f;
      Color accent = new Color(ThemePalette.field0567);
      GuiRenderHelper.method1463(matrices, avX, avY, avSize, avSize, avSize / 2f,
         new Color(accent.getRed(), accent.getGreen(), accent.getBlue(), (int) (200 * alpha)));

      String playerName = "Player";
      try {
         if (field0796.field_1724 != null) {
            playerName = field0796.field_1724.method_5477().getString();
            if (playerName.length() > 10) playerName = playerName.substring(0, 9) + "…";
         }
      } catch (Exception ignored) {}
      GuiRenderHelper.method1491(matrices, fontTiny, playerName, avX + avSize + 5, userY + 10, 
         new Color(220, 223, 235, (int) (255 * alpha)));
      GuiRenderHelper.method1491(matrices, fontTiny, "Online", avX + avSize + 5, userY + 20, 
         new Color(100, 200, 130, (int) (220 * alpha)));

      // ===== Поиск =====
      float searchX = winX + sidebarW + 10;
      float searchY = winY + 8;
      float searchW = winW - sidebarW - 20;
      GuiRenderHelper.method1463(matrices, searchX, searchY, searchW, 17, 4.0F,
         new Color(17, 18, 24, (int) (240 * alpha)));
      GuiRenderHelper.method1461(matrices, searchX, searchY, searchW, 17, 4.0F, 0.65F, 0.65F,
         new Color(52, 54, 68, (int) (130 * alpha)));

      String searchText = searchQuery.isEmpty() && !searchFocused ? "Search..." : searchQuery;
      if (searchFocused && (System.currentTimeMillis() % 1000) < 480) {
         searchText += "_";
      }
      Color searchCol = (searchQuery.isEmpty() && !searchFocused)
         ? new Color(90, 94, 110, (int) (190 * alpha))
         : new Color(222, 225, 238, (int) (255 * alpha));
      GuiRenderHelper.method1491(matrices, fontSmall, searchText, searchX + 6, searchY + 4.5F, searchCol);

      // ===== Модули =====
      float modX = winX + sidebarW + 9;
      float modY = winY + 30;
      float modW = winW - sidebarW - 18;
      float viewH = winH - 40;

      float totalH = 0f;
      for (DaamkyModuleEntry e : moduleEntries) {
         totalH += e.getHeight() + 2.5f;
      }
      maxScroll = Math.max(0f, totalH - viewH);
      if (scrollOffset > maxScroll) scrollOffset = maxScroll;

      float offsetY = modY - scrollOffset;
      for (DaamkyModuleEntry entry : moduleEntries) {
         float h = entry.getHeight();
         // Рисуем только видимые
         if (offsetY + h > modY - 4 && offsetY < modY + viewH + 4) {
            entry.render(ctx, matrices, modX, offsetY, modW, mouseX, mouseY, delta, alpha);
         }
         offsetY += h + 2.5f;
      }

      // Скроллбар
      if (maxScroll > 2f) {
         float barH = Math.max(18f, viewH * (viewH / (totalH + 0.1f)));
         float barY = modY + (viewH - barH) * (scrollOffset / Math.max(0.01f, maxScroll));
         GuiRenderHelper.method1463(matrices, winX + winW - 5.5F, barY, 2.2F, barH, 1.2F,
            new Color(75, 78, 95, (int) (150 * alpha)));
      }

      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      matrices.method_22909();
   }

   @Override
   public boolean method_25402(double mouseX, double mouseY, int button) {
      // Категории
      float catY = winY + 10;
      for (ModuleCategory cat : ModuleCategory.values()) {
         if (MathHelper.method0689(winX + 4, catY, sidebarW - 8, 20, mouseX, mouseY)) {
            if (button == 0) {
               selectedCategory = cat;
               scrollOffset = 0f;
               rebuildModules();
            }
            return true;
         }
         catY += 23;
      }

      // Поиск
      float searchX = winX + sidebarW + 10;
      float searchY = winY + 8;
      float searchW = winW - sidebarW - 20;
      if (MathHelper.method0689(searchX, searchY, searchW, 17, mouseX, mouseY)) {
         searchFocused = true;
         return true;
      } else {
         searchFocused = false;
      }

      // Модули
      float modX = winX + sidebarW + 9;
      float modY = winY + 30;
      float modW = winW - sidebarW - 18;
      float offsetY = modY - scrollOffset;
      for (DaamkyModuleEntry entry : moduleEntries) {
         float h = entry.getHeight();
         if (entry.mouseClicked(mouseX, mouseY, button, modX, offsetY, modW)) {
            return true;
         }
         offsetY += h + 2.5f;
      }

      return super.method_25402(mouseX, mouseY, button);
   }

   @Override
   public boolean method_25404(int keyCode, int scanCode, int modifiers) {
      if (keyCode == 256) { // ESC
         startClose();
         return true;
      }
      if (searchFocused) {
         if (keyCode == 259 && !searchQuery.isEmpty()) {
            searchQuery = searchQuery.substring(0, searchQuery.length() - 1);
            rebuildModules();
            return true;
         }
         if (keyCode == 257 || keyCode == 335) {
            searchFocused = false;
            return true;
         }
      }
      for (DaamkyModuleEntry entry : moduleEntries) {
         if (entry.expanded && entry.settingList != null
            && entry.settingList.method0746(keyCode, scanCode, modifiers)) {
            return true;
         }
      }
      return super.method_25404(keyCode, scanCode, modifiers);
   }

   @Override
   public boolean method_25400(char chr, int modifiers) {
      if (searchFocused && chr >= 32) {
         searchQuery += chr;
         rebuildModules();
         return true;
      }
      for (DaamkyModuleEntry entry : moduleEntries) {
         if (entry.expanded && entry.settingList != null
            && entry.settingList.method0149((int) chr, modifiers, 0)) {
            return true;
         }
      }
      return super.method_25400(chr, modifiers);
   }

   @Override
   public boolean method_25401(double mouseX, double mouseY, double horizontal, double vertical) {
      // Скролл списка
      if (MathHelper.method0689(winX + sidebarW, winY + 28, winW - sidebarW - 4, winH - 36, mouseX, mouseY)) {
         scrollOffset -= (float) (vertical * 13.0);
         scrollOffset = Math.max(0f, Math.min(maxScroll, scrollOffset));
         return true;
      }
      for (DaamkyModuleEntry entry : moduleEntries) {
         if (entry.expanded && entry.settingList != null
            && entry.settingList.method0623(mouseX, mouseY, horizontal, vertical)) {
            return true;
         }
      }
      return super.method_25401(mouseX, mouseY, horizontal, vertical);
   }

   private void startClose() {
      if (!closing) {
         closing = true;
         closeStart = System.currentTimeMillis();
         openAnim.method1570(false);
         scaleAnim.method1570(false);
         saveState();
      }
   }

   @Override
   public boolean method_25421() {
      return false;
   }

   @EventHandler
   private void keyEvent(KeyEvent e) {
      if (e.method1763() == 344) {
         long now = System.currentTimeMillis();
         if (now - lastToggleTime < 260L) return;
         lastToggleTime = now;

         if (field0796.field_1755 == null) {
            ClickGUI clickGui = ClickGUI.method1683();
            if (clickGui != null && clickGui.getDesign() == ClickGUI.Design.DAAMKY) {
               open();
            }
         } else if (field0796.field_1755 == this) {
            startClose();
         }
      }
   }

   // ======================== Module entry ========================

   private class DaamkyModuleEntry {
      final Module module;
      boolean expanded;
      final Animation expandAnim = new Animation(140L, 1.0, false, EasingCurve.field1011);
      final Animation enableAnim = new Animation(160L, 1.0, false, EasingCurve.field1011);
      SettingList settingList;
      final Animation animForSettings = new Animation(1L, 1.0, true, EasingCurve.field1011);

      DaamkyModuleEntry(Module m) {
         this.module = m;
         this.expanded = false;
         this.enableAnim.method1570(m.method2195());
         this.enableAnim.method1973();
         this.animForSettings.method1973();
      }

      float getHeight() {
         float base = 18.5F;
         if (expanded && settingList != null && !settingList.method1974()) {
            float settingsH = settingList.method1762();
            return base + 3.5F + settingsH * expandAnim.method0002();
         }
         return base;
      }

      void ensureSettings() {
         if (settingList == null && !module.method1914().isEmpty()) {
            List<SettingWidget> widgets = new ArrayList<>();
            for (Setting<?> s : module.method1914()) {
               SettingWidget w = SettingWidgetFactory.method0866(animForSettings, s);
               if (w != null) {
                  widgets.add(w);
               }
            }
            settingList = new SettingList(widgets);
         }
      }

      void render(class_332 ctx, class_4587 matrices, float x, float y, float w,
                 int mx, int my, float delta, float alpha) {

         enableAnim.method1570(module.method2195());
         enableAnim.method1973();
         float enableT = enableAnim.method0002();

         boolean hovered = MathHelper.method0689(x, y, w, 18.5f, mx, my);
         boolean hasSettings = !module.method1914().isEmpty();

         Color baseBg;
         if (enableT > 0.02F) {
            Color ac = new Color(ThemePalette.field0567);
            int a = (int) ((65 + 105 * enableT) * alpha);
            baseBg = new Color(ac.getRed(), ac.getGreen(), ac.getBlue(), a);
         } else {
            baseBg = new Color(35, 37, 47, (int) (210 * alpha));
         }
         if (hovered) {
            baseBg = new Color(
               Math.min(255, baseBg.getRed() + 12),
               Math.min(255, baseBg.getGreen() + 12),
               Math.min(255, baseBg.getBlue() + 14),
               baseBg.getAlpha());
         }

         float h = getHeight();
         GuiRenderHelper.method1463(matrices, x, y, w, h, 4.5F, baseBg);
         GuiRenderHelper.method1461(matrices, x, y, w, h, 4.5F, 0.6F, 0.6F,
            new Color(52, 54, 68, (int) (120 * alpha)));

         // Имя
         int textRgb = enableT > 0.4F ? 0xFFFFFFFF : 0xFFB8BCD0;
         Color nameCol = new Color((textRgb >> 16) & 0xFF, (textRgb >> 8) & 0xFF, textRgb & 0xFF, (int) (255 * alpha));
         GuiRenderHelper.method1491(matrices, fontModule, module.method0423(), x + 8, y + 5.5F, nameCol);

         // Стрелка
         if (hasSettings) {
            String arrow = expanded ? "▾" : "▸";
            Color arrowCol = new Color(130, 134, 150, (int) (200 * alpha));
            GuiRenderHelper.method1491(matrices, fontModule, arrow, x + w - 13, y + 5.5F, arrowCol);
         }

         // Настройки
         if (expanded) {
            ensureSettings();
            if (settingList != null && !settingList.method1974()) {
               expandAnim.method1973();
               float settingsAlpha = expandAnim.method0002();
               if (settingsAlpha > 0.03F) {
                  settingList.method0670(x + 6, y + 21).method0126(w - 12, -1.0F);
                  settingList.method0430();
                  RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, alpha * settingsAlpha);
                  settingList.method1414(ctx, mx, my, delta);
                  RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, alpha);
               }
            }
         }
      }

      boolean mouseClicked(double mx, double my, int button, float x, float y, float w) {
         if (expanded && settingList != null) {
            if (settingList.method0627(mx, my, button)) {
               return true;
            }
         }

         if (!MathHelper.method0689(x, y, w, 18.5f, mx, my)) {
            return false;
         }

         if (button == 0) {
            module.method1812();
            enableAnim.method1570(module.method2195());
            return true;
         }

         if (button == 1) {
            if (!module.method1914().isEmpty()) {
               expanded = !expanded;
               expandAnim.method1570(expanded);
               if (expanded) {
                  ensureSettings();
               }
            }
            return true;
         }
         return false;
      }
   }
}
