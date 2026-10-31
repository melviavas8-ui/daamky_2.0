package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.InventoryComponent;
import aethereal.MovementState;
import aethereal.InventoryManager;
import aethereal.RotationManager;
import aethereal.Rotation;
import aethereal.ItemUseEvent;
import aethereal.MovementEvent;
import aethereal.NoPush;
import aethereal.NoRender;
import aethereal.NoSlow;
import aethereal.NoSlowEvent;
import aethereal.PlayerDeathEvent;
import aethereal.PlayerTickEvent;
import aethereal.PlayerUpdateEvent;
import aethereal.PostMovementEvent;
import aethereal.PostMovementTickEvent;
import aethereal.PreTickEvent;
import aethereal.ScreenCloseEvent;
import aethereal.Sprint;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.mojang.authlib.GameProfile;
import net.minecraft.class_1313;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_742;
import net.minecraft.class_744;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_746.class)
public abstract class ClientPlayerEntityMixin extends class_742 {
   @Final
   @Shadow
   protected class_310 field_3937;
   @Final
   @Shadow
   public class_634 field_3944;
   @Shadow
   public class_744 field_3913;
   @Shadow
   public float field_44911;
   @Shadow
   public float field_44912;
   private double bodyYawPrevX = 0.0;
   private double bodyYawPrevZ = 0.0;
   private float prevBodyYaw = 0.0F;
   private boolean initialized = false;
   @Unique
   private boolean daamky$wasDead = false;

   public ClientPlayerEntityMixin(class_638 var1, GameProfile var2) {
      super(var1, var2);
   }

   @Shadow
   protected abstract void method_46742();

   @Shadow
   protected abstract void method_3148(float var1, float var2);

   @Inject(method = "tick", at = @At("HEAD"))
   private void onTick(CallbackInfo var1) {
      InventoryManager.method2078();
      PlayerTickEvent var2 = new PlayerTickEvent();
      DaamkyClient.method2004().method2072().post(var2);
   }

   @Inject(method = "tick", at = @At("HEAD"))
   public void onSilentRotationInit(CallbackInfo var1) {
      if (!this.initialized && this.field_3937.field_1724 != null) {
         this.bodyYawPrevX = this.field_3937.field_1724.method_23317();
         this.bodyYawPrevZ = this.field_3937.field_1724.method_23321();
         this.prevBodyYaw = this.field_3937.field_1724.method_43078();
         this.initialized = true;
      }
   }

   @ModifyExpressionValue(
      method = {"sendMovementPackets", "tick"},
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;getYaw()F")
   )
   private float hookSilentRotationYaw(float var1) {
      if (this.field_3937.field_1724 == null) {
         return var1;
      }

      boolean var3 = RotationManager.field0618.method1606() != null;
      float var2;
      if (var3) {
         var2 = RotationManager.field0618.method0545().method2047();
      } else {
         var2 = var1;
      }

      Rotation var4 = RotationManager.field0618.method2258();
      if (var4 != null) {
         var2 = var4.method2047() + class_3532.method_15393(var2 - var4.method2047());
      }

      if (var3) {
         float var5 = MovementState.method0679(
            var2,
            this.prevBodyYaw,
            this.bodyYawPrevX,
            this.bodyYawPrevZ,
            this.field_3937.field_1724.method_23317(),
            this.field_3937.field_1724.method_23321(),
            this.field_3937.field_1724.field_6251
         );
         this.prevBodyYaw = var5;
         this.bodyYawPrevX = this.field_3937.field_1724.method_23317();
         this.bodyYawPrevZ = this.field_3937.field_1724.method_23321();
         this.field_3937.field_1724.method_5636(var5);
      }

      return var2;
   }

   @ModifyExpressionValue(
      method = {"sendMovementPackets", "tick"},
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;getPitch()F")
   )
   private float hookSilentRotationPitch(float var1) {
      return RotationManager.field0618.method1606() == null ? var1 : RotationManager.field0618.method0545().method1762();
   }

   @Inject(method = "sendMovementPackets", at = @At("RETURN"))
   private void onPostMotion(CallbackInfo var1) {
      InventoryComponent.method0025();
      DaamkyClient.method2004().method2072().post(new PostMovementTickEvent());
   }

   @ModifyExpressionValue(method = "tickMovement", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;isUsingItem()Z"))
   private boolean usingItemHook(boolean var1) {
      if (var1) {
         ItemUseEvent var2 = new ItemUseEvent((byte)1);
         DaamkyClient.method2004().method2072().post(var2);
         if (var2.method2079()) {
            return false;
         }

         Sprint.field0004 = 1;
      }

      return var1;
   }

   @Inject(method = "tick", at = @At("TAIL"))
   private void onTickPost(CallbackInfo var1) {
      PreTickEvent var2 = new PreTickEvent();
      DaamkyClient.method2004().method2072().post(var2);
      if (((class_746)this).method_6032() <= 0.0F && !this.daamky$wasDead) {
         this.daamky$wasDead = true;
         DaamkyClient.method2004().method2072().post(new PlayerDeathEvent());
      } else if (((class_746)this).method_6032() > 0.0F) {
         this.daamky$wasDead = false;
      }
   }

   @Inject(method = "tickMovement", at = @At("TAIL"))
   private void onTickMovementPost(CallbackInfo var1) {
      DaamkyClient.method2004().method2072().post(new PostMovementEvent());
   }

   @Inject(method = "closeHandledScreen", at = @At("HEAD"), cancellable = true)
   private void onCloseHandledScreen(CallbackInfo var1) {
      if (this.field_7512 != null) {
         ScreenCloseEvent var2 = new ScreenCloseEvent(this.field_7512.field_7763);
         DaamkyClient.method2004().method2072().post(var2);
         if (var2.method2079()) {
            var1.cancel();
         }
      }
   }

   @Inject(method = "tickNausea", at = @At("HEAD"), cancellable = true)
   private void onTickNausea(boolean var1, CallbackInfo var2) {
      DaamkyClient var3 = DaamkyClient.method2004();
      if (var3 != null && var3.method1783() != null) {
         NoRender var4 = var3.method1783().method0976(NoRender.class);
         if (var4 != null && var4.method0406()) {
            this.field_44911 = 0.0F;
            this.field_44912 = 0.0F;
            var2.cancel();
         }
      }
   }

   @Inject(method = "pushOutOfBlocks", at = @At("HEAD"), cancellable = true)
   public void pushOutOfBlocks(double var1, double var3, CallbackInfo var5) {
      DaamkyClient var6 = DaamkyClient.method2004();
      if (var6 != null && var6.method1783() != null) {
         NoPush var7 = var6.method1783().method0976(NoPush.class);
         if (var7 != null && var7.method2195() && var7.method1692()) {
            var5.cancel();
         }
      }
   }

   private boolean checkNoSlowCancel() {
      NoSlowEvent var1 = new NoSlowEvent();
      DaamkyClient.method2004().method2072().post(var1);
      NoSlowEvent.method0345(var1.method2079());
      return var1.method2079();
   }

   @Redirect(method = "tickMovement", at = @At(value = "FIELD", target = "Lnet/minecraft/client/input/Input;movementSideways:F", opcode = 181, ordinal = 0))
   private void redirectMovementSideways(class_744 var1, float var2) {
      if (!this.checkNoSlowCancel()) {
         var1.field_3907 = var2;
      }
   }

   @Redirect(method = "tickMovement", at = @At(value = "FIELD", target = "Lnet/minecraft/client/input/Input;movementForward:F", opcode = 181, ordinal = 0))
   private void redirectMovementForward(class_744 var1, float var2) {
      if (!this.checkNoSlowCancel()) {
         var1.field_3905 = var2;
      }
   }

   @Redirect(method = "tickMovement", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;setSprinting(Z)V", ordinal = 0))
   private void redirectSetSprinting(class_746 var1, boolean var2) {
      if (!this.checkNoSlowCancel()) {
         var1.method_5728(var2);
      }
   }

   @Redirect(method = "sendMovementPackets", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;sendSprintingPacket()V"))
   public void invokeSprintUpdate(class_746 var1) {
      PlayerUpdateEvent var2 = new PlayerUpdateEvent();
      DaamkyClient.method2004().method2072().post(var2);
      if (!var2.method2079()) {
         this.method_46742();
      }
   }

   @Inject(
      method = "shouldStopSprinting",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;isUsingItem()Z"),
      cancellable = true
   )
   public void shouldStopSprintingHook(CallbackInfoReturnable<Boolean> var1) {
      Sprint var2 = Sprint.method1720();
      NoSlow var3 = NoSlow.method1715();
      if (var2 != null && var2.method2195() && var3 != null && var3.method2195()) {
         var1.setReturnValue(false);
      }
   }

   @Inject(
      method = "canStartSprinting",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;isUsingItem()Z"),
      cancellable = true
   )
   public void canStartSprintingHook(CallbackInfoReturnable<Boolean> var1) {
      Sprint var2 = Sprint.method1720();
      NoSlow var3 = NoSlow.method1715();
      if (var2 != null && var2.method2195() && var3 != null && var3.method2195()) {
         var1.setReturnValue(false);
      }
   }

   @Inject(
      method = "move",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;move(Lnet/minecraft/entity/MovementType;Lnet/minecraft/util/math/Vec3d;)V"
      ),
      cancellable = true
   )
   public void onMoveHook(class_1313 var1, class_243 var2, CallbackInfo var3) {
      MovementEvent var4 = new MovementEvent(var2);
      DaamkyClient.method2004().method2072().post(var4);
      double var5 = this.method_23317();
      double var7 = this.method_23321();
      super.method_5784(var1, var4.method1803());
      this.method_3148((float)(this.method_23317() - var5), (float)(this.method_23321() - var7));
      var3.cancel();
   }
}
