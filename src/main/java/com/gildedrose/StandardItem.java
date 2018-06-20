package com.gildedrose;

public class StandardItem extends Item {
  private static final int MINIMUM_QUALITY = 0;
  private static final int QUALITY_INCREMENT = 1;
  private static final int SELL_IN_INCREMENT = 1;

  public StandardItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void updateQuality() {
    if (aboveMinimumQuality()) this.quality -= QUALITY_INCREMENT;
  }

  public void updateSellIn() {
    this.sellIn -= SELL_IN_INCREMENT;
  }

  private boolean aboveMinimumQuality() {
    return this.quality > MINIMUM_QUALITY;
  }
}
