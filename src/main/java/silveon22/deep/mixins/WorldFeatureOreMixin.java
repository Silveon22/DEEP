package silveon22.deep.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;
import silveon22.deep.block.DEEPBlocks;

@Mixin(value = WorldFeatureOre.class, remap = false)
public class WorldFeatureOreMixin {
	@WrapOperation(
		method = "place",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/core/world/World;getBlockId(III)I"
		),
		slice = @Slice(
			from = @At(value = "INVOKE", target = "Lnet/minecraft/core/world/World;setBlock(IIII)Z"),
			to = @At(value = "INVOKE", target = "Lnet/minecraft/core/block/Block;id()I")
		)
	)
	public int spoofGetBlockID(World instance, int x, int y, int z, Operation<Integer> original) {
		int id = original.call(instance, x, y, z);
		if (id == DEEPBlocks.abyssalrite.id()||id == DEEPBlocks.pearlstone.id()||id == DEEPBlocks.peridotite.id()) {
			return Blocks.STONE.id();
		}
		return id;
	}
}
