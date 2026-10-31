package aethereal;

public class AntiInvisible extends Module {
   private final BooleanSetting field0034 = new BooleanSetting("antiinvisible.self", false)
      .method1007("Self")
      .method0210("Render yourself when invisible")
      .method2130("Отображать себя");

   public AntiInvisible() {
      super("AntiInvisible", ModuleCategory.field1004, "Renders invisible entities");
      this.method1013("Показывает невидимых сущностей");
   }

   public boolean method1736() {
      return this.field0034.method0492();
   }
}
