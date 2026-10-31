package aethereal;

import java.awt.Color;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_238;
import net.minecraft.class_2596;
import net.minecraft.class_2678;
import net.minecraft.class_2724;
import net.minecraft.class_2799;
import net.minecraft.class_2799.class_2800;

public class Blink extends Module {
   private final List<class_2596<?>> field1508 = new CopyOnWriteArrayList<>();
   private class_238 field1042;
   public static int field0004 = -1;

   public Blink() {
      super("Blink", ModuleCategory.field0088, "Holds outgoing packets and releases them on disable");
      this.method1013("Задерживает отправку пакетов движения до отключения модуля");
   }

   @Override
   public void method0025() {
      super.method0025();
      if (field0796.field_1724 != null) {
         this.field1042 = field0796.field_1724.method_5829();
      }
   }

   private void method1354(class_2596<?> var1) {
      if (field0796.field_1724 != null && field0796.field_1724.field_3944 != null) {
         PacketQueue.method1354(var1);
      }
   }

   @Override
   public void method2078() {
      this.field1508.forEach(this::method1354);
      this.field1508.clear();
      super.method2078();
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (field0796.field_1724 != null && field0796.field_1687 != null) {
         field0004--;
         if (field0004 >= 0 && !this.field1508.isEmpty()) {
            this.field1042 = field0796.field_1724.method_5829();
            this.field1508.forEach(this::method1354);
            this.field1508.clear();
         }
      }
   }

   @EventHandler
   public void onPacketSend(PacketEvent.Outbound var1) {
      if (field0796.field_1724 != null && field0796.field_1687 != null) {
         if (field0004 < 0) {
            this.field1508.add(var1.method1970());
            var1.method0578();
         }
      }
   }

   @EventHandler
   public void onPacketReceive(PacketEvent.Inbound var1) {
      if (field0796.field_1724 != null && field0796.field_1687 != null) {
         switch (var1.method1970()) {
            case class_2724 var4:
               this.method0345(false);
               break;
            case class_2678 var5:
               this.method0345(false);
               break;
            default:
         }
      }
   }

   @EventHandler
   public void onPacketAll(PacketEvent.Transfer var1) {
      if (field0796.field_1724 != null && field0796.field_1687 != null) {
         if (var1.method1970() instanceof class_2799 var2 && var2.method_12119() == class_2800.field_12774) {
            this.method0345(false);
         }
      }
   }

   @EventHandler
   public void onWorldRender(WorldRenderEvent.GamePass var1) {
      if (this.field1042 != null) {
         WorldRenderHelper.method2173(var1.method1629(), this.field1042, new Color(255, 255, 255, 180));
      }
   }
}
