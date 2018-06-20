package com.gildedrose;

public class BackstagePass extends Item {

  public BackstagePass(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void updateQuality() {
    quality += 1;
    if (sellIn <= 10) quality = 12;
  }
}
