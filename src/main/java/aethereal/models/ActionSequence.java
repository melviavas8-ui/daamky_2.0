package aethereal;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import java.util.function.BooleanSupplier;
import lombok.Generated;

public class ActionSequence {
   private final IntervalTimer field0647 = new IntervalTimer();
   private final List<ActionSequence.ScheduledStep> field0139 = Lists.newCopyOnWriteArrayList();
   private final List<ActionSequence.RepeatingStep> field1508 = Lists.newCopyOnWriteArrayList();
   private int field0958;
   private int field0759;
   private boolean field1276;
   private ActionSequence.SequenceStep field0326 = new ActionSequence.ImmediateStep(1);

   public ActionSequence() {
      this.method1778();
   }

   public ActionSequence method0759(int var1, Action var2) {
      return this.method0762(var1, var2, () -> true, 0);
   }

   public ActionSequence method0761(int var1, Action var2, BooleanSupplier var3) {
      return this.method0762(var1, var2, var3, 0);
   }

   public ActionSequence method0760(int var1, Action var2, int var3) {
      return this.method0762(var1, var2, () -> true, var3);
   }

   public ActionSequence method0762(int var1, Action var2, BooleanSupplier var3, int var4) {
      this.field0139.add(new ActionSequence.ScheduledStep(var1, var2, var3, var4));
      Collections.sort(this.field0139);
      return this;
   }

   public ActionSequence method0154(int var1, Action var2) {
      return this.method0157(var1, var2, () -> true, 0);
   }

   public ActionSequence method0156(int var1, Action var2, BooleanSupplier var3) {
      return this.method0157(var1, var2, var3, 0);
   }

   public ActionSequence method0155(int var1, Action var2, int var3) {
      return this.method0157(var1, var2, () -> true, var3);
   }

   public ActionSequence method0157(int var1, Action var2, BooleanSupplier var3, int var4) {
      this.field1508.add(new ActionSequence.RepeatingStep(var1, var2, var3, var4));
      Collections.sort(this.field1508);
      return this;
   }

   public void method0578() {
      this.field0647.method0578();
   }

   public void method0025() {
      this.field0958 = 0;
      this.field0759 = 0;
   }

   public ActionSequence method2056() {
      if (this.method1974()) {
         this.method1778();
      }

      return this;
   }

   public ActionSequence method1778() {
      this.field0139.clear();
      this.field1508.clear();
      this.method0578();
      this.method0025();
      return this;
   }

   public void method1634() {
      if ((!this.field0139.isEmpty() || !this.field1508.isEmpty()) && !this.field1276) {
         this.field0139.forEach(var1 -> {
            if (this.field0958 < this.field0139.size()) {
               ActionSequence.ScheduledStep var2 = this.field0139.get(this.field0958);
               if (var2.method2070().getAsBoolean() && this.field0647.method0612(var2.method0531())) {
                  var2.method0008().perform();
                  this.field0958++;
                  this.method0578();
                  if (this.field0326.method0739(this.field0958, this.field0139.size())) {
                     this.method0025();
                     this.field0326.method0578();
                  }
               }
            }
         });
         this.field1508.forEach(var1 -> {
            if (this.field0759 < this.field1508.size()) {
               ActionSequence.RepeatingStep var2 = this.field1508.get(this.field0759);
               if (var2.method1795().getAsBoolean() && var2.method0003() <= 0) {
                  var2.method2054().perform();
                  this.field0759++;
                  this.method0578();
                  if (this.field0326.method0739(this.field0759, this.field1508.size())) {
                     this.method0025();
                     this.field0326.method0578();
                  }
               }

               var2.method0578();
            }
         });
         this.field0958 = Math.min(this.field0958, this.field0139.size());
         this.field0759 = Math.min(this.field0759, this.field1508.size());
      }
   }

   public ActionSequence method0854(ActionSequence.SequenceStep var1) {
      this.field0326 = var1;
      return this;
   }

   public boolean method1974() {
      return this.field0958 >= this.field0139.size() && this.field0759 >= this.field1508.size() && !this.field1276 && this.field0326.method0026();
   }

   @Generated
   public IntervalTimer method0417() {
      return this.field0647;
   }

   @Generated
   public List<ActionSequence.ScheduledStep> method0370() {
      return this.field0139;
   }

   @Generated
   public List<ActionSequence.RepeatingStep> method0494() {
      return this.field1508;
   }

   @Generated
   public int method2214() {
      return this.field0958;
   }

   @Generated
   public int method2183() {
      return this.field0759;
   }

   @Generated
   public boolean method2267() {
      return this.field1276;
   }

   @Generated
   public ActionSequence.SequenceStep method1909() {
      return this.field0326;
   }

   @Generated
   public void method0729(int var1) {
      this.field0958 = var1;
   }

   @Generated
   public void method0143(int var1) {
      this.field0759 = var1;
   }

   @Generated
   public void method1570(boolean var1) {
      this.field1276 = var1;
   }

   public static class ImmediateStep implements ActionSequence.SequenceStep {
      private final int field0567;
      private int field0004;

      public ImmediateStep(int var1) {
         this.field0567 = var1 - 1;
      }

      @Override
      public boolean method0739(int var1, int var2) {
         return var1 >= var2 && this.field0004 < this.field0567;
      }

      @Override
      public void method0578() {
         this.field0004++;
      }

      @Override
      public boolean method0026() {
         return this.field0004 >= this.field0567;
      }
   }

   public static class ConditionalStep implements ActionSequence.SequenceStep {
      @Override
      public boolean method0739(int var1, int var2) {
         return var1 >= var2;
      }

      @Override
      public void method0578() {
      }

      @Override
      public boolean method0026() {
         return false;
      }
   }

   public interface SequenceStep {
      boolean method0739(int var1, int var2);

      void method0578();

      boolean method0026();
   }

   public static final class ScheduledStep implements Comparable<ActionSequence.ScheduledStep> {
      private int field0567;
      private Action field0069;
      private BooleanSupplier field1513;
      private int field0958;

      public ScheduledStep(int var1, Action var2, BooleanSupplier var3, int var4) {
         this.field0567 = var1;
         this.field0069 = var2;
         this.field1513 = var3;
         this.field0958 = var4;
      }

      public int method0855(ActionSequence.ScheduledStep var1) {
         return Integer.compare(var1.method1763(), this.method1763());
      }

      @Generated
      public int method0531() {
         return this.field0567;
      }

      @Generated
      public Action method0008() {
         return this.field0069;
      }

      @Generated
      public BooleanSupplier method2070() {
         return this.field1513;
      }

      @Generated
      public int method1763() {
         return this.field0958;
      }

      @Generated
      public ActionSequence.ScheduledStep method0720(int var1) {
         this.field0567 = var1;
         return this;
      }

      @Generated
      public ActionSequence.ScheduledStep method0847(Action var1) {
         this.field0069 = var1;
         return this;
      }

      @Generated
      public ActionSequence.ScheduledStep method1098(BooleanSupplier var1) {
         this.field1513 = var1;
         return this;
      }

      @Generated
      public ActionSequence.ScheduledStep method0139(int var1) {
         this.field0958 = var1;
         return this;
      }
   }

   public static final class RepeatingStep implements Comparable<ActionSequence.RepeatingStep> {
      private int field0567;
      private Action field0069;
      private BooleanSupplier field1513;
      private int field0958;

      public RepeatingStep(int var1, Action var2, BooleanSupplier var3, int var4) {
         this.field0567 = var1;
         this.field0069 = var2;
         this.field1513 = var3;
         this.field0958 = var4;
      }

      public int method0857(ActionSequence.RepeatingStep var1) {
         return Integer.compare(var1.method1604(), this.method1604());
      }

      public void method0578() {
         this.field0567--;
      }

      @Generated
      public int method0003() {
         return this.field0567;
      }

      @Generated
      public Action method2054() {
         return this.field0069;
      }

      @Generated
      public BooleanSupplier method1795() {
         return this.field1513;
      }

      @Generated
      public int method1604() {
         return this.field0958;
      }

      @Generated
      public ActionSequence.RepeatingStep method0721(int var1) {
         this.field0567 = var1;
         return this;
      }

      @Generated
      public ActionSequence.RepeatingStep method0848(Action var1) {
         this.field0069 = var1;
         return this;
      }

      @Generated
      public ActionSequence.RepeatingStep method1099(BooleanSupplier var1) {
         this.field1513 = var1;
         return this;
      }

      @Generated
      public ActionSequence.RepeatingStep method0140(int var1) {
         this.field0958 = var1;
         return this;
      }
   }
}
