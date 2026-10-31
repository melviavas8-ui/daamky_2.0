package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10142;
import net.minecraft.class_1294;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;

public class GappleIndicator extends Module {
   private static final class_2960 field0160 = DaamkyClient.method1012("textures/glow.png");
   private static final int field1411 = 255;
   private static final int field0958 = 215;
   private static final int field0178 = 0;
   private final List<GappleIndicator.IndicatorState> field0488 = new ArrayList<>();
   private final Random field1646 = new Random();
   private final Set<Integer> field1567 = new HashSet<>();

   public GappleIndicator() {
      super("GappleIndicator", ModuleCategory.field1004, "Shows healing cross particles when players eat golden apples");
      this.method1013("Показывает частицы при поедании золотых яблок");
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field0488.clear();
      this.field1567.clear();
   }

   @Override
   public void method2078() {
      super.method2078();
      this.field0488.clear();
      this.field1567.clear();
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         for (class_1657 var3 : field0796.field_1687.method_18456()) {
            if (var3 != field0796.field_1724 || !field0796.field_1690.method_31044().method_31034()) {
               boolean var4 = var3.method_6059(class_1294.field_5924);
               if (var4) {
                  this.field1567.add(var3.method_5628());
                  int var5 = 1 + this.field1646.nextInt(2);

                  for (int var6 = 0; var6 < var5; var6++) {
                     this.method1182(var3);
                  }
               } else {
                  this.field1567.remove(var3.method_5628());
               }
            }
         }

         Iterator var7 = this.field0488.iterator();

         while (var7.hasNext()) {
            GappleIndicator.IndicatorState var8 = var7.next();
            var8.field0956 = var8.field0565;
            var8.field0757 = var8.field0002;
            var8.field1241 = var8.field1409;
            var8.field0565 = var8.field0565 + var8.field0313;
            var8.field0002 = var8.field0002 + var8.field0176;
            var8.field1409 = var8.field1409 + var8.field0457;
            var8.field0176 += 0.001999998866807356;
            var8.field0313 *= 0.9600000169531109;
            var8.field0457 *= 0.9600000169531109;
            var8.field1615++;
            if (var8.field1615 >= var8.field1539) {
               var7.remove();
            }
         }
      }
   }

   private void method1182(class_1657 var1) {
      double var2 = var1.method_23317() + (this.field1646.nextDouble() - 0.5) * 0.7999999428167943;
      double var4 = var1.method_23318() + 0.5 + this.field1646.nextDouble() * 1.2000001196168377;
      double var6 = var1.method_23321() + (this.field1646.nextDouble() - 0.5) * 0.7999999428167943;
      double var8 = (this.field1646.nextDouble() - 0.5) * 0.04000001724767218;
      double var10 = 0.020000001006107267 + this.field1646.nextDouble() * 0.04000001724767218;
      double var12 = (this.field1646.nextDouble() - 0.5) * 0.04000001724767218;
      int var14 = 20 + this.field1646.nextInt(25);
      float var15 = 0.07F + this.field1646.nextFloat() * 0.08F;
      float var16 = this.field1646.nextFloat() * 360.0F;
      this.field0488.add(new GappleIndicator.IndicatorState(var2, var4, var6, var8, var10, var12, var14, var15, var16));
   }

   @EventHandler
   public void onRenderWorld(GlowRenderEvent var1) {
      if (!method1974() && !this.field0488.isEmpty()) {
         class_243 var2 = field0796.field_1773.method_19418().method_19326();
         float var3 = var1.method1603();
         Matrix4f var4 = new Matrix4f();
         RenderSystem.enableBlend();
         RenderSystem.blendFunc(770, 1);
         RenderSystem.enableDepthTest();
         RenderSystem.depthMask(false);
         RenderSystem.disableCull();
         RenderSystem.setShader(class_10142.field_53876);
         class_287 var5 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1576);
         boolean var6 = false;

         for (GappleIndicator.IndicatorState var8 : this.field0488) {
            float var9 = 1.0F - (float)var8.field1615 / var8.field1539;
            if (!(var9 <= 0.0F)) {
               float var10 = var9 < 0.4F ? var9 / 0.4F : 1.0F;
               int var11 = (int)(var10 * 160.0F);
               int var12 = var11 << 24 | 0xFF0000 | 55040 | 0;
               float var13 = (float)(method0625(var8.field0956, var8.field0565, var3) - var2.field_1352);
               float var14 = (float)(method0625(var8.field0757, var8.field0002, var3) - var2.field_1351);
               float var15 = (float)(method0625(var8.field1241, var8.field1409, var3) - var2.field_1350);
               float var16 = var8.field1704 * (0.7F + 0.3F * var9);
               float var17 = var16 * 0.3F;
               float var18 = (float)(var8.field0565 - var2.field_1352);
               float var19 = (float)(var8.field1409 - var2.field_1350);
               double var20 = Math.sqrt(var18 * var18 + var19 * var19);
               float var22;
               float var23;
               if (var20 > 0.0010000000441768861) {
                  var22 = (float)(-var19 / var20);
                  var23 = (float)(var18 / var20);
               } else {
                  var22 = 1.0F;
                  var23 = 0.0F;
               }

               var5.method_22918(var4, var13 - var22 * var17, var14 - var16, var15 - var23 * var17).method_39415(var12);
               var5.method_22918(var4, var13 + var22 * var17, var14 - var16, var15 + var23 * var17).method_39415(var12);
               var5.method_22918(var4, var13 + var22 * var17, var14 + var16, var15 + var23 * var17).method_39415(var12);
               var5.method_22918(var4, var13 - var22 * var17, var14 + var16, var15 - var23 * var17).method_39415(var12);
               float var24 = var16 * 0.75F;
               var5.method_22918(var4, var13 - var22 * var24, var14 - var17, var15 - var23 * var24).method_39415(var12);
               var5.method_22918(var4, var13 + var22 * var24, var14 - var17, var15 + var23 * var24).method_39415(var12);
               var5.method_22918(var4, var13 + var22 * var24, var14 + var17, var15 + var23 * var24).method_39415(var12);
               var5.method_22918(var4, var13 - var22 * var24, var14 + var17, var15 - var23 * var24).method_39415(var12);
               var6 = true;
            }
         }

         if (var6) {
            class_286.method_43433(var5.method_60800());
         }

         RenderSystem.enableCull();
         RenderSystem.setShaderTexture(0, field0160);
         RenderSystem.setShader(class_10142.field_53880);
         class_287 var25 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1575);
         boolean var26 = false;

         for (GappleIndicator.IndicatorState var28 : this.field0488) {
            float var29 = 1.0F - (float)var28.field1615 / var28.field1539;
            if (!(var29 <= 0.0F)) {
               float var30 = var29 < 0.4F ? var29 / 0.4F : 1.0F;
               int var31 = (int)(var30 * 50.0F);
               int var32 = var31 << 24 | 0xFF0000 | 55040 | 0;
               float var33 = (float)(method0625(var28.field0956, var28.field0565, var3) - var2.field_1352);
               float var34 = (float)(method0625(var28.field0757, var28.field0002, var3) - var2.field_1351);
               float var35 = (float)(method0625(var28.field1241, var28.field1409, var3) - var2.field_1350);
               float var36 = var28.field1704 * 3.0F * (0.5F + 0.5F * var29);
               float var37 = (float)(var28.field0565 - var2.field_1352);
               float var38 = (float)(var28.field1409 - var2.field_1350);
               double var21 = Math.sqrt(var37 * var37 + var38 * var38);
               float var39;
               float var40;
               if (var21 > 0.0010000000441768861) {
                  var39 = (float)(-var38 / var21);
                  var40 = (float)(var37 / var21);
               } else {
                  var39 = 1.0F;
                  var40 = 0.0F;
               }

               var25.method_22918(var4, var33 - var39 * var36, var34 - var36, var35 - var40 * var36).method_22913(0.0F, 0.0F).method_39415(var32);
               var25.method_22918(var4, var33 + var39 * var36, var34 - var36, var35 + var40 * var36).method_22913(1.0F, 0.0F).method_39415(var32);
               var25.method_22918(var4, var33 + var39 * var36, var34 + var36, var35 + var40 * var36).method_22913(1.0F, 1.0F).method_39415(var32);
               var25.method_22918(var4, var33 - var39 * var36, var34 + var36, var35 - var40 * var36).method_22913(0.0F, 1.0F).method_39415(var32);
               var26 = true;
            }
         }

         if (var26) {
            class_286.method_43433(var25.method_60800());
         }

         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.depthMask(true);
         RenderSystem.disableBlend();
         RenderSystem.blendFunc(770, 771);
      }
   }

   private static double method0625(double var0, double var2, float var4) {
      return var0 + (var2 - var0) * var4;
   }

   private static class IndicatorState {
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
      float field1704;
      float field1136;

      IndicatorState(double var1, double var3, double var5, double var7, double var9, double var11, int var13, float var14, float var15) {
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
         this.field1704 = var14;
         this.field1136 = var15;
      }
   }
}
