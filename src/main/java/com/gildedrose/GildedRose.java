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
      if (!isItem(BRIE, item)
          && !isItem(BACKSTAGE_PASS, item)) {
        if (item.quality > 0) {
          if (!isItem(SULFURAS, item)) {
            reduceQuality(item);
          }
        }
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

      if (!isItem(SULFURAS, item)) {
        reduceSellIn(item);
      }

      if (item.sellIn < 0) {
        if (!isItem(BRIE, item)) {
          if (!isItem(BACKSTAGE_PASS, item)) {
            if (item.quality > 0) {
              if (!isItem(SULFURAS, item)) {
                reduceQuality(item);
              }
            }
          } else {
            reduceQuality(item, item.quality);
          }
        } else {
          increaseQuality(item);
        }
      }
    }
  }
  
  private void reduceQuality(Item item) {
    item.quality = item.quality - 1;
  }

  private void reduceQuality(Item item, int amount) {
    item.quality = item.quality - amount;
  }

  private void increaseQuality(Item item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1;
    }
  }

  private void reduceSellIn(Item item) {
    item.sellIn = item.sellIn - 1;
  }

  private boolean isItem(String itemName, Item item ) {
    return item.name.equals(itemName);
  }
}