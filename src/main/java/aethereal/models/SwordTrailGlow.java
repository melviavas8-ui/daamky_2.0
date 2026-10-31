package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.class_10142;
import net.minecraft.class_243;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;

public final class SwordTrailGlow {
   private static final class_2960 field0738 = DaamkyClient.method1012("textures/glow.png");
   private final List<SwordTrailFade> field0139 = new ArrayList<>();
   private final Random field1510 = new Random();

   public void method0578() {
      SwordTrail var1 = DaamkyClient.method2004().method1783().method0976(SwordTrail.class);
      if (var1 != null) {
         if (var1.method2247() && var1.method1692()) {
            SwordTrailSample var2 = var1.method1712().method1773();
            if (var2 != null) {
               int var3 = var1.method2240();
               int var4 = var1.method2248();
               float var5 = (float)Math.toRadians(var1.method2209());
               class_243 var6 = var2.method0569();

               for (int var7 = 0; var7 < var3; var7++) {
                  double var8 = this.field1510.nextDouble() * 3.1415933136871637 * 2.0;
                  double var10 = this.field1510.nextDouble() * var5;
                  double var12 = Math.cos(var8) * Math.sin(var10) * 0.150000071595892;
                  double var14 = Math.cos(var10) * 0.150000071595892;
                  double var16 = Math.sin(var8) * Math.sin(var10) * 0.150000071595892;
                  this.field0139.add(new SwordTrailFade(var6.field_1352, var6.field_1351, var6.field_1350, var12, var14, var16, var4));
               }
            }
         }

         float var18 = var1.method2273();
         Iterator var19 = this.field0139.iterator();

         while (var19.hasNext()) {
            SwordTrailFade var20 = var19.next();
            var20.field0956 = var20.field0565;
            var20.field0757 = var20.field0002;
            var20.field1241 = var20.field1409;
            var20.field0565 = var20.field0565 + var20.field0313;
            var20.field0002 = var20.field0002 + var20.field0176;
            var20.field1409 = var20.field1409 + var20.field0457;
            var20.field0176 -= var18;
            var20.field0313 *= 0.8999997187437941;
            var20.field0176 *= 0.9500000004989715;
            var20.field0457 *= 0.8999997187437941;
            var20.field1615++;
            if (var20.method0579()) {
               var19.remove();
            }
         }
      }
   }

   public void method0665(float var1) {
      SwordTrail var2 = DaamkyClient.method2004().method1783().method0976(SwordTrail.class);
      if (var2 != null && !this.field0139.isEmpty()) {
         class_310 var3 = class_310.method_1551();
         class_4184 var4 = var3.field_1773 != null ? var3.field_1773.method_19418() : null;
         if (var4 != null) {
            class_243 var5 = var4.method_19326();
            Color var6 = var2.method2205();
            float var7 = var2.method2200();
            boolean var8 = var2.method2272();
            float var9 = (float)Math.toRadians(var4.method_19330());
            double var10 = -Math.cos(var9);
            double var12 = -Math.sin(var9);
            double var14 = 0.0;
            double var16 = 1.0;
            double var18 = 0.0;
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(770, 32772);
            RenderSystem.depthMask(false);
            RenderSystem.disableCull();
            RenderSystem.setShader(class_10142.field_53880);
            if (var8) {
               RenderSystem.setShaderTexture(0, field0738);
            }

            Matrix4f var20 = new Matrix4f();
            class_287 var21 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1575);

            for (SwordTrailFade var23 : this.field0139) {
               double var24 = var23.field0956 + (var23.field0565 - var23.field0956) * var1 - var5.field_1352;
               double var26 = var23.field0757 + (var23.field0002 - var23.field0757) * var1 - var5.field_1351;
               double var28 = var23.field1241 + (var23.field1409 - var23.field1241) * var1 - var5.field_1350;
               float var30 = var23.method0002() * (var6.getAlpha() / 255.0F);
               int var31 = Math.max(0, Math.min(255, (int)(var30 * 255.0F)));
               int var32 = var31 << 24 | var6.getRGB() & 16777215;
               double var33 = var10 * var7;
               double var35 = var12 * var7;
               double var37 = var14 * var7;
               double var39 = var16 * var7;
               double var41 = var18 * var7;
               var21.method_22918(var20, (float)(var24 - var33 - var37), (float)(var26 - var39), (float)(var28 - var35 - var41))
                  .method_22913(0.0F, 0.0F)
                  .method_39415(var32);
               var21.method_22918(var20, (float)(var24 + var33 - var37), (float)(var26 - var39), (float)(var28 + var35 - var41))
                  .method_22913(1.0F, 0.0F)
                  .method_39415(var32);
               var21.method_22918(var20, (float)(var24 + var33 + var37), (float)(var26 + var39), (float)(var28 + var35 + var41))
                  .method_22913(1.0F, 1.0F)
                  .method_39415(var32);
               var21.method_22918(var20, (float)(var24 - var33 + var37), (float)(var26 + var39), (float)(var28 - var35 + var41))
                  .method_22913(0.0F, 1.0F)
                  .method_39415(var32);
            }

            class_286.method_43433(var21.method_60800());
            RenderSystem.setShaderTexture(0, 0);
            RenderSystem.enableCull();
            RenderSystem.depthMask(true);
            RenderSystem.disableBlend();
         }
      }
   }

   public void method0025() {
      this.field0139.clear();
   }
}
