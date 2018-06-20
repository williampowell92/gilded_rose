package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SulfurasTest {

  private Sulfuras sulfuras;

  @Before
  public void setup() {
    sulfuras = new Sulfuras("Sulfuras", 10, 10);
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

}