package aethereal;

import lombok.Generated;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1294;
import net.minecraft.class_1657;
import net.minecraft.class_2663;
import net.minecraft.class_2828;
import net.minecraft.class_2848;
import net.minecraft.class_2868;

public class NetworkTickTracker implements MinecraftAccess {
   private int field0567;
   private float field0003;
   private float field1410;
   private float field0957;
   private double field0176;
   private double field0457;
   private double field1613;
   private boolean field1574;
   private boolean field1735;
   private boolean field1161;
   private boolean field1109;
   private double field1195 = Double.NaN;

   public NetworkTickTracker() {
      DaamkyClient.method2004().method2072().subscribe(this);
   }

   public boolean method0579() {
      return field0796.field_1724 == null
         ? false
         : !this.field1574
            && this.field0957 > 0.0F
            && !field0796.field_1724.method_6101()
            && !field0796.field_1724.method_5799()
            && !field0796.field_1724.method_6059(class_1294.field_5919)
            && !field0796.field_1724.method_5765();
   }

   @EventHandler
   public void onPacketSend(PacketEvent.Outbound var1) {
      if (!Module.method1974()) {
         if (var1.method1970() instanceof class_2828 var2) {
            boolean var10 = var2.method_12273();
            if (var2.method_36171()) {
               double var4 = var2.method_12268(field0796.field_1724.method_23318());
               if (var10) {
                  this.field0957 = 0.0F;
               } else if (!Double.isNaN(this.field1195)) {
                  double var6 = this.field1195 - var4;
                  if (var6 > 0.0) {
                     this.field0957 += (float)var6;
                  } else if (var6 < 0.0) {
                     this.field0957 = 0.0F;
                  }
               }

               this.field1195 = var4;
               this.field0176 = var2.method_12269(field0796.field_1724.method_23317());
               this.field0457 = var4;
               this.field1613 = var2.method_12274(field0796.field_1724.method_23321());
            } else if (var10) {
               this.field0957 = 0.0F;
            }

            if (var2.method_36172()) {
               this.field0003 = var2.method_12271(field0796.field_1724.method_36454());
               this.field1410 = var2.method_12270(field0796.field_1724.method_36455());
            }

            this.field1574 = var10;
            this.field1109 = var2.method_61225();
         }

         if (var1.method1970() instanceof class_2868 var8) {
            this.field0567 = var8.method_12442();
         }

         if (var1.method1970() instanceof class_2848 var9) {
            switch (var9.method_12365()) {
               case field_12981:
                  this.field1735 = true;
                  break;
               case field_12985:
                  this.field1735 = false;
                  break;
               case field_12979:
                  this.field1161 = true;
                  break;
               case field_12984:
                  this.field1161 = false;
            }
         }
      }
   }

   @EventHandler
   public void onPacketReceive(PacketEvent.Inbound var1) {
      if (!Module.method1974()) {
         if (var1.method1970() instanceof class_2663 var2 && var2.method_11470() == 35) {
            if (!(var2.method_11469(field0796.field_1687) instanceof class_1657 var5)) {
               return;
            }

            DaamkyClient.method2004().method2072().post(new TotemPopEvent(var5));
         }
      }
   }

   @Generated
   public int method0003() {
      return this.field0567;
   }

   @Generated
   public float method2047() {
      return this.field0003;
   }

   @Generated
   public float method1762() {
      return this.field1410;
   }

   @Generated
   public float method1603() {
      return this.field0957;
   }

   @Generated
   public double method1945() {
      return this.field0176;
   }

   @Generated
   public double method0412() {
      return this.field0457;
   }

   @Generated
   public double method0354() {
      return this.field1613;
   }

   @Generated
   public boolean method0499() {
      return this.field1574;
   }

   @Generated
   public boolean method2229() {
      return this.field1735;
   }

   @Generated
   public boolean method2195() {
      return this.field1161;
   }

   @Generated
   public boolean method2267() {
      return this.field1109;
   }

   @Generated
   public double method1900() {
      return this.field1195;
   }
}
