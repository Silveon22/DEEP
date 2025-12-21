package silveon22.deep.worldfeatures;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import silveon22.deep.block.DEEPBlocks;

import java.util.Random;

public class WorldFeatureSalt extends WorldFeature {
	public WorldFeatureSalt() {
	}

	public boolean place(World world, Random random, int x, int y, int z) {
		if (world.getBlockId(x, y - 1, z) != Blocks.FLUID_WATER_STILL.id()) {
			return false;
		} else {
			for(int l = 0; l < 16; ++l) {
				int i1 = x + random.nextInt(12) - random.nextInt(12);

				int k1;
				for(k1 = z + random.nextInt(12) - random.nextInt(12); world.getBlockId(i1, y - 1, k1) == Blocks.FLUID_WATER_STILL.id(); --y) {
				}

				int l1 = 5 + random.nextInt(random.nextInt(10) + 1);

				for(int i2 = 0; i2 < l1; ++i2) {
					if ((world.getBlockId(i1, y - 1 + i2, k1) == DEEPBlocks.blockSalt.id() ||world.getBlockId(i1, y - 1 + i2, k1) == Blocks.SAND.id() || world.getBlockId(i1, y - 1 + i2, k1) == Blocks.DIRT.id()) && world.getBlockId(i1, y + 1, k1) != 0)  {
						world.setBlockRaw(i1, y + i2, k1, DEEPBlocks.blockSalt.id());
					}
				}
			}

			return true;
		}
	}
}
