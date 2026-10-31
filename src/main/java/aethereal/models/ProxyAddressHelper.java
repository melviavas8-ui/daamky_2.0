package aethereal;

import lombok.Generated;

public final class ProxyAddressHelper {
   public static boolean method0579() {
      return ClickGuiDashboard.field0984.method0492() == ClickGuiDashboard.Language.field0631;
   }

   public static String method1044(String var0, String var1) {
      return method0579() ? var1 : var0;
   }

   @Generated
   private ProxyAddressHelper() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
