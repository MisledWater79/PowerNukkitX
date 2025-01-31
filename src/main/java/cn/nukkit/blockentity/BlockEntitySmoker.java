package cn.nukkit.blockentity;

import cn.nukkit.block.Block;
import cn.nukkit.inventory.InventoryType;
import cn.nukkit.item.Item;
import cn.nukkit.level.format.IChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.recipe.SmeltingRecipe;


public class BlockEntitySmoker extends BlockEntityFurnace {

    public BlockEntitySmoker(IChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    protected String getFurnaceName() {
        return "Smoker";
    }

    @Override
    protected String getClientName() {
        return SMOKER;
    }

    @Override
    protected String getIdleBlockId() {
        return Block.SMOKER;
    }

    @Override
    protected String getBurningBlockId() {
        return Block.LIT_SMOKER;
    }

    @Override
    protected InventoryType getInventoryType() {
        return InventoryType.SMOKER;
    }

    @Override
    protected SmeltingRecipe matchRecipe(Item raw) {
        return this.server.getCraftingManager().matchSmokerRecipe(raw);
    }

    @Override
    protected int getSpeedMultiplier() {
        return 2;
    }
}
