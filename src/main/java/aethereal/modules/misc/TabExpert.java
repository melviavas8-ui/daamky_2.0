package aethereal;

public class TabExpert extends Module {
   public final FloatSetting field0060 = new FloatSetting("tabexpert.limit", 200.0F, 1.0F, 1000.0F, 1.0F)
      .method1007("Limit")
      .method0210("Maximum number of players shown in tab list")
      .method2130("Максимальное количество игроков в списке");
   public final BooleanSetting field1432 = new BooleanSetting("tabexpert.friends", true)
      .method1007("Friends")
      .method0210("Highlight friends in the tab list")
      .method2130("Подсвечивать друзей в списке");

   public TabExpert() {
      super("TabExpert", ModuleCategory.field0776, "Enhanced tab list display");
      this.method1013("Улучшенное отображение списка игроков");
   }
}
