package silveon22.deep.compat.fishing;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.entity.EntityFishingBobber;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFishingRod;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silveon22.deep.item.DEEPItems;

@Mixin(value = EntityFishingBobber.class, remap = false)
public class EntityFishingBobberMixin {

	@WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/item/ItemStack;getItem()Lnet/minecraft/core/item/Item;"))
	private Item wrap(ItemStack heldItem, Operation<Item> original) {
		return heldItem.getItem() instanceof ItemFishingRod ? Items.TOOL_FISHINGROD : original.call(heldItem);
	}
	@Shadow
	private int ticksCatchable;
	@Unique
	private int ticksCatchableInitial;

	@Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/world/World;playSoundAtEntity(Lnet/minecraft/core/entity/Entity;Lnet/minecraft/core/entity/Entity;Ljava/lang/String;FF)V"))
	public void cacheValue(CallbackInfo ci) {
		this.ticksCatchableInitial = (int) (ticksCatchable / 3.0F);
	}

	@WrapOperation(method = "yoink", at = @At(value = "FIELD", target = "Lnet/minecraft/core/item/Items;FOOD_FISH_RAW:Lnet/minecraft/core/item/Item;"))
	private Item modItem(Operation<Item> original) {
		if (this.ticksCatchable > ticksCatchableInitial * 2.5) {
			return DEEPItems.rawBass;
		}
		else if(this.ticksCatchable > ticksCatchableInitial * 1.7) {
			return original.call();
		}
		else {
			return DEEPItems.rawSardine;
		}
	}
}
