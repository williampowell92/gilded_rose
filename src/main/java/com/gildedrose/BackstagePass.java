package com.gildedrose;

public class BackstagePass extends StandardItem {

  private static final int MAXIMUM_QUALITY = 50;

  public BackstagePass(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    incrementQuality();
    addTenSellInLeftBonus();
    addFiveSellInLeftBonus();

    if (sellIn <= 0) {
      quality = 0;
    }
  }

  private void incrementQuality() {
    if (quality < MAXIMUM_QUALITY) {
      quality += 1;
    }
  }

  private void addTenSellInLeftBonus() {
    if (sellIn <= 10) {
      incrementQuality();
    }
  }

  private void addFiveSellInLeftBonus() {
    if (sellIn <= 5) {
      incrementQuality();
    }
  }
}
