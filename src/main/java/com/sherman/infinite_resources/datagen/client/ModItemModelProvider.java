package com.sherman.infinite_resources.datagen.client;

import com.sherman.infinite_resources.registry.ModRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static com.sherman.infinite_resources.InfiniteResources.MODID;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput packOutput, ExistingFileHelper helper) {
        super(packOutput, MODID, helper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModRegistry.TOOL.get());
    }
}
