package silveon22.deep.item;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.world.World;

public class ItemFoodSour extends ItemFood {

	private final int healAmount;
	private final boolean isWolfsFavoriteMeat;
	private final int ticksPerHeal;

	public ItemFoodSour(String name, String namespaceId, int id, int healAmount, int ticksPerHeal, boolean favouriteWolfMeat, int maxStackSize) {
		super(name, namespaceId, id, healAmount, ticksPerHeal, favouriteWolfMeat, maxStackSize);
		this.healAmount = healAmount;
		this.ticksPerHeal = ticksPerHeal;
		this.isWolfsFavoriteMeat = favouriteWolfMeat;
		this.maxStackSize = maxStackSize;
	}

	@Override
	public ItemStack onUseItem(ItemStack itemstack, World world, Player entityplayer) {
		if (entityplayer.getHealth() < entityplayer.getMaxHealth() && entityplayer.getHealth() + entityplayer.getTotalHealingRemaining() < entityplayer.getMaxHealth() && itemstack.consumeItem(entityplayer)) {
			entityplayer.hurt(null,this. healAmount/2 , DamageType.GENERIC);
			super.onUseItem(itemstack, world, entityplayer);
		}
		return itemstack;
	}

	public int getHealAmount() {return this.healAmount;}

	public int getTicksPerHeal() {
		return this.ticksPerHeal;
	}

	public boolean getIsWolfsFavoriteMeat() {
		return this.isWolfsFavoriteMeat;
	}
}
