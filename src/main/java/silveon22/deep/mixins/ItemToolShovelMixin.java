package silveon22.deep.mixins;

import java.util.Random;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntityActivator;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.item.tool.ItemToolShovel;
import net.minecraft.core.player.inventory.slot.Slot;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.block.misc.BlockLogicPathSand;
import silveon22.deep.item.DEEPItems;

@Mixin(value = ItemToolShovel.class, remap = false)
public class ItemToolShovelMixin {
	@Inject(method = "onUseItemOnBlock", at = @At(value = "HEAD"), cancellable = true)
	public void addNewPathBlock(ItemStack itemstack, Player entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced, CallbackInfoReturnable<Boolean> cir){
		int blockId = world.getBlockId(blockX,blockY,blockZ);
		int blockAbove = world.getBlockId(blockX,blockY + 1,blockZ);
		if (side != Side.BOTTOM && blockAbove == 0 && (blockId == Blocks.SAND.id())) {
			world.playBlockSoundEffect(null, (float)blockX + 0.5f, (float)blockY + 0.5f, (float)blockZ + 0.5f, DEEPBlocks.sandPath, EnumBlockSoundEffectType.PLACE);
			if (!world.isClientSide) {
				world.setBlockWithNotify(blockX, blockY, blockZ, DEEPBlocks.sandPath.id());
				itemstack.damageItem(1, entityplayer);
			}
			cir.setReturnValue(true);
		}
		else if (side != Side.BOTTOM && blockAbove == 0 && (blockId == Blocks.DIRT_SCORCHED.id() || blockId == Blocks.GRASS_SCORCHED.id())) {
			world.playBlockSoundEffect(null, (float)blockX + 0.5f, (float)blockY + 0.5f, (float)blockZ + 0.5f, DEEPBlocks.scorchedDirtPath, EnumBlockSoundEffectType.PLACE);
			if (!world.isClientSide) {
				world.setBlockWithNotify(blockX, blockY, blockZ, DEEPBlocks.scorchedDirtPath.id());
				itemstack.damageItem(1, entityplayer);
			}
			cir.setReturnValue(true);
		}
	}
}
