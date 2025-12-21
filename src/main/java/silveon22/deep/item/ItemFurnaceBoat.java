package silveon22.deep.item;

import java.util.Random;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntityActivator;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.entity.vehicle.EntityBoat;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.util.phys.Vec3;
import net.minecraft.core.util.phys.HitResult.HitType;
import net.minecraft.core.world.World;
import silveon22.deep.mob.EntityFurnaceBoat;

public class ItemFurnaceBoat extends Item {
	public ItemFurnaceBoat(String name, String namespaceId, int id) {
		super(name, namespaceId, id);
		this.maxStackSize = 1;
	}

	public ItemStack onUseItem(ItemStack itemstack, World world, Player entityplayer) {
		float f = 1.0F;
		float f1 = entityplayer.xRotO + (entityplayer.xRot - entityplayer.xRotO) * f;
		float f2 = entityplayer.yRotO + (entityplayer.yRot - entityplayer.yRotO) * f;
		double d = entityplayer.xo + (entityplayer.x - entityplayer.xo) * (double)f;
		double d1 = entityplayer.yo + (entityplayer.y - entityplayer.yo) * (double)f + 1.62 - (double)entityplayer.heightOffset;
		double d2 = entityplayer.zo + (entityplayer.z - entityplayer.zo) * (double)f;
		Vec3 vec3 = Vec3.getTempVec3(d, d1, d2);
		float f3 = MathHelper.cos(-f2 * 0.01745329F - (float)Math.PI);
		float f4 = MathHelper.sin(-f2 * 0.01745329F - (float)Math.PI);
		float f5 = -MathHelper.cos(-f1 * 0.01745329F);
		float f6 = MathHelper.sin(-f1 * 0.01745329F);
		float f7 = f4 * f5;
		float f9 = f3 * f5;
		double d3 = (double)5.0F;
		Vec3 vec31 = vec3.add((double)f7 * d3, (double)f6 * d3, (double)f9 * d3);
		HitResult movingobjectposition = world.checkBlockCollisionBetweenPoints(vec3, vec31, true);
		if (movingobjectposition == null) {
			return itemstack;
		} else {
			if (movingobjectposition.hitType == HitType.TILE) {
				int i = movingobjectposition.x;
				int j = movingobjectposition.y;
				int k = movingobjectposition.z;
				if (!world.isClientSide) {
					if (world.getBlockId(i, j, k) == Blocks.LAYER_SNOW.id()) {
						--j;
					}

					EntityFurnaceBoat boat = new EntityFurnaceBoat(world);
					boat.setPos((double)((float)i + 0.5F), (double)((float)j + 1.0F), (double)((float)k + 0.5F));
					boat.setRot(entityplayer.yRot - 90.0F, 0.0F);
					world.entityJoinedWorld(boat);
				}

				itemstack.consumeItem(entityplayer);
			}

			return itemstack;
		}
	}

	public void onUseByActivator(ItemStack itemStack, TileEntityActivator activatorBlock, World world, Random random, int blockX, int blockY, int blockZ, double offX, double offY, double offZ, Direction direction) {
		double x = (double)blockX + offX + (double)direction.getOffsetX();
		double y = (double)blockY + offY + (double)direction.getOffsetY();
		double z = (double)blockZ + offZ + (double)direction.getOffsetZ();
		itemStack.consumeItem((Player)null);
		EntityBoat boat = new EntityBoat(world, x, y, z);
		world.entityJoinedWorld(boat);
	}
}
