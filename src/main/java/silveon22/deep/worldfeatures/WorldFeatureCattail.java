package silveon22.deep.worldfeatures;

import java.util.Random;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import silveon22.deep.block.DEEPBlocks;

public class WorldFeatureCattail extends WorldFeature {
	public WorldFeatureCattail() {
	}

	public boolean place(World world, Random random, int x, int y, int z) {
		for(int l = 0; l < 20; ++l) {
			int i1 = x + random.nextInt(4) - random.nextInt(4);
			int j1 = y;
			int k1 = z + random.nextInt(4) - random.nextInt(4);
			if (world.isAirBlock(i1, y, k1) && (world.getBlockMaterial(i1 - 1, y - 1, k1) == Material.water || world.getBlockMaterial(i1 + 1, y - 1, k1) == Material.water || world.getBlockMaterial(i1, y - 1, k1 - 1) == Material.water || world.getBlockMaterial(i1, y - 1, k1 + 1) == Material.water)) {
				int l1 = 1;

				for(int i2 = 0; i2 < l1; ++i2) {
					if (DEEPBlocks.cattailBottom.canPlaceBlockAt(world, i1, j1 + i2, k1)) {
						world.setBlock(i1, j1 + i2, k1, DEEPBlocks.cattailBottom.id());
					}
				}
			}
		}

		return true;
	}
}
