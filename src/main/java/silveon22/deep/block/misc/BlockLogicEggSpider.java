package silveon22.deep.block.misc;

import java.util.Random;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.BlockLogicFlower;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.entity.TileEntityMobSpawner;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.monster.MobSpider;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;
import silveon22.deep.item.DEEPItems;

public class BlockLogicEggSpider extends BlockLogic {
	public BlockLogicEggSpider(Block<?> block) {
		super(block, Material.cloth);
		float f = 0.4F;
		this.setBlockBounds((double)(0.5F - f), (double)0.0F, (double)(0.5F - f), (double)(0.5F + f), (double)(f * 2.0F), (double)(0.5F + f));
	}

	public boolean isSolidRender() {
		return false;
	}

	public boolean isCubeShaped() {
		return false;
	}

	protected boolean mayPlaceOn(int blockId) {
		return Blocks.solid[blockId];
	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		if (y >= 0 && y < world.getHeightBlocks()) {
			return world.getFullBlockLightValue(x, y, z) < 13 && this.mayPlaceOn(world.getBlockId(x, y - 1, z));
		} else {
			return false;
		}
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (entity instanceof Player) {
			world.scheduleBlockUpdate(x, y, z, this.block.id(), this.tickDelay());
		}

	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		super.onNeighborBlockChange(world, x, y, z, blockId);
		world.scheduleBlockUpdate(x, y, z, this.block.id(), this.tickDelay());
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		world.setBlockWithNotify(x, y, z, 0);

	}

	public int tickDelay() {
		return 3;
	}

	public void onBlockRemoved(World world, int x, int y, int z, int data) {
		if (!world.isClientSide) {
			for(int j = 0; j < 2; ++j) {
				MobSpider mobSpider = new MobSpider(world);
				mobSpider.moveTo(x, y + (double)0.2F, z, world.rand.nextFloat() * 360.0F, world.rand.nextFloat() * 360.0F);
				world.spawnParticle("snowshovel", x, y, z, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				world.entityJoinedWorld(mobSpider);
				world.playSoundEffect((Entity)null, SoundCategory.WORLD_SOUNDS, (double)x + (double)0.5F, (double)y + 0.1, (double)z + (double)0.5F, "mob.slime", 1F, 0.7F);
			}
		}
		super.onBlockRemoved(world, x, y, z, data);
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case SILK_TOUCH:
			case PICK_BLOCK:
			case PROPER_TOOL:
			case EXPLOSION:
			case PISTON_CRUSH:
			case WORLD:
			default:
				return null;
		}
	}
}
