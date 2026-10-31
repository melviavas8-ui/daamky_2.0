package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import net.minecraft.class_279;
import net.minecraft.class_283;
import net.minecraft.class_284;
import net.minecraft.class_2960;
import net.minecraft.class_5944;
import net.minecraft.class_9960;
import ua.patch.daamky.api.mixins.accessors.GameRendererAccessor;
import ua.patch.daamky.api.mixins.accessors.PostEffectProcessorAccessor;

public class ChromaticDistortionRenderer implements MinecraftAccess {
   private float field0566 = 0.004F;
   private float field0003 = 2.0F;
   private float field1410 = 0.0F;
   private float field0957 = 0.0F;
   private float field0177 = 1.0F;
   private float field0458 = 0.7F;
   private float field1614 = 0.4F;
   private float field1538 = 2.0F;
   private float field1704 = 0.3F;

   public void method0675(float var1, float var2) {
      this.field0566 = var1;
      this.field0003 = var2;
   }

   public void method0684(float var1, float var2, float var3) {
      this.field1410 = var1;
      this.field0957 = var2;
      this.field0177 = var3;
   }

   public void method0131(float var1, float var2, float var3) {
      this.field0458 = var1;
      this.field1614 = var2;
      this.field1538 = var3;
   }

   public void method0665(float var1) {
      this.field1704 = var1;
   }

   private static void method1523(class_5944 var0, String var1, float var2) {
      class_284 var3 = var0.method_34582(var1);
      if (var3 != null) {
         var3.method_1251(var2);
      }
   }

   private static void method1524(class_5944 var0, String var1, float var2, float var3) {
      class_284 var4 = var0.method_34582(var1);
      if (var4 != null) {
         var4.method_1255(var2, var3);
      }
   }

   public void method0578() {
      try {
         class_279 var1 = field0796.method_62887().method_62941(class_2960.method_60655("daamky", "chromaticdistortion"), class_9960.field_53902);
         if (var1 == null) {
            return;
         }

         List var2 = ((PostEffectProcessorAccessor)var1).getPasses();
         if (var2 == null || var2.isEmpty()) {
            return;
         }

         class_5944 var3 = var2.getFirst().method_62922();
         if (var3 == null) {
            return;
         }

         var3.method_62899("DiffuseSampler", field0796.method_1522().method_30277());
         method1523(var3, "AberrationAmount", this.field0566);
         method1523(var3, "AberrationFalloff", this.field0003);
         method1524(var3, "MotionVelocity", this.field1410, this.field0957);
         method1523(var3, "MotionAmount", this.field0177);
         method1523(var3, "BloomThreshold", this.field0458);
         method1523(var3, "BloomIntensity", this.field1614);
         method1523(var3, "BloomRadius", this.field1538);
         method1523(var3, "VignetteAmount", this.field1704);
         RenderSystem.disableBlend();
         var1.method_1258(field0796.method_1522(), ((GameRendererAccessor)field0796.field_1773).getPool());
         field0796.method_1522().method_1235(false);
      } catch (Throwable var4) {
      }
   }
}
