package silveon22.deep.block.misc;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicMesh;
import net.minecraft.core.block.entity.TileEntityMeshGold;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class BlockLogicLeadMesh extends BlockLogicMesh {
	public BlockLogicLeadMesh(Block<?> block) {
		super(block);
		block.withEntity(TileEntityMeshGold::new);
	}

	public boolean collidesWithEntity(Entity entity, World world, int x, int y, int z) {
		if (entity instanceof EntityItem) {
			ItemStack entityStack = ((EntityItem)entity).item;
			int stacksize = entityStack.getMaxStackSize();
			boolean itemisstackable = false;
			if (stacksize < 2) {
				itemisstackable = true;
			}
			return itemisstackable;
		} else {
			return true;
		}
	}
}
