package aethereal;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_1268;
import net.minecraft.class_1792;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2848;
import net.minecraft.class_2879;
import net.minecraft.class_2885;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_746;
import net.minecraft.class_2828.class_2831;
import net.minecraft.class_2848.class_2849;

public final class BlockPlacementContext {
   private static final class_310 field0739 = class_310.method_1551();
   private static long field0005 = -1L;

   private BlockPlacementContext() {
   }

   public static boolean method0779(long var0) {
      return field0005 != var0;
   }

   public static void method0160(long var0) {
      field0005 = var0;
   }

   public static boolean method1264(class_2338 var0) {
      if (field0739.field_1687 == null) {
         return false;
      }

      class_2680 var1 = field0739.field_1687.method_8320(var0);
      return !var1.method_26234(field0739.field_1687, var0) ? false : var1.method_26227().method_15769();
   }

   public static boolean method1275(class_2338 var0, class_2350 var1, class_1268 var2, boolean var3) {
      if (field0739.field_1687 != null && field0739.field_1724 != null && field0739.field_1724.field_3944 != null) {
         class_2338 var4 = var0.method_10093(var1);
         if (!method1264(var4)) {
            return false;
         }

         class_2350 var5 = var1.method_10153();
         class_243 var6 = new class_243(
            var4.method_10263() + 0.5 + var5.method_10148() * 0.5,
            var4.method_10264() + 0.5 + var5.method_10164() * 0.5,
            var4.method_10260() + 0.5 + var5.method_10165() * 0.5
         );
         if (var3) {
            float[] var7 = method1302(var6);
            method0675(var7[0], var7[1]);
         }

         class_746 var10 = field0739.field_1724;
         boolean var8 = var10.method_5624();
         if (var8) {
            var10.field_3944.method_52787(new class_2848(var10, class_2849.field_12985));
         }

         class_3965 var9 = new class_3965(var6, var5, var4, false);
         SequencedPacketSender.method1534(var2x -> new class_2885(var2, var9, var2x));
         var10.field_3944.method_52787(new class_2879(var2));
         if (var8) {
            var10.field_3944.method_52787(new class_2848(var10, class_2849.field_12981));
         }

         return true;
      } else {
         return false;
      }
   }

   public static class_2350 method0277(class_2338 var0) {
      class_2350[] var1 = new class_2350[]{
         class_2350.field_11033, class_2350.field_11043, class_2350.field_11035, class_2350.field_11034, class_2350.field_11039, class_2350.field_11036
      };

      for (class_2350 var5 : var1) {
         if (method1264(var0.method_10093(var5))) {
            return var5;
         }
      }

      return null;
   }

   public static void method0675(float var0, float var1) {
      if (field0739.field_1724 != null && field0739.field_1724.field_3944 != null) {
         Rotation var2 = RotationManager.field0618.method2258();
         if (var2 != null) {
            float var3 = class_3532.method_15393(var0 - var2.method2047());
            float var6 = var2.method2047() + var3;
            var0 = var6 + (ThreadLocalRandom.current().nextFloat() - 0.5F) * 0.05F;
            float var7 = var1 + (ThreadLocalRandom.current().nextFloat() - 0.5F) * 0.05F;
            var1 = class_3532.method_15363(var7, -90.0F, 90.0F);
            float var4 = class_3532.method_15393(var0 - var2.method2047());
            float var5 = var1 - var2.method1762();
            if (Math.abs(var4) < 0.01F && Math.abs(var5) < 0.01F) {
               return;
            }
         }

         field0739.field_1724.field_3944.method_52787(new class_2831(var0, var1, field0739.field_1724.method_24828(), field0739.field_1724.field_5976));
      }
   }

   public static float[] method1302(class_243 var0) {
      if (field0739.field_1724 == null) {
         return new float[]{0.0F, 0.0F};
      }

      class_243 var1 = field0739.field_1724.method_33571();
      double var2 = var0.field_1352 - var1.field_1352;
      double var4 = var0.field_1351 - var1.field_1351;
      double var6 = var0.field_1350 - var1.field_1350;
      double var8 = Math.sqrt(var2 * var2 + var6 * var6);
      float var10 = (float)class_3532.method_15338(Math.toDegrees(Math.atan2(var6, var2)) - 90.0);
      float var11 = (float)class_3532.method_15338(-Math.toDegrees(Math.atan2(var4, var8)));
      return new float[]{var10, var11};
   }

   public static class_1268 method1219(class_1792 var0) {
      if (field0739.field_1724 == null) {
         return null;
      } else if (field0739.field_1724.method_6079().method_7909() == var0) {
         return class_1268.field_5810;
      } else {
         return field0739.field_1724.method_6047().method_7909() == var0 ? class_1268.field_5808 : null;
      }
   }

   public static boolean method1269(class_2338 var0, class_1937 var1) {
      for (class_2350 var5 : class_2350.values()) {
         class_2338 var6 = var0.method_10093(var5);
         class_2680 var7 = var1.method_8320(var6);
         if (var7.method_26234(var1, var6) && var7.method_26227().method_15769()) {
            return true;
         }
      }

      return false;
   }
}
