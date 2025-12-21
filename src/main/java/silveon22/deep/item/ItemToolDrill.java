package silveon22.deep.item;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.player.inventory.slot.Slot;

public class ItemToolDrill extends ItemToolPickaxe {
	public ItemToolDrill(String name, String namespaceId, int id, ToolMaterial enumtoolmaterial) {
		super(name, namespaceId, id, enumtoolmaterial);
	}

	public boolean canHarvestBlock(Mob mob, ItemStack itemStack, Block<?> block) {
		Integer miningLevel = (Integer)miningLevels.get(block);
		if (miningLevel != null) {
			return this.material.getMiningLevel() >= miningLevel;
		} else {
			return block.hasTag(BlockTags.MINEABLE_BY_PICKAXE);
		}
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
