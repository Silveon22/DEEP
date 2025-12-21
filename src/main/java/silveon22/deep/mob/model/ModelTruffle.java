package silveon22.deep.mob.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.core.util.helper.MathHelper;

@Environment(EnvType.CLIENT)
public class ModelTruffle extends ModelBase {
	public Cube head;
	public Cube hair;
	public Cube legRight;
	public Cube legLeft;

	public ModelTruffle() {
		this(0.0F);
	}

	public ModelTruffle(float expansion) {
		this(expansion, 0.0F);
	}

	public ModelTruffle(float expansion, float yRotOffset) {
		this.head = new Cube(0, 0);
		this.head.addBox(-4.0F, 0F, -4.0F, 8, 2, 8, expansion);
		this.head.setRotationPoint(0.0F, 10F + yRotOffset, 0.0F);
		this.hair = new Cube(16, 12);
		this.hair.addBox(-6.0F, -4F, -6.0F, 12, 4, 12, expansion);
		this.hair.setRotationPoint(0.0F, 10F + yRotOffset, 0.0F);
		this.legRight = new Cube(0, 12);
		this.legRight.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, expansion);
		this.legRight.setRotationPoint(-2.0F, 12.0F + yRotOffset, 0.0F);
		this.legLeft = new Cube(0, 12);
		this.legLeft.mirror = true;
		this.legLeft.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, expansion);
		this.legLeft.setRotationPoint(2.0F, 12.0F + yRotOffset, 0.0F);
	}

	public void render(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		this.setupAnimation(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
		this.head.render(scale);
		this.legRight.render(scale);
		this.legLeft.render(scale);
		this.hair.render(scale);
	}

	public void setupAnimation(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		this.head.yRot = headYaw / 57.29578F;
		this.head.xRot = headPitch / 57.29578F;
		this.hair.yRot = this.head.yRot;
		this.hair.xRot = this.head.xRot;
		this.legRight.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbYaw;
		this.legLeft.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbYaw;
		this.legRight.yRot = 0.0F;
		this.legLeft.yRot = 0.0F;
		if (this.isRiding) {
			this.legRight.xRot = -1.256637F;
			this.legLeft.xRot = -1.256637F;
			this.legRight.yRot = 0.3141593F;
			this.legLeft.yRot = -0.3141593F;
		}


		if (this.onGround > -9990.0F) {
			float f6 = this.onGround;
			f6 = 1.0F - this.onGround;
			f6 *= f6;
			f6 *= f6;
			f6 = 1.0F - f6;
			float f7 = MathHelper.sin(f6 * (float)Math.PI);
			float f8 = MathHelper.sin(this.onGround * (float)Math.PI) * -(this.head.xRot - 0.7F) * 0.75F;
		}
	}
}
