package aethereal;

import net.minecraft.class_4588;
import net.minecraft.class_4597;

public final class DelegatingVertexConsumer implements class_4588 {
   public static final DelegatingVertexConsumer field0636 = new DelegatingVertexConsumer();
   public static final class_4597 field0165 = var0 -> field0636;

   public static class_4597 method1515(class_4597 var0) {
      return var1 -> var0 != null ? var0.getBuffer(var1) : field0636;
   }

   private DelegatingVertexConsumer() {
   }

   public class_4588 method_22912(float var1, float var2, float var3) {
      return this;
   }

   public class_4588 method_1336(int var1, int var2, int var3, int var4) {
      return this;
   }

   public class_4588 method_22913(float var1, float var2) {
      return this;
   }

   public class_4588 method_60796(int var1, int var2) {
      return this;
   }

   public class_4588 method_22921(int var1, int var2) {
      return this;
   }

   public class_4588 method_22914(float var1, float var2, float var3) {
      return this;
   }
}
