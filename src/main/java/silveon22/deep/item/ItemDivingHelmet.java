package silveon22.deep.item;

import net.minecraft.core.item.IArmorItem;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.material.ArmorMaterial;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

import static silveon22.deep.item.DEEPItems.diving_Armor;

public class ItemDivingHelmet extends Item implements IArmorItem {
	public ItemDivingHelmet(String translationKey, String namespaceId, int id) {
		super(translationKey, namespaceId, id);
		this.setMaxStackSize(1);
	}

	public @Nullable ArmorMaterial getArmorMaterial() {
		return diving_Armor;
	}

	public int getArmorPiece() {
		return 3;
	}

	// slotId is for all slots of the player 36 inventory + 4 armor
	public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slotId, boolean flag) {
		Player player = (Player) entity;
		if (
			slotId > player.inventory.mainInventory.length // we check that its in the armor slot
				&& slotId - player.inventory.mainInventory.length == 3 // we make sure that its on the head
		) {
			player.airSupply = 300;
		}
		return;
	}

}
