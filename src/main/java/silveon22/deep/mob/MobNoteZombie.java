package silveon22.deep.mob;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobZombie;
import net.minecraft.core.enums.LightLayer;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class MobNoteZombie extends MobZombie {
	int instrument = 0;
	boolean alerted = false;
	public MobNoteZombie(@Nullable World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("deep", "noteblock_zombie");
		this.moveSpeed = 0.4F;
		this.attackStrength = 4;
		this.setHealthRaw(25);
		this.scoreValue = 500;
		this.mobDrops.add(new WeightedRandomLootObject(Items.CLOTH.getDefaultStack(), 0, 2));
		instrument = random.nextInt(11);
	}

	protected List<WeightedRandomLootObject> getMobDrops() {
		List<WeightedRandomLootObject> drops = new ArrayList<>();
		float drop = this.world.rand.nextFloat();
		if (!(drop < 0.5F)) {
			if (drop < 0.95F) {
				drops.add(new WeightedRandomLootObject(Items.CLOTH.getDefaultStack(), 0, 2));
			}
			else {
				drops.add(new WeightedRandomLootObject(Blocks.NOTEBLOCK.getDefaultStack(), 1, 1));
			}
		}

		return drops;
	}

	public void onLivingUpdate() {
		if (!alerted && this.getHealth() <= 24) {
			alerted = true;
			playLivingSound();
			int backupCount = this.world.rand.nextInt(3) + 2;
			for(int k = 0; k < 20; ++k) {
				double d1 = (double)this.x + (double)0.5F + ((double)this.world.rand.nextFloat() - (double)0.5F) * (double)2.0F;
				double d3 = (double)this.y + (double)0.5F + ((double)this.world.rand.nextFloat() - (double)0.5F) * (double)2.0F;
				double d5 = (double)this.z + (double)0.5F + ((double)this.world.rand.nextFloat() - (double)0.5F) * (double)2.0F;
				this.world.spawnParticle("smoke", d1, d3, d5, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				this.world.spawnParticle("flame", d1, d3, d5, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				this.world.playSoundAtEntity((Entity)null, this, "mob.ghast.fireball", 0.025F, 0.75F);
			}

			for(int j = 0; j < backupCount; ++j) {
				MobZombie mobZombie = new MobZombie(this.world);
				mobZombie.moveTo(this.x + random.nextInt(3) - 1, this.y + (double)0.5F, this.z + random.nextInt(3) - 1, this.random.nextFloat() * 360.0F, this.random.nextFloat() * 360.0F);
				this.world.entityJoinedWorld(mobZombie);
			}
		}

		super.onLivingUpdate();
	}

	@Override
	public int getAmbientSoundInterval() {
		return 25;
	}

	@Override
	public void playLivingSound() {
		if (this.world != null) {
			String s = this.getLivingSound();
			if (instrument > 10) {
				s = "bd";
			}
			else if (instrument > 9) {
				s = "hat";
			}
			else if (instrument > 8) {
				s = "bassattack";
			}
			else if (instrument > 7) {
				s = "harp";
			}
			else if (instrument > 6) {
				s = "chant";
			}
			else if (instrument > 5) {
				s = "drum_steel";
			}
			else if (instrument > 4) {
				s = "chip_triangle";
			}
			else if (instrument > 3) {
				s = "guitar_electric";
			}
			else if (instrument > 2) {
				s = "celesta";
			}
			else if (instrument > 1) {
				s = "wood_block";
			}
			else {
				s = "snare";
			}
			if (!this.world.isClientSide) {
				this.world.playSoundAtEntity((Entity)null, this, "note." + s, this.getSoundVolume() * 2, (this.random.nextFloat() * 1.7F - this.random.nextFloat()) * 1.7F);
			}
			world.spawnParticle("note", this.x, this.y + 1.9, this.z, (double)0.0F, (double)0.0F, (double)0.0F, 1);

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
		}else if (this.y > rangeY / 4F) {
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
