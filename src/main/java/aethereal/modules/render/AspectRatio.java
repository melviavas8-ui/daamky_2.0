package aethereal;

import meteordevelopment.orbit.EventHandler;

public class AspectRatio extends Module {
   private final FloatSetting field0060 = new FloatSetting("aspectratio.ratio", 1.0F, 0.1F, 2.0F, 0.01F)
      .method1007("Ratio")
      .method0210("Width to height aspect ratio multiplier")
      .method2130("Множитель соотношения сторон");

   public AspectRatio() {
      super("AspectRatio", ModuleCategory.field1004, "Changes the game's aspect ratio");
      this.method1013("Изменяет соотношение сторон экрана");
   }

   @EventHandler
   public void onAspectRatio(FovEvent var1) {
      var1.method0665(this.field0060.method0492());
      var1.method0578();
   }
}
