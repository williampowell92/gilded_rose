package com.gildedrose.Features;

import com.gildedrose.BackstagePass;
import com.gildedrose.Brie;
import com.gildedrose.ConjuredItem;
import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.StandardItem;
import com.gildedrose.Sulfuras;

public class TexttestFixture {

  public static void main(String[] args) {
    System.out.println("OMGHAI!");

    StandardItem[] items = new StandardItem[]{
      new StandardItem("+5 Dexterity Vest", 10, 20), //
      new Brie("Aged Brie", 2, 0), //
      new StandardItem("Elixir of the Mongoose", 5, 7), //
      new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80), //
      new Sulfuras("Sulfuras, Hand of Ragnaros", -1, 80),
      new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20),
      new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 10, 49),
      new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 5, 49),
      new ConjuredItem("Conjured Mana Cake", 3, 6)};

    GildedRose app = new GildedRose(items);

    int days = 2;
    if (args.length > 0) {
      days = Integer.parseInt(args[0]) + 1;
    }

    for (int i = 0; i < days; i++) {
      System.out.println("-------- day " + i + " --------");
      System.out.println("name, sellIn, quality");
      for (Item item : items) {
        System.out.println(item);
      }
      System.out.println();
      app.updateQuality();
    }
  }

}
