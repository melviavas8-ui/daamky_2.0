package aethereal;

public enum EspTargetType implements DisplayNamed {
   field0670("Players", "g"),
   field0098("Monsters", "h"),
   field1475("Items", "i"),
   field1009("Self", "j");

   private final String field0791;
   private final String field1269;

   EspTargetType(String var3, String var4) {
      this.field0791 = var3;
      this.field1269 = var4;
   }

   @Override
   public String method0557() {
      return this.field0791;
   }

   public String method0017() {
      return this.field1269;
   }
}
