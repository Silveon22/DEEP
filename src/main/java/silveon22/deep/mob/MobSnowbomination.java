package silveon22.deep.mob;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.entity.projectile.ProjectileSnowball;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.season.Seasons;
import net.minecraft.core.world.weather.Weathers;
import org.jetbrains.annotations.NotNull;
import silveon22.deep.item.DEEPItems;

import javax.annotation.Nullable;

public class MobSnowbomination extends MobMonster {
	int hailcooldown = 0;
	int hailtime = 0;
	public MobSnowbomination(@Nullable World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("deep", "snowbomination");
		this.moveSpeed = 0.5F;
		this.attackStrength = 7;
		this.scoreValue = 1000;
		this.setHealthRaw(40);
		hailcooldown = 40;
		hailtime = 15;
		this.mobDrops.add(new WeightedRandomLootObject(DEEPItems.ammoHail.getDefaultStack(), 2, 6));
	}

	public void onLivingUpdate() {
		if (this.world.isDaytime()) {
			float f = this.getBrightness(1.0F);
			if (f > 0.5F && this.world.canBlockSeeTheSky(MathHelper.floor(this.x), MathHelper.floor(this.y), MathHelper.floor(this.z)) && this.random.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && (this.world.getCurrentWeather() != Weathers.OVERWORLD_FOG || this.world.weatherManager.getWeatherPower() < 0.75F) && this.world.getCurrentWeather() != Weathers.OVERWORLD_SNOW && this.world.getCurrentWeather() != Weathers.OVERWORLD_WINTER_SNOW) {
				this.remainingFireTicks = 300;
			}
		}

		super.onLivingUpdate();
	}

	protected void attackEntity(@NotNull Entity entity, float distance) {
		if (distance < 10.0F && distance > 4.0F) {
			this.speed = 0.1F;
			this.moveSpeed = 0.5F;
			double dX = entity.x - this.x;
			double dZ = entity.z - this.z;
			if (hailtime > 0) {
				hailtime -= 1;
			if (this.attackTime == 0) {
				if (!this.world.isClientSide) {
					ProjectileHail projectileSnowball = new ProjectileHail(this.world, this);
					double d2 = entity.y + (double)entity.getHeadHeight() - 0.2 - projectileSnowball.y;
					float f1 = MathHelper.sqrt(dX * dX + dZ * dZ) * 0.2F;
					this.world.playSoundAtEntity((Entity)null, this, "deep:mob.snowbomination.hail.launch", 1F, 0.7F);
					this.world.entityJoinedWorld(projectileSnowball);
					projectileSnowball.setHeading(dX * 0.8, d2 + (double)f1 + 6, dZ* 0.8, 0.6F, 20.0F);
				}

				this.attackTime = 2;
			}
			}
			if (hailcooldown == 0) {
				hailtime = 12;
				hailcooldown = 40;
			}
			hailcooldown -= 1;

			this.yRot = (float)(Math.atan2(dZ, dX) * (double)180.0F / Math.PI) - 90.0F;
			this.hasAttacked = true;
		} else if (distance <= 4.0F) {
			this.moveSpeed = 1F;
			this.speed = 0.15F;
			super.attackEntity(entity, distance);
		} else if (distance >= 10.0F) {
			this.moveSpeed = 1F;
			this.speed = 0.15F;
		}

	}

	public boolean canSpawnHere() {
		int x = (int)this.x;
		int y = (int)this.y;
		int z = (int)this.z;
		Biome biome = this.world.getBlockBiome(x, y, z);
		return super.canSpawnHere() && this.world.canBlockSeeTheSky(x, y, z) && (biome == Biomes.OVERWORLD_GLACIER || (this.world.getSeasonManager().getCurrentSeason() == Seasons.OVERWORLD_WINTER || this.world.getSeasonManager().getCurrentSeason() == Seasons.OVERWORLD_WINTER_ENDLESS) && (this.world.getCurrentWeather() == Weathers.OVERWORLD_SNOW || this.world.getCurrentWeather() == Weathers.OVERWORLD_WINTER_SNOW));
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

	protected void dropDeathItems() {
		if (this.random.nextInt(1000) == 0) {
			this.dropItem(Items.BUCKET_ICECREAM.id, 1);
		}

		super.dropDeathItems();
	}

}
