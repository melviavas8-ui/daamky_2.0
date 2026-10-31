package aethereal;

import net.minecraft.class_243;

public record SwordTrailSample(class_243 tipWorld, class_243 rootWorld, float swingProgress, long tickStamp) {
   public class_243 method0569() {
      return this.tipWorld;
   }

   public class_243 method0024() {
      return this.rootWorld;
   }

   public float method2047() {
      return this.swingProgress;
   }

   public long method1764() {
      return this.tickStamp;
   }
}
