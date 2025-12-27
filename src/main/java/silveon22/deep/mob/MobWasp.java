package silveon22.deep.mob;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.MobFlying;
import net.minecraft.core.entity.monster.Enemy;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.entity.projectile.ProjectileArrow;
import net.minecraft.core.entity.projectile.ProjectileFireball;
import net.minecraft.core.enums.LightLayer;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.util.phys.Vec3;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pathfinder.Path;
import net.minecraft.core.world.season.Seasons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.item.DEEPItems;

public class MobWasp extends MobFlying implements Enemy {
	public static final int DATA_CHARGING = 16;
	public int courseChangeCooldown = 0;
	public double waypointX;
	public double waypointY;
	public double waypointZ;
	private Entity targetedEntity = null;
	private int aggroCooldown = 0;
	public int attackChargeO = 0;
	public int attackCharge = 0;
	protected @Nullable Entity target;

	public MobWasp(World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("deep", "wasp");
		this.setSize(0.8F, 0.8F);
		this.scoreValue = 700;
		this.setHealthRaw(34);
		this.yd += 0.4;
		this.mobDrops.add(new WeightedRandomLootObject(DEEPItems.honeycomb.getDefaultStack(), 0, 2));
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(16, (byte)0, Byte.class);
	}

	public void tick() {
		this.walkAnimPos += 1;
		if (this.world.isClientSide) {
			byte i = this.entityData.getByte(16);

			this.attackCharge += i;
			if (this.attackCharge < 0) {
				this.attackCharge = 0;
			}

			if (this.attackCharge >= 20) {
				this.attackCharge = 20;
			}

			if (this.attackCharge >= 20 && i == 0) {
				this.attackCharge = -40 + this.random.nextInt();
			}
		}

		super.tick();
	}

//	protected void updateAI() {
//		if (!this.world.isClientSide && !this.world.getDifficulty().canHostileMobsSpawn()) {
//			this.remove();
//		}
//
//		this.tryToDespawn();
//		this.attackChargeO = this.attackCharge;
//		double d = this.waypointX - this.x;
//		double d1 = this.waypointY - this.y;
//		double d2 = this.waypointZ - this.z;
//		double d3 = (double)MathHelper.sqrt(d * d + d1 * d1 + d2 * d2);
//		if (d3 < (double)1.0F || d3 > (double)60.0F) {
//			this.waypointX = this.x + (double)((this.random.nextFloat() * 2.0F - 1.0F) * 16.0F);
//			this.waypointY = this.y + (double)((this.random.nextFloat() * 2.0F - 1.0F) * 16.0F);
//			this.waypointZ = this.z + (double)((this.random.nextFloat() * 2.0F - 1.0F) * 16.0F);
//		}
//
//		this.courseChangeCooldown -= 1;
//
//		if (this.courseChangeCooldown <= 0) {
//			this.courseChangeCooldown += this.random.nextInt(3) + 5;
//			if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3)) {
//				this.xd += d / d3 * 0.05;
//				this.yd += d1 / d3 * 0.05;
//				this.zd += d2 / d3 * 0.05;
//				this.moveForward = 1.0F;
//			} else {
//				this.waypointX = this.x;
//				this.waypointY = this.y;
//				this.waypointZ = this.z;
//			}
//		}
//
//		if (this.targetedEntity != null && this.targetedEntity.removed) {
//			this.targetedEntity = null;
//		}
//
//		if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
//			this.targetedEntity = this.world.getClosestPlayerToEntity(this, (double)100.0F);
//			if (this.targetedEntity != null && !((Player)this.targetedEntity).getGamemode().areMobsHostile()) {
//				this.targetedEntity = null;
//			}
//
//			if (this.targetedEntity != null) {
//				this.yBodyRot = this.yRot = ((float)Math.atan2(this.xd, this.zd)) * 180.0F / (float)Math.PI;
//				this.aggroCooldown = 20;
//			}
//		}
//
//		double d4 = (double)16.0F;
//		if (this.targetedEntity != null && this.targetedEntity.distanceToSqr(this) < d4 * d4) {
//			this.yBodyRot = this.yRot = ((float)Math.atan2(this.xd, this.zd)) * 180.0F / (float)Math.PI;
//
//			double d8 = (double)4.0F;
//			Vec3 vec3 = this.getViewVector(1.0F);
//			double fd = targetedEntity.x - this.x;
//			double fd1 = targetedEntity.z - this.z;
//			double dX = this.targetedEntity.x - this.x;
//			double dY = this.targetedEntity.y - this.y;
//			double dZ = this.targetedEntity.z - this.z;
//			double dist = (double)MathHelper.sqrt(dX * dX + dY * dY + dZ * dZ);
//			this.yBodyRot = this.yRot = (float)(Math.atan2(fd1, fd) * (double)180.0F / Math.PI) - 90.0F;
//			if (this.canEntityBeSeen(this.targetedEntity)) {
//				if (this.targetedEntity != null) {
//					float distanceToEntity = this.targetedEntity.distanceTo(this);
//					this.attackEntity(this.targetedEntity, distanceToEntity);
//				}
//
//				if (this.distanceTo(this.targetedEntity.x,this.targetedEntity.y,this.targetedEntity.z) > 3F) {
//					++this.attackCharge;
//					if (this.attackCharge == 20) {
//						this.xd *= 1;
//						this.yd *= 2.5F;
//						this.zd *= 1;
//
//						if (this.y < this.targetedEntity.y) {
//							this.yd += 0.1;
//						}
//						else {
//							this.yd -= 0.1;
//						}
//
//						this.waypointX = this.targetedEntity.x;
//						this.waypointY = this.targetedEntity.y;
//						this.waypointZ = this.targetedEntity.z;
//						this.attackCharge = 7 + this.random.nextInt(5);
//					}
//				}
//				else {
//					this.moveForward -= 4;
//				}
//			} else if (this.attackCharge > 0) {
//				--this.attackCharge;
//			} else {
//				this.targetedEntity = null;
//			}
//		} else {
//			if (this.attackCharge > 0) {
//				--this.attackCharge;
//			}
//		}
//
//		if (!this.world.isClientSide) {
//			byte chargeData = this.entityData.getByte(16);
//			byte chargeState = (byte)(this.attackCharge <= 10 ? 0 : 1);
//			if (chargeData != chargeState) {
//				this.entityData.set(16, chargeState);
//			}
//		}
//
//	}

	protected void updateAI() {
		if (!this.world.isClientSide && !this.world.getDifficulty().canHostileMobsSpawn()) {
			this.remove();
		}

		this.tryToDespawn();
		this.attackChargeO = this.attackCharge;
		double d = this.waypointX - this.x;
		double d1 = this.waypointY - this.y;
		double d2 = this.waypointZ - this.z;
		double d3 = (double)MathHelper.sqrt(d * d + d1 * d1 + d2 * d2);
		if (d3 < (double)1.0F || d3 > (double)60.0F) {
			this.waypointX = this.x + (double)((this.random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			this.waypointY = this.y + (double)((this.random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			this.waypointZ = this.z + (double)((this.random.nextFloat() * 2.0F - 1.0F) * 16.0F);
		}

		if (this.courseChangeCooldown-- <= 0) {
			this.courseChangeCooldown += this.random.nextInt(5) + 2;
			if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3)) {
				this.xd += d / d3 * 0.1;
				this.yd += d1 / d3 * 0.1;
				this.zd += d2 / d3 * 0.1;
			} else {
				this.waypointX = this.x;
				this.waypointY = this.y;
				this.waypointZ = this.z;
			}
		}

		if (this.targetedEntity != null && this.targetedEntity.removed) {
			this.targetedEntity = null;
		}

		if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
			this.targetedEntity = this.world.getClosestPlayerToEntity(this, (double)32.0F);
			if (this.targetedEntity != null && !((Player)this.targetedEntity).getGamemode().areMobsHostile()) {
				this.targetedEntity = null;
			}

			if (this.targetedEntity != null) {
				this.aggroCooldown = 20;
			}
		}

		double d4 = (double)32.0F;
		double ad4 = (double)6.0F;
		double bd4 = (double)2.0F;
		if (this.targetedEntity != null && this.targetedEntity.distanceToSqr(this) < d4 * d4) {
			if (this.targetedEntity.distanceTo(this) > ad4) {
				this.moveForward += 14F;
			} else if (this.targetedEntity.distanceTo(this) < bd4) {
				this.moveForward += -14F;
			}
			if (this.targetedEntity.y > this.y + 0.7F) {
				this.yd += 0.03;
			}
			else if (this.targetedEntity.y < this.y - 0.7F) {
				this.yd -= 0.03;
			}

			double d8 = (double)4.0F;
			Vec3 vec3 = this.getViewVector(1.0F);
			double dX = this.targetedEntity.x - this.x;
			double dY = this.targetedEntity.y - this.y;
			double dZ = this.targetedEntity.z - this.z;
			double dist = (double)MathHelper.sqrt(dX * dX + dY * dY + dZ * dZ);
			double vX = dX + this.targetedEntity.xd * dist / (double)1F - vec3.x * d8;
			double vY = dY + this.targetedEntity.yd * dist / (double)1F - ((double)(this.bbHeight / 2.0F) + (double)0.5F);
			double vZ = dZ + this.targetedEntity.zd * dist / (double)1F - vec3.z * d8;
			this.yBodyRot = this.yRot = -((float)Math.atan2(vX, vZ)) * 180.0F / (float)Math.PI;
			if (this.canEntityBeSeen(this.targetedEntity)) {
					double sd = this.targetedEntity.x - this.x;
					double sd1 = this.targetedEntity.z - this.z;
					if (this.attackTime == 0) {
						if (!this.world.isClientSide) {
							ProjectileArrow arrow = new ProjectileArrow(this.world, this, false, 0);
							double sd2 = this.targetedEntity.y + (double)this.targetedEntity.getHeadHeight() - 0.2 - arrow.y;
							float f1 = MathHelper.sqrt(sd * sd + sd1 * sd1) * 0.2F;
							this.world.playSoundAtEntity((Entity)null, this, "random.bow", 1.0F, 1.0F / (this.random.nextFloat() * 0.4F + 0.8F));
							arrow.setHeading(sd, sd2 + (double)f1, sd1, 0.6F, 6.0F);
							this.world.entityJoinedWorld(arrow);
						}
						this.attackTime = 30;

					}
					this.yRot = (float)(Math.atan2(sd1, sd) * (double)180.0F / Math.PI) - 90.0F;
			} else if (this.attackCharge > 0) {
				--this.attackCharge;
			} else {
				this.targetedEntity = null;
			}
		} else {
			this.yBodyRot = this.yRot = -((float)Math.atan2(this.xd, this.zd)) * 180.0F / (float)Math.PI;
			if (this.attackCharge > 0) {
				--this.attackCharge;
			}
		}

		if (!this.world.isClientSide) {
			byte chargeData = this.entityData.getByte(16);
			byte chargeState = (byte)(this.attackCharge <= 10 ? 0 : 1);
			if (chargeData != chargeState) {
				this.entityData.set(16, chargeState);
			}
		}
	}


	private boolean isCourseTraversable(double d, double d1, double d2, double d3) {
		double d4 = (this.waypointX - this.x) / d3;
		double d5 = (this.waypointY - this.y) / d3;
		double d6 = (this.waypointZ - this.z) / d3;
		AABB axisalignedbb = this.bb.copy();

		for(int i = 1; (double)i < d3; ++i) {
			axisalignedbb.move(d4, d5, d6);
			if (this.world.getCubes(this, axisalignedbb).size() > 0) {
				return false;
			}
		}

		return true;
	}

	public boolean hurt(Entity attacker, int i, DamageType type) {
		if (super.hurt(attacker, i, type)) {
			if (this.passenger != attacker && this.vehicle != attacker) {
				if (attacker != this) {
					this.targetedEntity = attacker;
					this.aggroCooldown = 60;
				}

				return true;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

//	protected void attackEntity(@NotNull Entity entity, float distance) {
//		if (distance < 14.0F) {
//			double d = entity.x - this.x;
//			double d1 = entity.z - this.z;
//			if (this.attackTime == 0) {
//				if (this.courseChangeCooldown-- > 4) {
//					if (!this.world.isClientSide) {
//						ProjectileArrow arrow = new ProjectileArrow(this.world, this, false, 0);
//						double d2 = entity.y + (double)entity.getHeadHeight() - 0.2 - arrow.y;
//						float f1 = MathHelper.sqrt(d * d + d1 * d1) * 0.2F;
//						this.world.playSoundAtEntity((Entity)null, this, "random.bow", 1.0F, 1.0F / (this.random.nextFloat() * 0.4F + 0.8F));
//						arrow.setHeading(d, d2 + (double)f1, d1, 0.7F, 2.0F);
//						this.world.entityJoinedWorld(arrow);
//						this.attackTime = 30;
//					}
//				}
//			}
//		}
//
//	}

	public String getLivingSound() {
		return "deep:mob.wasp.fly";
	}

	protected String getHurtSound() {
		return "deep:mob.wasp.hurt";
	}

	protected String getDeathSound() {
		return "deep:mob.wasp.hurt";
	}

	protected float getSoundVolume() {
		return 1.0F;
	}

	public boolean canSpawnHere() {
		int blockX = MathHelper.floor(this.x);
		int blockY = MathHelper.floor(this.bb.minY);
		int blockZ = MathHelper.floor(this.z);
		int id = this.world.getBlockId(blockX, blockY - 1, blockZ);
		if (id != DEEPBlocks.blockHoneycomb.id()) {
			return false;
		} else {
			if (this.world.getSavedLightValue(LightLayer.Block, blockX, blockY, blockZ) > 0) {
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
					return super.canSpawnHere() && blockLight <= 4;
				}
			}

		}
		}
	}
