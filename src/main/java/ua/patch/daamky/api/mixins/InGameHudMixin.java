package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.Crosshair;
import aethereal.HudRenderEvent;
import aethereal.Interface;
import aethereal.ScreenLayoutHelper;
import aethereal.NoRender;
import aethereal.Render2DEvent;
import aethereal.StatusEffectsRenderEvent;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1297;
import net.minecraft.class_1799;
import net.minecraft.class_1812;
import net.minecraft.class_1842;
import net.minecraft.class_1844;
import net.minecraft.class_266;
import net.minecraft.class_2960;
import net.minecraft.class_329;
import net.minecraft.class_332;
import net.minecraft.class_6880;
import net.minecraft.class_9334;
import net.minecraft.class_9779;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_329.class)
public abstract class InGameHudMixin {
   @Inject(method = "render", at = @At("HEAD"))
   public void renderPre(class_332 var1, class_9779 var2, CallbackInfo var3) {
      float var4 = ScreenLayoutHelper.method0002();
      if (var4 != 1.0F) {
         var1.method_51448().method_22903();
         var1.method_51448().method_22905(var4, var4, 1.0F);
      }

      Render2DEvent var5 = new Render2DEvent(var1, var2);
      DaamkyClient.method2004().method2072().post(var5);
      if (var4 != 1.0F) {
         var1.method_51448().method_22909();
      }
   }

   @Inject(method = "render", at = @At("RETURN"))
   public void render(class_332 var1, class_9779 var2, CallbackInfo var3) {
      float var4 = ScreenLayoutHelper.method0002();
      if (var4 != 1.0F) {
         var1.method_51448().method_22903();
         var1.method_51448().method_22905(var4, var4, 1.0F);
      }

      HudRenderEvent var5 = new HudRenderEvent(var1, var2);
      DaamkyClient.method2004().method2072().post(var5);
      if (var4 != 1.0F) {
         var1.method_51448().method_22909();
      }
   }

   @Inject(method = "renderStatusEffectOverlay", at = @At("HEAD"), cancellable = true)
   private void onRenderStatusEffectOverlay(class_332 var1, class_9779 var2, CallbackInfo var3) {
      DaamkyClient var4 = DaamkyClient.method2004();
      if (var4 != null && var4.method1783() != null) {
         NoRender var5 = var4.method1783().method0976(NoRender.class);
         if (var5 != null && var5.method2030()) {
            var3.cancel();
            return;
         }
      }

      StatusEffectsRenderEvent var6 = new StatusEffectsRenderEvent(var1, var2);
      DaamkyClient.method2004().method2072().post(var6);
      if (var6.method2079()) {
         var3.cancel();
      }
   }

   @Inject(method = "renderCrosshair", at = @At("HEAD"), cancellable = true)
   private void onRenderCrosshair(class_332 var1, class_9779 var2, CallbackInfo var3) {
      Crosshair var4 = DaamkyClient.method2004().method1783().method0976(Crosshair.class);
      if (var4 != null && var4.method2195()) {
         var3.cancel();
      }
   }

   @Inject(
      method = "renderScoreboardSidebar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/scoreboard/ScoreboardObjective;)V",
      at = @At("HEAD"),
      cancellable = true
   )
   private void onRenderScoreboardSidebar(class_332 var1, class_266 var2, CallbackInfo var3) {
      DaamkyClient var4 = DaamkyClient.method2004();
      if (var4 != null && var4.method1783() != null) {
         NoRender var5 = var4.method1783().method0976(NoRender.class);
         if (var5 != null && var5.method2016()) {
            var3.cancel();
         } else {
            Interface var6 = var4.method1783().method0976(Interface.class);
            if (var6 != null && var6.method1755()) {
               var3.cancel();
            }
         }
      }
   }

   @Inject(method = "renderHotbar", at = @At("HEAD"), cancellable = true)
   private void onRenderHotbar(class_332 var1, class_9779 var2, CallbackInfo var3) {
      DaamkyClient var4 = DaamkyClient.method2004();
      if (var4 != null && var4.method1783() != null) {
         Interface var5 = var4.method1783().method0976(Interface.class);
         if (var5 != null && var5.method1736()) {
            var3.cancel();
         }
      }
   }

   @Inject(method = "renderExperienceBar", at = @At("HEAD"), cancellable = true)
   private void onRenderExperienceBar(class_332 var1, int var2, CallbackInfo var3) {
      DaamkyClient var4 = DaamkyClient.method2004();
      if (var4 != null && var4.method1783() != null) {
         Interface var5 = var4.method1783().method0976(Interface.class);
         if (var5 != null && var5.method1736()) {
            var3.cancel();
         }
      }
   }

   @Inject(method = "renderExperienceLevel", at = @At("HEAD"), cancellable = true)
   private void onRenderExperienceLevel(class_332 var1, class_9779 var2, CallbackInfo var3) {
      DaamkyClient var4 = DaamkyClient.method2004();
      if (var4 != null && var4.method1783() != null) {
         Interface var5 = var4.method1783().method0976(Interface.class);
         if (var5 != null && var5.method1736()) {
            var3.cancel();
         }
      }
   }

   @Inject(method = "renderStatusBars", at = @At("HEAD"), cancellable = true)
   private void onRenderStatusBars(class_332 var1, CallbackInfo var2) {
      DaamkyClient var3 = DaamkyClient.method2004();
      if (var3 != null && var3.method1783() != null) {
         Interface var4 = var3.method1783().method0976(Interface.class);
         if (var4 != null && var4.method1736()) {
            var2.cancel();
         }
      }
   }

   @Inject(method = "renderHeldItemTooltip", at = @At("HEAD"), cancellable = true)
   private void onRenderHeldItemTooltip(class_332 var1, CallbackInfo var2) {
      DaamkyClient var3 = DaamkyClient.method2004();
      if (var3 != null && var3.method1783() != null) {
         Interface var4 = var3.method1783().method0976(Interface.class);
         if (var4 != null && var4.method1736()) {
            var2.cancel();
         }
      }
   }

   @Inject(method = "renderPortalOverlay", at = @At("HEAD"), cancellable = true)
   private void onRenderPortalOverlay(class_332 var1, float var2, CallbackInfo var3) {
      DaamkyClient var4 = DaamkyClient.method2004();
      if (var4 != null && var4.method1783() != null) {
         NoRender var5 = var4.method1783().method0976(NoRender.class);
         if (var5 != null && var5.method0472()) {
            var3.cancel();
         }
      }
   }

   @Inject(method = "renderNauseaOverlay", at = @At("HEAD"), cancellable = true)
   private void onRenderNauseaOverlay(class_332 var1, float var2, CallbackInfo var3) {
      DaamkyClient var4 = DaamkyClient.method2004();
      if (var4 != null && var4.method1783() != null) {
         NoRender var5 = var4.method1783().method0976(NoRender.class);
         if (var5 != null && var5.method0406()) {
            var3.cancel();
         }
      }
   }

   @Inject(method = "renderVignetteOverlay", at = @At("HEAD"), cancellable = true)
   private void onRenderVignetteOverlay(class_332 var1, class_1297 var2, CallbackInfo var3) {
      DaamkyClient var4 = DaamkyClient.method2004();
      if (var4 != null && var4.method1783() != null) {
         NoRender var5 = var4.method1783().method0976(NoRender.class);
         if (var5 != null && var5.method0528()) {
            var3.cancel();
         }
      }
   }

   @WrapWithCondition(
      method = "renderMiscOverlays",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/hud/InGameHud;renderOverlay(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/util/Identifier;F)V",
         ordinal = 0
      )
   )
   private boolean onRenderPumpkinOverlay(class_329 var1, class_332 var2, class_2960 var3, float var4) {
      DaamkyClient var5 = DaamkyClient.method2004();
      if (var5 != null && var5.method1783() != null) {
         NoRender var6 = var5.method1783().method0976(NoRender.class);
         return var6 == null || !var6.method2247();
      } else {
         return true;
      }
   }

   @WrapWithCondition(
      method = "renderMiscOverlays",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/hud/InGameHud;renderOverlay(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/util/Identifier;F)V",
         ordinal = 1
      )
   )
   private boolean onRenderSnowOverlay(class_329 var1, class_332 var2, class_2960 var3, float var4) {
      DaamkyClient var5 = DaamkyClient.method2004();
      if (var5 != null && var5.method1783() != null) {
         NoRender var6 = var5.method1783().method0976(NoRender.class);
         return var6 == null || !var6.method2244();
      } else {
         return true;
      }
   }

   @Unique
   private boolean isPotion(class_1799 var1, class_1291 var2) {
      if (!(var1.method_7909() instanceof class_1812)) {
         return false;
      }

      class_1844 var3 = (class_1844)var1.method_57824(class_9334.field_49651);
      if (var3 == null) {
         return false;
      }

      if (var3.comp_2378().isEmpty()) {
         return false;
      }

      for (class_1293 var5 : ((class_1842)((class_6880)var3.comp_2378().get()).comp_349()).method_8049()) {
         if (var5.method_5579().comp_349() == var2) {
            return true;
         }
      }

      return false;
   }
}
