package silveon22.deep.mob;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobSpider;
import net.minecraft.core.enums.LightLayer;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import silveon22.deep.item.DEEPItems;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class MobBeetle extends MobSpider {
	boolean alerted = false;
	public MobBeetle(@Nullable World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("deep", "beetle");
		this.moveSpeed = 0.4F;
		this.attackStrength = 5;
		this.setHealthRaw(34);
		this.scoreValue = 300;
		this.mobDrops.clear();
		this.mobDrops.add(new WeightedRandomLootObject(DEEPItems.huskBeetle.getDefaultStack(), 0,2));
	}

	protected void attackEntity(@NotNull Entity entity, float distance) {
		float brightness = this.getBrightness(1.0F);
		if (brightness > 0.5F && this.random.nextInt(100) == 0) {
			this.target = null;
		} else {
			super.attackEntity(entity, distance);

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
		}else if (this.y > rangeY / 2.2F) {
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
