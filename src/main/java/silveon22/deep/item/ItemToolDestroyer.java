package silveon22.deep.item;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicLog;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.gamerule.GameRules;
import net.minecraft.core.data.gamerule.TreecapitatorHelper;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.player.inventory.slot.Slot;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

import java.util.HashMap;
import java.util.Map;

public class ItemToolDestroyer extends ItemTool {
		private int weaponDamage;
		private ToolMaterial material;

		public static Map<Block, Integer> miningLevels = new HashMap();

		public ItemToolDestroyer(String name, String namespaceID, int id, ToolMaterial enumtoolmaterial) {
			super(name, namespaceID, id, 2, enumtoolmaterial, BlockTags.MINEABLE_BY_PICKAXE);
			this.maxStackSize = 1;
			this.setMaxDamage(enumtoolmaterial.getDurability());
			this.weaponDamage = 4 + enumtoolmaterial.getDamage() * 2;
			this.material = enumtoolmaterial;
		}

		public boolean canHarvestBlock(Mob entityLiving, ItemStack itemStack, Block block) {
			Integer miningLevel = (Integer)miningLevels.get(block);
			if (miningLevel != null) {
				return this.material.getMiningLevel() >= miningLevel;
			} else {
				return block.hasTag(BlockTags.MINEABLE_BY_PICKAXE) || block.hasTag(BlockTags.MINEABLE_BY_SHOVEL);
			}
		}

		//sword
		public float getStrVsBlock(ItemStack itemstack, Block block) {
			return block.hasTag(BlockTags.MINEABLE_BY_PICKAXE) || block.hasTag(BlockTags.MINEABLE_BY_SHOVEL) ? this.material.getEfficiency(false) : 1.0F;
		}

		public boolean hitEntity(ItemStack itemstack, Mob entityliving, Mob entityliving1) {
			itemstack.damageItem(2, entityliving1);
			return true;
		}

		public boolean onBlockDestroyed(World world, ItemStack itemstack, int i, int j, int k, int l, Side side, Mob entityliving) {
			Block block = Blocks.blocksList[i];
			if (block != null && (block.getHardness() > 0.0F || this.isSilkTouch())) {
				itemstack.damageItem(1, entityliving);
			}
			return true;
		}

		public int getDamageVsEntity(Entity entity, ItemStack is) {
			return this.weaponDamage;
		}

		public boolean isSilkTouch() {
			return this.material.isSilkTouch();
		}

		//pickaxe
		static {
			miningLevels.put(Blocks.OBSIDIAN, 3);
			miningLevels.put(Blocks.BLOCK_DIAMOND, 2);
			miningLevels.put(Blocks.ORE_DIAMOND_STONE, 2);
			miningLevels.put(Blocks.ORE_DIAMOND_BASALT, 2);
			miningLevels.put(Blocks.ORE_DIAMOND_GRANITE, 2);
			miningLevels.put(Blocks.ORE_DIAMOND_LIMESTONE, 2);
			miningLevels.put(Blocks.BLOCK_GOLD, 2);
			miningLevels.put(Blocks.ORE_GOLD_STONE, 2);
			miningLevels.put(Blocks.ORE_GOLD_BASALT, 2);
			miningLevels.put(Blocks.ORE_GOLD_GRANITE, 2);
			miningLevels.put(Blocks.ORE_GOLD_LIMESTONE, 2);
			miningLevels.put(Blocks.BLOCK_IRON, 1);
			miningLevels.put(Blocks.ORE_IRON_STONE, 1);
			miningLevels.put(Blocks.ORE_IRON_BASALT, 1);
			miningLevels.put(Blocks.ORE_IRON_GRANITE, 1);
			miningLevels.put(Blocks.ORE_IRON_LIMESTONE, 1);
			miningLevels.put(Blocks.BLOCK_STEEL, 2);
			miningLevels.put(Blocks.ORE_NETHERCOAL_NETHERRACK, 2);
			miningLevels.put(Blocks.BLOCK_LAPIS, 1);
			miningLevels.put(Blocks.ORE_LAPIS_STONE, 1);
			miningLevels.put(Blocks.ORE_LAPIS_BASALT, 1);
			miningLevels.put(Blocks.ORE_LAPIS_GRANITE, 1);
			miningLevels.put(Blocks.ORE_LAPIS_LIMESTONE, 1);
			miningLevels.put(Blocks.BLOCK_REDSTONE, 2);
			miningLevels.put(Blocks.ORE_REDSTONE_STONE, 2);
			miningLevels.put(Blocks.ORE_REDSTONE_BASALT, 2);
			miningLevels.put(Blocks.ORE_REDSTONE_GRANITE, 2);
			miningLevels.put(Blocks.ORE_REDSTONE_LIMESTONE, 2);
			miningLevels.put(Blocks.ORE_REDSTONE_GLOWING_STONE, 2);
			miningLevels.put(Blocks.ORE_REDSTONE_GLOWING_BASALT, 2);
			miningLevels.put(Blocks.ORE_REDSTONE_GLOWING_GRANITE, 2);
			miningLevels.put(Blocks.ORE_REDSTONE_GLOWING_LIMESTONE, 2);
		}

	}
