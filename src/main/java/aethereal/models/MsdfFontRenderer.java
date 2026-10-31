package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import net.minecraft.class_1044;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4588;
import org.joml.Matrix4f;

public final class MsdfFontRenderer {
   private final String field0715;
   private final class_1044 field0147;
   private final MsdfFontMetadata.Metrics field1461;
   private final MsdfFontMetadata.KerningPair field0996;
   private final Map<Integer, MsdfGlyphRenderer> field0794;
   private final Map<Integer, Map<Integer, Float>> field1270;

   private MsdfFontRenderer(
      String var1,
      class_1044 var2,
      MsdfFontMetadata.Metrics var3,
      MsdfFontMetadata.KerningPair var4,
      Map<Integer, MsdfGlyphRenderer> var5,
      Map<Integer, Map<Integer, Float>> var6
   ) {
      this.field0715 = var1;
      this.field0147 = var2;
      this.field1461 = var3;
      this.field0996 = var4;
      this.field0794 = var5;
      this.field1270 = var6;
   }

   public int method0531() {
      return this.field0147.method_4624();
   }

   public void method0025() {
      this.field0147.method_4527(true, false);
   }

   public void method1565(Matrix4f var1, class_4588 var2, String var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10) {
      int var11 = -1;

      for (int var12 = 0; var12 < var3.length(); var12++) {
         int var13 = var3.charAt(var12);
         MsdfGlyphRenderer var14 = this.field0794.get(var13);
         if (var14 != null) {
            Map var15 = this.field1270.get(var11);
            if (var15 != null) {
               var7 += var15.getOrDefault(var13, 0.0F) * var4;
            }

            var7 += var14.method1564(var1, var2, var4, var7, var8, var9, var10) + var5 + var6;
            var11 = var13;
         }
      }
   }

   public float method1016(String var1, float var2) {
      int var3 = -1;
      float var4 = 0.0F;

      for (int var5 = 0; var5 < var1.length(); var5++) {
         int var6 = var1.charAt(var5);
         MsdfGlyphRenderer var7 = this.field0794.get(var6);
         if (var7 != null) {
            Map var8 = this.field1270.get(var3);
            if (var8 != null) {
               var4 += var8.getOrDefault(var6, 0.0F) * var2;
            }

            var4 += var7.method0645(var2) * 1.05F;
            var3 = var6;
         }
      }

      return var4;
   }

   public float method1017(String var1, float var2, float var3) {
      int var4 = -1;
      float var5 = 0.0F;

      for (int var6 = 0; var6 < var1.length(); var6++) {
         int var7 = var1.charAt(var6);
         MsdfGlyphRenderer var8 = this.field0794.get(var7);
         if (var8 != null) {
            Map var9 = this.field1270.get(var4);
            if (var9 != null) {
               var5 += var9.getOrDefault(var7, 0.0F) * var2;
            }

            var5 += var8.method0645(var2) + var3 * var2;
            var4 = var7;
         }
      }

      return var5;
   }

   public float method0645(float var1) {
      return (this.field0996.method0002() * var1 + Math.abs(this.field0996.method2047() * var1)) * 1.05F;
   }

   public String method2067() {
      return this.field0715;
   }

   public MsdfFontMetadata.Metrics method1777() {
      return this.field1461;
   }

   public MsdfFontMetadata.KerningPair method1610() {
      return this.field0996;
   }

   public static MsdfFontRenderer.TextBatch method1952() {
      return new MsdfFontRenderer.TextBatch();
   }

   public static class TextBatch {
      private String field0715 = "?";
      private class_2960 field0160;
      private class_2960 field1522;

      private TextBatch() {
      }

      public MsdfFontRenderer.TextBatch method1003(String var1) {
         this.field0715 = var1;
         return this;
      }

      public MsdfFontRenderer.TextBatch method0209(String var1) {
         this.field0160 = DaamkyClient.method1012("fonts/" + var1 + ".json");
         return this;
      }

      public MsdfFontRenderer.TextBatch method2128(String var1) {
         this.field1522 = DaamkyClient.method1012("fonts/" + var1 + ".png");
         return this;
      }

      public MsdfFontRenderer method0542() {
         MsdfFontMetadata var1 = ResourceHelper.method1392(this.field0160, MsdfFontMetadata.class);
         class_1044 var2 = class_310.method_1551().method_1531().method_4619(this.field1522);
         if (var1 == null) {
            throw new RuntimeException(
               "Failed to read font data file: " + this.field0160.toString() + "; Are you sure this is json file? Try to check the correctness of its syntax."
            );
         }

         RenderSystem.recordRenderCall(() -> var2.method_4527(true, false));
         float var3 = var1.method0541().method0002();
         float var4 = var1.method0541().method2047();
         Map var5 = var1.method2068().stream().collect(Collectors.toMap(var0 -> var0.method0531(), var2x -> new MsdfGlyphRenderer(var2x, var3, var4)));
         Map var6 = new HashMap<>();
         var1.method1793().forEach(var1x -> {
            Map var2 = var6.get(var1x.method0531());
            if (var2 == null) {
               var2 = new HashMap<>();
               var6.put(var1x.method0531(), var2);
            }

            var2.put(var1x.method0003(), var1x.method2047());
         });
         return new MsdfFontRenderer(this.field0715, var2, var1.method0541(), var1.method0009(), var5, var6);
      }
   }
}
