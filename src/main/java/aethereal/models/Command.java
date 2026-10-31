package aethereal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class Command {
   private final String field0715;
   private final List<String> field0139;
   private final String field1504;
   private String field1030;

   protected Command(String var1, String var2, String... var3) {
      this.field0715 = var1;
      this.field1504 = var2;
      this.field0139 = var3.length > 0 ? Arrays.asList(var3) : Collections.emptyList();
   }

   protected void method1013(String var1) {
      this.field1030 = var1;
   }

   public abstract void method0800(CommandContext var1);

   public String method0557() {
      return this.field0715;
   }

   public List<String> method0019() {
      return Collections.unmodifiableList(this.field0139);
   }

   public String method2067() {
      if (this.field1030 != null) {
         try {
            if (ClickGuiDashboard.field0984.method0492() == ClickGuiDashboard.Language.field0631) {
               return this.field1030;
            }
         } catch (Exception var2) {
         }
      }

      return this.field1504 != null ? this.field1504 : "";
   }

   public boolean method0214(String var1) {
      return this.field0715.equalsIgnoreCase(var1) || this.field0139.stream().anyMatch(var1x -> var1x.equalsIgnoreCase(var1));
   }

   public List<String> method1593(String[] var1) {
      return Collections.emptyList();
   }

   public Map<String, String> method0351(String[] var1) {
      return Collections.emptyMap();
   }

   public String method2179(String[] var1) {
      return "";
   }

   protected static boolean method1813() {
      try {
         return ClickGuiDashboard.field0984.method0492() == ClickGuiDashboard.Language.field0631;
      } catch (Exception var1) {
         return true;
      }
   }
}
