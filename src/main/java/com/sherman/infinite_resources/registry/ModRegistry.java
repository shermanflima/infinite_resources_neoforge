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
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.sherman.infinite_resources.InfiniteResources.MODID;

public class ModRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredBlock<Block> ANCIENT_DEBRIS = registerBlockWithItem("ancient_debris", OreBlock::ancientDebris);
    public static final DeferredBlock<Block> BUDDING_AMETHYST = registerBlockWithItem("budding_amethyst", OreBlock::buddingAmethyst);
    public static final DeferredBlock<Block> COAL_ORE = registerBlockWithItem("coal_ore", OreBlock::coal);
    public static final DeferredBlock<Block> COPPER_ORE = registerBlockWithItem("copper_ore", OreBlock::copper);
    public static final DeferredBlock<Block> DIAMOND_ORE = registerBlockWithItem("diamond_ore", OreBlock::diamond);
    public static final DeferredBlock<Block> EMERALD_ORE = registerBlockWithItem("emerald_ore", OreBlock::emerald);
    public static final DeferredBlock<Block> GLOWSTONE = registerBlockWithItem("glowstone", OreBlock::glowstone);
    public static final DeferredBlock<Block> GOLD_ORE = registerBlockWithItem("gold_ore", OreBlock::gold);
    public static final DeferredBlock<Block> IRON_ORE = registerBlockWithItem("iron_ore", OreBlock::iron);
    public static final DeferredBlock<Block> LAPIS_ORE = registerBlockWithItem("lapis_ore", OreBlock::lapis);
    public static final DeferredBlock<Block> NETHER_QUARTZ_ORE = registerBlockWithItem("nether_quartz_ore", OreBlock::quartz);
    public static final DeferredBlock<Block> REDSTONE_ORE = registerBlockWithItem("redstone_ore", OreBlock::redstone);

    public static final DeferredItem<Item> TOOL = item("tool", InfiniteTool::new);

    private static <T extends Block> DeferredBlock<T> registerBlockWithItem(String name, Supplier<T> block) {
        DeferredBlock<T> deferredBlock = BLOCKS.register(name, block);
        registerBlockItem(name, deferredBlock);
        return deferredBlock;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static DeferredItem<Item> item(String name, Supplier<Item> supplier) {
        return ITEMS.register(name, supplier);
    }

    private static void creativeModeTabs(IEventBus eventBus){
        CREATIVE_MODE_TABS.register("tab", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(ModRegistry.IRON_ORE))
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
