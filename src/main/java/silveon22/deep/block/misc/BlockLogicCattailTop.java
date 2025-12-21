package silveon22.deep.block.misc;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import org.jetbrains.annotations.Nullable;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.item.DEEPItems;

public class BlockLogicCattailTop extends BlockLogic implements IBonemealable {
	public BlockLogicCattailTop(Block<?> block) {
		super(block, Material.plant);
		float f = 0.375F;
		this.setBlockBounds((double)(0.5F - f), (double)0.0F, (double)(0.5F - f), (double)(0.5F + f), (double)1.0F, (double)(0.5F + f));
		block.setTicking(true);
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		int l = world.getBlockId(x, y - 1, z);
		if (l == DEEPBlocks.cattailBottom.id()) {
			return true;
		} else {
			return false;
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		this.checkBlockCoordValid(world, x, y, z);
	}

	protected final void checkBlockCoordValid(World world, int x, int y, int z) {
		if (!this.canBlockStay(world, x, y, z)) {
			this.dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, world.getBlockMetadata(x, y, z), (TileEntity)null, (Player)null);
			world.setBlockWithNotify(x, y, z, 0);
		}

	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case SILK_TOUCH:
				return new ItemStack[]{new ItemStack(DEEPBlocks.cattailBottom)};
			case PICK_BLOCK:
				return new ItemStack[]{new ItemStack(DEEPBlocks.cattailBottom)};
			case EXPLOSION:
			case PROPER_TOOL:
				return new ItemStack[]{new ItemStack(DEEPBlocks.cattailBottom)};
			case PISTON_CRUSH:
			default:
				return null;
		}
	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		return this.canPlaceBlockAt(world, x, y, z);
	}

	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return null;
	}

	public boolean isSolidRender() {
		return false;
	}

	public boolean isCubeShaped() {
		return false;
	}

	public boolean onBonemealUsed(ItemStack itemstack, @Nullable Player player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		if (!world.isClientSide) {
			this.dropBlockWithCause(world, EnumDropCause.SILK_TOUCH, blockX, blockY, blockZ, world.getBlockMetadata(blockX, blockY, blockZ), (TileEntity)null, (Player)null);
			if (player == null || player.getGamemode().consumeBlocks()) {
				--itemstack.stackSize;
			}
		}

		return true;
	}
}
