package com.sherman.infinite_resources.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class OreBlock extends DropExperienceBlock {

    public OreBlock(IntProvider xpRange, Properties properties) {
        super(xpRange, properties);
    }

    public OreBlock(IntProvider xpRange, Block blockToCopy){
        this(xpRange, BlockBehaviour.Properties.ofFullCopy(blockToCopy));
    }

    public OreBlock(int xpMin, int xpMax, Block blockToCopy){
        this(UniformInt.of(xpMin, xpMax), blockToCopy);
    }

    public OreBlock(int xp, Block blockToCopy){
        this(ConstantInt.of(xp), blockToCopy);
    }

    public OreBlock(Block block){
        this(0,block);
    }

    public OreBlock(int min, int max) {
        this(min, max, Blocks.IRON_ORE);
    }

    public static OreBlock ancientDebris(){
        return new OreBlock(Blocks.ANCIENT_DEBRIS);
    }

    public static Block buddingAmethyst() {
        return new OreBlock(Blocks.BUDDING_AMETHYST);
    }

    public static Block coal() {
        return new OreBlock(0, 2, Blocks.COAL_ORE);
    }

    public static Block copper() {
        return new OreBlock(Blocks.COPPER_ORE);
    }

    public static Block diamond() {
        return new OreBlock(3, 7, Blocks.DIAMOND_ORE);
    }

    public static Block emerald() {
        return new OreBlock(3, 7, Blocks.EMERALD_ORE);
    }

    public static Block glowstone() {
        return new OreBlock(Blocks.GLOWSTONE);
    }

    public static Block gold() {
        return new OreBlock(Blocks.GOLD_ORE);
    }

    public static Block iron() {
        return new OreBlock(Blocks.IRON_ORE);
    }

    public static Block lapis() {
        return new OreBlock(2, 5, Blocks.LAPIS_ORE);
    }

    public static Block quartz() {
        return new OreBlock(2, 5, Blocks.NETHER_QUARTZ_ORE);
    }

    public static Block redstone() {
        return new OreBlock(1, 5);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack tool) {
        super.playerDestroy(level, player, pos, state, blockEntity, tool);
        level.setBlockAndUpdate(pos, this.defaultBlockState());
    }
}
