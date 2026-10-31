package aethereal;

import lombok.Generated;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1309;
import net.minecraft.class_2708;
import net.minecraft.class_2828;
import net.minecraft.class_3532;

public class RotationManager implements MinecraftAccess {
   public static RotationManager field0618 = new RotationManager();
   private RotationPlan field1442;
   private final PriorityTask<RotationPlan> field0997 = new PriorityTask<>();
   public Rotation field0081;
   private Rotation field0199;
   private Rotation field0478 = Rotation.field0653;
   private Rotation field1636;

   public RotationManager() {
      DaamkyClient.method2004().method2072().subscribe(this);
   }

   public void method0869(Rotation var1) {
      if (var1 == null) {
         this.field0199 = this.field0081 != null ? this.field0081 : RotationHelper.method0545();
      } else {
         this.field0199 = this.field0081;
      }

      this.field0081 = var1;
   }

   public Rotation method0545() {
      return this.field0081 != null ? this.field0081 : RotationHelper.method0545();
   }

   public Rotation method0012() {
      if (this.field1636 != null) {
         return this.field1636;
      } else {
         return this.field0081 != null ? this.field0081 : (this.field0199 != null ? this.field0199 : RotationHelper.method0545());
      }
   }

   public void method0181(Rotation var1) {
      this.field1636 = var1;
   }

   public Rotation method2059() {
      return this.field0081 != null && this.field0199 != null
         ? this.field0199
         : new Rotation(field0796.field_1724.field_5982, field0796.field_1724.field_6004);
   }

   public Rotation method1781() {
      RotationPlan var1 = this.method1606();
      return this.field0081 != null && var1 != null && var1.method0431() ? this.field0081 : RotationHelper.method0545();
   }

   public RotationPlan method1606() {
      return this.field0997.method0555() != null ? this.field0997.method0555() : this.field1442;
   }

   public void method0867(Rotation.VectorRotation var1, class_1309 var2, int var3, RotationHandler var4, RotationPriority var5, Module var6) {
      this.method0816(var4.method0877(var1.method0545(), var1.method0024(), var2, var3), var5, var6);
   }

   public void method0870(Rotation var1, int var2, RotationHandler var3, RotationPriority var4, Module var5) {
      this.method0816(var3.method0877(var1, var1.method0024(), null, var2), var4, var5);
   }

   public void method0875(Rotation var1, RotationHandler var2, RotationPriority var3, Module var4) {
      this.method0816(var2.method0877(var1, var1.method0024(), null, 1), var3, var4);
   }

   public void method0816(RotationPlan var1, RotationPriority var2, Module var3) {
      this.field0997.method0859(new PriorityTask.TaskValue<>(1, var2.method0531(), var3, var1));
   }

   public void method1973() {
      RotationPlan var1 = this.method1606();
      if (var1 != null) {
         Rotation var2 = RotationHelper.method0545();
         if (this.field0081 == null && this.field0478 != null) {
            float var3 = this.field0478.method2047() + class_3532.method_15393(var2.method2047() - this.field0478.method2047());
            var2 = new Rotation(var3, var2.method1762());
         }

         if (this.field1442 != null) {
            double var5 = method0871(this.field0478, var2);
            if (var1.method1604() <= this.field0997.field0567 && var5 < var1.method1946()) {
               this.method0869(null);
               this.field1442 = null;
               this.field0997.field0567 = 0;
               return;
            }
         }

         Rotation var6 = var1.method0879(this.field0081 != null ? this.field0081 : var2, this.field0997.method0555() == null).method0545();
         this.method0869(var6);
         this.field1442 = var1;
         this.field0997.method0729(1);
      }
   }

   public static double method0871(Rotation var0, Rotation var1) {
      return Math.hypot(Math.abs(method0667(var0.method2047(), var1.method2047())), Math.abs(var0.method1762() - var1.method1762()));
   }

   public static float method0667(float var0, float var1) {
      return class_3532.method_15393(var0 - var1);
   }

   public void method0430() {
      this.field0997.field0141.clear();
   }

   @EventHandler
   public void onTick(PlayerTickEvent var1) {
      DaamkyClient.method2004().method2072().post(new RotationUpdateEvent((byte)0));
      this.method1973();
      DaamkyClient.method2004().method2072().post(new RotationUpdateEvent((byte)2));
   }

   @EventHandler
   public void onPacketSend(PacketEvent.Outbound var1) {
      if (!var1.method2079() && var1.method1970() instanceof class_2828 var2 && var2.method_36172()) {
         this.field0478 = new Rotation(var2.method_12271(1.0F), var2.method_12270(1.0F));
      }
   }

   @EventHandler
   public void onPacketReceive(PacketEvent.Inbound var1) {
      if (!var1.method2079() && var1.method1970() instanceof class_2708 var2) {
         float var4 = var2.comp_3228().comp_3150();
         if (this.field0478 != null) {
            var4 = this.field0478.method2047() + class_3532.method_15393(var4 - this.field0478.method2047());
         }

         this.field0478 = new Rotation(var4, var2.comp_3228().comp_3151());
      }
   }

   @Generated
   public RotationPlan method0362() {
      return this.field1442;
   }

   @Generated
   public PriorityTask<RotationPlan> method0487() {
      return this.field0997;
   }

   @Generated
   public Rotation method2219() {
      return this.field0081;
   }

   @Generated
   public Rotation method2188() {
      return this.field0199;
   }

   @Generated
   public Rotation method2258() {
      return this.field0478;
   }

   @Generated
   public Rotation method1910() {
      return this.field1636;
   }
}
