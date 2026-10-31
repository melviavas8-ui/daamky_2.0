package aethereal;

import java.awt.Color;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector4f;

public class Tracers extends Module {
   private final ColorSetting field0049 = new ColorSetting("tracers.color", 255, 156, 249, 200)
      .method1882()
      .method1007("Color")
      .method0210("Tracer line color")
      .method2130("Цвет линии");
   private final BooleanSetting field1432 = new BooleanSetting("tracers.friendcolor", true)
      .method1007("Friend Color")
      .method0210("Render friends in green")
      .method2130("Друзей отрисовывать зелёным");

   public Tracers() {
      super("Tracers", ModuleCategory.field1004, "Draws lines from camera to nearby players");
      this.method1013("Рисует линии к ближайшим игрокам");
   }

   @EventHandler
   public void onRender3D(WorldRenderEvent.GamePass var1) {
      if (!method1974()) {
         float var2 = var1.method1811().method_60637(true);
         class_4587 var3 = new class_4587();
         class_243 var4 = this.method0942(var1);
         AntiBot var5 = AntiBot.method1700();
         FriendManager var6 = DaamkyClient.method2004().method1608();
         Color var7 = this.field0049.method1726();

         for (class_1657 var9 : field0796.field_1687.method_18456()) {
            if (var9 != field0796.field_1724 && var9.method_5805() && !var9.method_5477().getString().isEmpty() && (var5 == null || !var5.method0250(var9))) {
               class_243 var10 = method1188(var9, var2);
               boolean var11 = this.field1432.method0492() && var6 != null && var6.method2135(var9.method_5477().getString());
               Color var12 = var11 ? new Color(66, 245, 149, var7.getAlpha()) : var7;
               WorldRenderHelper.method1507(var3, var4, var10, var12);
            }
         }
      }
   }

   private class_243 method0942(WorldRenderEvent.GamePass var1) {
      class_4184 var2 = field0796.field_1773.method_19418();
      Matrix4f var3 = var1.method1629().method_23760().method_23761();
      Matrix4f var4 = new Matrix4f().rotation(var2.method_23767().conjugate(new Quaternionf()));
      Matrix4f var5 = new Matrix4f(var3).mul(var4).invert();
      Vector4f var6 = new Vector4f(0.0F, 0.0F, -1.0F, 1.0F);
      var6.mul(var5);
      return var2.method_19326().method_1031(var6.x, var6.y, var6.z);
   }

   private static class_243 method1188(class_1657 var0, float var1) {
      double var2 = class_3532.method_16436(var1, var0.field_6038, var0.method_23317());
      double var4 = class_3532.method_16436(var1, var0.field_5971, var0.method_23318());
      double var6 = class_3532.method_16436(var1, var0.field_5989, var0.method_23321());
      return new class_243(var2, var4 + var0.method_17682() / 2.0, var6);
   }
}
