package ua.patch.daamky.api.mixins.accessors;

import net.minecraft.class_1921.class_4688;
import net.minecraft.class_1921.class_4750;
import net.minecraft.class_4668.class_5939;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(class_4688.class)
public interface RenderLayerMultiPhaseParametersAccessor {
   @Accessor("outlineMode")
   class_4750 getOutlineMode();

   @Accessor("texture")
   class_5939 getTexture();
}
