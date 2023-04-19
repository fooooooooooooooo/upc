package ooo.foooooooooooo.upc.compat.megane;

import lol.bai.megane.api.provider.EnergyProvider;
import ooo.foooooooooooo.upc.blockentity.UPCStorage;

public class UPCEnergyProvider<T extends UPCStorage> extends EnergyProvider<T> {
    @Override
    public long getStored() {
        return getObject().getStored();
    }

    @Override
    public long getMax() {
        return getObject().getCapacity();
    }
}
