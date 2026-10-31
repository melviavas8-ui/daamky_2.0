package aethereal;

import net.minecraft.class_1309;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public class ElytraRotationController implements MinecraftAccess {
   private static final float field0566 = 45.0F;
   private static final float field0003 = 35.0F;
   private static final double field1409 = 10.0;
   private final ElytraTarget field0983;
   private final ElytraMovementPredictor field0200;

   public ElytraRotationController(ElytraTarget var1, ElytraMovementPredictor var2) {
      this.field0983 = var1;
      this.field0200 = var2;
   }

   public boolean method0579() {
      if (field0796.field_1724 == null || !field0796.field_1724.method_6128()) {
         return false;
      }

      if (!this.field0983.method2195()) {
         return false;
      }

      Aura var1 = Aura.method1701();
      return var1 != null && var1.method0409() != null;
   }

   public void method0025() {
      if (this.method0579()) {
         if (this.field0983.method1692()) {
            class_1309 var1 = Aura.method1701().method0409();
            if (var1 != null) {
               if (!(field0796.field_1724.method_5739(var1) <= this.field0983.method0461())) {
                  Rotation var2 = RotationManager.field0618.method0545();
                  Rotation var3 = this.method1154(var1);
                  Rotation var4 = this.method0872(var2, var3);
                  Rotation.VectorRotation var5 = new Rotation.VectorRotation(var4, this.method0239(var1));
                  RotationHandler var6 = new RotationHandler(new LinearRotationStrategy(), true, true);
                  RotationManager.field0618.method0867(var5, var1, 1, var6, RotationPriority.field1010, this.field0983);
               }
            }
         }
      }
   }

   private Rotation method0872(Rotation var1, Rotation var2) {
      float var3 = RotationHelper.method0667(var2.method2047(), var1.method2047());
      float var4 = var2.method1762() - var1.method1762();
      float var5 = (float)Math.sqrt(var3 * var3 + var4 * var4);
      long var6 = System.currentTimeMillis();
      boolean var8 = Math.sin(var6 / 300.0) > 0.7999999197174497;
      boolean var9 = Math.abs(var3) > 90.0F;
      float var10 = var8 ? 2.0F : 1.2F;
      float var11 = var8 ? (float)(Math.sin((float)(var6 % 360L) / 300.0F * 3.1415929793387427) * 0.8F + 1.2000005F) : 1.2F;
      float var12 = var9 ? (float)(2.1999996F * Math.sin(var6 / 150.0) * 0.19999997811392572 + 1.0) : 1.2F;
      float var13 = var10 * var11;
      float var14 = this.method2047() * var13 * var12;
      float var15 = this.method1762() * var13;
      float var16 = (float)(Math.sin(var6 / 80.0) * 0.08000003370954027 + Math.cos(var6 / 120.0) * 0.05000000242303777);
      float var17 = class_3532.method_15363(var3, -var14, var14);
      float var18 = class_3532.method_15363(var4, -var15, var15);
      if (var5 < 5.0F) {
         var17 += var16 * 0.2F;
         var18 += var16 * 0.8F;
      }

      return new Rotation(var1.method2047() + var17, class_3532.method_15363(var1.method1762() + var18, -90.0F, 90.0F));
   }

   public Rotation method1154(class_1309 var1) {
      class_243 var2 = this.method0239(var1);
      if (this.field0983.method2030()) {
         class_243 var3 = field0796.field_1724.method_19538();
         class_243 var4 = var2.method_1020(var3).method_1029();
         double var5 = var3.method_1025(var4);
         if (var5 < 100.0) {
            var2 = var2.method_1020(var4.method_1021(10.0 - var5));
         }
      }

      return RotationHelper.method0287(var2);
   }

   public class_243 method0239(class_1309 var1) {
      class_243 var2 = this.field0983.method2008().method1157(var1);
      return this.field0200.method1170(var1, var2);
   }

   private float method2047() {
      return (this.field0983.method1755() ? 67.5F : 45.0F) / 3.0F;
   }

   private float method1762() {
      return (this.field0983.method1755() ? 52.5F : 35.0F) / 3.0F;
   }
}
