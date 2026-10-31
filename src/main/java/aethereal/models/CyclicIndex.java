package aethereal;

import java.util.Arrays;
import java.util.Random;
import meteordevelopment.orbit.EventHandler;

public class CyclicIndex {
   public static final Random field0721 = new Random();
   private static final int field0004 = 20;
   private static long field1412 = 0L;
   private final IntArrayFiller field0990;
   private final CyclicIntSequence field0771 = new CyclicIntSequence(20, 2);
   private final int[] field1277 = new int[]{10, 11};
   private Integer field0335;

   private static long method1764() {
      return System.currentTimeMillis() - field1412;
   }

   public CyclicIndex(IntArrayFiller var1) {
      this.field0990 = var1;
      this.method1634();
      DaamkyClient.method2004().method2072().subscribe(this);
   }

   @EventHandler
   public void handler(PreTickEvent var1) {
      this.field0335 = null;
      if (this.field0771.method0579()) {
         int[] var2 = new int[20];
         CyclicIndex.Direction.field0638.field0068.fill(var2, this.field1277, this);
         this.field0771.method1581(var2);
      }
   }

   public Integer method0554() {
      return this.method0724(0);
   }

   public Integer method0724(int var1) {
      return this.method2103(var1) ? 1 : this.field0771.method0724(var1);
   }

   public boolean method0026() {
      return this.method0144(0);
   }

   public boolean method0144(int var1) {
      return this.method0724(var1) > 0;
   }

   private boolean method2103(int var1) {
      return method1764() + var1 * 50L >= 1000L;
   }

   public void method0991(Runnable var1) {
      int var2 = this.method0554();
      int var3 = 0;

      for (int var4 = 0; var4 < var2; var4++) {
         var1.run();
         var3++;
         field1412 = System.currentTimeMillis();
      }

      this.field0335 = var3;
   }

   private void method1634() {
      this.field0771.method0025();
      int[] var1 = new int[20];

      for (int var2 = 0; var2 < this.field0771.method2048(); var2++) {
         Arrays.fill(var1, 0);
         CyclicIndex.Direction.field0638.field0068.fill(var1, this.field1277, this);
         this.field0771.method1581(var1);
         this.field0771.method0144(20);
      }
   }

   public IntArrayFiller method2053() {
      return this.field0990;
   }

   public enum Direction {
      field0638((var0, var1, var2) -> {
         int var3 = var1[0];
         int var4 = var1[1];
         int var5 = CyclicIndex.field0721.nextInt(var4 - var3 + 1) + var3;

         for (int var6 = 0; var6 < var5; var6++) {
            int var7 = CyclicIndex.field0721.nextInt(var0.length);
            var0[var7]++;
         }
      });

      public final IntArrayFiller field0068;

      Direction(IntArrayFiller var3) {
         this.field0068 = var3;
      }
   }
}
