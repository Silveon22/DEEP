package silveon22.deep.block.misc;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.entity.vehicle.EntityBoat;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BlockLogicLilyPad extends BlockLogic implements IBonemealable {
	public BlockLogicLilyPad(Block<?> block) {
		super(block, Material.plant);
		this.setBlockBounds((double)0.0F, (double)-0.125F, (double)0.0F, (double)1F, (double)0.00625F, (double)1F);
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (entity instanceof EntityBoat) {
			int data = world.getBlockMetadata(x, y, z);
			world.playBlockEvent((Player)null, 2001, x, y, z, this.block.id());
			world.setBlockWithNotify(x, y, z, 0);
			this.onBlockRemoved(world, x, y, z, data);
			this.dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, world.getBlockMetadata(x, y, z), (TileEntity)null, (Player)null);
		}

	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		int blockId = world.getBlockId(x, y, z);
		return blockId == 0 && Blocks.hasTag(world.getBlockId(x, y - 1, z), BlockTags.IS_WATER) && world.getBlockMetadata(x, y - 1, z) == 0;
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		if (!Blocks.hasTag(world.getBlockId(x, y - 1, z), BlockTags.IS_WATER) || world.getBlockMetadata(x, y - 1, z) != 0) {
			world.setBlock(x, y, z, 0);
		}

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
			default:
				return new ItemStack[]{new ItemStack(this.block)};
		}
	}

	public boolean collidesWithEntity(Entity entity, World world, int x, int y, int z) {
		return !(entity instanceof EntityBoat);
	}

	public boolean onBonemealUsed(ItemStack itemstack, @Nullable Player player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		Random rand = world.rand;
		if (world.isClientSide) {
			return true;
		} else {
			if (player == null || player.getGamemode().consumeBlocks()) {
				--itemstack.stackSize;
			}

			label41:
			for(int i = 0; i < 128; ++i) {
				int _x = blockX;
				int _z = blockZ;

				for(int j = 0; j < i / 16; ++j) {
					_x += rand.nextInt(3) - 1;
					_z += rand.nextInt(3) - 1;
					int bId = world.getBlockId(_x, blockY - 1, _z);
					int bMeta = world.getBlockMetadata(_x, blockY - 1, _z);
					if (bId != Blocks.FLUID_WATER_FLOWING.id() && bId != Blocks.FLUID_WATER_STILL.id() || bMeta != 0) {
						continue label41;
					}
				}

				if (world.getBlockId(_x, blockY, _z) == 0 && (double)rand.nextFloat() > (double)0.75F) {
					world.setBlockWithNotify(_x, blockY, _z, this.block.id());
				}
			}

			return true;
		}
	}
}
