package aethereal;

import com.mojang.authlib.GameProfile;
import java.awt.Color;
import java.util.UUID;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_745;
import ua.patch.daamky.api.mixins.accessors.ILimbAnimator;

public class StaticPlayerEntity extends class_745 implements MinecraftAccess {
   public StaticPlayerEntity(class_1657 var1) {
      super(field0796.field_1687, new GameProfile(UUID.randomUUID(), var1.method_5477().getString()));

      try {
         ((StaticPlayerEntityAccessor)this).daamky$setStaticPlayerEntity(true);
      } catch (ClassCastException var3) {
      }

      this.method_5719(var1);
      this.field_5982 = this.method_36454();
      this.field_6004 = this.method_36455();
      this.field_6241 = var1.field_6241;
      this.field_6259 = this.field_6241;
      this.field_6283 = var1.field_6283;
      this.field_6220 = this.field_6283;
      this.field_6038 = this.method_23317();
      this.field_5971 = this.method_23318();
      this.field_5989 = this.method_23321();
      this.method_5660(var1.method_5715());
      this.field_42108.method_48567(0.0F);
      ((ILimbAnimator)this.field_42108).setPos(var1.field_42108.method_48569());
      this.method_18380(var1.method_18376());
   }

   public void method1300(class_243 var1) {
      this.method_23327(var1.field_1352, var1.field_1351, var1.field_1350);
      this.field_6038 = var1.field_1352;
      this.field_5971 = var1.field_1351;
      this.field_5989 = var1.field_1350;
   }

   public void method0713(float var1, boolean var2, Color var3, boolean var4, Color var5, boolean var6) {
      EntityVertexConsumer.method1148(this, true, 1.0F, var1, new EntityVertexConsumer.Quad(var2, var3, var4, var5, var6));
   }
}
