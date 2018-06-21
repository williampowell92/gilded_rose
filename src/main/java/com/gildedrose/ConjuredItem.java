package com.gildedrose;

public class ConjuredItem extends StandardItem {

  private static final int QUALITY_INCREMENT = 2;
  private static final int BEFORE_SELL_BY_MODIFIER = 1;
  private static final int PAST_SELL_BY_MODIFIER = 2;

  ConjuredItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    quality -= QUALITY_INCREMENT * conjuredSellInModifier();
  }

  private int conjuredSellInModifier() {
    return sellIn > 0 ? BEFORE_SELL_BY_MODIFIER : PAST_SELL_BY_MODIFIER;
  }

}
