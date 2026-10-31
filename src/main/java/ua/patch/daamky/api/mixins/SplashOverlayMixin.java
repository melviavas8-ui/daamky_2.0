package ua.patch.daamky.api.mixins;

import java.util.Optional;
import java.util.function.Consumer;
import net.minecraft.class_310;
import net.minecraft.class_4011;
import net.minecraft.class_425;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(class_425.class)
public class SplashOverlayMixin {
   @Shadow
   @Final
   private class_310 field_18217;
   @Shadow
   @Final
   private class_4011 field_17767;
   @Shadow
   @Final
   private Consumer<Optional<Throwable>> field_18218;
   @Shadow
   @Final
   private boolean field_18219;
   @Shadow
   private float field_17770;
   @Shadow
   private long field_18220;
   @Shadow
   private long field_17771;
}
