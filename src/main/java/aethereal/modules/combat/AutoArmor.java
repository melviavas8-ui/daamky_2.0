package aethereal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10192;
import net.minecraft.class_124;
import net.minecraft.class_1304;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1738;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_2378;
import net.minecraft.class_2561;
import net.minecraft.class_5134;
import net.minecraft.class_5250;
import net.minecraft.class_5321;
import net.minecraft.class_6880;
import net.minecraft.class_7924;
import net.minecraft.class_9285;
import net.minecraft.class_9334;
import net.minecraft.class_1304.class_1305;

public class AutoArmor extends Module {
   public AutoArmor() {
      super("AutoArmor", ModuleCategory.field0661, "Automatically equips the best armor from inventory");
      this.method1013("Автоматически надевает лучшую броню из инвентаря");
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         if (!InventorySearch.method0026()) {
            if (InventoryActionScheduler.field0649.method0026()) {
               List var2 = new ArrayList<>();

               for (class_1304 var6 : class_1304.values()) {
                  if (var6.method_5925() == class_1305.field_6178) {
                     class_1799 var7 = field0796.field_1724.method_31548().method_7372(var6.method_5927());
                     if (var6 != class_1304.field_6174 || var7.method_7909() != class_1802.field_8833) {
                        int var8 = 8 - var6.method_5927();
                        class_1735 var9 = InventorySearch.method1107(var3 -> {
                           class_1799 var4 = var3.method_7677();
                           if (var4.method_7960()) {
                              return false;
                           } else if (var3.field_7874 == var8) {
                              return false;
                           } else if (this.method0269(var4)) {
                              return false;
                           } else {
                              return this.method1241(var4) ? false : this.method1242(var4, var6);
                           }
                        }, Comparator.comparingDouble(var2x -> this.method0270(var2x.method_7677(), var6)));
                        if (var9 != null && this.method1243(var9.method_7677(), var7, var6)) {
                           class_1735 var11 = var9;
                           var2.add(() -> InventorySearch.method1208(var11, var8));
                        } else if (this.method0269(var7)) {
                           if (var9 != null) {
                              class_1735 var10 = var9;
                              var2.add(() -> InventorySearch.method1208(var10, var8));
                              this.method1060("Заменил - ", var6, var7);
                           } else if (InventorySearch.method1230(class_1802.field_8162, var0 -> var0.field_7874 >= 9) != null) {
                              var2.add(() -> InventorySearch.method0754(var8, 0, class_1713.field_7794, false));
                              this.method2157(var7);
                           }
                        }
                     }
                  }
               }

               if (!var2.isEmpty()) {
                  InventoryActionScheduler.method0991(() -> var2.forEach(Runnable::run));
               }
            }
         }
      }
   }

   private boolean method1242(class_1799 var1, class_1304 var2) {
      if (!(var1.method_7909() instanceof class_1738)) {
         return false;
      }

      class_10192 var3 = (class_10192)var1.method_57824(class_9334.field_54196);
      return var3 != null && var3.comp_3174() == var2;
   }

   private float method0270(class_1799 var1, class_1304 var2) {
      if (var1.method_7960()) {
         return 0.0F;
      }

      class_9285 var3 = (class_9285)var1.method_57824(class_9334.field_49636);
      float[] var4 = new float[]{0.0F};
      if (var3 != null) {
         var3.method_57482(var2, (var1x, var2x) -> {
            if (var1x.comp_349() == class_5134.field_23724.comp_349() || var1x.comp_349() == class_5134.field_23725.comp_349()) {
               var4[0] += (float)var2x.comp_2449();
            }
         });
      }

      float var5 = var4[0] + this.method1244(var1, class_1893.field_9111);
      float var6 = this.method1244(var1, class_1893.field_9119);
      float var7 = this.method1244(var1, class_1893.field_9101);
      return var5 + var6 * 0.1F + var7 * 0.2F;
   }

   private int method1244(class_1799 var1, class_5321<class_1887> var2) {
      if (field0796.field_1687 == null) {
         return 0;
      }

      class_2378 var3 = field0796.field_1687.method_30349().method_30530(class_7924.field_41265);
      class_6880 var4 = (class_6880<class_1887>)var3.method_10223(var2.method_29177()).orElse(null);
      return var4 == null ? 0 : class_1890.method_8225(var4, var1);
   }

   private boolean method1241(class_1799 var1) {
      return this.method1244(var1, class_1893.field_9113) > 0;
   }

   private boolean method0269(class_1799 var1) {
      return !var1.method_7960() && var1.method_7963() ? (double)var1.method_7919() / var1.method_7936() > 0.9799995641474735 : false;
   }

   private boolean method1243(class_1799 var1, class_1799 var2, class_1304 var3) {
      if (var2.method_7960()) {
         return true;
      } else {
         return this.method1242(var1, var3) && this.method1242(var2, var3) ? this.method0270(var1, var3) > this.method0270(var2, var3) : false;
      }
   }

   private String method1150(class_1304 var1) {
      return switch (var1) {
         case field_6166 -> "Ботинки";
         case field_6172 -> "Поножи";
         case field_6174 -> "Нагрудник";
         case field_6169 -> "Шлем";
         default -> "Броня";
      };
   }

   private void method1060(String var1, class_1304 var2, class_1799 var3) {
      class_5250 var4 = class_2561.method_43470(var1 + class_124.field_1060 + this.method1150(var2) + class_124.field_1070 + " на ")
         .method_10852(var3.method_7964());
      NewHUD.method1350(var4, ModuleCategory.field0661.method0017(), true);
   }

   private void method2157(class_1799 var1) {
      class_5250 var2 = class_2561.method_43470("Засейвил - ").method_10852(var1.method_7964());
      NewHUD.method1350(var2, ModuleCategory.field0661.method0017(), true);
   }
}
