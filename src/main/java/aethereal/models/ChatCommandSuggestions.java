package aethereal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import org.lwjgl.glfw.GLFW;

public class ChatCommandSuggestions {
   private static final float field0566 = 6.5F;
   private static final float field0003 = 8.0F;
   private static final float field1410 = 17.0F;
   private static final float field0957 = 10.0F;
   private static final float field0758 = 14.0F;
   private static final float field1242 = 6.0F;
   private static final float field0314 = 8.0F;
   private static final float field0177 = 18.0F;
   private static final float field0458 = 1.0F;
   private static final float field1614 = 6.0F;
   private static final float field1538 = 4.0F;
   private static final Color field1726 = new Color(21, 21, 27, 224);
   private static final Color field1153 = new Color(255, 255, 255, 255);
   private static final Color field1104 = new Color(255, 255, 255);
   private static final Color field1210 = new Color(255, 255, 255, 184);
   private boolean field0890 = false;
   private final StringBuilder field0842 = new StringBuilder();
   private int field0911 = 0;
   private int field1332 = -1;
   private final Animation field1305 = new Animation(250L, 1.0, false, EasingCurve.field1011);
   private final Animation field1382 = new Animation(280L, 1.0, false, EasingCurve.field0203);
   private long field0387 = 0L;
   private static final long field0353 = 80L;
   private float field0423 = 0.0F;
   private float field0255 = 0.0F;
   private final List<ChatCommandSuggestions.Suggestion> field0238 = new ArrayList<>();
   private int field0290 = -1;

   public boolean method0579() {
      return this.field0890;
   }

   public void method1013(String var1) {
      this.field0890 = true;
      this.field0842.setLength(0);
      this.field0842.append(var1);
      this.field0911 = var1.length();
      this.field1332 = -1;
      this.field1305.method1634();
      this.field1305.method1570(true);
      this.field1382.method1634();
      this.field0387 = System.currentTimeMillis();
      this.field0238.clear();
      this.field0290 = -1;
      this.method1973();
   }

   public void method0025() {
      this.field0890 = false;
      this.field0842.setLength(0);
      this.field0911 = 0;
      this.field1332 = -1;
      this.field0238.clear();
      this.field0290 = -1;
   }

   public void method1402(class_332 var1, float var2, float var3) {
      if (this.field0890) {
         FontSize var4 = Fonts.field0075.method0654(6.5F);
         FontSize var5 = Fonts.field0075.method0654(6.0F);
         class_4587 var6 = var1.method_51448();
         float var7 = this.field1305.method0002();
         if (!(var7 <= 0.01F)) {
            long var8 = System.currentTimeMillis() - this.field0387;
            if (var8 >= 80L && !this.field1382.method0376()) {
               this.field1382.method1634();
               this.field1382.method1570(true);
            }

            float var10 = this.field1382.method0002();
            String var11 = this.field0842.toString();
            float var12 = var4.method0998(var11);
            float var13 = var4.method0530();
            Color var14 = ThemeColorManager.method1908().method2063();
            Color var15 = ThemeColorManager.method1908().method0141(224);
            float var16 = 50.0F;
            float var17 = Math.max(var16, var12 + 16.0F + 2.0F);
            String var18 = this.method0368();
            String var19 = var18.isEmpty() ? this.method0423() : "";
            String var20 = var18.isEmpty() ? var19 : var18;
            if (!var20.isEmpty()) {
               var17 = Math.max(var17, var12 + var4.method0998(var20) + 16.0F + 2.0F);
            }

            this.field0423 = class_3532.method_16439(0.12F, this.field0423, var17);
            float var21 = 4.0F;
            float var22 = var3 - 17.0F - 6.0F;
            float var23 = Math.max(0.3F, var7);
            float var24 = Math.max(0.3F, var7 * var7);
            float var25 = var21;
            float var26 = var22 + 8.5F;
            var6.method_22903();
            var6.method_46416(var25, var26, 0.0F);
            var6.method_22905(var23, var24, 1.0F);
            var6.method_46416(-var25, -var26, 0.0F);
            Color var27 = this.method0964(var15, var7);
            Color var28 = new Color(255, 255, 255, Math.max(0, (int)(10.0F * var7)));
            GuiRenderHelper.method1462(var6, var21, var22, this.field0423, 17.0F, 10.0F, 14.0F, this.method0964(field1153, var7));
            GuiRenderHelper.method1463(var6, var21, var22, this.field0423, 17.0F, 10.0F, var27);
            GuiRenderHelper.method1461(var6, var21, var22, this.field0423, 17.0F, 10.0F, 0.5F, 0.5F, var28);
            GuiRenderHelper.method1404(var1, var21, var22, this.field0423, 17.0F);
            float var29 = var21 + 8.0F;
            float var30 = var22 + (17.0F - var13) / 2.0F;
            String var31 = DaamkyClient.method2004().method2257().method2067();
            if (var11.startsWith(var31)) {
               GuiRenderHelper.method1491(var6, var4, var31, var29, var30, this.method0964(var14, var7));
               float var32 = var4.method0998(var31);
               String var33 = var11.substring(var31.length());
               if (!var33.isEmpty()) {
                  GuiRenderHelper.method1491(var6, var4, var33, var29 + var32, var30, this.method0964(field1104, var7));
               }

               if (!var20.isEmpty()) {
                  float var34 = var29 + var4.method0998(var11);
                  GuiRenderHelper.method1491(var6, var4, var20, var34, var30, new Color(255, 255, 255, Math.max(0, (int)(60.0F * var7))));
               }
            } else {
               GuiRenderHelper.method1491(var6, var4, var11, var29, var30, this.method0964(field1104, var7));
            }

            if (this.method2079()) {
               int var59 = Math.min(this.field1332, this.field0911);
               int var61 = Math.max(this.field1332, this.field0911);
               String var62 = var11.substring(0, Math.min(var59, var11.length()));
               String var35 = var11.substring(Math.min(var59, var11.length()), Math.min(var61, var11.length()));
               float var36 = var29 + var4.method0998(var62);
               float var37 = var4.method0998(var35);
               Color var38 = new Color(var14.getRed(), var14.getGreen(), var14.getBlue(), Math.max(0, (int)(80.0F * var7)));
               GuiRenderHelper.method1463(var6, var36, var22 + 3.0F, var37, 11.0F, 2.0F, var38);
            }

            double var60 = 0.5 + 0.5 * Math.sin(System.currentTimeMillis() / 150.0);
            int var63 = (int)(var60 * 255.0 * var7);
            String var64 = var11.substring(0, Math.min(this.field0911, var11.length()));
            float var65 = var29 + var4.method0998(var64);
            float var66 = 7.0F;
            float var67 = var22 + (17.0F - var66) / 2.0F;
            GuiRenderHelper.method0326(var6, var65, var67, 1.0F, var66, 1.0F, new Color(255, 255, 255, Math.max(0, var63)));
            GuiRenderHelper.method1400(var1);
            var6.method_22909();
            if (!this.field0238.isEmpty() && var10 > 0.01F) {
               float var39 = this.field0238.size() * 18.0F + (this.field0238.size() - 1) * 1.0F;
               this.field0255 = class_3532.method_16439(0.15F, this.field0255, var39);
               FontSize var40 = Fonts.field0774.method0654(4.5F);
               float var41 = 0.0F;

               for (ChatCommandSuggestions.Suggestion var43 : this.field0238) {
                  float var44 = var5.method0998(var43.display) + 16.0F;
                  if (var43.description != null) {
                     var44 += 10.0F + var40.method0998("d") + 5.0F + var5.method0998(var43.description);
                  }

                  var41 = Math.max(var41, var44);
               }

               var41 = Math.max(var41, this.field0423);
               float var69 = var21;
               float var70 = var22 - this.field0255 - 2.0F;
               float var71 = Math.max(0.3F, var10);
               float var45 = Math.max(0.3F, var10 * var10);
               float var46 = var70 + this.field0255 / 2.0F;
               var6.method_22903();
               var6.method_46416(var69, var46, 0.0F);
               var6.method_22905(var71, var45, 1.0F);
               var6.method_46416(-var69, -var46, 0.0F);
               Color var47 = this.method0964(var15, var10);
               Color var48 = new Color(255, 255, 255, Math.max(0, (int)(10.0F * var10)));
               GuiRenderHelper.method1462(var6, var69, var70, var41, this.field0255, 10.0F, 14.0F, this.method0964(field1153, var10));
               GuiRenderHelper.method1463(var6, var69, var70, var41, this.field0255, 10.0F, var47);
               GuiRenderHelper.method1461(var6, var69, var70, var41, this.field0255, 10.0F, 0.5F, 0.5F, var48);
               GuiRenderHelper.method1404(var1, var69, var70, var41, this.field0255);
               float var49 = var70;

               for (int var50 = 0; var50 < this.field0238.size(); var50++) {
                  ChatCommandSuggestions.Suggestion var51 = this.field0238.get(var50);
                  if (var50 == this.field0290) {
                     Color var52 = new Color(var14.getRed(), var14.getGreen(), var14.getBlue(), Math.max(0, (int)(28.0F * var10)));
                     GuiRenderHelper.method1463(var6, var69 + 3.0F, var49 + 3.0F, var41 - 6.0F, 12.5F, 10.0F, var52);
                  }

                  float var72 = var69 + 8.0F;
                  float var53 = var49 + (18.0F - var5.method0530()) / 2.0F;
                  Color var54 = this.method0964(var50 == this.field0290 ? var14 : field1104, var10);
                  GuiRenderHelper.method1491(var6, var5, var51.display, var72, var53, var54);
                  if (var51.description != null) {
                     FontSize var55 = Fonts.field0774.method0654(4.5F);
                     float var56 = var72 + var5.method0998(var51.display) + 10.0F;
                     float var57 = var49 + (18.0F - var55.method0530()) / 2.0F;
                     GuiRenderHelper.method1491(var6, var55, "d", var56, var57 - 0.5F, new Color(255, 255, 255, Math.max(0, (int)(80.0F * var10))));
                     float var58 = var56 + var55.method0998("d") + 5.0F;
                     GuiRenderHelper.method1491(var6, var5, var51.description, var58, var53, new Color(255, 255, 255, Math.max(0, (int)(80.0F * var10))));
                  }

                  if (var50 < this.field0238.size() - 1) {
                     float var73 = var49 + 18.0F;
                     GuiRenderHelper.method1463(
                        var6, var69 + 8.0F, var73, var41 - 16.0F, 0.5F, 0.0F, new Color(255, 255, 255, Math.max(0, (int)(15.0F * var10)))
                     );
                  }

                  var49 += 19.0F;
               }

               GuiRenderHelper.method1400(var1);
               var6.method_22909();
            } else {
               this.field0255 = class_3532.method_16439(0.15F, this.field0255, 0.0F);
            }
         }
      }
   }

   private Color method0964(Color var1, float var2) {
      return var2 >= 0.99F ? var1 : new Color(var1.getRed(), var1.getGreen(), var1.getBlue(), Math.max(0, (int)(var1.getAlpha() * var2)));
   }

   public boolean method0746(int var1, int var2, int var3) {
      if (!this.field0890) {
         return false;
      }

      boolean var4 = (var3 & 2) != 0;
      String var5 = DaamkyClient.method2004().method2257().method2067();
      int var6 = var5.length();
      if (var1 == 256) {
         this.method0025();
         return true;
      }

      if (var1 == 257 || var1 == 335) {
         String var11 = this.field0842.toString();
         if (!var11.isEmpty()) {
            DaamkyClient.method2004().method2257().method0214(var11);
         }

         this.method0025();
         class_310.method_1551().method_1507(null);
         return true;
      } else {
         if (var1 == 258) {
            this.method0498();
            return true;
         }

         if (var4 && var1 == 65) {
            this.field1332 = var6;
            this.field0911 = this.field0842.length();
            return true;
         }

         if (var4 && var1 == 67) {
            String var10 = this.method1619();
            if (!var10.isEmpty()) {
               GLFW.glfwSetClipboardString(class_310.method_1551().method_22683().method_4490(), var10);
            }

            return true;
         } else if (var4 && var1 == 86) {
            String var9 = GLFW.glfwGetClipboardString(class_310.method_1551().method_22683().method_4490());
            if (var9 != null && !var9.isEmpty()) {
               this.method1812();
               this.field0842.insert(this.field0911, var9);
               this.field0911 = this.field0911 + var9.length();
               this.method1973();
            }

            return true;
         } else if (var4 && var1 == 88) {
            String var8 = this.method1619();
            if (!var8.isEmpty()) {
               GLFW.glfwSetClipboardString(class_310.method_1551().method_22683().method_4490(), var8);
               this.method1812();
               this.method1973();
            }

            return true;
         } else if (var4 && var1 == 259) {
            if (this.method2079()) {
               this.method1812();
            } else if (this.field0911 > var6) {
               int var7 = this.field0911;

               while (var7 > var6 && this.field0842.charAt(var7 - 1) == ' ') {
                  var7--;
               }

               while (var7 > var6 && this.field0842.charAt(var7 - 1) != ' ') {
                  var7--;
               }

               this.field0842.delete(var7, this.field0911);
               this.field0911 = var7;
            }

            this.field1332 = -1;
            this.method1973();
            return true;
         } else if (var1 == 265) {
            if (!this.field0238.isEmpty()) {
               this.field0290 = this.field0290 <= 0 ? this.field0238.size() - 1 : this.field0290 - 1;
            }

            return true;
         } else if (var1 == 264) {
            if (!this.field0238.isEmpty()) {
               this.field0290 = (this.field0290 + 1) % this.field0238.size();
            }

            return true;
         } else if (var1 == 259) {
            if (this.method2079()) {
               this.method1812();
               this.method1973();
               return true;
            }

            if (this.field0911 > 0) {
               if (this.field0911 <= var6 && this.field0842.toString().startsWith(var5)) {
                  this.method0025();
                  return true;
               }

               this.field0842.deleteCharAt(this.field0911 - 1);
               this.field0911--;
               this.method1973();
            }

            return true;
         } else if (var1 == 261) {
            if (this.method2079()) {
               this.method1812();
               this.method1973();
               return true;
            }

            if (this.field0911 < this.field0842.length()) {
               this.field0842.deleteCharAt(this.field0911);
               this.method1973();
            }

            return true;
         } else if (var1 == 263) {
            this.field1332 = -1;
            if (!var4) {
               if (this.field0911 > var6) {
                  this.field0911--;
               }
            } else {
               while (this.field0911 > var6 && this.field0842.charAt(this.field0911 - 1) == ' ') {
                  this.field0911--;
               }

               while (this.field0911 > var6 && this.field0842.charAt(this.field0911 - 1) != ' ') {
                  this.field0911--;
               }
            }

            return true;
         } else if (var1 == 262) {
            this.field1332 = -1;
            if (!var4) {
               if (this.field0911 < this.field0842.length()) {
                  this.field0911++;
               }
            } else {
               while (this.field0911 < this.field0842.length() && this.field0842.charAt(this.field0911) != ' ') {
                  this.field0911++;
               }

               while (this.field0911 < this.field0842.length() && this.field0842.charAt(this.field0911) == ' ') {
                  this.field0911++;
               }
            }

            return true;
         } else if (var1 == 268) {
            this.field1332 = -1;
            this.field0911 = var6;
            return true;
         } else if (var1 == 269) {
            this.field1332 = -1;
            this.field0911 = this.field0842.length();
            return true;
         } else {
            return false;
         }
      }
   }

   private boolean method2079() {
      return this.field1332 != -1 && this.field1332 != this.field0911;
   }

   private void method1812() {
      if (this.method2079()) {
         int var1 = Math.min(this.field1332, this.field0911);
         int var2 = Math.max(this.field1332, this.field0911);
         String var3 = DaamkyClient.method2004().method2257().method2067();
         var1 = Math.max(var1, var3.length());
         this.field0842.delete(var1, var2);
         this.field0911 = var1;
         this.field1332 = -1;
      }
   }

   private String method1619() {
      if (this.method2079()) {
         int var3 = Math.min(this.field1332, this.field0911);
         int var2 = Math.max(this.field1332, this.field0911);
         return this.field0842.substring(var3, var2);
      } else {
         String var1 = DaamkyClient.method2004().method2257().method2067();
         return this.field0842.length() > var1.length() ? this.field0842.substring(var1.length()) : "";
      }
   }

   public boolean method0607(char var1, int var2) {
      if (!this.field0890) {
         return false;
      }

      if (var1 < ' ') {
         return false;
      }

      this.method1812();
      this.field0842.insert(this.field0911, var1);
      this.field0911++;
      this.method1973();
      return true;
   }

   private void method1973() {
      this.field0238.clear();
      this.field0290 = -1;
      String var1 = DaamkyClient.method2004().method2257().method2067();
      String var2 = this.field0842.toString();
      if (var2.startsWith(var1)) {
         String var3 = var2.substring(var1.length());
         if (var3.contains(" ")) {
            String[] var4 = var3.split(" ", -1);
            String var5 = var4[0];
            String[] var6 = new String[var4.length - 1];
            System.arraycopy(var4, 1, var6, 0, var6.length);

            for (Command var8 : DaamkyClient.method2004().method2257().method0018()) {
               if (var8.method0214(var5)) {
                  List var9 = var8.method1593(var6);
                  Map var10 = var8.method0351(var6);
                  StringBuilder var11 = new StringBuilder(var1).append(var5);

                  for (int var12 = 0; var12 < var6.length - 1; var12++) {
                     var11.append(' ').append(var6[var12]);
                  }

                  String var20 = var11.toString();

                  for (String var14 : var9) {
                     this.field0238.add(new ChatCommandSuggestions.Suggestion(var14, var10.get(var14), var20 + " " + var14));
                  }
                  break;
               }
            }
         } else {
            String var15 = var3.toLowerCase();

            for (Command var17 : DaamkyClient.method2004().method2257().method0018()) {
               if (!var15.isEmpty() && !var17.method0557().toLowerCase().startsWith(var15)) {
                  for (String var19 : var17.method0019()) {
                     if (var19.toLowerCase().startsWith(var15)) {
                        this.field0238.add(new ChatCommandSuggestions.Suggestion(var19 + " (" + var17.method0557() + ")", var17.method2067(), var1 + var19));
                        break;
                     }
                  }
               } else {
                  this.field0238.add(new ChatCommandSuggestions.Suggestion(var17.method0557(), var17.method2067(), var1 + var17.method0557()));
               }
            }
         }
      }
   }

   private String method0423() {
      String var1 = DaamkyClient.method2004().method2257().method2067();
      String var2 = this.field0842.toString();
      if (!var2.startsWith(var1)) {
         return "";
      }

      String var3 = var2.substring(var1.length());
      if (!var3.contains(" ")) {
         return "";
      }

      String[] var4 = var3.split(" ", -1);
      String var5 = var4[0];
      String[] var6 = new String[var4.length - 1];
      System.arraycopy(var4, 1, var6, 0, var6.length);
      String var7 = var6.length > 0 ? var6[var6.length - 1] : "";
      if (!var7.isEmpty()) {
         return "";
      }

      for (Command var9 : DaamkyClient.method2004().method2257().method0018()) {
         if (var9.method0214(var5)) {
            return var9.method2179(var6);
         }
      }

      return "";
   }

   private String method0368() {
      String var1 = DaamkyClient.method2004().method2257().method2067();
      String var2 = this.field0842.toString();
      if (!var2.startsWith(var1)) {
         return "";
      }

      String var3 = var2.substring(var1.length());
      if (var3.contains(" ")) {
         String[] var4 = var3.split(" ", -1);
         String var5 = var4[0];
         String[] var6 = new String[var4.length - 1];
         System.arraycopy(var4, 1, var6, 0, var6.length);
         String var7 = var6.length > 0 ? var6[var6.length - 1] : "";

         for (Command var9 : DaamkyClient.method2004().method2257().method0018()) {
            if (var9.method0214(var5)) {
               List var10 = var9.method1593(var6);
               if (!var10.isEmpty()) {
                  String var11 = var10.get(0);
                  if (var11.toLowerCase().startsWith(var7.toLowerCase()) && !var11.equalsIgnoreCase(var7)) {
                     return var11.substring(var7.length());
                  }
               }
               break;
            }
         }
      } else {
         String var12 = var3.toLowerCase();

         for (Command var14 : DaamkyClient.method2004().method2257().method0018()) {
            if (var14.method0557().toLowerCase().startsWith(var12) && !var14.method0557().equalsIgnoreCase(var3)) {
               return var14.method0557().substring(var3.length());
            }

            for (String var16 : var14.method0019()) {
               if (var16.toLowerCase().startsWith(var12) && !var16.equalsIgnoreCase(var3)) {
                  return var16.substring(var3.length());
               }
            }
         }
      }

      return "";
   }

   private void method0498() {
      if (this.field0290 >= 0 && this.field0290 < this.field0238.size()) {
         ChatCommandSuggestions.Suggestion var2 = this.field0238.get(this.field0290);
         this.field0842.setLength(0);
         this.field0842.append(var2.fullText).append(' ');
         this.field0911 = this.field0842.length();
         this.method1973();
      } else {
         String var1 = this.method0368();
         if (!var1.isEmpty()) {
            this.field0842.insert(this.field0911, var1);
            this.field0911 = this.field0911 + var1.length();
            this.field0842.append(' ');
            this.field0911++;
            this.method1973();
         }
      }
   }

   private record Suggestion(String display, String description, String fullText) {
      public String method0557() {
         return this.display;
      }

      public String method0017() {
         return this.description;
      }

      public String method2067() {
         return this.fullText;
      }
   }
}
