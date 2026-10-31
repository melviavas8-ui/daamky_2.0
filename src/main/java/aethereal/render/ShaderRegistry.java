package aethereal;

import com.google.gson.JsonParser;
import com.mojang.serialization.JsonOps;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.class_10141;
import net.minecraft.class_10149;
import net.minecraft.class_10156;
import net.minecraft.class_10157;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_5913;
import net.minecraft.class_5944;
import net.minecraft.class_10141.class_282;
import ua.patch.daamky.api.mixins.accessors.ShaderLoaderInvoker;

public final class ShaderRegistry {
   private static final Map<class_10156, class_5944> field0720 = new HashMap<>();

   private ShaderRegistry() {
   }

   public static class_5944 method1112(class_10156 var0) {
      return field0720.get(var0);
   }

   public static void method0578() {
      method0231(new class_10156(DaamkyClient.method1012("core/msdf_font"), class_290.field_1575, class_10149.field_53930));
      method0231(new class_10156(DaamkyClient.method1012("core/rectangle"), class_290.field_1576, class_10149.field_53930));
      method0231(new class_10156(DaamkyClient.method1012("core/splash_loader"), class_290.field_1585, class_10149.field_53930));
   }

   private static void method0231(class_10156 var0) {
      try {
         class_2960 var1 = var0.comp_3113();
         String var2 = method1010("/assets/" + var1.method_12836() + "/shaders/" + var1.method_12832() + ".json");
         if (var2 == null) {
            return;
         }

         class_10157 var3 = (class_10157)class_10157.field_53949.parse(JsonOps.INSTANCE, JsonParser.parseString(var2)).getOrThrow(IllegalStateException::new);
         class_10149 var4 = var3.comp_3120().method_62928(var0.comp_3115());
         class_10141 var5 = method1394(var3.comp_3116(), class_282.field_1530, var4);
         class_10141 var6 = method1394(var3.comp_3117(), class_282.field_1531, var4);
         if (var5 == null || var6 == null) {
            return;
         }

         class_5944 var7 = ShaderLoaderInvoker.invokeCreateProgram(var0, var3, var5, var6);
         field0720.put(var0, var7);
      } catch (Throwable var8) {
      }
   }

   private static class_10141 method1394(final class_2960 var0, class_282 var1, class_10149 var2) throws Exception {
      String var3 = var1 == class_282.field_1530 ? ".vsh" : ".fsh";
      String var4 = method1010("/assets/" + var0.method_12836() + "/shaders/" + var0.method_12832() + var3);
      if (var4 == null) {
         return null;
      }

      class_5913 var5 = new class_5913() {
         public String method_34233(boolean var1, String var2x) {
            class_2960 var3 = var2x.contains(":") ? class_2960.method_12829(var2x) : class_2960.method_60655(var0.method_12836(), var2x);
            return var3 == null ? null : ShaderRegistry.method1010("/assets/" + var3.method_12836() + "/shaders/include/" + var3.method_12832());
         }
      };
      String var6 = String.join("\n", var5.method_34229(var4));
      String var7 = class_5913.method_62880(var6, var2);
      return class_10141.method_62882(var0, var1, var7);
   }

   private static String method1010(String var0) {
      try (InputStream var1 = ShaderRegistry.class.getResourceAsStream(var0)) {
         return var1 == null ? null : new String(var1.readAllBytes());
      } catch (Exception var6) {
         return null;
      }
   }
}
