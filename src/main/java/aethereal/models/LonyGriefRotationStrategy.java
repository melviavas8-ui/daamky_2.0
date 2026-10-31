package aethereal;

import java.security.SecureRandom;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public class LonyGriefRotationStrategy extends RotationStrategy {
   private int field0004 = 0;
   private boolean field1527 = false;
   private boolean field1049 = false;
   private boolean field0219 = false;
   Stopwatch field0648 = new Stopwatch();

   public LonyGriefRotationStrategy() {
      super("FakeRotation to LonyGrief");
   }

   @Override
   public Rotation method0874(Rotation var1, Rotation var2, class_243 var3, class_1297 var4) {
      if (var4 != null) {
         class_243 var5 = AimPointSampler.method1134(var4, 0.0F, 5.0F);
         var2 = RotationHelper.method0287(var5);
      }

      Rotation var15 = RotationHelper.method0872(var1, var2);
      float var6 = var15.method2047();
      float var7 = var15.method1762();
      float var8 = (float)Math.hypot(var6, var7);
      float var9 = Math.abs(var6 / var8) * 360.0F;
      float var10 = Math.abs(var7 / var8) * 360.0F;
      float var11 = (float)(8.0 * Math.sin(System.currentTimeMillis() / 85.0));
      float var12 = (float)(8.0 * Math.sin(System.currentTimeMillis() / 95.0));
      float var13 = var1.method2047() + Math.min(Math.max(var6, -var9), var9);
      float var14 = var1.method1762() + Math.min(Math.max(var7, -var10), var10);
      return new Rotation(var13, var14);
   }

   @Override
   public class_243 method0569() {
      return new class_243(0.05000000373316334, 0.10000000019019825, 0.0200000002338183);
   }

   private float method0667(float var1, float var2) {
      return class_3532.method_16439(new SecureRandom().nextFloat(), var1, var2);
   }
}
