package silveon22.deep.mob.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.core.util.helper.MathHelper;

@Environment(EnvType.CLIENT)
public class ModelPopper extends ModelBase {
	public Cube head;
	public Cube hair;
	public Cube body;
	public Cube leg1;
	public Cube leg2;
	public Cube leg3;
	public Cube leg4;

	public ModelPopper() {
		this(0.0F);
	}

	public ModelPopper(float expansion) {
		int yOff = 4;
		this.head = new Cube(0, 0);
		this.head.addBox(-4.0F, -15.0F, -2.0F, 8, 12, 4, 5F + expansion);
		this.head.setRotationPoint(0.0F, (float)yOff, 0.0F);
		this.hair = new Cube(32, 0);
		this.hair.addBox(-4.0F, -15.0F, -2.0F, 8, 12, 4, 5.5F + expansion);
		this.hair.setRotationPoint(0.0F, (float)yOff, 0.0F);
		this.body = new Cube(16, 16);
		this.body.addBox(-4.0F, 2.0F, -2.0F, 8, 12, 4, expansion);
		this.body.setRotationPoint(0.0F, (float)yOff, 0.0F);
		this.leg1 = new Cube(0, 16);
		this.leg1.addBox(-2.0F, 2.0F, -2.0F, 4, 6, 4, expansion);
		this.leg1.setRotationPoint(-2.0F, (float)(12 + yOff), 4.0F);
		this.leg2 = new Cube(0, 16);
		this.leg2.addBox(-2.0F, 2.0F, -2.0F, 4, 6, 4, expansion);
		this.leg2.setRotationPoint(2.0F, (float)(12 + yOff), 4.0F);
		this.leg3 = new Cube(0, 16);
		this.leg3.addBox(-2.0F, 2.0F, -2.0F, 4, 6, 4, expansion);
		this.leg3.setRotationPoint(-2.0F, (float)(12 + yOff), -4.0F);
		this.leg4 = new Cube(0, 16);
		this.leg4.addBox(-2.0F, 2.0F, -2.0F, 4, 6, 4, expansion);
		this.leg4.setRotationPoint(2.0F, (float)(12 + yOff), -4.0F);
	}

	public void render(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		this.setupAnimation(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
		this.head.render(scale);
		this.body.render(scale);
		this.leg1.render(scale);
		this.leg2.render(scale);
		this.leg3.render(scale);
		this.leg4.render(scale);
	}

	public void setupAnimation(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		float var7 = MathHelper.sin(this.onGround * (float)Math.PI);
		float var8 = MathHelper.sin((1.0F - (1.0F - this.onGround) * (1.0F - this.onGround)) * (float)Math.PI);
		this.head.zRot = 0.0F;
		this.head.yRot = headYaw / 57.29578F + (0.1F - var7 * 0.6F) + MathHelper.cos(limbSwing * 0.6662F) * 0.2F * limbYaw;
		this.head.xRot = headPitch / 57.29578F -(-(float)Math.PI * 2F) + MathHelper.cos(limbSwing * 0.6662F) * 0.6F * limbYaw;
		Cube var10000 = this.head;
		var10000.xRot -= var7 * 1.2F - var8 * 0.4F;
		var10000.zRot += MathHelper.cos(limbPitch * 0.09F) * 0.25F + 0.05F;
		var10000.xRot += MathHelper.sin(limbPitch * 0.067F) * 0.25F;
		this.leg1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbYaw;
		this.leg2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbYaw;
		this.leg3.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbYaw;
		this.leg4.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbYaw;
	}
}
