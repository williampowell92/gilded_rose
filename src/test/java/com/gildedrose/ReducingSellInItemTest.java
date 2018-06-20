package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReducingSellInItemTest {

  private ReducingSellInItem item;

  @Before
  public void setUp() {
    item = new ReducingSellInItem("An item", 10, 10);
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

}