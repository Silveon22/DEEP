package silveon22.deep.mob;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobSkeleton;
import net.minecraft.core.entity.projectile.ProjectileArrow;
import net.minecraft.core.enums.LightLayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import silveon22.deep.item.DEEPItems;

import javax.annotation.Nullable;

public class MobElderSkeleton extends MobSkeleton {
	private static final ItemStack neoDefaultHeldItem;
	public MobElderSkeleton(@Nullable World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("deep", "elder_skeleton");
		this.moveSpeed = 2.0F;
		this.scoreValue = 1000;
		this.setHealthRaw(34);
		this.mobDrops.add(new WeightedRandomLootObject(Items.AMMO_ARROW.getDefaultStack(), 2, 5));
		this.mobDrops.add(new WeightedRandomLootObject(Items.BONE.getDefaultStack(), 0, 2));
	}

	protected void attackEntity(@NotNull Entity entity, float distance) {
		if (distance < 10.0F) {
			double d = entity.x - this.x;
			double d1 = entity.z - this.z;
			if (this.attackTime == 0) {
				if (!this.world.isClientSide) {
					ProjectileArrow arrow = new ProjectileArrow(this.world, this, false, 1);
					double d2 = entity.y + (double)entity.getHeadHeight() - 0.2 - arrow.y;
					float f1 = MathHelper.sqrt(d * d + d1 * d1) * 0.2F;
					this.world.playSoundAtEntity((Entity)null, this, "random.bow", 1.0F, 1.6F / (this.random.nextFloat() * 0.4F + 0.8F));
					arrow.setHeading(d, d2 + (double)f1, d1, 0.6F, 3.0F);
					this.world.entityJoinedWorld(arrow);
				}

				this.attackTime = 20;
			}

			this.yRot = (float)(Math.atan2(d1, d) * (double)180.0F / Math.PI) - 90.0F;
			this.hasAttacked = true;
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

	public String getLivingSound() {
		return "deep:mob.elder.skeleton.say";
	}

	protected String getHurtSound() {
		return "deep:mob.elder.skeleton.hurt";
	}

	protected String getDeathSound() {
		return "deep:mob.elder.skeleton.death";
	}

	@Override
	public ItemStack getHeldItem() {
		return neoDefaultHeldItem;
	}

	static {
		neoDefaultHeldItem = new ItemStack(DEEPItems.toolBowSteel, 1);
	}

}
