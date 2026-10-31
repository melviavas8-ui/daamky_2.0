package aethereal;

import lombok.Generated;

public class HudWidgetState {
   private String field0715;
   private float field0003;
   private float field1410;
   private float field0957;
   private float field0758;
   private float field1242;
   private boolean field0343;
   private float field0177;
   private float field0458;
   private HudWidgetState.WidgetState field1632 = HudWidgetState.WidgetState.field0642;
   private boolean field1574 = false;
   private boolean field1735 = false;

   public HudWidgetState(String var1, float var2, float var3, float var4, float var5) {
      this.field0715 = var1;
      this.field0003 = var2;
      this.field1410 = var3;
      this.field0957 = var4;
      this.field0758 = var5;
      this.field0343 = false;
   }

   public boolean method0676(float var1, float var2) {
      float var3 = this.field1410 + this.field1242;
      return var1 >= this.field0003 && var1 <= this.field0003 + this.field0957 && var2 >= var3 && var2 <= var3 + this.field0758;
   }

   public void method0128(float var1, float var2) {
      this.field0343 = true;
      this.field0177 = var1 - this.field0003;
      this.field0458 = var2 - this.field1410;
   }

   public void method0578() {
      this.field0343 = false;
   }

   public void method1570(boolean var1) {
      this.field1574 = var1;
   }

   public boolean method0026() {
      return this.field1574;
   }

   public void method0345(boolean var1) {
      this.field1735 = var1;
   }

   public boolean method2079() {
      return this.field1735;
   }

   public void method1812() {
      this.field1632 = this.field1632 == HudWidgetState.WidgetState.field0642
         ? HudWidgetState.WidgetState.field0072
         : HudWidgetState.WidgetState.field0642;
   }

   public void method0701(float var1, float var2, int var3, float var4, float var5) {
      if (this.field0343) {
         float var6 = var2 - this.field0458;
         this.field1410 = Math.round(var6 / var3) * var3;
         if (!this.field1574) {
            float var7 = var1 - this.field0177;
            this.field0003 = Math.round(var7 / var3) * var3;
         }

         this.method2100(var4, var5);
      }
   }

   private void method2100(float var1, float var2) {
      this.field0003 = Math.max(0.0F, Math.min(this.field0003, var1 - this.field0957));
      this.field1410 = Math.max(-this.field1242, Math.min(this.field1410, var2 - this.field0758 - this.field1242));
   }

   @Generated
   public String method1619() {
      return this.field0715;
   }

   @Generated
   public float method1946() {
      return this.field0003;
   }

   @Generated
   public float method0413() {
      return this.field1410;
   }

   @Generated
   public float method0355() {
      return this.field0957;
   }

   @Generated
   public float method0483() {
      return this.field0758;
   }

   @Generated
   public float method2213() {
      return this.field1242;
   }

   @Generated
   public boolean method2195() {
      return this.field0343;
   }

   @Generated
   public float method2253() {
      return this.field0177;
   }

   @Generated
   public float method1901() {
      return this.field0458;
   }

   @Generated
   public HudWidgetState.WidgetState method1885() {
      return this.field1632;
   }

   @Generated
   public void method1013(String var1) {
      this.field0715 = var1;
   }

   @Generated
   public void method0665(float var1) {
      this.field0003 = var1;
   }

   @Generated
   public void method0124(float var1) {
      this.field1410 = var1;
   }

   @Generated
   public void method2098(float var1) {
      this.field0957 = var1;
   }

   @Generated
   public void method1822(float var1) {
      this.field0758 = var1;
   }

   @Generated
   public void method1638(float var1) {
      this.field1242 = var1;
   }

   @Generated
   public void method2178(boolean var1) {
      this.field0343 = var1;
   }

   @Generated
   public void method1977(float var1) {
      this.field0177 = var1;
   }

   @Generated
   public void method0435(float var1) {
      this.field0458 = var1;
   }

   @Generated
   public void method0851(HudWidgetState.WidgetState var1) {
      this.field1632 = var1;
   }

   public enum WidgetState {
      field0642,
      field0072;
   }
}
