package silveon22.deep.mixins;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeatureClay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import silveon22.deep.block.DEEPBlocks;

@Mixin(value = WorldFeatureClay.class, remap = false)
public abstract class WorldFeatureClayMixin {
	@Shadow
	private int clayBlockId;

	@Redirect(method = "place", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/world/World;setBlock(IIII)Z"))
	public boolean warmClay(World world, int x, int y, int z, int id) {
		return world.setBlock(x, y, z, world.getBlockTemperature(x, z) > 0.5 ? DEEPBlocks.blockClayRed.id() : clayBlockId);
	}
}
