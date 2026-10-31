package aethereal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import org.joml.Matrix4f;

public class Trails extends Module {
   private final EnumSetting<Trails.Mode> field0058 = new EnumSetting<>("particletrails.mode", Trails.Mode.field0130)
      .method1007("Mode")
      .method0210("Particle style")
      .method2130("Стиль частиц");
   private final FloatSetting field1450 = new FloatSetting("particletrails.amount", 10.0F, 1.0F, 20.0F, 1.0F)
      .method1007("Amount")
      .method0210("Particles spawned per tick")
      .method2130("Количество");
   private final FloatSetting field0985 = new FloatSetting("particletrails.size", 0.05F, 0.02F, 0.3F, 0.01F)
      .method1007("Size")
      .method0210("Base size of particles")
      .method2130("Размер");
   private final FloatSetting field0190 = new FloatSetting("particletrails.speed", 0.03F, 0.01F, 0.2F, 0.01F)
      .method1007("Speed")
      .method0210("Particle drift speed")
      .method2130("Скорость");
   private final FloatSetting field0470 = new FloatSetting("particletrails.lifetime", 50.0F, 10.0F, 100.0F, 1.0F)
      .method1007("Lifetime")
      .method0210("How long particles last in ticks")
      .method2130("Длительность");
   private final BooleanSetting field1619 = new BooleanSetting("particletrails.onlymoving", true)
      .method1007("Only Moving")
      .method0210("Only spawn particles while moving")
      .method2130("Создавать только при движении");
   private final BooleanSetting field1544 = new BooleanSetting("particletrails.thirdpersononly", false)
      .method1007("Third Person Only")
      .method0210("Only spawn particles in third person")
      .method2130("Создавать только от третьего лица");
   private final BooleanSetting field1709 = new BooleanSetting("particletrails.shine", true)
      .method1007("Shine")
      .method0210("Additive blending for glow")
      .method2130("Сияние");
   private final ColorSetting field1143 = new ColorSetting("particletrails.color", 255, 156, 228, 200)
      .method1882()
      .method1007("Color")
      .method0210("Particle trail color")
      .method2130("Цвет");
   private class_243 field1107 = class_243.field_1353;
   private final List<Trails.TrailParticle> field1213 = new ArrayList<>();
   private final Random field0886 = new Random();
   private int field0827 = 0;
   private boolean field0931 = true;
   private double field1330 = 0.0;
   private static final Trails.ParticleType[] field1313 = Trails.ParticleType.values();

   public Trails() {
      super("Trails", ModuleCategory.field1004, "Trails");
      this.method1013("Следы частиц за игроком");
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field1213.clear();
      this.field0827 = 0;
   }

   @Override
   public void method2078() {
      super.method2078();
      this.field1213.clear();
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         this.field0827++;
         class_243 var2 = field0796.field_1724.method_19538();
         class_243 var3 = var2.method_1020(this.field1107);
         boolean var4 = var3.method_1027() > 9.999997089662838E-5;
         double var5 = var3.method_37267();
         boolean var7 = field0796.field_1724.method_24828();
         double var8 = Math.toRadians(field0796.field_1724.method_36454());
         double var10 = var8 - this.field1330;
         if (this.field1544.method0492() && field0796.field_1690.method_31044().method_31034()) {
            this.field1107 = var2;
            this.field1330 = var8;
            this.field0931 = var7;
            this.method1735();
         } else if (this.field1619.method0492() && !var4) {
            this.field1107 = var2;
            this.field1330 = var8;
            this.field0931 = var7;
            this.method1735();
         } else {
            if (this.field0058.method0492() == Trails.Mode.field0706) {
               int var12 = this.field1450.method0492().intValue();

               for (int var13 = 0; var13 < var12; var13++) {
                  double var14 = (this.field0886.nextDouble() - 0.5) * 0.5;
                  double var16 = this.field0886.nextDouble() * 0.5;
                  double var18 = (this.field0886.nextDouble() - 0.5) * 0.5;
                  this.field1213
                     .add(
                        new Trails.TrailParticle(
                           var2.field_1352 + var14,
                           var2.field_1351 + var16,
                           var2.field_1350 + var18,
                           (this.field0886.nextDouble() - 0.5) * this.field0190.method0492().floatValue(),
                           this.field0886.nextDouble() * this.field0190.method0492().floatValue() * 0.5,
                           (this.field0886.nextDouble() - 0.5) * this.field0190.method0492().floatValue(),
                           (int)this.field0470.method0492().floatValue(),
                           Trails.ParticleType.field0705,
                           this.field0886.nextFloat() * 360.0F,
                           (this.field0886.nextFloat() - 0.5F) * 4.0F,
                           this.field0985.method0492()
                        )
                     );
               }
            } else {
               if (this.field0827 % 3 == 0) {
                  double var20 = this.field0827 * 0.11999995558028098;
                  double var32 = 0.5 + Math.sin(this.field0827 * 0.04999999442162316) * 0.2000000451988228;
                  double var36 = 0.7999999405212292 + Math.sin(this.field0827 * 0.0800000001783749) * 0.4000000307956725;
                  this.field1213
                     .add(
                        new Trails.TrailParticle(
                           var2.field_1352 + Math.cos(var20) * var32,
                           var2.field_1351 + var36,
                           var2.field_1350 + Math.sin(var20) * var32,
                           -Math.sin(var20) * 0.020000008426433003,
                           0.005000000029378958,
                           Math.cos(var20) * 0.020000008426433003,
                           (int)(this.field0470.method0492() * 0.8F),
                           Trails.ParticleType.field0705,
                           this.field0886.nextFloat() * 360.0F,
                           5.0F + this.field0886.nextFloat() * 4.0F,
                           this.field0985.method0492() * 1.2F
                        )
                     );
               }

               if (var4 && var7 && this.field0827 % 2 == 0) {
                  for (int var21 = 0; var21 < 2; var21++) {
                     double var28 = (this.field0886.nextDouble() - 0.5) * 0.3000000263176597;
                     double var15 = (this.field0886.nextDouble() - 0.5) * 0.3000000263176597;
                     this.field1213
                        .add(
                           new Trails.TrailParticle(
                              var2.field_1352 + var28,
                              var2.field_1351 + 0.04999999442162316,
                              var2.field_1350 + var15,
                              (this.field0886.nextDouble() - 0.5) * 0.029999993538952358,
                              0.020000008426433003 + this.field0886.nextDouble() * 0.020000008426433003,
                              (this.field0886.nextDouble() - 0.5) * 0.029999993538952358,
                              15 + this.field0886.nextInt(10),
                              Trails.ParticleType.field0129,
                              this.field0886.nextFloat() * 360.0F,
                              15.0F + this.field0886.nextFloat() * 10.0F,
                              this.field0985.method0492() * 0.7F
                           )
                        );
                  }
               }

               if (var4 && var5 > 0.04999999442162316) {
                  class_243 var22 = var3.method_1029();
                  double var29 = -0.30000014532136227;
                  this.field1213
                     .add(
                        new Trails.TrailParticle(
                           var2.field_1352 + var22.field_1352 * var29 + (this.field0886.nextDouble() - 0.5) * 0.10000000116859084,
                           var2.field_1351 + 0.3000000263176597 + this.field0886.nextDouble() * 0.5,
                           var2.field_1350 + var22.field_1350 * var29 + (this.field0886.nextDouble() - 0.5) * 0.10000000116859084,
                           -var22.field_1352 * 0.010000000500225757,
                           0.002999999130636981,
                           -var22.field_1350 * 0.010000000500225757,
                           (int)(this.field0470.method0492() * 0.5F),
                           Trails.ParticleType.field1498,
                           (float)Math.toDegrees(Math.atan2(var22.field_1350, var22.field_1352)),
                           3.0F + this.field0886.nextFloat() * 4.0F,
                           this.field0985.method0492() * (1.0F + (float)var5 * 5.0F)
                        )
                     );
               }

               if (var4 && var5 > 0.15000007152564834 && this.field0827 % 5 == 0) {
                  double var23 = this.field0886.nextDouble() * 3.1415936109900606 * 2.0;
                  this.field1213
                     .add(
                        new Trails.TrailParticle(
                           var2.field_1352,
                           var2.field_1351 + 0.5,
                           var2.field_1350,
                           Math.cos(var23) * 0.040000000007288476,
                           0.0,
                           Math.sin(var23) * 0.040000000007288476,
                           (int)(this.field0470.method0492() * 0.6F),
                           Trails.ParticleType.field1022,
                           this.field0886.nextFloat() * 360.0F,
                           4.0F + this.field0886.nextFloat() * 5.0F,
                           this.field0985.method0492() * 0.5F
                        )
                     );
               }

               if (Math.abs(var10) > 0.029999993538952358 && this.field0827 % 3 == 0) {
                  double var24 = var10 > 0.0 ? 1.0 : -1.0;
                  double var33 = Math.cos(var8 + 1.5707968931794145) * var24 * 0.4000000307956725;
                  double var37 = Math.sin(var8 + 1.5707968931794145) * var24 * 0.4000000307956725;
                  this.field1213
                     .add(
                        new Trails.TrailParticle(
                           var2.field_1352 + var33,
                           var2.field_1351 + 0.6000000179323369 + this.field0886.nextDouble() * 0.3000000263176597,
                           var2.field_1350 + var37,
                           var33 * 0.04999999442162316,
                           0.010000000500225757,
                           var37 * 0.04999999442162316,
                           (int)(this.field0470.method0492() * 0.7F),
                           Trails.ParticleType.field0786,
                           this.field0886.nextFloat() * 360.0F,
                           8.0F + this.field0886.nextFloat() * 6.0F,
                           this.field0985.method0492() * 0.9F
                        )
                     );
               }

               if (var4 && var5 > 0.10000000116859084 && this.field0827 % 4 == 0) {
                  this.field1213
                     .add(
                        new Trails.TrailParticle(
                           var2.field_1352 + (this.field0886.nextDouble() - 0.5) * 0.2000000451988228,
                           var2.field_1351 + 0.4000000307956725 + this.field0886.nextDouble() * 0.6000000179323369,
                           var2.field_1350 + (this.field0886.nextDouble() - 0.5) * 0.2000000451988228,
                           (this.field0886.nextDouble() - 0.5) * 0.014999993974599377,
                           0.00800000035432636,
                           (this.field0886.nextDouble() - 0.5) * 0.014999993974599377,
                           (int)(this.field0470.method0492() * 1.2F),
                           Trails.ParticleType.field1267,
                           this.field0827 * 5.0F,
                           2.0F + this.field0886.nextFloat() * 3.0F,
                           this.field0985.method0492() * 1.1F
                        )
                     );
               }

               if (var7 && !this.field0931 && var3.field_1351 < -0.30000014532136227) {
                  int var25 = 6 + this.field0886.nextInt(5);

                  for (int var30 = 0; var30 < var25; var30++) {
                     double var34 = 6.283186640837165 * var30 / var25;
                     double var38 = 0.04999999442162316 + this.field0886.nextDouble() * 0.040000000007288476;
                     this.field1213
                        .add(
                           new Trails.TrailParticle(
                              var2.field_1352,
                              var2.field_1351 + 0.10000000116859084,
                              var2.field_1350,
                              Math.cos(var34) * var38,
                              0.010000000500225757 + this.field0886.nextDouble() * 0.020000008426433003,
                              Math.sin(var34) * var38,
                              15 + this.field0886.nextInt(10),
                              Trails.ParticleType.field0333,
                              (float)(var34 * 57.30000623020847),
                              8.0F + this.field0886.nextFloat() * 6.0F,
                              this.field0985.method0492() * 1.3F
                           )
                        );
                  }
               }

               if (this.field0827 % 4 == 0) {
                  double var26 = this.field0886.nextDouble() * 3.1415936109900606 * 2.0;
                  double var35 = 0.3000000263176597 + this.field0886.nextDouble() * 0.5;
                  this.field1213
                     .add(
                        new Trails.TrailParticle(
                           var2.field_1352 + Math.cos(var26) * var35,
                           var2.field_1351 + 0.04999999442162316,
                           var2.field_1350 + Math.sin(var26) * var35,
                           0.0,
                           0.014999993974599377 + this.field0886.nextDouble() * 0.010000000500225757,
                           0.0,
                           (int)(this.field0470.method0492() * 0.9F),
                           Trails.ParticleType.field0206,
                           this.field0886.nextFloat() * 360.0F,
                           4.0F + this.field0886.nextFloat() * 4.0F,
                           this.field0985.method0492() * 0.6F
                        )
                     );
               }

               if (var4) {
                  int var27 = Math.min(3, this.field1450.method0492().intValue() / 3);

                  for (int var31 = 0; var31 < var27; var31++) {
                     this.field1213
                        .add(
                           new Trails.TrailParticle(
                              var2.field_1352 + (this.field0886.nextDouble() - 0.5) * 0.4000000307956725,
                              var2.field_1351 + this.field0886.nextDouble() * 0.7999999405212292,
                              var2.field_1350 + (this.field0886.nextDouble() - 0.5) * 0.4000000307956725,
                              (this.field0886.nextDouble() - 0.5) * 0.059999975785620274,
                              (this.field0886.nextDouble() - 0.5) * 0.040000000007288476,
                              (this.field0886.nextDouble() - 0.5) * 0.059999975785620274,
                              8 + this.field0886.nextInt(8),
                              Trails.ParticleType.field0484,
                              0.0F,
                              0.0F,
                              this.field0985.method0492() * 0.4F
                           )
                        );
                  }
               }
            }

            this.field1107 = var2;
            this.field1330 = var8;
            this.field0931 = var7;
            this.method1735();
         }
      }
   }

   private void method1735() {
      Iterator var1 = this.field1213.iterator();

      while (var1.hasNext()) {
         Trails.TrailParticle var2 = var1.next();
         var2.field0956 = var2.field0565;
         var2.field0757 = var2.field0002;
         var2.field1241 = var2.field1409;
         switch (var2.field1724) {
            case field0705:
               double var6 = var2.field1615 * 0.10000000116859084 + var2.field1136 * 0.020000008426433003;
               var2.field0313 = var2.field0313 + Math.cos(var6) * 5.000000039648302E-4;
               var2.field0457 = var2.field0457 + Math.sin(var6) * 5.000000039648302E-4;
               var2.field0176 *= 0.9900000316832716;
               var2.field0313 *= 0.9799995688342711;
               var2.field0457 *= 0.9799995688342711;
               break;
            case field0129:
               var2.field0176 *= 0.9199997616689671;
               var2.field0313 *= 0.8799997697452798;
               var2.field0457 *= 0.8799997697452798;
               break;
            case field1498:
               var2.field0313 *= 0.9000000904037876;
               var2.field0176 *= 0.9000000904037876;
               var2.field0457 *= 0.9000000904037876;
               break;
            case field1022:
               var2.field0313 *= 0.9500001192116827;
               var2.field0457 *= 0.9500001192116827;
               break;
            case field0786:
               var2.field0313 *= 0.9400000009323457;
               var2.field0457 *= 0.9400000009323457;
               var2.field0176 += 5.000000039648302E-4;
               var2.field0176 *= 0.9700000656037335;
               break;
            case field1267:
               double var5 = Math.sin(var2.field1615 * 0.2000000451988228 + var2.field1136 * 0.010000000500225757) * 0.002999999130636981;
               var2.field0313 += var5;
               var2.field0457 += var5 * 0.7000000959882013;
               var2.field0176 += 3.0000000048894566E-4;
               var2.field0313 *= 0.9799995688342711;
               var2.field0457 *= 0.9799995688342711;
               break;
            case field0333:
               var2.field0313 *= 0.930000179411146;
               var2.field0457 *= 0.930000179411146;
               var2.field0176 -= 0.002000000030183859;
               break;
            case field0206:
               double var3 = Math.sin(var2.field1615 * 0.0800000001783749) * 9.999994256636507E-4;
               var2.field0313 += var3;
               var2.field0457 += var3 * 0.5;
               var2.field0176 *= 0.9950002505257888;
               break;
            case field0484:
               var2.field0313 *= 0.8500000819719095;
               var2.field0176 *= 0.8500000819719095;
               var2.field0457 *= 0.8500000819719095;
         }

         var2.field0565 = var2.field0565 + var2.field0313;
         var2.field0002 = var2.field0002 + var2.field0176;
         var2.field1409 = var2.field1409 + var2.field0457;
         var2.field1136 = var2.field1136 + var2.field1087;
         var2.field1615++;
         if (var2.field1615 >= var2.field1539) {
            var1.remove();
         }
      }
   }

   @EventHandler
   public void onRenderWorld(GlowRenderEvent var1) {
      if (!method1974()) {
         class_243 var2 = field0796.field_1773.method_19418().method_19326();
         Matrix4f var3 = new class_4587().method_23760().method_23761();
         float var4 = var1.method1603();
         Color var5 = this.field1143.method1726();
         int var6 = var5.getRGB() & 16777215;
         boolean var7 = this.field1709.method0492();
         if (!this.field1213.isEmpty()) {
            List var8 = new ArrayList<>();

            for (Trails.TrailParticle var10 : this.field1213) {
               float var11 = 1.0F - (float)var10.field1615 / var10.field1539;
               if (!(var11 <= 0.0F)) {
                  float var12 = Math.min(1.0F, var10.field1615 / 3.0F);
                  float var13 = var11 < 0.3F ? var11 / 0.3F : 1.0F;
                  int var14 = Math.max(0, Math.min(255, (int)(var5.getAlpha() * var12 * var13)));
                  int var15 = (var14 & 0xFF) << 24 | var6;
                  float var16 = (float)(class_3532.method_16436(var4, var10.field0956, var10.field0565) - var2.field_1352);
                  float var17 = (float)(class_3532.method_16436(var4, var10.field0757, var10.field0002) - var2.field_1351);
                  float var18 = (float)(class_3532.method_16436(var4, var10.field1241, var10.field1409) - var2.field_1350);
                  float var19 = var10.field1196;
                  switch (var10.field1724) {
                     case field0705:
                        var19 *= 0.6F + 0.4F * var11;
                        break;
                     case field0129:
                        var19 *= var12 * var11;
                        break;
                     case field1498:
                        var19 *= 0.8F + 0.2F * (1.0F - var11);
                        break;
                     case field1022:
                        float var20 = var10.field1615 < var10.field1539 * 0.4F ? var10.field1615 / (var10.field1539 * 0.4F) : var11 / 0.6F;
                        var19 *= var20;
                        break;
                     case field0786:
                        var19 *= 0.5F + 0.5F * var11;
                        break;
                     case field1267:
                        var19 *= 0.7F + 0.3F * (float)Math.sin(var11 * 3.1415936109900606);
                        break;
                     case field0333:
                        var19 *= var11;
                        break;
                     case field0206:
                        var19 *= 0.4F + 0.6F * (float)Math.sin(var11 * 3.1415936109900606);
                        break;
                     case field0484:
                        var19 *= var11 * var11;
                  }

                  float var23 = var10.field1136 + var10.field1087 * var4;
                  float var21 = (float)Math.cos(Math.toRadians(var23));
                  float var22 = (float)Math.sin(Math.toRadians(var23));
                  this.method1563(var3, var8, var10.field1724, var16, var17, var18, var19, var21, var22, var23, var15);
               }
            }

            WorldGeometryRenderer.method1087(var8, var7, true);
         }
      }
   }

   private void method1563(
      Matrix4f var1,
      List<WorldGeometryRenderer.VertexBatch> var2,
      Trails.ParticleType var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      int var11
   ) {
      switch (var3) {
         case field0705:
            var2.add(this.method1556(var1, var4 - var7, var5, var6, var4 + var7, var5, var6, var11));
            var2.add(this.method1556(var1, var4, var5 - var7, var6, var4, var5 + var7, var6, var11));
            var2.add(this.method1556(var1, var4, var5, var6 - var7, var4, var5, var6 + var7, var11));
            float var30 = var7 * 0.55F;
            var2.add(this.method1556(var1, var4 - var30, var5, var6, var4 + var30, var5, var6, var11));
            var2.add(this.method1556(var1, var4, var5 - var30, var6, var4, var5 + var30, var6, var11));
            break;
         case field0129: {
            float var29 = var7 * 0.7F;
            var2.add(this.method1556(var1, var4 - var29 * var8, var5 - var29 * var9, var6, var4 + var29 * var8, var5 + var29 * var9, var6, var11));
            var2.add(this.method1556(var1, var4 + var29 * var9, var5 - var29 * var8, var6, var4 - var29 * var9, var5 + var29 * var8, var6, var11));
            break;
         }
         case field1498:
            float var28 = var7 * 2.0F;
            float var35 = var28 * var8;
            float var40 = var28 * var9 * 0.3F;
            var2.add(this.method1556(var1, var4 - var35, var5 - var40, var6, var4 + var35, var5 + var40, var6, var11));
            break;
         case field1022: {
            float var27 = var7 * 0.7F;
            int var34 = 10;

            for (int var39 = 0; var39 < var34; var39++) {
               float var44 = (float)(6.283186640837165 * var39 / var34);
               float var47 = (float)(6.283186640837165 * (var39 + 1) / var34);
               var2.add(
                  this.method1556(
                     var1,
                     var4 + var27 * (float)Math.cos(var44),
                     var5 + var27 * (float)Math.sin(var44),
                     var6,
                     var4 + var27 * (float)Math.cos(var47),
                     var5 + var27 * (float)Math.sin(var47),
                     var6,
                     var11
                  )
               );
            }
            break;
         }
         case field0786: {
            float var26 = var7 * 0.7F;
            float var33 = (float)Math.toRadians(var10);
            float var38 = var4 + var26 * (float)Math.cos(var33);
            float var43 = var5 + var26 * (float)Math.sin(var33);
            float var46 = var4 + var26 * (float)Math.cos(var33 + 2.094F);
            float var48 = var5 + var26 * (float)Math.sin(var33 + 2.094F);
            float var49 = var4 + var26 * (float)Math.cos(var33 + 4.189F);
            float var50 = var5 + var26 * (float)Math.sin(var33 + 4.189F);
            var2.add(this.method1556(var1, var38, var43, var6, var46, var48, var6, var11));
            var2.add(this.method1556(var1, var46, var48, var6, var49, var50, var6, var11));
            var2.add(this.method1556(var1, var49, var50, var6, var38, var43, var6, var11));
            break;
         }
         case field1267:
            float var25 = var7 * 0.6F;
            float var32 = var7 * 0.4F;
            float var37 = (float)Math.sin(var10 * 0.0800000001783749);
            float var42 = (float)Math.sin(var10 * 0.0800000001783749 + 2.0);
            float var45 = (float)Math.sin(var10 * 0.0800000001783749 + 4.0);
            var2.add(this.method1556(var1, var4 - var25, var5 + var32 * var37, var6, var4, var5 + var32 * var42, var6, var11));
            var2.add(this.method1556(var1, var4, var5 + var32 * var42, var6, var4 + var25, var5 + var32 * var45, var6, var11));
            break;
         case field0333:
            for (int var24 = 0; var24 < 4; var24++) {
               float var31 = (float)Math.toRadians(var10 + var24 * 90);
               float var36 = var4 + var7 * 0.8F * (float)Math.cos(var31);
               float var41 = var5 + var7 * 0.8F * (float)Math.sin(var31);
               var2.add(this.method1556(var1, var4, var5, var6, var36, var41, var6, var11));
            }
            break;
         case field0206:
            float var23 = var7 * 0.9F;
            float var13 = var7 * 0.45F;
            float var14 = (float)Math.toRadians(var10);
            float var15 = var4 + var23 * (float)Math.cos(var14 + 1.5707968931794145);
            float var16 = var5 + var23 * (float)Math.sin(var14 + 1.5707968931794145);
            float var17 = var4 - var23 * (float)Math.cos(var14 + 1.5707968931794145);
            float var18 = var5 - var23 * (float)Math.sin(var14 + 1.5707968931794145);
            float var19 = var4 + var13 * (float)Math.cos(var14);
            float var20 = var5 + var13 * (float)Math.sin(var14);
            float var21 = var4 - var13 * (float)Math.cos(var14);
            float var22 = var5 - var13 * (float)Math.sin(var14);
            var2.add(this.method1556(var1, var15, var16, var6, var19, var20, var6, var11));
            var2.add(this.method1556(var1, var19, var20, var6, var17, var18, var6, var11));
            var2.add(this.method1556(var1, var17, var18, var6, var21, var22, var6, var11));
            var2.add(this.method1556(var1, var21, var22, var6, var15, var16, var6, var11));
            break;
         case field0484: {
            float var12 = var7 * 0.3F;
            var2.add(this.method1556(var1, var4 - var12, var5, var6, var4 + var12, var5, var6, var11));
            var2.add(this.method1556(var1, var4, var5 - var12, var6, var4, var5 + var12, var6, var11));
         }
      }
   }

   private WorldGeometryRenderer.VertexBatch method1556(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {
      return new WorldGeometryRenderer.VertexBatch(
         new WorldGeometryRenderer.ColoredVertex(var1, var2, var3, var4, var8), new WorldGeometryRenderer.ColoredVertex(var1, var5, var6, var7, var8)
      );
   }

   private enum ParticleType {
      field0705,
      field0129,
      field1498,
      field1022,
      field0786,
      field1267,
      field0333,
      field0206,
      field0484;
   }

   private static class TrailParticle {
      double field0565;
      double field0002;
      double field1409;
      double field0956;
      double field0757;
      double field1241;
      double field0313;
      double field0176;
      double field0457;
      int field1615;
      int field1539;
      Trails.ParticleType field1724;
      float field1136;
      float field1087;
      float field1196;

      TrailParticle(
         double var1,
         double var3,
         double var5,
         double var7,
         double var9,
         double var11,
         int var13,
         Trails.ParticleType var14,
         float var15,
         float var16,
         float var17
      ) {
         this.field0565 = var1;
         this.field0002 = var3;
         this.field1409 = var5;
         this.field0956 = var1;
         this.field0757 = var3;
         this.field1241 = var5;
         this.field0313 = var7;
         this.field0176 = var9;
         this.field0457 = var11;
         this.field1615 = 0;
         this.field1539 = var13;
         this.field1724 = var14;
         this.field1136 = var15;
         this.field1087 = var16;
         this.field1196 = var17;
      }
   }

   public enum Mode implements DisplayNamed {
      field0706("Stars"),
      field0130("Harmony");

      private final String field1504;

      Mode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }
}
