package aethereal;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.Generated;
import net.minecraft.class_3532;

public final class SystemMetrics {
   private static final ExecutorService field0724 = Executors.newSingleThreadExecutor();
   private static final OperatingSystemMXBean field0137 = ManagementFactory.getOperatingSystemMXBean();
   private static final MemoryMXBean field1505 = ManagementFactory.getMemoryMXBean();
   private static double field0956 = 0.0;
   private static double field0757 = 0.0;
   private static long field1244 = 0L;
   private static long field0316 = 0L;
   private static double field0176 = 0.0;
   private static long field0460 = 0L;
   private static double field1613 = 0.0;
   private static double field1537 = 0.0;
   private static long field1706 = 0L;
   private static long field1138 = 0L;
   private static final long field1089 = 30000L;

   public static void method0578() {
      method1915();
      method1890();
      field1613 = class_3532.method_16436(0.5, field1613, field0956);
      field1537 = class_3532.method_16436(0.5, field1537, field0757);
      field1706 = (long)class_3532.method_16439(0.5F, (float)field1706, (float)field1244);
      if (System.currentTimeMillis() - field1138 > 30000L) {
         field1138 = System.currentTimeMillis();
         method1937();
      }

      field0460 = System.currentTimeMillis();
   }

   private static void method1915() {
      try {
         if (field0137 instanceof com.sun.management.OperatingSystemMXBean operatingsystemmxbean) {
            double d1 = operatingsystemmxbean.getCpuLoad();
            if (d1 >= 0.0) {
               field0956 = d1 * 100.0;
               return;
            }

            d1 = operatingsystemmxbean.getProcessCpuLoad();
            if (d1 >= 0.0) {
               field0956 = d1 * 100.0;
               return;
            }
         }

         double d0 = field0137.getSystemLoadAverage();
         if (d0 >= 0.0) {
            field0956 = Math.min(100.0, d0 * 100.0 / field0137.getAvailableProcessors());
         }
      } catch (Exception exception) {
      }
   }

   private static void method1890() {
      MemoryUsage memoryusage = field1505.getHeapMemoryUsage();
      field1244 = memoryusage.getUsed();
      field0316 = memoryusage.getMax();
      if (field0316 > 0L) {
         field0757 = (double)field1244 / field0316 * 100.0;
      }
   }

   private static void method1937() {
      field0176 = -1.0;
   }

   public static String method0017() {
      long i = field1706 / 1048576L;
      long j = field0316 / 1048576L;
      return i + "/" + j + " MB";
   }

   public static String method2067() {
      return String.format("%.0f%%", field1613);
   }

   public static double method1761() {
      return field1613;
   }

   public static double method1602() {
      return field1537;
   }

   public static String method1961() {
      if (field0176 < 0.0) {
         return "N/A";
      } else {
         return field0176 > 1024.0 ? String.format("%.1f MB/s", field0176 / 1024.0) : String.format("%.0f KB/s", field0176);
      }
   }

   @Generated
   private SystemMetrics() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   @Generated
   public static double method0412() {
      return field0956;
   }

   @Generated
   public static double method0354() {
      return field0757;
   }

   @Generated
   public static long method0485() {
      return field1244;
   }

   @Generated
   public static long method2215() {
      return field0316;
   }

   @Generated
   public static double method2181() {
      return field0176;
   }

   @Generated
   public static long method2255() {
      return field0460;
   }
}
