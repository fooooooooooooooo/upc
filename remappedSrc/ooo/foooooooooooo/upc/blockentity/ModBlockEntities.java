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
        register("upc", UPC_BLOCK_ENTITY);
        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.storage, UPC_BLOCK_ENTITY);
        EnergyApi.MOVEABLE.registerForBlockEntity((blockEntity, direction) -> blockEntity, UPC_BLOCK_ENTITY);
    }    public static final BlockEntityType<UPCBlockEntityLV> UPC_BLOCK_ENTITY
            = FabricBlockEntityTypeBuilder.create(UPCBlockEntityLV::new, ModBlocks.UPC_BLOCK).build();

    @SuppressWarnings({"SameParameterValue", "rawtypes"})
    private static void register(String path, BlockEntityType block) {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Upc.id(path), block);
    }


}
