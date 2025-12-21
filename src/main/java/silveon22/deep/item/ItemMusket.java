package silveon22.deep.item;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.entity.projectile.ProjectileArrow;
import net.minecraft.core.entity.projectile.ProjectileArrowGolden;
import net.minecraft.core.entity.projectile.ProjectileArrowPurple;
import net.minecraft.core.entity.projectile.ProjectileCannonball;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.World;
import silveon22.deep.mob.ProjectileBullet;
import silveon22.deep.mob.ProjectileHail;

public class ItemMusket extends Item {
	public ItemMusket(String name, String namespaceId, int id) {
		super(name, namespaceId, id);
		this.maxStackSize = 1;
		this.setMaxDamage(1536);
	}

	public ItemStack onUseItem(ItemStack itemstack, World world, Player entityplayer) {
		ItemStack bandolierSlot = entityplayer.inventory.armorItemInSlot(1);
		if (bandolierSlot != null && bandolierSlot.itemID == DEEPItems.armorBandolier.id && bandolierSlot.getMetadata() < bandolierSlot.getMaxDamage()) {
			entityplayer.inventory.armorItemInSlot(1).damageItem(1, entityplayer);
			itemstack.damageItem(1, entityplayer);
			world.playSoundAtEntity(entityplayer, entityplayer, "random.bow", 0.3F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isClientSide) {
				ProjectileBullet projectileBullet =new ProjectileBullet(world, entityplayer);
				world.entityJoinedWorld(projectileBullet);
			}
		} else if (bandolierSlot != null && bandolierSlot.itemID == DEEPItems.armorBandolierEndless.id) {
			itemstack.damageItem(1, entityplayer);
			world.playSoundAtEntity(entityplayer, entityplayer, "random.bow", 0.3F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isClientSide) {
				ProjectileBullet projectileBullet = new ProjectileBullet(world, entityplayer);
				world.entityJoinedWorld(projectileBullet);
			}
		} else if (entityplayer.inventory.consumeInventoryItem(DEEPItems.ammoBullet.id)) {
			itemstack.damageItem(1, entityplayer);
			world.playSoundAtEntity(entityplayer, entityplayer, "random.bow", 0.3F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isClientSide) {
				ProjectileBullet projectileBullet =new ProjectileBullet(world, entityplayer);
				world.entityJoinedWorld(projectileBullet);
			}
		}

		return itemstack;
	}

}
