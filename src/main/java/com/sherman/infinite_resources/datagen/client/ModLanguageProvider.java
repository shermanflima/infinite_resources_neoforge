package com.sherman.infinite_resources.datagen.client;

import com.sherman.infinite_resources.registry.ModRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static com.sherman.infinite_resources.InfiniteResources.MODID;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(PackOutput packOutput) {
        super(packOutput, MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." +  MODID, "Infinite Resources");

        addBlock(ModRegistry.ANCIENT_DEBRIS, "Infinite Ancient Debris");
        addBlock(ModRegistry.BUDDING_AMETHYST, "Infinite Budding Amethyst");
        addBlock(ModRegistry.COAL_ORE, "Infinite Coal Ore");
        addBlock(ModRegistry.COPPER_ORE, "Infinite Copper Ore");
        addBlock(ModRegistry.DIAMOND_ORE, "Infinite Diamond Ore");
        addBlock(ModRegistry.EMERALD_ORE, "Infinite Emerald Ore");
        addBlock(ModRegistry.GLOWSTONE, "Infinite Glowstone");
        addBlock(ModRegistry.GOLD_ORE, "Infinite Gold Ore");
        addBlock(ModRegistry.IRON_ORE, "Infinite Iron Ore");
        addBlock(ModRegistry.LAPIS_ORE, "Infinite Lapis Ore");
        addBlock(ModRegistry.NETHER_QUARTZ_ORE, "Infinite Nether Quartz Ore");
        addBlock(ModRegistry.REDSTONE_ORE, "Infinite Redstone Ore");

        addItem(ModRegistry.TOOL, "Infinite Tool");
        add("tooltip." + MODID + ".tool", "Right-click to remove a block");
    }
}
