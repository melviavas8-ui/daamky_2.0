package aethereal;

public class NoRender extends Module {
   public MultiSelectSetting field0089 = new MultiSelectSetting(
         "norender.elements",
         new BooleanSetting("norender.fire", false).method1007("Fire").method0210("Hide fire overlay on screen").method2130("Скрыть наложение огня на экране"),
         new BooleanSetting("norender.hurtcam", false)
            .method1007("Hurt Cam")
            .method0210("Disable screen shake when damaged")
            .method2130("Отключить тряску экрана при получении урона"),
         new BooleanSetting("norender.totem", false)
            .method1007("Totem")
            .method0210("Hide totem pop animation")
            .method2130("Скрыть анимацию срабатывания тотема"),
         new BooleanSetting("norender.potions", false)
            .method1007("Potions")
            .method0210("Hide potion effect particles")
            .method2130("Скрыть частицы эффектов зелий"),
         new BooleanSetting("norender.scoreboard", false)
            .method1007("Scoreboard")
            .method0210("Hide the scoreboard sidebar")
            .method2130("Скрыть боковую панель счёта"),
         new BooleanSetting("norender.bossbar", false).method1007("Boss Bar").method0210("Hide boss health bars").method2130("Скрыть полоски здоровья боссов"),
         new BooleanSetting("norender.underwater", false)
            .method1007("Underwater")
            .method0210("Hide underwater overlay and fog")
            .method2130("Скрыть подводное наложение и туман"),
         new BooleanSetting("norender.portal", false)
            .method1007("Portal")
            .method0210("Hide nether portal overlay")
            .method2130("Скрыть наложение портала Нижнего мира"),
         new BooleanSetting("norender.blindness", false).method1007("Blindness").method0210("Remove blindness effect").method2130("Убрать эффект слепоты"),
         new BooleanSetting("norender.nausea", false).method1007("Nausea").method0210("Remove nausea/wobble effect").method2130("Убрать эффект тошноты"),
         new BooleanSetting("norender.blockoverlay", false)
            .method1007("Block Overlay")
            .method0210("Hide overlay when head is inside a block")
            .method2130("Скрыть наложение, когда голова внутри блока"),
         new BooleanSetting("norender.armor", false).method1007("Armor").method0210("Hide armor on entities").method2130("Скрыть броню на сущностях"),
         new BooleanSetting("norender.explosions", false).method1007("Explosions").method0210("Hide explosion particles").method2130("Скрыть частицы взрывов"),
         new BooleanSetting("norender.signtext", false).method1007("Sign Text").method0210("Hide text on signs").method2130("Скрыть текст на табличках"),
         new BooleanSetting("norender.vignette", false)
            .method1007("Vignette")
            .method0210("Hide screen edge vignette")
            .method2130("Скрыть виньетку по краям экрана"),
         new BooleanSetting("norender.pumpkin", false)
            .method1007("Pumpkin")
            .method0210("Hide pumpkin head overlay")
            .method2130("Скрыть наложение тыквы на голове"),
         new BooleanSetting("norender.snow", false).method1007("Snow").method0210("Hide snow weather particles").method2130("Скрыть частицы снегопада"),
         new BooleanSetting("norender.rain", false).method1007("Rain").method0210("Hide rain weather rendering").method2130("Скрыть дождь"),
         new BooleanSetting("norender.itemframes", false).method1007("Frames").method0210("Hide item frames").method2130("Скрыть рамки"),
         new BooleanSetting("norender.camera", false)
            .method1007("Camera")
            .method0210("Disable third-person camera collision with blocks")
            .method2130("Убирает блоки от камеры в F5")
      )
      .method1007("Elements")
      .method0210("Render effects to disable")
      .method2130("Типы");

   public NoRender() {
      super("NoRender", ModuleCategory.field1004, "Disables various render effects for performance");
      this.method1013("Отключает различные прикольчики");
   }

   public boolean method1736() {
      return this.method2195() && this.field0089.method0439("norender.fire").method0492();
   }

   public boolean method1692() {
      return this.method2195() && this.field0089.method0439("norender.hurtcam").method0492();
   }

   public boolean method1755() {
      return this.method2195() && this.field0089.method0439("norender.totem").method0492();
   }

   public boolean method2030() {
      return this.method2195() && this.field0089.method0439("norender.potions").method0492();
   }

   public boolean method2016() {
      return this.method2195() && this.field0089.method0439("norender.scoreboard").method0492();
   }

   public boolean method2044() {
      return this.method2195() && this.field0089.method0439("norender.bossbar").method0492();
   }

   public boolean method0472() {
      return this.method2195() && this.field0089.method0439("norender.portal").method0492();
   }

   public boolean method0458() {
      return this.method2195() && this.field0089.method0439("norender.underwater").method0492();
   }

   public boolean method0480() {
      return this.method2195() && this.field0089.method0439("norender.blindness").method0492();
   }

   public boolean method0406() {
      return this.method2195() && this.field0089.method0439("norender.nausea").method0492();
   }

   public boolean method0399() {
      return this.method2195() && this.field0089.method0439("norender.blockoverlay").method0492();
   }

   public boolean method0411() {
      return this.method2195() && this.field0089.method0439("norender.armor").method0492();
   }

   public boolean method0522() {
      return this.method2195() && this.field0089.method0439("norender.explosions").method0492();
   }

   public boolean method0517() {
      return this.method2195() && this.field0089.method0439("norender.signtext").method0492();
   }

   public boolean method0528() {
      return this.method2195() && this.field0089.method0439("norender.vignette").method0492();
   }

   public boolean method2247() {
      return this.method2195() && this.field0089.method0439("norender.pumpkin").method0492();
   }

   public boolean method2244() {
      return this.method2195() && this.field0089.method0439("norender.snow").method0492();
   }

   public boolean method2252() {
      return this.method2195() && this.field0089.method0439("norender.rain").method0492();
   }

   public boolean method2208() {
      return this.method2195() && this.field0089.method0439("norender.itemframes").method0492();
   }

   public boolean method2203() {
      return this.method2195() && this.field0089.method0439("norender.camera").method0492();
   }
}
