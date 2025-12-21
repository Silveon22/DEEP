package silveon22.deep.mob;

import net.minecraft.core.achievement.Achievements;
import net.minecraft.core.block.Block;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.entity.projectile.Projectile;
import net.minecraft.core.entity.projectile.ProjectileArrowGolden;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.util.phys.Vec3;
import net.minecraft.core.world.World;
import silveon22.deep.item.DEEPItems;

public class ProjectileHail extends Projectile {

	protected void initProjectile() {
		super.initProjectile();
		this.damage = 7;
		this.defaultGravity = 0.05F;
		this.setSize(1F, 1F);
	}

	public ProjectileHail(World world) {
		super(world);
		this.modelItem = DEEPItems.ammoHail;
	}

	public ProjectileHail(World world, Mob owner) {
		super(world, owner);
		this.modelItem = DEEPItems.ammoHail;
	}

	public ProjectileHail(World world, double x, double y, double z) {
		super(world, x, y, z);
		this.modelItem = DEEPItems.ammoHail;
	}

	public void tick() {
		this.world.spawnParticle("snowshovel", this.x + this.xd * (double)0.5F, this.y + this.yd * (double)0.5F, this.z + this.zd * (double)0.5F, this.xd * 0.05, this.yd * 0.05 - 0.1, this.zd * 0.05, 0);

		super.tick();
	}

	public void onHit(HitResult hitResult) {
		if (hitResult.hitType == HitResult.HitType.TILE) {
			if (!this.world.isClientSide) {
				this.world.playSoundAtEntity((Entity)null, this, "random.glass", 0.5F, 0.7F / (this.random.nextFloat() * 0.2F + 0.9F));
			}
			this.world.spawnParticle("snowshovel", this.x + 0.5, this.y + 0.5, this.z + 0.5, this.xd * 0.05, 0.3, this.zd * 0.05, 0);
			this.world.spawnParticle("snowshovel", this.x - 0.5, this.y + 0.5, this.z + 0.5, this.xd * 0.05, 0.2, this.zd * 0.05, 0);
			this.world.spawnParticle("snowshovel", this.x - 0.5, this.y + 0.5, this.z - 0.5, this.xd * 0.05, 0.3, this.zd * 0.05, 0);
			this.world.spawnParticle("snowshovel", this.x + 0.5, this.y + 0.5, this.z - 0.5, this.xd * 0.05, 0.2, this.zd * 0.05, 0);


		}
		super.onHit(hitResult);

	}
}
