package silveon22.deep.item;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.World;

public class ItemJarred extends ItemFood {
	public ItemJarred(String name, String namespaceId, int id, int healAmount, int ticksPerHeal) {
		super(name, namespaceId, id, healAmount, ticksPerHeal, false, 1);
	}

	public ItemStack onUseItem(ItemStack itemstack, World world, Player entityplayer) {
		ItemStack stack = super.onUseItem(itemstack, world, entityplayer);
		return stack.stackSize <= 0 ? Items.JAR.getDefaultStack() : stack;
	}
}
