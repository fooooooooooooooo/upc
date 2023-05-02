package ooo.foooooooooooo.upc.compat.megane;

import lol.bai.megane.api.MeganeModule;
import lol.bai.megane.api.registry.CommonRegistrar;
import ooo.foooooooooooo.upc.blockentity.UPCBlockEntity;

@SuppressWarnings("unused")
public class UPCMeganeModule implements MeganeModule {
    @Override
    public void registerCommon(CommonRegistrar registrar) {
        registrar.addEnergy(UPCBlockEntity.class, new UPCEnergyProvider<>());
    }
}
