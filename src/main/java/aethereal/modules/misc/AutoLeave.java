package aethereal;

import java.util.Arrays;
import java.util.List;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_2561;

public class AutoLeave extends Module {
   private final EnumSetting<AutoLeave.TriggerType> field0058 = new EnumSetting<>("autoleave.type", AutoLeave.TriggerType.field0026)
      .method1007("Leave Type")
      .method0210("How to disconnect from the server")
      .method2130("Способ отключения от сервера");
   private final MultiSelectSetting field1471 = new MultiSelectSetting("autoleave.triggers", Arrays.asList("Players", "Staff"), false, () -> true)
      .method1007("Triggers")
      .method0210("Conditions that trigger automatic disconnect")
      .method2130("Условия для отключения");
   private final FloatSetting field0985 = new FloatSetting("autoleave.maxdistance", 10.0F, 5.0F, 40.0F, 1.0F, () -> this.method2135("Players"))
      .method1007("Max Distance")
      .method0210("Maximum distance for player detection trigger")
      .method2130("Максимальная дистанция обнаружения игроков");

   public AutoLeave() {
      super(" AutoLeave", ModuleCategory.field0776, "Automatically disconnects");
      this.method1013("Автоматически выполняет действие при определённых условиях");
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         if (this.method2135("Players")) {
            field0796.field_1687
               .method_18456()
               .stream()
               .filter(var0 -> var0 != field0796.field_1724)
               .filter(var1x -> field0796.field_1724.method_5739(var1x) < this.field0985.method0492())
               .filter(var0 -> {
                  DaamkyClient var1 = DaamkyClient.method2004();
                  return var1 == null || var1.method1608() == null || !var1.method1608().method2135(var0.method_7334().getName());
               })
               .findFirst()
               .ifPresent(
                  var1x -> this.method1347(
                     class_2561.method_43470(
                        var1x.method_5477().getString() + " appeared at " + String.format("%.1f", field0796.field_1724.method_5739(var1x)) + "m"
                     )
                  )
               );
         }

         if (this.method2135("Staff")) {
            List var2 = NewHUD.method1397(field0796);
            if (!var2.isEmpty()) {
               this.method1347(class_2561.method_43470("Сотрудник на сервере: " + String.join(", ", var2)));
            }
         }
      }
   }

   private void method1347(class_2561 var1) {
      if (field0796.method_1562() != null) {
         if (this.field0058.method0492() == AutoLeave.TriggerType.field0591) {
            field0796.method_1562().method_45730("hub");
         } else {
            field0796.method_1562().method_48296().method_10747(class_2561.method_43470("[AutoLeave]\n").method_27661().method_10852(var1));
         }

         this.method0345(false);
      }
   }

   private boolean method2135(String var1) {
      BooleanSetting var2 = this.field1471.method0439(var1);
      return var2 != null && var2.method0492();
   }

   public enum TriggerType implements DisplayNamed {
      field0591("Hub"),
      field0026("Main Menu");

      private final String field1504;

      TriggerType(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }
}
