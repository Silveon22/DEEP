package silveon22.deep.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.ContainerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import silveon22.deep.gui.ScreenFreezer;
import silveon22.deep.gui.displayFreezerScreen;
import silveon22.deep.mob.TileEntityFreezer;


@Mixin(value = Player.class, remap = false)
public abstract class PlayerMixin implements displayFreezerScreen {

	@Override
	public void deep$freezerScreen(TileEntityFreezer freezer) {
	}
}
