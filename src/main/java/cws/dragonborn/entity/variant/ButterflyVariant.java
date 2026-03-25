package cws.dragonborn.entity.variant;

public enum ButterflyVariant {
    BLUE(0),
    ORANGE(1);

    private final int id;

    ButterflyVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static ButterflyVariant byId(int id) {
        for (ButterflyVariant v : values()) {
            if (v.id == id) return v;
        }
        return BLUE;
    }
}

