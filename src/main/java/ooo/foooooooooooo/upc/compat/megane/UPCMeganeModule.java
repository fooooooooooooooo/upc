package ooo.foooooooooooo.upc.compat.megane;

import lol.bai.megane.api.MeganeModule;
import lol.bai.megane.api.registry.CommonRegistrar;

public class UPCMeganeModule implements MeganeModule {
    @Override
    public void registerCommon(CommonRegistrar registrar) {
        registrar.addEnergy(UPCBlockEntityLV.class, new UPCEnergyProvider<>());
        registrar.addEnergy(UPCBlockEntityMV.class, new UPCEnergyProvider<>());
    }
}
