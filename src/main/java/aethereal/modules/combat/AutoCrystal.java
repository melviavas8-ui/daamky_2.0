package aethereal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.Generated;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1268;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1303;
import net.minecraft.class_1511;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1738;
import net.minecraft.class_1779;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2604;
import net.minecraft.class_2606;
import net.minecraft.class_2824;
import net.minecraft.class_2879;
import net.minecraft.class_2885;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_4587;
import net.minecraft.class_640;

public class AutoCrystal extends Module {
   private final BooleanSetting field0034 = new BooleanSetting("autocrystal.attack", true)
      .method1007("Attack")
      .method0210("Auto-attack safe crystals")
      .method2130("Авто-удар по безопасным кристаллам");
   private final FloatSetting field1450 = new FloatSetting("autocrystal.attackspeed", 20.0F, 0.1F, 20.0F, 0.1F)
      .method1007("Attack Speed")
      .method0210("Crystal attack rate (1..20/s)")
      .method2130("Скорость ударов");
   private final FloatSetting field0985 = new FloatSetting("autocrystal.attackrange", 4.5F, 0.0F, 8.0F, 0.1F)
      .method1007("Attack Range")
      .method0210("Max attack distance")
      .method2130("Макс. дистанция");
   private final FloatSetting field0190 = new FloatSetting("autocrystal.attackwalls", 4.5F, 0.0F, 8.0F, 0.1F, () -> false)
      .method1007("Walls Range (Attack)")
      .method0210("Hidden — defaults to attack range")
      .method2130("Скрыто");
   private final EnumSetting<AutoCrystal.AntiWeaknessMode> field0469 = new EnumSetting<>(
         "autocrystal.antiweakness", AutoCrystal.AntiWeaknessMode.field1418, () -> false
      )
      .method1007("Anti Weakness")
      .method0210("Hidden default Silent")
      .method2130("Скрытый дефолт");
   private final BooleanSetting field1619 = new BooleanSetting("autocrystal.instant", true, () -> false)
      .method1007("Instant")
      .method0210("Hidden default true")
      .method2130("Скрытый дефолт");
   private final BooleanSetting field1544 = new BooleanSetting("autocrystal.inhibit", true, () -> false)
      .method1007("Inhibit")
      .method0210("Hidden default true")
      .method2130("Скрытый дефолт");
   private final BooleanSetting field1709 = new BooleanSetting("autocrystal.place", true)
      .method1007("Place")
      .method0210("Auto-place crystals")
      .method2130("Авто-постановка");
   private final FloatSetting field1144 = new FloatSetting("autocrystal.placespeed", 20.0F, 0.1F, 20.0F, 0.1F)
      .method1007("Place Speed")
      .method0210("Place rate (1..20/s)")
      .method2130("Скорость постановки");
   private final FloatSetting field1097 = new FloatSetting("autocrystal.placerange", 4.5F, 0.0F, 8.0F, 0.1F)
      .method1007("Place Range")
      .method0210("Max place distance")
      .method2130("Макс. дистанция постановки");
   private final FloatSetting field1206 = new FloatSetting("autocrystal.placewalls", 4.5F, 0.0F, 8.0F, 0.1F, () -> false)
      .method1007("Walls Range (Place)")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final EnumSetting<AutoCrystal.PlacementMode> field0880 = new EnumSetting<>("autocrystal.placements", AutoCrystal.PlacementMode.field0586, () -> false)
      .method1007("Placements")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final BooleanSetting field0830 = new BooleanSetting("autocrystal.blockdestruction", false, () -> false)
      .method1007("Block Destruction")
      .method0210("Hidden — needs SpeedMine")
      .method2130("Скрыто");
   private final EnumSetting<AutoCrystal.SwitchMode> field0918 = new EnumSetting<>("autocrystal.switch", AutoCrystal.SwitchMode.field0588)
      .method1007("Switch")
      .method0210("Auto-switch mode")
      .method2130("Режим переключения");
   private final EnumSetting<AutoCrystal.SequentialMode> field1340 = new EnumSetting<>("autocrystal.sequential", AutoCrystal.SequentialMode.field0583, () -> false)
      .method1007("Sequential")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final EnumSetting<AutoCrystal.RotationMode> field1301 = new EnumSetting<>("autocrystal.rotate", AutoCrystal.RotationMode.field1423)
      .method1007("Rotate")
      .method0210("Rotation mode")
      .method2130("Режим ротации");
   private final EnumSetting<AutoCrystal.SwingMode> field1376 = new EnumSetting<>("autocrystal.swing", AutoCrystal.SwingMode.field0582, () -> false)
      .method1007("Swing")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final BooleanSetting field0389 = new BooleanSetting("autocrystal.yawstep", false, () -> false)
      .method1007("Yaw Step")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final FloatSetting field0360 = new FloatSetting("autocrystal.yawstepthr", 75.0F, 1.0F, 180.0F, 1.0F, () -> false)
      .method1007("Yaw Step Threshold")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final BooleanSetting field0426 = new BooleanSetting("autocrystal.raytrace", false, () -> false)
      .method1007("Raytrace")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final FloatSetting field0262 = new FloatSetting("autocrystal.extrapolation", 0.0F, 0.0F, 20.0F, 1.0F, () -> false)
      .method1007("Extrapolation")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final FloatSetting field0234 = new FloatSetting("autocrystal.enemyrange", 10.0F, 0.0F, 24.0F, 0.5F, () -> false)
      .method1007("Enemy Range")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final BooleanSetting field0292 = new BooleanSetting("autocrystal.chestbreak", false, () -> false)
      .method1007("Chest Break")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final BooleanSetting field0526 = new BooleanSetting("autocrystal.async", true, () -> false)
      .method1007("Asynchronous")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final BooleanSetting field0503 = new BooleanSetting("autocrystal.gameloop", false, () -> false)
      .method1007("Game Loop")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final FloatSetting field0552 = new FloatSetting("autocrystal.loopdelay", 50.0F, 0.0F, 1000.0F, 10.0F, () -> false)
      .method1007("Loop Delay")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final EnumSetting<AutoCrystal.EatingMode> field1675 = new EnumSetting<>("autocrystal.whileeating", AutoCrystal.EatingMode.field0962, () -> false)
      .method1007("While Eating")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final BooleanSetting field1659 = new BooleanSetting("autocrystal.godsync", false, () -> false)
      .method1007("God Sync")
      .method0210("Hidden — entity-id prediction")
      .method2130("Скрыто");
   private final FloatSetting field1693 = new FloatSetting("autocrystal.predictions", 10.0F, 1.0F, 20.0F, 1.0F, () -> false)
      .method1007("Predictions")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final FloatSetting field1593 = new FloatSetting("autocrystal.offset", 0.0F, 0.0F, 2.0F, 1.0F, () -> false)
      .method1007("Offset")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final EnumSetting<AutoCrystal.GodSwingMode> field1583 = new EnumSetting<>("autocrystal.godswing", AutoCrystal.GodSwingMode.field0022, () -> false)
      .method1007("God Swing")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final BooleanSetting field1604 = new BooleanSetting("autocrystal.fast", false, () -> false)
      .method1007("Fast")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final BooleanSetting field1756 = new BooleanSetting("autocrystal.antikick", false, () -> false)
      .method1007("Anti Kick")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final FloatSetting field1744 = new FloatSetting("autocrystal.kickthr", 5.0F, 1.0F, 10.0F, 1.0F, () -> false)
      .method1007("Kick Threshold")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final EnumSetting<AutoCrystal.FacePlaceMode> field1768 = new EnumSetting<>("autocrystal.faceplace", AutoCrystal.FacePlaceMode.field0014)
      .method1007("Faceplace")
      .method0210("Faceplace logic")
      .method2130("Режим фейспласа");
   private final EnumSetting<AutoCrystal.FacePlaceSpeedMode> field1177 = new EnumSetting<>(
         "autocrystal.faceplacespeed", AutoCrystal.FacePlaceSpeedMode.field0580, () -> false
      )
      .method1007("Faceplace Speed")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final FloatSetting field1167 = new FloatSetting("autocrystal.faceplacedelay", 11.0F, 0.0F, 20.0F, 1.0F, () -> false)
      .method1007("Faceplace Delay")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final BooleanSetting field1188 = new BooleanSetting("autocrystal.healthplace", true, () -> false)
      .method1007("Health FP")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final FloatSetting field1122 = new FloatSetting("autocrystal.health", 8.0F, 0.0F, 36.0F, 0.5F, () -> false)
      .method1007("Faceplace Health")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final BooleanSetting field1114 = new BooleanSetting("autocrystal.armorplace", true, () -> false)
      .method1007("Armor FP")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final FloatSetting field1132 = new FloatSetting("autocrystal.armorpct", 10.0F, 1.0F, 100.0F, 1.0F, () -> false)
      .method1007("Armor %")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final FloatSetting field1230 = new FloatSetting("autocrystal.mindamage", 6.0F, 0.0F, 36.0F, 0.5F)
      .method1007("Min Damage")
      .method0210("Min damage to enemies")
      .method2130("Мин. урон цели");
   private final FloatSetting field1222 = new FloatSetting("autocrystal.maxselfdamage", 10.0F, 0.0F, 36.0F, 0.5F)
      .method1007("Max Self Damage")
      .method0210("Max self damage")
      .method2130("Макс. самоурон");
   private final FloatSetting field1236 = new FloatSetting("autocrystal.lethalmult", 1.5F, 0.0F, 4.0F, 0.05F, () -> false)
      .method1007("Lethal Multiplier")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final BooleanSetting field0900 = new BooleanSetting("autocrystal.antisuicide", true, () -> false)
      .method1007("Anti Suicide")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final BooleanSetting field0894 = new BooleanSetting("autocrystal.ignoreterrain", true, () -> false)
      .method1007("Ignore Terrain")
      .method0210("Hidden default")
      .method2130("Скрыто");
   private final BooleanSetting field0904 = new BooleanSetting("autocrystal.debug", false)
      .method1007("Debug")
      .method0210("Print decision trace to chat")
      .method2130("Печатать трассу решений в чат");
   private final EnumSetting<AutoCrystal.RenderMode> field0857 = new EnumSetting<>("autocrystal.rendermode", AutoCrystal.RenderMode.field0964)
      .method1007("Render")
      .method0210("Render mode for place position")
      .method2130("Отрисовка позиции");
   private final ColorSetting field0849 = new ColorSetting("autocrystal.fill", 100, 200, 255, 60, () -> false)
      .method1007("Fill Color")
      .method0210("Hidden")
      .method2130("Скрыто");
   private final ColorSetting field0866 = new ColorSetting(
         "autocrystal.outline",
         100,
         200,
         255,
         255,
         () -> this.field0857.method0492() == AutoCrystal.RenderMode.field1424 || this.field0857.method0492() == AutoCrystal.RenderMode.field0964
      )
      .method1007("Outline Color")
      .method0210("Outline color")
      .method2130("Цвет обводки");
   private final ExecutorService field0945 = Executors.newSingleThreadExecutor(var0 -> {
      Thread var1 = new Thread(var0, "AutoCrystal-Worker");
      var1.setDaemon(true);
      return var1;
   });
   private Runnable field0935 = null;
   private Runnable field0950 = null;
   private final Map<Integer, Long> field1360 = new ConcurrentHashMap<>();
   private final Map<class_2338, Long> field1354 = new ConcurrentHashMap<>();
   private final Map<class_2338, Long> field1364 = new ConcurrentHashMap<>();
   private final Stopwatch field1321 = new Stopwatch();
   private final Stopwatch field1316 = new Stopwatch();
   private final Stopwatch field1326 = new Stopwatch();
   private final Stopwatch field1398 = new Stopwatch();
   private boolean field1394 = false;
   private boolean field1407 = true;
   private boolean field0415 = false;
   private boolean field0410 = false;
   private class_1657 field0421 = null;
   private class_1511 field0376 = null;
   private AutoCrystal.RenderState field0373 = null;
   private AutoCrystal.RenderState field0380 = null;
   private final SelectedSlotTracker field0449 = new SelectedSlotTracker();
   private int field0444 = -100000;
   private int field0453 = 0;
   private String field0282 = "";
   private long field0274 = 0L;
   private long field0285 = 0L;
   private static final String[] field0249 = new String[]{"entityId", "field_12870"};

   private void method2134(String var1) {
      if (this.field0904.method0492()) {
         if (field0796.field_1705 != null) {
            field0796.field_1705.method_1743().method_1812(class_2561.method_43470("§8[§bAC§8] §7" + var1));
         }
      }
   }

   private void method1045(String var1, String var2) {
      if (this.field0904.method0492()) {
         long var3 = System.currentTimeMillis();
         String var5 = var1 + ":" + var2;
         if (!var5.equals(this.field0282) || var3 - this.field0274 >= 1000L) {
            this.field0282 = var5;
            this.field0274 = var3;
            this.method2134(var1 + " skip — " + var2);
         }
      }
   }

   public AutoCrystal() {
      super("AutoCrystal", ModuleCategory.field0661, "AutoCrystal port with ReallyWorld rotation");
      this.method1013("AutoCrystal с ротацией ReallyWorld");
   }

   @EventHandler
   public void onPlayerUpdate(PlayerTickEvent var1) {
      if (!method1974()) {
         long var2 = this.method0462();
         long var4 = 500L;
         long var6 = 30000L;
         long var8 = Math.max(var4, var2 * 2L + (long)((20.0F - this.field1450.method0492()) * 50.0F));
         this.field1360.entrySet().removeIf(var2x -> System.currentTimeMillis() - var2x.getValue() > var6);
         this.field1354.entrySet().removeIf(var2x -> System.currentTimeMillis() - var2x.getValue() > var8);
         this.field1364.entrySet().removeIf(var2x -> System.currentTimeMillis() - var2x.getValue() > var4);
         if (this.field0904.method0492() && System.currentTimeMillis() - this.field0285 > 1000L) {
            this.field0285 = System.currentTimeMillis();
            int var10 = 0;

            try {
               FriendManager var11 = DaamkyClient.method2004().method1608();

               for (class_1657 var13 : field0796.field_1687.method_18456()) {
                  if (var13 != field0796.field_1724
                     && var13.method_5805()
                     && !(field0796.field_1724.method_5858(var13) > class_3532.method_33723(this.field0234.method0492().doubleValue()))
                     && (var11 == null || !var11.method2135(var13.method_5477().getString()))) {
                     var10++;
                  }
               }
            } catch (Throwable var14) {
            }

            String var16 = this.field0373 != null && this.field0373.field0733 != null
               ? this.field0373.field0733.method_23854() + " dmg=" + String.format("%.1f", this.field0373.field0758)
               : "null";
            String var17 = this.field0376 != null ? "id=" + this.field0376.method_5628() : "null";
            this.method2134(
               "tick: enemies="
                  + var10
                  + " placeT="
                  + var16
                  + " atkT="
                  + var17
                  + " ping="
                  + var2
                  + " switch="
                  + this.field0918.method0492()
                  + " rotate="
                  + this.field1301.method0492()
                  + " placed="
                  + this.field1354.size()
            );
         }

         Runnable var15 = () -> {
            try {
               this.field0376 = this.method2014();
               this.field0373 = this.method1258(null);
               this.field0421 = this.field0373 == null ? null : this.field0373.field0152;
            } catch (Throwable var2x) {
            }
         };
         if (this.field0526.method0492()) {
            this.field0945.submit(var15);
         } else {
            var15.run();
         }

         if (!this.field0503.method0492()) {
            this.method1691();
         }
      }
   }

   @EventHandler
   public void onGameLoop(GameLoopEvent var1) {
      if (!method1974()) {
         if (this.field0503.method0492()) {
            if (this.field1398.method1646(this.field0552.method0492().longValue())) {
               this.field1398.method1634();
               this.method1691();
               if (this.field0935 != null) {
                  this.field0935.run();
                  this.field0935 = null;
               }

               if (this.field0950 != null) {
                  this.field0950.run();
                  this.field0950 = null;
               }
            }
         }
      }
   }

   private void method1691() {
      this.field0935 = null;
      this.field0950 = null;
      if (this.field1340.method0492() == AutoCrystal.SequentialMode.field0583) {
         if (this.field1394) {
            this.field1394 = false;
            this.field1407 = true;
            this.method1754();
            return;
         }

         if (this.field1407) {
            this.field1394 = true;
            this.field1407 = false;
            this.method1876(false);
         }
      } else {
         if (this.field0034.method0492()) {
            this.method1754();
         }

         if (this.field1709.method0492()) {
            this.method1876(false);
         }
      }
   }

   @EventHandler
   public void onUpdateMovementPost(PostMovementEvent var1) {
      if (!method1974()) {
         if (this.field0935 != null) {
            this.field0935.run();
         }

         if (this.field0950 != null) {
            this.field0950.run();
         }
      }
   }

   @EventHandler
   public void onSpawnEntity(EntitySpawnEvent var1) {
      if (!method1974()) {
         if (this.field0034.method0492() && this.field1619.method0492()) {
            if (var1.method1798() instanceof class_1511 var2) {
               if (!this.field1321.method1646((long)(1000.0F - this.field1450.method0492() * 50.0F))) {
                  this.method1045("instant", "cooldown");
               } else if (this.field1544.method0492() && this.field1360.containsKey(var2.method_5628())) {
                  this.method1045("instant", "inhibited");
               } else if (!this.field1354.containsKey(var2.method_24515().method_10074())) {
                  this.method1045("instant", "not our crystal (placedCrystals miss)");
               } else {
                  class_243 var4 = field0796.field_1724.method_33571();
                  if (var2.method_5829().method_49271(var4) > class_3532.method_33723(this.field0985.method0492().doubleValue())) {
                     this.method1045("instant", "out of range");
                  } else if (!field0796.field_1687.method_8621().method_11952(var2.method_24515())) {
                     this.method1045("instant", "world border");
                  } else if (BlockPlacementHelper.method1301(var2.method_5829().method_1005())
                     || !this.field0426.method0492()
                        && !(var2.method_5829().method_49271(var4) > class_3532.method_33723(this.field0190.method0492().doubleValue()))) {
                     this.method2134("INSTANT attack on spawn id=" + var2.method_5628());
                     this.method1300(class_243.method_26410(var2.method_24515(), 0.0));
                     this.method1174(var2);
                     this.field0415 = true;
                  } else {
                     this.method1045("instant", "blocked by walls");
                  }
               }
            }
         }
      }
   }

   @EventHandler
   public void onDestroyBlock(BlockDestroyEvent var1) {
      if (!method1974()) {
         this.field0453 = 0;
         if (this.field0830.method0492()) {
            if (this.field1316.method1646((long)(1000.0F - this.field1144.method0492() * 50.0F))) {
               class_2338 var2 = var1.method1802();
               if (var2 != null) {
                  int var3 = InventoryManager.method2154(class_1802.field_8301);
                  int var4 = field0796.field_1724.method_31548().field_7545;
                  boolean var5 = false;
                  if (this.field0918.method0492() == AutoCrystal.SwitchMode.field0588
                     || var3 != -1
                     || field0796.field_1724.method_6047().method_7909() == class_1802.field_8301
                     || field0796.field_1724.method_6079().method_7909() == class_1802.field_8301) {
                     AutoCrystal.RenderState var6 = this.field0380 == null ? null : this.field0380.method0533();
                     if (var6 == null || var6.field0733 != null && !var2.equals(var6.field1041)) {
                        var6 = this.method1258(var2);
                     }

                     if (var6 != null && var6.field0733 != null) {
                        class_2338 var7 = var6.field0733;
                        class_243 var8 = field0796.field_1724.method_33571();
                        if (!(var8.method_1025(class_243.method_24953(var7)) > class_3532.method_33723(this.field1097.method0492().doubleValue()))) {
                           if (BlockPlacementHelper.method1301(class_243.method_24953(var7))
                              || !this.field0426.method0492()
                                 && !(var8.method_1025(class_243.method_24953(var7)) > class_3532.method_33723(this.field1206.method0492().doubleValue()))) {
                              this.method1300(class_243.method_26410(var7, 1.0));
                              Iterator var9 = field0796.field_1687
                                 .method_8335(null, new class_238(var7.method_10084()))
                                 .stream()
                                 .filter(var0 -> var0 instanceof class_1511)
                                 .toList()
                                 .iterator();
                              if (var9.hasNext()) {
                                 class_1297 var10 = (class_1297)var9.next();
                                 this.method1300(var10.method_5829().method_1005());
                                 field0796.field_1724.field_3944.method_52787(class_2824.method_34206(var10, field0796.field_1724.method_5715()));
                                 field0796.field_1724.field_3944.method_52787(new class_2879(class_1268.field_5808));
                              }

                              if (this.field0918.method0492() != AutoCrystal.SwitchMode.field0588
                                 && field0796.field_1724.method_6047().method_7909() != class_1802.field_8301
                                 && field0796.field_1724.method_6079().method_7909() != class_1802.field_8301) {
                                 this.method0738(var3, var4);
                                 var5 = true;
                              }

                              this.method0278(var7);
                              if (var5) {
                                 this.method0148(var3, var4);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @EventHandler
   public void onPacketReceive(PacketEvent.Inbound var1) {
      if (!method1974()) {
         if (var1.method1970() instanceof class_2604 var2) {
            if (var2.method_11167() > this.field0444) {
               this.field0444 = var2.method_11167();
            }

            class_2338 var5 = class_2338.method_49637(var2.method_11175(), var2.method_11174(), var2.method_11176()).method_10069(0, -1, 0);
            if (this.field1364.containsKey(var5)) {
               if (this.field1326.method1646(this.field1167.method0492().longValue() * 50L)) {
                  this.field1326.method1634();
               }

               this.field1364.remove(var5);
               this.field0449.method0578();
            }
         }

         if (var1.method1970() instanceof class_2606 var4 && var4.method_11183() > this.field0444) {
            this.field0444 = var4.method_11183();
         }
      }
   }

   @EventHandler
   public void onPlayerDeath(PlayerDeathEvent var1) {
      this.field0453 = 0;
   }

   @EventHandler
   public void onClientConnect(ClientConnectEvent var1) {
      this.field0444 = -100000;
   }

   @EventHandler
   public void onRender(WorldRenderEvent.WorldPass var1) {
      if (!method1974()) {
         AutoCrystal.RenderState var2 = this.field0373;
         if (var2 != null && var2.field0733 != null && this.field0857.method0492() != AutoCrystal.RenderMode.field0585) {
            class_238 var3 = new class_238(var2.field0733.method_10084());
            class_4587 var4 = new class_4587();
            AutoCrystal.RenderMode var5 = this.field0857.method0492();
            if (var5 == AutoCrystal.RenderMode.field0020 || var5 == AutoCrystal.RenderMode.field0964) {
               WorldRenderHelper.method1498(var4, var3, this.field0849.method1726());
            }

            if (var5 == AutoCrystal.RenderMode.field1424 || var5 == AutoCrystal.RenderMode.field0964) {
               WorldRenderHelper.method2173(var4, var3, this.field0866.method1726());
            }
         }
      }
   }

   private void method1754() {
      class_1511 var1 = null;
      boolean var2 = this.field0373 != null && this.field0373.field1508 != null && !this.field0373.field1508.isEmpty();

      for (class_1297 var5 : var2 ? this.field0373.field1508 : field0796.field_1687.method_18112()) {
         if (var5 instanceof class_1511 var6
            && var6.method_5805()
            && (!this.field1544.method0492() || !this.field1360.containsKey(var5.method_5628()))
            && (var2 || this.field1354.containsKey(var6.method_24515().method_10074()))) {
            class_243 var7 = field0796.field_1724.method_33571();
            if (!(var6.method_5829().method_49271(var7) > class_3532.method_33723(this.field0985.method0492().doubleValue()))
               && field0796.field_1687.method_8621().method_11952(var6.method_24515())
               && (
                  BlockPlacementHelper.method1301(var6.method_5829().method_1005())
                     || !this.field0426.method0492()
                        && !(var6.method_5829().method_49271(var7) > class_3532.method_33723(this.field0190.method0492().doubleValue()))
               )) {
               var1 = var6;
               break;
            }
         }
      }

      class_1511 var8 = var1 == null ? this.field0376 : var1;
      if (var8 == null) {
         this.method1045("attack", "no candidate (calc=null & no override)");
      } else {
         if (this.field1301.method0492() == AutoCrystal.RotationMode.field0019) {
            this.method1300(class_243.method_26410(var8.method_24515(), 0.0));
         }

         if (this.field1321.method1646((long)(1000.0F - this.field1450.method0492() * 50.0F)) && !this.field0415) {
            class_1297 var9 = field0796.field_1687.method_8469(var8.method_5628());
            if (!(var9 != null && var9 instanceof class_1511 var10) || !var10.method_5805()) {
               this.method1045("attack", "crystal vanished");
            } else if (this.field1544.method0492() && this.field1360.containsKey(var9.method_5628())) {
               this.method1045("attack", "inhibited (already attacked)");
            } else {
               class_243 var11 = field0796.field_1724.method_33571();
               if (var10.method_5829().method_49271(var11) > class_3532.method_33723(this.field0985.method0492().doubleValue())) {
                  this.method1045("attack", "out of range");
               } else if (!field0796.field_1687.method_8621().method_11952(var10.method_24515())) {
                  this.method1045("attack", "world border");
               } else if (BlockPlacementHelper.method1301(var10.method_5829().method_1005())
                  || !this.field0426.method0492()
                     && !(var10.method_5829().method_49271(var11) > class_3532.method_33723(this.field0190.method0492().doubleValue()))) {
                  this.field0935 = () -> this.method1174(var8);
               } else {
                  this.method1045("attack", "blocked by walls");
               }
            }
         } else {
            if (this.field0415) {
               this.field0415 = false;
            } else {
               this.method1045("attack", "cooldown");
            }
         }
      }
   }

   private void method1876(boolean var1) {
      AutoCrystal.RenderState var2 = this.field0373 == null ? null : this.field0373.method0533();
      if (var2 != null && var2.field0733 != null) {
         int var3 = InventoryManager.method2154(class_1802.field_8301);
         int var4 = field0796.field_1724.method_31548().field_7545;
         boolean var5 = field0796.field_1724.method_6047().method_7909() == class_1802.field_8301
            || field0796.field_1724.method_6079().method_7909() == class_1802.field_8301;
         if (this.field0918.method0492() != AutoCrystal.SwitchMode.field0588 && var3 == -1 && !var5) {
            this.method1045("place", "no crystals in hotbar (autoSwitch=" + this.field0918.method0492() + ")");
         } else if (this.field0918.method0492() == AutoCrystal.SwitchMode.field0588 && !var5) {
            this.method1045("place", "no crystal in hand & autoSwitch=None — set Switch=Silent");
         } else {
            class_2338 var6 = var2.field0733;
            if (this.field1354.containsKey(var6)) {
               this.method1045("place", "already placed @" + var6.method_23854() + " (in flight)");
            } else {
               class_243 var7 = field0796.field_1724.method_33571();
               if (var7.method_1025(class_243.method_24953(var6)) > class_3532.method_33723(this.field1097.method0492().doubleValue())) {
                  this.method1045("place", "out of range " + var6);
               } else if (!field0796.field_1687.method_8621().method_11952(var6)) {
                  this.method1045("place", "world border");
               } else if (field0796.field_1687.method_8320(var6).method_26204() != class_2246.field_10540
                  && field0796.field_1687.method_8320(var6).method_26204() != class_2246.field_9987) {
                  this.method1045("place", "not obsidian/bedrock");
               } else if (field0796.field_1687.method_8320(var6.method_10069(0, 1, 0)).method_26215()
                  && (
                     this.field0880.method0492() != AutoCrystal.PlacementMode.field0021
                        || field0796.field_1687.method_8320(var6.method_10069(0, 2, 0)).method_26215()
                  )) {
                  if (BlockPlacementHelper.method1301(class_243.method_24953(var6))
                     || !this.field0426.method0492()
                        && !(var7.method_1025(class_243.method_24953(var6)) > class_3532.method_33723(this.field1206.method0492().doubleValue()))) {
                     if (field0796.field_1687
                        .method_8335(null, new class_238(var6.method_10069(0, 1, 0)))
                        .stream()
                        .anyMatch(var0 -> var0.method_5805() && !(var0 instanceof class_1303) && !(var0 instanceof class_1511))) {
                        this.method1045("place", "entity blocking spawn");
                     } else {
                        if (this.field1301.method0492() == AutoCrystal.RotationMode.field0019) {
                           this.method1300(class_243.method_26410(var6, 1.0));
                        }

                        if (!this.field1316.method1646((long)(1000.0F - this.field1144.method0492() * 50.0F))) {
                           this.method1045("place", "cooldown");
                        } else if (!var1 && this.field0410) {
                           this.field0410 = false;
                           this.method1045("place", "sequenced already");
                        } else {
                           class_2338 var8 = var6;
                           int var9 = var3;
                           int var10 = var4;
                           this.field0950 = () -> {
                              boolean var4 = false;
                              if (field0796.field_1724.method_6047().method_7909() != class_1802.field_8301
                                 && field0796.field_1724.method_6079().method_7909() != class_1802.field_8301) {
                                 this.method0738(var9, var10);
                                 var4 = true;
                              }

                              this.method0278(var8);
                              if (var4) {
                                 this.method0148(var9, var10);
                              }

                              if (this.field1659.method0492()) {
                                 this.method2029();
                              }
                           };
                           if (var1) {
                              this.field0950.run();
                              this.field0950 = null;
                              this.field0410 = true;
                           }
                        }
                     }
                  } else {
                     this.method1045("place", "blocked by walls");
                  }
               } else {
                  this.method1045("place", "blocked above");
               }
            }
         }
      } else {
         this.method1045("place", "no target (calc returned null/empty)");
      }
   }

   private void method2029() {
      boolean var1 = field0796.field_1724.method_6047().method_7909() instanceof class_1779
         || field0796.field_1724.method_6079().method_7909() instanceof class_1779;
      ThrowXP var2 = ThrowXP.method1723();
      boolean var3 = var2 != null && var2.method2195();
      boolean var4 = !this.field1756.method0492() || !var1 && !var3;
      if ((!this.field1756.method0492() || this.field0453 > this.field1744.method0492().intValue()) && var4) {
         if (!this.field1604.method0492()) {
            for (class_1297 var6 : field0796.field_1687.method_18112()) {
               if (var6.method_5628() > this.field0444) {
                  this.field0444 = var6.method_5628();
               }
            }
         }

         int var11 = this.field1693.method0492().intValue();
         int var12 = this.field1593.method0492().intValue();

         for (int var7 = 1 - var12; var7 < var11; var7++) {
            class_1297 var8 = field0796.field_1687.method_8469(this.field0444);
            if (var8 == null || var8 instanceof class_1511) {
               int var9 = this.field0444 + var7;
               class_2824 var10 = class_2824.method_34206(field0796.field_1724, field0796.field_1724.method_5715());
               method1377(var10, var9);
               field0796.method_1562().method_52787(var10);
               if (this.field1583.method0492() == AutoCrystal.GodSwingMode.field1425) {
                  field0796.method_1562().method_52787(new class_2879(class_1268.field_5808));
               }

               this.field1360.put(var9, System.currentTimeMillis());
            }
         }

         if (this.field1583.method0492() == AutoCrystal.GodSwingMode.field0022) {
            field0796.method_1562().method_52787(new class_2879(class_1268.field_5808));
         }
      }

      this.field0453++;
   }

   private static void method1377(class_2824 var0, int var1) {
      for (String var5 : field0249) {
         try {
            Field var6 = class_2824.class.getDeclaredField(var5);
            var6.setAccessible(true);
            var6.setInt(var0, var1);
            return;
         } catch (Throwable var8) {
         }
      }

      for (Field var12 : class_2824.class.getDeclaredFields()) {
         if (!Modifier.isStatic(var12.getModifiers()) && var12.getType() == int.class) {
            try {
               var12.setAccessible(true);
               var12.setInt(var0, var1);
               return;
            } catch (Throwable var7) {
            }
         }
      }
   }

   private class_1511 method2014() {
      if (!this.field0034.method0492()) {
         return null;
      }

      if (this.method1677(true)) {
         return null;
      }

      if (field0796.field_1687 != null && field0796.field_1724 != null) {
         List var1 = this.method2041();
         if (var1.isEmpty()) {
            return null;
         }

         class_1511 var2 = null;
         float var3 = 0.0F;

         for (class_1297 var5 : field0796.field_1687.method_18112()) {
            if (var5 instanceof class_1511 var6 && var6.method_5805() && (!this.field1544.method0492() || !this.field1360.containsKey(var5.method_5628()))) {
               class_243 var7 = field0796.field_1724.method_33571();
               if (!(var6.method_5829().method_49271(var7) > class_3532.method_33723(this.field0985.method0492().doubleValue()))
                  && field0796.field_1687.method_8621().method_11952(var6.method_24515())
                  && (
                     BlockPlacementHelper.method1301(var6.method_5829().method_1005())
                        || !this.field0426.method0492()
                           && !(var6.method_5829().method_49271(var7) > class_3532.method_33723(this.field0190.method0492().doubleValue()))
                  )) {
                  Suicide var8 = Suicide.method1721();
                  if (var8 == null || !var8.method2195()) {
                     float var9 = DamageCalculator.method1142(field0796.field_1724, null, var6, this.field0894.method0492());
                     if (var9 > this.field1222.method0492()
                        || this.field0900.method0492() && var9 > field0796.field_1724.method_6032() + field0796.field_1724.method_6067()) {
                        continue;
                     }
                  }

                  boolean var15 = false;
                  Iterator var10 = var1.iterator();

                  while (true) {
                     if (var10.hasNext()) {
                        class_1657 var11 = (class_1657)var10.next();
                        class_238 var12 = EntityPositionHelper.method1193(var11, this.field0262.method0492().intValue());
                        float var13 = DamageCalculator.method1142(var11, var12, var6, this.field0894.method0492());
                        float var14 = this.method1186(var11, this.field1230.method0492());
                        if (var13 < var14
                              && var13 < var11.method_6032() + var11.method_6067()
                              && !(var13 * (1.0F + this.field1236.method0492()) >= var11.method_6032() + var11.method_6067())
                           || !(var13 > var3) && !(var13 > var11.method_6032() + var11.method_6067())) {
                           continue;
                        }

                        var2 = var6;
                        var3 = var13;
                        if (!(var13 > var11.method_6032() + var11.method_6067())) {
                           continue;
                        }

                        var15 = true;
                     }

                     if (var15) {
                        return var2;
                     }
                     break;
                  }
               }
            }
         }

         return var2;
      } else {
         return null;
      }
   }

   private AutoCrystal.RenderState method1258(class_2338 var1) {
      if (!this.field1709.method0492()) {
         return null;
      }

      if (field0796.field_1687 == null || field0796.field_1724 == null) {
         return null;
      }

      if (!this.method1677(false)
         && (
            this.field0918.method0492() != AutoCrystal.SwitchMode.field0588 && InventoryManager.method2154(class_1802.field_8301) != -1
               || field0796.field_1724.method_6047().method_7909() == class_1802.field_8301
               || field0796.field_1724.method_6079().method_7909() == class_1802.field_8301
         )) {
         List var2 = this.method2041();
         if (var2.isEmpty()) {
            return null;
         }

         class_2338 var3 = null;
         class_1657 var4 = null;
         List var5 = new ArrayList<>();
         float var6 = 0.0F;
         int var7 = 0;
         int var8 = CrystalPositionHelper.method0609(Math.max(this.field1097.method0492().doubleValue(), this.field1206.method0492().doubleValue()));
         class_2338 var9 = field0796.field_1724.method_24515();
         class_243 var10 = field0796.field_1724.method_33571();

         for (int var11 = 0; var11 < var8; var11++) {
            class_2382 var12 = CrystalPositionHelper.method0726(var11);
            class_2338 var13 = var9.method_10081(var12);
            if (!(var10.method_1025(class_243.method_24953(var13)) > class_3532.method_33723(this.field1097.method0492().doubleValue()))
               && field0796.field_1687.method_8621().method_11952(var13)
               && (
                  field0796.field_1687.method_8320(var13).method_26204() == class_2246.field_10540
                     || field0796.field_1687.method_8320(var13).method_26204() == class_2246.field_9987
               )
               && field0796.field_1687.method_8320(var13.method_10069(0, 1, 0)).method_26215()
               && (
                  this.field0880.method0492() != AutoCrystal.PlacementMode.field0021
                     || field0796.field_1687.method_8320(var13.method_10069(0, 2, 0)).method_26215()
               )
               && (
                  BlockPlacementHelper.method1301(class_243.method_24953(var13))
                     || !this.field0426.method0492()
                        && !(var10.method_1025(class_243.method_24953(var13)) > class_3532.method_33723(this.field1206.method0492().doubleValue()))
               )
               && !field0796.field_1687
                  .method_8335(null, new class_238(var13.method_10069(0, 1, 0)))
                  .stream()
                  .anyMatch(var0 -> var0.method_5805() && !(var0 instanceof class_1303) && !(var0 instanceof class_1511))) {
               int var14 = this.field1450.method0492().intValue();
               List var15 = field0796.field_1687
                  .method_8335(null, new class_238(var13.method_10069(0, 1, 0)))
                  .stream()
                  .filter(var1x -> var1x instanceof class_1511 var2 && var2.field_6012 >= 20 - var14 + 15)
                  .toList();
               Suicide var16 = Suicide.method1721();
               if (var16 == null || !var16.method2195()) {
                  float var17 = DamageCalculator.method1143(field0796.field_1724, null, var13, var1, this.field0894.method0492());
                  if (var17 > this.field1222.method0492()
                     || this.field0900.method0492() && var17 > field0796.field_1724.method_6032() + field0796.field_1724.method_6067()) {
                     continue;
                  }
               }

               boolean var23 = false;

               for (class_1657 var19 : var2) {
                  var7++;
                  class_238 var20 = EntityPositionHelper.method1193(var19, this.field0262.method0492().intValue());
                  float var21 = DamageCalculator.method1143(var19, var20, var13, var1, this.field0894.method0492());
                  float var22 = this.method1186(var19, this.field1230.method0492());
                  if (!(var21 < var22)
                     || !(var21 < var19.method_6032() + var19.method_6067())
                     || var21 * (1.0F + this.field1236.method0492()) >= var19.method_6032() + var19.method_6067()) {
                     if (var1 == null && !var15.isEmpty()) {
                        var5.add(var15.get(0));
                        break;
                     }

                     if (var21 > var6 || var21 > var19.method_6032() + var19.method_6067()) {
                        var3 = var13;
                        var4 = var19;
                        var6 = var21;
                        if (var21 > var19.method_6032() + var19.method_6067()) {
                           var23 = true;
                           break;
                        }
                     }
                  }
               }

               if (var23) {
                  break;
               }
            }
         }

         return var3 == null
            ? new AutoCrystal.RenderState(null, null, var5, null, 0.0F, var7)
            : new AutoCrystal.RenderState(var3, var4, var5, var1, var6, var7);
      } else {
         return null;
      }
   }

   private void method1300(class_243 var1) {
      Rotation var2 = RotationHelper.method1296(var1.method_1020(field0796.field_1724.method_33571()));
      if (this.field0389.method0492()) {
         float var3 = DaamkyClient.method2004().method2186().method2047();
         float var4 = class_3532.method_15393(var3 - var2.method2047());
         float var5 = this.field0360.method0492();
         if (Math.abs(var4) > var5) {
            float var6 = (var4 > 0.0F ? -1 : 1) * var5;
            var2 = new Rotation(var3 + var6, var2.method1762());
         }
      }

      RotationHandler var7 = new RotationHandler(new LinearRotationStrategy(), true, true);
      RotationManager.field0618.method0875(var2, var7, RotationPriority.field0778, this);
   }

   private void method1174(class_1511 var1) {
      int var2 = field0796.field_1724.method_31548().field_7545;
      boolean var3 = false;
      if (this.field0469.method0492() != AutoCrystal.AntiWeaknessMode.field0578 && field0796.field_1724.method_6059(class_1294.field_5911)) {
         int var4 = InventoryManager.method0147(0, 8);
         if (var4 != -1) {
            if (this.field0469.method0492() == AutoCrystal.AntiWeaknessMode.field0013) {
               InventoryManager.method0808(InventoryManager.SwitchMode.field0613, var4, var2);
            } else {
               InventoryManager.method0808(InventoryManager.SwitchMode.field0046, var4, var2);
            }

            var3 = true;
         }
      }

      this.field1360.put(var1.method_5628(), System.currentTimeMillis());
      field0796.method_1562().method_52787(class_2824.method_34206(var1, field0796.field_1724.method_5715()));
      field0796.method_1562().method_52787(new class_2879(class_1268.field_5808));
      this.method2134("ATTACK id=" + var1.method_5628() + " @ " + var1.method_24515().method_23854());
      if (var3) {
         if (this.field0469.method0492() == AutoCrystal.AntiWeaknessMode.field0013) {
            InventoryManager.method0169(InventoryManager.SwitchMode.field0613, 0, var2);
         } else {
            InventoryManager.method0169(InventoryManager.SwitchMode.field0046, 0, var2);
         }
      }

      this.field1321.method1634();
   }

   private void method0278(class_2338 var1) {
      class_1268 var2 = field0796.field_1724.method_6079().method_7909() == class_1802.field_8301 ? class_1268.field_5810 : class_1268.field_5808;
      class_2350 var3 = CrystalPositionHelper.method1279(var1, true);
      class_243 var4 = CrystalPositionHelper.method1273(var1, var3);
      class_3965 var5 = new class_3965(var4, var3, var1, false);
      this.field1354.put(var1, System.currentTimeMillis());
      this.field1364.put(var1, System.currentTimeMillis());
      SequencedPacketSender.method1534(var2x -> new class_2885(var2, var5, var2x));
      this.method2134("PLACE @ " + var1.method_23854() + " hand=" + var2 + " dir=" + var3);
      switch ((AutoCrystal.SwingMode)this.field1376.method0492()) {
         case field0582:
            field0796.field_1724.method_6104(var2);
         case field0017:
         default:
            break;
         case field1421:
            field0796.method_1562().method_52787(new class_2879(var2));
            break;
         case field0963:
            field0796.field_1724.method_6104(class_1268.field_5808);
            break;
         case field0763:
            field0796.field_1724.method_6104(class_1268.field_5810);
            break;
         case field1248:
            field0796.field_1724.method_6104(class_1268.field_5808);
            field0796.field_1724.method_6104(class_1268.field_5810);
      }

      this.field1316.method1634();
   }

   private void method0738(int var1, int var2) {
      switch ((AutoCrystal.SwitchMode)this.field0918.method0492()) {
         case field0023:
            InventoryManager.method0808(InventoryManager.SwitchMode.field0613, var1, var2);
            break;
         case field1426:
            InventoryManager.method0808(InventoryManager.SwitchMode.field0046, var1, var2);
            break;
         case field0965:
            InventoryManager.method0808(InventoryManager.SwitchMode.field1440, var1, var2);
      }
   }

   private void method0148(int var1, int var2) {
      switch ((AutoCrystal.SwitchMode)this.field0918.method0492()) {
         case field0023:
            InventoryManager.method0169(InventoryManager.SwitchMode.field0613, var1, var2);
            break;
         case field1426:
            InventoryManager.method0169(InventoryManager.SwitchMode.field0046, var1, var2);
            break;
         case field0965:
            InventoryManager.method0169(InventoryManager.SwitchMode.field1440, var1, var2);
      }
   }

   private List<class_1657> method2041() {
      List var1 = new ArrayList<>();
      Suicide var2 = Suicide.method1721();
      if (var2 != null && var2.method2195()) {
         var1.add(field0796.field_1724);
         return var1;
      }

      FriendManager var3 = DaamkyClient.method2004().method1608();

      for (class_1657 var5 : field0796.field_1687.method_18456()) {
         if (var5 != field0796.field_1724
            && var5.method_5805()
            && !(field0796.field_1724.method_5858(var5) > class_3532.method_33723(this.field0234.method0492().doubleValue()))
            && (var3 == null || !var3.method2135(var5.method_5477().getString()))) {
            var1.add(var5);
         }
      }

      return var1;
   }

   private boolean method1677(boolean var1) {
      if (!field0796.field_1724.method_6115()) {
         return false;
      } else {
         AutoCrystal.EatingMode var2 = this.field1675.method0492();
         if (var2 == AutoCrystal.EatingMode.field0581) {
            return true;
         } else {
            return var1 && var2 == AutoCrystal.EatingMode.field1420 ? true : !var1 && var2 == AutoCrystal.EatingMode.field0016;
         }
      }
   }

   private float method1186(class_1657 var1, float var2) {
      if (var1 == null) {
         return var2;
      }

      if (this.field0292.method0492()) {
         int var3 = this.field1144.method0492().intValue();
         int var4 = this.method0462() / 50;
         boolean var5 = field0796.field_1687
            .method_8335(null, new class_238(var1.method_24515()).method_1014(1.0))
            .stream()
            .anyMatch(
               var2x -> var2x instanceof class_1542 var3
                  && var3.method_6983().method_7909() == class_1802.field_8281
                  && var3.method_6983().method_7947() >= 8
                  && var3.field_6012 <= 2 + var4 + (20 - var3)
            );
         boolean var6 = field0796.field_1687
            .method_8335(null, new class_238(field0796.field_1724.method_24515()).method_1014(1.0))
            .stream()
            .anyMatch(
               var2x -> var2x instanceof class_1542 var3
                  && var3.method_6983().method_7909() == class_1802.field_8281
                  && var3.method_6983().method_7947() >= 8
                  && var3.field_6012 <= 2 + var4 + (20 - var3)
            );
         if (var5 && !var6) {
            return 2.0F;
         }
      }

      if (this.field1768.method0492() == AutoCrystal.FacePlaceMode.field0579) {
         return var2;
      }

      if (this.field1177.method0492() == AutoCrystal.FacePlaceSpeedMode.field0580 || this.field1326.method1646(this.field1167.method0492().longValue() * 50L)) {
         if (this.field1768.method0492() == AutoCrystal.FacePlaceMode.field1419) {
            return Math.min(var2, 2.0F);
         }

         if (this.field1768.method0492() == AutoCrystal.FacePlaceMode.field0014
            && this.field1188.method0492()
            && var1.method_6032() + var1.method_6067() <= this.field1122.method0492()) {
            return Math.min(var2, 2.0F);
         }

         if (this.field1768.method0492() == AutoCrystal.FacePlaceMode.field0014 && this.field1114.method0492()) {
            for (class_1799 var8 : var1.method_5661()) {
               if (var8 != null && var8.method_7909() instanceof class_1738) {
                  int var9 = var8.method_7936();
                  if (var9 > 0) {
                     int var10 = (int)Math.round((var9 - var8.method_7919()) * 100.0 / var9);
                     if (var10 <= this.field1132.method0492().intValue()) {
                        return Math.min(var2, 2.0F);
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   private int method0462() {
      try {
         if (field0796.method_1562() == null) {
            return 0;
         }

         class_640 var1 = field0796.method_1562().method_2871(field0796.field_1724.method_5667());
         return var1 == null ? 0 : var1.method_2959();
      } catch (Throwable var2) {
         return 0;
      }
   }

   @Override
   public void method2078() {
      this.field0935 = null;
      this.field0950 = null;
      this.field1360.clear();
      this.field1354.clear();
      this.field1364.clear();
      this.field0415 = false;
      this.field0410 = false;
      this.field0421 = null;
      this.field0373 = null;
      this.field0380 = null;
      this.field0449.method2078();
      this.field0444 = -100000;
      this.field0453 = 0;
      super.method2078();
   }

   @Generated
   public class_1657 method1731() {
      return this.field0421;
   }

   public enum AntiWeaknessMode implements DisplayNamed {
      field0578("None"),
      field0013("Normal"),
      field1418("Silent");

      private final String field1030;

      AntiWeaknessMode(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }

   public enum FacePlaceMode implements DisplayNamed {
      field0579("None"),
      field0014("Dynamic"),
      field1419("Always");

      private final String field1030;

      FacePlaceMode(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }

   public enum FacePlaceSpeedMode implements DisplayNamed {
      field0580("Normal"),
      field0015("Custom");

      private final String field1504;

      FacePlaceSpeedMode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }

   public enum EatingMode implements DisplayNamed {
      field0581("None"),
      field0016("Attack"),
      field1420("Place"),
      field0962("Both");

      private final String field0791;

      EatingMode(String var3) {
         this.field0791 = var3;
      }

      @Override
      public String method0557() {
         return this.field0791;
      }
   }

   public enum SwingMode implements DisplayNamed {
      field0582("Default"),
      field0017("None"),
      field1421("Packet"),
      field0963("Mainhand"),
      field0763("Offhand"),
      field1248("Both");

      private final String field0336;

      SwingMode(String var3) {
         this.field0336 = var3;
      }

      @Override
      public String method0557() {
         return this.field0336;
      }
   }

   public enum SequentialMode implements DisplayNamed {
      field0583("None"),
      field0018("Strict"),
      field1422("Strong");

      private final String field1030;

      SequentialMode(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }

   public enum RotationMode implements DisplayNamed {
      field0584("None"),
      field0019("Normal"),
      field1423("Packet");

      private final String field1030;

      RotationMode(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }

   public enum RenderMode implements DisplayNamed {
      field0585("None"),
      field0020("Fill"),
      field1424("Outline"),
      field0964("Both");

      private final String field0791;

      RenderMode(String var3) {
         this.field0791 = var3;
      }

      @Override
      public String method0557() {
         return this.field0791;
      }
   }

   public enum PlacementMode implements DisplayNamed {
      field0586("Native"),
      field0021("Protocol");

      private final String field1504;

      PlacementMode(String var3) {
         this.field1504 = var3;
      }

      @Override
      public String method0557() {
         return this.field1504;
      }
   }

   private static class RenderState {
      class_2338 field0733;
      class_1657 field0152;
      List<class_1297> field1508;
      class_2338 field1041;
      float field0758;
      int field1243;

      RenderState(class_2338 var1, class_1657 var2, List<class_1297> var3, class_2338 var4, float var5, int var6) {
         this.field0733 = var1;
         this.field0152 = var2;
         this.field1508 = var3;
         this.field1041 = var4;
         this.field0758 = var5;
         this.field1243 = var6;
      }

      AutoCrystal.RenderState method0533() {
         return new AutoCrystal.RenderState(this.field0733, this.field0152, this.field1508, this.field1041, this.field0758, this.field1243);
      }
   }

   public enum GodSwingMode implements DisplayNamed {
      field0587("None"),
      field0022("Normal"),
      field1425("Strict");

      private final String field1030;

      GodSwingMode(String var3) {
         this.field1030 = var3;
      }

      @Override
      public String method0557() {
         return this.field1030;
      }
   }

   public enum SwitchMode implements DisplayNamed {
      field0588("None"),
      field0023("Normal"),
      field1426("Silent"),
      field0965("AltSwap");

      private final String field0791;

      SwitchMode(String var3) {
         this.field0791 = var3;
      }

      @Override
      public String method0557() {
         return this.field0791;
      }
   }
}
