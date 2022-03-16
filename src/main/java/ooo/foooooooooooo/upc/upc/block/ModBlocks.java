package ooo.foooooooooooo.upc.upc.block;

import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;
import ooo.foooooooooooo.upc.upc.Upc;

public final class ModBlocks {
    public static final Block UPC_BLOCK = new UPCBlock();

    public static void registerBlocks() {
        register("upc", UPC_BLOCK);
    }

    @SuppressWarnings("SameParameterValue")
    private static void register(String path, Block block) {
        Registry.register(Registry.BLOCK, Upc.id(path), block);
    }
}
