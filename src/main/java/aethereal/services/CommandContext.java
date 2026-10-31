package aethereal;

import net.minecraft.class_2561;

public final class CommandContext implements MinecraftAccess {
   private final Command field0637;
   private final String field0136;
   private final String field1504;
   private final String[] field1085;

   public CommandContext(Command var1, String var2, String var3, String[] var4) {
      this.field0637 = var1;
      this.field0136 = var2;
      this.field1504 = var3;
      this.field1085 = var4;
   }

   public Command method0539() {
      return this.field0637;
   }

   public String method0017() {
      return this.field0136;
   }

   public String method2067() {
      return this.field1504;
   }

   public String[] method1814() {
      return this.field1085;
   }

   public void method1013(String var1) {
      ChatHelper.method1347(class_2561.method_43470(var1).method_27694(var0 -> var0.method_36139(65415)));
   }

   public void method0213(String var1) {
      ChatHelper.method1347(class_2561.method_43470(var1).method_27694(var0 -> var0.method_36139(16739179)));
   }

   public void method2134(String var1) {
      ChatHelper.method1013(var1);
   }

   public void method1347(class_2561 var1) {
      ChatHelper.method1347(var1);
   }

   public void method1846(String var1) {
      ChatHelper.method1013(var1);
   }

   public void method0297(class_2561 var1) {
      ChatHelper.method1347(var1);
   }
}
