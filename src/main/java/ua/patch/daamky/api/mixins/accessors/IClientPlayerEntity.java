package ua.patch.daamky.api.mixins.accessors;

import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(class_746.class)
public interface IClientPlayerEntity {
   @Invoker("canSprint")
   boolean invokeCanSprint();

   @Invoker("isWalking")
   boolean invokeIsWalking();
}
