package silveon22.deep.mob;

import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.projectile.Projectile;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.World;
import silveon22.deep.item.DEEPItems;

public class ProjectileSilverKnife extends Projectile {
	public ProjectileSilverKnife(World world) {
		super(world);
		this.modelItem = DEEPItems.ammoKnifeSilver;
		this.damage = 9;
	}

	public ProjectileSilverKnife(World world, Mob owner) {
		super(world, owner);
		this.modelItem = DEEPItems.ammoKnifeSilver;
		this.damage = 9;
	}

	public ProjectileSilverKnife(World world, double x, double y, double z) {
		super(world, x, y, z);
		this.modelItem = DEEPItems.ammoKnifeSilver;
		this.damage = 9;
	}
}
