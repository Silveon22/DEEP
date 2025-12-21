package silveon22.deep.item;

import net.minecraft.core.item.IArmorItem;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.material.ArmorMaterial;
import org.jetbrains.annotations.Nullable;

import static silveon22.deep.item.DEEPItems.bandolier_Armor;
import static silveon22.deep.item.DEEPItems.gold_bandolier_Armor;

public class ItemBandolierEndless extends Item implements IArmorItem {
	public ItemBandolierEndless(String name, String namespaceId, int id) {
		super(name, namespaceId, id);
		this.setMaxStackSize(1);
	}

	public @Nullable ArmorMaterial getArmorMaterial() {
		return gold_bandolier_Armor;
	}

	public int getArmorPiece() {
		return 1;
	}
}
