package silveon22.deep.item;

import java.util.Random;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.entity.TileEntityActivator;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.util.phys.HitResult.HitType;
import net.minecraft.core.world.Dimension;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;

public class ItemCeramicBucket extends Item {
	private final @Nullable Block<?> blockToPlace;

	public ItemCeramicBucket(String name, String namespaceId, int id, @Nullable Block<?> blockToPlace) {
		super(name, namespaceId, id);
		this.maxStackSize = 1;
		this.blockToPlace = blockToPlace;
	}

	public ItemStack onUseItem(ItemStack stack, World world, Player player) {
		if (this.blockToPlace == null) {
			return new ItemStack(DEEPItems.bucketCeramicEmpty);
		} else {
			double reachDistance = (double)player.getGamemode().getBlockReachDistance();
			HitResult rayTraceResult = player.rayTrace(reachDistance, 1.0F, false, false);
			if (rayTraceResult != null && rayTraceResult.hitType == HitType.TILE) {
				int x = rayTraceResult.x;
				int y = rayTraceResult.y;
				int z = rayTraceResult.z;
				if (!world.canMineBlock(player, x, y, z)) {
					return stack;
				} else {
					Block<?> block = world.getBlock(x, y, z);
					if (block != null && !block.hasTag(BlockTags.PLACE_OVERWRITES) && !block.hasTag(BlockTags.BROKEN_BY_FLUIDS)) {
						Side side = rayTraceResult.side;
						x += side.getOffsetX();
						y += side.getOffsetY();
						z += side.getOffsetZ();
					}

					if (y >= 0 && y < world.getHeightBlocks()) {
						if (world.isAirBlock(x, y, z) || !world.getBlockMaterial(x, y, z).isSolid()) {
							if (world.dimension == Dimension.NETHER && this.blockToPlace == Blocks.FLUID_WATER_FLOWING) {
								world.playSoundEffect(player, SoundCategory.WORLD_SOUNDS, (double)z + (double)0.5F, (double)y + (double)0.5F, (double)x + (double)0.5F, "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

								for(int l = 0; l < 8; ++l) {
									world.spawnParticle("largesmoke", (double)x + Math.random(), (double)y + Math.random(), (double)z + Math.random(), (double)0.0F, (double)0.0F, (double)0.0F, 0);
								}
							} else {
								if (this.blockToPlace == Blocks.FLUID_WATER_FLOWING) {
									world.playSoundEffect(player, SoundCategory.WORLD_SOUNDS, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "liquid.splash", 0.5F, 1.0F);
								}

								player.swingItem();
								Block<?> block1 = world.getBlock(x, y, z);
								if (block1 != null) {
									block1.dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, world.getBlockMetadata(x, y, z), (TileEntity)null, (Player)null);
								}

								world.setBlockAndMetadataWithNotify(x, y, z, this.blockToPlace.id(), 0);
							}

							if (player.getGamemode().consumeBlocks()) {
								--stack.stackSize;
							}
						}

						return stack;
					} else {
						return stack;
					}
				}
			} else {
				return stack;
			}
		}
	}

	public void onUseByActivator(ItemStack itemStack, TileEntityActivator activatorBlock, World world, Random random, int blockX, int blockY, int blockZ, double offX, double offY, double offZ, Direction direction) {
		if (this.blockToPlace == null) {
			itemStack.itemID = DEEPItems.bucketCeramicEmpty.id;
		} else {
			int x = blockX + direction.getOffsetX();
			int y = blockY + direction.getOffsetY();
			int z = blockZ + direction.getOffsetZ();
			Block<?> b = world.getBlock(x, y, z);
			if (b == null || BlockTags.PLACE_OVERWRITES.appliesTo(b) || BlockTags.BROKEN_BY_FLUIDS.appliesTo(b)) {
				world.setBlockWithNotify(x, y, z, this.blockToPlace.id());
				--itemStack.stackSize;
			}

		}
	}
}
