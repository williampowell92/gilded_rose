package com.gildedrose;

public class StandardItem extends Item {

  final int MINIMUM_QUALITY = 0;
  final int QUALITY_INCREMENT = 1;
  final int BEFORE_SELL_BY_MODIFIER = 1;
  final int PAST_SELL_BY_MODIFIER = 2;
  private static final int SELL_IN_INCREMENT = 1;

  public StandardItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void updateQuality() {
    quality -= QUALITY_INCREMENT * sellByModifier();

    checkMinimumQuality();
  }

  public void updateSellIn() {
    sellIn -= SELL_IN_INCREMENT;
  }

  protected int sellByModifier() {
    return sellIn > 0 ? BEFORE_SELL_BY_MODIFIER : PAST_SELL_BY_MODIFIER;
  }

  protected void checkMinimumQuality() {
    quality = Math.max(MINIMUM_QUALITY, quality);
  }

}
