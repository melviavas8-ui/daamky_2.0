package aethereal;

import java.util.List;
import lombok.Generated;
import net.minecraft.class_10185;
import net.minecraft.class_1268;
import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1743;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2371;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2815;
import net.minecraft.class_2851;
import net.minecraft.class_2868;
import net.minecraft.class_2879;
import net.minecraft.class_304;
import net.minecraft.class_3489;
import net.minecraft.class_3675;
import net.minecraft.class_9282;
import ua.patch.daamky.api.mixins.accessors.IClientPlayerInteractionManager;

public final class InventoryManager implements MinecraftAccess {
   private static final DelayedAction field0999 = new DelayedAction();
   public static final int field0567 = 0;
   public static final int field0004 = 8;
   public static final int field1411 = 35;

   public static DelayedAction method0544() {
      return field0999;
   }

   public static boolean method0026() {
      return !field0999.method0026();
   }

   public static void method2078() {
      if (field0796.field_1724 != null) {
         field0999.method2078();
      }
   }

   public static void method0753(int var0, int var1, class_1713 var2) {
      field0796.field_1761.method_2906(0, var0, var1, var2, field0796.field_1724);
   }

   public static int method1217(class_1792 var0) {
      int var1 = 0;

      for (int var2 = 0; var2 < field0796.field_1724.field_7512.field_7761.size(); var2++) {
         if (((class_1735)field0796.field_1724.field_7512.field_7761.get(var2)).method_7677().method_7909() == var0) {
            var1++;
         }
      }

      return var1;
   }

   public static void method0996(Runnable var0, int var1) {
      method0997(var0, var1, true);
   }

   public static void method0997(Runnable var0, int var1, boolean var2) {
      if (var2) {
         field0999.method0578();
      }

      field0999.method0765(1, () -> method1973(), var1).method0765(2, () -> {
         method1812();
         var0.run();
         method1634();
         method0430();
      }, var1);
   }

   public static void method1077(List<class_2596<?>> var0, int var1, boolean var2, long var3) {
      if (var2) {
         field0999.method0578();
      }

      field0999.method0765(1, () -> method1973(), var1).method0765(2, () -> new Thread(() -> {
         float var3 = (float)var3 / var0.size();

         for (class_2596 var5 : var0) {
            PacketQueue.method1354(var5);
         }

         PacketQueue.method1354(new class_2815(field0796.field_1724.field_7512.field_7763));
         method0430();
         var0.clear();
      }).start(), var1);
   }

   private static void method1973() {
      field0796.field_1690.field_1894.method_23481(false);
      field0796.field_1690.field_1881.method_23481(false);
      field0796.field_1690.field_1913.method_23481(false);
      field0796.field_1690.field_1849.method_23481(false);
      field0796.field_1690.field_1903.method_23481(false);
      field0796.field_1690.field_1832.method_23481(false);
      field0796.field_1690.field_1867.method_23481(false);
      if (field0796.field_1724 != null && field0796.field_1724.method_5624()) {
         field0796.field_1724.method_5728(false);
      }

      field0004 = Math.max(Sprint.field0004, 1);
   }

   private static void method0430() {
      long var0 = field0796.method_22683().method_4490();
      class_304[] var2 = new class_304[]{
         field0796.field_1690.field_1894,
         field0796.field_1690.field_1881,
         field0796.field_1690.field_1913,
         field0796.field_1690.field_1849,
         field0796.field_1690.field_1903,
         field0796.field_1690.field_1832,
         field0796.field_1690.field_1867
      };

      for (class_304 var6 : var2) {
         var6.method_23481(class_3675.method_15987(var0, var6.method_1429().method_1444()));
      }
   }

   public static void method1812() {
      if (field0796.method_1562() != null) {
         field0796.method_1562().method_52787(new class_2851(new class_10185(false, false, false, false, false, false, false)));
      }
   }

   public static void method1634() {
      if (field0796.method_1562() != null && field0796.field_1724 != null) {
         field0796.method_1562().method_52787(new class_2851(field0796.field_1724.field_3913.field_54155));
      }
   }

   public static int method0716(int var0) {
      return var0 >= 0 && var0 <= 8 ? 36 + var0 : var0;
   }

   public static int method1567(boolean var0) {
      if (field0796.field_1724 == null) {
         return -1;
      }

      class_2371 var1 = field0796.field_1724.method_31548().field_7547;
      int var2 = var0 ? 0 : 9;
      int var3 = var0 ? 9 : 36;

      for (int var4 = var2; var4 < var3; var4++) {
         if (((class_1799)var1.get(var4)).method_7909() instanceof class_1743) {
            return var4;
         }
      }

      return -1;
   }

   public static void method0808(InventoryManager.SwitchMode var0, int var1, int var2) {
      if (var1 != -1 && var2 != -1 && var1 != DaamkyClient.method2004().method2186().method0003()) {
         switch (var0) {
            case field0613:
               field0796.field_1724.method_31548().field_7545 = var1;
               ((IClientPlayerInteractionManager)field0796.field_1761).syncSelectedSlot$drug();
               break;
            case field0046:
               PacketQueue.method0300(new class_2868(var1));
               break;
            case field1440:
               method0809(InventoryManager.ClickAction.field0047, var1, var2);
         }
      }
   }

   public static void method0169(InventoryManager.SwitchMode var0, int var1, int var2) {
      if (var1 != -1 && var2 != -1 && var1 != DaamkyClient.method2004().method2186().method0003()) {
         switch (var0) {
            case field0613:
               field0796.field_1724.method_31548().field_7545 = var2;
               ((IClientPlayerInteractionManager)field0796.field_1761).syncSelectedSlot$drug();
               break;
            case field0046:
               PacketQueue.method0300(new class_2868(var2));
               break;
            case field1440:
               method0809(InventoryManager.ClickAction.field0047, var1, var2);
         }
      }
   }

   public static void method0143(int var0) {
      method0771(var0, true);
   }

   public static void method0771(int var0, boolean var1) {
      if (field0796.field_1724 != null) {
         if (field0796.field_1724.method_31548().field_7545 != var0) {
            field0796.field_1724.field_3944.method_52787(new class_2868(var0));
            if (var1) {
               field0796.field_1724.method_31548().field_7545 = var0;
            }
         }
      }
   }

   public static void method0809(InventoryManager.ClickAction var0, int var1, int var2) {
      if (var1 != -1 && var2 != -1) {
         switch (var0) {
            case field0614:
               field0796.field_1761.method_2906(field0796.field_1724.field_7512.field_7763, method0716(var1), 0, class_1713.field_7790, field0796.field_1724);
               field0796.field_1761.method_2906(field0796.field_1724.field_7512.field_7763, method0716(var2), 0, class_1713.field_7790, field0796.field_1724);
               field0796.field_1761.method_2906(field0796.field_1724.field_7512.field_7763, method0716(var1), 0, class_1713.field_7790, field0796.field_1724);
               break;
            case field0047:
               field0796.field_1761.method_2906(field0796.field_1724.field_7512.field_7763, var1, var2, class_1713.field_7791, field0796.field_1724);
         }
      }
   }

   public static void method0738(int var0, int var1) {
      if (var0 != -1 && var1 != -1) {
         field0796.field_1761.method_2906(field0796.field_1724.field_7498.field_7763, method0716(var0), 0, class_1713.field_7790, field0796.field_1724);
         field0796.field_1761.method_2906(field0796.field_1724.field_7498.field_7763, var1, 0, class_1713.field_7790, field0796.field_1724);
         field0796.field_1761.method_2906(field0796.field_1724.field_7498.field_7763, method0716(var0), 0, class_1713.field_7790, field0796.field_1724);
      }
   }

   public static void method0807(InventoryManager.SwingHand var0) {
      switch (var0) {
         case field0612:
            field0796.field_1724.method_6104(class_1268.field_5808);
            break;
         case field0045:
            field0796.field_1724.method_6104(class_1268.field_5810);
            break;
         case field1439:
            PacketQueue.method0300(new class_2879(class_1268.field_5808));
      }
   }

   public static class_1268 method1118(class_1268 var0) {
      return var0 == class_1268.field_5808 ? class_1268.field_5810 : class_1268.field_5808;
   }

   public static int method0147(int var0, int var1) {
      int var2 = -1;
      int var3 = -1;
      int var4 = -1;
      int var5 = -1;
      int var6 = -1;
      int var7 = -1;

      for (int var8 = var1; var8 >= var0; var8--) {
         class_1799 var9 = field0796.field_1724.method_31548().method_5438(var8);
         if (var9.method_7909() == class_1802.field_22022) {
            var2 = var8;
         } else if (var9.method_7909() == class_1802.field_8802) {
            var3 = var8;
         } else if (var9.method_7909() == class_1802.field_8371) {
            var4 = var8;
         } else if (var9.method_7909() == class_1802.field_8845) {
            var5 = var8;
         } else if (var9.method_7909() == class_1802.field_8528) {
            var6 = var8;
         } else if (var9.method_7909() == class_1802.field_8091) {
            var7 = var8;
         }
      }

      if (var2 != -1) {
         return var2;
      } else if (var3 != -1) {
         return var3;
      } else if (var4 != -1) {
         return var4;
      } else if (var5 != -1) {
         return var5;
      } else {
         return var6 != -1 ? var6 : var7;
      }
   }

   public static int method2105(int var0, int var1) {
      int var2 = -1;
      int var3 = -1;
      int var4 = -1;
      int var5 = -1;
      int var6 = -1;
      int var7 = -1;

      for (int var8 = var1; var8 >= var0; var8--) {
         class_1799 var9 = field0796.field_1724.method_31548().method_5438(var8);
         if (var9.method_7909() == class_1802.field_22025) {
            var2 = var8;
         } else if (var9.method_7909() == class_1802.field_8556) {
            var3 = var8;
         } else if (var9.method_7909() == class_1802.field_8475) {
            var4 = var8;
         } else if (var9.method_7909() == class_1802.field_8825) {
            var5 = var8;
         } else if (var9.method_7909() == class_1802.field_8062) {
            var6 = var8;
         } else if (var9.method_7909() == class_1802.field_8406) {
            var7 = var8;
         }
      }

      if (var2 != -1) {
         return var2;
      } else if (var3 != -1) {
         return var3;
      } else if (var4 != -1) {
         return var4;
      } else if (var5 != -1) {
         return var5;
      } else {
         return var6 != -1 ? var6 : var7;
      }
   }

   public static int method1365(class_2680 var0, int var1, int var2) {
      double var3 = -1.0;
      int var5 = -1;

      for (int var6 = var1; var6 <= var2; var6++) {
         double var7 = field0796.field_1724.method_31548().method_5438(var6).method_7924(var0);
         if (var7 > var3) {
            var3 = var7;
            var5 = var6;
         }
      }

      return var5;
   }

   public static int method1829(int var0, int var1) {
      int var2 = -1;
      int var3 = -1;
      int var4 = -1;
      int var5 = -1;
      int var6 = -1;
      int var7 = -1;

      for (int var8 = var1; var8 >= var0; var8--) {
         class_1799 var9 = field0796.field_1724.method_31548().method_5438(var8);
         if (var9.method_7909() == class_1802.field_8577) {
            var2 = var8;
         } else if (var9.method_7909() == class_1802.field_8873) {
            var3 = var8;
         } else if (var9.method_7909() == class_1802.field_8523) {
            var4 = var8;
         } else if (var9.method_7909() == class_1802.field_8678) {
            var5 = var8;
         } else if (var9.method_7909() == class_1802.field_8058) {
            var6 = var8;
         } else if (var9.method_7909() == class_1802.field_22028) {
            var7 = var8;
         }
      }

      if (var3 != -1) {
         return var3;
      } else if (var4 != -1) {
         return var4;
      } else if (var5 != -1) {
         return var5;
      } else if (var6 != -1) {
         return var6;
      } else {
         return var7 != -1 ? var7 : var2;
      }
   }

   public static int method1191(class_1657 var0, int var1) {
      class_1799 var2 = var0.method_31548().method_7372(var1);
      return var2.method_31573(class_3489.field_48803) ? class_9282.method_57470(var2, -6265536) : -1;
   }

   public static int method0262(class_1792 var0) {
      return method1225(var0, 0, 35);
   }

   public static int method2154(class_1792 var0) {
      return method1225(var0, 0, 8);
   }

   public static int method1859(class_1792 var0) {
      return method1225(var0, 9, 35);
   }

   public static int method0975(Class<? extends class_1792> var0) {
      return method0978(var0, 0, 35);
   }

   public static int method0200(Class<? extends class_1792> var0) {
      return method0978(var0, 0, 8);
   }

   public static int method2123(Class<? extends class_1792> var0) {
      return method0978(var0, 9, 35);
   }

   public static int method1225(class_1792 var0, int var1, int var2) {
      for (int var3 = var2; var3 >= var1; var3--) {
         if (field0796.field_1724.method_31548().method_5438(var3).method_7909() == var0) {
            return var3;
         }
      }

      return -1;
   }

   public static int method0978(Class<? extends class_1792> var0, int var1, int var2) {
      for (int var3 = var2; var3 >= var1; var3--) {
         class_1799 var4 = field0796.field_1724.method_31548().method_5438(var3);
         if (var4.method_7909().getClass().isAssignableFrom(var0)) {
            return var3;
         }
      }

      return -1;
   }

   public static int method1643(int var0, int var1) {
      for (int var2 = var1; var2 >= var0; var2--) {
         if (field0796.field_1724.method_31548().method_5438(var2).method_7960()) {
            return var2;
         }
      }

      return -1;
   }

   public static int method0303(class_2680 var0, int var1, int var2) {
      if (field0796.field_1724 == null) {
         return -1;
      }

      int var3 = -1;
      float var4 = 0.0F;

      for (int var5 = var1; var5 <= var2; var5++) {
         class_1799 var6 = (class_1799)field0796.field_1724.method_31548().field_7547.get(var5);
         if (var6 != null && !var6.method_7960()) {
            float var7 = var6.method_7924(var0);
            if (var7 > var4) {
               var4 = var7;
               var3 = var5;
            }
         }
      }

      return var3;
   }

   @Generated
   private InventoryManager() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   public enum SwingHand implements DisplayNamed {
      field0612("settings.swing.mainhand"),
      field0045("settings.swing.offhand"),
      field1439("settings.packet"),
      field0975("settings.none");

      private final String field0791;

      @Override
      public String method0557() {
         return this.field0791;
      }

      @Generated
      SwingHand(String var3) {
         this.field0791 = var3;
      }
   }

   public enum SwitchMode implements DisplayNamed {
      field0613("settings.normal"),
      field0046("settings.switch.silent"),
      field1440("settings.switch.alternative"),
      field0976("settings.none");

      private final String field0791;

      @Override
      public String method0557() {
         return this.field0791;
      }

      @Generated
      SwitchMode(String var3) {
         this.field0791 = var3;
      }
   }

   public enum ClickAction {
      field0614,
      field0047;
   }
}
