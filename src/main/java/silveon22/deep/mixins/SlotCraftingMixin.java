package silveon22.deep.mixins;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.slot.SlotResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silveon22.deep.DeepAchievements;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.item.DEEPItems;


@Mixin(value = SlotResult.class, remap = false)
public abstract class SlotCraftingMixin {
	@Shadow
	private Player thePlayer;
	@Inject(method = "onTake", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/item/ItemStack;onCrafting(Lnet/minecraft/core/world/World;Lnet/minecraft/core/entity/player/Player;)V", shift = At.Shift.AFTER))
	public void addCraftingAchievements(ItemStack itemstack, CallbackInfo ci){
		if (itemstack.itemID == DEEPBlocks.freezerIdle.id()) {
			thePlayer.addStat(DeepAchievements.CRAFT_FREEZER, 1);
		}
	}
}
