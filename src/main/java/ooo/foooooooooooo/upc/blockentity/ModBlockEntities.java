package ooo.foooooooooooo.upc.blockentity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import ooo.foooooooooooo.upc.Tier;
import ooo.foooooooooooo.upc.Upc;
import ooo.foooooooooooo.upc.api.modern_industrialization.EnergyApi;
import ooo.foooooooooooo.upc.block.ModBlocks;
import team.reborn.energy.api.EnergyStorage;

public final class ModBlockEntities {
    public static final BlockEntityType<UpcBlockEntity> UPC_BLOCK_ENTITY_LV =
        createUpcBlockEntity(Tier.Lv, ModBlocks.UPC_BLOCK_LV);
    public static final BlockEntityType<UpcBlockEntity> UPC_BLOCK_ENTITY_MV =
        createUpcBlockEntity(Tier.Mv, ModBlocks.UPC_BLOCK_MV);
    public static final BlockEntityType<UpcBlockEntity> UPC_BLOCK_ENTITY_HV =
        createUpcBlockEntity(Tier.Hv, ModBlocks.UPC_BLOCK_HV);
    public static final BlockEntityType<UpcBlockEntity> UPC_BLOCK_ENTITY_EV =
        createUpcBlockEntity(Tier.Ev, ModBlocks.UPC_BLOCK_EV);

    private static BlockEntityType<UpcBlockEntity> createUpcBlockEntity(Tier tier, Block block) {
        return FabricBlockEntityTypeBuilder.create((pos, state) -> new UpcBlockEntity(pos, state, tier), block).build();
    }

    private static void register(String path, BlockEntityType<UpcBlockEntity> block) {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Upc.id(path), block);

        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.storage, block);

        EnergyApi.MOVEABLE.registerForBlockEntity((blockEntity, direction) -> blockEntity, block);
    }

    public static void registerBlockEntities() {
        register("upc", UPC_BLOCK_ENTITY_LV);
        register("upc_mv", UPC_BLOCK_ENTITY_MV);
        register("upc_hv", UPC_BLOCK_ENTITY_HV);
        register("upc_ev", UPC_BLOCK_ENTITY_EV);
    }
}
