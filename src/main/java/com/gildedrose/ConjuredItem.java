package com.gildedrose;

public class ConjuredItem extends StandardItem {

  private static final int CONJURED_QUALITY_CHANGE_RATE = -2;

  public ConjuredItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    quality += CONJURED_QUALITY_CHANGE_RATE * sellByModifier();

    checkMinimumQuality();
  }

}
