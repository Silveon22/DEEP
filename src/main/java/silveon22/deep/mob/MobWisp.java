package silveon22.deep.mob;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.MobFlying;
import net.minecraft.core.entity.monster.Enemy;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.entity.projectile.ProjectileFireball;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.util.phys.Vec3;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MobWisp extends MobFlying implements Enemy {
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

	public MobWisp(World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("deep", "wisp");
		this.setSize(3.0F, 3.0F);
		this.fireImmune = true;
		this.scoreValue = 500;
		this.setHealthRaw(12);
		this.bb.grow((double)2.0F, (double)3.0F, (double)2.0F);
		this.mobDrops.add(new WeightedRandomLootObject(Items.SULPHUR.getDefaultStack(), 0, 2));
	}

	public void playerTouch(Player player) {
		if (this.canEntityBeSeen(player) && (double)this.distanceTo(player) < 2 && player.hurt(this, 2, DamageType.COMBAT)) {
			player.fireHurt();
		}

	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(16, (byte)0, Byte.class);
	}

	public void tick() {
		if (this.world.isClientSide) {
			byte i = this.entityData.getByte(16);
			if (i > 0 && this.attackCharge == 0) {
				this.world.playSoundAtEntity((Entity)null, this, "mob.ghast.charge", this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			}

			this.attackCharge += i;
			if (this.attackCharge < 0) {
				this.attackCharge = 0;
			}

			if (this.attackCharge >= 20) {
				this.attackCharge = 20;
			}

			if (this.attackCharge >= 20 && i == 0) {
				this.world.playSoundAtEntity((Entity)null, this, "mob.ghast.fireball", this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
				this.attackCharge = -40 + this.random.nextInt();
			}
		}

		super.tick();
	}

	protected void updateAI() {
		if (!this.world.isClientSide && !this.world.getDifficulty().canHostileMobsSpawn()) {
			this.remove();
		}

		this.tryToDespawn();
		this.attackChargeO = this.attackCharge;
		double da = (double)this.x + (double)0.5F + ((double)this.world.rand.nextFloat() - (double)0.5F) * (double)2.0F;
		double db = (double)this.y + (double)0.5F + ((double)this.world.rand.nextFloat() - (double)0.5F) * (double)2.0F;
		double dc = (double)this.z + (double)0.5F + ((double)this.world.rand.nextFloat() - (double)0.5F) * (double)2.0F;
		this.world.spawnParticle("flame", da, db, dc, (double)0.0F, (double)0.0F, (double)0.0F, 0);
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
			this.courseChangeCooldown += this.random.nextInt(3) + 5;
			if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3)) {
				this.xd += d / d3 * 0.05;
				this.yd += d1 / d3 * 0.05;
				this.zd += d2 / d3 * 0.05;
				this.moveForward = 5.0F;
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
			this.targetedEntity = this.world.getClosestPlayerToEntity(this, (double)100.0F);
			if (this.targetedEntity != null && !((Player)this.targetedEntity).getGamemode().areMobsHostile()) {
				this.targetedEntity = null;
			}

			if (this.targetedEntity != null) {
				this.yBodyRot = this.yRot = -((float)Math.atan2(this.xd, this.zd)) * 180.0F / (float)Math.PI;
				this.aggroCooldown = 20;
			}
		}

		double d4 = (double)32.0F;
		if (this.targetedEntity != null && this.targetedEntity.distanceToSqr(this) < d4 * d4) {
			this.yBodyRot = this.yRot = -((float)Math.atan2(this.xd, this.zd)) * 180.0F / (float)Math.PI;

			double d8 = (double)4.0F;
			Vec3 vec3 = this.getViewVector(1.0F);
			double dX = this.targetedEntity.x - this.x;
			double dY = this.targetedEntity.y - this.y;
			double dZ = this.targetedEntity.z - this.z;
			double dist = (double)MathHelper.sqrt(dX * dX + dY * dY + dZ * dZ);
			double vX = dX + this.targetedEntity.xd * dist / (double)7.5F - vec3.x * d8;
			double vY = dY + this.targetedEntity.yd * dist / (double)7.5F - ((double)(this.bbHeight / 2.0F) + (double)0.5F);
			double vZ = dZ + this.targetedEntity.zd * dist / (double)7.5F - vec3.z * d8;
			this.yBodyRot = this.yRot = -((float)Math.atan2(vX, vZ)) * 180.0F / (float)Math.PI;
			if (this.canEntityBeSeen(this.targetedEntity)) {
				++this.attackCharge;
				if (this.attackCharge == 20) {
					this.world.playSoundAtEntity((Entity)null, this, "mob.ghast.fireball", this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
					this.xd *= 2;
					this.yd *= 4;
					this.zd *= 2;

					this.waypointX = this.targetedEntity.x;
					this.waypointY = this.targetedEntity.y;
					this.waypointZ = this.targetedEntity.z;
					this.attackCharge = -10 + this.random.nextInt(20);
					this.world.spawnParticle("largesmoke", da + 0.5F, db + 0.2F, dc + 0.3F, (double)0.0F, (double)0.0F, (double)0.0F, 0);
					this.world.spawnParticle("largesmoke", da - 0.3F, db - 0.2F, dc - 0.5F, (double)0.0F, (double)0.0F, (double)0.0F, 0);
					this.world.spawnParticle("largesmoke", da, db, dc, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				}
			} else if (this.attackCharge > 0) {
				--this.attackCharge;
			} else {
				this.targetedEntity = null;
			}
		} else {
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

	protected String getHurtSound() {
		return "mob.creeper";
	}

	protected String getDeathSound() {
		return "mob.creeperdeath";
	}

	protected float getSoundVolume() {
		return 2.0F;
	}

	public boolean canSpawnHere() {
		return this.world.getDifficulty().canHostileMobsSpawn() && BlockTags.NETHER_MOBS_SPAWN.appliesTo(this.world.getBlock(MathHelper.floor(this.x), MathHelper.floor(this.y - (double)this.heightOffset) - 1, MathHelper.floor(this.z))) && super.canSpawnHere();
	}

	public float getBrightness(float partialTick) {
		return 1.0F;
	}

	public int getLightmapCoord(float partialTick) {
		return this.world.getLightmapCoord(15, 15);
	}
}
