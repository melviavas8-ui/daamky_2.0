package aethereal;

import java.awt.Color;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1657;
import net.minecraft.class_243;

public class PopChams extends Module {
   private final FloatSetting field0060 = new FloatSetting("popchams.duration", 1500.0F, 500.0F, 5000.0F, 100.0F)
      .method1007("Duration")
      .method0210("How long the ghost model stays visible")
      .method2130("Время жизни");
   private final FloatSetting field1450 = new FloatSetting("popchams.fadetime", 500.0F, 100.0F, 2000.0F, 50.0F)
      .method1007("Fade Time")
      .method0210("Time for the ghost model to fade out")
      .method2130("Время затухания");
   private final BooleanSetting field0970 = new BooleanSetting("popchams.fill", true)
      .method1007("Fill")
      .method0210("Render filled ghost model")
      .method2130("Отрисовка заполненной модели");
   private final ColorSetting field0185 = new ColorSetting("popchams.fillcolor", 255, 0, 0, 100, this.field0970::method0492)
      .method1882()
      .method1007("Fill Color")
      .method0210("Color of the filled ghost model")
      .method2130("Цвет");
   private final BooleanSetting field0464 = new BooleanSetting("popchams.outline", true)
      .method1007("Outline")
      .method0210("Render outline around ghost model")
      .method2130("Обводка вокруг призрака");
   private final ColorSetting field1623 = new ColorSetting("popchams.outlinecolor", 255, 0, 0, 255, this.field0464::method0492)
      .method1882()
      .method1007("Outline Color")
      .method0210("Color of the ghost model outline")
      .method2130("Цвет обводки призрака");
   private final BooleanSetting field1544 = new BooleanSetting("popchams.shine", false)
      .method1007("Shine")
      .method0210("Add shine effect to ghost model")
      .method2130("Сияние");
   private final BooleanSetting field1709 = new BooleanSetting("popchams.self", false)
      .method1007("Self")
      .method0210("Show pop chams on yourself")
      .method2130("Показывать чамсы на себе");
   private final BooleanSetting field1141 = new BooleanSetting("popchams.rising", true)
      .method1007("Rising")
      .method0210("Ghost model rises upward over time")
      .method2130("Призрачная улетает на небеса");
   private final FloatSetting field1097 = new FloatSetting("popchams.risespeed", 0.5F, 0.1F, 2.0F, 0.1F, this.field1141::method0492)
      .method1007("Rise Speed")
      .method0210("Speed of the rising animation")
      .method2130("Скорость анимации подъёма");
   private final Map<Integer, PopChams.GhostEntity> field1214 = new ConcurrentHashMap<>();

   public PopChams() {
      super("PopChams", ModuleCategory.field1004, "Renders ghost model when a totem pops");
      this.method1013("Рисует призрака при срабатывании тотема");
   }

   @Override
   public void method2078() {
      super.method2078();
      this.field1214.clear();
   }

   @EventHandler
   public void onPopTotem(TotemPopEvent var1) {
      if (!method1974()) {
         class_1657 var2 = var1.method1800();
         if (var2 != null) {
            if (var2 != field0796.field_1724 || this.field1709.method0492()) {
               StaticPlayerEntity var3 = new StaticPlayerEntity(var2);
               PopChams.GhostEntity var4 = new PopChams.GhostEntity(var3, var2.method_19538(), System.currentTimeMillis());
               this.field1214.put(var2.method_5628(), var4);
            }
         }
      }
   }

   @EventHandler
   public void onRenderWorld(GlowRenderEvent var1) {
      if (!method1974()) {
         long var2 = System.currentTimeMillis();
         float var4 = this.field0060.method0492();
         float var5 = this.field1450.method0492();
         this.field1214.entrySet().removeIf(var6 -> {
            PopChams.GhostEntity var7 = var6.getValue();
            long var8 = var2 - var7.field1412;
            if ((float)var8 > var4) {
               return true;
            }

            float var10 = 1.0F;
            if ((float)var8 > var4 - var5) {
               var10 = 1.0F - ((float)var8 - (var4 - var5)) / var5;
            }

            var10 = Math.max(0.0F, Math.min(1.0F, var10));
            float var11 = 0.0F;
            if (this.field1141.method0492()) {
               float var12 = (float)var8 / var4;
               var11 = var12 * this.field1097.method0492();
            }

            this.method0904(var7, var10, var1.method1603(), var11);
            return false;
         });
      }
   }

   private void method0904(PopChams.GhostEntity var1, float var2, float var3, float var4) {
      class_243 var5 = var1.field0157.method_1031(0.0, var4, 0.0);
      var1.field0608.method1300(var5);
      Color var6 = new Color(this.field0185.method1742(), this.field0185.method2019(), this.field0185.method2002(), (int)(this.field0185.method2036() * var2));
      Color var7 = new Color(this.field1623.method1742(), this.field1623.method2019(), this.field1623.method2002(), (int)(this.field1623.method2036() * var2));

      try {
         var1.field0608.method0713(var3, this.field0970.method0492(), var6, this.field0464.method0492(), var7, this.field1544.method0492());
      } catch (Exception var9) {
      }
   }

   private static class GhostEntity {
      private final StaticPlayerEntity field0608;
      private final class_243 field0157;
      private final long field1412;

      public GhostEntity(StaticPlayerEntity var1, class_243 var2, long var3) {
         this.field0608 = var1;
         this.field0157 = var2;
         this.field1412 = var3;
      }

      @Generated
      public StaticPlayerEntity method0534() {
         return this.field0608;
      }

      @Generated
      public class_243 method0024() {
         return this.field0157;
      }

      @Generated
      public long method2049() {
         return this.field1412;
      }
   }
}
