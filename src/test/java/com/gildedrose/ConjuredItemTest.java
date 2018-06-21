package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;

public class ConjuredItemTest {

  private ConjuredItem item;

  @Before
  public void setup() {
    item = new ConjuredItem("Conjured Mana Cake", 3, 6);
  }

}