package aethereal;

import java.util.function.Supplier;

public class PositionSetting extends Setting<MutableSize> {
   public PositionSetting(String var1, MutableSize var2) {
      super(var1, var2);
   }

   public PositionSetting(String var1, MutableSize var2, Supplier<Boolean> var3) {
      super(var1, var2, var3);
   }
}
