package aethereal;

public final class GaussianBlurCommandBuilder extends RenderCommandBuilder<GaussianBlurRenderCommand> {
   private RenderSize field0680;
   private CornerRadius field0050;
   private QuadColor field1481;
   private float field0957;
   private float field0758;

   public GaussianBlurCommandBuilder method0924(RenderSize var1) {
      this.field0680 = var1;
      return this;
   }

   public GaussianBlurCommandBuilder method0823(CornerRadius var1) {
      this.field0050 = var1;
      return this;
   }

   public GaussianBlurCommandBuilder method0915(QuadColor var1) {
      this.field1481 = var1;
      return this;
   }

   public GaussianBlurCommandBuilder method0655(float var1) {
      this.field0957 = var1;
      return this;
   }

   public GaussianBlurCommandBuilder method0119(float var1) {
      this.field0758 = var1;
      return this;
   }

   protected GaussianBlurRenderCommand method1774() {
      return new GaussianBlurRenderCommand(this.field0680, this.field0050, this.field1481, this.field0957, this.field0758);
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
