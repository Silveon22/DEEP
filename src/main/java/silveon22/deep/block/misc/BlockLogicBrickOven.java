package silveon22.deep.block.misc;

import com.mojang.logging.LogUtils;
import net.minecraft.core.Global;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicRotatable;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.gui.displayBrickOvenScreen;
import silveon22.deep.mob.TileEntityBrickOven;

import java.util.Random;

public class BlockLogicBrickOven extends BlockLogicRotatable {
	private static final Logger LOGGER = LogUtils.getLogger();
	protected Random brickOvenRand;
	protected final boolean isActive;
	public static boolean keepFurnaceInventory = false;

	public BlockLogicBrickOven(Block<?> block, boolean active) {
		super(block, Material.stone);
		this.isActive = active;
		block.withEntity(TileEntityBrickOven::new);
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case PICK_BLOCK:
			case EXPLOSION:
			case PROPER_TOOL:
			case SILK_TOUCH:
			case PISTON_CRUSH:
				return new ItemStack[]{new ItemStack(DEEPBlocks.brickOvenIdle)};
			default:
				return null;
		}
	}

	public void animationTick(World world, int x, int y, int z, Random rand) {
		if (this.isActive) {
			int l = world.getBlockMetadata(x, y, z);
			double poxX = (double)x + (double)0.5F;
			double posY = (double)y + (double)0.1F + (double)(rand.nextFloat() * 6.0F / 16.0F);
			double posZ = (double)z + (double)0.5F;
			double f3 = (double)0.52F;
			double f4 = (double)(rand.nextFloat() * 0.6F - 0.3F);
			if (l == 4) {
				world.spawnParticle("smoke", poxX - f3, posY, posZ + f4, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				world.spawnParticle("flame", poxX - f3, posY, posZ + f4, (double)0.0F, (double)0.0F, (double)0.0F, 0);
			} else if (l == 5) {
				world.spawnParticle("smoke", poxX + f3, posY, posZ + f4, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				world.spawnParticle("flame", poxX + f3, posY, posZ + f4, (double)0.0F, (double)0.0F, (double)0.0F, 0);
			} else if (l == 2) {
				world.spawnParticle("smoke", poxX + f4, posY, posZ - f3, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				world.spawnParticle("flame", poxX + f4, posY, posZ - f3, (double)0.0F, (double)0.0F, (double)0.0F, 0);
			} else if (l == 3) {
				world.spawnParticle("smoke", poxX + f4, posY, posZ + f3, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				world.spawnParticle("flame", poxX + f4, posY, posZ + f3, (double)0.0F, (double)0.0F, (double)0.0F, 0);
			}

		}
	}

	public boolean onBlockRightClicked(World world, int x, int y, int z, Player player, Side side, double xPlaced, double yPlaced) {
		if (!world.isClientSide) {
			TileEntityBrickOven tileEntityBrickOven = (TileEntityBrickOven)world.getTileEntity(x, y, z);
			((displayBrickOvenScreen)player).deep$brickOvenScreen(tileEntityBrickOven);
		}

		return true;
	}

	public static void updateBrickOvenBlockState(boolean lit, @NotNull World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity == null) {
			String msg = "Brick Oven is missing Tile Entity at x: " + x + " y: " + y + " z: " + z + ", block will be removed!";
			if (Global.BUILD_CHANNEL.isUnstableBuild()) {
				throw new RuntimeException(msg);
			} else {
				world.setBlockWithNotify(x, y, z, 0);
				LOGGER.warn(msg);
			}
		} else {
			keepFurnaceInventory = true;
			if (lit) {
				world.setBlockWithNotify(x, y, z, DEEPBlocks.brickOvenActive.id());
			} else {
				world.setBlockWithNotify(x, y, z, DEEPBlocks.brickOvenIdle.id());
			}

			keepFurnaceInventory = false;
			world.setBlockMetadataWithNotify(x, y, z, meta);
			tileEntity.validate();
			world.setTileEntity(x, y, z, tileEntity);
		}
	}
}
