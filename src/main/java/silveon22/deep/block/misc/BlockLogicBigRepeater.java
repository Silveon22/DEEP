package silveon22.deep.block.misc;


import java.util.Random;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.entity.TileEntityActivator;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.item.DEEPItems;

public class BlockLogicBigRepeater extends BlockLogic {
	public static final double[] torchPosOffset = new double[]{(double)-0.0625F, (double)0.0625F, (double)0.1875F, (double)0.3125F};
	private static final int[] tickDelayMap = new int[]{5, 10, 15, 20};
	public static final int MASK_DIRECTION = 3;
	public static final int MASK_TICK_DELAY = 12;
	public final boolean isRepeaterPowered;

	public BlockLogicBigRepeater(Block<?> block, boolean flag) {
		super(block, Material.decoration);
		this.isRepeaterPowered = flag;
		this.setBlockBounds((double)0.0F, (double)0.0F, (double)0.0F, (double)1.0F, (double)0.125F, (double)1.0F);
	}

	public boolean isCubeShaped() {
		return false;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return !world.canPlaceOnSurfaceOfBlock(x, y - 1, z) ? false : super.canPlaceBlockAt(world, x, y, z);
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		return new ItemStack[]{new ItemStack(DEEPItems.bigRepeater)};
	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		return !world.canPlaceOnSurfaceOfBlock(x, y - 1, z) ? false : super.canBlockStay(world, x, y, z);
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		int meta = world.getBlockMetadata(x, y, z);
		boolean flag = this.isGettingPower(world, x, y, z, meta);
		if (this.isRepeaterPowered && !flag) {
			world.setBlockAndMetadataWithNotify(x, y, z, DEEPBlocks.repeaterBigIdle.id(), meta);
		} else if (!this.isRepeaterPowered) {
			world.setBlockAndMetadataWithNotify(x, y, z, DEEPBlocks.repeaterBigActive.id(), meta);
			if (!flag) {
				int i1 = (meta & 12) >> 2;
				world.scheduleBlockUpdate(x, y, z, DEEPBlocks.repeaterBigActive.id(), tickDelayMap[i1] * 2);
			}
		}

	}

	public boolean getDirectSignal(World world, int x, int y, int z, Side side) {
		return this.getSignal(world, x, y, z, side);
	}

	public boolean getSignal(WorldSource worldSource, int x, int y, int z, Side side) {
		if (!this.isRepeaterPowered) {
			return false;
		} else {
			int meta = worldSource.getBlockMetadata(x, y, z) & 3;
			if (meta == 0 && side == Side.SOUTH) {
				return true;
			} else if (meta == 1 && side == Side.WEST) {
				return true;
			} else if (meta == 2 && side == Side.NORTH) {
				return true;
			} else {
				return meta == 3 && side == Side.EAST;
			}
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		if (!this.canBlockStay(world, x, y, z)) {
			this.dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, world.getBlockMetadata(x, y, z), (TileEntity)null, (Player)null);
			world.setBlockWithNotify(x, y, z, 0);
		} else {
			int meta = world.getBlockMetadata(x, y, z);
			boolean flag = this.isGettingPower(world, x, y, z, meta);
			int tickDelay = (meta & 12) >> 2;
			if (this.isRepeaterPowered && !flag) {
				world.scheduleBlockUpdate(x, y, z, this.id(), tickDelayMap[tickDelay] * 2);
			} else if (!this.isRepeaterPowered && flag) {
				world.scheduleBlockUpdate(x, y, z, this.id(), tickDelayMap[tickDelay] * 2);
			}

		}
	}

	private boolean isGettingPower(World world, int x, int y, int z, int meta) {
		int direction = meta & 3;
		switch (direction) {
			case 0:
				return world.getSignal(x, y, z + 1, Side.SOUTH) || world.getBlockId(x, y, z + 1) == Blocks.WIRE_REDSTONE.id() && world.getBlockMetadata(x, y, z + 1) > 0;
			case 1:
				return world.getSignal(x - 1, y, z, Side.WEST) || world.getBlockId(x - 1, y, z) == Blocks.WIRE_REDSTONE.id() && world.getBlockMetadata(x - 1, y, z) > 0;
			case 2:
				return world.getSignal(x, y, z - 1, Side.NORTH) || world.getBlockId(x, y, z - 1) == Blocks.WIRE_REDSTONE.id() && world.getBlockMetadata(x, y, z - 1) > 0;
			case 3:
				return world.getSignal(x + 1, y, z, Side.EAST) || world.getBlockId(x + 1, y, z) == Blocks.WIRE_REDSTONE.id() && world.getBlockMetadata(x + 1, y, z) > 0;
			default:
				return false;
		}
	}

	public boolean onBlockRightClicked(World world, int x, int y, int z, @Nullable Player player, Side side, double xHit, double yHit) {
		int metadata = world.getBlockMetadata(x, y, z);
		int tickDelay = (metadata & 12) >> 2;
		tickDelay = tickDelay + 1 << 2 & 12;
		world.setBlockMetadataWithNotify(x, y, z, tickDelay | metadata & 3);
		return true;
	}

	public void onActivatorInteract(World world, int x, int y, int z, TileEntityActivator activator, Direction direction) {
		this.onBlockRightClicked(world, x, y, z, (Player)null, Side.NONE, (double)0.5F, (double)0.5F);
	}

	public void onBlockPlacedByMob(World world, int x, int y, int z, @NotNull Side side, Mob mob, double xPlaced, double yPlaced) {
		int l = mob.getHorizontalPlacementDirection(side).index;
		world.setBlockMetadataWithNotify(x, y, z, l);
		boolean flag = this.isGettingPower(world, x, y, z, l);
		if (flag) {
			world.scheduleBlockUpdate(x, y, z, this.id(), 1);
		}

	}

	public void onBlockPlacedOnSide(World world, int x, int y, int z, @NotNull Side side, double xPlaced, double yPlaced) {
		if (!side.isHorizontal()) {
			side = Side.NORTH;
		}

		int l = side.getDirection().index;
		world.setBlockMetadataWithNotify(x, y, z, l);
		boolean flag = this.isGettingPower(world, x, y, z, l);
		if (flag) {
			world.scheduleBlockUpdate(x, y, z, this.id(), 1);
		}

	}

	public void onBlockPlacedByWorld(World world, int x, int y, int z) {
		world.notifyBlocksOfNeighborChange(x + 1, y, z, this.id());
		world.notifyBlocksOfNeighborChange(x - 1, y, z, this.id());
		world.notifyBlocksOfNeighborChange(x, y, z + 1, this.id());
		world.notifyBlocksOfNeighborChange(x, y, z - 1, this.id());
		world.notifyBlocksOfNeighborChange(x, y - 1, z, this.id());
		world.notifyBlocksOfNeighborChange(x, y + 1, z, this.id());
	}

	public boolean isSolidRender() {
		return false;
	}

	public void animationTick(World world, int x, int y, int z, Random rand) {
		if (this.isRepeaterPowered) {
			int meta = world.getBlockMetadata(x, y, z);
			double px = (double)x + (double)0.5F + ((double)rand.nextFloat() - (double)0.5F) * 0.2;
			double py = (double)y + 0.4 + ((double)rand.nextFloat() - (double)0.5F) * 0.2;
			double pz = (double)z + (double)0.5F + ((double)rand.nextFloat() - (double)0.5F) * 0.2;
			double xOffset = (double)0.0F;
			double zOffset = (double)0.0F;
			int redstoneBrightness = 15;
			if (rand.nextInt(2) == 0) {
				switch (meta & 3) {
					case 0:
						zOffset = (double)-0.3125F;
						break;
					case 1:
						xOffset = (double)0.3125F;
						break;
					case 2:
						zOffset = (double)0.3125F;
						break;
					case 3:
						xOffset = (double)-0.3125F;
				}
			} else {
				int tickDelay = (meta & 12) >> 2;
				switch (meta & 3) {
					case 0:
						zOffset = torchPosOffset[tickDelay];
						break;
					case 1:
						xOffset = -torchPosOffset[tickDelay];
						break;
					case 2:
						zOffset = -torchPosOffset[tickDelay];
						break;
					case 3:
						xOffset = torchPosOffset[tickDelay];
				}
			}

			world.spawnParticle("reddust", px + xOffset, py, pz + zOffset, (double)0.0F, (double)0.0F, (double)0.0F, 15);
		}
	}
}
