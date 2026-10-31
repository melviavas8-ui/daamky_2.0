package aethereal;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.class_1799;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2626;
import net.minecraft.class_2637;
import net.minecraft.class_2666;
import net.minecraft.class_2672;
import net.minecraft.class_2680;
import net.minecraft.class_2818;
import net.minecraft.class_4587;
import net.minecraft.class_2338.class_2339;

public class BlockESP extends Module {
   private final BlockListSetting field0032 = new BlockListSetting("blockesp.blocks")
      .method1007("Blocks")
      .method0210("Blocks to highlight")
      .method2130("Блоки для подсветки");
   private final ColorSetting field1443 = new ColorSetting("blockesp.outline", 74, 214, 160, 255)
      .method1882()
      .method1007("Outline")
      .method0210("Outline color")
      .method2130("Цвет обводки");
   private final FloatSetting field0985 = new FloatSetting("blockesp.range", 48.0F, 16.0F, 128.0F, 8.0F)
      .method1007("Range")
      .method0210("Max render distance (blocks)")
      .method2130("Максимальная дистанция обнаружения");
   private final BooleanSetting field0184 = new BooleanSetting("blockesp.notify", false)
      .method1007("Notify")
      .method0210("Show HUD notification when a target block is found")
      .method2130("Показывать уведомление при нахождении блока");
   private static final int field0459 = 4096;
   private static final int field1615 = 8;
   private final Long2ObjectOpenHashMap<class_2248> field1563 = new Long2ObjectOpenHashMap();
   private final LongOpenHashSet field1725 = new LongOpenHashSet();
   private int field1137 = -1;
   private float field1087 = -1.0F;
   private class_2338 field1216;
   private class_1937 field0888;

   public BlockESP() {
      super("BlockESP", ModuleCategory.field1004, "Outlines selected blocks through walls");
      this.method1013("Подсвечивает выбранные блоки сквозь стены");
      this.method0213("C");
   }

   @Override
   public void method0025() {
      super.method0025();
      this.field1563.clear();
      this.field1725.clear();
      this.field1137 = this.field0032.method1879();
      this.field0888 = field0796.field_1687;
      this.method1735();
   }

   @Override
   public void method2078() {
      super.method2078();
      this.field1563.clear();
      this.field1725.clear();
      this.field0888 = null;
      this.field1216 = null;
   }

   private void method1735() {
      this.field1563.clear();
      if (field0796.field_1687 != null && field0796.field_1724 != null) {
         class_2338 var1 = field0796.field_1724.method_24515();
         this.field1216 = var1;
         this.field1087 = this.field0985.method0492();
         if (this.field0032.method0492().isEmpty()) {
            this.field1725.clear();
         } else {
            int var2 = (int)Math.ceil(this.field0985.method0492().floatValue());
            int var3 = (var2 >> 4) + 1;
            int var4 = var1.method_10263() >> 4;
            int var5 = var1.method_10260() >> 4;

            label41:
            for (int var6 = -var3; var6 <= var3; var6++) {
               for (int var7 = -var3; var7 <= var3; var7++) {
                  if (field0796.field_1687.method_2935().method_12123(var4 + var6, var5 + var7)) {
                     class_2818 var8 = field0796.field_1687.method_8497(var4 + var6, var5 + var7);
                     if (var8 != null) {
                        this.method1375(var8, var1, var2);
                        if (this.field1563.size() >= 4096) {
                           break label41;
                        }
                     }
                  }
               }
            }

            if (this.field0184.method1938() && !this.field1563.isEmpty()) {
               this.method0729(this.field1563.size());
            }
         }
      }
   }

   private void method1375(class_2818 var1, class_2338 var2, int var3) {
      class_1923 var4 = var1.method_12004();
      int var5 = field0796.field_1687.method_31607();
      int var6 = field0796.field_1687.method_31600() + 1;
      int var7 = var3 * var3;
      class_2339 var8 = new class_2339();

      for (int var9 = 0; var9 < 16; var9++) {
         for (int var10 = 0; var10 < 16; var10++) {
            int var11 = var4.method_8326() + var9;
            int var12 = var4.method_8328() + var10;
            int var13 = (var11 - var2.method_10263()) * (var11 - var2.method_10263()) + (var12 - var2.method_10260()) * (var12 - var2.method_10260());
            if (var13 <= var7) {
               for (int var14 = var5; var14 < var6; var14++) {
                  int var15 = var14 - var2.method_10264();
                  if (var13 + var15 * var15 <= var7) {
                     var8.method_10103(var11, var14, var12);
                     class_2680 var16 = var1.method_8320(var8);
                     if (this.field0032.method1253(var16.method_26204())) {
                        this.field1563.put(var8.method_10063(), var16.method_26204());
                        if (this.field1563.size() >= 4096) {
                           return;
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @EventHandler
   public void onTick(PreTickEvent var1) {
      if (!method1974()) {
         if (field0796.field_1687 != this.field0888) {
            this.field0888 = field0796.field_1687;
            this.field1137 = this.field0032.method1879();
            this.field1725.clear();
            this.method1735();
         } else {
            int var2 = this.field0032.method1879();
            if (var2 != this.field1137) {
               this.field1137 = var2;
               this.method1735();
            } else if (!(Math.abs(this.field0985.method0492() - this.field1087) > 0.001F) && !this.method1692()) {
               this.method1754();
            } else {
               this.method1735();
            }
         }
      }
   }

   @EventHandler
   public void onPacket(PacketEvent.Inbound var1) {
      switch (var1.method1970()) {
         case class_2626 var4:
            field0796.execute(() -> this.method1276(var4.method_11309(), var4.method_11308()));
            break;
         case class_2672 var5:
            field0796.execute(() -> this.method0738(var5.method_11523(), var5.method_11524()));
            break;
         case class_2666 var6:
            field0796.execute(() -> this.method1644(var6.comp_1726().field_9181, var6.comp_1726().field_9180));
            break;
         case class_2637 var7:
            field0796.execute(() -> this.method1357(var7));
            break;
         default:
      }
   }

   private void method1276(class_2338 var1, class_2680 var2) {
      if (field0796.field_1724 != null) {
         long var3 = var1.method_10063();
         if (this.field0032.method1253(var2.method_26204())) {
            if (this.field1563.size() >= 4096 && !this.field1563.containsKey(var3)) {
               return;
            }

            boolean var5 = !this.field1563.containsKey(var3);
            this.field1563.put(var3, var2.method_26204());
            if (var5 && this.field0184.method1938()) {
               this.method1254(var2.method_26204(), var1);
            }
         } else {
            this.field1563.remove(var3);
         }
      }
   }

   private void method1254(class_2248 var1, class_2338 var2) {
      String var3 = var1.method_9518().getString();
      String var4 = var3 + " " + var2.method_10263() + ", " + var2.method_10264() + ", " + var2.method_10260();
      class_1799 var5 = new class_1799(var1.method_8389());
      NewHUD.method1053("BlockESP", var4, var5, true);
   }

   private void method0729(int var1) {
      boolean var2 = NewHUD.HudEntry.method0026();
      String var3;
      if (var2) {
         int var5 = var1 % 100;
         int var6 = var1 % 10;
         String var4;
         if (var5 >= 11 && var5 <= 14) {
            var4 = "блоков";
         } else if (var6 == 1) {
            var4 = "блок";
         } else if (var6 >= 2 && var6 <= 4) {
            var4 = "блока";
         } else {
            var4 = "блоков";
         }

         var3 = "Найдено " + var1 + " " + var4;
      } else {
         var3 = "Found " + var1 + (var1 == 1 ? " block" : " blocks");
      }

      Set var9 = new LinkedHashSet<>(this.field1563.values());
      List var10 = new ArrayList<>(var9.size());

      for (class_2248 var7 : var9) {
         class_1799 var8 = new class_1799(var7.method_8389());
         if (!var8.method_7960()) {
            var10.add(var8);
         }
      }

      if (var10.isEmpty()) {
         NewHUD.method1050("BlockESP", var3, "", true);
      } else if (var10.size() == 1) {
         NewHUD.method1053("BlockESP", var3, var10.get(0), true);
      } else {
         NewHUD.method1051("BlockESP", var3, var10, true);
      }
   }

   private void method1357(class_2637 var1) {
      var1.method_30621((var1x, var2) -> this.method1276(new class_2338(var1x), var2));
   }

   private boolean method1692() {
      if (this.field1216 == null) {
         return true;
      }

      class_2338 var1 = field0796.field_1724.method_24515();
      int var2 = var1.method_10263() - this.field1216.method_10263();
      int var3 = var1.method_10264() - this.field1216.method_10264();
      int var4 = var1.method_10260() - this.field1216.method_10260();
      return var2 * var2 + var3 * var3 + var4 * var4 >= 64;
   }

   private void method0738(int var1, int var2) {
      this.field1725.add(this.method1830(var1, var2));
   }

   private void method1754() {
      if (!this.field1725.isEmpty()) {
         if (field0796.field_1687 != null && field0796.field_1724 != null && !this.field0032.method0492().isEmpty()) {
            LongIterator var1 = this.field1725.iterator();

            while (var1.hasNext()) {
               long var2 = var1.nextLong();
               int var4 = this.method0775(var2);
               int var5 = this.method0158(var2);
               if (!this.method2106(var4, var5)) {
                  var1.remove();
               } else if (field0796.field_1687.method_2935().method_12123(var4, var5)) {
                  this.method0148(var4, var5);
                  var1.remove();
               }
            }
         } else {
            this.field1725.clear();
         }
      }
   }

   private void method0148(int var1, int var2) {
      if (field0796.field_1687 != null && field0796.field_1724 != null) {
         if (!this.field0032.method0492().isEmpty()) {
            if (this.method2106(var1, var2)) {
               if (field0796.field_1687.method_2935().method_12123(var1, var2)) {
                  class_2818 var3 = field0796.field_1687.method_8497(var1, var2);
                  if (var3 != null) {
                     this.method1644(var1, var2);
                     int var4 = this.field1563.size();
                     this.method1375(var3, field0796.field_1724.method_24515(), (int)Math.ceil(this.field0985.method0492().floatValue()));
                     int var5 = this.field1563.size() - var4;
                     if (var5 > 0 && this.field0184.method1938()) {
                        this.method0729(var5);
                     }
                  }
               }
            }
         }
      }
   }

   private boolean method2106(int var1, int var2) {
      class_2338 var3 = field0796.field_1724.method_24515();
      int var4 = (int)Math.ceil(this.field0985.method0492().floatValue());
      int var5 = (var4 >> 4) + 1;
      return Math.abs(var1 - (var3.method_10263() >> 4)) > var5 ? false : Math.abs(var2 - (var3.method_10260() >> 4)) <= var5;
   }

   private long method1830(int var1, int var2) {
      return var1 & 4294967295L | (var2 & 4294967295L) << 32;
   }

   private int method0775(long var1) {
      return (int)var1;
   }

   private int method0158(long var1) {
      return (int)(var1 >> 32);
   }

   private void method1644(int var1, int var2) {
      long var3 = (long)var1 << 4;
      long var5 = (long)var2 << 4;
      long var7 = var3 + 15L;
      long var9 = var5 + 15L;
      ObjectIterator var11 = this.field1563.long2ObjectEntrySet().fastIterator();

      while (var11.hasNext()) {
         Entry var12 = (Entry<class_2248>)var11.next();
         class_2338 var13 = class_2338.method_10092(var12.getLongKey());
         if (var13.method_10263() >= var3 && var13.method_10263() <= var7 && var13.method_10260() >= var5 && var13.method_10260() <= var9) {
            var11.remove();
         }
      }
   }

   @EventHandler
   public void onRender3D(WorldRenderEvent.WorldPass var1) {
      if (!method1974()) {
         if (!this.field1563.isEmpty()) {
            class_243 var2 = field0796.field_1724.method_19538();
            float var3 = this.field0985.method0492();
            double var4 = var3 * var3;
            Color var6 = this.field1443.method1726();
            class_4587 var7 = new class_4587();
            ObjectIterator var8 = this.field1563.long2ObjectEntrySet().fastIterator();

            while (var8.hasNext()) {
               Entry var9 = (Entry<class_2248>)var8.next();
               class_2338 var10 = class_2338.method_10092(var9.getLongKey());
               if (!(var10.method_19770(var2) > var4)) {
                  WorldRenderHelper.method2173(var7, new class_238(var10), var6);
               }
            }
         }
      }
   }
}
