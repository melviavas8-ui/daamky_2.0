package aethereal;

import java.security.SecureRandom;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public class ReallyWorldRotationStrategy extends RotationStrategy {
   public ReallyWorldRotationStrategy() {
      super("ReallyWorld");
   }

   @Override
   public Rotation method0874(Rotation var1, Rotation var2, class_243 var3, class_1297 var4) {
      AttackController var5 = DaamkyClient.method2004().method1881().method2051();
      Aura var6 = Aura.method1701();
      if (var4 != null) {
         class_243 var7 = AimPointSampler.method1134(var4, 1.0F, 3.5F);
         var2 = RotationHelper.method0287(var7);
      }

      int var24 = var5.method0414();
      IntervalTimer var8 = var5.method2057();
      Rotation var9 = RotationHelper.method0872(var1, var2);
      float var10 = var9.method2047();
      float var11 = var9.method1762();
      float var12 = (float)Math.hypot(Math.abs(var10), Math.abs(var11));
      boolean var13 = var4 != null && var6.method0409() != null && var5.method0815(var6.method2005(), 0);
      float var14 = 1.0F;
      float var15 = 1.0F;
      float var16 = var13 ? var14 : var15;
      float var17 = Math.abs(var10 / var12) * 180.0F;
      float var18 = Math.abs(var11 / var12) * 180.0F;
      float var19 = var13 ? 0.0F : (float)(-6.0 * Math.cos(System.currentTimeMillis() / 90.0));
      float var20 = var13 ? 0.0F : (float)(6.0 * Math.sin(System.currentTimeMillis() / 90.0));
      if (!var6.method1635() || var4 == null) {
         var16 = 0.9F;
         var19 = 0.0F;
         var20 = 0.0F;
      }

      float var21 = class_3532.method_15363(var10, -var17, var17);
      float var22 = class_3532.method_15363(var11, -var18, var18);
      Rotation var23 = new Rotation(var1.method2047(), var1.method1762());
      var23.method1822(class_3532.method_16439(this.method0667(var16, var16 + 0.2F), var1.method2047(), var1.method2047() + var21) + var19);
      var23.method1638(class_3532.method_16439(this.method0667(var16, var16 + 0.2F), var1.method1762(), var1.method1762() + var22) + var20);
      if (var24 > 0 && var24 % 50 == 0 && !var8.method0612(200.0)) {
         var23.method1638(class_3532.method_16439(0.55F, var1.method1762(), var1.method1762() - 90.0F) + var20);
      }

      return var23;
   }

   private float method0667(float var1, float var2) {
      return class_3532.method_16439(new SecureRandom().nextFloat(), var1, var2);
   }

   @Override
   public class_243 method0569() {
      return new class_243(0.0, 0.0, 0.0);
   }
}
