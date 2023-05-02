package ooo.foooooooooooo.upc;

import aztech.modern_industrialization.api.energy.CableTier;

public enum Tier {
    Lv(192000, 256, 256),
    Mv(768000, 1024, 1024),
    Hv(6144000, 8192, 8192),
    Ev(49152000, 65536, 65536);

    public final int capacity;
    public final int maxInsert;
    public final int maxExtract;

    Tier(int capacity, int maxInsert, int maxExtract) {
        this.capacity = capacity;
        this.maxInsert = maxInsert;
        this.maxExtract = maxExtract;
    }

    public boolean Compatible(CableTier cableTier) {
        return this.ordinal() >= cableTier.ordinal();
    }
}
