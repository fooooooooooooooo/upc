package ooo.foooooooooooo.upc;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import ooo.foooooooooooo.upc.block.ModBlocks;
import ooo.foooooooooooo.upc.blockentity.ModBlockEntities;

public class Upc implements ModInitializer {
    public static final String MOD_ID = "upc";
    public static final ItemGroup TAB =
        FabricItemGroupBuilder.build(new Identifier(MOD_ID, "tab"), () -> new ItemStack(ModBlocks.UPC_BLOCK_LV));

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        ModBlocks.registerBlocks();
        ModBlockEntities.registerBlockEntities();
    }
}
