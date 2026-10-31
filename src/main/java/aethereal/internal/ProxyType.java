package aethereal;

import lombok.Generated;

public enum ProxyType {
   field0678("SOCKS5"),
   field0106("SOCKS4"),
   field1480("HTTP");

   private final String field1030;

   ProxyType(String var3) {
      this.field1030 = var3;
   }

   public static ProxyType method1006(String var0) {
      for (ProxyType var4 : values()) {
         if (var4.field1030.equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return field0678;
   }

   @Generated
   public String method0557() {
      return this.field1030;
   }
}
