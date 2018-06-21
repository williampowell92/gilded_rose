package com.gildedrose;

public class ConjuredItem extends StandardItem {

  private static final int QUALITY_INCREMENT = 2;

  ConjuredItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    quality -= QUALITY_INCREMENT;
  }
}
