package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import net.minecraft.class_332;

public class SettingsPopover extends PopupPanel {
   private static final float field0566 = 120.0F;
   private static final float field0003 = 100.0F;
   private static final long field1412 = 200L;
   private final SettingList field0988;
   private boolean field0219 = false;
   private boolean field0497 = false;
   private long field1616 = 0L;
   private float field1538;
   private float field1704;

   public SettingsPopover(List<SettingWidget> var1) {
      super(new GuiElement() {
         @Override
         public float method2047() {
            return 120.0F;
         }

         @Override
         public float method1762() {
            return 100.0F;
         }
      }, true);
      this.field0988 = (SettingList)new SettingList(var1).method0126(120.0F, -1.0F);
   }

   @Override
   public float method2047() {
      return 128.0F;
   }

   @Override
   public float method1762() {
      return this.field0988.method1762() + 8.0F;
   }

   public void method2100(float var1, float var2) {
      this.field1538 = var1;
      this.field1704 = var2;
      this.field0988.method0126(120.0F, -1.0F);
      this.field0988.method0430();
      float var3 = var1 - this.method2047() / 2.0F;
      float var4 = var2 - this.method1762() - 4.0F;
      this.method0670(var3, var4);
      this.method1570(true);
      this.field0497 = true;
      this.field0219 = true;
      this.field1616 = System.currentTimeMillis();
      if (!PopupManager.method0416().method1620().contains(this)) {
         PopupManager.method0416().method1620().add(this);
      }
   }

   @Override
   public void method1973() {
      if (this.field0219 && this.field0497) {
         this.field0497 = false;
         this.field1616 = System.currentTimeMillis();
      }
   }

   public void method0430() {
      this.field0219 = false;
      this.field0497 = false;
      PopupManager.method0416().method1620().remove(this);
   }

   public boolean method0376() {
      return this.field0219 && this.field0497;
   }

   @Override
   public boolean method1825(float var1, float var2) {
      return this.field0219 && !this.field0497 && !this.method2030()
         ? true
         : this.field0219
            && this.field0497
            && MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), var1, var2);
   }

   private float method1741() {
      long var1 = System.currentTimeMillis() - this.field1616;
      float var3 = Math.min(1.0F, (float)var1 / 200.0F);
      var3 = (float)EasingCurve.field0330.method0608(var3);
      return this.field0497 ? var3 : 1.0F - var3;
   }

   private boolean method2030() {
      return System.currentTimeMillis() - this.field1616 >= 200L;
   }

   @Override
   public void method1414(class_332 var1, int var2, int var3, float var4) {
      if (this.field0219) {
         float var5 = this.method1741();
         if (!this.field0497 && this.method2030()) {
            this.field0219 = false;
            PopupManager.method0416().method1620().remove(this);
         } else if (!(var5 <= 0.01F)) {
            float var6 = this.method2047();
            float var7 = this.method1762();
            float var8 = this.field1704 - var7 - 4.0F;
            if (Math.abs(this.method0002() - var8) > 0.1F) {
               this.method0670(this.method0530(), var8);
            }

            float var9 = this.method0530();
            float var10 = this.method0002() + (1.0F - var5) * 8.0F;
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var5);
            GuiRenderHelper.method1462(var1.method_51448(), var9, var10, var6, var7, 6.0F, ThemePalette.field0367.get(), ThemePalette.field0134);
            GuiRenderHelper.method1463(var1.method_51448(), var9, var10, var6, var7, 6.0F, ThemePalette.field0930.get());
            GuiRenderHelper.method1461(var1.method_51448(), var9, var10, var6, var7, 6.0F, 0.5F, 0.5F, ThemePalette.field0884);
            this.field0988.method0670(var9 + 4.0F, var10 + 4.0F);
            this.field0988.method1414(var1, var2, var3, var4);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         }
      }
   }

   @Override
   public boolean method0627(double var1, double var3, int var5) {
      if (this.field0219 && this.field0497) {
         return !MathHelper.method0689(this.method0530(), this.method0002(), this.method2047(), this.method1762(), (float)var1, (float)var3)
            ? false
            : this.field0988.method0627(var1, var3, var5);
      } else {
         return false;
      }
   }

   @Override
   public boolean method0112(double var1, double var3, int var5) {
      return this.field0219 && this.field0497 ? this.field0988.method0112(var1, var3, var5) : false;
   }

   @Override
   public boolean method0746(int var1, int var2, int var3) {
      return this.field0219 && this.field0497 ? this.field0988.method0746(var1, var2, var3) : false;
   }

   @Override
   public boolean method0607(char var1, int var2) {
      return this.field0219 && this.field0497 ? this.field0988.method0607(var1, var2) : false;
   }
}
