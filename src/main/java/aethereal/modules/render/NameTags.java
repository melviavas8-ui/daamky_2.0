package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1311;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_268;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_5251;
import net.minecraft.class_742;

public class NameTags extends Module {
   private final MultiSelectSetting field0089 = new MultiSelectSetting(
         "nametags.targets",
         method1056("nametags.target.self", "Self", false, "Render your own nametag in third person", "Отображать себя"),
         method1056("nametags.target.monsters", "Monsters", false, "Render nametags on hostile mobs", "Отображать враждебных мобов"),
         method1056("nametags.target.animals", "Animals", false, "Render nametags on passive mobs", "Отображать мирных мобов"),
         method1056("nametags.target.players", "Players", true, "Render nametags on other players", "Отображать игроков"),
         method1056("nametags.target.items", "Items", false, "Render nametags on dropped items", "Отображать предметы на земле")
      )
      .method1007("Targets")
      .method0210("Entity types to render nametags on")
      .method2130("Типы сущностей");
   private final MultiSelectSetting field1471 = new MultiSelectSetting(
         "nametags.playeroptions",
         () -> this.field0089.method0387("Players"),
         Arrays.asList(
            method1056("nametags.player.ping", "Show Ping", true, "Display player ping on nametag", "Отображать пинг"),
            method1056("nametags.player.health", "Show Health", true, "Display player health on nametag", "Отображать здоровье"),
            method1056("nametags.player.armor", "Show Armor", true, "Display armor items on nametag", "Отображать броню"),
            method1056("nametags.player.items", "Show Items", true, "Display held items on nametag", "Отображать предметы в руках"),
            method1056("nametags.player.self", "Show Self", true, "Show your own nametag (combined with Self target)", "Отображать себя"),
            method1056("nametags.player.invisible", "Show Invisible", false, "Show nametags for invisible players", "Отображать невидимых игроков"),
            method1056("nametags.player.prefix", "Show Prefix", true, "Display donation/rank prefix from scoreboard team", "Отображать привилегию")
         )
      )
      .method1007("Players Settings")
      .method0210("Player nametag display options")
      .method2130("Опции таблички игроков");
   private final EnumSetting<NameTags.ScaleMode> field0984 = new EnumSetting<>("nametags.scalemode", NameTags.ScaleMode.field0662)
      .method1007("Scale Mode")
      .method0210("")
      .method2130("HUD - масштаб с ограничением, World - во всём мире");
   private final BooleanSetting field0184 = new BooleanSetting("nametags.friendcolor", true)
      .method1007("Friend Color")
      .method0210("Highlight friends with green color")
      .method2130("Подсвечивать друзей зелёным цветом");
   private final BooleanSetting field0464 = new BooleanSetting("nametags.distancehideitems", true)
      .method1007("Hide Items By Distance")
      .method0210("Hide armor/items when players are far away")
      .method2130("Скрывать броню и предметы вдали");
   private final FloatSetting field1627 = new FloatSetting("nametags.scale", 1.0F, 0.3F, 2.0F, 0.05F)
      .method1007("Scale")
      .method0210("Nametag size multiplier")
      .method2130("Размер");
   private final FloatSetting field1553 = new FloatSetting(
         "nametags.range", 64.0F, 8.0F, 128.0F, 1.0F, () -> this.field0984.method0492() == NameTags.ScaleMode.field0662
      )
      .method1007("Max Range")
      .method0210("Maximum render distance")
      .method2130("Максимальная дальность");
   private static final float field1704 = 6.0F;
   private static final float field1136 = 3.0F;
   private static final float field1087 = 6.0F;
   private static final float field1196 = 12.0F;
   private static final float field0871 = 2.0F;
   private static final float field0826 = 30.0F;
   private static final float field0910 = 32.0F;
   private static final float field1331 = 0.08F;
   private final Map<String, float[]> field1309 = new ConcurrentHashMap<>();
   private final Map<UUID, Float> field1385 = new HashMap<>();
   private static final Color field0399 = new Color(255, 255, 255, 55);
   private static final Color field0364 = new Color(255, 255, 255, 80);
   private static final Color field0436 = new Color(227, 227, 227);
   private static final Color field0269 = new Color(255, 255, 255, 184);
   private static final Color field0236 = new Color(74, 214, 160);
   private static final Color field0298 = new Color(255, 80, 90);
   private static final Color field0533 = new Color(66, 245, 149);

   private static BooleanSetting method1056(String var0, String var1, boolean var2, String var3, String var4) {
      BooleanSetting var5 = new BooleanSetting(var0, var2);
      var5.method0442(var1);
      var5.method1846(var1);
      var5.method1656(var3);
      var5.method1985(var4);
      return var5;
   }

   public Map<String, float[]> method1730() {
      return this.field1309;
   }

   public NameTags() {
      super("NameTags", ModuleCategory.field1004, "Enhanced nametag rendering with extra info");
      this.method1013("Отображение информации над сущностями");
   }

   @EventHandler
   public void onRender2D(Render2DEvent var1) {
      if (field0796.field_1687 != null && field0796.field_1724 != null) {
         if (this.field0984.method0492() == NameTags.ScaleMode.field0662) {
            this.method0918(var1);
         } else {
            this.method0186(var1);
         }
      }
   }

   private void method0918(Render2DEvent var1) {
      boolean var2 = this.field0089.method0387("Self") && this.field1471.method0387("Show Self");
      boolean var3 = this.field0089.method0387("Players");
      boolean var4 = this.field0089.method0387("Monsters");
      boolean var5 = this.field0089.method0387("Animals");
      boolean var6 = this.field0089.method0387("Items");
      boolean var7 = this.field1471.method0387("Show Invisible");
      if (var2 || var3 || var4 || var5 || var6) {
         float var8 = var1.method1632().method_60637(true);
         class_332 var9 = var1.method1806();
         class_4587 var10 = var9.method_51448();
         class_243 var11 = field0796.field_1773.method_19418().method_19326();
         boolean var12 = field0796.field_1690.method_31044().method_31034();
         double var13 = this.field1553.method0492().doubleValue();
         List var15 = new ArrayList<>();
         if (var2 || var3) {
            for (class_1657 var17 : field0796.field_1687.method_18456()) {
               if ((var17 == field0796.field_1724 ? var2 && !var12 : var3 && (var7 || !var17.method_5767()))
                  && !var17.method_29504()
                  && ProjectionHelper.method1185(var17, var13)) {
                  var15.add(var17);
               }
            }
         }

         if (var4 || var5 || var6) {
            for (class_1297 var31 : field0796.field_1687.method_18112()) {
               if (!(var31 instanceof class_1657) && !var31.method_31481() && !(field0796.field_1724.method_5739(var31) > var13)) {
                  if (var31 instanceof class_1542) {
                     if (var6) {
                        var15.add(var31);
                     }
                  } else if (var31 instanceof class_1309 var18 && !var18.method_29504()) {
                     class_1311 var19 = var31.method_5864().method_5891();
                     if (var4 && var19 == class_1311.field_6302) {
                        var15.add(var31);
                     } else if (var5 && method1173(var19)) {
                        var15.add(var31);
                     }
                  }
               }
            }
         }

         var15.sort(Comparator.<class_1297>comparingDouble(var2x -> var11.method_1022(method1132(var2x, var8))).reversed());
         this.field1309.clear();
         GuiRenderHelper.method0578();

         try {
            for (class_1297 var32 : var15) {
               class_243 var33 = var32 instanceof class_1657 ? ProjectionHelper.method1188((class_1657)var32, var8) : method1132(var32, var8);
               class_243 var34 = ProjectionHelper.method1299(var33);
               if (ProjectionHelper.method0289(var34)) {
                  double var20 = Math.max(var11.method_1022(var33), 0.5);
                  float var22 = (float)Math.max(0.550000157981654, 5.0 / var20);
                  if (var32 instanceof class_1657 var23) {
                     this.method1440(var9, var10, var23, (float)var34.field_1352, (float)var34.field_1351, var22, var20);
                  } else if (var32 instanceof class_1542 var24) {
                     this.method1439(var9, var10, var24, (float)var34.field_1352, (float)var34.field_1351, var22);
                  } else if (var32 instanceof class_1309 var25) {
                     this.method1438(var9, var10, var25, (float)var34.field_1352, (float)var34.field_1351, var22);
                  }
               }
            }
         } finally {
            GuiRenderHelper.method0025();
         }
      }
   }

   private void method0186(Render2DEvent var1) {
      boolean var2 = this.field0089.method0387("Self") && this.field1471.method0387("Show Self");
      boolean var3 = this.field0089.method0387("Players");
      boolean var4 = this.field0089.method0387("Monsters");
      boolean var5 = this.field0089.method0387("Animals");
      boolean var6 = this.field0089.method0387("Items");
      boolean var7 = this.field1471.method0387("Show Invisible");
      if (var2 || var3 || var4 || var5 || var6) {
         float var8 = var1.method1632().method_60637(true);
         class_332 var9 = var1.method1806();
         class_4587 var10 = var9.method_51448();
         class_243 var11 = field0796.field_1773.method_19418().method_19326();
         boolean var12 = field0796.field_1690.method_31044().method_31034();
         List var13 = new ArrayList<>();
         if (var2 || var3) {
            for (class_1657 var15 : field0796.field_1687.method_18456()) {
               if ((var15 == field0796.field_1724 ? var2 && !var12 : var3 && (var7 || !var15.method_5767())) && !var15.method_29504()) {
                  var13.add(var15);
               }
            }
         }

         if (var4 || var5 || var6) {
            for (class_1297 var29 : field0796.field_1687.method_18112()) {
               if (!(var29 instanceof class_1657) && !var29.method_31481()) {
                  if (var29 instanceof class_1542) {
                     if (var6) {
                        var13.add(var29);
                     }
                  } else if (var29 instanceof class_1309 var16 && !var16.method_29504()) {
                     class_1311 var17 = var29.method_5864().method_5891();
                     if (var4 && var17 == class_1311.field_6302) {
                        var13.add(var29);
                     } else if (var5 && method1173(var17)) {
                        var13.add(var29);
                     }
                  }
               }
            }
         }

         var13.sort(Comparator.<class_1297>comparingDouble(var2x -> var11.method_1022(method1132(var2x, var8))).reversed());
         this.field1309.clear();
         GuiRenderHelper.method0578();

         try {
            for (class_1297 var30 : var13) {
               class_243 var31 = method1132(var30, var8);
               class_243 var32 = ProjectionHelper.method1299(var31);
               if (ProjectionHelper.method0289(var32)) {
                  double var18 = Math.max(var11.method_1022(var31), 0.5);
                  float var20 = (float)(0.9799997653140244 / (1.0 + var18 * 0.0149999937451505));
                  if (var30 instanceof class_1657 var21) {
                     this.method1440(var9, var10, var21, (float)var32.field_1352, (float)var32.field_1351, var20, var18);
                  } else if (var30 instanceof class_1542 var22) {
                     this.method1439(var9, var10, var22, (float)var32.field_1352, (float)var32.field_1351, var20);
                  } else if (var30 instanceof class_1309 var23) {
                     this.method1438(var9, var10, var23, (float)var32.field_1352, (float)var32.field_1351, var20);
                  }
               }
            }
         } finally {
            GuiRenderHelper.method0025();
         }
      }
   }

   private static boolean method1173(class_1311 var0) {
      return var0 == class_1311.field_6294
         || var0 == class_1311.field_6300
         || var0 == class_1311.field_24460
         || var0 == class_1311.field_30092
         || var0 == class_1311.field_34447;
   }

   private static class_243 method1132(class_1297 var0, float var1) {
      double var2 = class_3532.method_16436(var1, var0.field_6014, var0.method_23317());
      double var4 = class_3532.method_16436(var1, var0.field_6036, var0.method_23318());
      double var6 = class_3532.method_16436(var1, var0.field_5969, var0.method_23321());
      return new class_243(var2, var4 + var0.method_17682() + 0.30000014319085483, var6);
   }

   private void method1440(class_332 var1, class_4587 var2, class_1657 var3, float var4, float var5, float var6, double var7) {
      boolean var9 = this.field1471.method0387("Show Health");
      boolean var10 = this.field1471.method0387("Show Ping");
      boolean var11 = this.field1471.method0387("Show Armor");
      boolean var12 = this.field1471.method0387("Show Items");
      boolean var13 = this.field1471.method0387("Show Prefix");
      float var14 = this.field1627.method0492();
      float var15 = !this.field0464.method0492() ? 1.0F : (var7 < 32.0 ? 1.0F : 0.0F);
      float var16 = this.field1385.getOrDefault(var3.method_5667(), var15);
      var16 += (var15 - var16) * 0.08F;
      var16 = class_3532.method_15363(var16, 0.0F, 1.0F);
      this.field1385.put(var3.method_5667(), var16);
      float var17 = var16;
      boolean var18 = var17 > 0.01F;
      boolean var19 = true;
      FontSize var20 = Fonts.field0075.method0654(6.0F * var14);
      FontSize var21 = Fonts.field0075.method0654(6.0F * var14);
      FontSize var22 = Fonts.field0774.method0654(6.0F * var14 * 1.15F);
      String var23 = NameProtect.method2131(var3.method_5477().getString());
      String var24 = "";
      Color var25 = field0269;
      if (var13 && field0796.field_1687 != null) {
         class_268 var26 = field0796.field_1687.method_8428().method_1164(var23);
         if (var26 != null) {
            class_2561 var27 = var26.method_1144();
            String var28 = var27.getString();
            if (var28 != null && !var28.isEmpty()) {
               String var29 = NameDecorator.method1010(var28);
               String var30 = var29.replaceAll("§.", "").trim();
               if (!var30.isEmpty()) {
                  var24 = var30;
                  class_5251 var31 = null;
                  if (var27.method_10866() != null && var27.method_10866().method_10973() != null) {
                     var31 = var27.method_10866().method_10973();
                  } else {
                     for (class_2561 var33 : var27.method_10855()) {
                        if (var33.method_10866() != null && var33.method_10866().method_10973() != null) {
                           var31 = var33.method_10866().method_10973();
                           break;
                        }
                     }
                  }

                  if (var31 != null) {
                     int var83 = var31.method_27716();
                     var25 = new Color(var83 >> 16 & 0xFF, var83 >> 8 & 0xFF, var83 & 0xFF);
                  }
               }
            }
         }
      }

      float var77 = ProjectionHelper.method1178(var3);
      float var78 = ProjectionHelper.method1854(var3);
      int var79 = ProjectionHelper.method1663(var3);
      float var80 = ProjectionHelper.method2149(var3);
      String var81 = var9 ? ProjectionHelper.method0673(var77, var78) : "";
      String var82 = var10 ? var79 + "ms" : "";
      List var84 = this.method1180(var3);
      List var85 = this.method0249(var3);
      float var34 = 12.0F * var14;
      float var35 = var34;
      float var36 = var11 && var18 ? this.method1075(var84, var14) : 0.0F;
      float var37 = var12 && var18 ? this.method1075(var85, var14) : 0.0F;
      float var38 = var36 * var17;
      float var39 = var37 * var17;
      float var40 = 5.0F * var14;
      float var41 = 3.0F * var14;
      float var42 = 4.0F * var14;
      float var43 = 7.0F * var14;
      float var44 = var24.isEmpty() ? 0.0F : 3.0F * var14;
      float var45 = var24.isEmpty() ? 0.0F : var21.method0998(var24);
      float var46 = var20.method0998(var23);
      float var47 = var20.method0998(var81);
      float var48 = var20.method0998(var82);
      float var49 = var22.method0998("J");
      float var50 = var22.method0998("a");
      float var51 = var42 + var35;
      var51 += var40 + 1.0F + var40;
      var51 += var45 + var44 + var46;
      if (var9 && var47 > 0.0F) {
         var51 += var40 + 1.0F + var40;
         var51 += (var19 ? var49 + var41 : 0.0F) + var47;
      }

      if (var10 && var48 > 0.0F) {
         var51 += var40 + 1.0F + var40;
         var51 += (var19 ? var50 + var41 : 0.0F) + var48;
      }

      boolean var52 = var11 && var38 > 0.0F || var12 && var39 > 0.0F;
      if (var52) {
         var51 += var40 + 1.0F + var40;
         if (var11 && var38 > 0.0F) {
            var51 += var38;
            if (var12 && var39 > 0.0F) {
               var51 += 3.0F * var14;
            }
         }

         if (var12 && var39 > 0.0F) {
            var51 += var39;
         }
      }

      var51 += var42;
      float var53 = class_3532.method_16439(var17, var20.method0530(), var34);
      float var54 = var53 + 7.5F * var14;
      float var55 = var51;
      float var56 = -var55 / 2.0F;
      float var57 = -var54;
      float var58 = var4 + var56 * var6;
      float var59 = var5 - 4.0F + var57 * var6;
      float var60 = var55 * var6;
      float var61 = var54 * var6;
      this.field1309.put(var23, new float[]{var58, var59, var60, var61});
      float var62 = ThemePalette.field0367.get() * Math.min(var6, 1.0F);
      var2.method_22903();
      var2.method_46416(var4, var5 - 4.0F, 0.0F);
      var2.method_22905(var6, var6, 1.0F);
      boolean var63 = this.field0184.method0492() && DaamkyClient.method2004().method1608().method1129(var3);
      Color var64 = ThemePalette.field0930.get();
      Color var65 = ThemePalette.field1564;
      if (var63) {
         var64 = method0964(var64, 0.1F);
         var65 = method0964(var65, 0.3F);
      }

      GuiRenderHelper.method1462(var2, var56, var57, var55, var54, 6.0F * var14, var62, ThemePalette.field0134);
      GuiRenderHelper.method1463(var2, var56, var57, var55, var54, 6.0F * var14, var64);
      GuiRenderHelper.method1461(var2, var56, var57, var55, var54, 6.0F * var14, 0.5F, 0.5F, var65);
      float var66 = var57 + var54 / 2.0F;
      float var67 = var66 - var20.method0530() / 2.0F;
      float var68 = var66 - var22.method0530() / 2.0F;
      float var69 = var66 - var43 / 2.0F;
      float var70 = var56 + var42;
      class_2960 var71 = ((class_742)var3).method_52814().comp_1626();
      float var72 = 3.0F * var14;
      GuiRenderHelper.method1459(var2, var70, var66 - var35 / 2.0F, var35, var35, var72, 0.125F, 0.125F, 0.125F, 0.125F, var71, field0436);
      var70 += var35;
      var70 += var40;
      GuiRenderHelper.method0326(var2, var70, var69, 1.0F, var43, 1.0F, field0364);
      var70 += 1.0F + var40;
      if (!var24.isEmpty()) {
         var70 = this.method1490(var2, var21, var24, var70, var67, var25);
         var70 += var44;
      }

      Color var73 = var63 ? field0533 : field0436;
      GuiRenderHelper.method1491(var2, var20, var23, var70, var67, var73);
      var70 += var46;
      Color var74 = var63 ? field0533 : ThemeColorManager.method1908().method2063();
      if (var9 && var47 > 0.0F) {
         var70 += var40;
         GuiRenderHelper.method0326(var2, var70, var69, 1.0F, var43, 1.0F, field0364);
         var70 += 1.0F + var40;
         if (var19) {
            GuiRenderHelper.method1491(var2, var22, "J", var70, var68 - 0.7F * var14, var74);
            var70 += var49 + var41;
         }

         GuiRenderHelper.method1491(var2, var20, var81, var70, var67, field0436);
         var70 += var47;
      }

      if (var10 && var48 > 0.0F) {
         var70 += var40;
         GuiRenderHelper.method0326(var2, var70, var69, 1.0F, var43, 1.0F, field0364);
         var70 += 1.0F + var40;
         if (var19) {
            GuiRenderHelper.method1491(var2, var22, "a", var70, var68 - 0.6F * var14, var74);
            var70 += var50 + var41;
         }

         GuiRenderHelper.method1491(var2, var20, var82, var70, var67, field0436);
         var70 += var48;
      }

      if (var52 && var18) {
         var70 += var40;
         GuiRenderHelper.method0326(var2, var70, var69, 1.0F, var43, 1.0F, field0364);
         var70 += 1.0F + var40;
         if (var11 && var38 > 0.0F) {
            this.method1437(var1, var2, var84, var70, var66 - var34 / 2.0F, var14, var17);
            var70 += var38;
            if (var12 && var39 > 0.0F) {
               var70 += 3.0F * var14;
            }
         }

         if (var12 && var39 > 0.0F) {
            this.method1437(var1, var2, var85, var70, var66 - var34 / 2.0F, var14, var17);
         }
      }

      var2.method_22909();
   }

   private void method1438(class_332 var1, class_4587 var2, class_1309 var3, float var4, float var5, float var6) {
      float var7 = this.field1627.method0492();
      FontSize var8 = Fonts.field0075.method0654(6.0F * var7);
      FontSize var9 = Fonts.field0774.method0654(6.0F * var7 * 1.15F);
      String var10 = var3.method_5476().getString();
      String var11 = ProjectionHelper.method0673(var3.method_6032(), var3.method_6067());
      float var12 = 5.0F * var7;
      float var13 = 3.0F * var7;
      float var14 = 4.0F * var7;
      float var15 = 7.0F * var7;
      float var16 = var8.method0998(var10);
      float var17 = var8.method0998(var11);
      float var18 = var9.method0998("J");
      float var19 = var14 + var16 + var12 + 1.0F + var12 + var18 + var13 + var17 + var14;
      float var20 = var8.method0530() + 7.5F * var7;
      float var21 = var19;
      float var22 = -var21 / 2.0F;
      float var23 = -var20;
      float var24 = ThemePalette.field0367.get() * Math.min(var6, 1.0F);
      var2.method_22903();
      var2.method_46416(var4, var5 - 4.0F, 0.0F);
      var2.method_22905(var6, var6, 1.0F);
      Color var25 = ThemePalette.field0930.get();
      Color var26 = ThemePalette.field1564;
      GuiRenderHelper.method1462(var2, var22, var23, var21, var20, 6.0F * var7, var24, ThemePalette.field0134);
      GuiRenderHelper.method1463(var2, var22, var23, var21, var20, 6.0F * var7, var25);
      GuiRenderHelper.method1461(var2, var22, var23, var21, var20, 6.0F * var7, 0.5F, 0.5F, var26);
      float var27 = var23 + var20 / 2.0F;
      float var28 = var27 - var8.method0530() / 2.0F;
      float var29 = var27 - var9.method0530() / 2.0F;
      float var30 = var27 - var15 / 2.0F;
      float var31 = var22 + var14;
      GuiRenderHelper.method1491(var2, var8, var10, var31, var28, field0436);
      var31 += var16;
      var31 += var12;
      GuiRenderHelper.method0326(var2, var31, var30, 1.0F, var15, 1.0F, field0364);
      var31 += 1.0F + var12;
      Color var32 = ThemeColorManager.method1908().method2063();
      GuiRenderHelper.method1491(var2, var9, "J", var31, var29 - 0.7F * var7, var32);
      var31 += var18 + var13;
      GuiRenderHelper.method1491(var2, var8, var11, var31, var28, field0436);
      var2.method_22909();
   }

   private void method1439(class_332 var1, class_4587 var2, class_1542 var3, float var4, float var5, float var6) {
      float var7 = this.field1627.method0492();
      FontSize var8 = Fonts.field0075.method0654(6.0F * var7);
      class_1799 var9 = var3.method_6983();
      if (!var9.method_7960()) {
         String var10 = var9.method_7964().getString();
         int var11 = var9.method_7947();
         String var12 = var11 > 1 ? " x" + var11 : "";
         float var13 = 12.0F * var7;
         float var14 = 4.0F * var7;
         float var15 = 3.0F * var7;
         float var16 = var8.method0998(var10);
         float var17 = var12.isEmpty() ? 0.0F : var8.method0998(var12);
         float var18 = var14 + var13 + var15 + var16 + var17 + var14;
         float var19 = Math.max(var8.method0530(), var13);
         float var20 = var19 + 7.5F * var7;
         float var21 = var18;
         float var22 = -var21 / 2.0F;
         float var23 = -var20;
         float var24 = ThemePalette.field0367.get() * Math.min(var6, 1.0F);
         var2.method_22903();
         var2.method_46416(var4, var5 - 4.0F, 0.0F);
         var2.method_22905(var6, var6, 1.0F);
         Color var25 = ThemePalette.field0930.get();
         Color var26 = ThemePalette.field1564;
         GuiRenderHelper.method1462(var2, var22, var23, var21, var20, 6.0F * var7, var24, ThemePalette.field0134);
         GuiRenderHelper.method1463(var2, var22, var23, var21, var20, 6.0F * var7, var25);
         GuiRenderHelper.method1461(var2, var22, var23, var21, var20, 6.0F * var7, 0.5F, 0.5F, var26);
         float var27 = var23 + var20 / 2.0F;
         float var28 = var27 - var8.method0530() / 2.0F;
         float var29 = var22 + var14;
         this.method1441(var1, var2, var9, var29, var27 - var13 / 2.0F, var7, 1.0F);
         var29 += var13 + var15;
         GuiRenderHelper.method1491(var2, var8, var10, var29, var28, field0436);
         var29 += var16;
         if (!var12.isEmpty()) {
            GuiRenderHelper.method1491(var2, var8, var12, var29, var28, field0269);
         }

         var2.method_22909();
      }
   }

   private static Color method0964(Color var0, float var1) {
      int var2 = (int)(var0.getRed() * (1.0F - var1) + 66.0F * var1);
      int var3 = (int)(var0.getGreen() * (1.0F - var1) + 245.0F * var1);
      int var4 = (int)(var0.getBlue() * (1.0F - var1) + 149.0F * var1);
      return new Color(var2, var3, var4, var0.getAlpha());
   }

   private float method1490(class_4587 var1, FontSize var2, String var3, float var4, float var5, Color var6) {
      float var7 = var4;
      int var8 = 0;

      while (var8 < var3.length()) {
         RankColorResolver.RankStyle var9 = RankColorResolver.method1023(var3, var8);
         if (var9 != null) {
            for (int var13 = 0; var13 < var9.field0004; var13++) {
               String var11 = String.valueOf(var3.charAt(var8 + var13));
               Color var12 = var9.method0737(var13, var6.getAlpha());
               GuiRenderHelper.method1491(var1, var2, var11, var7, var5, var12);
               var7 += var2.method0998(var11);
            }

            var8 += var9.field0004;
         } else {
            String var10 = String.valueOf(var3.charAt(var8));
            GuiRenderHelper.method1491(var1, var2, var10, var7, var5, var6);
            var7 += var2.method0998(var10);
            var8++;
         }
      }

      return var7;
   }

   private List<class_1799> method1180(class_1657 var1) {
      List var2 = new ArrayList<>();
      var2.add((class_1799)var1.method_31548().field_7548.get(3));
      var2.add((class_1799)var1.method_31548().field_7548.get(2));
      var2.add((class_1799)var1.method_31548().field_7548.get(1));
      var2.add((class_1799)var1.method_31548().field_7548.get(0));
      var2.removeIf(class_1799::method_7960);
      return var2;
   }

   private List<class_1799> method0249(class_1657 var1) {
      List var2 = new ArrayList<>();
      class_1799 var3 = var1.method_6047();
      class_1799 var4 = var1.method_6079();
      if (!var4.method_7960()) {
         var2.add(var4);
      }

      if (!var3.method_7960()) {
         var2.add(var3);
      }

      return var2;
   }

   private float method1075(List<class_1799> var1, float var2) {
      if (var1.isEmpty()) {
         return 0.0F;
      }

      float var3 = 12.0F * var2;
      return var1.size() * var3 + (var1.size() - 1) * 2.0F * var2;
   }

   private void method1437(class_332 var1, class_4587 var2, List<class_1799> var3, float var4, float var5, float var6, float var7) {
      float var8 = 12.0F * var6;
      float var9 = var4;

      for (class_1799 var11 : var3) {
         this.method1441(var1, var2, var11, var9, var5, var6, var7);
         var9 += var8 + 2.0F * var6;
      }
   }

   private void method1441(class_332 var1, class_4587 var2, class_1799 var3, float var4, float var5, float var6, float var7) {
      if (!var3.method_7960() && !(var7 <= 0.01F)) {
         float var8 = 12.0F * var6;
         float var9 = var8 / 16.0F;
         var2.method_22903();
         var2.method_46416(var4, var5, 200.0F);
         var2.method_22905(var9, var9, 1.0F);
         RenderSystem.enableBlend();
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var7);
         var1.method_51427(var3, 0, 0);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         if (var3.method_7947() > 1) {
            String var10 = String.valueOf(var3.method_7947());
            FontSize var11 = Fonts.field0075.method0654(5.0F);
            float var12 = 16.0F - var11.method0998(var10);
            float var13 = 16.0F - var11.method0530();
            Color var14 = new Color(255, 255, 255, (int)(255.0F * var7));
            GuiRenderHelper.method1491(var2, var11, var10, var12, var13, var14);
         }

         var2.method_22909();
      }
   }

   public enum ScaleMode implements DisplayNamed {
      field0662("HUD"),
      field0091("World");

      private final String field1504;

      ScaleMode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }
}
