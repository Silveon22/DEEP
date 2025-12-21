package silveon22.deep.block.Models;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.LightmapHelper;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.block.model.BlockModelTorch;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.core.Global;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicRepeater;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.WorldSource;
import silveon22.deep.block.misc.BlockLogicBigRepeater;

@Environment(EnvType.CLIENT)
public class BlockModelBigRepeater extends BlockModelStandard<BlockLogicBigRepeater> {
	private static final BlockModelTorch<?> modelTorchActive;
	private static final BlockModelTorch<?> modelTorchIdle;

	public BlockModelBigRepeater(Block<BlockLogicBigRepeater> block) {
		super(block);
	}

	public boolean render(Tessellator tessellator, int x, int y, int z) {
		int meta = renderBlocks.blockAccess.getBlockMetadata(x, y, z);
		int i1 = meta & 3;
		switch (i1) {
			case 0:
				renderBlocks.uvRotateTop = 0;
				break;
			case 1:
				renderBlocks.uvRotateTop = 1;
				break;
			case 2:
				renderBlocks.uvRotateTop = 3;
				break;
			case 3:
				renderBlocks.uvRotateTop = 2;
		}

		int j1 = (meta & 12) >> 2;
		this.renderStandardBlock(tessellator, this.block.getBlockBoundsFromState(renderBlocks.blockAccess, x, y, z), x, y, z);
		this.resetRenderBlocks();
		float brightness = 1.0F;
		if (LightmapHelper.isLightmapEnabled()) {
			int lmc = this.block.getLightmapCoord(renderBlocks.blockAccess, x, y, z);
			if (this.block.emission > 0) {
				lmc = LightmapHelper.setBlocklightValue(lmc, 15);
			}

			tessellator.setLightmapCoord(lmc);
		} else {
			brightness = this.getBlockBrightness(renderBlocks.blockAccess, x, y, z);
			if (this.block.emission > 0 || Global.accessor.isFullbrightEnabled()) {
				brightness = 1.0F;
			}
		}

		tessellator.setColorOpaque_F(brightness, brightness, brightness);
		double d = (double)-0.1875F;
		double d1 = (double)0.0F;
		double d2 = (double)0.0F;
		double d3 = (double)0.0F;
		double d4 = (double)0.0F;
		switch (i1) {
			case 0:
				d4 = (double)-0.3125F;
				d2 = BlockLogicBigRepeater.torchPosOffset[j1];
				break;
			case 1:
				d3 = (double)0.3125F;
				d1 = -BlockLogicBigRepeater.torchPosOffset[j1];
				break;
			case 2:
				d4 = (double)0.3125F;
				d2 = -BlockLogicBigRepeater.torchPosOffset[j1];
				break;
			case 3:
				d3 = (double)-0.3125F;
				d1 = BlockLogicBigRepeater.torchPosOffset[j1];
		}

		BlockModelTorch<?> modelTorch = ((BlockLogicBigRepeater)this.block.getLogic()).isRepeaterPowered ? modelTorchActive : modelTorchIdle;
		if (renderBlocks.overbright && ((BlockLogicBigRepeater)this.block.getLogic()).isRepeaterPowered) {
			modelTorch.renderTorchAtAngle(tessellator, (double)x + d1, (double)y + d, (double)z + d2, (double)0.0F, (double)0.0F);
			modelTorch.renderTorchAtAngle(tessellator, (double)x + d3, (double)y + d, (double)z + d4, (double)0.0F, (double)0.0F);
		} else if (!renderBlocks.overbright) {
			modelTorch.renderTorchAtAngle(tessellator, (double)x + d1, (double)y + d, (double)z + d2, (double)0.0F, (double)0.0F);
			modelTorch.renderTorchAtAngle(tessellator, (double)x + d3, (double)y + d, (double)z + d4, (double)0.0F, (double)0.0F);
		}

		return true;
	}

	public boolean shouldItemRender3d() {
		return false;
	}

	public boolean shouldSideBeRendered(WorldSource blockAccess, AABB bounds, int x, int y, int z, int side) {
		return true;
	}

	static {
		modelTorchActive = (BlockModelTorch) BlockModelDispatcher.getInstance().getDispatch(Blocks.TORCH_REDSTONE_ACTIVE);
		modelTorchIdle = (BlockModelTorch)BlockModelDispatcher.getInstance().getDispatch(Blocks.TORCH_REDSTONE_IDLE);
	}
}
