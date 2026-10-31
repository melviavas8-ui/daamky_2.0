package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10142;
import net.minecraft.class_243;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

public class Constellation extends Module {
   private final FloatSetting field0060 = new FloatSetting("constellation.staramount", 110.0F, 50.0F, 300.0F, 10.0F)
      .method1007("Star Amount")
      .method0210("Number of stars to render")
      .method2130("Количество");
   private final FloatSetting field1450 = new FloatSetting("constellation.range", 145.0F, 20.0F, 200.0F, 5.0F)
      .method1007("Range")
      .method0210("Spawn range of stars around player")
      .method2130("Дальность");
   private final FloatSetting field0985 = new FloatSetting("constellation.connectiondistance", 35.0F, 10.0F, 80.0F, 5.0F)
      .method1007("Connection Distance")
      .method0210("Max distance for star connections")
      .method2130("Максимальноле расстояние для соединения звёзд");
   private final BooleanSetting field0184 = new BooleanSetting("constellation.showconnections", true)
      .method1007("Show Connections")
      .method0210("Draw lines between nearby stars")
      .method2130("Рисовать линии между ближайшими звёздами");
   private final ColorSetting field0466 = new ColorSetting("constellation.starcolor", 255, 152, 235, 58)
      .method1882()
      .method1007("Star Color")
      .method0210("Color of the stars")
      .method2130("Цвет звёзд");
   private final ColorSetting field1623 = new ColorSetting("constellation.connectioncolor", 253, 200, 255, 65, this.field0184::method0492)
      .method1882()
      .method1007("Connection Color")
      .method0210("Color of connection lines")
      .method2130("Цвет соединительных линий");
   private static final float field1538 = 150.0F;
   private static final float field1704 = 5.0F;
   private static final float field1136 = 45.0F;
   private static final float field1087 = 0.05F;
   private static final float field1196 = 0.05F;
   private static final float field0871 = 0.03F;
   private final List<Constellation.Star> field0843 = new ArrayList<>();
   private final List<Constellation.ConstellationMesh> field0928 = new ArrayList<>();
   private final Random field1348 = new Random();
   private class_243 field1311 = class_243.field_1353;
   private static final class_2960 field1387 = DaamkyClient.method1012("textures/glow.png");
   private int field0386 = 0;
   private class_243 field0368 = class_243.field_1353;
   private final List<Constellation.ColoredVertex> field0438 = new ArrayList<>();

   public Constellation() {
      super("Constellation", ModuleCategory.field1004, "Renders constellation visual effects");
      this.method1013("Рисует созвездия");
   }

   @Override
   public void method0025() {
      super.method0025();
      if (!method1974()) {
         this.field1311 = field0796.field_1724.method_19538();
         this.field0368 = field0796.field_1724.method_19538();
         this.method1735();
      }
   }

   @Override
   public void method2078() {
      super.method2078();
      this.field0843.clear();
      this.field0368 = class_243.field_1353;
   }

   private void method1735() {
      this.field1311 = field0796.field_1724.method_19538();
      int var1 = this.field0060.method0492().intValue();

      for (int var2 = 0; var2 < var1; var2++) {
         this.method1691();
      }
   }

   private void method1691() {
      double var1 = this.field1450.method0492().floatValue();
      double var3 = 5.0;
      class_243 var5 = field0796.field_1724.method_19538();
      class_243 var6 = class_243.field_1353;
      if (this.field0368 != class_243.field_1353) {
         var6 = var5.method_1020(this.field0368).method_1029();
      }

      double var7 = var6.method_1033() > 0.10000000404759532 ? 0.600000004890641 : 0.0;
      double var9;
      double var11;
      if (var7 > 0.0 && this.field1348.nextDouble() < var7) {
         double var13 = var1 * (0.5 + this.field1348.nextDouble() * 1.5);
         double var15 = var1 * (this.field1348.nextDouble() - 0.5);
         var9 = var6.field_1352 * var13 + var6.field_1350 * var15;
         var11 = var6.field_1350 * var13 - var6.field_1352 * var15;
      } else {
         var9 = (this.field1348.nextDouble() - 0.5) * var1 * 2.0;
         var11 = (this.field1348.nextDouble() - 0.5) * var1 * 2.0;
      }

      double var20 = var5.field_1352 + var9;
      double var21 = var5.field_1351 + var3 + (this.field1348.nextDouble() - 0.5) * 45.0;
      double var17 = var5.field_1350 + var11;
      class_243 var19 = new class_243(
         (this.field1348.nextDouble() - 0.5) * 0.05F,
         (this.field1348.nextDouble() - 0.5) * 0.05F * 0.30000015809487784,
         (this.field1348.nextDouble() - 0.5) * 0.05F
      );
      this.field0843.add(new Constellation.Star(new class_243(var20, var21, var17), var19, this.field1348.nextDouble() * 3.1415927131989854 * 2.0));
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         this.field0386++;
         class_243 var2 = field0796.field_1724.method_19538();
         double var3 = 150.0;
         int var5 = this.field0060.method0492().intValue();
         double var6 = 0.0;
         if (this.field0368 != class_243.field_1353) {
            var6 = var2.method_1022(this.field0368);
         }

         this.field0368 = var2;

         for (int var8 = this.field0843.size() - 1; var8 >= 0; var8--) {
            Constellation.Star var9 = this.field0843.get(var8);
            double var10 = var9.field0157.method_1022(var2);
            if (var10 > var3) {
               var9.field0219 = true;
            } else {
               var9.field0219 = false;
            }

            var9.method0578();
            if (var9.field0314 <= 0.001F && var9.field0219) {
               this.field0843.remove(var8);
            }
         }

         if (this.field0843.size() < var5) {
            int var12 = 3;
            if (var6 > 2.0) {
               var12 = Math.min(20, (int)(var6 * 5.0));
            } else if (var6 > 0.5) {
               var12 = 10;
            } else if (this.field0386 % 3 != 0) {
               var12 = 0;
            }

            int var13 = Math.min(var12, var5 - this.field0843.size());

            for (int var14 = 0; var14 < var13; var14++) {
               this.method1691();
            }
         }
      }
   }

   @EventHandler
   public void onRenderWorld(GlowRenderEvent var1) {
      if (!method1974()) {
         this.field0438.clear();
         this.field0928.clear();
         class_243 var2 = field0796.field_1773.method_19418().method_19326();
         Matrix4f var3 = new Matrix4f();
         float var4 = var1.method1603();
         if (this.field0184.method0492()) {
            double var5 = this.field0985.method0492().floatValue();
            double var7 = var5 * var5;

            for (int var9 = 0; var9 < this.field0843.size(); var9++) {
               Constellation.Star var10 = this.field0843.get(var9);
               if (!(var10.field0314 <= 0.001F)) {
                  class_243 var11 = var10.method0664(var4);

                  for (int var12 = var9 + 1; var12 < this.field0843.size(); var12++) {
                     Constellation.Star var13 = this.field0843.get(var12);
                     if (!(var13.field0314 <= 0.001F)) {
                        class_243 var14 = var13.method0664(var4);
                        double var15 = var11.method_1025(var14);
                        if (var15 < var7) {
                           float var17 = (float)(Math.sqrt(var15) / var5);
                           this.method1338(var11, var14, var2, var3, var17, var10.field0314, var13.field0314);
                        }
                     }
                  }
               }
            }
         }

         for (Constellation.Star var6 : this.field0843) {
            var6.method1344(var2, var3, var4);
         }

         if (!this.field0438.isEmpty()) {
            this.method2029();
         }

         if (!this.field0928.isEmpty()) {
         }
      }
   }

   private void method1754() {
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(770, 32772);
      RenderSystem.enableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.setShaderTexture(0, field1387);
      RenderSystem.setShader(class_10142.field_53880);
      class_287 var1 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1575);

      for (Constellation.ConstellationMesh var3 : this.field0928) {
         var1.method_22918(var3.matrix, var3.x1, var3.y1, var3.z1).method_22913(0.0F, 0.0F).method_39415(var3.color);
         var1.method_22918(var3.matrix, var3.x2, var3.y2, var3.z2).method_22913(1.0F, 0.0F).method_39415(var3.color);
         var1.method_22918(var3.matrix, var3.x3, var3.y3, var3.z3).method_22913(1.0F, 1.0F).method_39415(var3.color);
         var1.method_22918(var3.matrix, var3.x4, var3.y4, var3.z4).method_22913(0.0F, 1.0F).method_39415(var3.color);
      }

      class_286.method_43433(var1.method_60800());
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.depthMask(true);
      RenderSystem.disableBlend();
   }

   private void method2029() {
      if (!this.field0438.isEmpty()) {
         RenderSystem.enableBlend();
         RenderSystem.blendFunc(770, 32772);
         RenderSystem.enableDepthTest();
         RenderSystem.depthMask(false);
         class_287 var1 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_29344, class_290.field_1576);

         for (Constellation.ColoredVertex var3 : this.field0438) {
            var1.method_22918(var3.matrix, var3.x, var3.y, var3.z).method_39415(var3.color);
         }

         RenderSystem.setShader(class_10142.field_53876);
         GL11.glHint(3154, 4354);
         GL11.glEnable(2848);
         class_286.method_43433(var1.method_60800());
         GL11.glDisable(2848);
         RenderSystem.depthMask(true);
         RenderSystem.disableBlend();
      }
   }

   private void method1338(class_243 var1, class_243 var2, class_243 var3, Matrix4f var4, float var5, float var6, float var7) {
      float var8 = (float)(var1.field_1352 - var3.field_1352);
      float var9 = (float)(var1.field_1351 - var3.field_1351);
      float var10 = (float)(var1.field_1350 - var3.field_1350);
      float var11 = (float)(var2.field_1352 - var3.field_1352);
      float var12 = (float)(var2.field_1351 - var3.field_1351);
      float var13 = (float)(var2.field_1350 - var3.field_1350);
      Color var14 = this.field1623.method1726();
      float var15 = (var6 + var7) / 2.0F;
      int var16 = Math.max(0, Math.min(255, (int)(var14.getAlpha() * (1.0F - var5 * 0.7F) * var15)));
      int var17 = (var16 & 0xFF) << 24 | var14.getRGB() & 16777215;
      this.field0438.add(new Constellation.ColoredVertex(var4, var8, var9, var10, var17));
      this.field0438.add(new Constellation.ColoredVertex(var4, var11, var12, var13, var17));
      this.field0438.add(new Constellation.ColoredVertex(var4, var8, var9, var10, var17));
      this.field0438.add(new Constellation.ColoredVertex(var4, var11, var12, var13, var17));
   }

   private record ColoredVertex(Matrix4f matrix, float x, float y, float z, int color) {
      public Matrix4f method0577() {
         return this.matrix;
      }

      public float method0002() {
         return this.x;
      }

      public float method2047() {
         return this.y;
      }

      public float method1762() {
         return this.z;
      }

      public int method1604() {
         return this.color;
      }
   }

   private class Star {
      private class_243 field0157;
      private class_243 field1521;
      private final class_243 field1043;
      private double field0757;
      private final double field1241;
      private float field0314;
      private boolean field0219;

      public Star(class_243 var2, class_243 var3, double var4) {
         this.field0157 = var2;
         this.field1521 = var2;
         this.field1043 = var3;
         this.field0757 = 0.0;
         this.field1241 = var4;
         this.field0314 = 0.0F;
         this.field0219 = false;
      }

      public void method0578() {
         this.field1521 = this.field0157;
         this.field0157 = this.field0157.method_1019(this.field1043);
         this.field0757 += 0.08000003004254284;
         if (this.field0219) {
            this.field0314 = Math.max(0.0F, this.field0314 - 0.06F);
         } else {
            this.field0314 = Math.min(1.0F, this.field0314 + 0.03F);
         }
      }

      public class_243 method0664(float var1) {
         return this.field1521.method_35590(this.field0157, var1);
      }

      public void method1344(class_243 var1, Matrix4f var2, float var3) {
         if (!(this.field0314 <= 0.001F)) {
            class_243 var4 = this.method0664(var3);
            float var5 = (float)(var4.field_1352 - var1.field_1352);
            float var6 = (float)(var4.field_1351 - var1.field_1351);
            float var7 = (float)(var4.field_1350 - var1.field_1350);
            Color var8 = Constellation.this.field0466.method1726();
            float var9 = 1.0F;
            double var10 = (Math.sin(this.field0757 + this.field1241) + 1.0) / 2.0;
            var9 = (float)(0.6000000782357008 + var10 * 0.4000000149599089);
            int var19 = Math.max(0, Math.min(255, (int)(var8.getAlpha() * var9 * this.field0314)));
            int var11 = (var19 & 0xFF) << 24 | var8.getRGB() & 16777215;
            float var12 = 0.05F;
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 - var12, var6, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 + var12, var6, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5, var6 - var12, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5, var6 + var12, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5, var6, var7 - var12, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5, var6, var7 + var12, var11));
            float var13 = var12 * 0.7F;
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 - var13, var6 - var13, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 + var13, var6 + var13, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 - var13, var6 + var13, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 + var13, var6 - var13, var7, var11));
            float var14 = var12 * 0.5F;
            float var15 = var13 * 0.5F;
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 - var14, var6, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 + var14, var6, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5, var6 - var14, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5, var6 + var14, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5, var6, var7 - var14, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5, var6, var7 + var14, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 - var15, var6 - var15, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 + var15, var6 + var15, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 - var15, var6 + var15, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 + var15, var6 - var15, var7, var11));
            float var16 = var12 * 0.4F;
            float var17 = var13 * 0.4F;
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 - var16, var6, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 + var16, var6, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5, var6 - var16, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5, var6 + var16, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5, var6, var7 - var16, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5, var6, var7 + var16, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 - var17, var6 - var17, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 + var17, var6 + var17, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 - var17, var6 + var17, var7, var11));
            Constellation.this.field0438.add(new Constellation.ColoredVertex(var2, var5 + var17, var6 - var17, var7, var11));
         }
      }

      public void method0295(class_243 var1, Matrix4f var2, float var3) {
         if (!(this.field0314 <= 0.001F)) {
            class_243 var4 = this.method0664(var3);
            class_243 var5 = var1.method_1020(var4).method_1029();
            class_243 var6 = new class_243(-var5.field_1350, 0.0, var5.field_1352).method_1029();
            class_243 var7 = new class_243(0.0, 1.0, 0.0);
            float var8 = 0.2F;
            Color var9 = Constellation.this.field0466.method1726();
            float var10 = 1.0F;
            double var11 = (Math.sin(this.field0757 + this.field1241) + 1.0) / 2.0;
            var10 = (float)(0.6000000782357008 + var11 * 0.4000000149599089);
            int var21 = (int)(255.0F * var10 * this.field0314);
            var9 = new Color(var9.getRed(), var9.getGreen(), var9.getBlue(), Math.max(0, Math.min(255, var21)));
            float var12 = (float)(var4.field_1352 - var1.field_1352);
            float var13 = (float)(var4.field_1351 - var1.field_1351);
            float var14 = (float)(var4.field_1350 - var1.field_1350);
            class_243 var15 = new class_243(var12, var13, var14).method_1019(var6.method_1021(-var8)).method_1019(var7.method_1021(-var8));
            class_243 var16 = new class_243(var12, var13, var14).method_1019(var6.method_1021(var8)).method_1019(var7.method_1021(-var8));
            class_243 var17 = new class_243(var12, var13, var14).method_1019(var6.method_1021(var8)).method_1019(var7.method_1021(var8));
            class_243 var18 = new class_243(var12, var13, var14).method_1019(var6.method_1021(-var8)).method_1019(var7.method_1021(var8));
            Constellation.this.field0928
               .add(
                  new Constellation.ConstellationMesh(
                     var2,
                     (float)var15.field_1352,
                     (float)var15.field_1351,
                     (float)var15.field_1350,
                     (float)var16.field_1352,
                     (float)var16.field_1351,
                     (float)var16.field_1350,
                     (float)var17.field_1352,
                     (float)var17.field_1351,
                     (float)var17.field_1350,
                     (float)var18.field_1352,
                     (float)var18.field_1351,
                     (float)var18.field_1350,
                     var9.getRGB()
                  )
               );
         }
      }
   }

   private record ConstellationMesh(
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
}
