package ooo.foooooooooooo.upc.compat.megane;

import lol.bai.megane.api.MeganeModule;
import lol.bai.megane.api.registry.CommonRegistrar;
import ooo.foooooooooooo.upc.blockentity.UpcBlockEntity;

@SuppressWarnings("unused")
public class UPCMeganeModule implements MeganeModule {
    @Override
    public void registerCommon(CommonRegistrar registrar) {
        registrar.addEnergy(UpcBlockEntity.class, new UPCEnergyProvider<>());
    }
}
