package com.gildedrose;

public class Brie extends Item {

  public Brie(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void updateQuality() {
    this.quality += 1;
  }

  public void updateSellIn() {
    this.sellIn -= 1;
  }
}
