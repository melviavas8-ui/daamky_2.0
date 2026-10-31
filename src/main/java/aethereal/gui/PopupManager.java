package aethereal;

import lombok.Generated;
import net.minecraft.class_332;

public class PopupManager extends GuiElement {
   private static PopupManager field0634;

   public PopupManager() {
      field0634 = this;
   }

   public void method1973() {
      for (GuiElement var2 : this.method1620()) {
         PopupPanel var3 = (PopupPanel)var2;
         if (!var3.method1891()) {
            var3.method1973();
         }
      }
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      if (!this.method1620().isEmpty()) {
         super.method1414(var1, var2, var3, var4);
         this.method1620().removeIf(var0 -> {
            PopupPanel var1 = (PopupPanel)var0;
            return var1.method1891() ? false : var1.method2267();
         });
      }
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      boolean var6 = super.method0627(var1, var3, var5);
      if (!var6) {
         this.method1620().removeIf(var4 -> {
            PopupPanel var5 = (PopupPanel)var4;
            return var5.method1891() && !var5.method1825((float)var1, (float)var3);
         });
      }

      return var6;
   }

   @Override
   public boolean method0112(double var1, double var3, int var5) {
      boolean var6 = super.method0112(var1, var3, var5);
      NumberSettingWidget.method1973();
      return var6;
   }

   @Generated
   public static PopupManager method0416() {
      return field0634;
   }
}
