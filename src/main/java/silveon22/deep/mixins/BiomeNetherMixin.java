package silveon22.deep.mixins;

import net.minecraft.core.entity.SpawnListEntry;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.BiomeNether;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silveon22.deep.mob.*;

import java.util.List;

@Mixin(value = BiomeNether.class, remap = false)
public class BiomeNetherMixin extends Biome {

	public BiomeNetherMixin(String key) {
		super(key);
	}

	@Inject(method = "<init>", at = @At("TAIL"))
	private void injectMethod(String key, CallbackInfo ci) {
		this.spawnableMonsterList.add(new SpawnListEntry(MobPopper.class, 10));
		this.spawnableMonsterList.add(new SpawnListEntry(MobWisp.class, 10));
	}
}
