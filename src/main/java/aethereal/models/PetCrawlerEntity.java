package aethereal;

import java.util.Random;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3532;
import net.minecraft.class_746;
import net.minecraft.class_2338.class_2339;

public class PetCrawlerEntity {
   public static final float field0566 = 0.9F;
   public static final float field0003 = 0.9F;
   private static final double field1324 = 0.0800000114415252;
   private static final double field1395 = 1.400000198433554;
   private static final double field1389 = 0.700000120208071;
   private static final double field1402 = 0.9599995996097528;
   private static final double field0411 = 0.35000007870227423;
   private static final double field0406 = 1.0;
   private static final double field0417 = 0.5;
   private static final int field0375 = 8;
   private static final int field0371 = 22;
   private static final int field0379 = 10;
   private static final int field0448 = 26;
   private static final int field0444 = 8;
   private static final int field0453 = 14;
   public final PetCrawlerEntity.Segment field1456;
   public final Random field1034 = new Random();
   public class_243 field0795 = class_243.field_1353;
   public class_243 field1273 = class_243.field_1353;
   public class_243 field0338 = class_243.field_1353;
   public float field0177 = 0.0F;
   public float field0458 = 0.0F;
   public float field1614 = 0.0F;
   public float field1538 = 0.0F;
   public float field1704 = 0.0F;
   public float field1136 = 0.0F;
   public float field1087 = 0.0F;
   public float field1196 = 0.0F;
   public float field0871 = 0.0F;
   public float field0826 = 0.0F;
   public float field0910 = 0.0F;
   public float field1331 = 0.0F;
   public float field1292 = 0.0F;
   public float field1369 = 0.0F;
   public float field0385 = 0.0F;
   public float field0351 = 0.0F;
   public float field0423 = 0.0F;
   public float field0255 = 0.0F;
   public float field0226 = 0.0F;
   public float field0289 = 0.0F;
   public float field0523 = 0.0F;
   public float field0501 = 0.0F;
   public float field0547 = 0.0F;
   public float field1671 = 0.0F;
   public float field1657 = 0.0F;
   public float field1688 = 0.0F;
   public float field1590 = 0.0F;
   public float field1577 = 0.0F;
   public float field1601 = 0.0F;
   public PetCrawlerEntity.MovementState field1757 = PetCrawlerEntity.MovementState.field0635;
   public class_1309 field1748 = null;
   public class_243 field1773 = null;
   public float field1174 = 0.0F;
   public double field1163 = 1.7999994338495833;
   public int field1187 = 0;
   public boolean field1125 = false;
   public float field1112 = 0.0F;
   public float field1129 = 0.0F;
   public double field1226 = 0.0;
   public float field1219 = 1.0F;
   public float field1234 = 1.0F;
   private static final float field0279 = 4.0F;
   public boolean field0903 = false;
   public boolean field0897 = false;
   public boolean field0907 = false;
   public boolean field0860 = false;
   public boolean field0853 = false;
   public PetCrawlerEntity.MovementState field0867 = PetCrawlerEntity.MovementState.field0635;
   public boolean field0946 = false;
   public boolean field0938 = false;
   private class_243 field0277 = null;
   private int field0284 = 0;
   private int field0247 = 0;
   private int field0243 = 0;
   private float field0251 = 0.0F;
   private float field0307 = 0.0F;
   private int field0304 = 0;
   private int field0310 = 0;
   private float field0543 = 0.0F;
   private boolean field0542 = false;
   private boolean field0546 = false;
   public boolean field0953 = false;
   public boolean field1361 = false;
   private int field0519 = 0;
   private boolean field0518 = true;
   public boolean field1355 = false;
   private double field0521 = 0.0;
   private int field0561 = 0;
   public boolean field1367 = false;
   public int field1320 = 0;
   public boolean field1319 = false;

   public PetCrawlerEntity(PetCrawlerEntity.Segment var1) {
      this.field1456 = var1;
   }

   public boolean method0579() {
      return this.field1757 == PetCrawlerEntity.MovementState.field1255
         || this.field1757 == PetCrawlerEntity.MovementState.field0322
         || this.field1757 == PetCrawlerEntity.MovementState.field0193
         || this.field1757 == PetCrawlerEntity.MovementState.field0473;
   }

   public void method1311(class_243 var1, float var2) {
      this.field0795 = var1;
      this.field1273 = var1;
      this.field0338 = class_243.field_1353;
      this.field0177 = var2;
      this.field0458 = var2;
      this.field1614 = 0.0F;
      this.field1538 = 0.0F;
      this.field1704 = 0.0F;
      this.field1136 = 0.0F;
      this.field1087 = 0.0F;
      this.field1196 = 0.0F;
      this.field0871 = 0.0F;
      this.field0826 = 0.0F;
      this.field0910 = 0.0F;
      this.field1331 = 0.0F;
      this.field1292 = 0.0F;
      this.field1369 = 0.0F;
      this.field0385 = 0.0F;
      this.field0351 = 0.0F;
      this.field0423 = 0.0F;
      this.field0255 = 0.0F;
      this.field0226 = 0.0F;
      this.field0289 = 0.0F;
      this.field0523 = 0.0F;
      this.field0501 = 0.0F;
      this.field0547 = 0.0F;
      this.field1671 = 0.0F;
      this.field1657 = 0.0F;
      this.field1688 = 0.0F;
      this.field1590 = 0.0F;
      this.field1577 = 0.0F;
      this.field1601 = 0.0F;
      this.field1757 = PetCrawlerEntity.MovementState.field0635;
      this.field1187 = 0;
      this.field1748 = null;
      this.field1773 = null;
      this.field0946 = false;
      this.field0938 = true;
      this.field0277 = null;
      this.field0284 = 60 + this.field1034.nextInt(40);
      this.field0247 = 0;
   }

   public class_238 method0023() {
      return this.method1298(this.field0795);
   }

   public class_238 method1298(class_243 var1) {
      double var2 = 0.44999987F;
      return new class_238(
         var1.field_1352 - var2, var1.field_1351, var1.field_1350 - var2, var1.field_1352 + var2, var1.field_1351 + 0.9F, var1.field_1350 + var2
      );
   }

   public void method1542(class_746 var1, class_1937 var2) {
      if (this.field0938) {
         this.field1273 = this.field0795;
         this.field0458 = this.field0177;
         this.field1538 = this.field1614;
         this.field1136 = this.field1704;
         this.field0871 = this.field1196;
         this.field0910 = this.field0826;
         this.field1292 = this.field1331;
         this.field0385 = this.field1369;
         this.field0423 = this.field0351;
         this.field0226 = this.field0255;
         this.field0523 = this.field0289;
         this.field0547 = this.field0501;
         this.field1657 = this.field1671;
         this.field1590 = this.field1688;
         this.field1129 = this.field1112;
         this.field1601 = this.field1577;
         this.field1234 = this.field1219;
         this.field0867 = this.field1757;
         this.field1319 = false;
         this.field1331++;
         if (this.field1125) {
            this.field1757 = PetCrawlerEntity.MovementState.field0635;
            this.field1187 = 0;
            this.field1748 = null;
            this.method0341(var1);
            this.field1226 = 0.0;
            this.field1219 = 1.0F;
            this.method1634();
            this.method0450(var1);
            this.method1973();
            this.method0430();
         } else if (this.field1757 == PetCrawlerEntity.MovementState.field0635 && this.field0795.field_1351 < var1.method_23318() - 6.0) {
            this.method1311(this.method0342(var1, var2), var1.method_36454());
         } else {
            double var3 = this.field0795.method_1022(var1.method_19538());
            if (var3 > 7.0 && this.field1757 == PetCrawlerEntity.MovementState.field0635) {
               if (this.field0521 > 0.0 && this.field0521 - var3 < 0.029999988945560857) {
                  this.field0561++;
               } else {
                  this.field0561 = 0;
               }

               this.field0521 = var3;
            } else {
               this.field0561 = 0;
               this.field0521 = 0.0;
            }

            if (this.field1757 == PetCrawlerEntity.MovementState.field0635 && var3 > this.field1456.field0757 && this.field0561 > 80) {
               this.method1311(this.method0342(var1, var2), var1.method_36454());
               this.field0561 = 0;
            } else {
               if (!this.method0579() && this.field1757 != PetCrawlerEntity.MovementState.field0770 && this.field1757 != PetCrawlerEntity.MovementState.field1628
                  )
                {
                  class_238 var5 = this.method1298(this.field0795).method_1014(-0.18000006008545627);
                  if (var5.field_1320 > var5.field_1323
                     && var5.field_1325 > var5.field_1322
                     && var5.field_1324 > var5.field_1321
                     && this.method1250(var2, var5)) {
                     this.field1367 = true;
                     this.field1320++;
                     this.field0795 = this.field0795.method_1031(0.0, 0.059999975090199664, 0.0);
                     this.field0338 = class_243.field_1353;
                     if (this.field1320 % 4 == 0) {
                        this.field1319 = true;
                     }

                     this.field1226 = 0.0;
                     this.field1219 = 1.0F;
                     this.method1634();
                     this.method0450(var1);
                     this.method1973();
                     this.method0430();
                     return;
                  }

                  if (this.field1367) {
                     this.field1320 = 0;
                  }

                  this.field1367 = false;
               } else {
                  this.field1367 = false;
                  this.field1320 = 0;
               }

               boolean var12 = this.method2176(var1);
               if (!var12) {
                  class_243 var6 = this.method1874(var1);
                  this.field0338 = new class_243(
                     method0617(this.field0338.field_1352, var6.field_1352, 0.35000007870227423),
                     this.field0338.field_1351,
                     method0617(this.field0338.field_1350, var6.field_1350, 0.35000007870227423)
                  );
               }

               if (this.field1219 < 1.0F && this.field1757 == PetCrawlerEntity.MovementState.field0635) {
                  double var13 = 0.4499998887738949;
                  double var8 = Math.hypot(this.field0338.field_1352, this.field0338.field_1350);
                  if (var8 > var13) {
                     double var10 = var13 / var8;
                     this.field0338 = new class_243(this.field0338.field_1352 * var10, this.field0338.field_1351, this.field0338.field_1350 * var10);
                  }
               }

               if (!this.method0579()) {
                  if (!this.field0946) {
                     this.field0338 = this.field0338.method_1031(0.0, -0.08000004127662146, 0.0);
                     if (this.field0338.field_1351 < -1.4000000745096437) {
                        this.field0338 = new class_243(this.field0338.field_1352, -1.4000000745096437, this.field0338.field_1350);
                     }
                  }

                  if (this.field1757 != PetCrawlerEntity.MovementState.field0770) {
                     this.method2000(var1);
                  }

                  this.method1248(var2);
                  double var14 = this.field0946 ? 0.700000120208071 : 0.9599995996097528;
                  if (this.field1757 == PetCrawlerEntity.MovementState.field0770) {
                     var14 = 0.9599995996097528;
                  }

                  this.field0338 = new class_243(this.field0338.field_1352 * var14, this.field0338.field_1351, this.field0338.field_1350 * var14);
                  if (Math.abs(this.field0338.field_1352) < 9.999997505326666E-5) {
                     this.field0338 = new class_243(0.0, this.field0338.field_1351, this.field0338.field_1350);
                  }

                  if (Math.abs(this.field0338.field_1350) < 9.999997505326666E-5) {
                     this.field0338 = new class_243(this.field0338.field_1352, this.field0338.field_1351, 0.0);
                  }
               }

               if (this.field1219 < 1.0F) {
                  float var15 = 4.0F * Math.max(0.5F, (float)this.field1226);
                  this.field1219 = Math.min(1.0F, this.field1219 + 1.0F / var15);
                  if (this.field1219 >= 1.0F) {
                     this.field1226 = 0.0;
                  }
               }

               this.method1634();
               this.method0450(var1);
               this.method1973();
               this.method0430();
            }
         }
      }
   }

   private void method0341(class_746 var1) {
      float var2 = var1.method_36454();
      double var3 = Math.toRadians(var2);
      double var5 = -Math.cos(var3);
      double var7 = -Math.sin(var3);
      double var9 = Math.sin(var3);
      double var11 = -Math.cos(var3);
      double var13 = 0.1800000298032604;
      double var15 = 0.05000000896494815;
      this.field0795 = new class_243(
         var1.method_23317() + var5 * var13 + var9 * var15, var1.method_23318() + 1.5499996745959, var1.method_23321() + var7 * var13 + var11 * var15
      );
      this.field0177 = var2 + 8.0F;
      this.field0338 = class_243.field_1353;
      this.field0946 = false;
   }

   public void method2078() {
      this.field1125 = true;
      this.field1757 = PetCrawlerEntity.MovementState.field0635;
      this.field1187 = 0;
      this.field0338 = class_243.field_1353;
      this.field1226 = 0.0;
      this.field1219 = 1.0F;
   }

   public void method1541(class_746 var1) {
      if (this.field1125) {
         this.field1125 = false;
         float var2 = var1.method_36454();
         double var3 = Math.toRadians(var2);
         double var5 = -Math.cos(var3);
         double var7 = -Math.sin(var3);
         this.field0338 = new class_243(var5 * 0.11999994995062047, 0.05000000896494815, var7 * 0.11999994995062047);
         this.field0946 = false;
      }
   }

   private boolean method2176(class_746 var1) {
      this.field0903 = false;
      this.field0897 = false;
      this.field0907 = false;
      this.field0860 = false;
      this.field0853 = false;
      class_1309 var2 = this.field1748;
      if (var2 != null && (!var2.method_5805() || var2 == var1)) {
         var2 = null;
      }

      if (var2 != null) {
         this.field1773 = var2.method_19538();
         this.field1174 = var2.method_36454();
         this.field1163 = var2.method_5829().method_17940();
      }

      boolean var3 = var2 != null;
      boolean var4 = this.field1757 == PetCrawlerEntity.MovementState.field0770
         || this.field1757 == PetCrawlerEntity.MovementState.field1255
         || this.field1757 == PetCrawlerEntity.MovementState.field0322
         || this.field1757 == PetCrawlerEntity.MovementState.field0193
         || this.field1757 == PetCrawlerEntity.MovementState.field0473
         || this.field1757 == PetCrawlerEntity.MovementState.field1628
         || this.field1757 == PetCrawlerEntity.MovementState.field1554;
      if (!var3 && !var4) {
         if (this.field1757 != PetCrawlerEntity.MovementState.field0635) {
            this.field1757 = PetCrawlerEntity.MovementState.field0635;
            this.field1187 = 0;
            this.field0853 = true;
         }

         return false;
      } else {
         class_243 var5 = var3 ? var2.method_19538() : (this.field1773 != null ? this.field1773 : this.field0795);
         float var6 = var3 ? var2.method_36454() : this.field1174;
         double var7 = var3 ? var2.method_5829().method_17940() : this.field1163;
         class_243 var9 = new class_243(var5.field_1352 - this.field0795.field_1352, 0.0, var5.field_1350 - this.field0795.field_1350);
         double var10 = var9.method_1033();
         if (this.field1757 != PetCrawlerEntity.MovementState.field0770 && !this.method0579() && var10 > 9.999995343411587E-4) {
            float var12 = (float)Math.toDegrees(Math.atan2(-var9.field_1352, var9.field_1350));
            this.field0177 = method0681(this.field0177, var12, 0.4F);
         }

         if (this.field1757 != PetCrawlerEntity.MovementState.field0635) {
            this.field1577++;
         }

         switch (this.field1757) {
            case field0635:
               this.field1757 = PetCrawlerEntity.MovementState.field0070;
               this.field1187 = 0;
               this.field0853 = true;
            case field0070:
               if (!var3) {
                  this.method1812();
                  return false;
               } else {
                  if (var10 < 2.5) {
                     this.field1757 = PetCrawlerEntity.MovementState.field1457;
                     this.field1187 = 0;
                     this.field0853 = true;
                     return this.method0644(var10, var9);
                  }

                  this.field1187++;
                  if (var10 > 9.999995343411587E-4) {
                     double var22 = this.field1456.field0956 * 1.200000158705156;
                     this.field0338 = new class_243(
                        method0617(this.field0338.field_1352, var9.field_1352 / var10 * var22, 0.35000007870227423),
                        this.field0338.field_1351,
                        method0617(this.field0338.field_1350, var9.field_1350 / var10 * var22, 0.35000007870227423)
                     );
                  }

                  return true;
               }
            case field1457:
               if (!var3) {
                  this.method1812();
                  return false;
               } else {
                  this.field1187++;
                  if (var10 < 1.6000000629379607 && this.field1187 > 4) {
                     this.field1757 = PetCrawlerEntity.MovementState.field0991;
                     this.field1187 = 0;
                     this.field0853 = true;
                     this.field0338 = new class_243(
                        this.field0338.field_1352 * 0.4000000745826885, this.field0338.field_1351, this.field0338.field_1350 * 0.4000000745826885
                     );
                     return true;
                  } else {
                     if (var10 > 3.5) {
                        this.field1757 = PetCrawlerEntity.MovementState.field0070;
                        this.field1187 = 0;
                        this.field0853 = true;
                        return true;
                     }

                     return this.method0644(var10, var9);
                  }
               }
            case field0991:
               if (!var3) {
                  this.method1812();
                  return false;
               }

               this.field1187++;
               this.field0338 = new class_243(this.field0338.field_1352 * 0.5, this.field0338.field_1351, this.field0338.field_1350 * 0.5);
               if (this.field1187 >= 9) {
                  this.field1757 = PetCrawlerEntity.MovementState.field0770;
                  this.field1187 = 0;
                  this.field0853 = true;
                  this.field0903 = true;
                  if (var10 > 9.999997505326666E-5) {
                     double var21 = 11.0;
                     double var25 = class_3532.method_15350(0.3400000076270329 + var10 * 0.04500000745444953, 0.3400000076270329, 0.6000000682931831);
                     double var26 = class_3532.method_15350(var10 / var21 * 1.0499995268955502, 0.1800000298032604, 0.5500001509908443);
                     this.field0338 = new class_243(var9.field_1352 / var10 * var26, var25, var9.field_1350 / var10 * var26);
                     this.field0177 = (float)Math.toDegrees(Math.atan2(-var9.field_1352, var9.field_1350));
                     this.field0946 = false;
                  }
               }

               return true;
            case field0770:
               this.field1187++;
               boolean var20 = var3 && this.method0023().method_1014(0.1500000902291664).method_994(var2.method_5829());
               boolean var23 = this.field1187 > 4 && this.field0946;
               boolean var24 = this.field1187 > 28;
               if (var20 || var23 || var24) {
                  this.field1757 = PetCrawlerEntity.MovementState.field1255;
                  this.field1187 = 0;
                  this.field0897 = true;
                  this.field0853 = true;
                  this.field0338 = class_243.field_1353;
                  this.method1312(var5, var6, var7);
               }

               return false;
            case field1255:
               this.field1187++;
               this.method1312(var5, var6, var7);
               if (this.field1187 >= 8) {
                  this.field1757 = PetCrawlerEntity.MovementState.field0322;
                  this.field1187 = 0;
                  this.field0853 = true;
               }

               return true;
            case field0322:
               this.field1187++;
               this.method1312(var5, var6, var7);
               if (this.field1187 % 4 == 0) {
                  this.field0907 = true;
               }

               if (this.field1187 >= 22) {
                  this.field1757 = PetCrawlerEntity.MovementState.field0193;
                  this.field1187 = 0;
                  this.field0853 = true;
               }

               return true;
            case field0193:
               this.field1187++;
               float var19 = class_3532.method_15363(this.field1187 / 10.0F, 0.0F, 1.0F);
               float var13 = var19 * var19 * (3.0F - 2.0F * var19);
               this.method1313(var5, var6, var7, 0.5 + var13 * 0.35000007870227423);
               if (this.field1187 >= 10) {
                  this.field1757 = PetCrawlerEntity.MovementState.field0473;
                  this.field1187 = 0;
                  this.field0860 = true;
                  this.field0853 = true;
               }

               return true;
            case field0473:
               this.field1187++;
               this.method1313(var5, var6, var7, 0.8500002992619594);
               this.field0177 = var6 + class_3532.method_15374(this.field1187 * 1.1F) * 12.0F;
               if (this.field1187 >= 26) {
                  this.field1757 = PetCrawlerEntity.MovementState.field1628;
                  this.field1187 = 0;
                  this.field0853 = true;
                  double var18 = Math.toRadians(var6);
                  double var14 = -Math.sin(var18);
                  double var16 = Math.cos(var18);
                  this.field0338 = new class_243(-var14 * 0.25, 0.1800000298032604, -var16 * 0.25);
                  this.field0946 = false;
               }

               return true;
            case field1628:
               this.field1187++;
               if (this.field1187 >= 8 || this.field0946) {
                  this.field1757 = PetCrawlerEntity.MovementState.field1554;
                  this.field1187 = 0;
                  this.field0853 = true;
               }

               return false;
            case field1554:
               this.field1187++;
               this.field0338 = new class_243(
                  this.field0338.field_1352 * 0.6499997634928102, this.field0338.field_1351, this.field0338.field_1350 * 0.6499997634928102
               );
               if (this.field1187 >= 14) {
                  this.field1757 = PetCrawlerEntity.MovementState.field0635;
                  this.field1187 = 0;
                  this.field0853 = true;
                  return false;
               }

               return true;
            default:
               return false;
         }
      }
   }

   private void method1312(class_243 var1, float var2, double var3) {
      this.method1313(var1, var2, var3, 0.4499998887738949);
   }

   private void method1313(class_243 var1, float var2, double var3, double var5) {
      double var7 = Math.toRadians(var2);
      double var9 = -Math.sin(var7);
      double var11 = Math.cos(var7);
      double var13 = 0.2800001818411333;
      this.field0795 = new class_243(var1.field_1352 - var9 * var13, var1.field_1351 + var3 * var5 - 0.44999987F, var1.field_1350 - var11 * var13);
      this.field0338 = class_243.field_1353;
      this.field0177 = var2;
   }

   private void method1812() {
      this.field1757 = PetCrawlerEntity.MovementState.field0635;
      this.field1187 = 0;
      this.field0853 = true;
   }

   private boolean method0644(double var1, class_243 var3) {
      if (var1 > 9.999995343411587E-4) {
         double var4 = this.field1456.field1409 * 0.5500001509908443;
         this.field0338 = new class_243(
            method0617(this.field0338.field_1352, var3.field_1352 / var1 * var4, 0.35000007870227423),
            this.field0338.field_1351,
            method0617(this.field0338.field_1350, var3.field_1350 / var1 * var4, 0.35000007870227423)
         );
      } else {
         this.field0338 = new class_243(this.field0338.field_1352 * 0.5, this.field0338.field_1351, this.field0338.field_1350 * 0.5);
      }

      return true;
   }

   private void method1634() {
      float var1 = this.field1757 == PetCrawlerEntity.MovementState.field0991
         ? 1.0F
         : (this.field1757 == PetCrawlerEntity.MovementState.field1457 ? 0.45F : 0.0F);
      float var2 = this.field1757 == PetCrawlerEntity.MovementState.field0770 ? 1.0F : 0.0F;
      float var3 = this.field1757 == PetCrawlerEntity.MovementState.field1255 ? 1.0F : 0.0F;
      float var4 = this.field1757 == PetCrawlerEntity.MovementState.field0322 ? 1.0F : 0.0F;
      float var5 = this.field1757 == PetCrawlerEntity.MovementState.field0193 ? 1.0F : 0.0F;
      float var6 = this.field1757 == PetCrawlerEntity.MovementState.field0473 ? 1.0F : 0.0F;
      float var7 = this.field1757 == PetCrawlerEntity.MovementState.field1554 ? 1.0F : (this.field1757 == PetCrawlerEntity.MovementState.field1628 ? 0.5F : 0.0F);
      float var8 = this.field1125 ? 1.0F : 0.0F;
      if (this.field1125) {
         var7 = 0.0F;
         var6 = 0.0F;
         var5 = 0.0F;
         var4 = 0.0F;
         var3 = 0.0F;
         var2 = 0.0F;
         var1 = 0.0F;
      }

      this.field1369 = this.field1369 + (var1 - this.field1369) * 0.35F;
      this.field0351 = this.field0351 + (var2 - this.field0351) * 0.45F;
      this.field0255 = this.field0255 + (var3 - this.field0255) * 0.55F;
      this.field0289 = this.field0289 + (var4 - this.field0289) * 0.4F;
      this.field0501 = this.field0501 + (var5 - this.field0501) * 0.4F;
      this.field1671 = this.field1671 + (var6 - this.field1671) * 0.45F;
      this.field1688 = this.field1688 + (var7 - this.field1688) * 0.35F;
      this.field1112 = this.field1112 + (var8 - this.field1112) * 0.18F;
   }

   private class_243 method1874(class_746 var1) {
      class_243 var2 = var1.method_19538();
      class_243 var3 = new class_243(var2.field_1352 - this.field0795.field_1352, 0.0, var2.field_1350 - this.field0795.field_1350);
      double var4 = var3.method_1033();
      double var6 = var1.method_23317() - var1.field_6014;
      double var8 = var1.method_23321() - var1.field_5969;
      double var10 = Math.hypot(var6, var8);
      boolean var12 = var10 > 0.04000001684026696;
      double var13 = this.field1456.field0565;
      double var15 = this.field1456.field0002;
      boolean var17 = var4 > var15 || var12 && var4 > var13 * 0.700000120208071;
      boolean var18 = var4 > var15 * 1.6000000629379607;
      this.field1355 = var4 > 7.0;
      if (this.field1355) {
         this.field0519 = 0;
         this.field0518 = false;
         this.field0247 = 0;
         this.field0277 = null;
         if (var4 < 9.999995343411587E-4) {
            return class_243.field_1353;
         }

         double var24 = 1.400000198433554;
         return new class_243(var3.field_1352 / var4 * var24, 0.0, var3.field_1350 / var4 * var24);
      } else {
         if (!var17) {
            if (!this.field0518) {
               this.field0519 = 30 + this.field1034.nextInt(11);
               this.field0518 = true;
            }
         } else {
            this.field0518 = false;
            if (this.field0519 > 0 && !var18) {
               this.field0519--;
               if (!var12 && var4 < var13) {
                  this.field0247++;
                  return this.method1674(var1);
               }

               return class_243.field_1353;
            }
         }

         if (!var12 && var4 < var13) {
            this.field0247++;
            return this.method1674(var1);
         }

         this.field0247 = 0;
         this.field0277 = null;
         if (var17) {
            if (var4 < 9.999995343411587E-4) {
               return class_243.field_1353;
            }

            double var19;
            if (var12) {
               double var21 = class_3532.method_15350((var4 - var13) / Math.max(0.0100000000186558, var15 - var13), 0.0, 1.0);
               var19 = var10 * (1.0 + 0.4499998887738949 * var21);
            } else {
               var19 = this.field1456.field1409;
            }

            var19 = Math.min(var19, this.field1456.field0956);
            if (!var12) {
               var19 = Math.min(var19, Math.max(0.0, var4 - var13 * 0.8500002992619594));
            }

            return new class_243(var3.field_1352 / var4 * var19, 0.0, var3.field_1350 / var4 * var19);
         } else {
            return class_243.field_1353;
         }
      }
   }

   private class_243 method1674(class_746 var1) {
      if (this.field0284 > 0) {
         this.field0284--;
         return class_243.field_1353;
      }

      if (this.field0277 == null) {
         if (!(this.field1034.nextFloat() < 0.35F) || this.field0247 <= 30) {
            this.field0284 = 30 + this.field1034.nextInt(80);
            return class_243.field_1353;
         }

         double var2 = 0.7999999048087838 + this.field1034.nextDouble() * (this.field1456.field0565 - 0.5);
         double var4 = this.field1034.nextDouble() * 3.141593424725837 * 2.0;
         class_243 var6 = var1.method_19538();
         this.field0277 = new class_243(var6.field_1352 + Math.cos(var4) * var2, var6.field_1351, var6.field_1350 + Math.sin(var4) * var2);
      }

      class_243 var7 = new class_243(this.field0277.field_1352 - this.field0795.field_1352, 0.0, this.field0277.field_1350 - this.field0795.field_1350);
      double var3 = var7.method_1033();
      if (var3 < 0.19999997628185645) {
         this.field0277 = null;
         this.field0284 = 60 + this.field1034.nextInt(100);
         return class_243.field_1353;
      } else {
         double var5 = Math.min(this.field1456.field1409 * 0.6000000682931831, var3);
         return new class_243(var7.field_1352 / var3 * var5, 0.0, var7.field_1350 / var3 * var5);
      }
   }

   private void method1248(class_1937 var1) {
      boolean var2 = this.method1250(var1, this.method1298(this.field0795.method_1031(0.0, -0.02000000756901481, 0.0)));
      double var3 = this.field0795.field_1351;
      double var5 = this.field0795.field_1351 + this.field0338.field_1351;
      class_238 var7 = this.method1298(new class_243(this.field0795.field_1352, var5, this.field0795.field_1350));
      if (this.method1250(var1, var7)) {
         if (this.field0338.field_1351 < 0.0) {
            var5 = this.method1249(var1, this.field0795.field_1352, this.field0795.field_1351, this.field0795.field_1350);
            this.field0946 = true;
         } else {
            var5 = this.field0795.field_1351;
         }

         this.field0338 = new class_243(this.field0338.field_1352, 0.0, this.field0338.field_1350);
      } else {
         this.field0946 = var2;
      }

      boolean var8 = (var2 || this.field0946)
         && this.field1757 != PetCrawlerEntity.MovementState.field0770
         && this.field1757 != PetCrawlerEntity.MovementState.field1628;
      double var9 = var5;
      double var11 = this.field0795.field_1352 + this.field0338.field_1352;
      if (Math.abs(this.field0338.field_1352) > 1.0000000007112479E-5) {
         class_238 var13 = this.method1298(new class_243(var11, var5, this.field0795.field_1350));
         if (this.method1250(var1, var13)) {
            class_238 var14 = this.method1298(new class_243(var11, var5 + 1.0 + 9.999995343411587E-4, this.field0795.field_1350));
            if (var8 && !this.method1250(var1, var14)) {
               var5 = this.method0271(var1, var11, var5 + 1.0 + 9.999995343411587E-4, this.field0795.field_1350);
               double var15 = Math.signum(this.field0338.field_1352);
               double var17 = 0.4000000745826885;
               if (Math.abs(this.field0338.field_1352) > var17) {
                  var11 = this.field0795.field_1352 + var15 * var17;
                  this.field0338 = new class_243(var15 * var17, this.field0338.field_1351, this.field0338.field_1350);
               }
            } else {
               var11 = this.field0795.field_1352;
               this.field0338 = new class_243(0.0, this.field0338.field_1351, this.field0338.field_1350);
            }
         }
      } else {
         var11 = this.field0795.field_1352;
      }

      double var23 = this.field0795.field_1350 + this.field0338.field_1350;
      if (Math.abs(this.field0338.field_1350) > 1.0000000007112479E-5) {
         class_238 var24 = this.method1298(new class_243(var11, var5, var23));
         if (this.method1250(var1, var24)) {
            class_238 var16 = this.method1298(new class_243(var11, var5 + 1.0 + 9.999995343411587E-4, var23));
            if (var8 && !this.method1250(var1, var16)) {
               var5 = this.method0271(var1, var11, var5 + 1.0 + 9.999995343411587E-4, var23);
               double var26 = Math.signum(this.field0338.field_1350);
               double var19 = 0.4000000745826885;
               if (Math.abs(this.field0338.field_1350) > var19) {
                  var23 = this.field0795.field_1350 + var26 * var19;
                  this.field0338 = new class_243(this.field0338.field_1352, this.field0338.field_1351, var26 * var19);
               }
            } else {
               var23 = this.field0795.field_1350;
               this.field0338 = new class_243(this.field0338.field_1352, this.field0338.field_1351, 0.0);
            }
         }
      } else {
         var23 = this.field0795.field_1350;
      }

      double var25 = var5 - var9;
      if (var25 > 0.05000000896494815 && var25 <= 1.0499995268955502) {
         this.method0611(var25);
      }

      this.field0795 = new class_243(var11, var5, var23);
      if (this.field0338.field_1351 <= 0.0 && !this.field0946) {
         for (double var27 = 0.020000006578406306; var27 <= 0.5; var27 += 0.05000000896494815) {
            if (this.method1250(var1, this.method1298(this.field0795.method_1031(0.0, -var27, 0.0)))) {
               double var28 = this.method1249(
                  var1, this.field0795.field_1352, this.field0795.field_1351 - var27 + 0.0100000000186558, this.field0795.field_1350
               );
               double var21 = var28 - this.field0795.field_1351;
               if (var21 > 0.05000000896494815 && var21 <= 1.0499995268955502) {
                  this.method0611(var21);
               }

               this.field0795 = new class_243(this.field0795.field_1352, var28, this.field0795.field_1350);
               this.field0338 = new class_243(this.field0338.field_1352, 0.0, this.field0338.field_1350);
               this.field0946 = true;
               break;
            }
         }
      }

      if (!this.field0946 && this.method1250(var1, this.method1298(this.field0795.method_1031(0.0, -0.02000000756901481, 0.0)))) {
         this.field0946 = true;
         if (this.field0338.field_1351 < 0.0) {
            this.field0338 = new class_243(this.field0338.field_1352, 0.0, this.field0338.field_1350);
         }
      }
   }

   private double method1249(class_1937 var1, double var2, double var4, double var6) {
      for (int var8 = 0; var8 <= 3; var8++) {
         class_2338 var9 = class_2338.method_49637(var2, var4 - var8, var6);
         class_2680 var10 = var1.method_8320(var9);
         class_265 var11 = var10.method_26220(var1, var9);
         if (!var11.method_1110()) {
            return var9.method_10264() + var11.method_1107().field_1325;
         }
      }

      return var4;
   }

   private double method0271(class_1937 var1, double var2, double var4, double var6) {
      for (double var8 = 0.0; var8 <= 1.1000000536386465; var8 += 0.05000000896494815) {
         class_2338 var10 = class_2338.method_49637(var2, var4 - var8, var6);
         class_2680 var11 = var1.method_8320(var10);
         class_265 var12 = var11.method_26220(var1, var10);
         if (!var12.method_1110()) {
            return var10.method_10264() + var12.method_1107().field_1325;
         }
      }

      return var4;
   }

   private boolean method1250(class_1937 var1, class_238 var2) {
      int var3 = (int)Math.floor(var2.field_1323);
      int var4 = (int)Math.floor(var2.field_1320 - 9.999998845943189E-8);
      int var5 = (int)Math.floor(var2.field_1322);
      int var6 = (int)Math.floor(var2.field_1325 - 9.999998845943189E-8);
      int var7 = (int)Math.floor(var2.field_1321);
      int var8 = (int)Math.floor(var2.field_1324 - 9.999998845943189E-8);
      class_2339 var9 = new class_2339();

      for (int var10 = var3; var10 <= var4; var10++) {
         for (int var11 = var5; var11 <= var6; var11++) {
            for (int var12 = var7; var12 <= var8; var12++) {
               var9.method_10103(var10, var11, var12);
               class_2680 var13 = var1.method_8320(var9);
               class_265 var14 = var13.method_26220(var1, var9);
               if (!var14.method_1110()) {
                  class_238 var15 = var14.method_1107().method_989(var10, var11, var12);
                  if (var15.method_994(var2)) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   private void method2000(class_746 var1) {
      class_238 var2 = this.method0023();
      class_238 var3 = var1.method_5829();
      if (var2.method_994(var3)) {
         class_243 var4 = new class_243(
            (var2.field_1323 + var2.field_1320) * 0.5, (var2.field_1322 + var2.field_1325) * 0.5, (var2.field_1321 + var2.field_1324) * 0.5
         );
         class_243 var5 = var3.method_1005();
         double var6 = var4.field_1352 - var5.field_1352;
         double var8 = var4.field_1350 - var5.field_1350;
         double var10 = (var2.method_17939() + var3.method_17939()) * 0.5 - Math.abs(var6);
         double var12 = (var2.method_17941() + var3.method_17941()) * 0.5 - Math.abs(var8);
         if (!(var10 <= 0.0) && !(var12 <= 0.0)) {
            double var14 = Math.signum(var6 == 0.0 ? (this.field1034.nextBoolean() ? 1 : -1) : var6);
            double var16 = Math.signum(var8 == 0.0 ? (this.field1034.nextBoolean() ? 1 : -1) : var8);
            if (var10 < var12) {
               this.field0795 = this.field0795.method_1031(var14 * var10, 0.0, 0.0);
               this.field0338 = new class_243(this.field0338.field_1352 + var14 * 0.05000000896494815, this.field0338.field_1351, this.field0338.field_1350);
            } else {
               this.field0795 = this.field0795.method_1031(0.0, 0.0, var16 * var12);
               this.field0338 = new class_243(this.field0338.field_1352, this.field0338.field_1351, this.field0338.field_1350 + var16 * 0.05000000896494815);
            }
         }
      }
   }

   private void method0450(class_746 var1) {
      double var2 = Math.hypot(this.field0795.field_1352 - this.field1273.field_1352, this.field0795.field_1350 - this.field1273.field_1350);
      float var4 = (float)Math.min(var2 * 4.0, 1.0);
      if (this.field1757 == PetCrawlerEntity.MovementState.field0770 || this.method0579() || this.field1757 == PetCrawlerEntity.MovementState.field1628) {
         var4 *= 0.1F;
      }

      this.field1196 = this.field1196 + (var4 - this.field1196) * 0.4F;
      this.field1087 = this.field1087 + this.field1196 * 0.6662F;
      if (var2 > 0.01499999400554998 && this.field1757 != PetCrawlerEntity.MovementState.field0770 && !this.method0579()) {
         float var5 = (float)Math.toDegrees(
            Math.atan2(-(this.field0795.field_1352 - this.field1273.field_1352), this.field0795.field_1350 - this.field1273.field_1350)
         );
         this.field0177 = method0681(this.field0177, var5, 0.35F);
      }

      class_243 var15;
      if (this.field1748 != null && this.field1757 != PetCrawlerEntity.MovementState.field0635) {
         var15 = this.field1748.method_33571();
      } else {
         var15 = var1.method_33571();
      }

      double var6 = var15.field_1352 - this.field0795.field_1352;
      double var8 = var15.field_1350 - this.field0795.field_1350;
      double var10 = var15.field_1351 - (this.field0795.field_1351 + 0.764999993056772);
      float var12 = (float)Math.toDegrees(Math.atan2(-var6, var8)) - this.field0177;
      var12 = class_3532.method_15393(var12);
      var12 = class_3532.method_15363(var12, -75.0F, 75.0F);
      float var13 = (float)(-Math.toDegrees(Math.atan2(var10, Math.hypot(var6, var8))));
      var13 = class_3532.method_15363(var13, -45.0F, 35.0F);
      if (this.field1196 < 0.1F && this.field1757 == PetCrawlerEntity.MovementState.field0635) {
         if (this.field0243 <= 0) {
            this.field0243 = 40 + this.field1034.nextInt(80);
            this.field0251 = (this.field1034.nextFloat() - 0.5F) * 50.0F;
            this.field0307 = (this.field1034.nextFloat() - 0.5F) * 20.0F;
         } else {
            this.field0243--;
         }

         var12 += this.field0251;
         var13 += this.field0307;
         var12 = class_3532.method_15363(var12, -75.0F, 75.0F);
         var13 = class_3532.method_15363(var13, -45.0F, 35.0F);
      } else {
         this.field0243 = 0;
         this.field0251 = 0.0F;
         this.field0307 = 0.0F;
      }

      float var14 = this.field1757 == PetCrawlerEntity.MovementState.field0635 ? 0.25F : 0.5F;
      this.field1614 = method0681(this.field1614, var12, var14);
      this.field1704 = class_3532.method_16439(var14, this.field1704, var13);
   }

   private void method1973() {
      float var1;
      if (this.field1757 == PetCrawlerEntity.MovementState.field1457 || this.field1757 == PetCrawlerEntity.MovementState.field0991) {
         var1 = 0.25F + (float)Math.sin(this.field1331 * 0.5) * 0.05F;
      } else if (this.field1757 == PetCrawlerEntity.MovementState.field0770) {
         var1 = 1.0F;
      } else if (this.field1757 == PetCrawlerEntity.MovementState.field1255) {
         var1 = 1.0F;
      } else if (this.field1757 == PetCrawlerEntity.MovementState.field0322) {
         var1 = 0.7F + (float)Math.sin(this.field1577 * 0.6000000682931831) * 0.3F;
      } else if (this.field1757 == PetCrawlerEntity.MovementState.field0193) {
         var1 = 0.55F;
      } else if (this.field1757 == PetCrawlerEntity.MovementState.field0473) {
         var1 = 0.95F + (float)Math.sin(this.field1577 * 1.5) * 0.05F;
      } else if (this.field1757 == PetCrawlerEntity.MovementState.field1554 || this.field1757 == PetCrawlerEntity.MovementState.field1628) {
         var1 = 0.4F + (float)Math.sin(this.field1331 * 0.6000000682931831) * 0.2F;
      } else if (this.field1196 > 0.4F) {
         this.field0543 += 0.45F;
         var1 = (float)(0.35000007870227423 + 0.3000001511153016 * Math.sin(this.field0543));
      } else if (this.field0304 > 0) {
         float var2 = 1.0F - (float)this.field0304 / this.field0310;
         var1 = (float)Math.sin(var2 * 3.141593424725837);
         this.field0304--;
      } else {
         var1 = 0.0F;
         if (this.field1034.nextFloat() < 0.006F) {
            this.field0310 = 28 + this.field1034.nextInt(20);
            this.field0304 = this.field0310;
         }
      }

      this.field0826 = this.field0826 + (var1 - this.field0826) * 0.3F;
   }

   private void method0430() {
      float var1 = class_3532.method_15362(this.field1087);
      boolean var2 = var1 < -0.5F && this.field1196 > 0.25F;
      boolean var3 = var1 > 0.5F && this.field1196 > 0.25F;
      this.field0953 = var2 && !this.field0542;
      this.field1361 = var3 && !this.field0546;
      this.field0542 = var2;
      this.field0546 = var3;
   }

   private class_243 method0342(class_746 var1, class_1937 var2) {
      class_243 var3 = var1.method_19538();

      for (int var4 = 0; var4 < 8; var4++) {
         double var5 = this.field1034.nextDouble() * 3.141593424725837 * 2.0;
         double var7 = this.field1456.field0565 * (0.6000000682931831 + this.field1034.nextDouble() * 0.4000000745826885);
         class_243 var9 = new class_243(var3.field_1352 + Math.cos(var5) * var7, var3.field_1351, var3.field_1350 + Math.sin(var5) * var7);
         if (!this.method1250(var2, this.method1298(var9))) {
            return var9;
         }
      }

      return var3;
   }

   public class_243 method0664(float var1) {
      return new class_243(
         class_3532.method_16436(var1, this.field1273.field_1352, this.field0795.field_1352),
         class_3532.method_16436(var1, this.field1273.field_1351, this.field0795.field_1351),
         class_3532.method_16436(var1, this.field1273.field_1350, this.field0795.field_1350)
      );
   }

   public float method0115(float var1) {
      return class_3532.method_17821(var1, this.field0458, this.field0177);
   }

   public float method2092(float var1) {
      return class_3532.method_17821(var1, this.field1538, this.field1614);
   }

   public float method1817(float var1) {
      return class_3532.method_16439(var1, this.field1136, this.field1704);
   }

   public float method1636(float var1) {
      return class_3532.method_16439(var1, this.field0871, this.field1196);
   }

   public float method1975(float var1) {
      return class_3532.method_16439(var1, this.field0910, this.field0826);
   }

   public float method0433(float var1) {
      return class_3532.method_16439(var1, this.field1292, this.field1331);
   }

   public float method0377(float var1) {
      return class_3532.method_16439(var1, this.field0385, this.field1369);
   }

   public float method0500(float var1) {
      return class_3532.method_16439(var1, this.field0423, this.field0351);
   }

   public float method2231(float var1) {
      return class_3532.method_16439(var1, this.field0226, this.field0255);
   }

   public float method2196(float var1) {
      return class_3532.method_16439(var1, this.field0523, this.field0289);
   }

   public float method2268(float var1) {
      return class_3532.method_16439(var1, this.field0547, this.field0501);
   }

   public float method1917(float var1) {
      return class_3532.method_16439(var1, this.field1657, this.field1671);
   }

   public float method1892(float var1) {
      return class_3532.method_16439(var1, this.field1590, this.field1688);
   }

   public float method1939(float var1) {
      return class_3532.method_16439(var1, this.field1129, this.field1112);
   }

   public float method1737(float var1) {
      return class_3532.method_16439(var1, this.field1601, this.field1577);
   }

   private void method0611(double var1) {
      double var3 = (1.0F - this.field1219) * this.field1226;
      this.field1226 = Math.max(var3, var1);
      this.field1219 = 0.0F;
   }

   public float method1693(float var1) {
      return class_3532.method_16439(var1, this.field1234, this.field1219);
   }

   public double method1756(float var1) {
      if (this.field1226 < 9.999997505326666E-5) {
         return 0.0;
      }

      float var2 = class_3532.method_16439(var1, this.field1234, this.field1219);
      return -this.field1226 * (1.0F - method0459(var2));
   }

   private static float method0459(float var0) {
      if (var0 < 0.18F) {
         float var4 = var0 / 0.18F;
         return -0.08F * var4;
      } else if (var0 < 0.5F) {
         float var3 = (var0 - 0.18F) / 0.32F;
         float var2 = 1.0F - (1.0F - var3) * (1.0F - var3) * (1.0F - var3);
         return -0.08F + var2 * 1.15F;
      } else if (var0 < 0.8F) {
         float var1 = (var0 - 0.5F) / 0.3F;
         return 1.07F - var1 * 0.07F;
      } else {
         return 1.0F;
      }
   }

   private static float method0481(float var0) {
      return class_3532.method_15374(class_3532.method_15363(var0, 0.0F, 1.0F) * (float) Math.PI);
   }

   public float method2031(float var1) {
      if (this.field1226 < 9.999997505326666E-5) {
         return 0.0F;
      }

      float var2 = class_3532.method_16439(var1, this.field1234, this.field1219);
      if (var2 >= 0.3F) {
         return 0.0F;
      }

      float var3 = (float)Math.min(1.0, this.field1226);
      return method0481(var2 / 0.3F) * var3;
   }

   public float method2017(float var1) {
      if (this.field1226 < 9.999997505326666E-5) {
         return 0.0F;
      } else {
         float var2 = class_3532.method_16439(var1, this.field1234, this.field1219);
         if (!(var2 < 0.18F) && !(var2 >= 0.6F)) {
            float var3 = (var2 - 0.18F) / 0.42F;
            float var4 = (float)Math.min(1.0, this.field1226);
            return method0481(var3) * var4;
         } else {
            return 0.0F;
         }
      }
   }

   public float method2045(float var1) {
      if (this.field1226 < 9.999997505326666E-5) {
         return 0.0F;
      } else {
         float var2 = class_3532.method_16439(var1, this.field1234, this.field1219);
         if (!(var2 < 0.5F) && !(var2 >= 1.0F)) {
            float var3 = (var2 - 0.5F) / 0.5F;
            float var4 = (float)Math.min(1.0, this.field1226);
            return method0481(var3) * var4;
         } else {
            return 0.0F;
         }
      }
   }

   public class_243 method0473(float var1) {
      double var2 = Math.toRadians(this.field0177);
      double var4 = -Math.sin(var2);
      double var6 = Math.cos(var2);
      double var8 = 0.5890000077562889 * var1;
      double var10 = 0.3570000021536843 * var1;
      return new class_243(this.field0795.field_1352 + var4 * var8, this.field0795.field_1351 + var10, this.field0795.field_1350 + var6 * var8);
   }

   private static double method0617(double var0, double var2, double var4) {
      return var0 + (var2 - var0) * var4;
   }

   private static float method0681(float var0, float var1, float var2) {
      float var3 = class_3532.method_15393(var1 - var0);
      return var0 + var3 * var2;
   }

   public static class Segment {
      public double field0565 = 1.7999995474958326;
      public double field0002 = 3.5;
      public double field1409 = 0.18000002990478942;
      public double field0956 = 0.6000000191067264;
      public double field0757 = 14.0;
   }

   public enum MovementState {
      field0635,
      field0070,
      field1457,
      field0991,
      field0770,
      field1255,
      field0322,
      field0193,
      field0473,
      field1628,
      field1554;
   }
}
