package ooo.foooooooooooo.upc.upc.blockentity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import ooo.foooooooooooo.upc.upc.Upc;
import ooo.foooooooooooo.upc.upc.block.ModBlocks;

public final class ModBlockEntities {
    public static final BlockEntityType<UPCBlockEntity> UPC_BLOCK_ENTITY
            = FabricBlockEntityTypeBuilder.create(UPCBlockEntity::new, ModBlocks.UPC_BLOCK).build();

    public static void registerBlockEntities() {
        register("upc", UPC_BLOCK_ENTITY);
    }

    @SuppressWarnings({"SameParameterValue", "rawtypes"})
    private static void register(String path, BlockEntityType block) {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Upc.id(path), block);
    }
}
