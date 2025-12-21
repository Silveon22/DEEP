package silveon22.deep.mob;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.animal.MobCow;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.entity.projectile.ProjectileSnowball;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.season.Seasons;
import net.minecraft.core.world.weather.Weather;
import net.minecraft.core.world.weather.Weathers;
import org.jetbrains.annotations.NotNull;
import silveon22.deep.item.DEEPItems;

import javax.annotation.Nullable;

public class MobBanditZombie extends MobMonster {
	private static final ItemStack defaultHeldItem;
	boolean mixup = false;
	int mixuptime = 120;
	public MobBanditZombie(@Nullable World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("deep", "bandit_zombie");
		this.moveSpeed = 0.5F;
		this.attackStrength = 5;
		this.scoreValue = 1000;
		this.mobDrops.add(new WeightedRandomLootObject(Items.CLOTH.getDefaultStack(), 0, 2));
		this.mobDrops.add(new WeightedRandomLootObject(DEEPItems.ammoBullet.getDefaultStack(), 0, 2));
		this.setHealthRaw(34);
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

	protected void attackEntity(@NotNull Entity entity, float distance) {
		if (distance < 10.0F && distance > 6.0) {
			this.moveSpeed = 0.5F;
			double dX = entity.x - this.x;
			double dZ = entity.z - this.z;
			if (this.attackTime == 0) {
				if (!this.world.isClientSide) {
					ProjectileBullet projectileBullet = new ProjectileBullet(this.world, this);

					double d2 = entity.y + (double)entity.getHeadHeight() - 0.2 - projectileBullet.y;
					float f1 = MathHelper.sqrt(dX * dX + dZ * dZ) * 0.2F;
					this.world.playSoundAtEntity((Entity)null, this, "random.bow", 0.5F, 0.4F / (this.random.nextFloat() * 0.4F + 0.8F));
					this.world.entityJoinedWorld(projectileBullet);
					projectileBullet.setHeadingPrecise(dX, d2 + (double)f1, dZ, 0.6F);
				}

				this.attackTime = 30;
			}

			this.yRot = (float)(Math.atan2(dZ, dX) * (double)180.0F / Math.PI) - 90.0F;
			this.hasAttacked = true;
		} else if (distance <= 6.0F) {
			this.moveForward = 1;
			this.moveSpeed = -0.5F;
			double dX = entity.x - this.x;
			double dZ = entity.z - this.z;
			if (this.attackTime == 0) {
				if (!this.world.isClientSide) {
					ProjectileBullet projectileBullet = new ProjectileBullet(this.world, this);

					double d2 = entity.y + (double)entity.getHeadHeight() - 0.2 - projectileBullet.y;
					float f1 = MathHelper.sqrt(dX * dX + dZ * dZ) * 0.2F;
					this.world.playSoundAtEntity((Entity)null, this, "random.bow", 0.5F, 0.4F / (this.random.nextFloat() * 0.4F + 0.8F));
					this.world.entityJoinedWorld(projectileBullet);
					projectileBullet.setHeadingPrecise(dX, d2 + (double)f1, dZ, 0.6F);
				}

				this.attackTime = 30;
			}
		}
	}

	public void onLivingUpdate() {
		if (this.target == null) {
			this.moveSpeed = 0.5F;
		}

		super.onLivingUpdate();
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

	public ItemStack getHeldItem() {
		return defaultHeldItem;
	}

	static {
		defaultHeldItem = new ItemStack(DEEPItems.toolMusket, 1);
	}

}
