package aethereal;

public enum EspDisplayMode implements DisplayNamed {
   field0669("Visual"),
   field0097("Skeleton"),
   field1474("Slots");

   private final String field1030;

   EspDisplayMode(String var3) {
      this.field1030 = var3;
   }

   @Override
   public String method0557() {
      return this.field1030;
   }
}
