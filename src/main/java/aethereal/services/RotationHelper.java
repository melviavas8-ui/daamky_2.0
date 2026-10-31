package aethereal;

import lombok.Generated;
import net.minecraft.class_1297;
import net.minecraft.class_1675;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_241;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3966;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import org.jetbrains.annotations.NotNull;

public final class RotationHelper implements MinecraftAccess {
   public static Rotation method1295(class_241 var0) {
      return new Rotation(var0.field_1342, var0.field_1343);
   }

   public static float method0667(float var0, float var1) {
      return class_3532.method_15393(var0 - var1);
   }

   public static Rotation method1296(class_243 var0) {
      return new Rotation(
         (float)class_3532.method_15338(Math.toDegrees(Math.atan2(var0.field_1350, var0.field_1352)) - 90.0),
         (float)class_3532.method_15338(Math.toDegrees(-Math.atan2(var0.field_1351, Math.hypot(var0.field_1352, var0.field_1350))))
      );
   }

   public static Rotation method0872(Rotation var0, Rotation var1) {
      float var2 = class_3532.method_15393(var1.method2047() - var0.method2047());
      float var3 = class_3532.method_15393(var1.method1762() - var0.method1762());
      return new Rotation(var2, var3);
   }

   public static Rotation method0287(class_243 var0) {
      return method1296(var0.method_1020(field0796.field_1724.method_33571()));
   }

   public static Rotation method0657(float var0) {
      return new Rotation(field0796.field_1724.method_36454(), var0);
   }

   public static Rotation method0545() {
      return new Rotation(field0796.field_1724.method_36454(), field0796.field_1724.method_36455());
   }

   public static boolean method0699(float var0, float var1, float var2, float var3, class_1297 var4) {
      class_239 var5 = method0634(var2, var0, var1);
      class_243 var6 = field0796.field_1724.method_19538().method_1031(0.0, field0796.field_1724.method_18381(field0796.field_1724.method_18376()), 0.0);
      double var7 = Math.pow(var2, 2.0);
      Aura var9 = Aura.method1701();
      if (var5 != null) {
         var7 = var6.method_1025(var5.method_17784());
      }

      class_243 var10 = method0127(var1, var0).method_1021(var2);
      class_243 var11 = var6.method_1019(var10);
      class_238 var12 = field0796.field_1724.method_5829().method_18804(var10).method_1009(1.0, 1.0, 1.0);
      double var14 = Math.max(var7, Math.pow(var3, 2.0));
      class_3966 var13 = class_1675.method_18075(
         field0796.field_1724, var6, var11, var12, var1x -> !var1x.method_7325() && var1x.method_5863() && var1x == var4, var14
      );
      if (var13 != null) {
         boolean var16 = var6.method_1025(var13.method_17784()) <= Math.pow(var3, 2.0);
         boolean var17 = var5 == null;
         boolean var18 = var6.method_1025(var13.method_17784()) < var7;
         if (var6.method_1025(var13.method_17784()) <= Math.pow(var2, 2.0)) {
            double var19 = var4.method_23318();
            double var21 = var4.method_17682();
            double var23 = var19 + var21 * 0.30000000940645094;
            if (var13.method_17784().field_1351 >= var23) {
               return var13.method_17782() == var4;
            }
         }
      }

      return false;
   }

   public static class_239 method0634(double var0, float var2, float var3) {
      class_243 var4 = field0796.field_1724.method_5836(1.0F);
      class_243 var5 = method0127(var3, var2);
      class_243 var6 = var4.method_1031(var5.field_1352 * var0, var5.field_1351 * var0, var5.field_1350 * var0);
      return field0796.field_1687.method_17742(new class_3959(var4, var6, class_3960.field_17559, class_242.field_1348, field0796.field_1724));
   }

   @NotNull
   public static class_243 method0127(float var0, float var1) {
      return new class_243(
         class_3532.method_15374(-var1 * (float) (Math.PI / 180.0)) * class_3532.method_15362(var0 * (float) (Math.PI / 180.0)),
         -class_3532.method_15374(var0 * (float) (Math.PI / 180.0)),
         class_3532.method_15362(-var1 * (float) (Math.PI / 180.0)) * class_3532.method_15362(var0 * (float) (Math.PI / 180.0))
      );
   }

   @Generated
   private RotationHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
