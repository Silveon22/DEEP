package silveon22.deep.block.misc;

import java.util.Random;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.gamerule.GameRules;
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

public class BlockLogicRoot extends BlockLogic implements IBonemealable {
	public static final int MASK_PERMANENT = 128;
	public boolean canBeBonemealed = false;

	public BlockLogicRoot(Block<?> block) {
		super(block, Material.plant);
		block.setTicking(true);
		this.setBlockBounds((double)(0.10F), (double)0.10F, (double)(0.10F), (double)(0.90F), (double)(1), (double)(0.90F));
	}

	public BlockLogicRoot setBonemealable() {
		this.canBeBonemealed = true;
		return this;
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
				return new ItemStack[]{new ItemStack(DEEPBlocks.root)};
			default:
				return new ItemStack[]{new ItemStack(Items.STICK)};
		}
	}

	public boolean onBonemealUsed(ItemStack itemstack, @Nullable Player player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		Random rand = world.rand;
		if (!world.isClientSide && this.canBeBonemealed) {
			if (player == null || player.getGamemode().consumeBlocks()) {
				--itemstack.stackSize;
			}

			label35:
			for(int j1 = 0; j1 < 128; ++j1) {
				int k1 = blockX;
				int l1 = blockY;
				int i2 = blockZ;

				for(int j2 = 0; j2 < j1 / 16; ++j2) {
					k1 += rand.nextInt(3) - 1;
					l1 += (rand.nextInt(3) - 1) * rand.nextInt(3) / 2;
					i2 += rand.nextInt(3) - 1;
					int id1 = world.getBlockId(k1, l1 + 1, i2);
					if (!this.mayPlaceOn(id1)) {
						continue label35;
					}
				}

				if (world.getBlockId(k1, l1, i2) == 0 && (double)rand.nextFloat() > (double)0.75F) {
					world.setBlockWithNotify(k1, l1, i2, this.block.id());
				}
			}

			return true;
		} else {
			return this.canBeBonemealed;
		}
	}
}
