package silveon22.deep.item;

import java.util.Random;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntityActivator;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.util.phys.HitResult.HitType;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;

public class ItemBlockLilypad<T extends BlockLogic> extends ItemBlock<T> {
	public ItemBlockLilypad(Block<T> block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	public boolean onUseItemOnBlock(ItemStack itemstack, @Nullable Player player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		return false;
	}

	public ItemStack onUseItem(ItemStack itemstack, World world, Player player) {
		double reachDistance = (double)player.getGamemode().getBlockReachDistance();
		HitResult rayTraceResult = player.rayTrace(reachDistance, 1.0F, true, false);
		if (rayTraceResult == null) {
			return itemstack;
		} else {
			if (rayTraceResult.hitType == HitType.TILE) {
				int blockX = rayTraceResult.x;
				int blockY = rayTraceResult.y;
				int blockZ = rayTraceResult.z;
				if (world.getBlockId(blockX, blockY, blockZ) != Blocks.FLUID_WATER_STILL.id()) {
					return itemstack;
				}

				++blockY;
				if (world.getBlockId(blockX, blockY, blockZ) != 0) {
					return itemstack;
				}

				if (itemstack.consumeItem(player) && world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, this.block.id(), 0)) {
					this.block.onBlockPlacedByMob(world, blockX, blockY, blockZ, Side.NONE, player, (double)0.5F, (double)0.5F);
					world.playBlockSoundEffect(player, (double)((float)blockX + 0.5F), (double)((float)blockY + 0.5F), (double)((float)blockZ + 0.5F), this.block, EnumBlockSoundEffectType.PLACE);
					player.swingItem();
				}
			}

			return itemstack;
		}
	}

	public void onUseByActivator(ItemStack itemStack, TileEntityActivator activatorBlock, World world, Random random, int blockX, int blockY, int blockZ, double offX, double offY, double offZ, Direction direction) {
		int x = blockX + direction.getOffsetX();
		int y = blockY + direction.getOffsetY();
		int z = blockZ + direction.getOffsetZ();
		Block<?> b = world.getBlock(x, y, z);
		Block<?> bAbove = world.getBlock(x, y + 1, z);
		if (b == Blocks.FLUID_WATER_STILL && (bAbove == null || bAbove.hasTag(BlockTags.PLACE_OVERWRITES))) {
			world.setBlockWithNotify(x, y + 1, z, this.block.id());
			this.block.onBlockPlacedOnSide(world, x, y + 1, z, Side.NONE, (double)0.5F, (double)0.5F);
		}
	}
}
