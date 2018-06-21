package com.gildedrose.Features;

import static org.junit.Assert.*;

import com.gildedrose.BackstagePass;
import com.gildedrose.Brie;
import com.gildedrose.ConjuredItem;
import com.gildedrose.GildedRose;
import com.gildedrose.StandardItem;
import com.gildedrose.Sulfuras;
import org.junit.Test;

public class GildedRoseTest {

  @Test
  public void itemsKeepNames() {
    StandardItem[] items = new StandardItem[]{new StandardItem("An item", 0, 0)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals("An item", shop.items[0].name);
  }

  @Test
  public void normalItemsLoseQuality() {
    StandardItem[] items = new StandardItem[]{new StandardItem("An item", 10, 10)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(9, shop.items[0].quality);
  }

  @Test
  public void normalItemsLoseSellIn() {
    StandardItem[] items = new StandardItem[]{new StandardItem("An item", 10, 10)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(9, shop.items[0].sellIn);
  }

  @Test
  public void itemsLoseQualityFasterAfterSellIn() {
    StandardItem[] items = new StandardItem[]{new StandardItem("An item", 0, 10)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(8, shop.items[0].quality);
  }

  @Test
  public void qualityStaysAboveZero() {
    StandardItem[] items = new StandardItem[]{new StandardItem("An item", 0, 0)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(0, shop.items[0].quality);
  }

  @Test
  public void agedBrieIncreasesInQuality() {
    Brie[] items = new Brie[]{new Brie("Aged Brie", 1, 0)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(1, shop.items[0].quality);
  }

  @Test
  public void agedBrieIncreasesInQualityFasterAfterSellin() {
    Brie[] items = new Brie[]{new Brie("Aged Brie", 0, 0)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(2, shop.items[0].quality);
  }

  @Test
  public void agedBrieQualityIsNeverMoreThanFifty() {
    Brie[] items = new Brie[]{new Brie("Aged Brie", 0, 50)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(50, shop.items[0].quality);
  }

  @Test
  public void sulfurasDoesNotDecreaseInQuality() {
    Sulfuras[] items = new Sulfuras[]{new Sulfuras("Sulfuras, Hand of Ragnaros", 10, 10)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(10, shop.items[0].quality);
  }

  @Test
  public void sulfurasSellInDoesNotDecrease() {
    Sulfuras[] items = new Sulfuras[]{new Sulfuras("Sulfuras, Hand of Ragnaros", 10, 10)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(10, shop.items[0].sellIn);
  }

  @Test
  public void backStagePassesIncreaseInQuality() {
    BackstagePass[] items = new BackstagePass[]{
        new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 20, 10)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(11, shop.items[0].quality);
  }

  @Test
  public void passesIncreasesQualityByTwoBelowTenDays() {
    BackstagePass[] items = new BackstagePass[]{
        new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 10, 0)};
    GildedRose shop = new GildedRose(items);

    for (int days = 1; days <= 5; days++) {
      shop.updateQuality();
      assertEquals(days * 2, shop.items[0].quality);
    }
  }

  @Test
  public void passesIncreasesQualityByThreeBelowFiveDays() {
    BackstagePass[] items = new BackstagePass[]{
        new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 5, 0)};
    GildedRose shop = new GildedRose(items);

    for (int days = 1; days <= 5; days++) {
      shop.updateQuality();
      assertEquals(days * 3, shop.items[0].quality);
    }
  }

  @Test
  public void passesQualityReducesToZeroAfterSellIn() {
    BackstagePass[] items = new BackstagePass[]{
        new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 0, 25)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(0, shop.items[0].quality);
  }

  @Test
  public void passesQualityDoesNotIncreaseAboveFiftyTenDaysOrMore() {
    BackstagePass[] items = new BackstagePass[]{
        new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 11, 50)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(50, shop.items[0].quality);
  }

  @Test
  public void passesQualityDoesNotIncreaseAboveFiftyTenDaysOrLess() {
    BackstagePass[] items = new BackstagePass[]{
        new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 10, 50)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(50, shop.items[0].quality);
  }

  @Test
  public void passesQualityDoesNotIncreaseAboveFiftyFiveDaysOrLess() {
    BackstagePass[] items = new BackstagePass[]{
        new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 5, 50)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(50, shop.items[0].quality);
  }

  @Test
  public void conjuredQualityDecreasesByTwoBeforeSellBy() {
    ConjuredItem[] items = new ConjuredItem[]{
        new ConjuredItem("Conjured Mana Cake", 3, 6)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(4, shop.items[0].quality);
  }

  @Test
  public void conjuredQualityDecreasesByFourAfterSellBy() {
    ConjuredItem[] items = new ConjuredItem[]{
        new ConjuredItem("Conjured Mana Cake", 0, 6)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(2, shop.items[0].quality);
  }

  @Test
  public void conjuredQualityStaysAboveMaximum() {
    ConjuredItem[] items = new ConjuredItem[]{
        new ConjuredItem("Conjured Mana Cake", 3, 1)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(0, shop.items[0].quality);
  }

  @Test
  public void conjuredQualityStaysAboveMaximumAfterSellBy() {
    ConjuredItem[] items = new ConjuredItem[]{
        new ConjuredItem("Conjured Mana Cake", 0, 3)};
    GildedRose shop = new GildedRose(items);
    shop.updateQuality();

    assertEquals(0, shop.items[0].quality);
  }

}
