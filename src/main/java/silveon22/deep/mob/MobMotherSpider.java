package silveon22.deep.mob;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobSpider;
import net.minecraft.core.enums.LightLayer;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import org.jetbrains.annotations.NotNull;
import silveon22.deep.block.DEEPBlocks;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class MobMotherSpider extends MobSpider {
	boolean alerted = false;
	public MobMotherSpider(@Nullable World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("deep", "mother_spider");
		this.moveSpeed = 0.8F;
		this.attackStrength = 5;
		this.setHealthRaw(34);
		this.scoreValue = 1000;
		this.mobDrops.clear();
	}

	protected List<WeightedRandomLootObject> getMobDrops() {
		List<WeightedRandomLootObject> drops = new ArrayList<>();
		float drop = this.world.rand.nextFloat();
		if (!(drop < 0.5F)) {
			if (drop < 0.95F) {
				drops.add(new WeightedRandomLootObject(Items.STRING.getDefaultStack(), 3, 7));
			}
			else {
				drops.add(new WeightedRandomLootObject(DEEPBlocks.eggSpider.getDefaultStack(), 1, 1));
			}
		}

		return drops;
	}

	public void onLivingUpdate() {
		if (!alerted && this.getHealth() <= 18) {
			alerted = true;
			playLivingSound();
			int backupCount = this.world.rand.nextInt(1) + 2;
			for(int k = 0; k < 20; ++k) {
				double d1 = (double)this.x + (double)0.5F + ((double)this.world.rand.nextFloat() - (double)0.5F) * (double)2.0F;
				double d3 = (double)this.y + (double)0.5F + ((double)this.world.rand.nextFloat() - (double)0.5F) * (double)2.0F;
				double d5 = (double)this.z + (double)0.5F + ((double)this.world.rand.nextFloat() - (double)0.5F) * (double)2.0F;
				this.world.spawnParticle("snowshovel", d1, d3, d5, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				this.world.spawnParticle("snowshovel", d1, d3, d5, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				this.world.playSoundAtEntity((Entity)null, this, "mob.slime", 0.25F, 0.75F);
			}

			for(int j = 0; j < backupCount; ++j) {
				MobSpider mobSpider = new MobSpider(this.world);
				mobSpider.moveTo(this.x + random.nextInt(3) - 1, this.y + (double)0.5F, this.z + random.nextInt(3) - 1, this.random.nextFloat() * 360.0F, this.random.nextFloat() * 360.0F);
				this.world.entityJoinedWorld(mobSpider);
			}
		}

		super.onLivingUpdate();
	}

	protected void attackEntity(@NotNull Entity entity, float distance) {
		float brightness = this.getBrightness(1.0F);
		if (brightness > 0.5F && this.random.nextInt(100) == 0) {
			this.target = null;
		} else {
			if (distance > 5.0F && distance < 12.0F) {
				double dX = entity.x - this.x;
				double dZ = entity.z - this.z;
				if (this.attackTime == 0) {
					if (!this.world.isClientSide) {
						ProjectileWeb projectileweb = new ProjectileWeb(this.world, this);

						double d2 = entity.y + (double)entity.getHeadHeight() - 0.2 - projectileweb.y;
						float f1 = MathHelper.sqrt(dX * dX + dZ * dZ) * 0.2F;
						this.world.playSoundAtEntity((Entity)null, this, "random.bow", 0.5F, 0.4F / (this.random.nextFloat() * 0.4F + 0.8F));
						this.world.entityJoinedWorld(projectileweb);
						projectileweb.setHeadingPrecise(dX, d2 + (double)f1, dZ, 0.6F);
					}

					this.attackTime = 20;
				}

				this.yRot = (float)(Math.atan2(dZ, dX) * (double)180.0F / Math.PI) - 90.0F;
				this.hasAttacked = true;
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
		Biome biome = this.world.getBlockBiome((int) x, (int) y, (int) z);
		if (this.world.getSavedLightValue(LightLayer.Block, blockX, blockY, blockZ) > 0) {
			return false;
		}else if (this.y > rangeY / 4F && (biome != Biomes.OVERWORLD_OUTBACK) && (biome != Biomes.OVERWORLD_OUTBACK_GRASSY)) {
			return false;
		}else if (this.y > rangeY / 2F) {
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

}
