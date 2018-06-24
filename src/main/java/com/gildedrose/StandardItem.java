package com.gildedrose;

public class StandardItem extends Item {

  protected final int MINIMUM_QUALITY = 0;
  private final int MAXIMUM_QUALITY = 50;
  private final int BEFORE_SELL_BY_MODIFIER = 1;
  private final int PAST_SELL_BY_MODIFIER = 2;
  public int qualityChangeRate;
  public int sellInChangeRate;

  public StandardItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
    this.qualityChangeRate = -1;
    this.sellInChangeRate = -1;
  }

  public void updateQuality() {
    quality += qualityChangeRate * sellByModifier();

    checkQualityBounds();
  }

  public void updateSellIn() {
    sellIn += sellInChangeRate;
  }

  protected int sellByModifier() {
    return sellIn > 0 ? BEFORE_SELL_BY_MODIFIER : PAST_SELL_BY_MODIFIER;
  }

  protected void checkQualityBounds() {
    checkMinimumQuality();
    checkMaximumQuality();
  }

  protected void checkMinimumQuality() {
    quality = Math.max(MINIMUM_QUALITY, quality);
  }

  protected void checkMaximumQuality() {
    quality = Math.min(MAXIMUM_QUALITY, quality);
  }

}
