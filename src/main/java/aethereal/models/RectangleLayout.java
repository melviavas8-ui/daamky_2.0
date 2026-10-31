package aethereal;

import com.mojang.blaze3d.platform.GlStateManager.class_4534;
import com.mojang.blaze3d.platform.GlStateManager.class_4535;
import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_10142;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;

public class RectangleLayout {
   private float field0566;
   private float field0003;
   private float field1410;
   private float field0957;
   private float field0758 = 0.15F;
   private float field1242 = 5000.0F;
   private float field0314 = 0.98F;
   private float field0177 = 3.0F;
   private boolean field0497 = true;
   private float field1614 = -1.0F;
   private float field1538 = -1.0F;
   private final List<RectangleLayout.VerticalBounds> field1728 = new ArrayList<>();
   private final List<RectangleLayout.HorizontalBounds> field1155 = new ArrayList<>();
   private Color field1104 = new Color(84, 16, 178);

   public RectangleLayout method0958(Color var1) {
      this.field1104 = var1;
      return this;
   }

   public void method0686(float var1, float var2, float var3, float var4) {
      this.field0566 = var1;
      this.field0003 = var2;
      this.field1410 = var3;
      this.field0957 = var4;
   }

   public RectangleLayout method0656(float var1) {
      this.field0758 = var1;
      return this;
   }

   public RectangleLayout method0120(float var1) {
      this.field1242 = var1;
      return this;
   }

   public RectangleLayout method2094(float var1) {
      this.field0314 = var1;
      return this;
   }

   public RectangleLayout method1819(float var1) {
      this.field0177 = var1;
      return this;
   }

   public RectangleLayout method1568(boolean var1) {
      this.field0497 = var1;
      return this;
   }

   public void method1414(class_332 var1, int var2, int var3, float var4) {
      if (!(this.field1410 <= 0.0F) && !(this.field0957 <= 0.0F)) {
         float var5 = 0.016F;
         boolean var6 = var2 >= this.field0566 && var2 <= this.field0566 + this.field1410 && var3 >= this.field0003 && var3 <= this.field0003 + this.field0957;
         if (var6) {
            float var7 = var2 - this.field0566;
            float var8 = var3 - this.field0003;
            if (this.field1614 >= 0.0F && this.field1538 >= 0.0F) {
               float var9 = var7 - this.field1614;
               float var10 = var8 - this.field1538;
               float var11 = (float)Math.sqrt(var9 * var9 + var10 * var10);
               if (var11 > 1.0F) {
                  Color var12 = this.method0553();
                  this.method0696(var7, var8, var9 * this.field1242 * 0.001F, var10 * this.field1242 * 0.001F, var12);
               }
            }

            this.field1614 = var7;
            this.field1538 = var8;
         } else {
            this.field1614 = -1.0F;
            this.field1538 = -1.0F;
         }

         this.method1638(var5);
         this.method1977(var5);
         this.method1401(var1, var4);
      }
   }

   private Color method0553() {
      float var1 = 0.2F + (float)Math.random() * 0.3F;
      return new Color(
         Math.min(255, (int)(this.field1104.getRed() * var1)),
         Math.min(255, (int)(this.field1104.getGreen() * var1)),
         Math.min(255, (int)(this.field1104.getBlue() * var1)),
         255
      );
   }

   private void method0696(float var1, float var2, float var3, float var4, Color var5) {
      float var6 = this.field0758 * Math.min(this.field1410, this.field0957) * 0.5F;
      this.field1728.add(new RectangleLayout.VerticalBounds(var1, var2, var3, var4, var6, var5, 1.0F));
      int var7 = 3 + (int)(Math.random() * 5.0);

      for (int var8 = 0; var8 < var7; var8++) {
         float var9 = (float)(Math.random() * 3.1415927169270965 * 2.0);
         float var10 = (float)(Math.random() * 30.0 + 10.0);
         float var11 = var3 * 0.3F + (float)Math.cos(var9) * var10;
         float var12 = var4 * 0.3F + (float)Math.sin(var9) * var10;
         float var13 = (float)(Math.random() * 4.0 + 2.0);
         this.field1155.add(new RectangleLayout.HorizontalBounds(var1, var2, var11, var12, var13, var5, 1.0F));
      }
   }

   private void method1638(float var1) {
      float var2 = (float)System.currentTimeMillis() * 0.001F;
      float var3 = this.field0177 * 0.1F;
      Iterator var4 = this.field1728.iterator();

      while (var4.hasNext()) {
         RectangleLayout.VerticalBounds var5 = var4.next();
         var5.field0566 = var5.field0566 + var5.field1410 * var1;
         var5.field0003 = var5.field0003 + var5.field0957 * var1;
         var5.field1410 = var5.field1410 * this.field0314;
         var5.field0957 = var5.field0957 * this.field0314;
         var5.field1410 = var5.field1410 + (float)Math.sin(var5.field0003 * 0.05F + var2) * var3;
         var5.field0957 = var5.field0957 + (float)Math.cos(var5.field0566 * 0.05F + var2) * var3;
         var5.field0314 -= var1 * 0.5F;
         var5.field0758 *= 0.995F;
         if (var5.field0314 <= 0.0F || var5.field0758 < 1.0F) {
            var4.remove();
         }
      }
   }

   private void method1977(float var1) {
      Iterator var2 = this.field1155.iterator();

      while (var2.hasNext()) {
         RectangleLayout.HorizontalBounds var3 = var2.next();
         var3.field0566 = var3.field0566 + var3.field1410 * var1;
         var3.field0003 = var3.field0003 + var3.field0957 * var1;
         var3.field1410 *= 0.95F;
         var3.field0957 *= 0.95F;
         var3.field0314 -= var1 * 0.8F;
         if (var3.field0314 <= 0.0F) {
            var2.remove();
         }
      }
   }

   private void method1401(class_332 var1, float var2) {
      class_4587 var3 = var1.method_51448();
      Matrix4f var4 = var3.method_23760().method_23761();
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE);
      RenderSystem.setShader(class_10142.field_53876);
      class_287 var5 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1576);

      for (RectangleLayout.VerticalBounds var7 : this.field1728) {
         float var8 = this.field0566 + var7.field0566;
         float var9 = this.field0003 + var7.field0003;
         float var10 = var7.field0758;
         float var11 = var7.field0314 * var2;
         if (!(var11 < 0.01F)) {
            float var12 = var7.field1268.getRed() / 255.0F;
            float var13 = var7.field1268.getGreen() / 255.0F;
            float var14 = var7.field1268.getBlue() / 255.0F;
            if (this.field0497) {
               float var15 = 0.7F + var7.field0314 * 0.3F;
               var12 *= var15;
               var13 *= var15;
               var14 *= var15;
            }

            int var33 = 12;

            for (int var16 = 0; var16 < var33; var16++) {
               float var17 = (float)(var16 * 3.1415927169270965 * 2.0 / var33);
               float var18 = (float)((var16 + 1) * 3.1415927169270965 * 2.0 / var33);
               float var19 = var8 + (float)Math.cos(var17) * var10;
               float var20 = var9 + (float)Math.sin(var17) * var10;
               float var21 = var8 + (float)Math.cos(var18) * var10;
               float var22 = var9 + (float)Math.sin(var18) * var10;
               var5.method_22918(var4, var8, var9, 0.0F).method_22915(var12, var13, var14, var11 * 0.8F);
               var5.method_22918(var4, var19, var20, 0.0F).method_22915(var12, var13, var14, var11 * 0.3F);
               var5.method_22918(var4, var21, var22, 0.0F).method_22915(var12, var13, var14, var11 * 0.3F);
               var5.method_22918(var4, var8, var9, 0.0F).method_22915(var12, var13, var14, var11 * 0.8F);
            }
         }
      }

      for (RectangleLayout.HorizontalBounds var25 : this.field1155) {
         float var26 = this.field0566 + var25.field0566;
         float var27 = this.field0003 + var25.field0003;
         float var28 = var25.field0758 * var25.field0314;
         float var29 = var25.field0314 * var2;
         if (!(var29 < 0.01F)) {
            float var30 = var25.field1268.getRed() / 255.0F;
            float var31 = var25.field1268.getGreen() / 255.0F;
            float var32 = var25.field1268.getBlue() / 255.0F;
            var5.method_22918(var4, var26 - var28, var27 - var28, 0.0F).method_22915(var30, var31, var32, var29);
            var5.method_22918(var4, var26 - var28, var27 + var28, 0.0F).method_22915(var30, var31, var32, var29 * 0.5F);
            var5.method_22918(var4, var26 + var28, var27 + var28, 0.0F).method_22915(var30, var31, var32, var29 * 0.5F);
            var5.method_22918(var4, var26 + var28, var27 - var28, 0.0F).method_22915(var30, var31, var32, var29);
         }
      }

      try {
         class_286.method_43433(var5.method_60800());
      } catch (Exception var23) {
      }

      RenderSystem.defaultBlendFunc();
      RenderSystem.disableBlend();
   }

   private static class HorizontalBounds {
      float field0566;
      float field0003;
      float field1410;
      float field0957;
      float field0758;
      Color field1268;
      float field0314;

      HorizontalBounds(float var1, float var2, float var3, float var4, float var5, Color var6, float var7) {
         this.field0566 = var1;
         this.field0003 = var2;
         this.field1410 = var3;
         this.field0957 = var4;
         this.field0758 = var5;
         this.field1268 = var6;
         this.field0314 = var7;
      }
   }

   private static class VerticalBounds {
      float field0566;
      float field0003;
      float field1410;
      float field0957;
      float field0758;
      Color field1268;
      float field0314;

      VerticalBounds(float var1, float var2, float var3, float var4, float var5, Color var6, float var7) {
         this.field0566 = var1;
         this.field0003 = var2;
         this.field1410 = var3;
         this.field0957 = var4;
         this.field0758 = var5;
         this.field1268 = var6;
         this.field0314 = var7;
      }
   }
}
