package aethereal;

import com.mojang.blaze3d.platform.GlStateManager.class_4534;
import com.mojang.blaze3d.platform.GlStateManager.class_4535;
import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.Arrays;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10142;
import net.minecraft.class_1297;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;

public class ImageEsp extends Module {
   private static final class_2960 field0403 = class_2960.method_60655("daamky", "textures/glow.png");
   public final FloatSetting field0060 = new FloatSetting("imageesp.heightscale", 1.3F, 0.5F, 3.0F, 0.05F)
      .method1007("Height Scale")
      .method0210("Glow height as a multiplier of entity height")
      .method2130("Высота свечения относительно высоты сущности");
   public final FloatSetting field1450 = new FloatSetting("imageesp.widthscale", 2.0F, 0.5F, 6.0F, 0.05F)
      .method1007("Width Scale")
      .method0210("Glow width as a multiplier of entity width")
      .method2130("Ширина свечения относительно ширины сущности");
   public final FloatSetting field0985 = new FloatSetting("imageesp.pad", 0.3F, 0.0F, 3.0F, 0.05F)
      .method1007("Padding")
      .method0210("Extra size added on top of the auto-fit (in blocks)")
      .method2130("Доп. размер сверх авто-подгонки");
   public final FloatSetting field0190 = new FloatSetting("imageesp.heightoffset", 0.0F, -2.0F, 4.0F, 0.05F)
      .method1007("Height Offset")
      .method0210("Vertical offset from entity center")
      .method2130("Вертикальное смещение от центра");
   public final FloatSetting field0470 = new FloatSetting("imageesp.opacity", 1.0F, 0.05F, 1.0F, 0.05F)
      .method1007("Opacity")
      .method0210("Global opacity multiplier")
      .method2130("Общая прозрачность");
   public final FloatSetting field1627 = new FloatSetting("imageesp.layers", 2.0F, 1.0F, 5.0F, 1.0F)
      .method1007("Layers")
      .method0210("Number of stacked sprites (more = brighter halo)")
      .method2130("Количество наложений (ярче ореол)");
   public final BooleanSetting field1544 = new BooleanSetting("imageesp.throughwalls", false)
      .method1007("Through Walls")
      .method0210("Render through blocks (and on top of the entity)")
      .method2130("Рисовать сквозь блоки");
   public final BooleanSetting field1709 = new BooleanSetting("imageesp.additive", true)
      .method1007("Additive")
      .method0210("Use additive blending for a brighter glow")
      .method2130("Сложение цвета (ярче)");
   public final MultiSelectSetting field1152 = new MultiSelectSetting(
         "imageesp.target", Arrays.asList("Players", "Hostiles", "Animals", "Ambient", "Invisibles", "Items", "Crystals", "Others"), false, () -> true
      )
      .method1007("Target")
      .method0210("Entity types to render glow on")
      .method2130("Типы сущностей");
   public final ColorSetting field1095 = new ColorSetting("imageesp.playerscolor", 133, 232, 80, 255, () -> this.field1152.method0439("Players").method0492())
      .method1882()
      .method1007("Players Color")
      .method0210("Glow color for players")
      .method2130("Цвет для игроков");
   public final ColorSetting field1203 = new ColorSetting(
         "imageesp.hostilescolor", 250, 150, 255, 255, () -> this.field1152.method0439("Hostiles").method0492()
      )
      .method1882()
      .method1007("Hostiles Color")
      .method0210("Glow color for hostile mobs")
      .method2130("Цвет для враждебных мобов");
   public final ColorSetting field0878 = new ColorSetting("imageesp.animalscolor", 100, 255, 100, 255, () -> this.field1152.method0439("Animals").method0492())
      .method1882()
      .method1007("Animals Color")
      .method0210("Glow color for animals")
      .method2130("Цвет для животных");
   public final ColorSetting field0833 = new ColorSetting("imageesp.ambientcolor", 150, 150, 255, 255, () -> this.field1152.method0439("Ambient").method0492())
      .method1882()
      .method1007("Ambient Color")
      .method0210("Glow color for ambient creatures")
      .method2130("Цвет для фоновых существ");
   public final ColorSetting field0916 = new ColorSetting(
         "imageesp.invisiblescolor", 253, 121, 218, 255, () -> this.field1152.method0439("Invisibles").method0492()
      )
      .method1882()
      .method1007("Invisibles Color")
      .method0210("Glow color for invisible entities")
      .method2130("Цвет для невидимых сущностей");
   public final ColorSetting field1338 = new ColorSetting("imageesp.itemscolor", 244, 156, 255, 255, () -> this.field1152.method0439("Items").method0492())
      .method1882()
      .method1007("Items Color")
      .method0210("Glow color for items")
      .method2130("Цвет для предметов");
   public final ColorSetting field1299 = new ColorSetting(
         "imageesp.crystalscolor", 255, 145, 255, 255, () -> this.field1152.method0439("Crystals").method0492()
      )
      .method1882()
      .method1007("Crystals Color")
      .method0210("Glow color for end crystals")
      .method2130("Цвет для кристаллов края");
   public final ColorSetting field1374 = new ColorSetting("imageesp.otherscolor", 128, 128, 128, 255, () -> this.field1152.method0439("Others").method0492())
      .method1882()
      .method1007("Others Color")
      .method0210("Glow color for other entities")
      .method2130("Цвет для прочих сущностей");

   public ImageEsp() {
      super("ImageEsp", ModuleCategory.field1004, "Renders a glow.png sprite behind each entity, stretched to the body");
      this.method1013("Рисует glow.png-биллборд за каждой сущностью, растянутый по телу");
      this.field1152.method0439("Players").method0206(true);
      this.field1152.method0439("Hostiles").method0206(true);
      this.field1152.method0439("Animals").method0206(true);
      this.field1152.method0439("Ambient").method0206(true);
      this.field1152.method0439("Invisibles").method0206(true);
      this.field1152.method0439("Items").method0206(true);
      this.field1152.method0439("Crystals").method0206(true);
      this.field1152.method0439("Others").method0206(false);
   }

   @EventHandler
   public void onRenderEntity(RenderEntityEvent var1) {
      if (!method1974()) {
         class_1297 var2 = var1.method1798();
         if (this.method1129(var2)) {
            Color var3 = this.method0234(var2);
            if (var3.getAlpha() > 0) {
               class_4184 var4 = field0796.field_1773.method_19418();
               class_4587 var5 = var1.method2227();
               float var6 = var2.method_17682();
               float var7 = var2.method_17681();
               float var8 = this.field0985.method0492();
               float var9 = var6 * this.field0060.method0492() + var8;
               float var10 = var7 * this.field1450.method0492() + var8;
               double var11 = var1.method1945();
               double var13 = var1.method0412() + var6 * 0.5 + this.field0190.method0492().floatValue();
               double var15 = var1.method0354();
               RenderSystem.setShader(class_10142.field_53880);
               RenderSystem.setShaderTexture(0, field0403);
               RenderSystem.enableBlend();
               if (this.field1709.method0492()) {
                  RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE);
               } else {
                  RenderSystem.blendFuncSeparate(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA, class_4535.ZERO, class_4534.ONE);
               }

               RenderSystem.disableCull();
               RenderSystem.depthMask(false);
               if (this.field1544.method0492()) {
                  RenderSystem.disableDepthTest();
               } else {
                  RenderSystem.enableDepthTest();
               }

               int var17 = Math.max(1, this.field1627.method0492().intValue());
               float var18 = this.field0470.method0492();

               for (int var19 = 0; var19 < var17; var19++) {
                  float var20 = 1.0F + var19 * 0.3F;
                  float var21 = var18 * (1.0F / (1.0F + var19 * 0.6F));
                  int var22 = class_3532.method_15340((int)(var3.getAlpha() * var21), 0, 255);
                  if (var22 > 0) {
                     int var23 = new Color(var3.getRed(), var3.getGreen(), var3.getBlue(), var22).getRGB();
                     var5.method_22903();
                     var5.method_22904(var11, var13, var15);
                     var5.method_22907(var4.method_23767());
                     float var24 = var10 * var20 * 0.5F;
                     float var25 = var9 * var20 * 0.5F;
                     Matrix4f var26 = var5.method_23760().method_23761();
                     class_287 var27 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1575);
                     var27.method_22918(var26, -var24, -var25, 0.0F).method_22913(0.0F, 1.0F).method_39415(var23);
                     var27.method_22918(var26, var24, -var25, 0.0F).method_22913(1.0F, 1.0F).method_39415(var23);
                     var27.method_22918(var26, var24, var25, 0.0F).method_22913(1.0F, 0.0F).method_39415(var23);
                     var27.method_22918(var26, -var24, var25, 0.0F).method_22913(0.0F, 0.0F).method_39415(var23);
                     class_286.method_43433(var27.method_60800());
                     var5.method_22909();
                  }
               }

               RenderSystem.enableDepthTest();
               RenderSystem.depthMask(true);
               RenderSystem.enableCull();
               RenderSystem.blendFuncSeparate(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA, class_4535.ZERO, class_4534.ONE);
               RenderSystem.disableBlend();
            }
         }
      }
   }

   private boolean method1129(class_1297 var1) {
      if (!var1.method_5805()) {
         return false;
      } else if (var1 == field0796.field_1724 && field0796.field_1690.method_31044().method_31034()) {
         return false;
      } else if (this.field1152.method0439("Players").method0492() && EntityFilter.method1129(var1)) {
         return true;
      } else if (this.field1152.method0439("Hostiles").method0492() && EntityFilter.method0235(var1)) {
         return true;
      } else if (this.field1152.method0439("Animals").method0492() && EntityFilter.method2144(var1)) {
         return true;
      } else if (this.field1152.method0439("Ambient").method0492() && EntityFilter.method1851(var1)) {
         return true;
      } else if (this.field1152.method0439("Invisibles").method0492() && EntityFilter.method0444(var1)) {
         return true;
      } else if (this.field1152.method0439("Items").method0492() && EntityFilter.method1660(var1)) {
         return true;
      } else if (this.field1152.method0439("Crystals").method0492() && EntityFilter.method1988(var1)) {
         return true;
      } else {
         return this.field1152.method0439("Others").method0492() ? EntityFilter.method2237(var1) == EntityFilter.EntityKind.field0196 : false;
      }
   }

   private Color method0234(class_1297 var1) {
      return switch (EntityFilter.method2237(var1)) {
         case field0644 -> this.field1095.method1726();
         case field0074 -> this.field1203.method1726();
         case field1459 -> this.field0878.method1726();
         case field0994 -> this.field0833.method1726();
         case field0773 -> this.field0916.method1726();
         case field1257 -> this.field1338.method1726();
         case field0324 -> this.field1299.method1726();
         case field0196 -> this.field1374.method1726();
      };
   }
}
