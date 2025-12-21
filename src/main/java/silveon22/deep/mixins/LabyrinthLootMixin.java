package silveon22.deep.mixins;

import net.minecraft.core.WeightedRandomBag;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.generate.feature.WorldFeatureLabyrinth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.item.DEEPItems;

import java.util.Random;
@Mixin(value = WorldFeatureLabyrinth.class, remap = false)
public class LabyrinthLootMixin {
	@Shadow
	public WeightedRandomBag<WeightedRandomLootObject> chestLoot;
	@Shadow
	public ItemStack treasureItem;

	@Inject(method = "place", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/WeightedRandomBag;addEntry(Ljava/lang/Object;D)V", ordinal = 0))
	private void addLoot(final World world, final Random random, final int x, final int y, final int z, final CallbackInfoReturnable<Boolean> cir){
		this.chestLoot.addEntry(new WeightedRandomLootObject(DEEPItems.ingotLead.getDefaultStack(), 1, 6), (double)100.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(DEEPItems.ingotSilver.getDefaultStack(), 1, 4), (double)100.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(DEEPItems.ammoKnifeSilver.getDefaultStack(), 5, 30), (double)50.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Items.ROPE.getDefaultStack(), 5, 30), (double)50.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.TNT.getDefaultStack(), 2, 6), (double)50.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.RAIL.getDefaultStack(), 12, 24), (double)50.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.RAIL_POWERED.getDefaultStack(), 6, 12), (double)25.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(DEEPItems.silverApple.getDefaultStack(), 1,3), 1.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(DEEPItems.amethyst.getDefaultStack(), 1, 4), (double)2.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(DEEPItems.bismuth.getDefaultStack(), 1, 4), (double)1.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.PUMICE_DRY.getDefaultStack(), 1, 4), (double)5.0F);
	}

//	@Inject(method = "place", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/world/generate/feature/WorldFeatureLabyrinth;canReplace(Lnet/minecraft/core/world/World;III)Z"))
//	private void addTreasure(final World world, final Random random, final int x, final int y, final int z, final CallbackInfoReturnable<Boolean> cir){
//		Biome biome = world.getBlockBiome(x, y, z);
//		if (biome == Biomes.OVERWORLD_DESERT || biome == Biomes.OVERWORLD_OUTBACK) {
//			this.treasureItem = Items.ARMOR_QUIVER_GOLD.getDefaultStack();
//		}
//	}
}
