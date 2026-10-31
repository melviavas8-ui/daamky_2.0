package aethereal;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.pathing.goals.GoalXZ;
import baritone.api.utils.IPlayerContext;
import net.minecraft.class_2338;

public class BaritoneController {
   private static IBaritone field0709 = BaritoneAPI.getProvider().getPrimaryBaritone();

   public static boolean method0579() {
      return field0709.getPathingBehavior().isPathing();
   }

   public static boolean method0026() {
      return field0709.getCustomGoalProcess().isActive();
   }

   public static boolean method2079() {
      return field0709.getBuilderProcess().isActive();
   }

   public static void method1263(class_2338 var0) {
      field0709.getCustomGoalProcess().setGoal(new GoalBlock(var0.method_10263(), var0.method_10264(), var0.method_10260()));
   }

   public static void method0611(double var0) {
      IPlayerContext var2 = field0709.getPlayerContext();
      GoalXZ var3 = GoalXZ.fromDirection(var2.playerFeetAsVec(), var2.player().method_5791(), var0);
      field0709.getCustomGoalProcess().setGoal(var3);
   }

   public static void method1812() {
      field0709.getCustomGoalProcess().path();
   }

   public static void method1634() {
      field0709.getPathingBehavior().cancelEverything();
   }
}
