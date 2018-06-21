package com.gildedrose;

public class BackstagePass extends Item {

  private static final int MAXIMUM_QUALITY = 50;

  public BackstagePass(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void updateQuality() {
    incrementQuality();
    addTenSellInLeftBonus();
    addFiveSellInLeftBonus();
  }

  private void incrementQuality() {
    if (quality < MAXIMUM_QUALITY) quality += 1;
  }

  private void addTenSellInLeftBonus() {
    if (sellIn <= 10) incrementQuality();
  }

  private void addFiveSellInLeftBonus() {
    if (sellIn <= 5) incrementQuality();
  }
}
