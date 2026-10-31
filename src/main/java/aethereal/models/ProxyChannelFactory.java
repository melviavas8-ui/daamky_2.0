package aethereal;

import io.netty.handler.proxy.HttpProxyHandler;
import io.netty.handler.proxy.ProxyHandler;
import io.netty.handler.proxy.Socks4ProxyHandler;
import io.netty.handler.proxy.Socks5ProxyHandler;
import java.net.InetSocketAddress;
import lombok.Generated;

public final class ProxyChannelFactory {
   public static ProxyHandler method0906(ProxyEntry var0) {
      if (var0 != null && var0.method1791() != null && !var0.method1791().isEmpty()) {
         InetSocketAddress var1 = new InetSocketAddress(var0.method1791(), var0.method1604());
         if (var1.isUnresolved()) {
            return null;
         }

         return (ProxyHandler)(switch (var0.method2060()) {
            case field0678 -> var0.method0579() ? new Socks5ProxyHandler(var1, var0.method1961(), var0.method0423()) : new Socks5ProxyHandler(var1);
            case field0106 -> var0.method0579() ? new Socks4ProxyHandler(var1, var0.method1961()) : new Socks4ProxyHandler(var1);
            case field1480 -> var0.method0579() ? new HttpProxyHandler(var1, var0.method1961(), var0.method0423()) : new HttpProxyHandler(var1);
         });
      } else {
         return null;
      }
   }

   @Generated
   private ProxyChannelFactory() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
