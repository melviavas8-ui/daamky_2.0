package aethereal;

import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1738;
import net.minecraft.class_1799;
import net.minecraft.class_2703;
import net.minecraft.class_640;
import net.minecraft.class_7828;
import net.minecraft.class_2703.class_2705;

public class AntiBot extends Module {
   private final Set<UUID> field1511 = new HashSet<>();
   static Set<UUID> field0142 = new HashSet<>();
   private final EnumSetting<AntiBot.Mode> field0984 = new EnumSetting<>("antibot.mode", AntiBot.Mode.field0009)
      .method1007("Mode")
      .method0210("Bot detection algorithm")
      .method2130("Метод обнаружения");

   public AntiBot() {
      super("AntiBot", ModuleCategory.field0661, "Filters out fake players and bots");
      this.method1013("Удаляет ботов от античита");
   }

   public static AntiBot method1700() {
      DaamkyClient var0 = DaamkyClient.method2004();
      return var0 != null && var0.method1783() != null ? var0.method1783().method0976(AntiBot.class) : null;
   }

   @EventHandler
   public void onPacket(PacketEvent.Inbound var1) {
      switch (var1.method1970()) {
         case class_2703 var4:
            this.method1368(var4);
            break;
         case class_7828 var5:
            this.method1544(var5);
            break;
         default:
      }
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (field0796.field_1687 != null && field0796.field_1724 != null) {
         if (!this.field1511.isEmpty()) {
            field0796.field_1687.method_18456().stream().filter(var1x -> this.field1511.contains(var1x.method_5667())).forEach(this::method2150);
         }

         if (this.field0984.method0492() == AntiBot.Mode.field0572) {
            this.method1754();
         } else {
            this.method2029();
         }
      }
   }

   private void method1368(class_2703 var1) {
      var1.method_46330().forEach(var1x -> {
         GameProfile var2 = var1x.comp_1107();
         if (var2 != null && !this.method1367(var1x, var2)) {
            if (this.method0946(var2)) {
               field0142.add(var2.getId());
            } else {
               this.field1511.add(var2.getId());
            }
         }
      });
   }

   private void method1544(class_7828 var1) {
      var1.comp_1105().forEach(var1x -> {
         this.field1511.remove(var1x);
         field0142.remove(var1x);
      });
   }

   private boolean method1367(class_2705 var1, GameProfile var2) {
      return var1.comp_1109() < 2 && var2.getProperties() != null && !var2.getProperties().isEmpty();
   }

   private void method2150(class_1657 var1) {
      if (this.method1183(var1)) {
         field0142.add(var1.method_5667());
      }

      this.field1511.remove(var1.method_5667());
   }

   private void method1754() {
      if (field0796.field_1687 != null && field0796.field_1724 != null) {
         for (Iterator var1 = this.field1511.iterator(); var1.hasNext(); var1.remove()) {
            UUID var2 = var1.next();
            class_1657 var3 = field0796.field_1687.method_18470(var2);
            if (var3 != null) {
               String var4 = var3.method_5477().getString();
               boolean var5 = var4.startsWith("CIT-") && !var4.contains("NPC") && !var4.contains("[ZNPC]");
               int var6 = 0;

               for (class_1799 var8 : var3.method_5661()) {
                  if (!var8.method_7960()) {
                     var6++;
                  }
               }

               boolean var9 = var6 == 4;
               boolean var10 = !var3.method_5667().equals(UUID.nameUUIDFromBytes(("OfflinePlayer:" + var4).getBytes()));
               if (var9 || var5 || var10) {
                  field0142.add(var2);
               }
            }
         }

         if (field0796.field_1724.field_6012 % 100 == 0) {
            field0142.removeIf(var0 -> field0796.field_1687.method_18470(var0) == null);
         }
      }
   }

   private void method2029() {
      if (field0796.field_1687 != null) {
         for (class_1657 var2 : field0796.field_1687.method_18456()) {
            if (var2 != field0796.field_1724
               && !var2.method_5667().equals(UUID.nameUUIDFromBytes(("OfflinePlayer:" + var2.method_5477().getString()).getBytes()))
               && var2.method_5767()
               && !field0142.contains(var2.method_5667())
               && !var2.method_5477().getString().contains("NPC")
               && !var2.method_5477().getString().startsWith("[ZNPC]")) {
               field0142.add(var2.method_5667());
            }
         }
      }
   }

   public boolean method0946(GameProfile var1) {
      if (field0796.method_1562() == null) {
         return false;
      }

      List var2;
      try {
         var2 = new ArrayList<>(field0796.method_1562().method_2880());
      } catch (Exception var4) {
         return false;
      }

      return var2.stream().filter(var1x -> var1x.method_2966().getName().equals(var1.getName()) && !var1x.method_2966().getId().equals(var1.getId())).count()
         == 1L;
   }

   public boolean method1183(class_1657 var1) {
      return IntStream.rangeClosed(0, 3)
         .<class_1799>mapToObj(var1.method_31548()::method_7372)
         .allMatch(var0 -> var0.method_7909() instanceof class_1738 && !var0.method_7942());
   }

   public boolean method1196(class_1657 var1, Iterable<class_1799> var2) {
      if (var2 == null) {
         return true;
      }

      List var3 = StreamSupport.<class_1799>stream(var1.method_5661().spliterator(), false).toList();
      List var4 = StreamSupport.stream(var2.spliterator(), false).toList();
      return !IntStream.range(0, Math.min(var3.size(), var4.size())).allMatch(var2x -> var3.get(var2x).equals(var4.get(var2x))) || var3.size() != var4.size();
   }

   public boolean method0250(class_1657 var1) {
      String var2 = var1.method_5477().getString();
      boolean var3 = var2.startsWith("CIT-") && !var2.contains("NPC") && !var2.startsWith("[ZNPC]");
      boolean var4 = field0142.contains(var1.method_5667());
      return var3 || var4 || this.method1129(var1);
   }

   public boolean method1095(UUID var1) {
      return field0142.contains(var1);
   }

   public boolean method1129(class_1297 var1) {
      return !var1.method_5667().equals(UUID.nameUUIDFromBytes(("OfflinePlayer:" + var1.method_5477().getString()).getBytes()))
         && var1.method_5767()
         && !var1.method_5477().getString().contains("NPC")
         && !var1.method_5477().getString().startsWith("[ZNPC]");
   }

   public void method1691() {
      this.field1511.clear();
      field0142.clear();
   }

   @Override
   public void method2078() {
      this.method1691();
      super.method2078();
   }

   public enum Mode implements DisplayNamed {
      field0572("Matrix"),
      field0009("ReallyWorld");

      private final String field1504;

      Mode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }
}
