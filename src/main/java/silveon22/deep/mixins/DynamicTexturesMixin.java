package silveon22.deep.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.render.TextureManager;
import net.minecraft.client.render.dynamictexture.*;
import net.minecraft.client.render.texture.meta.AnimationProperties;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.util.helper.DyeColor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silveon22.deep.block.DynamicTextureMoltenGoldFlowing;
import silveon22.deep.block.DynamicTextureMoltenGoldStill;
import silveon22.deep.gui.DynamicTextureRadar;

import static silveon22.deep.Deep.MOD_ID;

@Mixin(value = TextureManager.class, remap = false)
public abstract class DynamicTexturesMixin {


	@Shadow
	@Final
	public Minecraft mc;

	@Shadow protected abstract void addDynamicTextureOverride(DynamicTexture texture, boolean override);

	@Shadow protected abstract void addDynamicTexture(DynamicTexture texture);

	@Inject(method = "initDynamicTextures", at = @At(value = "TAIL"))
	public void initDynamicTextures(CallbackInfo ci) {
		this.addDynamicTexture(new DynamicTextureRadar(this.mc));
	}

	@Inject(method = "addNativeDynamicTextures", at = @At(value = "TAIL"))
	protected void addNativeDynamicTextures(int state, CallbackInfo ci) {
		if (state > 0) {
			this.addDynamicTexture(new DynamicTextureMoltenGoldStill(TextureRegistry.getTexture("deep:block/molten_gold_still")));
			this.addDynamicTexture(new DynamicTextureMoltenGoldFlowing(TextureRegistry.getTexture("deep:block/molten_gold_flowing")));
		}

	}
}
