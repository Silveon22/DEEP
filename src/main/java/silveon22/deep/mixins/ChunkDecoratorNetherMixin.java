package silveon22.deep.mixins;

import net.minecraft.core.block.BlockLogicSand;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.perlin.nether.ChunkDecoratorNether;
import net.minecraft.core.world.generate.feature.WorldFeatureDungeon;
import net.minecraft.core.world.generate.feature.WorldFeatureLabyrinth;
import net.minecraft.core.world.generate.feature.WorldFeatureLake;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.block.ore.BlockLogicUraniumOre;

import java.util.Random;

@Mixin(value = ChunkDecoratorNether.class, remap = false)
public class ChunkDecoratorNetherMixin {
	@Shadow
	@Final
	private World world;

	@Inject(method = "decorate(Lnet/minecraft/core/world/chunk/Chunk;)V", at = @At(value = "TAIL"))
	public void addCustomOre(Chunk chunk, CallbackInfo ci) {
		BlockLogicSand.fallInstantly = true;

		int chunkX = chunk.xPosition;
		int chunkZ = chunk.zPosition;
		int minY = this.world.getWorldType().getMinY();
		int maxY = this.world.getWorldType().getMaxY();
		int rangeY = maxY + 1 - minY;
		Random rand = new Random((long)chunkX * 341873128712L + (long)chunkZ * 132897987541L);

		BlockLogicSand.fallInstantly = true;
		int x = chunkX * 16;
		int z = chunkZ * 16;

		for(int i = 0; i < 10; ++i) {
			int xf = x + rand.nextInt(16);
			int yf = minY + rand.nextInt(rangeY - 8) + 4;
			int zf = z + rand.nextInt(16);
			(new WorldFeatureOre(Blocks.COBBLE_NETHERRACK_IGNEOUS.id(), 16)).place(this.world, rand, xf, yf, zf);
		}
		for(int i = 0; i < 15; ++i) {
			int xf = x + rand.nextInt(16);
			int yf = minY + rand.nextInt(rangeY - 8) + 4;
			int zf = z + rand.nextInt(16);
			(new WorldFeatureOre(Blocks.SOULSAND.id(), 24)).place(this.world, rand, xf, yf, zf);
		}

		for(int i = 0; i < 7; ++i) {
			int xb = x + rand.nextInt(16);
			int yb = minY + rand.nextInt(rangeY - 8) + 4;
			int zb = z + rand.nextInt(16);
			(new WorldFeatureOre(DEEPBlocks.soulsandRaging.id(), 24)).place(this.world, rand, xb, yb, zb);
		}

		for(int i = 0; i < 20; ++i) {
			int xa = x + rand.nextInt(16);
			int ya = minY + rand.nextInt(rangeY - 8) + 4;
			int za = z + rand.nextInt(16);
			(new WorldFeatureOre(DEEPBlocks.netherrackRhodoniteOre.id(), 14)).place(this.world, rand, xa, ya, za);
		}

		for(int i = 0; i < 7; ++i) {
			int xm = x + rand.nextInt(16);
			int ym = minY + rand.nextInt(rangeY - 8) + 4;
			int zm = z + rand.nextInt(16);
			(new WorldFeatureOre(DEEPBlocks.netherrackSilverOre.id(), 7)).place(this.world, rand, xm, ym, zm);
		}

		for(int i = 0; i < 1; ++i) {
			int xm = x + rand.nextInt(16);
			int ym = minY + rand.nextInt(rangeY - 8) + 4;
			int zm = z + rand.nextInt(16);
			(new WorldFeatureOre(DEEPBlocks.netherrackAdamantiteOre.id(), 5)).place(this.world, rand, xm, ym, zm);
		}

		for(int i = 0; i < 5; ++i) {
			int xf = x + rand.nextInt(16);
			int yf = minY + rand.nextInt(rangeY - 8) + 4;
			int zf = z + rand.nextInt(16);
			(new WorldFeatureOre(DEEPBlocks.netherrackCryocoalOre.id(), 12)).place(this.world, rand, xf, yf, zf);
		}

//		for(int i = 0; i < 4	; ++i) {
//			int xm = x + rand.nextInt(16);
//			int ym = minY + rand.nextInt(rangeY - 8) + 4;
//			int zm = z + rand.nextInt(16);
//			(new WorldFeatureOre(DEEPBlocks.netherrackMagnetOre.id(), 7)).place(this.world, rand, xm, ym, zm);
//		}

		BlockLogicSand.fallInstantly = false;
	}
}
