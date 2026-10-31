package aethereal;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.Generated;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1429;
import net.minecraft.class_1531;
import net.minecraft.class_1657;
import net.minecraft.class_243;

public class TargetSelector implements MinecraftAccess {
   private final AttackPrediction field0616 = new AttackPrediction();
   private class_1309 field0150 = null;
   private Stream<class_1309> field1516;

   public void method1158(class_1309 var1) {
      if (this.field0150 == null) {
         this.field0150 = var1;
      }
   }

   public void method0578() {
      this.field0150 = null;
   }

   public void method1105(Predicate<class_1309> var1) {
      this.method0229(var1).ifPresent(this::method1158);
      if (this.field0150 != null && !var1.test(this.field0150)) {
         this.method0578();
      }
   }

   public void method0986(Iterable<class_1297> var1, float var2, float var3, boolean var4) {
      if (this.field0150 != null && (!this.field0616.method0243(this.field0150, var2, var4) || this.method1164(this.field0150, var2, var4) > var3)) {
         this.method0578();
      }

      this.field1516 = this.method0205(var1, var2, var3, var4);
   }

   private double method1164(class_1309 var1, float var2, boolean var3) {
      class_243 var4 = (class_243)this.field0616
         .method1163(var1, var2, RotationManager.field0618.method0545(), new LinearRotationStrategy().method0569(), var3)
         .method_15442();
      return RaycastHelper.method0643(var2, var1.method_5829())
         ? 0.0
         : RotationManager.method0871(RotationHelper.method0545(), RotationHelper.method0287(var4));
   }

   private Stream<class_1309> method0205(Iterable<class_1297> var1, float var2, float var3, boolean var4) {
      return StreamSupport.stream(var1.spliterator(), false)
         .filter(class_1309.class::isInstance)
         .map(class_1309.class::cast)
         .filter(var4x -> this.field0616.method0243(var4x, var2, var4) && this.method1164(var4x, var2, var4) < var3)
         .sorted(Comparator.comparingDouble(var0 -> var0.method_5739(field0796.field_1724)));
   }

   private Optional<class_1309> method0229(Predicate<class_1309> var1) {
      return this.field1516.filter(var1).findFirst();
   }

   @Generated
   public AttackPrediction method0006() {
      return this.field0616;
   }

   @Generated
   public class_1309 method2074() {
      return this.field0150;
   }

   @Generated
   public Stream<class_1309> method1796() {
      return this.field1516;
   }

   public static class TargetScore {
      private final List<String> field0719;

      public boolean method1159(class_1309 var1) {
         if (this.method0241(var1)) {
            return false;
         } else if (this.method2146(var1)) {
            return false;
         } else {
            return this.method1852(var1) ? false : this.method1989(var1);
         }
      }

      private boolean method0241(class_1309 var1) {
         return var1 == MinecraftAccess.field0796.field_1724;
      }

      private boolean method2146(class_1309 var1) {
         return !var1.method_5805() || var1.method_6032() <= 0.0F;
      }

      private boolean method1852(class_1309 var1) {
         return var1 instanceof class_1657 var2 && AntiBot.method1700().method0250(var2);
      }

      private boolean method1661(class_1309 var1) {
         return var1.method_6118(class_1304.field_6169).method_7960()
            && var1.method_6118(class_1304.field_6174).method_7960()
            && var1.method_6118(class_1304.field_6172).method_7960()
            && var1.method_6118(class_1304.field_6166).method_7960();
      }

      private boolean method1989(class_1309 var1) {
         return switch (var1) {
            case class_1657 var4 when this.field0719.contains("Friends") || !FriendManager.method0538().method1129(var4) -> this.method1661(var4)
               ? this.field0719.contains("Naked")
               : this.field0719.contains("Players");
            case class_1429 var5 -> this.field0719.contains("Animals");
            case class_1308 var6 -> this.field0719.contains("Mobs");
            case class_1531 var7 -> this.field0719.contains("Armor Stand");
            default -> false;
         };
      }

      @Generated
      public TargetScore(List<String> var1) {
         this.field0719 = var1;
      }
   }
}
