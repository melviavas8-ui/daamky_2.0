package aethereal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.Generated;
import net.minecraft.class_1268;
import net.minecraft.class_1291;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_266;
import net.minecraft.class_2680;
import net.minecraft.class_2824;
import net.minecraft.class_2848;
import net.minecraft.class_2886;
import net.minecraft.class_304;
import net.minecraft.class_3532;
import net.minecraft.class_4050;
import net.minecraft.class_408;
import net.minecraft.class_437;
import net.minecraft.class_5250;
import net.minecraft.class_6880;
import net.minecraft.class_7204;
import net.minecraft.class_8646;
import net.minecraft.class_9013;
import net.minecraft.class_9025;
import net.minecraft.class_2828.class_2830;
import net.minecraft.class_2848.class_2849;
import net.minecraft.class_3675.class_307;
import org.lwjgl.glfw.GLFW;
import ua.patch.daamky.api.mixins.accessors.IClientPlayerInteractionManager;

public final class PlayerActionHelper implements MinecraftAccess {
   public static void method1534(class_7204 var0) {
      ((IClientPlayerInteractionManager)field0796.field_1761).invokeSendSequencedPacket(field0796.field_1687, var0);
   }

   public static void method1119(class_1268 var0) {
      method1121(var0, RotationHelper.method0545());
   }

   public static void method1121(class_1268 var0, Rotation var1) {
      method1534(var2 -> new class_2886(var0, var2, var1.method2047(), var1.method1762()));
   }

   public static void method1128(class_1297 var0) {
      field0796.field_1724.field_3944.method_52787(class_2824.method_34208(var0, false, class_1268.field_5808, var0.method_5829().method_1005()));
      field0796.field_1724.field_3944.method_52787(class_2824.method_34207(var0, false, class_1268.field_5808));
   }

   public static void method0578() {
      field0796.field_1724.field_3944.method_52787(new class_2848(field0796.field_1724, class_2849.field_12982));
      field0796.field_1724.method_23669();
   }

   public static void method1354(class_2596<?> var0) {
      field0796.method_1562().method_48296().method_10752(var0, null);
   }

   public static void method0638(double var0, Rotation var2) {
      field0796.field_1724
         .field_3944
         .method_52787(
            new class_2830(
               field0796.field_1724.method_23317(),
               field0796.field_1724.method_23318() + var0,
               field0796.field_1724.method_23321(),
               var2.method2047(),
               var2.method1762(),
               field0796.field_1724.method_24828(),
               field0796.field_1724.field_5976
            )
         );
   }

   public static String method1156(class_1309 var0) {
      return method0663(method0238(var0));
   }

   public static String method0663(float var0) {
      return String.format("%.1f", var0).replace(",", ".").replace(".0", "");
   }

   public static float method0238(class_1309 var0) {
      float var1 = var0.method_6032() + var0.method_6067();
      if (var0 instanceof class_1657 var2) {
         switch (ServerEnvironment.field0715) {
            case "FunTime":
            case "ReallyWorld":
            case "GulPvP":
               class_266 var5 = var2.method_7327().method_1189(class_8646.field_45158);
               if (var5 != null) {
                  class_5250 var6 = class_9013.method_55398(var2.method_7327().method_55430(var2, var5), var5.method_55380(class_9025.field_47566));

                  try {
                     var1 = Float.parseFloat(var6.getString().replaceAll("§.", ""));
                  } catch (NumberFormatException var8) {
                  }
               }
         }
      }

      return class_3532.method_15363(var1, 0.0F, var0.method_6063());
   }

   public static void method0025() {
      if (field0796.field_1724.method_5624()) {
         float var0 = field0796.field_1724.method_36454() * (float) (Math.PI / 180.0);
         field0796.field_1724.method_45319(new class_243(-class_3532.method_15374(var0) * 0.2F, 0.0, class_3532.method_15362(var0) * 0.2F));
      }

      field0796.field_1724.field_6007 = true;
   }

   public static List<class_2338> method1265(class_2338 var0, float var1) {
      return method1267(var0, var1, var1, true);
   }

   public static List<class_2338> method1266(class_2338 var0, float var1, float var2) {
      return method1267(var0, var1, var2, true);
   }

   public static List<class_2338> method1267(class_2338 var0, float var1, float var2, boolean var3) {
      List var4 = new ArrayList<>();
      int var5 = var0.method_10263();
      int var6 = var0.method_10264();
      int var7 = var0.method_10260();
      int var8 = var3 ? var6 - (int)var2 : var6;

      for (int var9 = var5 - (int)var1; var9 <= var5 + var1; var9++) {
         for (int var10 = var7 - (int)var1; var10 <= var7 + var1; var10++) {
            for (int var11 = var8; var11 <= var6 + var2; var11++) {
               var4.add(new class_2338(var9, var11, var10));
            }
         }
      }

      return var4;
   }

   public static List<class_2338> method1271(class_2338 var0, class_2338 var1) {
      List var2 = new ArrayList<>();

      for (int var3 = var0.method_10263(); var3 <= var1.method_10263(); var3++) {
         for (int var4 = var0.method_10260(); var4 <= var1.method_10260(); var4++) {
            for (int var5 = var0.method_10264(); var5 <= var1.method_10264(); var5++) {
               var2.add(new class_2338(var3, var5, var4));
            }
         }
      }

      return var2;
   }

   public static class_307 method0728(int var0) {
      return var0 < 8 ? class_307.field_1672 : class_307.field_1668;
   }

   public static Stream<class_1297> method2071() {
      return StreamSupport.stream(field0796.field_1687.method_18112().spliterator(), false);
   }

   public static boolean method1447(class_4050 var0, class_243 var1) {
      return field0796.field_1724
         .method_37908()
         .method_8587(field0796.field_1724, field0796.field_1724.method_18377(var0).method_30757(var1).method_1011(1.0000000723087441E-7));
   }

   public static boolean method1531(class_6880<class_1291> var0) {
      return field0796.field_1724.method_6088().containsKey(var0);
   }

   public static boolean method1253(class_2248 var0) {
      return method1290(field0796.field_1724.method_5829().method_1014(-9.999996362687362E-4), var0);
   }

   public static boolean method1290(class_238 var0, class_2248 var1) {
      return method1289(var0, var1x -> field0796.field_1687.method_8320(var1x).method_26204().equals(var1));
   }

   public static boolean method1288(class_238 var0, List<class_2248> var1) {
      return method1289(var0, var1x -> var1.contains(field0796.field_1687.method_8320(var1x).method_26204()));
   }

   public static boolean method1289(class_238 var0, Predicate<class_2338> var1) {
      return class_2338.method_29715(var0).anyMatch(var1);
   }

   public static boolean method0882(KeyBindSetting var0) {
      int var1 = var0.method1879();
      return field0796.field_1755 == null && var0.method0026() && method1445(method0728(var1), var1);
   }

   public static boolean method1396(class_304 var0) {
      return method1445(var0.method_1429().method_1442(), var0.method_1429().method_1444());
   }

   public static boolean method1445(class_307 var0, int var1) {
      if (var1 != -1) {
         switch (var0) {
            case field_1668:
               return GLFW.glfwGetKey(field0796.method_22683().method_4490(), var1) == 1;
            case field_1672:
               return GLFW.glfwGetMouseButton(field0796.method_22683().method_4490(), var1) == 1;
         }
      }

      return false;
   }

   public static boolean method1264(class_2338 var0) {
      return method1363(field0796.field_1687.method_8320(var0));
   }

   public static boolean method1363(class_2680 var0) {
      return var0.method_26215() || var0.method_26204().equals(class_2246.field_10543) || var0.method_26204().equals(class_2246.field_10243);
   }

   public static boolean method1451(class_437 var0) {
      return var0 instanceof class_408;
   }

   public static boolean method1813() {
      return field0796.field_1724 == null || field0796.field_1687 == null;
   }

   @Generated
   private PlayerActionHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
