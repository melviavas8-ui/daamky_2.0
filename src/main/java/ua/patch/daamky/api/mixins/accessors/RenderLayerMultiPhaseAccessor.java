package ua.patch.daamky.api.mixins.accessors;

import net.minecraft.class_1921.class_4687;
import net.minecraft.class_1921.class_4688;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(class_4687.class)
public interface RenderLayerMultiPhaseAccessor {
   @Invoker("getPhases")
   class_4688 invokeGetPhases();
}
