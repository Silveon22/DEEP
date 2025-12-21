package silveon22.deep.item;

import net.minecraft.core.entity.EntityFishingBobber;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFishingRod;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.slot.Slot;
import net.minecraft.core.world.World;

public class itemFishingRodSteel extends ItemFishingRod {
	public itemFishingRodSteel(String name, String namespaceId, int id) {
		super(name, namespaceId, id);
		this.setMaxDamage(4608);
		this.setMaxStackSize(1);
	}

	public void setDurabilityCount(ItemStack stack, int count) {
		stack.setMetadata(stack.getMaxDamage() - count);
	}

	public boolean hasInventoryInteraction() {
		return true;
	}

	public ItemStack onInventoryInteract(Player player, Slot slot, ItemStack stackInSlot, boolean isItemGrabbed) {
		if (isItemGrabbed) {
			return stackInSlot;
		} else {
			int durabilityCount = this.getDurabilityCount(stackInSlot);
			ItemStack grabbedItem = player.inventory.getHeldItemStack();
			if (grabbedItem != null && grabbedItem.itemID == DEEPItems.bismuth.id) {
				if (durabilityCount < this.getMaxDamage()) {
					int newDurabilityCount = Math.min(this.getMaxDamage(), stackInSlot.getMaxDamage());
					this.setDurabilityCount(stackInSlot, newDurabilityCount);
					--grabbedItem.stackSize;
					if (grabbedItem.stackSize <= 0) {
						player.inventory.setHeldItemStack((ItemStack)null);
					}
				}
			}

			return stackInSlot;
		}
	}

	public int getDurabilityCount(ItemStack stack) {
		return stack.getMaxDamage() - stack.getMetadata();
	}

}
