package aethereal;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3300;

public final class ResourceHelper {
   private static final Gson field0710 = new Gson();

   private static class_3300 method0573() {
      return class_310.method_1551().method_1478();
   }

   public static class_2960 method1012(String var0) {
      return DaamkyClient.method1012("core/" + var0);
   }

   public static JsonObject method1390(class_2960 var0) {
      return JsonParser.parseString(method0306(var0)).getAsJsonObject();
   }

   public static <T> T method1392(class_2960 var0, Class<T> var1) {
      return (T)field0710.fromJson(method0306(var0), var1);
   }

   public static String method0306(class_2960 var0) {
      return method1393(var0, "\n");
   }

   public static String method1393(class_2960 var0, String var1) {
      try (
         InputStream var2 = method0573().open(var0);
         BufferedReader var3 = new BufferedReader(new InputStreamReader(var2));
      ) {
         return var3.lines().collect(Collectors.joining(var1));
      } catch (IOException var10) {
         throw new RuntimeException(var10);
      }
   }
}
