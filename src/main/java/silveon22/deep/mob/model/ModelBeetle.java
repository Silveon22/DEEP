package silveon22.deep.mob.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.core.util.helper.MathHelper;

@Environment(EnvType.CLIENT)
public class ModelBeetle extends ModelBase {
	public Cube spiderBody;
	public Cube spiderNeck;
	public Cube spiderHorns;
	public Cube spiderLeg1;
	public Cube spiderLeg2;
	public Cube spiderLeg3;
	public Cube spiderLeg4;
	public Cube spiderLeg7;
	public Cube spiderLeg8;

	public ModelBeetle(float expandAmount) {
		int yOff = 15;
		this.spiderBody = new Cube(0, 0);
		this.spiderBody.addBox(-6.0F, -5.5F, -17F, 12, 6, 16, 1 + expandAmount);
		this.spiderBody.setRotationPoint(0.0F, (float)yOff, 9.0F);
		this.spiderNeck = new Cube(0, 26);
		this.spiderNeck.addBox(-5.0F, 11.0F, -11.0F, 10, 4, 2, 0.5F + expandAmount);
		this.spiderHorns = new Cube(34, 0);
		this.spiderHorns.addBox(-5.0F, 15.0F, -18.0F, 10, -1, 6, 0.5F + expandAmount);
		this.spiderLeg1 = new Cube(16, 22);
		this.spiderLeg1.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, expandAmount);
		this.spiderLeg1.setRotationPoint(-4.0F, (float)yOff, 2.0F);
		this.spiderLeg2 = new Cube(16, 22);
		this.spiderLeg2.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, expandAmount);
		this.spiderLeg2.setRotationPoint(4.0F, (float)yOff, 2.0F);
		this.spiderLeg3 = new Cube(16, 22);
		this.spiderLeg3.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, expandAmount);
		this.spiderLeg3.setRotationPoint(-4.0F, (float)yOff, 0F);
		this.spiderLeg4 = new Cube(16, 22);
		this.spiderLeg4.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, expandAmount);
		this.spiderLeg4.setRotationPoint(4.0F, (float)yOff, 0F);
		this.spiderLeg7 = new Cube(16, 22);
		this.spiderLeg7.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, expandAmount);
		this.spiderLeg7.setRotationPoint(-4.0F, (float)yOff, -1.0F);
		this.spiderLeg8 = new Cube(16, 22);
		this.spiderLeg8.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, expandAmount);
		this.spiderLeg8.setRotationPoint(4.0F, (float)yOff, -1.0F);
	}

	public void render(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		this.setupAnimation(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
		this.spiderBody.render(scale);
		this.spiderNeck.render(scale);
		this.spiderHorns.render(scale);
		this.spiderLeg1.render(scale);
		this.spiderLeg2.render(scale);
		this.spiderLeg3.render(scale);
		this.spiderLeg4.render(scale);
		this.spiderLeg7.render(scale);
		this.spiderLeg8.render(scale);
	}

	public void setupAnimation(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		float f6 = ((float)Math.PI / 4F);
		this.spiderLeg1.zRot = -f6;
		this.spiderLeg2.zRot = f6;
		this.spiderLeg3.zRot = -f6;
		this.spiderLeg4.zRot = f6;
		this.spiderLeg7.zRot = -f6;
		this.spiderLeg8.zRot = f6;
		float f7 = -0.0F;
		float f8 = ((float)Math.PI / 8F);
		this.spiderLeg1.yRot = f8 * 2.0F + f7;
		this.spiderLeg2.yRot = -f8 * 2.0F - f7;
		this.spiderLeg3.yRot = f8 * 0F - f7;
		this.spiderLeg4.yRot = -f8 * 0F + f7;
		this.spiderLeg7.yRot = -f8 * 2.0F + f7;
		this.spiderLeg8.yRot = f8 * 2.0F - f7;
		float pair1Y = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbYaw;
		float pair2Y = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbYaw;
		float pair3Y = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbYaw;
		float pair4Y = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 1.5F)) * 0.4F) * limbYaw;
		float pair1Z = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbYaw;
		float pair2Z = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbYaw;
		float pair3Z = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbYaw;
		float pair4Z = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 1.5F)) * 0.4F) * limbYaw;
		Cube var10000 = this.spiderLeg1;
		var10000.yRot += pair1Y;
		var10000 = this.spiderLeg2;
		var10000.yRot += -pair1Y;
		var10000 = this.spiderLeg3;
		var10000.yRot += pair2Y;
		var10000 = this.spiderLeg4;
		var10000.yRot += -pair2Y;
		var10000 = this.spiderLeg7;
		var10000.yRot += pair4Y;
		var10000 = this.spiderLeg8;
		var10000.yRot += -pair4Y;
		var10000 = this.spiderLeg1;
		var10000.zRot += pair1Z;
		var10000 = this.spiderLeg2;
		var10000.zRot += -pair1Z;
		var10000 = this.spiderLeg3;
		var10000.zRot += pair2Z;
		var10000 = this.spiderLeg4;
		var10000.zRot += -pair2Z;
		var10000 = this.spiderLeg7;
		var10000.zRot += pair4Z;
		var10000 = this.spiderLeg8;
		var10000.zRot += -pair4Z;
	}
}
