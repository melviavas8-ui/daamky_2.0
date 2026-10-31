package ua.patch.daamky.api.mixins.accessors;

import net.minecraft.class_8080;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(class_8080.class)
public interface ILimbAnimator {
   @Accessor("pos")
   void setPos(float var1);
}
