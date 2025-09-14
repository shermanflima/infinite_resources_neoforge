package com.sherman.infinite_resources.datagen;

import com.sherman.infinite_resources.datagen.client.ModLanguageProvider;
import com.sherman.infinite_resources.datagen.client.ModModelProvider;
import com.sherman.infinite_resources.datagen.server.ModBlockLootSubProvider;
import com.sherman.infinite_resources.datagen.server.ModBlockTagProvider;
import com.sherman.infinite_resources.datagen.server.ModRecipeProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber
public class ModDataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<Provider> lookupProvider = event.getLookupProvider();

        event.addProvider(new LootTableProvider(packOutput, Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootSubProvider::new, LootContextParamSets.BLOCK)), lookupProvider));
        event.addProvider(new ModRecipeProvider.Runner(packOutput, lookupProvider));
        event.addProvider(new ModBlockTagProvider(packOutput, lookupProvider));

        event.addProvider(new ModLanguageProvider(packOutput));
        event.addProvider(new ModModelProvider(packOutput));

    }
}
