package silveon22.deep.item;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.IArmorItem;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ArmorMaterial;
import net.minecraft.core.player.inventory.slot.Slot;
import org.jetbrains.annotations.Nullable;

import static silveon22.deep.item.DEEPItems.bandolier_Armor;
import static silveon22.deep.item.DEEPItems.diving_Armor;

public class ItemBandolier extends Item implements IArmorItem {
	public ItemBandolier(String name, String namespaceId, int id) {
		super(name, namespaceId, id);
		this.setMaxStackSize(1);
		this.setMaxDamage(96);
	}

	public boolean hasInventoryInteraction() {
		return true;
	}

	public ItemStack onInventoryInteract(Player player, Slot slot, ItemStack stackInSlot, boolean isItemGrabbed) {
		ItemStack bandolierItem;
		if (isItemGrabbed) {
			bandolierItem = player.inventory.getHeldItemStack();
		} else {
			bandolierItem = stackInSlot;
		}

		int totalSpace = this.getMaxDamageForStack(stackInSlot);
		int bulletCount = this.getBulletCount(bandolierItem);
		int freeSpace = totalSpace - bulletCount;
		if (isItemGrabbed) {
			if (stackInSlot == null) {
				int amount = Math.min(64, bulletCount);
				if (amount > 0) {
					ItemStack bulletStack = new ItemStack(DEEPItems.ammoBullet, amount, 0);
					if (slot.mayPlace(bulletStack)) {
						this.setBulletCount(bandolierItem, bulletCount - amount);
						stackInSlot = bulletStack;
					}
				}
			} else if (stackInSlot != null && stackInSlot.itemID == DEEPItems.ammoBullet.id) {
				int amount = Math.min(freeSpace, stackInSlot.stackSize);
				if (amount > 0) {
					this.setBulletCount(bandolierItem, bulletCount + amount);
					stackInSlot.stackSize -= amount;
				}
			}
		} else {
			ItemStack grabbedItem = player.inventory.getHeldItemStack();
			if (grabbedItem != null && grabbedItem.itemID == DEEPItems.ammoBullet.id) {
				int amount = Math.min(grabbedItem.stackSize, freeSpace);
				if (amount > 0) {
					grabbedItem.stackSize -= amount;
					this.setBulletCount(bandolierItem, bulletCount + amount);
					if (grabbedItem.stackSize <= 0) {
						player.inventory.setHeldItemStack((ItemStack)null);
					}
				}
			} else if (grabbedItem == null) {
				int amount = Math.min(64, bulletCount);
				if (amount > 0) {
					this.setBulletCount(bandolierItem, bulletCount - amount);
					player.inventory.setHeldItemStack(new ItemStack(DEEPItems.ammoBullet, amount, 0));
				}
			}
		}

		return stackInSlot;
	}

	private int getBulletCount(ItemStack stack) {
		return stack.getMaxDamage() - stack.getMetadata();
	}

	private void setBulletCount(ItemStack stack, int count) {
		stack.setMetadata(stack.getMaxDamage() - count);
	}

	public boolean showFullDurability() {
		return true;
	}

	public @Nullable ArmorMaterial getArmorMaterial() {
		return bandolier_Armor;
	}

	public int getArmorPiece() {
		return 1;
	}
}
