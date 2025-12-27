package silveon22.deep.block.misc;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.BlockLogicTransparent;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityFallingBlock;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.util.phys.Vec3;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import silveon22.deep.block.DEEPBlocks;

import java.util.Random;

public class BlockLogicHoney extends BlockLogicTransparent {
	public static boolean fallInstantly = false;
	public BlockLogicHoney(Block<?> block, Material material) {
		super(block, material);
	}

	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return null;
	}

	public boolean isCubeShaped() {
		return false;
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		entity.yd = 0.0F;
		entity.xd *= 0.4;
		entity.zd *= 0.4;
		entity.fallDistance = 0;

	}

	public void onBlockPlacedByWorld(World world, int x, int y, int z) {
		world.scheduleBlockUpdate(x, y, z, this.block.id(), this.tickDelay());
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		world.scheduleBlockUpdate(x, y, z, this.block.id(), this.tickDelay());
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		this.tryToFall(world, x, y, z);
	}

	private void tryToFall(World world, int x, int y, int z) {
		if (canFallBelow(world, x, y - 1, z) && y >= 0 && canStickTo(world, x, y + 1, z) && canStickTo(world, x-1, y, z) && canStickTo(world, x+1, y, z) && canStickTo(world, x, y, z-1) && canStickTo(world, x, y, z+1)) {
			byte byte0 = 32;
			if (!fallInstantly && world.areBlocksLoaded(x - byte0, y - byte0, z - byte0, x + byte0, y + byte0, z + byte0)) {
				EntityFallingBlock entityFallingBlock = new EntityFallingBlock(world, (double)x + (double)0.5F, (double)y + (double)0.5F, (double)z + (double)0.5F, this.block.id(), 0, (TileEntity)null);
				world.entityJoinedWorld(entityFallingBlock);
			} else {
				world.setBlockWithNotify(x, y, z, 0);

				while(canFallBelow(world, x, y - 1, z) && y > 0) {
					--y;
				}

				if (y > 0) {
					world.setBlockWithNotify(x, y, z, this.block.id());
				}
			}
		}

	}

	public int tickDelay() {
		return 3;
	}

	public static boolean canFallBelow(World world, int x, int y, int z) {
		Block<?> block = world.getBlock(x, y, z);
		return block == null || block.hasTag(BlockTags.PLACE_OVERWRITES);
	}

	public static boolean canStickTo(World world, int x, int y, int z) {
		Block<?> block = world.getBlock(x, y, z);
		return block == null || block.hasTag(BlockTags.CAN_HANG_OFF);
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			default:
				return new ItemStack[]{new ItemStack(DEEPBlocks.blockHoney)};
		}
	}

}
