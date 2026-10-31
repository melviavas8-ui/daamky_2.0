package aethereal;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.glfw.GLFWImage.Buffer;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

public class WindowIconManager implements MinecraftAccess {
   public static void method0578() {
      ByteBuffer var0 = null;
      ByteBuffer var1 = null;
      ByteBuffer var2 = null;
      ByteBuffer var3 = null;

      try {
         try {
            try (
               InputStream var4 = WindowIconManager.class.getResourceAsStream("/assets/daamky/textures/icon16x16.png");
               InputStream var5 = WindowIconManager.class.getResourceAsStream("/assets/daamky/textures/icon32x32.png");
            ) {
               if (var4 == null || var5 == null) {
                  System.err.println("[Daamky] Icon files not found in resources");
                  return;
               }

               MemoryStack var6 = MemoryStack.stackPush();

               try {
                  Buffer var7 = GLFWImage.malloc(2, var6);
                  var0 = method0973(var4);
                  var1 = method0973(var5);
                  IntBuffer var8 = var6.mallocInt(1);
                  IntBuffer var9 = var6.mallocInt(1);
                  IntBuffer var10 = var6.mallocInt(1);
                  var2 = STBImage.stbi_load_from_memory(var0, var8, var9, var10, 4);
                  if (var2 != null) {
                     ((Buffer)var7.position(0)).width(var8.get(0)).height(var9.get(0)).pixels(var2);
                  } else {
                     System.err.println("[Daamky] Failed to decode icon16x16.png: " + STBImage.stbi_failure_reason());
                  }

                  var8.clear();
                  var9.clear();
                  var10.clear();
                  var3 = STBImage.stbi_load_from_memory(var1, var8, var9, var10, 4);
                  if (var3 != null) {
                     ((Buffer)var7.position(1)).width(var8.get(0)).height(var9.get(0)).pixels(var3);
                  } else {
                     System.err.println("[Daamky] Failed to decode icon32x32.png: " + STBImage.stbi_failure_reason());
                  }

                  var7.position(0);
                  GLFW.glfwSetWindowIcon(field0796.method_22683().method_4490(), var7);
               } catch (Throwable var23) {
                  if (var6 != null) {
                     try {
                        var6.close();
                     } catch (Throwable var22) {
                        var23.addSuppressed(var22);
                     }
                  }

                  throw var23;
               }

               if (var6 != null) {
                  var6.close();
               }
            }

            System.out.println("[Daamky] Window icon set successfully");
         } catch (Exception var26) {
            System.err.println("[Daamky] Failed to set window icon: " + var26.getMessage());
            var26.printStackTrace();
         }
      } finally {
         if (var2 != null) {
            STBImage.stbi_image_free(var2);
         }

         if (var3 != null) {
            STBImage.stbi_image_free(var3);
         }

         if (var0 != null) {
            MemoryUtil.memFree(var0);
         }

         if (var1 != null) {
            MemoryUtil.memFree(var1);
         }
      }
   }

   private static ByteBuffer method0973(InputStream var0) throws IOException {
      byte[] var1 = var0.readAllBytes();
      ByteBuffer var2 = MemoryUtil.memAlloc(var1.length);
      var2.put(var1);
      var2.flip();
      return var2;
   }
}
