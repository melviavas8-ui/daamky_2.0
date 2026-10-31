package aethereal;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.Generated;

public final class ProxyTester {
   private static final int field0567 = 2500;
   private static final ExecutorService field0143 = Executors.newFixedThreadPool(4, new ThreadFactory() {
      private final AtomicInteger field0725 = new AtomicInteger();

      @Override
      public Thread newThread(Runnable var1) {
         Thread var2 = new Thread(var1, "daamky-proxy-tester-" + this.field0725.incrementAndGet());
         var2.setDaemon(true);
         return var2;
      }
   });

   public static void method0907(ProxyEntry var0) {
      if (var0 != null) {
         if (var0.method0365() != ProxyEntry.ProxyProtocol.field0104) {
            var0.method0905(ProxyEntry.ProxyProtocol.field0104);
            var0.method0143(-1);
            field0143.submit(() -> {
               try {
                  InetAddress var1 = InetAddress.getByName(var0.method1791());
                  InetSocketAddress var2 = new InetSocketAddress(var1, var0.method1604());
                  long[] var3 = new long[3];
                  int var4 = 0;

                  for (int var5 = 0; var5 < 3; var5++) {
                     Long var6 = method0909(var0.method2060(), var2);
                     if (var6 == null) {
                        if (var5 == 0) {
                           var0.method0143(-1);
                           var0.method0905(ProxyEntry.ProxyProtocol.field1012);
                           var0.method0778(System.currentTimeMillis());
                           ProxyGeoService.method0907(var0);
                           return;
                        }
                     } else {
                        var3[var4++] = var6;
                     }

                     Thread.sleep(80L);
                  }

                  if (var4 > 0) {
                     Arrays.sort(var3, 0, var4);
                     long var9 = var3[var4 / 2];
                     int var7 = (int)Math.max(1L, (var9 + 500000L) / 1000000L);
                     var0.method0143(var7);
                     var0.method0905(ProxyEntry.ProxyProtocol.field1478);
                  } else {
                     var0.method0143(-1);
                     var0.method0905(ProxyEntry.ProxyProtocol.field1012);
                  }
               } catch (Exception var8) {
                  var0.method0143(-1);
                  var0.method0905(ProxyEntry.ProxyProtocol.field1012);
               }

               var0.method0778(System.currentTimeMillis());
               ProxyGeoService.method0907(var0);
            });
         }
      }
   }

   private static Long method0909(ProxyType var0, InetSocketAddress var1) {
      long var2 = System.nanoTime();

      try (Socket var4 = new Socket()) {
         var4.connect(var1, 2500);
         var4.setSoTimeout(2500);
         if (var0 == ProxyType.field0678) {
            if (!method1066(var4)) {
               return null;
            }
         } else if (var0 == ProxyType.field1480 && !method1067(var4, var1)) {
            return null;
         }

         return System.nanoTime() - var2;
      } catch (Exception var9) {
         return null;
      }
   }

   private static boolean method1066(Socket var0) throws Exception {
      OutputStream var1 = var0.getOutputStream();
      var1.write(new byte[]{5, 1, 0});
      var1.flush();
      InputStream var2 = var0.getInputStream();
      int var3 = var2.read();
      int var4 = var2.read();
      return var3 == 5 && var4 != -1;
   }

   private static boolean method1067(Socket var0, InetSocketAddress var1) throws Exception {
      OutputStream var2 = var0.getOutputStream();
      String var3 = "CONNECT " + var1.getHostString() + ":" + var1.getPort() + " HTTP/1.1\r\nHost: " + var1.getHostString() + "\r\n\r\n";
      var2.write(var3.getBytes(StandardCharsets.US_ASCII));
      var2.flush();
      InputStream var4 = var0.getInputStream();
      byte[] var5 = new byte[12];
      int var6 = 0;

      while (var6 < 12) {
         int var7 = var4.read(var5, var6, 12 - var6);
         if (var7 < 0) {
            return false;
         }

         var6 += var7;
      }

      return var5[0] == 72 && var5[1] == 84 && var5[2] == 84 && var5[3] == 80;
   }

   public static void method0578() {
      for (ProxyEntry var1 : ProxyStorage.method1786().method1620()) {
         method0907(var1);
      }
   }

   @Generated
   private ProxyTester() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
