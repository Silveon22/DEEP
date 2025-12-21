package silveon22.deep.mob.renderer;

import org.lwjgl.opengl.GL11;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.MobRenderer;
import net.minecraft.client.render.tessellator.Tessellator;
import silveon22.deep.mob.MobTruffle;
import silveon22.deep.mob.model.ModelTruffle;

@Environment(EnvType.CLIENT)
public class MobRendererTruffle extends MobRenderer<MobTruffle> {
	public MobRendererTruffle() {
		super(new ModelTruffle(), 0.5f);
	}

	@Override
	public void renderPreview(Tessellator tessellator, MobTruffle truffle, double x, double y, double z, float yaw, float partialTick) {
		GL11.glPushMatrix();
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		super.renderPreview(tessellator, truffle, x, y + 2, z, yaw, partialTick);
		GL11.glPopMatrix();
	}
}
