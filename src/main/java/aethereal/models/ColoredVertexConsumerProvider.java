package aethereal;

import java.util.Optional;
import net.minecraft.class_1921;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4720;
import net.minecraft.class_9799;
import net.minecraft.class_9848;
import net.minecraft.class_4597.class_4598;

public class ColoredVertexConsumerProvider implements class_4597 {
   private final class_4598 field0744;
   private final class_4598 field0164 = class_4597.method_22991(new class_9799(1536));
   private int field1411 = 255;
   private int field0958 = 255;
   private int field0759 = 255;
   private int field1243 = 255;

   public ColoredVertexConsumerProvider(class_4598 var1) {
      this.field0744 = var1;
   }

   public class_4588 getBuffer(class_1921 var1) {
      if (var1.method_24295()) {
         class_4588 var6 = this.field0164.getBuffer(var1);
         return new ColoredVertexConsumerProvider.ColoredVertexConsumer(var6, this.field1411, this.field0958, this.field0759, this.field1243);
      } else {
         class_4588 var2 = this.field0744.getBuffer(var1);
         Optional var3 = var1.method_23289();
         if (var3.isPresent()) {
            class_4588 var4 = this.field0164.getBuffer(var3.get());
            ColoredVertexConsumerProvider.ColoredVertexConsumer var5 = new ColoredVertexConsumerProvider.ColoredVertexConsumer(var4, this.field1411, this.field0958, this.field0759, this.field1243);
            return class_4720.method_24037(var5, var2);
         } else {
            return var2;
         }
      }
   }

   public void method0749(int var1, int var2, int var3, int var4) {
      this.field1411 = var1;
      this.field0958 = var2;
      this.field0759 = var3;
      this.field1243 = var4;
   }

   public void method0578() {
      this.field0164.method_22993();
   }

   public record ColoredVertexConsumer(class_4588 delegate, int color) implements class_4588 {
      public ColoredVertexConsumer(class_4588 var1, int var2, int var3, int var4, int var5) {
         this(var1, class_9848.method_61324(var5, var2, var3, var4));
      }

      public class_4588 method_22912(float var1, float var2, float var3) {
         this.delegate.method_22912(var1, var2, var3).method_39415(this.color);
         return this;
      }

      public class_4588 method_1336(int var1, int var2, int var3, int var4) {
         return this;
      }

      public class_4588 method_22913(float var1, float var2) {
         this.delegate.method_22913(var1, var2);
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

      public class_4588 method0574() {
         return this.delegate;
      }

      public int method0003() {
         return this.color;
      }
   }
}
