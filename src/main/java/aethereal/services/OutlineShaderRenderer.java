package aethereal;

import com.mojang.blaze3d.platform.GlStateManager.class_4534;
import com.mojang.blaze3d.platform.GlStateManager.class_4535;
import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import lombok.Generated;
import net.minecraft.class_1921;
import net.minecraft.class_276;
import net.minecraft.class_279;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4668;
import net.minecraft.class_4720;
import net.minecraft.class_5944;
import net.minecraft.class_6367;
import net.minecraft.class_9799;
import net.minecraft.class_9960;
import net.minecraft.class_1921.class_4687;
import net.minecraft.class_1921.class_4688;
import net.minecraft.class_1921.class_4750;
import net.minecraft.class_293.class_5596;
import net.minecraft.class_4668.class_4678;
import net.minecraft.class_4668.class_5939;
import ua.patch.daamky.api.mixins.accessors.GameRendererAccessor;
import ua.patch.daamky.api.mixins.accessors.PostEffectProcessorAccessor;
import ua.patch.daamky.api.mixins.accessors.RenderLayerMultiPhaseAccessor;
import ua.patch.daamky.api.mixins.accessors.RenderLayerMultiPhaseParametersAccessor;
import ua.patch.daamky.api.mixins.accessors.RenderPhaseTextureBaseAccessor;

public class OutlineShaderRenderer implements MinecraftAccess {
   private final ColoredVertexConsumerProvider field0650 = new ColoredVertexConsumerProvider(class_4597.method_22991(new class_9799(256)));
   private class_276 field0159;
   private class_4678 field1523;
   private Function<class_5939, class_1921> field1035;
   private boolean field0219 = false;
   private class_279 field0495;
   private class_279 field1649;
   private class_279 field1571;
   private final int field1705;

   public OutlineShaderRenderer() {
      this(1);
   }

   public OutlineShaderRenderer(int var1) {
      this.field1705 = Math.max(1, var1);
      ShaderCache.method0550().method0811(this);
   }

   private void method2266() {
      if (!this.field0219 && field0796.method_22683() != null) {
         int var1 = Math.max(1, field0796.method_22683().method_4489() / this.field1705);
         int var2 = Math.max(1, field0796.method_22683().method_4506() / this.field1705);
         this.field0159 = new class_6367(var1, var2, true);
         this.field0159.method_1236(0.0F, 0.0F, 0.0F, 0.0F);
         this.field1523 = new class_4678("shader_target", () -> this.field0159.method_1235(true), () -> field0796.method_1522().method_1235(true));
         this.field1035 = this.method1101(
            var1x -> class_1921.method_24048(
               "sydney_overlay",
               class_290.field_1575,
               class_5596.field_27382,
               1536,
               class_4688.method_23598()
                  .method_34578(class_4668.field_29418)
                  .method_34577(var1x)
                  .method_23604(class_4668.field_21346)
                  .method_23610(this.field1523)
                  .method_24297(class_4750.field_21854)
            )
         );
         this.field0219 = true;
      }
   }

   public void method0578() {
      this.method2266();
      if (this.field0219) {
         this.field0159.method_1236(0.0F, 0.0F, 0.0F, 0.0F);
         this.field0159.method_1230();
         field0796.method_1522().method_1235(true);
      }
   }

   public void method0764(
      int var1,
      Color var2,
      boolean var3,
      boolean var4,
      float var5,
      float var6,
      float var7,
      Color var8,
      boolean var9,
      float var10,
      float var11,
      float var12,
      Color var13,
      boolean var14,
      float var15,
      float var16,
      Color var17
   ) {
      this.method2266();
      if (this.field0219) {
         try {
            if (this.field0495 == null) {
               this.field0495 = field0796.method_62887().method_62941(class_2960.method_60655("daamky", "outline"), class_9960.field_53902);
            }

            class_279 var18 = this.field0495;
            if (var18 == null) {
               System.err.println("Shader is null!");
               return;
            }

            class_5944 var19 = ((PostEffectProcessorAccessor)var18).getPasses().getFirst().method_62922();
            if (var19 == null) {
               System.err.println("Program is null!");
               return;
            }

            var19.method_62899("DiffuseSampler", this.field0159.method_30277());
            var19.method_34582("RenderMode").method_35649(var1);
            var19.method_34582("MainColor").method_35657(var2.getRed() / 255.0F, var2.getGreen() / 255.0F, var2.getBlue() / 255.0F, var2.getAlpha() / 255.0F);
            var19.method_34582("GlintEnabled").method_1251(var4 ? 1.0F : 0.0F);
            var19.method_34582("GlintSpeed").method_1251(var5);
            var19.method_34582("GlintWidth").method_1251(var6);
            var19.method_34582("GlintGrad").method_1251(var7);
            var19.method_34582("GlintColor").method_35657(var8.getRed() / 255.0F, var8.getGreen() / 255.0F, var8.getBlue() / 255.0F, var8.getAlpha() / 255.0F);
            var19.method_34582("NoiseEnabled").method_1251(var9 ? 1.0F : 0.0F);
            var19.method_34582("NoiseSpeed").method_1251(var10);
            var19.method_34582("NoiseAngle").method_1251(var11);
            var19.method_34582("NoiseScale").method_1251(var12);
            var19.method_34582("NoiseColor")
               .method_35657(var13.getRed() / 255.0F, var13.getGreen() / 255.0F, var13.getBlue() / 255.0F, var13.getAlpha() / 255.0F);
            var19.method_34582("CircuitEnabled").method_1251(var14 ? 1.0F : 0.0F);
            var19.method_34582("CircuitSpeed").method_1251(var15);
            var19.method_34582("CircuitIntensity").method_1251(var16);
            var19.method_34582("CircuitColor")
               .method_35657(var17.getRed() / 255.0F, var17.getGreen() / 255.0F, var17.getBlue() / 255.0F, var17.getAlpha() / 255.0F);
            var19.method_34582("Time").method_1251((float)(System.currentTimeMillis() % 100000L) / 1000.0F);
            var18.method_1258(this.field0159, ((GameRendererAccessor)field0796.field_1773).getPool());
            field0796.method_1522().method_1235(true);
            RenderSystem.enableBlend();
            if (var3) {
               RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE);
            } else {
               RenderSystem.blendFuncSeparate(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA, class_4535.ZERO, class_4534.ONE);
            }

            this.field0159.method_1233(field0796.method_22683().method_4489(), field0796.method_22683().method_4506());
            RenderSystem.disableBlend();
         } catch (Exception var20) {
            System.err.println("Error rendering shader: " + var20.getMessage());
            var20.printStackTrace();
            this.field0495 = null;
         }
      }
   }

   public void method0735(int var1, float var2, int var3, float var4, float var5, float var6, int var7) {
      this.method2266();
      if (this.field0219) {
         try {
            if (this.field1649 == null) {
               this.field1649 = field0796.method_62887().method_62941(class_2960.method_60655("daamky", "itemchams_solid"), class_9960.field_53902);
            }

            class_279 var8 = this.field1649;
            if (var8 == null) {
               return;
            }

            class_5944 var9 = ((PostEffectProcessorAccessor)var8).getPasses().getFirst().method_62922();
            if (var9 == null) {
               return;
            }

            var9.method_62899("DiffuseSampler", this.field0159.method_30277());
            var9.method_34582("shapeMode").method_35649(var1);
            var9.method_34582("fillOpacity").method_1251(var2);
            var9.method_34582("glintEnabled").method_35649(var3);
            var9.method_34582("glintSpeed").method_1251(var4);
            var9.method_34582("glintScale").method_1251(var5);
            var9.method_34582("glintStrength").method_1251(var6);
            var9.method_34582("glintCount").method_35649(var7);
            var9.method_34582("Time").method_1251((float)(System.currentTimeMillis() % 100000L) / 1000.0F);
            var8.method_1258(this.field0159, ((GameRendererAccessor)field0796.field_1773).getPool());
            field0796.method_1522().method_1235(true);
            RenderSystem.enableBlend();
            RenderSystem.blendFuncSeparate(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA, class_4535.ZERO, class_4534.ONE);
            this.field0159.method_1233(field0796.method_22683().method_4489(), field0796.method_22683().method_4506());
            RenderSystem.disableBlend();
         } catch (Exception var10) {
            System.err.println("Error rendering itemchams_solid: " + var10.getMessage());
            var10.printStackTrace();
            this.field1649 = null;
         }
      }
   }

   public void method0743(int var1, int var2, float var3, int var4, float var5, int var6, float var7, float var8, float var9, int var10, int var11) {
      this.method2266();
      if (this.field0219) {
         try {
            if (this.field1571 == null) {
               this.field1571 = field0796.method_62887().method_62941(class_2960.method_60655("daamky", "itemchams_glow"), class_9960.field_53902);
            }

            class_279 var12 = this.field1571;
            if (var12 == null) {
               return;
            }

            class_5944 var13 = ((PostEffectProcessorAccessor)var12).getPasses().getFirst().method_62922();
            if (var13 == null) {
               return;
            }

            var13.method_62899("DiffuseSampler", this.field0159.method_30277());
            var13.method_34582("shapeMode").method_35649(var1);
            var13.method_34582("glowStrength").method_35649(var2);
            var13.method_34582("glowMultiplier").method_1251(var3);
            var13.method_34582("glowQuality").method_35649(var4);
            var13.method_34582("fillOpacity").method_1251(var5);
            var13.method_34582("glintEnabled").method_35649(var6);
            var13.method_34582("glintSpeed").method_1251(var7);
            var13.method_34582("glintScale").method_1251(var8);
            var13.method_34582("glintStrength").method_1251(var9);
            var13.method_34582("glintCount").method_35649(var10);
            var13.method_34582("optimize").method_35649(var11);
            var13.method_34582("Time").method_1251((float)(System.currentTimeMillis() % 100000L) / 1000.0F);
            var12.method_1258(this.field0159, ((GameRendererAccessor)field0796.field_1773).getPool());
            field0796.method_1522().method_1235(true);
            RenderSystem.enableBlend();
            RenderSystem.blendFuncSeparate(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA, class_4535.ZERO, class_4534.ONE);
            this.field0159.method_1233(field0796.method_22683().method_4489(), field0796.method_22683().method_4506());
            RenderSystem.disableBlend();
         } catch (Exception var14) {
            System.err.println("Error rendering itemchams_glow: " + var14.getMessage());
            var14.printStackTrace();
            this.field1571 = null;
         }
      }
   }

   public void method0738(int var1, int var2) {
      if (this.field0159 != null) {
         this.field0159.method_1234(Math.max(1, var1 / this.field1705), Math.max(1, var2 / this.field1705));
      }

      this.field0495 = null;
      this.field1649 = null;
      this.field1571 = null;
   }

   public void method0025() {
      this.field0495 = null;
      this.field1649 = null;
      this.field1571 = null;
   }

   public class_4597 method1517(class_4597 var1, Color var2) {
      return this.method1518(var1, var2, 255);
   }

   public class_4597 method1518(class_4597 var1, Color var2, int var3) {
      this.method2266();
      if (!this.field0219) {
         return var1;
      }

      int var4 = Math.max(0, Math.min(255, var3));
      return var4x -> {
         class_4588 var5 = var1.getBuffer(var4x);
         if (var4x instanceof class_4687
            && ((RenderLayerMultiPhaseParametersAccessor)((RenderLayerMultiPhaseAccessor)var4x).invokeGetPhases()).getOutlineMode() != class_4750.field_21853) {
            this.field0650.method0749(var2.getRed(), var2.getGreen(), var2.getBlue(), var4);
            class_4588 var6 = this.field0650
               .getBuffer(
                  this.field1035.apply(((RenderLayerMultiPhaseParametersAccessor)((RenderLayerMultiPhaseAccessor)var4x).invokeGetPhases()).getTexture())
               );
            return var6 != null ? class_4720.method_24037(var6, var5) : var5;
         } else {
            return var5;
         }
      };
   }

   private Function<class_5939, class_1921> method1101(final Function<class_5939, class_1921> var1) {
      return new Function<class_5939, class_1921>() {
         private final Map<class_2960, class_1921> field0140 = new HashMap<>();

         public class_1921 method1521(class_5939 var1x) {
            return this.field0140.computeIfAbsent(((RenderPhaseTextureBaseAccessor)var1x).invokeGetId().get(), var2 -> var1.apply(var1x));
         }
      };
   }

   @Generated
   public ColoredVertexConsumerProvider method2058() {
      return this.field0650;
   }

   @Generated
   public class_276 method1805() {
      return this.field0159;
   }

   @Generated
   public class_4678 method1631() {
      return this.field1523;
   }

   @Generated
   public Function<class_5939, class_1921> method1964() {
      return this.field1035;
   }

   @Generated
   public boolean method0431() {
      return this.field0219;
   }

   @Generated
   public class_279 method0373() {
      return this.field0495;
   }

   @Generated
   public class_279 method0496() {
      return this.field1649;
   }

   @Generated
   public class_279 method2226() {
      return this.field1571;
   }

   @Generated
   public int method2183() {
      return this.field1705;
   }
}
