package com.sherman.infinite_resources.datagen.client;

import com.sherman.infinite_resources.registry.ModRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

import static com.sherman.infinite_resources.InfiniteResources.MODID;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output, MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModels.createTrivialCube(ModRegistry.ANCIENT_DEBRIS.get());
        blockModels.createTrivialCube(ModRegistry.BUDDING_AMETHYST.get());
        blockModels.createTrivialCube(ModRegistry.COAL_ORE.get());
        blockModels.createTrivialCube(ModRegistry.COPPER_ORE.get());
        blockModels.createTrivialCube(ModRegistry.DIAMOND_ORE.get());
        blockModels.createTrivialCube(ModRegistry.EMERALD_ORE.get());
        blockModels.createTrivialCube(ModRegistry.GOLD_ORE.get());
        blockModels.createTrivialCube(ModRegistry.IRON_ORE.get());
        blockModels.createTrivialCube(ModRegistry.GLOWSTONE.get());
        blockModels.createTrivialCube(ModRegistry.LAPIS_ORE.get());
        blockModels.createTrivialCube(ModRegistry.NETHER_QUARTZ_ORE.get());
        blockModels.createTrivialCube(ModRegistry.REDSTONE_ORE.get());

        itemModels.generateFlatItem(ModRegistry.TOOL.get(), ModelTemplates.FLAT_ITEM);
    }
}
