package aethereal;

import net.minecraft.class_1799;

public class MaceCooldownTracker implements MinecraftAccess {
   private final int[] field0753 = new int[]{10, 11, 10, 13};
   private final int[] field0172 = new int[]{11, 10, 13, 10, 12, 11, 12};
   private final int[] field1529 = new int[]{10, 11};
   private long field0959 = System.currentTimeMillis();
   private static final long field0179 = 500L;

   public boolean method1572(boolean var1, int var2) {
      boolean var3 = this.method1813();
      boolean var4 = var3 || field0796.field_1724.method_7261(var2) > 0.9F;
      boolean var5 = this.method0532() >= 500L;
      return var4 && var5;
   }

   public boolean method0730(int var1) {
      return (float)this.method0532() >= (float)(var1 * 50L) * (20.0F / ServerEnvironment.field0003);
   }

   public long method0532() {
      return System.currentTimeMillis() - this.field0959;
   }

   public void method0025() {
      this.field0959 = System.currentTimeMillis();
   }

   int method2048() {
      int var1 = DaamkyClient.method2004().method1881().method2051().method0414();
      String var2 = ServerEnvironment.field0715;
      byte var3 = -1;
      var2.hashCode();
      switch (var3) {
         default:
            return this.field1529[var1 % this.field1529.length];
      }
   }

   private boolean method1813() {
      class_1799 var1 = field0796.field_1724.method_6047();
      return var1.method_7909().method_7876().toLowerCase().contains("mace");
   }
}
