package aethereal;

import meteordevelopment.orbit.EventHandler;

public final class FakePlayer extends Module {
   private static final int field0004 = 5;
   private final TextSetting field1497;
   private final BooleanSetting field0970;
   private final BooleanSetting field0184;
   private final FloatSetting field0470;
   private int field1615;
   private boolean field1574;

   public FakePlayer() {
      super("FakePlayer", ModuleCategory.field1470, "Spawns a fake player entity for testing");
      this.method1013("Спавнит фейкового игрока");
      this.field1497 = new TextSetting("settings.fakeplayer.name", "Player", false)
         .method1007("Name")
         .method0210("Name of the fake player entity")
         .method2130("Имя");
      this.field0970 = new BooleanSetting("settings.fakeplayer.copyinventory", true)
         .method1007("Copy Inventory")
         .method0210("Copy your inventory to the fake player")
         .method2130("Копировать инвентарь");
      this.field0184 = new BooleanSetting("settings.fakeplayer.syncinventory", true)
         .method1007("Sync Inventory")
         .method0210("Keep the fake player inventory in sync")
         .method2130("Синхронизировать инвентарь");
      this.field0470 = new FloatSetting("settings.fakeplayer.health", 20.0F, 1.0F, 100.0F, 1.0F)
         .method1007("Health")
         .method0210("Health points for the fake player")
         .method2130("Здоровье");
      this.field1615 = 0;
      this.field1574 = false;
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field1574 = false;
      if (this.method1692()) {
         this.method1735();
      }
   }

   @Override
   public void method2078() {
      try {
         if (field0796.field_1687 != null) {
            FakePlayerHelper.method0025();
         }
      } catch (Exception var2) {
      }

      this.field1574 = false;
      super.method2078();
   }

   @EventHandler
   public void onClientTick(ClientTickEvent var1) {
      if (this.field0751 && (field0796.field_1724 == null || field0796.field_1687 == null)) {
         this.method0345(false);
      }
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (this.field0751 && field0796.field_1724 != null && field0796.field_1687 != null) {
         if (!this.field1574 || FakePlayerHelper.method1763() == 0) {
            this.method1735();
         }

         if (this.method1755()) {
            this.field1615++;
            if (this.field1615 >= 5) {
               this.field1615 = 0;
               FakePlayerHelper.method0578();
            }
         }
      }
   }

   private void method1735() {
      if (field0796.field_1724 != null && field0796.field_1687 != null) {
         FakePlayerHelper.method1021(this.field1497.method0492(), this.field0470.method0492(), this.field0970.method0492());
         this.field1574 = true;
      }
   }

   private boolean method1692() {
      return !method1974();
   }

   private boolean method1755() {
      return this.field0751 && this.field0184.method0492() && this.method1692() && FakePlayerHelper.method1763() > 0;
   }
}
