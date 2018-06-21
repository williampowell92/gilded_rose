package com.gildedrose;

public class ConjuredItem extends StandardItem {

  ConjuredItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    quality = 4;
  }
}
