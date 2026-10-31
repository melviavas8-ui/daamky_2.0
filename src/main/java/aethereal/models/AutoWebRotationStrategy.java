package aethereal;

import java.security.SecureRandom;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public class AutoWebRotationStrategy extends RotationStrategy {
   private static final SecureRandom field0717 = new SecureRandom();
   private final float field0003;
   private final float field1410;

   public AutoWebRotationStrategy() {
      this(0.75F, 0.9F);
   }

   public AutoWebRotationStrategy(float var1, float var2) {
      super("AutoWeb");
      this.field0003 = var1;
      this.field1410 = var2;
   }

   @Override
   public Rotation method0874(Rotation var1, Rotation var2, class_243 var3, class_1297 var4) {
      Rotation var5 = RotationHelper.method0872(var1, var2);
      float var6 = var5.method2047();
      float var7 = var5.method1762();
      float var8 = (float)Math.hypot(Math.abs(var6), Math.abs(var7));
      if (var8 < 1.0E-4F) {
         return new Rotation(var1.method2047(), var1.method1762());
      }

      float var9 = Math.abs(var6 / var8) * 180.0F;
      float var10 = Math.abs(var7 / var8) * 180.0F;
      float var11 = class_3532.method_15363(var6, -var9, var9);
      float var12 = class_3532.method_15363(var7, -var10, var10);
      float var13 = class_3532.method_15363(method0667(this.field0003, this.field1410), 0.0F, 1.0F);
      Rotation var14 = new Rotation(var1.method2047(), var1.method1762());
      var14.method1822(class_3532.method_16439(var13, var1.method2047(), var1.method2047() + var11));
      var14.method1638(class_3532.method_16439(var13, var1.method1762(), var1.method1762() + var12));
      return var14;
   }

   private static float method0667(float var0, float var1) {
      return class_3532.method_16439(field0717.nextFloat(), var0, var1);
   }

   @Override
   public class_243 method0569() {
      return new class_243(0.0, 0.0, 0.0);
   }
}
