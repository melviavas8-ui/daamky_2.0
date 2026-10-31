package aethereal;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import lombok.Generated;
import meteordevelopment.orbit.EventBus;
import meteordevelopment.orbit.IEventBus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ClientBootstrap {
   @Generated
   private static final Logger field0749 = LogManager.getLogger(ClientBootstrap.class);

   public static void method0790(DaamkyClient var0) {
      var0.field0959 = System.currentTimeMillis();
      DaamkyClient.field0573 = var0;
      IEventBus var1 = new EventBus();
      var1.registerLambdaFactory("", (var0x, var1x) -> (Lookup)var0x.invoke(null, var1x, MethodHandles.lookup()));
      var0.field1438 = new ClientContext();
      var0.field1438.method1111(var1);
      var0.field1438.method1745().method0578();
      Runtime.getRuntime().addShutdownHook(new Thread(() -> {
         field0749.info("[DaamkyInnovate] Saving config...");
         var0.method2216().method1634();
         var0.method1608().method1634();
         var0.method1956().method0498();
         var0.method0420().method1634();
      }));
      var0.field1438.method0363().method1973();
      var0.field1438.method0490().method2228();
      var0.field1438.method2221().method1973();
      var0.field1438.method1931().method1973();
      var0.field1438.method1931().method0578();
   }
}
