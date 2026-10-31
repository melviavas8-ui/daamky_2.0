package aethereal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class RankColorResolver {
   private static final float field0566 = 0.85F;
   private static final List<RankColorResolver.RankStyle> field0139 = new ArrayList<>();

   private RankColorResolver() {
   }

   public static RankColorResolver.RankStyle method1023(String var0, int var1) {
      for (RankColorResolver.RankStyle var3 : field0139) {
         if (var1 + var3.field0004 <= var0.length() && var0.regionMatches(true, var1, var3.field0715, 0, var3.field0004)) {
            return var3;
         }
      }

      return null;
   }

   static {
      field0139.add(new RankColorResolver.RankStyle("D.ST.MODER", 0.17254902F, 0.22745098F, 0.8901961F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("IMPERATOR", 0.85F, 0.1F, 0.1F, 1.0F, 0.4F, 0.4F, 7.0F));
      field0139.add(new RankColorResolver.RankStyle("TITAN", 1.0F, 0.9F, 0.35F, 0.95F, 0.6F, 0.0F, 5.0F));
      field0139.add(new RankColorResolver.RankStyle("OVERLORD", 0.0F, 0.88F, 0.95F, 0.32F, 1.0F, 1.0F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("MAGISTER", 1.0F, 0.78F, 0.25F, 0.95F, 0.58F, 0.05F, 7.0F));
      field0139.add(new RankColorResolver.RankStyle("ML.ADMIN", 0.15F, 0.85F, 0.75F, 0.0F, 0.55F, 0.6F, 3.0F));
      field0139.add(new RankColorResolver.RankStyle("ML.MODER", 0.17254902F, 0.22745098F, 0.8901961F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("GL.MODER", 0.275F, 0.235F, 0.569F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("ST.MODER", 0.17254902F, 0.22745098F, 0.8901961F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("D.HELPER", 0.95F, 0.6F, 0.0F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("MODER+", 0.275F, 0.235F, 0.569F, 4.0F));
      field0139.add(new RankColorResolver.RankStyle("AVENGER", 0.15F, 1.0F, 0.15F, 5.0F));
      field0139.add(new RankColorResolver.RankStyle("SPONSOR", 0.9F, 0.7F, 0.0F, 5.0F));
      field0139.add(new RankColorResolver.RankStyle("DRACULA", 0.549F, 0.1F, 0.1F, 5.0F));
      field0139.add(new RankColorResolver.RankStyle("VAMPIRE", 0.549F, 0.1F, 0.1F, 5.0F));
      field0139.add(new RankColorResolver.RankStyle("PLAYER", 0.3F, 0.3F, 0.3F, 0.6F, 0.6F, 0.6F, 4.0F));
      field0139.add(new RankColorResolver.RankStyle("DRAGON", 0.6F, 0.2F, 0.9F, 0.9F, 0.55F, 1.0F, 4.0F));
      field0139.add(new RankColorResolver.RankStyle("RABBIT", 0.8F, 0.8F, 0.8F, 4.0F));
      field0139.add(new RankColorResolver.RankStyle("HELPER", 0.55F, 0.9F, 1.0F, 0.3F, 0.7F, 0.95F, 4.0F));
      field0139.add(new RankColorResolver.RankStyle("TIGER", 0.9F, 0.6F, 0.0F, 3.0F));
      field0139.add(new RankColorResolver.RankStyle("COBRA", 0.12F, 0.8F, 0.2F, 0.55F, 1.0F, 0.35F, 3.0F));
      field0139.add(new RankColorResolver.RankStyle("HYDRA", 0.156F, 0.365F, 0.012F, 3.0F));
      field0139.add(new RankColorResolver.RankStyle("BUNNY", 0.2F, 0.2F, 0.2F, 3.0F));
      field0139.add(new RankColorResolver.RankStyle("MODER", 0.45F, 0.72F, 0.95F, 0.2F, 0.5F, 0.85F, 4.0F));
      field0139.add(new RankColorResolver.RankStyle("ADMIN", 0.22F, 0.01F, 0.01F, 0.72F, 0.16F, 0.16F, 4.0F));
      field0139.add(new RankColorResolver.RankStyle("DEVELOPER", 0.32F, 0.03F, 0.03F, 0.78F, 0.12F, 0.12F, 8.0F));
      field0139.add(new RankColorResolver.RankStyle("MEDIA", 0.404F, 0.141F, 0.749F, 3.0F));
      field0139.add(new RankColorResolver.RankStyle("PEGAS", 0.8F, 0.45F, 0.0F, 1.0F, 0.75F, 0.15F, 3.0F));
      field0139.add(new RankColorResolver.RankStyle("GHOST", 0.6F, 0.6F, 0.6F, 3.0F));
      field0139.add(new RankColorResolver.RankStyle("HERO", 0.55F, 0.78F, 1.0F, 0.2F, 0.45F, 0.95F, 3.0F));
      field0139.add(new RankColorResolver.RankStyle("TIKTOK", 0.08F, 0.08F, 0.08F, 0.46F, 0.46F, 0.46F, 5.0F));
      field0139.add(new RankColorResolver.RankStyle("CUSTOM", 0.05F, 0.17F, 0.56F, 0.23F, 0.42F, 0.91F, 5.0F));
      field0139.add(new RankColorResolver.RankStyle("YOUTUBE+", 0.72F, 0.06F, 0.06F, 1.0F, 0.22F, 0.22F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("YOUTUBE", 0.7F, 0.05F, 0.05F, 0.95F, 0.18F, 0.18F, 5.0F));
      field0139.add(new RankColorResolver.RankStyle("SAKURA", 0.74F, 0.12F, 0.58F, 1.0F, 0.46F, 0.84F, 5.0F));
      field0139.add(new RankColorResolver.RankStyle("HALLOWEEN", 0.78F, 0.22F, 0.0F, 1.0F, 0.66F, 0.12F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("WINTER", 0.08F, 0.62F, 0.92F, 0.62F, 0.94F, 1.0F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("SUMMER", 0.9F, 0.66F, 0.08F, 1.0F, 0.92F, 0.35F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("PHANTOM", 0.75F, 0.08F, 0.08F, 1.0F, 0.3F, 0.3F, 5.0F));
      field0139.add(new RankColorResolver.RankStyle("KRATOS", 0.36F, 0.08F, 0.62F, 0.86F, 0.36F, 1.0F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("PHOENIX", 0.88F, 0.62F, 0.08F, 1.0F, 0.92F, 0.3F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("GUARDIAN", 0.0F, 0.62F, 0.22F, 0.26F, 0.95F, 0.48F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("PRINCE", 1.0F, 0.85F, 0.2F, 0.95F, 0.55F, 0.1F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("SPECTATOR", 0.45F, 0.45F, 0.45F, 0.78F, 0.78F, 0.78F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("INTERN", 0.08F, 0.48F, 0.82F, 0.45F, 0.86F, 1.0F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("CURATOR", 0.66F, 0.74F, 0.2F, 0.88F, 0.94F, 0.34F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("BULL", 0.7F, 0.15F, 0.7F, 2.0F));
      field0139.add(new RankColorResolver.RankStyle("GOD", 0.95F, 0.85F, 0.5F, 6.0F));
      field0139.add(new RankColorResolver.RankStyle("YT", 0.722F, 0.027F, 0.086F, 1.0F, 1.0F, 1.0F, 1.0F));
      field0139.sort(Comparator.<RankColorResolver.RankStyle>comparingInt(var0 -> var0.field0004).reversed());
   }

   public static final class RankStyle {
      public final String field0715;
      public final int field0004;
      public final float field1410;
      public final float field0957;
      public final float field0758;
      public final float field1242;
      public final float field0314;
      public final float field0177;
      public final float field0458;

      public RankStyle(String var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
         this.field0715 = var1;
         this.field0004 = var1.length();
         this.field1410 = var2;
         this.field0957 = var3;
         this.field0758 = var4;
         this.field1242 = var5;
         this.field0314 = var6;
         this.field0177 = var7;
         this.field0458 = var8;
      }

      public RankStyle(String var1, float var2, float var3, float var4, float var5) {
         this(var1, var2 * 0.85F, var3 * 0.85F, var4 * 0.85F, var2, var3, var4, var5);
      }

      public Color method0737(int var1, int var2) {
         float var3 = Math.min(1.0F, this.field0458 > 0.0F ? var1 / this.field0458 : 0.0F);
         int var4 = Math.round((this.field1410 + (this.field1242 - this.field1410) * var3) * 255.0F);
         int var5 = Math.round((this.field0957 + (this.field0314 - this.field0957) * var3) * 255.0F);
         int var6 = Math.round((this.field0758 + (this.field0177 - this.field0758) * var3) * 255.0F);
         return new Color(method0716(var4), method0716(var5), method0716(var6), method0716(var2));
      }

      private static int method0716(int var0) {
         return Math.max(0, Math.min(255, var0));
      }
   }
}
