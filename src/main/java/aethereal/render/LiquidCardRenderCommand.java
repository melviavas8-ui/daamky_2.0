package aethereal;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_10149;
import net.minecraft.class_10156;
import net.minecraft.class_276;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_310;
import net.minecraft.class_5944;
import net.minecraft.class_6367;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;

public record LiquidCardRenderCommand(RenderSize size, CornerRadius radius, QuadColor color, float blurRadius, float refraction) implements RenderCommand {
   private static final class_10156 SHADER_KEY = new class_10156(ResourceHelper.method1012("liquid_card"), class_290.field_1576, class_10149.field_53930);
   private static final Supplier<class_6367> TEMP_FBO_SUPPLIER = Suppliers.memoize(() -> new class_6367(1920, 1024, false));
   private static final class_276 MAIN_FBO = class_310.method_1551().method_1522();

   @Override
   public void method1553(Matrix4f var1, float var2, float var3, float var4) {
      class_6367 var5 = (class_6367)TEMP_FBO_SUPPLIER.get();
      if (var5.field_1482 != MAIN_FBO.field_1482 || var5.field_1481 != MAIN_FBO.field_1481) {
         var5.method_1234(MAIN_FBO.field_1482, MAIN_FBO.field_1481);
      }

      var5.method_1235(false);
      MAIN_FBO.method_1237(var5.field_1482, var5.field_1481);
      MAIN_FBO.method_1235(false);
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableCull();
      RenderSystem.setShaderTexture(0, var5.method_30277());
      float var6 = this.size.method0530();
      float var7 = this.size.method0002();
      class_5944 var8 = RenderSystem.setShader(SHADER_KEY);
      if (var8 == null) {
         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.enableCull();
         RenderSystem.disableBlend();
      } else {
         var8.method_34582("Size").method_1255(var6, var7);
         var8.method_34582("Radius").method_35657(this.radius.method0530(), this.radius.method0002(), this.radius.method2047(), this.radius.method1762());
         var8.method_34582("Smoothness").method_1251(1.0F);
         var8.method_34582("BlurRadius").method_1251(this.blurRadius);
         var8.method_34582("Refraction").method_1251(this.refraction);
         class_287 var9 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1576);
         var9.method_22918(var1, var2, var3, var4).method_39415(this.color.method0531());
         var9.method_22918(var1, var2, var3 + var7, var4).method_39415(this.color.method0003());
         var9.method_22918(var1, var2 + var6, var3 + var7, var4).method_39415(this.color.method2048());
         var9.method_22918(var1, var2 + var6, var3, var4).method_39415(this.color.method1763());
         class_286.method_43433(var9.method_60800());
         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.enableCull();
         RenderSystem.disableBlend();
      }
   }

   public RenderSize method0549() {
      return this.size;
   }

   public CornerRadius method0007() {
      return this.radius;
   }

   public QuadColor method2061() {
      return this.color;
   }

   public float method1762() {
      return this.blurRadius;
   }

   public float method1603() {
      return this.refraction;
   }
}
