package ua.patch.daamky.api.mixins;

import aethereal.RenderLayerParametersAccessor;
import net.minecraft.class_1921.class_4687;
import net.minecraft.class_1921.class_4688;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(class_4687.class)
public class RenderLayerMultiPhaseMixin implements RenderLayerParametersAccessor {
   @Shadow
   @Final
   private class_4688 field_21403;

   @Override
   public class_4688 daamky$getParameters() {
      return this.field_21403;
   }
}
