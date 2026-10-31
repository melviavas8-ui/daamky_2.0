package aethereal;

public class EasingAnimation {
   private final HudAnimation field0652 = new HudAnimation(EasingCurve.field0672);
   private final HudAnimation field0080 = new HudAnimation(EasingCurve.field0672);

   public EasingAnimation() {
   }

   public EasingAnimation(EasingCurve var1, EasingCurve var2) {
      this.method0902(var1, var2);
   }

   public float method0705(float var1, long var2) {
      return this.field0652.method0705(var1, var2);
   }

   public float method0135(float var1, long var2) {
      return this.field0080.method0705(var1, var2);
   }

   public float method0530() {
      return this.field0652.method2047();
   }

   public float method0002() {
      return this.field0080.method2047();
   }

   public boolean method2079() {
      return this.field0652.method0026() || this.field0080.method0026();
   }

   public void method0902(EasingCurve var1, EasingCurve var2) {
      this.field0652.method0901(var1);
      this.field0080.method0901(var2);
   }
}
