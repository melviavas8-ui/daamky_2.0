package aethereal;

import lombok.Generated;

public final class Fonts {
   public static FontFamily field0645;
   public static FontFamily field0075;
   public static FontFamily field1460;
   public static FontFamily field0995;
   public static FontFamily field0774;
   public static FontFamily field1258;
   public static FontFamily field0325;
   public static FontFamily field0197;
   public static FontFamily field0475;
   public static FontFamily field1633;
   public static FontFamily field1558;
   public static FontFamily field1718;
   public static FontFamily field1148;
   private static boolean field1109 = false;

   public static void method0578() {
      if (!field1109) {
         field1109 = true;
         field0645 = new FontFamily(MsdfFontRenderer.method1952().method2128("sf/sf_bold").method0209("sf/sf_bold").method0542());
         field0075 = new FontFamily(MsdfFontRenderer.method1952().method2128("sf/sf_medium").method0209("sf/sf_medium").method0542());
         field1460 = new FontFamily(MsdfFontRenderer.method1952().method2128("sf/sf_regular").method0209("sf/sf_regular").method0542());
         field0995 = new FontFamily(MsdfFontRenderer.method1952().method2128("sf/sf_semibold").method0209("sf/sf_semibold").method0542());
         field0774 = new FontFamily(MsdfFontRenderer.method1952().method2128("icons/daamkyicons").method0209("icons/daamkyicons").method0542());
         field1258 = new FontFamily(MsdfFontRenderer.method1952().method2128("misc/suisse_intl_bold").method0209("misc/suisse_intl_bold").method0542());
         field0325 = new FontFamily(MsdfFontRenderer.method1952().method2128("misc/sacramento").method0209("misc/sacramento").method0542());
         field0197 = new FontFamily(MsdfFontRenderer.method1952().method2128("icons/mainmenuicon").method0209("icons/mainmenuicon").method0542());
         field0475 = new FontFamily(MsdfFontRenderer.method1952().method2128("inter/inter-regular").method0209("inter/inter-regular").method0542());
         field1633 = new FontFamily(MsdfFontRenderer.method1952().method2128("inter/inter-bold").method0209("inter/inter-bold").method0542());
         field1558 = new FontFamily(MsdfFontRenderer.method1952().method2128("icons/additionalicons").method0209("icons/additionalicons").method0542());
         field1718 = new FontFamily(MsdfFontRenderer.method1952().method2128("icons/moduleicons").method0209("icons/moduleicons").method0542());
         field1148 = new FontFamily(MsdfFontRenderer.method1952().method2128("icons/proxyicons").method0209("icons/proxyicons").method0542());
      }
   }

   @Generated
   private Fonts() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
