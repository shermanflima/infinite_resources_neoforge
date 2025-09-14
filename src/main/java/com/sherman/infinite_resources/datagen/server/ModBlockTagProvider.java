package com.sherman.infinite_resources.datagen.server;

import com.sherman.infinite_resources.registry.ModRegistry;
import com.sherman.infinite_resources.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static com.sherman.infinite_resources.InfiniteResources.MODID;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(ModTags.Blocks.INFINITY_BLOCK);

        tag(ModTags.Blocks.INFINITY_BLOCK)
                .add(ModRegistry.ANCIENT_DEBRIS.get())
                .add(ModRegistry.BUDDING_AMETHYST.get())
                .add(ModRegistry.COAL_ORE.get())
                .add(ModRegistry.COPPER_ORE.get())
                .add(ModRegistry.DIAMOND_ORE.get())
                .add(ModRegistry.EMERALD_ORE.get())
                .add(ModRegistry.GLOWSTONE.get())
                .add(ModRegistry.GOLD_ORE.get())
                .add(ModRegistry.IRON_ORE.get())
                .add(ModRegistry.LAPIS_ORE.get())
                .add(ModRegistry.NETHER_QUARTZ_ORE.get())
                .add(ModRegistry.REDSTONE_ORE.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModRegistry.COAL_ORE.get())
                .add(ModRegistry.COPPER_ORE.get())
                .add(ModRegistry.IRON_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModRegistry.BUDDING_AMETHYST.get())
                .add(ModRegistry.DIAMOND_ORE.get())
                .add(ModRegistry.EMERALD_ORE.get())
                .add(ModRegistry.GLOWSTONE.get())
                .add(ModRegistry.GOLD_ORE.get())
                .add(ModRegistry.LAPIS_ORE.get())
                .add(ModRegistry.NETHER_QUARTZ_ORE.get())
                .add(ModRegistry.REDSTONE_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModRegistry.ANCIENT_DEBRIS.get());

    }
}