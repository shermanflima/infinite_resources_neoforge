package com.sherman.infinite_resources.datagen;

import com.sherman.infinite_resources.datagen.client.ModBlockStateProvider;
import com.sherman.infinite_resources.datagen.client.ModItemModelProvider;
import com.sherman.infinite_resources.datagen.client.ModLanguageProvider;
import com.sherman.infinite_resources.datagen.server.ModBlockLootSubProvider;
import com.sherman.infinite_resources.datagen.server.ModBlockTagProvider;
import com.sherman.infinite_resources.datagen.server.ModRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber
public class ModDataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeServer()) {
            generator.addProvider(true, new LootTableProvider(packOutput, Set.of(),
                    List.of(new LootTableProvider.SubProviderEntry(ModBlockLootSubProvider::new, LootContextParamSets.BLOCK)), lookupProvider));
            generator.addProvider(true, new ModRecipeProvider(packOutput, lookupProvider));
            generator.addProvider(true, new ModBlockTagProvider(packOutput, lookupProvider, helper));
        }
        if (event.includeClient()) {
            generator.addProvider(true, new ModLanguageProvider(packOutput));
            generator.addProvider(true, new ModItemModelProvider(packOutput, helper));
            generator.addProvider(true, new ModBlockStateProvider(packOutput, helper));
        }
    }
}
