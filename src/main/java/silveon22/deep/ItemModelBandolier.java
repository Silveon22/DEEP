package silveon22.deep;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static silveon22.deep.Deep.MOD_ID;

@Environment(EnvType.CLIENT)
public class ItemModelBandolier extends ItemModelStandard {
	protected IconCoordinate quiverFull = TextureRegistry.getTexture(MOD_ID + ":item/armor_bandolier_empty");

	public ItemModelBandolier(Item item, String namespace) {
		super(item, namespace);
	}

	public @NotNull IconCoordinate getIcon(@Nullable Entity entity, ItemStack itemStack) {
		return itemStack.getMetadata() >= itemStack.getItem().getMaxDamage() ? this.quiverFull : super.getIcon(entity, itemStack);
	}
}
