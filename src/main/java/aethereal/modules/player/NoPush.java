package aethereal;

import java.util.Arrays;

public class NoPush extends Module {
   public MultiSelectSetting field0089 = new MultiSelectSetting("nopush.targets", Arrays.asList("Players", "Blocks", "Water"), true, () -> true)
      .method1007("Targets")
      .method0210("Sources to ignore push from")
      .method2130("Источники толкания, которые игнорировать");

   public NoPush() {
      super("NoPush", ModuleCategory.field1470, "Prevents being pushed by entities or water");
      this.method1013("Отключает толкание взависимости от условий");
   }

   public boolean method1736() {
      return this.field0089.method0387("Players");
   }

   public boolean method1692() {
      return this.field0089.method0387("Blocks");
   }

   public boolean method1755() {
      return this.field0089.method0387("Water");
   }
}
