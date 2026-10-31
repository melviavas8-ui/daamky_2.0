package ua.patch.daamky.api.mixins;

import aethereal.RenderTargetAccessor;
import net.minecraft.class_1921.class_4688;
import net.minecraft.class_4668.class_4678;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(class_4688.class)
public abstract class RenderLayerMultiPhaseParametersMixin implements RenderTargetAccessor {
   @Shadow
   @Final
   private class_4678 field_21417;

   @Override
   public class_4678 daamky$getTarget() {
      return this.field_21417;
   }
}
