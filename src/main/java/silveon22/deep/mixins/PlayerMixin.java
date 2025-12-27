package silveon22.deep.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.core.achievement.stat.Stat;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.ContainerInventory;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silveon22.deep.DeepAchievements;
import silveon22.deep.gui.ScreenFreezer;
import silveon22.deep.gui.displayFreezerScreen;
import silveon22.deep.item.DEEPItems;
import silveon22.deep.mob.TileEntityFreezer;


@Mixin(value = Player.class, remap = false)
public abstract class PlayerMixin extends Mob implements displayFreezerScreen {

	public PlayerMixin(@Nullable World world) {
		super(world);
	}

	@Shadow
	public abstract void triggerAchievement(Stat statbase);

	@Override
	public void deep$freezerScreen(TileEntityFreezer freezer) {
	}

	@Inject(method = "tick", at = @At("HEAD"))
	public void addDEEPLocationAchievements(CallbackInfo ci) {
		if (world != null) {
			if (this.y < world.getWorldType().getOceanY() - 7 && !this.world.canBlockSeeTheSky((int) this.x, (int) this.y-1, (int) this.z)) {
				this.triggerAchievement(DeepAchievements.DELVE);
			}
			if (this.y < 4) {
				this.triggerAchievement(DeepAchievements.ROCK_BOTTOM);
			}
		}

	}

}
