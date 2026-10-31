package ua.patch.daamky.api.mixins.accessors;

import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_465;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(class_465.class)
public interface IHandledScreen {
   @Accessor("focusedSlot")
   class_1735 getFocusedSlot();

   @Accessor("x")
   int daamky$getX();

   @Accessor("y")
   int daamky$getY();

   @Accessor("backgroundWidth")
   int daamky$getBackgroundWidth();

   @Accessor("backgroundHeight")
   int daamky$getBackgroundHeight();

   @Invoker("onMouseClick")
   void daamky$onMouseClick(class_1735 var1, int var2, int var3, class_1713 var4);
}
