package silveon22.deep.block.Models;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.LightmapHelper;
import net.minecraft.client.render.block.color.BlockColor;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.WorldSource;

import static silveon22.deep.Deep.MOD_ID;

@Environment(EnvType.CLIENT)
public class BlockModelLilypad<T extends BlockLogic> extends BlockModelStandard<T> {
	public BlockModelLilypad(Block<T> block) {
		super(block);
	}
	private final IconCoordinate waterLilyOverlay = TextureRegistry.getTexture(MOD_ID + ":block/waterlily");

	public boolean render(Tessellator tessellator, int x, int y, int z) {
		AABB bounds = this.block.getBlockBoundsFromState(renderBlocks.blockAccess, x, y, z);
		AABB bounds2 = this.block.getBlockBoundsFromState(renderBlocks.blockAccess, x, y, z);
		float brightness = 1.0F;
		if (!LightmapHelper.isLightmapEnabled()) {
			brightness = this.getBlockBrightness(renderBlocks.blockAccess, x, y, z);
		} else {
			tessellator.setLightmapCoord(this.block.getLightmapCoord(renderBlocks.blockAccess, x, y, z));
		}

		int color = ((BlockColor)BlockColorDispatcher.getInstance().getDispatch(this.block)).getWorldColor(renderBlocks.blockAccess, x, y, z);
		float red = (float)(color >> 16 & 255) / 255.0F;
		float green = (float)(color >> 8 & 255) / 255.0F;
		float blue = (float)(color & 255) / 255.0F;
		tessellator.setColorOpaque_F(red * brightness, green * brightness, blue * brightness);
		IconCoordinate tex = this.getBlockTextureFromSideAndMetadata(Side.TOP, renderBlocks.blockAccess.getBlockMetadata(x, y, z));
		IconCoordinate tex2 = this.getBlockTextureFromSideAndMetadata(Side.NORTH, renderBlocks.blockAccess.getBlockMetadata(x, y, z));
		this.renderTopFace(tessellator, bounds, (double)x, (double)y - 0.1125, (double)z, tex);
		this.renderBottomFace(tessellator, bounds, (double)x, (double)y + 0.0125, (double)z, tex);
		red = (float) (255);
		green = (float)(255);
		blue = (float)(255);
		tessellator.setColorOpaque_F(red * brightness, green * brightness, blue * brightness);
		renderBlocks.overrideBlockTexture = this.waterLilyOverlay;
		this.renderTopFace(tessellator, bounds2, x, y - 0.0625, z, waterLilyOverlay);
		renderBlocks.overrideBlockTexture = null;
		return true;
	}

	public boolean shouldItemRender3d() {
		return false;
	}

	public boolean shouldSideBeRendered(WorldSource blockAccess, AABB bounds, int x, int y, int z, int side) {
		return side == 1 ? true : super.shouldSideBeRendered(blockAccess, bounds, x, y, z, side);
	}

	@Override
	public IconCoordinate getParticleTexture(Side side, int meta) {
		return TextureRegistry.getTexture(MOD_ID + ":block/lilypad");
	}
}
