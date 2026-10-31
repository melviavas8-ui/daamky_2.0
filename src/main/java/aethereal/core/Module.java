package aethereal;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;

public abstract class Module implements MinecraftAccess {
   private final String field0136;
   private final String field1504;
   private String field1030;
   private final ModuleCategory field0201;
   protected boolean field0751;
   private KeyBind field0479 = new KeyBind(-1, false);
   private final List<Setting<?>> field1644 = new ArrayList<>();
   private boolean field1574 = false;
   private String field1727 = null;

   public Module(String var1, ModuleCategory var2) {
      this.field0136 = var1;
      this.field0201 = var2;
      this.field1504 = "";
   }

   public Module(String var1, ModuleCategory var2, String var3) {
      this.field0136 = var1;
      this.field0201 = var2;
      this.field1504 = var3;
   }

   public String method0557() {
      if (this.field1030 != null && method1736()) {
         return this.field1030;
      } else {
         return this.field1504 != null ? this.field1504 : "";
      }
   }

   protected void method1013(String var1) {
      this.field1030 = var1;
   }

   protected void method1570(boolean var1) {
      this.field1574 = var1;
   }

   protected void method0213(String var1) {
      this.field1727 = var1;
   }

   private static boolean method1736() {
      try {
         return ClickGuiDashboard.field0984.method0492() == ClickGuiDashboard.Language.field0631;
      } catch (Exception var1) {
         return true;
      }
   }

   public void method0025() {
      this.field0751 = true;
      DaamkyClient.method2004().method2072().subscribe(this);
   }

   public void method2078() {
      this.field0751 = false;
      DaamkyClient.method2004().method2072().unsubscribe(this);
   }

   public void method0345(boolean var1) {
      if (this.field0751 != var1) {
         if (var1) {
            this.method0025();
         } else {
            this.method2078();
         }

         NewHUD.method1036(this.field0136, this.field0201, var1);
      }
   }

   public void method2178(boolean var1) {
      if (this.field0751 != var1) {
         if (var1) {
            this.method0025();
         } else {
            this.method2078();
         }
      }
   }

   public void method1812() {
      this.method0345(!this.field0751);
   }

   public boolean method1635() {
      return this.field0751;
   }

   public static boolean method1974() {
      return field0796.field_1724 == null || field0796.field_1687 == null;
   }

   @Generated
   public String method0423() {
      return this.field0136;
   }

   @Generated
   public String method0368() {
      return this.field1504;
   }

   @Generated
   public String method0493() {
      return this.field1030;
   }

   @Generated
   public ModuleCategory method2220() {
      return this.field0201;
   }

   @Generated
   public boolean method2195() {
      return this.field0751;
   }

   @Generated
   public KeyBind method2259() {
      return this.field0479;
   }

   @Generated
   public List<Setting<?>> method1914() {
      return this.field1644;
   }

   @Generated
   public void method0881(KeyBind var1) {
      this.field0479 = var1;
   }

   @Generated
   public boolean method1891() {
      return this.field1574;
   }

   @Generated
   public String method1935() {
      return this.field1727;
   }
}
