package aethereal;

public class SwordTrailAnimation {
   public final float field0566;
   public int field0004;
   public final int field1411;

   public SwordTrailAnimation(float var1, int var2) {
      this.field0566 = var1;
      this.field0004 = 0;
      this.field1411 = var2;
   }

   public boolean method0579() {
      return this.field0004 >= this.field1411;
   }

   public float method0002() {
      return (float)this.field0004 / this.field1411;
   }
}
