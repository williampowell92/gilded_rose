package com.gildedrose;

public class Brie extends StandardItem {

  private int BRIE_QUALITY_CHANGE_RATE = 1;

  public Brie(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    quality += BRIE_QUALITY_CHANGE_RATE * sellByModifier();

    checkQualityBounds();
  }

}
