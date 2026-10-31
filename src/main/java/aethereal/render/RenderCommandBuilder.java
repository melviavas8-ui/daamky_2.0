package aethereal;

public abstract class RenderCommandBuilder<T> {
   public RenderCommandBuilder() {
      this.method0025();
   }

   public final T method0555() {
      Object var1 = this.method2066();
      this.method0025();
      return var1;
   }

   protected abstract void method0025();

   protected abstract T method2066();
}
