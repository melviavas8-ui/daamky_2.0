package aethereal;

import com.mojang.blaze3d.platform.GlStateManager.class_4534;
import com.mojang.blaze3d.platform.GlStateManager.class_4535;
import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10142;
import net.minecraft.class_1309;
import net.minecraft.class_243;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_7833;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;

public class TargetESP extends Module {
   private static final class_2960 field0160 = class_2960.method_60655("daamky", "textures/target.png");
   private static final class_2960 field1522 = class_2960.method_60655("daamky", "textures/glow.png");
   private static final class_2960 field1044 = class_2960.method_60655("daamky", "textures/spark.png");
   private final EnumSetting<TargetESP.Mode> field0189 = new EnumSetting<>("targetesp.mode", TargetESP.Mode.field0699)
      .method1007("Mode")
      .method0210("Visual style of the target indicator")
      .method2130("Стиль модуля");
   private final EnumSetting<TargetESP.TextureStyle> field0469 = new EnumSetting<>(
         "targetesp.texture", TargetESP.TextureStyle.field0698, () -> this.field0189.method0492() == TargetESP.Mode.field0123
      )
      .method1007("Texture")
      .method0210("Particle texture type")
      .method2130("Тип текстуры");
   private final EnumSetting<TargetESP.ShapeType> field1626 = new EnumSetting<>(
         "targetesp.shapetype", TargetESP.ShapeType.field0700, () -> this.field0189.method0492() == TargetESP.Mode.field1492
      )
      .method1007("Shape")
      .method0210("Geometry shape for Shapes mode")
      .method2130("Тип фигуры");
   private final ColorSetting field1550 = new ColorSetting("targetesp.color", 255, 152, 226, 200)
      .method1882()
      .method1007("Color")
      .method0210("Color of the target indicator")
      .method2130("Цвет");
   private final FloatSetting field1716 = new FloatSetting("targetesp.speed", 1.5F, 1.0F, 15.0F, 0.5F)
      .method1007("Speed")
      .method0210("Animation speed of the indicator")
      .method2130("Скорость");
   private final FloatSetting field1144 = new FloatSetting("targetesp.spread", 0.8F, 0.2F, 2.0F, 0.1F)
      .method1007("Spread")
      .method0210("How far particles spread from target")
      .method2130("Как далеко частицы разлетаются от таргета");
   private final BooleanSetting field1093 = new BooleanSetting("targetesp.throughwalls", true)
      .method1007("Through Walls")
      .method0210("Render indicator through blocks")
      .method2130("Отображать таргет сквозь блоки");
   private final FloatSetting field1206 = new FloatSetting("targetesp.fallbackrange", 12.0F, 2.0F, 20.0F, 0.5F)
      .method1007("Range")
      .method0210("Max range for target detection")
      .method2130("Максимальная дальность обнаружения цели");
   private static final int field0872 = 96;
   private static final float field0826 = 0.15F;
   private final EnumSetting<TargetESP.Mode> field0918 = new EnumSetting<>(
         "targetesp.bladeorbit", TargetESP.Mode.field0697, () -> this.field0189.method0492() == TargetESP.Mode.field1019
      )
      .method1007("Blade Orbit")
      .method0210("Orbit plane of blades")
      .method2130("Плоскость орбиты лезвий");
   private final FloatSetting field1341 = new FloatSetting(
         "targetesp.bladeradius", 1.3F, 0.5F, 2.5F, 0.1F, () -> this.field0189.method0492() == TargetESP.Mode.field1019
      )
      .method1007("Blade Spread")
      .method0210("Orbit radius as multiplier of hitbox width")
      .method2130("Радиус орбиты как множитель ширины хитбокса");
   private final FloatSetting field1302 = new FloatSetting(
         "targetesp.bladesize", 1.0F, 0.4F, 1.0F, 0.1F, () -> this.field0189.method0492() == TargetESP.Mode.field1019
      )
      .method1007("Blade Size")
      .method0210("Size of each blade")
      .method2130("Размер лезвия");
   private final FloatSetting field1377 = new FloatSetting(
         "targetesp.bladespeed", 1.0F, 0.2F, 3.0F, 0.1F, () -> this.field0189.method0492() == TargetESP.Mode.field1019
      )
      .method1007("Blade Speed")
      .method0210("Rotation speed of blades")
      .method2130("Скорость вращения лезвий");
   private final FloatSetting field0393 = new FloatSetting(
         "targetesp.bladecount", 4.0F, 2.0F, 12.0F, 1.0F, () -> this.field0189.method0492() == TargetESP.Mode.field1019
      )
      .method1007("Blade Count")
      .method0210("Number of blades")
      .method2130("Количество лезвий");
   private final BooleanSetting field0355 = new BooleanSetting(
         "targetesp.cubesparks", false, () -> this.field0189.method0492() == TargetESP.Mode.field1266
      )
      .method1007("Sparks")
      .method0210("Emit a small spark burst from the cube on each hit")
      .method2130("Искорки вылетают из куба при ударе");
   private class_1309 field0440;
   private class_1309 field0272;
   private final List<TargetESP.RenderPoint> field0238 = new ArrayList<>();
   private float field0289;
   private long field0525;
   private float field0501;
   private float field0547;
   private double field1670;
   private double field1656;
   private double field1687;
   private boolean field1597;
   private float field1577;
   private float field1601;
   private long field1755 = -1L;
   private int field1740 = -1;
   private boolean field1774 = false;
   private int field1175 = 0;
   private static final long field1165 = 240L;
   private static final float field1186 = 0.65F;
   private long field1120 = -1L;
   private static final float field1112 = 0.18F;
   private static final float field1129 = 0.3F;
   private static final float field1227 = 0.4F;
   private static final float field1219 = 0.27F;
   private static final float field1234 = 0.6F;
   private static final float field0899 = 0.08F;
   private final List<TargetESP.TargetState> field0896 = new ArrayList<>();
   private boolean field0907 = false;
   private double field0855;
   private double field0847;
   private double field0862;
   private double field0940;
   private float field0933;
   private float field0948;
   private float field1356;
   private final List<TargetESP.RenderShape> field1353 = new ArrayList<>();
   private class_1309 field1366;
   private final List<TargetESP.TargetAnimation> field1323 = new ArrayList<>();
   private float field1314;
   private static final class_243[][] field1329 = new class_243[][]{
      {
            new class_243(0.0, 0.8500003162575299, 0.8000000015134241),
            new class_243(0.20000001585804067, 0.8500003162575299, -0.6750000685489941),
            new class_243(0.6000003159631385, 1.3499998137357587, 0.6000003159631385),
            new class_243(-0.7400002388842586, 1.0499995624093656, 0.39999995534312804),
            new class_243(0.7400000600814527, 0.950000007956495, -0.40000007458364306),
            new class_243(-0.475000060783353, 0.8500003162575299, -0.375),
            new class_243(0.0, 1.3499998137357587, -0.6000002870957047),
            new class_243(0.8500003162575299, 0.7000001202807937, 0.09999998819572534),
            new class_243(-0.7000000376259103, 1.3499998137357587, -0.30000000195726123),
            new class_243(-0.30000000195726123, 1.3499998137357587, 0.550000008949574),
            new class_243(-0.5, 0.7000001202807937, 0.7000001202807937),
            new class_243(0.5, 0.7000001202807937, 0.7000001202807937),
            new class_243(-0.7000000376259103, 0.75, 0.0),
            new class_243(-0.20000003729295496, 0.6499997319148408, -0.7000000376259103)
      }
   };
   private static final class_243[][] field1401 = new class_243[][]{
      {
            new class_243(-49.0, 0.0, 40.0),
            new class_243(35.0, 0.0, -30.0),
            new class_243(-30.0, 0.0, 35.0),
            new class_243(-25.0, 0.0, -30.0),
            new class_243(0.0, 0.0, 0.0),
            new class_243(30.0, 0.0, -25.0),
            new class_243(45.0, 0.0, 0.0),
            new class_243(-30.0, 0.0, 30.0),
            new class_243(0.0, 0.0, 0.0),
            new class_243(0.0, 0.0, 0.0),
            new class_243(0.0, 0.0, 0.0),
            new class_243(0.0, 0.0, 0.0),
            new class_243(0.0, 0.0, 0.0),
            new class_243(0.0, 0.0, 0.0)
      }
   };
   private static final int field1390 = 6;
   private static final float field1403 = 0.25F;
   private static final float field0412 = 0.5F;
   private static final float field0407 = 0.2F;
   private static final float field0418 = 0.06F;
   private static final float[] field0378 = new float[]{0.55F, 0.72F, 0.48F, 0.65F, 0.58F, 0.8F};
   private static final float[] field0374 = new float[]{0.0F, 1.2F, 2.8F, 4.1F, 5.5F, 0.7F};
   private static final float[] field0383 = new float[]{50.0F, 65.0F, 40.0F, 60.0F, 55.0F, 70.0F};
   private static final float[] field0452 = new float[]{0.35F, 0.5F, 0.42F, 0.6F, 0.38F, 0.55F};
   private static final float[] field0447 = new float[]{1.0F, 3.5F, 0.5F, 2.2F, 4.8F, 1.8F};
   private static final float[] field0456 = new float[]{20.0F, 30.0F, 25.0F, 35.0F, 22.0F, 28.0F};
   private static final float[] field0283 = new float[]{0.4F, 0.55F, 0.35F, 0.5F, 0.45F, 0.62F};
   private static final float[] field0278 = new float[]{0.5F, 2.0F, 3.8F, 1.3F, 4.5F, 0.2F};
   private static final float[] field0288 = new float[]{0.08F, 0.12F, 0.07F, 0.1F, 0.09F, 0.11F};
   private static final float[][] field0250;

   public TargetESP() {
      super("TargetESP", ModuleCategory.field1004, "Renders visual indicators around targets");
      this.method1013("Рисует красивые частицы вокруг таргет");
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field0440 = null;
      this.field0272 = null;
      this.field0238.clear();
      this.field0289 = 0.0F;
      this.field0525 = System.currentTimeMillis();
      this.field0501 = 0.0F;
      this.field0547 = 0.0F;
      this.field1597 = false;
      this.field1120 = -1L;
      this.field1774 = false;
      this.field1175 = 0;
      this.field0896.clear();
      this.field0907 = false;
      this.field1353.clear();
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         this.method1691();
         this.field1601 = this.field1577;
         this.field1577 += 4.0F;
         boolean var2 = field0796.field_1724.field_6252;
         int var3 = field0796.field_1724.field_6279;
         boolean var4 = var2 && (!this.field1774 || var3 < this.field1175);
         this.field1774 = var2;
         this.field1175 = var3;
         if (var4 && this.field0272 != null) {
            if (this.field0189.method0492() == TargetESP.Mode.field1019) {
               this.method1735();
            } else if (this.field0189.method0492() == TargetESP.Mode.field1266) {
               this.field1120 = System.currentTimeMillis();
               if (this.field0355.method0492()) {
                  this.method2043();
               }
            }
         }
      }
   }

   private void method1735() {
      if (this.field0272 != null) {
         int var1 = this.field0393.method0492().intValue();
         if (var1 > 0) {
            float var2 = this.field1577 * this.field1377.method0492();
            float var3 = Float.MAX_VALUE;
            int var4 = 0;
            float var5 = this.field0272.method_17681();
            float var6 = Math.max(0.4F, var5) * this.field1341.method0492();
            float var7 = this.field0272.method_17682() * 0.5F + 0.25F;

            for (int var8 = 0; var8 < var1; var8++) {
               float var9 = var2 + var8 * (360.0F / var1);
               float var10 = (float)Math.toRadians(var9);
               float var11 = (float)this.field1670 + class_3532.method_15362(var10) * var6;
               float var12 = (float)this.field1656 + var7;
               float var13 = (float)this.field1687 + class_3532.method_15374(var10) * var6;
               float var14 = var11 * var11 + var12 * var12 + var13 * var13;
               if (var14 < var3) {
                  var3 = var14;
                  var4 = var8;
               }
            }

            this.field1740 = var4;
            this.field1755 = System.currentTimeMillis();
         }
      }
   }

   private void method1691() {
      class_1309 var1 = this.method1753();
      if (var1 != this.field0440) {
         if (this.field0440 != null) {
            this.field0238.add(new TargetESP.RenderPoint(this.field0440));
         }

         this.field0440 = var1;
         this.field0547 = var1 != null ? 0.0F : this.field0547;
      }
   }

   private class_1309 method1753() {
      Aura var1 = Aura.method1701();
      return var1 != null && var1.method2195() ? var1.method0409() : null;
   }

   @EventHandler
   public void onRender3D(WorldRenderEvent.GamePass var1) {
      if (!method1974()) {
         long var2 = System.currentTimeMillis();
         float var4 = (float)(var2 - this.field0525) / 1000.0F;
         this.field0525 = var2;
         float var5 = this.field0189.method0492() == TargetESP.Mode.field0123 ? 1.5F : 4.0F;
         Iterator var6 = this.field0238.iterator();

         while (var6.hasNext()) {
            TargetESP.RenderPoint var7 = var6.next();
            var7.field0003 -= var4 * 2.0F;
            if (var7.field0003 <= 0.01F) {
               var6.remove();
            } else {
               var7.field1409 = var7.field0731.method_23317();
               var7.field0956 = var7.field0731.method_23318();
               var7.field0757 = var7.field0731.method_23321();
            }
         }

         if (this.field0440 != null && this.field0440.method_5805()) {
            this.field0272 = this.field0440;
            this.field1597 = true;
            this.field0547 = Math.min(1.0F, this.field0547 + var4 * var5);
         } else {
            this.field1597 = false;
            this.field0547 = Math.max(0.0F, this.field0547 - var4 * var5);
         }

         this.field0501 = method2092(this.field0547);
         if (this.field0189.method0492() == TargetESP.Mode.field1266) {
            if (this.field0907 && !this.field1597) {
               this.method2015();
               this.field0907 = false;
            }

            if (!this.field0896.isEmpty()) {
               this.method2172(var1.method1629(), var4, this.field1550.method1726());
            }

            if (!this.field1353.isEmpty()) {
               this.method1872(var1.method1629(), var4, this.field1550.method1726());
            }
         } else {
            if (!this.field0896.isEmpty()) {
               this.field0896.clear();
            }

            if (!this.field1353.isEmpty()) {
               this.field1353.clear();
            }
         }

         if (this.field0501 <= 0.001F && this.field0238.isEmpty()) {
            if (!this.field1597) {
               this.field0272 = null;
            }
         } else {
            this.field0289 = this.field0289 + this.field1716.method0492() * var4 * 1.667F;
            float var24 = var1.method1811().method_60637(false);
            class_243 var8 = field0796.field_1773.method_19418().method_19326();
            if (this.field0272 != null) {
               this.field1670 = class_3532.method_16436(var24, this.field0272.field_6014, this.field0272.method_23317()) - var8.field_1352;
               this.field1656 = class_3532.method_16436(var24, this.field0272.field_6036, this.field0272.method_23318()) - var8.field_1351;
               this.field1687 = class_3532.method_16436(var24, this.field0272.field_5969, this.field0272.method_23321()) - var8.field_1350;
            }

            Color var9 = this.field1550.method1726();
            float var10 = this.field0501;
            if (this.field0189.method0492() == TargetESP.Mode.field0699) {
               if (this.field0272 != null && var10 > 0.001F) {
                  int var11 = (int)(var9.getAlpha() * var10);
                  this.method1494(var1.method1629(), var9, var11, var10);
               }
            } else if (this.field0189.method0492() == TargetESP.Mode.field1492) {
               if (this.field0272 != null && var10 > 0.001F) {
                  this.method1454(var1.method1629(), var10);
               }
            } else if (this.field0189.method0492() == TargetESP.Mode.field1019) {
               if (this.field0272 != null && var10 > 0.001F) {
                  this.method1474(var1.method1629(), var10, var24, var9);
               }
            } else if (this.field0189.method0492() == TargetESP.Mode.field0783) {
               if (this.field0272 != null && var10 > 0.001F) {
                  this.method1477(var1.method1629(), var10, var9);
               }
            } else if (this.field0189.method0492() == TargetESP.Mode.field1266) {
               if (this.field0272 != null && var10 > 0.001F) {
                  this.method0330(var1.method1629(), var10, var9);
               }
            } else {
               RenderSystem.setShader(class_10142.field_53880);
               RenderSystem.setShaderTexture(0, this.method2028());
               RenderSystem.enableBlend();
               RenderSystem.blendFuncSeparate(770, 1, 0, 1);
               RenderSystem.disableCull();
               if (this.field1093.method0492()) {
                  RenderSystem.disableDepthTest();
               }

               RenderSystem.depthMask(false);
               int var25 = var9.getAlpha();
               if (this.field0272 != null && var10 > 0.001F) {
                  int var12 = (int)(var25 * var10);
                  Color var13 = new Color(var9.getRed(), var9.getGreen(), var9.getBlue(), var12);
                  float var14 = this.field1144.method0492() * var10;
                  this.method1453(var1.method1629(), this.field1670, this.field1656, this.field1687, this.field0289, var14, var13, var10);
               }

               for (TargetESP.RenderPoint var27 : this.field0238) {
                  float var28 = method2092(var27.field0003);
                  if (!(var28 <= 0.001F)) {
                     double var15 = class_3532.method_16436(var24, var27.field0731.field_6038, var27.field1409) - var8.field_1352;
                     double var17 = class_3532.method_16436(var24, var27.field0731.field_5971, var27.field0956) - var8.field_1351;
                     double var19 = class_3532.method_16436(var24, var27.field0731.field_5989, var27.field0757) - var8.field_1350;
                     int var21 = (int)(var25 * var28);
                     Color var22 = new Color(var9.getRed(), var9.getGreen(), var9.getBlue(), var21);
                     float var23 = this.field1144.method0492() * var28;
                     this.method1453(var1.method1629(), var15, var17, var19, this.field0289, var23, var22, var28);
                  }
               }

               RenderSystem.enableDepthTest();
               RenderSystem.depthMask(true);
               RenderSystem.disableBlend();
               RenderSystem.blendFunc(770, 771);
               RenderSystem.enableCull();
            }
         }
      }
   }

   private void method1453(class_4587 var1, double var2, double var4, double var6, float var8, float var9, Color var10, float var11) {
      int var12 = 3;
      int var13 = 12;
      int var14 = var12 * var13;
      class_287 var15 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1575);

      for (int var16 = 0; var16 < var14; var16++) {
         int var17 = var16 / var13;
         int var18 = var16 % var13;
         float var19 = var18 * ((float) (Math.PI * 2) / var13);
         float var20 = var8 + var19;
         float var21 = 0.3F * var11 * class_3532.method_15374(var8 + var19 * 2.0F);
         float var22 = 0.5F + var21 + 0.2F * var17;
         float var23 = var9 * class_3532.method_15374(var20 + (float)Math.pow(var17, 2.0));
         float var24 = var9 * class_3532.method_15362(var20 - (float)Math.pow(var17, 2.0));
         float var25 = 0.005F + var18 / 2000.0F;
         float var26 = var25 * var11;
         var1.method_22903();
         var1.method_22904(var2 + var23, var4 + var22, var6 + var24);
         var1.method_22905(var26, var26, var26);
         var1.method_22907(field0796.field_1773.method_19418().method_23767());
         float var27 = -25.0F;
         float var28 = 50.0F;
         int var29 = var10.getRGB();
         var15.method_22918(var1.method_23760().method_23761(), var27, var27 + var28, 0.0F).method_22913(0.0F, 1.0F).method_39415(var29);
         var15.method_22918(var1.method_23760().method_23761(), var27 + var28, var27 + var28, 0.0F).method_22913(1.0F, 1.0F).method_39415(var29);
         var15.method_22918(var1.method_23760().method_23761(), var27 + var28, var27, 0.0F).method_22913(1.0F, 0.0F).method_39415(var29);
         var15.method_22918(var1.method_23760().method_23761(), var27, var27, 0.0F).method_22913(0.0F, 0.0F).method_39415(var29);
         var1.method_22909();
      }

      class_286.method_43433(var15.method_60800());
   }

   private class_2960 method2028() {
      return switch ((TargetESP.TextureStyle)this.field0469.method0492()) {
         case field0122 -> field1522;
         case field1491 -> field1044;
         default -> field0160;
      };
   }

   private void method1477(class_4587 var1, float var2, Color var3) {
      float var4 = this.field0272.method_17682();
      float var5 = Math.max(0.45F, this.field0272.method_17681() * 0.55F) * this.field1144.method0492();
      float var6 = this.field0289 * 0.6F;
      float var7 = (class_3532.method_15374(var6) + 1.0F) * 0.5F;
      float var8 = var7 * var4;
      float var9 = 0.5F + 0.5F * Math.abs(class_3532.method_15362(var6));
      int var10 = Math.max(0, Math.min(255, (int)(var3.getAlpha() * var2 * var9)));
      if (var10 >= 2) {
         int var11 = this.method0965(var3, var10);
         class_4184 var12 = field0796.field_1773.method_19418();
         RenderSystem.setShader(class_10142.field_53880);
         RenderSystem.setShaderTexture(0, field1522);
         RenderSystem.enableBlend();
         RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE);
         RenderSystem.disableCull();
         if (this.field1093.method0492()) {
            RenderSystem.disableDepthTest();
         }

         RenderSystem.depthMask(false);

         for (int var13 = 0; var13 < 96; var13++) {
            float var14 = (float) (Math.PI * 2) * var13 / 96.0F;
            float var15 = class_3532.method_15362(var14);
            float var16 = class_3532.method_15374(var14);
            this.method1512(var1, var12, var15 * var5, var8, var16 * var5, 0.15F, var11);
         }

         RenderSystem.depthMask(true);
         RenderSystem.enableDepthTest();
         RenderSystem.enableCull();
         RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA);
         RenderSystem.disableBlend();
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      }
   }

   private void method1512(class_4587 var1, class_4184 var2, float var3, float var4, float var5, float var6, int var7) {
      if (var7 >>> 24 >= 2) {
         var1.method_22903();
         var1.method_46416((float)this.field1670 + var3, (float)this.field1656 + var4, (float)this.field1687 + var5);
         var1.method_22907(var2.method_23767());
         Matrix4f var8 = var1.method_23760().method_23761();
         class_287 var9 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1575);
         var9.method_22918(var8, -var6, -var6, 0.0F).method_22913(0.0F, 1.0F).method_39415(var7);
         var9.method_22918(var8, var6, -var6, 0.0F).method_22913(1.0F, 1.0F).method_39415(var7);
         var9.method_22918(var8, var6, var6, 0.0F).method_22913(1.0F, 0.0F).method_39415(var7);
         var9.method_22918(var8, -var6, var6, 0.0F).method_22913(0.0F, 0.0F).method_39415(var7);
         class_286.method_43433(var9.method_60800());
         var1.method_22909();
      }
   }

   private void method0330(class_4587 var1, float var2, Color var3) {
      if (this.field1597) {
         class_4184 var4 = field0796.field_1773.method_19418();
         float var5 = Math.max(0.4F, this.field0272.method_17681());
         float var6 = this.field0272.method_17682() * 0.5F;
         float var7 = var5 * 0.5F / 1.7320508F * this.field1144.method0492() * var2 * this.method0461();
         if (!(var7 < 0.001F)) {
            float var8 = this.method0645(this.field0289 * 0.4F);
            float var9 = this.method0645(this.field0289 * 0.27F + 0.5F);
            int var10 = this.method0965(var3, (int)(var3.getAlpha() * var2));
            RenderSystem.setShader(class_10142.field_53876);
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA);
            RenderSystem.disableCull();
            if (this.field1093.method0492()) {
               RenderSystem.disableDepthTest();
            } else {
               RenderSystem.enableDepthTest();
            }

            RenderSystem.depthMask(false);
            var1.method_22903();
            var1.method_22904(this.field1670, this.field1656 + var6, this.field1687);
            var1.method_22907(class_7833.field_40716.rotationDegrees(var8));
            var1.method_22907(class_7833.field_40714.rotationDegrees(var9));
            this.method1558(var1.method_23760().method_23761(), var7, var7 * 0.08F, var10);
            var1.method_22909();
            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
            this.method1513(var1, var4, var8, var9, var7, var6, var3, var2);
            class_243 var11 = var4.method_19326();
            this.field0855 = var11.field_1352 + this.field1670;
            this.field0847 = var11.field_1351 + this.field1656 + var6;
            this.field0862 = var11.field_1350 + this.field1687;
            this.field0940 = var11.field_1351 + this.field1656;
            this.field0933 = var7;
            this.field0948 = var8;
            this.field1356 = var9;
            this.field0907 = true;
         }
      }
   }

   private float method0645(float var1) {
      int var2 = (int)Math.floor(var1);
      float var3 = var1 - var2;
      float var4 = var3 < 0.6F ? method0115(var3 / 0.6F) : 1.0F;
      return (var2 % 4 + var4) * 90.0F;
   }

   private void method1558(Matrix4f var1, float var2, float var3, int var4) {
      class_287 var5 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1576);
      float var6 = 0.3F;

      for (int var7 = 0; var7 < 8; var7++) {
         float var8 = (var7 & 1) != 0 ? var2 : -var2;
         float var9 = (var7 & 2) != 0 ? var2 : -var2;
         float var10 = (var7 & 4) != 0 ? var2 : -var2;
         this.method1383(var5, var1, var8, var9, var10, var8 - 2.0F * var8 * var6, var9, var10, var3, var4);
         this.method1383(var5, var1, var8, var9, var10, var8, var9 - 2.0F * var9 * var6, var10, var3, var4);
         this.method1383(var5, var1, var8, var9, var10, var8, var9, var10 - 2.0F * var10 * var6, var3, var4);
      }

      class_286.method_43433(var5.method_60800());
   }

   private void method1383(class_287 var1, Matrix4f var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10) {
      float var11;
      float var12;
      float var13;
      float var14;
      float var15;
      float var16;
      if (var3 != var6) {
         var11 = 0.0F;
         var12 = var9;
         var13 = 0.0F;
         var14 = 0.0F;
         var15 = 0.0F;
         var16 = var9;
      } else if (var4 != var7) {
         var11 = var9;
         var12 = 0.0F;
         var13 = 0.0F;
         var14 = 0.0F;
         var15 = 0.0F;
         var16 = var9;
      } else {
         var11 = var9;
         var12 = 0.0F;
         var13 = 0.0F;
         var14 = 0.0F;
         var15 = var9;
         var16 = 0.0F;
      }

      float var17 = var3 - var11 - var14;
      float var18 = var4 - var12 - var15;
      float var19 = var5 - var13 - var16;
      float var20 = var3 + var11 - var14;
      float var21 = var4 + var12 - var15;
      float var22 = var5 + var13 - var16;
      float var23 = var3 + var11 + var14;
      float var24 = var4 + var12 + var15;
      float var25 = var5 + var13 + var16;
      float var26 = var3 - var11 + var14;
      float var27 = var4 - var12 + var15;
      float var28 = var5 - var13 + var16;
      float var29 = var6 - var11 - var14;
      float var30 = var7 - var12 - var15;
      float var31 = var8 - var13 - var16;
      float var32 = var6 + var11 - var14;
      float var33 = var7 + var12 - var15;
      float var34 = var8 + var13 - var16;
      float var35 = var6 + var11 + var14;
      float var36 = var7 + var12 + var15;
      float var37 = var8 + var13 + var16;
      float var38 = var6 - var11 + var14;
      float var39 = var7 - var12 + var15;
      float var40 = var8 - var13 + var16;
      this.method1381(var1, var2, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var10);
      this.method1381(var1, var2, var29, var30, var31, var38, var39, var40, var35, var36, var37, var32, var33, var34, var10);
      this.method1381(var1, var2, var17, var18, var19, var29, var30, var31, var32, var33, var34, var20, var21, var22, var10);
      this.method1381(var1, var2, var20, var21, var22, var32, var33, var34, var35, var36, var37, var23, var24, var25, var10);
      this.method1381(var1, var2, var23, var24, var25, var35, var36, var37, var38, var39, var40, var26, var27, var28, var10);
      this.method1381(var1, var2, var26, var27, var28, var38, var39, var40, var29, var30, var31, var17, var18, var19, var10);
   }

   private void method1381(
      class_287 var1,
      Matrix4f var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      int var15
   ) {
      var1.method_22918(var2, var3, var4, var5).method_39415(var15);
      var1.method_22918(var2, var6, var7, var8).method_39415(var15);
      var1.method_22918(var2, var9, var10, var11).method_39415(var15);
      var1.method_22918(var2, var12, var13, var14).method_39415(var15);
   }

   private void method1513(class_4587 var1, class_4184 var2, float var3, float var4, float var5, float var6, Color var7, float var8) {
      class_4587 var9 = new class_4587();
      var9.method_22907(class_7833.field_40716.rotationDegrees(var3));
      var9.method_22907(class_7833.field_40714.rotationDegrees(var4));
      Matrix4f var10 = new Matrix4f(var9.method_23760().method_23761());
      RenderSystem.setShader(class_10142.field_53880);
      RenderSystem.setShaderTexture(0, field1522);
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE);
      RenderSystem.disableCull();
      if (this.field1093.method0492()) {
         RenderSystem.disableDepthTest();
      } else {
         RenderSystem.enableDepthTest();
      }

      RenderSystem.depthMask(false);
      int var11 = this.method0965(var7, (int)(var7.getAlpha() * var8 * 0.3F));
      float var12 = var5 * 0.42F;
      float var13 = 0.3F;
      var1.method_22903();
      var1.method_22904(this.field1670, this.field1656 + var6, this.field1687);
      class_287 var14 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1575);

      for (int var15 = 0; var15 < 8; var15++) {
         float var16 = (var15 & 1) != 0 ? var5 : -var5;
         float var17 = (var15 & 2) != 0 ? var5 : -var5;
         float var18 = (var15 & 4) != 0 ? var5 : -var5;
         this.method1380(var14, var1, var2, var10, var16, var17, var18, var16 - 2.0F * var16 * var13, var17, var18, var12, var11);
         this.method1380(var14, var1, var2, var10, var16, var17, var18, var16, var17 - 2.0F * var17 * var13, var18, var12, var11);
         this.method1380(var14, var1, var2, var10, var16, var17, var18, var16, var17, var18 - 2.0F * var18 * var13, var12, var11);
      }

      class_286.method_43433(var14.method_60800());
      var1.method_22909();
      RenderSystem.depthMask(true);
      RenderSystem.enableDepthTest();
      RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA);
      RenderSystem.disableBlend();
      RenderSystem.enableCull();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void method1380(
      class_287 var1,
      class_4587 var2,
      class_4184 var3,
      Matrix4f var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      int var12
   ) {
      int var13 = 3;

      for (int var14 = 0; var14 < var13; var14++) {
         float var15 = (float)var14 / (var13 - 1);
         float var16 = var5 + (var8 - var5) * var15;
         float var17 = var6 + (var9 - var6) * var15;
         float var18 = var7 + (var10 - var7) * var15;
         Vector4f var19 = new Vector4f(var16, var17, var18, 1.0F);
         var4.transform(var19);
         var2.method_22903();
         var2.method_46416(var19.x, var19.y, var19.z);
         var2.method_22907(var3.method_23767());
         Matrix4f var20 = var2.method_23760().method_23761();
         var1.method_22918(var20, -var11, var11, 0.0F).method_22913(0.0F, 1.0F).method_39415(var12);
         var1.method_22918(var20, var11, var11, 0.0F).method_22913(1.0F, 1.0F).method_39415(var12);
         var1.method_22918(var20, var11, -var11, 0.0F).method_22913(1.0F, 0.0F).method_39415(var12);
         var1.method_22918(var20, -var11, -var11, 0.0F).method_22913(0.0F, 0.0F).method_39415(var12);
         var2.method_22909();
      }
   }

   private void method2015() {
      this.field0896.clear();
      float var1 = this.field0933;
      if (!(var1 < 0.001F)) {
         float var2 = 0.6F * var1;
         class_4587 var3 = new class_4587();
         var3.method_22907(class_7833.field_40716.rotationDegrees(this.field0948));
         var3.method_22907(class_7833.field_40714.rotationDegrees(this.field1356));
         Matrix4f var4 = new Matrix4f(var3.method_23760().method_23761());

         for (int var5 = 0; var5 < 8; var5++) {
            float var6 = (var5 & 1) != 0 ? 1.0F : -1.0F;
            float var7 = (var5 & 2) != 0 ? 1.0F : -1.0F;
            float var8 = (var5 & 4) != 0 ? 1.0F : -1.0F;
            Vector4f var9 = new Vector4f(var6 * var1, var7 * var1, var8 * var1, 1.0F);
            var4.transform(var9);
            TargetESP.TargetState var10 = new TargetESP.TargetState();
            var10.field0565 = this.field0855 + var9.x;
            var10.field0002 = this.field0847 + var9.y;
            var10.field1409 = this.field0862 + var9.z;
            var10.field0314 = var1;
            var10.field0177 = var2;
            var10.field0458 = var6;
            var10.field1614 = var7;
            var10.field1538 = var8;
            double var11 = Math.sqrt(var9.x * var9.x + var9.y * var9.y + var9.z * var9.z);
            if (var11 < 1.0000000052583687E-4) {
               var11 = 1.0;
            }

            float var13 = 1.7F;
            var10.field0956 = var9.x / var11 * var13 + (Math.random() - 0.5) * 0.7000001202807937;
            var10.field0757 = 1.299999465574693 + Math.random() * 0.9000000124056896;
            var10.field1241 = var9.z / var11 * var13 + (Math.random() - 0.5) * 0.7000001202807937;
            var10.field1704 = (float)(Math.random() * 360.0);
            var10.field1136 = (float)(Math.random() * 360.0);
            var10.field1087 = (float)(Math.random() * 360.0);
            var10.field1196 = (float)((Math.random() - 0.5) * 520.0);
            var10.field0871 = (float)((Math.random() - 0.5) * 520.0);
            var10.field0826 = (float)((Math.random() - 0.5) * 520.0);
            var10.field0910 = 0.0F;
            var10.field1331 = 1.1F + (float)(Math.random() * 0.5);
            this.field0896.add(var10);
         }
      }
   }

   private void method2172(class_4587 var1, float var2, Color var3) {
      float var4 = Math.min(var2, 0.1F);
      float var5 = 16.0F;
      Iterator var6 = this.field0896.iterator();

      while (var6.hasNext()) {
         TargetESP.TargetState var7 = var6.next();
         var7.field0910 += var4;
         if (var7.field0910 >= var7.field1331) {
            var6.remove();
         } else {
            var7.field0757 -= var5 * var4;
            var7.field0565 = var7.field0565 + var7.field0956 * var4;
            var7.field0002 = var7.field0002 + var7.field0757 * var4;
            var7.field1409 = var7.field1409 + var7.field1241 * var4;
            var7.field1704 = var7.field1704 + var7.field1196 * var4;
            var7.field1136 = var7.field1136 + var7.field0871 * var4;
            var7.field1087 = var7.field1087 + var7.field0826 * var4;
            if (var7.field0002 <= this.field0940) {
               var7.field0002 = this.field0940;
               if (var7.field0757 < 0.0) {
                  var7.field0757 = -var7.field0757 * 0.18000000001546174;
               }

               float var8 = (float)Math.pow(5.000000474975632E-4, var4);
               var7.field0956 *= var8;
               var7.field1241 *= var8;
               var7.field1196 *= var8;
               var7.field0871 *= var8;
               var7.field0826 *= var8;
            }
         }
      }

      if (!this.field0896.isEmpty()) {
         class_4184 var17 = field0796.field_1773.method_19418();
         class_243 var18 = var17.method_19326();
         int var9 = var3.getAlpha();
         RenderSystem.setShader(class_10142.field_53876);
         RenderSystem.enableBlend();
         RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA);
         RenderSystem.disableCull();
         if (this.field1093.method0492()) {
            RenderSystem.disableDepthTest();
         } else {
            RenderSystem.enableDepthTest();
         }

         RenderSystem.depthMask(false);
         class_287 var10 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1576);

         for (TargetESP.TargetState var12 : this.field0896) {
            int var13 = this.method0965(var3, (int)(var9 * method0940(var12)));
            float var14 = var12.field0314 * 0.08F;
            var1.method_22903();
            var1.method_22904(var12.field0565 - var18.field_1352, var12.field0002 - var18.field_1351, var12.field1409 - var18.field_1350);
            var1.method_22907(class_7833.field_40716.rotationDegrees(var12.field1136));
            var1.method_22907(class_7833.field_40714.rotationDegrees(var12.field1704));
            var1.method_22907(class_7833.field_40718.rotationDegrees(var12.field1087));
            Matrix4f var15 = var1.method_23760().method_23761();
            this.method1383(var10, var15, 0.0F, 0.0F, 0.0F, -var12.field0458 * var12.field0177, 0.0F, 0.0F, var14, var13);
            this.method1383(var10, var15, 0.0F, 0.0F, 0.0F, 0.0F, -var12.field1614 * var12.field0177, 0.0F, var14, var13);
            this.method1383(var10, var15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -var12.field1538 * var12.field0177, var14, var13);
            var1.method_22909();
         }

         class_286.method_43433(var10.method_60800());
         RenderSystem.depthMask(true);
         RenderSystem.enableDepthTest();
         RenderSystem.disableBlend();
         RenderSystem.enableCull();
         RenderSystem.setShader(class_10142.field_53880);
         RenderSystem.setShaderTexture(0, field1522);
         RenderSystem.enableBlend();
         RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE);
         RenderSystem.disableCull();
         if (this.field1093.method0492()) {
            RenderSystem.disableDepthTest();
         } else {
            RenderSystem.enableDepthTest();
         }

         RenderSystem.depthMask(false);
         class_287 var19 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1575);

         for (TargetESP.TargetState var21 : this.field0896) {
            int var22 = this.method0965(var3, (int)(var9 * method0940(var21) * 0.4F));
            float var23 = var21.field0314 * 0.6F;
            var1.method_22903();
            var1.method_22904(var21.field0565 - var18.field_1352, var21.field0002 - var18.field_1351, var21.field1409 - var18.field_1350);
            var1.method_22907(var17.method_23767());
            Matrix4f var16 = var1.method_23760().method_23761();
            var19.method_22918(var16, -var23, var23, 0.0F).method_22913(0.0F, 1.0F).method_39415(var22);
            var19.method_22918(var16, var23, var23, 0.0F).method_22913(1.0F, 1.0F).method_39415(var22);
            var19.method_22918(var16, var23, -var23, 0.0F).method_22913(1.0F, 0.0F).method_39415(var22);
            var19.method_22918(var16, -var23, -var23, 0.0F).method_22913(0.0F, 0.0F).method_39415(var22);
            var1.method_22909();
         }

         class_286.method_43433(var19.method_60800());
         RenderSystem.depthMask(true);
         RenderSystem.enableDepthTest();
         RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA);
         RenderSystem.disableBlend();
         RenderSystem.enableCull();
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      }
   }

   private static float method0940(TargetESP.TargetState var0) {
      float var1 = var0.field0910 / var0.field1331;
      if (var1 < 0.6F) {
         return 1.0F;
      }

      float var2 = 1.0F - (var1 - 0.6F) / 0.4F;
      return var2 < 0.0F ? 0.0F : var2;
   }

   private void method2043() {
      float var1 = this.field0933;
      if (!(var1 < 0.001F) && this.field1353.size() <= 500) {
         class_4587 var2 = new class_4587();
         var2.method_22907(class_7833.field_40716.rotationDegrees(this.field0948));
         var2.method_22907(class_7833.field_40714.rotationDegrees(this.field1356));
         Matrix4f var3 = new Matrix4f(var2.method_23760().method_23761());
         int var4 = 12 + (int)(Math.random() * 5.0);

         for (int var5 = 0; var5 < var4; var5++) {
            int var6 = (int)(Math.random() * 8.0);
            float var7 = (var6 & 1) != 0 ? var1 : -var1;
            float var8 = (var6 & 2) != 0 ? var1 : -var1;
            float var9 = (var6 & 4) != 0 ? var1 : -var1;
            Vector4f var10 = new Vector4f(var7, var8, var9, 1.0F);
            var3.transform(var10);
            double var11 = Math.sqrt(var10.x * var10.x + var10.y * var10.y + var10.z * var10.z);
            if (var11 < 1.0000000052583687E-4) {
               var11 = 1.0;
            }

            double var13 = 1.6000000484436039 + Math.random() * 2.2000000973542457;
            TargetESP.RenderShape var15 = new TargetESP.RenderShape();
            var15.field0565 = this.field0855 + var10.x;
            var15.field0002 = this.field0847 + var10.y;
            var15.field1409 = this.field0862 + var10.z;
            var15.field0956 = var10.x / var11 * var13 + (Math.random() - 0.5) * 1.2000006430216648;
            var15.field0757 = var10.y / var11 * var13 + (Math.random() - 0.5) * 1.2000006430216648 + 0.6000003159631385;
            var15.field1241 = var10.z / var11 * var13 + (Math.random() - 0.5) * 1.2000006430216648;
            var15.field0314 = 0.0F;
            var15.field0177 = 0.32F + (float)(Math.random() * 0.39999995534312804);
            var15.field0458 = 0.02F + (float)(Math.random() * 0.035000023406755926);
            this.field1353.add(var15);
         }
      }
   }

   private void method1872(class_4587 var1, float var2, Color var3) {
      float var4 = Math.min(var2, 0.1F);
      float var5 = 7.0F;
      Iterator var6 = this.field1353.iterator();

      while (var6.hasNext()) {
         TargetESP.RenderShape var7 = var6.next();
         var7.field0314 += var4;
         if (var7.field0314 >= var7.field0177) {
            var6.remove();
         } else {
            var7.field0757 -= var5 * var4;
            var7.field0565 = var7.field0565 + var7.field0956 * var4;
            var7.field0002 = var7.field0002 + var7.field0757 * var4;
            var7.field1409 = var7.field1409 + var7.field1241 * var4;
            double var8 = Math.pow(0.3500000596053877, var4);
            var7.field0956 *= var8;
            var7.field1241 *= var8;
         }
      }

      if (!this.field1353.isEmpty()) {
         class_4184 var17 = field0796.field_1773.method_19418();
         class_243 var18 = var17.method_19326();
         int var9 = var3.getAlpha();
         RenderSystem.setShader(class_10142.field_53880);
         RenderSystem.setShaderTexture(0, field1044);
         RenderSystem.enableBlend();
         RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE);
         RenderSystem.disableCull();
         if (this.field1093.method0492()) {
            RenderSystem.disableDepthTest();
         } else {
            RenderSystem.enableDepthTest();
         }

         RenderSystem.depthMask(false);
         class_287 var10 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1575);

         for (TargetESP.RenderShape var12 : this.field1353) {
            float var13 = 1.0F - var12.field0314 / var12.field0177;
            int var14 = this.method0965(var3, (int)(var9 * var13));
            float var15 = var12.field0458 * (0.55F + 0.45F * var13);
            var1.method_22903();
            var1.method_22904(var12.field0565 - var18.field_1352, var12.field0002 - var18.field_1351, var12.field1409 - var18.field_1350);
            var1.method_22907(var17.method_23767());
            Matrix4f var16 = var1.method_23760().method_23761();
            var10.method_22918(var16, -var15, var15, 0.0F).method_22913(0.0F, 1.0F).method_39415(var14);
            var10.method_22918(var16, var15, var15, 0.0F).method_22913(1.0F, 1.0F).method_39415(var14);
            var10.method_22918(var16, var15, -var15, 0.0F).method_22913(1.0F, 0.0F).method_39415(var14);
            var10.method_22918(var16, -var15, -var15, 0.0F).method_22913(0.0F, 0.0F).method_39415(var14);
            var1.method_22909();
         }

         class_286.method_43433(var10.method_60800());
         RenderSystem.depthMask(true);
         RenderSystem.enableDepthTest();
         RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA);
         RenderSystem.disableBlend();
         RenderSystem.enableCull();
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      }
   }

   private float method0461() {
      if (this.field1120 < 0L) {
         return 1.0F;
      } else {
         long var1 = System.currentTimeMillis() - this.field1120;
         if (var1 >= 240L) {
            this.field1120 = -1L;
            return 1.0F;
         } else {
            float var3 = (float)var1 / 240.0F;
            float var4 = var3 < 0.5F ? method2092(var3 * 2.0F) * 0.18F : (1.0F - method2092((var3 - 0.5F) * 2.0F)) * 0.18F;
            return 1.0F - var4;
         }
      }
   }

   private static float method0115(float var0) {
      float var1 = 1.70158F;
      float var2 = var1 + 1.0F;
      float var3 = var0 - 1.0F;
      return 1.0F + var2 * var3 * var3 * var3 + var1 * var3 * var3;
   }

   private void method1494(class_4587 var1, Color var2, int var3, float var4) {
      float var5 = this.field0272.method_17682();
      float var6 = this.field1144.method0492() * var4;
      int var7 = 7;
      int var8 = 80;
      this.method0457();
      Matrix4f var9 = var1.method_23760().method_23761();
      float[][] var10 = new float[][]{{0.06F, 0.18F}, {0.14F, 0.07F}, {0.26F, 0.03F}};
      float[][] var11 = new float[][]{{1.0F, 0.0F}, {-1.0F, 0.0F}, {0.0F, 1.0F}, {0.0F, -1.0F}};

      for (float[] var15 : var10) {
         float var16 = var15[0];
         float var17 = var15[1];

         for (float[] var21 : var11) {
            float var22 = var21[0] * var16;
            float var23 = var21[1] * var16;

            for (int var24 = 0; var24 < var7; var24++) {
               float var25 = var24 * 1.7F;
               float var26 = var24 * 2.3F;
               float var27 = var24 * 1.1F;
               float var28 = 1.0F + var24 * 0.3F;
               float var29 = 0.7F + var24 * 0.2F;
               float var30 = 1.2F + var24 * 0.25F;
               class_287 var31 = class_289.method_1348().method_60827(class_5596.field_29345, class_290.field_1576);

               for (int var32 = 0; var32 <= var8; var32 += 4) {
                  float var33 = (float)var32 / var8;
                  float var34 = this.field0289 * 0.5F;
                  float var35 = var6
                     * class_3532.method_15374(var34 * var28 + var33 * 6.0F + var25)
                     * (0.5F + 0.5F * class_3532.method_15362(var33 * 3.0F + var34 * 0.3F));
                  float var36 = var5 * 0.5F + var6 * 0.8F * class_3532.method_15374(var34 * var29 + var33 * 4.0F + var26);
                  float var37 = var6
                     * class_3532.method_15362(var34 * var30 + var33 * 5.0F + var27)
                     * (0.5F + 0.5F * class_3532.method_15374(var33 * 2.0F + var34 * 0.4F));
                  float var38 = class_3532.method_15374(var33 * (float) Math.PI);
                  var31.method_22918(var9, (float)(this.field1670 + var35 + var22), (float)(this.field1656 + var36), (float)(this.field1687 + var37 + var23))
                     .method_39415(this.method0965(var2, (int)(var3 * var38 * var17)));
               }

               class_286.method_43433(var31.method_60800());
            }
         }
      }

      for (int var39 = 0; var39 < var7; var39++) {
         float var40 = var39 * 1.7F;
         float var41 = var39 * 2.3F;
         float var42 = var39 * 1.1F;
         float var43 = 1.0F + var39 * 0.3F;
         float var44 = 0.7F + var39 * 0.2F;
         float var45 = 1.2F + var39 * 0.25F;
         class_287 var46 = class_289.method_1348().method_60827(class_5596.field_29345, class_290.field_1576);

         for (int var47 = 0; var47 <= var8; var47++) {
            float var49 = (float)var47 / var8;
            float var51 = this.field0289 * 0.5F;
            float var53 = var6
               * class_3532.method_15374(var51 * var43 + var49 * 6.0F + var40)
               * (0.5F + 0.5F * class_3532.method_15362(var49 * 3.0F + var51 * 0.3F));
            float var55 = var5 * 0.5F + var6 * 0.8F * class_3532.method_15374(var51 * var44 + var49 * 4.0F + var41);
            float var57 = var6
               * class_3532.method_15362(var51 * var45 + var49 * 5.0F + var42)
               * (0.5F + 0.5F * class_3532.method_15374(var49 * 2.0F + var51 * 0.4F));
            float var59 = class_3532.method_15374(var49 * (float) Math.PI);
            int var61 = (int)(var3 * var59 * 0.85F);
            var46.method_22918(var9, (float)(this.field1670 + var53), (float)(this.field1656 + var55), (float)(this.field1687 + var57))
               .method_39415(this.method0965(var2, var61));
         }

         class_286.method_43433(var46.method_60800());
         class_287 var48 = class_289.method_1348().method_60827(class_5596.field_29345, class_290.field_1576);

         for (int var50 = 0; var50 <= var8; var50 += 2) {
            float var52 = (float)var50 / var8;
            float var54 = this.field0289 * 0.5F;
            float var56 = var6
               * class_3532.method_15374(var54 * var43 + var52 * 6.0F + var40)
               * (0.5F + 0.5F * class_3532.method_15362(var52 * 3.0F + var54 * 0.3F));
            float var58 = var5 * 0.5F + var6 * 0.8F * class_3532.method_15374(var54 * var44 + var52 * 4.0F + var41);
            float var60 = var6
               * class_3532.method_15362(var54 * var45 + var52 * 5.0F + var42)
               * (0.5F + 0.5F * class_3532.method_15374(var52 * 2.0F + var54 * 0.4F));
            float var62 = class_3532.method_15374(var52 * (float) Math.PI);
            var48.method_22918(
                  var9, (float)(this.field1670 + var56 + 0.020000007F), (float)(this.field1656 + var58 + 0.020000007F), (float)(this.field1687 + var60)
               )
               .method_39415(this.method0965(var2, (int)(var3 * var62 * 0.2F)));
         }

         class_286.method_43433(var48.method_60800());
      }

      this.method0479();
   }

   private void method1454(class_4587 var1, float var2) {
      if (this.field0272 != null) {
         if (this.field1323.isEmpty() || this.field0272 != this.field1366) {
            this.field1366 = this.field0272;
            this.field1323.clear();
            class_243[] var3 = field1329[0];
            class_243[] var4 = field1401[0];

            for (int var5 = 0; var5 < var3.length; var5++) {
               this.field1323.add(new TargetESP.TargetAnimation(var3[var5], var4[var5]));
            }
         }

         RenderSystem.enableDepthTest();
         this.field1314 = (this.field1314 + 0.5F) % 360.0F;
         class_4184 var10 = field0796.field_1773.method_19418();
         var1.method_22903();
         var1.method_22904(this.field1670, this.field1656, this.field1687);
         var1.method_22907(class_7833.field_40716.rotationDegrees(this.field1314));
         Color var11 = this.field1550.method1726();
         int var12 = this.method0965(var11, (int)(var11.getAlpha() * var2));
         TargetESP.ShapeType var6 = this.field1626.method0492();
         float var7 = this.field1144.method0492();

         for (TargetESP.TargetAnimation var9 : this.field1323) {
            var9.method1476(var1, var2, var12, var10, var6, var7);
         }

         var1.method_22909();
         RenderSystem.enableDepthTest();
      }
   }

   private void method0457() {
      RenderSystem.setShader(class_10142.field_53876);
      RenderSystem.enableBlend();
      RenderSystem.blendFuncSeparate(770, 1, 0, 1);
      RenderSystem.disableCull();
      if (this.field1093.method0492()) {
         RenderSystem.disableDepthTest();
      }

      RenderSystem.depthMask(false);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
   }

   private void method0479() {
      GL11.glDisable(2848);
      RenderSystem.enableDepthTest();
      RenderSystem.depthMask(true);
      RenderSystem.disableBlend();
      RenderSystem.blendFunc(770, 771);
      RenderSystem.enableCull();
   }

   private int method0965(Color var1, int var2) {
      return new Color(var1.getRed(), var1.getGreen(), var1.getBlue(), Math.max(0, Math.min(255, var2))).getRGB();
   }

   private static float method2092(float var0) {
      return var0 < 0.5F ? 4.0F * var0 * var0 * var0 : 1.0F - (float)Math.pow(-2.0F * var0 + 2.0F, 3.0) / 2.0F;
   }

   private void method1474(class_4587 var1, float var2, float var3, Color var4) {
      class_4184 var5 = field0796.field_1773.method_19418();
      float var6 = this.field1377.method0492();
      int var7 = this.field0393.method0492().intValue();
      boolean var8 = true;
      float var9 = class_3532.method_16439(var3, this.field1601, this.field1577) * var6;
      float var10 = this.field0272.method_17682() * 0.5F;
      float var11 = this.field0272.method_17681();
      float var12 = Math.max(0.4F, var11) * this.field1341.method0492();
      float var13 = 1.0F - var2;
      float var14 = var13 * var13 * (3.0F - 2.0F * var13);
      float var15 = var12 + var14 * 0.4F;
      RenderSystem.disableCull();
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE);
      if (this.field1093.method0492()) {
         RenderSystem.disableDepthTest();
      } else {
         RenderSystem.enableDepthTest();
      }

      RenderSystem.setShader(class_10142.field_53876);
      boolean var16 = this.field0918.method0492() == TargetESP.Mode.field0697;
      float var17 = this.field1302.method0492();
      var1.method_22903();
      var1.method_22904(this.field1670, this.field1656 + var10 + 0.25, this.field1687);
      if (var16) {
         var1.method_22907(var5.method_23767());
      }

      class_287 var18 = class_289.method_1348().method_60827(class_5596.field_27379, class_290.field_1576);

      for (int var19 = 0; var19 < var7; var19++) {
         float var20 = var9 + var19 * (360.0F / var7);
         this.method1510(var1, var18, var20, 0.0F, var15, var2, var19, var9, var4, var16, var17);
      }

      class_286.method_43433(var18.method_60800());
      if (var8) {
         RenderSystem.setShaderTexture(0, field1522);
         RenderSystem.setShader(class_10142.field_53880);
         class_287 var22 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1575);

         for (int var23 = 0; var23 < var7; var23++) {
            float var21 = var9 + var23 * (360.0F / var7);
            this.method1511(var1, var22, var5, var21, 0.0F, var15, var2, var23, var9, var4, var16, var17);
         }

         class_286.method_43433(var22.method_60800());
      }

      var1.method_22909();
      RenderSystem.enableCull();
      RenderSystem.enableDepthTest();
      RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private float method0715(int var1) {
      if (var1 == this.field1740 && this.field1755 >= 0L) {
         long var2 = System.currentTimeMillis() - this.field1755;
         if (var2 >= 240L) {
            this.field1755 = -1L;
            this.field1740 = -1;
            return 1.0F;
         } else {
            float var4 = (float)var2 / 240.0F;
            float var5 = var4 < 0.5F ? method2092(var4 * 2.0F) * 0.65F : (1.0F - method2092((var4 - 0.5F) * 2.0F)) * 0.65F;
            return 1.0F - var5;
         }
      } else {
         return 1.0F;
      }
   }

   private void method1510(
      class_4587 var1, class_287 var2, float var3, float var4, float var5, float var6, int var7, float var8, Color var9, boolean var10, float var11
   ) {
      float var12 = (float)Math.toRadians(var3);
      float var13 = this.method0715(var7);
      float var14 = class_3532.method_15362(var12) * var5 * var13;
      float var15 = class_3532.method_15374(var12) * var5 * var13;
      int var16 = var7 % 6;
      float var17 = (float)Math.toRadians(var8 * field0378[var16]) + field0374[var16];
      float var18 = (float)Math.toRadians(var8 * field0452[var16]) + field0447[var16];
      float var19 = (float)Math.toRadians(var8 * field0283[var16]) + field0278[var16];
      float var20 = class_3532.method_15374(var17) * field0383[var16];
      float var21 = class_3532.method_15374(var18) * field0456[var16];
      float var22 = class_3532.method_15374(var19) * field0288[var16];
      var1.method_22903();
      if (var10) {
         var1.method_46416(var14, var4 + var15, var22);
         var1.method_22907(class_7833.field_40718.rotationDegrees(var3 - 90.0F));
         var1.method_22907(class_7833.field_40714.rotationDegrees(-90.0F));
         var1.method_22907(class_7833.field_40716.rotationDegrees(var20));
         var1.method_22907(class_7833.field_40714.rotationDegrees(var21));
      } else {
         var1.method_46416(var14, var4 + var22, var15);
         var1.method_22907(class_7833.field_40716.rotationDegrees(-var3 - 90.0F));
         var1.method_22907(class_7833.field_40714.rotationDegrees(var20));
         var1.method_22907(class_7833.field_40718.rotationDegrees(var21));
      }

      var1.method_22905(var11, var11, var11);
      Matrix4f var23 = var1.method_23760().method_23761();
      int var24 = this.method0965(var9, (int)(var6 * 255.0F));
      int var25 = this.method0965(var9, (int)(var6 * 240.0F));
      int var26 = this.method0965(var9, (int)(var6 * 200.0F));
      float var27 = -0.25F;
      float var28 = -0.5F;
      float var29 = 0.2F;
      float var30 = -0.06F;
      float var31 = 0.5F;
      float var32 = 0.2F;
      float var33 = 0.06F;
      var2.method_22918(var23, 0.0F, 0.0F, var27).method_39415(var24);
      var2.method_22918(var23, var30, 0.0F, 0.0F).method_39415(var25);
      var2.method_22918(var23, var28, 0.0F, var29).method_39415(var26);
      var2.method_22918(var23, 0.0F, 0.0F, var27).method_39415(var24);
      var2.method_22918(var23, 0.0F, 0.0F, 0.0F).method_39415(var25);
      var2.method_22918(var23, var30, 0.0F, 0.0F).method_39415(var25);
      var2.method_22918(var23, 0.0F, 0.0F, var27).method_39415(var24);
      var2.method_22918(var23, var31, 0.0F, var32).method_39415(var26);
      var2.method_22918(var23, var33, 0.0F, 0.0F).method_39415(var25);
      var2.method_22918(var23, 0.0F, 0.0F, var27).method_39415(var24);
      var2.method_22918(var23, var33, 0.0F, 0.0F).method_39415(var25);
      var2.method_22918(var23, 0.0F, 0.0F, 0.0F).method_39415(var25);
      var1.method_22909();
   }

   private void method1511(
      class_4587 var1,
      class_287 var2,
      class_4184 var3,
      float var4,
      float var5,
      float var6,
      float var7,
      int var8,
      float var9,
      Color var10,
      boolean var11,
      float var12
   ) {
      float var13 = (float)Math.toRadians(var4);
      float var14 = this.method0715(var8);
      float var15 = class_3532.method_15362(var13) * var6 * var14;
      float var16 = class_3532.method_15374(var13) * var6 * var14;
      int var17 = var8 % 6;
      float var18 = (float)Math.toRadians(var9 * field0378[var17]) + field0374[var17];
      float var19 = (float)Math.toRadians(var9 * field0452[var17]) + field0447[var17];
      float var20 = (float)Math.toRadians(var9 * field0283[var17]) + field0278[var17];
      float var21 = class_3532.method_15374(var18) * field0383[var17];
      float var22 = class_3532.method_15374(var19) * field0456[var17];
      float var23 = class_3532.method_15374(var20) * field0288[var17];
      class_4587 var24 = new class_4587();
      if (var11) {
         var24.method_46416(var15, var5 + var16, var23);
         var24.method_22907(class_7833.field_40718.rotationDegrees(var4 - 90.0F));
         var24.method_22907(class_7833.field_40714.rotationDegrees(-90.0F));
         var24.method_22907(class_7833.field_40716.rotationDegrees(var21));
         var24.method_22907(class_7833.field_40714.rotationDegrees(var22));
      } else {
         var24.method_46416(var15, var5 + var23, var16);
         var24.method_22907(class_7833.field_40716.rotationDegrees(-var4 - 90.0F));
         var24.method_22907(class_7833.field_40714.rotationDegrees(var21));
         var24.method_22907(class_7833.field_40718.rotationDegrees(var22));
      }

      var24.method_22905(var12, var12, var12);
      Matrix4f var25 = new Matrix4f(var24.method_23760().method_23761());

      for (float[] var29 : field0250) {
         float var30 = var29[0];
         float var31 = var29[1];
         float var32 = var29[2];
         float var33 = var29[3];
         float var34 = var29[4];
         Vector4f var35 = new Vector4f(var30, var31, var32, 1.0F);
         var25.transform(var35);
         int var36 = this.method0965(var10, (int)(var7 * 22.0F * var34));
         var1.method_22903();
         var1.method_46416(var35.x, var35.y, var35.z);
         if (!var11) {
            var1.method_22907(var3.method_23767());
         }

         Matrix4f var37 = var1.method_23760().method_23761();
         var2.method_22918(var37, -var33, var33, 0.0F).method_22913(0.0F, 1.0F).method_39415(var36);
         var2.method_22918(var37, var33, var33, 0.0F).method_22913(1.0F, 1.0F).method_39415(var36);
         var2.method_22918(var37, var33, -var33, 0.0F).method_22913(1.0F, 0.0F).method_39415(var36);
         var2.method_22918(var37, -var33, -var33, 0.0F).method_22913(0.0F, 0.0F).method_39415(var36);
         var1.method_22909();
      }
   }

   static {
      int var0 = 12;
      int var1 = 3 + var0 * 2;
      field0250 = new float[var1][5];
      int var2 = 0;
      field0250[var2++] = new float[]{0.0F, 0.0F, -0.25F, 0.22F, 1.0F};

      for (int var3 = 1; var3 <= var0; var3++) {
         float var4 = (float)var3 / (var0 + 1);
         float var5 = -0.5F * var4;
         float var6 = class_3532.method_16439(var4, -0.25F, 0.2F);
         float var7 = class_3532.method_16439(var4, 0.18F, 0.14F);
         float var8 = class_3532.method_16439(var4, 0.9F, 0.7F);
         field0250[var2++] = new float[]{var5, 0.0F, var6, var7, var8};
      }

      field0250[var2++] = new float[]{-0.5F, 0.0F, 0.2F, 0.2F, 0.9F};

      for (int var11 = 1; var11 <= var0; var11++) {
         float var12 = (float)var11 / (var0 + 1);
         float var13 = 0.5F * var12;
         float var14 = class_3532.method_16439(var12, -0.25F, 0.2F);
         float var15 = class_3532.method_16439(var12, 0.18F, 0.14F);
         float var16 = class_3532.method_16439(var12, 0.9F, 0.7F);
         field0250[var2++] = new float[]{var13, 0.0F, var14, var15, var16};
      }

      field0250[var2] = new float[]{0.5F, 0.0F, 0.2F, 0.2F, 0.9F};
   }

   public enum AnimationMode implements DisplayNamed {
      field0697("Camera"),
      field0121("Horizontal");

      private final String field1504;

      AnimationMode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }

   private static class TargetState {
      double field0565;
      double field0002;
      double field1409;
      double field0956;
      double field0757;
      double field1241;
      float field0314;
      float field0177;
      float field0458;
      float field1614;
      float field1538;
      float field1704;
      float field1136;
      float field1087;
      float field1196;
      float field0871;
      float field0826;
      float field0910;
      float field1331;
   }

   private static class RenderPoint {
      class_1309 field0731;
      float field0003;
      double field1409;
      double field0956;
      double field0757;

      RenderPoint(class_1309 var1) {
         this.field0731 = var1;
         this.field0003 = 1.0F;
         this.field1409 = var1.method_23317();
         this.field0956 = var1.method_23318();
         this.field0757 = var1.method_23321();
      }
   }

   private static class RenderShape {
      double field0565;
      double field0002;
      double field1409;
      double field0956;
      double field0757;
      double field1241;
      float field0314;
      float field0177;
      float field0458;
   }

   public enum TextureStyle implements DisplayNamed {
      field0698("Target"),
      field0122("Glow"),
      field1491("Spark");

      private final String field1030;

      TextureStyle(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }

   private static class TargetAnimation {
      final class_243 field0735;
      final class_243 field0157;
      static final float field1410 = 0.05F;
      final float field0957;

      TargetAnimation(class_243 var1, class_243 var2) {
         this.field0735 = var1;
         this.field0157 = var2;
         this.field0957 = 0.5F + (float)(Math.random() * 1.5);
      }

      void method1476(class_4587 var1, float var2, int var3, class_4184 var4, TargetESP.ShapeType var5, float var6) {
         var1.method_22903();
         var1.method_22904(this.field0735.field_1352 * var6, this.field0735.field_1351, this.field0735.field_1350 * var6);
         float var7 = 1.0F + (float)(Math.sin(System.currentTimeMillis() / 500.0) * 0.1F);
         var1.method_22905(var7, var7, var7);
         float var8 = (float)(System.currentTimeMillis() % 36000L) / 100.0F * this.field0957;
         var1.method_22907(class_7833.field_40714.rotationDegrees((float)this.field0157.field_1352));
         var1.method_22907(class_7833.field_40716.rotationDegrees((float)this.field0157.field_1351 + var8));
         var1.method_22907(class_7833.field_40718.rotationDegrees((float)this.field0157.field_1350));
         RenderSystem.disableCull();
         RenderSystem.enableBlend();
         RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE);
         method1480(var1, var3, 0.2F, true, var2, var5);
         RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA);
         method1480(var1, var3, 0.3F, true, var2, var5);
         method1480(var1, var3, 0.8F, false, var2, var5);
         RenderSystem.depthMask(false);
         RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE);
         var1.method_22903();
         var1.method_22905(1.2F, 1.2F, 1.2F);
         method1480(var1, var3, 0.3F, true, var2, var5);
         var1.method_22909();
         this.method1479(var1, var3, var2, var4);
         RenderSystem.depthMask(true);
         RenderSystem.disableBlend();
         RenderSystem.enableCull();
         var1.method_22909();
      }

      private void method1479(class_4587 var1, int var2, float var3, class_4184 var4) {
         RenderSystem.setShader(class_10142.field_53880);
         RenderSystem.setShaderTexture(0, TargetESP.field1522);
         RenderSystem.enableBlend();
         RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE);
         RenderSystem.depthMask(false);
         int var5 = var2 & 16777215 | Math.min(255, (int)(10.0F * var3)) << 24;
         float var6 = 0.65000004F;

         for (int var7 = 0; var7 < 6; var7++) {
            var1.method_22903();
            var1.method_22907(class_7833.field_40716.rotationDegrees(60.0F * var7));
            var1.method_22907(class_7833.field_40716.rotationDegrees(-var4.method_19330()));
            var1.method_22907(class_7833.field_40714.rotationDegrees(var4.method_19329()));
            Matrix4f var8 = var1.method_23760().method_23761();
            class_287 var9 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1575);
            var9.method_22918(var8, -var6 / 2.0F, -var6 / 2.0F, 0.0F).method_22913(0.0F, 1.0F).method_39415(var5);
            var9.method_22918(var8, var6 / 2.0F, -var6 / 2.0F, 0.0F).method_22913(1.0F, 1.0F).method_39415(var5);
            var9.method_22918(var8, var6 / 2.0F, var6 / 2.0F, 0.0F).method_22913(1.0F, 0.0F).method_39415(var5);
            var9.method_22918(var8, -var6 / 2.0F, var6 / 2.0F, 0.0F).method_22913(0.0F, 0.0F).method_39415(var5);
            class_286.method_43433(var9.method_60800());
            var1.method_22909();
         }

         RenderSystem.depthMask(true);
         RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA);
      }

      private static void method1480(class_4587 var0, int var1, float var2, boolean var3, float var4, TargetESP.ShapeType var5) {
         RenderSystem.setShader(class_10142.field_53876);
         int var6 = var1 & 16777215 | Math.min(255, (int)(var2 * 255.0F * var4)) << 24;
         Matrix4f var7 = var0.method_23760().method_23761();
         switch (var5) {
            case field0700:
               method0344(var7, var6, var3);
               break;
            case field0124:
               method2177(var7, var6, var3);
               break;
            case field1493:
               method1875(var7, var6, var3);
               break;
            case field1020:
               method1675(var7, var6, var3);
         }
      }

      private static void method1561(Matrix4f var0, int var1, boolean var2) {
         float var3 = 0.05F;
         int var4 = 8;
         List var5 = new ArrayList<>();
         List var6 = new ArrayList<>();

         for (int var7 = 0; var7 < var4; var7++) {
            float var8 = (float)(6.283187810787048 * var7 / var4);
            var5.add(new class_243(var3 * Math.cos(var8), var3 / 2.0F, var3 * Math.sin(var8)));
            var6.add(new class_243(var3 * Math.cos(var8), -var3 / 2.0F, var3 * Math.sin(var8)));
         }

         class_243 var9 = new class_243(0.0, var3 * 2.0F, 0.0);
         class_243 var10 = new class_243(0.0, -var3 * 2.0F, 0.0);
         method1562(var0, var1, var2, var5, var6, var9, var10, var4);
      }

      private static void method0344(Matrix4f var0, int var1, boolean var2) {
         float var3 = 0.075F;
         class_243 var4 = new class_243(0.0, var3, 0.0);
         class_243 var5 = new class_243(0.0, -var3, 0.0);
         class_243 var6 = new class_243(var3, 0.0, 0.0);
         class_243 var7 = new class_243(-var3, 0.0, 0.0);
         class_243 var8 = new class_243(0.0, 0.0, var3);
         class_243 var9 = new class_243(0.0, 0.0, -var3);
         class_287 var10 = method1569(var2);
         if (var2) {
            method1388(var10, var0, var4, var6, var8, var1);
            method1388(var10, var0, var4, var8, var7, var1);
            method1388(var10, var0, var4, var7, var9, var1);
            method1388(var10, var0, var4, var9, var6, var1);
            method1388(var10, var0, var5, var8, var6, var1);
            method1388(var10, var0, var5, var7, var8, var1);
            method1388(var10, var0, var5, var9, var7, var1);
            method1388(var10, var0, var5, var6, var9, var1);
         } else {
            method1387(var10, var0, var4, var6, var1);
            method1387(var10, var0, var4, var7, var1);
            method1387(var10, var0, var4, var8, var1);
            method1387(var10, var0, var4, var9, var1);
            method1387(var10, var0, var5, var6, var1);
            method1387(var10, var0, var5, var7, var1);
            method1387(var10, var0, var5, var8, var1);
            method1387(var10, var0, var5, var9, var1);
            method1387(var10, var0, var6, var8, var1);
            method1387(var10, var0, var8, var7, var1);
            method1387(var10, var0, var7, var9, var1);
            method1387(var10, var0, var9, var6, var1);
         }

         class_286.method_43433(var10.method_60800());
      }

      private static void method2177(Matrix4f var0, int var1, boolean var2) {
         float var3 = 0.05F;
         class_243[] var4 = new class_243[]{
            new class_243(-var3, -var3, -var3),
            new class_243(var3, -var3, -var3),
            new class_243(var3, var3, -var3),
            new class_243(-var3, var3, -var3),
            new class_243(-var3, -var3, var3),
            new class_243(var3, -var3, var3),
            new class_243(var3, var3, var3),
            new class_243(-var3, var3, var3)
         };
         int[][] var5 = new int[][]{{0, 1, 2, 3}, {5, 4, 7, 6}, {1, 5, 6, 2}, {4, 0, 3, 7}, {3, 2, 6, 7}, {4, 5, 1, 0}};
         class_287 var6 = method1569(var2);
         if (var2) {
            for (int[] var10 : var5) {
               method1388(var6, var0, var4[var10[0]], var4[var10[1]], var4[var10[2]], var1);
               method1388(var6, var0, var4[var10[0]], var4[var10[2]], var4[var10[3]], var1);
            }
         } else {
            int[][] var12 = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}, {4, 5}, {5, 6}, {6, 7}, {7, 4}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};

            for (int[] var11 : var12) {
               method1387(var6, var0, var4[var11[0]], var4[var11[1]], var1);
            }
         }

         class_286.method_43433(var6.method_60800());
      }

      private static void method1875(Matrix4f var0, int var1, boolean var2) {
         float var3 = 0.060000002F;
         float var4 = (1.0F + (float)Math.sqrt(5.0)) / 2.0F;
         float var5 = var3;
         float var6 = var3 * var4;
         class_243[] var7 = new class_243[]{
            new class_243(-var5, var6, 0.0),
            new class_243(var5, var6, 0.0),
            new class_243(-var5, -var6, 0.0),
            new class_243(var5, -var6, 0.0),
            new class_243(0.0, -var5, var6),
            new class_243(0.0, var5, var6),
            new class_243(0.0, -var5, -var6),
            new class_243(0.0, var5, -var6),
            new class_243(var6, 0.0, -var5),
            new class_243(var6, 0.0, var5),
            new class_243(-var6, 0.0, -var5),
            new class_243(-var6, 0.0, var5)
         };
         int[][] var8 = new int[][]{
            {0, 11, 5},
            {0, 5, 1},
            {0, 1, 7},
            {0, 7, 10},
            {0, 10, 11},
            {1, 5, 9},
            {5, 11, 4},
            {11, 10, 2},
            {10, 7, 6},
            {7, 1, 8},
            {3, 9, 4},
            {3, 4, 2},
            {3, 2, 6},
            {3, 6, 8},
            {3, 8, 9},
            {4, 9, 5},
            {2, 4, 11},
            {6, 2, 10},
            {8, 6, 7},
            {9, 8, 1}
         };
         class_287 var9 = method1569(var2);
         if (var2) {
            for (int[] var13 : var8) {
               method1388(var9, var0, var7[var13[0]], var7[var13[1]], var7[var13[2]], var1);
            }
         } else {
            Set var20 = new HashSet<>();

            for (int[] var14 : var8) {
               for (int var15 = 0; var15 < 3; var15++) {
                  int var16 = Math.min(var14[var15], var14[(var15 + 1) % 3]);
                  int var17 = Math.max(var14[var15], var14[(var15 + 1) % 3]);
                  long var18 = (long)var16 << 32 | var17;
                  if (var20.add(var18)) {
                     method1387(var9, var0, var7[var16], var7[var17], var1);
                  }
               }
            }
         }

         class_286.method_43433(var9.method_60800());
      }

      private static void method1675(Matrix4f var0, int var1, boolean var2) {
         float var3 = 0.05F;
         float var4 = 0.125F;
         class_243[] var5 = new class_243[]{
            new class_243(var4, 0.0, 0.0),
            new class_243(-var4, 0.0, 0.0),
            new class_243(0.0, var4, 0.0),
            new class_243(0.0, -var4, 0.0),
            new class_243(0.0, 0.0, var4),
            new class_243(0.0, 0.0, -var4)
         };
         class_243[] var6 = new class_243[]{
            new class_243(var3, var3, var3),
            new class_243(var3, var3, -var3),
            new class_243(var3, -var3, var3),
            new class_243(var3, -var3, -var3),
            new class_243(-var3, var3, var3),
            new class_243(-var3, var3, -var3),
            new class_243(-var3, -var3, var3),
            new class_243(-var3, -var3, -var3)
         };
         int[][] var7 = new int[][]{
            {0, 0, 1},
            {0, 1, 3},
            {0, 3, 2},
            {0, 2, 0},
            {1, 4, 5},
            {1, 5, 7},
            {1, 7, 6},
            {1, 6, 4},
            {2, 0, 1},
            {2, 1, 5},
            {2, 5, 4},
            {2, 4, 0},
            {3, 2, 3},
            {3, 3, 7},
            {3, 7, 6},
            {3, 6, 2},
            {4, 0, 2},
            {4, 2, 6},
            {4, 6, 4},
            {4, 4, 0},
            {5, 1, 3},
            {5, 3, 7},
            {5, 7, 5},
            {5, 5, 1}
         };
         class_287 var8 = method1569(var2);
         if (var2) {
            for (int[] var12 : var7) {
               method1388(var8, var0, var5[var12[0]], var6[var12[1]], var6[var12[2]], var1);
            }
         } else {
            for (class_243 var22 : var5) {
               for (class_243 var16 : var6) {
                  double var17 = var22.method_1022(var16);
                  if (var17 < var4 * 1.5) {
                     method1387(var8, var0, var22, var16, var1);
                  }
               }
            }
         }

         class_286.method_43433(var8.method_60800());
      }

      private static void method1562(
         Matrix4f var0, int var1, boolean var2, List<class_243> var3, List<class_243> var4, class_243 var5, class_243 var6, int var7
      ) {
         class_287 var8 = method1569(var2);
         if (var2) {
            for (int var9 = 0; var9 < var7; var9++) {
               int var10 = (var9 + 1) % var7;
               method1388(var8, var0, var4.get(var9), var4.get(var10), var3.get(var10), var1);
               method1388(var8, var0, var4.get(var9), var3.get(var10), var3.get(var9), var1);
               method1388(var8, var0, var5, var3.get(var9), var3.get(var10), var1);
               method1388(var8, var0, var6, var4.get(var10), var4.get(var9), var1);
            }
         } else {
            for (int var11 = 0; var11 < var7; var11++) {
               int var12 = (var11 + 1) % var7;
               method1387(var8, var0, var3.get(var11), var3.get(var12), var1);
               method1387(var8, var0, var4.get(var11), var4.get(var12), var1);
               method1387(var8, var0, var3.get(var11), var4.get(var11), var1);
               method1387(var8, var0, var5, var3.get(var11), var1);
               method1387(var8, var0, var6, var4.get(var11), var1);
            }
         }

         class_286.method_43433(var8.method_60800());
      }

      private static class_287 method1569(boolean var0) {
         return class_289.method_1348().method_60827(var0 ? class_5596.field_27379 : class_5596.field_29344, class_290.field_1576);
      }

      private static void method1388(class_287 var0, Matrix4f var1, class_243 var2, class_243 var3, class_243 var4, int var5) {
         var0.method_22918(var1, (float)var2.field_1352, (float)var2.field_1351, (float)var2.field_1350).method_39415(var5);
         var0.method_22918(var1, (float)var3.field_1352, (float)var3.field_1351, (float)var3.field_1350).method_39415(var5);
         var0.method_22918(var1, (float)var4.field_1352, (float)var4.field_1351, (float)var4.field_1350).method_39415(var5);
      }

      private static void method1387(class_287 var0, Matrix4f var1, class_243 var2, class_243 var3, int var4) {
         var0.method_22918(var1, (float)var2.field_1352, (float)var2.field_1351, (float)var2.field_1350).method_39415(var4);
         var0.method_22918(var1, (float)var3.field_1352, (float)var3.field_1351, (float)var3.field_1350).method_39415(var4);
      }
   }

   public enum Mode implements DisplayNamed {
      field0699("Orbit"),
      field0123("Particles"),
      field1492("Shapes"),
      field1019("Blades"),
      field0783("Circle"),
      field1266("Cube");

      private final String field0336;

      Mode(String var3) {
         this.field0336 = var3;
      }

      @Override
      public String method0557() {
         return this.field0336;
      }
   }

   public enum ShapeType implements DisplayNamed {
      field0700("Octahedron"),
      field0124("Cube"),
      field1493("Icosahedron"),
      field1020("Star");

      private final String field0791;

      ShapeType(String var3) {
         this.field0791 = var3;
      }

      @Override
      public String method0557() {
         return this.field0791;
      }
   }
}
