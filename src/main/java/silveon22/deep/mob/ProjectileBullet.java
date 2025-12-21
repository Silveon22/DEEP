package silveon22.deep.mob;

import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.projectile.Projectile;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.world.World;
import silveon22.deep.item.DEEPItems;

public class ProjectileBullet extends Projectile {

	public void initProjectile() {
		this.defaultProjectileSpeed = 1.01F;
		this.defaultGravity = 0.025F;
	}

	public ProjectileBullet(World world) {
		super(world);
		this.modelItem = DEEPItems.ammoBullet;
		this.damage = 7;
	}

	public ProjectileBullet(World world, Mob owner) {
		super(world, owner);
		this.modelItem = DEEPItems.ammoBullet;
		this.damage = 7;
	}

	public ProjectileBullet(World world, double x, double y, double z) {
		super(world, x, y, z);
		this.modelItem = DEEPItems.ammoBullet;
		this.damage = 7;
	}
}
