package ua.patch.daamky.api.mixins.accessors;

import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(class_310.class)
public interface IMinecraftClient {
   @Accessor("itemUseCooldown")
   void setItemUseCooldown(int var1);

   @Accessor("attackCooldown")
   void setAttackCooldown(int var1);
}
