package aethereal;

import java.awt.Color;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_4587;

public class IconDebug extends Module {
   private static final char[] field0170;
   private static final int field1411 = 10;
   private static final float field0957 = 22.0F;
   private static final float field0177 = 26.0F;
   private static final float field0458 = 6.0F;
   private static final Color field1641;
   private static final Color field1564;
   private static final Color field1726;
   private static final Color field1153;
   private static final Color field1104;

   public IconDebug() {
      super("IconDebug", ModuleCategory.field1004, "Shows every daamkyicons glyph with its char label");
      this.method1013("Показывает все глифы DAAMKYICONS");
   }

   @EventHandler
   public void onRender2D(HudRenderEvent var1) {
      if (this.method2195()) {
         if (field0796.field_1724 != null) {
            class_4587 var2 = var1.method1806().method_51448();
            FontSize var3 = Fonts.field0774.method0654(11.0F);
            FontSize var4 = Fonts.field0075.method0654(5.0F);
            FontSize var5 = Fonts.field0075.method0654(6.0F);
            int var6 = (int)Math.ceil(field0170.length / 10.0);
            float var7 = 14.0F;
            float var8 = 232.0F;
            float var9 = 6.0F + var7 + var6 * 26.0F + 6.0F;
            float var10 = 10.0F;
            float var11 = 10.0F;
            GuiRenderHelper.method1463(var2, var10, var11, var8, var9, 6.0F, field1641);
            String var12 = "daamkyicons debug";
            float var13 = Fonts.field0075.method1016(var12, 6.0F);
            GuiRenderHelper.method1491(var2, var5, var12, var10 + (var8 - var13) / 2.0F, var11 + 6.0F, field1104);
            float var14 = var11 + 6.0F + var7;

            for (int var15 = 0; var15 < field0170.length; var15++) {
               int var16 = var15 % 10;
               int var17 = var15 / 10;
               float var18 = var10 + 6.0F + var16 * 22.0F;
               float var19 = var14 + var17 * 26.0F;
               GuiRenderHelper.method1463(var2, var18, var19, 20.0F, 24.0F, 3.0F, field1564);
               String var20 = String.valueOf(field0170[var15]);
               String var21 = var20;
               float var22 = var3.method0998(var20);
               float var23 = var3.method0530();
               float var24 = var4.method0998(var21);
               GuiRenderHelper.method1491(var2, var3, var20, var18 + (20.0F - var22) / 2.0F, var19 + 3.0F, field1726);
               GuiRenderHelper.method1491(var2, var4, var21, var18 + (20.0F - var24) / 2.0F, var19 + 3.0F + var23 + 1.0F, field1153);
            }
         }
      }
   }

   static {
      int var0 = 26;
      int var1 = 23;
      field0170 = new char[var0 + var1];

      for (int var2 = 0; var2 < var0; var2++) {
         field0170[var2] = (char)(65 + var2);
      }

      for (int var3 = 0; var3 < var1; var3++) {
         field0170[var0 + var3] = (char)(97 + var3);
      }

      field1641 = new Color(15, 15, 20, 220);
      field1564 = new Color(30, 30, 40, 200);
      field1726 = new Color(255, 255, 255);
      field1153 = new Color(160, 160, 180);
      field1104 = new Color(255, 255, 255);
   }
}
