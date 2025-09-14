package com.sherman.infinite_resources.datagen.server;

import com.sherman.infinite_resources.registry.ModRegistry;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class ModBlockLootSubProvider extends BlockLootSubProvider {

    public ModBlockLootSubProvider() {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModRegistry.BLOCKS.getEntries()
                .stream()
                .map(e -> (Block) e.value())
                .toList();
    }

    @Override
    protected void generate() {
        add(ModRegistry.ANCIENT_DEBRIS.get(), createModOreDrop(Blocks.ANCIENT_DEBRIS));
        add(ModRegistry.BUDDING_AMETHYST.get(), createModOreDrop(Items.AMETHYST_CLUSTER, Items.AMETHYST_SHARD));
        add(ModRegistry.COAL_ORE.get(), createModOreDrop(Blocks.COAL_ORE, Items.COAL));
        add(ModRegistry.COPPER_ORE.get(), createCopperOreDrops(Blocks.COPPER_ORE));
        add(ModRegistry.DIAMOND_ORE.get(), createModOreDrop(Blocks.DIAMOND_ORE, Items.DIAMOND));
        add(ModRegistry.EMERALD_ORE.get(), createModOreDrop(Blocks.EMERALD_ORE, Items.EMERALD));
        add(ModRegistry.GLOWSTONE.get(), createModOreDrop(Blocks.GLOWSTONE, Items.GLOWSTONE_DUST));
        add(ModRegistry.GOLD_ORE.get(), createModOreDrop(Blocks.GOLD_ORE, Items.RAW_GOLD));
        add(ModRegistry.IRON_ORE.get(), createModOreDrop(Blocks.IRON_ORE, Items.RAW_IRON));
        add(ModRegistry.LAPIS_ORE.get(), createLapisOreDrops(Blocks.LAPIS_ORE));
        add(ModRegistry.NETHER_QUARTZ_ORE.get(), createModOreDrop(Blocks.NETHER_QUARTZ_ORE, Items.QUARTZ));
        add(ModRegistry.REDSTONE_ORE.get(), createRedstoneOreDrops(Blocks.REDSTONE_ORE));
    }

    protected LootTable.Builder createModOreDrop(ItemLike drop) {
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(drop))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)));
    }

    protected LootTable.Builder createModOreDrop(ItemLike withSilkTouch, ItemLike drop){
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(drop).when(HAS_NO_SILK_TOUCH))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(withSilkTouch).when(HAS_SILK_TOUCH)));
    }
}