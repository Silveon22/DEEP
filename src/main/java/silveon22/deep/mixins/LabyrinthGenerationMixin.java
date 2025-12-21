package silveon22.deep.mixins;

import net.minecraft.core.world.generate.feature.WorldFeatureLabyrinth;
import net.minecraft.core.WeightedRandomBag;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.item.DEEPItems;

import java.util.Random;

@Mixin(value = WorldFeatureLabyrinth.class, remap = false)
public class LabyrinthGenerationMixin {

	@Shadow
	int wallBlockA;
	@Shadow
	int wallBlockB;
	@Shadow
	int brickBlockA;
	@Shadow
	int brickBlockB;
	@Shadow
	int slabBlock;
	@Shadow
	public ItemStack treasureItem;
	@Shadow
	public WeightedRandomBag<String> spawnerMonsters;

	@Unique
	private boolean isHot;
	@Unique
	private boolean isWet;
	@Shadow
	boolean isCold;

	@Inject(method = "place", at = @At("HEAD"))
	public void generate(World world, Random random, int x, int y, int z, CallbackInfoReturnable<Boolean> cir) {
		Biome biome = world.getBlockBiome(x, y, z);
			if (biome == Biomes.OVERWORLD_DESERT || biome == Biomes.OVERWORLD_OUTBACK) {
				this.isHot = true;
			}
			if (biome == Biomes.OVERWORLD_SWAMPLAND || biome == Biomes.OVERWORLD_SWAMPLAND_MUDDY || biome == Biomes.OVERWORLD_RAINFOREST) {
				this.wallBlockA = Blocks.MUD_BAKED.id();
				this.wallBlockB = DEEPBlocks.packedMudBrick.id();
				this.brickBlockA = Blocks.LOG_OAK.id();
				this.brickBlockB = Blocks.LOG_OAK_MOSSY.id();
				this.slabBlock = Blocks.LEAVES_OAK.id();
				this.isWet = true;
			}
		}
	@Inject(method = "place", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/world/generate/feature/WorldFeatureLabyrinth;canReplace(Lnet/minecraft/core/world/World;III)Z"))
	public void generateTreasure(World world, Random random, int x, int y, int z, CallbackInfoReturnable<Boolean> cir) {
		if (this.isHot) {
			this.spawnerMonsters.addEntry("Skeleton", (double)100.0F);
			this.spawnerMonsters.addEntry("deep:outback_zombie", (double)100.0F);
			this.spawnerMonsters.addEntry("Spider", 100.0);
			this.spawnerMonsters.addEntry("deep:elder_skeleton", (double)200.0F);
			this.treasureItem = DEEPBlocks.statueBastBottom.getDefaultStack();
		}
		if (this.isWet) {
			this.spawnerMonsters.addEntry("Skeleton", (double)100.0F);
			this.spawnerMonsters.addEntry("deep:beetle", (double)100.0F);
			this.spawnerMonsters.addEntry("Creeper", 100.0);
			this.spawnerMonsters.addEntry("deep:cave_creeper", (double)200.0F);
			this.treasureItem = DEEPItems.divingHelmet.getDefaultStack();
		}
		if (!this.isWet && !this.isHot && !this.isCold) {
			int a = random.nextInt(2);
			this.spawnerMonsters.addEntry("deep:werewolf", (double)1.0F);
			if (a == 1) {
				this.treasureItem = DEEPItems.armorBandolierEndless.getDefaultStack();
			}
		}
	}
}
