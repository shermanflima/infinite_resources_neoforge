package com.sherman.infinite_resources.item;

import com.sherman.infinite_resources.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static com.sherman.infinite_resources.InfiniteResources.MODID;

public class InfiniteTool extends Item {

    public InfiniteTool(Properties properties) {
        super(properties.stacksTo(1));
    }

    private boolean isValidBlock(BlockState block){
        return block.is(ModTags.Blocks.INFINITY_BLOCK);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (!level.isClientSide()) {
            Player player = context.getPlayer();
            BlockPos position = context.getClickedPos();
            BlockState blockState = level.getBlockState(position);
            if (player != null && isValidBlock(blockState)) {
                Inventory inventory = player.getInventory();
                level.removeBlock(position, false);
                ItemStack itemStack = new ItemStack(blockState.getBlock().asItem());
                if (!inventory.add(itemStack)) {
                    Containers.dropItemStack(level, position.getX(), position.getY(), position.getZ(), itemStack);
                }
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag flag) {
        tooltipAdder.accept(Component.translatable("tooltip." + MODID + ".tool"));
        super.appendHoverText(stack, context, tooltipDisplay, tooltipAdder, flag);
    }
}

