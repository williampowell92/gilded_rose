package com.gildedrose;

public class Sulfuras extends StandardItem {

  public Sulfuras(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
    this.qualityChangeRate = 0;
  }

  @Override
  public void updateSellIn() {
    // Intentionally blank override as Sulfuras' sellIn does not change
  }

}
