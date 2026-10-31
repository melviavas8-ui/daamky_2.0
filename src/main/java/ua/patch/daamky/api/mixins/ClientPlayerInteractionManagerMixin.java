package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.BlockDestroyEvent;
import aethereal.BlockInteractEvent;
import aethereal.Chams;
import aethereal.FakePlayerHelper;
import aethereal.FakePlayer;
import aethereal.MinecraftAccess;
import aethereal.NoFriendDamage;
import aethereal.NoInteract;
import aethereal.SpeedMine;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_636;
import net.minecraft.class_745;
import net.minecraft.class_746;
import ua.patch.daamky.api.mixins.accessors.IClientPlayerInteractionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_636.class)
public class ClientPlayerInteractionManagerMixin {
   @Shadow
   private int field_3716;
   @Shadow
   private float field_3715;

   @Inject(method = "tick", at = @At("HEAD"))
   private void daamky$onTick(CallbackInfo var1) {
      SpeedMine var2 = SpeedMine.method1719();
      if (var2 != null && var2.method2195()) {
         this.field_3716 = 0;
      }
   }

   @Inject(method = "updateBlockBreakingProgress", at = @At("HEAD"))
   private void daamky$onUpdateBlockBreakingProgress(class_2338 var1, class_2350 var2, CallbackInfoReturnable<Boolean> var3) {
      SpeedMine var4 = SpeedMine.method1719();
      if (var4 != null && var4.method1692()) {
         this.field_3715 = 1.0F;
      }
   }

   @Inject(method = "breakBlock", at = @At("HEAD"))
   private void onBreakBlock(class_2338 var1, CallbackInfoReturnable<Boolean> var2) {
      DaamkyClient.method2004().method2072().post(new BlockDestroyEvent(var1));
   }

   @Inject(method = "interactBlock", at = @At("HEAD"), cancellable = true)
   private void onInteractBlock(class_746 var1, class_1268 var2, class_3965 var3, CallbackInfoReturnable<class_1269> var4) {
      if (MinecraftAccess.field0796.field_1687 != null) {
         NoInteract var5 = DaamkyClient.method2004().method1783().method0976(NoInteract.class);
         if (var5 != null) {
            if (var5.method1253(MinecraftAccess.field0796.field_1687.method_8320(var3.method_17777()).method_26204())) {
               var4.setReturnValue(class_1269.field_5811);
            }
         }
      }
   }

   @Inject(method = "interactEntity", at = @At("HEAD"), cancellable = true)
   private void daamky$onInteractEntity(class_1657 var1, class_1297 var2, class_1268 var3, CallbackInfoReturnable<class_1269> var4) {
      NoInteract var5 = DaamkyClient.method2004().method1783().method0976(NoInteract.class);
      if (var5 != null && var5.method1129(var2)) {
         var4.setReturnValue(class_1269.field_5811);
      }
   }

   @Inject(method = "interactEntityAtLocation", at = @At("HEAD"), cancellable = true)
   private void daamky$onInteractEntityAtLocation(
      class_1657 var1, class_1297 var2, class_3966 var3, class_1268 var4, CallbackInfoReturnable<class_1269> var5
   ) {
      NoInteract var6 = DaamkyClient.method2004().method1783().method0976(NoInteract.class);
      if (var6 != null && var6.method1129(var2)) {
         var5.setReturnValue(class_1269.field_5811);
      }
   }

   @Inject(method = "attackBlock", at = @At("HEAD"), cancellable = true)
   private void onAttackBlock(class_2338 var1, class_2350 var2, CallbackInfoReturnable<Boolean> var3) {
      BlockInteractEvent var4 = new BlockInteractEvent(var1, var2);
      DaamkyClient.method2004().method2072().post(var4);
      if (var4.method2079()) {
         var3.setReturnValue(true);
      }
   }

   @Inject(method = "attackEntity", at = @At("HEAD"), cancellable = true)
   private void onAttackEntityFriend(class_1657 var1, class_1297 var2, CallbackInfo var3) {
      NoFriendDamage var4 = DaamkyClient.method2004().method1783().method0976(NoFriendDamage.class);
      if (var4 != null && var4.method2195() && DaamkyClient.method2004().method1608().method1129(var2)) {
         var3.cancel();
      }
   }

   @Inject(method = "attackEntity", at = @At("HEAD"))
   private void onAttackEntityHit(class_1657 var1, class_1297 var2, CallbackInfo var3) {
      if (var2 != null) {
         if (MinecraftAccess.field0796.field_1765 instanceof class_3966 var5 && var5.method_17782() == var2) {
            Chams.method1096(var2.method_5667(), var5.method_17784());
         } else {
            Chams.method1096(var2.method_5667(), var2.method_5829().method_1005());
         }
      }
   }

   @Inject(method = "attackEntity", at = @At("HEAD"), cancellable = true)
   private void onAttackEntity(class_1657 var1, class_1297 var2, CallbackInfo var3) {
      if (FakePlayerHelper.method1129(var2)) {
         var3.cancel();
         if (MinecraftAccess.field0796.field_1724 != null && MinecraftAccess.field0796.field_1687 != null) {
            FakePlayer var4 = DaamkyClient.method2004().method1783().method0976(FakePlayer.class);
            if (var4 != null && var4.method2195()) {
               ((IClientPlayerInteractionManager)MinecraftAccess.field0796.field_1761).syncSelectedSlot$drug();
               class_745 var5 = (class_745)var2;
               float var6 = FakePlayerHelper.method1178(MinecraftAccess.field0796.field_1724);
               boolean var7 = FakePlayerHelper.method0250(MinecraftAccess.field0796.field_1724);
               FakePlayerHelper.method1539(var5, var6, MinecraftAccess.field0796.field_1724, var4.method2195());
               MinecraftAccess.field0796.field_1724.method_6104(class_1268.field_5808);
               MinecraftAccess.field0796.field_1724.method_7350();
               if (var7) {
                  MinecraftAccess.field0796
                     .field_1687
                     .method_43128(
                        MinecraftAccess.field0796.field_1724,
                        var2.method_23317(),
                        var2.method_23318(),
                        var2.method_23321(),
                        class_3417.field_15016,
                        class_3419.field_15248,
                        1.0F,
                        1.0F
                     );
                  MinecraftAccess.field0796.field_1724.method_7277(var2);
               } else {
                  MinecraftAccess.field0796
                     .field_1687
                     .method_43128(
                        MinecraftAccess.field0796.field_1724,
                        var2.method_23317(),
                        var2.method_23318(),
                        var2.method_23321(),
                        class_3417.field_14840,
                        class_3419.field_15248,
                        1.0F,
                        1.0F
                     );
               }

               MinecraftAccess.field0796
                  .field_1687
                  .method_43128(
                     MinecraftAccess.field0796.field_1724,
                     var2.method_23317(),
                     var2.method_23318(),
                     var2.method_23321(),
                     class_3417.field_15115,
                     class_3419.field_15248,
                     1.0F,
                     1.0F
                  );
            }
         }
      }
   }
}
