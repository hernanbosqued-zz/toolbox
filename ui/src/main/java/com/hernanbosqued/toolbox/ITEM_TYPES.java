package com.hernanbosqued.toolbox;

enum ITEM_TYPES {
    ERROR(""),
    THUMB("thumb"),
    POSTER("poster");

    String type;

    ITEM_TYPES(String type) {
        this.type = type;
    }

    static ITEM_TYPES fromOrdinal(int pos) {
        ITEM_TYPES[] values = values();

        if (pos < values.length) {
            return values[pos];
        } else {
            return ERROR;
        }
    }

    static ITEM_TYPES get(String type) {
        for (ITEM_TYPES item : ITEM_TYPES.values()) {
            if (item.type.contentEquals(type)) {
                return item;
            }
        }
        return ERROR;
    }
}
