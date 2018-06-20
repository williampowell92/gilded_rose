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

    assertEquals(brie.getQuality(), 6);
  }

  @Test
  public void updateQualityIncreasesDifferentQualityByOne() {
    brie.setQuality(10);
    brie.updateQuality();

    assertEquals(brie.getQuality(), 11);
  }

  @Test
  public void updateSellInReducesSellInByOne() {
    brie.updateSellIn();

    assertEquals(brie.getSellIn(), 4);
  }

  @Test
  public void updateSellInReducesDifferentSellInByOne() {
    brie.setSellIn(10);
    brie.updateSellIn();

    assertEquals(brie.getSellIn(), 9);
  }

  @Test
  public void updateQualityIncreasesQualityByTwoAfterSellBy() {
    brie.setSellIn(-1);
    brie.updateQuality();

    assertEquals(brie.getQuality(), 7);
  }

  @Test
  public void qualityCannotIncreaseAboveMaximum() {
    brie.setQuality(50);
    brie.updateQuality();

    assertEquals(50, brie.getQuality());
  }
}