package silveon22.deep.item;

import net.minecraft.core.block.entity.TileEntityActivator;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.animal.MobCow;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.player.inventory.slot.Slot;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.world.World;

import java.util.List;
import java.util.Random;

import net.minecraft.core.util.phys.HitResult.HitType;

public class ItemBucketDrain extends Item {
	public ItemBucketDrain(String name, String namespaceId, int id) {
		super(name, namespaceId, id);
		this.maxStackSize = 1;
		this.setMaxDamage(384);
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
					world.setBlockWithNotify(i, j, k, 0);
					entityplayer.swingItem();
					itemstack.damageItem(1, entityplayer);
				} else if (world.getBlockMaterial(i, j, k) == Material.lava && world.getBlockMetadata(i, j, k) == 0) {
					world.setBlockWithNotify(i, j, k, 0);
					entityplayer.swingItem();
					itemstack.damageItem(1, entityplayer);
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
				itemStack.damageItem(1, (Entity)null);
			} else if (world.getBlockMaterial(x, y, z) == Material.lava && world.getBlockMetadata(x, y, z) == 0) {
				world.setBlockWithNotify(x, y, z, 0);
				itemStack.damageItem(1, (Entity)null);
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

	public void setDurabilityCount(ItemStack stack, int count) {
		stack.setMetadata(stack.getMaxDamage() - count);
	}

	public boolean hasInventoryInteraction() {
		return true;
	}

	public ItemStack onInventoryInteract(Player player, Slot slot, ItemStack stackInSlot, boolean isItemGrabbed) {
		if (isItemGrabbed) {
			return stackInSlot;
		} else {
			int durabilityCount = this.getDurabilityCount(stackInSlot);
			ItemStack grabbedItem = player.inventory.getHeldItemStack();
			if (grabbedItem != null && grabbedItem.itemID == DEEPItems.bismuth.id) {
				if (durabilityCount < this.getMaxDamage()) {
					int newDurabilityCount = Math.min(this.getMaxDamage(), stackInSlot.getMaxDamage());
					this.setDurabilityCount(stackInSlot, newDurabilityCount);
					--grabbedItem.stackSize;
					if (grabbedItem.stackSize <= 0) {
						player.inventory.setHeldItemStack((ItemStack)null);
					}
				}
			}

			return stackInSlot;
		}
	}

	public int getDurabilityCount(ItemStack stack) {
		return stack.getMaxDamage() - stack.getMetadata();
	}
}
