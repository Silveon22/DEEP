package silveon22.deep.mob;

import com.mojang.nbt.tags.CompoundTag;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobCreeper;
import net.minecraft.core.entity.monster.MobMonster;
import net.minecraft.core.entity.monster.MobSkeleton;
import net.minecraft.core.enums.LightLayer;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import net.minecraft.core.entity.EntityLightning;
import org.jetbrains.annotations.Nullable;

public class MobPopper extends MobCreeper {
	int timeSinceIgnited;
	int lastActiveTime;

	public MobPopper(@Nullable World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("deep", "popper");
		this.moveSpeed = 1.1F;
		this.scoreValue = 1000;
		this.fireImmune = true;
		this.setHealthRaw(50);
		this.setSize(1.2F, 2.6F);
	}

	@Override
	public void tick() {
		this.lastActiveTime = this.timeSinceIgnited;
		if (this.world.isClientSide) {
			int i = this.getCreeperState();
			if (i > 0 && this.timeSinceIgnited == 0 && !this.world.isClientSide) {
				this.world.playSoundAtEntity((Entity)null, this, "mob.creeper.fuse", 1.0F, 1.5F);
			}

			this.timeSinceIgnited += i;
			if (this.timeSinceIgnited < 0) {
				this.timeSinceIgnited = 0;
			}

			if (this.timeSinceIgnited >= 25) {
				this.timeSinceIgnited = 25;
			}
		}

		super.tick();
	}

	@Override
	protected void attackEntity(@NotNull Entity entity, float distance) {
		if (!this.world.isClientSide) {
			int i = this.getCreeperState();
			if (i <= 0 && distance < 3.0F || i > 0 && distance < 4.0F) {
				if (this.timeSinceIgnited == 0 && !this.world.isClientSide) {
					this.world.playSoundAtEntity((Entity)null, this, "mob.creeper.fuse", 1.0F, 1.5F);
				}

				this.setCreeperState(1);
				++this.timeSinceIgnited;
				if (this.timeSinceIgnited >= 25) {
					if (this.getPowered()) {
						this.world.createExplosion(this, this.x, this.y + (double)(this.bbHeight / 5.0F), this.z, 4.0F);
					} else {
						this.world.createExplosion(this, this.x, this.y + (double)(this.bbHeight / 2.5F), this.z, 2.0F);
					}
					this.timeSinceIgnited = 5;
				}

				this.hasAttacked = true;
			} else {
				this.setCreeperState(-1);
				--this.timeSinceIgnited;
				if (this.timeSinceIgnited < 0) {
					this.timeSinceIgnited = 0;
				}
			}

		}
		double dX = entity.x - this.x;
		double dZ = entity.z - this.z;
	}


	public boolean canClimb() {
		return this.horizontalCollision;
	}

	private int getCreeperState() {
		return this.entityData.getByte(16);
	}

	private void setCreeperState(int i) {
		this.entityData.set(16, (byte)i);
	}

	@Override
	public boolean canSpawnHere() {
		int x = MathHelper.floor(this.x);
		int y = MathHelper.floor(this.y);
		int z = MathHelper.floor(this.z);
		if (this.world.getBlockId(x, y, z) != 0) {
			return false;
		} else {
			Block<?> below = this.world.getBlock(x, y - 1, z);
			if (!BlockTags.NETHER_MOBS_SPAWN.appliesTo(below)) {
				return false;
			} else {
				int blockLight = this.world.getSavedLightValue(LightLayer.Block, x, y, z);
				if (blockLight > 7) {
					return false;
				} else {
					return this.world.getDifficulty().canHostileMobsSpawn() && this.world.checkIfAABBIsClear(this.bb) && this.world.getCubes(this, this.bb).isEmpty() && !this.world.getIsAnyLiquid(this.bb);
				}
			}
		}
	}

	public String getLivingSound() {
		return "deep:mob.popper.pop";
	}
}
