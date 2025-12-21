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

public class BlockLogicBulb extends BlockLogic {
	public BlockLogicBulb(Block<?> block) {
		super(block, Material.stone);
		block.setTicking(true);
		this.setBlockBounds((double)0.25F, (double)0.0F, (double)0.25F, (double)0.75F, (double)0.5F, (double)0.75F);
		block.withLightBlock(255);
	}

	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return AABB.getTemporaryBB((double)x + 0.25F, (double)y, (double)z + 0.25F, (double)(x + 0.75F), (double)(y + 0.5F), (double)(z + 0.75F));
	}

	public boolean isSolidRender() {
		return false;
	}

	public boolean isCubeShaped() {
		return false;
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		return new ItemStack[]{new ItemStack(this)};
	}
}
