package aethereal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class SettingWidgetFactory {
   private SettingWidgetFactory() {
      throw new AssertionError("No instances");
   }

   public static List<SettingWidget> method0841(ModuleCard var0) {
      Objects.requireNonNull(var0, "module must not be null");
      List var1 = var0.method1954().method1914();
      List var2 = new ArrayList<>(var1.size());

      for (int var3 = 0; var3 < var1.size(); var3++) {
         SettingWidget var4 = method0866(var0.method0418(), var1.get(var3));
         if (var4 != null) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public static SettingWidget method0866(Animation var0, Setting var1) {
      Objects.requireNonNull(var0, "animation must not be null");
      Objects.requireNonNull(var1, "setting must not be null");

      return switch (var1) {
         case BooleanSetting var4 -> new BooleanSettingWidget(var4, var0::method0002);
         case FloatSetting var5 -> new NumberSettingWidget(var5, var0::method0002);
         case EnumSetting var6 -> new EnumSettingWidget(var6, var0::method0002);
         case MultiSelectSetting var7 -> new MultiSelectSettingWidget(var7, var0::method0002);
         case KeyBindSetting var8 -> new KeyBindSettingWidget(var8, var0::method0002);
         case ColorSetting var9 -> new ColorSettingWidget(var9, var0::method0002);
         case BlockListSetting var10 -> new BlockListSettingWidget(var10, var0::method0002);
         case KeyBindListSetting var11 -> new KeyBindListSettingWidget(var11, var0::method0002);
         case NumberListSetting var12 -> new NumberListSettingWidget(var12, var0::method0002);
         case ConditionalBooleanSetting var13 -> new ConditionalToggleWidget(var13, var0::method0002);
         default -> null;
      };
   }
}
