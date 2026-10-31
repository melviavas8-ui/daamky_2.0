package aethereal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.class_2960;
import net.minecraft.class_3264;
import net.minecraft.class_3300;

public final class ShaderCache {
   private static final ShaderCache field0685 = new ShaderCache();
   private final List<OutlineShaderRenderer> field0139 = new ArrayList<>();
   private boolean field1527;

   public static ShaderCache method0550() {
      return field0685;
   }

   private ShaderCache() {
   }

   void method0811(OutlineShaderRenderer var1) {
      this.field0139.add(var1);
   }

   public void method0025() {
      if (!this.field1527) {
         this.field1527 = true;
         ResourceManagerHelper.get(class_3264.field_14188).registerReloadListener(new SimpleSynchronousResourceReloadListener() {
            private final class_2960 field0160 = class_2960.method_60655("daamky", "shader_cache_reset");

            public class_2960 getFabricId() {
               return this.field0160;
            }

            public Collection<class_2960> getFabricDependencies() {
               return Collections.emptyList();
            }

            public void method_14491(class_3300 var1) {
               ShaderCache.this.method2078();
            }
         });
      }
   }

   public void method0738(int var1, int var2) {
      for (OutlineShaderRenderer var4 : this.field0139) {
         var4.method0738(var1, var2);
      }
   }

   public void method2078() {
      for (OutlineShaderRenderer var2 : this.field0139) {
         var2.method0025();
      }
   }
}
