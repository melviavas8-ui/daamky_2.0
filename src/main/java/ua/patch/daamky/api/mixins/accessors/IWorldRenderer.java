package ua.patch.daamky.api.mixins.accessors;

import net.minecraft.class_276;
import net.minecraft.class_4604;
import net.minecraft.class_761;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(class_761.class)
public interface IWorldRenderer {
   @Accessor("frustum")
   class_4604 getFrustum();

   @Accessor("entityOutlineFramebuffer")
   class_276 getEntityOutlineFramebuffer();

   @Accessor("entityOutlineFramebuffer")
   void setEntityOutlineFramebuffer(class_276 var1);
}
