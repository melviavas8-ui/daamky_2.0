package aethereal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_243;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_4184;
import net.minecraft.class_4587;

public class Waypoint extends Module {
   private final BooleanSetting field0034 = new BooleanSetting("waypoint.showdistance", true)
      .method1007("Show Distance")
      .method0210("Show the distance")
      .method2130("Отображать дистанцию");
   private static final class_2960 field1522 = class_2960.method_60655("daamky", "textures/glow.png");
   private static final float field0957 = 6.0F;
   private static final float field0177 = 3.0F;
   private static final float field0458 = 6.0F;
   private static final float field1614 = 7.0F;
   private static final float field1538 = 16.0F;
   private static final Color field1726 = new Color(255, 255, 255, 80);
   private static final Color field1153 = new Color(227, 227, 227);
   private static final Color field1104 = new Color(255, 255, 255, 184);

   public Waypoint() {
      super("Waypoint", ModuleCategory.field1004, "Renders for saved waypoints");
      this.method1013("Метки сохранённых вейпойнтов");
      this.method0213("W");
   }

   @EventHandler
   public void onRender(Render2DEvent var1) {
      if (!method1974()) {
         List var2 = new ArrayList<>(WaypointManager.method0552().method0424());
         WaypointManager.Waypoint var3 = WaypointManager.method0552().method0014();
         if (var3 != null) {
            var2.add(var3);
         }

         if (!var2.isEmpty()) {
            class_332 var4 = var1.method1806();
            class_4587 var5 = var4.method_51448();
            class_4184 var6 = field0796.field_1773.method_19418();
            class_243 var7 = var6.method_19326();
            float var8 = (float)Math.toRadians(var6.method_19330());
            float var9 = (float)Math.toRadians(var6.method_19329());
            double var10 = Math.cos(var9);
            double var12 = -Math.sin(var8) * var10;
            double var14 = -Math.sin(var9);
            double var16 = Math.cos(var8) * var10;
            float var18 = ScreenLayoutHelper.method2047();
            float var19 = ScreenLayoutHelper.method1762();
            float var20 = var18 / 2.0F;
            float var21 = var19 / 2.0F;
            float var22 = 30.0F;
            GuiRenderHelper.method0578();

            try {
               for (WaypointManager.Waypoint var24 : var2) {
                  class_243 var25 = new class_243(var24.method0001() + 0.5, var24.method2046() + 1.0, var24.method1761() + 0.5);
                  double var26 = var7.method_1022(var25);
                  double var28 = var25.field_1352 - var7.field_1352;
                  double var30 = var25.field_1351 - var7.field_1351;
                  double var32 = var25.field_1350 - var7.field_1350;
                  double var34 = var28 * var12 + var30 * var14 + var32 * var16;
                  class_243 var36 = ProjectionHelper.method1299(var25);
                  float var37 = (float)var36.field_1352;
                  float var38 = (float)var36.field_1351;
                  if (var34 <= 0.0) {
                     var37 = 2.0F * var20 - var37;
                     var38 = 2.0F * var21 - var38;
                  }

                  boolean var39 = var34 > 0.0 && var37 >= 0.0F && var37 <= var18 && var38 >= 0.0F && var38 <= var19;
                  if (!var39) {
                     float var40 = var37 - var20;
                     float var41 = var38 - var21;
                     float var42 = (float)Math.sqrt(var40 * var40 + var41 * var41);
                     if (var42 < 0.001F) {
                        var40 = 0.0F;
                        var41 = -1.0F;
                     } else {
                        var40 /= var42;
                        var41 /= var42;
                     }

                     float var43 = var20 - var22;
                     float var44 = var21 - var22;
                     float var45 = Math.abs(var40) > 0.001F ? var43 / Math.abs(var40) : Float.POSITIVE_INFINITY;
                     float var46 = Math.abs(var41) > 0.001F ? var44 / Math.abs(var41) : Float.POSITIVE_INFINITY;
                     float var47 = Math.min(var45, var46);
                     var37 = var20 + var40 * var47;
                     var38 = var21 + var41 * var47;
                  }

                  float var52 = 0.9116279F;
                  this.method1493(var5, var24, var37, var38, var52, var26);
               }
            } finally {
               GuiRenderHelper.method0025();
            }
         }
      }
   }

   private void method1493(class_4587 var1, WaypointManager.Waypoint var2, float var3, float var4, float var5, double var6) {
      FontSize var8 = Fonts.field0075.method0654(6.0F);
      String var9 = var2.method0557();
      boolean var10 = var9 != null && !var9.isEmpty();
      String var11 = "X " + (int)Math.floor(var2.method0001()) + ", Y " + (int)Math.floor(var2.method2046()) + ", Z " + (int)Math.floor(var2.method1761());
      boolean var12 = this.field0034.method1938();
      String var13 = var12 ? Math.round(var6) + "m" : "";
      Color var14 = new Color(var2.method1604() & 16777215);
      float var15 = 5.0F;
      float var16 = 4.0F;
      float var17 = 7.0F;
      float var18 = var10 ? var8.method0998(var9) : 0.0F;
      float var19 = var8.method0998(var11);
      float var20 = var12 ? var8.method0998(var13) : 0.0F;
      float var21 = var16 + 7.0F + var15 + 1.0F + var15 + var19;
      if (var10) {
         var21 += var15 + 1.0F + var15 + var18;
      }

      if (var12) {
         var21 += var15 + 1.0F + var15 + var20;
      }

      var21 += var16;
      float var22 = var8.method0530() + 7.5F;
      float var23 = var21;
      float var24 = -var23 / 2.0F;
      float var25 = -var22;
      float var26 = ThemePalette.field0367.get();
      var1.method_22903();
      var1.method_46416(var3, var4 - 4.0F, 0.0F);
      var1.method_22905(var5, var5, 1.0F);
      Color var27 = ThemePalette.field0930.get();
      Color var28 = ThemePalette.field1564;
      GuiRenderHelper.method1462(var1, var24, var25, var23, var22, 6.0F, var26, ThemePalette.field0134);
      GuiRenderHelper.method1463(var1, var24, var25, var23, var22, 6.0F, var27);
      GuiRenderHelper.method1461(var1, var24, var25, var23, var22, 6.0F, 0.5F, 0.5F, var28);
      float var29 = var25 + var22 / 2.0F;
      float var30 = var29 - var8.method0530() / 2.0F;
      float var31 = var29 - var17 / 2.0F;
      float var32 = var24 + var16;
      Color var33 = new Color(var14.getRed(), var14.getGreen(), var14.getBlue(), 200);
      GuiRenderHelper.method1466(var1, var32 + 3.5F - 8.0F, var29 - 8.0F, 16.0F, 16.0F, 8.0F, field1522, var33);
      GuiRenderHelper.method0326(var1, var32, var29 - 3.5F, 7.0F, 7.0F, 2.5F, var14);
      var32 += 7.0F;
      if (var10) {
         var32 += var15;
         GuiRenderHelper.method0326(var1, var32, var31, 1.0F, var17, 1.0F, field1726);
         var32 += 1.0F + var15;
         GuiRenderHelper.method1491(var1, var8, var9, var32, var30, field1153);
         var32 += var18;
      }

      var32 += var15;
      GuiRenderHelper.method0326(var1, var32, var31, 1.0F, var17, 1.0F, field1726);
      var32 += 1.0F + var15;
      GuiRenderHelper.method1491(var1, var8, var11, var32, var30, field1104);
      var32 += var19;
      if (var12) {
         var32 += var15;
         GuiRenderHelper.method0326(var1, var32, var31, 1.0F, var17, 1.0F, field1726);
         var32 += 1.0F + var15;
         GuiRenderHelper.method1491(var1, var8, var13, var32, var30, field1104);
      }

      var1.method_22909();
   }
}
