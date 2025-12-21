package silveon22.deep.mob;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobSlime;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import net.minecraft.core.world.chunk.Chunk;

public class MobWaterSlime extends MobSlime {
	private final boolean hasSlimeSplit;
	private int jumpDelay = 0;
	public MobWaterSlime(World world) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("deep", "water_slime");
		this.heightOffset = 0.0F;
		this.hasSlimeSplit = false;
		this.jumpDelay = 35;
		this.scoreValue = 125;
		this.mobDrops.add(new WeightedRandomLootObject(Items.SLIMEBALL.getDefaultStack(), 0, 2));
	}

	public MobWaterSlime(World world, boolean isSplit) {
		super(world);
		this.textureIdentifier = NamespaceID.getPermanent("deep", "water_slime");
		this.heightOffset = 0.0F;
		this.hasSlimeSplit = isSplit;
		this.scoreValue = 125;
		this.mobDrops.add(new WeightedRandomLootObject(Items.SLIMEBALL.getDefaultStack(), 0, 2));
	}

	@Override
	protected void updateAI() {
		this.tryToDespawn();
		Player entityplayer = this.world.getClosestPlayerToEntity(this, (double)16.0F);
		boolean targetPlayer = entityplayer != null && entityplayer.getGamemode().areMobsHostile();
		if (entityplayer != null && targetPlayer) {
			this.lookAt(entityplayer, 10.0F, 20.0F);
		}

		if (this.onGround && this.jumpDelay-- <= 0) {
			if (!targetPlayer) {
				float rotation = (this.world.rand.nextFloat() - 0.5F) * 90.0F;
				this.yRot += rotation;
			}

			this.jumpDelay = this.random.nextInt(35) + 35;
			if (entityplayer != null) {
				this.jumpDelay /= 2;
			}

			this.isJumping = true;
			if (this.getSlimeSize() > 1) {
				this.world.playSoundAtEntity((Entity)null, this, "mob.slime", this.getSoundVolume(), ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * 0.8F);
			}

			this.squish = 1F;
			this.moveStrafing = 0.5F - this.random.nextFloat() * 2F;
			this.moveForward = (float)this.getSlimeSize();
		} else {
			this.isJumping = false;
			if (this.onGround) {
				this.moveStrafing = this.moveForward = 10F;
			}
		}

	}

	@Override
	public void remove() {
		int size = this.getSlimeSize();
		if (!this.world.isClientSide && size > 1 && this.getHealth() <= 0) {
			int splitCount = this.world.rand.nextInt(4) + 1;

			for(int j = 0; j < splitCount; ++j) {
				float f = ((float)(j % 2) - 0.5F) * (float)size / 2.0F;
				float f1 = ((float)(j / 2) - 0.5F) * (float)size / 2.0F;
				MobWaterSlime mobWaterSlime = new MobWaterSlime(this.world, true);
				mobWaterSlime.setSlimeSize(size / 2);
				mobWaterSlime.moveTo(this.x + (double)f, this.y + (double)0.5F, this.z + (double)f1, this.random.nextFloat() * 360.0F, 0.0F);
				this.world.entityJoinedWorld(mobWaterSlime);
			}
		}

		removed = true;
	}

	protected String getHurtSound() {
		return "mob.slime";
	}

	protected String getDeathSound() {
		return "mob.slime";
	}

	public boolean canSpawnHere() {
		Chunk chunk = this.world.getChunkFromBlockCoords(MathHelper.floor(this.x), MathHelper.floor(this.z));
		if (this.y > (double)32.0F) {
			return false;
		} else if (chunk.getChunkRandom(987234911L).nextInt(10) != 0) {
			return false;
		} else {
			return !this.world.getDifficulty().canHostileMobsSpawn() ? false : super.canSpawnHere();
		}
	}

	protected float getSoundVolume() {
		return 0.6F;
	}
}
