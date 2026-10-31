package aethereal;

import it.unimi.dsi.fastutil.objects.Object2DoubleArrayMap;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import net.minecraft.class_10185;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1320;
import net.minecraft.class_1657;
import net.minecraft.class_1690;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2399;
import net.minecraft.class_243;
import net.minecraft.class_2533;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3481;
import net.minecraft.class_3486;
import net.minecraft.class_3532;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.class_5134;
import net.minecraft.class_5635;
import net.minecraft.class_6862;
import net.minecraft.class_6880;
import net.minecraft.class_744;
import net.minecraft.class_746;
import net.minecraft.class_2338.class_2339;

public class SimulatedPlayerInput implements MinecraftAccess, InputVectorProvider {
   public final class_1657 field0732;
   public final SimulatedPlayerInput.KeyboardInput field0044;
   public class_243 field1521;
   public class_243 field1043;
   public class_238 field0214;
   public float field0458;
   public float field1614;
   public boolean field1574;
   public float field1704;
   public int field1137;
   public boolean field1109;
   public boolean field1218;
   public boolean field0890;
   public boolean field0845;
   public boolean field0931;
   public boolean field1350;
   public boolean field1312;
   public boolean field1388;
   private final Object2DoubleMap<class_6862<class_3611>> field0398;
   private final HashSet<class_6862<class_3611>> field0365;
   private int field0424 = 0;
   private boolean field0273 = false;
   private static final double field0225 = 0.5;

   public SimulatedPlayerInput(
      class_1657 var1,
      SimulatedPlayerInput.KeyboardInput var2,
      class_243 var3,
      class_243 var4,
      class_238 var5,
      float var6,
      float var7,
      boolean var8,
      float var9,
      int var10,
      boolean var11,
      boolean var12,
      boolean var13,
      boolean var14,
      boolean var15,
      boolean var16,
      boolean var17,
      boolean var18,
      Object2DoubleMap<class_6862<class_3611>> var19,
      HashSet<class_6862<class_3611>> var20
   ) {
      this.field0732 = var1;
      this.field0044 = var2;
      this.field1521 = var3;
      this.field1043 = var4;
      this.field0214 = var5;
      this.field0458 = var6;
      this.field1614 = var7;
      this.field1574 = var8;
      this.field1704 = var9;
      this.field1137 = var10;
      this.field1109 = var11;
      this.field1218 = var12;
      this.field0890 = var13;
      this.field0845 = var14;
      this.field0931 = var15;
      this.field1350 = var16;
      this.field1312 = var17;
      this.field1388 = var18;
      this.field0398 = var19;
      this.field0365 = var20;
   }

   public static SimulatedPlayerInput method0717(int var0) {
      SimulatedPlayerInput var1 = method0804(SimulatedPlayerInput.KeyboardInput.method1113(field0796.field_1724.field_3913.field_54155));

      for (int var2 = 0; var2 < var0; var2++) {
         var1.method0025();
      }

      return var1;
   }

   public static SimulatedPlayerInput method1192(class_1657 var0, int var1) {
      SimulatedPlayerInput var2 = method1194(var0, SimulatedPlayerInput.KeyboardInput.method1179(var0));

      for (int var3 = 0; var3 < var1; var3++) {
         var2.method0025();
      }

      return var2;
   }

   public static SimulatedPlayerInput method0804(SimulatedPlayerInput.KeyboardInput var0) {
      class_746 var1 = field0796.field_1724;
      return new SimulatedPlayerInput(
         var1,
         var0,
         var1.method_19538(),
         var1.method_18798(),
         var1.method_5829(),
         var1.method_36454(),
         var1.method_36455(),
         var1.method_5624(),
         var1.field_6017,
         var1.field_6228,
         var1.field_6282,
         var1.method_6128(),
         var1.method_24828(),
         var1.field_5976,
         var1.field_5992,
         var1.method_5799(),
         var1.method_5681(),
         var1.method_5869(),
         new Object2DoubleArrayMap(var1.field_5964),
         new HashSet<>(var1.field_25599)
      );
   }

   public static SimulatedPlayerInput method1194(class_1657 var0, SimulatedPlayerInput.KeyboardInput var1) {
      return new SimulatedPlayerInput(
         var0,
         var1,
         var0.method_19538(),
         var0.method_19538().method_1020(new class_243(var0.field_6014, var0.field_6036, var0.field_5969)),
         var0.method_5829(),
         var0.method_36454(),
         var0.method_36455(),
         var0.method_5624(),
         var0.field_6017,
         var0.field_6228,
         var0.field_6282,
         var0.method_6128(),
         var0.method_24828(),
         var0.field_5976,
         var0.field_5992,
         var0.method_5799(),
         var0.method_5681(),
         var0.method_5869(),
         new Object2DoubleArrayMap(var0.field_5964),
         new HashSet<>(var0.field_25599)
      );
   }

   @Override
   public class_243 method0569() {
      return this.field0732.method_19538();
   }

   @Override
   public void method0025() {
      this.field0424++;
      this.field0273 = false;
      if (!(this.field1521.field_1351 <= -70.0)) {
         this.field0044.method0578();
         this.method2029();
         this.method2043();
         this.method2015();
         if (this.field1137 > 0) {
            this.field1137--;
         }

         this.field1109 = this.field0044.field1038.comp_3163();
         double var1 = this.field1043.field_1352;
         double var3 = this.field1043.field_1351;
         double var5 = this.field1043.field_1350;
         if (Math.abs(this.field1043.field_1352) < 0.0029999991268853153) {
            var1 = 0.0;
         }

         if (Math.abs(this.field1043.field_1351) < 0.0029999991268853153) {
            var3 = 0.0;
         }

         if (Math.abs(this.field1043.field_1350) < 0.0029999991268853153) {
            var5 = 0.0;
         }

         if (this.field0890) {
            this.field1218 = false;
         }

         this.field1043 = new class_243(var1, var3, var5);
         if (this.field1109) {
            double var7 = this.method1974() ? this.method0338(class_3486.field_15518) : this.method0338(class_3486.field_15517);
            boolean var9 = this.method1755() && var7 > 0.0;
            double var10 = this.method1678();
            if (!var9 || this.field0890 && !(var7 > var10)) {
               if (!this.method1974() || this.field0890 && !(var7 > var10)) {
                  if ((this.field0890 || var9 && var7 <= var10) && this.field1137 == 0) {
                     this.method2078();
                     if (this.field0732.equals(field0796.field_1724)
                        && (!NoDelay.method1714().method1635() || !NoDelay.method1714().field0089.method0387("Jump"))) {
                        this.field1137 = 10;
                     }
                  }
               } else {
                  this.method1527(class_3486.field_15518);
               }
            } else {
               this.method1527(class_3486.field_15517);
            }
         }

         float var12 = this.field0044.field1410 * 0.98F;
         float var8 = this.field0044.field0003 * 0.98F;
         float var13 = 0.0F;
         if (this.method1531(class_1294.field_5906) || this.method1531(class_1294.field_5902)) {
            this.method2194();
         }

         this.method0288(new class_243(var12, var13, var8));
      }
   }

   private void method0288(class_243 var1) {
      if (this.field1312 && !this.field0732.method_5765()) {
         double var2 = this.method0478().field_1351;
         double var4 = var2 < -0.19999997815235143 ? 0.08500001693865673 : 0.05999997579028321;
         class_2338 var6 = new class_2338(
            class_3532.method_15357(this.field1521.field_1352),
            class_3532.method_15357(this.field1521.field_1351 + 1.0 - 0.10000001823565788),
            class_3532.method_15357(this.field1521.field_1350)
         );
         if (var2 <= 0.0 || this.field0044.field1038.comp_3163() || !this.field0732.method_37908().method_8320(var6).method_26227().method_15769()) {
            this.field1043 = this.field1043.method_1031(0.0, (var2 - this.field1043.field_1351) * var4, 0.0);
         }
      }

      double var19 = this.field1043.field_1351;
      double var20 = 0.0800000114235772;
      boolean var21 = this.field1043.field_1351 <= 0.0;
      if (this.field1043.field_1351 <= 0.0 && this.method1531(class_1294.field_5906)) {
         var20 = 0.01000000048794437;
         this.method2194();
      }

      if (this.method1755() && this.field0732.method_29920()) {
         double var25 = this.field1521.field_1351;
         float var28 = this.method2267() ? 0.9F : 0.8F;
         float var30 = 0.02F;
         float var32 = (float)this.method0339(class_5134.field_51578);
         if (!this.field0890) {
            var32 *= 0.5F;
         }

         if (var32 > 0.0F) {
            var28 += (0.54600006F - var28) * var32 / 3.0F;
            var30 += (this.method2213() - var30) * var32 / 3.0F;
         }

         if (this.method1531(class_1294.field_5900)) {
            var28 = 0.96F;
         }

         this.method0710(var30, var1);
         this.method2163(this.field1043);
         class_243 var33 = this.field1043;
         if (this.field0845 && this.method1813()) {
            var33 = new class_243(var33.field_1352, 0.20000000000419266, var33.field_1350);
         }

         this.field1043 = var33.method_18805(var28, 0.8000000099030629, var28);
         class_243 var34 = this.field0732.method_26317(var20, var21, this.field1043);
         this.field1043 = var34;
         if (this.field0845 && this.method0620(var34.field_1352, var34.field_1351 + 0.6000000670561955 - this.field1521.field_1351 + var25, var34.field_1350)) {
            this.field1043 = new class_243(var34.field_1352, 0.30000003135304115, var34.field_1350);
         }
      } else if (this.method1974() && this.field0732.method_29920()) {
         double var24 = this.field1521.field_1351;
         this.method0710(0.02F, var1);
         this.method2163(this.field1043);
         if (this.method0338(class_3486.field_15518) <= this.method1678()) {
            this.field1043 = this.field1043.method_18805(0.5, 0.8000000099030629, 0.5);
            this.field1043 = this.field0732.method_26317(var20, var21, this.field1043);
         } else {
            this.field1043 = this.field1043.method_1021(0.5);
         }

         if (!this.field0732.method_5740()) {
            this.field1043 = this.field1043.method_1031(0.0, -var20 / 4.0, 0.0);
         }

         if (this.field0845
            && this.method0620(
               this.field1043.field_1352, this.field1043.field_1351 + 0.6000000670561955 - this.field1521.field_1351 + var24, this.field1043.field_1350
            )) {
            this.field1043 = new class_243(this.field1043.field_1352, 0.30000003135304115, this.field1043.field_1350);
         }
      } else if (this.field1218) {
         class_243 var9 = this.field1043;
         if (var9.field_1351 > -0.5) {
            this.field1704 = 1.0F;
         }

         class_243 var10 = this.method0478();
         float var11 = this.field1614 * (float) (Math.PI / 180.0);
         double var12 = Math.sqrt(var10.field_1352 * var10.field_1352 + var10.field_1350 * var10.field_1350);
         double var14 = this.field1043.method_37267();
         double var16 = var10.method_1033();
         float var18 = class_3532.method_15362(var11);
         var18 = (float)(var18 * (var18 * Math.min(1.0, var16 / 0.4000000345208531)));
         var9 = this.field1043.method_1031(0.0, var20 * (-1.0 + var18 * 0.75), 0.0);
         if (var9.field_1351 < 0.0 && var12 > 0.0) {
            double var7 = var9.field_1351 * -0.10000000396274325 * var18;
            var9 = var9.method_1031(var10.field_1352 * var7 / var12, var7, var10.field_1350 * var7 / var12);
         }

         if (var11 < 0.0F && var12 > 0.0) {
            double var22 = var14 * -class_3532.method_15374(var11) * 0.040000016838344525;
            var9 = var9.method_1031(-var10.field_1352 * var22 / var12, var22 * 3.200000134168893, -var10.field_1350 * var22 / var12);
         }

         if (var12 > 0.0) {
            var9 = var9.method_1031(
               (var10.field_1352 / var12 * var14 - var9.field_1352) * 0.10000001823565788,
               0.0,
               (var10.field_1350 / var12 * var14 - var9.field_1350) * 0.10000001823565788
            );
         }

         this.field1043 = var9.method_18805(0.990000123866386, 0.9799995615426513, 0.990000123866386);
         this.method2163(this.field1043);
      } else {
         class_2338 var23 = this.method1732();
         float var8 = this.field0732.method_37908().method_8320(var23).method_26204().method_9499();
         float var27 = this.field0890 ? var8 * 0.91F : 0.91F;
         class_243 var29 = this.method1310(var1, var8);
         double var31 = var29.field_1351;
         if (this.method1531(class_1294.field_5902)) {
            class_1293 var13 = this.method2174(class_1294.field_5902);
            if (var13 != null) {
               var31 += (0.05000000009680665 * (var13.method_5578() + 1) - var29.field_1351) * 0.20000000000419266;
            }
         } else if (this.field0732.method_37908().method_8608() && !this.field0732.method_37908().method_22340(var23)) {
            var31 = this.field1521.field_1351 > this.field0732.method_37908().method_31607() ? -0.10000000396274325 : 0.0;
         } else if (!this.field0732.method_5740()) {
            var31 -= var20;
         }

         if (this.field0732.method_35053()) {
            this.field1043 = new class_243(var29.field_1352, var31, var29.field_1350);
         } else {
            this.field1043 = new class_243(var29.field_1352 * var27, var31 * 0.98F, var29.field_1350 * var27);
         }
      }

      if (this.field0732.method_31549().field_7479 && !this.field0732.method_5765()) {
         this.field1043 = new class_243(this.field1043.field_1352, var19 * 0.6000000670561955, this.field1043.field_1350);
         this.method2194();
      }
   }

   private class_243 method1310(class_243 var1, float var2) {
      this.method0710(this.method0645(var2), var1);
      this.field1043 = this.method1668(this.field1043);
      this.method2163(this.field1043);
      class_243 var3 = this.field1043;
      class_2338 var4 = this.method1297(this.field1521);
      class_2680 var5 = this.method1262(var4);
      if ((this.field0845 || this.field1109)
         && (this.method1813() || var5 != null && var5.method_27852(class_2246.field_27879) && class_5635.method_32355(this.field0732))) {
         var3 = new class_243(var3.field_1352, 0.20000000000419266, var3.field_1350);
      }

      return var3;
   }

   private void method0710(float var1, class_243 var2) {
      class_243 var3 = class_1297.method_18795(var2, var1, this.field0458);
      this.field1043 = this.field1043.method_1019(var3);
   }

   private float method0645(float var1) {
      return this.field0890 ? this.method2213() * (0.21600002F / (var1 * var1 * var1)) : this.method0483();
   }

   private float method0483() {
      float var1 = 0.02F;
      return this.field0044.field1038.comp_3165() ? var1 + 0.006F : var1;
   }

   private float method2213() {
      return 0.1F;
   }

   private void method2163(class_243 var1) {
      class_243 var2 = var1;
      var2 = this.method1995(var2);
      class_243 var3 = this.method1865(var2);
      if (var3.method_1027() > 1.0000000366948902E-7) {
         this.field1521 = this.field1521.method_1019(var3);
         this.field0214 = this.field0732.field_18065.method_30757(this.field1521);
      }

      boolean var4 = !class_3532.method_20390(var1.field_1352, var3.field_1352);
      boolean var5 = !class_3532.method_20390(var1.field_1350, var3.field_1350);
      this.field0845 = var4 || var5;
      this.field0931 = var1.field_1351 != var3.field_1351;
      this.field0890 = this.field0931 && var1.field_1351 < 0.0;
      if (!this.method1755()) {
         this.method2029();
      }

      if (this.field0890) {
         this.method2194();
      } else if (var1.field_1351 < 0.0) {
         this.field1704 = this.field1704 - (float)var1.field_1351;
      }

      class_243 var6 = this.field1043;
      if (this.field0845 || this.field0931) {
         this.field1043 = new class_243(var4 ? 0.0 : var6.field_1352, this.field0890 ? 0.0 : var6.field_1351, var5 ? 0.0 : var6.field_1350);
      }
   }

   private class_243 method1865(class_243 var1) {
      class_238 var2 = new class_238(-0.3000000019563894, 0.0, -0.3000000019563894, 0.30000003135304115, 1.7999995251564769, 0.30000003135304115)
         .method_997(this.field1521);
      List var3 = Collections.emptyList();
      class_243 var4;
      if (var1.method_1027() == 0.0) {
         var4 = var1;
      } else {
         var4 = class_1297.method_20736(this.field0732, var1, var2, this.field0732.method_37908(), var3);
      }

      boolean var5 = var1.field_1352 != var4.field_1352;
      boolean var6 = var1.field_1351 != var4.field_1351;
      boolean var7 = var1.field_1350 != var4.field_1350;
      boolean var8 = this.field0890 || var6 && var1.field_1351 < 0.0;
      if (this.field0732.method_49476() > 0.0F && var8 && (var5 || var7)) {
         class_243 var9 = class_1297.method_20736(
            this.field0732, new class_243(var1.field_1352, this.field0732.method_49476(), var1.field_1350), var2, this.field0732.method_37908(), var3
         );
         class_243 var10 = class_1297.method_20736(
            this.field0732,
            new class_243(0.0, this.field0732.method_49476(), 0.0),
            var2.method_1012(var1.field_1352, 0.0, var1.field_1350),
            this.field0732.method_37908(),
            var3
         );
         class_243 var11 = class_1297.method_20736(
               this.field0732, new class_243(var1.field_1352, 0.0, var1.field_1350), var2.method_997(var10), this.field0732.method_37908(), var3
            )
            .method_1019(var10);
         if (var10.field_1351 < this.field0732.method_49476() && var11.method_37268() > var9.method_37268()) {
            var9 = var11;
         }

         if (var9.method_37268() > var4.method_37268()) {
            return var9.method_1019(
               class_1297.method_20736(
                  this.field0732, new class_243(0.0, -var9.field_1351 + var1.field_1351, 0.0), var2.method_997(var9), this.field0732.method_37908(), var3
               )
            );
         }
      }

      return var4;
   }

   private void method2194() {
      this.field1704 = 0.0F;
   }

   public void method2078() {
      this.field1043 = this.field1043.method_1031(0.0, this.method1901() - this.field1043.field_1351, 0.0);
      if (this.method2267()) {
         float var1 = (float)Math.toRadians(this.field0458);
         this.field1043 = this.field1043
            .method_1031(-class_3532.method_15374(var1) * 0.20000000000419266, 0.0, class_3532.method_15362(var1) * 0.20000000000419266);
      }
   }

   private class_243 method1668(class_243 var1) {
      if (!this.method1813()) {
         return var1;
      }

      this.method2194();
      double var2 = class_3532.method_15350(var1.field_1352, -0.15000007F, 0.15F);
      double var4 = class_3532.method_15350(var1.field_1350, -0.15000007F, 0.15F);
      double var6 = Math.max(var1.field_1351, -0.15000007F);
      if (var6 < 0.0 && !this.method1262(this.method1297(this.field1521)).method_27852(class_2246.field_16492) && this.field0732.method_21754()) {
         var6 = 0.0;
      }

      return new class_243(var2, var6, var4);
   }

   public boolean method1813() {
      class_2338 var1 = this.method1297(this.field1521);
      class_2680 var2 = this.method1262(var1);
      return var2.method_26164(class_3481.field_22414) ? true : var2.method_26204() instanceof class_2533 && this.method1277(var1, var2);
   }

   private boolean method1277(class_2338 var1, class_2680 var2) {
      if (!(Boolean)var2.method_11654(class_2533.field_11631)) {
         return false;
      }

      class_2680 var3 = this.field0732.method_37908().method_8320(var1.method_10074());
      return var3.method_27852(class_2246.field_9983)
         && ((class_2350)var3.method_11654(class_2399.field_11253)).equals(var2.method_11654(class_2533.field_11177));
   }

   private class_243 method1995(class_243 var1) {
      if (var1.field_1351 <= 0.0 && this.method_30263()) {
         double var2 = var1.field_1352;
         double var4 = var1.field_1350;

         double var6;
         for (var6 = 0.05000000009680665;
            var2 != 0.0 && this.field0732.method_37908().method_8587(this.field0732, this.field0214.method_989(var2, -0.5, 0.0));
            var2 += var2 > 0.0 ? -var6 : var6
         ) {
            if (var2 < var6 && var2 >= -var6) {
               var2 = 0.0;
               break;
            }
         }

         while (var4 != 0.0 && this.field0732.method_37908().method_8587(this.field0732, this.field0214.method_989(0.0, -0.5, var4))) {
            if (var4 < var6 && var4 >= -var6) {
               var4 = 0.0;
               break;
            }

            var4 += var4 > 0.0 ? -var6 : var6;
         }

         while (var2 != 0.0 && var4 != 0.0 && this.field0732.method_37908().method_8587(this.field0732, this.field0214.method_989(var2, -0.5, var4))) {
            var2 = var2 < var6 && var2 >= -var6 ? 0.0 : (var2 > 0.0 ? var2 - var6 : var2 + var6);
            if (var4 < var6 && var4 >= -var6) {
               var4 = 0.0;
               break;
            }

            var4 += var4 > 0.0 ? -var6 : var6;
         }

         if (var1.field_1352 != var2 || var1.field_1350 != var4) {
            this.field0273 = true;
         }

         if (this.method1635()) {
            var1 = new class_243(var2, var1.field_1351, var4);
         }
      }

      return var1;
   }

   protected boolean method1635() {
      return this.field0044.field1038.comp_3164() || this.field0044.field0751;
   }

   private boolean method_30263() {
      return this.field0890
         || this.field1704 < 0.5 && !this.field0732.method_37908().method_8587(this.field0732, this.field0214.method_989(0.0, this.field1704 - 0.5, 0.0));
   }

   private boolean method2267() {
      return this.field1574;
   }

   private float method1901() {
      return 0.42F * this.method1928() + this.method1878();
   }

   private float method1878() {
      if (this.method1531(class_1294.field_5913)) {
         class_1293 var1 = this.method2174(class_1294.field_5913);
         return 0.1F * (var1.method_5578() + 1);
      } else {
         return 0.0F;
      }
   }

   private float method1928() {
      float var1 = 0.0F;
      class_2248 var2 = this.method1262(this.method1297(this.field1521)).method_26204();
      if (var2 != null) {
         var1 = var2.method_23350();
      }

      float var3 = 0.0F;
      class_2248 var4 = this.method1262(this.method1732()).method_26204();
      if (var4 != null) {
         var3 = var4.method_23350();
      }

      return var1 == 1.0F ? var3 : var1;
   }

   private boolean method0620(double var1, double var3, double var5) {
      return this.method1284(this.field0214.method_989(var1, var3, var5));
   }

   private boolean method1284(class_238 var1) {
      return this.field0732.method_37908().method_8587(this.field0732, var1) && !this.field0732.method_37908().method_22345(var1);
   }

   private void method1527(class_6862<class_3611> var1) {
      this.field1043 = this.field1043.method_1031(0.0, 0.04F, 0.0);
   }

   private class_2338 method1732() {
      return class_2338.method_49637(this.field1521.field_1352, this.field0214.field_1322 - 0.5000004674147634, this.field1521.field_1350);
   }

   private double method1678() {
      return this.field0732.method_5751() < 0.4000000345208531 ? 0.0 : 0.4000000345208531;
   }

   private boolean method1755() {
      return this.field1350;
   }

   public boolean method1974() {
      return this.field0398.getDouble(class_3486.field_15518) > 0.0;
   }

   private void method2029() {
      if (this.field0732.method_5854() instanceof class_1690) {
         class_1690 var1 = (class_1690)this.field0732.method_5854();
         if (!var1.method_5869()) {
            this.field1350 = false;
            return;
         }
      }

      if (this.method1528(class_3486.field_15517, 0.01400000507340886)) {
         this.method2194();
         this.field1350 = true;
      } else {
         this.field1350 = false;
      }
   }

   private void method2015() {
      if (this.field1312) {
         this.field1312 = this.method2267() && this.method1755() && !this.field0732.method_5765();
      } else {
         this.field1312 = this.method2267()
            && this.method0431()
            && !this.field0732.method_5765()
            && this.field0732.method_37908().method_8316(this.method1297(this.field1521)).method_15767(class_3486.field_15517);
      }
   }

   private void method2043() {
      this.field1388 = this.field0365.contains(class_3486.field_15517);
      this.field0365.clear();
      double var1 = this.method0460() - 0.11111111F;
      if (!(
         this.field0732.method_5854() instanceof class_1690 var4
            && !var4.method_5869()
            && var4.method_5829().field_1325 >= var1
            && var4.method_5829().field_1322 <= var1
      )) {
         class_2338 var8 = class_2338.method_49637(this.field1521.field_1352, var1, this.field1521.field_1350);
         class_3610 var5 = this.field0732.method_37908().method_8316(var8);
         double var6 = var8.method_10264() + var5.method_15763(this.field0732.method_37908(), var8);
         if (var6 > var1) {
            this.field0365.addAll(var5.method_40181().toList());
         }
      }
   }

   private double method0460() {
      return this.field1521.field_1351 + this.field0732.method_5751();
   }

   public boolean method0431() {
      return this.field1388 && this.method1755();
   }

   private double method0338(class_6862<class_3611> var1) {
      return this.field0398.getDouble(var1);
   }

   private boolean method1528(class_6862<class_3611> var1, double var2) {
      if (this.method0458()) {
         return false;
      }

      class_238 var4 = this.field0214.method_1011(0.0010000000076880794);
      int var5 = class_3532.method_15357(var4.field_1323);
      int var6 = class_3532.method_15384(var4.field_1320);
      int var7 = class_3532.method_15357(var4.field_1322);
      int var8 = class_3532.method_15384(var4.field_1325);
      int var9 = class_3532.method_15357(var4.field_1321);
      int var10 = class_3532.method_15384(var4.field_1324);
      double var11 = 0.0;
      boolean var13 = true;
      boolean var14 = false;
      class_243 var15 = class_243.field_1353;
      int var16 = 0;
      class_2339 var17 = new class_2339();

      for (int var18 = var5; var18 < var6; var18++) {
         for (int var19 = var7; var19 < var8; var19++) {
            for (int var20 = var9; var20 < var10; var20++) {
               var17.method_10103(var18, var19, var20);
               class_3610 var21 = this.field0732.method_37908().method_8316(var17);
               if (var21.method_15767(var1)) {
                  double var22 = var19 + var21.method_15763(this.field0732.method_37908(), var17);
                  if (var22 >= var4.field_1322) {
                     var14 = true;
                     var11 = Math.max(var22 - var4.field_1322, var11);
                     if (var13) {
                        class_243 var24 = var21.method_15758(this.field0732.method_37908(), var17);
                        if (var11 < 0.4000000345208531) {
                           var24 = var24.method_1021(var11);
                        }

                        var15 = var15.method_1019(var24);
                        var16++;
                     }
                  }
               }
            }
         }
      }

      if (var15.method_1033() > 0.0) {
         if (var16 > 0) {
            var15 = var15.method_1021(1.0 / var16);
         }

         var15 = var15.method_1021(var2);
         if (Math.abs(this.field1043.field_1352) < 0.0029999991268853153
            && Math.abs(this.field1043.field_1350) < 0.0029999991268853153
            && var15.method_1033() < 0.0045000015352560626) {
            var15 = var15.method_1029().method_1021(0.0045000015352560626);
         }

         this.field1043 = this.field1043.method_1019(var15);
      }

      this.field0398.put(var1, var11);
      return var14;
   }

   private boolean method0458() {
      class_238 var1 = this.field0214.method_1014(1.0);
      int var2 = class_3532.method_15357(var1.field_1323);
      int var3 = class_3532.method_15384(var1.field_1320);
      int var4 = class_3532.method_15357(var1.field_1321);
      int var5 = class_3532.method_15384(var1.field_1324);
      return !this.field0732.method_37908().method_33597(var2, var4, var3, var5);
   }

   private class_243 method0478() {
      return this.method0674(this.field1614, this.field0458);
   }

   private class_243 method0674(float var1, float var2) {
      float var3 = (float)(var1 * 3.1415929553574067 / 180.0);
      float var4 = (float)(-var2 * 3.1415929553574067 / 180.0);
      float var5 = class_3532.method_15362(var4);
      float var6 = class_3532.method_15374(var4);
      float var7 = class_3532.method_15362(var3);
      float var8 = class_3532.method_15374(var3);
      return new class_243(var6 * var7, -var8, var5 * var7);
   }

   public boolean method1531(class_6880<class_1291> var1) {
      class_1293 var2 = this.field0732.method_6112(var1);
      return var2 != null && var2.method_5584() >= this.field0424;
   }

   private class_1293 method2174(class_6880<class_1291> var1) {
      class_1293 var2 = this.field0732.method_6112(var1);
      return var2 != null && var2.method_5584() >= this.field0424 ? var2 : null;
   }

   public double method0339(class_6880<class_1320> var1) {
      return this.field0732.method_6127().method_26852(var1);
   }

   public SimulatedPlayerInput method0360() {
      return new SimulatedPlayerInput(
         this.field0732,
         this.field0044,
         this.field1521,
         this.field1043,
         this.field0214,
         this.field0458,
         this.field1614,
         this.field1574,
         this.field1704,
         this.field1137,
         this.field1109,
         this.field1218,
         this.field0890,
         this.field0845,
         this.field0931,
         this.field1350,
         this.field1312,
         this.field1388,
         new Object2DoubleArrayMap(this.field0398),
         new HashSet<>(this.field0365)
      );
   }

   public class_2338 method1297(class_243 var1) {
      return new class_2338(class_3532.method_15357(var1.field_1352), class_3532.method_15357(var1.field_1351), class_3532.method_15357(var1.field_1350));
   }

   public class_2680 method1262(class_2338 var1) {
      return this.field0732.method_37908().method_8320(var1);
   }

   public static class KeyboardInput extends class_744 {
      public boolean field0751 = false;
      public float field0003;
      public float field1410;
      public class_10185 field1038;
      public static final double field0757 = 0.12100004572049139;

      public KeyboardInput(class_10185 var1) {
         this.field1038 = var1;
      }

      public void method0578() {
         if (this.field1038.comp_3159() != this.field1038.comp_3160()) {
            this.field0003 = this.field1038.comp_3159() ? 1.0F : -1.0F;
         } else {
            this.field0003 = 0.0F;
         }

         if (this.field1038.comp_3161() == this.field1038.comp_3162()) {
            this.field1410 = 0.0F;
         } else {
            this.field1410 = this.field1038.comp_3161() ? 1.0F : -1.0F;
         }

         if (this.field1038.comp_3164()) {
            this.field1410 *= 0.3F;
            this.field0003 *= 0.3F;
         }
      }

      public String toString() {
         return "SimulatedPlayerInput(forwards={"
            + this.field1038.comp_3159()
            + "}, backwards={"
            + this.field1038.comp_3160()
            + "}, left={"
            + this.field1038.comp_3161()
            + "}, right={"
            + this.field1038.comp_3162()
            + "}, jumping={"
            + this.field1038.comp_3163()
            + "}, sprinting="
            + this.field1038.comp_3165()
            + ", slowDown="
            + this.field1038.comp_3164()
            + ")";
      }

      public static SimulatedPlayerInput.KeyboardInput method1113(class_10185 var0) {
         return new SimulatedPlayerInput.KeyboardInput(var0);
      }

      public static SimulatedPlayerInput.KeyboardInput method1179(class_1657 var0) {
         class_243 var1 = var0.method_19538().method_1020(new class_243(var0.field_6014, var0.field_6036, var0.field_5969));
         double var2 = var1.method_37268();
         class_10185 var4 = new class_10185(false, false, false, false, !var0.method_24828(), var0.method_5715(), var2 >= 0.014641000178811979);
         if (var2 > 0.0025000010524018398) {
            double var5 = MovementState.method1308(var1, var0.method_36454());
            double var7 = class_3532.method_15338(var5);
            var4 = MovementState.method1115(var4, var7);
         }

         return new SimulatedPlayerInput.KeyboardInput(var4);
      }
   }
}
