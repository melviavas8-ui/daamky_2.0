package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_10149;
import net.minecraft.class_10156;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_5944;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;

public record MsdfTextRenderCommand(
   MsdfFontRenderer font, String text, float size, float thickness, int color, float smoothness, float spacing, int outlineColor, float outlineThickness
) implements RenderCommand {
   private static final class_10156 MSDF_FONT_SHADER_KEY = new class_10156(
      ResourceHelper.method1012("msdf_font"), class_290.field_1575, class_10149.field_53930
   );

   @Override
   public void method1553(Matrix4f var1, float var2, float var3, float var4) {
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableCull();
      this.font.method0025();
      RenderSystem.setShaderTexture(0, this.font.method0531());
      boolean var5 = this.outlineThickness > 0.0F;
      class_5944 var6 = RenderSystem.setShader(MSDF_FONT_SHADER_KEY);
      if (var6 == null) {
         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.enableCull();
         RenderSystem.disableBlend();
      } else {
         var6.method_34582("Range").method_1251(this.font.method1777().method0530());
         var6.method_34582("Thickness").method_1251(this.thickness);
         var6.method_34582("Smoothness").method_1251(this.smoothness);
         var6.method_34582("Outline").method_35649(var5 ? 1 : 0);
         if (var5) {
            var6.method_34582("OutlineThickness").method_1251(this.outlineThickness);
            float[] var7 = ColorConverter.method0145(this.outlineColor);
            var6.method_34582("OutlineColor").method_35657(var7[0], var7[1], var7[2], var7[3]);
         }

         class_287 var16 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1575);
         String[] var8 = this.text.split("\n");
         float var9 = var3;
         float var10 = this.font.method0645(this.size);

         for (String var14 : var8) {
            if (var14.isEmpty()) {
               var9 += var10;
            } else {
               this.font
                  .method1565(
                     var1,
                     var16,
                     var14,
                     this.size,
                     (this.thickness + this.outlineThickness * 0.5F) * 0.5F * this.size,
                     this.spacing,
                     var2,
                     var9 + this.font.method1610().method1762() * this.size,
                     var4,
                     this.color
                  );
               var9 += var10;
            }
         }

         try {
            class_286.method_43433(var16.method_60800());
         } catch (IllegalStateException var15) {
         }

         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.enableCull();
         RenderSystem.disableBlend();
      }
   }

   public MsdfFontRenderer method0542() {
      return this.font;
   }

   public String method0017() {
      return this.text;
   }

   public float method2047() {
      return this.size;
   }

   public float method1762() {
      return this.thickness;
   }

   public int method1604() {
      return this.color;
   }

   public float method1946() {
      return this.smoothness;
   }

   public float method0413() {
      return this.spacing;
   }

   public int method0356() {
      return this.outlineColor;
   }

   public float method0483() {
      return this.outlineThickness;
   }
}
