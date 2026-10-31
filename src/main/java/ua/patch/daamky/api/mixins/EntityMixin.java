package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.RotationManager;
import aethereal.EntityCollisionEvent;
import aethereal.MinecraftAccess;
import aethereal.NoPush;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_1297.class)
public abstract class EntityMixin implements MinecraftAccess {
   @Shadow
   private class_238 field_6005;

   @Inject(method = "pushAwayFrom", at = @At("HEAD"), cancellable = true)
   public void pushAwayFrom(CallbackInfo var1) {
      if (this == field0796.field_1724) {
         DaamkyClient var2 = DaamkyClient.method2004();
         if (var2 != null && var2.method1783() != null) {
            NoPush var3 = var2.method1783().method0976(NoPush.class);
            if (var3 != null && var3.method2195() && var3.method1736()) {
               var1.cancel();
            }
         }
      }
   }

   @Inject(method = "isPushedByFluids", at = @At("RETURN"), cancellable = true)
   public void isPushedByFluids(CallbackInfoReturnable<Boolean> var1) {
      if (this == field0796.field_1724) {
         DaamkyClient var2 = DaamkyClient.method2004();
         if (var2 != null && var2.method1783() != null) {
            NoPush var3 = var2.method1783().method0976(NoPush.class);
            if (var3 != null && var3.method2195() && var3.method1755()) {
               var1.setReturnValue(false);
            }
         }
      }
   }

   @Inject(method = "getBoundingBox", at = @At("HEAD"), cancellable = true)
   private void getBoundingBox$hitbox(CallbackInfoReturnable<class_238> var1) {
      class_1297 var2 = (class_1297)this;
      if (var2 != field0796.field_1724) {
         if (EntityCollisionEvent.method1813()) {
            EntityCollisionEvent var3 = new EntityCollisionEvent(this.field_6005, var2);
            DaamkyClient.method2004().method2072().post(var3);
            var1.setReturnValue(var3.method1627());
         }
      }
   }

   @ModifyVariable(method = "getRotationVector(FF)Lnet/minecraft/util/math/Vec3d;", at = @At("HEAD"), ordinal = 0, argsOnly = true)
   private float modifyPitch(float var1) {
      return this instanceof class_746 && RotationManager.field0618.method2219() != null ? RotationManager.field0618.method2219().method1762() : var1;
   }

   @ModifyExpressionValue(method = "move", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;isControlledByPlayer()Z"))
   public boolean isControlledByPlayerHook(boolean var1) {
      return this == field0796.field_1724 ? false : var1;
   }

   @ModifyExpressionValue(method = "updateVelocity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getYaw()F"))
   private float updateVelocityYaw(float var1) {
      class_1297 var2 = (class_1297)this;
      return var2 != field0796.field_1724 ? var1 : RotationManager.field0618.method1781().method2047();
   }
}
