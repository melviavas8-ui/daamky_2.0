package aethereal;

public class WorldTime extends Module {
   private final FloatSetting field0060 = new FloatSetting("worldtime.hour", 12.0F, 0.0F, 24.0F, 1.0F)
      .method1007("Hour")
      .method0210("Visual time of day in hours")
      .method2130("Визуальное время суток в часах");

   public WorldTime() {
      super("WorldTime", ModuleCategory.field1004, "Controls the visual time of day");
   }

   public long method1699() {
      float var1 = this.field0060.method0492();
      long var2 = (long)((var1 - 6.0F) * 1000.0F);
      if (var2 < 0L) {
         var2 += 24000L;
      }

      return var2;
   }
}
