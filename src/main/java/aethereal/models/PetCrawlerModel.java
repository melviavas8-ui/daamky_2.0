package aethereal;

import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_630;

public class PetCrawlerModel {
   private static final float field1614 = 0.48F;
   public final class_630 field0747;
   public final class_630 field0166;
   public final class_630 field1524;
   public final class_630 field1047;
   public final class_630 field0797;
   public final class_630 field1275;
   public final class_630 field0341;
   public final class_630 field0216;
   public final class_630 field0496;

   public PetCrawlerModel(class_630 var1) {
      this.field0747 = var1.method_32086("head");
      this.field0166 = var1.method_32086("torso");
      this.field1524 = var1.method_32086("left_arm");
      this.field1047 = var1.method_32086("right_arm");
      this.field0797 = var1.method_32086("left_leg");
      this.field1275 = var1.method_32086("right_leg");
      this.field0341 = this.field0747.method_32086("bottomjaw_r1");
      this.field0216 = this.field0747.method_32086("teeth").method_32086("bottomteeth");
      this.field0496 = this.field0747.method_32086("tounge");
   }

   public static class_5607 method0576() {
      class_5609 var0 = new class_5609();
      class_5610 var1 = var0.method_32111();
      class_5610 var2 = var1.method_32117("head", class_5606.method_32108(), class_5603.method_32090(0.0F, 15.0F, -4.0F));
      var2.method_32117(
         "bottomjaw_r1",
         class_5606.method_32108().method_32101(37, 28).method_32098(-3.0F, 0.0F, -5.0F, 6.0F, 1.0F, 5.0F, new class_5605(0.0F)),
         class_5603.method_32091(0.0F, 1.0F, -1.0F, 0.48F, 0.0F, 0.0F)
      );
      var2.method_32117(
         "topjaw_r1",
         class_5606.method_32108().method_32101(31, 0).method_32098(-3.0F, -4.0F, -6.0F, 6.0F, 4.0F, 6.0F, new class_5605(0.0F)),
         class_5603.method_32091(0.0F, 1.0F, -1.0F, -0.48F, 0.0F, 0.0F)
      );
      class_5610 var3 = var2.method_32117("teeth", class_5606.method_32108(), class_5603.method_32090(0.0F, 1.0F, -1.0F));
      class_5610 var4 = var3.method_32117("bottomteeth", class_5606.method_32108(), class_5603.method_32090(0.0F, 0.0F, 0.0F));
      var4.method_32117(
         "cube_r1",
         class_5606.method_32108()
            .method_32101(3, 12)
            .method_32098(-1.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new class_5605(0.0F))
            .method_32101(11, 12)
            .method_32098(-3.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new class_5605(0.0F))
            .method_32101(4, 4)
            .method_32098(1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 1.0F, new class_5605(0.0F)),
         class_5603.method_32091(0.0F, 0.0F, 0.0F, 0.48F, 0.0F, 0.0F)
      );
      class_5610 var5 = var3.method_32117("topteeth", class_5606.method_32108(), class_5603.method_32090(0.0F, 0.0F, 0.0F));
      var5.method_32117(
         "cube_r2",
         class_5606.method_32108()
            .method_32101(8, 11)
            .method_32098(1.0F, 0.0F, -6.0F, 1.0F, 1.0F, 1.0F, new class_5605(0.0F))
            .method_32101(7, 0)
            .method_32098(-2.0F, 0.0F, -6.0F, 1.0F, 2.0F, 1.0F, new class_5605(0.0F)),
         class_5603.method_32091(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.0F)
      );
      class_5610 var6 = var2.method_32117("rightcheek", class_5606.method_32108(), class_5603.method_32090(-3.0F, 3.0F, -4.0F));
      var6.method_32117(
         "cube_r3",
         class_5606.method_32108().method_32101(11, 0).method_32098(0.0F, -4.0053F, -0.5374F, 0.5F, 4.0F, 0.5F, new class_5605(0.0F)),
         class_5603.method_32091(0.0F, 0.0F, 0.0F, -0.3924F, 0.0167F, 0.0403F)
      );
      var6.method_32117(
         "cube_r4",
         class_5606.method_32108().method_32101(9, 5).method_32098(-3.0F, -4.0F, -4.0F, 0.5F, 6.0F, 0.5F, new class_5605(0.0F)),
         class_5603.method_32091(3.0F, -2.0F, 3.0F, 0.1308F, -0.0057F, 0.0433F)
      );
      class_5610 var7 = var2.method_32117("leftcheek", class_5606.method_32108(), class_5603.method_32090(3.0F, 3.0F, -4.0F));
      var7.method_32117(
         "cube_r5",
         class_5606.method_32108().method_32101(0, 7).method_32098(-0.5F, -5.0053F, -0.5374F, 0.5F, 5.0F, 0.5F, new class_5605(0.0F)),
         class_5603.method_32091(0.0F, 0.0F, 0.0F, -0.3957F, 0.1209F, -0.0503F)
      );
      var7.method_32117(
         "cube_r6",
         class_5606.method_32108().method_32101(5, 6).method_32098(2.5F, -4.5F, -4.0F, 0.5F, 6.0F, 0.5F, new class_5605(0.0F)),
         class_5603.method_32091(-3.0F, -2.0F, 3.0F, 0.218F, 0.0094F, -0.0426F)
      );
      class_5610 var8 = var2.method_32117("tounge", class_5606.method_32108(), class_5603.method_32090(0.0F, 2.0F, -8.0F));
      var8.method_32117(
         "cube_r7",
         class_5606.method_32108().method_32101(0, 4).method_32098(-0.4F, 0.0307F, -2.0984F, 1.0F, 0.5F, 2.2F, new class_5605(0.0F)),
         class_5603.method_32091(0.0F, 0.0F, 0.0F, 0.6988F, 0.0859F, 0.0152F)
      );
      var8.method_32117(
         "cube_r8",
         class_5606.method_32108().method_32101(0, 0).method_32098(-0.5F, -0.6166F, -2.3061F, 1.5F, 0.5F, 3.0F, new class_5605(0.0F)),
         class_5603.method_32091(-1.0F, 0.0F, 2.0F, 0.3917F, -0.3564F, -0.151F)
      );
      var8.method_32117(
         "cube_r9",
         class_5606.method_32108().method_32101(46, 10).method_32098(-1.0F, -0.5F, -5.0F, 2.0F, 0.5F, 6.0F, new class_5605(0.0F)),
         class_5603.method_32091(0.0F, -1.0F, 7.0F, 0.1772F, 0.1719F, 0.0306F)
      );
      class_5610 var9 = var1.method_32117("torso", class_5606.method_32108(), class_5603.method_32090(0.0F, 19.0F, 2.0F));
      var9.method_32117(
         "cube_r10",
         class_5606.method_32108()
            .method_32101(0, 0)
            .method_32098(-4.0F, -4.0F, -7.0F, 8.0F, 3.0F, 15.0F, new class_5605(0.0F))
            .method_32101(30, 18)
            .method_32098(-4.0F, -5.0F, -7.0F, 8.0F, 1.0F, 7.0F, new class_5605(0.0F)),
         class_5603.method_32091(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F)
      );
      class_5610 var10 = var1.method_32117("left_arm", class_5606.method_32108(), class_5603.method_32090(4.0F, 16.0F, -3.0F));
      var10.method_32117(
         "cube_r11",
         class_5606.method_32108().method_32101(37, 36).method_32098(3.0F, -1.0F, -5.0F, 2.0F, 2.0F, 7.0F, new class_5605(0.0F)),
         class_5603.method_32091(0.0F, 3.0F, -1.0F, 0.897F, 0.3093F, 0.4295F)
      );
      var10.method_32117(
         "cube_r12",
         class_5606.method_32108().method_32101(0, 41).method_32098(0.0F, -2.0F, -3.0F, 3.0F, 3.0F, 6.0F, new class_5605(0.0F)),
         class_5603.method_32091(0.0F, 3.0F, -1.0F, 0.9964F, -0.3332F, -0.468F)
      );
      class_5610 var11 = var1.method_32117("right_arm", class_5606.method_32108(), class_5603.method_32090(-4.0F, 16.0F, -3.0F));
      var11.method_32117(
         "cube_r13",
         class_5606.method_32108().method_32101(11, 43).method_32098(-5.0F, -1.0F, -5.0F, 2.0F, 2.0F, 7.0F, new class_5605(0.0F)),
         class_5603.method_32091(0.0F, 3.0F, -1.0F, 0.897F, -0.3093F, -0.4295F)
      );
      var11.method_32117(
         "cube_r14",
         class_5606.method_32108().method_32101(29, 45).method_32098(-3.0F, -2.0F, -3.0F, 3.0F, 3.0F, 6.0F, new class_5605(0.0F)),
         class_5603.method_32091(0.0F, 3.0F, -1.0F, 0.9964F, 0.3332F, 0.468F)
      );
      class_5610 var12 = var1.method_32117("left_leg", class_5606.method_32108(), class_5603.method_32090(4.0F, 17.0F, 10.0F));
      var12.method_32117(
         "cube_r15",
         class_5606.method_32108().method_32101(15, 20).method_32098(4.25F, 3.0F, -3.0F, 2.0F, 2.0F, 11.0F, new class_5605(0.0F)),
         class_5603.method_32091(-4.0F, 2.0F, -1.0F, -0.3491F, 0.0F, -0.3491F)
      );
      var12.method_32117(
         "cube_r16",
         class_5606.method_32108().method_32101(22, 33).method_32098(-0.5F, -1.7934F, -2.3912F, 3.5F, 3.0F, 7.0F, new class_5605(0.0F)),
         class_5603.method_32091(0.0F, 1.0F, -1.0F, -2.4871F, 0.0F, -0.3491F)
      );
      class_5610 var13 = var1.method_32117("right_leg", class_5606.method_32108(), class_5603.method_32090(-4.0F, 17.0F, 9.0F));
      var13.method_32117(
         "cube_r17",
         class_5606.method_32108().method_32101(0, 18).method_32098(-6.25F, 3.0F, -3.0F, 2.0F, 2.0F, 11.0F, new class_5605(0.0F)),
         class_5603.method_32091(4.0F, 2.0F, 0.0F, -0.3491F, 0.0F, 0.3491F)
      );
      var13.method_32117(
         "cube_r18",
         class_5606.method_32108().method_32101(0, 31).method_32098(-3.0F, -1.7934F, -2.3912F, 3.5F, 3.0F, 7.0F, new class_5605(0.0F)),
         class_5603.method_32091(0.0F, 1.0F, 0.0F, -2.4871F, 0.0F, 0.3491F)
      );
      return class_5607.method_32110(var0, 64, 64);
   }

   public void method1514(class_4587 var1, class_4588 var2, int var3, int var4, int var5) {
      this.field0747.method_22699(var1, var2, var3, var4, var5);
      this.field0166.method_22699(var1, var2, var3, var4, var5);
      this.field1524.method_22699(var1, var2, var3, var4, var5);
      this.field1047.method_22699(var1, var2, var3, var4, var5);
      this.field0797.method_22699(var1, var2, var3, var4, var5);
      this.field1275.method_22699(var1, var2, var3, var4, var5);
   }

   public void method0692(float var1, float var2, float var3, float var4, float var5, float var6, PetCrawlerModel.ModelPart var7) {
      float var8 = Math.max(
         var7.field0566,
         Math.max(
            var7.field0003,
            Math.max(var7.field1410, Math.max(var7.field0957, Math.max(var7.field0758, Math.max(var7.field1242, Math.max(var7.field0314, var7.field0177)))))
         )
      );
      float var9 = Math.max(var7.field1614, Math.max(var7.field1538, var7.field1704));
      var8 = Math.max(var8, var9);
      float var10 = 1.0F - var8 * 0.85F;
      this.field0747.field_3675 = var3 * (float) (Math.PI / 180.0);
      this.field0747.field_3654 = var4 * (float) (Math.PI / 180.0);
      this.field0747.field_3674 = 0.0F;
      this.field0747.field_3654 = this.field0747.field_3654 + class_3532.method_15362(var1 * 2.0F + 1.0F) * var2 * 0.05F * var10;
      this.field0747.field_3654 = this.field0747.field_3654 + class_3532.method_15374(var6 * 0.4F) * (1.0F - var2) * 0.025F * (1.0F - var8);
      this.field0747.field_3654 = this.field0747.field_3654 + -0.4F * var7.field0566;
      this.field0747.field_3654 = this.field0747.field_3654 + 0.45F * var7.field0003;
      this.field0747.field_3654 = this.field0747.field_3654 + class_3532.method_15374(var7.field0458 * 2.0F) * 0.3F * var7.field1410;
      this.field0747.field_3674 = this.field0747.field_3674 + class_3532.method_15362(var7.field0458 * 1.5F) * 0.3F * var7.field1410;
      this.field0747.field_3654 = this.field0747.field_3654 + 0.35F * var7.field0957;
      this.field0747.field_3674 = this.field0747.field_3674 + class_3532.method_15374(var7.field0458 * 0.8F) * 0.2F * var7.field0957;
      this.field0747.field_3654 = this.field0747.field_3654 + -0.3F * var7.field0758;
      float var11 = class_3532.method_15374(var7.field0458 * 1.6F) * 0.65F * var7.field1242;
      this.field0747.field_3675 += var11;
      this.field0747.field_3654 = this.field0747.field_3654 + (0.55F * var7.field1242 + class_3532.method_15362(var7.field0458 * 1.6F) * 0.2F * var7.field1242);
      this.field0747.field_3674 = this.field0747.field_3674 + class_3532.method_15374(var7.field0458 * 1.6F + 0.5F) * 0.35F * var7.field1242;
      float var12 = var5;
      var12 = Math.max(var12, var7.field0003);
      var12 = Math.max(var12, var7.field1410);
      var12 = Math.max(var12, 0.85F * var7.field0957);
      var12 = Math.max(var12, var7.field1242);
      var12 = Math.max(var12, 0.25F * var7.field0566);
      float var13 = class_3532.method_15363(var12, 0.0F, 1.0F);
      float var14 = 0.2F * var7.field1242;
      this.field0341.field_3654 = 0.48F + var13 * 0.65F + var14;
      this.field0216.field_3654 = var13 * 0.35F + var14 * 0.5F;
      this.field0496.field_3654 = var13 * 0.25F + class_3532.method_15374(var6 * 0.6F) * 0.05F * var13;
      float var15 = class_3532.method_15362(var1) * var2 * var10;
      this.field1047.field_3654 = var15 * 1.15F;
      this.field1524.field_3654 = var15 * -1.15F;
      this.field0797.field_3654 = var15 * -1.0F;
      this.field1275.field_3654 = var15 * 1.0F;
      float var16 = class_3532.method_15374(var1 * 2.0F) * var2 * 0.18F * var10;
      this.field1524.field_3675 = var16;
      this.field1047.field_3675 = -var16;
      this.field0797.field_3675 = -var16 * 0.5F;
      this.field1275.field_3675 = var16 * 0.5F;
      float var17 = class_3532.method_15374(var1) * var2 * 0.12F * var10;
      this.field1524.field_3674 = var17;
      this.field1047.field_3674 = -var17;
      this.field1524.field_3654 = this.field1524.field_3654 + 0.55F * var7.field0566;
      this.field1047.field_3654 = this.field1047.field_3654 + 0.55F * var7.field0566;
      this.field1524.field_3674 = this.field1524.field_3674 + 0.25F * var7.field0566;
      this.field1047.field_3674 = this.field1047.field_3674 + -0.25F * var7.field0566;
      this.field0797.field_3654 = this.field0797.field_3654 + -0.45F * var7.field0566;
      this.field1275.field_3654 = this.field1275.field_3654 + -0.45F * var7.field0566;
      this.field1524.field_3654 = this.field1524.field_3654 + -1.55F * var7.field0003;
      this.field1047.field_3654 = this.field1047.field_3654 + -1.55F * var7.field0003;
      this.field1524.field_3675 = this.field1524.field_3675 + 0.2F * var7.field0003;
      this.field1047.field_3675 = this.field1047.field_3675 + -0.2F * var7.field0003;
      this.field0797.field_3654 = this.field0797.field_3654 + 0.65F * var7.field0003;
      this.field1275.field_3654 = this.field1275.field_3654 + 0.65F * var7.field0003;
      float var18 = class_3532.method_15374(var7.field0458 * 4.0F) * var7.field1410;
      this.field1524.field_3654 = this.field1524.field_3654 + (-1.3F * var7.field1410 + var18 * 0.4F);
      this.field1047.field_3654 = this.field1047.field_3654 + (-1.3F * var7.field1410 - var18 * 0.4F);
      this.field1524.field_3675 = this.field1524.field_3675 + 0.4F * var7.field1410;
      this.field1047.field_3675 = this.field1047.field_3675 + -0.4F * var7.field1410;
      this.field0797.field_3654 = this.field0797.field_3654
         + (-0.35F * var7.field1410 + class_3532.method_15374(var7.field0458 * 6.0F + 1.0F) * 0.55F * var7.field1410);
      this.field1275.field_3654 = this.field1275.field_3654
         + (-0.35F * var7.field1410 + class_3532.method_15362(var7.field0458 * 5.5F + 0.5F) * 0.55F * var7.field1410);
      this.field0797.field_3675 = this.field0797.field_3675
         + (-0.25F * var7.field1410 + class_3532.method_15374(var7.field0458 * 7.0F) * 0.25F * var7.field1410);
      this.field1275.field_3675 = this.field1275.field_3675
         + (0.25F * var7.field1410 - class_3532.method_15374(var7.field0458 * 7.0F) * 0.25F * var7.field1410);
      this.field0797.field_3674 = this.field0797.field_3674 + class_3532.method_15362(var7.field0458 * 4.5F) * 0.3F * var7.field1410;
      this.field1275.field_3674 = this.field1275.field_3674 + -class_3532.method_15362(var7.field0458 * 4.5F) * 0.3F * var7.field1410;
      float var19 = var7.field0458 * 1.2F;
      this.field0797.field_3654 = this.field0797.field_3654
         + (-0.6F * var7.field0957 + class_3532.method_15374(var19 + (float) Math.PI) * 0.55F * var7.field0957);
      this.field1275.field_3654 = this.field1275.field_3654 + (-0.6F * var7.field0957 + class_3532.method_15374(var19) * 0.55F * var7.field0957);
      this.field0797.field_3675 = this.field0797.field_3675 + (-0.2F * var7.field0957 + class_3532.method_15362(var19) * 0.18F * var7.field0957);
      this.field1275.field_3675 = this.field1275.field_3675 + (0.2F * var7.field0957 - class_3532.method_15362(var19) * 0.18F * var7.field0957);
      this.field0797.field_3674 = this.field0797.field_3674 + class_3532.method_15374(var19 * 0.5F) * 0.2F * var7.field0957;
      this.field1275.field_3674 = this.field1275.field_3674 + -class_3532.method_15374(var19 * 0.5F) * 0.2F * var7.field0957;
      float var20 = class_3532.method_15374(var7.field0458 * 1.2F) * 1.1F * var7.field0957;
      float var21 = class_3532.method_15374(var7.field0458 * 1.2F + (float) Math.PI) * 1.1F * var7.field0957;
      this.field1524.field_3654 = this.field1524.field_3654 + (-1.3F * var7.field0957 + var20);
      this.field1047.field_3654 = this.field1047.field_3654 + (-1.3F * var7.field0957 + var21);
      this.field1524.field_3674 = this.field1524.field_3674 + class_3532.method_15362(var7.field0458 * 1.2F) * 0.4F * var7.field0957;
      this.field1047.field_3674 = this.field1047.field_3674 + -class_3532.method_15362(var7.field0458 * 1.2F) * 0.4F * var7.field0957;
      float var22 = var7.field0458 * 1.5F;
      this.field1524.field_3654 = this.field1524.field_3654 + (-2.0F * var7.field0758 + class_3532.method_15374(var22) * 0.35F * var7.field0758);
      this.field1047.field_3654 = this.field1047.field_3654
         + (-2.0F * var7.field0758 + class_3532.method_15374(var22 + (float) Math.PI) * 0.35F * var7.field0758);
      this.field0797.field_3654 = this.field0797.field_3654
         + (-1.0F * var7.field0758 + class_3532.method_15374(var22 + (float) Math.PI) * 0.4F * var7.field0758);
      this.field1275.field_3654 = this.field1275.field_3654 + (-1.0F * var7.field0758 + class_3532.method_15374(var22) * 0.4F * var7.field0758);
      this.field1524.field_3654 = this.field1524.field_3654 + -1.6F * var7.field1242;
      this.field1047.field_3654 = this.field1047.field_3654 + -1.6F * var7.field1242;
      this.field1524.field_3675 = this.field1524.field_3675 + (0.45F * var7.field1242 + class_3532.method_15374(var7.field0458 * 1.6F) * 0.3F * var7.field1242);
      this.field1047.field_3675 = this.field1047.field_3675
         + (-0.45F * var7.field1242 - class_3532.method_15374(var7.field0458 * 1.6F) * 0.3F * var7.field1242);
      float var23 = var7.field0458 * 1.6F;
      this.field0797.field_3654 = this.field0797.field_3654 + (-0.5F * var7.field1242 + class_3532.method_15374(var23) * 0.35F * var7.field1242);
      this.field1275.field_3654 = this.field1275.field_3654 + (-0.5F * var7.field1242 - class_3532.method_15374(var23) * 0.35F * var7.field1242);
      this.field0797.field_3675 = this.field0797.field_3675 + (-0.35F * var7.field1242 + class_3532.method_15362(var23) * 0.2F * var7.field1242);
      this.field1275.field_3675 = this.field1275.field_3675 + (0.35F * var7.field1242 - class_3532.method_15362(var23) * 0.2F * var7.field1242);
      this.field0797.field_3674 = this.field0797.field_3674 + class_3532.method_15374(var23 + (float) Math.PI) * 0.3F * var7.field1242;
      this.field1275.field_3674 = this.field1275.field_3674 + -class_3532.method_15374(var23 + (float) Math.PI) * 0.3F * var7.field1242;
      this.field0166.field_3654 = class_3532.method_15362(var1 * 2.0F) * var2 * 0.07F * var10;
      this.field0166.field_3674 = class_3532.method_15374(var1) * var2 * 0.06F * var10;
      this.field0166.field_3675 = 0.0F;
      this.field0166.field_3654 = this.field0166.field_3654 + class_3532.method_15374(var6 * 0.25F) * (1.0F - var2) * 0.04F * (1.0F - var8);
      this.field0166.field_3654 = this.field0166.field_3654 + -0.18F * var7.field0566;
      this.field0166.field_3654 = this.field0166.field_3654 + 0.45F * var7.field0003;
      this.field0166.field_3654 = this.field0166.field_3654 + class_3532.method_15374(var7.field0458 * 5.0F) * 0.3F * var7.field1410;
      this.field0166.field_3674 = this.field0166.field_3674 + class_3532.method_15362(var7.field0458 * 4.0F) * 0.35F * var7.field1410;
      this.field0166.field_3654 = this.field0166.field_3654 + -0.95F * var7.field0957;
      this.field0166.field_3674 = this.field0166.field_3674 + class_3532.method_15374(var7.field0458 * 0.6F) * 0.18F * var7.field0957;
      this.field0166.field_3654 = this.field0166.field_3654 + -1.15F * var7.field0758;
      float var24 = -var11 * 0.6F;
      this.field0166.field_3675 += var24;
      this.field0166.field_3654 = this.field0166.field_3654
         + (-0.4F * var7.field1242 + class_3532.method_15362(var7.field0458 * 1.6F) * 0.15F * var7.field1242);
      this.field0166.field_3674 = this.field0166.field_3674 + class_3532.method_15374(var7.field0458 * 1.6F + (float) Math.PI) * 0.3F * var7.field1242;
      this.field0797.field_3654 = this.field0797.field_3654 + 0.85F * var7.field1614;
      this.field1275.field_3654 = this.field1275.field_3654 + 0.85F * var7.field1614;
      this.field1524.field_3654 = this.field1524.field_3654 + 0.45F * var7.field1614;
      this.field1047.field_3654 = this.field1047.field_3654 + 0.45F * var7.field1614;
      this.field0166.field_3654 = this.field0166.field_3654 + -0.18F * var7.field1614;
      this.field0747.field_3654 = this.field0747.field_3654 + -0.3F * var7.field1614;
      this.field0797.field_3654 = this.field0797.field_3654 + -0.85F * var7.field1538;
      this.field1275.field_3654 = this.field1275.field_3654 + -0.85F * var7.field1538;
      this.field1524.field_3654 = this.field1524.field_3654 + -1.6F * var7.field1538;
      this.field1047.field_3654 = this.field1047.field_3654 + -1.6F * var7.field1538;
      this.field1524.field_3675 = this.field1524.field_3675 + 0.15F * var7.field1538;
      this.field1047.field_3675 = this.field1047.field_3675 + -0.15F * var7.field1538;
      this.field0166.field_3654 = this.field0166.field_3654 + 0.15F * var7.field1538;
      this.field0747.field_3654 = this.field0747.field_3654 + -0.15F * var7.field1538;
      this.field0797.field_3654 = this.field0797.field_3654 + 0.35F * var7.field1704;
      this.field1275.field_3654 = this.field1275.field_3654 + 0.35F * var7.field1704;
      this.field1524.field_3654 = this.field1524.field_3654 + -0.45F * var7.field1704;
      this.field1047.field_3654 = this.field1047.field_3654 + -0.45F * var7.field1704;
      this.field0166.field_3654 = this.field0166.field_3654 + 0.08F * var7.field1704;
      this.field1524.field_3654 = this.field1524.field_3654 + 0.85F * var7.field0177;
      this.field1047.field_3654 = this.field1047.field_3654 + 0.85F * var7.field0177;
      this.field1524.field_3675 = this.field1524.field_3675 + 0.25F * var7.field0177;
      this.field1047.field_3675 = this.field1047.field_3675 + -0.25F * var7.field0177;
      this.field0797.field_3654 = this.field0797.field_3654 + -0.55F * var7.field0177;
      this.field1275.field_3654 = this.field1275.field_3654 + -0.55F * var7.field0177;
      this.field0797.field_3675 = this.field0797.field_3675 + -0.2F * var7.field0177;
      this.field1275.field_3675 = this.field1275.field_3675 + 0.2F * var7.field0177;
      this.field0166.field_3654 = this.field0166.field_3654 + -0.05F * var7.field0177;
      this.field0166.field_3674 = this.field0166.field_3674 + -0.35F * var7.field0177;
      this.field0747.field_3654 = this.field0747.field_3654 + 0.18F * var7.field0177;
      this.field0747.field_3675 = this.field0747.field_3675 + class_3532.method_15374(var6 * 0.04F) * 0.5F * var7.field0177;
      this.field0166.field_3654 = this.field0166.field_3654 + class_3532.method_15374(var6 * 0.18F) * 0.04F * var7.field0177;
   }

   public static class ModelPart {
      public float field0566;
      public float field0003;
      public float field1410;
      public float field0957;
      public float field0758;
      public float field1242;
      public float field0314;
      public float field0177;
      public float field0458;
      public float field1614;
      public float field1538;
      public float field1704;
   }
}
