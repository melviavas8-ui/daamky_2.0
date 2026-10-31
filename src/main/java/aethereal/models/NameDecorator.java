package aethereal;

import java.util.HashMap;
import java.util.Map;

public final class NameDecorator {
   private static final Map<Character, Character> field0720 = new HashMap<>();
   private static final Map<Character, String> field0140 = new HashMap<>();

   private NameDecorator() {
      throw new UnsupportedOperationException("Utility class");
   }

   public static String method1010(String var0) {
      return var0 != null && !var0.isEmpty() ? method1844(method2131(method0212(var0))) : var0;
   }

   private static String method0212(String var0) {
      StringBuilder var1 = new StringBuilder(var0.length());

      for (char var5 : var0.toCharArray()) {
         var1.append(field0720.getOrDefault(var5, var5));
      }

      return var1.toString();
   }

   private static String method2131(String var0) {
      StringBuilder var1 = new StringBuilder(var0.length());

      for (char var5 : var0.toCharArray()) {
         String var6 = field0140.get(var5);
         if (var6 != null) {
            var1.append(var6);
         } else {
            var1.append(var5);
         }
      }

      return var1.toString();
   }

   private static String method1844(String var0) {
      String var1 = var0;
      var1 = var1.replace('↬', '>');
      var1 = var1.replace('↫', '<');
      var1 = var1.replace('◄', '<');
      var1 = var1.replace('►', '>');
      var1 = var1.replace('◀', '<');
      var1 = var1.replace('▶', '>');
      var1 = var1.replace('◂', '<');
      var1 = var1.replace('▸', '>');
      var1 = var1.replace('◁', '<');
      var1 = var1.replace('▷', '>');
      var1 = var1.replace('‹', '<');
      var1 = var1.replace('›', '>');
      var1 = var1.replace("⚡", "");
      var1 = var1.replace("☇", "");
      var1 = var1.replace("⌓", "");
      var1 = var1.replace("✨", "");
      var1 = var1.replace("⭐", "");
      var1 = var1.replace("\ud83c\udf1f", "");
      var1 = var1.replace("\ud83d\udcab", "");
      var1 = var1.replace("\ud83d\udd25", "");
      var1 = var1.replace("\ud83d\udc8e", "");
      var1 = var1.replace("⚔", "");
      var1 = var1.replace("⚔️", "");
      var1 = var1.replace("\ud83d\udee1", "");
      var1 = var1.replace("\ud83d\udee1️", "");
      var1 = var1.replace("⚜", "");
      return var1.replace("⚜️", "");
   }

   static {
      field0720.put('ᴀ', 'a');
      field0720.put('ʙ', 'b');
      field0720.put('ᴄ', 'c');
      field0720.put('ᴅ', 'd');
      field0720.put('ᴇ', 'e');
      field0720.put('ꜰ', 'F');
      field0720.put('ғ', 'F');
      field0720.put('ɢ', 'g');
      field0720.put('ʜ', 'h');
      field0720.put('ɪ', 'i');
      field0720.put('ᴊ', 'j');
      field0720.put('ᴋ', 'k');
      field0720.put('ʟ', 'l');
      field0720.put('ᴍ', 'm');
      field0720.put('ɴ', 'n');
      field0720.put('ᴏ', 'o');
      field0720.put('ᴘ', 'p');
      field0720.put('ǫ', 'q');
      field0720.put('ʀ', 'r');
      field0720.put('ꜱ', 's');
      field0720.put('ᴛ', 't');
      field0720.put('ᴜ', 'u');
      field0720.put('ᴠ', 'v');
      field0720.put('ᴡ', 'w');
      field0720.put('x', 'x');
      field0720.put('ʏ', 'y');
      field0720.put('ᴢ', 'z');
      field0140.put('⚡', "");
      field0140.put('ꔀ', "PLAYER");
      field0140.put('ꔄ', "HERO");
      field0140.put('ꔈ', "TITAN");
      field0140.put('ꔒ', "AVENGER");
      field0140.put('ꔖ', "OVERLORD");
      field0140.put('ꔠ', "MAGISTER");
      field0140.put('ꔤ', "IMPERATOR");
      field0140.put('ꔨ', "DRAGON");
      field0140.put('ꔲ', "BULL");
      field0140.put('ꔶ', "TIGER");
      field0140.put('ꕄ', "DRACULA");
      field0140.put('ꕖ', "BUNNY");
      field0140.put('ꕈ', "COBRA");
      field0140.put('ꕀ', "HYDRA");
      field0140.put('ꕒ', "RABBIT");
      field0140.put('ꕁ', "GOD");
      field0140.put('ꔂ', "GOD");
      field0140.put('ꔸ', "GOD");
      field0140.put('ꕠ', "D.HELPER");
      field0140.put('ꔉ', "HELPER");
      field0140.put('ꔓ', "ML.MODER");
      field0140.put('ꔗ', "MODER");
      field0140.put('ꔡ', "MODER+");
      field0140.put('ꔥ', "ST.MODER");
      field0140.put('ꔩ', "GL.MODER");
      field0140.put('ꔳ', "ML.ADMIN");
      field0140.put('ꔷ', "ADMIN");
      field0140.put('ꔁ', "MEDIA");
      field0140.put('ꕗ', "SPONSOR");
      field0140.put('ꕅ', "VAMPIRE");
      field0140.put('ꔆ', "VAMPIRE");
      field0140.put('ꕉ', "PEGAS");
      field0140.put('ꕓ', "GHOST");
      field0140.put('ꔢ', "D.ST.MODER");
      field0140.put('ꔅ', "YT");
   }
}
