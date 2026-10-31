package ua.patch.daamky.api.mixins.accessors;

import java.util.List;
import net.minecraft.class_279;
import net.minecraft.class_283;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(class_279.class)
public interface PostEffectProcessorAccessor {
   @Accessor("passes")
   List<class_283> getPasses();
}
