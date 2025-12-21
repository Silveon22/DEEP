package silveon22.deep.item;

import java.util.List;
import java.util.Random;
import net.minecraft.core.block.entity.TileEntityActivator;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.animal.MobCow;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.util.phys.HitResult.HitType;
import net.minecraft.core.world.World;

public class ItemCeramicBucketEmpty extends Item {
	public ItemCeramicBucketEmpty(String name, String namespaceId, int id) {
		super(name, namespaceId, id);
		this.maxStackSize = 64;
	}

	public ItemStack onUseItem(ItemStack itemstack, World world, Player entityplayer) {
		double reachDistance = (double)entityplayer.getGamemode().getBlockReachDistance();
		HitResult hitResult = entityplayer.rayTrace(reachDistance, 1.0F, true, false);
		if (hitResult == null) {
			return itemstack;
		} else {
			if (hitResult.hitType == HitType.TILE) {
				int i = hitResult.x;
				int j = hitResult.y;
				int k = hitResult.z;
				if (!world.canMineBlock(entityplayer, i, j, k)) {
					return itemstack;
				}

				if (world.getBlockMaterial(i, j, k) == Material.water && world.getBlockMetadata(i, j, k) == 0) {
					if (useBucket(entityplayer, new ItemStack(DEEPItems.bucketCeramicWater))) {
						world.setBlockWithNotify(i, j, k, 0);
						entityplayer.swingItem();
					}
				}
			}

			return itemstack;
		}
	}

	public void onUseByActivator(ItemStack itemStack, TileEntityActivator activatorBlock, World world, Random random, int blockX, int blockY, int blockZ, double offX, double offY, double offZ, Direction direction) {
		if (itemStack.stackSize <= 1) {
			int x = blockX + direction.getOffsetX();
			int y = blockY + direction.getOffsetY();
			int z = blockZ + direction.getOffsetZ();
			if (world.getBlockMaterial(x, y, z) == Material.water && world.getBlockMetadata(x, y, z) == 0) {
				world.setBlockWithNotify(x, y, z, 0);
				itemStack.itemID = DEEPItems.bucketCeramicWater.id;
			}
		}
	}

	public static boolean useBucket(Player player, ItemStack itemToGive) {
		if (player.inventory.getCurrentItem().stackSize <= 1) {
			player.inventory.setItem(player.inventory.getCurrentItemIndex(), itemToGive);
			return true;
		} else {
			player.inventory.insertItem(itemToGive, true);
			if (itemToGive.stackSize < 1) {
				player.inventory.getCurrentItem().consumeItem(player);
				return true;
			} else {
				return false;
			}
		}
	}
}
