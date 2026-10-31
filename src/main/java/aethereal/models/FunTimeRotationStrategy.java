package aethereal;

import java.security.SecureRandom;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public class FunTimeRotationStrategy extends RotationStrategy {
   public FunTimeRotationStrategy() {
      super("FunTime");
   }

   @Override
   public Rotation method0874(Rotation var1, Rotation var2, class_243 var3, class_1297 var4) {
      AttackController var5 = DaamkyClient.method2004().method1881().method2051();
      IntervalTimer var6 = var5.method2057();
      int var7 = var5.method0414();
      float var8 = new SecureRandom().nextBoolean() ? 0.4F : 0.2F;
      Rotation var9 = RotationHelper.method0872(var1, var2);
      float var10 = var9.method2047();
      float var11 = var9.method1762();
      float var12 = (float)Math.hypot(Math.abs(var10), Math.abs(var11));
      float var13 = Math.abs(var10 / var12) * 180.0F;
      float var14 = Math.abs(var11 / var12) * 180.0F;
      float var15 = class_3532.method_15363(var10, -var13, var13);
      float var16 = class_3532.method_15363(var11, -var14, var14);
      if (Aura.method1701().method0409() != null && var5.method0171(Aura.method1701().method2005(), 0)) {
         return new Rotation(var1.method2047() + var15, var1.method1762() + var16);
      }

      float var17 = var6.method0612(500.0) ? var8 : -0.2F;
      float var18 = (float)(System.currentTimeMillis() % 2000L) / 75.0F;
      float var19 = (float)(System.currentTimeMillis() % 1000L) / 75.0F;

      Rotation var20 = switch (var7 % 4) {
         case 0 -> new Rotation((float)Math.cos(var18), (float)Math.sin(var19));
         case 1 -> new Rotation((float)Math.sin(var18), (float)Math.cos(var19));
         case 2 -> new Rotation((float)Math.sin(var18), (float)(-Math.cos(var19)));
         default -> new Rotation((float)(-Math.cos(var18)), (float)Math.sin(var19));
      };
      float var21 = !var6.method0612(1000.0) ? this.method0667(6.0F, 12.0F) * var20.method2047() : 0.0F;
      float var22 = !var6.method0612(1000.0) ? this.method0667(2.0F, 4.0F) * var20.method1762() : 0.0F;
      float var23 = class_3532.method_15363(this.method0667(var17, var17 + 0.2F), 0.0F, 1.0F);
      float var24 = class_3532.method_15363(this.method0667(var17, var17 + 0.2F), 0.0F, 1.0F);
      float var25 = class_3532.method_16439(var23, var1.method2047(), var1.method2047() + var15) + var21;
      float var26 = class_3532.method_16439(var24, var1.method1762(), var1.method1762() + var16) + var22;
      return new Rotation(var25, var26);
   }

   @Override
   public class_243 method0569() {
      return new class_243(0.0, 0.0, 0.0);
   }

   private float method0667(float var1, float var2) {
      return class_3532.method_16439(new SecureRandom().nextFloat(), var1, var2);
   }
}
