package silveon22.deep.mixins;

import net.minecraft.core.entity.SpawnListEntry;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.BiomeOutback;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silveon22.deep.mob.*;

import java.util.List;

@Mixin(value = BiomeOutback.class, remap = false)
public class BiomeOutbackMixin extends Biome {

	public BiomeOutbackMixin(String key) {
		super(key);
	}

	@Inject(method = "<init>", at = @At("TAIL"))
	private void injectMethod(String key, CallbackInfo ci) {
		this.spawnableMonsterList.add(new SpawnListEntry(MobMotherSpider.class, 10));
		this.spawnableMonsterList.add(new SpawnListEntry(MobBeetle.class, 15));
		this.spawnableMonsterList.add(new SpawnListEntry(MobOutbackZombie.class, 10));

	}
}
