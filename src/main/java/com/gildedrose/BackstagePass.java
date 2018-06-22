package com.gildedrose;

public class BackstagePass extends StandardItem {

  public BackstagePass(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    incrementQuality();
    addTenSellInLeftBonus();
    addFiveSellInLeftBonus();

    checkNegativeSellIn();
    checkQualityBounds();
  }

  private void incrementQuality() {
    quality += 1;
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

  private void checkNegativeSellIn() {
    if (sellIn <= 0) quality = MINIMUM_QUALITY;
  }
}
