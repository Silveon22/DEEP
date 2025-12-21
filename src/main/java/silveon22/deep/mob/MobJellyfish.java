package silveon22.deep.mob;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.animal.MobSquid;
import net.minecraft.core.entity.animal.MobWaterAnimal;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.LightLayer;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.season.SeasonFall;
import net.minecraft.core.world.season.SeasonSummer;
import net.minecraft.core.world.season.Seasons;
import silveon22.deep.item.DEEPItems;

public class MobJellyfish extends MobWaterAnimal {
	public float xBodyRot = 0.0F;
	public float xBodyRotO = 0.0F;
	public float zBodyRot = 0.0F;
	public float zBodyRotO = 0.0F;
	public float tentacleMovement = 0.0F;
	public float oldTentacleMovement = 0.0F;
	public float tentacleAngle = 0.0F;
	public float oldTentacleAngle = 0.0F;
	private float _speed = 0.0F;
	private float tentacleSpeed = 0.0F;
	private float rotateSpeed = 0.0F;
	private float tx = 0.0F;
	private float ty = 0.0F;
	private float tz = 0.0F;

	public MobJellyfish(World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("deep", "jellyfish");
		this.setSize(0.9F, 0.9F);
		this.tentacleSpeed = 0.5F / (this.random.nextFloat() + 0.5F) * 0.2F;
		this.setHealthRaw(2);
		this.scoreValue = 25;
		this.mobDrops.add(new WeightedRandomLootObject(DEEPItems.gel.getDefaultStack(), 0, 2));
	}

	protected String getHurtSound() {
		return "mob.slime";
	}

	protected String getDeathSound() {
		return "mob.slime";
	}

	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.xBodyRotO = this.xBodyRot;
		this.zBodyRotO = this.zBodyRot;
		this.oldTentacleMovement = this.tentacleMovement;
		this.oldTentacleAngle = this.tentacleAngle;
		this.tentacleMovement += this.tentacleSpeed;
		if (this.tentacleMovement > ((float)Math.PI * 2F)) {
			this.tentacleMovement = 0.0F;
			if (this.random.nextInt(10) == 9) {
				this.tentacleSpeed = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
			}
		}

		if (this.isInWater() && !this.isSpecial()) {
			if (this.tentacleMovement < (float)Math.PI) {
				float f = this.tentacleMovement / (float)Math.PI;
				this.tentacleAngle = MathHelper.sin(f * f * (float)Math.PI) * (float)Math.PI * 0.25F;
				if ((double)f > (double)0.75F) {
					this._speed = 1.0F;
					this.rotateSpeed = 1.0F;
				} else {
					this.rotateSpeed *= 0.8F;
				}
			} else {
				this.tentacleAngle = 0.0F;
				this._speed *= 0.9F;
				this.rotateSpeed *= 0.99F;
			}

			if (!this.isMultiplayerEntity) {
				this.xd = (double)(this.tx * this._speed);
				this.yd = (double)(this.ty * this._speed);
				this.zd = (double)(this.tz * this._speed);
			}

			float horizontalSpeed = MathHelper.sqrt(this.xd * this.xd + this.zd * this.zd);
			this.yBodyRot += (-((float)Math.atan2(this.xd, this.zd)) * 180.0F / (float)Math.PI - this.yBodyRot) * 0.1F;
			this.yRot = this.yBodyRot;
			this.zBodyRot += (float)Math.PI * this.rotateSpeed * 1.5F;
			this.xBodyRot += (-((float)Math.atan2((double)horizontalSpeed, this.yd)) * 180.0F / (float)Math.PI - this.xBodyRot) * 0.1F;
		} else {
			this.tentacleAngle = MathHelper.abs(MathHelper.sin(this.tentacleMovement)) * (float)Math.PI * 0.25F;
			if (!this.isSpecial()) {
				if (!this.isMultiplayerEntity) {
					this.xd = (double)0.0F;
					this.yd -= 0.08;
					this.yd *= 0.98;
					this.zd = (double)0.0F;
				}

				this.xBodyRot += (-90.0F - this.xBodyRot) * 0.02F;
			}
		}

	}

	public void trySuffocate() {
		if (!this.isSpecial()) {
			if (this.isAlive() && !this.isUnderLiquid(Material.water) && this.canBreatheUnderwater()) {
				--this.airSupply;
				if (this.airSupply == -20) {
					this.airSupply = 0;
					this.hurt((Entity)null, 2, DamageType.DROWN);
				}

				this.remainingFireTicks = 0;
			} else {
				this.airSupply = this.airMaxSupply;
			}

		}
	}

	public void moveEntityWithHeading(float moveStrafing, float moveForward) {
		if (this.isSpecial()) {
			super.moveEntityWithHeading(moveStrafing, moveForward);
		} else {
			this.move(this.xd, this.yd, this.zd);
		}

	}

	protected void updateAI() {
		if (this.isSpecial()) {
			Player closest = this.world.getClosestPlayer(this.x, this.y, this.z, (double)10.0F);
			if (closest != null) {
				this.setTarget(closest);
			}

			super.updateAI();
		} else {
			if (this.random.nextInt(50) == 0 || !this.wasInWater || this.tx == 0.0F && this.ty == 0.0F && this.tz == 0.0F) {
				float f = this.random.nextFloat() * (float)Math.PI * 2.0F;
				this.tx = MathHelper.cos(f) * 0.2F;
				Block<?> upwardsBlock = this.world.getBlock((int)this.x, (int)this.y + 3, (int)this.z);
				Block<?> downwardsBlock = this.world.getBlock((int)this.x, (int)this.y - 3, (int)this.z);
				boolean isTouchingBlock = this.isTouchingBlock();
				if (isTouchingBlock && this.isInWater() && !this.world.isAirBlock((int)this.x, (int)(this.y + (double)1.0F), (int)this.z) && !this.world.isAirBlock((int)this.x, (int)(this.y + (double)2.0F), (int)this.z)) {
					this.ty = this.random.nextFloat() * 0.2F;
				} else if (upwardsBlock != null && upwardsBlock.getMaterial() == Material.water) {
					if (downwardsBlock != null && downwardsBlock.getMaterial() == Material.water) {
						this.ty = -0.1F + this.random.nextFloat() * 0.2F;
					} else {
						this.ty = -0.05F + this.random.nextFloat() * 0.4F;
					}
				} else {
					this.ty = -0.15F + this.random.nextFloat() * 0.2F;
				}

				this.tz = MathHelper.sin(f) * 0.2F;
			}

			this.tryToDespawn();
		}
	}

	public boolean isTouchingBlock() {
		int minX = MathHelper.floor(this.bb.minX - (double)0.25F);
		int minY = MathHelper.floor(this.bb.minY - (double)0.25F);
		int minZ = MathHelper.floor(this.bb.minZ - (double)0.25F);
		int maxX = MathHelper.floor(this.bb.maxX + (double)0.25F);
		int maxY = MathHelper.floor(this.bb.maxY + (double)0.25F);
		int maxZ = MathHelper.floor(this.bb.maxZ + (double)0.25F);
		if (this.world.areBlocksLoaded(minX, minY, minZ, maxX, maxY, maxZ)) {
			for(int _x = minX; _x <= maxX; ++_x) {
				for(int _y = minY; _y <= maxY; ++_y) {
					for(int _z = minZ; _z <= maxZ; ++_z) {
						Block<?> block = this.world.getBlock(_x, _y, _z);
						if (block != null && block.getMaterial() != Material.water) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public boolean canSpawnHere() {
		int x = MathHelper.floor(this.x);
		int y = MathHelper.floor(this.bb.minY);
		int z = MathHelper.floor(this.z);
		if (!this.world.isDaytime()) {
			return super.canSpawnHere();
		} else {
			return false;
		}
	}

	protected boolean makeStepSound() {
		return false;
	}

	public boolean isSpecial() {
		return "Silveon22".equals(this.nickname);
	}
}
