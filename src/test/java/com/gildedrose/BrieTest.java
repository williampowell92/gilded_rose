package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BrieTest {
  private Brie brie;

  @Before
  public void setup() {
    brie = new Brie("Aged Brie", 5, 5);
  }

  @Test
  public void updateQualityIncreasesQualityByOne() {
    brie.updateQuality();

    assertEquals(6, brie.getQuality());
  }

  @Test
  public void updateQualityIncreasesDifferentQualityByOne() {
    brie.setQuality(10);
    brie.updateQuality();

    assertEquals(11, brie.getQuality());
  }

  @Test
  public void updateQualityIncreasesQualityByTwoAfterSellBy() {
    brie.setSellIn(0);
    brie.updateQuality();

    assertEquals(7, brie.getQuality());
  }

  @Test
  public void qualityCannotIncreaseAboveMaximum() {
    brie.setQuality(50);
    brie.updateQuality();

    assertEquals(50, brie.getQuality());
  }

  @Test
  public void qualityCannotIncreaseAboveMaximumPastSellBy() {
    brie.setQuality(49);
    brie.setSellIn(-1);
    brie.updateQuality();

    assertEquals(50, brie.getQuality());
  }
}