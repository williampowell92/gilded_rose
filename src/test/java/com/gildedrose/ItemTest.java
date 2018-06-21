package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
  private Item item;

  @Before
  public void setup() {
    item = new Item("name", 5, 10);
  }

  @Test
  public void isStringCreatesCorrectString() {
    assertEquals("name, 5, 10", item.toString());
  }
}