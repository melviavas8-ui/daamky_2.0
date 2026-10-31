package aethereal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1684;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_9334;

public class UseTracker extends Module {
   public final MultiSelectSetting field0089 = new MultiSelectSetting(
         "usetracker.tracks", Arrays.asList("Potions", "Food", "Ender Pearls", "Totems"), true, () -> true
      )
      .method1007("Track")
      .method0210("Which actions to notify about")
      .method2130("Какие действия отслеживать");
   private static final long field1412 = 1500L;
   private static final int field0958 = 2;
   private final Map<UUID, UseTracker.UseSession> field0210 = new HashMap<>();
   private final List<UseTracker.UseEntry> field0488 = new ArrayList<>();
   private final Set<Integer> field1647 = new HashSet<>();

   public static UseTracker method1725() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(UseTracker.class) : null;
   }

   public UseTracker() {
      super("UseTracker", ModuleCategory.field0776, "Notifies when nearby players use items");
      this.method1013("Уведомления о использовании предметов");
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field0210.clear();
      this.field0488.clear();
      this.field1647.clear();
   }

   @Override
   public void method2078() {
      this.field0210.clear();
      this.field0488.clear();
      this.field1647.clear();
      super.method2078();
   }

   @EventHandler
   public void onSpawn(EntitySpawnEvent var1) {
      if (!method1974()) {
         if (this.field0089.method0387("Ender Pearls")) {
            if (var1.method1798() instanceof class_1684 var3) {
               if (!this.field1647.contains(var3.method_5628())) {
                  if (!this.field0488.stream().anyMatch(var1x -> var1x.field0567 == var3.method_5628())) {
                     if (var3.method_24921() instanceof class_1657 var5 && var5 != field0796.field_1724) {
                        this.field1647.add(var3.method_5628());
                        this.method1182(var5);
                     } else {
                        this.field0488.add(new UseTracker.UseEntry(var3.method_5628()));
                     }
                  }
               }
            }
         }
      }
   }

   @EventHandler
   public void onPopTotem(TotemPopEvent var1) {
      if (!method1974()) {
         if (this.field0089.method0387("Totems")) {
            class_1657 var2 = var1.method1800();
            if (var2 != null && var2 != field0796.field_1724) {
               class_1799 var3 = new class_1799(class_1802.field_8288);
               boolean var4 = method2030();
               String var5 = (var4 ? "потерял " : "lost ") + "\"" + var3.method_7964().getString() + "\"";
               NewHUD.method1053(var2.method_5477().getString(), var5, var3, false);
            }
         }
      }
   }

   @EventHandler
   public void onPlayerTick(PlayerTickEvent var1) {
      if (!method1974()) {
         this.method1691();
         this.method1754();
      }
   }

   private void method1691() {
      if (!this.field0488.isEmpty()) {
         boolean var1 = this.field0089.method0387("Ender Pearls");
         Iterator var2 = this.field0488.iterator();

         while (var2.hasNext()) {
            UseTracker.UseEntry var3 = var2.next();
            class_1297 var4 = field0796.field_1687.method_8469(var3.field0567);
            if (var4 instanceof class_1684 var5) {
               if (var5.method_24921() instanceof class_1657 var7 && var7 != field0796.field_1724) {
                  if (var1 && !this.field1647.contains(var5.method_5628())) {
                     this.field1647.add(var5.method_5628());
                     this.method1182(var7);
                  }

                  var2.remove();
                  continue;
               }
            } else if (var4 == null) {
               var2.remove();
               continue;
            }

            var3.field0004++;
            if (var3.field0004 > 10) {
               var2.remove();
            }
         }
      }

      this.field1647.removeIf(var0 -> field0796.field_1687.method_8469(var0) == null);
   }

   private void method1754() {
      boolean var1 = this.field0089.method0387("Potions");
      boolean var2 = this.field0089.method0387("Food");
      Set var3 = new HashSet<>();

      for (class_1657 var5 : field0796.field_1687.method_18456()) {
         if (var5 != field0796.field_1724) {
            UUID var6 = var5.method_5667();
            var3.add(var6);
            UseTracker.UseSession var7 = this.field0210.computeIfAbsent(var6, var0 -> new UseTracker.UseSession());
            boolean var8 = var5.method_6115();
            if (var8) {
               if (!var7.field0751) {
                  var7.field1520 = var5.method_6030().method_7972();
                  var7.field0751 = true;
               }

               var7.field0004 = 0;
            } else if (var7.field0751) {
               var7.field0004++;
               if (var7.field0004 >= 2) {
                  this.method1195(var5, var7, var1, var2);
                  var7.field0751 = false;
                  var7.field0004 = 0;
                  var7.field1520 = null;
               }
            }
         }
      }

      this.field0210.keySet().removeIf(var1x -> !var3.contains(var1x));
   }

   private void method1195(class_1657 var1, UseTracker.UseSession var2, boolean var3, boolean var4) {
      class_1799 var5 = var2.field1520;
      if (var5 != null && !var5.method_7960()) {
         boolean var6 = var5.method_31574(class_1802.field_8574) || var5.method_31574(class_1802.field_20417) || var5.method_31574(class_1802.field_8103);
         boolean var7 = !var6 && var5.method_57824(class_9334.field_50075) != null;
         if (!var6 || var3) {
            if (!var7 || var4) {
               if (var6 || var7) {
                  long var8 = System.currentTimeMillis();
                  if (var8 - var2.field0959 >= 1500L) {
                     var2.field0959 = var8;
                     boolean var10 = method2030();
                     String var11 = var5.method_7964().getString();
                     String var12;
                     if (var6) {
                        var12 = (var10 ? "выпил " : "drank ") + "\"" + var11 + "\"";
                     } else {
                        var12 = (var10 ? "съел " : "ate ") + "\"" + var11 + "\"";
                     }

                     NewHUD.method1053(var1.method_5477().getString(), var12, var5.method_7972(), true);
                  }
               }
            }
         }
      }
   }

   private void method1182(class_1657 var1) {
      boolean var2 = method2030();
      String var3 = var2 ? "бросил эндер-жемчуг" : "threw an ender pearl";
      NewHUD.method1053(var1.method_5477().getString(), var3, new class_1799(class_1802.field_8634), true);
   }

   private static boolean method2030() {
      try {
         return ClickGuiDashboard.field0984.method0492() == ClickGuiDashboard.Language.field0631;
      } catch (Exception var1) {
         return true;
      }
   }

   private static class UseEntry {
      final int field0567;
      int field0004;

      UseEntry(int var1) {
         this.field0567 = var1;
      }
   }

   private static class UseSession {
      boolean field0751;
      int field0004;
      class_1799 field1520;
      long field0959;
   }
}
