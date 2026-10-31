package aethereal;

import java.util.List;
import lombok.Generated;
import net.minecraft.class_332;

public class SettingList extends GuiElement {
   private final List<SettingWidget> field0719;

   public boolean method1974() {
      return this.field0719.isEmpty();
   }

   public void method0430() {
      for (int var1 = 0; var1 < this.field0719.size(); var1++) {
         this.field0719.get(var1).method0126(this.method2047(), -1.0F);
      }
   }

   @Override
   public float method1762() {
      if (this.method1974()) {
         return 0.0F;
      }

      float var1 = 0.0F;

      for (int var2 = 0; var2 < this.field0719.size(); var2++) {
         SettingWidget var3 = this.field0719.get(var2);
         if (var3.method0366().method0026()) {
            var1 += var3.method1762() + 6.0F;
         }
      }

      return var1 - 6.0F;
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      float var5 = this.method0002();
      float var6 = this.method0002() + this.method1762();
      float var7 = 0.0F;

      for (int var8 = 0; var8 < this.field0719.size(); var8++) {
         SettingWidget var9 = this.field0719.get(var8);
         if (var9.method0366().method0026()) {
            float var10 = this.method0002() + var7;
            float var11 = var9.method1762();
            var9.method0670(this.method0530(), var10).method0126(this.method2047(), -1.0F);
            if (var10 + var11 >= var5 - 20.0F && var10 <= var6 + 20.0F) {
               var9.method1414(var1, var2, var3, var4);
            }

            var7 += var11 + 6.0F;
         }
      }
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      for (int var6 = 0; var6 < this.field0719.size(); var6++) {
         SettingWidget var7 = this.field0719.get(var6);
         if (var7.method0366().method0026() && var7.method0627(var1, var3, var5)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean method0746(int var1, int var2, int var3) {
      for (int var4 = 0; var4 < this.field0719.size(); var4++) {
         SettingWidget var5 = this.field0719.get(var4);
         if (var5.method0366().method0026() && var5.method0746(var1, var2, var3)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean method0112(double var1, double var3, int var5) {
      for (int var6 = 0; var6 < this.field0719.size(); var6++) {
         SettingWidget var7 = this.field0719.get(var6);
         if (var7.method0366().method0026() && var7.method0112(var1, var3, var5)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean method0623(double var1, double var3, double var5, double var7) {
      for (int var9 = 0; var9 < this.field0719.size(); var9++) {
         SettingWidget var10 = this.field0719.get(var9);
         if (var10.method0366().method0026() && var10.method0623(var1, var3, var5, var7)) {
            return true;
         }
      }

      return false;
   }

   @Generated
   public SettingList(List<SettingWidget> var1) {
      this.field0719 = var1;
   }
}
