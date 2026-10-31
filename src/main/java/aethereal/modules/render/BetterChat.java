package aethereal;

public class BetterChat extends Module {
   public final BooleanSetting field0034 = new BooleanSetting("betterchat.nobackground", false)
      .method1007("No Background")
      .method0210("Remove the dark background behind chat messages")
      .method2130("Убрать фон чата");
   public final BooleanSetting field1432 = new BooleanSetting("betterchat.timestamp", false)
      .method1007("TimeStamp")
      .method0210("Show time before each chat message")
      .method2130("Показывать время перед сообщением");
   public final BooleanSetting field0970 = new BooleanSetting("betterchat.showseconds", false, this.field1432::method0492)
      .method1007("Show Seconds")
      .method0210("Include seconds in the timestamp")
      .method2130("Выводить секунды");
   public final BooleanSetting field0184 = new BooleanSetting("betterchat.animation", false)
      .method1007("Animation")
      .method0210("Animate chat messages appearing")
      .method2130("Анимация появления сообщений в чате");
   public final FloatSetting field0470 = new FloatSetting("betterchat.animspeed", 6.0F, 1.0F, 20.0F, 0.5F, this.field0184::method0492)
      .method1007("Animation Speed")
      .method0210("Speed of message slide-in animation")
      .method2130("Скорость анимации");

   public BetterChat() {
      super("BetterChat", ModuleCategory.field1004, "BetterChat");
      this.method1013("Разные улучшения для игрового чата");
   }
}
