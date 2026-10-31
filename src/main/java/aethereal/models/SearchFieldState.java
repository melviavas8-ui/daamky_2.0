package aethereal;

import lombok.Generated;
import net.minecraft.class_310;

public class SearchFieldState {
   private final StringBuilder field0716 = new StringBuilder();
   private final Animation field0079 = new Animation(250L, 1.0, true, EasingCurve.field1477);
   private String field1504;
   private Boolean field1027 = false;
   private boolean field0798 = false;

   public SearchFieldState method1001(String var1) {
      this.field1504 = var1;
      return this;
   }

   public void method1570(boolean var1) {
      this.field1027 = var1;
      this.field0079.method1570(var1);
      this.field0079.method1634();
      if (!var1) {
         this.field0798 = false;
      }
   }

   public boolean method0579() {
      return this.field1027;
   }

   public boolean method0026() {
      return this.field0798 && !this.field0716.isEmpty();
   }

   public void method2078() {
      this.field0798 = false;
   }

   public boolean method0746(int var1, int var2, int var3) {
      if (ClickGuiScreen.method_25441() && var1 == 70) {
         this.method1570(!this.method0579());
         return false;
      }

      if (this.method0579() && ClickGuiScreen.method_25441()) {
         if (var1 == 65) {
            this.field0798 = !this.field0716.isEmpty();
            return true;
         }

         if (var1 == 67) {
            if (!this.field0716.isEmpty()) {
               class_310.method_1551().field_1774.method_1455(this.field0716.toString());
            }

            return true;
         }

         if (var1 == 86) {
            String var9 = class_310.method_1551().field_1774.method_1460();
            if (var9 != null) {
               if (this.method0026()) {
                  this.field0716.setLength(0);
                  this.field0798 = false;
               }

               for (char var8 : var9.toCharArray()) {
                  if (var8 >= ' ') {
                     this.field0716.append(var8);
                  }
               }
            }

            return true;
         }

         if (var1 == 88) {
            if (!this.field0716.isEmpty()) {
               class_310.method_1551().field_1774.method_1455(this.field0716.toString());
               this.field0716.setLength(0);
               this.field0798 = false;
            }

            return true;
         }
      }

      if (this.method0579() && var1 == 259 && !this.field0716.isEmpty()) {
         if (this.method0026()) {
            this.field0716.setLength(0);
            this.field0798 = false;
         } else if (ClickGuiScreen.method_25441()) {
            String[] var4 = this.field0716.toString().split(" ");
            if (var4.length == 0) {
               this.field0716.setLength(0);
            } else {
               int var5 = var4[var4.length - 1].length();
               int var6 = this.field0716.toString().strip().length() - var5;
               this.field0716.delete(Math.max(0, var6), this.field0716.length());
            }
         } else {
            this.field0716.deleteCharAt(this.field0716.length() - 1);
         }

         return true;
      } else if (this.method0579() && var1 == 261 && this.method0026()) {
         this.field0716.setLength(0);
         this.field0798 = false;
         return true;
      } else if (this.method0579() && (var1 == 263 || var1 == 262 || var1 == 268 || var1 == 269 || var1 == 256) && this.field0798) {
         this.field0798 = false;
         return true;
      } else {
         return false;
      }
   }

   public boolean method0607(char var1, int var2) {
      if (this.field1027) {
         if (this.method0026()) {
            this.field0716.setLength(0);
            this.field0798 = false;
         }

         this.field0716.append(var1);
         return true;
      } else {
         return false;
      }
   }

   @Generated
   public StringBuilder method1792() {
      return this.field0716;
   }

   @Generated
   public Animation method1612() {
      return this.field0079;
   }

   @Generated
   public String method1961() {
      return this.field1504;
   }

   @Generated
   public Boolean method0422() {
      return this.field1027;
   }
}
