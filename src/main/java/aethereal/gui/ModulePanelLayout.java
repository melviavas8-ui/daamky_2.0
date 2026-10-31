package aethereal;

import net.minecraft.class_332;

public class ModulePanelLayout extends GuiElement {
   final float field0566 = 128.0F;
   final float field0003 = 337.5F;
   final float field1410 = 8.0F;

   public ModulePanelLayout() {
      ModuleCategory[] var1 = ModuleCategory.values();

      for (int var2 = 0; var2 < var1.length; var2++) {
         ModuleCategoryPanel var3 = new ModuleCategoryPanel(var1[var2]);
         var3.method0729(var2);
         this.method1620().add(var3);
      }
   }

   public void method1570(boolean var1) {
      int var2 = this.method1620().size();
      int var3 = var2 / 2;

      for (int var4 = 0; var4 < this.method1620().size(); var4++) {
         ModuleCategoryPanel var5 = (ModuleCategoryPanel)this.method1620().get(var4);
         int var6 = Math.abs(var4 - var3);
         long var7 = var6 * 40L;
         Animation var9 = new ModulePanelLayout.StaggeredAnimation(250L, 1.0, var1, EasingCurve.field0330, var7);
         var9.method1634();
         var5.method0865(var9);
      }
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      float var5 = 0.0F;

      for (int var6 = 0; var6 < this.method1620().size(); var6++) {
         GuiElement var7 = this.method1620().get(var6);
         var7.method0670(this.method0530() + var5, this.method0002()).method0126(128.0F, 337.5F);
         var5 += 136.0F;
      }

      super.method1414(var1, var2, var3, var4);
   }

   private static class StaggeredAnimation extends Animation {
      private final long field0568;
      private final long field0005;
      private long field1412;

      public StaggeredAnimation(long var1, double var3, boolean var5, EasingCurve var6, long var7) {
         super(var1, var3, var5, var6);
         this.field0568 = var7;
         this.field0005 = var1;
         this.field1412 = -1L;
      }

      @Override
      public float method0002() {
         if (this.field1412 == -1L) {
            this.field1412 = System.currentTimeMillis();
         }

         long var1 = System.currentTimeMillis() - this.field1412;
         if (var1 < this.field0568) {
            return this.method0376() ? 0.0F : 1.0F;
         }

         long var3 = var1 - this.field0568;
         if (this.method0376()) {
            if (var3 >= this.field0005) {
               return 1.0F;
            }

            double var9 = (double)var3 / this.field0005;
            double var10 = Math.sqrt(1.0 - Math.pow(var9 - 1.0, 2.0));
            return (float)var10;
         } else {
            if (var3 >= this.field0005) {
               return 0.0F;
            }

            double var5 = (double)var3 / this.field0005;
            double var7 = Math.sqrt(1.0 - Math.pow(var5 - 1.0, 2.0));
            return (float)(1.0 - var7);
         }
      }

      @Override
      public void method1634() {
         super.method1634();
         this.field1412 = -1L;
      }
   }
}
