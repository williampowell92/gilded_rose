package com.gildedrose;

public class Brie extends Item {
  private static final int QUALITY_INCREMENT = 1;
  private static final int SELL_IN_INCREMENT = 1;
  private static final int BEFORE_SELL_BY_MODIFIER = 1;
  private static final int PAST_SELL_BY_MODIFIER = 2;
  private static final int MAXIMUM_QUALITY = 50;

  public Brie(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void updateQuality() {
    if (belowMaximumQuality()) this.quality += QUALITY_INCREMENT * sellByModifier();
  }

  public void updateSellIn() {
    this.sellIn -= SELL_IN_INCREMENT;
  }

  private int sellByModifier() {
    if (this.quality > 48) return BEFORE_SELL_BY_MODIFIER;

    return this.sellIn >= 0 ? BEFORE_SELL_BY_MODIFIER : PAST_SELL_BY_MODIFIER;
  }

  private boolean belowMaximumQuality() {
    return this.quality < MAXIMUM_QUALITY;
  }
}
