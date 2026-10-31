package aethereal;

public class SwordTrailFade {
   public double field0565;
   public double field0002;
   public double field1409;
   public double field0956;
   public double field0757;
   public double field1241;
   public double field0313;
   public double field0176;
   public double field0457;
   public int field1615;
   public final int field1539;

   public SwordTrailFade(double var1, double var3, double var5, double var7, double var9, double var11, int var13) {
      this.field0565 = var1;
      this.field0002 = var3;
      this.field1409 = var5;
      this.field0956 = var1;
      this.field0757 = var3;
      this.field1241 = var5;
      this.field0313 = var7;
      this.field0176 = var9;
      this.field0457 = var11;
      this.field1615 = 0;
      this.field1539 = var13;
   }

   public boolean method0579() {
      return this.field1615 >= this.field1539;
   }

   public float method0002() {
      return 1.0F - (float)this.field1615 / this.field1539;
   }
}
