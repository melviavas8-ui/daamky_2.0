package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.BetterChat;
import aethereal.ThemeColorManager;
import aethereal.NameProtect;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_338;
import net.minecraft.class_3532;
import net.minecraft.class_5250;
import net.minecraft.class_5251;
import net.minecraft.class_303.class_7590;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(class_338.class)
public abstract class ChatHudMixin {
   @Shadow
   @Final
   private List<class_7590> field_2064;
   @Unique
   private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");
   @Unique
   private static final DateTimeFormatter TIME_FORMAT_SECONDS = DateTimeFormatter.ofPattern("HH:mm:ss");
   @Unique
   private boolean daamky$animationEnabled = false;
   @Unique
   private float daamky$animationSpeed = 6.0F;
   @Unique
   private int daamky$currentLineIndex = 0;
   @Unique
   private int daamky$currentTick = 0;
   @Unique
   private float daamky$partialTick = 0.0F;

   @ModifyArgs(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V", ordinal = 0))
   private void modifyChatBackground(Args var1) {
      BetterChat var2 = DaamkyClient.method2004().method1783().method0976(BetterChat.class);
      if (var2 != null && var2.method2195() && var2.field0034.method0492()) {
         var1.set(4, 0);
      }
   }

   @ModifyVariable(method = "addMessage(Lnet/minecraft/text/Text;)V", at = @At("HEAD"), argsOnly = true)
   private class_2561 addTimestamp(class_2561 var1) {
      return this.daamky$prependTimestamp(var1);
   }

   @Unique
   private class_2561 daamky$prependTimestamp(class_2561 var1) {
      class_2561 var2 = NameProtect.method1346(var1);
      if (var2 != null) {
         var1 = var2;
      }

      BetterChat var3 = DaamkyClient.method2004().method1783().method0976(BetterChat.class);
      if (var3 != null && var3.method2195() && var3.field1432.method0492()) {
         String var4 = LocalTime.now().format(var3.field0970.method0492() ? TIME_FORMAT_SECONDS : TIME_FORMAT);
         int var5 = ThemeColorManager.method1604() & 16777215;
         class_2583 var6 = class_2583.field_24360.method_27703(class_5251.method_27717(var5));
         class_5250 var7 = class_2561.method_43473();
         var7.method_10852(class_2561.method_43470("[" + var4 + "] ").method_10862(var6));
         var7.method_10852(var1);
         return var7;
      } else {
         return var1;
      }
   }

   @Inject(method = "render", at = @At("HEAD"))
   private void onRenderHead(class_332 var1, int var2, int var3, int var4, boolean var5, CallbackInfo var6) {
      BetterChat var7 = DaamkyClient.method2004().method1783().method0976(BetterChat.class);
      if (var7 != null && var7.method2195() && var7.field0184.method0492()) {
         this.daamky$animationEnabled = true;
         this.daamky$animationSpeed = var7.field0470.method0492();
      } else {
         this.daamky$animationEnabled = false;
      }

      this.daamky$currentLineIndex = 0;
      this.daamky$currentTick = var2;
      this.daamky$partialTick = class_310.method_1551().method_61966().method_60637(true);
   }

   @Inject(
      method = "render",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/OrderedText;III)I"
      )
   )
   private void beforeDrawLine(class_332 var1, int var2, int var3, int var4, boolean var5, CallbackInfo var6) {
      if (this.daamky$animationEnabled) {
         int var7 = this.daamky$currentLineIndex;
         if (var7 >= 0 && var7 < this.field_2064.size()) {
            class_7590 var8 = this.field_2064.get(var7);
            float var9 = this.daamky$currentTick - var8.comp_895() + this.daamky$partialTick;
            float var10 = class_3532.method_15363(var9 * this.daamky$animationSpeed / 60.0F, 0.0F, 1.0F);
            float var11 = 1.0F - (1.0F - var10) * (1.0F - var10);
            float var12 = (1.0F - var11) * -50.0F;
            var1.method_51448().method_22903();
            var1.method_51448().method_46416(var12, 0.0F, 0.0F);
         }

         this.daamky$currentLineIndex++;
      }
   }

   @Inject(
      method = "render",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/OrderedText;III)I",
         shift = Shift.AFTER
      )
   )
   private void afterDrawLine(class_332 var1, int var2, int var3, int var4, boolean var5, CallbackInfo var6) {
      if (this.daamky$animationEnabled) {
         var1.method_51448().method_22909();
      }
   }
}
