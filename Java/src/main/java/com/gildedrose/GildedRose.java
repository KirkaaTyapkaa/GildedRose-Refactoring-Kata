package com.gildedrose;

class GildedRose {
    Item[] items;

    private static final String Sulf = "Sulfuras, Hand of Ragnaros";
    private static final String Aged = "Aged Brie";
    private static final String BackPass = "Backstage passes to a TAFKAL80ETC concert";

    
    public GildedRose(Item[] items) {
        this.items = items;
    }

    private boolean checkEqual(Item item, String check) {
        return item.name.equals(check);
    }

    
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!checkEqual(items[i], Aged) && !checkEqual(items[i], BackPass)) {
                if (items[i].quality > 0) {
                   if (!checkEqual(items[i], Sulf)) {
                        --items[i].quality;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    ++items[i].quality;

                    if (checkEqual(items[i], BackPass)) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                ++items[i].quality;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                ++items[i].quality;
                            }
                        }
                    }
                }
            }

            if (!checkEqual(items[i], Sulf)) {
                --items[i].sellIn;
            }

            if (items[i].sellIn < 0) {
                if (!checkEqual(items[i], Aged)) {
                    if (!(checkEqual(items[i], BackPass)) {
                        if (items[i].quality > 0) {
                            if (!checkEqual(items[i], Sulf)) {
                                --items[i].quality;
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        ++items[i].quality;
                    }
                }
            }
        }
    }
}
