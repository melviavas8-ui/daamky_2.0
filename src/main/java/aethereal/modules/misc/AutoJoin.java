package aethereal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1802;
import net.minecraft.class_476;
import net.minecraft.class_7439;

public class AutoJoin extends Module {
   private static final String field0136 = "Выбор мира грифа";
   private static final Pattern field1515 = Pattern.compile("(\\d+)/(\\d+)");
   private static final int field0958 = 36;
   private static final int field0178 = 44;
   private static final long field0460 = 500L;
   private static final int[] field1654 = new int[]{
      0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 23, 24, 25, 26, 27, 28, 29, 30, 32, 33, 34, 35
   };
   private static final int[] field1575 = new int[]{0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
   private final EnumSetting<AutoJoin.Mode> field1715 = new EnumSetting<>("autojoin.mode", AutoJoin.Mode.field0590)
      .method1007("Server")
      .method2130("Режим автозахода");
   private final FloatSetting field1144 = new FloatSetting(
         "autojoin.grief", 1.0F, 1.0F, 74.0F, 1.0F, () -> this.field1715.method0492() == AutoJoin.Mode.field0590
      )
      .method1007("Grief")
      .method2130("Номер гриферского мира");
   private final FloatSetting field1097 = new FloatSetting(
         "autojoin.speed", 3.0F, 1.0F, 10.0F, 1.0F, () -> this.field1715.method0492() == AutoJoin.Mode.field0590
      )
      .method1007("Delay")
      .method2130("Задержка");
   private final Stopwatch field1209 = new Stopwatch();
   private final Stopwatch field0883 = new Stopwatch();
   private int field0827 = -1;

   public AutoJoin() {
      super("AutoJoin", ModuleCategory.field0776, "Automatically joins server");
      this.method1013("Автоматически заходит на сервер");
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field0827 = -1;
      this.field1209.method1812();
      this.field0883.method1812();
      this.method1691();
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         if (this.field1715.method0492() == AutoJoin.Mode.field0590) {
            this.method1735();
         }
      }
   }

   @EventHandler
   public void onPacket(PacketEvent.Inbound var1) {
      if (!method1974()) {
         if (this.field1715.method0492() == AutoJoin.Mode.field0590) {
            if (var1.method1970() instanceof class_7439 var2) {
               String var4 = var2.comp_763().getString();
               if (var4.contains("К сожалению сервер переполнен") || var4.contains("Подождите 20 секунд!") || var4.contains("большой поток игроков")) {
                  this.method1691();
               }
            }
         }
      }
   }

   private void method1735() {
      if (field0796.field_1755 == null) {
         this.field0827 = -1;
         if (field0796.field_1724.field_6012 < 3) {
            this.method1691();
         }
      } else if (field0796.field_1755 instanceof class_476 var1) {
         if (field0796.field_1724.field_7512 instanceof class_1707 var8) {
            try {
               if (this.method1522(var1, var8)) {
                  return;
               }

               int var9 = this.field1144.method0492().intValue();

               for (class_1735 var5 : var8.field_7761) {
                  if (var5.field_7871 != field0796.field_1724.method_31548()) {
                     String var6 = var5.method_7677().method_7964().getString();
                     if ((var6.contains("ГРИФЕРСКОЕ ВЫЖИВАНИЕ") || var6.contains("ГРИФ #" + var9 + " (1.16.5+)"))
                        && this.field1209.method0779(this.field1097.method0492().longValue())) {
                        field0796.field_1761.method_2906(var8.field_7763, var5.field_7874, 0, class_1713.field_7790, field0796.field_1724);
                        this.field1209.method1812();
                     }
                  }
               }
            } catch (Exception var7) {
            }
         }
      }
   }

   private boolean method1522(class_476 var1, class_1707 var2) {
      String var3 = var1.method_25440().getString();
      if (!var3.contains("Выбор мира грифа")) {
         this.field0827 = -1;
         return false;
      }

      int var4 = this.method2127(var3);
      if (var4 == -1) {
         return true;
      }

      if (this.field0827 != -1) {
         if (var4 == this.field0827) {
            this.field0827 = -1;
         } else {
            if (!this.field0883.method0779(500L)) {
               return true;
            }

            this.field0827 = -1;
         }
      }

      int var5 = this.field1144.method0492().intValue();
      int var6 = this.method0716(var5);
      int var7 = this.method0137(var5);
      if (var7 == -1) {
         return true;
      }

      if (var4 != var6) {
         if (!this.field1209.method0779(this.field1097.method0492().longValue())) {
            return true;
         }

         int var8 = var4 < var6 ? 44 : 36;
         field0796.field_1761.method_2906(var2.field_7763, var8, 0, class_1713.field_7790, field0796.field_1724);
         this.field0827 = var4 < var6 ? var4 + 1 : var4 - 1;
         this.field0883.method1812();
         this.field1209.method1812();
         return true;
      } else {
         if (this.field1209.method0779(this.field1097.method0492().longValue())) {
            field0796.field_1761.method_2906(var2.field_7763, var7, 0, class_1713.field_7790, field0796.field_1724);
            this.field1209.method1812();
         }

         return true;
      }
   }

   private void method1691() {
      if (field0796.field_1724 != null && field0796.field_1761 != null) {
         int var1 = InventoryManager.method2154(class_1802.field_8251);
         if (var1 != -1) {
            field0796.field_1724.method_31548().field_7545 = var1;
            field0796.field_1761.method_2919(field0796.field_1724, class_1268.field_5808);
         }
      }
   }

   private int method2127(String var1) {
      Matcher var2 = field1515.matcher(var1);
      return !var2.find() ? -1 : Integer.parseInt(var2.group(1));
   }

   private int method0716(int var1) {
      if (var1 <= 32) {
         return 1;
      } else {
         return var1 <= 64 ? 2 : 3;
      }
   }

   private int method0137(int var1) {
      if (var1 < 1 || var1 > 74) {
         return -1;
      } else if (var1 <= 32) {
         return field1654[var1 - 1];
      } else {
         return var1 <= 64 ? field1654[var1 - 33] : field1575[var1 - 65];
      }
   }

   public enum Mode implements DisplayNamed {
      field0590("ReallyWorld"),
      field0025("FunTime"),
      field1428("MineBlaze");

      private final String field1030;

      Mode(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }
}
