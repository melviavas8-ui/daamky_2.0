package aethereal;

import java.util.Optional;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1309;
import net.minecraft.class_1921;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2388;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4608;
import net.minecraft.class_630;
import net.minecraft.class_761;
import net.minecraft.class_7833;
import net.minecraft.class_4597.class_4598;

public class PetCrawler extends Module {
   private final FloatSetting field0060 = new FloatSetting("petcrawler.scale", 1.0F, 0.3F, 2.5F, 0.1F)
      .method1007("Scale")
      .method0210("Pet size")
      .method2130("Размер");
   private final FloatSetting field1450 = new FloatSetting("petcrawler.idleradius", 1.8F, 0.8F, 5.0F, 0.1F)
      .method1007("Idle Radius")
      .method0210("Idle radius")
      .method2130("Радиус покоя");
   private final FloatSetting field0985 = new FloatSetting("petcrawler.followradius", 3.5F, 1.5F, 8.0F, 0.1F)
      .method1007("Follow Radius")
      .method0210("Follow radius")
      .method2130("Дистанция догона");
   private final FloatSetting field0190 = new FloatSetting("petcrawler.walkspeed", 0.18F, 0.05F, 0.6F, 0.01F)
      .method1007("Walk Speed")
      .method0210("Walk speed")
      .method2130("Скорость прогулки");
   private final FloatSetting field0470 = new FloatSetting("petcrawler.maxspeed", 0.6F, 0.2F, 1.5F, 0.05F)
      .method1007("Max Speed")
      .method0210("Sprint cap")
      .method2130("Максимальная скорость");
   private final FloatSetting field1627 = new FloatSetting("petcrawler.teleportdist", 30.0F, 8.0F, 80.0F, 1.0F)
      .method1007("Last-Resort Teleport")
      .method0210("Distance beyond which pet teleports only if stuck for >4s. Pet runs frantically up to this distance.")
      .method2130("Телепорт только если застрял на >4 секунды дальше этой дистанции. До неё бежит как зверь.");
   private final BooleanSetting field1544 = new BooleanSetting("petcrawler.fullbright", false)
      .method1007("Full Bright")
      .method0210("Always lit")
      .method2130("Без затенения");
   private final BooleanSetting field1709 = new BooleanSetting("petcrawler.mouth", true)
      .method1007("Mouth Animation")
      .method0210("Jaw animation")
      .method2130("Анимация челюсти");
   private final BooleanSetting field1141 = new BooleanSetting("petcrawler.blood", true)
      .method1007("Blood Drips")
      .method0210("Idle blood drips")
      .method2130("Кровь из пасти");
   private final FloatSetting field1097 = new FloatSetting("petcrawler.bloodfreq", 14.0F, 4.0F, 60.0F, 1.0F, this.field1141::method0492)
      .method1007("Blood Interval")
      .method0210("Drip interval")
      .method2130("Интервал капель");
   private final BooleanSetting field1201 = new BooleanSetting("petcrawler.dust", true)
      .method1007("Footstep Dust")
      .method0210("Dust on running")
      .method2130("Пыль из-под лап");
   private final BooleanSetting field0875 = new BooleanSetting("petcrawler.combat", true)
      .method1007("Combat")
      .method0210("Cinematic attack on Aura's target")
      .method2130("Кинематографичная атака на цель ауры");
   private final BooleanSetting field0830 = new BooleanSetting("petcrawler.combatsound", true, this.field0875::method0492)
      .method1007("Combat Sound")
      .method0210("Combat SFX")
      .method2130("Звуки атаки");
   private final BooleanSetting field0914 = new BooleanSetting("petcrawler.impact", true, this.field0875::method0492)
      .method1007("Impact Particles")
      .method0210("Heavy blood/dust effects")
      .method2130("Эффекты ударов");
   private final BooleanSetting field1335 = new BooleanSetting("petcrawler.mount", true)
      .method1007("Mount")
      .method0210("Hold right-click on pet to mount on shoulder. Sneak to dismount.")
      .method2130("Зажми ПКМ на питомце чтобы он залез на плечо. Шифт чтобы спрыгнул.");
   private final FloatSetting field1302 = new FloatSetting("petcrawler.mounthold", 14.0F, 4.0F, 40.0F, 1.0F, this.field1335::method0492)
      .method1007("Mount Hold Time")
      .method0210("Right-click hold ticks needed to mount")
      .method2130("Сколько тиков держать ПКМ");
   private static final class_2960 field1387 = class_2960.method_60655("daamky", "textures/entities/crawler.png");
   private PetCrawlerModel field0395;
   private final PetCrawlerEntity.Segment field0361 = new PetCrawlerEntity.Segment();
   private final PetCrawlerEntity field0431 = new PetCrawlerEntity(this.field0361);
   private final PetCrawlerModel.ModelPart field0263 = new PetCrawlerModel.ModelPart();
   private int field0227 = 0;
   private int field0290 = 0;
   private boolean field0538 = false;

   public PetCrawler() {
      super("PetCrawler", ModuleCategory.field1004, "Crawler pet with cinematic combat — pounce, maul, climb, bite");
      this.method1013("Питомец-краулер: набрасывается, терзает, взбирается, вгрызается в шею");
   }

   private void method1735() {
      if (this.field0395 == null) {
         class_630 var1 = PetCrawlerModel.method0576().method_32109();
         this.field0395 = new PetCrawlerModel(var1);
      }
   }

   private void method1691() {
      this.field0361.field0565 = this.field1450.method0492().floatValue();
      this.field0361.field0002 = Math.max(this.field0985.method0492(), this.field1450.method0492() + 0.4F);
      this.field0361.field1409 = this.field0190.method0492().floatValue();
      this.field0361.field0956 = this.field0470.method0492().floatValue();
      this.field0361.field0757 = this.field1627.method0492().floatValue();
   }

   @Override
   public void method0025() {
      super.method0025();
      this.method1735();
      this.field0431.field0938 = false;
      this.field0227 = 0;
      this.field0290 = 0;
      this.field0538 = false;
   }

   @Override
   public void method2078() {
      super.method2078();
      this.field0431.field0938 = false;
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         this.method1691();
         if (!this.field0431.field0938) {
            this.field0431.method1311(field0796.field_1724.method_19538(), field0796.field_1724.method_36454());
         } else {
            class_1309 var2 = null;
            if (this.field0875.method0492() && !this.field0431.field1125) {
               Aura var3 = Aura.method1701();
               if (var3 != null && var3.method2195()) {
                  var2 = var3.method0409();
               }
            }

            this.field0431.field1748 = var2;
            if (this.field1335.method0492()) {
               this.method1754();
            }

            this.field0431.method1542(field0796.field_1724, field0796.field_1687);
            this.method2043();
            this.method0471();
            this.method2015();
         }
      }
   }

   private void method1754() {
      boolean var1 = field0796.field_1690.field_1904.method_1434();
      boolean var2 = field0796.field_1690.field_1832.method_1434();
      boolean var3 = var2 && !this.field0538;
      this.field0538 = var2;
      if (this.field0431.field1125) {
         if (var3) {
            this.field0431.method1541(field0796.field_1724);
            this.field0290 = 0;
         }
      } else {
         if (var1 && this.method2030()) {
            this.field0290++;
            int var4 = (int)Math.max(2.0F, this.field1302.method0492());
            if (this.field0290 >= var4) {
               this.field0431.method2078();
               this.field0290 = 0;
               if (this.field0830.method0492()) {
                  field0796.field_1687
                     .method_43128(
                        null,
                        this.field0431.field0795.field_1352,
                        this.field0431.field0795.field_1351,
                        this.field0431.field0795.field_1350,
                        class_3417.field_15117,
                        class_3419.field_15251,
                        0.5F,
                        1.4F
                     );
               }
            }
         } else {
            this.field0290 = 0;
         }
      }
   }

   private boolean method2030() {
      if (field0796.field_1724 == null) {
         return false;
      }

      class_243 var1 = field0796.field_1724.method_33571();
      class_243 var2 = field0796.field_1724.method_5828(1.0F);
      double var3 = 5.0;
      class_243 var5 = var1.method_1019(var2.method_1021(var3));
      class_238 var6 = this.field0431.method0023().method_1014(0.1500000752625216);
      Optional var7 = var6.method_992(var1, var5);
      return var7.isPresent();
   }

   private void method2015() {
      if (this.field0431.field1367 && this.field0431.field1319) {
         class_2338 var1 = class_2338.method_49637(
            this.field0431.field0795.field_1352, this.field0431.field0795.field_1351 + 0.3000000611529762, this.field0431.field0795.field_1350
         );
         class_2680 var2 = field0796.field_1687.method_8320(var1);
         if (!var2.method_26215()) {
            class_2388 var3 = new class_2388(class_2398.field_11217, var2);

            for (int var4 = 0; var4 < 6; var4++) {
               field0796.field_1687
                  .method_8406(
                     var3,
                     this.field0431.field0795.field_1352 + (this.field0431.field1034.nextDouble() - 0.5) * 0.6000003652647138,
                     this.field0431.field0795.field_1351 + 0.4000000198574819 + this.field0431.field1034.nextDouble() * 0.3000000611529762,
                     this.field0431.field0795.field_1350 + (this.field0431.field1034.nextDouble() - 0.5) * 0.6000003652647138,
                     (this.field0431.field1034.nextDouble() - 0.5) * 0.1500000752625216,
                     0.04999999403976525 + this.field0431.field1034.nextDouble() * 0.10000002255638121,
                     (this.field0431.field1034.nextDouble() - 0.5) * 0.1500000752625216
                  );
            }

            if (this.field0431.field1320 % 10 == 0 && this.field0830.method0492()) {
               field0796.field_1687
                  .method_43128(
                     null,
                     this.field0431.field0795.field_1352,
                     this.field0431.field0795.field_1351,
                     this.field0431.field0795.field_1350,
                     class_3417.field_15211,
                     class_3419.field_15251,
                     0.6F,
                     0.8F + this.field0431.field1034.nextFloat() * 0.4F
                  );
            }
         }
      }
   }

   private void method2043() {
      float var1 = this.field0060.method0492();
      if (this.field1141.method0492() && this.field0431.field1757 == PetCrawlerEntity.MovementState.field0635) {
         if (this.field0227 > 0) {
            this.field0227--;
         } else {
            class_243 var2 = this.field0431.method0473(var1);
            double var3 = var2.field_1352 + (this.field0431.field1034.nextDouble() - 0.5) * 0.0800000001746239 * var1;
            double var5 = var2.field_1351 - 0.04999999403976525 * var1;
            double var7 = var2.field_1350 + (this.field0431.field1034.nextDouble() - 0.5) * 0.0800000001746239 * var1;
            class_2388 var9 = new class_2388(class_2398.field_11217, class_2246.field_10002.method_9564());
            field0796.field_1687.method_8406(var9, var3, var5, var7, 0.0, -0.04999999465984688, 0.0);
            if (this.field0431.field0826 > 0.6F && this.field0431.field1034.nextFloat() < 0.4F) {
               field0796.field_1687
                  .method_8406(
                     class_2398.field_11209,
                     var3,
                     var5,
                     var7,
                     (this.field0431.field1034.nextDouble() - 0.5) * 0.04999999403976525,
                     -0.020000006639505945,
                     (this.field0431.field1034.nextDouble() - 0.5) * 0.04999999403976525
                  );
            }

            int var10 = (int)Math.max(2.0F, this.field1097.method0492());
            this.field0227 = (int)(var10 * (0.6000003652647138 + this.field0431.field1034.nextDouble() * 0.7999999069718797));
         }
      }

      if (this.field1201.method0492() && (this.field0431.field0953 || this.field0431.field1361) && this.field0431.field0946) {
         class_2338 var20 = class_2338.method_49637(
            this.field0431.field0795.field_1352, this.field0431.field0795.field_1351 - 0.04999999403976525, this.field0431.field0795.field_1350
         );
         class_2680 var21 = field0796.field_1687.method_8320(var20);
         if (!var21.method_26215()) {
            double var4 = Math.toRadians(this.field0431.field0177);
            double var6 = Math.cos(var4);
            double var8 = Math.sin(var4);
            double var22 = this.field0431.field0953 ? 1.0 : -1.0;
            double var12 = 0.35000006732172506 * var1 * var22;
            double var14 = this.field0431.field0795.field_1352 + var6 * var12;
            double var16 = this.field0431.field0795.field_1350 + var8 * var12;
            class_2388 var18 = new class_2388(class_2398.field_11217, var21);

            for (int var19 = 0; var19 < 2; var19++) {
               field0796.field_1687
                  .method_8406(
                     var18,
                     var14 + (this.field0431.field1034.nextDouble() - 0.5) * 0.1500000752625216,
                     this.field0431.field0795.field_1351 + 0.04999999403976525,
                     var16 + (this.field0431.field1034.nextDouble() - 0.5) * 0.1500000752625216,
                     (this.field0431.field1034.nextDouble() - 0.5) * 0.04999999403976525,
                     0.02000000849834695 + this.field0431.field1034.nextDouble() * 0.030000000995046933,
                     (this.field0431.field1034.nextDouble() - 0.5) * 0.04999999403976525
                  );
            }
         }
      }
   }

   private void method0471() {
      if (this.field0875.method0492()) {
         float var1 = this.field0060.method0492();
         if (this.field0431.field0903) {
            if (this.field0830.method0492()) {
               this.method1343(this.field0431.field0795, class_3417.field_14733, 0.7F, 1.6F);
            }

            this.method0732(8, 0.25 * var1 + 0.3000000611529762, 0.04999999403976525);
         }

         if (this.field0431.field0897) {
            class_243 var2 = this.field0431.field1773 != null
               ? new class_243(
                  this.field0431.field1773.field_1352,
                  this.field0431.field1773.field_1351 + this.field0431.field1163 * 0.5,
                  this.field0431.field1773.field_1350
               )
               : this.field0431.field0795;
            if (this.field0830.method0492()) {
               this.method1343(var2, class_3417.field_15240, 1.1F, 1.3F);
               this.method1343(var2, class_3417.field_14840, 0.9F, 0.95F);
            }

            if (this.field0914.method0492()) {
               this.method1319(var2, 22, 0.18000001490326473, 0.2800000027989722);
               this.method1318(var2, 6);
               this.method0732(12, 0.4000000198574819 * var1, 0.10000002255638121);
            }
         }

         if (this.field0431.field1757 == PetCrawlerEntity.MovementState.field0322 && this.field0431.field0907) {
            class_243 var10 = this.method0610(0.5500000005608758);
            if (this.field0914.method0492()) {
               this.method1319(var10, 6, 0.10000002255638121, 0.1500000752625216);
               if (this.field0431.field1034.nextFloat() < 0.5F) {
                  this.method1318(var10, 1);
               }
            }

            if (this.field0830.method0492()) {
               float var3 = 0.85F + this.field0431.field1034.nextFloat() * 0.3F;
               this.method1343(var10, class_3417.field_14940, 0.6F, var3);
            }
         }

         if (this.field0431.field1757 == PetCrawlerEntity.MovementState.field0193) {
            if (this.field0914.method0492() && this.field0431.field1034.nextFloat() < 0.6F) {
               class_243 var11 = this.method0610(0.700000244497869);
               this.method1319(var11, 2, 0.0800000001746239, 0.11999997417560893);
            }

            if (this.field0830.method0492() && this.field0431.field1187 == 1) {
               this.method1343(this.field0431.field0795, class_3417.field_14575, 0.7F, 1.4F);
            }
         }

         if (this.field0431.field0860) {
            class_243 var12 = this.method0610(0.8500002982678782);
            if (this.field0830.method0492()) {
               this.method1343(var12, class_3417.field_14733, 1.2F, 1.4F);
               this.method1343(var12, class_3417.field_15016, 1.0F, 0.9F);
            }

            if (this.field0914.method0492()) {
               this.method1319(var12, 16, 0.2000000059628803, 0.3000000611529762);
               this.method1318(var12, 4);
            }
         }

         if (this.field0431.field1757 == PetCrawlerEntity.MovementState.field0473) {
            class_243 var13 = this.method0610(0.8500002982678782);
            if (this.field0914.method0492()) {
               class_2388 var14 = new class_2388(class_2398.field_11217, class_2246.field_10002.method_9564());
               int var4 = 4 + this.field0431.field1034.nextInt(3);

               for (int var5 = 0; var5 < var4; var5++) {
                  double var6 = this.field0431.field1034.nextDouble() * 3.1415934291489016 * 2.0;
                  double var8 = 0.10000002255638121 + this.field0431.field1034.nextDouble() * 0.2000000059628803;
                  field0796.field_1687
                     .method_8406(
                        var14,
                        var13.field_1352 + Math.cos(var6) * var8,
                        var13.field_1351 + (this.field0431.field1034.nextDouble() - 0.4000000198574819) * 0.3000000611529762,
                        var13.field_1350 + Math.sin(var6) * var8,
                        (this.field0431.field1034.nextDouble() - 0.5) * 0.25,
                        0.030000000995046933 + this.field0431.field1034.nextDouble() * 0.1500000752625216,
                        (this.field0431.field1034.nextDouble() - 0.5) * 0.25
                     );
               }

               if (this.field0431.field1034.nextFloat() < 0.4F) {
                  field0796.field_1687
                     .method_8406(
                        class_2398.field_11209,
                        var13.field_1352 + (this.field0431.field1034.nextDouble() - 0.5) * 0.3000000611529762,
                        var13.field_1351 + this.field0431.field1034.nextDouble() * 0.2000000059628803,
                        var13.field_1350 + (this.field0431.field1034.nextDouble() - 0.5) * 0.3000000611529762,
                        (this.field0431.field1034.nextDouble() - 0.5) * 0.1500000752625216,
                        0.04999999403976525 + this.field0431.field1034.nextDouble() * 0.10000002255638121,
                        (this.field0431.field1034.nextDouble() - 0.5) * 0.1500000752625216
                     );
               }
            }

            if (this.field0830.method0492() && this.field0431.field1187 % 6 == 3) {
               float var15 = 0.7F + this.field0431.field1034.nextFloat() * 0.4F;
               this.method1343(var13, (class_3414)class_3417.field_20614.comp_349(), 0.8F, var15);
               if (this.field0431.field1034.nextFloat() < 0.3F) {
                  this.method1343(var13, class_3417.field_15115, 0.6F, 0.9F + this.field0431.field1034.nextFloat() * 0.3F);
               }
            }
         }
      }
   }

   private class_243 method0610(double var1) {
      class_243 var3 = this.field0431.field1773 != null ? this.field0431.field1773 : this.field0431.field0795;
      double var4 = this.field0431.field1163;
      double var6 = Math.toRadians(this.field0431.field1174);
      double var8 = -Math.sin(var6);
      double var10 = Math.cos(var6);
      return new class_243(var3.field_1352 - var8 * 0.1500000752625216, var3.field_1351 + var4 * var1, var3.field_1350 - var10 * 0.1500000752625216);
   }

   private void method1319(class_243 var1, int var2, double var3, double var5) {
      class_2388 var7 = new class_2388(class_2398.field_11217, class_2246.field_10002.method_9564());

      for (int var8 = 0; var8 < var2; var8++) {
         double var9 = this.field0431.field1034.nextDouble() * 3.1415934291489016 * 2.0;
         double var11 = var3 * (0.5 + this.field0431.field1034.nextDouble());
         double var13 = this.field0431.field1034.nextDouble() * var5 + 0.04999999403976525;
         field0796.field_1687.method_8406(var7, var1.field_1352, var1.field_1351, var1.field_1350, Math.cos(var9) * var11, var13, Math.sin(var9) * var11);
      }
   }

   private void method1318(class_243 var1, int var2) {
      for (int var3 = 0; var3 < var2; var3++) {
         field0796.field_1687
            .method_8406(
               class_2398.field_11209,
               var1.field_1352 + (this.field0431.field1034.nextDouble() - 0.5) * 0.4000000198574819,
               var1.field_1351 + (this.field0431.field1034.nextDouble() - 0.5) * 0.3000000611529762,
               var1.field_1350 + (this.field0431.field1034.nextDouble() - 0.5) * 0.4000000198574819,
               (this.field0431.field1034.nextDouble() - 0.5) * 0.2000000059628803,
               0.04999999403976525 + this.field0431.field1034.nextDouble() * 0.1500000752625216,
               (this.field0431.field1034.nextDouble() - 0.5) * 0.2000000059628803
            );
      }
   }

   private void method0732(int var1, double var2, double var4) {
      class_2338 var6 = class_2338.method_49637(
         this.field0431.field0795.field_1352, this.field0431.field0795.field_1351 - 0.04999999403976525, this.field0431.field0795.field_1350
      );
      class_2680 var7 = field0796.field_1687.method_8320(var6);
      if (!var7.method_26215()) {
         class_2388 var8 = new class_2388(class_2398.field_11217, var7);

         for (int var9 = 0; var9 < var1; var9++) {
            double var10 = this.field0431.field1034.nextDouble() * 3.1415934291489016 * 2.0;
            double var12 = var2 * (0.5 + this.field0431.field1034.nextDouble());
            field0796.field_1687
               .method_8406(
                  var8,
                  this.field0431.field0795.field_1352 + Math.cos(var10) * var12,
                  this.field0431.field0795.field_1351 + 0.04999999403976525,
                  this.field0431.field0795.field_1350 + Math.sin(var10) * var12,
                  Math.cos(var10) * 0.10000002255638121,
                  var4 + this.field0431.field1034.nextDouble() * 0.04999999403976525,
                  Math.sin(var10) * 0.10000002255638121
               );
         }
      }
   }

   private void method1343(class_243 var1, class_3414 var2, float var3, float var4) {
      field0796.field_1687.method_43128(null, var1.field_1352, var1.field_1351, var1.field_1350, var2, class_3419.field_15251, var3, var4);
   }

   @EventHandler
   public void onRenderWorld(GlowRenderEvent var1) {
      if (!method1974() && this.field0431.field0938 && this.field0395 != null) {
         if (!this.field0431.field1125 || !field0796.field_1690.method_31044().method_31034()) {
            float var2 = var1.method1603();
            class_243 var3 = field0796.field_1773.method_19418().method_19326();
            class_243 var4 = this.field0431.method0664(var2);
            this.field0263.field0566 = this.field0431.method0377(var2);
            this.field0263.field0003 = this.field0431.method0500(var2);
            this.field0263.field1410 = this.field0431.method2231(var2);
            this.field0263.field0957 = this.field0431.method2196(var2);
            this.field0263.field0758 = this.field0431.method2268(var2);
            this.field0263.field1242 = this.field0431.method1917(var2);
            this.field0263.field0314 = this.field0431.method1892(var2);
            this.field0263.field0177 = this.field0431.method1939(var2);
            this.field0263.field0458 = this.field0431.method1737(var2);
            this.field0263.field1614 = this.field0431.method2031(var2);
            this.field0263.field1538 = this.field0431.method2017(var2);
            this.field0263.field1704 = this.field0431.method2045(var2);
            double var5 = -0.1199999703056912 * this.field0263.field0566 + this.field0431.method1756(var2);
            double var7 = var4.field_1352 - var3.field_1352;
            double var9 = var4.field_1351 - var3.field_1351 + var5;
            double var11 = var4.field_1350 - var3.field_1350;
            float var13 = this.field0431.method0115(var2);
            float var14 = this.field0431.method1636(var2);
            float var15 = this.field0431.method2092(var2);
            float var16 = this.field0431.method1817(var2);
            float var17 = this.field1709.method0492() ? this.field0431.method1975(var2) : 0.0F;
            float var18 = this.field0431.method0433(var2);
            class_4587 var19 = var1.method1808();
            var19.method_22903();
            var19.method_22904(var7, var9, var11);
            float var20 = this.field0060.method0492();
            var19.method_22905(var20, var20, var20);
            var19.method_22907(class_7833.field_40716.rotationDegrees(180.0F - var13));
            var19.method_22905(-1.0F, -1.0F, 1.0F);
            var19.method_46416(0.0F, -1.501F, 0.0F);
            this.field0395.method0692(this.field0431.field1087, var14, var15, var16, var17, var18, this.field0263);
            class_4598 var21 = field0796.method_22940().method_23000();
            class_4588 var22 = var21.getBuffer(class_1921.method_23578(field1387));
            int var23;
            if (this.field1544.method0492()) {
               var23 = 15728880;
            } else {
               class_2338 var24 = class_2338.method_49637(var4.field_1352, var4.field_1351 + 0.5, var4.field_1350);
               var23 = class_761.method_23794(field0796.field_1687, var24);
            }

            this.field0395.method1514(var19, var22, var23, class_4608.field_21444, -1);
            var19.method_22909();
            var21.method_22993();
         }
      }
   }
}
