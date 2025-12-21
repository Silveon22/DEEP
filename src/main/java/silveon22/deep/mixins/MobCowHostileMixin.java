package silveon22.deep.mixins;

import net.minecraft.core.block.Block;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.animal.MobAnimal;
import net.minecraft.core.entity.animal.MobCow;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.item.tool.ItemToolAxe;
import net.minecraft.core.player.inventory.slot.Slot;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import silveon22.deep.item.DEEPItems;

@Mixin(value = MobCow.class, remap = false)
public class MobCowHostileMixin extends MobAnimal {

	@Unique
	protected int attackStrength = 7;
	public MobCowHostileMixin(World world) {
		super(world);
	}

	@Override
	protected void checkForPlayerHoldingItem() {
		if (this.target == null) {
			this.closestPlayer = this.world.getClosestPlayer(this.x, this.y, this.z, (double)10.0F);
		}

		if (this.closestPlayer != null) {
			if (this.isFavouriteItem(this.closestPlayer.getHeldItem())) {
				this.setTarget(this.closestPlayer);
			} else {
				this.setTarget((Entity)null);
				this.closestPlayer = null;
			}
		}

		if (this.target != null) {
			float distanceToEntity = this.target.distanceTo(this);
			if (distanceToEntity < 3.0F) {
				this.moveForward = 0.0F;
			}
		}
		if (this.passenger != null) {
			if (this.target == null) {
				this.closestPlayer = this.world.getClosestPlayer(this.x, this.y, this.z, (double) 16.0F);
				if (this.closestPlayer != null) {
					this.setTarget(this.closestPlayer);
					this.moveSpeed = 2F;
					this.speed = 0.13F;
				}
				else {
					this.moveSpeed = 0.5F;
					this.speed = 0.1F;
				}
			}
		}
	}

	protected void attackEntity(@NotNull Entity entity, float distance) {
		if (this.passenger != null) {
			if (distance > 2.0F && distance < 6.0F && this.random.nextInt(10) == 0) {
				if (this.onGround) {
					double d = entity.x - this.x;
					double d1 = entity.z - this.z;
					float f2 = MathHelper.sqrt(d * d + d1 * d1);
					this.xd = d / (double)f2 * (double)0.5F * (double)0.8F + this.xd * 0.2;
					this.zd = d1 / (double)f2 * (double)0.5F * (double)0.8F + this.zd * 0.2;
					this.yd = (double)0.4F;
				}
			} else {
				if (this.attackTime <= 0 && distance < 2.0F && entity.bb.maxY > this.bb.minY && entity.bb.minY < this.bb.maxY) {
					this.attackTime = 20;
					entity.hurt(this, this.attackStrength, DamageType.COMBAT);
				}
			}

		}
	}


}
