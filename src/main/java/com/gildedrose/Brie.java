package com.gildedrose;

public class Brie extends StandardItem {

  public Brie(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
    this.qualityChangeRate = 1;
  }

}
