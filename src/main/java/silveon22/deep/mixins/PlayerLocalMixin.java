package silveon22.deep.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.PlayerLocal;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import silveon22.deep.gui.ScreenBrickOven;
import silveon22.deep.gui.ScreenFreezer;
import silveon22.deep.gui.displayBrickOvenScreen;
import silveon22.deep.gui.displayFreezerScreen;
import silveon22.deep.mob.TileEntityBrickOven;
import silveon22.deep.mob.TileEntityFreezer;


@Mixin(value = PlayerLocal.class, remap = false)
public abstract class PlayerLocalMixin extends Player implements displayFreezerScreen, displayBrickOvenScreen {

	@Shadow
	protected Minecraft mc;

	public PlayerLocalMixin(World world) {
		super(world);
	}

	@Override
	public void deep$freezerScreen(TileEntityFreezer freezer) {
		this.mc.displayScreen(new ScreenFreezer(this.inventory, freezer));
	}

	@Override
	public void deep$brickOvenScreen(TileEntityBrickOven brickOven) {
		this.mc.displayScreen(new ScreenBrickOven(this.inventory, brickOven));
	}
}
