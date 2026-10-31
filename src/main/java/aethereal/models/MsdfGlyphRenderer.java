package aethereal;

import net.minecraft.class_4588;
import org.joml.Matrix4f;

public final class MsdfGlyphRenderer {
   private final int field0567;
   private final float field0003;
   private final float field1410;
   private final float field0957;
   private final float field0758;
   private final float field1242;
   private final float field0314;
   private final float field0177;
   private final float field0458;

   public MsdfGlyphRenderer(MsdfFontMetadata.Atlas var1, float var2, float var3) {
      this.field0567 = var1.method0531();
      this.field1242 = var1.method0002();
      MsdfFontMetadata.Glyph var4 = var1.method1776();
      if (var4 != null) {
         this.field0003 = var4.method0530() / var2;
         this.field1410 = var4.method2047() / var2;
         this.field0957 = 1.0F - var4.method0002() / var3;
         this.field0758 = 1.0F - var4.method1762() / var3;
      } else {
         this.field0003 = this.field1410 = this.field0957 = this.field0758 = 0.0F;
      }

      MsdfFontMetadata.Glyph var5 = var1.method2055();
      if (var5 != null) {
         this.field0177 = var5.method2047() - var5.method0530();
         this.field0458 = var5.method0002() - var5.method1762();
         this.field0314 = var5.method0002();
      } else {
         this.field0177 = this.field0458 = this.field0314 = 0.0F;
      }
   }

   public float method1564(Matrix4f var1, class_4588 var2, float var3, float var4, float var5, float var6, int var7) {
      var5 -= this.field0314 * var3;
      float var8 = this.field0177 * var3;
      float var9 = this.field0458 * var3;
      var2.method_22918(var1, var4, var5, var6).method_22913(this.field0003, this.field0957).method_39415(var7);
      var2.method_22918(var1, var4, var5 + var9, var6).method_22913(this.field0003, this.field0758).method_39415(var7);
      var2.method_22918(var1, var4 + var8, var5 + var9, var6).method_22913(this.field1410, this.field0758).method_39415(var7);
      var2.method_22918(var1, var4 + var8, var5, var6).method_22913(this.field1410, this.field0957).method_39415(var7);
      return this.field1242 * var3;
   }

   public float method0645(float var1) {
      return this.field1242 * var1;
   }

   public float method0115(float var1) {
      return this.field0458 * var1;
   }

   public int method0531() {
      return this.field0567;
   }
}
