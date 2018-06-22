package com.gildedrose;

public class Brie extends StandardItem {

  private static final int MAXIMUM_QUALITY = 50;

  public Brie(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    if (belowMaximumQuality()) {
      quality += QUALITY_INCREMENT * brieSellByModifier();
    }
  }

  private int brieSellByModifier() {
    if (quality > 48) {
      return BEFORE_SELL_BY_MODIFIER;
    }

    return sellIn > 0 ? BEFORE_SELL_BY_MODIFIER : PAST_SELL_BY_MODIFIER;
  }

  private boolean belowMaximumQuality() {
    return quality < MAXIMUM_QUALITY;
  }

}
