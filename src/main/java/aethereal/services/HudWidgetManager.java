package aethereal;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.Generated;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_4587;
import org.lwjgl.glfw.GLFW;

public class HudWidgetManager implements MinecraftAccess {
   private static final HudWidgetManager field0607 = new HudWidgetManager();
   private final Map<String, HudWidgetState> field0140 = new HashMap<>();
   private final Map<String, float[]> field1509 = new HashMap<>();
   private final Map<String, HudWidgetState.WidgetState> field1033 = new HashMap<>();
   private final Map<String, Boolean> field0210 = new HashMap<>();
   private final int field0459 = 3;
   private final int field1615 = 1;
   private static final float field1538 = 4.0F;
   private boolean field1735 = false;
   private boolean field1161 = false;
   private float field1087 = 0.0F;
   private float field1196 = 0.0F;
   private float field0871 = -1.0F;
   private float field0826 = -1.0F;

   private HudWidgetManager() {
   }

   public void method1019(String var1, float var2, float var3, float var4, float var5) {
      if (this.field1509.containsKey(var1)) {
         float[] var6 = this.field1509.get(var1);
         float var7 = var6[0];
         float var8 = var6[1];
         if (Math.abs(var7) <= 2.0F && Math.abs(var8) <= 2.0F) {
            var7 *= ScreenLayoutHelper.method2047();
            var8 *= ScreenLayoutHelper.method1762();
         }

         this.field0140.put(var1, new HudWidgetState(var1, var7, var8, var4, var5));
         this.field1509.remove(var1);
      } else if (!this.field0140.containsKey(var1)) {
         this.field0140.put(var1, new HudWidgetState(var1, var2, var3, var4, var5));
      }

      HudWidgetState.WidgetState var9 = this.field1033.remove(var1);
      if (var9 != null) {
         this.field0140.get(var1).method0851(var9);
      }

      Boolean var10 = this.field0210.remove(var1);
      if (var10 != null) {
         this.field0140.get(var1).method0345(var10);
      }
   }

   public void method1062(String var1, boolean var2) {
      if (this.field0140.containsKey(var1)) {
         this.field0140.get(var1).method0345(var2);
      } else {
         this.field0210.put(var1, var2);
      }
   }

   public void method1018(String var1, float var2, float var3) {
      if (this.field0140.containsKey(var1)) {
         this.field0140.get(var1).method0665(var2);
         this.field0140.get(var1).method0124(var3);
      } else {
         this.field1509.put(var1, new float[]{var2, var3});
      }
   }

   public void method1033(String var1, HudWidgetState.WidgetState var2) {
      if (this.field0140.containsKey(var1)) {
         this.field0140.get(var1).method0851(var2);
      } else {
         this.field1033.put(var1, var2);
      }
   }

   public HudWidgetState method1002(String var1) {
      return this.field0140.get(var1);
   }

   public Map<String, HudWidgetState> method0560() {
      return this.field0140;
   }

   public void method0025() {
      this.field0140.clear();
   }

   public void method0215(String var1, float var2, float var3) {
      HudWidgetState var4 = this.field0140.get(var1);
      if (var4 != null) {
         var4.method2098(var2);
         var4.method1822(var3);
      }
   }

   public boolean method2079() {
      return this.field0140.values().stream().anyMatch(HudWidgetState::method2195);
   }

   public void method1812() {
      for (HudWidgetState var2 : this.field0140.values()) {
         var2.method0578();
      }
   }

   public void method1400(class_332 var1) {
      if (this.method2079()) {
         class_4587 var2 = var1.method_51448();
         int var3 = (int)ScreenLayoutHelper.method2047();
         int var4 = (int)ScreenLayoutHelper.method1762();
         Color var5 = new Color(553648127, true);

         for (int var6 = 0; var6 < var3; var6 += 3) {
            GuiRenderHelper.method1463(var2, var6, 0.0F, 1.0F, var4, 0.0F, var5);
         }

         for (int var10 = 0; var10 < var4; var10 += 3) {
            GuiRenderHelper.method1463(var2, 0.0F, var10, var3, 1.0F, 0.0F, var5);
         }

         Color var11 = new Color(255, 255, 255, 40);
         float var7 = var3 / 2.0F;
         float var8 = var4 / 2.0F;
         GuiRenderHelper.method1463(var2, var7, 0.0F, 0.5F, var4, 0.0F, var11);
         GuiRenderHelper.method1463(var2, 0.0F, var8, var3, 0.5F, 0.0F, var11);
         if (this.field1161) {
            Color var9 = ThemeColorManager.method1908().method0662(0.6F);
            GuiRenderHelper.method1463(var2, this.field1196 - 0.75F, 0.0F, 1.5F, var4, 0.0F, var9);
         }

         if (this.field1735) {
            Color var12 = ThemeColorManager.method1908().method0662(0.6F);
            GuiRenderHelper.method1463(var2, 0.0F, this.field1087 - 0.75F, var3, 1.5F, 0.0F, var12);
         }

         if (this.field0871 >= 0.0F) {
            Color var13 = ThemeColorManager.method1908().method0662(0.5F);
            GuiRenderHelper.method1463(var2, this.field0871 - 0.5F, 0.0F, 1.0F, var4, 0.0F, var13);
         }

         if (this.field0826 >= 0.0F) {
            Color var14 = ThemeColorManager.method1908().method0662(0.5F);
            GuiRenderHelper.method1463(var2, 0.0F, this.field0826 - 0.5F, var3, 1.0F, 0.0F, var14);
         }
      }
   }

   public void method0309(class_332 var1) {
      for (HudWidgetState var3 : this.field0140.values()) {
         this.method1421(var1, var3);
      }
   }

   public void method1431(class_332 var1, Set<String> var2) {
      for (HudWidgetState var4 : this.field0140.values()) {
         if (var2.contains(var4.method1619())) {
            this.method1421(var1, var4);
         }
      }
   }

   private void method1421(class_332 var1, HudWidgetState var2) {
      if (var2.method2195()) {
         class_4587 var3 = var1.method_51448();
         float var4 = var2.method1946();
         float var5 = var2.method0413() + var2.method2213();
         float var6 = var2.method0355();
         float var7 = var2.method0483();
         Color var8 = ThemeColorManager.method1908().method2063();
         GuiRenderHelper.method1461(var3, var4, var5, var6, var7, 10.0F, 1.5F, 1.0F, var8);
      }
   }

   public boolean method0627(double var1, double var3, int var5) {
      return this.method0628(var1, var3, var5, null);
   }

   public boolean method0628(double var1, double var3, int var5, Set<String> var6) {
      if (var5 == 0) {
         for (HudWidgetState var8 : this.field0140.values()) {
            if ((var6 == null || var6.contains(var8.method1619())) && var8.method0676((float)var1, (float)var3)) {
               var8.method0128((float)var1, (float)var3);
               return true;
            }
         }
      } else if (var5 == 1) {
         boolean var10 = GLFW.glfwGetKey(class_310.method_1551().method_22683().method_4490(), 342) == 1;
         if (var10) {
            for (HudWidgetState var9 : this.field0140.values()) {
               if ((var6 == null || var6.contains(var9.method1619())) && var9.method0676((float)var1, (float)var3) && var9.method1619().equals("NewArmorHUD")) {
                  var9.method1812();
                  DaamkyClient.method2004().method2216().method1634();
                  return true;
               }
            }
         }
      }

      return false;
   }

   public void method0111(double var1, double var3, int var5) {
      if (var5 == 0) {
         boolean var6 = false;

         for (HudWidgetState var8 : this.field0140.values()) {
            if (var8.method2195()) {
               var6 = true;
            }

            var8.method0578();
         }

         if (var6) {
            this.field1735 = false;
            this.field1161 = false;
            this.field0871 = -1.0F;
            this.field0826 = -1.0F;
            DaamkyClient.method2004().method2216().method1634();
         }
      }
   }

   public void method0615(double var1, double var3) {
      this.method0630(var1, var3, null);
   }

   public void method0630(double var1, double var3, Set<String> var5) {
      this.field1735 = false;
      this.field1161 = false;
      this.field0871 = -1.0F;
      this.field0826 = -1.0F;
      float var6 = ScreenLayoutHelper.method2047();
      float var7 = ScreenLayoutHelper.method1762();
      float var8 = var6 / 2.0F;
      float var9 = var7 / 2.0F;

      label135:
      for (HudWidgetState var11 : this.field0140.values()) {
         if (var11.method2195()) {
            if (var5 != null && !var5.contains(var11.method1619())) {
               var11.method0578();
            } else {
               var11.method0701((float)var1, (float)var3, 1, var6, var7);
               float var12 = var11.method1946() + var11.method0355() / 2.0F;
               float var13 = var11.method0413() + var11.method2213() + var11.method0483() / 2.0F;
               if (!var11.method0026() && Math.abs(var12 - var8) < 4.0F) {
                  var11.method0665(Math.round(var8 - var11.method0355() / 2.0F));
                  var11.method0345(true);
                  this.field1161 = true;
                  this.field1196 = var8;
               } else if (!var11.method0026()) {
                  var11.method0345(false);
               }

               if (Math.abs(var13 - var9) < 4.0F) {
                  var11.method0124(Math.round(var9 - var11.method0483() / 2.0F));
                  this.field1735 = true;
                  this.field1087 = var9;
               }

               if (!this.field1161 && !var11.method0026()) {
                  float var14 = var11.method1946();
                  float var15 = var14 + var11.method0355();
                  float var16 = var14 + var11.method0355() / 2.0F;
                  float[] var17 = new float[]{var14, var16, var15};

                  label121:
                  for (HudWidgetState var19 : this.field0140.values()) {
                     if (var19 != var11 && (var5 == null || var5.contains(var19.method1619()))) {
                        float var20 = var19.method1946();
                        float var21 = var20 + var19.method0355();
                        float var22 = var20 + var19.method0355() / 2.0F;
                        float[] var23 = new float[]{var20, var22, var21};

                        for (int var24 = 0; var24 < 3; var24++) {
                           for (int var25 = 0; var25 < 3; var25++) {
                              if (Math.abs(var17[var24] - var23[var25]) < 4.0F) {
                                 float var26 = var23[var25] - var17[var24];
                                 var11.method0665(Math.round(var11.method1946() + var26));
                                 this.field0871 = var23[var25];
                                 break label121;
                              }
                           }
                        }
                     }
                  }
               }

               if (!this.field1735) {
                  float var27 = var11.method0413() + var11.method2213();
                  float var28 = var27 + var11.method0483();
                  float var29 = var27 + var11.method0483() / 2.0F;
                  float[] var30 = new float[]{var27, var29, var28};

                  for (HudWidgetState var32 : this.field0140.values()) {
                     if (var32 != var11 && (var5 == null || var5.contains(var32.method1619()))) {
                        float var33 = var32.method0413() + var32.method2213();
                        float var34 = var33 + var32.method0483();
                        float var35 = var33 + var32.method0483() / 2.0F;
                        float[] var36 = new float[]{var33, var35, var34};

                        for (int var37 = 0; var37 < 3; var37++) {
                           for (int var38 = 0; var38 < 3; var38++) {
                              if (Math.abs(var30[var37] - var36[var38]) < 4.0F) {
                                 float var39 = var36[var38] - var30[var37];
                                 var11.method0124(Math.round(var11.method0413() + var39));
                                 this.field0826 = var36[var38];
                                 continue label135;
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @Generated
   public static HudWidgetManager method1605() {
      return field0607;
   }

   @Generated
   public Map<String, float[]> method1963() {
      return this.field1509;
   }

   @Generated
   public Map<String, HudWidgetState.WidgetState> method0425() {
      return this.field1033;
   }

   @Generated
   public Map<String, Boolean> method0371() {
      return this.field0210;
   }
}
