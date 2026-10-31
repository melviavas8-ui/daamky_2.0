package aethereal;

import lombok.Generated;

public class SettingChangedEvent extends CancellableEvent {
   private final Setting<?> field0684;

   @Generated
   public SettingChangedEvent(Setting<?> var1) {
      this.field0684 = var1;
   }

   @Generated
   public Setting<?> method1788() {
      return this.field0684;
   }
}
