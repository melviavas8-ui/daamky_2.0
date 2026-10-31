package aethereal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1297;
import net.minecraft.class_1665;
import net.minecraft.class_1682;
import net.minecraft.class_243;
import net.minecraft.class_4587;
import org.joml.Matrix4f;

public class ProjectileTrails extends Module {
   private final FloatSetting field0060 = new FloatSetting("projectiletrails.amount", 5.0F, 1.0F, 15.0F, 1.0F)
      .method1007("Amount")
      .method0210("Particles spawned per tick per projectile")
      .method2130("Количество");
   private final FloatSetting field1450 = new FloatSetting("projectiletrails.size", 0.04F, 0.01F, 0.2F, 0.01F)
      .method1007("Size")
      .method0210("Size of trail particles")
      .method2130("Размер");
   private final FloatSetting field0985 = new FloatSetting("projectiletrails.lifetime", 30.0F, 5.0F, 60.0F, 1.0F)
      .method1007("Lifetime")
      .method0210("How long particles last in ticks")
      .method2130("Длительность");
   private final BooleanSetting field0184 = new BooleanSetting("projectiletrails.shine", true)
      .method1007("Shine")
      .method0210("Additive blending for glow")
      .method2130("Сияние");
   private final ColorSetting field0466 = new ColorSetting("projectiletrails.color", 255, 156, 228, 180)
      .method1882()
      .method1007("Color")
      .method0210("Trail color")
      .method2130("Цвет");
   private final List<ProjectileTrails.TrailPoint> field1644 = new ArrayList<>();
   private final Map<Integer, class_243> field1566 = new HashMap<>();
   private final Random field1730 = new Random();

   public ProjectileTrails() {
      super("ProjectileTrails", ModuleCategory.field1004, "Adds particle trails to thrown projectiles");
      this.method1013("Добавляет следы частиц к предметам которые бросают игроки");
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field1644.clear();
      this.field1566.clear();
   }

   @Override
   public void method2078() {
      super.method2078();
      this.field1644.clear();
      this.field1566.clear();
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         Set var2 = new HashSet<>();

         for (class_1297 var4 : field0796.field_1687.method_18112()) {
            if (this.method1129(var4)) {
               var2.add(var4.method_5628());
               class_243 var5 = var4.method_19538();
               class_243 var6 = this.field1566.get(var4.method_5628());
               if (var6 != null && var5.method_1025(var6) > 9.999994329400472E-4) {
                  int var7 = this.field0060.method0492().intValue();

                  for (int var8 = 0; var8 < var7; var8++) {
                     float var9 = (float)var8 / var7;
                     double var10 = var6.field_1352 + (var5.field_1352 - var6.field_1352) * var9 + (this.field1730.nextDouble() - 0.5) * 0.09999998808295149;
                     double var12 = var6.field_1351 + (var5.field_1351 - var6.field_1351) * var9 + (this.field1730.nextDouble() - 0.5) * 0.09999998808295149;
                     double var14 = var6.field_1350 + (var5.field_1350 - var6.field_1350) * var9 + (this.field1730.nextDouble() - 0.5) * 0.09999998808295149;
                     double var16 = (this.field1730.nextDouble() - 0.5) * 0.010000003791233567;
                     double var18 = (this.field1730.nextDouble() - 0.5) * 0.010000003791233567;
                     double var20 = (this.field1730.nextDouble() - 0.5) * 0.010000003791233567;
                     this.field1644.add(new ProjectileTrails.TrailPoint(var10, var12, var14, var16, var18, var20, this.field0985.method0492().intValue()));
                  }
               }

               this.field1566.put(var4.method_5628(), var5);
            }
         }

         this.field1566.keySet().retainAll(var2);
         Iterator var22 = this.field1644.iterator();

         while (var22.hasNext()) {
            ProjectileTrails.TrailPoint var23 = var22.next();
            var23.field0956 = var23.field0565;
            var23.field0757 = var23.field0002;
            var23.field1241 = var23.field1409;
            var23.field0565 = var23.field0565 + var23.field0313;
            var23.field0002 = var23.field0002 + var23.field0176;
            var23.field1409 = var23.field1409 + var23.field0457;
            var23.field1615++;
            if (var23.field1615 >= var23.field1539) {
               var22.remove();
            }
         }
      }
   }

   private boolean method1129(class_1297 var1) {
      return var1 instanceof class_1682 || var1 instanceof class_1665;
   }

   @EventHandler
   public void onRenderWorld(GlowRenderEvent var1) {
      if (!method1974() && !this.field1644.isEmpty()) {
         class_243 var2 = field0796.field_1773.method_19418().method_19326();
         Matrix4f var3 = new class_4587().method_23760().method_23761();
         float var4 = var1.method1603();
         Color var5 = this.field0466.method1726();
         int var6 = var5.getRGB() & 16777215;

         for (ProjectileTrails.TrailPoint var8 : this.field1644) {
            float var9 = 1.0F - (float)var8.field1615 / var8.field1539;
            if (!(var9 <= 0.0F)) {
               int var10 = Math.max(0, Math.min(255, (int)(var5.getAlpha() * var9)));
               int var11 = (var10 & 0xFF) << 24 | var6;
               float var12 = (float)(method0625(var8.field0956, var8.field0565, var4) - var2.field_1352);
               float var13 = (float)(method0625(var8.field0757, var8.field0002, var4) - var2.field_1351);
               float var14 = (float)(method0625(var8.field1241, var8.field1409, var4) - var2.field_1350);
               float var15 = this.field1450.method0492() * var9;
               List var16 = new ArrayList<>();
               var16.add(this.method1556(var3, var12 - var15, var13, var14, var12 + var15, var13, var14, var11));
               var16.add(this.method1556(var3, var12, var13 - var15, var14, var12, var13 + var15, var14, var11));
               var16.add(this.method1556(var3, var12, var13, var14 - var15, var12, var13, var14 + var15, var11));
               if (this.field0184.method0492()) {
                  WorldGeometryRenderer.field0209.addAll(var16);
               } else {
                  WorldGeometryRenderer.field1508.addAll(var16);
               }
            }
         }
      }
   }

   private WorldGeometryRenderer.VertexBatch method1556(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {
      return new WorldGeometryRenderer.VertexBatch(
         new WorldGeometryRenderer.ColoredVertex(var1, var2, var3, var4, var8), new WorldGeometryRenderer.ColoredVertex(var1, var5, var6, var7, var8)
      );
   }

   private static double method0625(double var0, double var2, float var4) {
      return var0 + (var2 - var0) * var4;
   }

   private static class TrailPoint {
      double field0565;
      double field0002;
      double field1409;
      double field0956;
      double field0757;
      double field1241;
      double field0313;
      double field0176;
      double field0457;
      int field1615;
      int field1539;

      TrailPoint(double var1, double var3, double var5, double var7, double var9, double var11, int var13) {
         this.field0565 = var1;
         this.field0002 = var3;
         this.field1409 = var5;
         this.field0956 = var1;
         this.field0757 = var3;
         this.field1241 = var5;
         this.field0313 = var7;
         this.field0176 = var9;
         this.field0457 = var11;
         this.field1615 = 0;
         this.field1539 = var13;
      }
   }
}
