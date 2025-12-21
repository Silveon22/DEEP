package silveon22.deep.mixins;


import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.CavesLargeFeature;
import net.minecraft.core.world.generate.LargeFeature;
import net.minecraft.core.world.generate.chunk.ChunkGeneratorResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = CavesLargeFeature.class, remap = false)
public class CavesLargeFeatureMixin extends LargeFeature {
	@Inject(method = "doGeneration", at = @At(value = "FIELD", target = "Lnet/minecraft/core/world/generate/CavesLargeFeature;maxY:I",shift = At.Shift.BEFORE))
	protected void doGeneration(World world, int chunkX, int chunkZ, int baseChunkX, int baseChunkZ, ChunkGeneratorResult result, CallbackInfo ci, @Local(name = "cavesToGenerate") LocalIntRef cavesToGenerate)
	{
		cavesToGenerate.set(cavesToGenerate.get()*3);
	}
}
