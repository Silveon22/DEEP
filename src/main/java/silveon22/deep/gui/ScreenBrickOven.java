package silveon22.deep.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.container.ScreenContainerAbstract;
import net.minecraft.core.lang.I18n;
import net.minecraft.core.player.inventory.container.ContainerInventory;
import org.lwjgl.opengl.GL11;
import silveon22.deep.mob.TileEntityBrickOven;

@Environment(EnvType.CLIENT)
public class ScreenBrickOven extends ScreenContainerAbstract {
	private final TileEntityBrickOven brickOvenInventory;

	public ScreenBrickOven(ContainerInventory inventory, TileEntityBrickOven tileEntityBrickOven) {
		super(new MenuBrickOven(inventory, tileEntityBrickOven));
		this.brickOvenInventory = tileEntityBrickOven;
	}

	protected void drawGuiContainerForegroundLayer() {
		I18n i18n = I18n.getInstance();
		this.font.drawString(i18n.translateKey("deep.gui.brick.oven.label.brick.oven"), 60, 6, 4210752);

		this.font.drawString(i18n.translateKey("deep.gui.brick.oven.label.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float f) {
		this.mc.textureManager.loadTexture("/assets/minecraft/textures/gui/container/furnace.png").bind();

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
		if (this.brickOvenInventory.isBurning()) {
			int fireHeight = this.brickOvenInventory.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(x + 56, y + 36 + 12 - fireHeight, 176, 12 - fireHeight, 14, fireHeight + 2);
			int arrowWidth = this.brickOvenInventory.getCookProgressScaled(24);
			this.drawTexturedModalRect(x + 79, y + 34, 176, 14, arrowWidth + 1, 16);
		}

	}
}
