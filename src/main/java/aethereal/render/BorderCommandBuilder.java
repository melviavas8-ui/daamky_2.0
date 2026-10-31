package aethereal;

public final class BorderCommandBuilder extends RenderCommandBuilder<BorderRenderCommand> {
   private RenderSize field0680;
   private CornerRadius field0050;
   private QuadColor field1481;
   private float field0957;
   private float field0758;
   private float field1242;

   public BorderCommandBuilder method0920(RenderSize var1) {
      this.field0680 = var1;
      return this;
   }

   public BorderCommandBuilder method0819(CornerRadius var1) {
      this.field0050 = var1;
      return this;
   }

   public BorderCommandBuilder method0911(QuadColor var1) {
      this.field1481 = var1;
      return this;
   }

   public BorderCommandBuilder method0648(float var1) {
      this.field0957 = var1;
      return this;
   }

   public BorderCommandBuilder method0668(float var1, float var2) {
      this.field0758 = var1;
      this.field1242 = var2;
      return this;
   }

   protected BorderRenderCommand method1766() {
      return new BorderRenderCommand(this.field0680, this.field0050, this.field1481, this.field0957, this.field0758, this.field1242);
   }

   @Override
   protected void method0025() {
      this.field0680 = RenderSize.NONE;
      this.field0050 = CornerRadius.NO_ROUND;
      this.field1481 = QuadColor.TRANSPARENT;
      this.field0957 = 0.0F;
      this.field0758 = 1.0F;
      this.field1242 = 1.0F;
   }
}
