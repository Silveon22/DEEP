package silveon22.deep.mixins;

import net.minecraft.client.render.entity.*;
import net.minecraft.client.render.model.*;
import net.minecraft.core.entity.*;
import net.minecraft.core.entity.animal.*;
import net.minecraft.core.entity.monster.*;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.entity.projectile.*;
import net.minecraft.core.entity.vehicle.EntityBoat;
import net.minecraft.core.entity.vehicle.EntityMinecart;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silveon22.deep.mob.MobCaveCreeper;
import silveon22.deep.mob.MobElderSkeleton;
import silveon22.deep.mob.MobJellyfish;
import silveon22.deep.mob.MobWerewolf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mixin(value = Biome.class, remap = false)
public class EntityRenderDispatcherMixin {
}
