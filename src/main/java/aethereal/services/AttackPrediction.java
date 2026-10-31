package aethereal;

import java.security.SecureRandom;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import lombok.Generated;
import net.minecraft.class_1309;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3545;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3959.class_3960;

public class AttackPrediction implements MinecraftAccess {
   private final Random field0721 = new SecureRandom();
   private class_243 field0157 = class_243.field_1353;

   public class_3545<class_243, class_238> method1163(class_1309 var1, float var2, Rotation var3, class_243 var4, boolean var5) {
      class_3545 var6 = this.method1165(var1, var2, var5);
      class_243 var7 = this.method1078((List<class_243>)var6.method_15442(), var3);
      this.method1300(var4);
      return new class_3545((var7 == null ? var1.method_33571() : var7).method_1019(this.field0157), (class_238)var6.method_15441());
   }

   public class_3545<List<class_243>, class_238> method1165(class_1309 var1, float var2, boolean var3) {
      class_238 var4 = var1.method_5829();
      double var5 = var4.method_17940() / 10.0;
      List var7 = Stream.<Double>iterate(var4.field_1322, var1x -> var1x <= var4.field_1325, var2x -> var2x + var5)
         .map(var1x -> new class_243(var4.method_1005().field_1352, var1x, var4.method_1005().field_1350))
         .filter(var3x -> this.method1332(field0796.field_1724.method_33571(), var3x, var2, var3))
         .toList();
      return new class_3545(var7, var4);
   }

   public boolean method0243(class_1309 var1, float var2, boolean var3) {
      class_238 var4 = var1.method_5829();
      double var5 = var4.method_17940() / 10.0;
      return Stream.<Double>iterate(var4.field_1322, var1x -> var1x < var4.field_1325, var2x -> var2x + var5)
         .map(var1x -> new class_243(var4.method_1005().field_1352, var1x, var4.method_1005().field_1350))
         .anyMatch(var3x -> this.method1332(field0796.field_1724.method_33571(), var3x, var2, var3));
   }

   private boolean method1332(class_243 var1, class_243 var2, float var3, boolean var4) {
      return var1.method_1022(var2) <= var3
         && (var4 || !RaycastHelper.method1339(var1, var2, class_3960.field_17558).method_17783().equals(class_240.field_1332));
   }

   private class_243 method1078(List<class_243> var1, Rotation var2) {
      return var1.stream().min(Comparator.comparing(var2x -> this.method1333(field0796.field_1724.method_33571(), var2x, var2))).orElse(null);
   }

   private double method1333(class_243 var1, class_243 var2, Rotation var3) {
      Rotation var4 = RotationHelper.method1296(var2.method_1020(var1));
      Rotation var5 = RotationHelper.method0872(var3, var4);
      return Math.hypot(var5.method2047(), var5.method1762());
   }

   private void method1300(class_243 var1) {
      this.field0157 = this.field0157
         .method_1031(this.field0721.nextGaussian(), this.field0721.nextGaussian(), this.field0721.nextGaussian())
         .method_18806(var1);
   }

   @Generated
   public Random method0561() {
      return this.field0721;
   }

   @Generated
   public class_243 method0024() {
      return this.field0157;
   }
}
