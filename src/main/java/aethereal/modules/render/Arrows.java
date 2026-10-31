package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10142;
import net.minecraft.class_1044;
import net.minecraft.class_1657;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_465;
import net.minecraft.class_7833;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

public class Arrows extends Module {
   private static final class_2960 field1159 = class_2960.method_60655("daamky", "textures/arrow.png");
   private static final float field1087 = 0.9F;
   private static final float field1196 = 0.15F;
   public EnumSetting<Arrows.Style> field0058 = new EnumSetting<>("arrows.style", Arrows.Style.field0574)
      .method1007("Style")
      .method0210("Arrow rendering style")
      .method2130("Стиль отрисовки");
   public FloatSetting field1450 = new FloatSetting("arrows.distance", 30.0F, 20.0F, 150.0F, 5.0F)
      .method1007("Distance")
      .method0210("Distance of arrows from screen center")
      .method2130("Расстояние стрелок от центра экрана");
   public FloatSetting field0985 = new FloatSetting("arrows.size", 24.0F, 6.0F, 30.0F, 1.0F)
      .method1007("Size")
      .method0210("Size of arrow indicators")
      .method2130("Размер");
   public BooleanSetting field0184 = new BooleanSetting("arrows.expandoninventory", true)
      .method1007("Expand On Inventory")
      .method0210("Expand arrow radius when inventory is open")
      .method2130("Увеличить радиус при открытом инвентаре");
   public BooleanSetting field0464 = new BooleanSetting("arrows.showdistance", true)
      .method1007("Show Distance")
      .method0210("Display distance text below arrows")
      .method2130("Показывать расстояние");
   public ColorSetting field1623 = new ColorSetting("arrows.color", 255, 156, 249, 200)
      .method1882()
      .method1007("Arrow Color")
      .method0210("Default arrow color")
      .method2130("Цвет по умолчанию");
   public BooleanSetting field1544 = new BooleanSetting("arrows.friendcolor", true)
      .method1007("Friend Color")
      .method0210("Render friends in green instead of the default color")
      .method2130("Отображать друзей зелёным вместо обычного цвета");
   public BooleanSetting field1709 = new BooleanSetting("arrows.dynamic", true)
      .method1007("Dynamic")
      .method0210("Arrows react to camera and player movement")
      .method2130("Реагировать на движения");
   private float field0871;
   private float field0826 = 0.0F;
   private float field0910 = 0.0F;
   private float field1331 = 0.0F;
   private float field1292 = 0.0F;
   private boolean field1388 = true;
   private float field0385 = 0.0F;
   private float field0351 = 0.0F;
   private float field0423 = 0.0F;
   private final Map<UUID, Float> field0271 = new HashMap<>();

   public Arrows() {
      super("Arrows", ModuleCategory.field1004, "Renders directional arrows pointing to nearby players");
      this.method1013("Рисует стрелки к ближайшим игрокам");
   }

   @Override
   public void method2078() {
      super.method2078();
      this.field0271.clear();
      this.field1388 = true;
   }

   private static float method1186(class_1657 var0, float var1) {
      double var2 = var0.field_6014 + (var0.method_23317() - var0.field_6014) * var1;
      double var4 = var0.field_5969 + (var0.method_23321() - var0.field_5969) * var1;
      double var6 = field0796.field_1724.field_6014 + (field0796.field_1724.method_23317() - field0796.field_1724.field_6014) * var1;
      double var8 = field0796.field_1724.field_5969 + (field0796.field_1724.method_23321() - field0796.field_1724.field_5969) * var1;
      return (float)(-(Math.atan2(var2 - var6, var4 - var8) * 57.29577954311793));
   }

   @EventHandler
   public void onRender2D(HudRenderEvent var1) {
      if (this.method2195()) {
         if (field0796.field_1724 != null && field0796.field_1687 != null) {
            float var2 = field0796.field_1724.method_36454();
            float var3 = field0796.field_1724.method_36455();
            if (this.field1388) {
               this.field1331 = var2;
               this.field1292 = var3;
               this.field1388 = false;
            }

            if (this.field1709.method0492()) {
               float var4 = this.field1331 - var2;
               float var5 = this.field1292 - var3;

               while (var4 > 180.0F) {
                  var4 -= 360.0F;
               }

               while (var4 < -180.0F) {
                  var4 += 360.0F;
               }

               float var6 = var4 * 2.0F;
               float var7 = var5 * 2.0F;
               float var8 = (float)field0796.field_1724.method_18798().field_1352;
               float var9 = (float)field0796.field_1724.method_18798().field_1351;
               float var10 = (float)field0796.field_1724.method_18798().field_1350;
               this.field0385 = this.field0385 + (var8 - this.field0385) * 0.15F;
               this.field0351 = this.field0351 + (var9 - this.field0351) * 0.15F;
               this.field0423 = this.field0423 + (var10 - this.field0423) * 0.15F;
               float var11 = (float)Math.toRadians(field0796.field_1724.method_36454());
               float var12 = (float)(-this.field0385 * Math.sin(var11) + this.field0423 * Math.cos(var11));
               float var13 = (float)(this.field0385 * Math.cos(var11) + this.field0423 * Math.sin(var11));
               var6 += var13 * 10.0F;
               var7 += var12 * 10.0F;
               var7 -= this.field0351 * 8.0F;
               this.field0826 = this.field0826 + (var6 - this.field0826) * 0.05F;
               this.field0910 = this.field0910 + (var7 - this.field0910) * 0.05F;
               if (Math.abs(this.field0826) < 0.01F) {
                  this.field0826 = 0.0F;
               }

               if (Math.abs(this.field0910) < 0.01F) {
                  this.field0910 = 0.0F;
               }
            } else {
               this.field0826 *= 0.85F;
               this.field0910 *= 0.85F;
            }

            this.field1331 = var2;
            this.field1292 = var3;
            float var32 = this.field1450.method0492();
            if (this.field0184.method0492() && field0796.field_1755 instanceof class_465) {
               var32 += 100.0F;
            }

            this.field0871 = this.field0871 + (var32 - this.field0871) * 0.1F;
            FontSize var33 = Fonts.field0075.method0654(6.0F);
            float var35 = var1.method1632().method_60637(false);
            float var38 = ScreenLayoutHelper.method2047() / 2.0F;
            float var39 = ScreenLayoutHelper.method1762() / 2.0F;
            float var40 = field0796.field_1724.field_5982 + (field0796.field_1724.method_36454() - field0796.field_1724.field_5982) * var35;
            List var41 = new ArrayList<>();
            List var42 = new ArrayList<>();
            AntiBot var43 = AntiBot.method1700();

            for (class_1657 var14 : field0796.field_1687.method_18456()) {
               if (var14 != field0796.field_1724 && !var14.method_5477().getString().isEmpty() && (var43 == null || !var43.method0250(var14))) {
                  float var15 = method1186(var14, var35) - var40;
                  UUID var16 = var14.method_5667();
                  float var17 = this.field0271.getOrDefault(var16, var15);
                  float var18 = var15 - var17;

                  while (var18 > 180.0F) {
                     var18 -= 360.0F;
                  }

                  while (var18 < -180.0F) {
                     var18 += 360.0F;
                  }

                  var17 += var18 * 0.15F;
                  this.field0271.put(var16, var17);
                  float var19 = (float)Math.toRadians(var17);
                  float var20 = this.field0871 * class_3532.method_15374(var19) + var38 + this.field0826;
                  float var21 = -this.field0871 * class_3532.method_15362(var19) + var39 + this.field0910;
                  boolean var22 = this.field1544.method0492() && DaamkyClient.method2004().method1608().method2135(var14.method_5477().getString());
                  Color var23 = var22 ? new Color(66, 245, 149, this.field1623.method2036()) : this.field1623.method1726();
                  var41.add(new float[]{var20, var21, var17, Float.intBitsToFloat(var23.getRGB())});
                  if (this.field0464.method0492()) {
                     double var24 = var14.field_6014
                        + (var14.method_23317() - var14.field_6014) * var35
                        - (field0796.field_1724.field_6014 + (field0796.field_1724.method_23317() - field0796.field_1724.field_6014) * var35);
                     double var26 = var14.field_6036
                        + (var14.method_23318() - var14.field_6036) * var35
                        - (field0796.field_1724.field_6036 + (field0796.field_1724.method_23318() - field0796.field_1724.field_6036) * var35);
                     double var28 = var14.field_5969
                        + (var14.method_23321() - var14.field_5969) * var35
                        - (field0796.field_1724.field_5969 + (field0796.field_1724.method_23321() - field0796.field_1724.field_5969) * var35);
                     double var30 = Math.sqrt(var24 * var24 + var28 * var28);
                     var42.add(new Object[]{(double)var20, (double)var21, var30, var23});
                  }
               }
            }

            this.method0845(var1, var41);

            for (Object[] var46 : var42) {
               double var47 = (Double)var46[0];
               double var49 = (Double)var46[1];
               double var50 = (Double)var46[2];
               Color var51 = (Color)var46[3];
               String var52 = String.format("%.1fm", var50);
               float var53 = var33.method0998(var52);
               float var54 = (float)var47 - var53 / 2.0F;
               float var25 = (float)var49 + this.field0985.method0492() / 2.0F + 3.0F;
               GuiRenderHelper.method1491(var1.method1806().method_51448(), var33, var52, var54, var25, var51);
            }

            this.field0271.keySet().removeIf(var0 -> field0796.field_1687.method_18456().stream().noneMatch(var1x -> var1x.method_5667().equals(var0)));
         }
      }
   }

   private void method0845(HudRenderEvent var1, List<float[]> var2) {
      RenderSystem.setShader(class_10142.field_53880);
      RenderSystem.setShaderTexture(0, field1159);
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(770, 1);
      RenderSystem.disableCull();
      RenderSystem.depthMask(false);
      class_1044 var3 = field0796.method_1531().method_4619(field1159);
      if (var3 != null) {
         var3.method_4527(true, true);
      }

      GL11.glHint(3155, 4354);
      GL11.glEnable(2881);

      for (float[] var5 : var2) {
         class_4587 var6 = var1.method1806().method_51448();
         var6.method_22903();
         var6.method_46416(var5[0], var5[1], 0.0F);
         var6.method_22907(class_7833.field_40718.rotationDegrees(var5[2]));
         float var7 = this.field0985.method0492();
         float var8 = var7 * 0.9F;
         float var9 = var8 / 2.0F;
         float var10 = var7 / 2.0F;
         int var11 = Float.floatToRawIntBits(var5[3]);
         Matrix4f var12 = var6.method_23760().method_23761();
         class_287 var13 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1575);
         var13.method_22918(var12, -var9, -var10, 0.0F).method_22913(0.0F, 0.0F).method_39415(var11);
         var13.method_22918(var12, -var9, var10, 0.0F).method_22913(0.0F, 1.0F).method_39415(var11);
         var13.method_22918(var12, var9, var10, 0.0F).method_22913(1.0F, 1.0F).method_39415(var11);
         var13.method_22918(var12, var9, -var10, 0.0F).method_22913(1.0F, 0.0F).method_39415(var11);
         class_286.method_43433(var13.method_60800());
         var6.method_22909();
      }

      GL11.glDisable(2881);
      if (var3 != null) {
         var3.method_4527(false, false);
      }

      RenderSystem.depthMask(true);
      RenderSystem.enableCull();
      RenderSystem.disableBlend();
      RenderSystem.defaultBlendFunc();
   }

   public enum Style implements DisplayNamed {
      field0574("Default");

      private final String field0136;

      Style(String var3) {
         this.field0136 = var3;
      }

      @Override
      public String method0557() {
         return this.field0136;
      }
   }
}
