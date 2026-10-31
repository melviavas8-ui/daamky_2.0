package aethereal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.class_2248;
import net.minecraft.class_2960;
import net.minecraft.class_7923;

public class BlockListSetting extends Setting<List<class_2248>> {
   private int field1411 = 0;

   public BlockListSetting(String var1) {
      super(var1, new ArrayList<>());
   }

   public BlockListSetting(String var1, Supplier<Boolean> var2) {
      super(var1, new ArrayList<>(), var2);
   }

   public int method1879() {
      return this.field1411;
   }

   public boolean method1253(class_2248 var1) {
      return this.method0492().contains(var1);
   }

   public void method0273(class_2248 var1) {
      if (!this.method1253(var1)) {
         this.method0492().add(var1);
         this.field1411++;
      }
   }

   public void method2158(class_2248 var1) {
      if (this.method0492().remove(var1)) {
         this.field1411++;
      }
   }

   public void method1861(class_2248 var1) {
      if (this.method1253(var1)) {
         this.method2158(var1);
      } else {
         this.method0273(var1);
      }
   }

   public List<String> method1936() {
      List var1 = new ArrayList<>();

      for (class_2248 var3 : this.method0492()) {
         var1.add(class_7923.field_41175.method_10221(var3).toString());
      }

      return var1;
   }

   public void method1074(List<String> var1) {
      this.method0492().clear();

      for (String var3 : var1) {
         class_2248 var4 = (class_2248)class_7923.field_41175.method_63535(class_2960.method_60654(var3));
         if (var4 != null) {
            this.method0492().add(var4);
         }
      }

      this.field1411++;
   }
}
