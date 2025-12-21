package silveon22.deep.block.misc;

import java.util.Random;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import org.jetbrains.annotations.NotNull;

public class BlockLogicCryoTorch extends BlockLogic {
	public static final int MASK_DIRECTION = 7;
	public static final int SIDE_NONE = 0;
	public static final int SIDE_WEST = 1;
	public static final int SIDE_EAST = 2;
	public static final int SIDE_NORTH = 3;
	public static final int SIDE_SOUTH = 4;
	public static final int SIDE_BOTTOM = 5;
	public static final int SIDE_TOP = 6;

	public BlockLogicCryoTorch(Block<?> block) {
		super(block, Material.decoration);
		block.setTicking(true);
	}

	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return null;
	}

	public AABB getBlockBoundsFromState(WorldSource world, int x, int y, int z) {
		float f = 0.15F;
		int side = world.getBlockMetadata(x, y, z) & 7;
		switch (side) {
			case 1:
				return AABB.getTemporaryBB((double)0.0F, (double)0.2F, (double)(0.5F - f), (double)(f * 2.0F), (double)0.8F, (double)(0.5F + f));
			case 2:
				return AABB.getTemporaryBB((double)(1.0F - f * 2.0F), (double)0.2F, (double)(0.5F - f), (double)1.0F, (double)0.8F, (double)(0.5F + f));
			case 3:
				return AABB.getTemporaryBB((double)(0.5F - f), (double)0.2F, (double)0.0F, (double)(0.5F + f), (double)0.8F, (double)(f * 2.0F));
			case 4:
				return AABB.getTemporaryBB((double)(0.5F - f), (double)0.2F, (double)(1.0F - f * 2.0F), (double)(0.5F + f), (double)0.8F, (double)1.0F);
			case 5:
			default:
				float f1 = 0.1F;
				return AABB.getTemporaryBB((double)0.4F, (double)0.0F, (double)0.4F, (double)0.6F, (double)0.6F, (double)0.6F);
		}
	}

	public boolean isSolidRender() {
		return false;
	}

	public boolean isCubeShaped() {
		return false;
	}

	private boolean canPlaceOnTop(World world, int x, int y, int z) {
		int blockBelow = world.getBlockId(x, y, z);
		return world.canPlaceOnSurfaceOfBlock(x, y, z) || blockBelow == Blocks.FENCE_PLANKS_OAK.id() || blockBelow == Blocks.FENCE_PLANKS_OAK_PAINTED.id() || blockBelow == Blocks.FENCE_CHAINLINK.id() || blockBelow == Blocks.FENCE_PAPER_WALL.id() || blockBelow == Blocks.FENCE_STEEL.id();
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		if (world.isBlockNormalCube(x - 1, y, z)) {
			return true;
		} else if (world.isBlockNormalCube(x + 1, y, z)) {
			return true;
		} else if (world.isBlockNormalCube(x, y, z - 1)) {
			return true;
		} else {
			return world.isBlockNormalCube(x, y, z + 1) ? true : this.canPlaceOnTop(world, x, y - 1, z);
		}
	}

	public void onBlockPlacedByMob(World world, int x, int y, int z, @NotNull Side side, Mob mob, double xPlaced, double yPlaced) {
		int orientation = 0;
		switch (side) {
			case TOP:
				if (this.canPlaceOnTop(world, x, y - 1, z)) {
					orientation = 5;
				}
				break;
			case NORTH:
				if (world.isBlockNormalCube(x, y, z + 1)) {
					orientation = 4;
				}
				break;
			case SOUTH:
				if (world.isBlockNormalCube(x, y, z - 1)) {
					orientation = 3;
				}
				break;
			case WEST:
				if (world.isBlockNormalCube(x + 1, y, z)) {
					orientation = 2;
				}
				break;
			case EAST:
				if (world.isBlockNormalCube(x - 1, y, z)) {
					orientation = 1;
				}
		}

		if (orientation == 0) {
			orientation = this.getDefaultOrientation(world, x, y, z);
		}

		world.setBlockMetadataWithNotify(x, y, z, orientation);
		this.dropTorchIfCantStay(world, x, y, z);
	}

	public void onBlockPlacedOnSide(World world, int x, int y, int z, @NotNull Side side, double xPlaced, double yPlaced) {
		int orientation = 0;
		if (side.isHorizontal()) {
			side = side.getOpposite();
		}

		switch (side) {
			case TOP:
				if (this.canPlaceOnTop(world, x, y - 1, z)) {
					orientation = 5;
				}
				break;
			case NORTH:
				if (world.isBlockNormalCube(x, y, z + 1)) {
					orientation = 4;
				}
				break;
			case SOUTH:
				if (world.isBlockNormalCube(x, y, z - 1)) {
					orientation = 3;
				}
				break;
			case WEST:
				if (world.isBlockNormalCube(x + 1, y, z)) {
					orientation = 2;
				}
				break;
			case EAST:
				if (world.isBlockNormalCube(x - 1, y, z)) {
					orientation = 1;
				}
		}

		if (orientation == 0) {
			orientation = this.getDefaultOrientation(world, x, y, z);
		}

		world.setBlockMetadataWithNotify(x, y, z, orientation);
		this.dropTorchIfCantStay(world, x, y, z);
	}

	public int getDefaultOrientation(World world, int x, int y, int z) {
		if (this.canPlaceOnTop(world, x, y - 1, z)) {
			return 5;
		} else if (world.isBlockNormalCube(x, y, z + 1)) {
			return 4;
		} else if (world.isBlockNormalCube(x, y, z - 1)) {
			return 3;
		} else if (world.isBlockNormalCube(x + 1, y, z)) {
			return 2;
		} else {
			return world.isBlockNormalCube(x - 1, y, z) ? 1 : 0;
		}
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		super.updateTick(world, x, y, z, rand);
		if (world.getBlockMetadata(x, y, z) == 0) {
			this.onBlockPlacedByWorld(world, x, y, z);
		}

	}

	public void onBlockPlacedByWorld(World world, int x, int y, int z) {
		if (world.isBlockNormalCube(x - 1, y, z)) {
			world.setBlockMetadataWithNotify(x, y, z, 1);
		} else if (world.isBlockNormalCube(x + 1, y, z)) {
			world.setBlockMetadataWithNotify(x, y, z, 2);
		} else if (world.isBlockNormalCube(x, y, z - 1)) {
			world.setBlockMetadataWithNotify(x, y, z, 3);
		} else if (world.isBlockNormalCube(x, y, z + 1)) {
			world.setBlockMetadataWithNotify(x, y, z, 4);
		} else if (this.canPlaceOnTop(world, x, y - 1, z)) {
			world.setBlockMetadataWithNotify(x, y, z, 5);
		}

		this.dropTorchIfCantStay(world, x, y, z);
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		int side = world.getBlockMetadata(x, y, z) & 7;
		boolean invalid;
		switch (side) {
			case 1:
				invalid = !world.isBlockNormalCube(x - 1, y, z);
				break;
			case 2:
				invalid = !world.isBlockNormalCube(x + 1, y, z);
				break;
			case 3:
				invalid = !world.isBlockNormalCube(x, y, z - 1);
				break;
			case 4:
				invalid = !world.isBlockNormalCube(x, y, z + 1);
				break;
			case 5:
				int blockBelow = world.getBlockId(x, y - 1, z);
				invalid = !world.canPlaceOnSurfaceOfBlock(x, y - 1, z) && blockBelow != Blocks.FENCE_PLANKS_OAK.id() && blockBelow != Blocks.FENCE_PLANKS_OAK_PAINTED.id() && blockBelow != Blocks.FENCE_CHAINLINK.id() && blockBelow != Blocks.FENCE_PAPER_WALL.id() && blockBelow != Blocks.FENCE_STEEL.id();
				break;
			default:
				invalid = true;
		}

		if (invalid) {
			this.dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, side, (TileEntity)null, (Player)null);
			world.setBlockWithNotify(x, y, z, 0);
		}

	}

	private boolean dropTorchIfCantStay(World world, int x, int y, int z) {
		if (!this.canPlaceBlockAt(world, x, y, z)) {
			this.dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, world.getBlockMetadata(x, y, z), (TileEntity)null, (Player)null);
			world.setBlockWithNotify(x, y, z, 0);
			return false;
		} else {
			return true;
		}
	}

	public void animationTick(World world, int x, int y, int z, Random rand) {
		double xPos = (double)x + (double)0.5F;
		double yPos = (double)y + 0.7;
		double zPos = (double)z + (double)0.5F;
		double d3 = 0.22;
		double d4 = 0.27;
		int side = world.getBlockMetadata(x, y, z) & 7;
		switch (side) {
			case 1:
				world.spawnParticle("snowshovel", xPos - d4, yPos + d3, zPos, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				world.spawnParticle("blueflame", xPos - d4, yPos + d3, zPos, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				break;
			case 2:
				world.spawnParticle("snowshovel", xPos + d4, yPos + d3, zPos, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				world.spawnParticle("blueflame", xPos + d4, yPos + d3, zPos, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				break;
			case 3:
				world.spawnParticle("snowshovel", xPos, yPos + d3, zPos - d4, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				world.spawnParticle("blueflame", xPos, yPos + d3, zPos - d4, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				break;
			case 4:
				world.spawnParticle("snowshovel", xPos, yPos + d3, zPos + d4, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				world.spawnParticle("blueflame", xPos, yPos + d3, zPos + d4, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				break;
			case 5:
				world.spawnParticle("snowshovel", xPos, yPos, zPos, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				world.spawnParticle("blueflame", xPos, yPos, zPos, (double)0.0F, (double)0.0F, (double)0.0F, 0);
		}

	}

	public int getLightmapCoord(WorldSource blockAccess, int x, int y, int z) {
		return blockAccess.getLightmapCoord(x, y, z, this.block.emission > 0 ? 15 : 0);
	}
}
