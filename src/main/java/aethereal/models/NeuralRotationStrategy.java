package aethereal;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public class NeuralRotationStrategy extends RotationStrategy {
   private static final float field0566 = -30.0F;
   private static final float field0003 = 70.0F;
   private static final float field1410 = 120.0F;
   private static final float field0957 = 45.0F;
   private static final float field0177 = 60.0F;
   private static final float field0458 = 25.0F;
   private static final double field1613 = 0.30000014367120315;
   private static final float field1538 = 0.3F;
   private static final float field1704 = 0.4F;
   private static final float field1136 = 0.2F;
   private static final float field1087 = 6.0F;
   private static final float field1196 = 12.0F;
   private static final float field0871 = 2.0F;
   private static final float field0826 = 4.0F;
   private static float field0910;
   private static float field1331;
   private static boolean field1312;
   private static int field1370 = -1;
   private static long field0387;
   private static boolean field0369;
   private static int field0424;

   public NeuralRotationStrategy() {
      super("Neuro");
   }

   public static void method0025() {
      field0387 = System.currentTimeMillis();
   }

   @Override
   public Rotation method0874(Rotation var1, Rotation var2, class_243 var3, class_1297 var4) {
      if (field0796.field_1724 == null || field0796.field_1687 == null) {
         return var2;
      }

      if (!(var4 instanceof class_1309)) {
         return method0182(var1, var2);
      }

      if (field0369) {
         field0369 = false;
         field1312 = false;
      }

      if (!NeuralRotationModel.method0579()) {
         return var2;
      }

      int var5 = var4.method_5628();
      if (var5 != field1370) {
         field1312 = false;
         field1370 = var5;
      }

      float var6 = var1.method2047();
      float var7 = var1.method1762();
      float var8 = field1312 ? class_3532.method_15393(var6 - field0910) : 0.0F;
      float var9 = field1312 ? var7 - field1331 : 0.0F;
      class_243 var10 = field0796.field_1724.method_33571();
      class_243 var11 = var4.method_33571();
      float var12 = class_3532.method_15393(var2.method2047());
      float var13 = class_3532.method_15363(var2.method1762(), -90.0F, 90.0F);
      float var14 = (float)var10.method_1022(var11);
      float var15 = class_3532.method_15393(var6);
      float var16 = method0645(var15 - var12);
      float var17 = var7 - var13;
      float var18 = class_3532.method_15363(var7, -30.0F, 70.0F);
      float var19 = class_3532.method_15363(var16, -120.0F, 120.0F);
      float var20 = class_3532.method_15363(var17, -45.0F, 45.0F);
      int var21 = field0796.field_1724.method_24828() ? 1 : 0;
      int var22 = !field0796.field_1724.method_6128() && !field0796.field_1724.method_5869() ? 0 : 1;
      float var23 = field0796.field_1724.method_7261(0.0F);
      int var24 = field0796.field_1724.field_6279;
      long var25 = field0387 == 0L ? 0L : System.currentTimeMillis() - field0387;
      float[] var27 = new float[]{
         var8,
         var9,
         var15,
         var18,
         var12,
         var13,
         var14,
         var19,
         var20,
         (float)var10.field_1352,
         (float)var10.field_1351,
         (float)var10.field_1350,
         (float)var11.field_1352,
         (float)var11.field_1351,
         (float)var11.field_1350,
         var21,
         var22,
         var23,
         var24,
         (float)var25
      };
      double var28 = class_3532.method_15350(NeuralRotationModel.method1578(var27), -60.0, 60.0);
      double var30 = class_3532.method_15350(NeuralRotationModel.method0348(var27), -25.0, 25.0);
      float var32 = method0115(Math.abs(var16));
      var28 *= var32;
      var30 *= var32;
      double var33 = 0.39000002F;
      var28 += class_3532.method_15350(-var16 * var33, -60.0, 60.0);
      var30 += class_3532.method_15350(-var17 * var33, -25.0, 25.0);
      var28 = method0631(var28, var16);
      var30 = method0631(var30, var17);
      float var35 = var23 >= 0.9F ? 0.08F : 1.0F;
      var28 += ThreadLocalRandom.current().nextGaussian() * 0.30000014367120315 * var35;
      var30 += ThreadLocalRandom.current().nextGaussian() * 0.30000014367120315 * var35;
      float var36 = (float)class_3532.method_15338(var6 + var28);
      float var37 = class_3532.method_15363((float)(var7 + var30), -90.0F, 90.0F);
      field0910 = var6;
      field1331 = var7;
      field1312 = true;
      return new Rotation(var36, var37);
   }

   private static Rotation method0182(Rotation var0, Rotation var1) {
      if (!field0369) {
         field0369 = true;
         field0424 = 0;
         field1312 = false;
      }

      int var2 = field0424++;
      float var3 = var0.method2047();
      float var4 = var0.method1762();
      float var5 = class_3532.method_15393(var1.method2047());
      float var6 = class_3532.method_15363(var1.method1762(), -90.0F, 90.0F);
      float var7 = method0645(class_3532.method_15393(var3) - var5);
      float var8 = var4 - var6;
      double var9 = -var7 * 0.4F;
      double var11 = -var8 * 0.4F;
      float var13 = method0115(Math.abs(var7));
      var9 *= var13;
      var11 *= var13;
      var9 = class_3532.method_15350(var9, -60.0, 60.0);
      var11 = class_3532.method_15350(var11, -25.0, 25.0);
      var9 += ThreadLocalRandom.current().nextGaussian() * 0.30000014367120315;
      var11 += ThreadLocalRandom.current().nextGaussian() * 0.30000014367120315;
      long var14 = System.currentTimeMillis();
      float var16 = (float)(var14 % 2000L) / 75.0F;
      float var17 = (float)(var14 % 1000L) / 75.0F;
      float var18;
      float var19;
      switch (var2 % 4) {
         case 0:
            var18 = (float)Math.cos(var16);
            var19 = (float)Math.sin(var17);
            break;
         case 1:
            var18 = (float)Math.sin(var16);
            var19 = (float)Math.cos(var17);
            break;
         case 2:
            var18 = (float)Math.sin(var16);
            var19 = (float)(-Math.cos(var17));
            break;
         default:
            var18 = (float)(-Math.cos(var16));
            var19 = (float)Math.sin(var17);
      }

      float var20 = (float)Math.exp(-var2 * 0.2F);
      float var21 = method0667(6.0F, 12.0F) * var18 * var20;
      float var22 = method0667(2.0F, 4.0F) * var19 * var20;
      float var23 = (float)class_3532.method_15338(var3 + var9 + var21);
      float var24 = class_3532.method_15363((float)(var4 + var11 + var22), -90.0F, 90.0F);
      return new Rotation(var23, var24);
   }

   private static float method0667(float var0, float var1) {
      return class_3532.method_16439(ThreadLocalRandom.current().nextFloat(), var0, var1);
   }

   private static double method0631(double var0, float var2) {
      return var2 != 0.0F && Math.signum(var0) == Math.signum((double)(-var2)) && Math.abs(var0) > Math.abs(var2) ? -var2 : var0;
   }

   private static float method0645(float var0) {
      return ((var0 + 180.0F) % 360.0F + 360.0F) % 360.0F - 180.0F;
   }

   private static float method0115(float var0) {
      if (var0 <= 30.0F) {
         return 1.0F;
      }

      float var1 = 30.0F + (float)(ThreadLocalRandom.current().nextGaussian() * 3.0);
      if (var0 <= var1) {
         return 1.0F;
      }

      float var2 = class_3532.method_15363((var0 - var1) / 30.0F, 0.0F, 1.0F);
      float var3 = (30.0F * var2 * var2 - 60.0F * var2 * var2 * var2 + 30.0F * var2 * var2 * var2 * var2) / 1.875F;
      float var4 = 1.5F + (float)(ThreadLocalRandom.current().nextGaussian() * 0.35000005F);
      var4 = class_3532.method_15363(var4, 0.6F, 2.4F);
      return 1.0F + var3 * var4;
   }

   @Override
   public class_243 method0569() {
      return class_243.field_1353;
   }
}
