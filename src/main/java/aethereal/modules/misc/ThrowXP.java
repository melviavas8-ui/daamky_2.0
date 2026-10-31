package aethereal;

public class ThrowXP extends Module {
   public ThrowXP() {
      super("ThrowXP", ModuleCategory.field0776, "Stub for AutoCrystal antiKick gate");
      this.method1013("Заглушка для antiKick AutoCrystal");
   }

   public static ThrowXP method1723() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(ThrowXP.class) : null;
   }
}
