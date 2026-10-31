package aethereal;

import dev.redstones.mediaplayerinfo.IMediaSession;
import dev.redstones.mediaplayerinfo.MediaInfo;
import dev.redstones.mediaplayerinfo.MediaPlayerInfo;
import java.awt.image.BufferedImage;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.Generated;
import net.minecraft.class_1044;

public class MediaSessionManager {
   private BufferedImage field0713;
   private class_1044 field0147;
   private String field1504 = "";
   private String field1030 = "";
   private String field0791 = "";
   private String field1269 = "";
   private long field0316;
   private long field0179;
   private long field0460 = -1L;
   private long field1616;
   private long field1540;
   private boolean field1735 = true;
   private boolean field1161;
   private IMediaSession field1103;
   private List<IMediaSession> field1213;
   private final ExecutorService field0887 = Executors.newSingleThreadExecutor();
   private static final long field0828 = 1500L;
   private static final long field0912 = 800L;

   public void method0578() {
      this.field0887.submit(this::method2043);
   }

   private void method2043() {
      try {
         this.field1213 = MediaPlayerInfo.Instance.getMediaSessions();
         if (this.field1213 == null || this.field1213.isEmpty()) {
            this.method0457();
            return;
         }

         this.field1103 = this.method0467();
         if (this.field1103 == null) {
            this.method0457();
            return;
         }

         MediaInfo var1 = this.field1103.getMedia();
         if (var1 == null) {
            this.method0457();
            return;
         }

         this.method0955(var1);
         this.method0193(var1);
         this.method2120(var1);
      } catch (Exception var2) {
         this.method0457();
      }
   }

   private IMediaSession method0467() {
      try {
         return this.field1213.stream().filter(var0 -> {
            try {
               MediaInfo var1 = var0.getMedia();
               return var1 != null && (!var1.getArtist().isEmpty() || !var1.getTitle().isEmpty());
            } catch (Exception var2) {
               return false;
            }
         }).findFirst().orElse(null);
      } catch (Exception var2) {
         return null;
      }
   }

   private void method0457() {
      this.field1504 = "";
      this.field1030 = "";
      this.field0791 = "";
      this.field1269 = "";
      this.field0713 = null;
      this.field1735 = false;
      this.field0460 = -1L;
      if (this.field0147 != null) {
         this.field0147.close();
         this.field0147 = null;
      }
   }

   private void method0955(MediaInfo var1) {
      try {
         this.field1504 = var1.getTitle() != null ? var1.getTitle() : "";
         this.field1030 = var1.getArtist() != null ? var1.getArtist() : "";
         this.field0316 = var1.getDuration();
         this.field0179 = var1.getPosition();
         this.field0713 = var1.getArtwork();
         this.field0791 = this.field1103 != null ? this.field1103.getOwner() : "";
      } catch (Exception var3) {
         this.field1504 = "";
         this.field1030 = "";
      }
   }

   private void method0193(MediaInfo var1) {
      long var2 = var1.getPosition();
      long var4 = System.currentTimeMillis();
      if (var4 - this.field1540 > 1500L && this.field0460 >= 0L && var4 - this.field1616 > 800L) {
         this.field1735 = var2 != this.field0460;
      }

      this.field0460 = var2;
      this.field1616 = var4;
   }

   private void method2120(MediaInfo var1) {
      if (this.field1269 == null || !this.field1269.equals(this.field1504)) {
         this.field1161 = true;
         this.field1269 = this.field1504;
      }

      if (this.field1161) {
         if (this.field0147 != null) {
            this.field0147.close();
         }

         this.field0147 = GuiRenderHelper.method0970(this.field0713);
         this.field1161 = false;
      }
   }

   public boolean method0026() {
      return this.field1735;
   }

   public void method2078() {
      if (this.method1594("previous", "prev")) {
         this.field0887.submit(this::method0479);
      }
   }

   public void method1812() {
      if (this.method1594("next")) {
         this.field0887.submit(this::method0479);
      }
   }

   public void method1634() {
      if (this.field1103 != null) {
         String var1 = this.field1735 ? "pause" : "play";
         if (this.method1594(var1)) {
            this.field1735 = !this.field1735;
            this.field1540 = System.currentTimeMillis();
         }
      }
   }

   private void method0479() {
      try {
         Thread.sleep(300L);
         this.method2043();
      } catch (InterruptedException var2) {
      }
   }

   private boolean method1594(String... var1) {
      if (this.field1103 == null) {
         return false;
      }

      try {
         for (Method var5 : this.field1103.getClass().getMethods()) {
            String var6 = var5.getName().toLowerCase();
            if (var5.getParameterCount() == 0) {
               for (String var10 : var1) {
                  if (var6.contains(var10)) {
                     var5.invoke(this.field1103);
                     return true;
                  }
               }
            }
         }
      } catch (Exception var11) {
      }

      return false;
   }

   @Generated
   public BufferedImage method1958() {
      return this.field0713;
   }

   @Generated
   public class_1044 method0428() {
      return this.field0147;
   }

   @Generated
   public String method0368() {
      return this.field1504;
   }

   @Generated
   public String method0493() {
      return this.field1030;
   }

   @Generated
   public String method2224() {
      return this.field0791;
   }

   @Generated
   public String method2191() {
      return this.field1269;
   }

   @Generated
   public long method2255() {
      return this.field0316;
   }

   @Generated
   public long method1903() {
      return this.field0179;
   }

   @Generated
   public long method1880() {
      return this.field0460;
   }

   @Generated
   public long method1930() {
      return this.field1616;
   }

   @Generated
   public long method1699() {
      return this.field1540;
   }

   @Generated
   public boolean method1692() {
      return this.field1161;
   }

   @Generated
   public IMediaSession method1748() {
      return this.field1103;
   }

   @Generated
   public List<IMediaSession> method2025() {
      return this.field1213;
   }

   @Generated
   public ExecutorService method2012() {
      return this.field0887;
   }

   @Generated
   public void method0971(BufferedImage var1) {
      this.field0713 = var1;
   }

   @Generated
   public void method1117(class_1044 var1) {
      this.field0147 = var1;
   }

   @Generated
   public void method1013(String var1) {
      this.field1504 = var1;
   }

   @Generated
   public void method0213(String var1) {
      this.field1030 = var1;
   }

   @Generated
   public void method2134(String var1) {
      this.field0791 = var1;
   }

   @Generated
   public void method1846(String var1) {
      this.field1269 = var1;
   }

   @Generated
   public void method0778(long var1) {
      this.field0316 = var1;
   }

   @Generated
   public void method0160(long var1) {
      this.field0179 = var1;
   }

   @Generated
   public void method2107(long var1) {
      this.field0460 = var1;
   }

   @Generated
   public void method1831(long var1) {
      this.field1616 = var1;
   }

   @Generated
   public void method1645(long var1) {
      this.field1540 = var1;
   }

   @Generated
   public void method1570(boolean var1) {
      this.field1735 = var1;
   }

   @Generated
   public void method0345(boolean var1) {
      this.field1161 = var1;
   }

   @Generated
   public void method0954(IMediaSession var1) {
      this.field1103 = var1;
   }

   @Generated
   public void method1074(List<IMediaSession> var1) {
      this.field1213 = var1;
   }
}
