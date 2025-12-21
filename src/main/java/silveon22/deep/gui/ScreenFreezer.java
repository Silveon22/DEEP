package silveon22.deep.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.container.ScreenContainerAbstract;
import net.minecraft.client.input.controller.ControllerInput;
import net.minecraft.core.block.entity.TileEntityFurnace;
import net.minecraft.core.block.entity.TileEntityFurnaceBlast;
import net.minecraft.core.lang.I18n;
import net.minecraft.core.player.inventory.container.ContainerInventory;
import net.minecraft.core.player.inventory.menu.MenuFurnace;
import org.lwjgl.opengl.GL11;
import silveon22.deep.mob.TileEntityFreezer;

@Environment(EnvType.CLIENT)
public class ScreenFreezer extends ScreenContainerAbstract {
	private final TileEntityFreezer freezerInventory;

	public ScreenFreezer(ContainerInventory inventory, TileEntityFreezer tileEntityFreezer) {
		super(new MenuFreezer(inventory, tileEntityFreezer));
		this.freezerInventory = tileEntityFreezer;
	}

	protected void drawGuiContainerForegroundLayer() {
		I18n i18n = I18n.getInstance();
		this.font.drawString(i18n.translateKey("deep.gui.freezer.label.freezer"), 60, 6, 4210752);

		this.font.drawString(i18n.translateKey("deep.gui.freezer.label.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float f) {
		this.mc.textureManager.loadTexture("/assets/deep/textures/gui/freezer.png").bind();

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
		if (this.freezerInventory.isBurning()) {
			int fireHeight = this.freezerInventory.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(x + 56, y + 36 + 12 - fireHeight, 176, 12 - fireHeight, 14, fireHeight + 2);
			int arrowWidth = this.freezerInventory.getCookProgressScaled(24);
			this.drawTexturedModalRect(x + 79, y + 34, 176, 14, arrowWidth + 1, 16);
		}

	}
}
