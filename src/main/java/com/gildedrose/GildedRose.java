package com.gildedrose;

import java.util.ArrayList;

public class GildedRose {

  public final StandardItem[] items;

  public GildedRose(Item[] items) {
    this.items = convertItems(items);
  }

  public void updateQuality() {

    for (StandardItem item : items) {
      item.updateQuality();
      item.updateSellIn();
    }

  }

  private StandardItem[] convertItems(Item[] items) {
    
    ArrayList<StandardItem> convertedItems = new ArrayList<>();

    for (Item item : items) {
      if(item.getName() == "Aged Brie") {
        convertedItems.add(new Brie(item.getName(), item.getSellIn(), item.getQuality()));
      } else if (item.getName() == "Sulfuras, Hand of Ragnaros") {
        convertedItems.add(new Sulfuras(item.getName(), item.getSellIn(), item.getQuality()));
      } else if (item.getName() == "Backstage passes to a TAFKAL80ETC concert") {
        convertedItems.add(new BackstagePass(item.getName(), item.getSellIn(), item.getQuality()));
      } else if (item.getName().startsWith("Conjured")) {
        convertedItems.add(new ConjuredItem(item.getName(), item.getSellIn(), item.getQuality()));
      } else {
        convertedItems.add(new StandardItem(item.getName(), item.getSellIn(), item.getQuality()));
      }
    }

    return convertedItems.toArray(new StandardItem[convertedItems.size()]);

  }

}