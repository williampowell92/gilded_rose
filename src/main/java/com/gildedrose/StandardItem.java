package com.gildedrose;

public class StandardItem extends Item {

  public StandardItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void updateQuality() {
    this.quality = 9;
  }
}