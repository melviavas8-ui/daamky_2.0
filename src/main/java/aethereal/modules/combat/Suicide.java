package aethereal;

public class Suicide extends Module {
   public Suicide() {
      super("Suicide", ModuleCategory.field0661, "Targets yourself with crystals");
      this.method1013("Атакует кристаллы по самому себе");
   }

   public static Suicide method1721() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(Suicide.class) : null;
   }
}
