package silveon22.deep.mob.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.MobRenderer;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.client.render.model.ModelCreeper;
import net.minecraft.core.entity.monster.MobCreeper;
import net.minecraft.core.util.helper.MathHelper;
import org.lwjgl.opengl.GL11;
import silveon22.deep.mob.MobPopper;
import silveon22.deep.mob.model.ModelPopper;

@Environment(EnvType.CLIENT)
public class MobRendererPopper extends MobRenderer<MobPopper> {
	private ModelBase chargedModel = new ModelPopper(2.0F);

	public MobRendererPopper() {
		super(new ModelPopper(), 0.5F);
	}

	protected void setupScale(MobPopper popper, float partialTick) {
		float g = popper.getSwelling(partialTick)*1.2F;
		float wobble = 1.0F + MathHelper.sin(g * 100.0F) * g * 0.01F;
		if (g < 0.0F) {
			g = 0.0F;
		}

		if (g > 1.2F) {
			g = 1.2F;
		}

		g *= g;
		g *= g;
		float s = (1.0F + g * 0.8F) * wobble;
		float hs = (1.0F + g * 0.2F) / wobble;
		GL11.glScalef(s, hs, s);
	}

	protected int getOverlayColor(MobPopper popper, float brightness, float partialTick) {
		float step = popper.getSwelling(partialTick);
		if ((int)(step * 10.0F) % 2 == 0) {
			return 0;
		} else {
			int _a = (int)(step * 0.2F * 255.0F);
			if (_a < 0) {
				_a = 0;
			}

			if (_a > 255) {
				_a = 255;
			}

			int r = 255;
			int g = 255;
			int b = 255;
			return _a << 24 | 16711680 | '\uff00' | 255;
		}
	}

	protected boolean prepareArmor(MobPopper entity, int layer, float partialTick) {
		if (entity.getPowered()) {
			if (layer == 1) {
				float f1 = (float)entity.tickCount + partialTick;
				this.bindTexture("/armor/power.png");
				GL11.glMatrixMode(5890);
				GL11.glLoadIdentity();
				float f2 = f1 * 0.01F;
				float f3 = f1 * 0.01F;
				GL11.glTranslatef(f2, f3, 0.0F);
				this.setArmorModel(this.chargedModel);
				GL11.glMatrixMode(5888);
				GL11.glEnable(3042);
				float brightness = 0.5F;
				GL11.glColor4f(brightness, brightness, brightness, 1.0F);
				GL11.glDisable(2896);
				GL11.glBlendFunc(1, 1);
				return true;
			}

			if (layer == 2) {
				GL11.glMatrixMode(5890);
				GL11.glLoadIdentity();
				GL11.glMatrixMode(5888);
				GL11.glEnable(2896);
				GL11.glDisable(3042);
			}
		}

		return false;
	}
}
