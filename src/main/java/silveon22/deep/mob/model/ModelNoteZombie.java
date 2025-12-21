package silveon22.deep.mob.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelBiped;
import net.minecraft.core.util.helper.MathHelper;

@Environment(EnvType.CLIENT)
public class ModelNoteZombie extends ModelBiped {

	public ModelNoteZombie(float var1) {
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
		this.hair = new Cube(32, 0);
		this.hair.addBox(-4.0F, 4.0F, -10.5F, 8, 8, 8, var1 + 0.5F);
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

	@Override
	public void setupAnimation(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		this.head.yRot = headYaw / 57.29578F;
		this.head.xRot = headPitch / 57.29578F;
		this.hair.yRot = this.body.yRot;
		this.hair.xRot = this.body.xRot;
		if (this.holdingLarge) {
			this.armRight.xRot = MathHelper.cos(limbSwing / 2.0F * 0.6662F) * 2.0F * limbYaw * 0.125F - 0.65F;
			this.armLeft.xRot = MathHelper.cos(limbSwing / 2.0F * 0.6662F) * 2.0F * limbYaw * 0.125F - 0.65F;
		} else {
			this.armRight.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbYaw * 0.5F;
			this.armLeft.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbYaw * 0.5F;
		}

		this.armRight.zRot = 0.0F;
		this.armLeft.zRot = 0.0F;
		this.legRight.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbYaw;
		this.legLeft.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbYaw;
		this.legRight.yRot = 0.0F;
		this.legLeft.yRot = 0.0F;
		if (this.isRiding) {
			Cube var10000 = this.armRight;
			var10000.xRot += -0.6283185F;
			var10000 = this.armLeft;
			var10000.xRot += -0.6283185F;
			this.legRight.xRot = -1.256637F;
			this.legLeft.xRot = -1.256637F;
			this.legRight.yRot = 0.3141593F;
			this.legLeft.yRot = -0.3141593F;
		}

		if (this.holdingLeftHand) {
			this.armLeft.xRot = this.armLeft.xRot * 0.5F - 0.3141593F;
		}

		if (this.holdingRightHand) {
			this.armRight.xRot = this.armRight.xRot * 0.5F - 0.3141593F;
		}

		this.armRight.yRot = 0.0F;
		this.armLeft.yRot = 0.0F;
		if (this.onGround > -9990.0F) {
			float f6 = this.onGround;
			this.body.yRot = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI * 2.0F) * 0.2F;
			this.armRight.z = MathHelper.sin(this.body.yRot) * 5.0F;
			this.armRight.x = -MathHelper.cos(this.body.yRot) * 5.0F;
			this.armLeft.z = -MathHelper.sin(this.body.yRot) * 5.0F;
			this.armLeft.x = MathHelper.cos(this.body.yRot) * 5.0F;
			Cube var15 = this.armRight;
			var15.yRot += this.body.yRot;
			var15 = this.armLeft;
			var15.yRot += this.body.yRot;
			var15 = this.armLeft;
			var15.xRot += this.body.xRot;
			f6 = 1.0F - this.onGround;
			f6 *= f6;
			f6 *= f6;
			f6 = 1.0F - f6;
			float f7 = MathHelper.sin(f6 * (float)Math.PI);
			float f8 = MathHelper.sin(this.onGround * (float)Math.PI) * -(this.head.xRot - 0.7F) * 0.75F;
			var15 = this.armRight;
			var15.xRot = (float)((double)var15.xRot - ((double)f7 * 1.2 + (double)f8));
			var15 = this.armRight;
			var15.yRot += this.body.yRot * 2.0F;
			this.armRight.zRot = MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F;
		}

		if (this.sneaking) {
			this.body.xRot = 0.5F;
			Cube var20 = this.legRight;
			var20.xRot -= 0.0F;
			var20 = this.legLeft;
			var20.xRot -= 0.0F;
			var20 = this.armRight;
			var20.xRot += 0.4F;
			if (this.holdingLarge) {
				var20 = this.armRight;
				var20.xRot -= 0.4F;
				var20 = this.armLeft;
				var20.xRot -= 0.5F;
			}

			this.legRight.z = 4.0F;
			this.legLeft.z = 4.0F;
			this.legRight.y = 9.0F;
			this.legLeft.y = 9.0F;
			this.head.y = 1.0F;
			this.hair.y = 1.0F;
		} else {
			this.body.xRot = 0.0F;
			this.legRight.z = 0.0F;
			this.legLeft.z = 0.0F;
			this.legRight.y = 12.0F;
			this.legLeft.y = 12.0F;
			this.head.y = 0.0F;
			this.hair.y = 0.0F;
		}

		Cube var25 = this.armRight;
		var25.zRot += MathHelper.cos(limbPitch * 0.09F) * 0.05F + 0.05F;
		var25 = this.armLeft;
		var25.zRot -= MathHelper.cos(limbPitch * 0.09F) * 0.05F + 0.05F;
		var25 = this.armRight;
		var25.xRot += MathHelper.sin(limbPitch * 0.067F) * 0.05F;
		var25 = this.armLeft;
		var25.xRot -= MathHelper.sin(limbPitch * 0.067F) * 0.05F;
		float var7 = MathHelper.sin(this.onGround * (float)Math.PI);
		float var8 = MathHelper.sin((1.0F - (1.0F - this.onGround) * (1.0F - this.onGround)) * (float)Math.PI);
		this.armRight.zRot = 0.0F;
		this.armLeft.zRot = 0.0F;
		this.armRight.yRot = -(0.1F - var7 * 0.6F);
		this.armLeft.yRot = 0.1F - var7 * 0.6F;
		this.armRight.xRot = (-(float)Math.PI / 4F);
		this.armLeft.xRot = (-(float)Math.PI / 4F);
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
		var10000.xRot -= (float) (MathHelper.sin(limbPitch * 0.067F) * 0.05);
	}
}
