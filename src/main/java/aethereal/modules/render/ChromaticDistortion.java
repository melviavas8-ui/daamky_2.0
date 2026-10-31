package aethereal;

import meteordevelopment.orbit.EventHandler;

public class ChromaticDistortion extends Module {
   private final FloatSetting field0060 = new FloatSetting("chromdist.aberration", 0.012F, 0.0F, 0.05F, 0.001F)
      .method1007("Aberration")
      .method2130("Хром. аберрация");
   private final FloatSetting field1450 = new FloatSetting("chromdist.falloff", 2.0F, 0.5F, 5.0F, 0.1F).method1007("Falloff").method2130("Спад от центра");
   private final FloatSetting field0985 = new FloatSetting("chromdist.motion", 1.5F, 0.0F, 5.0F, 0.1F)
      .method1007("Motion")
      .method2130("Сила от движения камеры");
   private final FloatSetting field0190 = new FloatSetting("chromdist.smooth", 0.2F, 0.02F, 0.5F, 0.01F)
      .method1007("Motion Smooth")
      .method2130("Сглаживание движения");
   private final FloatSetting field0470 = new FloatSetting("chromdist.bloomThr", 0.65F, 0.2F, 1.0F, 0.02F)
      .method1007("Bloom Threshold")
      .method2130("Порог bloom");
   private final FloatSetting field1627 = new FloatSetting("chromdist.bloomInt", 0.8F, 0.0F, 3.0F, 0.05F).method1007("Bloom").method2130("Сила bloom");
   private final FloatSetting field1553 = new FloatSetting("chromdist.bloomRad", 3.0F, 0.5F, 8.0F, 0.25F).method1007("Bloom Radius").method2130("Радиус bloom");
   private final FloatSetting field1716 = new FloatSetting("chromdist.vignette", 0.5F, 0.0F, 1.0F, 0.05F).method1007("Vignette").method2130("Виньетка");
   private final ChromaticDistortionRenderer field1142 = new ChromaticDistortionRenderer();
   private float field1087;
   private float field1196;
   private float field0871;
   private float field0826;
   private boolean field0931 = true;

   public ChromaticDistortion() {
      super("ChromaticDistortion", ModuleCategory.field1004, "Cinematic post-effect: aberration, motion distortion, bloom, vignette");
      this.method1013("Кинематографический пост-эффект: аберрация, motion-distortion, bloom, виньетка");
   }

   @Override
   public void method2078() {
      super.method2078();
      this.field0931 = true;
      this.field0871 = 0.0F;
      this.field0826 = 0.0F;
   }

   @EventHandler
   public void onRender(Render2DEvent var1) {
      if (!method1974()) {
         float var2 = field0796.field_1724.method_36454();
         float var3 = field0796.field_1724.method_36455();
         if (this.field0931) {
            this.field1087 = var2;
            this.field1196 = var3;
            this.field0931 = false;
         }

         float var4 = var2 - this.field1087;

         while (var4 > 180.0F) {
            var4 -= 360.0F;
         }

         while (var4 < -180.0F) {
            var4 += 360.0F;
         }

         float var5 = var3 - this.field1196;
         this.field1087 = var2;
         this.field1196 = var3;
         float var6 = this.field0190.method0492();
         this.field0871 = this.field0871 + (var4 * 0.04F - this.field0871) * var6;
         this.field0826 = this.field0826 + (var5 * 0.04F - this.field0826) * var6;
         this.field1142.method0675(this.field0060.method0492(), this.field1450.method0492());
         this.field1142.method0684(this.field0871, this.field0826, this.field0985.method0492());
         this.field1142.method0131(this.field0470.method0492(), this.field1627.method0492(), this.field1553.method0492());
         this.field1142.method0665(this.field1716.method0492());
         this.field1142.method0578();
      }
   }
}
