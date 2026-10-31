package ua.patch.daamky.api.mixins.accessors;

import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_7204;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(class_636.class)
public interface IClientPlayerInteractionManager {
   @Invoker("syncSelectedSlot")
   void syncSelectedSlot$drug();

   @Accessor("blockBreakingCooldown")
   void setBlockBreakingCooldown(int var1);

   @Invoker("sendSequencedPacket")
   void invokeSendSequencedPacket(class_638 var1, class_7204 var2);
}
