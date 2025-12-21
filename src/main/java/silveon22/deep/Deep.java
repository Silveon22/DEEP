package silveon22.deep;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.gui.guidebook.mobs.MobInfoRegistry;
import net.minecraft.client.sound.SoundRepository;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.sound.SoundTypes;
import net.minecraft.core.util.collection.NamespaceID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.item.DEEPItems;
import silveon22.deep.mob.*;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class Deep implements ModInitializer, RecipeEntrypoint, GameStartEntrypoint, ClientStartEntrypoint {
	public static final String MOD_ID = "deep";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("DEEP: Initializing blocks.");
		DEEPBlocks.initBlocks();
		LOGGER.info("DEEP: Blocks have been initialized.");
		EntityHelper.createEntity(MobElderSkeleton.class, NamespaceID.getPermanent(MOD_ID, "elder_skeleton"), "entity.deep.elder.skeleton");
		EntityHelper.createEntity(MobCaveCreeper.class, NamespaceID.getPermanent(MOD_ID, "cave_creeper"), "entity.deep.cave.creeper");
		EntityHelper.createEntity(MobWerewolf.class, NamespaceID.getPermanent(MOD_ID, "werewolf"), "entity.deep.werewolf");
		EntityHelper.createEntity(MobJellyfish.class, NamespaceID.getPermanent(MOD_ID, "jellyfish"), "entity.deep.jellyfish");
		EntityHelper.createEntity(MobShade.class, NamespaceID.getPermanent(MOD_ID, "shade"), "entity.deep.shade");
		EntityHelper.createEntity(MobRedSlime.class, NamespaceID.getPermanent(MOD_ID, "red_slime"), "entity.deep.slime.red");
		EntityHelper.createEntity(MobWaterSlime.class, NamespaceID.getPermanent(MOD_ID, "water_slime"), "entity.deep.slime.water");
		EntityHelper.createEntity(MobVolatileSlime.class, NamespaceID.getPermanent(MOD_ID, "volatile_slime"), "entity.deep.slime.volatile");
		EntityHelper.createEntity(MobNoteZombie.class, NamespaceID.getPermanent(MOD_ID, "noteblock_zombie"), "entity.deep.zombie.noteblock");
		EntityHelper.createEntity(MobPistonZombie.class, NamespaceID.getPermanent(MOD_ID, "piston_zombie"), "entity.deep.zombie.piston");
		EntityHelper.createEntity(MobMotherSpider.class, NamespaceID.getPermanent(MOD_ID, "mother_spider"), "entity.deep.spider.mother");
		EntityHelper.createEntity(MobBeetle.class, NamespaceID.getPermanent(MOD_ID, "beetle"), "entity.deep.beetle");
		EntityHelper.createEntity(MobPopper.class, NamespaceID.getPermanent(MOD_ID, "popper"), "entity.deep.popper");
		EntityHelper.createEntity(MobWisp.class, NamespaceID.getPermanent(MOD_ID, "wisp"), "entity.deep.wisp");
		EntityHelper.createEntity(MobOutbackZombie.class, NamespaceID.getPermanent(MOD_ID, "outback_zombie"), "entity.deep.zombie.outback");
		EntityHelper.createEntity(EntityFurnaceBoat.class, NamespaceID.getPermanent(MOD_ID, "boat_furnace"), "entity.deep.boat.furnace");
		EntityHelper.createEntity(MobTruffle.class, NamespaceID.getPermanent(MOD_ID, "truffle"), "entity.deep.truffle");
		EntityHelper.createEntity(MobSnowbomination.class, NamespaceID.getPermanent(MOD_ID, "snowbomination"), "entity.deep.snowbomination");
		EntityHelper.createEntity(MobBanditZombie.class, NamespaceID.getPermanent(MOD_ID, "bandit_zombie"), "entity.deep.zombie.bandit");
		EntityHelper.createTileEntity(TileEntityFreezer.class, NamespaceID.getPermanent(MOD_ID, "freezer"));
		EntityHelper.createTileEntity(TileEntityBrickOven.class, NamespaceID.getPermanent(MOD_ID, "brick_oven"));

		SoundRepository.registerNamespace("deep");
		SoundTypes.loadSoundsJson("deep");

		LOGGER.info("DEEP: onInitialize() has finished");
	}

	@Override
	public void onRecipesReady() {

	}

	@Override
	public void initNamespaces() {

	}

	@Override
	public void beforeGameStart() {

	}
	@Override
	public void afterGameStart() {
		MobInfoRegistry.register(MobJellyfish.class, "guidebook.section.deep.mob.jellyfish.name", "guidebook.section.deep.mob.jellyfish.desc", 2, 25, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(DEEPItems.gel), 0.66F, 1, 2)});
		MobInfoRegistry.register(MobTruffle.class, "guidebook.section.deep.mob.truffle.name", "guidebook.section.deep.mob.truffle.desc", 20, 100, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(Blocks.MUSHROOM_RED), 0.66F, 1, 1)});

		MobInfoRegistry.register(MobElderSkeleton.class, "guidebook.section.deep.mob.elder.skeleton.name", "guidebook.section.deep.mob.elder.skeleton.desc", 34, 1000, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(Items.BONE), 0.66F, 1, 2), new MobInfoRegistry.MobDrop(new ItemStack(Items.AMMO_ARROW), 0.66F, 1, 5)});
		MobInfoRegistry.register(MobCaveCreeper.class, "guidebook.section.deep.mob.cave.creeper.name", "guidebook.section.deep.mob.cave.creeper.desc", 34, 1000, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(Items.SULPHUR), 0.66F, 1, 2), new MobInfoRegistry.MobDrop(new ItemStack(DEEPItems.niter), 0.66F, 1, 3)});
		MobInfoRegistry.register(MobWerewolf.class, "guidebook.section.deep.mob.werewolf.name", "guidebook.section.deep.mob.werewolf.desc", 12, 300, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(Items.BONE), 0.66F, 1, 2), new MobInfoRegistry.MobDrop(new ItemStack(Items.CLOTH), 0.66F, 1, 2)});
		MobInfoRegistry.register(MobShade.class, "guidebook.section.deep.mob.shade.name", "guidebook.section.deep.mob.shade.desc", 4, 900, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(DEEPItems.eyeShade), 0.66F, 1, 1)});
		MobInfoRegistry.register(MobRedSlime.class, "guidebook.section.deep.mob.slime.red.name", "guidebook.section.deep.mob.slime.red.desc", 0, 150, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(Items.SLIMEBALL), 0.66F, 1, 2)});
		MobInfoRegistry.register(MobWaterSlime.class, "guidebook.section.deep.mob.slime.water.name", "guidebook.section.deep.mob.slime.water.desc", 0, 125, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(Items.SLIMEBALL), 0.66F, 1, 2)});
		MobInfoRegistry.register(MobVolatileSlime.class, "guidebook.section.deep.mob.slime.volatile.name", "guidebook.section.deep.mob.slime.volatile.desc", 0, 175, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(Items.SLIMEBALL), 0.66F, 1, 2), new MobInfoRegistry.MobDrop(new ItemStack(Items.SULPHUR), 0.66F, 1, 2)});
		MobInfoRegistry.register(MobNoteZombie.class, "guidebook.section.deep.mob.zombie.noteblock.name", "guidebook.section.deep.mob.zombie.noteblock.desc", 25, 500, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(Items.CLOTH), 0.66F, 1, 2), new MobInfoRegistry.MobDrop(new ItemStack(Blocks.NOTEBLOCK), 0.01F, 1, 1)});
		MobInfoRegistry.register(MobPistonZombie.class, "guidebook.section.deep.mob.zombie.piston.name", "guidebook.section.deep.mob.zombie.piston.desc", 25, 500, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(Items.CLOTH), 0.66F, 1, 2)});
		MobInfoRegistry.register(MobMotherSpider.class, "guidebook.section.deep.mob.spider.mother.name", "guidebook.section.deep.mob.spider.mother.desc", 34, 1000, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(Items.STRING), 0.66F, 3, 7), new MobInfoRegistry.MobDrop(new ItemStack(DEEPBlocks.eggSpider), 0.01F, 1, 1)});
		MobInfoRegistry.register(MobBeetle.class, "guidebook.section.deep.mob.beetle.name", "guidebook.section.deep.mob.beetle.desc", 34, 600, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(DEEPItems.huskBeetle), 0.66F, 1, 2)});
		MobInfoRegistry.register(MobOutbackZombie.class, "guidebook.section.deep.mob.zombie.outback.name", "guidebook.section.deep.mob.zombie.outback.desc", 20, 300, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(Items.CLOTH), 0.66F, 1, 2)});
		MobInfoRegistry.register(MobBanditZombie.class, "guidebook.section.deep.mob.zombie.bandit.name", "guidebook.section.deep.mob.zombie.bandit.desc", 34, 1000, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(Items.CLOTH), 0.66F, 1, 2), new MobInfoRegistry.MobDrop(new ItemStack(DEEPItems.ammoBullet), 0.66F, 1, 2)});
		MobInfoRegistry.register(MobSnowbomination.class, "guidebook.section.deep.mob.snowbomination.name", "guidebook.section.deep.mob.snowbomination.desc", 40, 1000, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(DEEPItems.ammoHail), 0.66F, 1, 2)});

		MobInfoRegistry.register(MobPopper.class, "guidebook.section.deep.mob.popper.name", "guidebook.section.deep.mob.popper.desc", 50, 1000, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(Items.SULPHUR), 0.66F, 1, 2)});
		MobInfoRegistry.register(MobWisp.class, "guidebook.section.deep.mob.wisp.name", "guidebook.section.deep.mob.wisp.desc", 12, 500, new MobInfoRegistry.MobDrop[]{new MobInfoRegistry.MobDrop(new ItemStack(Items.SULPHUR), 0.66F, 1, 2)});
		LOGGER.info("DEEP: afterGameStart() has finished");
	}

	@Override
	public void beforeClientStart() {

	}

	@Override
	public void afterClientStart() {
	}
}
