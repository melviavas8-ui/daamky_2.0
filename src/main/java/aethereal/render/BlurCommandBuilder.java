package aethereal;

public final class BlurCommandBuilder extends RenderCommandBuilder<BlurRenderCommand> {
   private RenderSize field0680;
   private CornerRadius field0050;
   private QuadColor field1481;
   private float field0957;
   private float field0758;

   public BlurCommandBuilder method0919(RenderSize var1) {
      this.field0680 = var1;
      return this;
   }

   public BlurCommandBuilder method0818(CornerRadius var1) {
      this.field0050 = var1;
      return this;
   }

   public BlurCommandBuilder method0910(QuadColor var1) {
      this.field1481 = var1;
      return this;
   }

   public BlurCommandBuilder method0647(float var1) {
      this.field0957 = var1;
      return this;
   }

   public BlurCommandBuilder method0116(float var1) {
      this.field0758 = var1;
      return this;
   }

   protected BlurRenderCommand method1765() {
      return new BlurRenderCommand(this.field0680, this.field0050, this.field1481, this.field0957, this.field0758);
   }

   @Override
   protected void method0025() {
      this.field0680 = RenderSize.NONE;
      this.field0050 = CornerRadius.NO_ROUND;
      this.field1481 = QuadColor.WHITE;
      this.field0957 = 1.0F;
      this.field0758 = 0.0F;
   }
}
