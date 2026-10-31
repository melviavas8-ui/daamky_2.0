package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.ClientContext;
import aethereal.ClientTickEvent;
import aethereal.GameLoopEvent;
import aethereal.MainMenuScreen;
import aethereal.MultiTask;
import aethereal.WindowHandleUtil;
import aethereal.WindowIconManager;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_542;
import net.minecraft.class_636;
import net.minecraft.class_746;
import net.minecraft.class_757;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_310.class)
public class MinecraftClientMixin {
   @Shadow
   @Nullable
   public class_636 field_1761;
   @Shadow
   @Nullable
   public class_746 field_1724;
   @Shadow
   @Final
   public class_757 field_1773;
   @Unique
   private static boolean daamky$replacingScreen = false;

   @Inject(method = "tick", at = @At("HEAD"))
   private void onClientTick(CallbackInfo var1) {
      if (DaamkyClient.method2004() != null && DaamkyClient.method2004().method2072() != null) {
         DaamkyClient.method2004().method2072().post(new ClientTickEvent());
         DaamkyClient.method2004().method2072().post(new GameLoopEvent());
      }
   }

   @Inject(
      method = "<init>",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;setOverlay(Lnet/minecraft/client/gui/screen/Overlay;)V", shift = Shift.BEFORE)
   )
   private void init(class_542 var1, CallbackInfo var2) {
      DaamkyClient.method0025();
   }

   @Inject(method = "<init>", at = @At("TAIL"))
   private void onInit(class_542 var1, CallbackInfo var2) {
      class_310 var3 = (class_310)(Object)this;

      try {
         Thread.sleep(50L);
         WindowIconManager.method0578();
         WindowHandleUtil.method0778(var3.method_22683().method_4490());
      } catch (Throwable var5) {
      }
   }

   @Inject(method = "setScreen", at = @At("HEAD"), cancellable = true)
   private void onSetScreen(class_437 var1, CallbackInfo var2) {
      if (!daamky$replacingScreen) {
         class_310 var3 = (class_310)(Object)this;
         if (var1 instanceof class_442) {
            daamky$replacingScreen = true;
            var3.method_1507(new MainMenuScreen());
            daamky$replacingScreen = false;
            var2.cancel();
         } else {
            if (var1 == null && var3.field_1687 == null) {
               daamky$replacingScreen = true;
               var3.method_1507(new MainMenuScreen());
               daamky$replacingScreen = false;
               var2.cancel();
            }
         }
      }
   }

   @ModifyReturnValue(method = "getWindowTitle", at = @At("RETURN"))
   private String daamky$modifyWindowTitle(String var1) {
      ClientContext var2 = DaamkyClient.method2004().method1744();
      return "Daamky 1.21.4 #" + var2.method0423() + " | " + var2.method0557();
   }

   @ModifyExpressionValue(
      method = "handleBlockBreaking",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;isUsingItem()Z")
   )
   private boolean daamky$handleBlockBreaking(boolean var1) {
      return this.daamky$isMultiTaskEnabled() ? false : var1;
   }

   @ModifyExpressionValue(
      method = "doItemUse",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerInteractionManager;isBreakingBlock()Z")
   )
   private boolean daamky$doItemUse(boolean var1) {
      return this.daamky$isMultiTaskEnabled() ? false : var1;
   }

   @Unique
   private boolean daamky$isMultiTaskEnabled() {
      DaamkyClient var1 = DaamkyClient.method2004();
      if (var1 != null && var1.method1783() != null) {
         MultiTask var2 = var1.method1783().method0976(MultiTask.class);
         return var2 != null && var2.method2195();
      } else {
         return false;
      }
   }
}
