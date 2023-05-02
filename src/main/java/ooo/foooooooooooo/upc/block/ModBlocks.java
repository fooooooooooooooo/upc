package ooo.foooooooooooo.upc.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.registry.Registry;
import ooo.foooooooooooo.upc.Tier;
import ooo.foooooooooooo.upc.Upc;

public final class ModBlocks {
    public static final Block UPC_BLOCK_LV = new UpcBlock(baseSettings("upc"), Tier.Lv);
    public static final Block UPC_BLOCK_MV = new UpcBlock(baseSettings("upc_mv"), Tier.Mv);
    public static final Block UPC_BLOCK_HV = new UpcBlock(baseSettings("upc_hv"), Tier.Hv);
    public static final Block UPC_BLOCK_EV = new UpcBlock(baseSettings("upc_ev"), Tier.Ev);

    private static FabricBlockSettings baseSettings(String dropId) {
        return FabricBlockSettings.of(Material.METAL).strength(0.5F, 10F).drops(Upc.id(dropId));
    }

    @SuppressWarnings("SameParameterValue")
    private static void register(String path, Block block) {
        Registry.register(Registry.BLOCK, Upc.id(path), block);
        Registry.register(Registry.ITEM, Upc.id(path), new BlockItem(block, new FabricItemSettings().group(Upc.TAB)));
    }

    public static void registerBlocks() {
        register("upc", UPC_BLOCK_LV);
        register("upc_mv", UPC_BLOCK_MV);
        register("upc_hv", UPC_BLOCK_HV);
        register("upc_ev", UPC_BLOCK_EV);
    }
}
