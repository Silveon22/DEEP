package silveon22.deep.mob.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelBiped;
import net.minecraft.core.util.helper.MathHelper;

@Environment(EnvType.CLIENT)
public class ModelOutbackZombie extends ModelBiped {
	public ModelOutbackZombie() {
		this(0.0F);
	}

	public ModelOutbackZombie(float var1) {
		this.parts(var1, 0.0F);
	}

	public void parts(float var1, float var2) {
		this.holdingLeftHand = false;
		this.holdingRightHand = false;
		this.sneaking = false;
		this.cloak = new Cube(0, 0);
		this.cloak.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, var1);
		this.ear = new Cube(24, 0);
		this.ear.addBox(-4.0F, -7.0F, -1.0F, 7, 7, 1, var1);
		this.head = new Cube(0, 0);
		this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, var1);
		this.head.setRotationPoint(0.0F, 0.0F + var2, 0.0F);
		this.hair = new Cube(16, 0);
		this.hair.addBox(-8.0F, -4.0F, -8.0F, 16, 0, 16, var1);
		this.hair.setRotationPoint(0.0F, 0.0F + var2, 0.0F);
		this.body = new Cube(16, 16);
		this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, var1);
		this.body.setRotationPoint(0.0F, 0.0F + var2, 0.0F);
		this.armRight = new Cube(40, 16);
		this.armRight.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, var1);
		this.armRight.setRotationPoint(-5.0F, 2.0F + var2, 0.0F);
		this.armLeft = new Cube(40, 16);
		this.armLeft.mirror = true;
		this.armLeft.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, var1);
		this.armLeft.setRotationPoint(5.0F, 2.0F + var2, 0.0F);
		this.legRight = new Cube(0, 16);
		this.legRight.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, var1);
		this.legRight.setRotationPoint(-2.0F, 12.0F + var2, 0.0F);
		this.legLeft = new Cube(0, 16);
		this.legLeft.mirror = true;
		this.legLeft.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, var1);
		this.legLeft.setRotationPoint(2.0F, 12.0F + var2, 0.0F);
	}

	public void setupAnimation(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		super.setupAnimation(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
		float var7 = MathHelper.sin(this.onGround * (float)Math.PI);
		float var8 = MathHelper.sin((1.0F - (1.0F - this.onGround) * (1.0F - this.onGround)) * (float)Math.PI);
		this.armRight.zRot = 0.0F;
		this.armLeft.zRot = 0.0F;
		this.armRight.yRot = -(0.1F - var7 * 0.6F);
		this.armLeft.yRot = 0.1F - var7 * 0.6F;
		this.armRight.xRot = (-(float)Math.PI / 2F);
		this.armLeft.xRot = (-(float)Math.PI / 2F);
		Cube var10000 = this.armRight;
		var10000.xRot -= var7 * 1.2F - var8 * 0.4F;
		var10000 = this.armLeft;
		var10000.xRot -= var7 * 1.2F - var8 * 0.4F;
		var10000 = this.armRight;
		var10000.zRot += MathHelper.cos(limbPitch * 0.09F) * 0.05F + 0.05F;
		var10000 = this.armLeft;
		var10000.zRot -= MathHelper.cos(limbPitch * 0.09F) * 0.05F + 0.05F;
		var10000 = this.armRight;
		var10000.xRot += MathHelper.sin(limbPitch * 0.067F) * 0.05F;
		var10000 = this.armLeft;
		var10000.xRot -= MathHelper.sin(limbPitch * 0.067F) * 0.05F;
	}
}
