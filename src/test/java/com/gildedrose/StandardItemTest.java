package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StandardItemTest {
  private StandardItem item;

  @Before
  public void setup() {
    item = new StandardItem("Item name", 10, 10);
  }

  @Test
  public void updateQualityReducesQualityByOne() {
    item.updateQuality();

    assertEquals(item.getQuality(), 9);
  }

  @Test
  public void updateQualityReducesDifferentQualityByOne() {
    item.setQuality(5);
    item.updateQuality();

    assertEquals(item.getQuality(), 4);
  }

  @Test
  public void qualityCannotReduceToNegative() {
    item.setQuality(0);
    item.updateQuality();

    assertEquals(item.getQuality(), 0);
  }

  @Test
  public void updateSellInReducesSellInByOne() {
    item.updateSellIn();

    assertEquals(item.getSellIn(), 9);
  }

  @Test
  public void updateSellInReducesDifferentSellInByOne() {
    item.setSellIn(5);
    item.updateSellIn();

    assertEquals(item.getSellIn(), 4);
  }

  @Test
  public void updateQualityReducesQualityByTwoAfterSellBy() {
    item.setSellIn(0);
    item.updateQuality();

    assertEquals(item.getQuality(), 8);
  }
}