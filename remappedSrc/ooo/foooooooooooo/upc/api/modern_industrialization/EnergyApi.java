package ooo.foooooooooooo.upc.api.modern_industrialization;

import aztech.modern_industrialization.api.energy.EnergyMoveable;
import net.fabricmc.fabric.api.lookup.v1.block.BlockApiLookup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class EnergyApi {
    public static final BlockApiLookup<EnergyMoveable, Direction> MOVEABLE = BlockApiLookup
            .get(new Identifier("modern_industrialization:energy_moveable"), EnergyMoveable.class, Direction.class);

}
