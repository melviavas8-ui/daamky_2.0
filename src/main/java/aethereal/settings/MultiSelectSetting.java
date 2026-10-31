package aethereal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MultiSelectSetting extends Setting<List<BooleanSetting>> {
   public MultiSelectSetting(String var1, BooleanSetting... var2) {
      super(var1, Arrays.asList(var2), () -> true);
   }

   public MultiSelectSetting(String var1, Supplier<Boolean> var2, List<BooleanSetting> var3) {
      super(var1, var3, var2 != null ? var2 : () -> true);
   }

   public MultiSelectSetting(String var1, List<String> var2) {
      super(var1, method1057(var1, var2, false, () -> true), () -> true);
   }

   public MultiSelectSetting(String var1, List<String> var2, Supplier<Boolean> var3) {
      super(var1, method1057(var1, var2, false, var3), var3 != null ? var3 : () -> true);
   }

   public MultiSelectSetting(String var1, List<String> var2, boolean var3, Supplier<Boolean> var4) {
      super(var1, method1057(var1, var2, var3, var4), var4 != null ? var4 : () -> true);
   }

   private static List<BooleanSetting> method1057(String var0, List<String> var1, boolean var2, Supplier<Boolean> var3) {
      List var4 = new ArrayList<>();
      Supplier var5 = var3 != null ? var3 : () -> true;
      String var6 = var0.toLowerCase().replace(" ", ".");

      for (String var8 : var1) {
         String var9 = var6 + "." + var8.toLowerCase().replace(" ", ".");
         BooleanSetting var10 = new BooleanSetting(var9, var2, var5);
         var10.method0442(var8);
         var4.add(var10);
      }

      return var4;
   }

   public BooleanSetting method0439(String var1) {
      return this.method0492().stream().filter(var1x -> {
         String var2 = var1x.method1888();
         return var2 != null ? var2.equalsIgnoreCase(var1) : var1x.method0423().equalsIgnoreCase(var1);
      }).findFirst().orElse(null);
   }

   public List<BooleanSetting> method1889() {
      return this.method0492().stream().filter(Setting::method0492).toList();
   }

   public boolean method0730(int var1) {
      return this.method0492().get(var1).method0492();
   }

   public void method0771(int var1, boolean var2) {
      this.method0492().get(var1).method0206(var2);
   }

   public boolean method0387(String var1) {
      BooleanSetting var2 = this.method0439(var1);
      return var2 != null && var2.method0492();
   }

   public List<String> method1936() {
      return this.method0492().stream().filter(Setting::method0492).map(var0 -> var0.method1888() != null ? var0.method1888() : var0.method0423()).toList();
   }
}
