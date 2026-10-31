package aethereal;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.class_2596;

public final class PacketQueue implements MinecraftAccess {
   private static final List<class_2596<?>> field0719 = new ArrayList<>();

   public static void method1354(class_2596<?> var0) {
      field0719.add(var0);
      field0796.method_1562().method_52787(var0);
   }

   public static void method0300(class_2596<?> var0) {
      field0796.method_1562().method_52787(var0);
   }

   @Generated
   private PacketQueue() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   @Generated
   public static List<class_2596<?>> method0559() {
      return field0719;
   }
}
