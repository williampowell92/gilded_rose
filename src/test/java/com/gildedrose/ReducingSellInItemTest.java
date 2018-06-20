package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;

public class ReducingSellInItemTest {

  private ReducingSellInItem item;

  @Before
  public void setUp() {
    item = new ReducingSellInItem("An item", 10, 10);
  }

}