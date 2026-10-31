package aethereal;

import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_3532;
import net.minecraft.class_5498;

public final class BetterF5 extends Module {
   private final FloatSetting field0060 = new FloatSetting("betterf5.distance", 8.5F, 2.0F, 15.0F, 0.5F)
      .method1007("Distance")
      .method0210("Camera distance from player")
      .method2130("Расстояние камеры от игрока");
   private final FloatSetting field1450 = new FloatSetting("betterf5.height", 0.1F, -2.0F, 3.0F, 0.1F)
      .method1007("Height")
      .method0210("Camera height offset")
      .method2130("Смещение высоты камеры");
   private static final float field0957 = 0.08F;
   private static final float field0177 = 0.12F;
   private static final float field0458 = 0.05F;
   private static final float field1614 = 0.4F;
   private static final float field1538 = 0.8F;
   private static final float field1704 = 0.5F;
   private static final float field1136 = 100.0F;
   private static final float field1087 = 0.25F;
   private static final float field1196 = 40.0F;
   private static final float field0871 = 0.6F;
   private static final float field0826 = 0.06F;
   private double field0909;
   private double field1330;
   private double field1291;
   private double field1368;
   private double field0384;
   private float field0351;
   private double field0422;
   private double field0254;
   private float field0226;
   private long field0291;
   private class_5498 field0537 = class_5498.field_26664;
   private boolean field0514 = true;
   private long field0549;
   private boolean field1683 = false;

   public BetterF5() {
      super("BetterF5", ModuleCategory.field1004, "Improved third-person camera controls");
      this.method1013("Улучшенное управление камерой от третьего лица");
      DaamkyClient.method2004().method2072().subscribe(this);
   }

   @Override
   public void method0025() {
      super.method0025();
      this.method1735();
   }

   @Override
   public void method2078() {
      this.method1735();
      super.method2078();
   }

   @EventHandler
   public void onJump(JumpEvent var1) {
      if (this.field0751) {
         this.field0291 = System.currentTimeMillis();
      }
   }

   @EventHandler
   public void onCameraUpdate(CameraEvent var1) {
      if (!this.field0751) {
         this.method1735();
      } else {
         class_5498 var2 = field0796.field_1690.method_31044();
         if (var2 != this.field0537) {
            if (var2 != class_5498.field_26664) {
               this.field0514 = true;
            }

            this.field0537 = var2;
         }

         if (var2 != class_5498.field_26664) {
            long var3 = System.currentTimeMillis();
            float var5 = this.field0549 == 0L ? 0.016F : class_3532.method_15363((float)(var3 - this.field0549) / 1000.0F, 0.001F, 0.1F);
            this.field0549 = var3;
            if (var1.method1807().method_19331() instanceof class_1657 var7) {
               if (this.field0514) {
                  this.method0797(var1);
                  this.field0514 = false;
               }

               this.method1182(var7);
               this.method0665(var5);
               this.method0798(var1, var7);
            }
         }
      }
   }

   private void method0797(CameraEvent var1) {
      float var2 = this.field0060.method0492();
      float var3 = this.field1450.method0492();
      this.field0909 = var2;
      this.field1330 = var3;
      this.field1291 = var1.method1945();
      this.field1368 = var1.method0412();
      this.field0384 = var1.method0354();
      this.field0351 = 0.0F;
      this.field0422 = var2;
      this.field0254 = var3;
      this.field0226 = 0.0F;
      this.field0291 = 0L;
      this.field0549 = System.currentTimeMillis();
   }

   private void method1182(class_1657 var1) {
      float var2 = this.field0060.method0492();
      float var3 = this.field1450.method0492();
      boolean var4 = field0796.field_1690.method_31044() == class_5498.field_26666;
      double var5 = var2;
      double var7 = var3;
      float var9 = 0.0F;
      double var10 = CameraMath.method1177(var1);
      if (CameraMath.method1855(var1)) {
         double var12 = class_3532.method_15350(var10 / 0.30000002483330174, 0.0, 1.0);
         if (var4) {
            var5 += 1.2000005543231964 * CameraMath.method0102(var12);
         } else {
            var5 += 0.7999999F * CameraMath.method0102(var12);
         }
      } else if (var10 > 0.010000003756227357) {
         double var18 = class_3532.method_15350(var10 / 0.1500000901677722, 0.0, 1.0);
         if (var4) {
            var5 += 0.47999983021081966 * CameraMath.method2085(var18);
         } else {
            var5 += 0.4F * CameraMath.method2085(var18);
         }
      }

      long var19 = System.currentTimeMillis() - this.field0291;
      if ((float)var19 > 100.0F && (float)var19 < 700.0F) {
         double var14 = ((float)var19 - 100.0F) / 600.0;
         double var16 = CameraMath.method0102(var14) * (1.0 - CameraMath.method0608(var14));
         var7 += 0.5 * var16 * 2.0;
      }

      if (CameraMath.method1664(var1)) {
         double var20 = class_3532.method_15350(Math.abs(var1.method_18798().field_1351) / 0.5, 0.0, 1.0);
         var7 += 0.25 * CameraMath.method0102(var20);
      }

      if (CameraMath.method1991(var1)) {
         double var21 = class_3532.method_15350(var1.method_18798().field_1351 / 0.39999996007461613, 0.0, 1.0);
         var7 += 0.1500000901677722 * var21;
      }

      this.field1683 = CameraMath.method0579();
      if (this.field1683) {
         class_2338 var22 = CameraMath.method0022();
         class_2350 var15 = CameraMath.method2076();
         if (var22 != null && var15 != null) {
            var9 = switch (var15) {
               case field_11043, field_11034 -> -40.0F;
               case field_11035, field_11039 -> 40.0F;
               default -> var1.field_6283 > var1.method_36454() ? -40.0F : 40.0F;
            };
            var5 += 0.60000026F;
            var7 += 0.1500000901677722;
         }
      }

      this.field0422 = var5;
      this.field0254 = var7;
      this.field0226 = var9;
   }

   private void method0665(float var1) {
      double var2 = this.field1683 ? 0.06F : 0.08000003F;
      double var4 = 1.0 / (var2 * 10.0);
      double var6 = 2.0;
      if (Math.abs(this.field0909 - this.field0422) > 9.99999425615245E-4) {
         this.field0909 = CameraMath.method2090(this.field0909, this.field0422, var6, var1);
         if (Math.abs(this.field0909 - this.field0422) < 9.99999425615245E-4) {
            this.field0909 = this.field0422;
         }
      }

      if (Math.abs(this.field1330 - this.field0254) > 9.99999425615245E-4) {
         this.field1330 = CameraMath.method2090(this.field1330, this.field0254, var4, var1);
         if (Math.abs(this.field1330 - this.field0254) < 9.99999425615245E-4) {
            this.field1330 = this.field0254;
         }
      }

      if (Math.abs(this.field0351 - this.field0226) > 0.010000003756227357) {
         this.field0351 = (float)CameraMath.method2090(this.field0351, this.field0226, var4, var1);
         if (Math.abs(this.field0351 - this.field0226) < 0.010000003756227357) {
            this.field0351 = this.field0226;
         }
      }
   }

   private void method0798(CameraEvent var1, class_1657 var2) {
      var1.method0665((float)this.field0909);
      double var3 = var1.method1945();
      double var5 = var1.method0412() + this.field1330;
      double var7 = var1.method0354();
      double var9 = 0.8333331447600631;
      if (Math.abs(var3 - this.field1291) > 9.99999425615245E-4
         || Math.abs(var5 - this.field1368) > 9.99999425615245E-4
         || Math.abs(var7 - this.field0384) > 9.99999425615245E-4) {
         this.field1291 = CameraMath.method2090(this.field1291, var3, var9, 0.01599999F);
         this.field1368 = CameraMath.method2090(this.field1368, var5, var9, 0.01599999F);
         this.field0384 = CameraMath.method2090(this.field0384, var7, var9, 0.01599999F);
         if (Math.abs(var3 - this.field1291) < 9.99999425615245E-4) {
            this.field1291 = var3;
         }

         if (Math.abs(var5 - this.field1368) < 9.99999425615245E-4) {
            this.field1368 = var5;
         }

         if (Math.abs(var7 - this.field0384) < 9.99999425615245E-4) {
            this.field0384 = var7;
         }
      }

      var1.method0611(this.field1291);
      var1.method0103(this.field1368);
      var1.method2086(this.field0384);
      if (Math.abs(this.field0351) > 0.5F) {
         var1.method0675(var1.method0483() + this.field0351, var1.method2213());
      }
   }

   private void method1735() {
      float var1 = this.field0060.method0492();
      float var2 = this.field1450.method0492();
      this.field0909 = var1;
      this.field1330 = var2;
      this.field1291 = 0.0;
      this.field1368 = 0.0;
      this.field0384 = 0.0;
      this.field0351 = 0.0F;
      this.field0422 = var1;
      this.field0254 = var2;
      this.field0226 = 0.0F;
      this.field0291 = 0L;
      this.field0514 = true;
      this.field0549 = 0L;
      this.field1683 = false;
   }
}
