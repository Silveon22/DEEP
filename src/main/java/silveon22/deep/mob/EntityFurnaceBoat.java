package silveon22.deep.mob;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.crafting.LookupFuelFurnace;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.entity.vehicle.EntityBoat;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;

public class EntityFurnaceBoat extends EntityBoat {

	public double xPush;
	public double zPush;
	public static final int DATA_FUEL = 14;


	public EntityFurnaceBoat(World world) {
		super(world);
	}

	@Override
	public double getRideHeight() {
		return (double)this.bbHeight * (double)0.0F + 0.7;
	}

	public void setFuel(int fuel) {
		this.entityData.set(14, fuel);
	}

	public int getFuel() {
		return this.entityData.getInt(14);
	}

	@Override
	protected void defineSynchedData() {
		this.entityData.define(14, 0, Integer.class);
		super.defineSynchedData();
	}

	@Override
	public void tick() {
		super.tick();
		boolean didFurnacePush = false;
		double vel = Math.hypot(this.xd, this.zd);
		vel = Math.hypot(this.xPush, this.zPush);
		if (vel > 0.01) {
			didFurnacePush = true;
			this.xPush /= vel;
			this.zPush /= vel;
			this.xd *= 0.85;
			this.zd *= 0.85;
			this.xd += this.xPush * 0.12;
			this.zd += this.zPush * 0.12;
		}

		double pushMagnitude = Math.hypot(this.xPush, this.zPush);
		if (pushMagnitude > 0.01 && Math.hypot(this.xd, this.zd) > 0.01) {
			this.xPush = this.xd;
			this.zPush = this.zd;
		}

		if (didFurnacePush) {
			this.setFuel(this.getFuel() - 2);
			if (this.getFuel() < 0) {
				this.xPush = (double)0.0F;
				this.zPush = (double)0.0F;
			}

			this.world.spawnParticle("largesmoke", this.x, this.y + 0.8, this.z, (double)0.0F, (double)0.0F, (double)0.0F, 0);
		}
	}

	public void remove() {
		this.dropItem(Blocks.FURNACE_STONE_IDLE.asItem().id, 1, 0.0F);

		super.remove();
	}


	public boolean interact(@NotNull Player player) {
				ItemStack itemstack = player.inventory.getCurrentItem();
				if (itemstack != null && LookupFuelFurnace.instance.getFuelYield(itemstack.itemID) > 0 && itemstack.consumeItem(player)) {
					if (itemstack.stackSize <= 0) {
						player.inventory.setItem(player.inventory.getCurrentItemIndex(), (ItemStack)null);
					}

					this.setFuel(this.getFuel() + MathHelper.round((double)((float)LookupFuelFurnace.instance.getFuelYield(itemstack.itemID) / 1600.0F * 1200.0F)));
					this.xPush = this.x - player.x;
					this.zPush = this.z - player.z;

				}
				else {
					super.interact(player);
				}
		return false;
	}
}
