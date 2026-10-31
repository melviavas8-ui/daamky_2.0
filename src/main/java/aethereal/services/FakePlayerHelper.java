package aethereal;

import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_5134;
import net.minecraft.class_745;
import net.minecraft.class_1297.class_5529;

public final class FakePlayerHelper implements MinecraftAccess {
   private static final List<class_745> field0719 = new ArrayList<>();
   private static final float field0003 = 0.5F;
   private static final float field1410 = 1.5F;
   private static final double field0956 = 0.40000001590828516;

   private FakePlayerHelper() {
      throw new AssertionError("Utility class");
   }

   public static class_745 method1021(String var0, float var1, boolean var2) {
      if (var0 == null || var0.isEmpty()) {
         throw new IllegalArgumentException("Name cannot be null or empty");
      }

      if (var1 <= 0.0F) {
         throw new IllegalArgumentException("Health must be positive");
      }

      class_745 var3 = new class_745(field0796.field_1687, new GameProfile(UUID.randomUUID(), var0));
      var3.method_5814(field0796.field_1724.method_23317(), field0796.field_1724.method_23318(), field0796.field_1724.method_23321());
      var3.field_6014 = field0796.field_1724.method_23317();
      var3.field_6036 = field0796.field_1724.method_23318();
      var3.field_5969 = field0796.field_1724.method_23321();
      var3.method_36456(field0796.field_1724.method_36454());
      var3.method_36457(field0796.field_1724.method_36455());
      var3.field_6241 = field0796.field_1724.field_6241;
      var3.field_6283 = field0796.field_1724.field_6283;
      var3.field_5982 = field0796.field_1724.method_36454();
      var3.field_6004 = field0796.field_1724.method_36455();
      var3.field_6259 = field0796.field_1724.field_6241;
      var3.field_6220 = field0796.field_1724.field_6283;
      var3.method_6033(var1);
      if (var2) {
         method1540(var3, field0796.field_1724);
      }

      var3.method_5838(-100 - field0796.field_1687.method_18456().size());
      field0796.field_1687.method_53875(var3);
      field0719.add(var3);
      return var3;
   }

   public static float method1178(class_1657 var0) {
      float var1 = (float)var0.method_45325(class_5134.field_23721);
      float var2 = var0.method_7261(0.5F);
      float var3 = var1 * (0.2F + var2 * var2 * 0.8F);
      if (method0250(var0)) {
         var3 *= 1.5F;
      }

      return var3;
   }

   public static void method1538(class_745 var0, float var1, class_1657 var2) {
      method1539(var0, var1, var2, true);
   }

   public static void method1539(class_745 var0, float var1, class_1657 var2, boolean var3) {
      float var4 = Math.max(var0.method_6032() - var1, 0.5F);
      var0.method_6033(var4);
      var0.field_6235 = 10;
      var0.field_6254 = 10;
      var0.field_6008 = 20;
      var0.field_42108.method_48567(1.5F);
      if (var3) {
         double var5 = var0.method_23317() - var2.method_23317();

         double var7;
         for (var7 = var0.method_23321() - var2.method_23321();
            var5 * var5 + var7 * var7 < 9.999995134913989E-5;
            var7 = (Math.random() - Math.random()) * 0.010000000030013353
         ) {
            var5 = (Math.random() - Math.random()) * 0.010000000030013353;
         }

         var0.method_6005(0.40000001590828516, -var5, -var7);
         var0.field_6037 = true;
      }
   }

   public static boolean method0250(class_1657 var0) {
      float var1 = var0.method_7261(0.5F);
      return var1 > 0.9F
         && var0.field_6017 > 0.0F
         && !var0.method_24828()
         && !var0.method_6101()
         && !var0.method_5799()
         && !var0.method_6059(class_1294.field_5919)
         && !var0.method_5765()
         && !var0.method_5624();
   }

   public static void method0578() {
      if (field0796.field_1724 != null) {
         for (class_745 var1 : field0719) {
            method1540(var1, field0796.field_1724);
         }
      }
   }

   public static void method0025() {
      for (class_745 var1 : new ArrayList<>(field0719)) {
         var1.method_31472();
         if (field0796.field_1687 != null) {
            field0796.field_1687.method_2945(var1.method_5628(), class_5529.field_26999);
         }
      }

      field0719.clear();
   }

   public static List<class_745> method2068() {
      return Collections.unmodifiableList(field0719);
   }

   public static int method1763() {
      return field0719.size();
   }

   public static boolean method1129(class_1297 var0) {
      return field0719.contains(var0);
   }

   private static void method1540(class_745 var0, class_1657 var1) {
      for (int var2 = 0; var2 < var1.method_31548().method_5439(); var2++) {
         var0.method_31548().method_5447(var2, var1.method_31548().method_5438(var2).method_7972());
      }

      for (class_1304 var5 : class_1304.values()) {
         var0.method_5673(var5, var1.method_6118(var5).method_7972());
      }

      var0.method_31548().field_7545 = var1.method_31548().field_7545;
   }
}
