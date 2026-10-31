package aethereal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import net.minecraft.class_1657;
import net.minecraft.class_1743;
import net.minecraft.class_1766;
import net.minecraft.class_1799;
import net.minecraft.class_1810;
import net.minecraft.class_1821;
import net.minecraft.class_1829;
import net.minecraft.class_243;
import net.minecraft.class_310;

public class SwordTrailBuffer {
   private final Deque<SwordTrailSample> field0718 = new ArrayDeque<>();
   private int field0004 = 40;

   public void method0729(int var1) {
      this.field0004 = Math.max(2, var1);

      while (this.field0718.size() > this.field0004) {
         this.field0718.pollFirst();
      }
   }

   public void method0827(SwordTrailSample var1) {
      this.field0718.addLast(var1);

      while (this.field0718.size() > this.field0004) {
         this.field0718.pollFirst();
      }
   }

   public void method0578() {
      this.field0718.clear();
   }

   public int method0003() {
      return this.field0718.size();
   }

   public Iterable<SwordTrailSample> method2065() {
      return this.field0718;
   }

   public SwordTrailSample method1773() {
      return this.field0718.peekLast();
   }

   public SwordTrailSample method1187(class_1657 var1, float var2) {
      class_310 var3 = class_310.method_1551();
      class_243 var4 = var1.method_5836(var2);
      class_243 var5 = var1.method_5828(var2).method_1029();
      class_1799 var6 = var1.method_6047();
      float var7 = method1238(var6);
      class_243 var8 = var5.method_1036(new class_243(0.0, 1.0, 0.0)).method_1029();
      if (var8.method_1027() < 1.0000000022797057E-6) {
         var8 = new class_243(1.0, 0.0, 0.0);
      }

      class_243 var9 = var5.method_1036(var8).method_1029();
      class_243 var10 = var4.method_1019(var8.method_1021(0.25)).method_1019(var9.method_1021(-0.2000000471773113)).method_1019(var5.method_1021(0.5));
      class_243 var11 = var10.method_1019(var5.method_1021(var7));
      float var12 = var1.method_6055(var2);
      long var13 = var3.field_1687 != null ? var3.field_1687.method_8510() : 0L;
      return new SwordTrailSample(var11, var10, var12, var13);
   }

   public static float method1238(class_1799 var0) {
      if (var0 == null || var0.method_7960()) {
         return 0.5F;
      } else if (var0.method_7909() instanceof class_1829) {
         return 0.8F;
      } else if (var0.method_7909() instanceof class_1743) {
         return 0.7F;
      } else if (var0.method_7909() instanceof class_1810) {
         return 0.6F;
      } else if (var0.method_7909() instanceof class_1821) {
         return 0.6F;
      } else {
         return var0.method_7909() instanceof class_1766 ? 0.6F : 0.5F;
      }
   }

   public void method0782(long var1, long var3) {
      Iterator var5 = this.field0718.iterator();

      while (var5.hasNext()) {
         SwordTrailSample var6 = var5.next();
         if (var1 - var6.method1764() <= var3) {
            break;
         }

         var5.remove();
      }
   }
}
