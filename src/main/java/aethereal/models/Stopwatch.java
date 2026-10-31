package aethereal;

import lombok.Generated;

public class Stopwatch {
   private long field0568 = System.currentTimeMillis();

   public Stopwatch() {
      this.field0568 = System.currentTimeMillis();
   }

   public static Stopwatch method0543() {
      return new Stopwatch();
   }

   public boolean method0779(long var1) {
      return System.currentTimeMillis() - this.field0568 >= var1;
   }

   public boolean method0612(double var1) {
      return this.method0779((long)var1);
   }

   public boolean method0161(long var1) {
      return this.method0779(var1);
   }

   public boolean method2108(long var1) {
      return this.method0779(var1);
   }

   public boolean method0104(double var1) {
      return this.method0612(var1);
   }

   public boolean method1832(long var1) {
      return this.method0779(var1);
   }

   public boolean method1646(long var1) {
      return System.currentTimeMillis() - this.field0568 > var1;
   }

   public boolean method0026() {
      return this.field0568 < System.currentTimeMillis();
   }

   public boolean method2079() {
      return System.currentTimeMillis() - this.field0568 <= 0L;
   }

   public void method1812() {
      this.field0568 = System.currentTimeMillis();
   }

   public void method1634() {
      this.method1812();
   }

   public long method1948() {
      return System.currentTimeMillis() - this.field0568;
   }

   public long method0415() {
      return this.method1948();
   }

   public long method0357() {
      return this.method1948();
   }

   public long method0485() {
      return this.method1948();
   }

   public void method1979(long var1) {
      this.field0568 = var1;
   }

   public void method0436(long var1) {
      this.field0568 = var1;
   }

   public void method0380(long var1) {
      this.field0568 = System.currentTimeMillis() + var1;
   }

   @Generated
   public long method2215() {
      return this.field0568;
   }
}
