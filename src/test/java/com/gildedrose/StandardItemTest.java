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

    assertEquals(9, item.getQuality());
  }

  @Test
  public void updateQualityReducesDifferentQualityByOne() {
    item.setQuality(5);
    item.updateQuality();

    assertEquals(4, item.getQuality());
  }

  @Test
  public void updateQualityReducesQualityByTwoAfterSellBy() {
    item.setSellIn(0);
    item.updateQuality();

    assertEquals(8, item.getQuality());
  }

  @Test
  public void qualityCannotReduceToNegative() {
    item.setQuality(0);
    item.updateQuality();

    assertEquals(0, item.getQuality());
  }

  @Test
  public void qualityCannotReduceToNegativeAfterSellBy() {
    item.setSellIn(-1);
    item.setQuality(1);
    item.updateQuality();

    assertEquals(0, item.getQuality());
  }

  @Test
  public void updateSellInReducesSellInByOne() {
    item.updateSellIn();

    assertEquals(9, item.getSellIn());
  }

  @Test
  public void updateSellInReducesDifferentSellInByOne() {
    item.setSellIn(5);
    item.updateSellIn();

    assertEquals(4, item.getSellIn());
  }
}