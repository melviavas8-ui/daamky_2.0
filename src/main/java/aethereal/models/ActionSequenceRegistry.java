package aethereal;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class ActionSequenceRegistry {
   private final Map<String, ActionSequence> field0720 = new ConcurrentHashMap<>();

   public Optional<ActionSequence> method1011(String var1) {
      return this.method0443(var1) ? Optional.empty() : Optional.of(this.field0720.computeIfAbsent(var1, var0 -> new ActionSequence()));
   }

   public ActionSequence method1034(String var1, ActionSequence var2) {
      if (!this.method0443(var1) && var2 != null) {
         return this.field0720.put(var1, var2);
      } else {
         throw new IllegalArgumentException("Script name or instance cannot be null or empty");
      }
   }

   public boolean method0214(String var1) {
      return !this.method0443(var1) && this.field0720.containsKey(var1);
   }

   public boolean method2135(String var1) {
      return !this.method0443(var1) && this.method1011(var1).isPresent() && this.method1011(var1).get().method1974();
   }

   public void method1846(String var1) {
      if (!this.method0443(var1)) {
         this.field0720.remove(var1);
      }
   }

   public void method1656(String var1) {
      if (!this.method0443(var1)) {
         this.field0720.computeIfPresent(var1, (var0, var1x) -> {
            var1x.method1778();
            return (ActionSequence)var1x;
         });
      }
   }

   public void method0578() {
      this.field0720.forEach((var0, var1) -> var1.method1778());
   }

   public void method0025() {
      this.field0720.clear();
   }

   public void method1985(String var1) {
      this.method1058(var1, () -> true);
   }

   public void method1058(String var1, Supplier<Boolean> var2) {
      if (var2.get() && !this.method0443(var1)) {
         this.field0720.computeIfPresent(var1, (var0, var1x) -> {
            var1x.method1634();
            return (ActionSequence)var1x;
         });
      }
   }

   public void method2078() {
      this.field0720.values().forEach(ActionSequence::method1634);
   }

   public Set<String> method1794() {
      return Collections.unmodifiableSet(this.field0720.keySet());
   }

   public Map<String, ActionSequence> method1621() {
      return Collections.unmodifiableMap(this.field0720);
   }

   private boolean method0443(String var1) {
      return var1 == null || var1.trim().isEmpty();
   }
}
