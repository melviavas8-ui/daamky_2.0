package aethereal;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import java.awt.Color;
import java.util.List;
import net.minecraft.class_1268;
import net.minecraft.class_1799;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_742;
import net.minecraft.class_759;

public final class FirstPersonTrailRenderer {
   private FirstPersonTrailRenderer() {
   }

   public static void method1543(
      class_759 var0,
      class_742 var1,
      float var2,
      float var3,
      class_1268 var4,
      float var5,
      class_1799 var6,
      float var7,
      class_4587 var8,
      class_4597 var9,
      int var10,
      Operation<Void> var11
   ) {
      SwordTrail var12 = DaamkyClient.method2004().method1783().method0976(SwordTrail.class);
      if (var12 != null && var12.method2030()) {
         if (!var12.method1755() || var4 == class_1268.field_5808) {
            List var13 = var12.method1924();
            if (!var13.isEmpty()) {
               Shaders var14 = DaamkyClient.method2004().method1783().method0976(Shaders.class);
               boolean var15 = var14 != null && var14.method2195() && var14.method1755();
               if (var15) {
                  float var16 = var12.method2001();
                  float var17 = var12.method1919();
                  float var18 = var12.method1925();
                  boolean var19 = var12.method0472();
                  Color var20 = var19 ? var12.method0453() : var14.method2023();

                  for (SwordTrailAnimation var22 : var13) {
                     float var23 = method0681(var22.method0002(), var17, var18);
                     if (!(var23 <= 0.001F)) {
                        int var24 = (int)(255.0F * var16 * var23);
                        if (var24 > 0) {
                           class_4597 var25 = var14.method1708().method1518(DelegatingVertexConsumer.field0165, var20, var24);
                           var11.call(new Object[]{var0, var1, var2, var3, var4, var22.field0566, var6, var7, var8, var25, var10});
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private static float method0681(float var0, float var1, float var2) {
      if (!(var0 <= 0.0F) && !(var0 >= 1.0F)) {
         float var3 = var1 > 0.0F ? Math.min(1.0F, var0 / var1) : 1.0F;
         float var4 = var2 > 0.0F ? Math.min(1.0F, (1.0F - var0) / var2) : 1.0F;
         return Math.max(0.0F, Math.min(var3, var4));
      } else {
         return 0.0F;
      }
   }
}
