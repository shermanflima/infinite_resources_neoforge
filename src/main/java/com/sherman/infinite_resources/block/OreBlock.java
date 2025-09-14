package com.sherman.infinite_resources.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class OreBlock extends DropExperienceBlock {

    public OreBlock(IntProvider xpRange, Properties properties) {
        super(xpRange, properties);
    }

    public OreBlock(int xpMin, int xpMax, Properties properties){
        this(UniformInt.of(xpMin, xpMax), properties);
    }

    public OreBlock(int xp, Properties properties){
        this(ConstantInt.of(xp), properties);
    }

    public OreBlock(Properties properties) {
        this(0, properties);
    }

    public static OreBlock coal(Properties properties) {
        return new OreBlock(0, 2, properties);
    }

    public static OreBlock diamond(Properties properties) {
        return new OreBlock(3, 7, properties);
    }

    public static OreBlock emerald(Properties properties) {
        return new OreBlock(3, 7, properties);
    }

    public static OreBlock glowstone(Properties properties) {
        return new OreBlock(properties);
    }

    public static OreBlock lapis(Properties properties) {
        return new OreBlock(2, 5, properties);
    }

    public static OreBlock quartz(Properties properties) {
        return new OreBlock(2, 5, properties);
    }

    public static OreBlock redstone(Properties properties) {
        return new OreBlock(1, 5, properties);
    }

    @Override
    public void playerDestroy(@NotNull Level level, Player player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack tool) {
        super.playerDestroy(level, player, pos, state, blockEntity, tool);
        level.setBlockAndUpdate(pos, this.defaultBlockState());
    }

}
