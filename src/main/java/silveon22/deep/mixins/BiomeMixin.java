package silveon22.deep.mixins;

import net.minecraft.core.entity.SpawnListEntry;
import net.minecraft.core.entity.animal.MobChicken;
import net.minecraft.core.entity.animal.MobSquid;
import net.minecraft.core.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silveon22.deep.mob.*;

import java.util.List;

@Mixin(value = Biome.class, remap = false)
public class BiomeMixin {
	@Shadow
	protected List<SpawnListEntry> spawnableMonsterList;
	@Shadow
	protected List<SpawnListEntry> spawnableCreatureList;
	@Shadow
	protected List<SpawnListEntry> spawnableWaterCreatureList;

	@Inject(method = "<init>", at = @At("TAIL"))
	private void injectMethod(String key, CallbackInfo ci) {
		this.spawnableMonsterList.add(new SpawnListEntry(MobElderSkeleton.class, 3));
		this.spawnableMonsterList.add(new SpawnListEntry(MobCaveCreeper.class, 3));
		this.spawnableMonsterList.add(new SpawnListEntry(MobWerewolf.class, 10));
		this.spawnableMonsterList.add(new SpawnListEntry(MobShade.class, 3));
		this.spawnableMonsterList.add(new SpawnListEntry(MobRedSlime.class, 10));
		this.spawnableMonsterList.add(new SpawnListEntry(MobWaterSlime.class, 10));
		this.spawnableMonsterList.add(new SpawnListEntry(MobVolatileSlime.class, 10));
		this.spawnableMonsterList.add(new SpawnListEntry(MobNoteZombie.class, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(MobPistonZombie.class, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(MobMotherSpider.class, 3));
		this.spawnableMonsterList.add(new SpawnListEntry(MobBeetle.class, 8));
		this.spawnableMonsterList.add(new SpawnListEntry(MobOutbackZombie.class, 10));
		this.spawnableMonsterList.add(new SpawnListEntry(MobSnowbomination.class, 3));
		this.spawnableMonsterList.add(new SpawnListEntry(MobBanditZombie.class, 3));
		this.spawnableMonsterList.add(new SpawnListEntry(MobWasp.class, 200));
		this.spawnableCreatureList.add(new SpawnListEntry(MobTruffle.class, 25));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(MobJellyfish.class, 20));

	}
}
