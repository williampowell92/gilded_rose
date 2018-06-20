package com.gildedrose;

public class ReducingSellInItem extends Item {

  private static final int SELL_IN_INCREMENT = 1;

  public ReducingSellInItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void updateSellIn() {
    sellIn -= SELL_IN_INCREMENT;
  }

}
