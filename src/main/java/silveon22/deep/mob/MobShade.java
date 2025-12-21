package silveon22.deep.mob;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.entity.monster.MobZombie;
import net.minecraft.core.enums.LightLayer;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import net.minecraft.core.world.weather.Weather;
import net.minecraft.core.world.weather.Weathers;
import org.jetbrains.annotations.NotNull;
import silveon22.deep.item.DEEPItems;

import javax.annotation.Nullable;

public class MobShade extends MobMonster {
	public MobShade(@Nullable World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("deep", "shade");
		this.attackStrength = 12;
		this.moveSpeed = 9.0F;
		this.speed = 0.3F;
		this.scoreValue = 900;
		this.setHealthRaw(4);
		this.mobDrops.add(new WeightedRandomLootObject(DEEPItems.eyeShade.getDefaultStack(), 0, 1));
	}

	public void onLivingUpdate() {
		if (this.world.isDaytime()) {
			float f = this.getBrightness(1.0F);
			Weather weather = this.world.getCurrentWeather();
			if (f > 0.5F && this.world.canBlockSeeTheSky(MathHelper.floor(this.x), MathHelper.floor(this.y), MathHelper.floor(this.z)) && this.random.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && weather != null && !weather.isDamp && (this.world.getCurrentWeather() != Weathers.OVERWORLD_FOG || this.world.weatherManager.getWeatherPower() < 0.75F)) {
				this.remainingFireTicks = 300;
			}
		}

		super.onLivingUpdate();
	}

	protected void attackEntity(@NotNull Entity entity, float distance) {
		float brightness = this.getBrightness(1.0F);
		if (brightness > 0.5F && this.random.nextInt(100) == 0) {
			this.target = null;
		} else {
			if (distance > 1.0F && distance < 8.0F && this.random.nextInt(5) == 0) {
				if (this.onGround) {
					double d = entity.x - this.x;
					double d1 = entity.z - this.z;
					float f2 = MathHelper.sqrt(d * d + d1 * d1);
					this.xd = d / (double)f2 * (double)0.5F * (double)0.8F + this.xd * 0.2;
					this.zd = d1 / (double)f2 * (double)0.5F * (double)0.8F + this.zd * 0.2;
					this.yd = (double)0.4F;
				}
			} else {
				super.attackEntity(entity, distance);
			}

		}
	}

	@Override
	public boolean canSpawnHere() {
		int minY = this.world.getWorldType().getMinY();
		int maxY = this.world.getWorldType().getMaxY();
		int rangeY = maxY + 1 - minY;
		int blockX = MathHelper.floor(this.x);
		int blockY = MathHelper.floor(this.bb.minY);
		int blockZ = MathHelper.floor(this.z);
		if (this.world.getSavedLightValue(LightLayer.Block, blockX, blockY, blockZ) > 0) {
			return false;
		}else if (this.y > rangeY / 6F) {
			return false;
		} else if (this.world.getSavedLightValue(LightLayer.Sky, blockX, blockY, blockZ) > this.random.nextInt(32)) {
			return false;
		} else {
			int blockLight = this.world.getBlockLightValue(blockX, blockY, blockZ);
			if (this.world.getCurrentWeather() != null && this.world.getCurrentWeather().doMobsSpawnInDaylight) {
				blockLight /= 2;
			}

			return blockLight <= 4 && super.canSpawnHere();
		}
	}

	public String getLivingSound() {
		return "deep:mob.shade.whisper";
	}

	protected String getHurtSound() {
		return "deep:mob.shade.hurt";
	}

	protected String getDeathSound() {
		return "deep:mob.shade.death";
	}

	protected float getSoundVolume() {
		return 1F;
	}

}
