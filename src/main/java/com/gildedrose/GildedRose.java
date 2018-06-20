package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
      for (int i = 0; i < items.length; i++) {
        if (!items[i].name.equals("Aged Brie")
              && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
          if (items[i].quality > 0) {
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
              reduceQuality(i);
            }
          }
        } else {
          if (items[i].quality < 50) {
            increaseQuality(i);

            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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

        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
          reduceSellIn(i);
        }

        if (items[i].sellIn < 0) {
          if (!items[i].name.equals("Aged Brie")) {
            if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
              if (items[i].quality > 0) {
                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
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
    
    public void reduceQuality(int index) {
      items[index].quality = items[index].quality - 1;
    }
    
    public void increaseQuality(int index) {
      items[index].quality = items[index].quality + 1;
    }
    
    public void reduceSellIn(int index) {
      items[index].sellIn = items[index].sellIn - 1;
    }
}