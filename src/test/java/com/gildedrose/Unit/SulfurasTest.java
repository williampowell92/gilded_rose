package com.gildedrose.Unit;

import static org.junit.Assert.*;

import com.gildedrose.Sulfuras;
import org.junit.Before;
import org.junit.Test;

public class SulfurasTest {

  private Sulfuras sulfuras;

  @Before
  public void setup() {
    sulfuras = new Sulfuras("Sulfuras, Hand of Ragnaros", 10, 10);
  }

  @Test
  public void updateQualityDoesNotChangeQuality() {
    sulfuras.updateQuality();

    assertEquals(10, sulfuras.getQuality());
  }

  @Test
  public void updateQualityDoesNotChangeDifferentQuality() {
    sulfuras.setQuality(5);
    sulfuras.updateQuality();

    assertEquals(5, sulfuras.getQuality());
  }

  @Test
  public void updateSellInDoesNotChangeSellIn() {
    sulfuras.updateSellIn();

    assertEquals(10, sulfuras.getSellIn());
  }

  @Test
  public void updateSellInDoesNotChangeDifferentSellIn() {
    sulfuras.setSellIn(5);
    sulfuras.updateSellIn();

    assertEquals(5, sulfuras.getSellIn());
  }

}