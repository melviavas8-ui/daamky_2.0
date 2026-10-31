package aethereal;

import net.minecraft.class_2561;
import net.minecraft.class_5250;
import net.minecraft.class_7417;
import net.minecraft.class_8828;

public class NameProtect extends Module {
   public static NameProtect field0090;
   private final TextSetting field1497 = new TextSetting("nameprotect.selfmask", "Daamky", false)
      .method1007("Self Mask")
      .method0210("Text to replace your own nickname with")
      .method2130("Текст для замены вашего ника");
   private final BooleanSetting field0970 = new BooleanSetting("nameprotect.hidefriends", false)
      .method1007("Hide Friends")
      .method0210("Also replace friend names in chat and UI")
      .method2130("Скрывать никнеймы друзей");
   private final TextSetting field0205 = new TextSetting("nameprotect.friendmask", "Daamky", this.field0970::method0492, false)
      .method1007("Friend Mask")
      .method0210("Text to replace friend nicknames with")
      .method2130("Текст для замены ников друзей");

   public NameProtect() {
      super("NameProtect", ModuleCategory.field0776, "Hides your username in chat and UI");
      this.method1013("Скрывает ваш ник в чате и интерфейсе");
      field0090 = this;
   }

   public static String method1728() {
      if (field0090 != null && field0090.method2195()) {
         return field0090.field1497.method0492();
      } else {
         return field0796.field_1724 != null ? field0796.field_1724.method_5820() : "Daamky";
      }
   }

   public static String method2131(String var0) {
      if (field0090 != null && field0090.method2195() && field0796.field_1724 != null && var0 != null && !var0.isEmpty()) {
         String var1 = field0796.field_1724.method_5820();
         if (var1 != null && var0.contains(var1)) {
            return var0.replace(var1, field0090.field1497.method0492());
         }

         if (field0090.field0970.method0492()) {
            for (String var4 : DaamkyClient.method2004().method1608().method0424()) {
               if (var0.contains(var4)) {
                  return var0.replace(var4, field0090.field0205.method0492());
               }
            }
         }

         return var0;
      } else {
         return var0;
      }
   }

   public static class_5250 method1346(class_2561 var0) {
      if (var0 == null) {
         return null;
      } else {
         return field0090 != null && field0090.method2195() && field0796.field_1724 != null ? method0296(var0) : var0.method_27661();
      }
   }

   private static class_5250 method0296(class_2561 var0) {
      class_7417 var1 = var0.method_10851();
      class_5250 var2;
      if (var1 instanceof class_8828 var3) {
         String var4 = var3.comp_737();
         String var5 = method2131(var4);
         var2 = var5.equals(var4) ? class_2561.method_43470(var4) : class_2561.method_43470(var5);
      } else {
         var2 = class_5250.method_43477(var1);
      }

      var2.method_10862(var0.method_10866());

      for (class_2561 var7 : var0.method_10855()) {
         var2.method_10852(method0296(var7));
      }

      return var2;
   }
}
