package silveon22.deep.mob.model;

import java.util.Random;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.core.util.helper.MathHelper;

@Environment(EnvType.CLIENT)
public class ModelWasp extends ModelBase {
	Cube body;
	Cube body2;
	Cube leg1;
	Cube leg2;
	Cube leg3;
	Cube mandibles;
	Cube antler;
	Cube antler2;
	Cube wing;
	Cube wing2;


	public ModelWasp(float expandAmount) {
		byte yOff = -16;
		this.body = new Cube(0, 0);
		this.body.addBox(-3.5F, 14F, -5.5F, 7, 7, 12, expandAmount);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body2 = new Cube(26, 12);
		this.body2.addBox(-3.5F, 16F, -25.5F, 7, 7, 12, expandAmount);
		this.body2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leg1 = new Cube(26, 0);
		this.leg1.addBox(-2.5F, 21F, -3.5F, 5, 7, 0, expandAmount);
		this.leg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leg2 = new Cube(26, 0);
		this.leg2.addBox(-2.5F, 21F, -0.5F, 5, 7, 0, expandAmount);
		this.leg2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leg3 = new Cube(26, 0);
		this.leg3.addBox(-2.5F, 21F, 2.5F, 5, 7, 0, expandAmount);
		this.leg3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.mandibles = new Cube(12, 19);
		this.mandibles.addBox(-1.0F, 15.5F, 15F, 7, 7, 0, expandAmount);
		this.mandibles.setRotationPoint(-2.5F, 0.0F, 0.0F);
		this.antler = new Cube(0, 26);
		this.antler.addBox(5.5F, 13F, -2.5F, 10, 4, 0, expandAmount);
		this.antler.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.antler2 = new Cube(0, 26);
		this.antler2.addBox(5.5F, 13F, 2.5F, 10, 4, 0, expandAmount);
		this.antler2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wing = new Cube(60, 0);
		this.wing.addBox(0F, 0F, 0F, -11, 6, 0, expandAmount);
		this.wing.setRotationPoint(-3.5F, 17.0F, 4.0F);
		this.wing2 = new Cube(38, 0);
		this.wing2.addBox(0F, 0F, 0F, 11, 6, 0, expandAmount);
		this.wing2.setRotationPoint(3.5F, 17.0F, 4.0F);

	}

	public void render(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		this.setupAnimation(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
		this.body.render(scale);
		this.body2.render(scale);
		this.leg1.render(scale);
		this.leg2.render(scale);
		this.leg3.render(scale);
		this.mandibles.render(scale);
		this.antler.render(scale);
		this.antler2.render(scale);
		this.wing.render(scale);
		this.wing2.render(scale);
	}

	public void setupAnimation(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		this.body2.xRot = 45;
		this.mandibles.xRot = -45;
		this.antler.yRot = 1.57F;
		this.antler2.yRot = 1.57F;
		this.wing.xRot = -1.57F;
		this.wing2.xRot = -1.57F;
		this.wing.zRot = MathHelper.cos(limbSwing * 0.6662F) * 1.6F * limbYaw;
		this.wing2.zRot = -MathHelper.cos(limbSwing * 0.6662F) * 1.6F * limbYaw;
	}
}
