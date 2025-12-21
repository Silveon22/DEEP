package silveon22.deep.gui;

import java.util.List;
import net.minecraft.core.InventoryAction;
import net.minecraft.core.block.entity.TileEntityFurnace;
import net.minecraft.core.crafting.ContainerListener;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.ContainerInventory;
import net.minecraft.core.player.inventory.menu.MenuAbstract;
import net.minecraft.core.player.inventory.slot.Slot;
import net.minecraft.core.player.inventory.slot.SlotFurnace;
import silveon22.deep.mob.TileEntityFreezer;

public class MenuFreezer extends MenuAbstract {
	public static final int ID_CURRENT_COOK_TIME = 0;
	public static final int ID_CURRENT_BURN_TIME = 1;
	public static final int ID_MAX_COOK_TIME = 2;
	public static final int ID_MAX_BURN_TIME = 3;
	public TileEntityFreezer freezer;
	private int currentCookTime = 0;
	private int currentBurnTime = 0;
	private int itemBurnTime = 0;
	private int itemCookTime = 0;

	public MenuFreezer(ContainerInventory inventory, TileEntityFreezer tileEntity) {
		this.freezer = tileEntity;
		this.addSlot(new Slot(tileEntity, 0, 56, 17));
		this.addSlot(new Slot(tileEntity, 1, 56, 53));
		this.addSlot(new SlotFurnace(inventory.player, tileEntity, 2, 116, 35));

		for(int i = 0; i < 3; ++i) {
			for(int k = 0; k < 9; ++k) {
				this.addSlot(new Slot(inventory, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
			}
		}

		for(int j = 0; j < 9; ++j) {
			this.addSlot(new Slot(inventory, j, 8 + j * 18, 142));
		}

	}

	public void broadcastChanges() {
		super.broadcastChanges();

		for(ContainerListener crafter : this.containerListeners) {
			if (this.currentCookTime != this.freezer.currentCookTime) {
				crafter.updateCraftingInventoryInfo(this, 0, this.freezer.currentCookTime);
			}

			if (this.currentBurnTime != this.freezer.currentBurnTime) {
				crafter.updateCraftingInventoryInfo(this, 1, this.freezer.currentBurnTime);
			}

			if (this.itemCookTime != this.freezer.maxCookTime) {
				crafter.updateCraftingInventoryInfo(this, 2, this.freezer.maxCookTime);
			}

			if (this.itemBurnTime != this.freezer.maxBurnTime) {
				crafter.updateCraftingInventoryInfo(this, 3, this.freezer.maxBurnTime);
			}
		}

		this.currentCookTime = this.freezer.currentCookTime;
		this.currentBurnTime = this.freezer.currentBurnTime;
		this.itemCookTime = this.freezer.maxCookTime;
		this.itemBurnTime = this.freezer.maxBurnTime;
	}

	public void setData(int id, int value) {
		switch (id) {
			case 0:
				this.freezer.currentCookTime = value;
				break;
			case 1:
				this.freezer.currentBurnTime = value;
				break;
			case 2:
				this.freezer.maxCookTime = value;
				break;
			case 3:
				this.freezer.maxBurnTime = value;
		}

	}

	public boolean stillValid(Player entityplayer) {
		return this.freezer.stillValid(entityplayer);
	}

	public List<Integer> getMoveSlots(InventoryAction action, Slot slot, int target, Player player) {
		if (slot.index >= 0 && slot.index <= 3) {
			return this.getSlots(slot.index, 1, false);
		} else {
			if (action == InventoryAction.MOVE_ALL) {
				if (slot.index >= 3 && slot.index <= 30) {
					return this.getSlots(3, 27, false);
				}

				if (slot.index >= 30 && slot.index <= 38) {
					return this.getSlots(30, 9, false);
				}
			}

			return slot.index >= 3 && slot.index <= 38 ? this.getSlots(3, 36, false) : null;
		}
	}

	public List<Integer> getTargetSlots(InventoryAction action, Slot slot, int target, Player player) {
		if (slot.index >= 3 && slot.index <= 39) {
			if (action != InventoryAction.MOVE_ALL) {
				if (target == 1) {
					return this.getSlots(0, 1, false);
				}

				if (target == 2) {
					return this.getSlots(1, 1, false);
				}
			}

			if (slot.index >= 3 && slot.index <= 29) {
				return this.getSlots(30, 9, false);
			}

			if (slot.index >= 31 && slot.index <= 38) {
				return this.getSlots(3, 27, false);
			}
		}

		if (slot.index >= 0 && slot.index <= 2) {
			return slot.index == 2 ? this.getSlots(3, 36, true) : this.getSlots(3, 36, false);
		} else {
			return null;
		}
	}
}
