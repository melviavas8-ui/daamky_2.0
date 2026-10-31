package ua.patch.daamky.api.mixins.accessors;

import java.util.Map;
import java.util.UUID;
import net.minecraft.class_337;
import net.minecraft.class_345;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(class_337.class)
public interface IBossBarHud {
   @Accessor("bossBars")
   Map<UUID, class_345> getBossBars();
}
