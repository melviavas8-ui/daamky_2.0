package aethereal;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_10142;
import net.minecraft.class_1309;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_286;
import net.minecraft.class_287;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3481;
import net.minecraft.class_2338.class_2339;
import net.minecraft.class_293.class_5596;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL11;

public class Ambience extends Module {
   private final BooleanSetting field0034 = new BooleanSetting("ambience.time", false)
      .method1007("Custom Time")
      .method0210("Override visual time of day")
      .method2130("Время суток");
   private final FloatSetting field1450 = new FloatSetting("ambience.timehour", 12.0F, 0.0F, 24.0F, 0.5F, this.field0034::method0492)
      .method1007("Hour")
      .method0210("Visual time of day (0=midnight, 12=noon)")
      .method2130("Изменить время суток на уровне клиента");
   private final BooleanSetting field0970 = new BooleanSetting("ambience.skyshader", false)
      .method1007("Sky Shader")
      .method0210("Replace the vanilla sky with a custom shader")
      .method2130("Шейдерное небо вместо ванильного");
   private final ColorSetting field0185 = new ColorSetting("ambience.skycolor1", 0, 0, 13, 255, this.field0970::method0492)
      .method1007("Sky Color 1")
      .method0210("Top sky gradient color")
      .method2130("Верхний цвет градиента");
   private final ColorSetting field0466 = new ColorSetting("ambience.skycolor2", 5, 3, 38, 255, this.field0970::method0492)
      .method1007("Sky Color 2")
      .method0210("Bottom sky gradient color")
      .method2130("Нижний цвет градиента");
   private final FloatSetting field1627 = new FloatSetting("ambience.nebulaintensity", 0.3F, 0.0F, 1.5F, 0.05F, this.field0970::method0492)
      .method1007("Nebula Intensity")
      .method0210("Nebula brightness")
      .method2130("Интенсивность туманности");
   private final ColorSetting field1550 = new ColorSetting("ambience.nebulacolor", 178, 71, 35, 255, this.field0970::method0492)
      .method1007("Nebula Color 1")
      .method0210("Warm nebula tint")
      .method2130("Тёплый цвет туманности");
   private final ColorSetting field1711 = new ColorSetting("ambience.nebulacolor2", 51, 0, 51, 255, this.field0970::method0492)
      .method1007("Nebula Color 2")
      .method0210("Cool nebula tint")
      .method2130("Холодный цвет туманности");
   private final ColorSetting field1143 = new ColorSetting("ambience.suncolor", 102, 102, 51, 255, this.field0970::method0492)
      .method1007("Sun Color")
      .method0210("Sun disc color")
      .method2130("Цвет солнца");
   private final FloatSetting field1097 = new FloatSetting("ambience.sunsize", 1.0F, 0.1F, 5.0F, 0.1F, this.field0970::method0492)
      .method1007("Sun Size")
      .method0210("Sun disc size (1.0 = default, larger = bigger softer disc)")
      .method2130("Размер солнечного диска");
   private final BooleanSetting field1201 = new BooleanSetting("ambience.tone", false)
      .method1007("Tone Grading")
      .method0210("Color tone post-process")
      .method2130("Цветовой постпроцесс");
   private final ColorSetting field0878 = new ColorSetting("ambience.tonetint", 255, 220, 180, 255, this.field1201::method0492)
      .method1007("Tone Tint")
      .method0210("Tint color")
      .method2130("Цвет тинта");
   private final FloatSetting field0836 = new FloatSetting("ambience.tonestrength", 0.25F, 0.0F, 1.0F, 0.05F, this.field1201::method0492)
      .method1007("Tint Strength")
      .method0210("Tint intensity")
      .method2130("Сила тинта");
   private final FloatSetting field0919 = new FloatSetting("ambience.tonesat", 1.15F, 0.0F, 2.0F, 0.05F, this.field1201::method0492)
      .method1007("Saturation")
      .method0210("Color saturation")
      .method2130("Насыщенность");
   private final FloatSetting field1341 = new FloatSetting("ambience.tonecontrast", 1.05F, 0.5F, 1.6F, 0.05F, this.field1201::method0492)
      .method1007("Contrast")
      .method0210("Image contrast")
      .method2130("Контраст");
   private final FloatSetting field1302 = new FloatSetting("ambience.tonebright", 1.0F, 0.4F, 1.6F, 0.05F, this.field1201::method0492)
      .method1007("Brightness")
      .method0210("Image brightness")
      .method2130("Яркость");
   private final FloatSetting field1377 = new FloatSetting("ambience.tonevignette", 0.4F, 0.0F, 1.0F, 0.05F, this.field1201::method0492)
      .method1007("Vignette")
      .method0210("Vignette darkness at edges")
      .method2130("Виньетка");
   private final FloatSetting field0393 = new FloatSetting("ambience.tonebloom", 0.3F, 0.0F, 1.5F, 0.05F, this.field1201::method0492)
      .method1007("Bloom")
      .method0210("Highlight bloom strength")
      .method2130("Свечение бликов");
   private final CustomSkyRenderer field0356 = new CustomSkyRenderer();
   private final ToneShaderRenderer field0427 = new ToneShaderRenderer();
   private final BooleanSetting field0259 = new BooleanSetting("ambience.starrain", false)
      .method1007("Star Rain")
      .method0210("Falling glowing star particles")
      .method2130("Падающие звёздные частицы");
   private final FloatSetting field0234 = new FloatSetting("ambience.starparticleamount", 400.0F, 50.0F, 1500.0F, 50.0F, this.field0259::method0492)
      .method1007("Particle Amount")
      .method0210("Max number of star particles")
      .method2130("Максимальное количество звёздных частиц");
   private final FloatSetting field0295 = new FloatSetting("ambience.starradius", 30.0F, 10.0F, 80.0F, 5.0F, this.field0259::method0492)
      .method1007("Radius")
      .method0210("Spawn radius around player")
      .method2130("Радиус вокруг игрока");
   private final FloatSetting field0529 = new FloatSetting("ambience.starsize", 0.06F, 0.01F, 0.3F, 0.01F, this.field0259::method0492)
      .method1007("Star Size")
      .method0210("Size of each falling star")
      .method2130("Размер падающей звезды");
   private final ColorSetting field0504 = new ColorSetting("ambience.starcolor", 255, 200, 255, 160, this.field0259::method0492)
      .method1882()
      .method1007("Star Color")
      .method0210("Color of falling stars")
      .method2130("Цвет");
   private final BooleanSetting field0550 = new BooleanSetting("ambience.sirocco", true)
      .method1007("Sirocco")
      .method0210("Hot desert wind: ash, embers, petals, streaks")
      .method2130("Жаркий ветер пустыни");
   private final FloatSetting field1676 = new FloatSetting("ambience.siroccocount", 800.0F, 20.0F, 800.0F, 20.0F, this.field0550::method0492)
      .method1007("Particle Count")
      .method0210("Max Sirocco particles")
      .method2130("Кол-во частиц");
   private final FloatSetting field1661 = new FloatSetting("ambience.siroccoradius", 12.0F, 8.0F, 60.0F, 2.0F, this.field0550::method0492)
      .method1007("Radius")
      .method0210("Spawn radius around player")
      .method2130("Радиус");
   private final FloatSetting field1693 = new FloatSetting("ambience.siroccowindangle", 360.0F, 0.0F, 360.0F, 5.0F, this.field0550::method0492)
      .method1007("Wind Angle")
      .method0210("Wind direction in degrees")
      .method2130("Угол ветра");
   private final FloatSetting field1593 = new FloatSetting("ambience.siroccowindspeed", 0.5F, 0.5F, 12.0F, 0.25F, this.field0550::method0492)
      .method1007("Wind Speed")
      .method0210("Wind speed")
      .method2130("Скорость ветра");
   private final ColorSetting field1581 = new ColorSetting("ambience.siroccocolor", 255, 0, 0, 255, this.field0550::method0492)
      .method1882()
      .method1007("Color")
      .method0210("Color for all Sirocco elements")
      .method2130("Цвет всех элементов");
   private static final float field1601 = 20.0F;
   private static final float field1753 = 20.0F;
   private static final float field1739 = 0.15F;
   private static final float field1766 = 0.06F;
   private static final float field1174 = 0.08F;
   private static final float field1164 = 15.0F;
   private final List<Ambience.SkyAnimation> field1191 = new ArrayList<>();
   private final List<Ambience.SkyMesh> field1124 = new ArrayList<>();
   private final List<Ambience.ColoredVertex> field1116 = new ArrayList<>();
   private final List<Ambience.SkyObject> field1134 = new ArrayList<>();
   private final List<Ambience.SkyMesh> field1232 = new ArrayList<>();
   private final List<Ambience.SkyMesh> field1224 = new ArrayList<>();
   private final List<Ambience.SkyLayer> field1238 = new ArrayList<>();
   private final List<Ambience.SkyLayer> field0902 = new ArrayList<>();
   private final float[] field0898 = new float[16];
   private final float[] field0908 = new float[16];
   private final float[] field0861 = new float[16];
   private final float[] field0854 = new float[16];
   private final float[] field0869 = new float[16];
   private final float[] field0947 = new float[16];
   private final float[] field0939 = new float[16];
   private final int[] field0954 = new int[16];
   private final List<Ambience.SkyMesh> field1359 = new ArrayList<>();
   private final Map<Integer, List<Ambience.SkyMesh>> field1354 = new HashMap<>();
   private final List<Ambience.SkyMesh> field1363 = new ArrayList<>();
   private final List<Ambience.SkyObject> field1323 = new ArrayList<>();
   private final List<class_2338> field1318 = new ArrayList<>();
   private int field1325 = 0;
   private final Random field1399 = new Random();
   private static final class_2960 field1393 = DaamkyClient.method1012("textures/glow.png");
   private static final class_2960 field1406 = DaamkyClient.method1012("textures/spark.png");
   private static final class_2960[] field0416 = new class_2960[]{
      DaamkyClient.method1012("textures/particles/2.png"),
      DaamkyClient.method1012("textures/particles/3.png"),
      DaamkyClient.method1012("textures/particles/4.png"),
      DaamkyClient.method1012("textures/particles/5.png"),
      DaamkyClient.method1012("textures/particles/7.png"),
      DaamkyClient.method1012("textures/particles/8.png"),
      DaamkyClient.method1012("textures/particles/9.png"),
      DaamkyClient.method1012("textures/particles/10.png"),
      DaamkyClient.method1012("textures/particles/13.png"),
      DaamkyClient.method1012("textures/particles/17.png"),
      DaamkyClient.method1012("textures/particles/20.png"),
      DaamkyClient.method1012("textures/particles/21.png"),
      DaamkyClient.method1012("textures/particles/23.png"),
      DaamkyClient.method1012("textures/particles/24.png"),
      DaamkyClient.method1012("textures/particles/25.png"),
      DaamkyClient.method1012("textures/particles/26.png"),
      DaamkyClient.method1012("textures/particles/28.png"),
      DaamkyClient.method1012("textures/particles/29.png"),
      DaamkyClient.method1012("textures/particles/30.png"),
      DaamkyClient.method1012("textures/particles/32.png"),
      DaamkyClient.method1012("textures/particles/33.png"),
      DaamkyClient.method1012("textures/particles/36.png"),
      DaamkyClient.method1012("textures/particles/42.png"),
      DaamkyClient.method1012("textures/particles/43.png"),
      DaamkyClient.method1012("textures/particles/44.png"),
      DaamkyClient.method1012("textures/particles/48.png"),
      DaamkyClient.method1012("textures/particles/49.png"),
      DaamkyClient.method1012("textures/particles/50.png"),
      DaamkyClient.method1012("textures/particles/51.png"),
      DaamkyClient.method1012("textures/particles/52.png"),
      DaamkyClient.method1012("textures/particles/55.png")
   };

   public Ambience() {
      super("Ambience", ModuleCategory.field1004, "Time of day and falling star effects");
      this.method1013("Разные изменения в игровом мире");
   }

   public boolean method1736() {
      return this.field0751 && this.field0034.method0492();
   }

   public long method1681() {
      float var1 = this.field1450.method0492();
      long var2 = (long)((var1 - 6.0F) * 1000.0F);
      if (var2 < 0L) {
         var2 += 24000L;
      }

      return var2;
   }

   public boolean method1755() {
      return this.field0751 && this.field0970.method0492();
   }

   public void method2029() {
      SkyOverlayRenderer.method0706(
         this.field1627.method0492(),
         this.field0185.method1726(),
         this.field0466.method1726(),
         this.field1550.method1726(),
         this.field1711.method1726(),
         this.field1143.method1726(),
         this.field1097.method0492()
      );
   }

   @EventHandler
   public void onRenderShaderPost(RenderShaderEvent.Pre var1) {
      if (!method1974()) {
         if (this.field1201.method0492()) {
            this.field0427.method0961(this.field0878.method1726());
            this.field0427.method0665(this.field0836.method0492());
            this.field0427.method2098(this.field0919.method0492());
            this.field0427.method1638(this.field1341.method0492());
            this.field0427.method1822(this.field1302.method0492());
            this.field0427.method0124(this.field1377.method0492());
            this.field0427.method1977(this.field0393.method0492());
            this.field0427.method0578();
         }
      }
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         if (this.field0259.method0492()) {
            this.method0457();
         }

         if (this.field0550.method0492()) {
            this.method2015();
         }
      }
   }

   private void method2015() {
      if (field0796.field_1724 != null) {
         class_243 var1 = field0796.field_1724.method_19538();
         class_243 var2 = this.method2042();
         int var3 = this.field1676.method0492().intValue();
         int var4 = Math.min(Math.max(0, var3 - this.field1134.size()), 6);

         for (int var5 = 0; var5 < var4; var5++) {
            this.method1329(var1, var2);
         }

         if (this.field1399.nextFloat() < 0.04F) {
            this.field1134.add(this.method1304(this.method1299(var1), 0.0));
         }

         if (this.field1399.nextFloat() < 0.008F) {
            int var13 = 2 + this.field1399.nextInt(2);

            for (int var6 = 0; var6 < var13; var6++) {
               this.field1134.add(this.method1304(this.method1299(var1), 0.0));
            }
         }

         if (this.field1399.nextFloat() < 0.05F) {
            this.field1134.add(this.method1994(var1));
         }

         if (this.field1399.nextFloat() < 0.018F) {
            this.field1134.add(this.method1667(var1));
         }

         if (this.field1399.nextFloat() < 0.014F) {
            this.field1134.add(this.method1864(var1));
         }

         if (this.field1399.nextFloat() < 0.18F) {
            this.field1134.add(this.method2162(var1));
         }

         if (--this.field1325 <= 0) {
            this.method0288(var1);
            this.field1325 = 40;
         }

         if (!this.field1318.isEmpty()) {
            if (this.field1399.nextFloat() < 0.22F) {
               class_2338 var14 = this.field1318.get(this.field1399.nextInt(this.field1318.size()));
               this.field1134.add(this.method1257(var14));
            }

            if (this.field1399.nextFloat() < 0.35F) {
               class_2338 var15 = this.field1318.get(this.field1399.nextInt(this.field1318.size()));
               this.field1134.add(this.method0275(var15));
            }
         }

         Iterator var16 = this.field1134.iterator();

         while (var16.hasNext()) {
            Ambience.SkyObject var17 = var16.next();
            this.method0789(var17, var2);
            double var7 = var17.field0002 - var1.field_1352;
            double var9 = var17.field0956 - var1.field_1350;
            double var11 = this.field1661.method0492().floatValue() * 2.5;
            if (var17.field1539 >= var17.field1705 || var7 * var7 + var9 * var9 > var11 * var11) {
               var16.remove();
            }
         }

         if (!this.field1323.isEmpty()) {
            this.field1134.addAll(this.field1323);
            this.field1323.clear();
         }
      }
   }

   private class_243 method2042() {
      double var1 = Math.toRadians(this.field1693.method0492().floatValue());
      double var3 = this.field1593.method0492().floatValue() / 20.0;
      return new class_243(Math.cos(var1) * var3, 0.0, Math.sin(var1) * var3);
   }

   private Ambience.SkyObjectType method0463() {
      List var1 = new ArrayList<>();
      var1.add(Ambience.SkyObjectType.field0006);
      var1.add(Ambience.SkyObjectType.field0006);
      var1.add(Ambience.SkyObjectType.field0006);
      var1.add(Ambience.SkyObjectType.field0006);
      var1.add(Ambience.SkyObjectType.field0006);
      var1.add(Ambience.SkyObjectType.field0569);
      var1.add(Ambience.SkyObjectType.field0569);
      var1.add(Ambience.SkyObjectType.field0569);
      var1.add(Ambience.SkyObjectType.field0569);
      var1.add(Ambience.SkyObjectType.field0180);
      var1.add(Ambience.SkyObjectType.field0180);
      var1.add(Ambience.SkyObjectType.field0461);
      var1.add(Ambience.SkyObjectType.field0461);
      var1.add(Ambience.SkyObjectType.field0461);
      var1.add(Ambience.SkyObjectType.field1413);
      var1.add(Ambience.SkyObjectType.field1413);
      var1.add(Ambience.SkyObjectType.field0761);
      var1.add(Ambience.SkyObjectType.field0761);
      var1.add(Ambience.SkyObjectType.field1199);
      var1.add(Ambience.SkyObjectType.field1199);
      return var1.get(this.field1399.nextInt(var1.size()));
   }

   private void method1329(class_243 var1, class_243 var2) {
      Ambience.SkyObjectType var3 = this.method0463();
      if (var3 != null) {
         double var4 = this.field1661.method0492().floatValue();
         double var6 = this.field1399.nextDouble() * 3.1415936675679283 * 2.0;
         double var8 = var4 * (0.3000000093137463 + this.field1399.nextDouble() * 0.700000000954607);
         double var10 = var1.field_1352 + Math.cos(var6) * var8;
         double var12 = var1.field_1350 + Math.sin(var6) * var8;
         double var14 = var1.field_1351 + 4.0 + this.field1399.nextDouble() * var4 * 0.700000000954607;
         Ambience.SkyObject var16 = new Ambience.SkyObject();
         var16.field0569 = var3;
         var16.field0002 = var10;
         var16.field1409 = var14;
         var16.field0956 = var12;
         var16.field0757 = var10;
         var16.field1241 = var14;
         var16.field0313 = var12;
         var16.field1196 = 0.4F + this.field1399.nextFloat() * 1.3F;
         switch (var3) {
            case field0569:
               var16.field1136 = (0.06F + this.field1399.nextFloat() * 0.08F) * var16.field1196;
               var16.field1087 = var16.field1136;
               var16.field1705 = 320 + this.field1399.nextInt(200);
               var16.field0176 = var2.field_1352 * (0.25 + this.field1399.nextDouble() * 0.3000000093137463) * var16.field1196
                  + (this.field1399.nextDouble() - 0.5) * 0.010000003294232477;
               var16.field1613 = var2.field_1350 * (0.25 + this.field1399.nextDouble() * 0.3000000093137463) * var16.field1196
                  + (this.field1399.nextDouble() - 0.5) * 0.010000003294232477;
               var16.field0457 = (this.field1399.nextDouble() - 0.6000000484588345) * 0.005999998620070951 * var16.field1196;
               var16.field0871 = this.field1399.nextFloat() * (float) (Math.PI * 2);
               var16.field0826 = (this.field1399.nextFloat() - 0.5F) * 0.03F;
               break;
            case field0006:
               var16.field1136 = (0.05F + this.field1399.nextFloat() * 0.06F) * var16.field1196;
               var16.field1087 = var16.field1136;
               var16.field1705 = 140 + this.field1399.nextInt(100);
               var16.field0176 = var2.field_1352 * 0.20000000981720706 * var16.field1196 + (this.field1399.nextDouble() - 0.5) * 0.010000003294232477;
               var16.field1613 = var2.field_1350 * 0.20000000981720706 * var16.field1196 + (this.field1399.nextDouble() - 0.5) * 0.010000003294232477;
               var16.field0457 = 0.005000002112303237 + this.field1399.nextDouble() * 0.011999996541534604;
               var16.field0871 = this.field1399.nextFloat();
               break;
            case field1413:
               var16.field1136 = (0.09F + this.field1399.nextFloat() * 0.07F) * var16.field1196;
               var16.field1087 = var16.field1136;
               var16.field1705 = 200 + this.field1399.nextInt(120);
               var16.field0176 = var2.field_1352 * 0.25 * var16.field1196 + (this.field1399.nextDouble() - 0.5) * 0.010000003294232477;
               var16.field1613 = var2.field_1350 * 0.25 * var16.field1196 + (this.field1399.nextDouble() - 0.5) * 0.010000003294232477;
               var16.field0457 = -0.005000001892210841 - this.field1399.nextDouble() * 0.010000003294232477;
               var16.field0871 = this.field1399.nextFloat() * (float) (Math.PI * 2);
               var16.field0826 = (this.field1399.nextFloat() - 0.5F) * 0.14F;
               break;
            case field0960:
            case field0317:
               return;
            case field0761:
               var16.field1136 = (0.05F + this.field1399.nextFloat() * 0.05F) * var16.field1196;
               var16.field1087 = var16.field1136;
               var16.field1705 = 160 + this.field1399.nextInt(80);
               var16.field0176 = var2.field_1352 * 0.15000000077852818 * var16.field1196 + (this.field1399.nextDouble() - 0.5) * 0.011999996541534604;
               var16.field1613 = var2.field_1350 * 0.15000000077852818 * var16.field1196 + (this.field1399.nextDouble() - 0.5) * 0.011999996541534604;
               var16.field0457 = -(0.03500000774912257 + this.field1399.nextDouble() * 0.04500000458047833) * var16.field1196;
               var16.field0871 = this.field1399.nextFloat() * (float) (Math.PI * 2);
               var16.field0826 = (this.field1399.nextFloat() - 0.5F) * 0.06F;
            case field1245:
            case field1617:
            case field1541:
            case field1707:
            case field1139:
            case field1090:
            default:
               break;
            case field0180:
               var16.field1136 = (0.55F + this.field1399.nextFloat() * 0.55F) * var16.field1196;
               var16.field1087 = var16.field1136;
               var16.field1705 = 320 + this.field1399.nextInt(220);
               var16.field0176 = var2.field_1352 * 0.4000000310832036 * var16.field1196 + (this.field1399.nextDouble() - 0.5) * 0.007999995405319822;
               var16.field1613 = var2.field_1350 * 0.4000000310832036 * var16.field1196 + (this.field1399.nextDouble() - 0.5) * 0.007999995405319822;
               var16.field0457 = 0.0029999991208599216 + this.field1399.nextDouble() * 0.007999995405319822;
               var16.field0871 = this.field1399.nextFloat() * (float) (Math.PI * 2);
               var16.field0826 = (this.field1399.nextFloat() - 0.5F) * 0.012F;
               break;
            case field0461:
               var16.field1136 = (0.025F + this.field1399.nextFloat() * 0.025F) * var16.field1196;
               var16.field1087 = var16.field1136;
               var16.field1705 = 140 + this.field1399.nextInt(120);
               var16.field0176 = (this.field1399.nextDouble() - 0.5) * 0.010000003294232477;
               var16.field1613 = (this.field1399.nextDouble() - 0.5) * 0.010000003294232477;
               var16.field0457 = 0.02500000005873084 + this.field1399.nextDouble() * 0.02500000005873084;
               var16.field0871 = this.field1399.nextFloat() * (float) (Math.PI * 2);
               break;
            case field1199:
               var16.field1136 = (0.1F + this.field1399.nextFloat() * 0.06F) * var16.field1196;
               var16.field1087 = var16.field1136;
               var16.field1705 = 180 + this.field1399.nextInt(140);
               var16.field0176 = var2.field_1352 * 0.35000012316843765 * var16.field1196 + (this.field1399.nextDouble() - 0.5) * 0.011999996541534604;
               var16.field1613 = var2.field_1350 * 0.35000012316843765 * var16.field1196 + (this.field1399.nextDouble() - 0.5) * 0.011999996541534604;
               var16.field0457 = -(0.029999992609062415 + this.field1399.nextDouble() * 0.02500000005873084) * var16.field1196;
               var16.field0871 = this.field1399.nextFloat() * (float) (Math.PI * 2);
               var16.field0826 = (this.field1399.nextFloat() - 0.5F) * 0.1F;
               int var17 = 9;
               var16.field0241 = new double[var17];
               var16.field0303 = new double[var17];
               var16.field0539 = new double[var17];

               for (int var18 = 0; var18 < var17; var18++) {
                  var16.field0241[var18] = var16.field0002;
                  var16.field0303[var18] = var16.field1409;
                  var16.field0539[var18] = var16.field0956;
               }
         }

         this.field1134.add(var16);
      }
   }

   private class_243 method1299(class_243 var1) {
      double var2 = this.field1661.method0492().floatValue();
      double var4 = this.field1399.nextDouble() * 3.1415936675679283 * 2.0;
      double var6 = var2 * (0.6000000484588345 + this.field1399.nextDouble() * 0.5);
      return new class_243(
         var1.field_1352 + Math.cos(var4) * var6,
         var1.field_1351 + 14.0 + this.field1399.nextDouble() * var2 * 0.4000000310832036,
         var1.field_1350 + Math.sin(var4) * var6
      );
   }

   private void method0288(class_243 var1) {
      this.field1318.clear();
      if (field0796.field_1687 != null) {
         int var2 = 14;
         int var3 = (int)var1.field_1352;
         int var4 = (int)var1.field_1351;
         int var5 = (int)var1.field_1350;
         class_2339 var6 = new class_2339();

         for (int var7 = -var2; var7 <= var2; var7 += 2) {
            for (int var8 = -4; var8 <= 10; var8 += 2) {
               for (int var9 = -var2; var9 <= var2; var9 += 2) {
                  var6.method_10103(var3 + var7, var4 + var8, var5 + var9);
                  class_2680 var10 = field0796.field_1687.method_8320(var6);
                  if (var10.method_26164(class_3481.field_15503)) {
                     this.field1318.add(var6.method_10062());
                  }
               }
            }
         }
      }
   }

   private Ambience.SkyObject method2162(class_243 var1) {
      double var2 = this.field1661.method0492().floatValue() * 0.75;
      Ambience.SkyObject var4 = new Ambience.SkyObject();
      var4.field0569 = Ambience.SkyObjectType.field1707;
      var4.field0002 = var1.field_1352 + (this.field1399.nextDouble() - 0.5) * var2 * 2.0;
      var4.field0956 = var1.field_1350 + (this.field1399.nextDouble() - 0.5) * var2 * 2.0;
      var4.field1409 = var1.field_1351 + 1.0 + this.field1399.nextDouble() * var2 * 0.8999997783500137;
      var4.field0757 = var4.field0002;
      var4.field1241 = var4.field1409;
      var4.field0313 = var4.field0956;
      var4.field1196 = 0.6F + this.field1399.nextFloat() * 1.0F;
      var4.field1136 = (0.018F + this.field1399.nextFloat() * 0.022F) * var4.field1196;
      var4.field1087 = 0.0F;
      var4.field1705 = 60 + this.field1399.nextInt(80);
      var4.field0176 = (this.field1399.nextDouble() - 0.5) * 0.005999998620070951;
      var4.field1613 = (this.field1399.nextDouble() - 0.5) * 0.005999998620070951;
      var4.field0457 = (this.field1399.nextDouble() - 0.5) * 0.003999997703356243;
      var4.field0871 = this.field1399.nextFloat() * 6.28F;
      return var4;
   }

   private Ambience.SkyObject method1257(class_2338 var1) {
      Ambience.SkyObject var2 = new Ambience.SkyObject();
      var2.field0569 = Ambience.SkyObjectType.field1139;
      var2.field0002 = var1.method_10263() + this.field1399.nextDouble();
      var2.field1409 = var1.method_10264() + this.field1399.nextDouble() * 0.6000000484588345;
      var2.field0956 = var1.method_10260() + this.field1399.nextDouble();
      var2.field0757 = var2.field0002;
      var2.field1241 = var2.field1409;
      var2.field0313 = var2.field0956;
      var2.field1196 = 1.0F;
      var2.field1136 = 0.07F + this.field1399.nextFloat() * 0.05F;
      var2.field1087 = var2.field1136;
      var2.field1705 = 160 + this.field1399.nextInt(120);
      var2.field0176 = (this.field1399.nextDouble() - 0.5) * 0.02500000005873084;
      var2.field1613 = (this.field1399.nextDouble() - 0.5) * 0.02500000005873084;
      var2.field0457 = -0.01800000002188833 - this.field1399.nextDouble() * 0.01499999499508052;
      var2.field0871 = this.field1399.nextFloat() * 6.28F;
      var2.field0826 = (this.field1399.nextFloat() - 0.5F) * 0.16F;
      return var2;
   }

   private Ambience.SkyObject method0275(class_2338 var1) {
      Ambience.SkyObject var2 = new Ambience.SkyObject();
      var2.field0569 = Ambience.SkyObjectType.field1090;
      var2.field0002 = var1.method_10263() + this.field1399.nextDouble();
      var2.field1409 = var1.method_10264() + this.field1399.nextDouble();
      var2.field0956 = var1.method_10260() + this.field1399.nextDouble();
      var2.field0757 = var2.field0002;
      var2.field1241 = var2.field1409;
      var2.field0313 = var2.field0956;
      var2.field1196 = 1.0F;
      var2.field1136 = 0.035F + this.field1399.nextFloat() * 0.03F;
      var2.field1087 = 0.0F;
      var2.field1705 = 80 + this.field1399.nextInt(60);
      var2.field0176 = (this.field1399.nextDouble() - 0.5) * 0.007999995405319822;
      var2.field1613 = (this.field1399.nextDouble() - 0.5) * 0.007999995405319822;
      var2.field0457 = 0.003999997703356243 + this.field1399.nextDouble() * 0.007999995405319822;
      var2.field0871 = this.field1399.nextFloat() * 6.28F;
      return var2;
   }

   private Ambience.SkyObject method1864(class_243 var1) {
      double var2 = this.field1661.method0492().floatValue();
      double var4 = this.field1399.nextDouble() * 3.1415936675679283 * 2.0;
      double var6 = var2 * (0.5 + this.field1399.nextDouble() * 0.5);
      Ambience.SkyObject var8 = new Ambience.SkyObject();
      var8.field0569 = Ambience.SkyObjectType.field1617;
      var8.field0002 = var1.field_1352 + Math.cos(var4) * var6;
      var8.field0956 = var1.field_1350 + Math.sin(var4) * var6;
      var8.field1409 = var1.field_1351 + 16.0 + this.field1399.nextDouble() * 8.0;
      var8.field0757 = var8.field0002;
      var8.field1241 = var8.field1409;
      var8.field0313 = var8.field0956;
      var8.field1196 = 1.0F;
      var8.field1136 = 0.09F + this.field1399.nextFloat() * 0.05F;
      var8.field1087 = var8.field1136;
      var8.field1705 = 70 + this.field1399.nextInt(40);
      double var9 = Math.toRadians(this.field1693.method0492().floatValue());
      double var11 = 0.22000000006059642 + this.field1399.nextDouble() * 0.11999995622966886;
      var8.field0176 = Math.cos(var9) * var11 * 0.5500001491047446;
      var8.field1613 = Math.sin(var9) * var11 * 0.5500001491047446;
      var8.field0457 = -var11;
      return var8;
   }

   private Ambience.SkyObject method0618(double var1, double var3, double var5) {
      Ambience.SkyObject var7 = new Ambience.SkyObject();
      var7.field0569 = Ambience.SkyObjectType.field1541;
      double var8 = 0.25;
      var7.field0002 = var1 + (this.field1399.nextDouble() - 0.5) * var8;
      var7.field1409 = var3 + (this.field1399.nextDouble() - 0.5) * var8;
      var7.field0956 = var5 + (this.field1399.nextDouble() - 0.5) * var8;
      var7.field0757 = var7.field0002;
      var7.field1241 = var7.field1409;
      var7.field0313 = var7.field0956;
      var7.field1196 = 1.0F;
      var7.field1136 = 0.035F + this.field1399.nextFloat() * 0.04F;
      var7.field1087 = 0.0F;
      var7.field1705 = 24 + this.field1399.nextInt(22);
      var7.field0176 = (this.field1399.nextDouble() - 0.5) * 0.007999995405319822;
      var7.field1613 = (this.field1399.nextDouble() - 0.5) * 0.007999995405319822;
      var7.field0457 = -0.003999998168394917 - this.field1399.nextDouble() * 0.005000002112303237;
      var7.field0871 = this.field1399.nextFloat() * (float) (Math.PI * 2);
      var7.field0826 = (this.field1399.nextFloat() - 0.5F) * 0.06F;
      var7.field1293 = this.field1399.nextInt(field0416.length);
      return var7;
   }

   private Ambience.SkyObject method1667(class_243 var1) {
      double var2 = this.field1661.method0492().floatValue();
      double var4 = this.field1399.nextDouble() * 3.1415936675679283 * 2.0;
      double var6 = var2 * (0.3000000093137463 + this.field1399.nextDouble() * 0.700000000954607);
      Ambience.SkyObject var8 = new Ambience.SkyObject();
      var8.field0569 = Ambience.SkyObjectType.field0317;
      var8.field1368 = var1.field_1352 + Math.cos(var4) * var6;
      var8.field0350 = var1.field_1350 + Math.sin(var4) * var6;
      var8.field0384 = var1.field_1351 + 5.0 + this.field1399.nextDouble() * 24.0;
      var8.field1196 = 0.6F + this.field1399.nextFloat() * 0.9F;
      var8.field0423 = this.field1399.nextFloat() * (float) (Math.PI * 2);
      var8.field0255 = 0.4F + this.field1399.nextFloat() * 3.2F;
      var8.field0002 = var8.field1368 + Math.cos(var8.field0423) * var8.field0255;
      var8.field1409 = var8.field0384;
      var8.field0956 = var8.field0350 + Math.sin(var8.field0423) * var8.field0255;
      var8.field0757 = var8.field0002;
      var8.field1241 = var8.field1409;
      var8.field0313 = var8.field0956;
      var8.field1136 = 0.05F + this.field1399.nextFloat() * 0.05F;
      var8.field1087 = var8.field1136;
      var8.field1705 = 90 + this.field1399.nextInt(70);
      var8.field0457 = -(0.020000008440140268 + this.field1399.nextDouble() * 0.02500000005873084);
      var8.field0826 = 0.18F + this.field1399.nextFloat() * 0.22F;
      if (this.field1399.nextBoolean()) {
         var8.field0826 = -var8.field0826;
      }

      int var9 = 14;
      var8.field0241 = new double[var9];
      var8.field0303 = new double[var9];
      var8.field0539 = new double[var9];

      for (int var10 = 0; var10 < var9; var10++) {
         var8.field0241[var10] = var8.field0002;
         var8.field0303[var10] = var8.field1409;
         var8.field0539[var10] = var8.field0956;
      }

      return var8;
   }

   private Ambience.SkyObject method1994(class_243 var1) {
      double var2 = this.field1661.method0492().floatValue();
      double var4 = this.field1399.nextDouble() * 3.1415936675679283 * 2.0;
      double var6 = var2 * (0.3000000093137463 + this.field1399.nextDouble() * 0.700000000954607);
      Ambience.SkyObject var8 = new Ambience.SkyObject();
      var8.field0569 = Ambience.SkyObjectType.field1245;
      var8.field0002 = var1.field_1352 + Math.cos(var4) * var6;
      var8.field0956 = var1.field_1350 + Math.sin(var4) * var6;
      var8.field1409 = var1.field_1351 + 2.0 + this.field1399.nextDouble() * var2 * 0.800000026077553;
      var8.field0757 = var8.field0002;
      var8.field1241 = var8.field1409;
      var8.field0313 = var8.field0956;
      var8.field1196 = 0.5F + this.field1399.nextFloat() * 1.2F;
      var8.field1136 = (0.06F + this.field1399.nextFloat() * 0.09F) * var8.field1196;
      var8.field1087 = 0.0F;
      var8.field1705 = 90 + this.field1399.nextInt(110);
      var8.field0176 = (this.field1399.nextDouble() - 0.5) * 0.007999995405319822;
      var8.field1613 = (this.field1399.nextDouble() - 0.5) * 0.007999995405319822;
      var8.field0457 = (this.field1399.nextDouble() - 0.4000000310832036) * 0.011999996541534604;
      var8.field0871 = this.field1399.nextFloat() * (float) (Math.PI * 2);
      var8.field0826 = (this.field1399.nextFloat() - 0.5F) * 0.03F;
      var8.field1293 = this.field1399.nextInt(field0416.length);
      return var8;
   }

   private Ambience.SkyObject method1304(class_243 var1, double var2) {
      Ambience.SkyObject var4 = new Ambience.SkyObject();
      var4.field0569 = Ambience.SkyObjectType.field0960;
      var4.field0002 = var1.field_1352 + (this.field1399.nextDouble() - 0.5) * var2;
      var4.field1409 = var1.field_1351 + (this.field1399.nextDouble() - 0.5) * var2 * 0.6000000484588345;
      var4.field0956 = var1.field_1350 + (this.field1399.nextDouble() - 0.5) * var2;
      var4.field0757 = var4.field0002;
      var4.field1241 = var4.field1409;
      var4.field0313 = var4.field0956;
      var4.field1196 = 1.0F;
      var4.field1136 = 0.11F + this.field1399.nextFloat() * 0.06F;
      var4.field1087 = var4.field1136;
      var4.field1705 = 18 + this.field1399.nextInt(12);
      double var5 = Math.toRadians(this.field1693.method0492().floatValue());
      double var7 = 0.700000000954607 + this.field1399.nextDouble() * 0.4000000310832036;
      var4.field0176 = Math.cos(var5) * var7;
      var4.field1613 = Math.sin(var5) * var7;
      var4.field0457 = -var7 * 0.8999997783500137;
      var4.field0931 = this.field1399.nextFloat() < 0.55F;
      return var4;
   }

   private void method0789(Ambience.SkyObject var1, class_243 var2) {
      var1.field0757 = var1.field0002;
      var1.field1241 = var1.field1409;
      var1.field0313 = var1.field0956;
      var1.field1539++;
      switch (var1.field0569) {
         case field0569:
            var1.field0176 = var1.field0176 * 0.9700000610052666 + var2.field_1352 * 0.029999992609062415 * var1.field1196;
            var1.field1613 = var1.field1613 * 0.9700000610052666 + var2.field_1350 * 0.029999992609062415 * var1.field1196;
            var1.field0457 = var1.field0457 - 5.000000005447899E-4 * var1.field1196;
            if (var1.field0457 < -0.08000000096784139) {
               var1.field0457 = -0.08000000096784139;
            }

            var1.field0002 = var1.field0002 + (var1.field0176 + Math.sin(var1.field1539 * 0.07000000061174955) * 0.005999998620070951);
            var1.field1409 = var1.field1409 + var1.field0457;
            var1.field0956 = var1.field0956 + (var1.field1613 + Math.cos(var1.field1539 * 0.07000000061174955) * 0.005999998620070951);
            var1.field0871 = var1.field0871 + var1.field0826;
            if (!var1.field1350 && this.method0788(var1)) {
               var1.field1350 = true;
               int var18 = var1.field1705 - var1.field1539;
               if (var18 > 6) {
                  var1.field1539 = var1.field1705 - 6;
               }
            }
            break;
         case field0006:
            var1.field0176 = var1.field0176 * 0.9799995850626044 + var2.field_1352 * 0.020000008440140268 * var1.field1196;
            var1.field1613 = var1.field1613 * 0.9799995850626044 + var2.field_1350 * 0.020000008440140268 * var1.field1196;
            var1.field0457 = var1.field0457 * 0.9900000205074073 + 3.999998342730354E-4;
            var1.field0002 = var1.field0002 + var1.field0176;
            var1.field1409 = var1.field1409 + var1.field0457;
            var1.field0956 = var1.field0956 + var1.field1613;
            break;
         case field1413: {
            var1.field0176 = var1.field0176 * 0.959999763444066
               + var2.field_1352 * 0.04000000566798708 * var1.field1196
               + Math.sin(var1.field1539 * 0.0600000020991191) * 0.005999998620070951;
            var1.field1613 = var1.field1613 * 0.959999763444066
               + var2.field_1350 * 0.04000000566798708 * var1.field1196
               + Math.cos(var1.field1539 * 0.0600000020991191) * 0.005999998620070951;
            var1.field0457 = -0.0029999993027588533 + Math.sin(var1.field1539 * 0.09000000745087192) * 0.00700000230307797;
            var1.field0002 = var1.field0002 + var1.field0176;
            var1.field1409 = var1.field1409 + var1.field0457;
            var1.field0956 = var1.field0956 + var1.field1613;
            var1.field0871 = var1.field0871 + var1.field0826;
            float var17 = (float)var1.field1539 / var1.field1705;
            var1.field1087 = var1.field1136 * (1.0F - var17 * 0.55F);
            break;
         }
         case field0960:
            var1.field0457 -= 0.011999996541534604;
            var1.field0002 = var1.field0002 + var1.field0176;
            var1.field1409 = var1.field1409 + var1.field0457;
            var1.field0956 = var1.field0956 + var1.field1613;
            break;
         case field0761:
            var1.field0176 = var1.field0176 * 0.9900000205074073 + var2.field_1352 * 0.010000003294232477 * var1.field1196;
            var1.field1613 = var1.field1613 * 0.9900000205074073 + var2.field_1350 * 0.010000003294232477 * var1.field1196;
            var1.field0457 = var1.field0457 - 3.999998342730354E-4 * var1.field1196;
            if (var1.field0457 < -0.12000000048749848) {
               var1.field0457 = -0.12000000048749848;
            }

            var1.field0002 = var1.field0002 + (var1.field0176 + Math.sin(var1.field1539 * 0.08000004191318248) * 0.003999997703356243);
            var1.field1409 = var1.field1409 + var1.field0457;
            var1.field0956 = var1.field0956 + (var1.field1613 + Math.cos(var1.field1539 * 0.08000004191318248) * 0.003999997703356243);
            var1.field0871 = var1.field0871 + var1.field0826;
            break;
         case field1245: {
            var1.field0176 = var1.field0176 * 0.9850001258200113 + var2.field_1352 * 0.005000002112303237 * var1.field1196;
            var1.field1613 = var1.field1613 * 0.9850001258200113 + var2.field_1350 * 0.005000002112303237 * var1.field1196;
            var1.field0457 *= 0.9900000205074073;
            var1.field0002 = var1.field0002 + (var1.field0176 + Math.sin(var1.field1539 * 0.05000001140965078) * 0.0029999991208599216);
            var1.field1409 = var1.field1409 + (var1.field0457 + Math.cos(var1.field1539 * 0.04000000566798708) * 0.0020000000153774806);
            var1.field0956 = var1.field0956 + (var1.field1613 + Math.cos(var1.field1539 * 0.05000001140965078) * 0.0029999991208599216);
            var1.field0871 = var1.field0871 + var1.field0826;
            float var16 = (float)var1.field1539 / var1.field1705;
            float var21 = var16 < 0.25F ? var16 / 0.25F : 1.0F - (var16 - 0.25F) / 0.75F * 0.4F;
            var1.field1087 = var1.field1136 * var21;
            break;
         }
         case field0317:
            var1.field1368 = var1.field1368 + var2.field_1352 * 0.05000001140965078 * var1.field1196;
            var1.field0350 = var1.field0350 + var2.field_1350 * 0.05000001140965078 * var1.field1196;
            var1.field0457 -= 0.0018000000000147173;
            if (var1.field0457 < -0.2800000896520831) {
               var1.field0457 = -0.2800000896520831;
            }

            var1.field0384 = var1.field0384 + var1.field0457;
            var1.field0423 = var1.field0423 + var1.field0826 * var1.field1196;
            var1.field0255 *= 0.965F;
            var1.field0002 = var1.field1368 + Math.cos(var1.field0423) * var1.field0255;
            var1.field1409 = var1.field0384;
            var1.field0956 = var1.field0350 + Math.sin(var1.field0423) * var1.field0255;
            var1.field0502 = (var1.field0502 + 1) % var1.field0241.length;
            var1.field0241[var1.field0502] = var1.field0002;
            var1.field0303[var1.field0502] = var1.field1409;
            var1.field0539[var1.field0502] = var1.field0956;
            break;
         case field0180: {
            var1.field0176 = var1.field0176 * 0.9960000149887187 + var2.field_1352 * 0.003999997703356243 * var1.field1196;
            var1.field1613 = var1.field1613 * 0.9960000149887187 + var2.field_1350 * 0.003999997703356243 * var1.field1196;
            var1.field0457 = var1.field0457 * 0.998000141139481 + 1.5000008738365585E-4;
            var1.field0002 = var1.field0002 + (var1.field0176 + Math.sin(var1.field1539 * 0.02500000005873084) * 0.005000002112303237);
            var1.field1409 = var1.field1409 + var1.field0457;
            var1.field0956 = var1.field0956 + (var1.field1613 + Math.cos(var1.field1539 * 0.02500000005873084) * 0.005000002112303237);
            var1.field0871 = var1.field0871 + var1.field0826;
            float var15 = (float)var1.field1539 / var1.field1705;
            var1.field1087 = var1.field1136 * (1.0F + var15 * 0.5F);
            break;
         }
         case field0461:
            var1.field0176 = var1.field0176 * 0.9200000037255532
               + (float)Math.sin(var1.field1539 * 0.15000000077852818 + var1.field0871 * 4.0F) * 0.011999996541534604;
            var1.field1613 = var1.field1613 * 0.9200000037255532
               + (float)Math.cos(var1.field1539 * 0.15000000077852818 + var1.field0871 * 4.0F) * 0.011999996541534604;
            var1.field0457 = 0.022000000001943833 + Math.sin(var1.field1539 * 0.08000004191318248) * 0.011999996541534604;
            var1.field0002 = var1.field0002 + var1.field0176;
            var1.field1409 = var1.field1409 + var1.field0457;
            var1.field0956 = var1.field0956 + var1.field1613;
            break;
         case field1617:
            var1.field0002 = var1.field0002 + var1.field0176;
            var1.field1409 = var1.field1409 + var1.field0457;
            var1.field0956 = var1.field0956 + var1.field1613;
            this.field1323.add(this.method0618(var1.field0002, var1.field1409, var1.field0956));
            break;
         case field1541: {
            var1.field0002 = var1.field0002 + var1.field0176;
            var1.field1409 = var1.field1409 + var1.field0457;
            var1.field0956 = var1.field0956 + var1.field1613;
            var1.field0871 = var1.field0871 + var1.field0826;
            float var14 = (float)var1.field1539 / var1.field1705;
            float var20 = var14 < 0.2F ? var14 / 0.2F : 1.0F - (var14 - 0.2F) / 0.8F * 0.5F;
            var1.field1087 = var1.field1136 * var20;
            break;
         }
         case field1707: {
            var1.field0176 = var1.field0176 * 0.9900000205074073 + var2.field_1352 * 0.003999997703356243 * var1.field1196;
            var1.field1613 = var1.field1613 * 0.9900000205074073 + var2.field_1350 * 0.003999997703356243 * var1.field1196;
            var1.field0002 = var1.field0002 + (var1.field0176 + Math.sin(var1.field1539 * 0.07000000061174955) * 0.0020000000153774806);
            var1.field1409 = var1.field1409 + (var1.field0457 + Math.cos(var1.field1539 * 0.05000001140965078) * 0.0014999995752660923);
            var1.field0956 = var1.field0956 + (var1.field1613 + Math.cos(var1.field1539 * 0.07000000061174955) * 0.0020000000153774806);
            float var13 = (float)var1.field1539 / var1.field1705;
            float var19 = var13 < 0.15F ? var13 / 0.15F : 1.0F;
            var1.field1087 = var1.field1136 * var19;
            break;
         }
         case field1139:
            var1.field0176 = var1.field0176 * 0.9500000003748397
               + var2.field_1352 * 0.05000001140965078
               + Math.sin(var1.field1539 * 0.11999995622966886) * 0.011999996541534604;
            var1.field1613 = var1.field1613 * 0.9500000003748397
               + var2.field_1350 * 0.05000001140965078
               + Math.cos(var1.field1539 * 0.11999995622966886) * 0.011999996541534604;
            var1.field0457 = var1.field0457 * 0.9900000205074073 - 6.000001166863272E-4;
            if (var1.field0457 < -0.06000000046657533) {
               var1.field0457 = -0.06000000046657533;
            }

            var1.field0002 = var1.field0002 + var1.field0176;
            var1.field1409 = var1.field1409 + var1.field0457;
            var1.field0956 = var1.field0956 + var1.field1613;
            var1.field0871 = var1.field0871 + var1.field0826;
            break;
         case field1090: {
            var1.field0176 = var1.field0176 * 0.9700000610052666
               + (float)Math.sin(var1.field1539 * 0.1000000074513778 + var1.field0871) * 0.0029999991208599216;
            var1.field1613 = var1.field1613 * 0.9700000610052666
               + (float)Math.cos(var1.field1539 * 0.1000000074513778 + var1.field0871) * 0.0029999991208599216;
            var1.field0457 = var1.field0457 * 0.9950000121147059 + 1.9999990269916785E-4;
            var1.field0002 = var1.field0002 + var1.field0176;
            var1.field1409 = var1.field1409 + var1.field0457;
            var1.field0956 = var1.field0956 + var1.field1613;
            float var12 = (float)var1.field1539 / var1.field1705;
            float var4 = var12 < 0.2F ? var12 / 0.2F : 1.0F - (var12 - 0.2F) / 0.8F * 0.4F;
            var1.field1087 = var1.field1136 * var4;
            break;
         }
         case field1199:
            if (!var1.field1350) {
               var1.field0176 = var1.field0176 * 0.9700000610052666
                  + var2.field_1352 * 0.029999992609062415 * var1.field1196
                  + Math.sin(var1.field1539 * 0.09000000745087192) * 0.005000002112303237;
               var1.field1613 = var1.field1613 * 0.9700000610052666
                  + var2.field_1350 * 0.029999992609062415 * var1.field1196
                  + Math.cos(var1.field1539 * 0.09000000745087192) * 0.005000002112303237;
               var1.field0457 = var1.field0457 - 2.4999984915444217E-4 * var1.field1196;
               if (var1.field0457 < -0.04999999450665436) {
                  var1.field0457 = -0.04999999450665436;
               }

               double var3 = var1.field0002 + var1.field0176;
               double var5 = var1.field1409 + var1.field0457;
               double var7 = var1.field0956 + var1.field1613;
               boolean var9 = false;
               if (field0796.field_1687 != null) {
                  class_2338 var10 = class_2338.method_49637(var3, var5, var7);
                  class_2680 var11 = field0796.field_1687.method_8320(var10);
                  if (!var11.method_26220(field0796.field_1687, var10).method_1110()) {
                     var9 = true;
                  }
               }

               if (var9) {
                  var1.field0176 = 0.0;
                  var1.field0457 = 0.0;
                  var1.field1613 = 0.0;
                  var1.field1350 = true;
                  int var22 = var1.field1705 - var1.field1539;
                  if (var22 > 14) {
                     var1.field1539 = var1.field1705 - 14;
                  }
               } else {
                  var1.field0002 = var3;
                  var1.field1409 = var5;
                  var1.field0956 = var7;
               }
            }

            var1.field0871 = var1.field0871 + var1.field0826;
            var1.field0502 = (var1.field0502 + 1) % var1.field0241.length;
            var1.field0241[var1.field0502] = var1.field0002;
            var1.field0303[var1.field0502] = var1.field1409;
            var1.field0539[var1.field0502] = var1.field0956;
      }
   }

   private boolean method0788(Ambience.SkyObject var1) {
      if (field0796.field_1687 == null) {
         return false;
      }

      class_238 var2 = new class_238(
         var1.field0002 - 0.0600000020991191,
         var1.field1409 - 0.0600000020991191,
         var1.field0956 - 0.0600000020991191,
         var1.field0002 + 0.0600000020991191,
         var1.field1409 + 0.0600000020991191,
         var1.field0956 + 0.0600000020991191
      );
      List var3 = field0796.field_1687.method_8390(class_1309.class, var2, var0 -> var0 != field0796.field_1724 && var0.method_5805());
      return !var3.isEmpty();
   }

   private void method0457() {
      class_243 var1 = field0796.field_1724.method_19538();
      int var2 = this.field0234.method0492().intValue();
      int var3 = 20;

      for (int var4 = 0; var4 < var3 && this.field1191.size() < var2; var4++) {
         double var5 = this.field1399.nextDouble() * 3.1415936675679283 * 2.0;
         double var7 = this.field1399.nextDouble() * this.field0295.method0492().floatValue();
         double var9 = var1.field_1352 + Math.cos(var5) * var7;
         double var11 = var1.field_1350 + Math.sin(var5) * var7;
         double var13 = var1.field_1351 + 20.0 + (this.field1399.nextDouble() - 0.5) * 5.0;
         float var15 = 0.4F + this.field1399.nextFloat() * 1.2F;
         double var16 = (this.field1399.nextDouble() - 0.5) * 0.04000000566798708 * var15;
         double var18 = -(0.15F * var15);
         double var20 = (this.field1399.nextDouble() - 0.5) * 0.04000000566798708 * var15;
         this.field1191.add(new Ambience.SkyAnimation(var9, var13, var11, var16, var18, var20, 300, false, true));
      }

      List var22 = new ArrayList<>();
      Iterator var23 = this.field1191.iterator();

      while (var23.hasNext()) {
         Ambience.SkyAnimation var6 = var23.next();
         var6.field0956 = var6.field0565;
         var6.field0757 = var6.field0002;
         var6.field1241 = var6.field1409;
         var6.field0565 = var6.field0565 + var6.field0313;
         var6.field0002 = var6.field0002 + var6.field0176;
         var6.field1409 = var6.field1409 + var6.field0457;
         var6.field1615++;
         if (var6.field1161 && !var6.field1735) {
            double var25 = (this.field1399.nextDouble() - 0.5) * 0.15000000077852818;
            double var28 = (this.field1399.nextDouble() - 0.5) * 0.1000000074513778;
            double var31 = (this.field1399.nextDouble() - 0.5) * 0.15000000077852818;
            int var32 = 15 + this.field1399.nextInt(20);
            var22.add(new Ambience.SkyAnimation(var6.field0956 + var25, var6.field0757 + var28, var6.field1241 + var31, 0.0, 0.0, 0.0, var32, false, false));
         }

         if (var6.field1161 && !var6.field1735) {
            class_2338 var26 = class_2338.method_49637(var6.field0565, var6.field0002 - 0.1000000074513778, var6.field1409);
            if (!field0796.field_1687.method_8320(var26).method_26215()) {
               int var8 = 4 + this.field1399.nextInt(4);

               for (int var30 = 0; var30 < var8; var30++) {
                  double var10 = 0.08F * (0.5 + this.field1399.nextDouble());
                  double var12 = this.field1399.nextDouble() * 3.1415936675679283 * 2.0;
                  double var14 = Math.cos(var12) * var10;
                  double var33 = Math.sin(var12) * var10;
                  double var34 = this.field1399.nextDouble() * var10 * 0.700000000954607;
                  var22.add(new Ambience.SkyAnimation(var6.field0565, var6.field0002, var6.field1409, var14, var34, var33, 15, true, false));
               }

               var23.remove();
               continue;
            }
         } else if (var6.field1735) {
            var6.field0313 *= 0.9200000037255532;
            var6.field0176 -= 0.007999995405319822;
            var6.field0457 *= 0.9200000037255532;
         }

         double var27 = (var6.field0565 - var1.field_1352) * (var6.field0565 - var1.field_1352)
            + (var6.field1409 - var1.field_1350) * (var6.field1409 - var1.field_1350);
         double var29 = this.field0295.method0492().floatValue() * 1.8000000019795739;
         if (var6.field1615 >= var6.field1539 || var27 > var29 * var29) {
            var23.remove();
         }
      }

      if (!var22.isEmpty()) {
         int var24 = var2 - this.field1191.size();
         if (var24 > 0) {
            this.field1191.addAll(var22.subList(0, Math.min(var22.size(), var24)));
         }
      }
   }

   @EventHandler
   public void onRenderWorld(GlowRenderEvent var1) {
      if (!method1974()) {
         if (this.field0550.method0492() && !this.field1134.isEmpty()) {
            this.method0839(var1);
         }

         if (this.field0259.method0492() && !this.field1191.isEmpty()) {
            this.field1124.clear();
            this.field1116.clear();
            class_243 var2 = field0796.field_1773.method_19418().method_19326();
            Matrix4f var3 = new Matrix4f();
            Color var4 = this.field0504.method1726();
            int var5 = var4.getRGB() & 16777215;
            float var6 = var1.method1603();
            float var7 = this.field0529.method0492();
            boolean var8 = true;

            for (Ambience.SkyAnimation var10 : this.field1191) {
               float var11 = 1.0F - (float)var10.field1615 / var10.field1539;
               if (!(var11 <= 0.0F)) {
                  float var12 = (float)(var10.field0956 + (var10.field0565 - var10.field0956) * var6 - var2.field_1352);
                  float var13 = (float)(var10.field0757 + (var10.field0002 - var10.field0757) * var6 - var2.field_1351);
                  float var14 = (float)(var10.field1241 + (var10.field1409 - var10.field1241) * var6 - var2.field_1350);
                  float var15 = var10.field1161 ? 1.0F : var11;
                  int var16 = Math.max(0, Math.min(255, (int)(var4.getAlpha() * var15)));
                  int var17 = (var16 & 0xFF) << 24 | var5;
                  float var18 = var10.field1161 ? 1.5F : var11;
                  float var19 = var7 * var18;
                  this.field1116.add(new Ambience.ColoredVertex(var3, var12 - var19, var13, var14, var17));
                  this.field1116.add(new Ambience.ColoredVertex(var3, var12 + var19, var13, var14, var17));
                  this.field1116.add(new Ambience.ColoredVertex(var3, var12, var13 - var19, var14, var17));
                  this.field1116.add(new Ambience.ColoredVertex(var3, var12, var13 + var19, var14, var17));
                  this.field1116.add(new Ambience.ColoredVertex(var3, var12, var13, var14 - var19, var17));
                  this.field1116.add(new Ambience.ColoredVertex(var3, var12, var13, var14 + var19, var17));
                  if (var8) {
                     float var20 = var19 * 4.0F;
                     double var21 = var10.field0565 - var2.field_1352;
                     double var23 = var10.field1409 - var2.field_1350;
                     double var25 = Math.sqrt(var21 * var21 + var23 * var23);
                     float var27;
                     float var28;
                     if (var25 > 9.999995499875352E-4) {
                        var27 = (float)(-var23 / var25);
                        var28 = (float)(var21 / var25);
                     } else {
                        var27 = 1.0F;
                        var28 = 0.0F;
                     }

                     this.field1124
                        .add(
                           new Ambience.SkyMesh(
                              var3,
                              var12 - var27 * var20,
                              var13 - var20,
                              var14 - var28 * var20,
                              var12 + var27 * var20,
                              var13 - var20,
                              var14 + var28 * var20,
                              var12 + var27 * var20,
                              var13 + var20,
                              var14 + var28 * var20,
                              var12 - var27 * var20,
                              var13 + var20,
                              var14 - var28 * var20,
                              var17
                           )
                        );
                  }
               }
            }

            if (!this.field1116.isEmpty()) {
               this.method0521();
            }

            if (!this.field1124.isEmpty()) {
               this.method0516();
            }
         }
      }
   }

   private void method0839(GlowRenderEvent var1) {
      this.field1232.clear();
      this.field1224.clear();
      this.field1238.clear();
      this.field1359.clear();
      this.field1354.clear();
      this.field1363.clear();
      this.field0902.clear();
      class_243 var2 = field0796.field_1773.method_19418().method_19326();
      Matrix4f var3 = new Matrix4f();
      Color var4 = this.field1581.method1726();
      int var5 = var4.getRGB() & 16777215;
      int var6 = var4.getAlpha();
      int var7 = var5;
      int var8 = var6;
      int var9 = var5;
      int var10 = var6;
      int var11 = var5;
      int var12 = var6;
      int var13 = var5;
      int var14 = var6;
      int var15 = var5;
      int var16 = var6;
      int var17 = 3750201;
      int var18 = 130;
      int var19 = var5;
      int var20 = var6;
      int var21 = var5;
      int var22 = var6;
      int var23 = var5;
      int var24 = var6;
      int var25 = var5;
      int var26 = var6;
      int var27 = var5;
      int var28 = var6;
      int var29 = var5;
      int var30 = var6;
      float var31 = var1.method1603();
      Quaternionf var32 = field0796.field_1773.method_19418().method_23767();
      Vector3f var33 = new Vector3f(1.0F, 0.0F, 0.0F);
      var32.transform(var33);
      Vector3f var34 = new Vector3f(0.0F, 1.0F, 0.0F);
      var32.transform(var34);
      float var35 = var33.x;
      float var36 = var33.y;
      float var37 = var33.z;
      float var38 = var34.x;
      float var39 = var34.y;
      float var40 = var34.z;

      for (Ambience.SkyObject var42 : this.field1134) {
         float var43 = (float)var42.field1539 / var42.field1705;
         float var44 = var43 < 0.1F ? var43 / 0.1F : (1.0F - var43) / 0.9F;
         if (!(var44 <= 0.0F)) {
            float var45 = (float)(var42.field0757 + (var42.field0002 - var42.field0757) * var31 - var2.field_1352);
            float var46 = (float)(var42.field1241 + (var42.field1409 - var42.field1241) * var31 - var2.field_1351);
            float var47 = (float)(var42.field0313 + (var42.field0956 - var42.field0313) * var31 - var2.field_1350);
            switch (var42.field0569) {
               case field0569:
                  int var77 = var7 >> 16 & 0xFF;
                  int var91 = var7 >> 8 & 0xFF;
                  int var102 = var7 & 0xFF;
                  int var110 = (int)(var77 * 0.45F);
                  int var117 = (int)(var91 * 0.32F);
                  int var122 = (int)(var102 * 0.25F);
                  int var125 = Math.max(0, Math.min(255, (int)(210.0F * var44)));
                  int var128 = var125 << 24 | var110 << 16 | var117 << 8 | var122;
                  this.method1086(this.field1224, var3, var45, var46, var47, var42.field1087, var128, var35, var36, var37, var38, var39, var40, var42.field0871);
                  break;
               case field0006: {
                  float var76 = (float)Math.sin(var42.field1539 * 0.18F + var42.field0871 * 6.28F) * 0.25F + 0.9F;
                  int var90 = Math.max(0, Math.min(255, (int)(var8 * var44 * var76 * 1.7F)));
                  int var101 = var90 << 24 | var7;
                  this.method1085(this.field1232, var3, var45, var46, var47, var42.field1087 * 1.4F, var101, var35, var36, var37, var38, var39, var40);
                  break;
               }
               case field1413:
                  int var75 = Math.max(0, Math.min(255, (int)(var8 * var44)));
                  int var89 = var75 << 24 | var7;
                  this.method1086(this.field1232, var3, var45, var46, var47, var42.field1087, var89, var35, var36, var37, var38, var39, var40, var42.field0871);
                  break;
               case field0960: {
                  float var74 = (float)Math.sqrt(var42.field0176 * var42.field0176 + var42.field0457 * var42.field0457 + var42.field1613 * var42.field1613);
                  float var88 = var42.field1136 * 14.0F + var74 * 4.0F;
                  float var100 = var42.field1136 * 0.55F;
                  int var109 = Math.max(0, Math.min(255, (int)(var10 * var44)));
                  int var116 = var109 << 24 | var9;
                  int var121 = var9;
                  this.method0343(
                     var3, var45, var46, var47, (float)var42.field0176, (float)var42.field0457, (float)var42.field1613, var88, var100, var116, var121
                  );
                  if (var42.field0931) {
                     int coreAx = Math.max(0, Math.min(255, (int)(255.0F * var44)));
                     int var127 = coreAx << 24 | 16777215;
                     this.method0343(
                        var3,
                        var45,
                        var46,
                        var47,
                        (float)var42.field0176,
                        (float)var42.field0457,
                        (float)var42.field1613,
                        var88 * 0.65F,
                        var100 * 0.4F,
                        var127,
                        16777215
                     );
                  }

                  this.method1085(this.field1232, var3, var45, var46, var47, var42.field1136 * 1.6F, var116, var35, var36, var37, var38, var39, var40);
                  break;
               }
               case field0761: {
                  float var73 = (float)Math.sin(var42.field1539 * 0.25F + var42.field0871 * 3.0F) * 0.25F + 0.85F;
                  int var87 = Math.max(0, Math.min(255, (int)(var12 * var44 * var73 * 0.85F)));
                  int var99 = var87 << 24 | var11;
                  this.method1085(this.field1232, var3, var45, var46, var47, var42.field1087 * 2.2F, var99, var35, var36, var37, var38, var39, var40);
                  int var108 = Math.max(0, Math.min(255, (int)(255.0F * var44 * var73)));
                  int var115 = var108 << 24 | var11;
                  this.method1086(
                     this.field1359, var3, var45, var46, var47, var42.field1087 * 1.1F, var115, var35, var36, var37, var38, var39, var40, var42.field0871
                  );
                  break;
               }
               case field1245: {
                  float var72 = (float)Math.sin(var42.field1539 * 0.15F + var42.field1293 * 1.7F) * 0.2F + 0.85F;
                  int var86 = Math.max(0, Math.min(255, (int)(var14 * var44 * var72)));
                  int var98 = var86 << 24 | var13;
                  List var107 = this.field1354.computeIfAbsent(var42.field1293, var0 -> new ArrayList<>());
                  this.method1086(var107, var3, var45, var46, var47, var42.field1087, var98, var35, var36, var37, var38, var39, var40, var42.field0871);
                  int var114 = Math.max(0, Math.min(255, (int)(var14 * var44 * 0.35F)));
                  int var120 = var114 << 24 | var13;
                  this.method1085(this.field1232, var3, var45, var46, var47, var42.field1087 * 1.8F, var120, var35, var36, var37, var38, var39, var40);
                  break;
               }
               case field0317: {
                  int var71 = var42.field0241.length;
                  int var85 = var71 - 1;
                  int var97 = Math.max(0, Math.min(255, (int)(var16 * var44)));
                  this.method1085(
                     this.field1232, var3, var45, var46, var47, var42.field1136 * 1.5F, var97 << 24 | var15, var35, var36, var37, var38, var39, var40
                  );
                  if (var85 < 2) {
                     break;
                  }

                  float var106 = var42.field1136 * 0.55F;

                  for (int var113 = 0; var113 < var85; var113++) {
                     int var119 = (var42.field0502 - var113 + var71) % var71;
                     int var123 = (var42.field0502 - var113 - 1 + var71) % var71;
                     double var126 = var42.field0241[var123] + (var42.field0241[var119] - var42.field0241[var123]) * var31;
                     double var129 = var42.field0303[var123] + (var42.field0303[var119] - var42.field0303[var123]) * var31;
                     double var130 = var42.field0539[var123] + (var42.field0539[var119] - var42.field0539[var123]) * var31;
                     this.field0898[var113] = (float)(var126 - var2.field_1352);
                     this.field0908[var113] = (float)(var129 - var2.field_1351);
                     this.field0861[var113] = (float)(var130 - var2.field_1350);
                     this.field0939[var113] = var106;
                     float var131 = 1.0F - (float)var113 / (var85 - 1);
                     int var132 = Math.max(0, Math.min(255, (int)(var16 * var44 * var131)));
                     this.field0954[var113] = var132 << 24 | var15;
                  }

                  this.method1559(var3, var85);
                  break;
               }
               case field0180:
                  int var70 = Math.max(0, Math.min(255, (int)(var18 * var44)));
                  int var84 = var70 << 24 | var17;
                  this.method1086(this.field1363, var3, var45, var46, var47, var42.field1087, var84, var35, var36, var37, var38, var39, var40, var42.field0871);
                  break;
               case field0461: {
                  float var69 = (float)Math.sin(var42.field1539 * 0.3F + var42.field0871 * 5.0F) * 0.3F + 0.85F;
                  int var83 = Math.max(0, Math.min(255, (int)(var20 * var44 * var69)));
                  int var96 = var83 << 24 | var19;
                  this.method1085(this.field1232, var3, var45, var46, var47, var42.field1087 * 2.2F, var96, var35, var36, var37, var38, var39, var40);
                  int var105 = Math.max(0, Math.min(255, (int)(255.0F * var44 * var69)));
                  this.method1085(
                     this.field1232, var3, var45, var46, var47, var42.field1087 * 0.8F, var105 << 24 | var19, var35, var36, var37, var38, var39, var40
                  );
                  break;
               }
               case field1617: {
                  float var68 = (float)Math.sqrt(var42.field0176 * var42.field0176 + var42.field0457 * var42.field0457 + var42.field1613 * var42.field1613);
                  float var82 = var42.field1136 * 8.0F + var68 * 7.0F;
                  float var95 = var42.field1136 * 0.5F;
                  int var104 = Math.max(0, Math.min(255, (int)(var22 * var44)));
                  int var112 = var104 << 24 | var21;
                  this.method0343(
                     var3, var45, var46, var47, (float)var42.field0176, (float)var42.field0457, (float)var42.field1613, var82, var95, var112, var21
                  );
                  int var118 = Math.max(0, Math.min(255, (int)(255.0F * var44)));
                  this.method0343(
                     var3,
                     var45,
                     var46,
                     var47,
                     (float)var42.field0176,
                     (float)var42.field0457,
                     (float)var42.field1613,
                     var82 * 0.6F,
                     var95 * 0.35F,
                     var118 << 24 | 16777215,
                     16777215
                  );
                  this.method1085(this.field1232, var3, var45, var46, var47, var42.field1136 * 2.0F, var112, var35, var36, var37, var38, var39, var40);
                  break;
               }
               case field1541: {
                  float var67 = (float)Math.sin(var42.field1539 * 0.3F + var42.field0871 * 4.0F) * 0.25F + 0.85F;
                  int var81 = Math.max(0, Math.min(255, (int)(var22 * var44 * var67)));
                  int var94 = var81 << 24 | var21;
                  List var103 = this.field1354.computeIfAbsent(var42.field1293, var0 -> new ArrayList<>());
                  this.method1086(var103, var3, var45, var46, var47, var42.field1087, var94, var35, var36, var37, var38, var39, var40, var42.field0871);
                  int var111 = Math.max(0, Math.min(255, (int)(var22 * var44 * 0.4F)));
                  this.method1085(
                     this.field1232, var3, var45, var46, var47, var42.field1087 * 1.7F, var111 << 24 | var21, var35, var36, var37, var38, var39, var40
                  );
                  break;
               }
               case field1707: {
                  float var66 = (float)Math.sin(var42.field1539 * 0.4F + var42.field0871 * 7.0F) * 0.4F + 0.7F;
                  int var80 = Math.max(0, Math.min(255, (int)(255.0F * var44 * var66)));
                  this.method1085(this.field1232, var3, var45, var46, var47, var42.field1087, var80 << 24 | var23, var35, var36, var37, var38, var39, var40);
                  int var93 = Math.max(0, Math.min(255, (int)(var24 * var44 * var66 * 0.5F)));
                  this.method1085(
                     this.field1232, var3, var45, var46, var47, var42.field1087 * 2.6F, var93 << 24 | var23, var35, var36, var37, var38, var39, var40
                  );
                  break;
               }
               case field1139:
                  int var65 = Math.max(0, Math.min(255, (int)(var26 * var44)));
                  int var79 = var65 << 24 | var25;
                  this.method1086(this.field1232, var3, var45, var46, var47, var42.field1087, var79, var35, var36, var37, var38, var39, var40, var42.field0871);
                  break;
               case field1090: {
                  float var64 = (float)Math.sin(var42.field1539 * 0.25F + var42.field0871 * 3.0F) * 0.3F + 0.85F;
                  int var78 = Math.max(0, Math.min(255, (int)(var28 * var44 * var64)));
                  this.method1085(
                     this.field1232, var3, var45, var46, var47, var42.field1087 * 1.6F, var78 << 24 | var27, var35, var36, var37, var38, var39, var40
                  );
                  int var92 = Math.max(0, Math.min(255, (int)(255.0F * var44 * var64)));
                  this.method1085(
                     this.field1232, var3, var45, var46, var47, var42.field1087 * 0.6F, var92 << 24 | var27, var35, var36, var37, var38, var39, var40
                  );
                  break;
               }
               case field1199: {
                  int var48 = var42.field0241.length;
                  int var49 = var48 - 1;
                  int var50 = Math.max(0, Math.min(255, (int)(var30 * var44)));
                  int var51 = var50 << 24 | var29;
                  this.method1557(var3, var45, var46, var47, var42.field1087, var51, var35, var36, var37, var38, var39, var40, var42.field0871);
                  if (var49 >= 2) {
                     for (int var52 = 0; var52 < var49; var52++) {
                        int var53 = (var42.field0502 - var52 + var48) % var48;
                        int var54 = (var42.field0502 - var52 - 1 + var48) % var48;
                        double var55 = var42.field0241[var54] + (var42.field0241[var53] - var42.field0241[var54]) * var31;
                        double var57 = var42.field0303[var54] + (var42.field0303[var53] - var42.field0303[var54]) * var31;
                        double var59 = var42.field0539[var54] + (var42.field0539[var53] - var42.field0539[var54]) * var31;
                        this.field0898[var52] = (float)(var55 - var2.field_1352);
                        this.field0908[var52] = (float)(var57 - var2.field_1351);
                        this.field0861[var52] = (float)(var59 - var2.field_1350);
                        float var61 = (float)var52 / (var49 - 1);
                        this.field0939[var52] = var42.field1136 * (0.45F + var61 * 2.4F);
                        float var62 = (1.0F - var61) * (1.0F - var61) * var44;
                        int var63 = Math.max(0, Math.min(255, (int)(var30 * var62)));
                        this.field0954[var52] = var63 << 24 | var29;
                     }

                     this.method1559(var3, var49);
                  }
               }
            }
         }
      }

      if (!this.field1363.isEmpty()) {
         this.method0405();
      }

      if (!this.field0902.isEmpty()) {
         this.method0479();
      }

      if (!this.field1238.isEmpty()) {
         this.method2141(this.field1238);
      }

      if (!this.field1232.isEmpty()) {
         this.method0225(this.field1232);
      }

      if (!this.field1359.isEmpty()) {
         this.method1074(this.field1359);
      }

      if (!this.field1354.isEmpty()) {
         this.method0398();
      }

      if (!this.field1224.isEmpty()) {
         this.method0410();
      }
   }

   private void method1559(Matrix4f var1, int var2) {
      if (var2 >= 2) {
         for (int var3 = 0; var3 < var2; var3++) {
            float var4;
            float var5;
            float var6;
            if (var3 == 0) {
               var4 = this.field0898[1] - this.field0898[0];
               var5 = this.field0908[1] - this.field0908[0];
               var6 = this.field0861[1] - this.field0861[0];
            } else if (var3 == var2 - 1) {
               var4 = this.field0898[var3] - this.field0898[var3 - 1];
               var5 = this.field0908[var3] - this.field0908[var3 - 1];
               var6 = this.field0861[var3] - this.field0861[var3 - 1];
            } else {
               var4 = this.field0898[var3 + 1] - this.field0898[var3 - 1];
               var5 = this.field0908[var3 + 1] - this.field0908[var3 - 1];
               var6 = this.field0861[var3 + 1] - this.field0861[var3 - 1];
            }

            float var7 = (float)Math.sqrt(var4 * var4 + var5 * var5 + var6 * var6);
            if (var7 < 1.0E-5F) {
               this.field0854[var3] = 0.0F;
               this.field0869[var3] = 0.0F;
               this.field0947[var3] = 0.0F;
            } else {
               var4 /= var7;
               var5 /= var7;
               var6 /= var7;
               float var8 = this.field0898[var3];
               float var9 = this.field0908[var3];
               float var10 = this.field0861[var3];
               float var11 = (float)Math.sqrt(var8 * var8 + var9 * var9 + var10 * var10);
               if (var11 < 1.0E-5F) {
                  this.field0854[var3] = 0.0F;
                  this.field0869[var3] = 0.0F;
                  this.field0947[var3] = 0.0F;
               } else {
                  var8 /= var11;
                  var9 /= var11;
                  var10 /= var11;
                  float var12 = var5 * var10 - var6 * var9;
                  float var13 = var6 * var8 - var4 * var10;
                  float var14 = var4 * var9 - var5 * var8;
                  float var15 = (float)Math.sqrt(var12 * var12 + var13 * var13 + var14 * var14);
                  if (var15 < 1.0E-5F) {
                     this.field0854[var3] = 0.0F;
                     this.field0869[var3] = 0.0F;
                     this.field0947[var3] = 0.0F;
                  } else {
                     this.field0854[var3] = var12 / var15;
                     this.field0869[var3] = var13 / var15;
                     this.field0947[var3] = var14 / var15;
                  }
               }
            }
         }

         for (int var16 = 0; var16 < var2 - 1; var16++) {
            float var18 = this.field0939[var16] * 0.5F;
            float var20 = this.field0939[var16 + 1] * 0.5F;
            float var22 = this.field0854[var16] * var18;
            float var23 = this.field0869[var16] * var18;
            float var25 = this.field0947[var16] * var18;
            float var27 = this.field0854[var16 + 1] * var20;
            float var29 = this.field0869[var16 + 1] * var20;
            float var30 = this.field0947[var16 + 1] * var20;
            this.field0902
               .add(
                  new Ambience.SkyLayer(
                     var1,
                     this.field0898[var16] - var22,
                     this.field0908[var16] - var23,
                     this.field0861[var16] - var25,
                     this.field0954[var16],
                     this.field0898[var16] + var22,
                     this.field0908[var16] + var23,
                     this.field0861[var16] + var25,
                     this.field0954[var16],
                     this.field0898[var16 + 1] + var27,
                     this.field0908[var16 + 1] + var29,
                     this.field0861[var16 + 1] + var30,
                     this.field0954[var16 + 1],
                     this.field0898[var16 + 1] - var27,
                     this.field0908[var16 + 1] - var29,
                     this.field0861[var16 + 1] - var30,
                     this.field0954[var16 + 1]
                  )
               );
         }
      }
   }

   private void method0479() {
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(770, 1);
      RenderSystem.enableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.disableCull();
      RenderSystem.setShaderTexture(0, field1393);
      RenderSystem.setShader(class_10142.field_53880);
      class_287 var1 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1575);

      for (Ambience.SkyLayer var3 : this.field0902) {
         var1.method_22918(var3.matrix, var3.x1, var3.y1, var3.z1).method_22913(0.5F, 0.0F).method_39415(var3.c1);
         var1.method_22918(var3.matrix, var3.x2, var3.y2, var3.z2).method_22913(0.5F, 1.0F).method_39415(var3.c2);
         var1.method_22918(var3.matrix, var3.x3, var3.y3, var3.z3).method_22913(0.5F, 1.0F).method_39415(var3.c3);
         var1.method_22918(var3.matrix, var3.x4, var3.y4, var3.z4).method_22913(0.5F, 0.0F).method_39415(var3.c4);
      }

      class_286.method_43433(var1.method_60800());
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.enableCull();
      RenderSystem.depthMask(true);
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableBlend();
   }

   private void method1554(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10, int var11) {
      float var12 = var2 - var5;
      float var13 = var3 - var6;
      float var14 = var4 - var7;
      float var15 = (float)Math.sqrt(var12 * var12 + var13 * var13 + var14 * var14);
      if (!(var15 < 1.0E-4F)) {
         var12 /= var15;
         var13 /= var15;
         var14 /= var15;
         float var16 = (var2 + var5) * 0.5F;
         float var17 = (var3 + var6) * 0.5F;
         float var18 = (var4 + var7) * 0.5F;
         float var19 = (float)Math.sqrt(var16 * var16 + var17 * var17 + var18 * var18);
         if (!(var19 < 1.0E-4F)) {
            float var20 = var16 / var19;
            float var21 = var17 / var19;
            float var22 = var18 / var19;
            float var23 = var13 * var22 - var14 * var21;
            float var24 = var14 * var20 - var12 * var22;
            float var25 = var12 * var21 - var13 * var20;
            float var26 = (float)Math.sqrt(var23 * var23 + var24 * var24 + var25 * var25);
            if (!(var26 < 1.0E-4F)) {
               float var27 = 1.0F / var26;
               float var28 = var8 * 0.5F * var27;
               float var29 = var9 * 0.5F * var27;
               float var30 = var23 * var28;
               float var31 = var24 * var28;
               float var32 = var25 * var28;
               float var33 = var23 * var29;
               float var34 = var24 * var29;
               float var35 = var25 * var29;
               this.field1238
                  .add(
                     new Ambience.SkyLayer(
                        var1,
                        var2 - var30,
                        var3 - var31,
                        var4 - var32,
                        var10,
                        var2 + var30,
                        var3 + var31,
                        var4 + var32,
                        var10,
                        var5 + var33,
                        var6 + var34,
                        var7 + var35,
                        var11,
                        var5 - var33,
                        var6 - var34,
                        var7 - var35,
                        var11
                     )
                  );
            }
         }
      }
   }

   private void method1555(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, int var10) {
      float var11 = var2 - var5;
      float var12 = var3 - var6;
      float var13 = var4 - var7;
      float var14 = (float)Math.sqrt(var11 * var11 + var12 * var12 + var13 * var13);
      if (!(var14 < 1.0E-4F)) {
         var11 /= var14;
         var12 /= var14;
         var13 /= var14;
         float var15 = (var2 + var5) * 0.5F;
         float var16 = (var3 + var6) * 0.5F;
         float var17 = (var4 + var7) * 0.5F;
         float var18 = (float)Math.sqrt(var15 * var15 + var16 * var16 + var17 * var17);
         if (!(var18 < 1.0E-4F)) {
            float var19 = var15 / var18;
            float var20 = var16 / var18;
            float var21 = var17 / var18;
            float var22 = var12 * var21 - var13 * var20;
            float var23 = var13 * var19 - var11 * var21;
            float var24 = var11 * var20 - var12 * var19;
            float var25 = (float)Math.sqrt(var22 * var22 + var23 * var23 + var24 * var24);
            if (!(var25 < 1.0E-4F)) {
               float var26 = var8 * 0.5F / var25;
               var22 *= var26;
               var23 *= var26;
               var24 *= var26;
               this.field1238
                  .add(
                     new Ambience.SkyLayer(
                        var1,
                        var2 - var22,
                        var3 - var23,
                        var4 - var24,
                        var9,
                        var2 + var22,
                        var3 + var23,
                        var4 + var24,
                        var9,
                        var5 + var22,
                        var6 + var23,
                        var7 + var24,
                        var10,
                        var5 - var22,
                        var6 - var23,
                        var7 - var24,
                        var10
                     )
                  );
            }
         }
      }
   }

   private void method0405() {
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.enableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.disableCull();
      RenderSystem.setShaderTexture(0, field1393);
      RenderSystem.setShader(class_10142.field_53880);
      class_287 var1 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1575);

      for (Ambience.SkyMesh var3 : this.field1363) {
         var1.method_22918(var3.matrix, var3.x1, var3.y1, var3.z1).method_22913(0.0F, 0.0F).method_39415(var3.color);
         var1.method_22918(var3.matrix, var3.x2, var3.y2, var3.z2).method_22913(1.0F, 0.0F).method_39415(var3.color);
         var1.method_22918(var3.matrix, var3.x3, var3.y3, var3.z3).method_22913(1.0F, 1.0F).method_39415(var3.color);
         var1.method_22918(var3.matrix, var3.x4, var3.y4, var3.z4).method_22913(0.0F, 1.0F).method_39415(var3.color);
      }

      class_286.method_43433(var1.method_60800());
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.enableCull();
      RenderSystem.depthMask(true);
      RenderSystem.disableBlend();
   }

   private void method0398() {
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(770, 1);
      RenderSystem.enableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.disableCull();
      RenderSystem.setShader(class_10142.field_53880);

      for (Entry var2 : this.field1354.entrySet()) {
         List var3 = var2.getValue();
         if (!var3.isEmpty()) {
            RenderSystem.setShaderTexture(0, field0416[var2.getKey()]);
            class_287 var4 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1575);

            for (Ambience.SkyMesh var6 : var3) {
               var4.method_22918(var6.matrix, var6.x1, var6.y1, var6.z1).method_22913(0.0F, 0.0F).method_39415(var6.color);
               var4.method_22918(var6.matrix, var6.x2, var6.y2, var6.z2).method_22913(1.0F, 0.0F).method_39415(var6.color);
               var4.method_22918(var6.matrix, var6.x3, var6.y3, var6.z3).method_22913(1.0F, 1.0F).method_39415(var6.color);
               var4.method_22918(var6.matrix, var6.x4, var6.y4, var6.z4).method_22913(0.0F, 1.0F).method_39415(var6.color);
            }

            class_286.method_43433(var4.method_60800());
         }
      }

      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.enableCull();
      RenderSystem.depthMask(true);
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableBlend();
   }

   private void method1074(List<Ambience.SkyMesh> var1) {
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(770, 1);
      RenderSystem.enableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.disableCull();
      RenderSystem.setShaderTexture(0, field1406);
      RenderSystem.setShader(class_10142.field_53880);
      class_287 var2 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1575);

      for (Ambience.SkyMesh var4 : var1) {
         var2.method_22918(var4.matrix, var4.x1, var4.y1, var4.z1).method_22913(0.0F, 0.0F).method_39415(var4.color);
         var2.method_22918(var4.matrix, var4.x2, var4.y2, var4.z2).method_22913(1.0F, 0.0F).method_39415(var4.color);
         var2.method_22918(var4.matrix, var4.x3, var4.y3, var4.z3).method_22913(1.0F, 1.0F).method_39415(var4.color);
         var2.method_22918(var4.matrix, var4.x4, var4.y4, var4.z4).method_22913(0.0F, 1.0F).method_39415(var4.color);
      }

      class_286.method_43433(var2.method_60800());
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.enableCull();
      RenderSystem.depthMask(true);
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableBlend();
   }

   private void method1085(
      List<Ambience.SkyMesh> var1,
      Matrix4f var2,
      float var3,
      float var4,
      float var5,
      float var6,
      int var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13
   ) {
      float var14 = var6 * 0.5F;
      float var15 = var8 * var14;
      float var16 = var9 * var14;
      float var17 = var10 * var14;
      float var18 = var11 * var14;
      float var19 = var12 * var14;
      float var20 = var13 * var14;
      var1.add(
         new Ambience.SkyMesh(
            var2,
            var3 - var15 - var18,
            var4 - var16 - var19,
            var5 - var17 - var20,
            var3 + var15 - var18,
            var4 + var16 - var19,
            var5 + var17 - var20,
            var3 + var15 + var18,
            var4 + var16 + var19,
            var5 + var17 + var20,
            var3 - var15 + var18,
            var4 - var16 + var19,
            var5 - var17 + var20,
            var7
         )
      );
   }

   private void method1557(
      Matrix4f var1,
      float var2,
      float var3,
      float var4,
      float var5,
      int var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13
   ) {
      float var14 = (float)Math.cos(var13);
      float var15 = (float)Math.sin(var13);
      float var16 = var14 * var7 + var15 * var10;
      float var17 = var14 * var8 + var15 * var11;
      float var18 = var14 * var9 + var15 * var12;
      float var19 = -var15 * var7 + var14 * var10;
      float var20 = -var15 * var8 + var14 * var11;
      float var21 = -var15 * var9 + var14 * var12;
      float var22 = var5 * 0.65F;
      float var23 = var5 * 0.22F;
      this.field1224
         .add(
            new Ambience.SkyMesh(
               var1,
               var2 + var19 * var22,
               var3 + var20 * var22,
               var4 + var21 * var22,
               var2 + var16 * var23,
               var3 + var17 * var23,
               var4 + var18 * var23,
               var2 - var19 * var22,
               var3 - var20 * var22,
               var4 - var21 * var22,
               var2 - var16 * var23,
               var3 - var17 * var23,
               var4 - var18 * var23,
               var6
            )
         );
   }

   private void method1086(
      List<Ambience.SkyMesh> var1,
      Matrix4f var2,
      float var3,
      float var4,
      float var5,
      float var6,
      int var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14
   ) {
      float var15 = (float)Math.cos(var14);
      float var16 = (float)Math.sin(var14);
      float var17 = var15 * var8 + var16 * var11;
      float var18 = var15 * var9 + var16 * var12;
      float var19 = var15 * var10 + var16 * var13;
      float var20 = -var16 * var8 + var15 * var11;
      float var21 = -var16 * var9 + var15 * var12;
      float var22 = -var16 * var10 + var15 * var13;
      this.method1085(var1, var2, var3, var4, var5, var6, var7, var17, var18, var19, var20, var21, var22);
   }

   private void method0343(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10, int var11) {
      float var12 = (float)Math.sqrt(var5 * var5 + var6 * var6 + var7 * var7);
      if (!(var12 < 1.0E-4F)) {
         float var13 = var5 / var12;
         float var14 = var6 / var12;
         float var15 = var7 / var12;
         float var16 = var2 - var13 * var8;
         float var17 = var3 - var14 * var8;
         float var18 = var4 - var15 * var8;
         float var19 = (var2 + var16) * 0.5F;
         float var20 = (var3 + var17) * 0.5F;
         float var21 = (var4 + var18) * 0.5F;
         float var22 = (float)Math.sqrt(var19 * var19 + var20 * var20 + var21 * var21);
         if (!(var22 < 1.0E-4F)) {
            float var23 = var19 / var22;
            float var24 = var20 / var22;
            float var25 = var21 / var22;
            float var26 = var14 * var25 - var15 * var24;
            float var27 = var15 * var23 - var13 * var25;
            float var28 = var13 * var24 - var14 * var23;
            float var29 = (float)Math.sqrt(var26 * var26 + var27 * var27 + var28 * var28);
            if (!(var29 < 1.0E-4F)) {
               float var30 = var9 * 0.5F / var29;
               var26 *= var30;
               var27 *= var30;
               var28 *= var30;
               this.field1238
                  .add(
                     new Ambience.SkyLayer(
                        var1,
                        var2 - var26,
                        var3 - var27,
                        var4 - var28,
                        var10,
                        var2 + var26,
                        var3 + var27,
                        var4 + var28,
                        var10,
                        var16 + var26,
                        var17 + var27,
                        var18 + var28,
                        var11,
                        var16 - var26,
                        var17 - var27,
                        var18 - var28,
                        var11
                     )
                  );
            }
         }
      }
   }

   private void method0225(List<Ambience.SkyMesh> var1) {
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(770, 1);
      RenderSystem.enableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.disableCull();
      RenderSystem.setShaderTexture(0, field1393);
      RenderSystem.setShader(class_10142.field_53880);
      class_287 var2 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1575);

      for (Ambience.SkyMesh var4 : var1) {
         var2.method_22918(var4.matrix, var4.x1, var4.y1, var4.z1).method_22913(0.0F, 0.0F).method_39415(var4.color);
         var2.method_22918(var4.matrix, var4.x2, var4.y2, var4.z2).method_22913(1.0F, 0.0F).method_39415(var4.color);
         var2.method_22918(var4.matrix, var4.x3, var4.y3, var4.z3).method_22913(1.0F, 1.0F).method_39415(var4.color);
         var2.method_22918(var4.matrix, var4.x4, var4.y4, var4.z4).method_22913(0.0F, 1.0F).method_39415(var4.color);
      }

      class_286.method_43433(var2.method_60800());
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.enableCull();
      RenderSystem.depthMask(true);
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableBlend();
   }

   private void method2141(List<Ambience.SkyLayer> var1) {
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(770, 1);
      RenderSystem.enableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.disableCull();
      RenderSystem.setShaderTexture(0, field1393);
      RenderSystem.setShader(class_10142.field_53880);
      class_287 var2 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1575);

      for (Ambience.SkyLayer var4 : var1) {
         var2.method_22918(var4.matrix, var4.x1, var4.y1, var4.z1).method_22913(0.5F, 0.0F).method_39415(var4.c1);
         var2.method_22918(var4.matrix, var4.x2, var4.y2, var4.z2).method_22913(0.5F, 1.0F).method_39415(var4.c2);
         var2.method_22918(var4.matrix, var4.x3, var4.y3, var4.z3).method_22913(1.0F, 1.0F).method_39415(var4.c3);
         var2.method_22918(var4.matrix, var4.x4, var4.y4, var4.z4).method_22913(1.0F, 0.0F).method_39415(var4.c4);
      }

      class_286.method_43433(var2.method_60800());
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.enableCull();
      RenderSystem.depthMask(true);
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableBlend();
   }

   private void method0410() {
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.enableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.disableCull();
      RenderSystem.setShaderTexture(0, field1393);
      RenderSystem.setShader(class_10142.field_53880);
      class_287 var1 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1575);

      for (Ambience.SkyMesh var3 : this.field1224) {
         var1.method_22918(var3.matrix, var3.x1, var3.y1, var3.z1).method_22913(0.0F, 0.0F).method_39415(var3.color);
         var1.method_22918(var3.matrix, var3.x2, var3.y2, var3.z2).method_22913(1.0F, 0.0F).method_39415(var3.color);
         var1.method_22918(var3.matrix, var3.x3, var3.y3, var3.z3).method_22913(1.0F, 1.0F).method_39415(var3.color);
         var1.method_22918(var3.matrix, var3.x4, var3.y4, var3.z4).method_22913(0.0F, 1.0F).method_39415(var3.color);
      }

      class_286.method_43433(var1.method_60800());
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.enableCull();
      RenderSystem.depthMask(true);
      RenderSystem.disableBlend();
   }

   private void method0521() {
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(770, 32772);
      RenderSystem.enableDepthTest();
      RenderSystem.depthMask(false);
      class_287 var1 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_29344, class_290.field_1576);

      for (Ambience.ColoredVertex var3 : this.field1116) {
         var1.method_22918(var3.matrix, var3.x, var3.y, var3.z).method_39415(var3.color);
      }

      RenderSystem.setShader(class_10142.field_53876);
      GL11.glHint(3154, 4354);
      GL11.glEnable(2848);
      class_286.method_43433(var1.method_60800());
      GL11.glDisable(2848);
      RenderSystem.depthMask(true);
      RenderSystem.disableBlend();
   }

   private void method0516() {
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(770, 32772);
      RenderSystem.enableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.disableCull();
      RenderSystem.setShaderTexture(0, field1393);
      RenderSystem.setShader(class_10142.field_53880);
      class_287 var1 = RenderSystem.renderThreadTesselator().method_60827(class_5596.field_27382, class_290.field_1575);

      for (Ambience.SkyMesh var3 : this.field1124) {
         var1.method_22918(var3.matrix, var3.x1, var3.y1, var3.z1).method_22913(0.0F, 0.0F).method_39415(var3.color);
         var1.method_22918(var3.matrix, var3.x2, var3.y2, var3.z2).method_22913(1.0F, 0.0F).method_39415(var3.color);
         var1.method_22918(var3.matrix, var3.x3, var3.y3, var3.z3).method_22913(1.0F, 1.0F).method_39415(var3.color);
         var1.method_22918(var3.matrix, var3.x4, var3.y4, var3.z4).method_22913(0.0F, 1.0F).method_39415(var3.color);
      }

      class_286.method_43433(var1.method_60800());
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.enableCull();
      RenderSystem.depthMask(true);
      RenderSystem.disableBlend();
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field1191.clear();
      this.field1134.clear();
   }

   @Override
   public void method2078() {
      super.method2078();
      this.field1191.clear();
      this.field1134.clear();
   }

   private static class SkyObject {
      Ambience.SkyObjectType field0569;
      double field0002;
      double field1409;
      double field0956;
      double field0757;
      double field1241;
      double field0313;
      double field0176;
      double field0457;
      double field1613;
      int field1539;
      int field1705;
      float field1136;
      float field1087;
      float field1196;
      float field0871;
      float field0826;
      boolean field0931;
      boolean field1350;
      int field1293;
      double field1368;
      double field0384;
      double field0350;
      float field0423;
      float field0255;
      double[] field0241;
      double[] field0303;
      double[] field0539;
      int field0502;
   }

   private enum SkyObjectType {
      field0569,
      field0006,
      field1413,
      field0960,
      field0761,
      field1245,
      field0317,
      field0180,
      field0461,
      field1617,
      field1541,
      field1707,
      field1139,
      field1090,
      field1199;
   }

   private record ColoredVertex(Matrix4f matrix, float x, float y, float z, int color) {
      public Matrix4f method0577() {
         return this.matrix;
      }

      public float method0002() {
         return this.x;
      }

      public float method2047() {
         return this.y;
      }

      public float method1762() {
         return this.z;
      }

      public int method1604() {
         return this.color;
      }
   }

   private record SkyMesh(
      Matrix4f matrix, float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4, int color
   ) {
      public Matrix4f method0577() {
         return this.matrix;
      }

      public float method0002() {
         return this.x1;
      }

      public float method2047() {
         return this.y1;
      }

      public float method1762() {
         return this.z1;
      }

      public float method1603() {
         return this.x2;
      }

      public float method1946() {
         return this.y2;
      }

      public float method0413() {
         return this.z2;
      }

      public float method0355() {
         return this.x3;
      }

      public float method0483() {
         return this.y3;
      }

      public float method2213() {
         return this.z3;
      }

      public float method2182() {
         return this.x4;
      }

      public float method2253() {
         return this.y4;
      }

      public float method1901() {
         return this.z4;
      }

      public int method1879() {
         return this.color;
      }
   }

   private record SkyLayer(
      Matrix4f matrix,
      float x1,
      float y1,
      float z1,
      int c1,
      float x2,
      float y2,
      float z2,
      int c2,
      float x3,
      float y3,
      float z3,
      int c3,
      float x4,
      float y4,
      float z4,
      int c4
   ) {
      public Matrix4f method0577() {
         return this.matrix;
      }

      public float method0002() {
         return this.x1;
      }

      public float method2047() {
         return this.y1;
      }

      public float method1762() {
         return this.z1;
      }

      public int method1604() {
         return this.c1;
      }

      public float method1946() {
         return this.x2;
      }

      public float method0413() {
         return this.y2;
      }

      public float method0355() {
         return this.z2;
      }

      public int method0484() {
         return this.c2;
      }

      public float method2213() {
         return this.x3;
      }

      public float method2182() {
         return this.y3;
      }

      public float method2253() {
         return this.z3;
      }

      public int method1902() {
         return this.c3;
      }

      public float method1878() {
         return this.x4;
      }

      public float method1928() {
         return this.y4;
      }

      public float method1697() {
         return this.z4;
      }

      public int method1680() {
         return this.c4;
      }
   }

   private static class SkyAnimation {
      double field0565;
      double field0002;
      double field1409;
      double field0956;
      double field0757;
      double field1241;
      double field0313;
      double field0176;
      double field0457;
      int field1615;
      int field1539;
      boolean field1735;
      boolean field1161;

      SkyAnimation(double var1, double var3, double var5, double var7, double var9, double var11, int var13, boolean var14, boolean var15) {
         this.field0565 = var1;
         this.field0002 = var3;
         this.field1409 = var5;
         this.field0956 = var1;
         this.field0757 = var3;
         this.field1241 = var5;
         this.field0313 = var7;
         this.field0176 = var9;
         this.field0457 = var11;
         this.field1615 = 0;
         this.field1539 = var13;
         this.field1735 = var14;
         this.field1161 = var15;
      }
   }
}
