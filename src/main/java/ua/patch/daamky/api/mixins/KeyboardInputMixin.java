package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.InventoryComponent;
import aethereal.KeyboardEvent;
import aethereal.KeyboardInputEvent;
import aethereal.MoveInputEvent;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.class_10185;
import net.minecraft.class_743;
import net.minecraft.class_744;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_743.class)
public abstract class KeyboardInputMixin extends class_744 {
   @ModifyExpressionValue(method = "tick", at = @At(value = "NEW", target = "(ZZZZZZZ)Lnet/minecraft/util/PlayerInput;"))
   private class_10185 tickHook(class_10185 var1) {
      float var2 = this.daamky$getMovementMultiplier(var1.comp_3159(), var1.comp_3160());
      float var3 = this.daamky$getMovementMultiplier(var1.comp_3161(), var1.comp_3162());
      KeyboardEvent var4 = new KeyboardEvent(var2, var3, var1.comp_3163(), var1.comp_3164(), var1.comp_3165());
      DaamkyClient.method2004().method2072().post(var4);
      class_10185 var5 = var4.method2079()
         ? new class_10185(false, false, false, false, var1.comp_3163(), var1.comp_3164(), var1.comp_3165())
         : new class_10185(
            var4.method1762() > 0.0F,
            var4.method1762() < 0.0F,
            var4.method1603() > 0.0F,
            var4.method1603() < 0.0F,
            var4.method1974(),
            var4.method0431(),
            var4.method0376()
         );
      MoveInputEvent var6 = new MoveInputEvent(var5, var4.method1762(), var4.method1603());
      DaamkyClient.method2004().method2072().post(var6);
      class_10185 var7 = var5;
      if (var6.method2079()) {
         var7 = new class_10185(false, false, false, false, var5.comp_3163(), var5.comp_3164(), var5.comp_3165());
      } else if (var6.method1603() != var4.method1762() || var6.method1946() != var4.method1603()) {
         var7 = new class_10185(
            var6.method1603() > 0.0F,
            var6.method1603() < 0.0F,
            var6.method1946() > 0.0F,
            var6.method1946() < 0.0F,
            var5.comp_3163(),
            var5.comp_3164(),
            var5.comp_3165()
         );
      }

      KeyboardInputEvent var8 = new KeyboardInputEvent(var7);
      DaamkyClient.method2004().method2072().post(var8);
      InventoryComponent.method0888(var8);
      return var8.method0427();
   }

   @Unique
   private float daamky$getMovementMultiplier(boolean var1, boolean var2) {
      if (var1 == var2) {
         return 0.0F;
      } else {
         return var1 ? 1.0F : -1.0F;
      }
   }
}
