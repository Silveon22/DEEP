package silveon22.deep.mixins;

import net.minecraft.core.block.*;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.perlin.overworld.ChunkDecoratorOverworld;
import net.minecraft.core.world.generate.feature.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.block.ore.*;
import silveon22.deep.worldfeatures.*;

import java.util.Random;

@Mixin(value = ChunkDecoratorOverworld.class, remap = false)
public class ChunkDecoratorOverworldMixin {
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
		float oreHeightModifier = (float)rangeY / 128.0F;
		Random rand = new Random((long)chunkX * 341873898712L + (long)chunkZ * 132696981241L);

		BlockLogicSand.fallInstantly = true;
		int x = chunkX * 16;
		int z = chunkZ * 16;
		int y = this.world.getHeightValue(x + 16, z + 16);
		Biome biome = this.world.getBlockBiome(x + 16, y, z + 16);

		for(int i4 = 0; (float)i4 < oreHeightModifier; ++i4) {
			int j7 = x + rand.nextInt(16);
			int k10 = minY + rand.nextInt(rangeY / 8);
			int j13 = z + rand.nextInt(16);
			(new WorldFeatureOre(BlockLogicAmethystOre.variantMap, 7)).place(this.world, rand, j7, k10, j13);
		}

		for(int k3 = 0; (float)k3 < 2.0F * oreHeightModifier; ++k3) {
			int l6 = x + rand.nextInt(16);
			int i10 = minY + rand.nextInt(rangeY / 6);
			int l12 = z + rand.nextInt(16);
			(new WorldFeatureOre(BlockLogicSilverOre.variantMap, 8)).place(this.world, rand, l6, i10, l12);
		}

		if (rand.nextInt(2) == 0) {
			for(int i4 = 0; (float)i4 < 0.5F * oreHeightModifier; ++i4) {
				int j7 = x + rand.nextInt(16);
				int k10 = minY + rand.nextInt(rangeY / 8);
				int j13 = z + rand.nextInt(16);
				(new WorldFeatureOre(BlockLogicUraniumOre.variantMap, 7)).place(this.world, rand, j7, k10, j13);
			}
		}

		for(int j3 = 0; (float)j3 < 8.0F * oreHeightModifier; ++j3) {
			int k6 = x + rand.nextInt(16);
			int l9 = minY + rand.nextInt(rangeY / 2);
			int k12 = z + rand.nextInt(16);
			(new WorldFeatureOre(BlockLogicLeadOre.variantMap, 5)).place(this.world, rand, k6, l9, k12);
		}

		if (rand.nextInt(4) == 0) {
			for(int a3 = 0; (float)a3 < oreHeightModifier; ++a3) {
				int b6 = x + rand.nextInt(16);
				int h9 = minY + rand.nextInt((rangeY / 16));
				int u12 = z + rand.nextInt(16);
				(new WorldFeatureOre(BlockLogicBismuthOre.variantMap, 7)).place(this.world, rand, b6, h9, u12);
			}
		}

		if (rand.nextInt(2) == 0) {
			int l15 = x + rand.nextInt(16) + 8;
			int l17 = minY + rand.nextInt(rangeY / 4);
			int l20 = z + rand.nextInt(16) + 8;
			(new WorldFeatureFlowers(DEEPBlocks.mushroomExplosive.id(), 32, false)).place(this.world, rand, l15, l17, l20);
		}

		if (rand.nextInt(2) == 0) {
			int l15 = x + rand.nextInt(16) + 8;
			int l17 = minY + rand.nextInt(rangeY / 2);
			int l20 = z + rand.nextInt(16) + 8;
			(new WorldFeatureFlowers(DEEPBlocks.mushroomBlue.id(), 64, false)).place(this.world, rand, l15, l17, l20);
		}

		if (rand.nextInt(4) == 0) {
			int l15 = x + rand.nextInt(16) + 8;
			int l17 = minY + rand.nextInt(rangeY / 2);
			int l20 = z + rand.nextInt(16) + 8;
			(new WorldFeatureFlowers(DEEPBlocks.mushroomGray.id(), 64, false)).place(this.world, rand, l15, l17, l20);
		}

		if (rand.nextInt(8) == 0) {
			int l15 = x + rand.nextInt(16) + 8;
			int l17 = minY + rand.nextInt(rangeY / 2);
			int l20 = z + rand.nextInt(16) + 8;
			(new WorldFeatureFlowers(DEEPBlocks.mushroomSilver.id(), 64, false)).place(this.world, rand, l15, l17, l20);
		}

		if (rand.nextInt(24) == 0) {
			int l15 = x + rand.nextInt(16) + 8;
			int l17 = minY + rand.nextInt(rangeY / 2);
			int l20 = z + rand.nextInt(16) + 8;
			(new WorldFeatureFlowers(DEEPBlocks.mushroomYellow.id(), 64, false)).place(this.world, rand, l15, l17, l20);
		}

		for(int k1 = 0; (float)k1 < oreHeightModifier; ++k1) {
			int l15 = x + rand.nextInt(16) + 8;
			int l17 = minY + rand.nextInt(rangeY / 5);
			int l20 = z + rand.nextInt(16) + 8;
			(new WorldFeatureFlowers(Blocks.COBWEB.id(), 24, false)).place(this.world, rand, l15, l17, l20);
		}

		if (rand.nextInt(2) == 0) {
			int l15 = x + rand.nextInt(16) + 8;
			int l17 = minY + rand.nextInt((int) (rangeY / 4));
			int l20 = z + rand.nextInt(16) + 8;
			(new WorldFeatureFlowers(DEEPBlocks.eggSpider.id(), 32, false)).place(this.world, rand, l15, l17, l20);
		}

		if (rand.nextInt(12) == 0) {
			int j16 = x + rand.nextInt(16) + 8;
			int j21 = z + rand.nextInt(16) + 8;
			int i22 = this.world.getHeightValue(j16, j21);
			(new WorldFeatureCoral()).place(this.world, rand, j16, i22, j21);
		}

		if (rand.nextInt(256) == 0) {
			int j16 = x + rand.nextInt(16) + 8;
			int j21 = z + rand.nextInt(16) + 8;
			int i22 = this.world.getHeightValue(j16, j21);
			(new WorldFeatureSalt()).place(this.world, rand, j16, i22, j21);
		}

		if (rand.nextInt(3) == 0 && world.getBlockHumidity(x, z) > 0.3) {
			int i18 = x + rand.nextInt(16) + 8;
			int i23 = z + rand.nextInt(16) + 8;
			int i21 = this.world.getHeightValue(i18, i23);
			(new WorldFeatureCattail()).place(this.world, rand, i18, i21, i23);
		}

		int oceanY = this.world.getWorldType().getOceanY();
		if (rand.nextInt(32) == 0 && world.getBlockHumidity(x, z) > 0.5 && world.getBlockTemperature(x, z) > 0.4) {
			int j16 = x + rand.nextInt(16) + 8;
			int j21 = z + rand.nextInt(16) + 8;
			(new WorldFeatureLilypad()).place(this.world, rand, j16, oceanY - 1, j21);
		}

		for(int k7 = 0; (float)k7 < 2F * oreHeightModifier; ++k7) {
			int r15 = x + rand.nextInt(16) + 8;
			int r17 = (int) (minY + (rangeY / 2.5F) + rand.nextInt((int) (rangeY / 3.5F)));
			int r20 = z + rand.nextInt(16) + 8;
			(new WorldFeatureFlowers(DEEPBlocks.root.id(), 64, false)).place(this.world, rand, r15, r17, r20);
		}

		if (rand.nextInt(4) == 0) {
			int z15 = x + rand.nextInt(16) + 8;
			int z17 = minY + rand.nextInt(rangeY / 5);
			int z20 = z + rand.nextInt(16) + 8;
			(new WorldFeatureFlowers(DEEPBlocks.crystalQuartz.id(), 64, false)).place(this.world, rand, z15, z17, z20);
		}

		for(int k2 = 0; (float)k2 < 3.5F * oreHeightModifier; ++k2) {
			int i6 = x + rand.nextInt(16);
			int j9 = minY + rand.nextInt(rangeY);
			int i12 = z + rand.nextInt(16);
			(new WorldFeatureOre(DEEPBlocks.silt.id(), 32)).place(this.world, rand, i6, j9, i12);
		}

		if ( world.getBlockTemperature(x, z) < 0.3) {
			for(int k2 = 0; (float)k2 < 5.0F * oreHeightModifier; ++k2) {
				int i6 = x + rand.nextInt(16);
				int j9 = minY + rand.nextInt(rangeY);
				int i12 = z + rand.nextInt(16);
				(new WorldFeatureOre(DEEPBlocks.slush.id(), 32)).place(this.world, rand, i6, j9, i12);
			}
		}

		if (biome == Biomes.OVERWORLD_DESERT || biome == Biomes.OVERWORLD_OUTBACK || biome == Biomes.OVERWORLD_OUTBACK_GRASSY) {
			for(int k2 = 0; (float)k2 < oreHeightModifier; ++k2) {
				int xf = x + rand.nextInt(16) + 8;
				int yf = minY + rand.nextInt((int) (rand.nextInt((int) (rangeY - rangeY / 2.1F)) + rangeY / 2.1F));
				int zf = z + rand.nextInt(16) + 8;
				if (yf < minY + rangeY / 2 || rand.nextInt(10) == 0) {
					(new WorldFeatureLake(Blocks.FLUID_LAVA_STILL.id())).place(this.world, rand, xf, yf, zf);
				}
			}

			for(int k2 = 0; (float)k2 < 4.0F * oreHeightModifier; ++k2) {
				int j7 = x + rand.nextInt(16);
				int k10 = minY + rand.nextInt(rangeY / 2);
				int j13 = z + rand.nextInt(16);
				(new WorldFeatureFossil(12 + rand.nextInt(12), DEEPBlocks.scorchedSandstone)).place(this.world, rand, j7, k10, j13);
			}

			for(int z1 = 0; (float)z1 < 3F * oreHeightModifier; ++z1) {
				int l15 = x + rand.nextInt(16) + 8;
				int l17 = minY + rand.nextInt((int) (rangeY / 2.2F));
				int l20 = z + rand.nextInt(16) + 8;
				(new WorldFeatureFlowers(DEEPBlocks.eggSpider.id(), 64, false)).place(this.world, rand, l15, l17, l20);
			}
		}

		if (rand.nextInt((int) (1024/2.5F)) == 0) {
			int i = x + rand.nextInt(16);
			int j = (minY + 24) + rand.nextInt(rangeY / 8);
			int k = z + rand.nextInt(16);
			new WorldFeatureGeode(Blocks.ORE_COAL_BASALT.id(),Blocks.BASALT.id(), Blocks.MARBLE.id(),30,(3 + rand.nextInt(3))).place(world, rand, i, j, k);
		}

		if (rand.nextInt((int) (1024/2.5F)) == 0) {
			int i = x + rand.nextInt(16);
			int j = (minY + 24) + rand.nextInt(rangeY / 8);
			int k = z + rand.nextInt(16);
			new WorldFeatureGeode(DEEPBlocks.abyssalriteLapisOre.id(),DEEPBlocks.abyssalrite.id(), Blocks.MARBLE.id(),30,(3 + rand.nextInt(3))).place(world, rand, i, j, k);
		}

		if (rand.nextInt((int) (1024/2)) == 0) {
			int i = x + rand.nextInt(16);
			int j = (minY + 24) + rand.nextInt(rangeY / 8);
			int k = z + rand.nextInt(16);
			new WorldFeatureGeode(Blocks.ORE_IRON_GRANITE.id(),Blocks.GRANITE.id(), Blocks.MARBLE.id(),30,(3 + rand.nextInt(3))).place(world, rand, i, j, k);
		}

		if (rand.nextInt((int) (1024)) == 0) {
			int i = x + rand.nextInt(16);
			int j = (minY + 24) + rand.nextInt(rangeY / 8);
			int k = z + rand.nextInt(16);
			new WorldFeatureGeode(Blocks.ORE_GOLD_LIMESTONE.id(),Blocks.LIMESTONE.id(), Blocks.MARBLE.id(),30,(3 + rand.nextInt(3))).place(world, rand, i, j, k);
		}

		if (rand.nextInt((int) (1024/2)) == 0) {
			int i = x + rand.nextInt(16);
			int j = (minY + 24) + rand.nextInt(rangeY / 8);
			int k = z + rand.nextInt(16);
			new WorldFeatureGeode(DEEPBlocks.pearlstoneLeadOre.id(),DEEPBlocks.pearlstone.id(), Blocks.MARBLE.id(),30,(3 + rand.nextInt(3))).place(world, rand, i, j, k);
		}

		if (rand.nextInt((int) (1024)) == 0) {
			int i = x + rand.nextInt(16);
			int j = (minY + 24) + rand.nextInt(rangeY / 8);
			int k = z + rand.nextInt(16);
			new WorldFeatureGeode(DEEPBlocks.abyssalriteSilverOre.id(),DEEPBlocks.abyssalrite.id(), Blocks.MARBLE.id(),30,(3 + rand.nextInt(3))).place(world, rand, i, j, k);
		}

		if (rand.nextInt((int) (1024/2F)) == 0) {
			int i = x + rand.nextInt(16);
			int j = (minY + 24) + rand.nextInt(rangeY / 8);
			int k = z + rand.nextInt(16);
			new WorldFeatureGeode(Blocks.ORE_REDSTONE_BASALT.id(),Blocks.BASALT.id(), Blocks.MARBLE.id(),30,(3 + rand.nextInt(3))).place(world, rand, i, j, k);
		}

		if (rand.nextInt((int) (1024*2F)) == 0) {
			int i = x + rand.nextInt(16);
			int j = (minY + 24) + rand.nextInt(rangeY / 8);
			int k = z + rand.nextInt(16);
			new WorldFeatureGeode(DEEPBlocks.abyssalriteDiamondOre.id(),DEEPBlocks.abyssalrite.id(), Blocks.MARBLE.id(),30,(3 + rand.nextInt(3))).place(world, rand, i, j, k);
		}

		if (rand.nextInt((int) (1024*2F)) == 0) {
			int i = x + rand.nextInt(16);
			int j = (minY + 24) + rand.nextInt(rangeY / 8);
			int k = z + rand.nextInt(16);
			new WorldFeatureGeode(DEEPBlocks.pearlstoneAmethystOre.id(),DEEPBlocks.pearlstone.id(), Blocks.MARBLE.id(),30,(3 + rand.nextInt(3))).place(world, rand, i, j, k);
		}

		if (rand.nextInt((int) (1024*4F)) == 0) {
			int i = x + rand.nextInt(16);
			int j = (minY + 24) + rand.nextInt(rangeY / 8);
			int k = z + rand.nextInt(16);
			new WorldFeatureGeode(DEEPBlocks.basaltBismuthOre.id(),Blocks.BASALT.id(), Blocks.MARBLE.id(),30,(3 + rand.nextInt(3))).place(world, rand, i, j, k);
		}

		if (rand.nextInt((int) (128)) == 0) {
			int i = x + rand.nextInt(16);
			int j = (minY + 24) + rand.nextInt(rangeY / 8);
			int k = z + rand.nextInt(16);
			new WorldFeatureHive(DEEPBlocks.blockHoney.id(), 0,DEEPBlocks.blockHoneycomb.id(),2,(5 + rand.nextInt(2))).place(world, rand, i, j, k);
//			(new WorldFeatureHiveHoney(12 + rand.nextInt(12), DEEPBlocks.blockHoneycomb)).place(this.world, rand, i, j, k);
		}


		BlockLogicSand.fallInstantly = false;
	}

}
