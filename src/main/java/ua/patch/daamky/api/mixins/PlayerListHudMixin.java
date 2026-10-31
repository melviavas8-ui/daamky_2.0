package ua.patch.daamky.api.mixins;

import aethereal.DaamkyClient;
import aethereal.Interface;
import aethereal.NameProtect;
import aethereal.TabExpert;
import java.util.Comparator;
import java.util.List;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_266;
import net.minecraft.class_268;
import net.minecraft.class_269;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_355;
import net.minecraft.class_5250;
import net.minecraft.class_5481;
import net.minecraft.class_640;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_355.class)
public abstract class PlayerListHudMixin {
   @Shadow
   @Final
   private class_310 field_2155;
   @Shadow
   @Final
   private static Comparator<class_640> field_2156;
   @Shadow
   private class_2561 field_2153;
   @Shadow
   private class_2561 field_2154;

   @Shadow
   protected abstract class_2561 method_27538(class_640 var1, class_5250 var2);

   @Shadow
   protected abstract List<class_640> method_48213();

   @Shadow
   public abstract class_2561 method_1918(class_640 var1);

   @Inject(method = "render", at = @At("HEAD"))
   private void daamky$drawTabBg(class_332 var1, int var2, class_269 var3, class_266 var4, CallbackInfo var5) {
      if (this.daamky$tabReplaceEnabled()) {
         if (this.field_2155.field_1724 != null && this.field_2155.field_1724.field_3944 != null) {
            List var6 = this.method_48213();
            int var7 = var6.size();
            if (var7 != 0) {
               class_327 var8 = this.field_2155.field_1772;
               int var9 = 0;

               for (class_640 var11 : var6) {
                  var9 = Math.max(var9, var8.method_27525(this.method_1918(var11)));
               }

               int var26 = var7;

               int var27;
               for (var27 = 1; var26 > 20; var26 = (int)Math.ceil((double)var7 / var27)) {
                  var27++;
               }

               int var12 = var9 + 13;
               int var13 = var27 * var12 + Math.max(var27 - 1, 0) * 5;
               int var14 = 0;
               if (this.field_2153 != null) {
                  List var15 = var8.method_1728(this.field_2153, var2 - 50);
                  var14 = var15.size();
               }

               int var28 = 0;
               if (this.field_2154 != null) {
                  List var16 = var8.method_1728(this.field_2154, var2 - 50);
                  var28 = var16.size();
               }

               int var29 = 9;
               int var17 = var14 * var29 + (var14 > 0 ? 1 : 0);
               int var18 = var26 * (var29 + 1);
               int var19 = var28 * var29 + (var28 > 0 ? var29 + 1 : 0);
               int var20 = 10;
               int var21 = var20 - var17 - 1;
               int var22 = var2 / 2 - var13 / 2 - 1;
               int var23 = var13 + 2;
               int var24 = var17 + var18 + var19 + 2;
               Interface var25 = DaamkyClient.method2004().method1783().method0976(Interface.class);
               var25.method1404(var1, var22 - 4.0F, var21 - 4.0F, var23 + 8.0F, var24 + 8.0F);
            }
         }
      }
   }

   @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V"))
   private void daamky$skipVanillaFill(class_332 var1, int var2, int var3, int var4, int var5, int var6) {
      if (!this.daamky$tabReplaceEnabled()) {
         var1.method_25294(var2, var3, var4, var5, var6);
      }
   }

   private boolean daamky$tabReplaceEnabled() {
      DaamkyClient var1 = DaamkyClient.method2004();
      if (var1 != null && var1.method1783() != null) {
         Interface var2 = var1.method1783().method0976(Interface.class);
         return var2 != null && var2.method2030();
      } else {
         return false;
      }
   }

   @Inject(method = "collectPlayerEntries", at = @At("HEAD"), cancellable = true)
   private void daamky$collectPlayerEntries(CallbackInfoReturnable<List<class_640>> var1) {
      DaamkyClient var2 = DaamkyClient.method2004();
      if (var2 != null && var2.method1783() != null) {
         TabExpert var3 = var2.method1783().method0976(TabExpert.class);
         if (var3 != null && var3.method2195()) {
            var1.setReturnValue(
               this.field_2155.field_1724.field_3944.method_45732().stream().sorted(field_2156).limit((long)var3.field0060.method0492().floatValue()).toList()
            );
         }
      }
   }

   @Inject(method = "getPlayerName", at = @At("HEAD"), cancellable = true)
   private void daamky$getPlayerName(class_640 var1, CallbackInfoReturnable<class_2561> var2) {
      DaamkyClient var3 = DaamkyClient.method2004();
      if (var3 != null && var3.method1783() != null) {
         String var4 = var1.method_2966().getName();
         String var5 = NameProtect.method2131(var4);
         if (!var5.equals(var4)) {
            class_2561 var13 = var1.method_2971();
            class_5250 var14 = var13 != null ? NameProtect.method1346(var13) : class_268.method_1142(var1.method_2955(), class_2561.method_43470(var5));
            var2.setReturnValue(this.method_27538(var1, var14));
         } else {
            TabExpert var6 = var3.method1783().method0976(TabExpert.class);
            if (var6 != null && var6.method2195() && var6.field1432.method0492()) {
               if (var3.method1608() != null) {
                  String var7 = var1.method_2966().getName();
                  if (var3.method1608().method2135(var7)) {
                     class_2561 var8 = var1.method_2971();
                     String var9 = var8 != null ? var8.getString() : var7;
                     int var10 = var9.indexOf(var7);
                     if (var10 < 0) {
                        var2.setReturnValue(
                           this.method_27538(var1, class_268.method_1142(var1.method_2955(), class_2561.method_43470(var7).method_27692(class_124.field_1075)))
                        );
                     } else {
                        class_5250 var11 = class_2561.method_43473();
                        if (var10 > 0) {
                           var11.method_10852(class_2561.method_43470(var9.substring(0, var10)).method_27692(class_124.field_1068));
                        }

                        var11.method_10852(class_2561.method_43470(var7).method_27692(class_124.field_1075));
                        int var12 = var10 + var7.length();
                        if (var12 < var9.length()) {
                           var11.method_10852(class_2561.method_43470(var9.substring(var12)).method_27692(class_124.field_1068));
                        }

                        var2.setReturnValue(this.method_27538(var1, var11));
                     }
                  }
               }
            }
         }
      }
   }
}
