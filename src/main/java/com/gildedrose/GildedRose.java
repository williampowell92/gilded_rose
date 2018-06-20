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
      if (!isItem(BRIE, i)
            && !isItem(BACKSTAGE_PASS, i)) {
        if (items[i].quality > 0) {
          if (!isItem(SULFURAS, i)) {
            reduceQuality(i);
          }
        }
      } else {
        if (items[i].quality < 50) {
          increaseQuality(i);

          if (isItem(BACKSTAGE_PASS, i)) {
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

      if (!isItem(SULFURAS, i)) {
        reduceSellIn(i);
      }

      if (items[i].sellIn < 0) {
        if (!isItem(BRIE, i)) {
          if (!isItem(BACKSTAGE_PASS, i)) {
            if (items[i].quality > 0) {
              if (!isItem(SULFURAS, i)) {
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

  private boolean isItem(String itemName, int index) {
    return items[index].name.equals(itemName);
  }
}