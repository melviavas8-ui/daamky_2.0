package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.HudWidgetManager;
import aethereal.MathHelper;
import aethereal.FriendScreen;
import aethereal.ChatCommandSuggestions;
import aethereal.ServerSearchOverlay;
import aethereal.HudWidgetState;
import aethereal.InventoryHudEditor;
import aethereal.ScreenLayoutHelper;
import aethereal.NameTags;
import aethereal.NewHUD;
import aethereal.ServerAssist;
import java.util.Map.Entry;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_338;
import net.minecraft.class_342;
import net.minecraft.class_408;
import net.minecraft.class_437;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_408.class)
public abstract class ChatScreenMixin extends class_437 {
   @Shadow
   protected class_342 field_2382;
   @Unique
   private final InventoryHudEditor daamky$hudPanel = new InventoryHudEditor();
   @Unique
   private final ServerSearchOverlay daamky$elementPopup = new ServerSearchOverlay();
   @Unique
   private final ChatCommandSuggestions daamky$cmdOverlay = new ChatCommandSuggestions();

   protected ChatScreenMixin(class_2561 var1) {
      super(var1);
   }

   @Inject(method = "init", at = @At("RETURN"))
   private void daamky$onInit(CallbackInfo var1) {
      NewHUD.method1735();
   }

   @Inject(method = "onChatFieldUpdate", at = @At("HEAD"), cancellable = true)
   private void onChatFieldUpdate(String var1, CallbackInfo var2) {
      String var3 = DaamkyClient.method2004().method2257().method2067();
      if (var1 != null && var1.startsWith(var3) && !this.daamky$cmdOverlay.method0579()) {
         this.daamky$cmdOverlay.method1013(var1);
         this.field_2382.method_1862(false);
         this.field_2382.method_25365(false);
         var2.cancel();
      } else {
         if (this.daamky$cmdOverlay.method0579()) {
            var2.cancel();
         }
      }
   }

   @Inject(method = "keyPressed", at = @At("HEAD"), cancellable = true)
   private void onKeyPressed(int var1, int var2, int var3, CallbackInfoReturnable<Boolean> var4) {
      if (var1 == 256 && this.daamky$elementPopup.method0026()) {
         this.daamky$elementPopup.method0578();
         var4.setReturnValue(true);
      } else if (var1 == 256 && this.daamky$hudPanel.method0026()) {
         this.daamky$hudPanel.method0578();
         var4.setReturnValue(true);
      } else {
         if (this.daamky$cmdOverlay.method0579()) {
            boolean var5 = this.daamky$cmdOverlay.method0746(var1, var2, var3);
            if (var5) {
               if (!this.daamky$cmdOverlay.method0579() && this.field_2382 != null) {
                  this.field_2382.method_1862(true);
                  this.field_2382.method_25365(true);
                  this.field_2382.method_1852("");
               }

               var4.setReturnValue(true);
            }
         }
      }
   }

   public boolean method_25400(char var1, int var2) {
      return this.daamky$cmdOverlay.method0579() && this.daamky$cmdOverlay.method0607(var1, var2) ? true : super.method_25400(var1, var2);
   }

   @Inject(method = "mouseClicked", at = @At("HEAD"), cancellable = true)
   private void onMouseClicked(double var1, double var3, int var5, CallbackInfoReturnable<Boolean> var6) {
      float var7 = ScreenLayoutHelper.method0002();
      float var8 = (float)(var1 / var7);
      float var9 = (float)(var3 / var7);
      if (this.daamky$elementPopup.method0026() && this.daamky$elementPopup.method0627(var8, var9, var5)) {
         var6.setReturnValue(true);
      } else if (this.daamky$hudPanel.method0026() && this.daamky$hudPanel.method0627(var8, var9, var5)) {
         var6.setReturnValue(true);
      } else {
         if (var5 == 1) {
            class_310 var10 = class_310.method_1551();
            NameTags var11 = DaamkyClient.method2004().method1783().method0976(NameTags.class);
            if (var11 != null && var11.method2195()) {
               for (Entry var13 : var11.method1730().entrySet()) {
                  float[] var14 = var13.getValue();
                  if (MathHelper.method0689(var14[0], var14[1], var14[2], var14[3], var8, var9)) {
                     this.daamky$elementPopup.method0578();
                     this.daamky$hudPanel.method0578();
                     var10.method_1507(new FriendScreen(var13.getKey(), var8, var9));
                     var6.setReturnValue(true);
                     return;
                  }
               }
            }

            boolean var17 = GLFW.glfwGetKey(var10.method_22683().method_4490(), 342) == 1;
            NewHUD var18 = DaamkyClient.method2004().method1783().method0976(NewHUD.class);

            for (HudWidgetState var15 : HudWidgetManager.method1605().method0560().values()) {
               if ((var18 == null || var18.method1986(var15.method1619()))
                  && var15.method0676(var8, var9)
                  && this.daamky$elementPopup.method1014(var15.method1619())) {
                  if (var17 && var15.method1619().equals("NewArmorHUD")) {
                     var6.setReturnValue(true);
                     return;
                  }

                  this.daamky$hudPanel.method0578();
                  this.daamky$elementPopup.method0703(var8, var9, var15.method1619());
                  var6.setReturnValue(true);
                  return;
               }
            }

            boolean var20 = false;

            for (HudWidgetState var16 : HudWidgetManager.method1605().method0560().values()) {
               if ((var18 == null || var18.method1986(var16.method1619())) && var16.method0676(var8, var9)) {
                  var20 = true;
                  break;
               }
            }

            if (!var20 && this.field_2382 != null && !this.field_2382.method_25405(var1, var3)) {
               this.daamky$elementPopup.method0578();
               if (this.daamky$hudPanel.method0026()) {
                  this.daamky$hudPanel.method0578();
               } else {
                  this.daamky$hudPanel.method0675(var8, var9);
               }

               var6.setReturnValue(true);
            }
         }
      }
   }

   public boolean method_25403(double var1, double var3, int var5, double var6, double var8) {
      if (this.daamky$elementPopup.method0026()) {
         float var10 = ScreenLayoutHelper.method0002();
         this.daamky$elementPopup.method0615(var1 / var10, var3 / var10);
      }

      return super.method_25403(var1, var3, var5, var6, var8);
   }

   public boolean method_25406(double var1, double var3, int var5) {
      if (this.daamky$elementPopup.method0026()) {
         float var6 = ScreenLayoutHelper.method0002();
         this.daamky$elementPopup.method0111(var1 / var6, var3 / var6, var5);
      }

      return super.method_25406(var1, var3, var5);
   }

   @Inject(method = "render", at = @At("HEAD"), cancellable = true)
   private void onRenderHead(class_332 var1, int var2, int var3, float var4, CallbackInfo var5) {
      if (this.daamky$cmdOverlay.method0579()) {
         class_310 var6 = class_310.method_1551();
         class_338 var7 = var6.field_1705.method_1743();
         var7.method_1805(var1, var6.field_1705.method_1738(), var2, var3, true);
         this.daamky$cmdOverlay.method1402(var1, this.field_22789, this.field_22790);
         this.daamky$renderHudPanels(var1, var2, var3, var4);
         var5.cancel();
      }
   }

   @Inject(method = "render", at = @At("TAIL"))
   private void onRenderTail(class_332 var1, int var2, int var3, float var4, CallbackInfo var5) {
      this.daamky$renderHudPanels(var1, var2, var3, var4);
      this.daamky$renderServerAssistHud(var1);
      this.daamky$renderHudHint(var1);
   }

   @Unique
   private void daamky$renderHudHint(class_332 var1) {
      boolean var2 = !this.daamky$hudPanel.method0026() && !this.daamky$elementPopup.method0026();
      float var3 = ScreenLayoutHelper.method0002();
      var1.method_51448().method_22903();
      var1.method_51448().method_22905(var3, var3, 1.0F);
      NewHUD.method1475(var1.method_51448(), this.field_22789 / var3, this.field_22790 / var3, var2);
      var1.method_51448().method_22909();
   }

   @Unique
   private void daamky$renderServerAssistHud(class_332 var1) {
      ServerAssist var2 = DaamkyClient.method2004().method1783().method0976(ServerAssist.class);
      if (var2 != null && var2.method2195()) {
         float var3 = ScreenLayoutHelper.method0002();
         var1.method_51448().method_22903();
         if (var3 != 1.0F) {
            var1.method_51448().method_22905(var3, var3, 1.0F);
         }

         var2.method1400(var1);
         var1.method_51448().method_22909();
      }
   }

   @Unique
   private void daamky$renderHudPanels(class_332 var1, int var2, int var3, float var4) {
      float var5 = ScreenLayoutHelper.method0002();
      int var6 = (int)(var2 / var5);
      int var7 = (int)(var3 / var5);
      var1.method_51448().method_22903();
      var1.method_51448().method_22905(var5, var5, 1.0F);
      this.daamky$hudPanel.method1414(var1, var6, var7, var4);
      this.daamky$elementPopup.method1414(var1, var6, var7, var4);
      var1.method_51448().method_22909();
   }

   @Inject(method = "removed", at = @At("HEAD"))
   private void onRemoved(CallbackInfo var1) {
      if (this.daamky$elementPopup.method0026()) {
         this.daamky$elementPopup.method0578();
      }

      if (this.daamky$hudPanel.method0026()) {
         this.daamky$hudPanel.method0578();
      }

      if (this.daamky$cmdOverlay.method0579()) {
         this.daamky$cmdOverlay.method0025();
      }

      DaamkyClient.method2004().method2216().method1634();
   }
}
