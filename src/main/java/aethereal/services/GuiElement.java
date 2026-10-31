package aethereal;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.class_332;

public abstract class GuiElement implements MinecraftAccess, GuiInputHandler {
   private float field0566;
   private float field0003;
   private float field1410;
   private float field0957;
   private final List<GuiElement> field0209 = new ArrayList<>();

   public GuiElement method0670(float var1, float var2) {
      this.field0566 = var1;
      this.field0003 = var2;
      return this;
   }

   public GuiElement method0126(float var1, float var2) {
      this.field1410 = var1;
      this.field0957 = var2;
      return this;
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      for (int var5 = 0; var5 < this.field0209.size(); var5++) {
         this.field0209.get(var5).method1414(var1, var2, var3, var4);
      }
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      for (int var6 = 0; var6 < this.field0209.size(); var6++) {
         if (this.field0209.get(var6).method0627(var1, var3, var5)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean method0112(double var1, double var3, int var5) {
      for (int var6 = 0; var6 < this.field0209.size(); var6++) {
         if (this.field0209.get(var6).method0112(var1, var3, var5)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean method0746(int var1, int var2, int var3) {
      for (int var4 = 0; var4 < this.field0209.size(); var4++) {
         if (this.field0209.get(var4).method0746(var1, var2, var3)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean method0149(int var1, int var2, int var3) {
      for (int var4 = 0; var4 < this.field0209.size(); var4++) {
         if (this.field0209.get(var4).method0149(var1, var2, var3)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean method0623(double var1, double var3, double var5, double var7) {
      for (int var9 = 0; var9 < this.field0209.size(); var9++) {
         if (this.field0209.get(var9).method0623(var1, var3, var5, var7)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean method0607(char var1, int var2) {
      for (int var3 = 0; var3 < this.field0209.size(); var3++) {
         if (this.field0209.get(var3).method0607(var1, var2)) {
            return true;
         }
      }

      return false;
   }

   @Generated
   public float method0530() {
      return this.field0566;
   }

   @Generated
   public float method0002() {
      return this.field0003;
   }

   @Generated
   public float method2047() {
      return this.field1410;
   }

   @Generated
   public float method1762() {
      return this.field0957;
   }

   @Generated
   public List<GuiElement> method1620() {
      return this.field0209;
   }
}
