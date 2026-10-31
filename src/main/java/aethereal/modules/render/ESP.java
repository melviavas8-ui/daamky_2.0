package aethereal;

import com.mojang.blaze3d.platform.GlStateManager.class_4534;
import com.mojang.blaze3d.platform.GlStateManager.class_4535;
import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10017;
import net.minecraft.class_10042;
import net.minecraft.class_10142;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_289;
import net.minecraft.class_290;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_897;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public class ESP extends Module {
   private static final float field0003 = 64.0F;
   private final EnumSetting<ESP.Mode> field1448 = new EnumSetting<>("esp.mode", ESP.Mode.field0625)
      .method1007("Mode")
      .method0210("ESP visual mode")
      .method2130("Режим ESP");
   private final BooleanSetting field0970 = new BooleanSetting("esp.invisible", false)
      .method1007("Show Invisible")
      .method0210("Render invisible players")
      .method2130("Невидимых игроков");
   private final BooleanSetting field0184 = new BooleanSetting("esp.self", false)
      .method1007("Self")
      .method0210("Render ESP on yourself")
      .method2130("Отображать ESP на себе");
   private final ColorSetting field0466 = new ColorSetting(
         "esp.skel.color", 255, 255, 255, 230, () -> this.field1448.method0492() == ESP.Mode.field0625
      )
      .method1882()
      .method1007("Skeleton Color")
      .method0210("Skeleton bone color")
      .method2130("Цвет костей");
   private final BooleanSetting field1619 = new BooleanSetting("esp.skel.additive", true, () -> this.field1448.method0492() == ESP.Mode.field0625)
      .method1007("Additive Blend")
      .method0210("Additive blending for the skeleton glow")
      .method2130("Аддитивный блендинг скелета");
   private final ColorSetting field1550 = new ColorSetting(
         "esp.box3d.fill", 240, 100, 150, 130, () -> this.field1448.method0492() == ESP.Mode.field0056
      )
      .method1882()
      .method1007("Fill Color")
      .method0210("Box fill base color")
      .method2130("Цвет заливки");
   private final ColorSetting field1711 = new ColorSetting(
         "esp.box3d.outlinecolor", 130, 200, 255, 220, () -> this.field1448.method0492() == ESP.Mode.field0056
      )
      .method1882()
      .method1007("Outline Color")
      .method0210("Glowing outline color")
      .method2130("Цвет светящейся обводки");
   private final FloatSetting field1144 = new FloatSetting(
         "esp.box3d.glow", 4.0F, 0.0F, 8.0F, 1.0F, () -> this.field1448.method0492() == ESP.Mode.field0056
      )
      .method1007("Glow Passes")
      .method0210("How bright the outline glows")
      .method2130("Сила свечения");
   private final BooleanSetting field1093 = new BooleanSetting("esp.box3d.additive", true, () -> this.field1448.method0492() == ESP.Mode.field0056)
      .method1007("Additive Blend")
      .method0210("Additive fill blend (bright glow on dark BG)")
      .method2130("Аддитивный блендинг заливки");

   public ESP() {
      super("ESP", ModuleCategory.field1004, "Skeleton or glowing 3D box");
      this.method1013("Скелет, светящийся 3D бокс");
   }

   @EventHandler
   public void onRenderWorld(GlowRenderEvent var1) {
      if (!method1974()) {
         ESP.Mode var2 = this.field1448.method0492();
         float var3 = var1.method1603();
         if (var2 == ESP.Mode.field0625) {
            Color var12 = this.field0466.method1726();

            for (class_1657 var14 : field0796.field_1687.method_18456()) {
               if (this.method1183(var14)) {
                  this.method1190(var14, var3, var12);
               }
            }
         } else {
            if (var2 == ESP.Mode.field0056) {
               Color var4 = this.field1711.method1726();
               Color var5 = this.field1550.method1726();
               Color var6 = this.method0960(var5);
               int var7 = this.field1144.method0492().intValue();
               class_4587 var8 = new class_4587();

               for (class_1657 var10 : field0796.field_1687.method_18456()) {
                  if (this.method1183(var10)) {
                     class_238 var11 = this.method1161(var10, var3);
                     if (var5.getAlpha() > 0) {
                        this.method1286(var11, var5, var6);
                     }

                     WorldGeometryRenderer.method0333(var8, var11, var4);
                     if (var7 > 0) {
                        this.method1499(var8, var11, var4, var7);
                     }
                  }
               }
            }
         }
      }
   }

   private Color method0960(Color var1) {
      int var2 = var1.getRed() + (255 - var1.getRed()) * 6 / 10;
      int var3 = var1.getGreen() + (255 - var1.getGreen()) * 6 / 10;
      int var4 = var1.getBlue() + (255 - var1.getBlue()) * 6 / 10;
      return new Color(Math.min(255, var2), Math.min(255, var3), Math.min(255, var4), Math.max(80, var1.getAlpha() / 2));
   }

   private boolean method1183(class_1657 var1) {
      if (var1 != field0796.field_1724 || this.field0184.method0492() && !field0796.field_1690.method_31044().method_31034()) {
         if (var1.method_29504()) {
            return false;
         } else if (!this.field0970.method0492() && var1.method_5767()) {
            return false;
         } else {
            return var1.method_5477().getString().isEmpty() ? false : field0796.field_1724.method_5739(var1) <= 64.0F;
         }
      } else {
         return false;
      }
   }

   private class_238 method1161(class_1309 var1, float var2) {
      class_238 var3 = var1.method_5829();
      double var4 = class_3532.method_16436(var2, var1.field_6038, var1.method_23317()) - var1.method_23317();
      double var6 = class_3532.method_16436(var2, var1.field_5971, var1.method_23318()) - var1.method_23318();
      double var8 = class_3532.method_16436(var2, var1.field_5989, var1.method_23321()) - var1.method_23321();
      return new class_238(
         var3.field_1323 + var4, var3.field_1322 + var6, var3.field_1321 + var8, var3.field_1320 + var4, var3.field_1325 + var6, var3.field_1324 + var8
      );
   }

   private void method1190(class_1657 var1, float var2, Color var3) {
      class_897 var4 = field0796.method_1561().method_3953(var1);
      if (var4 instanceof EntityModelRenderHook var5) {
         class_10017 var6 = var4.method_62425(var1, var2);
         if (var6 instanceof class_10042 var7) {
            class_243 var8 = var4.method_23169(var6);
            class_243 var9 = new class_243(
               class_3532.method_16436(var2, var1.field_6038, var1.method_23317()) + var8.field_1352,
               class_3532.method_16436(var2, var1.field_5971, var1.method_23318()) + var8.field_1351,
               class_3532.method_16436(var2, var1.field_5989, var1.method_23321()) + var8.field_1350
            );
            HashMap var10 = new HashMap();
            var5.daamky$collectSkeleton(var7, new class_4587(), var10);
            if (!var10.isEmpty()) {
               class_4587 var11 = new class_4587();
               boolean var12 = this.field1619.method0492();
               this.method1504(var11, var9, var10, "headTop", "neck", var3, var12);
               this.method1504(var11, var9, var10, "neck", "pelvis", var3, var12);
               this.method0335(var11, var9, var10, "shoulderR", "handR", var3, var12);
               this.method0335(var11, var9, var10, "shoulderL", "handL", var3, var12);
               this.method1504(var11, var9, var10, "pelvis", "hipR", var3, var12);
               this.method1504(var11, var9, var10, "pelvis", "hipL", var3, var12);
               this.method1504(var11, var9, var10, "hipR", "hipL", var3, var12);
               this.method1504(var11, var9, var10, "hipR", "footR", var3, var12);
               this.method1504(var11, var9, var10, "hipL", "footL", var3, var12);
            }
         }
      }
   }

   private void method1504(class_4587 var1, class_243 var2, Map<String, Vector3f> var3, String var4, String var5, Color var6, boolean var7) {
      Vector3f var8 = var3.get(var4);
      Vector3f var9 = var3.get(var5);
      if (var8 != null && var9 != null) {
         WorldGeometryRenderer.method1508(var1, var2.method_1031(var8.x, var8.y, var8.z), var2.method_1031(var9.x, var9.y, var9.z), var6, var7);
      }
   }

   private void method0335(class_4587 var1, class_243 var2, Map<String, Vector3f> var3, String var4, String var5, Color var6, boolean var7) {
      Vector3f var8 = var3.get("neck");
      Vector3f var9 = var3.get("pelvis");
      Vector3f var10 = var3.get(var4);
      if (var8 != null && var9 != null && var10 != null) {
         this.method1509(var1, var2, this.method1566(var10, var8, var9), var10, var6, var7);
         Vector3f var11 = var3.get(var5);
         if (var11 != null) {
            this.method1509(var1, var2, var10, var11, var6, var7);
         }
      }
   }

   private Vector3f method1566(Vector3f var1, Vector3f var2, Vector3f var3) {
      Vector3f var4 = new Vector3f(var2).sub(var3);
      float var5 = var4.lengthSquared();
      if (var5 < 1.0E-6F) {
         return new Vector3f(var2);
      }

      float var6 = new Vector3f(var1).sub(var3).dot(var4) / var5;
      return var4.mul(var6).add(var3);
   }

   private void method1509(class_4587 var1, class_243 var2, Vector3f var3, Vector3f var4, Color var5, boolean var6) {
      WorldGeometryRenderer.method1508(var1, var2.method_1031(var3.x, var3.y, var3.z), var2.method_1031(var4.x, var4.y, var4.z), var5, var6);
   }

   private void method1499(class_4587 var1, class_238 var2, Color var3, int var4) {
      class_243 var5 = field0796.field_1773.method_19418().method_19326();
      float var6 = (float)(var2.field_1323 - var5.field_1352);
      float var7 = (float)(var2.field_1320 - var5.field_1352);
      float var8 = (float)(var2.field_1322 - var5.field_1351);
      float var9 = (float)(var2.field_1325 - var5.field_1351);
      float var10 = (float)(var2.field_1321 - var5.field_1350);
      float var11 = (float)(var2.field_1324 - var5.field_1350);
      Matrix4f var12 = var1.method_23760().method_23761();
      int var13 = var3.getAlpha() << 24 | var3.getRGB() & 16777215;

      for (int var14 = 0; var14 < var4; var14++) {
         this.method1560(var12, var13, var6, var8, var10, var7, var8, var10);
         this.method1560(var12, var13, var7, var8, var10, var7, var8, var11);
         this.method1560(var12, var13, var7, var8, var11, var6, var8, var11);
         this.method1560(var12, var13, var6, var8, var11, var6, var8, var10);
         this.method1560(var12, var13, var6, var9, var10, var7, var9, var10);
         this.method1560(var12, var13, var7, var9, var10, var7, var9, var11);
         this.method1560(var12, var13, var7, var9, var11, var6, var9, var11);
         this.method1560(var12, var13, var6, var9, var11, var6, var9, var10);
         this.method1560(var12, var13, var6, var8, var10, var6, var9, var10);
         this.method1560(var12, var13, var7, var8, var10, var7, var9, var10);
         this.method1560(var12, var13, var7, var8, var11, var7, var9, var11);
         this.method1560(var12, var13, var6, var8, var11, var6, var9, var11);
      }
   }

   private void method1560(Matrix4f var1, int var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      WorldGeometryRenderer.field0209
         .add(
            new WorldGeometryRenderer.VertexBatch(
               new WorldGeometryRenderer.ColoredVertex(var1, var3, var4, var5, var2), new WorldGeometryRenderer.ColoredVertex(var1, var6, var7, var8, var2)
            )
         );
   }

   private void method1286(class_238 var1, Color var2, Color var3) {
      class_243 var4 = field0796.field_1773.method_19418().method_19326();
      float var5 = (float)(var1.field_1323 - var4.field_1352);
      float var6 = (float)(var1.field_1320 - var4.field_1352);
      float var7 = (float)(var1.field_1322 - var4.field_1351);
      float var8 = (float)(var1.field_1325 - var4.field_1351);
      float var9 = (float)(var1.field_1321 - var4.field_1350);
      float var10 = (float)(var1.field_1324 - var4.field_1350);
      RenderSystem.enableBlend();
      if (this.field1093.method0492()) {
         RenderSystem.blendFunc(class_4535.SRC_ALPHA, class_4534.ONE);
      } else {
         RenderSystem.blendFuncSeparate(class_4535.SRC_ALPHA, class_4534.ONE_MINUS_SRC_ALPHA, class_4535.ONE, class_4534.ZERO);
      }

      RenderSystem.disableCull();
      RenderSystem.disableDepthTest();
      RenderSystem.setShader(class_10142.field_53876);
      int var11 = var3.getRGB();
      int var12 = var2.getRGB();
      class_287 var13 = class_289.method_1348().method_60827(class_5596.field_27382, class_290.field_1576);
      Matrix4f var14 = new Matrix4f();
      this.method1385(var13, var14, var5, var7, var9, var12, var6, var7, var9, var12, var6, var7, var10, var12, var5, var7, var10, var12);
      this.method1385(var13, var14, var5, var8, var9, var11, var5, var8, var10, var11, var6, var8, var10, var11, var6, var8, var9, var11);
      this.method1385(var13, var14, var5, var7, var9, var12, var6, var7, var9, var12, var6, var8, var9, var11, var5, var8, var9, var11);
      this.method1385(var13, var14, var5, var7, var10, var12, var5, var8, var10, var11, var6, var8, var10, var11, var6, var7, var10, var12);
      this.method1385(var13, var14, var5, var7, var9, var12, var5, var7, var10, var12, var5, var8, var10, var11, var5, var8, var9, var11);
      this.method1385(var13, var14, var6, var7, var9, var12, var6, var8, var9, var11, var6, var8, var10, var11, var6, var7, var10, var12);
      class_286.method_43433(var13.method_60800());
      RenderSystem.defaultBlendFunc();
      RenderSystem.enableDepthTest();
      RenderSystem.enableCull();
      RenderSystem.disableBlend();
   }

   private void method1385(
      class_287 var1,
      Matrix4f var2,
      float var3,
      float var4,
      float var5,
      int var6,
      float var7,
      float var8,
      float var9,
      int var10,
      float var11,
      float var12,
      float var13,
      int var14,
      float var15,
      float var16,
      float var17,
      int var18
   ) {
      var1.method_22918(var2, var3, var4, var5).method_39415(var6);
      var1.method_22918(var2, var7, var8, var9).method_39415(var10);
      var1.method_22918(var2, var11, var12, var13).method_39415(var14);
      var1.method_22918(var2, var15, var16, var17).method_39415(var18);
   }

   public enum Mode implements DisplayNamed {
      field0625("Skeleton"),
      field0056("3D Box");

      private final String field1504;

      Mode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }
}
