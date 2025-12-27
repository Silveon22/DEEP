package silveon22.deep.mob.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.LightmapHelper;
import net.minecraft.client.render.entity.MobRenderer;
import net.minecraft.client.render.model.ModelSpider;
import net.minecraft.core.entity.monster.MobSpider;
import org.lwjgl.opengl.GL11;
import silveon22.deep.mob.MobWasp;
import silveon22.deep.mob.model.ModelWasp;

@Environment(EnvType.CLIENT)
public class MobRendererWasp extends MobRenderer<MobWasp> {
	public MobRendererWasp() {
		super(new ModelWasp(0.0F), 0.5F);
		this.setArmorModel(new ModelWasp(0.01F));
	}

	protected boolean setWaspEyeBrightness(MobWasp wasp, int renderPass, float partialTick) {
		if (renderPass == 0) {
			this.bindTexture("/assets/deep/textures/entity/wasp/eyes/" + wasp.getTextureReference() + ".png");
			float brightness = wasp.getBrightness(1.0F);
			if (LightmapHelper.isLightmapEnabled()) {
				LightmapHelper.setLightmapCoord(LightmapHelper.getLightmapCoord(15, 15));
			}

			float f1 = (1.0F - brightness) * 0.5F;
			GL11.glEnable(3042);
			GL11.glDisable(3008);
			GL11.glBlendFunc(770, 771);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
			return true;
		} else {
			return false;
		}
	}

	protected float getMaxDeathRotation(MobWasp entity) {
		return 180.0F;
	}

	protected boolean prepareArmor(MobWasp entity, int renderPass, float partialTick) {
		return this.setWaspEyeBrightness(entity, renderPass, partialTick);
	}
}
