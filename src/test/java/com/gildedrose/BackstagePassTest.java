package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BackstagePassTest {

  private BackstagePass pass;

  @Before
  public void setUp() {
    pass = new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 20, 10);
  }

  @Test
  public void qualityIncreasesByOneAboveTenSellIn() {
    pass.updateQuality();

    assertEquals(11, pass.getQuality());
  }

  @Test
  public void differentQualityIncreasesByOneAboveTenSellIn() {
    pass.setQuality(15);
    pass.updateQuality();

    assertEquals(16, pass.getQuality());
  }

  @Test
  public void qualityIncreasesByTwoFromTenSellIn() {
    pass.setSellIn(10);
    pass.updateQuality();

    assertEquals(12, pass.getQuality());
  }

  @Test
  public void differentQualityIncreasesByTwoFromTenSellIn() {
    pass.setSellIn(10);
    pass.setQuality(15);
    pass.updateQuality();

    assertEquals(17, pass.getQuality());
  }

  @Test
  public void qualityIncreasesByThreeFromFiveSellIn() {
    pass.setSellIn(5);
    pass.updateQuality();

    assertEquals(13, pass.getQuality());
  }

  @Test
  public void differentQualityIncreasesByThreeFromFiveSellIn() {
    pass.setSellIn(5);
    pass.setQuality(15);
    pass.updateQuality();

    assertEquals(18, pass.getQuality());
  }

  @Test
  public void qualityCannotIncreaseAboveMaximumAboveTenDaysLeft() {
    pass.setQuality(50);
    pass.updateQuality();

    assertEquals(50, pass.getQuality());
  }

}