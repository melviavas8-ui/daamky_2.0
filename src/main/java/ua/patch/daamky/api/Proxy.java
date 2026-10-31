package ua.patch.daamky.api;

import aethereal.DaamkyClient;
import net.fabricmc.api.ModInitializer;

public class Proxy implements ModInitializer {
   DaamkyClient field0573 = new DaamkyClient();

   public void onInitialize() {
      this.field0573.method0578();
   }
}
