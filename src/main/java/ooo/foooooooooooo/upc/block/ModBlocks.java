package ooo.foooooooooooo.upc.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.registry.Registry;
import ooo.foooooooooooo.upc.Upc;

public final class ModBlocks {
    public static final Block UPC_BLOCK = new UPCBlock(FabricBlockSettings.of(Material.METAL).strength(0.5F, 10F).drops(Upc.id("upc")));

    public static void registerBlocks() {
        register("upc", UPC_BLOCK);
    }

    @SuppressWarnings("SameParameterValue")
    private static void register(String path, Block block) {
        Registry.register(Registry.BLOCK, Upc.id(path), block);
        Registry.register(Registry.ITEM, Upc.id(path), new BlockItem(block, new FabricItemSettings().group(Upc.TAB)));
    }
}
