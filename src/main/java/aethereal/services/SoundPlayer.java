package aethereal;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.JavaSoundAudioDevice;
import javazoom.jl.player.advanced.AdvancedPlayer;
import lombok.Generated;

public class SoundPlayer implements MinecraftAccess {
   private static float field0566 = 0.05F;

   public static void method0665(float var0) {
      field0566 = Math.max(0.0F, Math.min(1.0F, var0));
   }

   public static void method0936(SoundPlayer.SoundEffect var0) {
      if (!(field0566 <= 0.0F)) {
         new Thread(() -> {
            InputStream var1 = null;
            BufferedInputStream var2 = null;
            AdvancedPlayer var3 = null;

            try {
               var1 = SoundPlayer.class.getResourceAsStream("/assets/daamky/sounds/" + var0.method0557());
               if (var1 != null) {
                  var2 = new BufferedInputStream(var1);
                  var3 = new AdvancedPlayer(var2, new SoundPlayer.VolumeAudioDevice());
                  var3.play();
                  return;
               }

               System.err.println("[Sound] File not found: /assets/daamky/sounds/" + var0.method0557());
            } catch (Exception var14) {
               System.err.println("[Sound] Error playing: " + var0.method0557());
               var14.printStackTrace();
               return;
            } finally {
               try {
                  if (var3 != null) {
                     var3.close();
                  }

                  if (var2 != null) {
                     var2.close();
                  }

                  if (var1 != null) {
                     var1.close();
                  }
               } catch (Exception var13) {
               }
            }
         }, "SoundPlayer-" + var0.name()).start();
      }
   }

   @Generated
   public static float method0530() {
      return field0566;
   }

   public enum SoundEffect {
      field0687("open.mp3"),
      field0111("close.mp3"),
      field1486("enable.mp3"),
      field1015("disable.mp3"),
      field0781("module_hover.mp3");

      private final String field1269;

      SoundEffect(String var3) {
         this.field1269 = var3;
      }

      public String method0557() {
         return this.field1269;
      }
   }

   private static class VolumeAudioDevice extends JavaSoundAudioDevice {
      public void write(short[] var1, int var2, int var3) throws JavaLayerException {
         if (!(SoundPlayer.field0566 <= 0.0F)) {
            if (SoundPlayer.field0566 < 1.0F) {
               for (int var4 = var2; var4 < var2 + var3; var4++) {
                  var1[var4] = (short)(var1[var4] * SoundPlayer.field0566);
               }
            }

            super.write(var1, var2, var3);
         }
      }
   }
}
