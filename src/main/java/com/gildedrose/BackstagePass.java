package com.gildedrose;

public class BackstagePass extends Item {

  public BackstagePass(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void updateQuality() {
    incrementQuality();
    addTenSellInLeftBonus();
    addFiveSellInLeftBonus();
  }

  private void incrementQuality() {
    quality += 1;
  }

  private void addTenSellInLeftBonus() {
    if (sellIn <= 10) incrementQuality();
  }

  private void addFiveSellInLeftBonus() {
    if (sellIn <= 5) incrementQuality();
  }
}
