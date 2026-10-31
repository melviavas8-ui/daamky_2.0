package ua.patch.daamky.api.mixins.accessors;

import java.util.Optional;
import net.minecraft.class_2960;
import net.minecraft.class_4668.class_5939;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(class_5939.class)
public interface RenderPhaseTextureBaseAccessor {
   @Invoker("getId")
   Optional<class_2960> invokeGetId();
}
