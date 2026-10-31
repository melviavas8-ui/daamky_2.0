package aethereal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Generated;
import meteordevelopment.orbit.EventHandler;

public class ModuleManager implements MinecraftAccess {
   private final List<Module> field0719 = new ArrayList<>();

   public ModuleManager() {
      DaamkyClient.method2004().method2072().subscribe(this);
      this.method1590(
         new AntiBot(),
         new Aura(),
         new AutoArmor(),
         new AutoPotions(),
         new AutoSwap(),
         new AutoTotem(),
         new AutoWeb(),
         new Criticals(),
         new CrossbowRapid(),
         new CrystalHelper(),
         new Knockback(),
         new NoInteract(),
         new NoFriendDamage(),
         new ShiftTap(),
         new TargetPearl(),
         new TriggerBot(),
         new Velocity(),
         new AirStuck(),
         new AutoDodge(),
         new Blink(),
         new ElytraMotion(),
         new ElytraTarget(),
         new Flight(),
         new Glide(),
         new GuiMove(),
         new NoSlow(),
         new NoWeb(),
         new Speed(),
         new Spider(),
         new Sprint(),
         new SuperFirework(),
         new TargetStrafe(),
         new SpeedMine(),
         new Tracers(),
         new AuctionHelper(),
         new Arrows(),
         new AspectRatio(),
         new BetterF5(),
         new Waypoint(),
         new CustomFOG(),
         new BlockOverlay(),
         new BlockESP(),
         new Cape(),
         new Chams(),
         new ClickGUI(),
         new Constellation(),
         new Crosshair(),
         new Ambience(),
         new GeometricShapes(),
         new NewHUD(),
         new ModifyGlint(),
         new NameTags(),
         new NoRender(),
         new Trails(),
         new PopChams(),
         new Shaders(),
         new ItemChams(),
         new ProjectilePrediction(),
         new TargetESP(),
         new ESP(),
         new ViewModel(),
         new EmberHands(),
         new FullBright(),
         new AntiInvisible(),
         new SwingAnimation(),
         new BetterChat(),
         new GappleIndicator(),
         new ProjectileTrails(),
         new AutoDuel(),
         new AutoExp(),
         new AutoLeave(),
         new AutoTpAccept(),
         new ChestStealer(),
         new ClickPearl(),
         new ElytraHelper(),
         new FakePlayer(),
         new FreeCam(),
         new ItemScroller(),
         new MultiTask(),
         new NameProtect(),
         new NoPush(),
         new ServerAssist(),
         new ServerRPSpoofer(),
         new TabExpert(),
         new UseTracker(),
         new AutoRespawn(),
         new AutoTool(),
         new AutoUse(),
         new AutoJoin(),
         new AntiAFK(),
         new ItemFixSwap(),
         new FreeLook(),
         new NoDelay(),
         new NoTrace(),
         new Nuker()
      );

      for (Module var2 : this.field0719) {
         try {
            for (Field var6 : var2.getClass().getDeclaredFields()) {
               if (Setting.class.isAssignableFrom(var6.getType())) {
                  var6.setAccessible(true);
                  Setting var7 = (Setting<?>)var6.get(var2);
                  if (var7 != null) {
                     var7.method0889(var2);
                     if (!var2.method1914().contains(var7)) {
                        var2.method1914().add(var7);
                     }
                  }
               }
            }
         } catch (Exception var8) {
         }
      }
   }

   private void method1590(Module... var1) {
      this.field0719.addAll(List.of(var1));
   }

   @EventHandler
   public void onKey(KeyEvent var1) {
      if (!Module.method1974() && field0796.field_1755 == null) {
         if (var1.method1604() == 1) {
            for (Module var3 : this.field0719) {
               KeyBind var4 = var3.method2259();
               if (!var4.method0579() && !var4.method1813() && var4.method2048() == var1.method1763()) {
                  var3.method1812();
               }
            }
         }
      }
   }

   @EventHandler
   public void onMouse(MouseEvent var1) {
      if (!Module.method1974() && field0796.field_1755 == null) {
         if (var1.method1604() == 1) {
            for (Module var3 : this.field0719) {
               KeyBind var4 = var3.method2259();
               if (!var4.method0579() && var4.method1813() && var4.method2048() == var1.method1763()) {
                  var3.method1812();
               }
            }
         }
      }
   }

   public List<Module> method0893(ModuleCategory var1) {
      return this.field0719.stream().filter(var1x -> var1x.method2220() == var1).toList();
   }

   public List<ModuleCategory> method0559() {
      return Arrays.asList(ModuleCategory.values());
   }

   public <T extends Module> T method0976(Class<T> var1) {
      for (Module var3 : this.field0719) {
         if (var1.isInstance(var3)) {
            return (T)var3;
         }
      }

      return null;
   }

   public <T extends Module> T method0201(Class<T> var1) {
      return this.method0976(var1);
   }

   @Generated
   public List<Module> method0019() {
      return this.field0719;
   }
}
