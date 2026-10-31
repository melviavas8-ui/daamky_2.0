package aethereal;

import net.minecraft.class_1044;

public final class TextureCommandBuilder extends RenderCommandBuilder<TextureRenderCommand> {
   private RenderSize field0680;
   private CornerRadius field0050;
   private QuadColor field1481;
   private float field0957;
   private float field0758;
   private float field1242;
   private float field0314;
   private float field0177;
   private int field0459;

   public TextureCommandBuilder method0926(RenderSize var1) {
      this.field0680 = var1;
      return this;
   }

   public TextureCommandBuilder method0825(CornerRadius var1) {
      this.field0050 = var1;
      return this;
   }

   public TextureCommandBuilder method0917(QuadColor var1) {
      this.field1481 = var1;
      return this;
   }

   public TextureCommandBuilder method0661(float var1) {
      this.field0957 = var1;
      return this;
   }

   public TextureCommandBuilder method0698(float var1, float var2, float var3, float var4, class_1044 var5) {
      return this.method0695(var1, var2, var3, var4, var5.method_4624());
   }

   public TextureCommandBuilder method0695(float var1, float var2, float var3, float var4, int var5) {
      this.field0758 = var1;
      this.field1242 = var2;
      this.field0314 = var3;
      this.field0177 = var4;
      this.field0459 = var5;
      return this;
   }

   protected TextureRenderCommand method1789() {
      return new TextureRenderCommand(
         this.field0680, this.field0050, this.field1481, this.field0957, this.field0758, this.field1242, this.field0314, this.field0177, this.field0459
      );
   }

   @Override
   protected void method0025() {
      this.field0680 = RenderSize.NONE;
      this.field0050 = CornerRadius.NO_ROUND;
      this.field1481 = QuadColor.WHITE;
      this.field0957 = 1.0F;
      this.field0758 = 0.0F;
      this.field1242 = 0.0F;
      this.field0314 = 0.0F;
      this.field0177 = 0.0F;
      this.field0459 = 0;
   }
}
