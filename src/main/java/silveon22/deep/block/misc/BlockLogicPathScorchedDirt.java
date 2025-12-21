package silveon22.deep.block.misc;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

public class BlockLogicPathScorchedDirt extends BlockLogic {
	public BlockLogicPathScorchedDirt(Block<?> block) {
		super(block, Material.dirt);
		block.setTicking(true);
		this.setBlockBounds((double)0.0F, (double)0.0F, (double)0.0F, (double)1.0F, (double)0.9375F, (double)1.0F);
		block.withLightBlock(255);
	}

	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return AABB.getTemporaryBB((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1));
	}

	public boolean isSolidRender() {
		return false;
	}

	public boolean isCubeShaped() {
		return false;
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		super.onNeighborBlockChange(world, x, y, z, blockId);
		Material material = world.getBlockMaterial(x, y + 1, z);
		int id = world.getBlockId(x, y + 1, z);
		if (material.isSolid() && id != Blocks.FENCE_GATE_PLANKS_OAK.id() && id != Blocks.FENCE_GATE_PLANKS_OAK_PAINTED.id() && id != Blocks.SIGN_WALL_PLANKS_OAK.id()) {
			world.setBlockWithNotify(x, y, z, Blocks.DIRT_SCORCHED.id());
		}

	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case SILK_TOUCH:
			case PICK_BLOCK:
				return new ItemStack[]{new ItemStack(this)};
			default:
				return new ItemStack[]{new ItemStack(Blocks.DIRT_SCORCHED)};
		}
	}
}
