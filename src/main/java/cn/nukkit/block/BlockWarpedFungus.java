package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.event.level.StructureGrowEvent;
import cn.nukkit.level.generator.object.BlockManager;
import cn.nukkit.level.generator.object.legacytree.LegacyWarpedTree;
import cn.nukkit.utils.random.NukkitRandomSource;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class BlockWarpedFungus extends BlockFungus {
    public static final BlockProperties PROPERTIES = new BlockProperties(WARPED_FUNGUS);

    @Override
    @NotNull public BlockProperties getProperties() {
        return PROPERTIES;
    }

    public BlockWarpedFungus() {
        this(PROPERTIES.getDefaultState());
    }

    public BlockWarpedFungus(BlockState blockstate) {
        super(blockstate);
    }

    private final LegacyWarpedTree feature = new LegacyWarpedTree();

    @Override
    public String getName() {
        return "Warped Fungus";
    }

    @Override
    protected boolean canGrowOn(Block support) {
        if (support.getId().equals(WARPED_NYLIUM)) {
            for (int i = 1; i <= this.feature.getTreeHeight(); i++) {
                if (!this.up(i).isAir()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean grow(@Nullable Player cause) {
        NukkitRandomSource nukkitRandom = new NukkitRandomSource();
        BlockManager blockManager = new BlockManager(this.getLevel());
        this.feature.placeObject(blockManager, this.getFloorX(), this.getFloorY(), this.getFloorZ(), nukkitRandom);
        StructureGrowEvent ev = new StructureGrowEvent(this, blockManager.getBlocks());
        this.level.getServer().getPluginManager().callEvent(ev);
        if (ev.isCancelled()) {
            return false;
        }
        blockManager.apply(ev.getBlockList());
        return true;
    }
}