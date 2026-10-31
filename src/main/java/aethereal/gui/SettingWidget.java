package aethereal;

import java.util.function.Supplier;
import lombok.Generated;

public abstract class SettingWidget extends GuiElement {
   private final Setting field0684;
   private final Supplier<Float> field0144;

   @Generated
   public Setting method0366() {
      return this.field0684;
   }

   @Generated
   public Supplier<Float> method0495() {
      return this.field0144;
   }

   @Generated
   public SettingWidget(Setting var1, Supplier<Float> var2) {
      this.field0684 = var1;
      this.field0144 = var2;
   }
}
