package aethereal;

import java.awt.Color;
import lombok.Generated;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_243;
import net.minecraft.class_2678;
import net.minecraft.class_2724;
import net.minecraft.class_2828;
import net.minecraft.class_5498;
import org.joml.Vector2d;

public class FreeCam extends Module {
   public static FreeCam field0061;
   private final FloatSetting field1450 = new FloatSetting("freecam.speed", 2.0F, 0.5F, 5.0F, 0.1F)
      .method1007("Speed")
      .method0210("Camera fly speed")
      .method2130("Скорость камеры");
   private final BooleanSetting field0970 = new BooleanSetting("freecam.freeze", false)
      .method1007("Freeze")
      .method0210("Freeze player in place while camera flies")
      .method2130("Замораживает игрока на месте");
   private final BooleanSetting field0184 = new BooleanSetting("freecam.showmodel", true)
      .method1007("Show Model")
      .method0210("Render a static ghost of your player at the locked position")
      .method2130("Рисует вашу модель игрока на месте включения модуля");
   private final BooleanSetting field0464 = new BooleanSetting("freecam.modelfill", true, this.field0184::method0492)
      .method1007("Fill")
      .method0210("Render filled model")
      .method2130("Заливка модели");
   private final ColorSetting field1623 = new ColorSetting(
         "freecam.modelfillcolor", 255, 156, 228, 100, () -> this.field0184.method0492() && this.field0464.method0492()
      )
      .method1882()
      .method1007("Fill Color")
      .method0210("Color of the filled ghost model")
      .method2130("Цвет заливки модели");
   private final BooleanSetting field1544 = new BooleanSetting("freecam.modeloutline", true, this.field0184::method0492)
      .method1007("Outline")
      .method0210("Render outline around ghost model")
      .method2130("Обводка модели");
   private final ColorSetting field1711 = new ColorSetting(
         "freecam.modeloutlinecolor", 255, 156, 228, 255, () -> this.field0184.method0492() && this.field1544.method0492()
      )
      .method1882()
      .method1007("Outline Color")
      .method0210("Color of the ghost model outline")
      .method2130("Цвет обводки модели");
   private class_243 field1158;
   private class_243 field1107;
   private StaticPlayerEntity field1202;
   private class_243 field0889;

   public FreeCam() {
      super("FreeCam", ModuleCategory.field0776, "Free-flying camera detached from the player");
      this.method1013("Свободная камера полёта");
      field0061 = this;
   }

   @Override
   public void method0025() {
      super.method0025();
      if (field0796.field_1724 != null && field0796.field_1687 != null && field0796.field_1773 != null && field0796.field_1773.method_19418() != null) {
         field0796.field_1730 = false;
         this.field1107 = this.field1158 = field0796.field_1773.method_19418().method_19326();
         this.field1202 = new StaticPlayerEntity(field0796.field_1724);
         this.field0889 = field0796.field_1724.method_19538();
      } else {
         this.method0345(false);
      }
   }

   @Override
   public void method2078() {
      super.method2078();
      if (field0796.field_1687 != null) {
         field0796.field_1730 = true;
      }

      this.field1202 = null;
      this.field0889 = null;
   }

   @EventHandler
   public void onPacketSend(PacketEvent.Outbound var1) {
      if (this.field0970.method0492() && var1.method1970() instanceof class_2828) {
         var1.method0578();
      }
   }

   @EventHandler
   public void onPacketReceive(PacketEvent.Inbound var1) {
      if (var1.method1970() instanceof class_2724 || var1.method1970() instanceof class_2678) {
         this.method0345(false);
      }
   }

   @EventHandler
   public void onMove(MovementEvent var1) {
      if (this.field0970.method0492()) {
         var1.method1300(class_243.field_1353);
      }
   }

   @EventHandler
   public void onMoveInput(MoveInputEvent var1) {
      if (!method1974() && this.field1158 != null) {
         double var2 = this.field1450.method0492().doubleValue();
         Vector2d var4 = this.method0635(var2, var1.method1603(), var1.method1946());
         double var5 = 0.0;
         if (var1.method1797() != null) {
            if (var1.method1797().comp_3163()) {
               var5 = var2;
            } else if (var1.method1797().comp_3164()) {
               var5 = -var2;
            }
         }

         this.field1107 = this.field1158;
         this.field1158 = this.field1158.method_1031(var4.x, var5, var4.y);
         var1.method0665(0.0F);
         var1.method0124(0.0F);
      }
   }

   @EventHandler
   public void onRenderWorld(GlowRenderEvent var1) {
      if (this.field0184.method0492() && this.field1202 != null && this.field0889 != null) {
         if (field0796.field_1687 != null) {
            this.field1202.method1300(this.field0889);
            Color var2 = new Color(this.field1623.method1742(), this.field1623.method2019(), this.field1623.method2002(), this.field1623.method2036());
            Color var3 = new Color(this.field1711.method1742(), this.field1711.method2019(), this.field1711.method2002(), this.field1711.method2036());

            try {
               this.field1202.method0713(var1.method1603(), this.field0464.method0492(), var2, this.field1544.method0492(), var3, false);
            } catch (Exception var5) {
            }
         }
      }
   }

   @EventHandler
   public void onCamera(CameraEvent var1) {
      if (this.method2195() && this.field1158 != null && this.field1107 != null) {
         class_243 var2 = MathHelper.method1328(this.field1107, this.field1158);
         var1.method0611(var2.field_1352);
         var1.method0103(var2.field_1351);
         var1.method2086(var2.field_1350);
         if (field0796.field_1690 != null && field0796.field_1690.method_31044() != class_5498.field_26664) {
            field0796.field_1690.method_31043(class_5498.field_26664);
         }
      }
   }

   private Vector2d method0635(double var1, float var3, float var4) {
      if (field0796.field_1724 == null) {
         return new Vector2d(0.0, 0.0);
      }

      float var5 = field0796.field_1724.method_36454();
      float var6 = var3;
      float var7 = var4;
      if (var6 == 0.0F && var7 == 0.0F) {
         return new Vector2d(0.0, 0.0);
      }

      if (var6 != 0.0F) {
         if (var7 >= 1.0F) {
            var5 += var6 > 0.0F ? -45.0F : 45.0F;
            var7 = 0.0F;
         } else if (var7 <= -1.0F) {
            var5 += var6 > 0.0F ? 45.0F : -45.0F;
            var7 = 0.0F;
         }

         var6 = var6 > 0.0F ? 1.0F : -1.0F;
      }

      double var8 = Math.cos(Math.toRadians(var5 + 90.0F));
      double var10 = Math.sin(Math.toRadians(var5 + 90.0F));
      return new Vector2d(var6 * var1 * var8 + var7 * var1 * var10, var6 * var1 * var10 - var7 * var1 * var8);
   }

   @Generated
   public FloatSetting method1711() {
      return this.field1450;
   }

   @Generated
   public BooleanSetting method1682() {
      return this.field0970;
   }

   @Generated
   public BooleanSetting method1743() {
      return this.field0184;
   }

   @Generated
   public BooleanSetting method2021() {
      return this.field0464;
   }

   @Generated
   public ColorSetting method2006() {
      return this.field1623;
   }

   @Generated
   public BooleanSetting method2037() {
      return this.field1544;
   }

   @Generated
   public ColorSetting method0465() {
      return this.field1711;
   }

   @Generated
   public class_243 method0456() {
      return this.field1158;
   }

   @Generated
   public class_243 method0478() {
      return this.field1107;
   }

   @Generated
   public StaticPlayerEntity method0401() {
      return this.field1202;
   }

   @Generated
   public class_243 method0397() {
      return this.field0889;
   }
}
