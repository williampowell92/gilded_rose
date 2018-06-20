package com.gildedrose;

class GildedRose {

  Item[] items;
  
  private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
  private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  private static final String BRIE = "Aged Brie";
  private static final int MAX_QUALITY = 50;
  private static final int MIN_QUALITY = 0;
  private static final int QUALITY_INCREMENT = 1;
  private static final int SELL_IN_INCREMENT = 1;

  public GildedRose(Item[] items) {
      this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      if (!isItem(BRIE, item) && !isItem(BACKSTAGE_PASS, item)) {
        reduceQuality(item);
      } else {
        if (item.quality < 50) {
          increaseQuality(item);

          if (isItem(BACKSTAGE_PASS, item)) {
            if (item.sellIn < 11) {
              increaseQuality(item);
            }

            if (item.sellIn < 6) {
              increaseQuality(item);
            }
          }
        }
      }

      reduceSellIn(item);

      if (item.sellIn < 0) {
        if (!isItem(BRIE, item)) {
          if (!isItem(BACKSTAGE_PASS, item)) {
            reduceQuality(item);
          } else {
            makeQualityMinimum(item);
          }
        } else {
          increaseQuality(item);
        }
      }
    }
  }

  private void reduceQuality(Item item) {
    if (isItem(SULFURAS, item)) return ;

    if (isMinimumQuality(item)) {
        item.quality = item.quality - QUALITY_INCREMENT;
    }
  }

  private boolean isMinimumQuality(Item item) {
    return item.quality > MIN_QUALITY;
  }

  private void makeQualityMinimum(Item item) {
    item.quality = MIN_QUALITY;
  }

//  Checks if item is below maximum quality AND increases item quality
  private void increaseQuality(Item item) {
    if (isBelowMaxQuality(item)) item.quality = item.quality + QUALITY_INCREMENT;
  }

  private boolean isBelowMaxQuality(Item item) {
    return item.quality < MAX_QUALITY;
  }

  private void reduceSellIn(Item item) {
    if (!isItem(SULFURAS, item)) {
      item.sellIn = item.sellIn - SELL_IN_INCREMENT;
    }
  }

  private boolean isItem(String itemName, Item item ) {
    return item.name.equals(itemName);
  }

}