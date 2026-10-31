package aethereal;

public final class RectangleCommandBuilder extends RenderCommandBuilder<RectangleRenderCommand> {
   private RenderSize field0680;
   private CornerRadius field0050;
   private QuadColor field1481;
   private float field0957;

   public RectangleCommandBuilder method0925(RenderSize var1) {
      this.field0680 = var1;
      return this;
   }

   public RectangleCommandBuilder method0824(CornerRadius var1) {
      this.field0050 = var1;
      return this;
   }

   public RectangleCommandBuilder method0916(QuadColor var1) {
      this.field1481 = var1;
      return this;
   }

   public RectangleCommandBuilder method0660(float var1) {
      this.field0957 = var1;
      return this;
   }

   protected RectangleRenderCommand method1787() {
      return new RectangleRenderCommand(this.field0680, this.field0050, this.field1481, this.field0957);
   }

   @Override
   protected void method0025() {
      this.field0680 = RenderSize.NONE;
      this.field0050 = CornerRadius.NO_ROUND;
      this.field1481 = QuadColor.TRANSPARENT;
      this.field0957 = 1.0F;
   }
}
