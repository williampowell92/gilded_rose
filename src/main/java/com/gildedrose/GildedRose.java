package com.gildedrose;

class GildedRose {

  final StandardItem[] items;

  public GildedRose(StandardItem[] items) {
    this.items = items;
  }

  public void updateQuality() {

    for (StandardItem item : items) {
      item.updateQuality();
      item.updateSellIn();
    }

  }

}