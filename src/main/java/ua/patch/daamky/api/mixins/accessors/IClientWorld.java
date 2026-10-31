package ua.patch.daamky.api.mixins.accessors;

import net.minecraft.class_638;
import net.minecraft.class_7202;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(class_638.class)
public interface IClientWorld {
   @Invoker("getPendingUpdateManager")
   class_7202 invokeGetPendingUpdateManager();
}
