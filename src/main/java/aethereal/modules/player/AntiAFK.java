package aethereal;

import meteordevelopment.orbit.EventHandler;

public class AntiAFK extends Module {
   private final EnumSetting<AntiAFK.Mode> field0058 = new EnumSetting<>("antiafk.mode", AntiAFK.Mode.field0571)
      .method1007("Режим")
      .method0210("Action")
      .method2130("Действие");
   private final FloatSetting field1450 = new FloatSetting(
         "antiafk.jumptime", 1.0F, 1.0F, 60.0F, 1.0F, () -> this.field0058.method0492() == AntiAFK.Mode.field0571
      )
      .method1007("Время прыжка")
      .method0210("Seconds between jumps")
      .method2130("Секунд между прыжками");
   private final FloatSetting field0985 = new FloatSetting(
         "antiafk.rottime", 1.0F, 1.0F, 60.0F, 1.0F, () -> this.field0058.method0492() == AntiAFK.Mode.field0008
      )
      .method1007("Время поворота")
      .method0210("Seconds between rotations")
      .method2130("Секунд между поворотами");
   private final FloatSetting field0190 = new FloatSetting(
         "antiafk.angle", 10.0F, 1.0F, 180.0F, 10.0F, () -> this.field0058.method0492() == AntiAFK.Mode.field0008
      )
      .method1007("Угол поворота")
      .method0210("Yaw")
      .method2130("Угол");
   private final FloatSetting field0470 = new FloatSetting(
         "antiafk.msgtime", 15.0F, 1.0F, 60.0F, 1.0F, () -> this.field0058.method0492() == AntiAFK.Mode.field1415
      )
      .method1007("Время сообщения")
      .method0210("Seconds between messages")
      .method2130("Секунд между сообщениями");
   private final TextSetting field1640 = new TextSetting(
         "antiafk.msg", "/арбуздыняананасяпидорас", () -> this.field0058.method0492() == AntiAFK.Mode.field1415, false
      )
      .method1007("Сообщение")
      .method0210("Text or command to send")
      .method2130("Текст или команда для отправки");
   private final Stopwatch field1560 = new Stopwatch();

   public AntiAFK() {
      super("AntiAFK", ModuleCategory.field1470, "Keeps the player active to avoid AFK kicks");
      this.method1013("Не даёт уйти в АФК");
   }

   @Override
   public void method0025() {
      this.field1560.method1812();
      super.method0025();
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         switch ((AntiAFK.Mode)this.field0058.method0492()) {
            case field0571:
               if (!this.field1560.method0779((long)(this.field1450.method0492() * 1000.0F))) {
                  return;
               }

               if (field0796.field_1724.method_24828()) {
                  field0796.field_1724.method_6043();
                  this.field1560.method1812();
               }
               break;
            case field0008:
               if (!this.field1560.method0779((long)(this.field0985.method0492() * 1000.0F))) {
                  return;
               }

               field0796.field_1724.method_36456(field0796.field_1724.method_36454() + this.field0190.method0492());
               this.field1560.method1812();
               break;
            case field1415:
               if (!this.field1560.method0779((long)(this.field0470.method0492() * 1000.0F))) {
                  return;
               }

               String var2 = this.field1640.method0492();
               if (var2 == null || var2.isBlank()) {
                  return;
               }

               if (var2.startsWith("/")) {
                  field0796.field_1724.field_3944.method_45730(var2.substring(1));
               } else {
                  field0796.field_1724.field_3944.method_45729(var2);
               }

               this.field1560.method1812();
         }
      }
   }

   public enum Mode implements DisplayNamed {
      field0571("Jump"),
      field0008("Rotate"),
      field1415("Message");

      private final String field1030;

      Mode(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }
}
