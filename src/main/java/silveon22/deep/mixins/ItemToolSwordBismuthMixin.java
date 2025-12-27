package silveon22.deep.mixins;

import net.minecraft.core.block.Block;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.item.tool.ItemToolSword;
import net.minecraft.core.player.inventory.slot.Slot;
import net.minecraft.core.util.collection.NamespaceID;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import silveon22.deep.DeepAchievements;
import silveon22.deep.item.DEEPItems;

@Mixin(value = ItemToolSword.class, remap = false)
public class ItemToolSwordBismuthMixin extends Item {
	public ItemToolSwordBismuthMixin(NamespaceID namespaceId, int id) {
		super(namespaceId, id);
	}

	@Unique
	public void setDurabilityCount(ItemStack stack, int count) {
		stack.setMetadata(stack.getMaxDamage() - count);
	}

	@Unique
	public boolean hasInventoryInteraction() {
		return true;
	}

	@Unique
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
					player.addStat(DeepAchievements.BISMUTH_REPAIR, 1);
				}
			}

			return stackInSlot;
		}
	}

	@Unique
	public int getDurabilityCount(ItemStack stack) {
		return stack.getMaxDamage() - stack.getMetadata();
	}

}
