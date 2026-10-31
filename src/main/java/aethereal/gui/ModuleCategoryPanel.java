package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import lombok.Generated;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_4587;

public class ModuleCategoryPanel extends GuiElement {
   private static FontSize field0624;
   private static FontSize field0055;
   private static boolean field1527 = false;
   private final ModuleCategory field1004;
   private float field0177;
   private float field0458;
   private float field1614 = 0.0F;
   private Animation field1561;
   private int field1705;

   private static void method0375() {
      if (!field1527) {
         field0624 = Fonts.field0774.method0654(8.0F);
         field0055 = Fonts.field0075.method0654(8.0F);
         field1527 = true;
      }
   }

   public ModuleCategoryPanel(ModuleCategory var1) {
      this.field1004 = var1;
      DaamkyClient.method2004()
         .method1783()
         .method0019()
         .stream()
         .filter(var1x -> var1x.method2220().equals(var1) && !var1x.method1891())
         .sorted((var0, var1x) -> var0.method0423().compareToIgnoreCase(var1x.method0423()))
         .forEach(var1x -> this.method1620().add(new ModuleCard(var1x)));
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      method0375();
      this.field0458 = class_3532.method_16439(0.05F, this.field0458, this.field0177);
      float var5 = this.field1561 != null ? this.field1561.method0002() : 1.0F;
      ClickGUI.AnimationStyle var6 = ClickGUI.method1683() != null ? ClickGUI.method1683().method1706() : ClickGUI.AnimationStyle.field0603;
      float var12 = 0.0F;
      float var8;
      float var9;
      float var10;
      float var11;
      float var27;
      if (var6 == ClickGUI.AnimationStyle.field0040) {
         float var13 = ScreenLayoutHelper.method2047();
         float var14 = ScreenLayoutHelper.method1762();
         float var15 = var13 / 2.0F;
         float var16 = var14 + 50.0F;
         float var17 = this.method0530() + this.method2047() / 2.0F;
         float var18 = this.method0002() + this.method1762() / 2.0F;
         float var19 = 1.0F - var5;
         float var20 = var19 * var19 * (3.0F - 2.0F * var19);
         float var21 = Math.min(1.0F, var20 * 1.2F);
         float var22 = var20 * 0.7F;
         float var23 = (var21 + var22) / 2.0F;
         var8 = (var15 - var17) * var23;
         var27 = (var16 - var18) * var23;
         var27 += (var21 - var22) * 80.0F;
         float var24 = var5;
         float var25 = Math.min(1.0F, var5 * 1.3F);
         var10 = 0.01F + var24 * var24 * 0.99F;
         var9 = 0.1F + var25 * 0.9F;
         float var26 = var17 - var15;
         var12 = (1.0F - var5) * 0.25F * Math.signum(var26);
         var11 = var5 < 0.3F ? var5 / 0.3F : 1.0F - (1.0F - var5) * 0.5F;
      } else {
         var8 = 0.0F;
         var27 = (1.0F - var5) * 450.0F;
         var9 = var10 = 0.8F + var5 * 0.2F;
         var11 = var5;
      }

      class_4587 var28 = var1.method_51448();
      var28.method_22903();
      float var29 = this.method0530() + this.method2047() / 2.0F;
      float var30 = this.method0002() + this.method1762() / 2.0F;
      if (var6 == ClickGUI.AnimationStyle.field0040) {
         var28.method_46416(var29 + var8, var30 + var27, 0.0F);
         if (var12 != 0.0F) {
            var28.method_23760().method_23761().m10(var12);
         }

         var28.method_22905(var9, var10, 1.0F);
         var28.method_46416(-(var29 + var8), -(var30 + var27), 0.0F);
      } else {
         var28.method_46416(var29, var30 + var27, 0.0F);
         var28.method_22905(var9, var10, 1.0F);
         var28.method_46416(-var29, -(var30 - var27), 0.0F);
         var28.method_46416(0.0F, var27, 0.0F);
      }

      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var11);
      float var31 = this.method0530()
         + (this.method2047() - (field0055.method0998(this.field1004.name()) + field0624.method0998(this.field1004.method0557()) + 4.0F)) / 2.0F;
      GuiRenderHelper.method1462(
         var1.method_51448(),
         this.method0530(),
         this.method0002(),
         this.method2047(),
         this.method1762(),
         8.0F,
         ThemePalette.field0367.get(),
         ThemePalette.field0134
      );
      GuiRenderHelper.method1463(
         var1.method_51448(), this.method0530(), this.method0002(), this.method2047(), this.method1762(), 8.0F, ThemePalette.field0930.get()
      );
      GuiRenderHelper.method1461(
         var1.method_51448(), this.method0530(), this.method0002(), this.method2047(), this.method1762(), 8.0F, 0.5F, 0.5F, ThemePalette.field1210
      );
      GuiRenderHelper.method1491(
         var1.method_51448(), field0624, this.field1004.method0557(), var31, this.method0002() + 8.0F, ThemePalette.field1514.get()
      );
      Color var32 = ThemePalette.field0789;
      GuiRenderHelper.method1491(
         var1.method_51448(),
         field0055,
         this.field1004.name(),
         var31 + field0624.method0998(this.field1004.method0557()) + 4.0F,
         this.method0002() + 8.0F,
         var32
      );
      String var33 = ClickGuiScreen.method1904().method1775().method1951().method1792().toString().toLowerCase();
      float var34 = this.method0002() + 25.5F;
      float var35 = var34 + (this.method1762() - 27.5F);
      float var36 = this.method0002() + 25.5F;
      float var37 = 0.0F;

      for (int var38 = 0; var38 < this.method1620().size(); var38++) {
         ModuleCard var40 = (ModuleCard)this.method1620().get(var38);
         if (var40.method1954().method0423().toLowerCase().contains(var33)) {
            var40.method0126(this.method2047() - 8.0F, -1488.0F).method0670(this.method0530() + 4.0F, var36 + var37 + this.field0458);
            var37 += var40.method1762() + 2.0F;
         }
      }

      this.field0177 = Math.clamp(this.field0177, Math.min(0.0F, this.method1762() - var37 - 25.5F), 0.0F);
      GuiRenderHelper.method1404(var1, this.method0530(), var34, this.method2047(), this.method1762() - 27.5F);

      for (int var39 = 0; var39 < this.method1620().size(); var39++) {
         ModuleCard var41 = (ModuleCard)this.method1620().get(var39);
         if (var41.method1954().method0423().toLowerCase().contains(var33)) {
            float var42 = var41.method0002();
            float var43 = var41.method1762();
            var41.method2100(var34, var35);
            if (var42 + var43 >= var34 - 20.0F && var42 <= var35 + 20.0F) {
               var41.method1414(var1, var2, var3, var4);
            }
         }
      }

      GuiRenderHelper.method1400(var1);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      var28.method_22909();
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      if (!MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3)) {
         return false;
      }

      String var6 = ClickGuiScreen.method1904().method1775().method1951().method1792().toString().toLowerCase();

      for (int var7 = 0; var7 < this.method1620().size(); var7++) {
         ModuleCard var8 = (ModuleCard)this.method1620().get(var7);
         if (var8.method1954().method0423().toLowerCase().contains(var6) && var8.method0627(var1, var3, var5)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean method0112(double var1, double var3, int var5) {
      String var6 = ClickGuiScreen.method1904().method1775().method1951().method1792().toString().toLowerCase();

      for (int var7 = 0; var7 < this.method1620().size(); var7++) {
         ModuleCard var8 = (ModuleCard)this.method1620().get(var7);
         if (var8.method1954().method0423().toLowerCase().contains(var6) && var8.method0112(var1, var3, var5)) {
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean method0623(double var1, double var3, double var5, double var7) {
      if (super.method0623(var1, var3, var5, var7)) {
         return true;
      } else if (MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3)) {
         this.field0177 = (float)(this.field0177 + var7 * 20.0);
         return true;
      } else {
         return false;
      }
   }

   @Generated
   public Animation method1953() {
      return this.field1561;
   }

   @Generated
   public void method0865(Animation var1) {
      this.field1561 = var1;
   }

   @Generated
   public int method0414() {
      return this.field1705;
   }

   @Generated
   public void method0729(int var1) {
      this.field1705 = var1;
   }
}
