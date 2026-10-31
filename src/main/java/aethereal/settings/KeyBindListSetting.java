package aethereal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.class_1792;

public class KeyBindListSetting extends Setting<Object> {
   private static final Object field1502 = new Object();
   private final List<KeyBindListSetting.KeyBindEntry> field1032 = new ArrayList<>();

   public KeyBindListSetting(String var1) {
      super(var1, field1502);
   }

   public KeyBindListSetting(String var1, Supplier<Boolean> var2) {
      super(var1, field1502, var2);
   }

   public KeyBindListSetting method0884(KeyBindSetting var1, class_1792 var2, Supplier<Boolean> var3) {
      this.field1032.add(new KeyBindListSetting.KeyBindEntry(var1, var2, var3));
      return this;
   }

   public KeyBindListSetting method0883(KeyBindSetting var1, class_1792 var2) {
      return this.method0884(var1, var2, () -> true);
   }

   public List<KeyBindListSetting.KeyBindEntry> method1889() {
      return this.field1032;
   }

   public int method1929() {
      int var1 = 0;

      for (KeyBindListSetting.KeyBindEntry var3 : this.field1032) {
         if (var3.method2079() && var3.method0546().method0492().method2048() != -1) {
            var1++;
         }
      }

      return var1;
   }

   public static final class KeyBindEntry {
      private final KeyBindSetting field0658;
      private final class_1792 field0153;
      private final Supplier<Boolean> field1514;

      public KeyBindEntry(KeyBindSetting var1, class_1792 var2, Supplier<Boolean> var3) {
         this.field0658 = var1;
         this.field0153 = var2;
         this.field1514 = var3;
      }

      public KeyBindSetting method0546() {
         return this.field0658;
      }

      public class_1792 method0021() {
         return this.field0153;
      }

      public boolean method2079() {
         return this.field1514.get();
      }
   }
}
