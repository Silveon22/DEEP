package silveon22.deep.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.dynamictexture.DynamicTextureAbstractClock;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.world.Dimension;
import net.minecraft.core.world.season.SeasonManagerCycle;

import static silveon22.deep.Deep.MOD_ID;

@Environment(EnvType.CLIENT)
public class DynamicTextureRadar extends DynamicTextureAbstractClock {
	public DynamicTextureRadar(Minecraft minecraft) {
		super(minecraft, "/assets/"+ MOD_ID +"/textures/misc/dialradar.png", TextureRegistry.getTexture(MOD_ID +":item/tool_radar"));
	}

	public double getAngle() {
		double d = (double)0.0F;
		if (this.mc.currentWorld != null && this.mc.thePlayer != null) {
			float f = this.mc.currentWorld.getCelestialAngle(1.0F) * 8;
			d = (double)(-f) * Math.PI * (double)256.0F;
			if (this.mc.currentWorld.dimension == Dimension.NETHER) {
				d = Math.random() * Math.PI * (double)8.0F;
			}
		}

		return d;
	}
}
