package com.gildedrose;

public class Brie extends StandardItem {

  private static final int QUALITY_INCREMENT = 1;
  private static final int BEFORE_SELL_BY_MODIFIER = 1;
  private static final int PAST_SELL_BY_MODIFIER = 2;
  private static final int MAXIMUM_QUALITY = 50;

  public Brie(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    if (belowMaximumQuality()) quality += QUALITY_INCREMENT * sellByModifier();
  }

  private int sellByModifier() {
    if (quality > 48) return BEFORE_SELL_BY_MODIFIER;

    return sellIn >= 0 ? BEFORE_SELL_BY_MODIFIER : PAST_SELL_BY_MODIFIER;
  }

  private boolean belowMaximumQuality() {
    return quality < MAXIMUM_QUALITY;
  }

}
