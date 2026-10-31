package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_4587;

public class ClickGuiScreen extends class_437 implements MinecraftAccess {
   private final List<GuiElement> field0719 = new ArrayList<>();
   private final ModulePanelLayout field0065 = new ModulePanelLayout();
   private final ModuleSearchBar field1453 = new ModuleSearchBar(new SearchFieldState().method1001("Search"));
   private final ClickGuiDashboard field0987 = new ClickGuiDashboard();
   private final Animation field0198 = new Animation(200L, 1.0, false, EasingCurve.field1011);
   private final Animation field0477 = new Animation(280L, 1.0, false, EasingCurve.field0330);
   private long field1616 = -1L;
   private boolean field1574 = false;
   private long field1706 = -1L;
   private long field1138 = -1L;
   private long field1089 = -1L;
   private boolean field1218 = false;
   private static ClickGuiScreen field0876;

   public void method0578() {
      this.field1218 = true;
   }

   public ClickGuiScreen() {
      super(class_2561.method_43470("daamky.menu"));
      field0876 = this;
      this.field0719.addAll(List.of(this.field0065, this.field1453, this.field0987, new PopupManager()));
      DaamkyClient.method2004().method2072().subscribe(this);
   }

   public void method_25394(class_332 var1, int var2, int var3, float var4) {
      if (this.field1574 && this.field1706 > 0L) {
         long var5 = System.currentTimeMillis() - this.field1706;
         if (var5 > 350L) {
            field0796.method_1507(null);
            this.field1574 = false;
            this.field1706 = -1L;
            this.field1138 = -1L;
            return;
         }

         if (var5 > 80L) {
            boolean var7 = true;
            float var8 = 0.0F;

            for (int var9 = 0; var9 < this.field0065.method1620().size(); var9++) {
               ModuleCategoryPanel var10 = (ModuleCategoryPanel)this.field0065.method1620().get(var9);
               if (var10.method1953() == null) {
                  var7 = false;
                  break;
               }

               float var11 = var10.method1953().method0002();
               var8 = Math.max(var8, var11);
               if (var11 > 0.25F) {
                  var7 = false;
               }
            }

            float var30 = this.method1878();
            if (var7 && var30 > 0.25F) {
               var7 = false;
            }

            if (var7) {
               field0796.method_1507(null);
               this.field1574 = false;
               this.field1706 = -1L;
               this.field1138 = -1L;
               return;
            }
         }
      }

      this.method_57734();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      float var27 = ScreenLayoutHelper.method0002();
      int var6 = (int)(var2 / var27);
      int var28 = (int)(var3 / var27);
      var1.method_51448().method_22903();
      var1.method_51448().method_22905(var27, var27, 1.0F);
      class_4587 var29 = var1.method_51448();
      float var31 = 128.0F * ModuleCategory.values().length + 8.0F * ModuleCategory.values().length - 1.0F;
      float var32 = 337.5F;
      float var33 = (ScreenLayoutHelper.method2047() - var31) / 2.0F;
      float var12 = (ScreenLayoutHelper.method1762() - var32) / 2.0F;
      float var13 = 24.0F;
      boolean var14 = field0796.method_22683() != null && field0796.method_22683().method_4498();
      float var15 = var14 ? 34.625F : 22.0F;
      float var16 = var14 ? 62.75F : 50.125F;
      this.field0065.method0670(var33, var12);
      this.field0987.method0670(var33 + (var31 - 112.0F) / 2.0F, var12 + var32 + var15).method0126(112.5F, var13);
      this.field1453.method0670(var33 + (var31 - 112.0F) / 2.0F, var12 + var32 + var16).method0126(112.5F, var13);
      this.field0065.method1414(var1, var6, var28, var4);
      float var17 = this.method1878();
      var29.method_22903();
      float var18 = (1.0F - var17) * 200.0F;
      float var19 = 0.85F + var17 * 0.15F;
      float var20 = var17;
      float var21 = this.field0987.method0530() + this.field0987.method2047() / 2.0F;
      float var22 = this.field0987.method0002() + this.field0987.method1762() / 2.0F;
      var29.method_22903();
      var29.method_46416(var21, var22 + var18, 0.0F);
      var29.method_22905(var19, var19, var19);
      var29.method_46416(-var21, -var22, 0.0F);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var20);
      this.field0987.method1414(var1, var6, var28, var4);
      var29.method_22909();
      float var23 = this.field1453.method0530() + this.field1453.method2047() / 2.0F;
      float var24 = this.field1453.method0002() + this.field1453.method1762() / 2.0F;
      var29.method_22903();
      var29.method_46416(var23, var24 + var18, 0.0F);
      var29.method_22905(var19, var19, var19);
      var29.method_46416(-var23, -var24, 0.0F);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var20);
      this.field1453.method1414(var1, var6, var28, var4);
      var29.method_22909();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      var29.method_22909();
      var29.method_22903();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.field0198.method0002());

      for (int var25 = 0; var25 < this.field0719.size(); var25++) {
         GuiElement var26 = this.field0719.get(var25);
         if (var26 != this.field0065 && var26 != this.field0987 && var26 != this.field1453) {
            var26.method1414(var1, var6, var28, var4);
         }
      }

      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      var29.method_22909();
      var1.method_51448().method_22909();
   }

   private float method1878() {
      if (this.field1616 == -1L) {
         return this.field1574 ? 1.0F : 0.0F;
      }

      long var1 = System.currentTimeMillis() - this.field1616;
      long var3 = 140L;
      if (var1 < var3) {
         return this.field1574 ? 1.0F : 0.0F;
      }

      long var5 = var1 - var3;
      if (var5 >= 280L) {
         return this.field1574 ? 0.0F : 1.0F;
      }

      double var7 = var5 / 280.0;
      double var9 = 1.0 - Math.pow(1.0 - var7, 3.0);
      return this.field1574 ? (float)(1.0 - var9) : (float)var9;
   }

   @EventHandler
   private void keyEvent(KeyEvent var1) {
      if (var1.method1763() == 344) {
         long var2 = System.currentTimeMillis();
         if (this.field1089 > 0L && var2 - this.field1089 < 300L) {
            return;
         }

         this.field1089 = var2;
         if (field0796.field_1755 == null) {
            // Respect Design setting: only open dropdown style when selected
            ClickGUI clickGui = ClickGUI.method1683();
            if (clickGui != null && clickGui.getDesign() == ClickGUI.Design.DAAMKY) {
               return; // DaamkyClickGuiScreen handles opening
            }
            field0796.method_1507(this);
            this.field1574 = false;
            this.field1706 = -1L;
            this.field1138 = System.currentTimeMillis();
            this.field0198.method1570(true);
            this.field0198.method1634();
            this.field0065.method1570(true);
            this.field1616 = System.currentTimeMillis();
            this.field0477.method1634();
            this.field0477.method1570(true);
            this.field1453.method1951().method1792().setLength(0);
            this.field1453.method1951().method1570(false);
         } else if (field0796.field_1755 == this && !this.field1574) {
            if (this.field1138 > 0L && var2 - this.field1138 < 500L) {
               return;
            }

            this.method_25419();
         }
      }
   }

   public void method_25419() {
      if (!this.field1574) {
         DaamkyClient.method2004().method2216().method1634();
         ColorSettingWidget.method1973();
         BlockListSettingWidget.method1973();
         KeyBindListSettingWidget.method1973();
         NumberListSettingWidget.method1973();
         NumberSettingWidget.method1973();
         this.field0987.method1973();
         PopupManager var1 = PopupManager.method0416();
         if (var1 != null) {
            var1.method1973();
         }

         this.field1574 = true;
         this.field1706 = System.currentTimeMillis();
         this.field0198.method1570(false);
         this.field0198.method1634();
         this.field0065.method1570(false);
         this.field1616 = System.currentTimeMillis();
         this.field0477.method1634();
         this.field0477.method1570(false);
         this.field1453.method1951().method1792().setLength(0);
         this.field1453.method1951().method1570(false);
      }
   }

   public boolean method_25421() {
      return false;
   }

   public void method_25432() {
      super.method_25432();
      ColorSettingWidget.method0430();
      BlockListSettingWidget.method2228();
      KeyBindListSettingWidget.method2228();
      NumberListSettingWidget.method0430();
      this.field0987.method1973();
      PopupManager var1 = PopupManager.method0416();
      if (var1 != null) {
         var1.method1620().clear();
      }

      this.field1574 = false;
      this.field1706 = -1L;
      this.field1138 = -1L;
   }

   public boolean method_25402(double var1, double var3, int var5) {
      float var6 = ScreenLayoutHelper.method0002();
      double var7 = var1 / var6;
      double var9 = var3 / var6;

      for (GuiElement var12 : this.field0719) {
         if (var12 instanceof PopupManager) {
            if (var12.method0627(var7, var9, var5)) {
               return true;
            }
            break;
         }
      }

      if (this.field0987.method0376()) {
         this.field0987.method0430();
         return true;
      }

      for (int var13 = 0; var13 < this.field0719.size(); var13++) {
         GuiElement var14 = this.field0719.get(var13);
         if (!(var14 instanceof PopupManager) && var14.method0627(var7, var9, var5)) {
            return true;
         }
      }

      return false;
   }

   public boolean method_25406(double var1, double var3, int var5) {
      float var6 = ScreenLayoutHelper.method0002();
      double var7 = var1 / var6;
      double var9 = var3 / var6;
      NumberSettingWidget.method1973();

      for (int var11 = 0; var11 < this.field0719.size(); var11++) {
         GuiElement var12 = this.field0719.get(var11);
         if (var12 instanceof PopupManager) {
            if (var12.method0112(var7, var9, var5)) {
               return true;
            }
            break;
         }
      }

      for (int var13 = 0; var13 < this.field0719.size(); var13++) {
         GuiElement var14 = this.field0719.get(var13);
         if (!(var14 instanceof PopupManager) && var14.method0112(var7, var9, var5)) {
            return true;
         }
      }

      return false;
   }

   public boolean method_25404(int var1, int var2, int var3) {
      for (int var4 = 0; var4 < this.field0719.size(); var4++) {
         if (this.field0719.get(var4).method0746(var1, var2, var3)) {
            return false;
         }
      }

      if (var1 == 256 && !this.field1574) {
         this.method_25419();
      }

      return true;
   }

   public boolean method_16803(int var1, int var2, int var3) {
      for (int var4 = 0; var4 < this.field0719.size(); var4++) {
         if (this.field0719.get(var4).method0149(var1, var2, var3)) {
            return true;
         }
      }

      return false;
   }

   public boolean method_25401(double var1, double var3, double var5, double var7) {
      float var9 = ScreenLayoutHelper.method0002();
      double var10 = var1 / var9;
      double var12 = var3 / var9;

      for (int var14 = 0; var14 < this.field0719.size(); var14++) {
         GuiElement var15 = this.field0719.get(var14);
         if (var15 instanceof PopupManager) {
            if (var15.method0623(var10, var12, var5, var7)) {
               return true;
            }
            break;
         }
      }

      for (int var16 = 0; var16 < this.field0719.size(); var16++) {
         GuiElement var17 = this.field0719.get(var16);
         if (!(var17 instanceof PopupManager) && var17.method0623(var10, var12, var5, var7)) {
            return true;
         }
      }

      return false;
   }

   public boolean method_25400(char var1, int var2) {
      if (this.field1218) {
         this.field1218 = false;
         return true;
      }

      for (int var3 = 0; var3 < this.field0719.size(); var3++) {
         if (this.field0719.get(var3).method0607(var1, var2)) {
            return true;
         }
      }

      return false;
   }

   @Generated
   public List<GuiElement> method0019() {
      return this.field0719;
   }

   @Generated
   public ModulePanelLayout method2052() {
      return this.field0065;
   }

   @Generated
   public ModuleSearchBar method1775() {
      return this.field1453;
   }

   @Generated
   public ClickGuiDashboard method1609() {
      return this.field0987;
   }

   @Generated
   public Animation method1953() {
      return this.field0198;
   }

   @Generated
   public Animation method0418() {
      return this.field0477;
   }

   @Generated
   public long method0357() {
      return this.field1616;
   }

   @Generated
   public boolean method0499() {
      return this.field1574;
   }

   @Generated
   public long method2215() {
      return this.field1706;
   }

   @Generated
   public long method2184() {
      return this.field1138;
   }

   @Generated
   public long method2255() {
      return this.field1089;
   }

   @Generated
   public static ClickGuiScreen method1904() {
      return field0876;
   }
}
