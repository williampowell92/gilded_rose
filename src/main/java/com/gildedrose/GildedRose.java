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
    for (int i = 0; i < items.length; i++) {
      if (!items[i].name.equals(BRIE)
            && !items[i].name.equals(BACKSTAGE_PASS)) {
        if (items[i].quality > 0) {
          if (!items[i].name.equals(SULFURAS)) {
            reduceQuality(i);
          }
        }
      } else {
        if (items[i].quality < 50) {
          increaseQuality(i);

          if (items[i].name.equals(BACKSTAGE_PASS)) {
            if (items[i].sellIn < 11) {
              if (items[i].quality < 50) {
                increaseQuality(i);
              }
            }

            if (items[i].sellIn < 6) {
              if (items[i].quality < 50) {
                increaseQuality(i);
              }
            }
          }
        }
      }

      if (!items[i].name.equals(SULFURAS)) {
        reduceSellIn(i);
      }

      if (items[i].sellIn < 0) {
        if (!items[i].name.equals(BRIE)) {
          if (!items[i].name.equals(BACKSTAGE_PASS)) {
            if (items[i].quality > 0) {
              if (!items[i].name.equals(SULFURAS)) {
                reduceQuality(i);
              }
            }
          } else {
            items[i].quality = items[i].quality - items[i].quality;
          }
        } else {
          if (items[i].quality < 50) {
            increaseQuality(i);
          }
        }
      }
    }
  }
  
  private void reduceQuality(int index) {
    items[index].quality = items[index].quality - 1;
  }

  private void increaseQuality(int index) {
    items[index].quality = items[index].quality + 1;
  }

  private void reduceSellIn(int index) {
    items[index].sellIn = items[index].sellIn - 1;
  }
}