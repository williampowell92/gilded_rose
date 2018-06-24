package com.gildedrose;

public class ConjuredItem extends StandardItem {

  public ConjuredItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
    this.qualityChangeRate = -2;
  }

}
