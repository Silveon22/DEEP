package silveon22.deep.mob;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.projectile.Projectile;
import net.minecraft.core.world.World;
import silveon22.deep.item.DEEPItems;

public class ProjectileWeb extends Projectile {
	public ProjectileWeb(World world) {
		super(world);
		this.modelItem = Blocks.COBWEB.asItem();
		this.damage = 4;
	}

	public ProjectileWeb(World world, Mob owner) {
		super(world, owner);
		this.modelItem = Blocks.COBWEB.asItem();
		this.damage = 4;
	}

	public ProjectileWeb(World world, double x, double y, double z) {
		super(world, x, y, z);
		this.modelItem = Blocks.COBWEB.asItem();
		this.damage = 4;
	}
}
