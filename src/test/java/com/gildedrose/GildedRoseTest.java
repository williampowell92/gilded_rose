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

}
