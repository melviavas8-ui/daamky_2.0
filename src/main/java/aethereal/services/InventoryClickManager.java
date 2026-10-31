package aethereal;

import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import net.minecraft.class_124;
import net.minecraft.class_1268;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1730;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1844;
import net.minecraft.class_2561;
import net.minecraft.class_2813;
import net.minecraft.class_2815;
import net.minecraft.class_4081;
import net.minecraft.class_4174;
import net.minecraft.class_6880;
import net.minecraft.class_7923;
import net.minecraft.class_9334;

public class InventoryClickManager implements MinecraftAccess {
   public static void method1208(class_1735 var0, int var1) {
      if (var0 != null) {
         method0757(var0.field_7874, var1, false, false);
      }
   }

   public static void method1210(class_1735 var0, int var1, boolean var2) {
      method1211(var0, var1, var2, false);
   }

   public static void method1211(class_1735 var0, int var1, boolean var2, boolean var3) {
      if (var0 != null) {
         method0757(var0.field_7874, var1, var2, var3);
      }
   }

   public static void method0757(int var0, int var1, boolean var2, boolean var3) {
      if (var0 != var1 && var0 != -1) {
         int var4 = Math.toIntExact(method1623().count()) - 10;
         if (var0 >= var4 && var4 == 36) {
            if (var2) {
               InventoryComponent.method0991(() -> method0754(var1, var0 - var4, class_1713.field_7791, false));
            } else {
               method0754(var1, var0 - var4, class_1713.field_7791, false);
            }
         } else {
            if (var2) {
               InventoryComponent.method0991(() -> method0756(var0, var1, var3));
            } else {
               method0756(var0, var1, var3);
            }
         }
      }
   }

   public static void method0756(int var0, int var1, boolean var2) {
      method0754(var0, 0, class_1713.field_7791, false);
      method0754(var1, 0, class_1713.field_7791, false);
      method0754(var0, 0, class_1713.field_7791, false);
      if (var2) {
         method0578();
      }
   }

   public static void method1215(class_1735 var0, class_1268 var1, boolean var2) {
      method1216(var0, var1, var2, false);
   }

   public static void method1216(class_1735 var0, class_1268 var1, boolean var2, boolean var3) {
      if (var0 != null
         && var0.field_7874 != -1
         && (!var1.equals(class_1268.field_5810) || var0.field_7871 instanceof class_1661 || var0.field_7871 instanceof class_1730)) {
         int var4 = var1.equals(class_1268.field_5808) ? field0796.field_1724.method_31548().field_7545 : 40;
         if (var2) {
            InventoryComponent.method0991(() -> method0259(var0, var4, var3));
         } else {
            method0259(var0, var4, var3);
         }
      }
   }

   public static void method0259(class_1735 var0, int var1, boolean var2) {
      method1209(var0, var1, class_1713.field_7791, false);
      if (var2) {
         method0578();
      }
   }

   public static void method1214(class_1735 var0, String var1, boolean var2) {
      if (var0 == null) {
         NotificationBuilder.method0540().method1028(class_124.field_1061 + var1 + class_124.field_1070 + " - не найден!", 3000L);
      } else {
         if (var2) {
            InventoryComponent.method0991(() -> method1212(var0, RotationHelper.method0545()));
         } else {
            method1212(var0, RotationHelper.method0545());
         }
      }
   }

   public static void method1221(class_1792 var0) {
      method1226(var0, RotationHelper.method0545(), false);
   }

   public static void method0753(int var0, int var1, class_1713 var2) {
      if (var0 != -1 && field0796.field_1761 != null && field0796.field_1724 != null) {
         field0796.field_1761.method_2906(field0796.field_1724.field_7512.field_7763, var0, var1, var2, field0796.field_1724);
      }
   }

   public static void method0729(int var0) {
      if (field0796.field_1724 != null && field0796.method_1562() != null) {
         if (field0796.field_1724.method_31548().field_7545 != var0) {
            field0796.field_1724.method_31548().field_7545 = var0;
         }
      }
   }

   public static void method1228(class_1792 var0, String var1, boolean var2) {
      float var3 = ItemStackHelper.method0261(var0);
      if (var3 > 0.0F) {
         String var5 = MathHelper.method0614(var3, 0.10000000420648689) + "с";
         NotificationBuilder.method0540().method1028(class_124.field_1061 + var0.method_63680().getString() + class_124.field_1070 + " - в кд еще " + var5, 2000L);
      } else {
         class_1735 var4 = method1104(
            var2x -> var2x.method_7677().method_7909().equals(var0) && method1345(var2x.method_7677().method_7964()).contains(var1.toLowerCase())
         );
         if (var4 == null) {
            NotificationBuilder.method0540().method1028(class_124.field_1061 + var0.method_63680().getString() + class_124.field_1070 + " - не найден!", 2000L);
         } else {
            if (var2) {
               InventoryComponent.method0991(() -> method1212(var4, RotationHelper.method0545()));
            } else {
               method1212(var4, RotationHelper.method0545());
            }
         }
      }
   }

   public static void method1226(class_1792 var0, Rotation var1, boolean var2) {
      float var3 = ItemStackHelper.method0261(var0);
      if (var3 > 0.0F) {
         String var5 = MathHelper.method0614(var3, 0.10000000420648689) + "с";
         NotificationBuilder.method0540().method1028(class_124.field_1061 + var0.method_63680().getString() + class_124.field_1070 + " - в кд еще " + var5, 2000L);
      } else {
         class_1735 var4 = method0264(var0);
         if (var4 == null) {
            NotificationBuilder.method0540().method1028(class_124.field_1061 + var0.method_63680().getString() + class_124.field_1070 + " - не найден!", 2000L);
         } else {
            if (var2) {
               InventoryComponent.method0991(() -> method1212(var4, var1));
            } else {
               method1212(var4, var1);
            }
         }
      }
   }

   public static void method1212(class_1735 var0, Rotation var1) {
      method1215(var0, class_1268.field_5808, false);
      PlayerActionHelper.method1119(class_1268.field_5808);
      method1216(var0, class_1268.field_5808, false, true);
   }

   public static void method0578() {
      class_1703 var0 = field0796.field_1724.field_7512;
      class_1799 var1 = ((class_1792)class_7923.field_41178.method_10200(MathHelper.method0736(0, 100))).method_7854();
      field0796.field_1724
         .field_3944
         .method_52787(new class_2813(var0.field_7763, var0.method_37421(), 0, 0, class_1713.field_7793, var1, Int2ObjectMaps.singleton(0, var1)));
   }

   public static void method1570(boolean var0) {
      if (var0) {
         field0796.field_1724.field_3944.method_52787(new class_2815(field0796.field_1724.field_7512.field_7763));
      } else {
         field0796.field_1724.method_7346();
      }
   }

   public static void method1209(class_1735 var0, int var1, class_1713 var2, boolean var3) {
      if (var0 != null) {
         method0754(var0.field_7874, var1, var2, var3);
      }
   }

   public static void method0754(int var0, int var1, class_1713 var2, boolean var3) {
      method0750(field0796.field_1724.field_7512.field_7763, var0, var1, var2, var3);
   }

   public static void method0750(int var0, int var1, int var2, class_1713 var3, boolean var4) {
      field0796.field_1761.method_2906(var0, var1, var2, var3, field0796.field_1724);
      if (var4) {
         field0796.field_1724.field_7512.method_7593(var1, var2, var3, field0796.field_1724);
      }
   }

   public static class_1735 method0264(class_1792 var0) {
      return method1230(var0, var0x -> true);
   }

   public static class_1735 method1230(class_1792 var0, Predicate<class_1735> var1) {
      return method1229(var0, Comparator.comparingInt(var0x -> 0), var1);
   }

   public static class_1735 method1104(Predicate<class_1735> var0) {
      return method1623().filter(var0).findFirst().orElse(null);
   }

   public static class_1735 method1107(Predicate<class_1735> var0, Comparator<class_1735> var1) {
      return method1623().filter(var0).max(var1).orElse(null);
   }

   public static class_1735 method1229(class_1792 var0, Comparator<class_1735> var1, Predicate<class_1735> var2) {
      return method1623().filter(var1x -> var1x.method_7677().method_7909().equals(var0)).filter(var2).max(var1).orElse(null);
   }

   public static class_1735 method0020() {
      return method1623()
         .filter(
            var0 -> var0.method_7677().method_57824(class_9334.field_50075) != null
               && !((class_4174)var0.method_7677().method_57824(class_9334.field_50075)).comp_2493()
         )
         .max(Comparator.comparingDouble(var0 -> ((class_4174)var0.method_7677().method_57824(class_9334.field_50075)).comp_2492()))
         .orElse(null);
   }

   public static class_1735 method1073(List<class_1792> var0) {
      return method1623().filter(var1 -> var0.contains(var1.method_7677().method_7909())).findFirst().orElse(null);
   }

   public static class_1735 method1530(class_6880<class_1291> var0) {
      return method1623()
         .filter(
            var1 -> {
               class_1844 var2 = (class_1844)var1.method_7677().method_57824(class_9334.field_49651);
               return var2 == null
                  ? false
                  : StreamSupport.<class_1293>stream(var2.method_57397().spliterator(), false).anyMatch(var1x -> var1x.method_5579().equals(var0));
            }
         )
         .findFirst()
         .orElse(null);
   }

   public static class_1735 method1448(class_4081 var0) {
      return method1623()
         .filter(
            var1 -> {
               class_1799 var2 = var1.method_7677();
               class_1844 var3 = (class_1844)var2.method_57824(class_9334.field_49651);
               if (var2.method_7909().equals(class_1802.field_8436) && var3 != null) {
                  class_4081 var4 = var0.equals(class_4081.field_18271) ? class_4081.field_18272 : class_4081.field_18271;
                  long var5 = StreamSupport.<class_1293>stream(var3.method_57397().spliterator(), false)
                     .filter(var1x -> ((class_1291)var1x.method_5579().comp_349()).method_18792().equals(var0))
                     .count();
                  long var7 = StreamSupport.<class_1293>stream(var3.method_57397().spliterator(), false)
                     .filter(var1x -> ((class_1291)var1x.method_5579().comp_349()).method_18792().equals(var4))
                     .count();
                  return var5 >= var7;
               } else {
                  return false;
               }
            }
         )
         .findFirst()
         .orElse(null);
   }

   public static int method2154(class_1792 var0) {
      return IntStream.range(0, 45)
         .filter(var1 -> Objects.requireNonNull(field0796.field_1724).method_31548().method_5438(var1).method_7909().equals(var0))
         .map(var0x -> field0796.field_1724.method_31548().method_5438(var0x).method_7947())
         .sum();
   }

   public static int method0223(List<class_1792> var0) {
      return IntStream.range(0, 9).filter(var1 -> var0.contains(field0796.field_1724.method_31548().method_5438(var1).method_7909())).findFirst().orElse(-1);
   }

   public static int method1103(IntPredicate var0) {
      return IntStream.range(0, 9).filter(var0).findFirst().orElse(-1);
   }

   public static int method0228(Predicate<class_1735> var0) {
      return method1623().filter(var0).mapToInt(var0x -> var0x.method_7677().method_7947()).sum();
   }

   public static class_1735 method2075() {
      long var0 = method1623().count();
      int var2 = var0 == 46L ? 10 : 9;
      return method1623().toList().get(Math.toIntExact(var0 - var2 + field0796.field_1724.method_31548().field_7545));
   }

   public static boolean method1813() {
      return method1623().toList().size() != 46;
   }

   public static Stream<class_1735> method1623() {
      return field0796.field_1724.field_7512.field_7761.stream();
   }

   public static void method1973() {
      class_1735 var0 = method0264(class_1802.field_8251);
      if (var0 != null) {
         field0796.field_1724.method_31548().field_7545 = var0.field_7874 < 9 ? var0.field_7874 : 0;
         method1216(var0, class_1268.field_5808, false, true);
      }
   }

   public static String method1345(class_2561 var0) {
      if (var0 == null) {
         return "";
      }

      String var1 = var0.getString();
      return var1 == null ? "" : var1.replaceAll("§[0-9a-fk-or]", "").toLowerCase();
   }
}
