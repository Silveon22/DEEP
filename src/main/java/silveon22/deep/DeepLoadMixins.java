package silveon22.deep;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import org.spongepowered.asm.mixin.Mixins;
import turniplabs.halplibe.helper.EnvironmentHelper;

public class DeepLoadMixins implements PreLaunchEntrypoint {
	@Override
	public void onPreLaunch() {
		if (!EnvironmentHelper.isServerEnvironment()) {
			FabricLoader loader = FabricLoader.getInstance();
			if (loader.isModLoaded("stardew") == false) {
				Mixins.addConfiguration("compat/deep/stardew/deep.fishingmixins.json");
			}
		}
	}
}
