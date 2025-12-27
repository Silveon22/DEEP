package silveon22.deep.worldfeatures;



import net.minecraft.core.WeightedRandomBag;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.BlockLogicChest;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntityChest;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.item.DEEPItems;

import java.util.Random;

public class WorldFeatureHive extends WorldFeature {

	public int oreID;
	public int blockID = Blocks.BASALT.id();
	public int blockID2 = Blocks.MARBLE.id();
	public int oreChance;
	public int radius = 4;
	public WeightedRandomBag<WeightedRandomLootObject> chestLoot;

	public WorldFeatureHive(int oreID, int blockID, int blockId2, int oreChance){
		this.oreID = oreID;
		this.blockID = blockID;
		this.blockID2 = blockId2;
		this.oreChance = oreChance;
	}

	public WorldFeatureHive(int oreId, int blockId, int blockId2, int oreChance, int radius){
		this.oreID = oreId;
		this.blockID = blockId;
		this.blockID2 = blockId2;
		this.oreChance = oreChance;
		this.radius = radius;
		this.chestLoot = new WeightedRandomBag();
		this.chestLoot.addEntry(new WeightedRandomLootObject(Items.INGOT_IRON.getDefaultStack(), 1, 4), (double)100.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Items.INGOT_GOLD.getDefaultStack(), 1, 2), (double)100.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Items.WHEAT.getDefaultStack(), 1, 4), (double)100.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Items.BONE.getDefaultStack(), 1, 4), (double)100.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Items.SULPHUR.getDefaultStack(), 1, 4), (double)100.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Items.STRING.getDefaultStack(), 1, 4), (double)100.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Items.BUCKET.getDefaultStack()), (double)100.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Items.FOOD_APPLE_GOLD.getDefaultStack()), (double)1.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Items.DUST_REDSTONE.getDefaultStack(), 1, 4), (double)50.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Items.ROPE.getDefaultStack(), 5, 30), (double)50.0F);

		for(int i = 0; i < 9; ++i) {
			this.chestLoot.addEntry(new WeightedRandomLootObject(new ItemStack(Item.itemsList[Items.RECORD_13.id + i]), 1), (double)1.0F);
		}

		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.SAPLING_CACAO.getDefaultStack()), (double)100.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.SPONGE_DRY.getDefaultStack(), 1, 4), (double)100.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Items.BONE.getDefaultStack(), 2, 6), (double)150.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(DEEPItems.ingotLead.getDefaultStack(), 1, 4), (double)100.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(DEEPItems.ingotSilver.getDefaultStack(), 1, 2), (double)100.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(DEEPItems.amethyst.getDefaultStack(), 1, 4), (double)2.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Items.DIAMOND.getDefaultStack(), 1, 4), (double)2.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(DEEPItems.bismuth.getDefaultStack(), 1, 4), (double)1.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(DEEPItems.silverApple.getDefaultStack(), 1,3), 1.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.TNT.getDefaultStack(), 2, 6), (double)33.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.SAPLING_EUCALYPTUS.getDefaultStack()), (double)25.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.SAPLING_PALM.getDefaultStack()), (double)25.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.SAPLING_THORN.getDefaultStack()), (double)25.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Items.BUCKET_ICECREAM.getDefaultStack()), (double)25.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.PUMICE_DRY.getDefaultStack(), 1, 4), (double)5.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject((ItemStack)null), (double)150.0F);
	}
	@Override
	public boolean place(World world, Random random, int i, int j, int k) {
		int oreBlocks = 0;

		int radius1 = radius+3;
		int hive2xoffset = random.nextInt(8) - random.nextInt(8);
		int hive2yoffset = 4 + random.nextInt(8);
		int hive2zoffset = random.nextInt(8) - random.nextInt(8);
		int hive3xoffset = hive2xoffset + random.nextInt(8) - random.nextInt(8);
		int hive3yoffset = hive2yoffset + 4 + random.nextInt(8);
		int hive3zoffset = hive2zoffset + random.nextInt(8) - random.nextInt(8);
		int hive4xoffset = hive3xoffset + random.nextInt(8) - random.nextInt(8);
		int hive4yoffset = hive3yoffset + 3 + random.nextInt(8) - random.nextInt(3);
		int hive4zoffset = hive3zoffset + random.nextInt(8) - random.nextInt(8);
		int hive6xoffset = hive3xoffset + random.nextInt(10) - random.nextInt(10);
		int hive6yoffset = hive3yoffset + random.nextInt(8) - random.nextInt(8);
		int hive6zoffset = hive3zoffset + random.nextInt(10) - random.nextInt(10);
		int hive5xoffset = hive6xoffset + random.nextInt(10) - random.nextInt(10);
		int hive5yoffset = hive6yoffset + random.nextInt(4) - random.nextInt(4);
		int hive5zoffset = hive6zoffset + random.nextInt(10) - random.nextInt(10);
		int hive7xoffset = hive5xoffset + random.nextInt(8) - random.nextInt(8);
		int hive7yoffset = hive5yoffset + 3 + random.nextInt(8);
		int hive7zoffset = hive5zoffset + random.nextInt(8) - random.nextInt(8);
		int hive8xoffset = random.nextInt(10) - random.nextInt(10);
		int hive8yoffset = 4 + random.nextInt(8);
		int hive8zoffset = random.nextInt(10) - random.nextInt(10);
		int hive9xoffset = hive8xoffset + random.nextInt(8) - random.nextInt(8);
		int hive9yoffset = hive8yoffset + 4 + random.nextInt(8);
		int hive9zoffset = hive8zoffset + random.nextInt(8) - random.nextInt(8);
		int hive2radius = radius+1;
		int hive2radius1 = hive2radius+2;
		int hive3radius = radius + random.nextInt(2)-1;
		int hive3radius1 = hive3radius+2;
		int hive4radius = radius + random.nextInt(3)-2;
		int hive4radius1 = hive4radius+2;
		int hive5radius = radius + random.nextInt(2)-1;
		int hive5radius1 = hive5radius+2;
		int hive6radius = radius + random.nextInt(2)-1;
		int hive6radius1 = hive6radius+2;
		int hive7radius = radius + random.nextInt(3)-2;
		int hive7radius1 = hive7radius+2;
		int hive8radius = radius + random.nextInt(2)-1;
		int hive8radius1 = hive8radius+2;
		int hive9radius = radius + random.nextInt(2)-1;
		int hive9radius1 = hive9radius+2;

		//Hive 1 Honeycomb
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

		//Hive 2 Honeycomb
		for(int x = -hive2radius1+1; x <= hive2radius1; ++x) {
			for (int y = -hive2radius1; y <= hive2radius1; ++y) {
				for (int z = -hive2radius1; z <= hive2radius1; ++z) {
					if (isPointInsideSphere(x, y, z, hive2radius1)) {
						if(world.getBlock(x+i+hive2xoffset, (y+j)-8+hive2yoffset, z+k+hive2zoffset) != Blocks.BEDROCK){
							world.setBlockAndMetadataWithNotify(x+i+hive2xoffset, (y+j)-8+hive2yoffset, z+k+hive2zoffset, this.blockID2, 0);
						}
					}
				}
			}
		}

		//Hive 3 Honeycomb
		for(int x = -hive3radius1+1; x <= hive3radius1; ++x) {
			for (int y = -hive3radius1; y <= hive3radius1; ++y) {
				for (int z = -hive3radius1; z <= hive3radius1; ++z) {
					if (isPointInsideSphere(x, y, z, hive3radius1)) {
						if(world.getBlock(x+i+hive3xoffset, (y+j)-8+hive3yoffset, z+k+hive3zoffset) != Blocks.BEDROCK){
							world.setBlockAndMetadataWithNotify(x+i+hive3xoffset, (y+j)-8+hive3yoffset, z+k+hive3zoffset, this.blockID2, 0);
						}
					}
				}
			}
		}

		//Hive 4 Honeycomb
		for(int x = -hive4radius1+1; x <= hive4radius1; ++x) {
			for (int y = -hive4radius1; y <= hive4radius1; ++y) {
				for (int z = -hive4radius1; z <= hive4radius1; ++z) {
					if (isPointInsideSphere(x, y, z, hive4radius1)) {
						if(world.getBlock(x+i+hive4xoffset, (y+j)-8+hive4yoffset, z+k+hive4zoffset) != Blocks.BEDROCK){
							world.setBlockAndMetadataWithNotify(x+i+hive4xoffset, (y+j)-8+hive4yoffset, z+k+hive4zoffset, this.blockID2, 0);
						}
					}
				}
			}
		}

		//Hive 5 Honeycomb
		for(int x = -hive5radius1+1; x <= hive5radius1; ++x) {
			for (int y = -hive5radius1; y <= hive5radius1; ++y) {
				for (int z = -hive5radius1; z <= hive5radius1; ++z) {
					if (isPointInsideSphere(x, y, z, hive5radius1)) {
						if(world.getBlock(x+i+hive5xoffset, (y+j)-8+hive5yoffset, z+k+hive5zoffset) != Blocks.BEDROCK){
							world.setBlockAndMetadataWithNotify(x+i+hive5xoffset, (y+j)-8+hive5yoffset, z+k+hive5zoffset, this.blockID2, 0);
						}
					}
				}
			}
		}

		//Hive 6 Honeycomb
		for(int x = -hive6radius1+1; x <= hive6radius1; ++x) {
			for (int y = -hive6radius1; y <= hive6radius1; ++y) {
				for (int z = -hive6radius1; z <= hive6radius1; ++z) {
					if (isPointInsideSphere(x, y, z, hive6radius1)) {
						if(world.getBlock(x+i+hive6xoffset, (y+j)-8+hive6yoffset, z+k+hive6zoffset) != Blocks.BEDROCK){
							world.setBlockAndMetadataWithNotify(x+i+hive6xoffset, (y+j)-8+hive6yoffset, z+k+hive6zoffset, this.blockID2, 0);
						}
					}
				}
			}
		}

		//Hive 7 Honeycomb
		for(int x = -hive7radius1+1; x <= hive7radius1; ++x) {
			for (int y = -hive7radius1; y <= hive7radius1; ++y) {
				for (int z = -hive7radius1; z <= hive7radius1; ++z) {
					if (isPointInsideSphere(x, y, z, hive7radius1)) {
						if(world.getBlock(x+i+hive7xoffset, (y+j)-8+hive7yoffset, z+k+hive7zoffset) != Blocks.BEDROCK){
							world.setBlockAndMetadataWithNotify(x+i+hive7xoffset, (y+j)-8+hive7yoffset, z+k+hive7zoffset, this.blockID2, 0);
						}
					}
				}
			}
		}

		//Hive 8 Honeycomb
		for(int x = -hive8radius1+1; x <= hive8radius1; ++x) {
			for (int y = -hive8radius1; y <= hive8radius1; ++y) {
				for (int z = -hive8radius1; z <= hive8radius1; ++z) {
					if (isPointInsideSphere(x, y, z, hive8radius1)) {
						if(world.getBlock(x+i+hive8xoffset, (y+j)-8+hive8yoffset, z+k+hive8zoffset) != Blocks.BEDROCK){
							world.setBlockAndMetadataWithNotify(x+i+hive8xoffset, (y+j)-8+hive8yoffset, z+k+hive8zoffset, this.blockID2, 0);
						}
					}
				}
			}
		}

		//Hive 9 Honeycomb
		for(int x = -hive9radius1+1; x <= hive9radius1; ++x) {
			for (int y = -hive9radius1; y <= hive9radius1; ++y) {
				for (int z = -hive9radius1; z <= hive9radius1; ++z) {
					if (isPointInsideSphere(x, y, z, hive9radius1)) {
						if(world.getBlock(x+i+hive9xoffset, (y+j)-8+hive9yoffset, z+k+hive9zoffset) != Blocks.BEDROCK){
							world.setBlockAndMetadataWithNotify(x+i+hive9xoffset, (y+j)-8+hive9yoffset, z+k+hive9zoffset, this.blockID2, 0);
						}
					}
				}
			}
		}

		//Hive 1 Cavern
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

		//Hive 2 Cavern
		for(int x = -hive2radius; x <= hive2radius; ++x) {
			for(int y = -hive2radius; y <= hive2radius; ++y) {
				for(int z = -hive2radius; z <= hive2radius; ++z) {
					if (isPointInsideSphere(x, y, z, hive2radius)) {
						if(world.getBlock(x+i+hive2xoffset, (y+j)-8+hive2yoffset, z+k+hive2zoffset) != Blocks.BEDROCK){
							if (oreID != 0 && random.nextInt(100) < oreChance){
								world.setBlockAndMetadataWithNotify(x+i+hive2xoffset, (y+j)-8+hive2yoffset, z+k+hive2zoffset, oreID, 0);
								oreBlocks++;
							} else {
								world.setBlockAndMetadataWithNotify(x+i+hive2xoffset, (y+j)-8+hive2yoffset, z+k+hive2zoffset, this.blockID, 0);
							}
						}
					}
				}
			}
		}

		//Hive 3 Cavern
		for(int x = -hive3radius; x <= hive3radius; ++x) {
			for(int y = -hive3radius; y <= hive3radius; ++y) {
				for(int z = -hive3radius; z <= hive3radius; ++z) {
					if (isPointInsideSphere(x, y, z, hive3radius)) {
						if(world.getBlock(x+i+hive3xoffset, (y+j)-8+hive3yoffset, z+k+hive3zoffset) != Blocks.BEDROCK){
							if (oreID != 0 && random.nextInt(100) < oreChance){
								world.setBlockAndMetadataWithNotify(x+i+hive3xoffset, (y+j)-8+hive3yoffset, z+k+hive3zoffset, oreID, 0);
								oreBlocks++;
							} else {
								world.setBlockAndMetadataWithNotify(x+i+hive3xoffset, (y+j)-8+hive3yoffset, z+k+hive3zoffset, this.blockID, 0);
							}
						}
					}
				}
			}
		}

		//Hive 4 Cavern
		for(int x = -hive4radius; x <= hive4radius; ++x) {
			for(int y = -hive4radius; y <= hive4radius; ++y) {
				for(int z = -hive4radius; z <= hive4radius; ++z) {
					if (isPointInsideSphere(x, y, z, hive4radius)) {
						if(world.getBlock(x+i+hive4xoffset, (y+j)-8+hive4yoffset, z+k+hive4zoffset) != Blocks.BEDROCK){
							if (oreID != 0 && random.nextInt(100) < oreChance){
								world.setBlockAndMetadataWithNotify(x+i+hive4xoffset, (y+j)-8+hive4yoffset, z+k+hive4zoffset, oreID, 0);
								oreBlocks++;
							} else {
								world.setBlockAndMetadataWithNotify(x+i+hive4xoffset, (y+j)-8+hive4yoffset, z+k+hive4zoffset, this.blockID, 0);
							}
						}
					}
				}
			}
		}

		//Hive 5 Cavern
		for(int x = -hive5radius; x <= hive5radius; ++x) {
			for(int y = -hive5radius; y <= hive5radius; ++y) {
				for(int z = -hive5radius; z <= hive5radius; ++z) {
					if (isPointInsideSphere(x, y, z, hive5radius)) {
						if(world.getBlock(x+i+hive5xoffset, (y+j)-8+hive5yoffset, z+k+hive5zoffset) != Blocks.BEDROCK){
							if (oreID != 0 && random.nextInt(100) < oreChance){
								world.setBlockAndMetadataWithNotify(x+i+hive5xoffset, (y+j)-8+hive5yoffset, z+k+hive5zoffset, oreID, 0);
								oreBlocks++;
							} else {
								world.setBlockAndMetadataWithNotify(x+i+hive5xoffset, (y+j)-8+hive5yoffset, z+k+hive5zoffset, this.blockID, 0);
							}
						}
					}
				}
			}
		}

		//Hive 6 Cavern
		for(int x = -hive6radius; x <= hive6radius; ++x) {
			for(int y = -hive6radius; y <= hive6radius; ++y) {
				for(int z = -hive6radius; z <= hive6radius; ++z) {
					if (isPointInsideSphere(x, y, z, hive6radius)) {
						if(world.getBlock(x+i+hive6xoffset, (y+j)-8+hive6yoffset, z+k+hive6zoffset) != Blocks.BEDROCK){
							if (oreID != 0 && random.nextInt(100) < oreChance){
								world.setBlockAndMetadataWithNotify(x+i+hive6xoffset, (y+j)-8+hive6yoffset, z+k+hive6zoffset, oreID, 0);
								oreBlocks++;
							} else {
								world.setBlockAndMetadataWithNotify(x+i+hive6xoffset, (y+j)-8+hive6yoffset, z+k+hive6zoffset, this.blockID, 0);
							}
						}
					}
				}
			}
		}

		//Hive 7 Cavern
		for(int x = -hive7radius; x <= hive7radius; ++x) {
			for(int y = -hive7radius; y <= hive7radius; ++y) {
				for(int z = -hive7radius; z <= hive7radius; ++z) {
					if (isPointInsideSphere(x, y, z, hive7radius)) {
						if(world.getBlock(x+i+hive7xoffset, (y+j)-8+hive7yoffset, z+k+hive7zoffset) != Blocks.BEDROCK){
							if (oreID != 0 && random.nextInt(100) < oreChance){
								world.setBlockAndMetadataWithNotify(x+i+hive7xoffset, (y+j)-8+hive7yoffset, z+k+hive7zoffset, oreID, 0);
								oreBlocks++;
							} else {
								world.setBlockAndMetadataWithNotify(x+i+hive7xoffset, (y+j)-8+hive7yoffset, z+k+hive7zoffset, this.blockID, 0);
							}
						}
					}
				}
			}
		}

		//Hive 8 Cavern
		for(int x = -hive8radius; x <= hive8radius; ++x) {
			for(int y = -hive8radius; y <= hive8radius; ++y) {
				for(int z = -hive8radius; z <= hive8radius; ++z) {
					if (isPointInsideSphere(x, y, z, hive8radius)) {
						if(world.getBlock(x+i+hive8xoffset, (y+j)-8+hive8yoffset, z+k+hive8zoffset) != Blocks.BEDROCK){
							if (oreID != 0 && random.nextInt(100) < oreChance){
								world.setBlockAndMetadataWithNotify(x+i+hive8xoffset, (y+j)-8+hive8yoffset, z+k+hive8zoffset, oreID, 0);
								oreBlocks++;
							} else {
								world.setBlockAndMetadataWithNotify(x+i+hive8xoffset, (y+j)-8+hive8yoffset, z+k+hive8zoffset, this.blockID, 0);
							}
						}
					}
				}
			}
		}

		//Hive 9 Cavern
		for(int x = -hive9radius; x <= hive9radius; ++x) {
			for(int y = -hive9radius; y <= hive9radius; ++y) {
				for(int z = -hive9radius; z <= hive9radius; ++z) {
					if (isPointInsideSphere(x, y, z, hive9radius)) {
						if(world.getBlock(x+i+hive9xoffset, (y+j)-8+hive9yoffset, z+k+hive9zoffset) != Blocks.BEDROCK){
							if (oreID != 0 && random.nextInt(100) < oreChance){
								world.setBlockAndMetadataWithNotify(x+i+hive9xoffset, (y+j)-8+hive9yoffset, z+k+hive9zoffset, oreID, 0);
								oreBlocks++;
							} else {
								world.setBlockAndMetadataWithNotify(x+i+hive9xoffset, (y+j)-8+hive9yoffset, z+k+hive9zoffset, this.blockID, 0);
							}
						}
					}
				}
			}
		}

		world.setBlockAndMetadataWithNotify(i+hive2xoffset, (j)-8+hive2yoffset-1, k+hive2zoffset, this.blockID2, 0);
		world.setBlockWithNotify(i+hive2xoffset, (j)-8+hive2yoffset, k+hive2zoffset, Blocks.CHEST_PLANKS_OAK.id());
		BlockLogicChest.setDefaultDirection(world, i+hive2xoffset, (j)-8+hive2yoffset, k+hive2zoffset);
		TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(i+hive2xoffset, (j)-8+hive2yoffset, k+hive2zoffset);

		world.setBlockAndMetadataWithNotify(i+hive6xoffset, (j)-8+hive6yoffset-1, k+hive6zoffset, this.blockID2, 0);
		world.setBlockWithNotify(i+hive6xoffset, (j)-8+hive6yoffset, k+hive6zoffset, Blocks.CHEST_PLANKS_OAK.id());
		BlockLogicChest.setDefaultDirection(world, i+hive6xoffset, (j)-8+hive6yoffset, k+hive6zoffset);
		TileEntityChest tileentitychest2 = (TileEntityChest)world.getTileEntity(i+hive6xoffset, (j)-8+hive6yoffset, k+hive6zoffset);

		for(int k4 = 0; k4 < 8; ++k4) {
			ItemStack itemstack = this.pickCheckLootItem(random);
			if (itemstack != null) {
				tileentitychest.setItem(random.nextInt(tileentitychest.getContainerSize()), itemstack);
			}
		}

		for(int k4 = 0; k4 < 8; ++k4) {
			ItemStack itemstack = this.pickCheckLootItem(random);
			if (itemstack != null) {
				tileentitychest2.setItem(random.nextInt(tileentitychest2.getContainerSize()), itemstack);
			}
		}

		return true;
	}

	private ItemStack pickCheckLootItem(Random random) {
		return ((WeightedRandomLootObject)this.chestLoot.getRandom(random)).getItemStack(random);
	}

	public boolean isPointInsideSphere(int x, int y, int z, double radius) {
		return x*x + y*y + z*z < radius*radius;
	}

}
