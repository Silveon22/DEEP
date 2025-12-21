package silveon22.deep.block.misc;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.EntityFallingBlock;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockLogicSlush extends BlockLogic {
	public static boolean fallInstantly = false;

	public BlockLogicSlush(Block<?> block) {
		super(block, Material.ice);
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
		if (canFallBelow(world, x, y - 1, z) && y >= 0) {
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
		return 1;
	}

	public static boolean canFallBelow(World world, int x, int y, int z) {
		Block<?> block = world.getBlock(x, y, z);
		return block == null || block.hasTag(BlockTags.PLACE_OVERWRITES);
	}
}
