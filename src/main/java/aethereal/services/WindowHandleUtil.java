package aethereal;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;
import java.lang.reflect.Method;
import net.minecraft.class_310;

public final class WindowHandleUtil {
   private static final String field0715 = System.getProperty("os.name", "").toLowerCase();
   private static final boolean field0169 = field0715.contains("win");
   private static final int field1411 = 35;
   private static final int field0958 = 0;
   private static volatile Integer field0790 = 0;

   private WindowHandleUtil() {
   }

   public static void method0778(long var0) {
      if (field0169) {
         Pointer var2 = method0159(var0);
         if (var2 != null) {
            method0948(var2);
         }
      }
   }

   public static void method0948(Pointer var0) {
      if (field0169 && var0 != null) {
         try {
            if (field0790 == null) {
               method0949(var0, -1);
               return;
            }

            int var1 = field0790 >> 16 & 0xFF;
            int var2 = field0790 >> 8 & 0xFF;
            int var3 = field0790 & 0xFF;
            int var4 = var3 << 16 | var2 << 8 | var1;
            method0949(var0, var4);
         } catch (Throwable var5) {
         }
      }
   }

   private static void method0949(Pointer var0, int var1) {
      Memory var2 = new Memory(4L);

      try {
         var2.setInt(0L, var1);
         WindowHandleUtil.User32Library.field0708.method0950(var0, 35, var2, 4);
      } catch (Throwable var6) {
         try {
            var2.close();
         } catch (Throwable var5) {
            var6.addSuppressed(var5);
         }

         throw var6;
      }

      var2.close();
   }

   private static Pointer method0159(long var0) {
      if (var0 == 0L) {
         return null;
      }

      try {
         Class var2 = Class.forName("org.lwjgl.glfw.GLFWNativeWin32");
         Method var3 = var2.getMethod("glfwGetWin32Window", long.class);
         long var4 = (Long)var3.invoke(null, var0);
         return var4 == 0L ? null : Pointer.createConstant(var4);
      } catch (Throwable var6) {
         return null;
      }
   }

   public static void method0983(Integer var0) {
      field0790 = var0;
      if (field0169) {
         class_310 var1 = class_310.method_1551();
         if (var1 != null && var1.method_22683() != null) {
            method0778(var1.method_22683().method_4490());
         }
      }
   }

   public static Integer method0554() {
      return field0790;
   }

   public interface User32Library extends StdCallLibrary {
      WindowHandleUtil.User32Library field0708 = (WindowHandleUtil.User32Library)Native.load(
         "dwmapi", WindowHandleUtil.User32Library.class, W32APIOptions.DEFAULT_OPTIONS
      );

      int method0950(Pointer var1, int var2, Pointer var3, int var4);
   }
}
