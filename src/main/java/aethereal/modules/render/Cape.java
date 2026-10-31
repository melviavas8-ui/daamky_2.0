package aethereal;

import net.minecraft.class_2960;

public final class Cape extends Module {
   private static final class_2960 field0160 = class_2960.method_60655("daamky", "textures/capes/cape1.png");
   private static final class_2960 field1522 = class_2960.method_60655("daamky", "textures/capes/cape2.png");
   private final EnumSetting<Cape.CapeType> field0984 = new EnumSetting<>("cape.type", Cape.CapeType.field0599)
      .method1007("Type")
      .method0210("Mode cape")
      .method2130("Тип плаща");

   public Cape() {
      super("Cape", ModuleCategory.field1004, "Displays custom capes on your player");
      this.method1013("Отображает плащ с логотипом клиента");
   }

   public class_2960 method1734() {
      if (!this.method2195()) {
         return null;
      }

      return switch ((Cape.CapeType)this.field0984.method0492()) {
         case field0599 -> field0160;
         case field0035 -> field1522;
      };
   }

   public enum CapeType implements DisplayNamed {
      field0599("Cape 1"),
      field0035("Cape 2");

      private final String field1504;

      CapeType(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }
}
