package silveon22.deep.mob;

import com.mojang.nbt.tags.CompoundTag;
import com.mojang.nbt.tags.ListTag;
import java.util.List;
import java.util.Random;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicFurnace;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.motion.CarriedBlock;
import net.minecraft.core.crafting.LookupFuelFurnace;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryFurnace;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.net.packet.Packet;
import net.minecraft.core.net.packet.PacketTileEntityData;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;
import silveon22.deep.DEEPRecipes;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.block.LookupFuelFreezer;
import silveon22.deep.block.misc.BlockLogicFreezer;
import silveon22.deep.recipe.RecipeEntryFreezer;

public class TileEntityFreezer extends TileEntity implements Container {
	private final Random random = new Random();
	protected ItemStack[] freezerItemStacks = new ItemStack[3];
	public int maxBurnTime = 0;
	public int currentCookTime = 0;
	public int maxCookTime = 200;
	public int currentBurnTime = 0;

	public TileEntityFreezer() {
	}

	public int getContainerSize() {
		return this.freezerItemStacks.length;
	}

	public @Nullable ItemStack getItem(int index) {
		return this.freezerItemStacks[index];
	}

	public @Nullable ItemStack removeItem(int index, int takeAmount) {
		if (this.freezerItemStacks[index] != null) {
			if (this.freezerItemStacks[index].stackSize <= takeAmount) {
				ItemStack itemstack = this.freezerItemStacks[index];
				this.freezerItemStacks[index] = null;
				if (this.worldObj != null && index == 2) {
					this.worldObj.markBlockNeedsUpdate(this.x, this.y, this.z);
				}

				return itemstack;
			} else {
				ItemStack itemstack1 = this.freezerItemStacks[index].splitStack(takeAmount);
				if (this.freezerItemStacks[index].stackSize <= 0) {
					this.freezerItemStacks[index] = null;
					if (this.worldObj != null && index == 2) {
						this.worldObj.markBlockNeedsUpdate(this.x, this.y, this.z);
					}
				}

				return itemstack1;
			}
		} else {
			return null;
		}
	}

	public void setItem(int index, @Nullable ItemStack itemstack) {
		this.freezerItemStacks[index] = itemstack;
		if (itemstack != null && itemstack.stackSize > this.getMaxStackSize()) {
			itemstack.stackSize = this.getMaxStackSize();
		}

		if (this.worldObj != null && index == 2 && itemstack == null) {
			this.worldObj.markBlockNeedsUpdate(this.x, this.y, this.z);
		}

	}

	public String getNameTranslationKey() {
		return "container.freezer.name";
	}

	public void readFromNBT(CompoundTag nbttagcompound) {
		super.readFromNBT(nbttagcompound);
		ListTag nbttaglist = nbttagcompound.getList("Items");
		this.freezerItemStacks = new ItemStack[this.getContainerSize()];

		for(int i = 0; i < nbttaglist.tagCount(); ++i) {
			CompoundTag nbttagcompound1 = (CompoundTag)nbttaglist.tagAt(i);
			byte byte0 = nbttagcompound1.getByte("Slot");
			if (byte0 >= 0 && byte0 < this.freezerItemStacks.length) {
				this.freezerItemStacks[byte0] = ItemStack.readItemStackFromNbt(nbttagcompound1);
			}
		}

		this.currentBurnTime = nbttagcompound.getShort("BurnTime");
		this.currentCookTime = nbttagcompound.getShort("CookTime");
		this.maxBurnTime = nbttagcompound.getShort("MaxBurnTime");
	}

	public void writeToNBT(CompoundTag nbttagcompound) {
		super.writeToNBT(nbttagcompound);
		nbttagcompound.putShort("BurnTime", (short)this.currentBurnTime);
		nbttagcompound.putShort("CookTime", (short)this.currentCookTime);
		nbttagcompound.putShort("MaxBurnTime", (short)this.maxBurnTime);
		ListTag nbttaglist = new ListTag();

		for(int i = 0; i < this.freezerItemStacks.length; ++i) {
			if (this.freezerItemStacks[i] != null) {
				CompoundTag nbttagcompound1 = new CompoundTag();
				nbttagcompound1.putByte("Slot", (byte)i);
				this.freezerItemStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.addTag(nbttagcompound1);
			}
		}

		nbttagcompound.put("Items", nbttaglist);
	}

	public int getMaxStackSize() {
		return 64;
	}

	public int getCookProgressScaled(int i) {
		return this.maxCookTime == 0 ? 0 : this.currentCookTime * i / this.maxCookTime;
	}

	public int getBurnTimeRemainingScaled(int i) {
		return this.maxBurnTime == 0 ? 0 : this.currentBurnTime * i / this.maxBurnTime;
	}

	public boolean isBurning() {
		return this.currentBurnTime > 0;
	}

	public void tick() {
		boolean isBurnTimeHigherThan0 = this.currentBurnTime > 0;
		boolean freezerUpdated = false;
		if (this.currentBurnTime > 0) {
			--this.currentBurnTime;
		}

		if (this.worldObj == null || !this.worldObj.isClientSide) {
			if ((this.worldObj == null || this.worldObj.getBlockId(this.x, this.y, this.z) == DEEPBlocks.freezerIdle.id()) && this.currentBurnTime == 0 && this.freezerItemStacks[0] == null && this.freezerItemStacks[1] != null && this.freezerItemStacks[1].itemID == Blocks.PERMAICE.id()) {
				--this.freezerItemStacks[1].stackSize;
				if (this.freezerItemStacks[1].stackSize <= 0) {
					this.freezerItemStacks[1] = null;
				}

				this.updateFreezer(true);
				freezerUpdated = true;
			}

			if (this.currentBurnTime == 0 && this.freezerItemStacks[1] != null && this.canSmelt()) {
				this.maxBurnTime = this.currentBurnTime = this.getBurnTimeFromItem(this.freezerItemStacks[1]);
				if (this.currentBurnTime > 0) {
					freezerUpdated = true;
					if (this.freezerItemStacks[1] != null) {
						if (this.freezerItemStacks[1].getItem() == Items.BUCKET_LAVA) {
							this.freezerItemStacks[1] = new ItemStack(Items.BUCKET);
						} else {
							--this.freezerItemStacks[1].stackSize;
							if (this.freezerItemStacks[1].stackSize <= 0) {
								this.freezerItemStacks[1] = null;
							}
						}
					}
				}
			}

			if (this.isBurning() && this.canSmelt()) {
				++this.currentCookTime;
				if (this.currentCookTime == this.maxCookTime) {
					this.currentCookTime = 0;
					this.smeltItem();
					freezerUpdated = true;
				}
			} else {
				this.currentCookTime = 0;
			}

			if (isBurnTimeHigherThan0 != this.currentBurnTime > 0) {
				freezerUpdated = true;
				this.updateFreezer(false);
			}
		}

		if (freezerUpdated) {
			this.setChanged();
		}

	}

	private boolean canSmelt() {
		if (this.freezerItemStacks[0] == null) {
			return false;
		} else {
			List<RecipeEntryFreezer> list = DEEPRecipes.getAllRecipesOfType(RecipeEntryFreezer.class);
			ItemStack itemstack = null;

			for(RecipeEntryFreezer recipeEntryBase : list) {
				if (recipeEntryBase != null && recipeEntryBase.matches(this.freezerItemStacks[0])) {
					itemstack = (ItemStack)recipeEntryBase.getOutput();
				}
			}

			if (itemstack == null) {
				return false;
			} else if (this.freezerItemStacks[2] == null) {
				return true;
			} else if (!this.freezerItemStacks[2].isItemEqual(itemstack)) {
				return false;
			} else if (this.freezerItemStacks[2].stackSize < this.getMaxStackSize() && this.freezerItemStacks[2].stackSize < this.freezerItemStacks[2].getMaxStackSize()) {
				return true;
			} else {
				return this.freezerItemStacks[2].stackSize < itemstack.getMaxStackSize();
			}
		}
	}

	public void smeltItem() {
		if (this.canSmelt()) {
			List<RecipeEntryFreezer> list = DEEPRecipes.getAllRecipesOfType(RecipeEntryFreezer.class);
			ItemStack itemstack = null;

			for(RecipeEntryFreezer recipeEntryBase : list) {
				if (recipeEntryBase != null && recipeEntryBase.matches(this.freezerItemStacks[0])) {
					itemstack = (ItemStack)recipeEntryBase.getOutput();
				}
			}

			boolean wasEmpty = this.freezerItemStacks[2] == null;
			if (this.freezerItemStacks[2] == null && itemstack != null) {
				this.freezerItemStacks[2] = itemstack.copy();
			} else if (this.freezerItemStacks[2] != null && itemstack != null && this.freezerItemStacks[2].itemID == itemstack.itemID) {
				ItemStack var10000 = this.freezerItemStacks[2];
				var10000.stackSize += itemstack.stackSize;
			}

			--this.freezerItemStacks[0].stackSize;
			if (this.freezerItemStacks[0].stackSize <= 0) {
				this.freezerItemStacks[0] = null;
			}

			if (this.worldObj != null && wasEmpty && this.freezerItemStacks[2] != null) {
				this.worldObj.markBlockNeedsUpdate(this.x, this.y, this.z);
			}

		}
	}

	protected void updateFreezer(boolean forceLit) {
		if (this.worldObj != null) {
			BlockLogicFreezer.updateFreezerBlockState(forceLit | this.currentBurnTime > 0, this.worldObj, this.x, this.y, this.z);
		} else if (this.carriedBlock != null) {
			this.carriedBlock.blockId = forceLit | this.currentBurnTime > 0 ? DEEPBlocks.freezerActive.id() : DEEPBlocks.freezerIdle.id();
		}

	}

	private int getBurnTimeFromItem(ItemStack itemStack) {
		return itemStack == null ? 0 : (((LookupFuelFreezer.instance.getFuelYield(itemStack.getItem().id))) / 2);
	}

	public boolean stillValid(Player entityplayer) {
		if (this.worldObj != null && this.worldObj.getTileEntity(this.x, this.y, this.z) == this) {
			return entityplayer.distanceToSqr((double)this.x + (double)0.5F, (double)this.y + (double)0.5F, (double)this.z + (double)0.5F) <= (double)64.0F;
		} else {
			return false;
		}
	}

	public void dropContents(World world, int x, int y, int z) {
		super.dropContents(world, x, y, z);
		if (!BlockLogicFreezer.keepFurnaceInventory) {
			for(int l = 0; l < this.getContainerSize(); ++l) {
				ItemStack itemstack = this.getItem(l);
				if (itemstack != null) {
					float f = this.random.nextFloat() * 0.8F + 0.1F;
					float f1 = this.random.nextFloat() * 0.8F + 0.1F;
					float f2 = this.random.nextFloat() * 0.8F + 0.1F;

					while(itemstack.stackSize > 0) {
						int i1 = this.random.nextInt(21) + 10;
						if (i1 > itemstack.stackSize) {
							i1 = itemstack.stackSize;
						}

						itemstack.stackSize -= i1;
						EntityItem entityItem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.itemID, i1, itemstack.getMetadata()));
						float f3 = 0.05F;
						entityItem.xd = (double)((float)this.random.nextGaussian() * f3);
						entityItem.yd = (double)((float)this.random.nextGaussian() * f3 + 0.2F);
						entityItem.zd = (double)((float)this.random.nextGaussian() * f3);
						world.entityJoinedWorld(entityItem);
					}
				}
			}
		}

	}

	public Packet getDescriptionPacket() {
		return this.freezerItemStacks[2] != null ? new PacketTileEntityData(this) : null;
	}

	public void sortContainer() {
	}

	public void heldTick(World world, Entity holder) {
		this.tick();
	}

	public boolean tryPlace(World world, Entity holder, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		boolean success = super.tryPlace(world, holder, blockX, blockY, blockZ, side, xPlaced, yPlaced);
		if (success) {
			this.updateFreezer(false);
		}

		return success;
	}

	public boolean canBeCarried(World world, Entity potentialHolder) {
		return true;
	}

	public CarriedBlock getCarriedEntry(World world, Entity holder, Block<?> currentBlock, int currentMeta) {
		return super.getCarriedEntry(world, holder, currentBlock, currentMeta & -8 | 2);
	}
}
