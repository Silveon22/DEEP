package silveon22.deep.mob.model;

import java.util.Random;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.core.util.helper.MathHelper;

@Environment(EnvType.CLIENT)
public class ModelWisp extends ModelBase {
	Cube body;

	public ModelWisp() {
		byte yOff = -16;
		this.body = new Cube(0, 0);
		this.body.addBox(-4.0F, -12F, -4.0F, 8, 8, 8);
		Cube var10000 = this.body;
		var10000.y += (float)(24 + yOff);

	}

	public void render(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		this.setupAnimation(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
		this.body.render(scale * 2.5F);

	}
}
