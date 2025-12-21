package silveon22.deep.item;

import net.minecraft.core.block.entity.TileEntityActivator;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.IDispensable;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.world.World;
import silveon22.deep.mob.ProjectileHail;
import silveon22.deep.mob.ProjectileSilverKnife;

import java.util.Random;

public class ItemHail extends Item implements IDispensable {
	public ItemHail(String name, String namespaceId, int id) {
		super(name, namespaceId, id);
		this.maxStackSize = 64;
	}

	public ItemStack onUseItem(ItemStack itemstack, World world, Player entityplayer) {
		itemstack.consumeItem(entityplayer);
		world.playSoundAtEntity(entityplayer, entityplayer, "deep:mob.snowbomination.hail.launch", 1F, 0.7F);
		if (!world.isClientSide) {
			ProjectileHail projectileHail = new ProjectileHail(world, entityplayer);
			projectileHail.yd = 0.5;
			projectileHail.xd *= 0.2;
			projectileHail.zd *= 0.2;
			world.entityJoinedWorld(projectileHail);
		}

		return itemstack;
	}

	public void onUseByActivator(ItemStack itemStack, TileEntityActivator activatorBlock, World world, Random random, int blockX, int blockY, int blockZ, double offX, double offY, double offZ, Direction direction) {
		world.playSoundEffect((Entity)null, SoundCategory.ENTITY_SOUNDS, (double)blockX + (double)0.5F, (double)blockY + (double)0.5F, (double)blockZ + (double)0.5F, "deep:mob.snowbomination.hail.launch", 1.0F, 0.7F);
		ProjectileHail projectileHail = new ProjectileHail(world, (double)blockX + offX, (double)blockY + offY, (double)blockZ + offZ);
		projectileHail.setHeading((double)direction.getOffsetX() * 0.6, direction.getOffsetY() == 0 ? 0.1 : (double)direction.getOffsetY() * 0.6, (double)((float)direction.getOffsetZ() * 0.6F), 0.6F, 2.0F);
		if (projectileHail.yd > 0) {
			projectileHail.yd = 0.5;
		}
		projectileHail.xd *= 0.2;
		projectileHail.zd *= 0.2;
		world.entityJoinedWorld(projectileHail);
		--itemStack.stackSize;
	}

	public void onDispensed(ItemStack itemStack, World world, double x, double y, double z, int xOffset, int yOffset, int zOffset, Random random) {
		world.playSoundEffect((Entity)null, SoundCategory.ENTITY_SOUNDS, (double)x + (double)0.5F, (double)y + (double)0.5F, (double)z + (double)0.5F, "deep:mob.snowbomination.hail.launch", 1.0F, 0.7F);
		ProjectileHail entityhail = new ProjectileHail(world, x, y, z);
		entityhail.setHeading((double)xOffset, (double)yOffset + 0.1, (double)zOffset, 0.6F, 2.0F);
		if (entityhail.yd > 0) {
			entityhail.yd = 0.5;
		}
		entityhail.xd *= 0.2;
		entityhail.zd *= 0.2;
		--itemStack.stackSize;
		world.entityJoinedWorld(entityhail);
	}
}
