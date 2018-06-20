package com.gildedrose;

public class StandardItem extends Item {
  private static final int MINIMUM_QUALITY = 0;
  private static final int QUALITY_INCREMENT = 1;
  private static final int SELL_IN_INCREMENT = 1;
  private static final int BEFORE_SELL_BY_MODIFIER = 1;
  private static final int PAST_SELL_BY_MODIFIER = 2;

  public StandardItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void updateQuality() {
    if (aboveMinimumQuality()) this.quality -= QUALITY_INCREMENT * sellByModifier();
  }

  public void updateSellIn() {
    this.sellIn -= SELL_IN_INCREMENT;
  }

  private boolean aboveMinimumQuality() {
    return this.quality > MINIMUM_QUALITY;
  }

  private int sellByModifier() {
    if (this.quality == 1) return BEFORE_SELL_BY_MODIFIER;

    return this.sellIn >= 0 ? BEFORE_SELL_BY_MODIFIER : PAST_SELL_BY_MODIFIER;
  }
}
