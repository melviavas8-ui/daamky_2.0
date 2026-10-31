package aethereal;

import lombok.Generated;

public class ProxyEntry {
   private ProxyType field0678;
   private String field0136;
   private int field1411;
   private String field1030;
   private String field0791;
   private transient ProxyEntry.ProxyProtocol field1263 = ProxyEntry.ProxyProtocol.field0675;
   private transient int field0315 = -1;
   private transient String field0208 = "";
   private transient long field0460 = 0L;

   public ProxyEntry() {
      this(ProxyType.field0678, "", 1080, "", "");
   }

   public ProxyEntry(ProxyType var1, String var2, int var3, String var4, String var5) {
      this.field0678 = var1;
      this.field0136 = var2;
      this.field1411 = var3;
      this.field1030 = var4;
      this.field0791 = var5;
   }

   public boolean method0579() {
      return this.field1030 != null && !this.field1030.isEmpty();
   }

   public String method0017() {
      return this.field0678.method0557() + " " + this.field0136 + ":" + this.field1411;
   }

   @Generated
   public ProxyType method2060() {
      return this.field0678;
   }

   @Generated
   public String method1791() {
      return this.field0136;
   }

   @Generated
   public int method1604() {
      return this.field1411;
   }

   @Generated
   public String method1961() {
      return this.field1030;
   }

   @Generated
   public String method0423() {
      return this.field0791;
   }

   @Generated
   public ProxyEntry.ProxyProtocol method0365() {
      return this.field1263;
   }

   @Generated
   public int method0484() {
      return this.field0315;
   }

   @Generated
   public String method2224() {
      return this.field0208;
   }

   @Generated
   public long method2184() {
      return this.field0460;
   }

   @Generated
   public void method0908(ProxyType var1) {
      this.field0678 = var1;
   }

   @Generated
   public void method1013(String var1) {
      this.field0136 = var1;
   }

   @Generated
   public void method0729(int var1) {
      this.field1411 = var1;
   }

   @Generated
   public void method0213(String var1) {
      this.field1030 = var1;
   }

   @Generated
   public void method2134(String var1) {
      this.field0791 = var1;
   }

   @Generated
   public void method0905(ProxyEntry.ProxyProtocol var1) {
      this.field1263 = var1;
   }

   @Generated
   public void method0143(int var1) {
      this.field0315 = var1;
   }

   @Generated
   public void method1846(String var1) {
      this.field0208 = var1;
   }

   @Generated
   public void method0778(long var1) {
      this.field0460 = var1;
   }

   public enum ProxyProtocol {
      field0675,
      field0104,
      field1478,
      field1012;
   }
}
