package aethereal;

import net.minecraft.class_1297;
import net.minecraft.class_243;

public class LinearRotationStrategy extends RotationStrategy {
   public LinearRotationStrategy() {
      super("Linear");
   }

   @Override
   public Rotation method0874(Rotation var1, Rotation var2, class_243 var3, class_1297 var4) {
      Rotation var5 = RotationHelper.method0872(var1, var2);
      float var6 = var5.method2047();
      float var7 = var5.method1762();
      float var8 = (float)Math.hypot(var6, var7);
      float var9 = Math.abs(var6 / var8) * 360.0F;
      float var10 = Math.abs(var7 / var8) * 360.0F;
      float var11 = var1.method2047() + Math.min(Math.max(var6, -var9), var9);
      float var12 = var1.method1762() + Math.min(Math.max(var7, -var10), var10);
      return new Rotation(var11, var12);
   }

   @Override
   public class_243 method0569() {
      return new class_243(0.0, 0.0, 0.0);
   }
}
