package silveon22.deep.worldfeatures;

import java.util.Random;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import silveon22.deep.block.DEEPBlocks;

public class WorldFeatureLilypad extends WorldFeature {
	public WorldFeatureLilypad() {
	}

	public boolean place(World world, Random random, int x, int y, int z) {
		for(int l = 0; l < 8; ++l) {
			int i1 = x + random.nextInt(16) - random.nextInt(16);
			int k1 = z + random.nextInt(16) - random.nextInt(16);
			if (world.getBlockId(i1, y, k1) == Blocks.FLUID_WATER_STILL.id() && world.getBlockMaterial(i1, y + 1, k1) == Material.air) {
				world.setBlock(i1, y + 1, k1, DEEPBlocks.lilypad.id());
			}
		}

		return true;
	}
}
