package aethereal;

import java.util.Comparator;
import java.util.Objects;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_4587;

public class Nuker extends Module {
   private final BooleanSetting field0034 = new BooleanSetting("nuker.rotate", true)
      .method1007("Rotate")
      .method0210("Rotate towards the block being broken")
      .method2130("Поворачиваться к блоку");
   private final BooleanSetting field1432 = new BooleanSetting("nuker.down", true)
      .method1007("Down")
      .method0210("Also break blocks below you")
      .method2130("Ломать блоки под вами");
   private final FloatSetting field0985 = new FloatSetting("nuker.radius", 3.0F, 1.0F, 6.0F, 1.0F)
      .method1007("Radius")
      .method0210("Block breaking radius around the player")
      .method2130("Радиус разрушения");
   private class_2338 field0213;
   private class_265 field0493;

   public Nuker() {
      super("Nuker", ModuleCategory.field1470, "Automatically breaks blocks around you");
      this.method1013("Автоматически ломает блоки вокруг");
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         int var2 = this.field0985.method0492().intValue();
         this.field0213 = BlockAreaScanner.method1268(field0796.field_1724.method_24515(), var2, var2, this.field1432.method0492())
            .stream()
            .filter(this::method0279)
            .min(Comparator.comparingDouble(this::method1256))
            .orElse(null);
         if (this.field0213 == null) {
            this.field0493 = null;
         } else {
            this.field0493 = field0796.field_1687.method_8320(this.field0213).method_26218(field0796.field_1687, this.field0213);
            field0796.field_1761.method_2902(this.field0213, class_2350.field_11036);
            field0796.field_1724.method_6104(class_1268.field_5808);
         }
      }
   }

   @EventHandler
   public void onRender(WorldRenderEvent.WorldPass var1) {
      if (!method1974() && this.field0213 != null && this.field0493 != null && !this.field0493.method_1110()) {
         WorldRenderHelper.method0334(
            new class_4587(), this.field0493.method_1107().method_996(this.field0213), BlockHighlightColor.method0553(), BlockHighlightColor.method0553()
         );
      }
   }

   private double method1256(class_2338 var1) {
      String var2 = field0796.field_1687.method_8320(var1).method_26204().method_63499().replace("block.minecraft.", "");

      return switch (var2) {
         case "ancient_debris" -> 0.0;
         case "diamond_ore" -> 1.0;
         case "emerald_ore" -> 2.0;
         case "gold_ore" -> 3.0;
         case "iron_ore" -> 4.0;
         case "lapis_ore" -> 5.0;
         case "redstone_ore" -> 6.0;
         default -> field0796.field_1724.method_5707(var1.method_46558());
      };
   }

   private boolean method0279(class_2338 var1) {
      class_2680 var2 = Objects.requireNonNull(field0796.field_1687).method_8320(var1);
      return !var2.method_26215()
         && var2.method_26204() != class_2246.field_10382
         && var2.method_26204() != class_2246.field_10164
         && var2.method_26204() != class_2246.field_9987
         && var2.method_26204() != class_2246.field_10499;
   }
}
