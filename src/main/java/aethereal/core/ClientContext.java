package aethereal;

import lombok.Generated;
import meteordevelopment.orbit.IEventBus;

public class ClientContext {
   private final String field0715 = Session.username();
   private final String field0136 = Session.expire();
   private final int field1411 = Integer.parseInt(Session.uid());
   private final String field1030 = Session.role();
   private final String field0791 = Session.hwid();
   private final String field1269 = "";
   private final String field0336 = "1.0.3";
   private FriendManager field0191;
   private WaypointManager field0485;
   private StaffManager field1639;
   private ClickGuiScreen field1545;
   private IEventBus field1731;
   private ModuleManager field1151;
   private MediaSessionManager field1102;
   private ConfigManager field1204;
   private TargetPositionTracker field0877;
   private NetworkTickTracker field0831;
   private CommandManager field0925;
   private CombatController field1337;
   private PlayerMotionController field1304;

   public void method1111(IEventBus ieventbus) {
      this.field1731 = ieventbus;
      this.field0191 = new FriendManager();
      this.field0485 = new WaypointManager();
      this.field1639 = new StaffManager();
      this.field1151 = new ModuleManager();
      this.field1102 = new MediaSessionManager();
      this.field1545 = new ClickGuiScreen();
      this.field0831 = new NetworkTickTracker();
      this.field1204 = new ConfigManager();
      this.field0925 = new CommandManager();
      this.field1639 = new StaffManager();
      this.field0877 = new TargetPositionTracker();
      this.field1337 = new CombatController();
      this.field1304 = new PlayerMotionController();
      ieventbus.subscribe(this.field1304);
   }

   @Generated
   public String method0557() {
      return this.field0715;
   }

   @Generated
   public String method0017() {
      return this.field0136;
   }

   @Generated
   public int method2048() {
      return this.field1411;
   }

   @Generated
   public String method1791() {
      return this.field1030;
   }

   @Generated
   public String method1619() {
      return this.field0791;
   }

   @Generated
   public String method1961() {
      return this.field1269;
   }

   @Generated
   public String method0423() {
      return "1.0.3";
   }

   @Generated
   public FriendManager method0363() {
      return this.field0191;
   }

   @Generated
   public WaypointManager method0490() {
      return this.field0485;
   }

   @Generated
   public StaffManager method2221() {
      return this.field1639;
   }

   @Generated
   public ClickGuiScreen method2185() {
      return this.field1545;
   }

   @Generated
   public IEventBus method2265() {
      return this.field1731;
   }

   @Generated
   public ModuleManager method1912() {
      return this.field1151;
   }

   @Generated
   public MediaSessionManager method1886() {
      return this.field1102;
   }

   @Generated
   public ConfigManager method1931() {
      return this.field1204;
   }

   @Generated
   public TargetPositionTracker method1707() {
      return this.field0877;
   }

   @Generated
   public NetworkTickTracker method1684() {
      return this.field0831;
   }

   @Generated
   public CommandManager method1745() {
      return this.field0925;
   }

   @Generated
   public CombatController method2022() {
      return this.field1337;
   }

   @Generated
   public PlayerMotionController method2007() {
      return this.field1304;
   }
}
