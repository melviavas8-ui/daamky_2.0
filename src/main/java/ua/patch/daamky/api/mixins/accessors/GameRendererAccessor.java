package ua.patch.daamky.api.mixins.accessors;

import net.minecraft.class_757;
import net.minecraft.class_759;
import net.minecraft.class_9920;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(class_757.class)
public interface GameRendererAccessor {
   @Accessor
   class_9920 getPool();

   @Accessor("firstPersonRenderer")
   class_759 getFirstPersonRenderer();
}
