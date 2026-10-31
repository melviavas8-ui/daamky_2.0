package aethereal;

import lombok.Generated;

public final class EnumCycler {
   public static int method0980(Enum<?> var0) {
      for (int var1 = 0; var1 < ((Enum[])var0.getDeclaringClass().getEnumConstants()).length; var1++) {
         Enum var2 = ((Enum[])var0.getDeclaringClass().getEnumConstants())[var1];
         if (var2.name().equalsIgnoreCase(var0.name())) {
            return var1;
         }
      }

      return -1;
   }

   public static Enum<?> method0203(Enum<?> var0) {
      int var1 = method0980(var0);

      for (int var2 = 0; var2 < ((Enum[])var0.getDeclaringClass().getEnumConstants()).length; var2++) {
         Enum var3 = ((Enum[])var0.getDeclaringClass().getEnumConstants())[var2];
         if (var2 == var1 + 1) {
            return var3;
         }
      }

      return ((Enum[])var0.getDeclaringClass().getEnumConstants())[0];
   }

   @Generated
   private EnumCycler() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
