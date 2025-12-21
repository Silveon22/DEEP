package silveon22.deep.block.misc;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

public class BlockLogicRagingSoulSand extends BlockLogic {
	public BlockLogicRagingSoulSand(Block<?> block) {
		super(block, Material.soulsand);
	}

	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		float f = 0.125F;
		return AABB.getTemporaryBB((double)x + f, (double)y + f, (double)z + f, (double)(x + 1 - f), (double)((float)(y + 1) - f), (double)(z + 1 - f));
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		entity.xd = 0.0F;
		entity.zd = 0.0F;
		entity.yd = 0.0F;
		if (entity instanceof Mob) {

			if (entity.tickCount % 5 == 0) {
				entity.hurt((Entity)null, 2, DamageType.GENERIC);
			}

			entity.stuckInSpikes = true;

		}
		else if (entity instanceof EntityItem) {
			entity.remove();
			world.playSoundEffect((Entity)null, SoundCategory.WORLD_SOUNDS, (double)x + (double)0.5F, (double)y + 0.5, (double)z + (double)0.5F, "random.bite", 0.3F, 1F);
		}

	}

}
