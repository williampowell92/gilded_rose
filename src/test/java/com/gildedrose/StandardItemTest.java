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
}