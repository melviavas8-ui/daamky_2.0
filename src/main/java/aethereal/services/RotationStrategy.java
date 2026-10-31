package aethereal;

import lombok.Generated;
import net.minecraft.class_1297;
import net.minecraft.class_243;

public abstract class RotationStrategy implements MinecraftAccess {
   private final String field0715;

   public Rotation method0872(Rotation var1, Rotation var2) {
      return this.method0874(var1, var2, null, null);
   }

   public Rotation method0873(Rotation var1, Rotation var2, class_243 var3) {
      return this.method0874(var1, var2, var3, null);
   }

   public abstract Rotation method0874(Rotation var1, Rotation var2, class_243 var3, class_1297 var4);

   public abstract class_243 method0569();

   @Generated
   public String method2067() {
      return this.field0715;
   }

   @Generated
   public RotationStrategy(String var1) {
      this.field0715 = var1;
   }
}
