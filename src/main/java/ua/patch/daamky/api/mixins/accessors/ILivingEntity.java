package ua.patch.daamky.api.mixins.accessors;

import net.minecraft.class_1309;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(class_1309.class)
public interface ILivingEntity {
   @Accessor("jumpingCooldown")
   void setJumpingCooldown(int var1);
}
