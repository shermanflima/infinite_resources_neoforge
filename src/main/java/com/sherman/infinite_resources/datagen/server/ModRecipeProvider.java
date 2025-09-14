package com.sherman.infinite_resources.datagen.server;

import com.sherman.infinite_resources.registry.ModRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {


    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        threeByThreePacker(recipeOutput, RecipeCategory.MISC, ModRegistry.ANCIENT_DEBRIS.get(), Blocks.ANCIENT_DEBRIS);
        threeByThreePacker(recipeOutput, RecipeCategory.MISC, ModRegistry.BUDDING_AMETHYST.get(), Blocks.AMETHYST_BLOCK);
        threeByThreePacker(recipeOutput, RecipeCategory.MISC, ModRegistry.COAL_ORE.get(), Blocks.COAL_BLOCK);
        threeByThreePacker(recipeOutput, RecipeCategory.MISC, ModRegistry.COPPER_ORE.get(), Blocks.RAW_COPPER_BLOCK);
        threeByThreePacker(recipeOutput, RecipeCategory.MISC, ModRegistry.DIAMOND_ORE.get(), Blocks.DIAMOND_BLOCK);
        threeByThreePacker(recipeOutput, RecipeCategory.MISC, ModRegistry.EMERALD_ORE.get(), Blocks.EMERALD_BLOCK);
        threeByThreePacker(recipeOutput, RecipeCategory.MISC, ModRegistry.GLOWSTONE.get(), Blocks.GLOWSTONE);
        threeByThreePacker(recipeOutput, RecipeCategory.MISC, ModRegistry.GOLD_ORE.get(), Blocks.RAW_GOLD_BLOCK);
        threeByThreePacker(recipeOutput, RecipeCategory.MISC, ModRegistry.IRON_ORE.get(), Blocks.RAW_IRON_BLOCK);
        threeByThreePacker(recipeOutput, RecipeCategory.MISC, ModRegistry.LAPIS_ORE.get(), Blocks.LAPIS_BLOCK);
        threeByThreePacker(recipeOutput, RecipeCategory.MISC, ModRegistry.NETHER_QUARTZ_ORE.get(), Blocks.QUARTZ_BLOCK);
        threeByThreePacker(recipeOutput, RecipeCategory.MISC, ModRegistry.REDSTONE_ORE.get(), Blocks.REDSTONE_BLOCK);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModRegistry.TOOL.get())
                .pattern("D D")
                .pattern(" O ")
                .pattern(" O ")
                .define('D', Items.DIAMOND)
                .define('O', Blocks.OBSIDIAN)
                .unlockedBy("has_obsidian", has(Blocks.OBSIDIAN))
                .save(recipeOutput);
    }
}
