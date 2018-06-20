package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {
  @Test
  public void itemsKeepNames() {
    Item[] items = new Item[] { new Item("An item", 0, 0) };
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals("An item", shop.items[0].name);
  }

  @Test
  public void normalItemsLoseQuality() {
    Item[] items = new Item[] { new Item("An item", 10, 10) };
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(9, shop.items[0].quality);
  }

  @Test
  public void normalItemsLoseSellIn() {
    Item[] items = new Item[] { new Item("An item", 10, 10) };
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(9, shop.items[0].sellIn);
  }

  @Test
  public void itemsLoseQualityFasterAfterSellIn() {
    Item[] items = new Item[] { new Item("An item", 0, 10) };
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(8, shop.items[0].quality);
  }

  @Test
  public void qualityStaysAboveZero() {
    Item[] items = new Item[] { new Item("An item", 0, 0) };
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(0, shop.items[0].quality);
  }

  @Test
  public void agedBrieIncreasesInQuality() {
    Item[] items = new Item[] { new Item("Aged Brie", 1, 0) };
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(1, shop.items[0].quality);
  }

  @Test
  public void agedBrieIncreasesInQualityFasterAfterSellin() {
    Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(2, shop.items[0].quality);
  }

  @Test
  public void agedBrieQualityIsNeverMoreThanFifty() {
    Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(50, shop.items[0].quality);
  }

  @Test
  public void sulfurasDoesNotDecreaseInQuality() {
    Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 10) };
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(10, shop.items[0].quality);
  }

  @Test
  public void sulfurasSellInDoesNotDecrease() {
    Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 10) };
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(10, shop.items[0].sellIn);
  }

  @Test
  public void backStagePassesIncreaseInQuality() {
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10) };
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(11, shop.items[0].quality);
  }

  @Test
  public void passesIncreasesQualityByTwoBelowTenDays() {
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0) };
    GildedRose shop = new GildedRose(items);

    for(int days = 1; days <= 5; days++) {
      shop.updateQuality();
      assertEquals(days * 2, shop.items[0].quality);
    }
  }

  @Test
  public void passesIncreasesQualityByThreeBelowFiveDays() {
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0) };
    GildedRose shop = new GildedRose(items);

    for(int days = 1; days <= 5; days++) {
      shop.updateQuality();
      assertEquals(days * 3, shop.items[0].quality);
    }
  }

  @Test
  public void passesQualityReducesToZeroAfterSellIn() {
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 25) };
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(0, shop.items[0].quality);
  }

  @Test
  public void passesQualityDoesNotIncreaseAboveFiftyTenDaysOrMore() {
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50) };
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(50, shop.items[0].quality);
  }

  @Test
  public void passesQualityDoesNotIncreaseAboveFiftyTenDaysOrLess() {
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50) };
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(50, shop.items[0].quality);
  }

  @Test
  public void passesQualityDoesNotIncreaseAboveFiftyFiveDaysOrLess() {
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50) };
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(50, shop.items[0].quality);
  }
}
