package silveon22.deep.block.misc;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import silveon22.deep.block.DEEPBlocks;

public class BlockLogicStatueBastBottom extends BlockLogic {
	public BlockLogicStatueBastBottom(Block<?> block) {
		super(block, Material.stone);
		float f = 0.375F;
		this.setBlockBounds((double)(0.5F - f), (double)0.0F, (double)(0.5F - f), (double)(0.5F + f), (double)1.0F, (double)(0.5F + f));
		block.setTicking(true);
	}

	public void growTop(World world, int x, int y, int z) {
		if (world.isAirBlock(x, y + 1, z)) {
			world.setBlockWithNotify(x, y + 1, z, DEEPBlocks.statueBastTop.id());
		}

	}

	@Override
	public void onBlockPlacedByWorld(World world, int x, int y, int z) {
		super.onBlockPlacedByWorld(world, x, y, z);
		if (world.isAirBlock(x, y + 1, z)) {
			world.setBlockWithNotify(x, y + 1, z, DEEPBlocks.statueBastTop.id());
		}
	}

	@Override
	public void onBlockPlacedByMob(World world, int x, int y, int z, @NotNull Side side, Mob mob, double xPlaced, double yPlaced) {
		super.onBlockPlacedByMob(world, x, y, z, side, mob, xPlaced, yPlaced);
		if (world.isAirBlock(x, y + 1, z)) {
			world.setBlockWithNotify(x, y + 1, z, DEEPBlocks.statueBastTop.id());
		}
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		int l = world.getBlockId(x, y - 1, z);
		int a = world.getBlockId(x, y + 1, z);
		if (l == this.id()) {
			return true;
		} else if (Blocks.blocksList[l] == null) {
			return false;
		} else if (Blocks.blocksList[a] != null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean canPlaceBlockStayAt(World world, int x, int y, int z) {
		int l = world.getBlockId(x, y - 1, z);
		int a = world.getBlockId(x, y + 1, z);
		if (l == this.id()) {
			return true;
		} else if (Blocks.blocksList[l] == null) {
			return false;
		} else if (a != DEEPBlocks.statueBastTop.id()) {
			return false;
		} else {
			return true;
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
			case PICK_BLOCK:
			case EXPLOSION:
			case PROPER_TOOL:
			case PISTON_CRUSH:
			default:
				return new ItemStack[]{new ItemStack(DEEPBlocks.statueBastBottom)};
		}
	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		return this.canPlaceBlockStayAt(world, x, y, z);
	}

	public boolean isSolidRender() {
		return false;
	}

	public boolean isCubeShaped() {
		return false;
	}

}
