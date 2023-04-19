package ooo.foooooooooooo.upc.blockentity;

import J;
import aztech.modern_industrialization.api.energy.CableTier;
import aztech.modern_industrialization.api.energy.EnergyExtractable;
import aztech.modern_industrialization.api.energy.EnergyInsertable;
import aztech.modern_industrialization.util.Simulation;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public class UPCBlockEntity extends BlockEntity implements EnergyInsertable, EnergyExtractable, UPCStorage {
    public final SimpleEnergyStorage storage = new SimpleEnergyStorage(16_384, 16_384, 16_384);

    public UPCBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.UPC_BLOCK_ENTITY, pos, state);
    }

    @Override
    @SuppressWarnings("UnstableApiUsage")
    public long extractEnergy(long amount, Simulation simulation) {
        var transaction = Transaction.openOuter();

        var energy = storage.extract(amount, transaction);

        if (simulation.isSimulating()) {
            transaction.abort();
        } else {
            transaction.commit();
        }

        transaction.close();

        return energy;
    }

    @Override
    public boolean canExtract(CableTier cableTier) {
        return true;
    }

    @Override
    @SuppressWarnings("UnstableApiUsage")
    public long insertEnergy(long amount, Simulation simulation) {
        var transaction = Transaction.openOuter();

        var energy = storage.insert(amount, transaction);

        if (simulation.isSimulating()) {
            transaction.abort();
        } else {
            transaction.commit();
        }

        transaction.close();

        return energy;
    }

    @Override
    public boolean canInsert(CableTier cableTier) {
        return true;
    }

    @Override
    public long getStored() {
        return storage.getAmount();
    }

    @Override
    public long getCapacity() {
        return storage.getCapacity();
    }
}
