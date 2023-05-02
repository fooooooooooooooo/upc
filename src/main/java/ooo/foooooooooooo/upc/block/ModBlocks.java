package ooo.foooooooooooo.upc.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import ooo.foooooooooooo.upc.Upc;

public final class ModBlocks {
    public static final Block UPC_BLOCK = new UPCBlock();

    public static void registerBlocks() {
        register("upc", UPC_BLOCK);
    }

    @SuppressWarnings("SameParameterValue")
    private static void register(String path, Block block) {
        Registry.register(Registry.BLOCK, Upc.id(path), block);
        Registry.register(Registry.ITEM, Upc.id(path), new BlockItem(block, new FabricItemSettings().group(Upc.TAB)));
    }
}
