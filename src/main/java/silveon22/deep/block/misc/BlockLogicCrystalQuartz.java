package silveon22.deep.block.misc;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import org.jetbrains.annotations.Nullable;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.item.DEEPItems;

import java.util.Random;

public class BlockLogicCrystalQuartz extends BlockLogic {
	public static final int MASK_PERMANENT = 128;

	public BlockLogicCrystalQuartz(Block<?> block) {
		super(block, Material.metal);
		block.setTicking(true);
		this.setBlockBounds((double)(0.10F), (double)0.10F, (double)(0.10F), (double)(0.90F), (double)(1), (double)(0.90F));
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return super.canPlaceBlockAt(world, x, y, z) && this.mayPlaceOn(world.getBlockId(x, y + 1, z));
	}

	protected boolean mayPlaceOn(int blockId) {
		return Blocks.blocksList[blockId] == null ? false : Blocks.solid[blockId];
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		super.onNeighborBlockChange(world, x, y, z, blockId);
		this.checkAlive(world, x, y, z);
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		this.checkAlive(world, x, y, z);
	}

	protected final void checkAlive(World world, int x, int y, int z) {
		if (!this.canBlockStay(world, x, y, z)) {
			this.dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, world.getBlockMetadata(x, y, z), (TileEntity)null, (Player)null);
			world.setBlockWithNotify(x, y, z, 0);
		}

	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		return (this.mayPlaceOn(world.getBlockId(x, y + 1, z)));
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

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case SILK_TOUCH:
			case PICK_BLOCK:
			case PISTON_CRUSH:
				return new ItemStack[]{new ItemStack(DEEPBlocks.crystalQuartz)};
			default:
				return new ItemStack[]{new ItemStack((Items.QUARTZ), 2 + world.rand.nextInt(3))};
		}
	}
}
