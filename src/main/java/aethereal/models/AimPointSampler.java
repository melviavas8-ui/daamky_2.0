package aethereal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_3532;

public class AimPointSampler {
   private static final Random field0721 = new Random();
   private static final IntervalTimer field0077 = new IntervalTimer();
   private static final IntervalTimer field1463 = new IntervalTimer();
   private static List<class_243> field1032 = new ArrayList<>();
   private static int field0759 = 0;

   public static class_243 method1135(class_1297 var0, float var1, float var2, float var3, float var4) {
      double var5 = var0.method_17681() / var4;
      double var7 = class_3532.method_15350(var0.method_23320() - var0.method_23318(), 0.0, var0.method_17682());
      double var9 = class_3532.method_15350(MinecraftAccess.field0796.field_1724.method_23317() - var0.method_23317(), -var5, var5);
      double var11 = class_3532.method_15350(MinecraftAccess.field0796.field_1724.method_23321() - var0.method_23321(), -var5, var5);
      return new class_243(var0.method_23317() + var9 / var1, var0.method_23318() + var7 / var2, var0.method_23321() + var11 / var3);
   }

   public static class_243 method1134(class_1297 var0, float var1, float var2) {
      double var3 = MinecraftAccess.field0796.field_1724.method_19538().method_1022(var0.method_19538());
      double var5 = class_3532.method_15350((var3 - var1) / (var2 - var1), 0.0, 1.0);
      double var7 = var5;
      double var9 = 0.20000000852947503;
      double var11 = 0.7999999050060296;
      double var13 = var9 + (var11 - var9) * var7;
      double var15 = var0.method_23318() + var0.method_17682() * var13;
      return new class_243(var0.method_23317(), var15, var0.method_23321());
   }

   public static class_243 method1139(class_1297 var0, int var1, float var2) {
      if (field1463.method0104(1000.0) || field1032.isEmpty()) {
         method0236(var0, var1);
         field0759 = 0;
         field0077.method0578();
      }

      if (field0077.method0612(var2)) {
         field0759 = (field0759 + 1) % field1032.size();
         field0077.method0578();
      }

      return field1032.isEmpty() ? var0.method_19538() : field1032.get(field0759);
   }

   private static void method0236(class_1297 var0, int var1) {
      field1032.clear();
      double var2 = var0.method_17681();
      double var4 = var0.method_17682();
      class_243 var6 = var0.method_19538();

      for (int var7 = 0; var7 < var1; var7++) {
         double var8 = var6.field_1352 + (field0721.nextDouble() - 0.5) * var2;
         double var10 = var6.field_1351 + field0721.nextDouble() * var4;
         double var12 = var6.field_1350 + (field0721.nextDouble() - 0.5) * var2;
         field1032.add(new class_243(var8, var10, var12));
      }
   }

   public static List<class_243> method0559() {
      return new ArrayList<>(field1032);
   }

   public static int method0003() {
      return field0759;
   }

   public static long method2049() {
      return field0077.method0004();
   }

   public static void method1812() {
      field1032.clear();
      field0759 = 0;
      field0077.method0578();
      field1463.method0578();
   }

   public static void method1138(class_1297 var0, int var1) {
      method0236(var0, var1);
      field0759 = 0;
      field0077.method0578();
      field1463.method0578();
   }
}
