package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;

public class BackstagePassTest {

  private BackstagePass pass;

  @Before
  public void setUp() {
    pass = new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 10, 10);
  }

}