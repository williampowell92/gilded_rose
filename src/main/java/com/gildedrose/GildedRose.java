package com.gildedrose;

class GildedRose {
  Item[] items;
  
  private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
  private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  private static final String BRIE = "Aged Brie";

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
            zeroQuality(item);
          }
        } else {
          increaseQuality(item);
        }
      }
    }
  }

//  Checks if item is minimum quality AND reduces the item quality
  private void reduceQuality(Item item) {
    if (isItem(SULFURAS, item)) return ;

    if (isMinimumQuality(item)) {
        item.quality = item.quality - 1;
    }
  }

  private boolean isMinimumQuality(Item item) {
    return item.quality > 0;
  }

  private void zeroQuality(Item item) {
    item.quality = 0;
  }

//  Checks if item is below maximum quality AND increases item quality
  private void increaseQuality(Item item) {
    if (item.quality < 50) item.quality = item.quality + 1;
  }

  private void reduceSellIn(Item item) {
    if (!isItem(SULFURAS, item)) {
      item.sellIn = item.sellIn - 1;
    }
  }

  private boolean isItem(String itemName, Item item ) {
    return item.name.equals(itemName);
  }
}