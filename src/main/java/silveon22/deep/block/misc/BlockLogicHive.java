package silveon22.deep.block.misc;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.BlockLogicTransparent;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.MobSpider;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;
import silveon22.deep.DeepAchievements;
import silveon22.deep.mob.MobWasp;

import static net.minecraft.core.enums.EnumDropCause.*;

public class BlockLogicHive extends BlockLogic {
	public BlockLogicHive(Block<?> block, Material material) {
		super(block, material);
	}

	public ItemStack @Nullable [] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case SILK_TOUCH:
			case PICK_BLOCK:
			case PROPER_TOOL:
			case EXPLOSION:
			case PISTON_CRUSH:
				if (world.rand.nextInt(4)==0) {
					if (!world.isClientSide) {
						MobWasp mobWasp = new MobWasp(world);
						mobWasp.moveTo(x + 0.5, y + (double)0.5, z + 0.5, world.rand.nextFloat() * 360.0F, world.rand.nextFloat() * 360.0F);
						world.entityJoinedWorld(mobWasp);
						world.playSoundEffect((Entity)null, SoundCategory.WORLD_SOUNDS, (double)x + (double)0.5F, (double)y + 0.5, (double)z + (double)0.5F, "mob.slime", 1F, 0.7F);

					}
				}
				else {
					return new ItemStack[]{new ItemStack(this)};
				}
			case WORLD:
			default:
				return new ItemStack[]{new ItemStack(this)};
		}
	}
}
