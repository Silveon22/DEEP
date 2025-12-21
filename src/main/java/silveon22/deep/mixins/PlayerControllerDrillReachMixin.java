package silveon22.deep.mixins;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.controller.PlayerController;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import silveon22.deep.item.ItemToolDrill;

@Mixin(value = PlayerController.class, remap = false)
public class PlayerControllerDrillReachMixin {

	@Final
	@Shadow
	protected Minecraft mc;

	@Unique
	public boolean held_item_is_drill(Player player) {
		ItemStack held = player.getHeldItem();
		if (held == null)
			return false;
		else if (held.getItem() instanceof ItemToolDrill) {
			return true;
		} else return held.getItem() instanceof ItemToolDrill;
	}

	@ModifyReturnValue(method = "getBlockReachDistance", at=@At("RETURN"))
	public float getBlockReachDistance(float original) {
		return original - (held_item_is_drill(this.mc.thePlayer) ? 2.5F : 0);
	}

	@ModifyReturnValue(method = "getEntityReachDistance", at=@At("RETURN"))
	public float getEntityReachDistance(float original) {
		return original - (held_item_is_drill(this.mc.thePlayer) ? 2.5F : 0);
	}
}
