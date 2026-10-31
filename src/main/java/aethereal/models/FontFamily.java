package aethereal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class FontFamily {
   private final MsdfFontRenderer field0646;
   private final Map<Float, FontSize> field0140 = new ConcurrentHashMap<>();

   public FontFamily(MsdfFontRenderer var1) {
      this.field0646 = var1;
   }

   public FontSize method0654(float var1) {
      return this.field0140.computeIfAbsent(var1, var1x -> new FontSize(this.field0646, var1x));
   }

   public float method1016(String var1, float var2) {
      return this.field0646.method1016(var1, var2);
   }

   public float method0115(float var1) {
      return this.field0646.method0645(var1);
   }
}
