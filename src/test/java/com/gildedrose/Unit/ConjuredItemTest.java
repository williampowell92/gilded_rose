package com.gildedrose.Unit;

import static org.junit.Assert.*;

import com.gildedrose.ConjuredItem;
import org.junit.Before;
import org.junit.Test;

public class ConjuredItemTest {

  private ConjuredItem item;

  @Before
  public void setup() {
    item = new ConjuredItem("Conjured Mana Cake", 3, 6);
  }

  @Test
  public void qualityDropsByTwoBeforeSellBy() {
    item.updateQuality();

    assertEquals(4, item.getQuality());
  }

  @Test
  public void differentQualityDropsByTwoBeforeSellBy() {
    item.setQuality(10);
    item.updateQuality();

    assertEquals(8, item.getQuality());
  }

  @Test
  public void qualityDropsByFourAfterSellBy() {
    item.setSellIn(0);
    item.updateQuality();

    assertEquals(2, item.getQuality());
  }

  @Test
  public void qualityCannotReduceToNegative() {
    item.setQuality(1);
    item.updateQuality();

    assertEquals(0, item.getQuality());
  }

  @Test
  public void qualityCannotReduceToNegativeAfterSellBy() {
    item.setQuality(3);
    item.setSellIn(0);
    item.updateQuality();

    assertEquals(0, item.getQuality());
  }

}