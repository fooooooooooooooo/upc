package ooo.foooooooooooo.upc.blockentity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import ooo.foooooooooooo.upc.Upc;
import ooo.foooooooooooo.upc.api.modern_industrialization.EnergyApi;
import ooo.foooooooooooo.upc.block.ModBlocks;
import team.reborn.energy.api.EnergyStorage;

public final class ModBlockEntities {
    public static void registerBlockEntities() {
        register("upc", UPC_BLOCK_ENTITY_LV);
        register("upc_mv", UPC_BLOCK_ENTITY_MV);
        register("upc_hv", UPC_BLOCK_ENTITY_HV);
        register("upc_ev", UPC_BLOCK_ENTITY_EV);
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.storage, UPC_BLOCK_ENTITY_LV);
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.storage, UPC_BLOCK_ENTITY_MV);
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.storage, UPC_BLOCK_ENTITY_HV);
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.storage, UPC_BLOCK_ENTITY_EV);
        EnergyApi.MOVEABLE.registerForBlockEntity((blockEntity, direction) -> blockEntity, UPC_BLOCK_ENTITY_LV);
        EnergyApi.MOVEABLE.registerForBlockEntity((blockEntity, direction) -> blockEntity, UPC_BLOCK_ENTITY_MV);
        EnergyApi.MOVEABLE.registerForBlockEntity((blockEntity, direction) -> blockEntity, UPC_BLOCK_ENTITY_HV);
        EnergyApi.MOVEABLE.registerForBlockEntity((blockEntity, direction) -> blockEntity, UPC_BLOCK_ENTITY_EV);
    }
    public static final BlockEntityType<UPCBlockEntityLV> UPC_BLOCK_ENTITY_LV
            = FabricBlockEntityTypeBuilder.create(UPCBlockEntityLV::new, ModBlocks.UPC_BLOCK_LV).build();
    public static final BlockEntityType<UPCBlockEntityMV> UPC_BLOCK_ENTITY_MV
            = FabricBlockEntityTypeBuilder.create(UPCBlockEntityMV::new, ModBlocks.UPC_BLOCK_MV).build();

    public static final BlockEntityType<UPCBlockEntityHV> UPC_BLOCK_ENTITY_HV
            = FabricBlockEntityTypeBuilder.create(UPCBlockEntityHV::new, ModBlocks.UPC_BLOCK_HV).build();

    public static final BlockEntityType<UPCBlockEntityEV> UPC_BLOCK_ENTITY_EV
            = FabricBlockEntityTypeBuilder.create(UPCBlockEntityEV::new, ModBlocks.UPC_BLOCK_EV).build();

    @SuppressWarnings({"SameParameterValue", "rawtypes"})
    private static void register(String path, BlockEntityType block) {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Upc.id(path), block);
    }


}
