package com.sherman.infinite_resources.registry;

import com.sherman.infinite_resources.block.OreBlock;
import com.sherman.infinite_resources.item.InfiniteTool;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

import static com.sherman.infinite_resources.InfiniteResources.MODID;

public class ModRegistry {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredBlock<Block> ANCIENT_DEBRIS = registerBlockWithItem("ancient_debris", OreBlock::new, Blocks.ANCIENT_DEBRIS);
    public static final DeferredBlock<Block> BUDDING_AMETHYST = registerBlockWithItem("budding_amethyst", OreBlock::new, Blocks.BUDDING_AMETHYST);
    public static final DeferredBlock<Block> COAL_ORE = registerBlockWithItem("coal_ore", OreBlock::coal, Blocks.COAL_ORE);
    public static final DeferredBlock<Block> COPPER_ORE = registerBlockWithItem("copper_ore", OreBlock::new, Blocks.COPPER_ORE);
    public static final DeferredBlock<Block> DIAMOND_ORE = registerBlockWithItem("diamond_ore", OreBlock::diamond, Blocks.DIAMOND_ORE);
    public static final DeferredBlock<Block> EMERALD_ORE = registerBlockWithItem("emerald_ore", OreBlock::emerald, Blocks.EMERALD_ORE);
    public static final DeferredBlock<Block> GLOWSTONE = registerBlockWithItem("glowstone", OreBlock::new, Blocks.GLOWSTONE);
    public static final DeferredBlock<Block> GOLD_ORE = registerBlockWithItem("gold_ore", OreBlock::new, Blocks.GOLD_ORE);
    public static final DeferredBlock<Block> IRON_ORE = registerBlockWithItem("iron_ore", OreBlock::new, Blocks.IRON_ORE);
    public static final DeferredBlock<Block> LAPIS_ORE = registerBlockWithItem("lapis_ore", OreBlock::lapis, Blocks.LAPIS_ORE);
    public static final DeferredBlock<Block> NETHER_QUARTZ_ORE = registerBlockWithItem("nether_quartz_ore", OreBlock::quartz, Blocks.NETHER_QUARTZ_ORE);
    public static final DeferredBlock<Block> REDSTONE_ORE = registerBlockWithItem("redstone_ore", OreBlock::redstone, Blocks.IRON_ORE);

    public static final DeferredItem<Item> TOOL = ITEMS.registerItem("tool", InfiniteTool::new);

    private static DeferredBlock<Block> registerBlockWithItem(String name, Function<BlockBehaviour.Properties, ? extends Block> block, BlockBehaviour blockToCopy) {
        DeferredBlock<Block> deferredBlock = BLOCKS.registerBlock(name, block, BlockBehaviour.Properties.ofFullCopy(blockToCopy));
        ITEMS.registerItem(name, (properties) -> new BlockItem(deferredBlock.get(), properties.useBlockDescriptionPrefix()));
        return deferredBlock;
    }

    private static void creativeModeTabs(IEventBus eventBus){
        CREATIVE_MODE_TABS.register("tab", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(ModRegistry.ANCIENT_DEBRIS))
                .title(Component.translatable("itemGroup." + MODID))
                .displayItems((displayParameters, output) -> {
                    for(DeferredHolder<Block, ? extends Block> holder : ModRegistry.BLOCKS.getEntries()){
                        output.accept(holder.get());
                    }
                    for(DeferredHolder<Item, ? extends Item> holder : ModRegistry.ITEMS.getEntries()){
                        output.accept(holder.get());
                    }
                }).build());
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        creativeModeTabs(eventBus);
    }
}
