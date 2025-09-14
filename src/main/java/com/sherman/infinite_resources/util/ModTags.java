package com.sherman.infinite_resources.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static com.sherman.infinite_resources.InfiniteResources.MODID;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INFINITY_BLOCK = createTag("infinite_resources_block");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(MODID, name));
        }
    }
}
