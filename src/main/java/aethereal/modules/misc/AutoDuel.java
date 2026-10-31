package aethereal;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_640;
import net.minecraft.class_7439;

public class AutoDuel extends Module {
   private final Pattern field0145 = Pattern.compile("^\\w{3,16}$");
   private final EnumSetting<AutoDuel.Mode> field1448 = new EnumSetting<>("autoduel.mode", AutoDuel.Mode.field0589)
      .method1007("Mode")
      .method0210("Duel set to pick from the in-game menu")
      .method2130("Набор поединка");
   private final FloatSetting field0985 = new FloatSetting("autoduel.delay", 500.0F, 300.0F, 1000.0F, 100.0F)
      .method1007("Send Delay")
      .method0210("Delay")
      .method2130("Задержка");
   private final BooleanSetting field0184 = new BooleanSetting("autoduel.money", false)
      .method1007("For Money")
      .method0210("Attach a wager to each duel request")
      .method2130("Играть на деньги");
   private final TextSetting field0483 = new TextSetting("autoduel.moneyamount", "10000", this.field0184::method0492, true)
      .method1007("Money")
      .method0210("Coin amount for the wager")
      .method2130("Сумма монет для ставки");
   private final List<String> field1644 = Lists.newArrayList();
   private final IntervalTimer field1559 = new IntervalTimer();
   private final IntervalTimer field1719 = new IntervalTimer();
   private final IntervalTimer field1149 = new IntervalTimer();
   private final IntervalTimer field1101 = new IntervalTimer();
   private double field1195;
   private double field0870;
   private double field0825;

   public AutoDuel() {
      super("AutoDuel", ModuleCategory.field0776, "Automatically sends duel requests to nearby players");
      this.method1013("Автоматически отправляет запросы на дуэль игрокам");
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field1644.clear();
      this.field1559.method0578();
      this.field1719.method0578();
      this.field1149.method0578();
      this.field1101.method0578();
      if (field0796.field_1724 != null) {
         this.field1195 = field0796.field_1724.method_23317();
         this.field0870 = field0796.field_1724.method_23318();
         this.field0825 = field0796.field_1724.method_23321();
      }
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         double var2 = this.field1195 - field0796.field_1724.method_23317();
         double var4 = this.field0870 - field0796.field_1724.method_23318();
         double var6 = this.field0825 - field0796.field_1724.method_23321();
         if (Math.sqrt(var2 * var2 + var4 * var4 + var6 * var6) > 500.0) {
            this.method1812();
         } else {
            this.field1195 = field0796.field_1724.method_23317();
            this.field0870 = field0796.field_1724.method_23318();
            this.field0825 = field0796.field_1724.method_23321();
            List var8 = this.method1729();
            if (this.field1719.method0612(800.0 * Math.max(1, var8.size()))) {
               this.field1644.clear();
               this.field1719.method0578();
            }

            String var9 = field0796.field_1724.method_7334().getName();

            for (String var11 : var8) {
               if (!this.field1644.contains(var11) && !var11.equals(var9)) {
                  if (!this.field1559.method0612(this.field0985.method0492().doubleValue())) {
                     break;
                  }

                  String var12 = this.field0184.method0492() ? "duel " + var11 + " " + this.field0483.method0492() : "duel " + var11;
                  field0796.field_1724.field_3944.method_45730(var12);
                  this.field1644.add(var11);
                  this.field1559.method0578();
               }
            }

            if (field0796.field_1755 != null && field0796.field_1724.field_7512 != null) {
               class_1703 var13 = field0796.field_1724.field_7512;
               String var14 = field0796.field_1755.method_25440().getString();
               if (var14.contains("Выбор набора (1/1)")) {
                  if (this.field1149.method0612(150.0)) {
                     int var15 = this.field1448.method0492().method0003();
                     if (var15 >= 0) {
                        field0796.field_1761.method_2906(var13.field_7763, var15, 0, class_1713.field_7794, field0796.field_1724);
                     }

                     this.field1149.method0578();
                  }
               } else if (var14.contains("Настройка поединка") && this.field1101.method0612(150.0)) {
                  field0796.field_1761.method_2906(var13.field_7763, 0, 0, class_1713.field_7794, field0796.field_1724);
                  this.field1101.method0578();
               }
            }
         }
      }
   }

   @EventHandler
   public void onPacket(PacketEvent.Inbound var1) {
      if (!method1974()) {
         if (var1.method1970() instanceof class_7439 var2) {
            String var4 = var2.comp_763().getString().toLowerCase();
            if (var4.contains("начало") && var4.contains("через") && var4.contains("секунд!")
               || var4.contains("во время поединка запрещено использовать команды")) {
               this.method1812();
            }
         }
      }
   }

   private List<String> method1729() {
      return field0796.field_1724
         .field_3944
         .method_2880()
         .stream()
         .map(class_640::method_2966)
         .<String>map(GameProfile::getName)
         .filter(var1 -> this.field0145.matcher(var1).matches())
         .collect(Collectors.toList());
   }

   public enum Mode implements DisplayNamed {
      field0589("Шары", 5),
      field0024("Щит", 0),
      field1427("Шипы 3", 1),
      field0966("Незеритка", 8),
      field0764("Читерский рай", 7),
      field1249("Лук", 2),
      field0319("Классик", 6),
      field0182("Тотемы", 3),
      field0463("Нодебафф", 4);

      private final String field1643;
      private final int field1539;

      Mode(String var3, int var4) {
         this.field1643 = var3;
         this.field1539 = var4;
      }

      @Override
      public String method0557() {
         return this.field1643;
      }

      public int method0003() {
         return this.field1539;
      }
   }
}
