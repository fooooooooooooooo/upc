package ooo.foooooooooooo.upc.upc.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class UPCBlockEntity extends BlockEntity {
    public UPCBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityType.BELL, pos, state);
    }
}
