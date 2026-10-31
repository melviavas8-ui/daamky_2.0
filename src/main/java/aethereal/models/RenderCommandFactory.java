package aethereal;

public final class RenderCommandFactory {
   private static final RectangleCommandBuilder field0679 = new RectangleCommandBuilder();
   private static final CircularRectangleCommandBuilder field0039 = new CircularRectangleCommandBuilder();
   private static final BorderCommandBuilder field1433 = new BorderCommandBuilder();
   private static final CircularBorderCommandBuilder field0973 = new CircularBorderCommandBuilder();
   private static final TextureCommandBuilder field0785 = new TextureCommandBuilder();
   private static final CircularTextureCommandBuilder field1251 = new CircularTextureCommandBuilder();
   private static final MsdfTextCommandBuilder field0328 = new MsdfTextCommandBuilder();
   private static final BlurCommandBuilder field0183 = new BlurCommandBuilder();
   private static final GaussianBlurCommandBuilder field0471 = new GaussianBlurCommandBuilder();

   public static RectangleCommandBuilder method0548() {
      return field0679;
   }

   public static CircularRectangleCommandBuilder method0005() {
      return field0039;
   }

   public static BorderCommandBuilder method2050() {
      return field1433;
   }

   public static CircularBorderCommandBuilder method1767() {
      return field0973;
   }

   public static TextureCommandBuilder method1615() {
      return field0785;
   }

   public static CircularTextureCommandBuilder method1949() {
      return field1251;
   }

   public static MsdfTextCommandBuilder method0419() {
      return field0328;
   }

   public static BlurCommandBuilder method0358() {
      return field0183;
   }

   public static GaussianBlurCommandBuilder method0486() {
      return field0471;
   }
}
