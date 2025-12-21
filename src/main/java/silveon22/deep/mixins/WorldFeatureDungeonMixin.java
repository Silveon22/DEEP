package silveon22.deep.mixins;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;
import net.minecraft.core.WeightedRandomBag;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeatureDungeon;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.item.DEEPItems;

import java.util.Random;

@Mixin(value = WorldFeatureDungeon.class, remap = false)
public abstract class WorldFeatureDungeonMixin {
	@Shadow
	public WeightedRandomBag<WeightedRandomLootObject> chestLoot;

	@Shadow
	public int blockIdWalls;

	@Shadow
	public int blockIdFloor;

	@Shadow
	public WeightedRandomBag<String> spawnerMonsters;

	@Inject(method = "<init>", at = @At(value = "TAIL"))
	public void addLoot(CallbackInfo ci) {
		this.chestLoot.addEntry(new WeightedRandomLootObject(DEEPItems.ingotLead.getDefaultStack(), 1, 4), (double)100.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(DEEPItems.silverApple.getDefaultStack(), 1,3), 1.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.PUMPKIN.getDefaultStack(), 1,3), 100.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.TNT.getDefaultStack(), 2, 6), (double)33.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.FLOWER_ORANGE.getDefaultStack(), 1, 4), (double)25.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.FLOWER_LIGHT_BLUE.getDefaultStack(), 1, 4), (double)25.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.FLOWER_PINK.getDefaultStack(), 1, 4), (double)25.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.FLOWER_PURPLE.getDefaultStack(), 1, 4), (double)25.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(DEEPBlocks.lilypad.getDefaultStack(), 1, 4), (double)25.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.SAPLING_CHERRY.getDefaultStack()), (double)25.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.SAPLING_EUCALYPTUS.getDefaultStack()), (double)25.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.SAPLING_PALM.getDefaultStack()), (double)25.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Blocks.SAPLING_THORN.getDefaultStack()), (double)25.0F);
		this.chestLoot.addEntry(new WeightedRandomLootObject(Items.BUCKET_ICECREAM.getDefaultStack()), (double)25.0F);
		this.spawnerMonsters.addEntry("Creeper", 1.0);
		this.spawnerMonsters.addEntry("deep:outback_zombie", (double)1.0F);
		this.spawnerMonsters.addEntry("deep:werewolf", (double)1.0F);
		this.spawnerMonsters.addEntry("deep:beetle", (double)1.0F);
	}

	@Inject(method = "place", at = @At(value = "HEAD"))
	public void changePallet(World world, Random random, int x, int y, int z, CallbackInfoReturnable<Boolean> cir) {
		int palletnum = random.nextInt(5);
		if (palletnum == 0) {
			this.blockIdWalls = Blocks.BRICK_CLAY.id();
			this.blockIdFloor = DEEPBlocks.tileCeramicRed.id();
		} else if (palletnum == 1) {
			this.blockIdWalls = DEEPBlocks.brickClayBlue.id();
			this.blockIdFloor = DEEPBlocks.tileCeramicBlue.id();
		} else if (palletnum == 2) {
			this.blockIdWalls = Blocks.BRICK_MARBLE.id();
			this.blockIdFloor = Blocks.MARBLE.id();
		} else if (palletnum == 3) {
			this.blockIdWalls = Blocks.BRICK_LAPIS.id();
			this.blockIdFloor = DEEPBlocks.lapisTile.id();
		} else {
			this.blockIdWalls = Blocks.BRICK_STONE.id();
			this.blockIdFloor = Blocks.COBBLE_STONE_MOSSY.id();
		}
	}
}
