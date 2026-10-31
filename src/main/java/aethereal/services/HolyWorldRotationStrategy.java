package aethereal;

import net.minecraft.class_1297;
import net.minecraft.class_1675;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;

public class HolyWorldRotationStrategy extends RotationStrategy implements MinecraftAccess {
   private static float field0566 = 0.0F;
   private static long field0005 = 0L;
   private static boolean field1527 = false;
   private static int field0958 = -1;
   private static float field0177 = 0.0F;
   private static float field0458 = 0.0F;
   private static float field1614 = 0.0F;
   private static float field1538 = 0.0F;
   private static float field1704 = 0.0F;
   private static float field1136 = 0.0F;
   private static boolean field1109 = false;
   private static long field1198 = 0L;
   private static long field0873 = 0L;
   private static float field0826 = 1.0F;
   private static boolean field0931 = false;
   private static long field1333 = 0L;
   private static long field1294 = 0L;
   private static float field1369 = 1.0F;
   private static long field0387 = 0L;
   private static long field0353 = 0L;
   private static float field0423 = 1.0F;
   private static float field0255 = 1.0F;
   private static float field0226 = 1.0F;
   private static float field0289 = 1.0F;
   private static float field0523 = 0.0F;
   private static float field0501 = 0.0F;
   private static float field0547 = 0.0F;
   private static long field1673 = 0L;
   private static float field1657 = 0.0F;
   private static float field1688 = 0.0F;
   private static float field1590 = 0.0F;
   private static float field1577 = 0.0F;
   private static int field1602 = -1;
   private static final float field1753 = 16.6667F;
   private static long field1741 = 0L;
   private static float field1766 = 1.0F;

   public HolyWorldRotationStrategy() {
      super("HolyWorld");
   }

   @Override
   public Rotation method0874(Rotation var1, Rotation var2, class_243 var3, class_1297 var4) {
      long var5 = System.currentTimeMillis();
      float var7 = (float)var5 / 1000.0F;
      if (field1741 == 0L) {
         field1766 = 1.0F;
      } else {
         long var8 = Math.max(1L, var5 - field1741);
         field1766 = class_3532.method_15363((float)var8 / 16.6667F, 0.1F, 10.0F);
      }

      field1741 = var5;
      AttackController var57 = DaamkyClient.method2004().method1881().method2051();
      int var9 = var57.method0414();
      if (field1602 != -1 && var9 != field1602) {
         field1673 = var5;
         float var10 = Math.random() < 0.5 ? -1.0F : 1.0F;
         float var11 = Math.random() < 0.5 ? -1.0F : 1.0F;
         field1657 = var10 * MathHelper.method1823(0.15F, 0.4F);
         field1688 = var11 * MathHelper.method1823(0.1F, 0.28F);
      }

      field1602 = var9;
      int var58 = var4 != null ? var4.method_5628() : -1;
      if (var58 != field0958) {
         field1527 = false;
         field0005 = 0L;
         field0177 = MathHelper.method1823(0.0F, (float) (Math.PI * 2));
         field0458 = MathHelper.method1823(0.0F, (float) (Math.PI * 2));
         field1614 = MathHelper.method1823(0.0F, (float) (Math.PI * 2));
         field1538 = MathHelper.method1823(0.0F, (float) (Math.PI * 2));
         field1704 = 0.0F;
         field1136 = 0.0F;
         field1109 = false;
         field1198 = 0L;
         field0873 = 0L;
         field0826 = 1.0F;
         field0931 = false;
         field1333 = 0L;
         field1294 = 0L;
         field1369 = 1.0F;
         field0387 = 0L;
         field0353 = 0L;
         field0423 = 1.0F;
         field0255 = 1.0F;
         field0226 = 1.0F;
         field0289 = 1.0F;
         field0523 = 0.0F;
         field0501 = 0.0F;
         field0547 = 0.0F;
         field1590 = 0.0F;
         field1577 = 0.0F;
         field0958 = var58;
      }

      Rotation var59 = var2;
      if (var4 != null && field0796.field_1724 != null) {
         class_243 var12 = var4.method_5829().method_1005();
         var59 = RotationHelper.method1296(var12.method_1020(field0796.field_1724.method_33571()));
      }

      float var60 = (float)(Math.sin(var7 * 0.5500000015139996 + field0177) * 0.9000000047080011 + Math.sin(var7 * 1.1000001231247238 + field0458) * 0.5);
      float var13 = (float)(Math.sin(var7 * 0.5 + field1614) * 0.70000012681449 + Math.sin(var7 * 0.9500000003726716 + field1538) * 0.35000000375877394);
      field1704 = class_3532.method_15363(field1704 * method2092(0.995F) + MathHelper.method1823(-method1817(0.03F), method1817(0.03F)), -1.0F, 1.0F);
      field1136 = class_3532.method_15363(field1136 * method2092(0.995F) + MathHelper.method1823(-method1817(0.025F), method1817(0.025F)), -0.7F, 0.7F);
      float var14 = var60 + field1704;
      float var15 = var13 + field1136;
      Rotation var16 = new Rotation(var59.method2047() + var14, var59.method1762() + var15);
      Rotation var17 = RotationHelper.method0872(var1, var16);
      float var18 = var17.method2047();
      float var19 = var17.method1762();
      float var20 = Math.abs(var18);
      float var21 = Math.abs(var19);
      Aura var22 = Aura.method1701();
      float var23 = var22 != null ? var22.method2204().method0492() + var22.method2201().method0492() : 4.5F;
      class_3966 var24 = method0637(var23, var1);
      boolean var25 = var4 != null && var24 != null && var24.method_17782() == var4;
      if (field1527 && !var25 && var5 >= field0005) {
         field0005 = var5 + MathHelper.method2105(3, 77);
      }

      field1527 = var25;
      float var26 = (float)(Math.sin(var7 * 2.0 + 0.3000001453008759) * 0.05000000152067581 + Math.cos(var7 * 1.7000005722106721) * 0.02999998935021761);
      float var27 = (float)(Math.sin(var7 * 2.3000000016648885) * 0.05999997590294254 + Math.cos(var7 * 1.5) * 0.04000000023482025);
      float var28 = (float)(var5 - field1673) / 1000.0F;
      float var29 = var28 > 0.0F ? (float)Math.exp(-var28 * 7.0) : 0.0F;
      float var30 = field1657 * var29;
      float var31 = field1688 * var29;
      if (var5 < field0005) {
         field0547 = MathHelper.method0129(field0547, 1.0F, method0115(0.72F));
      } else {
         field0547 = MathHelper.method0129(field0547, 0.0F, method0115(0.184F));
      }

      if (!field1109 && var20 > 42.0F && !var25) {
         field1109 = true;
         field1198 = var5 + MathHelper.method2105(145, 270);
         field0873 = field1198;
      }

      if (field1109 && var20 < 8.0F) {
         field1109 = false;
         field1198 = 0L;
         field0873 = 0L;
      }

      boolean var32 = field1109 && var5 < field1198;
      boolean var33 = field1109 && !var32 && var5 < field0873;
      if (field1109 && !var32 && !var33) {
         field1198 = var5 + MathHelper.method2105(145, 270);
         field0873 = field1198 + MathHelper.method2105(72, 162);
         var32 = true;
      } else if (field1109 && var32 && field0873 <= field1198) {
         field0873 = field1198 + MathHelper.method2105(72, 162);
      }

      float var34 = field1109 && !var32 ? 0.0F : 1.0F;
      field0826 = MathHelper.method0129(field0826, var34, method0115(0.168F));
      if (!field0931 && var21 > 20.0F && !var25) {
         field0931 = true;
         field1333 = var5 + MathHelper.method2105(145, 270);
         field1294 = field1333;
      }

      if (field0931 && var21 < 4.0F) {
         field0931 = false;
         field1333 = 0L;
         field1294 = 0L;
      }

      boolean var35 = field0931 && var5 < field1333;
      boolean var36 = field0931 && !var35 && var5 < field1294;
      if (field0931 && !var35 && !var36) {
         field1333 = var5 + MathHelper.method2105(145, 270);
         field1294 = field1333 + MathHelper.method2105(72, 162);
         var35 = true;
      } else if (field0931 && var35 && field1294 <= field1333) {
         field1294 = field1333 + MathHelper.method2105(72, 162);
      }

      float var37 = field0931 && !var35 ? 0.0F : 1.0F;
      field1369 = MathHelper.method0129(field1369, var37, method0115(0.168F));
      float var38 = var25 ? 1.0F : 0.0F;
      float var39 = var25 ? 0.468F : 0.187F;
      field0566 = MathHelper.method0129(field0566, var38, method0115(var39));
      if (var5 >= field0387) {
         field0226 = var25 ? MathHelper.method1823(0.9F, 1.08F) : MathHelper.method1823(0.78F, 1.24F);
         field0387 = var5 + MathHelper.method2105(85, 230);
      }

      if (var5 >= field0353) {
         field0289 = var25 ? MathHelper.method1823(0.92F, 1.06F) : MathHelper.method1823(0.82F, 1.18F);
         field0353 = var5 + MathHelper.method2105(95, 260);
      }

      field0423 = MathHelper.method0129(field0423, field0226, method0115(0.204F));
      field0255 = MathHelper.method0129(field0255, field0289, method0115(0.187F));
      field0523 = class_3532.method_15363(field0523 * method2092(0.74F) + MathHelper.method1823(-method1817(0.014F), method1817(0.014F)), -0.045F, 0.045F);
      field0501 = class_3532.method_15363(field0501 * method2092(0.76F) + MathHelper.method1823(-method1817(0.011F), method1817(0.011F)), -0.035F, 0.035F);
      float var40 = class_3532.method_15363(
         1.0F + (float)Math.sin(var7 * 8.7F + field0177 * 0.31F) * 0.028F + (float)Math.sin(var7 * 15.4F + field0458 * 0.57F) * 0.014F + field0523,
         0.92F,
         1.08F
      );
      float var41 = class_3532.method_15363(
         1.0F + (float)Math.sin(var7 * 7.9F + field1614 * 0.34F) * 0.022F + (float)Math.sin(var7 * 13.8F + field1538 * 0.52F) * 0.012F + field0501,
         0.93F,
         1.07F
      );
      float var42 = 1.0F - field0566;
      float var43 = 1.0F - field0547;
      float var44 = (float)(
         Math.sin(var7 * 1.2999995530970996) * 0.35000000375877394 + Math.sin(var7 * 0.6000000821901307 + 1.7000005722106721) * 0.20000003786594506
      );
      float var45 = (float)(Math.cos(var7 * 1.1000001231247238 + 0.39999997119451247) * 0.3000001453008759 + Math.cos(var7 * 0.5) * 0.20000003786594506);
      float var46 = class_3532.method_15363(17.22F + var44 * 8.61F, 7.38F, 27.05F);
      float var47 = class_3532.method_15363(4.91F + var45 * 3.07F, 2.21F, 8.61F);
      float var48 = class_3532.method_15363(var20 / 25.0F, 0.25F, 1.0F);
      float var49 = method0645(var46 * var42 * var48 * field0826 * var43 * field0423 * var40);
      float var50 = method0645(var47 * var42 * field0826 * field1369 * var43 * field0255 * var41);
      float var51 = class_3532.method_15363(var18, -var49, var49);
      float var52 = class_3532.method_15363(var19, -var50, var50);
      float var53 = var26 + var30;
      float var54 = var27 + var31;
      float var55 = var53 - field1590;
      float var56 = var54 - field1577;
      field1590 = var53;
      field1577 = var54;
      return new Rotation(var1.method2047() + var51 + var55, var1.method1762() + var52 + var56);
   }

   @Override
   public class_243 method0569() {
      return new class_243(0.0, 0.0, 0.0);
   }

   private static float method0645(float var0) {
      return var0 * field1766;
   }

   private static float method0115(float var0) {
      float var1 = class_3532.method_15363(var0, 0.0F, 1.0F);
      return 1.0F - (float)Math.pow(1.0F - var1, field1766);
   }

   private static float method2092(float var0) {
      return (float)Math.pow(class_3532.method_15363(var0, 0.0F, 1.0F), field1766);
   }

   private static float method1817(float var0) {
      return var0 * (float)Math.sqrt(field1766);
   }

   private static class_3966 method0637(double var0, Rotation var2) {
      class_1297 var3 = field0796.method_1560();
      if (var3 != null && field0796.field_1687 != null) {
         class_243 var4 = var3.method_33571();
         class_243 var5 = var2.method0024();
         class_243 var6 = var4.method_1031(var5.field_1352 * var0, var5.field_1351 * var0, var5.field_1350 * var0);
         class_238 var7 = var3.method_5829().method_18804(var5.method_1021(var0)).method_1009(1.0, 1.0, 1.0);
         class_3966 var8 = class_1675.method_18075(
            var3, var4, var6, var7, var0x -> var0x.method_5863() && var0x.method_5805() && !var0x.method_7325(), var0 * var0
         );
         if (var8 == null) {
            return null;
         }

         class_243 var9 = var8.method_17782().method_5829().method_992(var4, var6).orElse(var8.method_17782().method_19538());
         class_3965 var10 = field0796.field_1687.method_17742(new class_3959(var4, var9, class_3960.field_17558, class_242.field_1347, field0796.field_1724));
         if (var10 != null && var10.method_17783() == class_240.field_1332) {
            class_2680 var11 = field0796.field_1687.method_8320(var10.method_17777());
            if (var11 != null
               && !var11.method_26220(field0796.field_1687, var10.method_17777()).method_1110()
               && var10.method_17784().method_1025(var4) < var9.method_1025(var4)) {
               return null;
            }
         }

         return var8;
      } else {
         return null;
      }
   }
}
