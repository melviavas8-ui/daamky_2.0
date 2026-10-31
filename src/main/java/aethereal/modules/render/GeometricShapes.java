package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10142;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_2338.class_2339;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

public class GeometricShapes extends Module {
   private final MultiSelectSetting field0089 = new MultiSelectSetting(
         "geometricshapes.shapetype",
         Arrays.asList("Cube", "Pyramid", "Octahedron", "Tetrahedron", "Star", "Snowflake", "Icosahedron", "Dodecahedron", "Torus")
      )
      .method1007("Shape Type")
      .method0210("Types of shapes to render")
      .method2130("Типы фигур");
   private final FloatSetting field1450 = new FloatSetting("geometricshapes.amount", 79.0F, 5.0F, 700.0F, 1.0F)
      .method1007("Amount")
      .method0210("Number of shapes to spawn")
      .method2130("Количество фигур");
   private final FloatSetting field0985 = new FloatSetting("geometricshapes.size", 0.05F, 0.05F, 0.25F, 0.01F)
      .method1007("Size")
      .method0210("Size of each shape")
      .method2130("Размер");
   private final FloatSetting field0190 = new FloatSetting("geometricshapes.spawnradius", 7.0F, 3.0F, 50.0F, 1.0F)
      .method1007("Spawn Radius")
      .method0210("Radius around player to spawn shapes")
      .method2130("Радиус вокруг игрока");
   private final BooleanSetting field0464 = new BooleanSetting("geometricshapes.filled", false)
      .method1007("Filled")
      .method0210("Render shapes with filled faces")
      .method2130("Отрисовка фигур с заполненными гранями");
   private final ColorSetting field1623 = new ColorSetting("geometricshapes.color", 255, 99, 204, 113)
      .method1882()
      .method1007("Color")
      .method0210("Shape color")
      .method2130("Цвет фигур");
   private final BooleanSetting field1544 = new BooleanSetting("geometricshapes.glow", false)
      .method1007("Glow")
      .method0210("Render a soft glow halo behind each shape")
      .method2130("Рисовать свечение");
   private static final class_2960 field1733 = DaamkyClient.method1012("textures/glow.png");
   private static final float field1136 = 4.0F;
   private static final float field1087 = 0.06F;
   private static final float field1196 = 20.0F;
   private static final float field0871 = 0.05F;
   private final List<GeometricShapes.ShapeInstance> field0843 = new ArrayList<>();
   private final Random field0929 = new Random();
   private int field1332 = 0;
   private class_243 field1311 = class_243.field_1353;
   private final List<GeometricShapes.ColoredLine> field1384 = new ArrayList<>();
   private final List<GeometricShapes.ShapeMesh> field0400 = new ArrayList<>();
   private final double[] field0370 = new double[3];

   public GeometricShapes() {
      super("GeometricShapes", ModuleCategory.field1004, "Renders geometric shape effects");
      this.method1013("Рисует эффекты геометрических фигур");
      this.field0089.method0439("Pyramid").method0206(false);
      this.field0089.method0439("Octahedron").method0206(false);
      this.field0089.method0439("Tetrahedron").method0206(false);
      this.field0089.method0439("Star").method0206(false);
      this.field0089.method0439("Torus").method0206(false);
   }

   @Override
   public void method0025() {
      super.method0025();
      if (!method1974()) {
         this.method1735();
      }
   }

   @Override
   public void method2078() {
      super.method2078();
      this.field0843.clear();
      this.field1384.clear();
      this.field0400.clear();
      this.field1311 = class_243.field_1353;
   }

   private void method1735() {
      int var1 = this.field1450.method0492().intValue();

      for (int var2 = 0; var2 < var1; var2++) {
         this.method1691();
      }
   }

   private void method1691() {
      if (!method1974()) {
         List var1 = this.field0089.method1889();
         if (!var1.isEmpty()) {
            BooleanSetting var2 = var1.get(this.field0929.nextInt(var1.size()));
            String var3 = var2.method1888() != null ? var2.method1888() : var2.method0423();
            GeometricShapes.ShapeType var4 = GeometricShapes.ShapeType.method1000(var3);
            class_243 var5 = field0796.field_1724.method_19538();
            double var6 = this.field0190.method0492().floatValue();
            double var8 = 20.0;
            double var10 = 0.059999976F;
            double var12 = this.field0929.nextDouble() * 3.141593782352789 * 2.0;
            double var14 = var6 * (0.5 + this.field0929.nextDouble() * 0.5);
            double var16 = var5.field_1352 + Math.cos(var12) * var14;
            double var18 = var5.field_1350 + Math.sin(var12) * var14;
            double var20 = var5.field_1351 + 2.0 + this.field0929.nextDouble() * var8;
            class_2338 var22 = class_2338.method_49637(var16, var20, var18);

            while (!field0796.field_1687.method_8320(var22).method_26215() && var20 < var5.field_1351 + 20.0) {
               var22 = class_2338.method_49637(var16, ++var20, var18);
            }

            class_243 var23 = new class_243(
               (this.field0929.nextDouble() - 0.5) * var10,
               (this.field0929.nextDouble() - 0.7000000447150796) * var10 * 0.30000014541235215,
               (this.field0929.nextDouble() - 0.5) * var10
            );
            double var24 = this.field0929.nextDouble() * 3.141593782352789 * 2.0;
            this.field0843.add(new GeometricShapes.ShapeInstance(var4, new class_243(var16, var20, var18), var23, var24));
         }
      }
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         Set var2 = this.method1752();
         this.method1090(var2);
         if (!var2.isEmpty()) {
            this.field1332++;
            class_243 var3 = field0796.field_1724.method_19538();
            double var4 = this.field0190.method0492().floatValue();
            double var6 = var4 * 1.8000000388027193 * (var4 * 1.8000000388027193);
            double var8 = var4 * 1.3000000019595366 * (var4 * 1.3000000019595366);
            double var10 = var4 * var4;
            int var12 = this.field1450.method0492().intValue();
            int var13 = 0;
            int var14 = this.field0843.size();

            for (int var15 = var14 - 1; var15 >= 0; var15--) {
               GeometricShapes.ShapeInstance var16 = this.field0843.get(var15);
               var16.method0578();
               double var17 = var16.field0795.method_1025(var3);
               if (var17 > var6) {
                  int var19 = this.field0843.size() - 1;
                  if (var15 != var19) {
                     this.field0843.set(var15, this.field0843.get(var19));
                  }

                  this.field0843.remove(var19);
               } else {
                  var16.field0169 = var17 > var8;
                  if (var16.field0566 <= 0.0F && var16.field0169) {
                     int var25 = this.field0843.size() - 1;
                     if (var15 != var25) {
                        this.field0843.set(var15, this.field0843.get(var25));
                     }

                     this.field0843.remove(var25);
                  } else if (var17 <= var10) {
                     var13++;
                  }
               }
            }

            if (var13 < var12) {
               int var20 = var12 - var13;
               int var22 = Math.min(50, var20);

               for (int var24 = 0; var24 < var22; var24++) {
                  this.method1691();
               }
            }

            if (this.field1311.method_1025(var3) > 100.0) {
               this.field1311 = var3;
               int var21 = Math.min(100, var12 / 4);

               for (int var23 = 0; var23 < var21; var23++) {
                  this.method1691();
               }
            }
         }
      }
   }

   @EventHandler
   public void onRenderWorld(GlowRenderEvent var1) {
      if (!method1974()) {
         this.method1090(this.method1752());
         float var2 = var1.method1603();
         class_243 var3 = field0796.field_1773.method_19418().method_19326();
         this.field1384.clear();
         this.field0400.clear();
         var1.method1808().method_22903();
         var1.method1808().method_23760().method_23761().identity();
         int var4 = this.field0843.size();
         float var5 = this.field0985.method0492();

         for (int var6 = 0; var6 < var4; var6++) {
            GeometricShapes.ShapeInstance var7 = this.field0843.get(var6);
            var7.method0840(var1, 0.0F, var5, var2, this.field1384, this.field0400);
         }

         var1.method1808().method_22909();
         this.method1079(this.field1384, this.field0400);
         if (this.field1544.method0492()) {
            this.method0665(var2);
         }
      }
   }

   private Set<GeometricShapes.ShapeType> method1752() {
      EnumSet var1 = EnumSet.noneOf(GeometricShapes.ShapeType.class);

      for (BooleanSetting var3 : this.field0089.method1889()) {
         String var4 = var3.method1888() != null ? var3.method1888() : var3.method0423();
         var1.add(GeometricShapes.ShapeType.method1000(var4));
      }

      return var1;
   }

   private void method1090(Set<GeometricShapes.ShapeType> var1) {
      if (!this.field0843.isEmpty()) {
         if (var1.isEmpty()) {
            this.field0843.clear();
         } else {
            this.field0843.removeIf(var1x -> !var1.contains(var1x.field0986));
         }
      }
   }

   private void method0665(float var1) {
      if (!this.field0843.isEmpty()) {
         class_243 var2 = field0796.field_1773.method_19418().method_19326();
         Color var3 = this.field1623.method1726();
         int var4 = var3.getRGB() & 16777215;
         int var5 = var3.getAlpha();
         float var6 = this.field0985.method0492() * 3.0F;
         Matrix4f var7 = new Matrix4f();
         RenderSystem.enableBlend();
         RenderSystem.blendFunc(770, 32772);
         RenderSystem.enableDepthTest();
         RenderSystem.depthMask(false);
         RenderSystem.disableCull();
         RenderSystem.setShaderTexture(0, field1733);
         RenderSystem.setShader(class_10142.field_53880);
         class_287 var8 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1575);
         boolean var9 = false;

         for (GeometricShapes.ShapeInstance var11 : this.field0843) {
            if (!(var11.field0566 <= 0.001F)) {
               class_243 var12 = var11.field1273.method_35590(var11.field0795, var1);
               float var13 = (float)(var12.field_1352 - var2.field_1352);
               float var14 = (float)(var12.field_1351 - var2.field_1351);
               float var15 = (float)(var12.field_1350 - var2.field_1350);
               double var16 = var12.field_1352 - var2.field_1352;
               double var18 = var12.field_1350 - var2.field_1350;
               double var20 = Math.sqrt(var16 * var16 + var18 * var18);
               float var22;
               float var23;
               if (var20 > 0.001000000009275471) {
                  var22 = (float)(-var18 / var20);
                  var23 = (float)(var16 / var20);
               } else {
                  var22 = 1.0F;
                  var23 = 0.0F;
               }

               int var24 = Math.max(0, Math.min(255, (int)(var5 * var11.field0566)));
               int var25 = var24 << 24 | var4;
               var8.method_22918(var7, var13 - var22 * var6, var14 - var6, var15 - var23 * var6).method_22913(0.0F, 0.0F).method_39415(var25);
               var8.method_22918(var7, var13 + var22 * var6, var14 - var6, var15 + var23 * var6).method_22913(1.0F, 0.0F).method_39415(var25);
               var8.method_22918(var7, var13 + var22 * var6, var14 + var6, var15 + var23 * var6).method_22913(1.0F, 1.0F).method_39415(var25);
               var8.method_22918(var7, var13 - var22 * var6, var14 + var6, var15 - var23 * var6).method_22913(0.0F, 1.0F).method_39415(var25);
               var9 = true;
            }
         }

         if (var9) {
            class_286.method_43433(var8.method_60800());
         }

         RenderSystem.setShaderTexture(0, 0);
         RenderSystem.enableCull();
         RenderSystem.depthMask(true);
         RenderSystem.disableBlend();
      }
   }

   private void method1079(List<GeometricShapes.ColoredLine> var1, List<GeometricShapes.ShapeMesh> var2) {
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(770, 32772);
      RenderSystem.enableDepthTest();
      RenderSystem.depthMask(false);
      if (!var1.isEmpty()) {
         class_287 var3 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_29344, class_290.field_1576);

         for (GeometricShapes.ColoredLine var5 : var1) {
            var3.method_22918(var5.matrix, var5.x1, var5.y1, var5.z1).method_39415(var5.color);
            var3.method_22918(var5.matrix, var5.x2, var5.y2, var5.z2).method_39415(var5.color);
         }

         RenderSystem.setShader(class_10142.field_53876);
         GL11.glHint(3154, 4354);
         GL11.glEnable(2848);
         class_286.method_43433(var3.method_60800());
         GL11.glDisable(2848);
      }

      if (!var2.isEmpty() && this.field0464.method0492()) {
         class_287 var6 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1576);

         for (GeometricShapes.ShapeMesh var8 : var2) {
            var6.method_22918(var8.matrix, var8.x1, var8.y1, var8.z1).method_39415(var8.color);
            var6.method_22918(var8.matrix, var8.x2, var8.y2, var8.z2).method_39415(var8.color);
            var6.method_22918(var8.matrix, var8.x3, var8.y3, var8.z3).method_39415(var8.color);
            var6.method_22918(var8.matrix, var8.x4, var8.y4, var8.z4).method_39415(var8.color);
         }

         RenderSystem.setShader(class_10142.field_53876);
         RenderSystem.disableCull();
         class_286.method_43433(var6.method_60800());
         RenderSystem.enableCull();
      }

      RenderSystem.depthMask(true);
      RenderSystem.disableBlend();
   }

   private record ColoredLine(Matrix4f matrix, float x1, float y1, float z1, float x2, float y2, float z2, int color) {
      public Matrix4f method0577() {
         return this.matrix;
      }

      public float method0002() {
         return this.x1;
      }

      public float method2047() {
         return this.y1;
      }

      public float method1762() {
         return this.z1;
      }

      public float method1603() {
         return this.x2;
      }

      public float method1946() {
         return this.y2;
      }

      public float method0413() {
         return this.z2;
      }

      public int method0356() {
         return this.color;
      }
   }

   private record ShapeMesh(
      Matrix4f matrix, float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4, int color
   ) {
      public Matrix4f method0577() {
         return this.matrix;
      }

      public float method0002() {
         return this.x1;
      }

      public float method2047() {
         return this.y1;
      }

      public float method1762() {
         return this.z1;
      }

      public float method1603() {
         return this.x2;
      }

      public float method1946() {
         return this.y2;
      }

      public float method0413() {
         return this.z2;
      }

      public float method0355() {
         return this.x3;
      }

      public float method0483() {
         return this.y3;
      }

      public float method2213() {
         return this.z3;
      }

      public float method2182() {
         return this.x4;
      }

      public float method2253() {
         return this.y4;
      }

      public float method1901() {
         return this.z4;
      }

      public int method1879() {
         return this.color;
      }
   }

   private class ShapeInstance {
      private final GeometricShapes.ShapeType field0986;
      private class_243 field0795;
      private class_243 field1273;
      private class_243 field0338;
      private double field0176;
      private double field0457;
      private double field1613;
      private double field1537;
      private double field1703;
      private double field1135;
      public float field0566;
      public boolean field0169;
      private double field1086;
      private double field1195;
      private double field0870;
      private double field0825;
      private double field0909;
      private double field1330;
      private double field1291 = Double.NaN;
      private double field1368 = Double.NaN;
      private double field0384 = Double.NaN;

      public ShapeInstance(GeometricShapes.ShapeType var2, class_243 var3, class_243 var4, double var5) {
         this.field0986 = var2;
         this.field0795 = var3;
         this.field1273 = var3;
         this.field0338 = var4;
         this.field0176 = var5;
         this.field0457 = var5;
         this.field1613 = GeometricShapes.this.field0929.nextDouble() * 3.141593439626053 * 2.0;
         this.field1537 = this.field1613;
         this.field1703 = GeometricShapes.this.field0929.nextDouble() * 3.141593439626053 * 2.0;
         this.field1135 = this.field1703;
         this.field0566 = 0.0F;
         this.field0169 = false;
      }

      public void method0578() {
         float var1 = 0.1F;
         if (this.field0169) {
            this.field0566 = Math.max(0.0F, this.field0566 - var1);
         } else {
            this.field0566 = Math.min(1.0F, this.field0566 + var1);
         }

         this.field1273 = this.field0795;
         this.field0457 = this.field0176;
         this.field1537 = this.field1613;
         this.field1135 = this.field1703;
         double var2 = 0.06F;
         if (GeometricShapes.this.field0929.nextInt(5) == 0) {
            class_243 var4 = new class_243(
               (GeometricShapes.this.field0929.nextDouble() - 0.5) * var2 * 0.20000004508207708,
               (GeometricShapes.this.field0929.nextDouble() - 0.5) * var2 * 0.15000007922541733,
               (GeometricShapes.this.field0929.nextDouble() - 0.5) * var2 * 0.20000004508207708
            );
            this.field0338 = this.field0338.method_1019(var4);
         }

         this.field0338 = this.field0338.method_18805(0.9849997920843107, 0.9849997920843107, 0.9849997920843107);
         class_238 var20 = MinecraftAccess.field0796.field_1724.method_5829().method_1014(0.5);
         class_238 var5 = new class_238(
            this.field0795.field_1352 - 0.20000004508207708,
            this.field0795.field_1351 - 0.20000004508207708,
            this.field0795.field_1350 - 0.20000004508207708,
            this.field0795.field_1352 + 0.20000004508207708,
            this.field0795.field_1351 + 0.20000004508207708,
            this.field0795.field_1350 + 0.20000004508207708
         );
         if (var20.method_994(var5)) {
            class_243 var6 = MinecraftAccess.field0796
               .field_1724
               .method_19538()
               .method_1031(0.0, MinecraftAccess.field0796.field_1724.method_17682() / 2.0F, 0.0);
            class_243 var7 = this.field0795.method_1020(var6).method_1029();
            double var8 = 0.15000007922541733;
            this.field0338 = this.field0338.method_1019(var7.method_1021(var8));
         }

         double var22 = GeometricShapes.this.field0985.method0492().floatValue() * 0.5;
         class_238 var23 = new class_238(
            this.field0795.field_1352 - var22,
            this.field0795.field_1351 - var22,
            this.field0795.field_1350 - var22,
            this.field0795.field_1352 + var22,
            this.field0795.field_1351 + var22,
            this.field0795.field_1350 + var22
         );
         class_243 var9 = this.field0338;
         class_238 var10 = var23.method_989(0.0, var9.field_1351, 0.0);
         class_2339 var11 = new class_2339();
         boolean var12 = false;

         for (int var13 = (int)Math.floor(var10.field_1323); var13 <= Math.floor(var10.field_1320); var13++) {
            for (int var14 = (int)Math.floor(var10.field_1322); var14 <= Math.floor(var10.field_1325); var14++) {
               for (int var15 = (int)Math.floor(var10.field_1321); var15 <= Math.floor(var10.field_1324); var15++) {
                  var11.method_10103(var13, var14, var15);
                  if (!MinecraftAccess.field0796.field_1687.method_8320(var11).method_26215()) {
                     var12 = true;
                     break;
                  }
               }

               if (var12) {
                  break;
               }
            }

            if (var12) {
               break;
            }
         }

         if (var12) {
            if (this.field0338.field_1351 < 0.0) {
               this.field0338 = new class_243(
                  this.field0338.field_1352 * 0.7000001065509516,
                  -this.field0338.field_1351 * 0.6000000039872756,
                  this.field0338.field_1350 * 0.7000001065509516
               );
            } else {
               this.field0338 = new class_243(this.field0338.field_1352, 0.0, this.field0338.field_1350);
            }

            var9 = new class_243(var9.field_1352, 0.0, var9.field_1350);
         }

         class_238 var24 = var23.method_989(var9.field_1352, var9.field_1351, 0.0);
         boolean var25 = false;

         for (int var26 = (int)Math.floor(var24.field_1323); var26 <= Math.floor(var24.field_1320); var26++) {
            for (int var16 = (int)Math.floor(var24.field_1322); var16 <= Math.floor(var24.field_1325); var16++) {
               for (int var17 = (int)Math.floor(var24.field_1321); var17 <= Math.floor(var24.field_1324); var17++) {
                  var11.method_10103(var26, var16, var17);
                  if (!MinecraftAccess.field0796.field_1687.method_8320(var11).method_26215()) {
                     var25 = true;
                     break;
                  }
               }

               if (var25) {
                  break;
               }
            }

            if (var25) {
               break;
            }
         }

         if (var25) {
            this.field0338 = new class_243(-this.field0338.field_1352 * 0.5, this.field0338.field_1351, this.field0338.field_1350);
            var9 = new class_243(0.0, var9.field_1351, var9.field_1350);
         }

         class_238 var27 = var23.method_989(var9.field_1352, var9.field_1351, var9.field_1350);
         boolean var28 = false;

         for (int var29 = (int)Math.floor(var27.field_1323); var29 <= Math.floor(var27.field_1320); var29++) {
            for (int var18 = (int)Math.floor(var27.field_1322); var18 <= Math.floor(var27.field_1325); var18++) {
               for (int var19 = (int)Math.floor(var27.field_1321); var19 <= Math.floor(var27.field_1324); var19++) {
                  var11.method_10103(var29, var18, var19);
                  if (!MinecraftAccess.field0796.field_1687.method_8320(var11).method_26215()) {
                     var28 = true;
                     break;
                  }
               }

               if (var28) {
                  break;
               }
            }

            if (var28) {
               break;
            }
         }

         if (var28) {
            this.field0338 = new class_243(this.field0338.field_1352, this.field0338.field_1351, -this.field0338.field_1350 * 0.5);
            var9 = new class_243(var9.field_1352, var9.field_1351, 0.0);
         }

         this.field0795 = this.field0795.method_1019(var9);
         double var21 = Math.toRadians(4.0) * 0.5;
         this.field0176 += var21;
         this.field1613 += var21 * 0.7000001065509516;
         this.field1703 += var21 * 0.5;
         if (this.field0176 >= 6.283187713717119) {
            this.field0176 -= 6.283187713717119;
         }

         if (this.field1613 >= 6.283187713717119) {
            this.field1613 -= 6.283187713717119;
         }

         if (this.field1703 >= 6.283187713717119) {
            this.field1703 -= 6.283187713717119;
         }
      }

      public void method0840(
         GlowRenderEvent var1, float var2, float var3, float var4, List<GeometricShapes.ColoredLine> var5, List<GeometricShapes.ShapeMesh> var6
      ) {
         if (!(this.field0566 <= 0.001F)) {
            class_243 var7 = this.field1273.method_35590(this.field0795, var4);
            double var8 = this.method0625(this.field0457, this.field0176, var4);
            double var10 = this.method0625(this.field1537, this.field1613, var4);
            double var12 = this.method0625(this.field1135, this.field1703, var4);
            class_243 var14 = MinecraftAccess.field0796.field_1773.method_19418().method_19326();
            Matrix4f var15 = var1.method1808().method_23760().method_23761();
            Color var16 = GeometricShapes.this.field1623.method1726();
            int var17 = Math.max(0, Math.min(255, (int)(var16.getAlpha() * this.field0566)));
            int var18 = (var17 & 0xFF) << 24 | var16.getRGB() & 16777215;
            switch (this.field0986) {
               case field0630:
                  this.method1342(var7, var14, var15, var18, var3, var8, var10, var12, var5, var6);
                  break;
               case field0063:
                  this.method0294(var7, var14, var15, var18, var3, var8, var10, var12, var5, var6);
                  break;
               case field1451:
                  this.method2164(var7, var14, var15, var18, var3, var8, var10, var12, var5, var6);
                  break;
               case field0986:
                  this.method1866(var7, var14, var15, var18, var3, var8, var10, var12, var5, var6);
                  break;
               case field0769:
                  this.method1669(var7, var14, var15, var18, var3, var8, var10, var12, var5, var6);
                  break;
               case field1254:
                  this.method1996(var7, var14, var15, var18, var3, var8, var10, var12, var5, var6);
                  break;
               case field0321:
                  this.method0447(var7, var14, var15, var18, var3, var8, var10, var12, var5, var6);
                  break;
               case field0192:
                  this.method0390(var7, var14, var15, var18, var3, var8, var10, var12, var5, var6);
                  break;
               case field0472:
                  this.method0509(var7, var14, var15, var18, var3, var8, var10, var12, var5, var6);
            }
         }
      }

      private double method0625(double var1, double var3, float var5) {
         double var6 = var3 - var1;
         if (var6 > 3.141593439626053) {
            var6 -= 6.283187713717119;
         } else if (var6 < -3.1415933127849662) {
            var6 += 6.283187713717119;
         }

         return var1 + var6 * var5;
      }

      private void method1342(
         class_243 var1,
         class_243 var2,
         Matrix4f var3,
         int var4,
         float var5,
         double var6,
         double var8,
         double var10,
         List<GeometricShapes.ColoredLine> var12,
         List<GeometricShapes.ShapeMesh> var13
      ) {
         float var14 = (float)(var1.field_1352 - var2.field_1352);
         float var15 = (float)(var1.field_1351 - var2.field_1351);
         float var16 = (float)(var1.field_1350 - var2.field_1350);
         class_243[] var17 = new class_243[]{
            this.method1305(new class_243(-var5, -var5, -var5), var6, var8, var10),
            this.method1305(new class_243(var5, -var5, -var5), var6, var8, var10),
            this.method1305(new class_243(var5, var5, -var5), var6, var8, var10),
            this.method1305(new class_243(-var5, var5, -var5), var6, var8, var10),
            this.method1305(new class_243(-var5, -var5, var5), var6, var8, var10),
            this.method1305(new class_243(var5, -var5, var5), var6, var8, var10),
            this.method1305(new class_243(var5, var5, var5), var6, var8, var10),
            this.method1305(new class_243(-var5, var5, var5), var6, var8, var10)
         };
         if (GeometricShapes.this.field0464.method0492()) {
            int[][] var18 = new int[][]{{0, 1, 2, 3}, {4, 5, 6, 7}, {0, 1, 5, 4}, {2, 3, 7, 6}, {0, 3, 7, 4}, {1, 2, 6, 5}};

            for (int[] var22 : var18) {
               this.method2180(var17, var22, var14, var15, var16, var3, var4, var13);
            }
         }

         int[][] var23 = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}, {4, 5}, {5, 6}, {6, 7}, {7, 4}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};

         for (int[] var27 : var23) {
            this.method1598(var17, var27, var14, var15, var16, var3, var4, var12);
         }

         if (GeometricShapes.this.field0464.method0492()) {
            this.method1597(var17, var14, var15, var16, var3, var4, var12);
         }
      }

      private void method0294(
         class_243 var1,
         class_243 var2,
         Matrix4f var3,
         int var4,
         float var5,
         double var6,
         double var8,
         double var10,
         List<GeometricShapes.ColoredLine> var12,
         List<GeometricShapes.ShapeMesh> var13
      ) {
         float var14 = (float)(var1.field_1352 - var2.field_1352);
         float var15 = (float)(var1.field_1351 - var2.field_1351);
         float var16 = (float)(var1.field_1350 - var2.field_1350);
         class_243[] var17 = new class_243[]{
            this.method1305(new class_243(0.0, var5, 0.0), var6, var8, var10),
            this.method1305(new class_243(-var5, -var5, -var5), var6, var8, var10),
            this.method1305(new class_243(var5, -var5, -var5), var6, var8, var10),
            this.method1305(new class_243(var5, -var5, var5), var6, var8, var10),
            this.method1305(new class_243(-var5, -var5, var5), var6, var8, var10)
         };
         if (GeometricShapes.this.field0464.method0492()) {
            int[][] var18 = new int[][]{{0, 1, 2}, {0, 2, 3}, {0, 3, 4}, {0, 4, 1}, {1, 2, 3, 4}};

            for (int[] var22 : var18) {
               if (var22.length == 3) {
                  this.method0353(var17, var22, var14, var15, var16, var3, var4, var13);
               } else {
                  this.method2180(var17, var22, var14, var15, var16, var3, var4, var13);
               }
            }
         }

         int[][] var24 = new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 2}, {2, 3}, {3, 4}, {4, 1}};

         for (int[] var31 : var24) {
            this.method1598(var17, var31, var14, var15, var16, var3, var4, var12);
         }

         if (GeometricShapes.this.field0464.method0492()) {
            int[][] var26 = new int[][]{{0, 1, 2}, {0, 2, 3}, {0, 3, 4}, {0, 4, 1}};

            for (int[] var23 : var26) {
               this.method1877(var17, var23, var14, var15, var16, var3, var4, var12);
            }
         }
      }

      private void method2164(
         class_243 var1,
         class_243 var2,
         Matrix4f var3,
         int var4,
         float var5,
         double var6,
         double var8,
         double var10,
         List<GeometricShapes.ColoredLine> var12,
         List<GeometricShapes.ShapeMesh> var13
      ) {
         float var14 = (float)(var1.field_1352 - var2.field_1352);
         float var15 = (float)(var1.field_1351 - var2.field_1351);
         float var16 = (float)(var1.field_1350 - var2.field_1350);
         class_243[] var17 = new class_243[]{
            this.method1305(new class_243(0.0, var5, 0.0), var6, var8, var10),
            this.method1305(new class_243(var5, 0.0, 0.0), var6, var8, var10),
            this.method1305(new class_243(0.0, 0.0, var5), var6, var8, var10),
            this.method1305(new class_243(-var5, 0.0, 0.0), var6, var8, var10),
            this.method1305(new class_243(0.0, 0.0, -var5), var6, var8, var10),
            this.method1305(new class_243(0.0, -var5, 0.0), var6, var8, var10)
         };
         if (GeometricShapes.this.field0464.method0492()) {
            int[][] var18 = new int[][]{{0, 1, 2}, {0, 2, 3}, {0, 3, 4}, {0, 4, 1}, {5, 2, 1}, {5, 3, 2}, {5, 4, 3}, {5, 1, 4}};

            for (int[] var22 : var18) {
               this.method0353(var17, var22, var14, var15, var16, var3, var4, var13);
            }
         }

         int[][] var24 = new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}, {5, 1}, {5, 2}, {5, 3}, {5, 4}, {1, 2}, {2, 3}, {3, 4}, {4, 1}};

         for (int[] var31 : var24) {
            this.method1598(var17, var31, var14, var15, var16, var3, var4, var12);
         }

         if (GeometricShapes.this.field0464.method0492()) {
            int[][] var26 = new int[][]{{0, 1, 2}, {0, 2, 3}, {0, 3, 4}, {0, 4, 1}, {5, 2, 1}, {5, 3, 2}, {5, 4, 3}, {5, 1, 4}};

            for (int[] var23 : var26) {
               this.method1877(var17, var23, var14, var15, var16, var3, var4, var12);
            }
         }
      }

      private void method1866(
         class_243 var1,
         class_243 var2,
         Matrix4f var3,
         int var4,
         float var5,
         double var6,
         double var8,
         double var10,
         List<GeometricShapes.ColoredLine> var12,
         List<GeometricShapes.ShapeMesh> var13
      ) {
         float var14 = (float)(var1.field_1352 - var2.field_1352);
         float var15 = (float)(var1.field_1351 - var2.field_1351);
         float var16 = (float)(var1.field_1350 - var2.field_1350);
         class_243[] var17 = new class_243[]{
            this.method1305(new class_243(0.0, var5, 0.0), var6, var8, var10),
            this.method1305(new class_243(-var5, -var5, -var5), var6, var8, var10),
            this.method1305(new class_243(var5, -var5, -var5), var6, var8, var10),
            this.method1305(new class_243(0.0, -var5, var5), var6, var8, var10)
         };
         if (GeometricShapes.this.field0464.method0492()) {
            int[][] var18 = new int[][]{{0, 1, 2}, {0, 2, 3}, {0, 3, 1}, {1, 3, 2}};

            for (int[] var22 : var18) {
               this.method0353(var17, var22, var14, var15, var16, var3, var4, var13);
            }
         }

         int[][] var24 = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {3, 1}};

         for (int[] var31 : var24) {
            this.method1598(var17, var31, var14, var15, var16, var3, var4, var12);
         }

         if (GeometricShapes.this.field0464.method0492()) {
            int[][] var26 = new int[][]{{0, 1, 2}, {0, 2, 3}, {0, 3, 1}, {1, 3, 2}};

            for (int[] var23 : var26) {
               this.method1877(var17, var23, var14, var15, var16, var3, var4, var12);
            }
         }
      }

      private void method1598(
         class_243[] var1, int[] var2, float var3, float var4, float var5, Matrix4f var6, int var7, List<GeometricShapes.ColoredLine> var8
      ) {
         class_243 var9 = var1[var2[0]];
         class_243 var10 = var1[var2[1]];
         var8.add(
            new GeometricShapes.ColoredLine(
               var6,
               var3 + (float)var9.field_1352,
               var4 + (float)var9.field_1351,
               var5 + (float)var9.field_1350,
               var3 + (float)var10.field_1352,
               var4 + (float)var10.field_1351,
               var5 + (float)var10.field_1350,
               var7
            )
         );
      }

      private static int method0716(int var0) {
         int var1 = var0 >>> 24 & 0xFF;
         return var0 & 16777215 | var1 >> 1 << 24;
      }

      private void method0353(
         class_243[] var1, int[] var2, float var3, float var4, float var5, Matrix4f var6, int var7, List<GeometricShapes.ShapeMesh> var8
      ) {
         class_243 var9 = var1[var2[0]];
         class_243 var10 = var1[var2[1]];
         class_243 var11 = var1[var2[2]];
         int var12 = method0716(var7);
         var8.add(
            new GeometricShapes.ShapeMesh(
               var6,
               var3 + (float)var9.field_1352,
               var4 + (float)var9.field_1351,
               var5 + (float)var9.field_1350,
               var3 + (float)var10.field_1352,
               var4 + (float)var10.field_1351,
               var5 + (float)var10.field_1350,
               var3 + (float)var11.field_1352,
               var4 + (float)var11.field_1351,
               var5 + (float)var11.field_1350,
               var3 + (float)var11.field_1352,
               var4 + (float)var11.field_1351,
               var5 + (float)var11.field_1350,
               var12
            )
         );
         var8.add(
            new GeometricShapes.ShapeMesh(
               var6,
               var3 + (float)(var9.field_1352 * 0.5),
               var4 + (float)(var9.field_1351 * 0.5),
               var5 + (float)(var9.field_1350 * 0.5),
               var3 + (float)(var10.field_1352 * 0.5),
               var4 + (float)(var10.field_1351 * 0.5),
               var5 + (float)(var10.field_1350 * 0.5),
               var3 + (float)(var11.field_1352 * 0.5),
               var4 + (float)(var11.field_1351 * 0.5),
               var5 + (float)(var11.field_1350 * 0.5),
               var3 + (float)(var11.field_1352 * 0.5),
               var4 + (float)(var11.field_1351 * 0.5),
               var5 + (float)(var11.field_1350 * 0.5),
               var12
            )
         );
      }

      private void method2180(
         class_243[] var1, int[] var2, float var3, float var4, float var5, Matrix4f var6, int var7, List<GeometricShapes.ShapeMesh> var8
      ) {
         class_243 var9 = var1[var2[0]];
         class_243 var10 = var1[var2[1]];
         class_243 var11 = var1[var2[2]];
         class_243 var12 = var1[var2[3]];
         int var13 = method0716(var7);
         var8.add(
            new GeometricShapes.ShapeMesh(
               var6,
               var3 + (float)var9.field_1352,
               var4 + (float)var9.field_1351,
               var5 + (float)var9.field_1350,
               var3 + (float)var10.field_1352,
               var4 + (float)var10.field_1351,
               var5 + (float)var10.field_1350,
               var3 + (float)var11.field_1352,
               var4 + (float)var11.field_1351,
               var5 + (float)var11.field_1350,
               var3 + (float)var12.field_1352,
               var4 + (float)var12.field_1351,
               var5 + (float)var12.field_1350,
               var13
            )
         );
         var8.add(
            new GeometricShapes.ShapeMesh(
               var6,
               var3 + (float)(var9.field_1352 * 0.5),
               var4 + (float)(var9.field_1351 * 0.5),
               var5 + (float)(var9.field_1350 * 0.5),
               var3 + (float)(var10.field_1352 * 0.5),
               var4 + (float)(var10.field_1351 * 0.5),
               var5 + (float)(var10.field_1350 * 0.5),
               var3 + (float)(var11.field_1352 * 0.5),
               var4 + (float)(var11.field_1351 * 0.5),
               var5 + (float)(var11.field_1350 * 0.5),
               var3 + (float)(var12.field_1352 * 0.5),
               var4 + (float)(var12.field_1351 * 0.5),
               var5 + (float)(var12.field_1350 * 0.5),
               var13
            )
         );
      }

      private void method1597(class_243[] var1, float var2, float var3, float var4, Matrix4f var5, int var6, List<GeometricShapes.ColoredLine> var7) {
         int[][] var8 = new int[][]{{0, 1, 2, 3}, {4, 5, 6, 7}, {0, 1, 5, 4}, {2, 3, 7, 6}, {0, 3, 7, 4}, {1, 2, 6, 5}};

         for (int[] var12 : var8) {
            class_243 var13 = var1[var12[0]];
            class_243 var14 = var1[var12[1]];
            class_243 var15 = var1[var12[2]];
            class_243 var16 = var1[var12[3]];

            for (int var17 = 1; var17 < 3; var17++) {
               float var18 = var17 / 3.0F;
               class_243 var19 = var13.method_35590(var16, var18);
               class_243 var20 = var14.method_35590(var15, var18);
               var7.add(
                  new GeometricShapes.ColoredLine(
                     var5,
                     var2 + (float)var19.field_1352,
                     var3 + (float)var19.field_1351,
                     var4 + (float)var19.field_1350,
                     var2 + (float)var20.field_1352,
                     var3 + (float)var20.field_1351,
                     var4 + (float)var20.field_1350,
                     var6
                  )
               );
               class_243 var21 = var13.method_35590(var14, var18);
               class_243 var22 = var16.method_35590(var15, var18);
               var7.add(
                  new GeometricShapes.ColoredLine(
                     var5,
                     var2 + (float)var21.field_1352,
                     var3 + (float)var21.field_1351,
                     var4 + (float)var21.field_1350,
                     var2 + (float)var22.field_1352,
                     var3 + (float)var22.field_1351,
                     var4 + (float)var22.field_1350,
                     var6
                  )
               );
            }
         }
      }

      private void method1877(
         class_243[] var1, int[] var2, float var3, float var4, float var5, Matrix4f var6, int var7, List<GeometricShapes.ColoredLine> var8
      ) {
         class_243 var9 = var1[var2[0]];
         class_243 var10 = var1[var2[1]];
         class_243 var11 = var1[var2[2]];
         class_243 var12 = new class_243(
            (var9.field_1352 + var10.field_1352 + var11.field_1352) / 3.0,
            (var9.field_1351 + var10.field_1351 + var11.field_1351) / 3.0,
            (var9.field_1350 + var10.field_1350 + var11.field_1350) / 3.0
         );
         var8.add(
            new GeometricShapes.ColoredLine(
               var6,
               var3 + (float)var9.field_1352,
               var4 + (float)var9.field_1351,
               var5 + (float)var9.field_1350,
               var3 + (float)var12.field_1352,
               var4 + (float)var12.field_1351,
               var5 + (float)var12.field_1350,
               var7
            )
         );
         var8.add(
            new GeometricShapes.ColoredLine(
               var6,
               var3 + (float)var10.field_1352,
               var4 + (float)var10.field_1351,
               var5 + (float)var10.field_1350,
               var3 + (float)var12.field_1352,
               var4 + (float)var12.field_1351,
               var5 + (float)var12.field_1350,
               var7
            )
         );
         var8.add(
            new GeometricShapes.ColoredLine(
               var6,
               var3 + (float)var11.field_1352,
               var4 + (float)var11.field_1351,
               var5 + (float)var11.field_1350,
               var3 + (float)var12.field_1352,
               var4 + (float)var12.field_1351,
               var5 + (float)var12.field_1350,
               var7
            )
         );
      }

      private void method1669(
         class_243 var1,
         class_243 var2,
         Matrix4f var3,
         int var4,
         float var5,
         double var6,
         double var8,
         double var10,
         List<GeometricShapes.ColoredLine> var12,
         List<GeometricShapes.ShapeMesh> var13
      ) {
         float var14 = (float)(var1.field_1352 - var2.field_1352);
         float var15 = (float)(var1.field_1351 - var2.field_1351);
         float var16 = (float)(var1.field_1350 - var2.field_1350);
         class_243[] var17 = new class_243[12];
         int var18 = 5;
         float var19 = var5 * 1.2F;
         float var20 = var5 * 0.5F;

         for (int var21 = 0; var21 < var18; var21++) {
            double var22 = 6.283187713717119 * var21 / var18 - 1.57079665648706;
            var17[var21] = this.method1305(new class_243(Math.cos(var22) * var19, 0.0, Math.sin(var22) * var19), var6, var8, var10);
            double var24 = 6.283187713717119 * (var21 + 0.5) / var18 - 1.57079665648706;
            var17[var21 + var18] = this.method1305(new class_243(Math.cos(var24) * var20, 0.0, Math.sin(var24) * var20), var6, var8, var10);
         }

         var17[10] = this.method1305(new class_243(0.0, var5 * 0.6000000039872756, 0.0), var6, var8, var10);
         var17[11] = this.method1305(new class_243(0.0, -var5 * 0.6000000039872756, 0.0), var6, var8, var10);
         if (GeometricShapes.this.field0464.method0492()) {
            for (int var26 = 0; var26 < var18; var26++) {
               int var28 = (var26 + 1) % var18;
               this.method0353(var17, new int[]{var26, var26 + var18, 10}, var14, var15, var16, var3, var4, var13);
               this.method0353(var17, new int[]{var28, var26 + var18, 10}, var14, var15, var16, var3, var4, var13);
               this.method0353(var17, new int[]{var26, var26 + var18, 11}, var14, var15, var16, var3, var4, var13);
               this.method0353(var17, new int[]{var28, var26 + var18, 11}, var14, var15, var16, var3, var4, var13);
            }
         }

         for (int var27 = 0; var27 < var18; var27++) {
            int var29 = (var27 + 1) % var18;
            this.method1598(var17, new int[]{var27, var27 + var18}, var14, var15, var16, var3, var4, var12);
            this.method1598(var17, new int[]{var27 + var18, var29}, var14, var15, var16, var3, var4, var12);
            this.method1598(var17, new int[]{var27, 10}, var14, var15, var16, var3, var4, var12);
            this.method1598(var17, new int[]{var27, 11}, var14, var15, var16, var3, var4, var12);
         }
      }

      private void method1996(
         class_243 var1,
         class_243 var2,
         Matrix4f var3,
         int var4,
         float var5,
         double var6,
         double var8,
         double var10,
         List<GeometricShapes.ColoredLine> var12,
         List<GeometricShapes.ShapeMesh> var13
      ) {
         float var14 = (float)(var1.field_1352 - var2.field_1352);
         float var15 = (float)(var1.field_1351 - var2.field_1351);
         float var16 = (float)(var1.field_1350 - var2.field_1350);
         int var17 = 6;
         double var18 = var5 * 1.4000004889625575;
         double var20 = var5 * 0.20000004508207708;
         class_243 var22 = this.method1305(new class_243(0.0, var20, 0.0), var6, var8, var10);
         class_243 var23 = this.method1305(new class_243(0.0, -var20, 0.0), var6, var8, var10);

         for (int var24 = 0; var24 < var17; var24++) {
            double var25 = 6.283187713717119 * var24 / var17;
            class_243 var27 = this.method1305(new class_243(Math.cos(var25) * var18, var20, Math.sin(var25) * var18), var6, var8, var10);
            class_243 var28 = this.method1305(new class_243(Math.cos(var25) * var18, -var20, Math.sin(var25) * var18), var6, var8, var10);
            if (GeometricShapes.this.field0464.method0492()) {
               class_243[] var29 = new class_243[]{var22, var23, var28, var27};
               this.method2180(var29, new int[]{0, 1, 2, 3}, var14, var15, var16, var3, var4, var13);
            }

            this.method1598(new class_243[]{var22, var27}, new int[]{0, 1}, var14, var15, var16, var3, var4, var12);
            this.method1598(new class_243[]{var23, var28}, new int[]{0, 1}, var14, var15, var16, var3, var4, var12);
            this.method1598(new class_243[]{var27, var28}, new int[]{0, 1}, var14, var15, var16, var3, var4, var12);

            for (int var42 = 1; var42 <= 2; var42++) {
               double var30 = var18 * (0.30000003411622683 * var42);
               class_243 var32 = this.method1305(new class_243(Math.cos(var25) * var30, var20, Math.sin(var25) * var30), var6, var8, var10);
               class_243 var33 = this.method1305(new class_243(Math.cos(var25) * var30, -var20, Math.sin(var25) * var30), var6, var8, var10);
               double var34 = var25 + 0.7853984019917979;
               class_243 var36 = this.method1305(
                  new class_243(
                     Math.cos(var25) * var30 + Math.cos(var34) * var18 * 0.20000004508207708,
                     var20,
                     Math.sin(var25) * var30 + Math.sin(var34) * var18 * 0.20000004508207708
                  ),
                  var6,
                  var8,
                  var10
               );
               class_243 var37 = this.method1305(
                  new class_243(
                     Math.cos(var25) * var30 + Math.cos(var34) * var18 * 0.20000004508207708,
                     -var20,
                     Math.sin(var25) * var30 + Math.sin(var34) * var18 * 0.20000004508207708
                  ),
                  var6,
                  var8,
                  var10
               );
               if (GeometricShapes.this.field0464.method0492()) {
                  this.method2180(new class_243[]{var32, var33, var37, var36}, new int[]{0, 1, 2, 3}, var14, var15, var16, var3, var4, var13);
               }

               this.method1598(new class_243[]{var32, var36}, new int[]{0, 1}, var14, var15, var16, var3, var4, var12);
               this.method1598(new class_243[]{var36, var37}, new int[]{0, 1}, var14, var15, var16, var3, var4, var12);
               double var38 = var25 - 0.7853984019917979;
               class_243 var40 = this.method1305(
                  new class_243(
                     Math.cos(var25) * var30 + Math.cos(var38) * var18 * 0.20000004508207708,
                     var20,
                     Math.sin(var25) * var30 + Math.sin(var38) * var18 * 0.20000004508207708
                  ),
                  var6,
                  var8,
                  var10
               );
               class_243 var41 = this.method1305(
                  new class_243(
                     Math.cos(var25) * var30 + Math.cos(var38) * var18 * 0.20000004508207708,
                     -var20,
                     Math.sin(var25) * var30 + Math.sin(var38) * var18 * 0.20000004508207708
                  ),
                  var6,
                  var8,
                  var10
               );
               if (GeometricShapes.this.field0464.method0492()) {
                  this.method2180(new class_243[]{var32, var33, var41, var40}, new int[]{0, 1, 2, 3}, var14, var15, var16, var3, var4, var13);
               }

               this.method1598(new class_243[]{var32, var40}, new int[]{0, 1}, var14, var15, var16, var3, var4, var12);
               this.method1598(new class_243[]{var40, var41}, new int[]{0, 1}, var14, var15, var16, var3, var4, var12);
            }
         }
      }

      private void method0447(
         class_243 var1,
         class_243 var2,
         Matrix4f var3,
         int var4,
         float var5,
         double var6,
         double var8,
         double var10,
         List<GeometricShapes.ColoredLine> var12,
         List<GeometricShapes.ShapeMesh> var13
      ) {
         float var14 = (float)(var1.field_1352 - var2.field_1352);
         float var15 = (float)(var1.field_1351 - var2.field_1351);
         float var16 = (float)(var1.field_1350 - var2.field_1350);
         double var17 = (1.0 + Math.sqrt(5.0)) / 2.0;
         double var19 = var5;
         double var21 = var5 / var17;
         class_243[] var23 = new class_243[]{
            this.method1305(new class_243(0.0, var21, -var19), var6, var8, var10),
            this.method1305(new class_243(var21, var19, 0.0), var6, var8, var10),
            this.method1305(new class_243(-var21, var19, 0.0), var6, var8, var10),
            this.method1305(new class_243(0.0, var21, var19), var6, var8, var10),
            this.method1305(new class_243(0.0, -var21, var19), var6, var8, var10),
            this.method1305(new class_243(-var19, 0.0, var21), var6, var8, var10),
            this.method1305(new class_243(0.0, -var21, -var19), var6, var8, var10),
            this.method1305(new class_243(var19, 0.0, -var21), var6, var8, var10),
            this.method1305(new class_243(var19, 0.0, var21), var6, var8, var10),
            this.method1305(new class_243(-var19, 0.0, -var21), var6, var8, var10),
            this.method1305(new class_243(var21, -var19, 0.0), var6, var8, var10),
            this.method1305(new class_243(-var21, -var19, 0.0), var6, var8, var10)
         };
         int[][] var24 = new int[][]{
            {0, 1, 2},
            {3, 2, 1},
            {3, 1, 8},
            {3, 8, 4},
            {3, 4, 5},
            {2, 3, 5},
            {4, 10, 11},
            {4, 11, 5},
            {5, 11, 9},
            {5, 9, 2},
            {2, 9, 0},
            {9, 7, 0},
            {0, 7, 1},
            {6, 9, 11},
            {6, 11, 10},
            {6, 10, 7},
            {7, 10, 1},
            {8, 1, 10},
            {4, 8, 10},
            {6, 7, 9}
         };
         if (GeometricShapes.this.field0464.method0492()) {
            for (int[] var28 : var24) {
               this.method0353(var23, var28, var14, var15, var16, var3, var4, var13);
            }
         }

         int[][] var30 = new int[][]{
            {0, 1},
            {0, 2},
            {0, 7},
            {0, 9},
            {1, 2},
            {1, 3},
            {1, 7},
            {1, 8},
            {1, 10},
            {2, 3},
            {2, 5},
            {2, 9},
            {3, 4},
            {3, 5},
            {3, 8},
            {4, 5},
            {4, 8},
            {4, 10},
            {4, 11},
            {5, 9},
            {5, 11},
            {6, 7},
            {6, 9},
            {6, 10},
            {6, 11},
            {7, 9},
            {7, 10},
            {8, 10},
            {9, 11},
            {10, 11}
         };

         for (int[] var29 : var30) {
            this.method1598(var23, var29, var14, var15, var16, var3, var4, var12);
         }
      }

      private void method0390(
         class_243 var1,
         class_243 var2,
         Matrix4f var3,
         int var4,
         float var5,
         double var6,
         double var8,
         double var10,
         List<GeometricShapes.ColoredLine> var12,
         List<GeometricShapes.ShapeMesh> var13
      ) {
         float var14 = (float)(var1.field_1352 - var2.field_1352);
         float var15 = (float)(var1.field_1351 - var2.field_1351);
         float var16 = (float)(var1.field_1350 - var2.field_1350);
         double var17 = (1.0 + Math.sqrt(5.0)) / 2.0;
         double var19 = var5;
         double var21 = var5 / var17;
         double var23 = var5 * (2.0 - var17);
         class_243[] var25 = new class_243[]{
            this.method1305(new class_243(var19, var19, var19), var6, var8, var10),
            this.method1305(new class_243(var19, var19, -var19), var6, var8, var10),
            this.method1305(new class_243(var19, -var19, var19), var6, var8, var10),
            this.method1305(new class_243(var19, -var19, -var19), var6, var8, var10),
            this.method1305(new class_243(-var19, var19, var19), var6, var8, var10),
            this.method1305(new class_243(-var19, var19, -var19), var6, var8, var10),
            this.method1305(new class_243(-var19, -var19, var19), var6, var8, var10),
            this.method1305(new class_243(-var19, -var19, -var19), var6, var8, var10),
            this.method1305(new class_243(0.0, var21, var23), var6, var8, var10),
            this.method1305(new class_243(0.0, var21, -var23), var6, var8, var10),
            this.method1305(new class_243(0.0, -var21, var23), var6, var8, var10),
            this.method1305(new class_243(0.0, -var21, -var23), var6, var8, var10),
            this.method1305(new class_243(var23, 0.0, var21), var6, var8, var10),
            this.method1305(new class_243(var23, 0.0, -var21), var6, var8, var10),
            this.method1305(new class_243(-var23, 0.0, var21), var6, var8, var10),
            this.method1305(new class_243(-var23, 0.0, -var21), var6, var8, var10),
            this.method1305(new class_243(var21, var23, 0.0), var6, var8, var10),
            this.method1305(new class_243(var21, -var23, 0.0), var6, var8, var10),
            this.method1305(new class_243(-var21, var23, 0.0), var6, var8, var10),
            this.method1305(new class_243(-var21, -var23, 0.0), var6, var8, var10)
         };
         if (GeometricShapes.this.field0464.method0492()) {
            int[][] var26 = new int[][]{
               {0, 8, 4, 14, 12},
               {0, 12, 2, 17, 13},
               {0, 13, 1, 16, 8},
               {1, 9, 5, 18, 16},
               {1, 13, 3, 11, 9},
               {2, 10, 6, 14, 12},
               {2, 12, 0, 16, 17},
               {3, 17, 2, 10, 11},
               {3, 13, 0, 8, 9},
               {4, 8, 16, 18, 14},
               {5, 15, 7, 19, 18},
               {6, 10, 11, 7, 19}
            };

            for (int[] var30 : var26) {
               this.method0353(var25, new int[]{var30[0], var30[1], var30[2]}, var14, var15, var16, var3, var4, var13);
               this.method0353(var25, new int[]{var30[0], var30[2], var30[3]}, var14, var15, var16, var3, var4, var13);
               this.method0353(var25, new int[]{var30[0], var30[3], var30[4]}, var14, var15, var16, var3, var4, var13);
            }
         }

         int[][] var31 = new int[][]{
            {0, 8},
            {0, 12},
            {0, 16},
            {1, 9},
            {1, 13},
            {1, 16},
            {2, 10},
            {2, 12},
            {2, 17},
            {3, 11},
            {3, 13},
            {3, 17},
            {4, 8},
            {4, 14},
            {4, 18},
            {5, 9},
            {5, 15},
            {5, 18},
            {6, 10},
            {6, 14},
            {6, 19},
            {7, 11},
            {7, 15},
            {7, 19},
            {8, 9},
            {10, 11},
            {12, 13},
            {14, 15},
            {16, 18},
            {17, 19}
         };

         for (int[] var35 : var31) {
            this.method1598(var25, var35, var14, var15, var16, var3, var4, var12);
         }
      }

      private void method0509(
         class_243 var1,
         class_243 var2,
         Matrix4f var3,
         int var4,
         float var5,
         double var6,
         double var8,
         double var10,
         List<GeometricShapes.ColoredLine> var12,
         List<GeometricShapes.ShapeMesh> var13
      ) {
         float var14 = (float)(var1.field_1352 - var2.field_1352);
         float var15 = (float)(var1.field_1351 - var2.field_1351);
         float var16 = (float)(var1.field_1350 - var2.field_1350);
         double var17 = var5 * 1.0;
         double var19 = var5 * 0.3999999535514235;
         int var21 = 16;
         int var22 = 8;
         class_243[][] var23 = new class_243[var21][var22];

         for (int var24 = 0; var24 < var21; var24++) {
            double var25 = 6.283187713717119 * var24 / var21;

            for (int var27 = 0; var27 < var22; var27++) {
               double var28 = 6.283187713717119 * var27 / var22;
               double var30 = (var17 + var19 * Math.cos(var28)) * Math.cos(var25);
               double var32 = var19 * Math.sin(var28);
               double var34 = (var17 + var19 * Math.cos(var28)) * Math.sin(var25);
               var23[var24][var27] = this.method1305(new class_243(var30, var32, var34), var6, var8, var10);
            }
         }

         if (GeometricShapes.this.field0464.method0492()) {
            for (int var36 = 0; var36 < var21; var36++) {
               int var38 = (var36 + 1) % var21;

               for (int var26 = 0; var26 < var22; var26++) {
                  int var41 = (var26 + 1) % var22;
                  class_243 var43 = var23[var36][var26];
                  class_243 var29 = var23[var38][var26];
                  class_243 var46 = var23[var38][var41];
                  class_243 var31 = var23[var36][var41];
                  class_243[] var48 = new class_243[]{var43, var29, var46, var31};
                  this.method2180(var48, new int[]{0, 1, 2, 3}, var14, var15, var16, var3, var4, var13);
               }
            }
         }

         for (int var37 = 0; var37 < var21; var37++) {
            int var39 = (var37 + 1) % var21;

            for (int var40 = 0; var40 < var22; var40++) {
               int var42 = (var40 + 1) % var22;
               class_243 var44 = var23[var37][var40];
               class_243 var45 = var23[var39][var40];
               class_243 var47 = var23[var37][var42];
               var12.add(
                  new GeometricShapes.ColoredLine(
                     var3,
                     var14 + (float)var44.field_1352,
                     var15 + (float)var44.field_1351,
                     var16 + (float)var44.field_1350,
                     var14 + (float)var45.field_1352,
                     var15 + (float)var45.field_1351,
                     var16 + (float)var45.field_1350,
                     var4
                  )
               );
               var12.add(
                  new GeometricShapes.ColoredLine(
                     var3,
                     var14 + (float)var44.field_1352,
                     var15 + (float)var44.field_1351,
                     var16 + (float)var44.field_1350,
                     var14 + (float)var47.field_1352,
                     var15 + (float)var47.field_1351,
                     var16 + (float)var47.field_1350,
                     var4
                  )
               );
            }
         }
      }

      private void method0619(double var1, double var3, double var5) {
         if (var1 != this.field1291 || var3 != this.field1368 || var5 != this.field0384) {
            this.field1086 = Math.sin(var1);
            this.field1195 = Math.cos(var1);
            this.field0870 = Math.sin(var3);
            this.field0825 = Math.cos(var3);
            this.field0909 = Math.sin(var5);
            this.field1330 = Math.cos(var5);
            this.field1291 = var1;
            this.field1368 = var3;
            this.field0384 = var5;
         }
      }

      private class_243 method1305(class_243 var1, double var2, double var4, double var6) {
         this.method0619(var2, var4, var6);
         this.method0108(var1.field_1352, var1.field_1351, var1.field_1350);
         return new class_243(GeometricShapes.this.field0370[0], GeometricShapes.this.field0370[1], GeometricShapes.this.field0370[2]);
      }

      private void method0108(double var1, double var3, double var5) {
         double var7 = var3 * this.field1195 - var5 * this.field1086;
         double var9 = var3 * this.field1086 + var5 * this.field1195;
         double var11 = var1 * this.field0825 + var9 * this.field0870;
         double var13 = -var1 * this.field0870 + var9 * this.field0825;
         GeometricShapes.this.field0370[0] = var11 * this.field1330 - var7 * this.field0909;
         GeometricShapes.this.field0370[1] = var11 * this.field0909 + var7 * this.field1330;
         GeometricShapes.this.field0370[2] = var13;
      }
   }

   public enum ShapeType implements DisplayNamed {
      field0630("Cube"),
      field0063("Pyramid"),
      field1451("Octahedron"),
      field0986("Tetrahedron"),
      field0769("Star"),
      field1254("Snowflake"),
      field0321("Icosahedron"),
      field0192("Dodecahedron"),
      field0472("Torus");

      private final String field1643;

      ShapeType(String var3) {
         this.field1643 = var3;
      }

      @Override
      public String method0557() {
         return this.field1643;
      }

      public static GeometricShapes.ShapeType method1000(String var0) {
         for (GeometricShapes.ShapeType var4 : values()) {
            if (var4.method0557().equalsIgnoreCase(var0)) {
               return var4;
            }
         }

         return field0630;
      }
   }
}
