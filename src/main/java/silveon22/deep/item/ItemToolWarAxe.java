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
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

import java.util.HashMap;
import java.util.Map;

public class ItemToolWarAxe extends ItemTool {
	private int weaponDamage;
	private ToolMaterial material;

	public static Map<Block, Integer> miningLevels = new HashMap();

	public ItemToolWarAxe(String name, String namespaceID, int id, ToolMaterial enumtoolmaterial) {
		super(name, namespaceID, id, 2, enumtoolmaterial, BlockTags.MINEABLE_BY_AXE);
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
			return block.hasTag(BlockTags.MINEABLE_BY_SWORD) || block.hasTag(BlockTags.MINEABLE_BY_AXE);
		}
	}

	//sword
	public float getStrVsBlock(ItemStack itemstack, Block block) {
		return block.hasTag(BlockTags.MINEABLE_BY_SWORD) || block.hasTag(BlockTags.MINEABLE_BY_AXE) ? this.material.getEfficiency(false) : 1.0F;
	}

	public boolean hitEntity(ItemStack itemstack, Mob entityliving, Mob entityliving1) {
		itemstack.damageItem(1, entityliving1);
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

	//axe
	public boolean beforeDestroyBlock(World world, ItemStack itemStack, int blockId, int x, int y, int z, Side side, Player player) {
		if (!world.isClientSide && (Boolean)world.getGameRuleValue(GameRules.TREECAPITATOR) && !player.isSneaking()) {
			int id = world.getBlockId(x, y, z);
			if (Block.hasLogicClass(Blocks.getBlock(id), BlockLogicLog.class)) {
				return !(new TreecapitatorHelper(world, x, y, z, player)).chopTree();
			}
		}
		return true;
	}

	}
