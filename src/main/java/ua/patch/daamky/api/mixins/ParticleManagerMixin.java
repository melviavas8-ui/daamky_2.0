package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.NoRender;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_702;
import net.minecraft.class_703;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_702.class)
public abstract class ParticleManagerMixin {
   @Inject(method = "addParticle(Lnet/minecraft/particle/ParticleEffect;DDDDDD)Lnet/minecraft/client/particle/Particle;", at = @At("HEAD"), cancellable = true)
   private void onAddParticle(
      class_2394 var1, double var2, double var4, double var6, double var8, double var10, double var12, CallbackInfoReturnable<class_703> var14
   ) {
      DaamkyClient var15 = DaamkyClient.method2004();
      if (var15 != null && var15.method1783() != null) {
         NoRender var16 = var15.method1783().method0976(NoRender.class);
         if (var16 != null && var16.method0522() && (var1.method_10295() == class_2398.field_11236 || var1.method_10295() == class_2398.field_11221)) {
            var14.setReturnValue(null);
         }
      }
   }
}
