package aethereal;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public final class MsdfFontMetadata {
   private MsdfFontMetadata.Metrics atlas;
   private MsdfFontMetadata.KerningPair metrics;
   private List<MsdfFontMetadata.Atlas> glyphs;
   @SerializedName("kerning")
   private List<MsdfFontMetadata.Bounds> kernings;

   public MsdfFontMetadata.Metrics method0541() {
      return this.atlas;
   }

   public MsdfFontMetadata.KerningPair method0009() {
      return this.metrics;
   }

   public List<MsdfFontMetadata.Atlas> method2068() {
      return this.glyphs;
   }

   public List<MsdfFontMetadata.Bounds> method1793() {
      return this.kernings;
   }

   public static final class Atlas {
      private int unicode;
      private float advance;
      private MsdfFontMetadata.Glyph planeBounds;
      private MsdfFontMetadata.Glyph atlasBounds;

      public int method0531() {
         return this.unicode;
      }

      public float method0002() {
         return this.advance;
      }

      public MsdfFontMetadata.Glyph method2055() {
         return this.planeBounds;
      }

      public MsdfFontMetadata.Glyph method1776() {
         return this.atlasBounds;
      }
   }

   public static final class Glyph {
      private float left;
      private float top;
      private float right;
      private float bottom;

      public float method0530() {
         return this.left;
      }

      public float method0002() {
         return this.top;
      }

      public float method2047() {
         return this.right;
      }

      public float method1762() {
         return this.bottom;
      }
   }

   public static final class Metrics {
      @SerializedName("distanceRange")
      private float range;
      private float width;
      private float height;

      public float method0530() {
         return this.range;
      }

      public float method0002() {
         return this.width;
      }

      public float method2047() {
         return this.height;
      }
   }

   public static final class Bounds {
      @SerializedName("unicode1")
      private int leftChar;
      @SerializedName("unicode2")
      private int rightChar;
      private float advance;

      public int method0531() {
         return this.leftChar;
      }

      public int method0003() {
         return this.rightChar;
      }

      public float method2047() {
         return this.advance;
      }
   }

   public static final class KerningPair {
      private float lineHeight;
      private float ascender;
      private float descender;

      public float method0530() {
         return this.lineHeight;
      }

      public float method0002() {
         return this.ascender;
      }

      public float method2047() {
         return this.descender;
      }

      public float method1762() {
         return this.lineHeight + this.descender;
      }
   }
}
