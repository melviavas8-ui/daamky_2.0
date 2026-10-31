package aethereal;

import java.awt.Color;
import java.util.List;
import net.minecraft.class_10014;
import net.minecraft.class_10017;
import net.minecraft.class_10042;
import net.minecraft.class_1297;
import net.minecraft.class_1921;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_892;
import net.minecraft.class_897;
import net.minecraft.class_922;
import org.joml.Matrix4f;

public class EntityVertexConsumer implements MinecraftAccess {
   private static EntityVertexConsumer.Quad field0611;
   private static Matrix4f field0168;
   private static class_243 field1521;
   private static class_243 field1043;

   public static void method1136(class_1297 var0, float var1, float var2, EntityVertexConsumer.Quad var3) {
      method1148(var0, false, var1, var2, var3);
   }

   public static void method1148(class_1297 var0, boolean var1, float var2, float var3, EntityVertexConsumer.Quad var4) {
      field0611 = var4;
      field1043 = field0796.field_1773.method_19418().method_19326();
      class_897 var5 = field0796.method_1561().method_3953(var0);
      class_10017 var6 = var5.method_62425(var0, var3);
      class_243 var7 = var5.method_23169(var6);
      field1521 = new class_243(
         class_3532.method_16436(var3, var0.field_6038, var0.method_23317()) + var7.field_1352,
         class_3532.method_16436(var3, var0.field_5971, var0.method_23318()) + var7.field_1351,
         class_3532.method_16436(var3, var0.field_5989, var0.method_23321()) + var7.field_1350
      );
      class_4587 var8 = new class_4587();
      field0168 = var8.method_23760().method_23761();
      var8.method_22903();
      var8.method_22905(var2, var2, var2);
      EntityVertexConsumer.VertexConsumer.field0610.method0578();
      if (var5 instanceof class_922 && var6 instanceof class_10042 var9) {
         ((EntityModelRenderHook)var5).daamky$render(var9, var8, EntityVertexConsumer.ConsumerProvider.field0609, 15);
      }

      if (var5 instanceof class_892 var11 && var6 instanceof class_10014 var10) {
         var11.method_3908(var10, var8, EntityVertexConsumer.ConsumerProvider.field0609, 15);
      }

      var8.method_22903();
   }

   private static class ConsumerProvider implements class_4597 {
      public static final EntityVertexConsumer.ConsumerProvider field0609 = new EntityVertexConsumer.ConsumerProvider();

      public class_4588 getBuffer(class_1921 var1) {
         return EntityVertexConsumer.VertexConsumer.field0610;
      }
   }

   private static class VertexConsumer implements class_4588 {
      public static final EntityVertexConsumer.VertexConsumer field0610 = new EntityVertexConsumer.VertexConsumer();
      private final float[] field0171 = new float[4];
      private final float[] field1528 = new float[4];
      private final float[] field1050 = new float[4];
      private int field0759 = 0;
      private int field1243 = 0;

      public void method0578() {
         this.field1243 = 0;
      }

      public class_4588 method_22912(float var1, float var2, float var3) {
         this.field0171[this.field0759] = var1;
         this.field1528[this.field0759] = var2;
         this.field1050[this.field0759] = var3;
         this.field0759++;
         if (this.field0759 == 4) {
            List var4;
            if (EntityVertexConsumer.field0611.method1974()) {
               var4 = WorldGeometryRenderer.field0488;
            } else if (EntityVertexConsumer.field0611.method1635()) {
               var4 = WorldGeometryRenderer.field1032;
            } else {
               var4 = WorldGeometryRenderer.field0139;
            }

            List var5 = EntityVertexConsumer.field0611.method1974()
               ? WorldGeometryRenderer.field1644
               : (EntityVertexConsumer.field0611.method1635() ? WorldGeometryRenderer.field0209 : WorldGeometryRenderer.field1508);
            if (EntityVertexConsumer.field0611.method0431() && EntityVertexConsumer.field0611.fill) {
               this.method1074(var4);
               this.field0759 = 0;
               return this;
            }

            if (EntityVertexConsumer.field0611.fill) {
               var4.add(
                  new WorldGeometryRenderer.VertexBatch(
                     new WorldGeometryRenderer.ColoredVertex(
                        EntityVertexConsumer.field0168,
                        (float)(EntityVertexConsumer.field1521.method_10216() + this.field0171[0] - EntityVertexConsumer.field1043.method_10216()),
                        (float)(EntityVertexConsumer.field1521.method_10214() + this.field1528[0] - EntityVertexConsumer.field1043.method_10214()),
                        (float)(EntityVertexConsumer.field1521.method_10215() + this.field1050[0] - EntityVertexConsumer.field1043.method_10215()),
                        EntityVertexConsumer.field0611.method0015().getRGB()
                     ),
                     new WorldGeometryRenderer.ColoredVertex(
                        EntityVertexConsumer.field0168,
                        (float)(EntityVertexConsumer.field1521.method_10216() + this.field0171[1] - EntityVertexConsumer.field1043.method_10216()),
                        (float)(EntityVertexConsumer.field1521.method_10214() + this.field1528[1] - EntityVertexConsumer.field1043.method_10214()),
                        (float)(EntityVertexConsumer.field1521.method_10215() + this.field1050[1] - EntityVertexConsumer.field1043.method_10215()),
                        EntityVertexConsumer.field0611.method0015().getRGB()
                     ),
                     new WorldGeometryRenderer.ColoredVertex(
                        EntityVertexConsumer.field0168,
                        (float)(EntityVertexConsumer.field1521.method_10216() + this.field0171[2] - EntityVertexConsumer.field1043.method_10216()),
                        (float)(EntityVertexConsumer.field1521.method_10214() + this.field1528[2] - EntityVertexConsumer.field1043.method_10214()),
                        (float)(EntityVertexConsumer.field1521.method_10215() + this.field1050[2] - EntityVertexConsumer.field1043.method_10215()),
                        EntityVertexConsumer.field0611.method0015().getRGB()
                     ),
                     new WorldGeometryRenderer.ColoredVertex(
                        EntityVertexConsumer.field0168,
                        (float)(EntityVertexConsumer.field1521.method_10216() + this.field0171[3] - EntityVertexConsumer.field1043.method_10216()),
                        (float)(EntityVertexConsumer.field1521.method_10214() + this.field1528[3] - EntityVertexConsumer.field1043.method_10214()),
                        (float)(EntityVertexConsumer.field1521.method_10215() + this.field1050[3] - EntityVertexConsumer.field1043.method_10215()),
                        EntityVertexConsumer.field0611.method0015().getRGB()
                     )
                  )
               );
            }

            if (EntityVertexConsumer.field0611.outline) {
               var5.add(
                  new WorldGeometryRenderer.VertexBatch(
                     new WorldGeometryRenderer.ColoredVertex(
                        EntityVertexConsumer.field0168,
                        (float)(EntityVertexConsumer.field1521.field_1352 + this.field0171[0] - EntityVertexConsumer.field1043.method_10216()),
                        (float)(EntityVertexConsumer.field1521.field_1351 + this.field1528[0] - EntityVertexConsumer.field1043.method_10214()),
                        (float)(EntityVertexConsumer.field1521.field_1350 + this.field1050[0] - EntityVertexConsumer.field1043.method_10215()),
                        EntityVertexConsumer.field0611.method1790().getRGB()
                     ),
                     new WorldGeometryRenderer.ColoredVertex(
                        EntityVertexConsumer.field0168,
                        (float)(EntityVertexConsumer.field1521.field_1352 + this.field0171[1] - EntityVertexConsumer.field1043.method_10216()),
                        (float)(EntityVertexConsumer.field1521.field_1351 + this.field1528[1] - EntityVertexConsumer.field1043.method_10214()),
                        (float)(EntityVertexConsumer.field1521.field_1350 + this.field1050[1] - EntityVertexConsumer.field1043.method_10215()),
                        EntityVertexConsumer.field0611.method1790().getRGB()
                     ),
                     new WorldGeometryRenderer.ColoredVertex(
                        EntityVertexConsumer.field0168,
                        (float)(EntityVertexConsumer.field1521.field_1352 + this.field0171[1] - EntityVertexConsumer.field1043.method_10216()),
                        (float)(EntityVertexConsumer.field1521.field_1351 + this.field1528[1] - EntityVertexConsumer.field1043.method_10214()),
                        (float)(EntityVertexConsumer.field1521.field_1350 + this.field1050[1] - EntityVertexConsumer.field1043.method_10215()),
                        EntityVertexConsumer.field0611.method1790().getRGB()
                     ),
                     new WorldGeometryRenderer.ColoredVertex(
                        EntityVertexConsumer.field0168,
                        (float)(EntityVertexConsumer.field1521.field_1352 + this.field0171[2] - EntityVertexConsumer.field1043.method_10216()),
                        (float)(EntityVertexConsumer.field1521.field_1351 + this.field1528[2] - EntityVertexConsumer.field1043.method_10214()),
                        (float)(EntityVertexConsumer.field1521.field_1350 + this.field1050[2] - EntityVertexConsumer.field1043.method_10215()),
                        EntityVertexConsumer.field0611.method1790().getRGB()
                     ),
                     new WorldGeometryRenderer.ColoredVertex(
                        EntityVertexConsumer.field0168,
                        (float)(EntityVertexConsumer.field1521.field_1352 + this.field0171[2] - EntityVertexConsumer.field1043.method_10216()),
                        (float)(EntityVertexConsumer.field1521.field_1351 + this.field1528[2] - EntityVertexConsumer.field1043.method_10214()),
                        (float)(EntityVertexConsumer.field1521.field_1350 + this.field1050[2] - EntityVertexConsumer.field1043.method_10215()),
                        EntityVertexConsumer.field0611.method1790().getRGB()
                     ),
                     new WorldGeometryRenderer.ColoredVertex(
                        EntityVertexConsumer.field0168,
                        (float)(EntityVertexConsumer.field1521.field_1352 + this.field0171[3] - EntityVertexConsumer.field1043.method_10216()),
                        (float)(EntityVertexConsumer.field1521.field_1351 + this.field1528[3] - EntityVertexConsumer.field1043.method_10214()),
                        (float)(EntityVertexConsumer.field1521.field_1350 + this.field1050[3] - EntityVertexConsumer.field1043.method_10215()),
                        EntityVertexConsumer.field0611.method1790().getRGB()
                     ),
                     new WorldGeometryRenderer.ColoredVertex(
                        EntityVertexConsumer.field0168,
                        (float)(EntityVertexConsumer.field1521.field_1352 + this.field0171[0] - EntityVertexConsumer.field1043.method_10216()),
                        (float)(EntityVertexConsumer.field1521.field_1351 + this.field1528[0] - EntityVertexConsumer.field1043.method_10214()),
                        (float)(EntityVertexConsumer.field1521.field_1350 + this.field1050[0] - EntityVertexConsumer.field1043.method_10215()),
                        EntityVertexConsumer.field0611.method1790().getRGB()
                     ),
                     new WorldGeometryRenderer.ColoredVertex(
                        EntityVertexConsumer.field0168,
                        (float)(EntityVertexConsumer.field1521.field_1352 + this.field0171[0] - EntityVertexConsumer.field1043.method_10216()),
                        (float)(EntityVertexConsumer.field1521.field_1351 + this.field1528[0] - EntityVertexConsumer.field1043.method_10214()),
                        (float)(EntityVertexConsumer.field1521.field_1350 + this.field1050[0] - EntityVertexConsumer.field1043.method_10215()),
                        EntityVertexConsumer.field0611.method1790().getRGB()
                     )
                  )
               );
            }

            this.field0759 = 0;
         }

         return this;
      }

      public class_4588 method_1336(int var1, int var2, int var3, int var4) {
         return this;
      }

      public class_4588 method_22913(float var1, float var2) {
         return this;
      }

      public class_4588 method_60796(int var1, int var2) {
         return this;
      }

      public class_4588 method_22921(int var1, int var2) {
         return this;
      }

      public class_4588 method_22914(float var1, float var2, float var3) {
         return this;
      }

      private void method1074(List<WorldGeometryRenderer.VertexBatch> var1) {
         int var2 = this.field1243++;
         EntityVertexConsumer.Vertex var3 = EntityVertexConsumer.field0611.method0361();
         float var4 = this.field0171[1] - this.field0171[0];
         float var5 = this.field1528[1] - this.field1528[0];
         float var6 = this.field1050[1] - this.field1050[0];
         float var7 = this.field0171[3] - this.field0171[0];
         float var8 = this.field1528[3] - this.field1528[0];
         float var9 = this.field1050[3] - this.field1050[0];
         float var10 = var5 * var9 - var6 * var8;
         float var11 = var6 * var7 - var4 * var9;
         float var12 = var4 * var8 - var5 * var7;
         float var13 = (float)Math.sqrt(var10 * var10 + var11 * var11 + var12 * var12);
         if (!(var13 < 1.0E-6F)) {
            var10 /= var13;
            var11 /= var13;
            var12 /= var13;
            float var14 = 0.16903F;
            float var15 = 0.84515F;
            float var16 = -0.50709F;
            float var17 = -0.16903F;
            float var18 = 0.84515F;
            float var19 = 0.50709F;
            float var20 = Math.max(0.0F, var10 * var14 + var11 * var15 + var12 * var16) + Math.max(0.0F, var10 * var17 + var11 * var18 + var12 * var19);
            float var21 = Math.min(0.7F + 0.35F * var20, 1.3F);
            long var22 = var2 * 1390625219L;
            float var24 = (float)(var22 >>> 17 & 65535L) / 65535.0F;
            float var25 = (float)(var22 >>> 1 & 65535L) / 65535.0F;
            float var26 = (float)Math.sin(var3.method1762() * var3.method1603() + var25 * 6.28318F) * 0.5F + 0.5F;
            float var27 = var21 * (1.0F + (var24 - 0.5F) * 2.0F * var3.method1946() + var26 * 0.1F);
            int var28 = EntityVertexConsumer.field0611.method0015().getRGB();
            int var29 = this.method0716((int)((var28 >> 16 & 0xFF) * var27));
            int var30 = this.method0716((int)((var28 >> 8 & 0xFF) * var27));
            int var31 = this.method0716((int)((var28 & 0xFF) * var27));
            int var32 = var28 >>> 24 & 0xFF;
            int var33 = var32 << 24 | var29 << 16 | var30 << 8 | var31;
            float var34 = 0.0F;
            float var35 = 0.0F;
            float var36 = 0.0F;
            if (var3.method0483() >= 0.0F && var3.method1697() > 0.0F) {
               float var37 = (this.field0171[0] + this.field0171[1] + this.field0171[2] + this.field0171[3]) * 0.25F;
               float var38 = (this.field1528[0] + this.field1528[1] + this.field1528[2] + this.field1528[3]) * 0.25F;
               float var39 = (this.field1050[0] + this.field1050[1] + this.field1050[2] + this.field1050[3]) * 0.25F;
               float var40 = (float)(EntityVertexConsumer.field1521.field_1352 + var37) - var3.method1901();
               float var41 = (float)(EntityVertexConsumer.field1521.field_1351 + var38) - var3.method1878();
               float var42 = (float)(EntityVertexConsumer.field1521.field_1350 + var39) - var3.method1928();
               float var43 = var40 * var40 + var41 * var41 + var42 * var42;
               float var44 = var3.method1697() * var3.method1697();
               if (var43 < var44) {
                  float var45 = (float)Math.sqrt(var43);
                  float var46 = 1.0F - var45 / var3.method1697();
                  var46 *= var46;
                  float var47 = Math.min(var3.method0483() / var3.method2213(), 1.0F);
                  float var48 = (float)Math.exp(-3.0F * var47);
                  float var49 = (float)Math.cos(var47 * 9.42F);
                  float var50 = var48 * var49;
                  float var51 = var50 * var46 * var3.method2182() * var3.method0002();
                  float var52 = var45 > 1.0E-4F ? 1.0F / var45 : 0.0F;
                  var34 = var40 * var52 * var51;
                  var35 = var41 * var52 * var51;
                  var36 = var42 * var52 * var51;
               }
            }

            double var56 = EntityVertexConsumer.field1521.field_1352 - EntityVertexConsumer.field1043.field_1352 + var34;
            double var57 = EntityVertexConsumer.field1521.field_1351 - EntityVertexConsumer.field1043.field_1351 + var35;
            double var58 = EntityVertexConsumer.field1521.field_1350 - EntityVertexConsumer.field1043.field_1350 + var36;
            var1.add(
               new WorldGeometryRenderer.VertexBatch(
                  new WorldGeometryRenderer.ColoredVertex(
                     EntityVertexConsumer.field0168,
                     (float)(var56 + this.field0171[0]),
                     (float)(var57 + this.field1528[0]),
                     (float)(var58 + this.field1050[0]),
                     var33
                  ),
                  new WorldGeometryRenderer.ColoredVertex(
                     EntityVertexConsumer.field0168,
                     (float)(var56 + this.field0171[1]),
                     (float)(var57 + this.field1528[1]),
                     (float)(var58 + this.field1050[1]),
                     var33
                  ),
                  new WorldGeometryRenderer.ColoredVertex(
                     EntityVertexConsumer.field0168,
                     (float)(var56 + this.field0171[2]),
                     (float)(var57 + this.field1528[2]),
                     (float)(var58 + this.field1050[2]),
                     var33
                  ),
                  new WorldGeometryRenderer.ColoredVertex(
                     EntityVertexConsumer.field0168,
                     (float)(var56 + this.field0171[3]),
                     (float)(var57 + this.field1528[3]),
                     (float)(var58 + this.field1050[3]),
                     var33
                  )
               )
            );
         }
      }

      private int method0716(int var1) {
         return var1 < 0 ? 0 : (var1 > 255 ? 255 : var1);
      }
   }

   public record Vertex(
      float cellSize,
      float depth,
      float gap,
      float time,
      float waveSpeed,
      float brightVar,
      float breatheAmount,
      float sideDarken,
      float hitElapsed,
      float hitDuration,
      float hitStrength,
      float hitWaveSpeed,
      float hitX,
      float hitY,
      float hitZ,
      float hitRadius
   ) {
      public static final EntityVertexConsumer.Vertex DEFAULT = new EntityVertexConsumer.Vertex(
         0.0625F, 0.04F, 0.0F, 0.0F, 1.2F, 0.2F, 0.25F, 0.55F, -1.0F, 0.55F, 1.6F, 6.0F, 0.0F, 0.0F, 0.0F, 0.4F
      );

      public float method0530() {
         return this.cellSize;
      }

      public float method0002() {
         return this.depth;
      }

      public float method2047() {
         return this.gap;
      }

      public float method1762() {
         return this.time;
      }

      public float method1603() {
         return this.waveSpeed;
      }

      public float method1946() {
         return this.brightVar;
      }

      public float method0413() {
         return this.breatheAmount;
      }

      public float method0355() {
         return this.sideDarken;
      }

      public float method0483() {
         return this.hitElapsed;
      }

      public float method2213() {
         return this.hitDuration;
      }

      public float method2182() {
         return this.hitStrength;
      }

      public float method2253() {
         return this.hitWaveSpeed;
      }

      public float method1901() {
         return this.hitX;
      }

      public float method1878() {
         return this.hitY;
      }

      public float method1928() {
         return this.hitZ;
      }

      public float method1697() {
         return this.hitRadius;
      }
   }

   public record Quad(
      boolean fill,
      Color fillColor,
      boolean outline,
      Color outlineColor,
      boolean shine,
      boolean additive,
      boolean pixelScale,
      EntityVertexConsumer.Vertex pixelParams
   ) {
      public Quad(boolean var1, Color var2, boolean var3, Color var4, boolean var5, boolean var6, boolean var7) {
         this(var1, var2, var3, var4, var5, var6, var7, EntityVertexConsumer.Vertex.DEFAULT);
      }

      public Quad(boolean var1, Color var2, boolean var3, Color var4, boolean var5, boolean var6) {
         this(var1, var2, var3, var4, var5, var6, false, EntityVertexConsumer.Vertex.DEFAULT);
      }

      public Quad(boolean var1, Color var2, boolean var3, Color var4, boolean var5) {
         this(var1, var2, var3, var4, var5, false, false, EntityVertexConsumer.Vertex.DEFAULT);
      }

      public boolean method0579() {
         return this.fill;
      }

      public Color method0015() {
         return this.fillColor;
      }

      public boolean method2079() {
         return this.outline;
      }

      public Color method1790() {
         return this.outlineColor;
      }

      public boolean method1635() {
         return this.shine;
      }

      public boolean method1974() {
         return this.additive;
      }

      public boolean method0431() {
         return this.pixelScale;
      }

      public EntityVertexConsumer.Vertex method0361() {
         return this.pixelParams;
      }
   }
}
