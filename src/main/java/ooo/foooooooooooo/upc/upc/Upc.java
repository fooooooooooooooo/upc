package ooo.foooooooooooo.upc.upc;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import ooo.foooooooooooo.upc.upc.block.ModBlocks;
import ooo.foooooooooooo.upc.upc.blockentity.ModBlockEntities;

public class Upc implements ModInitializer {
    public static final String MOD_ID = "upc";

    @Override
    public void onInitialize() {
        ModBlocks.registerBlocks();
        ModBlockEntities.registerBlockEntities();
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
