package silveon22.deep.mixins;

import net.minecraft.client.gui.guidebook.GuidebookSections;
import net.minecraft.client.gui.guidebook.smelting.GuidebookSectionSmelting;
import net.minecraft.core.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silveon22.deep.Guidebook.GuidebookSectionBaking;
import silveon22.deep.Guidebook.GuidebookSectionFreezing;
import silveon22.deep.block.DEEPBlocks;

@Mixin(value = GuidebookSections.class, remap = false)
public abstract class GuidebookSectionMixin {

	@Unique
	private static boolean includedDEEPSections = false;

	@Inject(method = "init", at = @At("TAIL"))
	private static void includeAetherSection(CallbackInfo ci) {
		if (includedDEEPSections) {
			return;
		}
		includedDEEPSections = true;
		GuidebookSections.register(new GuidebookSectionBaking("deep.guidebook.section.brick.oven", new ItemStack(DEEPBlocks.brickOvenActive), 0x7c4536, 0xb5a39d));
		GuidebookSections.register(new GuidebookSectionFreezing("deep.guidebook.section.freezer", new ItemStack(DEEPBlocks.freezerActive), 0x7ea0a3, 0xc6dcdf));
	}}

