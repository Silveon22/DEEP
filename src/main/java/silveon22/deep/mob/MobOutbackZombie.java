package silveon22.deep.mob;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.entity.animal.MobCow;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.season.Seasons;
import net.minecraft.core.world.weather.Weathers;

import javax.annotation.Nullable;

public class MobOutbackZombie extends MobMonster {
	public MobOutbackZombie(@Nullable World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("deep", "outback_zombie");
		this.moveSpeed = 0.5F;
		this.attackStrength = 5;
		this.scoreValue = 300;
		this.mobDrops.add(new WeightedRandomLootObject(Items.CLOTH.getDefaultStack(), 0, 2));
		this.setHealthRaw(20);
	}

	public void spawnInit() {
		super.defineSynchedData();
		if (this.world.getDifficulty().canHostileMobsSpawn() && this.random.nextInt(50 / this.world.getDifficulty().id()) == 0) {
			MobCow mobCow = new MobCow(this.world);
			mobCow.moveTo(this.x, this.y, this.z, this.yRot, 0.0F);
			this.world.entityJoinedWorld(mobCow);
			this.startRiding(mobCow);
		}

	}

	public String getLivingSound() {
		return "mob.zombie";
	}

	protected String getHurtSound() {
		return "mob.zombiehurt";
	}

	protected String getDeathSound() {
		return "mob.zombiedeath";
	}

	public boolean canSpawnHere() {
		int x = (int)this.x;
		int y = (int)this.y;
		int z = (int)this.z;
		int minY = this.world.getWorldType().getMinY();
		int maxY = this.world.getWorldType().getMaxY();
		int rangeY = maxY + 1 - minY;
		Biome biome = this.world.getBlockBiome(x, y, z);
		if ((biome == Biomes.OVERWORLD_GLACIER) || (biome == Biomes.OVERWORLD_TUNDRA) || (biome == Biomes.OVERWORLD_TAIGA)) {
			return false;
		}
		else if (this.y < rangeY / 2F && (biome == Biomes.OVERWORLD_OUTBACK) || (biome == Biomes.OVERWORLD_OUTBACK_GRASSY)) {
			return super.canSpawnHere();
		}
		else  {
			return super.canSpawnHere() && (biome == Biomes.OVERWORLD_DESERT || (this.world.getSeasonManager().getCurrentSeason() == Seasons.OVERWORLD_SUMMER && this.world.getCurrentWeather() == Weathers.OVERWORLD_CLEAR));
		}
	}

}
