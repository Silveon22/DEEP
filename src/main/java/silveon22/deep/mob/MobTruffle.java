package silveon22.deep.mob;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.animal.MobAnimal;
import net.minecraft.core.entity.animal.MobCow;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.enums.LightLayer;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.phys.Vec3;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.season.Seasons;
import net.minecraft.core.world.weather.Weathers;

import javax.annotation.Nullable;

public class MobTruffle extends MobAnimal {
	int mobmimic;
	float jumpheightmod = 1F;
	public MobTruffle(@Nullable World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("deep", "truffle");
		this.moveSpeed = 1F;
		this.speed = 0.25F;
		this.scoreValue = 100;
		this.setSize(0.9F, 0.9F);
		this.mobDrops.add(new WeightedRandomLootObject(Blocks.MUSHROOM_RED.getDefaultStack(), 1, 3));
		this.setHealthRaw(20);
		jumpheightmod = world.rand.nextFloat()*3 - world.rand.nextFloat()*3;
		mobmimic = world.rand.nextInt(7);
	}

	@Override
	public int getAmbientSoundInterval() {
		return 300;
	}

	@Override
	public void playLivingSound() {
		if (this.world != null) {
			String s = this.getLivingSound();
			if (mobmimic > 4) {
				s = "deep:mob.werewolf.say";
			}
			else if (mobmimic > 3) {
				s = "deep:mob.elder.skeleton.say";
			}
			else if (mobmimic > 2) {
				s = "ambient.cave.cave";
			}
			else if (mobmimic > 1) {
				s = "mob.creeper.fuse";
			}
			else {
				s = "deep:mob.shade.whisper";
			}
			if (!this.world.isClientSide) {
				this.world.playSoundAtEntity((Entity)null, this, s, this.getSoundVolume() * 2, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			}

		}
	}

	@Override
	protected void updateAI() {
		if (this.world != null) {
			this.hasAttacked = this.isMovementCeased();
			float sightRadius = 16.0F;
			if (this.target == null) {
				this.target = this.findPlayerToAttack();
				if (this.target != null) {
					this.pathToEntity = this.world.getPathToEntity(this, this.target, sightRadius);
				}
			} else if (!this.target.isAlive()) {
				this.target = null;
			} else {
				float distanceToEntity = this.target.distanceTo(this);
				if (this.canEntityBeSeen(this.target)) {
					this.attackEntity(this.target, distanceToEntity);
				} else {
					this.attackBlockedEntity(this.target, distanceToEntity);
				}
			}

			if (this.hasAttacked || this.target == null || this.pathToEntity != null && this.random.nextInt(5) != 0) {
				if (!this.hasAttacked && this.closestFireflyEntity == null && (this.pathToEntity == null && this.random.nextInt(5) == 0 || this.random.nextInt(5) == 0)) {
					this.roamRandomPath();
				}
			} else {
				this.pathToEntity = this.world.getPathToEntity(this, this.target, sightRadius);
			}

			int i = MathHelper.floor(this.bb.minY + (double)0.5F);
			boolean inWater = this.isInWater();
			boolean inLava = this.isInLava();
			this.xRot = 0.0F;
			if (this.pathToEntity != null && this.random.nextInt(100) != 0) {
				Vec3 coordsForNextPath = this.pathToEntity.getPos(this);
				double d = (double)(this.bbWidth * 2.0F);

				while(coordsForNextPath != null && coordsForNextPath.distanceToSquared(this.x, coordsForNextPath.y, this.z) < d * d) {
					this.pathToEntity.next();
					if (this.pathToEntity.isDone()) {
						this.closestFireflyEntity = null;
						coordsForNextPath = null;
						this.pathToEntity = null;
					} else {
						coordsForNextPath = this.pathToEntity.getPos(this);
					}
				}

				this.isJumping = false;
				jumpheightmod = world.rand.nextFloat()*3 - world.rand.nextFloat()*3;
				if (coordsForNextPath != null) {
					d = coordsForNextPath.x - this.x;
					double z1 = coordsForNextPath.z - this.z;
					double y1 = coordsForNextPath.y - (double)i;
					float f2 = (float)(Math.atan2(z1, d) * (double)180.0F / Math.PI) - 90.0F;
					float f3 = f2 - this.yRot;

					for(this.moveForward = this.moveSpeed; f3 < -180.0F; f3 += 360.0F) {
					}

					while(f3 >= 180.0F) {
						f3 -= 360.0F;
					}

					if (f3 > 30.0F) {
						f3 = 30.0F;
					}

					if (f3 < -30.0F) {
						f3 = -30.0F;
					}

					this.yRot += f3;
					if (this.hasAttacked && this.target != null) {
						double d4 = this.target.x - this.x;
						double d5 = this.target.z - this.z;
						float f5 = this.yRot;
						this.yRot = (float)(Math.atan2(d5, d4) * (double)180.0F / Math.PI) - 90.0F;
						float f4 = (f5 - this.yRot + 90.0F) * (float)Math.PI / 180.0F;
						this.moveStrafing = -MathHelper.sin(f4) * this.moveForward * 1.0F;
						this.moveForward = MathHelper.cos(f4) * this.moveForward * 1.0F;
					}

					if (y1 > (double)0.0F) {
						this.isJumping = true;
					}
				}

				if (this.target != null) {
					this.lookAt(this.target, 30.0F, 30.0F);
				}

				if (this.horizontalCollision && !this.hasPath()) {
					this.isJumping = true;
				}

				if (this.random.nextFloat() < 0.8F && (inWater || inLava)) {
					this.isJumping = true;
				}

				if (this.random.nextInt(50) == 0 || this.random.nextInt(50) == 0) {
					this.isJumping = true;
				}

			} else {
				super.updateAI();
				this.pathToEntity = null;
			}
		}
	}

	@Override
	protected void jump() {
		if (!this.noPhysics) {
			this.yd = 0.45 * jumpheightmod;
			if (this.isSprinting()) {
				float f = this.yRot * 0.01745329F;
				this.xd -= (double)(MathHelper.sin(f) * 0.2F);
				this.zd += (double)(MathHelper.cos(f) * 0.2F);
			}

		}
	}

	protected String getHurtSound() {
		return "mob.cowhurt";
	}

	protected String getDeathSound() {
		return "mob.pigdeath";
	}

	@Override
	protected void causeFallDamage(float distance) {

	}

	@Override
	public boolean canSpawnHere() {
		int blockX = MathHelper.floor(this.x);
		int blockY = MathHelper.floor(this.bb.minY);
		int blockZ = MathHelper.floor(this.z);
		int minY = this.world.getWorldType().getMinY();
		int maxY = this.world.getWorldType().getMaxY();
		int rangeY = maxY + 1 - minY;

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

			if (this.world == null) {
				return false;
			} else {
				if (Blocks.hasTag(this.world.getBlockId(blockX, blockY, blockZ), BlockTags.PREVENT_MOB_SPAWNS)) {
					return false;
				} else {
					return this.world.checkIfAABBIsClear(this.bb) && this.world.getCubes(this, this.bb).size() == 0 && !this.world.getIsAnyLiquid(this.bb) && blockLight <= 4;
				}
			}
		}
		
	}

}
