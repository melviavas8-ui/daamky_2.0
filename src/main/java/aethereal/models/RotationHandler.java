package aethereal;

import net.minecraft.class_1297;
import net.minecraft.class_243;

public class RotationHandler {
   public static RotationHandler field0654 = new RotationHandler(new LinearRotationStrategy(), true, true);
   public static boolean field0169;
   public static boolean field1527;
   private final RotationStrategy field0974;
   private final int field0759 = 1;

   public RotationHandler(boolean var1, boolean var2) {
      this(new LinearRotationStrategy(), var1, var2);
   }

   public RotationHandler(boolean var1) {
      this(new LinearRotationStrategy(), var1, true);
   }

   public RotationHandler(RotationStrategy var1, boolean var2, boolean var3) {
      this.field0974 = var1;
      field0169 = var2;
      field1527 = var3;
   }

   public RotationPlan method0877(Rotation var1, class_243 var2, class_1297 var3, int var4) {
      return new RotationPlan(var1, var2, var3, this.field0974, var4, 1.0F, field0169, field1527);
   }

   public RotationPlan method0878(Rotation var1, class_243 var2, class_1297 var3, boolean var4, boolean var5) {
      return new RotationPlan(var1, var2, var3, this.field0974, 1, 1.0F, var4, var5);
   }
}
