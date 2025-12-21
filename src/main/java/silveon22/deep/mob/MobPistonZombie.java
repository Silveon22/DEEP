package silveon22.deep.mob;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobZombie;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.enums.LightLayer;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class MobPistonZombie extends MobZombie {
	public MobPistonZombie(@Nullable World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("deep", "piston_zombie");
		this.moveSpeed = 0.4F;
		this.attackStrength = 5;
		this.setHealthRaw(25);
		this.scoreValue = 500;
		this.mobDrops.add(new WeightedRandomLootObject(Items.CLOTH.getDefaultStack(), 0, 2));
	}

	@Override
	public void knockBack(Entity entity, int i, double d, double d1) {
		float f = MathHelper.sqrt(d * d + d1 * d1);
		float f1 = -0.6F;
		this.xd /= (double)1F;
		this.yd = (double)0.5F;
		this.zd /= (double)1F;
		this.xd -= d / (double)f * (double)f1;
		this.yd += (double)1F;
		this.zd -= d1 / (double)f * (double)f1;
		this.world.playSoundAtEntity((Entity)null, this, "tile.piston.out", 1F, (this.random.nextFloat() * 1.2F - this.random.nextFloat()) * 1.2F);

	}


	@Override
	protected void attackEntity(@NotNull Entity entity, float distance) {
		if (distance > 2.0F && distance < 16.0F && this.y < entity.y - 3 && this.random.nextInt(15) == 0) {
			if (this.onGround) {
				double d = entity.x - this.x;
				double d1 = entity.z - this.z;
				float f2 = MathHelper.sqrt(d * d + d1 * d1);
				this.xd = d / (double)f2 * (double)0.5F * (double)0.8F + this.xd * 0.2;
				this.zd = d1 / (double)f2 * (double)0.5F * (double)0.8F + this.zd * 0.2;
				this.yd += (double)1F + this.random.nextFloat();
				this.world.playSoundAtEntity((Entity)null, this, "tile.piston.out", 0.5F, (this.random.nextFloat() * 1.2F - this.random.nextFloat()) * 1.2F);

			}
		} else {
			super.attackEntity(entity, distance);
		}
	}

	@Override
	protected void jump() {
		if (!this.noPhysics) {
			this.xd += this.xd;
			this.yd += (double)1F;
			this.zd += this.zd;
			this.world.playSoundAtEntity((Entity)null, this, "tile.piston.out", 1F, (this.random.nextFloat() * 1.2F - this.random.nextFloat()) * 1.2F);

		}
	}

	@Override
	protected void causeFallDamage(float distance) {

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
		}else if (this.y > rangeY / 1.8F) {
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
