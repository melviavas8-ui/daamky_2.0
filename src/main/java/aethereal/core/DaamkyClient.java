package aethereal;

import lombok.Generated;
import meteordevelopment.orbit.IEventBus;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.impl.FabricLoaderImpl;
import net.minecraft.class_2960;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DaamkyClient implements MinecraftAccess {
   @Generated
   private static final Logger field0218 = LogManager.getLogger(DaamkyClient.class);
   static DaamkyClient field0573;
   public static final String field0136 = "daamky";
   ClientContext field1438;
   long field0959;

   public void method0578() {
      field0218.info("[Daamky] hello initialization.");
      ClientBootstrap.method0790(this);
      field0218.info("[Daamky] successfully initialized for {} ms.", System.currentTimeMillis() - this.field0959);
   }

   public static void method0025() {
      ShaderCache.method0550().method0025();
      Fonts.method0578();
      ShaderRegistry.method0578();
      ServerEnvironment.method0578();
      ClientTickDispatcher.method0578();
      RemoteAvatarService.method0025();
   }

   public IEventBus method2072() {
      return this.field1438.method2265();
   }

   public ModuleManager method1783() {
      return this.field1438.method1912();
   }

   public FriendManager method1608() {
      return this.field1438.method0363();
   }

   public WaypointManager method1956() {
      return this.field1438.method0490();
   }

   public StaffManager method0420() {
      return this.field1438.method2221();
   }

   public ClickGuiScreen method0359() {
      return this.field1438.method2185();
   }

   public MediaSessionManager method0489() {
      return this.field1438.method1886();
   }

   public ConfigManager method2216() {
      return this.field1438.method1931();
   }

   public NetworkTickTracker method2186() {
      return this.field1438.method1684();
   }

   public CommandManager method2257() {
      return this.field1438.method1745();
   }

   public TargetPositionTracker method1906() {
      return this.field1438.method1707();
   }

   public CombatController method1881() {
      return this.field1438.method2022();
   }

   public PlayerMotionController method1933() {
      return this.field1438.method2007();
   }

   public boolean method1736() {
      return FabricLoaderImpl.INSTANCE.isDevelopmentEnvironment();
   }

   public boolean method1692() {
      return FabricLoader.getInstance().isModLoaded("baritone") || FabricLoader.getInstance().isModLoaded("baritone-meteor");
   }

   public static class_2960 method1012(String s) {
      return class_2960.method_60655("daamky", s);
   }

   @Generated
   public ClientContext method1744() {
      return this.field1438;
   }

   @Generated
   public long method2020() {
      return this.field0959;
   }

   @Generated
   public static DaamkyClient method2004() {
      return field0573;
   }
}
