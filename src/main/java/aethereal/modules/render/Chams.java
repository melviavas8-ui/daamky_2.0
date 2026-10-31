package aethereal;

import com.mojang.blaze3d.platform.GlStateManager.class_4534;
import com.mojang.blaze3d.platform.GlStateManager.class_4535;
import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10142;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1311;
import net.minecraft.class_1511;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;

public class Chams extends Module {
   private static Chams field1435;
   private static final class_2960 field1044 = class_2960.method_60655("daamky", "textures/glow.png");
   private final MultiSelectSetting field0202 = new MultiSelectSetting(
         "chams.targets",
         new BooleanSetting("chams.self", true).method1007("Self").method0210("Render chams on yourself").method2130("Рисовать на себе"),
         new BooleanSetting("chams.players", true).method1007("Players").method0210("Render chams on players").method2130("Рисовать на игроках"),
         new BooleanSetting("chams.hostiles", false)
            .method1007("Hostiles")
            .method0210("Render chams on hostile mobs")
            .method2130("Рисовать на враждебных мобах"),
         new BooleanSetting("chams.passives", false).method1007("Passives").method0210("Render chams on passive mobs").method2130("Рисовать на мирных мобах"),
         new BooleanSetting("chams.crystals", true).method1007("Crystals").method0210("Render chams on end crystals").method2130("Рисовать на кристалле края")
      )
      .method1007("Targets")
      .method0210("Entity types to apply chams to")
      .method2130("Типы сущностей для применения чамсов");
   private final BooleanSetting field0464 = new BooleanSetting("chams.shine", true)
      .method1007("Shine")
      .method0210("Apply shine effect to chams")
      .method2130("Эффект сияния");
   private final BooleanSetting field1619 = new BooleanSetting("chams.glow", false)
      .method1007("Glow")
      .method0210("Render a glow sprite behind chams entities")
      .method2130("Рисовать ореол за сущностями чамса");
   private final ColorSetting field1550 = new ColorSetting("chams.glowcolor", 255, 152, 243, 255, this.field1619::method0492)
      .method1882()
      .method1007("Glow Color")
      .method0210("Glow color")
      .method2130("Цвет ореола");
   private final FloatSetting field1716 = new FloatSetting("chams.glowopacity", 1.0F, 0.05F, 1.0F, 0.05F, this.field1619::method0492)
      .method1007("Glow Opacity")
      .method0210("Glow opacity multiplier")
      .method2130("Прозрачность ореола");
   private final BooleanSetting field1141 = new BooleanSetting("chams.glowadditive", true, this.field1619::method0492)
      .method1007("Glow Additive")
      .method0210("Additive blending for brighter glow")
      .method2130("Сложение цвета для более яркого свечения");
   private final EnumSetting<Chams.RenderMode> field1096 = new EnumSetting<>("chams.entitymode", Chams.RenderMode.field1434)
      .method1007("Entity Mode")
      .method0210("Render mode for entity chams")
      .method2130("Режим отрисовки чамсов сущностей");
   public final ColorSetting field0049 = new ColorSetting(
         "chams.entityfillcolor", 255, 152, 243, 49, () -> this.field1096.method0492() != Chams.RenderMode.field0036
      )
      .method1882()
      .method1007("Entity Fill Color")
      .method0210("Fill color for entity chams")
      .method2130("Цвет заливки чамсов сущностей");
   private final ColorSetting field1203 = new ColorSetting(
         "chams.entityoutlinecolor",
         255,
         152,
         253,
         51,
         () -> this.field1096.method0492() == Chams.RenderMode.field0036 || this.field1096.method0492() == Chams.RenderMode.field1434
      )
      .method1882()
      .method1007("Entity Outline Color")
      .method0210("Outline color for entity chams")
      .method2130("Цвет обводки чамсов сущностей");
   private final BooleanSetting field0875 = new BooleanSetting("chams.friendcolor", true)
      .method1007("Friend Color")
      .method0210("Render friends in green instead of the default color")
      .method2130("Рисовать друзей зелёным вместо обычного цвета");
   private final BooleanSetting field0830 = new BooleanSetting("chams.ps.showskin", true, () -> this.field1096.method0492() == Chams.RenderMode.field0971)
      .method1007("Show Skin")
      .method0210("Render vanilla skin underneath; chams alpha tints it")
      .method2130("Показывать скин снизу; альфа чамса даёт тинт");
   private static final float field0910 = 0.0625F;
   private static final float field1331 = 0.04F;
   private static final float field1292 = 0.0F;
   private static final float field1369 = 0.55F;
   private static final float field0385 = 1.6F;
   private static final float field0351 = 0.4F;
   private final BooleanSetting field0426 = new BooleanSetting(
         "chams.damagemodify",
         false,
         () -> this.field1096.method0492() == Chams.RenderMode.field0600 || this.field1096.method0492() == Chams.RenderMode.field1434
      )
      .method1007("Damage Modify")
      .method0210("Change color when entity takes damage")
      .method2130("Изменить цвет при получении урона сущностью");
   private final ColorSetting field0260 = new ColorSetting("chams.damagecolor", 255, 0, 0, 255, this.field0426::method0492)
      .method1882()
      .method1007("Damage Color")
      .method0210("Color when entity is damaged")
      .method2130("Цвет при получении урона");
   private final EnumSetting<Chams.RenderMode> field0233 = new EnumSetting<>(
         "chams.crystalmode", Chams.RenderMode.field1434, () -> this.field0202.method0439("chams.crystals").method0492()
      )
      .method1007("Crystal Mode")
      .method0210("Render mode for crystal chams")
      .method2130("Режим отрисовки чамсов кристаллов");
   private final ColorSetting field0293 = new ColorSetting(
         "chams.crystalfillcolor",
         255,
         139,
         255,
         55,
         () -> this.field0202.method0439("chams.crystals").method0492()
            && (this.field0233.method0492() == Chams.RenderMode.field0600 || this.field0233.method0492() == Chams.RenderMode.field1434)
      )
      .method1882()
      .method1007("Crystal Fill Color")
      .method0210("Fill color for crystal chams")
      .method2130("Цвет заливки чамсов кристаллов");
   private final ColorSetting field0527 = new ColorSetting(
         "chams.crystaloutlinecolor",
         255,
         156,
         255,
         73,
         () -> this.field0202.method0439("chams.crystals").method0492()
            && (this.field0233.method0492() == Chams.RenderMode.field0036 || this.field0233.method0492() == Chams.RenderMode.field1434)
      )
      .method1882()
      .method1007("Crystal Outline Color")
      .method0210("Outline color for crystal chams")
      .method2130("Цвет обводки чамсов кристаллов");
   private Color field0512;
   private Color field0556;
   private int field1672;
   private int field1658;
   private int field1689;
   private int field1591;
   private int field1578;
   private final Map<UUID, Long> field1608 = new HashMap<>();
   private final Map<UUID, Integer> field1760 = new HashMap<>();
   private final Map<UUID, class_243> field1747 = new HashMap<>();

   public static Chams method1705() {
      return field1435;
   }

   public static void method1096(UUID var0, class_243 var1) {
      if (field1435 != null) {
         field1435.field1747.put(var0, var1);
         field1435.field1608.put(var0, System.currentTimeMillis());
      }
   }

   public Chams() {
      super("Chams", ModuleCategory.field1004, "Renders entity models with custom colors through walls");
      this.method1013("Рисует модели сущностей через стены");
      field1435 = this;
   }

   public boolean method1129(class_1297 var1) {
      if (!this.method2195() || this.field1096.method0492() != Chams.RenderMode.field0971) {
         return false;
      } else if (this.field0830.method0492()) {
         return false;
      } else if (!(var1 instanceof class_1309)) {
         return false;
      } else {
         boolean var2 = this.field0202.method0439("chams.self").method0492();
         boolean var3 = this.field0202.method0439("chams.players").method0492();
         boolean var4 = this.field0202.method0439("chams.hostiles").method0492();
         boolean var5 = this.field0202.method0439("chams.passives").method0492();
         if (var1 != field0796.field_1724) {
            return this.method1149(var1, var3, var4, var5);
         } else {
            return !var2 ? false : !field0796.field_1690.method_31044().method_31034();
         }
      }
   }

   private EntityVertexConsumer.Vertex method0709(float var1, class_243 var2) {
      float var3 = (float)(System.currentTimeMillis() % 100000L / 1000.0);
      float var4 = var2 != null ? (float)var2.field_1352 : 0.0F;
      float var5 = var2 != null ? (float)var2.field_1351 : 0.0F;
      float var6 = var2 != null ? (float)var2.field_1350 : 0.0F;
      return new EntityVertexConsumer.Vertex(0.0625F, 0.04F, 0.0F, var3, 1.2F, 0.25F, 0.25F, 0.55F, var1, 0.55F, 1.6F, 6.0F, var4, var5, var6, 0.4F);
   }

   private float method1153(class_1309 var1) {
      UUID var2 = var1.method_5667();
      int var3 = var1.field_6235;
      int var4 = this.field1760.getOrDefault(var2, 0);
      long var5 = System.currentTimeMillis();
      if (var3 > var4) {
         this.field1608.put(var2, var5);
      }

      this.field1760.put(var2, var3);
      Long var7 = this.field1608.get(var2);
      if (var7 == null) {
         return -1.0F;
      }

      float var8 = (float)(var5 - var7) / 1000.0F;
      return var8 < 1.1F ? var8 : -1.0F;
   }

   @EventHandler
   public void onRenderWorld(GlowRenderEvent var1) {
      if (this.method2195()) {
         if (field0796.field_1687 != null && field0796.field_1724 != null) {
            boolean var2 = this.field0202.method0439("chams.self").method0492();
            boolean var3 = this.field0202.method0439("chams.players").method0492();
            boolean var4 = this.field0202.method0439("chams.hostiles").method0492();
            boolean var5 = this.field0202.method0439("chams.passives").method0492();
            boolean var6 = this.field0202.method0439("chams.crystals").method0492();
            boolean var7 = this.field0426.method0492();
            boolean var8 = this.field0464.method0492();
            boolean var9 = this.field1619.method0492();
            boolean var10 = field0796.field_1690.method_31044().method_31034();
            boolean var11 = FreeCam.field0061 != null && FreeCam.field0061.method2195();
            Chams.RenderMode var12 = this.field1096.method0492();
            boolean var13 = var12 == Chams.RenderMode.field0971;
            boolean var14 = var13 || var12 == Chams.RenderMode.field0600 || var12 == Chams.RenderMode.field1434;
            boolean var15 = !var13 && (var12 == Chams.RenderMode.field0036 || var12 == Chams.RenderMode.field1434);
            Color var16 = this.field0049.method1726();
            Color var17 = this.field1203.method1726();
            this.method1691();
            Chams.RenderMode var18 = this.field0233.method0492();
            boolean var19 = var18 == Chams.RenderMode.field0600 || var18 == Chams.RenderMode.field1434;
            boolean var20 = var18 == Chams.RenderMode.field0036 || var18 == Chams.RenderMode.field1434;
            Color var21 = this.field0293.method1726();
            Color var22 = this.field0527.method1726();
            float var23 = var1.method1603();
            class_4587 var24 = var1.method1808();
            Color var25 = this.field1550.method1726();
            float var26 = this.field1716.method0492();
            boolean var27 = this.field1141.method0492();

            for (class_1297 var29 : field0796.field_1687.method_18112()) {
               if ((var29 != field0796.field_1724 || var2 && !var10) && WorldGeometryRenderer.method1284(var29.method_5829())) {
                  if (var29 instanceof class_1309 var30) {
                     if (!this.method1149(var29, var3, var4, var5)) {
                        continue;
                     }

                     boolean var31 = this.field0875.method0492()
                        && var29 instanceof class_1657 var32
                        && DaamkyClient.method2004().method1608().method1129(var32);
                     boolean var39 = var7 && var30.field_6235 > 0;
                     Color var33;
                     Color var34;
                     if (var31) {
                        var33 = new Color(66, 245, 149, this.field0049.method2036());
                        var34 = new Color(66, 245, 149, this.field1203.method2036());
                     } else if (var39) {
                        var33 = this.field0512;
                        var34 = this.field0556;
                     } else {
                        var33 = var16;
                        var34 = var17;
                     }

                     float var35 = var13 ? this.method1153(var30) : -1.0F;
                     class_243 var36 = var13 ? this.field1747.get(var30.method_5667()) : null;
                     if (var13 && var36 == null && var35 >= 0.0F) {
                        var36 = var30.method_5829().method_1005();
                     }

                     EntityVertexConsumer.Vertex var37 = var13 ? this.method0709(var35, var36) : EntityVertexConsumer.Vertex.DEFAULT;
                     if (var13 && !this.field0830.method0492()) {
                        var33 = new Color(var33.getRed(), var33.getGreen(), var33.getBlue(), 255);
                     }

                     EntityVertexConsumer.method1148(
                        var30, false, 1.0F, var23, new EntityVertexConsumer.Quad(var14, var33, var15, var34, var8, var11, var13, var37)
                     );
                     if (var9) {
                        this.method1137(var30, var23, var24, var25, var26, var27);
                     }
                  }

                  if (var6 && var29 instanceof class_1511 var38) {
                     EntityVertexConsumer.method1148(var38, false, 1.0F, var23, new EntityVertexConsumer.Quad(var19, var21, var20, var22, var8, var11));
                  }
               }
            }
         }
      }
   }

   private void method1137(class_1297 var1, float var2, class_4587 var3, Color var4, float var5, boolean var6) {
      if (var4.getAlpha() > 0) {
         class_4184 var7 = field0796.field_1773.method_19418();
         class_243 var8 = var7.method_19326();
         float var9 = var1.method_17682();
         float var10 = var1.method_17681();
         float var11 = var9 * 1.3F + 0.3F;
         float var12 = var10 * 2.0F + 0.3F;
         double var13 = class_3532.method_16436(var2, var1.field_6038, var1.method_23317()) - var8.field_1352;
         double var15 = class_3532.method_16436(var2, var1.field_5971, var1.method_23318()) - var8.field_1351 + var9 * 0.5;
         double var17 = class_3532.method_16436(var2, var1.field_5989, var1.method_23321()) - var8.field_1350;
         RenderSystem.setShader(class_10142.field_53880);
         RenderSystem.setShaderTexture(0, field1044);
         RenderSystem.enableBlend();
         if (var6) {
            RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE);
         } else {
            RenderSystem.blendFuncSeparate(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA, class_4535.ZERO, class_4534.ONE);
         }

         RenderSystem.disableCull();
         RenderSystem.depthMask(false);
         RenderSystem.disableDepthTest();

         for (int var19 = 0; var19 < 2; var19++) {
            float var20 = 1.0F + var19 * 0.3F;
            float var21 = var5 * (1.0F / (1.0F + var19 * 0.6F));
            int var22 = class_3532.method_15340((int)(var4.getAlpha() * var21), 0, 255);
            if (var22 > 0) {
               int var23 = new Color(var4.getRed(), var4.getGreen(), var4.getBlue(), var22).getRGB();
               var3.method_22903();
               var3.method_22904(var13, var15, var17);
               var3.method_22907(var7.method_23767());
               float var24 = var12 * var20 * 0.5F;
               float var25 = var11 * var20 * 0.5F;
               Matrix4f var26 = var3.method_23760().method_23761();
               class_287 var27 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1575);
               var27.method_22918(var26, -var24, -var25, 0.0F).method_22913(0.0F, 1.0F).method_39415(var23);
               var27.method_22918(var26, var24, -var25, 0.0F).method_22913(1.0F, 1.0F).method_39415(var23);
               var27.method_22918(var26, var24, var25, 0.0F).method_22913(1.0F, 0.0F).method_39415(var23);
               var27.method_22918(var26, -var24, var25, 0.0F).method_22913(0.0F, 0.0F).method_39415(var23);
               class_286.method_43433(var27.method_60800());
               var3.method_22909();
            }
         }

         RenderSystem.enableDepthTest();
         RenderSystem.depthMask(true);
         RenderSystem.enableCull();
         RenderSystem.blendFuncSeparate(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA, class_4535.ZERO, class_4534.ONE);
         RenderSystem.disableBlend();
      }
   }

   private void method1691() {
      int var1 = this.field0260.method1742();
      int var2 = this.field0260.method2019();
      int var3 = this.field0260.method2002();
      int var4 = this.field0049.method2036();
      int var5 = this.field1203.method2036();
      if (var1 != this.field1672 || var2 != this.field1658 || var3 != this.field1689 || var4 != this.field1591 || var5 != this.field1578) {
         this.field0512 = new Color(var1, var2, var3, var4);
         this.field0556 = new Color(var1, var2, var3, var5);
         this.field1672 = var1;
         this.field1658 = var2;
         this.field1689 = var3;
         this.field1591 = var4;
         this.field1578 = var5;
      }
   }

   private boolean method1149(class_1297 var1, boolean var2, boolean var3, boolean var4) {
      if (var2 && var1.method_5864() == class_1299.field_6097) {
         return true;
      }

      if (var3 && var1.method_5864().method_5891() == class_1311.field_6302) {
         return true;
      }

      if (!var4) {
         return false;
      }

      class_1311 var5 = var1.method_5864().method_5891();
      return var5 == class_1311.field_6294
         || var5 == class_1311.field_6300
         || var5 == class_1311.field_24460
         || var5 == class_1311.field_30092
         || var5 == class_1311.field_34447;
   }

   public enum RenderMode implements DisplayNamed {
      field0600("Fill"),
      field0036("Outline"),
      field1434("Both"),
      field0971("Pixel Scale");

      private final String field0791;

      RenderMode(String var3) {
         this.field0791 = var3;
      }

      @Override
      public String method0557() {
         return this.field0791;
      }
   }
}
