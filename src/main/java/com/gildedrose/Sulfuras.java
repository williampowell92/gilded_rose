package com.gildedrose;

public class Sulfuras extends StandardItem {

  public Sulfuras(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    // Intentionally blank override as Sulfuras' quality does not change
  }

  @Override
  public void updateSellIn() {
    // Intentionally blank override as Sulfuras' sellIn does not change
  }

}
