package aethereal;

public final class CircularRectangleCommandBuilder extends RenderCommandBuilder<CircularRectangleRenderCommand> {
   private RenderSize field0680;
   private CornerRadius field0050;
   private QuadColor field1481;
   private float field0957;

   public CircularRectangleCommandBuilder method0922(RenderSize var1) {
      this.field0680 = var1;
      return this;
   }

   public CircularRectangleCommandBuilder method0821(CornerRadius var1) {
      this.field0050 = var1;
      return this;
   }

   public CircularRectangleCommandBuilder method0913(QuadColor var1) {
      this.field1481 = var1;
      return this;
   }

   public CircularRectangleCommandBuilder method0650(float var1) {
      this.field0957 = var1;
      return this;
   }

   protected CircularRectangleRenderCommand method1769() {
      return new CircularRectangleRenderCommand(this.field0680, this.field0050, this.field1481, this.field0957);
   }

   @Override
   protected void method0025() {
      this.field0680 = RenderSize.NONE;
      this.field0050 = CornerRadius.NO_ROUND;
      this.field1481 = QuadColor.TRANSPARENT;
      this.field0957 = 1.0F;
   }
}
