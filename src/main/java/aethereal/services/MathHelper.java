package aethereal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Generated;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public final class MathHelper implements MinecraftAccess {
   public static final double field0565 = 6.2831854268631915;

   public static boolean method0689(float var0, float var1, float var2, float var3, float var4, float var5) {
      return var4 > var0 && var4 < var0 + var2 && var5 > var1 && var5 < var1 + var3;
   }

   public static double method0529() {
      return Math.pow((Double)field0796.field_1690.method_42495().method_41753() * 0.6000002984935072 + 0.20000004473258753, 3.0) * 1.2000002459274814;
   }

   public static int method0736(int var0, int var1) {
      return (int)method0667(var0, var1 + 1.0F);
   }

   public static float method0667(float var0, float var1) {
      return (float)method2088(var0, var1);
   }

   public static class_243 method0740(int var0, int var1, double var2) {
      int var4 = Math.min(var0, var1);
      float var5 = (float)(Math.cos(var4 * 6.2831854268631915 / var1) * var2);
      float var6 = (float)(-Math.sin(var4 * 6.2831854268631915 / var1) * var2);
      return new class_243(var5, 0.0, var6);
   }

   public static class_243 method1328(class_243 var0, class_243 var1) {
      float var2 = field0342 != null ? field0342.method_60637(false) : 0.0F;
      return new class_243(
         class_3532.method_16436(var2, var0.field_1352, var1.field_1352),
         class_3532.method_16436(var2, var0.field_1351, var1.field_1351),
         class_3532.method_16436(var2, var0.field_1350, var1.field_1350)
      );
   }

   public static class_243 method1127(class_1297 var0) {
      if (var0 == null) {
         return class_243.field_1353;
      }

      float var1 = field0342 != null ? field0342.method_60637(false) : 0.0F;
      return new class_243(
         class_3532.method_16436(var1, var0.field_6014, var0.method_23317()),
         class_3532.method_16436(var1, var0.field_6036, var0.method_23318()),
         class_3532.method_16436(var1, var0.field_5969, var0.method_23321())
      );
   }

   public static float method0002() {
      float var0 = ((Double)field0796.field_1690.method_42495().method_41753()).floatValue() * 0.6F + 0.2F;
      float var1 = var0 * var0 * var0 * 8.0F;
      return var1 * 0.15F;
   }

   public static float method0125(float var0, float var1) {
      return (float)(Math.random() * (var1 - var0) + var0);
   }

   public static int method0147(int var0, int var1) {
      return (int)(Math.random() * (var1 - var0) + var0);
   }

   public static float method0645(float var0) {
      return Math.round(var0 * 10.0F) / 10.0F;
   }

   public static float method2099(float var0, float var1) {
      float var2 = Math.round(var0 / var1) * var1;
      BigDecimal var3 = new BigDecimal(var2);
      var3 = var3.setScale(2, RoundingMode.HALF_UP);
      return var3.floatValue();
   }

   public static class_243 method1552(Matrix4f var0, float var1, float var2, float var3) {
      Vector3f var4 = var0.transformPosition(var1, var2, var3, new Vector3f());
      return new class_243(var4.x(), var4.y(), var4.z());
   }

   public static String method2067() {
      ZonedDateTime var0 = ZonedDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.of("Europe/Moscow"));
      return var0.format(DateTimeFormatter.ofPattern("HH:mm"));
   }

   public static boolean method1320(class_243 var0, int var1, float var2) {
      double var3 = var0.method_10216() - field0796.field_1724.method_23317();
      double var5 = var0.method_10215() - field0796.field_1724.method_23321();
      float var7 = (float)Math.toDegrees(Math.atan2(var5, var3)) - 90.0F;
      float var8 = class_3532.method_15393(var7 - var2);
      return Math.abs(var8) <= var1;
   }

   public static float method0681(float var0, float var1, float var2) {
      return Math.abs(var1 - var0) <= var2 ? var1 : var0 + Math.signum(var1 - var0) * var2;
   }

   public static double method0614(double var0, double var2) {
      double var4 = Math.round(var0 / var2) * var2;
      BigDecimal var6 = new BigDecimal(var4);
      var6 = var6.setScale(2, RoundingMode.HALF_UP);
      return var6.doubleValue();
   }

   public static float method0129(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * var2;
   }

   public static double method0617(double var0, double var2, double var4) {
      return var0 + (var2 - var0) * var4;
   }

   public static int method0741(int var0, int var1, float var2) {
      return (int)(var0 + (var1 - var0) * var2);
   }

   public static int method2105(int var0, int var1) {
      return (int)(Math.random() * (var1 - var0 + 1)) + var0;
   }

   public static float method1823(float var0, float var1) {
      return (float)(Math.random() * (var1 - var0)) + var0;
   }

   public static double method0106(double var0, double var2) {
      return Math.random() * (var2 - var0) + var0;
   }

   public static double method2088(double var0, double var2) {
      if (var0 == var2) {
         return var0;
      }

      if (var0 > var2) {
         double var4 = var0;
         var0 = var2;
         var2 = var4;
      }

      return Math.random() * (var2 - var0) + var0;
   }

   @Generated
   private MathHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
