package com.itdev.electronicsstore.database.entity.fields;

public enum Size {
    THIRTEEN(13),
    FOURTEEN(14),
    FIFTEEN(15),
    SEVENTEEN(17);

    private final Integer value;

    Size(Integer val) {
        value = val;
    }

    public Integer getValue() {
        return value;
    }

    public static Size getSize(int value) {
        switch (value) {
            case 13: return THIRTEEN;
            case 14: return FOURTEEN;
            case 15: return FIFTEEN;
            case 17: return SEVENTEEN;
            default: throw new IllegalArgumentException();
        }
    }
}
