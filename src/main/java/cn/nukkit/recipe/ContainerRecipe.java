package cn.nukkit.recipe;

import cn.nukkit.item.Item;

public class ContainerRecipe extends MixRecipe {
    public ContainerRecipe(Item input, Item ingredient, Item output) {
        super(input, ingredient, output);
    }

    public ContainerRecipe(String recipeId, Item input, Item ingredient, Item output) {
        super(recipeId, input, ingredient, output);
    }

    @Override
    public void registerToCraftingManager(CraftingManager manager) {
        manager.registerContainerRecipe(this);
    }

    @Override
    public RecipeType getType() {
        throw new UnsupportedOperationException();
    }
}
