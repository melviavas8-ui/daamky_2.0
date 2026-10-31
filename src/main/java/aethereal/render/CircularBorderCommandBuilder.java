package aethereal;

public final class CircularBorderCommandBuilder extends RenderCommandBuilder<CircularBorderRenderCommand> {
   private RenderSize field0680;
   private CornerRadius field0050;
   private QuadColor field1481;
   private float field0957;
   private float field0758;
   private float field1242;

   public CircularBorderCommandBuilder method0921(RenderSize var1) {
      this.field0680 = var1;
      return this;
   }

   public CircularBorderCommandBuilder method0820(CornerRadius var1) {
      this.field0050 = var1;
      return this;
   }

   public CircularBorderCommandBuilder method0912(QuadColor var1) {
      this.field1481 = var1;
      return this;
   }

   public CircularBorderCommandBuilder method0649(float var1) {
      this.field0957 = var1;
      return this;
   }

   public CircularBorderCommandBuilder method0669(float var1, float var2) {
      this.field0758 = var1;
      this.field1242 = var2;
      return this;
   }

   protected CircularBorderRenderCommand method1768() {
      return new CircularBorderRenderCommand(this.field0680, this.field0050, this.field1481, this.field0957, this.field0758, this.field1242);
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
