package aethereal;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import net.minecraft.class_2338;

public final class BlockAreaScanner {
   public static List<class_2338> method1268(class_2338 var0, int var1, int var2, boolean var3) {
      List var4 = new ArrayList<>();
      int var5 = var3 ? var0.method_10264() - var2 : var0.method_10264();
      int var6 = var0.method_10264() + var2;

      for (int var7 = var0.method_10263() - var1; var7 <= var0.method_10263() + var1; var7++) {
         for (int var8 = var5; var8 <= var6; var8++) {
            for (int var9 = var0.method_10260() - var1; var9 <= var0.method_10260() + var1; var9++) {
               var4.add(new class_2338(var7, var8, var9));
            }
         }
      }

      return var4;
   }

   @Generated
   private BlockAreaScanner() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
