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

public record LiquidGlassTextRenderCommand(
   MsdfFontRenderer font, String text, float size, float thickness, int color, float smoothness, float spacing, float refraction, float blur
) implements RenderCommand {
   private static final class_10156 LIQUIDGLASS_FONT_SHADER_KEY = new class_10156(
      ResourceHelper.method1012("msdf_font_liquidglass"), class_290.field_1575, class_10149.field_53930
   );

   @Override
   public void method1553(Matrix4f var1, float var2, float var3, float var4) {
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableCull();
      this.font.method0025();
      RenderSystem.setShaderTexture(0, this.font.method0531());
      RenderSystem.setShaderTexture(1, MinecraftAccess.field0796.method_1522().method_30277());
      class_5944 var5 = RenderSystem.setShader(LIQUIDGLASS_FONT_SHADER_KEY);
      if (var5 == null) {
         System.err.println("[Daamky] LiquidGlass font shader not loaded!");
      } else {
         var5.method_34582("Range").method_1251(this.font.method1777().method0530());
         var5.method_34582("Thickness").method_1251(this.thickness);
         var5.method_34582("Smoothness").method_1251(this.smoothness);
         var5.method_34582("ScreenSize")
            .method_1255(MinecraftAccess.field0796.method_22683().method_4489(), MinecraftAccess.field0796.method_22683().method_4506());
         var5.method_34582("Refraction").method_1251(this.refraction);
         var5.method_34582("Blur").method_1251(this.blur);
         class_287 var6 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1575);
         String[] var7 = this.text.split("\n");
         float var8 = var3;
         float var9 = this.font.method0645(this.size);

         for (String var13 : var7) {
            if (var13.isEmpty()) {
               var8 += var9;
            } else {
               this.font
                  .method1565(
                     var1,
                     var6,
                     var13,
                     this.size,
                     this.thickness * 0.5F * this.size,
                     this.spacing,
                     var2,
                     var8 + this.font.method1610().method1762() * this.size,
                     var4,
                     this.color
                  );
               var8 += var9;
            }
         }

         try {
            class_286.method_43433(var6.method_60800());
         } catch (IllegalStateException var14) {
         }

         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.setShaderTexture(1, 0);
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

   public float method0355() {
      return this.refraction;
   }

   public float method0483() {
      return this.blur;
   }
}
