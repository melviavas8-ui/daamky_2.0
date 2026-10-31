package aethereal;

import java.util.Map;
import net.minecraft.class_10042;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import org.joml.Vector3f;

public interface EntityModelRenderHook {
   void daamky$render(class_10042 var1, class_4587 var2, class_4597 var3, int var4);

   void daamky$collectSkeleton(class_10042 var1, class_4587 var2, Map<String, Vector3f> var3);
}
