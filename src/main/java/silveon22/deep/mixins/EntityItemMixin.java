package silveon22.deep.mixins;


import net.minecraft.core.achievement.Achievements;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silveon22.deep.DeepAchievements;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.item.DEEPItems;

@Mixin(value = EntityItem.class, remap = false)
public abstract class EntityItemMixin {
	@Unique
	public ItemStack item;

	@Inject(method = "playerTouch", at = @At("TAIL"), cancellable = true)
	public void playerTouch(Player player, CallbackInfo ci) {
		if (this.item.itemID == DEEPItems.amethyst.id) {
			player.addStat(DeepAchievements.OBTAIN_AMETHYST, 1);
		}
		if (this.item.itemID == DEEPItems.uranium.id) {
			player.addStat(DeepAchievements.OBTAIN_URANIUM, 1);
		}
		if (this.item.itemID == DEEPItems.adamantite.id) {
			player.addStat(DeepAchievements.OBTAIN_ADAMANTITE, 1);
		}
		if (this.item.itemID == DEEPItems.cryocoal.id) {
			player.addStat(DeepAchievements.OBTAIN_CRYOCOAL, 1);
		}
		if (this.item.itemID == DEEPItems.rhodonite.id) {
			player.addStat(DeepAchievements.OBTAIN_RHODONITE, 1);
		}
		if ((this.item.itemID == DEEPBlocks.abyssalriteCobbled.id() || this.item.itemID == DEEPBlocks.pearlstoneCobbled.id() || this.item.itemID == DEEPBlocks.peridotiteCobbled.id() || this.item.itemID == DEEPBlocks.scorchedSandstone.id()) && player.getStat(DEEPBlocks.abyssalriteCobbled.asItem().getStat("stat_picked_up")) > 0 && player.getStat(DEEPBlocks.pearlstoneCobbled.asItem().getStat("stat_picked_up")) > 0 && player.getStat(DEEPBlocks.peridotiteCobbled.asItem().getStat("stat_picked_up")) > 0 && player.getStat(DEEPBlocks.scorchedSandstone.asItem().getStat("stat_picked_up")) > 0) {
			player.addStat(DeepAchievements.NEAPOLITAN_2, 1);
		}
		if (this.item.itemID == DEEPItems.honeycomb.id) {
			player.addStat(DeepAchievements.OBTAIN_HONEYCOMB, 1);
		}
		if (this.item.itemID == DEEPItems.rawBass.id) {
			player.addStat(DeepAchievements.BIG_ONE, 1);
		}
	}
}
