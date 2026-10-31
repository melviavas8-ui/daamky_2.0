package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.Cape;
import aethereal.MinecraftAccess;
import com.mojang.authlib.GameProfile;
import net.minecraft.class_2960;
import net.minecraft.class_640;
import net.minecraft.class_8685;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_640.class)
public abstract class PlayerListEntryMixin implements MinecraftAccess {
   @Shadow
   @Final
   private GameProfile field_3741;
   private static final class_2960 DEFAULT_ELYTRA_TEXTURE = class_2960.method_60656("textures/entity/equipment/wings/elytra.png");

   @Inject(method = "getSkinTextures", at = @At("RETURN"), cancellable = true)
   private void onGetSkinTextures(CallbackInfoReturnable<class_8685> var1) {
      if (field0796.field_1724 != null) {
         Cape var2 = DaamkyClient.method2004().method1783().method0201(Cape.class);
         if (var2 != null && var2.method2195()) {
            GameProfile var3 = field0796.field_1724.method_7334();
            if (this.isCurrentPlayer(var3)) {
               class_2960 var4 = var2.method1734();
               if (var4 != null) {
                  this.applyCapeTexture(var1, var4);
               }
            }
         }
      }
   }

   private boolean isCurrentPlayer(GameProfile var1) {
      return this.field_3741.getName().equals(var1.getName()) && this.field_3741.getId().equals(var1.getId());
   }

   private void applyCapeTexture(CallbackInfoReturnable<class_8685> var1, class_2960 var2) {
      class_8685 var3 = (class_8685)var1.getReturnValue();
      class_2960 var4 = var3.comp_1628() != null ? var3.comp_1628() : DEFAULT_ELYTRA_TEXTURE;
      class_8685 var5 = new class_8685(var3.comp_1626(), var3.comp_1911(), var2, var4, var3.comp_1629(), var3.comp_1630());
      var1.setReturnValue(var5);
   }
}
