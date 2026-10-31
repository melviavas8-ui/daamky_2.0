package aethereal;

import com.mojang.blaze3d.platform.GlStateManager.class_4534;
import com.mojang.blaze3d.platform.GlStateManager.class_4535;
import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10142;
import net.minecraft.class_1297;
import net.minecraft.class_1306;
import net.minecraft.class_1309;
import net.minecraft.class_1542;
import net.minecraft.class_1665;
import net.minecraft.class_1667;
import net.minecraft.class_1676;
import net.minecraft.class_1680;
import net.minecraft.class_1681;
import net.minecraft.class_1683;
import net.minecraft.class_1684;
import net.minecraft.class_1685;
import net.minecraft.class_1686;
import net.minecraft.class_1753;
import net.minecraft.class_1764;
import net.minecraft.class_1771;
import net.minecraft.class_1776;
import net.minecraft.class_1779;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1823;
import net.minecraft.class_1828;
import net.minecraft.class_1835;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2678;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_3486;
import net.minecraft.class_3532;
import net.minecraft.class_3857;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_7833;
import net.minecraft.class_811;
import net.minecraft.class_9278;
import net.minecraft.class_9334;
import net.minecraft.class_239.class_240;
import net.minecraft.class_293.class_5596;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import ua.patch.daamky.api.mixins.accessors.GameRendererAccessor;

public class ProjectilePrediction extends Module {
   private static ProjectilePrediction field0103;
   private final BooleanSetting field1432 = new BooleanSetting("projectileprediction.renderhand", true)
      .method1007("Render Hand")
      .method0210("Show trajectory of your currently held item")
      .method2130("Показывать траекторию предмета в руке");
   private final BooleanSetting field0970 = new BooleanSetting("projectileprediction.handline", true, () -> this.field1432.method0492())
      .method1007("Hand Line")
      .method0210("Draw a fading line from your hand to the predicted landing spot")
      .method2130("Линия от руки до точки приземления, с фейдом");
   private final BooleanSetting field0184 = new BooleanSetting("projectileprediction.itemmarker", true, () -> this.field1432.method0492())
      .method1007("3D Item Marker")
      .method0210("Show a 3D outline of the predicted item at the landing spot instead of the ring")
      .method2130("3D-контур предмета в точке приземления вместо кольца");
   private final OutlineShaderRenderer field0465 = new OutlineShaderRenderer();
   private static final class_4588 field1651 = new class_4588() {
      public class_4588 method_22912(float var1, float var2, float var3) {
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
   };
   private static final class_4597 field1572 = var0 -> field1651;
   private final BooleanSetting field1709 = new BooleanSetting("projectileprediction.renderincoming", true)
      .method1007("Render Incoming")
      .method0210("Show trajectories of incoming projectiles")
      .method2130("Показывать траектории от игроков");
   private final BooleanSetting field1141 = new BooleanSetting("projectileprediction.render2d", true)
      .method1007("2D HUD")
      .method0210("Show 2D HUD with item icon and time-to-impact")
      .method2130("Отображать время до окончания перед выполнением");
   private final BooleanSetting field1093 = new BooleanSetting("projectileprediction.crosshair", true)
      .method1007("Crosshair Indicator")
      .method0210("Show time-to-impact indicator near crosshair")
      .method2130("Отображать время до окончания после выполнения");
   private final ColorSetting field1203 = new ColorSetting("projectileprediction.linecolor", 255, 156, 228, 200)
      .method1882()
      .method1007("Line Color")
      .method0210("Trajectory line color")
      .method2130("Цвет траектории");
   private final List<ProjectilePrediction.PathMesh> field0885 = new ArrayList<>();
   private final List<class_243> field0843 = new ArrayList<>();
   private final List<class_2350> field0928 = new ArrayList<>();
   private final List<Boolean> field1347 = new ArrayList<>();
   private final List<class_243> field1308 = new ArrayList<>();
   private final List<class_243> field1384 = new ArrayList<>();
   private boolean field0404 = false;
   private float field0351 = -1.0F;
   private class_1799 field0441 = class_1799.field_8037;
   private float field0255 = -1.0F;
   private float field0226 = 0.0F;
   private float field0289 = 0.0F;
   private String field0534 = "";
   private String field0513 = "";
   private long field0549 = 0L;
   private long field1673 = 0L;
   private static final int field1658 = 150;
   private class_1297 field1698 = null;
   private final List<ProjectilePrediction.PathPoint> field1595 = new ArrayList<>();
   private static final long field1579 = 220L;
   private static final long field1603 = 200L;
   private class_1799 field1761 = class_1799.field_8037;
   private float field1739 = -1.0F;
   private long field1767 = 0L;
   private static final class_2960 field1181 = class_2960.method_60655("daamky", "textures/glow.png");

   public static ProjectilePrediction method1716() {
      return field0103;
   }

   public ProjectilePrediction() {
      super("ProjectilePrediction", ModuleCategory.field1004, "Predicts projectile trajectories (incoming + hand item)");
      this.method1013("Предсказывает траектории падающих предметов");
      field0103 = this;
   }

   private ProjectilePrediction.ProjectilePath method1747() {
      return field0796.field_1724 == null
         ? new ProjectilePrediction.ProjectilePath(0.0F, 0.0F)
         : new ProjectilePrediction.ProjectilePath(field0796.field_1724.method_36454(), field0796.field_1724.method_36455());
   }

   private Stream<class_1297> method2026() {
      return field0796.field_1687 == null ? Stream.empty() : StreamSupport.stream(field0796.field_1687.method_18112().spliterator(), false);
   }

   public List<class_239> method1199(class_1676 var1, double var2, ProjectilePrediction.ProjectilePath var4) {
      return new ArrayList<>(Collections.singletonList(this.method1323(var4.method2077(), var1, var2)));
   }

   public class_239 method1323(class_243 var1, class_1676 var2, double var3) {
      float var5 = class_3532.method_15355((float)var1.method_1027());
      class_243 var6;
      if (var2 instanceof class_1667 var7 && var7.method_54759().method_7909().equals(class_1802.field_8399)) {
         var6 = class_243.field_1353;
      } else {
         var6 = field0796.field_1724.method_18798();
      }

      return this.method1335(
         field0796.field_1724.method_33571().method_1019(MathHelper.method1127(field0796.field_1724).method_1020(field0796.field_1724.method_19538())),
         var1.method_1021(var3 / var5).method_1019(var6),
         var2
      );
   }

   public class_239 method1198(class_1676 var1) {
      return this.method1335(var1.method_19538(), var1.method_18798(), var1);
   }

   public class_239 method1335(class_243 var1, class_243 var2, class_1676 var3) {
      this.field1384.clear();
      this.field1384.add(var1);

      for (int var5 = 0; var5 < 300; var5++) {
         class_243 var4 = var1;
         var1 = var1.method_1019(var2);
         var2 = this.method1147(var3, var4, var2);
         class_239 var6 = field0796.field_1687.method_17742(new class_3959(var4, var1, class_3960.field_17558, class_242.field_1348, var3));
         if (!var6.method_17783().equals(class_240.field_1333)) {
            this.field1384.add(var6.method_17784());
            return var6;
         }

         class_243 var7 = var1;
         class_243 var8 = var4;
         boolean var9 = this.method2026()
            .filter(var1x -> var1x instanceof class_1309 var2 && var2 != var3.method_24921() && var2.method_5805())
            .anyMatch(var3x -> this.method1293(var3x.method_5829().method_1014(0.3000001804584443), var8, var7));
         if (var9) {
            this.field1384.add(var1);
            return new class_239(var1) {
               public class_240 method_17783() {
                  return class_240.field_1331;
               }
            };
         }

         this.field1384.add(var1);
         if (var1.field_1351 < -128.0) {
            break;
         }
      }

      return null;
   }

   private boolean method1293(class_238 var1, class_243 var2, class_243 var3) {
      double var4 = Math.min(var2.field_1352, var3.field_1352) - 0.010000003747132445;
      double var6 = Math.min(var2.field_1351, var3.field_1351) - 0.010000003747132445;
      double var8 = Math.min(var2.field_1350, var3.field_1350) - 0.010000003747132445;
      double var10 = Math.max(var2.field_1352, var3.field_1352) + 0.010000003747132445;
      double var12 = Math.max(var2.field_1351, var3.field_1351) + 0.010000003747132445;
      double var14 = Math.max(var2.field_1350, var3.field_1350) + 0.010000003747132445;
      return var10 >= var1.field_1323
         && var4 <= var1.field_1320
         && var12 >= var1.field_1322
         && var6 <= var1.field_1325
         && var14 >= var1.field_1321
         && var8 <= var1.field_1324;
   }

   private void method2015() {
      try {
         class_243 var1 = field0796.field_1773.method_19418().method_19326();
         Color var2 = this.field1203.method1726();
         this.field0465.method0578();
         class_4597 var3 = this.field0465.method1517(field1572, var2);
         float var4 = (float)(System.currentTimeMillis() % 3600L) / 10.0F;

         for (int var5 = 0; var5 < this.field0843.size(); var5++) {
            class_243 var6 = this.field0843.get(var5);
            class_4587 var7 = new class_4587();
            var7.method_22904(var6.field_1352 - var1.field_1352, var6.field_1351 - var1.field_1351 + 0.2800001835305881, var6.field_1350 - var1.field_1350);
            var7.method_22905(0.7F, 0.7F, 0.7F);
            var7.method_22907(class_7833.field_40716.rotationDegrees(var4));
            ((GameRendererAccessor)field0796.field_1773)
               .getFirstPersonRenderer()
               .method_3233(field0796.field_1724, this.field0441, class_811.field_4318, false, var7, var3, 15728880);
         }

         this.field0465.method2058().method0578();
         this.field0465.method0764(1, var2, false, false, 0.0F, 0.0F, 0.0F, var2, false, 0.0F, 0.0F, 0.0F, var2, false, 0.0F, 0.0F, var2);
      } catch (Exception var8) {
      }
   }

   @EventHandler
   public void onGlowPass(GlowRenderEvent.Pre var1) {
      if (!method1974()) {
         if (this.field0184.method0492() && this.field1432.method0492() && !this.field0843.isEmpty() && !this.field0441.method_7960()) {
            this.method2015();
         }

         if (!this.field0843.isEmpty() || !this.field0885.isEmpty()) {
            class_243 var2 = field0796.field_1773.method_19418().method_19326();
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(770, 32772);
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.disableCull();
            RenderSystem.setShaderTexture(0, field1181);
            RenderSystem.setShader(class_10142.field_53880);
            class_287 var3 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1575);
            Matrix4f var4 = new Matrix4f();
            Color var5 = this.field1203.method1726();
            int[] var6 = new int[]{0};
            class_4184 var7 = field0796.field_1773.method_19418();
            float var8 = (float)Math.toRadians(-var7.method_19330());
            float var9 = (float)Math.toRadians(var7.method_19329());
            float var10 = (float)Math.cos(var8);
            float var11 = (float)Math.sin(var8);
            float var12 = (float)Math.cos(var9);
            float var13 = (float)Math.sin(var9);
            float var14 = var10;
            float var15 = 0.0F;
            float var16 = -var11;
            float var17 = var11 * var13;
            float var18 = var12;
            float var19 = var10 * var13;

            for (int var20 = 0; var20 < this.field0843.size(); var20++) {
               class_243 var21 = this.field0843.get(var20);
               class_2350 var22 = this.field0928.get(var20);
               if (this.field0404) {
                  var6[0] += this.method1386(var3, var4, var21, var22, var2, 2.0F, var5, 180, var14, var15, var16, var17, var18, var19);
               }
            }

            for (ProjectilePrediction.PathMesh var26 : this.field0885) {
               class_1297 var27 = var26.entity instanceof class_1676 var23 ? var23.method_24921() : null;
               boolean var28 = var27 == field0796.field_1724;
               if (!var28 && var26.isPotion) {
                  var6[0] += this.method1386(var3, var4, var26.pos, var26.facing, var2, 4.0F, var5, 180, var14, var15, var16, var17, var18, var19);
               }
            }

            if (var6[0] > 0) {
               class_286.method_43433(var3.method_60800());
            } else {
               var3.method_60794();
            }

            RenderSystem.setShaderTexture(0, 0);
            RenderSystem.enableCull();
            RenderSystem.depthMask(true);
            RenderSystem.blendFuncSeparate(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA, class_4535.ZERO, class_4534.ONE);
            RenderSystem.disableBlend();
         }
      }
   }

   private void method1506(class_4587 var1, class_243 var2, class_2350 var3, Color var4) {
      class_243 var5;
      class_243 var6;
      switch (var3) {
         case field_11043:
         case field_11035:
            var5 = new class_243(1.0, 0.0, 0.0);
            var6 = new class_243(0.0, 1.0, 0.0);
            break;
         case field_11039:
         case field_11034:
            var5 = new class_243(0.0, 0.0, 1.0);
            var6 = new class_243(0.0, 1.0, 0.0);
            break;
         default:
            var5 = new class_243(1.0, 0.0, 0.0);
            var6 = new class_243(0.0, 0.0, 1.0);
      }

      double var7 = 0.3000001804584443;
      double var9 = 0.015000000495704477;
      class_243 var11 = new class_243(
         var2.field_1352 + var3.method_10148() * var9, var2.field_1351 + var3.method_10164() * var9, var2.field_1350 + var3.method_10165() * var9
      );
      int var12 = 90;

      for (int var13 = 0; var13 < var12; var13++) {
         double var14 = 6.283185314844992 * var13 / var12;
         double var16 = 6.283185314844992 * (var13 + 1) / var12;
         class_243 var18 = var11.method_1019(var5.method_1021(Math.cos(var14) * var7)).method_1019(var6.method_1021(Math.sin(var14) * var7));
         class_243 var19 = var11.method_1019(var5.method_1021(Math.cos(var16) * var7)).method_1019(var6.method_1021(Math.sin(var16) * var7));
         WorldRenderHelper.method1507(var1, var18, var19, var4);
      }

      WorldRenderHelper.method1507(var1, var11.method_1020(var5.method_1021(var7)), var11.method_1019(var5.method_1021(var7)), var4);
      WorldRenderHelper.method1507(var1, var11.method_1020(var6.method_1021(var7)), var11.method_1019(var6.method_1021(var7)), var4);
   }

   private void method1382(
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
      Color var13,
      int var14
   ) {
      int var15 = var13.getRed();
      int var16 = var13.getGreen();
      int var17 = var13.getBlue();
      float var18 = var7 * var6;
      float var19 = var8 * var6;
      float var20 = var9 * var6;
      float var21 = var10 * var6;
      float var22 = var11 * var6;
      float var23 = var12 * var6;
      var1.method_22918(var2, var3 - var18 - var21, var4 - var19 - var22, var5 - var20 - var23)
         .method_22913(0.0F, 1.0F)
         .method_1336(var15, var16, var17, var14);
      var1.method_22918(var2, var3 + var18 - var21, var4 + var19 - var22, var5 + var20 - var23)
         .method_22913(1.0F, 1.0F)
         .method_1336(var15, var16, var17, var14);
      var1.method_22918(var2, var3 + var18 + var21, var4 + var19 + var22, var5 + var20 + var23)
         .method_22913(1.0F, 0.0F)
         .method_1336(var15, var16, var17, var14);
      var1.method_22918(var2, var3 - var18 + var21, var4 - var19 + var22, var5 - var20 + var23)
         .method_22913(0.0F, 0.0F)
         .method_1336(var15, var16, var17, var14);
   }

   private int method1386(
      class_287 var1,
      Matrix4f var2,
      class_243 var3,
      class_2350 var4,
      class_243 var5,
      float var6,
      Color var7,
      int var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14
   ) {
      float var15 = (float)(var3.field_1352 - var5.field_1352);
      float var16 = (float)(var3.field_1351 - var5.field_1351) + 1.0F;
      float var17 = (float)(var3.field_1350 - var5.field_1350);
      int var18 = 96;
      float var19 = (float)(6.283185314844992 * var6 / var18);
      float var20 = var19 * 2.0F;

      for (int var21 = 0; var21 < var18; var21++) {
         double var22 = 6.283185314844992 * var21 / var18;
         float var24 = var15 + (float)Math.cos(var22) * var6;
         float var25 = var16;
         float var26 = var17 + (float)Math.sin(var22) * var6;
         this.method1382(var1, var2, var24, var25, var26, var20, var9, var10, var11, var12, var13, var14, var7, var8);
      }

      return var18 * 4;
   }

   @EventHandler
   public void onPacketReceive(PacketEvent.Inbound var1) {
      if (var1.method1970() instanceof class_2678) {
         this.method2043();
      }
   }

   private void method2043() {
      this.field0885.clear();
      this.field0843.clear();
      this.field0928.clear();
      this.field1347.clear();
      this.field0404 = false;
      this.field0351 = -1.0F;
      this.field0441 = class_1799.field_8037;
      this.field0255 = -1.0F;
      this.field1698 = null;
      this.field1595.clear();
      this.field1761 = class_1799.field_8037;
      this.field1739 = -1.0F;
      this.field1767 = 0L;
      this.field0226 = 0.0F;
      this.field0289 = 0.0F;
      this.field0534 = "";
      this.field0513 = "";
      this.field0549 = 0L;
      this.field1673 = 0L;
   }

   @EventHandler
   public void onWorldRender(WorldRenderEvent.GamePass var1) {
      if (!method1974()) {
         this.field0885.clear();
         this.field0843.clear();
         this.field0928.clear();
         this.field1347.clear();
         this.field1308.clear();
         this.field0404 = false;
         this.field0351 = -1.0F;
         this.field0441 = class_1799.field_8037;
         this.field0255 = -1.0F;
         Color var2 = this.field1203.method1726();
         int var3 = var2.getRGB();
         if (this.field1432.method0492()) {
            this.method1495(var1.method1629(), field0796.field_1724.method_5877(), this.method1747());
         }

         long var4 = System.currentTimeMillis();

         for (ProjectilePrediction.PathPoint var7 : this.field1595) {
            if (var7.field1244 == 0L && (var7.field0730.method_31481() || !var7.field0730.method_5805() || var7.field0730.field_6012 > 200)) {
               var7.method1634();
            }
         }

         this.field1595.removeIf(var2x -> var2x.method0161(var4));

         for (class_1297 var18 : this.method1689()) {
            if (var18 instanceof class_1676 var8 && var8.method_24921() == field0796.field_1724 && var18.field_6012 < 40) {
               boolean var9 = false;

               for (ProjectilePrediction.PathPoint var11 : this.field1595) {
                  if (var11.method0563() == var18) {
                     var9 = true;
                     break;
                  }
               }

               if (!var9) {
                  ProjectilePrediction.HitResult var28 = this.method0292(var18.method_19538(), var18.method_18798(), var8);
                  if (var28 != null) {
                     class_1799 var31 = class_1799.field_8037;
                     if (var18 instanceof class_3857 var12) {
                        var31 = var12.method_7495();
                     } else if (var18 instanceof class_1665 var13) {
                        var31 = var13.method_54759();
                     } else if (var18 instanceof class_1542 var14) {
                        var31 = var14.method_6983();
                     }

                     if (!var31.method_7960()) {
                        this.field1595.add(new ProjectilePrediction.PathPoint(var18, var28.method0568().method_17784(), var28.method0003(), var31));
                     }
                  }
               }
            }
         }

         this.field1698 = this.field1595.isEmpty() ? null : this.field1595.get(0).method0563();
         if (this.field1709.method0492()) {
            for (class_1297 var19 : this.method1689()) {
               class_243 var21 = var19.method_18798();
               class_243 var25 = var19.method_19538();

               for (int var32 = 0; var32 < 300; var32++) {
                  class_243 var29 = var25;
                  var25 = var25.method_1019(var21);
                  var21 = this.method1147(var19, var29, var21);
                  class_239 var34 = field0796.field_1687.method_17742(new class_3959(var29, var25, class_3960.field_17558, class_242.field_1348, var19));
                  if (!var34.method_17783().equals(class_240.field_1333)) {
                     var25 = var34.method_17784();
                  }

                  int var36 = (int)(255.0F * class_3532.method_15363(var32 / 25.0F, 0.0F, 1.0F));
                  int var37 = ColorMath.method1828(var3, var36 / 255.0F);
                  WorldRenderHelper.method1507(var1.method1629(), var29, var25, new Color(var37, true));
                  if (!var34.method_17783().equals(class_240.field_1333) || var25.field_1351 < -128.0) {
                     this.method1146(var19, var25, var32, var34);
                     break;
                  }
               }
            }
         }

         Color var17 = this.field1203.method1726();
         Color var20 = Color.RED;
         if (!this.field0184.method0492()) {
            for (int var22 = 0; var22 < this.field0843.size(); var22++) {
               boolean var26 = var22 < this.field1347.size() && this.field1347.get(var22);
               this.method1506(var1.method1629(), this.field0843.get(var22), this.field0928.get(var22), var26 ? var20 : var17);
            }
         }

         if (this.field1432.method0492() && this.field0970.method0492() && this.field1308.size() >= 2) {
            boolean var23 = !this.field1347.isEmpty() && this.field1347.get(this.field1347.size() - 1);
            this.method1503(var1.method1629(), this.method0470(), this.field1308, var23 ? var20 : var17);
         }

         for (ProjectilePrediction.PathMesh var27 : this.field0885) {
            class_1297 var30 = var27.entity instanceof class_1676 var33 ? var33.method_24921() : null;
            if (var30 != field0796.field_1724) {
               this.method1506(var1.method1629(), var27.pos, var27.facing, var27.isEntityHit ? var20 : var17);
            }
         }
      }
   }

   private class_243 method0470() {
      class_4184 var1 = field0796.field_1773.method_19418();
      class_243 var2 = var1.method_19326();
      double var3 = Math.toRadians(var1.method_19330());
      double var5 = Math.toRadians(var1.method_19329());
      class_243 var7 = new class_243(-Math.sin(var3) * Math.cos(var5), -Math.sin(var5), Math.cos(var3) * Math.cos(var5));
      class_243 var8 = new class_243(-var7.field_1350, 0.0, var7.field_1352);
      if (var8.method_1027() < 1.0000000010018248E-6) {
         var8 = new class_243(1.0, 0.0, 0.0);
      } else {
         var8 = var8.method_1029();
      }

      class_243 var9 = var8.method_1036(var7).method_1029();
      double var10 = field0796.field_1690.method_42552().method_41753() == class_1306.field_6182 ? -1.0 : 1.0;
      return var2.method_1019(var8.method_1021(0.32000000096362474 * var10))
         .method_1019(var9.method_1021(-0.16000005268583464))
         .method_1019(var7.method_1021(0.44999991806726064));
   }

   private void method1503(class_4587 var1, class_243 var2, List<class_243> var3, Color var4) {
      int var5 = var3.size();
      if (var5 >= 2) {
         int var6 = var4.getRGB();
         float var7 = var4.getAlpha() / 255.0F;
         class_243 var8 = var2.method_1020(var3.get(0));
         int var9 = Math.max(2, (int)(var5 * 0.44999991806726064));
         class_243 var10 = null;

         for (int var11 = 0; var11 < var5; var11++) {
            float var12 = var11 >= var9 ? 0.0F : 1.0F - (float)var11 / var9;
            float var13 = var12 * var12 * (3.0F - 2.0F * var12);
            class_243 var14 = var3.get(var11).method_1019(var8.method_1021(var13));
            if (var10 != null) {
               float var15 = (float)var11 / (var5 - 1);
               float var16 = class_3532.method_15363(var15 / 0.3F, 0.0F, 1.0F);
               int var17 = ColorMath.method1828(var6, var7 * var16);
               WorldRenderHelper.method1507(var1, var10, var14, new Color(var17, true));
            }

            var10 = var14;
         }
      }
   }

   private void method1495(class_4587 var1, Iterable<class_1799> var2, ProjectilePrediction.ProjectilePath var3) {
      if (field0796.field_1724 != null) {
         class_1792 var4 = field0796.field_1724.method_6030().method_7909();
         Iterator var5 = var2.iterator();
         if (var5.hasNext()) {
            class_1799 var6 = (class_1799)var5.next();
            List var7 = null;
            class_1792 var8 = var6.method_7909();
            if (var8 instanceof class_1779) {
               var7 = this.method1199(new class_1683(field0796.field_1687, field0796.field_1724, var6), 0.7999999493743812, var3);
            } else if (var8 instanceof class_1828) {
               var7 = this.method1199(new class_1686(field0796.field_1687, field0796.field_1724, var6), 0.5500000601931105, var3);
            } else if (var8 instanceof class_1835 && var8.equals(var4) && field0796.field_1724.method_6048() >= 10) {
               var7 = this.method1199(new class_1685(field0796.field_1687, field0796.field_1724, var6), 2.5, var3);
            } else if (var8 instanceof class_1823) {
               var7 = this.method1199(new class_1680(field0796.field_1687, field0796.field_1724, var6), 1.5, var3);
            } else if (var8 instanceof class_1771) {
               var7 = this.method1199(new class_1681(field0796.field_1687, field0796.field_1724, var6), 1.5, var3);
            } else if (var8 instanceof class_1776) {
               var7 = this.method1199(new class_1684(field0796.field_1687, field0796.field_1724, var6), 1.5, var3);
            } else if (var8 instanceof class_1753 && var8.equals(var4) && field0796.field_1724.method_6115()) {
               float var18 = field0796.method_61966() != null ? field0796.method_61966().method_60637(false) : 0.0F;
               float var20 = 3.0F * class_3532.method_15363((field0796.field_1724.method_6048() + var18) / 20.0F, 0.0F, 1.0F);
               var7 = this.method1199(new class_1667(field0796.field_1687, field0796.field_1724, var6, var6), var20, var3);
            } else if (var8 instanceof class_1764 && class_1764.method_7781(var6)) {
               class_9278 var9 = (class_9278)var6.method_57824(class_9334.field_49649);
               List var10 = new ArrayList<>();
               if (var9 != null && !var9.method_57437().isEmpty()) {
                  float var11 = ((class_1799)var9.method_57437().getFirst()).method_31574(class_1802.field_8639) ? 100.0F : 3.0F;
                  var10.add(this.method1323(var3.method2077(), new class_1667(field0796.field_1687, field0796.field_1724, var6, var6), var11));
                  if (var9.method_57437().size() > 2) {
                     float var12 = var3.method0002() / 90.0F;
                     float var13 = var12 * var12 * var12 * var12 * var12;
                     float var14 = class_3532.method_48781(Math.abs(var13), 10, 90);
                     float var15 = class_3532.method_48781(var13, 0, 10);
                     var10.add(
                        this.method1323(
                           var3.method0659(-var14).method0123(-var15).method2077(),
                           new class_1667(field0796.field_1687, field0796.field_1724, var6, var6),
                           var11
                        )
                     );
                     var10.add(
                        this.method1323(
                           var3.method0659(var14).method0123(-var15).method2077(),
                           new class_1667(field0796.field_1687, field0796.field_1724, var6, var6),
                           var11
                        )
                     );
                  }
               }

               var7 = var10;
            }

            if (var7 != null) {
               var7 = var7.stream().filter(Objects::nonNull).toList();
               if (!var7.isEmpty()) {
                  this.method1496(var1, var7);
                  this.field1308.clear();
                  this.field1308.addAll(this.field1384);
                  if (var8 instanceof class_1828) {
                     this.field0404 = true;
                  }

                  this.field0441 = var6;
                  class_243 var19 = var3.method2077();
                  double var21 = this.method1234(var8, var6, var4);
                  if (var21 > 0.0) {
                     float var22 = class_3532.method_15355((float)var19.method_1027());
                     class_243 var23 = var19.method_1021(var21 / var22).method_1019(field0796.field_1724.method_18798());
                     class_1676 var24 = this.method1232(var8, var6);
                     if (var24 != null) {
                        ProjectilePrediction.HitResult var25 = this.method0292(
                           field0796.field_1724
                              .method_33571()
                              .method_1019(MathHelper.method1127(field0796.field_1724).method_1020(field0796.field_1724.method_19538())),
                           var23,
                           var24
                        );
                        if (var25 != null) {
                           this.field0441 = var6;
                           float var16 = field0796.method_61966() != null ? field0796.method_61966().method_60637(false) : 0.0F;
                           this.field0255 = Math.max(0.0F, (var25.ticks - var16) * 0.05F);
                           this.field0351 = this.field0255;
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private void method1496(class_4587 var1, List<class_239> var2) {
      for (class_239 var4 : var2) {
         class_2350 var5 = this.method1294(var4);
         this.field0843.add(var4.method_17784());
         this.field0928.add(var5);
         this.field1347.add(var4.method_17783() == class_240.field_1331);
      }
   }

   private void method0336(class_4587 var1, class_243 var2, class_2350 var3, Color var4) {
      float var5 = 0.015F;
      class_243 var6 = var2.method_1031(var3.method_10148() * var5, var3.method_10164() * var5, var3.method_10165() * var5);

      Quaternionf var7 = switch (var3) {
         case field_11043, field_11035 -> class_7833.field_40714.rotationDegrees(90.0F);
         case field_11039, field_11034 -> class_7833.field_40718.rotationDegrees(90.0F);
         default -> new Quaternionf();
      };
      float var8 = 0.15F;
      float var9 = 0.18F;
      float var10 = 0.06F;
      var1.method_22903();
      var1.method_22904(var6.field_1352, var6.field_1351, var6.field_1350);
      var1.method_22907(var7);
      this.method1463(var1, var9, var9 + var8, 0.0F, 0.0F, var10, var4);
      this.method1463(var1, -var9, -(var9 + var8), 0.0F, 0.0F, var10, var4);
      this.method1463(var1, 0.0F, 0.0F, var9, var9 + var8, var10, var4);
      this.method1463(var1, 0.0F, 0.0F, -var9, -(var9 + var8), var10, var4);
      var1.method_22909();
   }

   private void method1463(class_4587 var1, float var2, float var3, float var4, float var5, float var6, Color var7) {
      float var8 = var3 - var2;
      float var9 = var5 - var4;
      float var10 = (float)Math.sqrt(var8 * var8 + var9 * var9);
      if (!(var10 < 0.001F)) {
         float var11 = -var9 / var10;
         float var12 = var8 / var10;
         class_243 var13 = new class_243(var3, 0.0, var5);
         class_243 var14 = new class_243(var2 + var11 * var6, 0.0, var4 + var12 * var6);
         class_243 var15 = new class_243(var2 - var11 * var6, 0.0, var4 - var12 * var6);
         WorldRenderHelper.method0337(var1, var13, var14, var7);
         WorldRenderHelper.method0337(var1, var14, var15, var7);
         WorldRenderHelper.method0337(var1, var15, var13, var7);
      }
   }

   private Quaternionf method1280(class_2350 var1) {
      return switch (var1) {
         case field_11043, field_11035 -> class_7833.field_40714.rotationDegrees(90.0F);
         case field_11039, field_11034 -> class_7833.field_40718.rotationDegrees(90.0F);
         default -> new Quaternionf();
      };
   }

   private void method1505(class_4587 var1, class_243 var2, class_2350 var3, float var4, Color var5) {
      var1.method_22903();
      var1.method_22904(var2.field_1352, var2.field_1351 + 0.02000001037642601, var2.field_1350);
      var1.method_22907(this.method1280(var3));
      int var6 = 48;

      for (int var7 = 0; var7 < var6; var7++) {
         double var8 = 6.283185314844992 * var7 / var6;
         double var10 = 6.283185314844992 * (var7 + 1) / var6;
         class_243 var12 = new class_243(Math.cos(var8) * var4, 0.0, -Math.sin(var8) * var4);
         class_243 var13 = new class_243(Math.cos(var10) * var4, 0.0, -Math.sin(var10) * var4);
         WorldRenderHelper.method0337(var1, var12, var13, var5);
      }

      var1.method_22909();
   }

   @EventHandler
   public void onRender2D(HudRenderEvent var1) {
      if (!method1974()) {
         class_332 var2 = var1.method1806();
         class_4587 var3 = var2.method_51448();
         if (this.field1141.method0492()) {
            class_4184 var4 = field0796.field_1773.method_19418();
            class_243 var5 = var4.method_19326();
            float var6 = (float)Math.toRadians(var4.method_19330());
            float var7 = (float)Math.toRadians(var4.method_19329());
            double var8 = Math.cos(var7);
            double var10 = -Math.sin(var6) * var8;
            double var12 = -Math.sin(var7);
            double var14 = Math.cos(var6) * var8;
            float var16 = ScreenLayoutHelper.method2047();
            float var17 = ScreenLayoutHelper.method1762();
            float var18 = var16 / 2.0F;
            float var19 = var17 / 2.0F;
            float var20 = 30.0F;
            GuiRenderHelper.method0578();

            try {
               String var21 = field0796.field_1724 != null ? field0796.field_1724.method_5477().getString() : null;
               float var22 = field0796.method_61966() != null ? field0796.method_61966().method_60637(false) : 0.0F;
               long var23 = System.currentTimeMillis();

               for (ProjectilePrediction.PathPoint var26 : this.field1595) {
                  class_1297 var27 = var26.method0563();
                  float var28 = var26.method0774(var23);
                  if (!(var28 < 0.01F)) {
                     float var29 = Math.max(0.0F, (var26.method2048() - var27.field_6012 - var22) * 0.05F);
                     this.method1443(
                        var2, var3, var26.method0024(), var26.method1801(), var21, var29, var28, var5, var10, var12, var14, var16, var17, var18, var19, var20
                     );
                  }
               }

               for (ProjectilePrediction.PathMesh var34 : this.field0885) {
                  class_1297 var35 = var34.entity instanceof class_1676 var36 ? var36.method_24921() : null;
                  if (var35 != field0796.field_1724) {
                     String var37 = null;
                     if (var35 instanceof class_1309 var39 && !var35.method_5767()) {
                        var37 = var39.method_5477().getString();
                     }

                     this.method1443(
                        var2, var3, var34.pos, var34.stack, var37, var34.remainingTime, 1.0F, var5, var10, var12, var14, var16, var17, var18, var19, var20
                     );
                  }
               }
            } finally {
               GuiRenderHelper.method0025();
            }
         }

         if (this.field1093.method0492()) {
            this.method1432(var2, var3);
         }
      }
   }

   private void method1443(
      class_332 var1,
      class_4587 var2,
      class_243 var3,
      class_1799 var4,
      String var5,
      float var6,
      float var7,
      class_243 var8,
      double var9,
      double var11,
      double var13,
      float var15,
      float var16,
      float var17,
      float var18,
      float var19
   ) {
      double var20 = var3.field_1352 - var8.field_1352;
      double var22 = var3.field_1351 - var8.field_1351;
      double var24 = var3.field_1350 - var8.field_1350;
      double var26 = var20 * var9 + var22 * var11 + var24 * var13;
      class_243 var28 = ProjectionHelper.method1299(var3);
      float var29 = (float)var28.field_1352;
      float var30 = (float)var28.field_1351;
      if (var26 <= 0.0) {
         var29 = 2.0F * var17 - var29;
         var30 = 2.0F * var18 - var30;
      }

      boolean var31 = var26 > 0.0 && var29 >= 0.0F && var29 <= var15 && var30 >= 0.0F && var30 <= var16;
      if (!var31) {
         float var32 = var29 - var17;
         float var33 = var30 - var18;
         float var34 = (float)Math.sqrt(var32 * var32 + var33 * var33);
         if (var34 < 0.001F) {
            var32 = 0.0F;
            var33 = -1.0F;
         } else {
            var32 /= var34;
            var33 /= var34;
         }

         float var35 = var17 - var19;
         float var36 = var18 - var19;
         float var37 = Math.abs(var32) > 0.001F ? var35 / Math.abs(var32) : Float.POSITIVE_INFINITY;
         float var38 = Math.abs(var33) > 0.001F ? var36 / Math.abs(var33) : Float.POSITIVE_INFINITY;
         float var39 = Math.min(var37, var38);
         var29 = var17 + var32 * var39;
         var30 = var18 + var33 * var39;
      }

      float var41 = 0.9116279F;
      this.method1442(var1, var2, var4, var5, var6, var29, var30, var41, var7);
   }

   private static Color method0964(Color var0, float var1) {
      int var2 = Math.max(0, Math.min(255, (int)(var0.getAlpha() * var1)));
      return new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), var2);
   }

   private void method1442(class_332 var1, class_4587 var2, class_1799 var3, String var4, float var5, float var6, float var7, float var8, float var9) {
      FontSize var10 = Fonts.field0075.method0654(6.0F);
      float var11 = 3.0F;
      float var12 = 6.0F;
      float var13 = 4.0F;
      float var14 = 5.0F;
      float var15 = 7.0F;
      float var16 = 9.0F;
      String var17 = String.format("%.1f", Math.max(0.0F, var5)) + "s";
      boolean var18 = var4 != null && !var4.isEmpty();
      float var19 = var18 ? var10.method0998(var4) : 0.0F;
      float var20 = var10.method0998(var17);
      float var21 = var13 + var16 + var14 + 1.0F + var14 + var20;
      if (var18) {
         var21 += var14 + 1.0F + var14 + var19;
      }

      var21 += var13;
      float var22 = var10.method0530() + var11 * 2.5F;
      float var23 = var21;
      float var24 = -var23 / 2.0F;
      float var25 = -var22;
      float var26 = ThemePalette.field0367.get();
      var2.method_22903();
      var2.method_46416(var6, var7 - 4.0F, 0.0F);
      float var27 = 0.55F + 0.45F * var9;
      var2.method_22905(var8 * var27, var8 * var27, 1.0F);
      Color var28 = method0964(ThemePalette.field0930.get(), var9);
      Color var29 = method0964(ThemePalette.field1564, var9);
      Color var30 = method0964(new Color(227, 227, 227), var9);
      Color var31 = method0964(new Color(255, 255, 255, 184), var9);
      Color var32 = method0964(new Color(255, 255, 255, 80), var9);
      GuiRenderHelper.method1462(var2, var24, var25, var23, var22, var12, var26, method0964(new Color(255, 255, 255), var9));
      GuiRenderHelper.method1463(var2, var24, var25, var23, var22, var12, var28);
      GuiRenderHelper.method1461(var2, var24, var25, var23, var22, var12, 0.5F, 0.5F, var29);
      float var33 = var25 + var22 / 2.0F;
      float var34 = var33 - var10.method0530() / 2.0F;
      float var35 = var33 - var15 / 2.0F;
      float var36 = var24 + var13;
      var2.method_22903();
      var2.method_46416(var36, var33 - var16 / 2.0F, 200.0F);
      float var37 = var16 / 16.0F;
      var2.method_22905(var37, var37, 1.0F);
      RenderSystem.enableBlend();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var9);
      var1.method_51427(var3, 0, 0);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      var2.method_22909();
      var36 += var16;
      if (var18) {
         var36 += var14;
         GuiRenderHelper.method0326(var2, var36, var35, 1.0F, var15, 1.0F, var32);
         var36 += 1.0F + var14;
         GuiRenderHelper.method1491(var2, var10, var4, var36, var34, var30);
         var36 += var19;
      }

      var36 += var14;
      GuiRenderHelper.method0326(var2, var36, var35, 1.0F, var15, 1.0F, var32);
      var36 += 1.0F + var14;
      GuiRenderHelper.method1491(var2, var10, var17, var36, var34, var31);
      var2.method_22909();
   }

   private void method1432(class_332 var1, class_4587 var2) {
      long var3 = System.currentTimeMillis();
      float var5 = this.field1673 == 0L ? 0.016F : (float)(var3 - this.field1673) / 1000.0F;
      this.field1673 = var3;
      var5 = Math.min(var5, 0.1F);
      class_1799 var6 = this.field0441;
      float var7 = this.field0255;
      if (var6.method_7960() && this.field1698 != null) {
         class_1297 var8 = this.field1698;
         if (var8 instanceof class_1676 var9 && var8.method_5805() && !var8.method_31481()) {
            ProjectilePrediction.HitResult var10 = this.method0292(var8.method_19538(), var8.method_18798(), var9);
            float var11 = field0796.method_61966() != null ? field0796.method_61966().method_60637(false) : 0.0F;
            if (var10 != null) {
               var7 = Math.max(0.0F, (var10.ticks - var11) * 0.05F);
            } else {
               var7 = 0.0F;
            }

            if (var8 instanceof class_3857 var12) {
               var6 = var12.method_7495();
            } else if (var8 instanceof class_1665 var13) {
               var6 = var13.method_54759();
            }
         }
      }

      if (!var6.method_7960() && var7 >= 0.0F) {
         this.field1761 = var6;
         this.field1739 = var7;
         this.field1767 = var3;
      } else if (var3 - this.field1767 < 400L && !this.field1761.method_7960()) {
         float var55 = (float)(var3 - this.field1767) / 1000.0F;
         var6 = this.field1761;
         var7 = Math.max(0.0F, this.field1739 - var55);
      }

      boolean var56 = var7 >= 0.0F && !var6.method_7960();
      float var57 = var56 ? 1.0F : 0.0F;
      float var58 = var5 / 0.25F;
      this.field0226 = this.field0226 + Math.signum(var57 - this.field0226) * Math.min(Math.abs(var57 - this.field0226), var58);
      if (this.field0226 < 0.01F && !var56) {
         this.field0226 = 0.0F;
      } else {
         float var59 = this.field0226;
         String var60 = String.format("%.1f", Math.max(0.0F, var7));
         if (!var60.equals(this.field0513)) {
            this.field0534 = this.field0513;
            this.field0513 = var60;
            this.field0549 = System.currentTimeMillis();
         }

         FontSize var61 = Fonts.field0075.method0654(6.5F);
         FontSize var14 = Fonts.field0075.method0654(6.5F);
         float var15 = 10.0F;
         float var16 = 7.0F;
         float var17 = 6.0F;
         float var18 = 5.0F;
         String var19 = "s";
         float var20 = var61.method0998(this.field0513);
         float var21 = var14.method0998(var19);
         float var22 = var15 + var18 + 1.0F + var18 + var20 + var21;
         float var23 = var17 + var22 + var17;
         float var24 = 18.0F;
         float var25 = var23;
         float var26 = var5 / 0.15F * Math.abs(var25 - this.field0289);
         this.field0289 = this.field0289 + Math.signum(var25 - this.field0289) * Math.min(Math.abs(var25 - this.field0289), var26);
         if (Math.abs(var25 - this.field0289) < 0.5F) {
            this.field0289 = var25;
         }

         float var27 = this.field0289 * var59;
         float var28 = ScreenLayoutHelper.method2047() / 2.0F;
         float var29 = ScreenLayoutHelper.method1762() / 2.0F;
         float var30 = var28 + 10.0F;
         float var31 = var29 - var24 / 2.0F;
         Color var32 = ThemeColorManager.method1908().method0141(224);
         Color var33 = new Color(var32.getRed(), var32.getGreen(), var32.getBlue(), (int)(var32.getAlpha() * var59));
         Color var34 = new Color(255, 255, 255, (int)(255.0F * var59));
         Color var35 = new Color(255, 255, 255, (int)(184.0F * var59));
         Color var36 = new Color(255, 255, 255, (int)(80.0F * var59));
         float var37 = Math.max(0.3F, var59);
         float var38 = Math.max(0.3F, var59 * var59);
         float var39 = var30 + var27 / 2.0F;
         float var40 = var31 + var24 / 2.0F;
         var2.method_22903();
         var2.method_46416(var39, var40, 0.0F);
         var2.method_22905(var37, var38, 1.0F);
         var2.method_46416(-var39, -var40, 0.0F);
         if (var59 > 0.01F) {
            GuiRenderHelper.method1462(var2, var30, var31, var27, var24, 8.0F, 14.0F, new Color(255, 255, 255, (int)(255.0F * var59)));
            GuiRenderHelper.method1463(var2, var30, var31, var27, var24, 8.0F, var33);
         }

         GuiRenderHelper.method1404(var1, var30, var31, var27, var24);
         float var41 = var30 + var17;
         float var42 = var31 + var24 / 2.0F;
         float var43 = var42 - var15 / 2.0F;
         var2.method_22903();
         var2.method_46416(var41, var43, 200.0F);
         float var44 = var15 / 16.0F;
         var2.method_22905(var44, var44, 1.0F);
         RenderSystem.enableBlend();
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var59);
         var1.method_51427(var6, 0, 0);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         var2.method_22909();
         var41 += var15 + var18;
         float var45 = var42 - var16 / 2.0F;
         GuiRenderHelper.method0326(var2, var41, var45, 1.0F, var16, 1.0F, var36);
         var41 += 1.0F + var18;
         float var46 = var42 - var61.method0530() / 2.0F;
         long var47 = System.currentTimeMillis() - this.field0549;
         float var49 = Math.min(1.0F, (float)var47 / 150.0F);
         float var50 = 1.0F - (1.0F - var49) * (1.0F - var49);
         if (var49 < 1.0F && !this.field0534.isEmpty()) {
            float var51 = var61.method0530() * 0.8F;
            int var52 = (int)(255.0F * (1.0F - var50) * var59);
            if (var52 > 0) {
               GuiRenderHelper.method1491(var2, var61, this.field0534, var41, var46 + var51 * var50, new Color(255, 255, 255, var52));
            }

            int var53 = (int)(255.0F * var50 * var59);
            if (var53 > 0) {
               GuiRenderHelper.method1491(var2, var61, this.field0513, var41, var46 - var51 * (1.0F - var50), new Color(255, 255, 255, var53));
            }
         } else {
            GuiRenderHelper.method1491(var2, var61, this.field0513, var41, var46, var34);
         }

         var41 += var20;
         GuiRenderHelper.method1491(var2, var14, var19, var41, var46, var35);
         GuiRenderHelper.method1400(var1);
         var2.method_22909();
      }
   }

   public List<class_1297> method1689() {
      List var1 = new ArrayList<>();
      this.method2026()
         .filter(var1x -> (var1x instanceof class_1665 || var1x instanceof class_3857 || var1x instanceof class_1542) && !this.method1129(var1x))
         .forEach(var1::add);
      return var1;
   }

   public class_243 method1147(class_1297 var1, class_243 var2, class_243 var3) {
      boolean var4 = field0796.field_1687.method_8316(class_2338.method_49638(var2)).method_15767(class_3486.field_15517);
      double var5;
      if (var1 instanceof class_1685) {
         var5 = 0.9900000190921701;
      } else if (var1 instanceof class_1665) {
         var5 = var4 ? 0.6000003606674028 : 0.9900000190921701;
      } else {
         var5 = var4 ? 0.7999999493743812 : 0.9900000190921701;
      }

      return var3.method_1021(var5).method_1031(0.0, -var1.method_56989(), 0.0);
   }

   private void method1146(class_1297 var1, class_243 var2, int var3, class_239 var4) {
      float var5 = field0796.method_61966() != null ? field0796.method_61966().method_60637(false) : 0.0F;
      float var6 = Math.max(0.0F, (var3 - var5) * 0.05F);
      class_2350 var7 = var4 instanceof class_3965 var8 ? var8.method_17780() : class_2350.field_11036;
      boolean var14 = var4 != null && var4.method_17783() == class_240.field_1331;
      class_1799 var9 = null;
      boolean var10 = false;
      if (var1 instanceof class_1542 var11) {
         var9 = var11.method_6983();
      } else if (var1 instanceof class_3857 var12) {
         var9 = var12.method_7495();
         var10 = var1 instanceof class_1686;
      } else if (var1 instanceof class_1665 var13) {
         var9 = var13.method_54759();
      }

      if (var9 != null) {
         this.field0885.add(new ProjectilePrediction.PathMesh(var9, var2, var6, var1, var10, var7, var14));
      }
   }

   private class_2350 method1294(class_239 var1) {
      return var1 instanceof class_3965 var2
         ? var2.method_17780()
         : class_2350.method_58251(var1.method_17784().method_1020(field0796.field_1724.method_33571()).method_1029());
   }

   private boolean method1129(class_1297 var1) {
      boolean var2 = var1.method_23317() == var1.field_6014 && var1.method_23318() == var1.field_6036 && var1.method_23321() == var1.field_5969;
      boolean var3 = var1 instanceof class_1542 && (var1.method_24828() || this.method0235(var1));
      return var2 || var3;
   }

   private boolean method0235(class_1297 var1) {
      return field0796.field_1687.method_8316(class_2338.method_49638(var1.method_19538())).method_15767(class_3486.field_15517);
   }

   private double method1234(class_1792 var1, class_1799 var2, class_1792 var3) {
      if (var1 instanceof class_1779) {
         return 0.7999999493743812;
      }

      if (var1 instanceof class_1828) {
         return 0.5500000601931105;
      }

      if (var1 instanceof class_1835 && var1.equals(var3) && field0796.field_1724.method_6048() >= 10) {
         return 2.5;
      }

      if (var1 instanceof class_1823 || var1 instanceof class_1771 || var1 instanceof class_1776) {
         return 1.5;
      }

      if (var1 instanceof class_1753 && var1.equals(var3) && field0796.field_1724.method_6115()) {
         float var5 = field0796.method_61966() != null ? field0796.method_61966().method_60637(false) : 0.0F;
         return 3.0F * class_3532.method_15363((field0796.field_1724.method_6048() + var5) / 20.0F, 0.0F, 1.0F);
      }

      if (var1 instanceof class_1764 && class_1764.method_7781(var2)) {
         class_9278 var4 = (class_9278)var2.method_57824(class_9334.field_49649);
         if (var4 != null && !var4.method_57437().isEmpty()) {
            return ((class_1799)var4.method_57437().getFirst()).method_31574(class_1802.field_8639) ? 100.0 : 3.0;
         }
      }

      return -1.0;
   }

   private class_1676 method1232(class_1792 var1, class_1799 var2) {
      if (var1 instanceof class_1779) {
         return new class_1683(field0796.field_1687, field0796.field_1724, var2);
      } else if (var1 instanceof class_1828) {
         return new class_1686(field0796.field_1687, field0796.field_1724, var2);
      } else if (var1 instanceof class_1835) {
         return new class_1685(field0796.field_1687, field0796.field_1724, var2);
      } else if (var1 instanceof class_1823) {
         return new class_1680(field0796.field_1687, field0796.field_1724, var2);
      } else if (var1 instanceof class_1771) {
         return new class_1681(field0796.field_1687, field0796.field_1724, var2);
      } else if (var1 instanceof class_1776) {
         return new class_1684(field0796.field_1687, field0796.field_1724, var2);
      } else {
         return !(var1 instanceof class_1753) && !(var1 instanceof class_1764) ? null : new class_1667(field0796.field_1687, field0796.field_1724, var2, var2);
      }
   }

   private ProjectilePrediction.HitResult method0292(class_243 var1, class_243 var2, class_1676 var3) {
      for (int var5 = 0; var5 < 300; var5++) {
         class_243 var4 = var1;
         var1 = var1.method_1019(var2);
         var2 = this.method1147(var3, var4, var2);
         class_239 var6 = field0796.field_1687.method_17742(new class_3959(var4, var1, class_3960.field_17558, class_242.field_1348, var3));
         if (!var6.method_17783().equals(class_240.field_1333)) {
            return new ProjectilePrediction.HitResult(var6, var5);
         }

         class_243 var7 = var1;
         class_243 var8 = var4;
         boolean var9 = this.method2026()
            .filter(var1x -> var1x instanceof class_1309 var2 && var2 != var3.method_24921() && var2.method_5805())
            .anyMatch(var3x -> this.method1293(var3x.method_5829().method_1014(0.3000001804584443), var8, var7));
         if (var9) {
            return new ProjectilePrediction.HitResult(new class_239(var1) {
               public class_240 method_17783() {
                  return class_240.field_1331;
               }
            }, var5);
         }

         if (var1.field_1351 < -128.0) {
            break;
         }
      }

      return null;
   }

   private static final class ProjectilePath {
      final float field0566;
      final float field0003;

      ProjectilePath(float var1, float var2) {
         this.field0566 = var1;
         this.field0003 = var2;
      }

      float method0530() {
         return this.field0566;
      }

      float method0002() {
         return this.field0003;
      }

      ProjectilePrediction.ProjectilePath method0659(float var1) {
         return new ProjectilePrediction.ProjectilePath(this.field0566 + var1, this.field0003);
      }

      ProjectilePrediction.ProjectilePath method0123(float var1) {
         return new ProjectilePrediction.ProjectilePath(this.field0566, this.field0003 + var1);
      }

      class_243 method2077() {
         float var1 = (float)Math.toRadians(this.field0003);
         float var2 = (float)Math.toRadians(-this.field0566);
         float var3 = class_3532.method_15362(var1);
         return new class_243(class_3532.method_15374(var2) * var3, -class_3532.method_15374(var1), class_3532.method_15362(var2) * var3);
      }
   }

   private static class PathPoint {
      final class_1297 field0730;
      final class_243 field0157;
      final int field1411;
      final class_1799 field1040;
      final long field0760;
      long field1244 = 0L;

      PathPoint(class_1297 var1, class_243 var2, int var3, class_1799 var4) {
         this.field0730 = var1;
         this.field0157 = var2;
         this.field1411 = var3;
         this.field1040 = var4;
         this.field0760 = System.currentTimeMillis();
      }

      class_1297 method0563() {
         return this.field0730;
      }

      class_243 method0024() {
         return this.field0157;
      }

      int method2048() {
         return this.field1411;
      }

      class_1799 method1801() {
         return this.field1040;
      }

      void method1634() {
         if (this.field1244 == 0L) {
            this.field1244 = System.currentTimeMillis();
         }
      }

      float method0774(long var1) {
         if (this.field1244 != 0L) {
            float var5 = (float)(var1 - this.field1244) / 200.0F;
            var5 = Math.min(1.0F, Math.max(0.0F, var5));
            return 1.0F - var5 * var5;
         } else {
            float var3 = (float)(var1 - this.field0760) / 220.0F;
            var3 = Math.min(1.0F, Math.max(0.0F, var3));
            return 1.0F - (1.0F - var3) * (1.0F - var3);
         }
      }

      boolean method0161(long var1) {
         return this.field1244 != 0L && var1 - this.field1244 > 200L;
      }
   }

   private record PathMesh(
      class_1799 stack, class_243 pos, float remainingTime, class_1297 entity, boolean isPotion, class_2350 facing, boolean isEntityHit
   ) {
      public class_1799 method0567() {
         return this.stack;
      }

      public class_243 method0024() {
         return this.pos;
      }

      public float method2047() {
         return this.remainingTime;
      }

      public class_1297 method1798() {
         return this.entity;
      }

      public boolean method1635() {
         return this.isPotion;
      }

      public class_2350 method1969() {
         return this.facing;
      }

      public boolean method0431() {
         return this.isEntityHit;
      }
   }

   private record HitResult(class_239 hit, int ticks) {
      public class_239 method0568() {
         return this.hit;
      }

      public int method0003() {
         return this.ticks;
      }
   }
}
