package aethereal;

import java.awt.Color;

public final class MsdfTextCommandBuilder extends RenderCommandBuilder<MsdfTextRenderCommand> {
   private MsdfFontRenderer field0646;
   private String field0136;
   private float field1410;
   private float field0957;
   private int field0759;
   private float field1242;
   private float field0314;
   private int field0178;
   private float field0458;

   public MsdfTextCommandBuilder method0853(MsdfFontRenderer var1) {
      this.field0646 = var1;
      return this;
   }

   public MsdfTextCommandBuilder method1004(String var1) {
      this.field0136 = var1;
      return this;
   }

   public MsdfTextCommandBuilder method0658(float var1) {
      this.field1410 = var1;
      return this;
   }

   public MsdfTextCommandBuilder method0122(float var1) {
      this.field0957 = var1;
      return this;
   }

   public MsdfTextCommandBuilder method0959(Color var1) {
      return this.method0722(var1.getRGB());
   }

   public MsdfTextCommandBuilder method0722(int var1) {
      this.field0759 = var1;
      return this;
   }

   public MsdfTextCommandBuilder method2096(float var1) {
      this.field1242 = var1;
      return this;
   }

   public MsdfTextCommandBuilder method1820(float var1) {
      this.field0314 = var1;
      return this;
   }

   public MsdfTextCommandBuilder method0963(Color var1, float var2) {
      return this.method0734(var1.getRGB(), var2);
   }

   public MsdfTextCommandBuilder method0734(int var1, float var2) {
      this.field0178 = var1;
      this.field0458 = var2;
      return this;
   }

   protected MsdfTextRenderCommand method1784() {
      return new MsdfTextRenderCommand(
         this.field0646, this.field0136, this.field1410, this.field0957, this.field0759, this.field1242, this.field0314, this.field0178, this.field0458
      );
   }

   @Override
   protected void method0025() {
      this.field0646 = null;
      this.field0136 = "";
      this.field1410 = 0.0F;
      this.field0957 = 0.05F;
      this.field0759 = -1;
      this.field1242 = 0.5F;
      this.field0314 = 0.0F;
      this.field0178 = 0;
      this.field0458 = 0.0F;
   }
}
