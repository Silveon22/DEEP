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

public class BlockLogicMeshSilver extends BlockLogicMesh {
	public BlockLogicMeshSilver(Block<?> block) {
		super(block);
		block.withEntity(TileEntityMeshGold::new);
	}

	public boolean onBlockRightClicked(World world, int x, int y, int z, Player player, Side side, double xPlaced, double yPlaced) {
		TileEntityMeshGold meshGold = (TileEntityMeshGold)world.getTileEntity(x, y, z);
		ItemStack heldItem = player.getHeldItem();
		boolean flag = meshGold.setFilterItem(player, heldItem);
		if (heldItem != null && heldItem.stackSize <= 0) {
			player.inventory.setItem(player.inventory.getCurrentItemIndex(), (ItemStack)null);
		}

		return flag;
	}

	public boolean collidesWithEntity(Entity entity, World world, int x, int y, int z) {
		if (entity instanceof EntityItem) {
			TileEntityMeshGold mesh = (TileEntityMeshGold)world.getTileEntity(x, y, z);
			if (mesh.filterItem == null) {
				return false;
			} else {
				ItemStack entityStack = ((EntityItem)entity).item;
				return entityStack.isItemEqual(mesh.filterItem);
			}
		} else {
			return true;
		}
	}
}
