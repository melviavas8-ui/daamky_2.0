package aethereal;

import java.util.List;
import lombok.Generated;
import net.minecraft.class_1309;
import net.minecraft.class_238;

public class CombatController implements MinecraftAccess {
   AttackController field0617 = new AttackController();

   public void method0578() {
      this.field0617.method0578();
   }

   public void method0903(PacketEvent var1) {
      this.field0617.method0903(var1);
   }

   public void method0880(ItemUseEvent var1) {
      this.field0617.method0880(var1);
   }

   public void method0025() {
      this.field0617.method0025();
   }

   public void method0813(CombatController.CombatAction var1) {
      this.field0617.method0813(var1);
   }

   @Generated
   public AttackController method2051() {
      return this.field0617;
   }

   public static class CombatAction {
      private final class_1309 field0731;
      private final Rotation field0081;
      private final float field1410;
      private final boolean field1049;
      private final boolean field0798;
      private final boolean field1276;
      private final boolean field0343;
      private final class_238 field0214;

      public CombatAction(class_1309 var1, Rotation var2, float var3, List<String> var4, class_238 var5) {
         this.field0731 = var1;
         this.field0081 = var2;
         this.field1410 = var3;
         this.field1049 = var4.contains("Only Critical");
         this.field0798 = var4.contains("Break Shield");
         this.field1276 = var4.contains("UnPress Shield");
         this.field0343 = var4.contains("No Attack When Eat");
         this.field0214 = var5;
      }

      @Generated
      public class_1309 method0564() {
         return this.field0731;
      }

      @Generated
      public Rotation method0012() {
         return this.field0081;
      }

      @Generated
      public float method2047() {
         return this.field1410;
      }

      @Generated
      public boolean method1813() {
         return this.field1049;
      }

      @Generated
      public boolean method1635() {
         return this.field0798;
      }

      @Generated
      public boolean method1974() {
         return this.field1276;
      }

      @Generated
      public boolean method0431() {
         return this.field0343;
      }

      @Generated
      public class_238 method0372() {
         return this.field0214;
      }
   }
}
