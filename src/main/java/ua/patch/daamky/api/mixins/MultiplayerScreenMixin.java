package ua.patch.daamky.api.mixins;

import aethereal.ProxyAddressHelper;
import aethereal.ProxyEntry;
import aethereal.ProxyScreen;
import aethereal.ProxyStorage;
import net.minecraft.class_2561;
import net.minecraft.class_4185;
import net.minecraft.class_437;
import net.minecraft.class_500;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_500.class)
public abstract class MultiplayerScreenMixin extends class_437 {
   protected MultiplayerScreenMixin(class_2561 var1) {
      super(var1);
   }

   @Inject(method = "init", at = @At("TAIL"))
   private void onInitAddProxyButton(CallbackInfo var1) {
      class_500 var2 = (class_500)this;
      ProxyEntry var3 = ProxyStorage.method1786().method0547();
      String var4 = ProxyAddressHelper.method1044("Proxy", "Прокси");
      String var5 = var3 == null ? var4 : var4 + ": " + var3.method2060().method0557();
      this.method_37063(
         class_4185.method_46430(class_2561.method_43470(var5), var2x -> this.field_22787.method_1507(new ProxyScreen(var2)))
            .method_46434(5, 5, 85, 20)
            .method_46431()
      );
   }
}
