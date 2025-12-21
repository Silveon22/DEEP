package silveon22.deep.mixins;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.ChunkGeneratorResult;
import net.minecraft.core.world.generate.chunk.perlin.SurfaceGenerator;
import net.minecraft.core.world.generate.chunk.perlin.overworld.SurfaceGeneratorOverworld;
import net.minecraft.core.world.noise.BasePerlinNoise;
import net.minecraft.core.world.noise.PerlinNoise;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import silveon22.deep.block.DEEPBlocks;

import java.util.Random;

import java.util.Random;

@Mixin(value = SurfaceGeneratorOverworld.class, remap = false)
public class SurfaceGeneratorOverworldMixin {
	@Shadow
	@Final
	private World world;

	@Shadow
	@Final
	private BasePerlinNoise<?> beachNoise;

	@Shadow
	@Final
	private BasePerlinNoise<?> soilNoise;

	@Shadow
	@Final
	private boolean generateStoneVariants;

	@Shadow
	@Final
	private BasePerlinNoise<?> mainNoise;

	/**
	 * @author silveon
	 * @reason This code is pissing me off... I'm the original    silveon
	 */
	@Overwrite
	public void generateSurface(Chunk chunk, ChunkGeneratorResult result) {
			int oceanY = this.world.getWorldType().getOceanY();
			int minY = this.world.getWorldType().getMinY();
			int maxY = this.world.getWorldType().getMaxY();
			int terrainHeight = maxY + 1 - minY;
			int chunkX = chunk.xPosition;
			int chunkZ = chunk.zPosition;
			int oceanBlock = this.world.getWorldType().getOceanBlockId();
			int worldFillBlock = this.world.getWorldType().getFillerBlockId();
			Random rand = new Random((long)chunkX * 341873128712L + (long)chunkZ * 132897987541L);
			double beachScale = (double)0.03125F;
			double[] sandBeachNoise = this.beachNoise.get((double[])null, (double)(chunkX * 16), (double)(chunkZ * 16), (double)0.0F, 16, 16, 1, beachScale, beachScale, (double)1.0F);
			double[] gravelBeachNoise = this.beachNoise.get((double[])null, (double)(chunkX * 16), 109.0134, (double)(chunkZ * 16), 16, 1, 16, beachScale, (double)1.0F, beachScale);
			double[] soilThicknessNoise = this.soilNoise.get((double[])null, (double)(chunkX * 16), (double)(chunkZ * 16), (double)0.0F, 16, 16, 1, beachScale * (double)2.0F, beachScale * (double)2.0F, beachScale * (double)2.0F);
			double[] stoneLayerNoise = null;
			double[] stoneLayerNoiseGranite = null;
			double[] stoneLayerNoiseAbyssalrite = null;
			double[] stoneLayerNoiseLimestone = null;
			if (this.generateStoneVariants) {
				stoneLayerNoise = this.soilNoise.get((double[])null, (double)(chunkX * 16), (double)(chunkZ * 16), (double)0.0F, 16, 16, 1, beachScale * (double)4.0F, beachScale * (double)4.0F, beachScale * (double)4.0F);
				stoneLayerNoiseGranite = this.mainNoise.get((double[])null, (double)(chunkX * 16), (double)(chunkZ * 16), (double)0.0F, 16, 16, 1, beachScale * (double)4.0F, beachScale * (double)4.0F, beachScale * (double)4.0F);
				stoneLayerNoiseAbyssalrite = this.mainNoise.get((double[])null, (double)(chunkX * 16), (double)(chunkZ * 16), (double)(chunkZ * 8), 16, 16, 1, beachScale * (double)4.0F, beachScale * (double)4.0F, beachScale * (double)4.0F);
				stoneLayerNoiseLimestone = this.beachNoise.get((double[])null, (double)(chunkX * 16), (double)(chunkZ * 16), (double)0.0F, 16, 16, 1, beachScale * (double)4.0F, beachScale * (double)4.0F, beachScale * (double)4.0F);
			}

			for(int z = 0; z < 16; ++z) {
				for(int x = 0; x < 16; ++x) {
					boolean generateSandBeach = sandBeachNoise[z + x * 16] + rand.nextDouble() * 0.2 > (double)0.0F;
					boolean generateGravelBeach = gravelBeachNoise[z + x * 16] + rand.nextDouble() * 0.2 > (double)3.0F;
					int soilThickness = (int)(soilThicknessNoise[z + x * 16] / (double)3.0F + (double)3.0F + rand.nextDouble() * (double)0.25F);
					boolean generateBasaltLayer = false;
					boolean generateGraniteLayer = false;
					boolean generateAbyssalriteLayer = false;
					boolean generateLimestoneLayer = false;
					int basaltThicknessLevel = 0;
					int graniteThicknessLevel = 0;
					int abyssalriteThicknessLevel = 0;
					int limestoneThicknessLevel = 0;
					if (this.generateStoneVariants) {
						generateBasaltLayer = stoneLayerNoise[z + x * 16] + rand.nextDouble() * 0.2 > (double)0.0F;
						generateGraniteLayer = stoneLayerNoiseGranite[z + x * 16] + rand.nextDouble() * 0.2 > (double)2.0F;
						generateAbyssalriteLayer = stoneLayerNoiseGranite[z + x * 16] + rand.nextDouble() * 0.2 > (double)2.0F;
						generateLimestoneLayer = stoneLayerNoiseLimestone[z + x * 16] + rand.nextDouble() * 0.2 > (double)3.0F;
						basaltThicknessLevel = (int)(stoneLayerNoise[z + x] + rand.nextDouble() * (double)0.5F);
						graniteThicknessLevel = (int)(stoneLayerNoiseGranite[z + x] + rand.nextDouble() * (double)0.5F);
						abyssalriteThicknessLevel = (int)(stoneLayerNoiseAbyssalrite[z + x] + rand.nextDouble() * (double)0.5F);
						limestoneThicknessLevel = (int)(stoneLayerNoiseLimestone[z + x] + rand.nextDouble() * (double)0.5F);
					}

					int currentLayerDepth = -1;
					short topBlock = -1;
					short fillerBlock = -1;
					Biome lastBiome = null;

					for(int y = maxY; y >= minY; --y) {
						Biome biome = chunk.getBlockBiome(x, y, z);
						if (biome == null) {
							biome = this.world.getBiomeProvider().getBiome(chunkX * 16 + x, y >> 3, chunkZ * 16 + z);
						}

						int block = result.getBlock(x, y, z);
						if ((biome != lastBiome || topBlock == -1 || fillerBlock == -1) && block == 0) {
							topBlock = biome.topBlock;
							fillerBlock = biome.fillerBlock;
						}

						lastBiome = biome;
						if (block == 0) {
							currentLayerDepth = -1;
						} else if (block == worldFillBlock) {
							if (currentLayerDepth == -1) {
								if (soilThickness <= 0) {
									topBlock = 0;
									fillerBlock = (short)worldFillBlock;
								} else {
									boolean biomeGeneratesMud = biome == Biomes.OVERWORLD_CAATINGA_PLAINS || biome == Biomes.OVERWORLD_CAATINGA || biome == Biomes.OVERWORLD_SWAMPLAND || biome == Biomes.OVERWORLD_SWAMPLAND_MUDDY;
									if (y >= minY + oceanY - 4 && y <= minY + oceanY + 1) {
										topBlock = biome.topBlock;
										fillerBlock = biome.fillerBlock;
										if (biomeGeneratesMud) {
											topBlock = (short) Blocks.MUD.id();
											fillerBlock = (short)Blocks.MUD.id();
										} else if (generateGravelBeach) {
											topBlock = 0;
											fillerBlock = (short)Blocks.GRAVEL.id();
										} else if (generateSandBeach) {
											topBlock = (short)Blocks.SAND.id();
											fillerBlock = (short)Blocks.SAND.id();
										}
									} else if (y <= oceanY && biomeGeneratesMud) {
										topBlock = (short)Blocks.MUD.id();
										fillerBlock = (short)Blocks.MUD.id();
									}
								}

								if (y < minY + oceanY && topBlock == 0) {
									topBlock = (short)oceanBlock;
								}

								currentLayerDepth = soilThickness;
								if (y >= minY + oceanY - 1) {
									result.setBlock(x, y, z, topBlock);
								} else {
									result.setBlock(x, y, z, fillerBlock);
								}
							} else if (this.generateStoneVariants && currentLayerDepth <= 0) {
								if (y >= minY + basaltThicknessLevel - rand.nextInt(3) && y <= minY + 30 + basaltThicknessLevel - rand.nextInt(3) && generateBasaltLayer) {
									result.setBlock(x, y, z, Blocks.BASALT.id());
								} else if (biome == Biomes.OVERWORLD_GLACIER && y >= minY + 56 + graniteThicknessLevel / 4 - rand.nextInt(3) && y <= maxY) {
									result.setBlock(x, y, z, Blocks.PERMAFROST.id());
								} else if (biome == Biomes.OVERWORLD_TUNDRA && y >= minY + 56 + graniteThicknessLevel / 4 - rand.nextInt(3) && y <= minY + 92 + graniteThicknessLevel / 8 - rand.nextInt(3)) {
									result.setBlock(x, y, z, Blocks.PERMAFROST.id());
								} else if (biome == Biomes.OVERWORLD_DESERT && y >= minY + 56 + graniteThicknessLevel / 4 - rand.nextInt(3) && y <= maxY) {
									result.setBlock(x, y, z, DEEPBlocks.scorchedSandstone.id());
								} else if (biome == Biomes.OVERWORLD_OUTBACK && y >= minY + 56 + graniteThicknessLevel / 4 - rand.nextInt(3) && y <= minY + 92 + graniteThicknessLevel / 8 - rand.nextInt(3)) {
									result.setBlock(x, y, z, DEEPBlocks.scorchedSandstone.id());
								} else if (biome == Biomes.OVERWORLD_OUTBACK_GRASSY && y >= minY + 56 + graniteThicknessLevel / 4 - rand.nextInt(3) && y <= minY + 92 + graniteThicknessLevel / 8 - rand.nextInt(3)) {
									result.setBlock(x, y, z, DEEPBlocks.scorchedSandstone.id());
								} else if (y >= minY + 64 + graniteThicknessLevel - rand.nextInt(3) && y <= minY + 128 + graniteThicknessLevel - rand.nextInt(3) && generateGraniteLayer) {
									result.setBlock(x, y, z, Blocks.GRANITE.id());
								} else if (y >= minY + 64 + basaltThicknessLevel * 2 - rand.nextInt(3) && y <= minY + 170 + basaltThicknessLevel * 3 - rand.nextInt(3) && !generateBasaltLayer && !generateLimestoneLayer && generateGraniteLayer) {
									result.setBlock(x, y, z, DEEPBlocks.pearlstone.id());
								} else if (y >= minY + 64 + basaltThicknessLevel * 2 - rand.nextInt(3) && y <= minY + 170 + graniteThicknessLevel * 3 - rand.nextInt(3) && generateBasaltLayer && !generateGraniteLayer) {
									result.setBlock(x, y, z, DEEPBlocks.peridotite.id());
								} else if (y >= minY + abyssalriteThicknessLevel / 4 - rand.nextInt(3) && y <= minY + 20 + abyssalriteThicknessLevel / 2 - rand.nextInt(3) && generateAbyssalriteLayer) {
									result.setBlock(x, y, z, DEEPBlocks.abyssalrite.id());
								} else if (y >= minY + 64 + limestoneThicknessLevel - rand.nextInt(3) && y <= minY + 128 + limestoneThicknessLevel - rand.nextInt(3) && generateLimestoneLayer) {
									result.setBlock(x, y, z, Blocks.LIMESTONE.id());
								}
							} else {
								if (currentLayerDepth > 0) {
									--currentLayerDepth;
									result.setBlock(x, y, z, fillerBlock);
								}

								if (currentLayerDepth == 0) {
									if (biome == Biomes.OVERWORLD_DESERT && fillerBlock == Blocks.SAND.id()) {
										currentLayerDepth = rand.nextInt(8) + 16;
										fillerBlock = (short)Blocks.SANDSTONE.id();
									} else if (biome == Biomes.OVERWORLD_GLACIER && fillerBlock == Blocks.BLOCK_SNOW.id()) {
										currentLayerDepth = rand.nextInt(8) + 16;
										fillerBlock = (short)Blocks.PERMAFROST.id();
									}
								}
							}
						}
					}
				}
			}

		}
}
