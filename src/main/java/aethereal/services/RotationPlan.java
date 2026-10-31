package aethereal;

import lombok.Generated;
import net.minecraft.class_1297;
import net.minecraft.class_243;

public class RotationPlan implements MinecraftAccess {
   private final Rotation field1001;
   private final class_243 field0215;
   private final class_1297 field0491;
   private final RotationStrategy field1621;
   private final int field1539;
   private final float field1704;
   public final boolean field0751;
   public final boolean field0169;
   public final boolean field1527 = AutoPilot.method1703() != null && AutoPilot.method1703().method1635() && AutoPilot.method1703().field0151 != null;

   public Rotation method0879(Rotation var1, boolean var2) {
      return var2
         ? this.field1621.method0872(var1, RotationHelper.method1295(field0796.field_1724.method_5802()))
         : this.field1621.method0874(var1, this.field1001, this.field0215, this.field0491);
   }

   @Generated
   public Rotation method0545() {
      return this.field1001;
   }

   @Generated
   public class_243 method0024() {
      return this.field0215;
   }

   @Generated
   public class_1297 method2073() {
      return this.field0491;
   }

   @Generated
   public RotationStrategy method1771() {
      return this.field1621;
   }

   @Generated
   public int method1604() {
      return this.field1539;
   }

   @Generated
   public float method1946() {
      return this.field1704;
   }

   @Generated
   public boolean method0431() {
      return this.field0751;
   }

   @Generated
   public boolean method0376() {
      return this.field1527;
   }

   @Generated
   public RotationPlan(Rotation var1, class_243 var2, class_1297 var3, RotationStrategy var4, int var5, float var6, boolean var7, boolean var8) {
      this.field1001 = var1;
      this.field0215 = var2;
      this.field0491 = var3;
      this.field1621 = var4;
      this.field1539 = var5;
      this.field1704 = var6;
      this.field0751 = var7;
      this.field0169 = var8;
   }

   @Generated
   public boolean method0499() {
      return this.field0169;
   }
}
