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

    private boolean checkNoSpecial(Item item) {
    return !checkEqual(item, Aged) 
            && !checkEqual(item, BackPass) 
            && !checkEqual(item, Sulf) 
            && item.quality > 0;
    }

    private boolean qualityLowThen50(Item item) {
    return item.quality < 50;
    }

    private void increaseIfSellin(Item item) {
    if (item.sellIn < 11 && qualityLowThen50(item)) {
        ++item.quality;
    }
    if (item.sellIn < 6 && qualityLowThen50(item)) {
        ++item.quality;
    }
    }

    private void processQualityIncrease(Item item) {
    if (qualityLowThen50(item)) {
        ++item.quality;

        if (checkEqual(item, BackPass)) {
            increaseIfSellin(item);
        }
    }
    }

     public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (checkNoSpecial(items[i])) {
                    --items[i].quality;
                }
            } else {
               processQualityIncrease(items[i]);
            }

            if (!checkEqual(items[i], Sulf)) {
                --items[i].sellIn;
            }

            if (items[i].sellIn < 0) {
                if (!checkEqual(items[i], Aged)) {
                    if (!(checkEqual(items[i], BackPass)) && items[i].quality > 0 && !checkEqual(items[i], Sulf)) {
                         --items[i].quality;
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

