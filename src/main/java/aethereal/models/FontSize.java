package aethereal;

public record FontSize(MsdfFontRenderer font, float size) {
   public float method0998(String var1) {
      return this.font.method1016(var1, this.size);
   }

   public float method1016(String var1, float var2) {
      return this.font.method1017(var1, this.size, var2);
   }

   public float method0530() {
      return this.font.method0645(this.size);
   }

   public float method0208(String var1) {
      float var2 = 0.0F;

      for (int var3 = 0; var3 < var1.length(); var3++) {
         int var4 = var1.charAt(var3);
         if (var4 == 10) {
            var2 += this.font.method0645(this.size) + 1.5F;
         } else {
            var2 = Math.max(this.font.method0645(this.size), var2);
         }
      }

      return var2;
   }

   public MsdfFontRenderer method0010() {
      return this.font;
   }

   public float method2047() {
      return this.size;
   }
}
