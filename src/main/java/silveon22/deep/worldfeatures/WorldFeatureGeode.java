package silveon22.deep.worldfeatures;



import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureGeode extends WorldFeature {

	public int oreID;
	public int blockID = Blocks.BASALT.id();
	public int blockID2 = Blocks.MARBLE.id();
	public int oreChance;
	public int radius = 4;

	public WorldFeatureGeode(int oreID, int blockID, int blockId2, int oreChance){
		this.oreID = oreID;
		this.blockID = blockID;
		this.blockID2 = blockId2;
		this.oreChance = oreChance;
	}

	public WorldFeatureGeode(int oreId, int blockId, int blockId2, int oreChance, int radius){
		this.oreID = oreId;
		this.blockID = blockId;
		this.blockID2 = blockId2;
		this.oreChance = oreChance;
		this.radius = radius;
	}
	@Override
	public boolean place(World world, Random random, int i, int j, int k) {
		int oreBlocks = 0;

		int radius1 = radius+2;
		int radius2 = radius+3;

		for(int x = -radius2+1; x <= radius2; ++x) {
			for (int y = -radius2; y <= radius2; ++y) {
				for (int z = -radius2; z <= radius2; ++z) {
					if (isPointInsideSphere(x, y, z, radius2)) {
						if(world.getBlock(x+i, (y+j)-8, z+k) != Blocks.BEDROCK){
							world.setBlockAndMetadataWithNotify(x+i, (y+j)-8, z+k, 0, 0);
						}
					}
				}
			}
		}

		for(int x = -radius1+1; x <= radius1; ++x) {
			for (int y = -radius1; y <= radius1; ++y) {
				for (int z = -radius1; z <= radius1; ++z) {
					if (isPointInsideSphere(x, y, z, radius1)) {
						if(world.getBlock(x+i, (y+j)-8, z+k) != Blocks.BEDROCK){
							world.setBlockAndMetadataWithNotify(x+i, (y+j)-8, z+k, this.blockID2, 0);
						}
					}
				}
			}
		}

		for(int x = -radius; x <= radius; ++x) {
			for(int y = -radius; y <= radius; ++y) {
				for(int z = -radius; z <= radius; ++z) {
					if (isPointInsideSphere(x, y, z, radius)) {
						if(world.getBlock(x+i, (y+j)-8, z+k) != Blocks.BEDROCK){
							if (oreID != 0 && random.nextInt(100) < oreChance){
								world.setBlockAndMetadataWithNotify(x+i, (y+j)-8, z+k, oreID, 0);
								oreBlocks++;
							} else {
								world.setBlockAndMetadataWithNotify(x+i, (y+j)-8, z+k, this.blockID, 0);
							}
						}
					}
				}
			}
		}
		return true;
	}

	public boolean isPointInsideSphere(int x, int y, int z, double radius) {
		return x*x + y*y + z*z < radius*radius;
	}

}
