package ua.patch.daamky.api.mixins;

import aethereal.NameProtect;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.class_268;
import net.minecraft.class_5250;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_268.class)
public class TeamMixin {
   @ModifyReturnValue(
      method = "decorateName(Lnet/minecraft/scoreboard/AbstractTeam;Lnet/minecraft/text/Text;)Lnet/minecraft/text/MutableText;",
      at = @At("RETURN")
   )
   private static class_5250 daamky$decorateName(class_5250 var0) {
      return NameProtect.field0090 != null && NameProtect.field0090.method2195() && var0 != null ? NameProtect.method1346(var0) : var0;
   }
}
