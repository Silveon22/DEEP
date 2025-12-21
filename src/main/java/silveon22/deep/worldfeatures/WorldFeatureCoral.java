package silveon22.deep.worldfeatures;

import java.util.Random;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import silveon22.deep.block.DEEPBlocks;

public class WorldFeatureCoral extends WorldFeature {
	public WorldFeatureCoral() {
	}

	public boolean place(World world, Random random, int x, int y, int z) {
		if (world.getBlockId(x, y - 1, z) != Blocks.FLUID_WATER_STILL.id()) {
			return false;
		} else {
			for(int l = 0; l < 64; ++l) {
				int i1 = x + random.nextInt(32) - random.nextInt(32);

				int k1;
				for(k1 = z + random.nextInt(32) - random.nextInt(32); world.getBlockId(i1, y - 1, k1) == Blocks.FLUID_WATER_STILL.id(); --y) {
				}

				if ((world.getBlockId(i1, y - 1, k1) == DEEPBlocks.coral.id() ||world.getBlockId(i1, y - 1, k1) == Blocks.SAND.id() || world.getBlockId(i1, y - 1, k1) == Blocks.DIRT.id()) && world.getBlockId(i1, y + 1, k1) != 0)  {
					world.setBlockRaw(i1, y, k1, DEEPBlocks.coral.id());
				}
			}

			return true;
		}
	}
}
