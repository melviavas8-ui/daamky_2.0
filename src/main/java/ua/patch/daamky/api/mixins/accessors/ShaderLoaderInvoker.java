package ua.patch.daamky.api.mixins.accessors;

import net.minecraft.class_10141;
import net.minecraft.class_10151;
import net.minecraft.class_10156;
import net.minecraft.class_10157;
import net.minecraft.class_5944;
import net.minecraft.class_10151.class_10152;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(class_10151.class)
public interface ShaderLoaderInvoker {
   @Invoker("createProgram")
   static class_5944 invokeCreateProgram(class_10156 var0, class_10157 var1, class_10141 var2, class_10141 var3) throws class_10152 {
      throw new AssertionError();
   }
}
