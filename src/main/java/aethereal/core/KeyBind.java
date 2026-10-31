package aethereal;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import lombok.Generated;
import org.lwjgl.glfw.GLFW;

public class KeyBind implements MinecraftAccess {
   private int field0567;
   private boolean field0169;
   private boolean field1527;
   private static final Map<Integer, String> field1033 = new HashMap<>();
   private static final Map<Integer, String> field0210 = new HashMap<>();

   public KeyBind(int var1, boolean var2) {
      this.field0567 = var1;
      this.field0169 = var2;
      this.field1527 = false;
   }

   public KeyBind(int var1, boolean var2, boolean var3) {
      this.field0567 = var1;
      this.field0169 = var2;
      this.field1527 = var3;
   }

   @Override
   public String toString() {
      if (this.field0567 == -1) {
         return "None";
      }

      if (this.field0169) {
         return "M" + (this.field0567 + 1);
      }

      String var1 = field0210.get(this.field0567);
      return var1 != null ? var1 : field1033.getOrDefault(this.field0567, "");
   }

   public boolean method0579() {
      return this.field0567 < 0;
   }

   public boolean method0026() {
      if (this.method0579()) {
         return false;
      }

      if (field0796.method_22683() == null) {
         return false;
      }

      if (field0796.field_1755 != null) {
         return false;
      }

      long var1 = field0796.method_22683().method_4490();
      return this.field0169 ? GLFW.glfwGetMouseButton(var1, this.field0567) == 1 : GLFW.glfwGetKey(var1, this.field0567) == 1;
   }

   @Generated
   public int method2048() {
      return this.field0567;
   }

   @Generated
   public boolean method1813() {
      return this.field0169;
   }

   @Generated
   public boolean method1635() {
      return this.field1527;
   }

   @Generated
   public void method0729(int var1) {
      this.field0567 = var1;
   }

   @Generated
   public void method1570(boolean var1) {
      this.field0169 = var1;
   }

   @Generated
   public void method0345(boolean var1) {
      this.field1527 = var1;
   }

   static {
      for (Field var3 : GLFW.class.getDeclaredFields()) {
         if (var3.getName().startsWith("GLFW_KEY_")) {
            try {
               int var4 = (Integer)var3.get(null);
               String var5 = var3.getName().substring("GLFW_KEY_".length());
               var5 = var5.substring(0, 1).toUpperCase() + var5.substring(1).toLowerCase();
               field1033.put(var4, var5.toUpperCase());
            } catch (IllegalAccessException var6) {
            }
         }
      }

      field0210.put(39, "APOS");
      field0210.put(44, ",");
      field0210.put(45, "-");
      field0210.put(46, ".");
      field0210.put(47, "/");
      field0210.put(59, ";");
      field0210.put(61, "=");
      field0210.put(91, "[");
      field0210.put(92, "\\");
      field0210.put(93, "]");
      field0210.put(96, "`");
      field0210.put(256, "ESC");
      field0210.put(259, "BSPC");
      field0210.put(260, "INS");
      field0210.put(261, "DEL");
      field0210.put(266, "PGUP");
      field0210.put(267, "PGDN");
      field0210.put(280, "CAPS");
      field0210.put(281, "SCRLK");
      field0210.put(282, "NUMLK");
      field0210.put(283, "PRTSC");
      field0210.put(320, "NP0");
      field0210.put(321, "NP1");
      field0210.put(322, "NP2");
      field0210.put(323, "NP3");
      field0210.put(324, "NP4");
      field0210.put(325, "NP5");
      field0210.put(326, "NP6");
      field0210.put(327, "NP7");
      field0210.put(328, "NP8");
      field0210.put(329, "NP9");
      field0210.put(330, "NP.");
      field0210.put(331, "NP/");
      field0210.put(332, "NP*");
      field0210.put(333, "NP-");
      field0210.put(334, "NP+");
      field0210.put(335, "NPENT");
      field0210.put(336, "NP=");
      field0210.put(340, "LSHFT");
      field0210.put(341, "LCTRL");
      field0210.put(342, "LALT");
      field0210.put(343, "LWIN");
      field0210.put(344, "RSHFT");
      field0210.put(345, "RCTRL");
      field0210.put(346, "RALT");
      field0210.put(347, "RWIN");
      field0210.put(161, "WLD1");
      field0210.put(162, "WLD2");
   }
}
