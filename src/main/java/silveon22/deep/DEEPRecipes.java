package silveon22.deep;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.data.DataLoader;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeEntryBase;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.helper.DyeColor;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.item.DEEPItems;
import silveon22.deep.recipe.RecipeEntryBrickOven;
import silveon22.deep.recipe.RecipeEntryFreezer;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static silveon22.deep.Deep.MOD_ID;

public class DEEPRecipes implements RecipeEntrypoint {

	public static <T extends RecipeEntryBase<?,?,?>> List<T> getAllRecipesOfType(Class<T> clazz){
		List<T> recipes = new ArrayList<>();
		for (RecipeEntryBase<?, ?, ?> recipe : Registries.RECIPES.getAllRecipes()) {
			if (clazz.isAssignableFrom(recipe.getClass())) {
				recipes.add(clazz.cast(recipe));
			}
		}
		return Collections.unmodifiableList(recipes);
	}

	@Override
	public void onRecipesReady() {


		Registries.RECIPE_TYPES.register("deep:freezing/freezer", RecipeEntryFreezer.class);
		Registries.RECIPE_TYPES.register("deep:baking/brick_oven", RecipeEntryBrickOven.class);

		RecipeNamespace deep = RecipeBuilder.getRecipeNamespace(MOD_ID);
		deep.register("freezer", new RecipeGroup<>(new RecipeSymbol(new ItemStack(DEEPBlocks.freezerIdle))));
		deep.register("brick_oven", new RecipeGroup<>(new RecipeSymbol(new ItemStack(DEEPBlocks.brickOvenIdle))));

		RecipeBuilder.getRecipeNamespace(MOD_ID);
		DataLoader.loadRecipesFromFile("/assets/deep/recipes/freezer.json");
		DataLoader.loadRecipesFromFile("/assets/deep/recipes/brick_oven.json");

		Registries.ITEM_GROUPS.register("deep:gemstones",Registries.stackListOf(Items.DIAMOND,DEEPItems.amethyst,DEEPItems.adamantite));
		Registries.ITEM_GROUPS.register("deep:clayBricks",Registries.stackListOf(DEEPItems.clayBrickBlue,Items.BRICK_CLAY));
		RecipeBuilder.addItemsToGroup("minecraft","stones", DEEPBlocks.abyssalrite,DEEPBlocks.pearlstone,DEEPBlocks.peridotite);
		RecipeBuilder.addItemsToGroup("minecraft","cobblestones", DEEPBlocks.abyssalriteCobbled, DEEPBlocks.pearlstoneCobbled, DEEPBlocks.peridotiteCobbled, Blocks.SANDSTONE, DEEPBlocks.scorchedSandstone);
		RecipeBuilder.addItemsToGroup("minecraft","coal_ores", DEEPBlocks.abyssalriteCoalOre,DEEPBlocks.pearlstoneCoalOre,DEEPBlocks.peridotiteCoalOre);
		RecipeBuilder.addItemsToGroup("minecraft","iron_ores", DEEPBlocks.abyssalriteIronOre,DEEPBlocks.pearlstoneIronOre,DEEPBlocks.peridotiteIronOre);
		RecipeBuilder.addItemsToGroup("minecraft","gold_ores", DEEPBlocks.abyssalriteGoldOre,DEEPBlocks.pearlstoneGoldOre,DEEPBlocks.peridotiteGoldOre);
		RecipeBuilder.addItemsToGroup("minecraft","redstone_ores", DEEPBlocks.abyssalriteRedstoneOre,DEEPBlocks.pearlstoneRedstoneOre,DEEPBlocks.peridotiteRedstoneOre);
		RecipeBuilder.addItemsToGroup("minecraft","lapis_ores", DEEPBlocks.abyssalriteLapisOre,DEEPBlocks.pearlstoneLapisOre,DEEPBlocks.peridotiteLapisOre);
		RecipeBuilder.addItemsToGroup("minecraft","diamond_ores", DEEPBlocks.abyssalriteDiamondOre,DEEPBlocks.pearlstoneDiamondOre,DEEPBlocks.peridotiteDiamondOre);
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R")
			.addInput('R', DEEPItems.rhodonite)
			.create("rhodoniteToPinkDye", new ItemStack(Items.DYE, 1, DyeColor.PINK.itemMeta));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR","RRR","RRR")
			.addInput('R', DEEPItems.rhodonite)
			.create("rhodoniteToBlock", new ItemStack(DEEPBlocks.rhodoniteBlock, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R")
			.addInput('R', DEEPBlocks.rhodoniteBlock)
			.create("blockToRhodonite", new ItemStack(DEEPItems.rhodonite, 9));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RR","RR")
			.addInput('R', DEEPItems.rhodonite)
			.create("rhodoniteToBrick", new ItemStack(DEEPBlocks.rhodoniteBrick, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.rhodoniteBrick)
			.create("rhodoniteBrickSlab", new ItemStack(DEEPBlocks.slabRhodoniteBrick, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.rhodoniteBrick)
			.create("rhodoniteBrickStairs", new ItemStack(DEEPBlocks.stairsRhodoniteBrick, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AAA","AAA","AAA")
			.addInput('A', DEEPItems.amethyst)
			.create("amethystToBlock", new ItemStack(DEEPBlocks.amethystBlock, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("A")
			.addInput('A', DEEPBlocks.amethystBlock)
			.create("blockToAmethyst", new ItemStack(DEEPItems.amethyst, 9));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AAA"," S "," S ")
			.addInput('A', DEEPItems.amethyst)
			.addInput('S', Items.STICK)
			.create("amethystPickaxe", new ItemStack(DEEPItems.amethystPickaxe, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AA ","AS "," S ")
			.addInput('A', DEEPItems.amethyst)
			.addInput('S', Items.STICK)
			.create("amethystAxeLeft", new ItemStack(DEEPItems.amethystAxe, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AA","SA","S ")
			.addInput('A', DEEPItems.amethyst)
			.addInput('S', Items.STICK)
			.create("amethystAxeRight", new ItemStack(DEEPItems.amethystAxe, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("A","A","S")
			.addInput('A', DEEPItems.amethyst)
			.addInput('S', Items.STICK)
			.create("amethystSword", new ItemStack(DEEPItems.amethystSword, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("A","S","S")
			.addInput('A', DEEPItems.amethyst)
			.addInput('S', Items.STICK)
			.create("amethystShovel", new ItemStack(DEEPItems.amethystShovel, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AA","S ","S ")
			.addInput('A', DEEPItems.amethyst)
			.addInput('S', Items.STICK)
			.create("amethystHoeRight", new ItemStack(DEEPItems.amethystHoe, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AA"," S"," S")
			.addInput('A', DEEPItems.amethyst)
			.addInput('S', Items.STICK)
			.create("amethystHoeLeft", new ItemStack(DEEPItems.amethystHoe, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AAA","A A")
			.addInput('A', DEEPItems.amethyst)
			.create("amethystHelmet", new ItemStack(DEEPItems.amethystHelmet, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("A A","AAA","AAA")
			.addInput('A', DEEPItems.amethyst)
			.create("amethystChestplate", new ItemStack(DEEPItems.amethystChestplate, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AAA","A A","A A")
			.addInput('A', DEEPItems.amethyst)
			.create("amethystLeggings", new ItemStack(DEEPItems.amethystLeggings, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("A A","A A")
			.addInput('A', DEEPItems.amethyst)
			.create("amethystBoots", new ItemStack(DEEPItems.amethystBoots, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SSS","SSS","SSS")
			.addInput('S', DEEPItems.ingotSilver)
			.create("silverToBlock", new ItemStack(DEEPBlocks.silverBlock, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("S")
			.addInput('S', DEEPBlocks.silverBlock)
			.create("blockToSilver", new ItemStack(DEEPItems.ingotSilver, 9));
		RecipeBuilder.ModifyWorkbench("minecraft").removeRecipe("jukebox");
		RecipeBuilderShaped jukebox = new RecipeBuilderShaped(MOD_ID,"WWW","WGW","WWW");
		jukebox.addInput('W',"minecraft:planks").addInput('G',"deep:gemstones").create("jukebox", new ItemStack(Blocks.JUKEBOX, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AAA"," S "," S ")
			.addInput('A', DEEPItems.ingotSilver)
			.addInput('S', Items.STICK)
			.create("silverPickaxe", new ItemStack(DEEPItems.silverPickaxe, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AA ","AS "," S ")
			.addInput('A', DEEPItems.ingotSilver)
			.addInput('S', Items.STICK)
			.create("silverAxeLeft", new ItemStack(DEEPItems.silverAxe, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AA","SA","S ")
			.addInput('A', DEEPItems.ingotSilver)
			.addInput('S', Items.STICK)
			.create("silverAxeRight", new ItemStack(DEEPItems.silverAxe, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("A","A","S")
			.addInput('A', DEEPItems.ingotSilver)
			.addInput('S', Items.STICK)
			.create("silverSword", new ItemStack(DEEPItems.silverSword, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("A","S","S")
			.addInput('A', DEEPItems.ingotSilver)
			.addInput('S', Items.STICK)
			.create("silverShovel", new ItemStack(DEEPItems.silverShovel, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AA","S ","S ")
			.addInput('A', DEEPItems.ingotSilver)
			.addInput('S', Items.STICK)
			.create("silverHoeRight", new ItemStack(DEEPItems.silverHoe, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AA"," S"," S")
			.addInput('A', DEEPItems.ingotSilver)
			.addInput('S', Items.STICK)
			.create("silverHoeLeft", new ItemStack(DEEPItems.silverHoe, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AAA","A A")
			.addInput('A', DEEPItems.ingotSilver)
			.create("silverHelmet", new ItemStack(DEEPItems.silverHelmet, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("A A","AAA","AAA")
			.addInput('A', DEEPItems.ingotSilver)
			.create("silverChestplate", new ItemStack(DEEPItems.silverChestplate, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AAA","A A","A A")
			.addInput('A', DEEPItems.ingotSilver)
			.create("silverLeggings", new ItemStack(DEEPItems.silverLeggings, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("A A","A A")
			.addInput('A', DEEPItems.ingotSilver)
			.create("silverBoots", new ItemStack(DEEPItems.silverBoots, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" S ","IUI"," I ")
			.addInput('U', DEEPItems.uranium)
			.addInput('S', Items.STRING)
			.addInput('I', Items.INGOT_IRON)
			.create("uraniumExplosiveCharge", new ItemStack(Items.AMMO_CHARGE_EXPLOSIVE, 16));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" S ","PUP"," P ")
			.addInput('U', DEEPItems.uranium)
			.addInput('S', Items.STRING)
			.addInput('P', Items.PAPER)
			.create("uraniumTNT", new ItemStack(Blocks.TNT, 8));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("U","S")
			.addInput('U', DEEPItems.uranium)
			.addInput('S', Items.STICK)
			.create("uraniumTorch", new ItemStack(Blocks.TORCH_COAL, 12));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("UUU","U U","UUU")
			.addInput('U', DEEPItems.uranium)
			.create("uraniumToBlock", new ItemStack(DEEPBlocks.uraniumBlock, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("U")
			.addInput('U', DEEPBlocks.uraniumBlock)
			.create("blockToUranium", new ItemStack(DEEPItems.uranium, 8));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.ingotLead)
			.addInput(Items.DYE, DyeColor.RED.itemMeta)
			.create("leadToRedDye", new ItemStack(Items.DYE, 8, DyeColor.RED.itemMeta));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.ingotLead)
			.addInput(Items.DYE, DyeColor.ORANGE.itemMeta)
			.create("leadToOrangeDye", new ItemStack(Items.DYE, 8, DyeColor.ORANGE.itemMeta));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.ingotLead)
			.addInput(Items.DYE, DyeColor.YELLOW.itemMeta)
			.create("leadToYellowDye", new ItemStack(Items.DYE, 8, DyeColor.YELLOW.itemMeta));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.ingotLead)
			.addInput(Items.DYE, DyeColor.GREEN.itemMeta)
			.create("leadToGreenDye", new ItemStack(Items.DYE, 8, DyeColor.GREEN.itemMeta));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.ingotLead)
			.addInput(Items.DYE, DyeColor.LIME.itemMeta)
			.create("leadToLimeDye", new ItemStack(Items.DYE, 4, DyeColor.LIME.itemMeta));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.ingotLead)
			.addInput(Items.DYE, DyeColor.CYAN.itemMeta)
			.create("leadToCyanDye", new ItemStack(Items.DYE, 6, DyeColor.CYAN.itemMeta));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.ingotLead)
			.addInput(Items.DYE, DyeColor.BLUE.itemMeta)
			.create("leadToBlueDye", new ItemStack(Items.DYE, 4, DyeColor.BLUE.itemMeta));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.ingotLead)
			.addInput(Items.DYE, DyeColor.LIGHT_BLUE.itemMeta)
			.create("leadToLightBlueDye", new ItemStack(Items.DYE, 8, DyeColor.LIGHT_BLUE.itemMeta));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.ingotLead)
			.addInput(Items.DYE, DyeColor.PURPLE.itemMeta)
			.create("leadToPurpleDye", new ItemStack(Items.DYE, 8, DyeColor.PURPLE.itemMeta));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.ingotLead)
			.addInput(Items.DYE, DyeColor.MAGENTA.itemMeta)
			.create("leadToMagentaDye", new ItemStack(Items.DYE, 8, DyeColor.MAGENTA.itemMeta));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.ingotLead)
			.addInput(Items.DYE, DyeColor.PINK.itemMeta)
			.create("leadToPinkDye", new ItemStack(Items.DYE, 8, DyeColor.PINK.itemMeta));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.ingotLead)
			.addInput(Items.DYE, DyeColor.BLACK.itemMeta)
			.create("leadToBlackDye", new ItemStack(Items.DYE, 6, DyeColor.BLACK.itemMeta));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.ingotLead)
			.addInput(Items.DYE, DyeColor.GRAY.itemMeta)
			.create("leadToGrayDye", new ItemStack(Items.DYE, 4, DyeColor.GRAY.itemMeta));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.ingotLead)
			.addInput(Items.DYE, DyeColor.SILVER.itemMeta)
			.create("leadToSilverDye", new ItemStack(Items.DYE, 4, DyeColor.SILVER.itemMeta));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("LLL","LLL","LLL")
			.addInput('L', DEEPItems.ingotLead)
			.create("silverToLead", new ItemStack(DEEPBlocks.leadBlock, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("L")
			.addInput('L', DEEPBlocks.leadBlock)
			.create("blockToLead", new ItemStack(DEEPItems.ingotLead, 9));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.ingotLead)
			.addInput(Blocks.GLASS)
			.addInput(Blocks.GLASS)
			.addInput(DEEPItems.ingotLead)
			.create("leadedGlass", new ItemStack(DEEPBlocks.leadedGlass, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AAA"," S "," S ")
			.addInput('A', DEEPItems.ingotLead)
			.addInput('S', Items.STICK)
			.create("leadPickaxe", new ItemStack(DEEPItems.leadPickaxe, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AA ","AS "," S ")
			.addInput('A', DEEPItems.ingotLead)
			.addInput('S', Items.STICK)
			.create("leadAxeLeft", new ItemStack(DEEPItems.leadAxe, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AA","SA","S ")
			.addInput('A', DEEPItems.ingotLead)
			.addInput('S', Items.STICK)
			.create("leadAxeRight", new ItemStack(DEEPItems.leadAxe, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("A","A","S")
			.addInput('A', DEEPItems.ingotLead)
			.addInput('S', Items.STICK)
			.create("leadSword", new ItemStack(DEEPItems.leadSword, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("A","S","S")
			.addInput('A', DEEPItems.ingotLead)
			.addInput('S', Items.STICK)
			.create("leadShovel", new ItemStack(DEEPItems.leadShovel, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AA","S ","S ")
			.addInput('A', DEEPItems.ingotLead)
			.addInput('S', Items.STICK)
			.create("leadHoeRight", new ItemStack(DEEPItems.leadHoe, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AA"," S"," S")
			.addInput('A', DEEPItems.ingotLead)
			.addInput('S', Items.STICK)
			.create("leadHoeLeft", new ItemStack(DEEPItems.leadHoe, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("BB","BB")
			.addInput('B', DEEPItems.clayBrickBlue)
			.create("blueClayBricks", new ItemStack(DEEPBlocks.brickClayBlue, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RR","RR")
			.addInput('R', DEEPItems.clayRed)
			.create("redClayBlock", new ItemStack(DEEPBlocks.blockClayRed, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.brickClayBlue)
			.create("blueClayBrickSlab", new ItemStack(DEEPBlocks.slabBrickClayBlue, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.brickClayBlue)
			.create("blueClayBrickStairs", new ItemStack(DEEPBlocks.stairsBrickClayBlue, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("B","B")
			.addInput('B', DEEPBlocks.brickClayBlue)
			.create("blueCeramicTiles", new ItemStack(DEEPBlocks.tileCeramicBlue, 2));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("B","B")
			.addInput('B', Blocks.BRICK_CLAY)
			.create("redCeramicTiles", new ItemStack(DEEPBlocks.tileCeramicRed, 2));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.tileCeramicBlue)
			.create("blueCeramicTileSlab", new ItemStack(DEEPBlocks.slabTileCeramicBlue, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.tileCeramicBlue)
			.create("blueCeramicTileStairs", new ItemStack(DEEPBlocks.stairsTileCeramicBlue, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.tileCeramicRed)
			.create("redCeramicTileSlab", new ItemStack(DEEPBlocks.slabTileCeramicRed, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.tileCeramicRed)
			.create("redCeramicTileStairs", new ItemStack(DEEPBlocks.stairsTileCeramicRed, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("N")
			.addInput('N', DEEPItems.niter)
			.create("niterToBonemeal", new ItemStack(Items.DYE, 1, DyeColor.WHITE.itemMeta));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.niter)
			.addInput(Items.COAL)
			.create("niterToGunpowder", new ItemStack(Items.SULPHUR, 2));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.niter)
			.addInput(Items.COAL, 1)
			.create("niterToGunpowderCharcoal", new ItemStack(Items.SULPHUR, 2));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.niter)
			.addInput(Items.AMMO_PEBBLE)
			.addInput(Items.AMMO_PEBBLE)
			.addInput(DEEPItems.niter)
			.create("niterGravel", new ItemStack(Blocks.GRAVEL, 1));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.niter)
			.addInput(Items.FLINT)
			.addInput(Items.FLINT)
			.addInput(DEEPItems.niter)
			.create("niterFlintGravel", new ItemStack(Blocks.GRAVEL, 1));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Items.QUARTZ)
			.addInput(Blocks.MUSHROOM_BROWN)
			.addInput(Blocks.MUSHROOM_RED)
			.addInput(Items.QUARTZ)
			.create("pigMosaic", new ItemStack(DEEPBlocks.mosaicPig, 4));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Items.OLIVINE)
			.addInput(Items.SULPHUR)
			.addInput(Items.SULPHUR)
			.addInput(Items.OLIVINE)
			.create("creeperMosaic", new ItemStack(DEEPBlocks.mosaicCreeper, 4));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Items.DIAMOND)
			.addInput(Items.CLOTH)
			.addInput(Items.CLOTH)
			.addInput(Items.DIAMOND)
			.create("humanMosaic", new ItemStack(DEEPBlocks.mosaicSteve, 4));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.gel)
			.addInput(Blocks.ALGAE)
			.addInput(DEEPItems.gel)
			.addInput(Blocks.ALGAE)
			.addInput(DEEPItems.gel)
			.addInput(Blocks.ALGAE)
			.addInput(DEEPItems.gel)
			.addInput(Blocks.ALGAE)
			.addInput(DEEPItems.gel)
			.create("gelToSlime", new ItemStack(Items.SLIMEBALL, 1));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Items.DUST_SUGAR)
			.addInput(DEEPItems.gel)
			.addInput(DEEPItems.gel)
			.addInput(Items.JAR)
			.create("gelToSlime", new ItemStack(DEEPItems.jelly, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("S "," S")
			.addInput('S', Items.INGOT_STEEL_CRUDE)
			.create("wireframeSteel", new ItemStack(DEEPBlocks.wireframeSteel, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" S","S ")
			.addInput('S', Items.INGOT_STEEL_CRUDE)
			.create("wireframeSteel", new ItemStack(DEEPBlocks.wireframeSteel, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RR","RR")
			.addInput('R', Items.OLIVINE)
			.create("olivineToBrick", new ItemStack(DEEPBlocks.olivineBrick, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.olivineBrick)
			.create("olivineBrickSlab", new ItemStack(DEEPBlocks.slabOlivineBrick, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.olivineBrick)
			.create("olivineBrickStairs", new ItemStack(DEEPBlocks.stairsOlivineBrick, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RR","RR")
			.addInput('R', Items.DIAMOND)
			.create("diamondToBrick", new ItemStack(DEEPBlocks.diamondBrick, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.diamondBrick)
			.create("diamondBrickSlab", new ItemStack(DEEPBlocks.slabDiamondBrick, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.diamondBrick)
			.create("diamondBrickStairs", new ItemStack(DEEPBlocks.stairsDiamondBrick, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RR","RR")
			.addInput('R', Items.QUARTZ)
			.create("quartzToBrick", new ItemStack(DEEPBlocks.quartzBrick, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.quartzBrick)
			.create("quartzBrickSlab", new ItemStack(DEEPBlocks.slabQuartzBrick, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.quartzBrick)
			.create("quartzBrickStairs", new ItemStack(DEEPBlocks.stairsQuartzBrick, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RR","RR")
			.addInput('R', DEEPItems.amethyst)
			.create("amethystToBrick", new ItemStack(DEEPBlocks.amethystBrick, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.amethystBrick)
			.create("amethystBrickSlab", new ItemStack(DEEPBlocks.slabAmethystBrick, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.amethystBrick)
			.create("amethystBrickStairs", new ItemStack(DEEPBlocks.stairsAmethystBrick, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RR","RR")
			.addInput('R', DEEPItems.ingotSilver)
			.create("silverToBrick", new ItemStack(DEEPBlocks.silverBrick, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.silverBrick)
			.create("silverBrickSlab", new ItemStack(DEEPBlocks.slabSilverBrick, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.silverBrick)
			.create("silverBrickStairs", new ItemStack(DEEPBlocks.stairsSilverBrick, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RR","RR")
			.addInput('R', DEEPItems.ingotLead)
			.create("leadToBrick", new ItemStack(DEEPBlocks.leadBrick, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.leadBrick)
			.create("leadBrickSlab", new ItemStack(DEEPBlocks.slabLeadBrick, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.leadBrick)
			.create("leadBrickStairs", new ItemStack(DEEPBlocks.stairsLeadBrick, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("EEE","EEE","EEE")
			.addInput('E', DEEPBlocks.mushroomExplosive)
			.create("explosiveMushroomToGunpowder", new ItemStack(Items.SULPHUR, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("C")
			.addInput('C', DEEPBlocks.mushroomBlue)
			.create("cyanMushroomToCyanDye", new ItemStack(Items.DYE, 3, DyeColor.CYAN.itemMeta));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SSS","SAS","SSS")
			.addInput('S', DEEPBlocks.silverBlock)
			.addInput('A', Items.FOOD_APPLE)
			.create("silverApple", new ItemStack(DEEPItems.silverApple, 1));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Blocks.DIRT)
			.addInput(Blocks.GRAVEL)
			.addInput(Blocks.GRAVEL)
			.addInput(Blocks.DIRT)
			.create("coarseDirt", new ItemStack(DEEPBlocks.coarseDirt, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("V","T")
			.addInput('T', Items.STICK)
			.addInput('V', DEEPItems.ingotSilver)
			.create("silverThrowingKnife", new ItemStack(DEEPItems.ammoKnifeSilver, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" ER","E R"," ER")
			.addInput('E', Items.INGOT_STEEL_CRUDE)
			.addInput('R', Items.STRING)
			.create("steelBow", new ItemStack(DEEPItems.toolBowSteel, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("CCC","CCC","CCC")
			.addInput('C', DEEPBlocks.cattailBottom)
			.create("cattailToWool", new ItemStack(Blocks.WOOL, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("  E"," ER","E R")
			.addInput('E', Items.INGOT_STEEL_CRUDE)
			.addInput('R', Items.STRING)
			.create("steelFishingRod", new ItemStack(DEEPItems.toolFishingRodSteel, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("L")
			.addInput('L', DEEPBlocks.lilypad)
			.create("lilypadToMagentaDye", new ItemStack(Items.DYE, 2, DyeColor.MAGENTA.itemMeta));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SSS","SIS","SSS")
			.addInput('S', DEEPItems.ingotSilver)
			.addInput('I', DEEPItems.cryocoal)
			.create("freezer", new ItemStack(DEEPBlocks.freezerIdle, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("L","L")
			.addInput('L',"minecraft:logs")
			.create("logsToSticks", new ItemStack(Items.STICK, 16));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("LL","LL")
			.addInput('L',"minecraft:logs")
			.create("logsToWorkbenches", new ItemStack(Blocks.WORKBENCH, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("S")
			.addInput('S', Blocks.BLOCK_SUGARCANE)
			.create("sugarcaneBlockToSugarcane", new ItemStack(Items.SUGARCANE, 9));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RR","RR")
			.addInput('R', DEEPBlocks.rhodoniteBrick)
			.create("rhodoniteBricksToTiles", new ItemStack(DEEPBlocks.rhodoniteTile, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.rhodoniteTile)
			.create("rhodoniteTileSlab", new ItemStack(DEEPBlocks.slabRhodoniteTile, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.rhodoniteTile)
			.create("rhodoniteTileStairs", new ItemStack(DEEPBlocks.stairsRhodoniteTile, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("LL","LL")
			.addInput('L', Blocks.BRICK_LAPIS)
			.create("lapisBricksToTiles", new ItemStack(DEEPBlocks.lapisTile, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("LLL")
			.addInput('L', DEEPBlocks.lapisTile)
			.create("lapisTileSlab", new ItemStack(DEEPBlocks.slabLapisTile, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("L  ","LL ","LLL")
			.addInput('L', DEEPBlocks.lapisTile)
			.create("lapisTileStairs", new ItemStack(DEEPBlocks.stairsLapisTile, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" L ","LGL"," L ")
			.addInput('L', Items.DYE, DyeColor.BLUE.itemMeta)
			.addInput('G', Items.INGOT_GOLD)
			.create("lapisSol", new ItemStack(DEEPBlocks.lapisSol, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" L ","LSL"," L ")
			.addInput('L', Items.DYE, DyeColor.BLUE.itemMeta)
			.addInput('S', DEEPItems.ingotSilver)
			.create("lapisLuna", new ItemStack(DEEPBlocks.lapisLuna, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("L")
			.addInput('L', Blocks.BRICK_LAPIS)
			.create("lapisBricksToBulb", new ItemStack(DEEPBlocks.lapisBulb, 8));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R")
			.addInput('R', DEEPBlocks.rhodoniteBrick)
			.create("rhodniteBricksToBulb", new ItemStack(DEEPBlocks.rhodoniteBulb, 8));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" L ","LSL"," L ")
			.addInput('L', Blocks.LADDER_OAK)
			.addInput('S', Items.INGOT_STEEL_CRUDE)
			.create("ladderToSteelLadder", new ItemStack(DEEPBlocks.ladderSteel, 4));

		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Blocks.SAND)
			.addInput(Blocks.BLOCK_CLAY)
			.addInput(Blocks.BLOCK_CLAY)
			.addInput(Blocks.SAND)
			.create("siltBlue", new ItemStack(DEEPBlocks.silt, 2));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Blocks.SAND)
			.addInput(DEEPBlocks.blockClayRed)
			.addInput(DEEPBlocks.blockClayRed)
			.addInput(Blocks.SAND)
			.create("siltRed", new ItemStack(DEEPBlocks.silt, 2));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput("minecraft:cobblestones")
			.addInput(DEEPBlocks.silt)
			.addInput(DEEPBlocks.silt)
			.addInput("minecraft:cobblestones")
			.create("stucco", new ItemStack(DEEPBlocks.stucco, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SS","SS")
			.addInput('S', DEEPBlocks.stucco)
			.create("carvedStucco", new ItemStack(DEEPBlocks.stuccoCarved, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SSS","S S","SSS")
			.addInput('S', DEEPItems.ingotSilver)
			.create("silverMesh", new ItemStack(DEEPBlocks.meshSilver, 8));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("ITI","ITI")
			.addInput('I', DEEPItems.ingotSilver)
			.addInput('T', Items.STICK)
			.create("silverFence", new ItemStack(DEEPBlocks.fenceSilver, 8));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("GSG","GSG")
			.addInput('G', Items.INGOT_GOLD)
			.addInput('S', Items.STICK)
			.create("goldFence", new ItemStack(DEEPBlocks.fenceGold, 8));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("LSL","LSL")
			.addInput('L', DEEPItems.ingotLead)
			.addInput('S', Items.STICK)
			.create("leadFence", new ItemStack(DEEPBlocks.fenceLead, 8));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("L L"," L ")
			.addInput('L', DEEPItems.ingotLead)
			.create("drainBucket", new ItemStack(DEEPItems.bucketDrain, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("TRT","NNN")
			.addInput('R', Items.DUST_REDSTONE)
			.addInput('T', Blocks.TORCH_REDSTONE_ACTIVE)
			.addInput('N', Blocks.COBBLE_NETHERRACK)
			.create("bigRepeater", new ItemStack(DEEPItems.bigRepeater, 1));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Items.AMMO_PEBBLE)
			.addInput(Items.DYE, DyeColor.BLUE.itemMeta)
			.addInput(Items.DYE, DyeColor.BLUE.itemMeta)
			.addInput(Items.AMMO_PEBBLE)
			.create("pebbleToCobbledAbyssalrite", new ItemStack(DEEPBlocks.abyssalriteCobbled, 2));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" AA","RBA","BS ")
			.addInput('A', DEEPItems.amethyst)
			.addInput('S', Items.STICK)
			.addInput('R', Items.DUST_REDSTONE)
			.addInput('B',"minecraft:stones")
			.create("amethystDrill", new ItemStack(DEEPItems.amethystDrill, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" AA","RBA","BS ")
			.addInput('A', DEEPItems.ingotSilver)
			.addInput('S', Items.STICK)
			.addInput('R', Items.DUST_REDSTONE)
			.addInput('B',"minecraft:stones")
			.create("silverDrill", new ItemStack(DEEPItems.silverDrill, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" AA","RBA","BS ")
			.addInput('A', DEEPItems.ingotLead)
			.addInput('S', Items.STICK)
			.addInput('R', Items.DUST_REDSTONE)
			.addInput('B',"minecraft:stones")
			.create("leadDrill", new ItemStack(DEEPItems.leadDrill, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" AA","RBA","BS ")
			.addInput('A', Items.INGOT_IRON)
			.addInput('S', Items.STICK)
			.addInput('R', Items.DUST_REDSTONE)
			.addInput('B',"minecraft:stones")
			.create("ironDrill", new ItemStack(DEEPItems.ironDrill, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" AA","RBA","BS ")
			.addInput('A', Items.INGOT_GOLD)
			.addInput('S', Items.STICK)
			.addInput('R', Items.DUST_REDSTONE)
			.addInput('B',"minecraft:stones")
			.create("goldDrill", new ItemStack(DEEPItems.goldDrill, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" AA","RBA","BS ")
			.addInput('A', Items.INGOT_STEEL)
			.addInput('S', Items.STICK)
			.addInput('R', Items.DUST_REDSTONE)
			.addInput('B',"minecraft:stones")
			.create("steelDrill", new ItemStack(DEEPItems.steelDrill, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" AA","RBA","BS ")
			.addInput('A', Items.DIAMOND)
			.addInput('S', Items.STICK)
			.addInput('R', Items.DUST_REDSTONE)
			.addInput('B',"minecraft:stones")
			.create("diamondDrill", new ItemStack(DEEPItems.diamondDrill, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("B B"," B ")
			.addInput('B',"deep:clayBricks")
			.create("ceramicBucket", new ItemStack(DEEPItems.bucketCeramicEmpty, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SSS","SSS","SSS")
			.addInput('S', Items.DUST_SUGAR)
			.create("sugartosugarblock", new ItemStack(DEEPBlocks.blockSugar, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("S")
			.addInput('S', DEEPBlocks.blockSugar)
			.create("sugarblocktosugar", new ItemStack(Items.DUST_SUGAR, 9));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SSS","SSS","SSS")
			.addInput('S', Items.STRING)
			.create("stringtostringblock", new ItemStack(DEEPBlocks.blockString, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("S")
			.addInput('S', DEEPBlocks.blockString)
			.create("stringblocktostring", new ItemStack(Items.STRING, 9));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SSS","SSS","SSS")
			.addInput('S', Items.CLOTH)
			.create("clothtoclothblock", new ItemStack(DEEPBlocks.blockCloth, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("S")
			.addInput('S', DEEPBlocks.blockCloth)
			.create("clothblocktocloth", new ItemStack(Items.CLOTH, 9));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SSS","SSS","SSS")
			.addInput('S', Items.LEATHER)
			.create("leathertoleatherblock", new ItemStack(DEEPBlocks.blockLeather, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("S")
			.addInput('S', DEEPBlocks.blockLeather)
			.create("leatherblocktoleather", new ItemStack(Items.LEATHER, 9));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SSS","SSS","SSS")
			.addInput('S', Items.CHAINLINK)
			.create("chainlinktochainlinkblock", new ItemStack(DEEPBlocks.blockChainlink, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("S")
			.addInput('S', DEEPBlocks.blockChainlink)
			.create("chainlinkblocktochainlink", new ItemStack(Items.CHAINLINK, 9));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SSS","SSS","SSS")
			.addInput('S', Items.FEATHER_CHICKEN)
			.create("feathertofeatherblock", new ItemStack(DEEPBlocks.blockFeather, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("S")
			.addInput('S', DEEPBlocks.blockFeather)
			.create("featherblocktofeather", new ItemStack(Items.FEATHER_CHICKEN, 9));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SSS","SSS","SSS")
			.addInput('S', Items.SULPHUR)
			.create("gunpowdertogunpowderblock", new ItemStack(DEEPBlocks.blockGunpowder, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("S")
			.addInput('S', DEEPBlocks.blockGunpowder)
			.create("gunpowderblocktogunpowder", new ItemStack(Items.SULPHUR, 9));
		RecipeBuilder.ModifyWorkbench("minecraft").removeRecipe("cobweb");
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("S S"," S ","S S")
			.addInput('S', Items.STRING)
			.create("cobweb", new ItemStack(Blocks.COBWEB, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SS","SS")
			.addInput('S', DEEPItems.salt)
			.create("saltblock", new ItemStack(DEEPBlocks.blockSalt, 1));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Items.AMMO_PEBBLE)
			.addInput(Items.OLIVINE)
			.addInput(Items.OLIVINE)
			.addInput(Items.AMMO_PEBBLE)
			.create("pebbleToCobbledPeridotite", new ItemStack(DEEPBlocks.peridotiteCobbled, 2));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Items.AMMO_PEBBLE)
			.addInput(DEEPItems.salt)
			.addInput(DEEPItems.salt)
			.addInput(Items.AMMO_PEBBLE)
			.create("pebbleToCobbledPearlstone", new ItemStack(DEEPBlocks.pearlstoneCobbled, 2));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Items.PAPER)
			.addInput(DEEPItems.salt)
			.addInput(Items.DUST_SUGAR)
			.addInput(DEEPItems.salt)
			.addInput(Items.DUST_SUGAR)
			.addInput(Items.PAPER)
			.create("taffy", new ItemStack(DEEPItems.taffy, 2));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("BBB","BAB","TTT")
			.addInput('B',"deep:clayBricks")
			.addInput('A', DEEPItems.salt)
			.addInput('T',"minecraft:stones")
			.create("brickOven", new ItemStack(DEEPBlocks.brickOvenIdle, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SSS","SSS")
			.addInput('S', Items.INGOT_GOLD)
			.create("goldTrapdoor", new ItemStack(DEEPBlocks.trapdoorGold, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SS","SS","SS")
			.addInput('S', Items.INGOT_GOLD)
			.create("goldDoor", new ItemStack(DEEPItems.doorGold, 2));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SSS","SSS")
			.addInput('S', DEEPItems.ingotSilver)
			.create("silverTrapdoor", new ItemStack(DEEPBlocks.trapdoorSilver, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SS","SS","SS")
			.addInput('S', DEEPItems.ingotSilver)
			.create("silverDoor", new ItemStack(DEEPItems.doorSilver, 2));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SSS","SSS")
			.addInput('S', DEEPItems.ingotLead)
			.create("leadTrapdoor", new ItemStack(DEEPBlocks.trapdoorLead, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SS","SS","SS")
			.addInput('S', DEEPItems.ingotLead)
			.create("leadDoor", new ItemStack(DEEPItems.doorLead, 2));

		RecipeBuilder.ModifyWorkbench("minecraft").removeRecipe("rail");
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("I I","ISI","I I")
			.addInput('I', Items.INGOT_IRON)
			.addInput('S', Items.STICK)
			.create("rail", new ItemStack(Blocks.RAIL, 32));
		RecipeBuilder.ModifyWorkbench("minecraft").removeRecipe("powered_rail");
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("I I","ISI","IRI")
			.addInput('I', Items.INGOT_GOLD)
			.addInput('R', Items.DUST_REDSTONE)
			.addInput('S', Items.STICK)
			.create("powered_rail", new ItemStack(Blocks.RAIL_POWERED, 16));
		RecipeBuilder.ModifyWorkbench("minecraft").removeRecipe("detector_rail");
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("I I","IPI","IRI")
			.addInput('I', Items.INGOT_IRON)
			.addInput('R', Items.DUST_REDSTONE)
			.addInput('P',"minecraft:pressureplates")
			.create("detector_rail", new ItemStack(Blocks.RAIL_DETECTOR, 32));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R","R")
			.addInput('R', DEEPBlocks.abyssalrite)
			.create("abyssalritePolished", new ItemStack(DEEPBlocks.abyssalritePolished, 2));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.abyssalritePolished)
			.create("abyssalritePolishedSlab", new ItemStack(DEEPBlocks.abyssalritePolishedSlab, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RR","RR")
			.addInput('R', DEEPBlocks.abyssalrite)
			.create("abyssalriteBrick", new ItemStack(DEEPBlocks.abyssalriteBrick, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.abyssalriteBrick)
			.create("abyssalriteBrickSlab", new ItemStack(DEEPBlocks.abyssalriteBrickSlab, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.abyssalriteBrick)
			.create("abyssalriteBrickStairs", new ItemStack(DEEPBlocks.abyssalriteBrickStairs, 6));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R","R")
			.addInput('R', DEEPBlocks.pearlstone)
			.create("pearlstonePolished", new ItemStack(DEEPBlocks.pearlstonePolished, 2));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.pearlstonePolished)
			.create("pearlstonePolishedSlab", new ItemStack(DEEPBlocks.pearlstonePolishedSlab, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RR","RR")
			.addInput('R', DEEPBlocks.pearlstone)
			.create("pearlstoneBrick", new ItemStack(DEEPBlocks.pearlstoneBrick, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.pearlstoneBrick)
			.create("pearlstoneBrickSlab", new ItemStack(DEEPBlocks.pearlstoneBrickSlab, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.pearlstoneBrick)
			.create("pearlstoneBrickStairs", new ItemStack(DEEPBlocks.pearlstoneBrickStairs, 6));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R","R")
			.addInput('R', DEEPBlocks.peridotite)
			.create("peridotitePolished", new ItemStack(DEEPBlocks.peridotitePolished, 2));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.peridotitePolished)
			.create("peridotitePolishedSlab", new ItemStack(DEEPBlocks.peridotitePolishedSlab, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RR","RR")
			.addInput('R', DEEPBlocks.peridotite)
			.create("peridotiteBrick", new ItemStack(DEEPBlocks.peridotiteBrick, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.peridotiteBrick)
			.create("peridotiteBrickSlab", new ItemStack(DEEPBlocks.peridotiteBrickSlab, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.peridotiteBrick)
			.create("peridotiteBrickStairs", new ItemStack(DEEPBlocks.peridotiteBrickStairs, 6));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("G")
			.addInput('G', DEEPBlocks.mushroomGray)
			.create("grayMushroomToGrayDye", new ItemStack(Items.DYE, 3, DyeColor.GRAY.itemMeta));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("S")
			.addInput('S', DEEPBlocks.mushroomSilver)
			.create("silverMushroomToSilverDye", new ItemStack(Items.DYE, 3, DyeColor.SILVER.itemMeta));
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Items.BOWL)
			.addInput(DEEPBlocks.mushroomYellow)
			.addInput(DEEPBlocks.mushroomYellow)
			.addInput(DEEPBlocks.mushroomYellow)
			.create("yellowMushroomStew", Items.FOOD_STEW_MUSHROOM.getDefaultStack());
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Items.BOWL)
			.addInput(DEEPBlocks.mushroomGray)
			.addInput(DEEPBlocks.mushroomGray)
			.addInput(Blocks.MUSHROOM_BROWN)
			.addInput(Blocks.MUSHROOM_BROWN)
			.create("grayAndSilverMushroomStew", Items.FOOD_STEW_MUSHROOM.getDefaultStack());
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Items.BOWL)
			.addInput(DEEPBlocks.mushroomExplosive)
			.addInput(DEEPBlocks.mushroomExplosive)
			.addInput(DEEPBlocks.mushroomExplosive)
			.addInput(DEEPBlocks.mushroomExplosive)
			.addInput(DEEPBlocks.mushroomExplosive)
			.addInput(Blocks.MUSHROOM_RED)
			.addInput(Blocks.MUSHROOM_RED)
			.create("grayAndSilverMushroomStew", Items.FOOD_STEW_MUSHROOM.getDefaultStack());
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(DEEPItems.huskBeetle)
			.create("huskBeetleToRedDye", new ItemStack(Items.DYE, 4, DyeColor.RED.itemMeta));
		RecipeBuilder.ModifyWorkbench("minecraft").removeRecipe("cobblestone_pressure_plate");
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("CC")
			.addInput('C', Blocks.COBBLE_STONE)
			.create("cobblestonePressurePlate", new ItemStack(Blocks.PRESSURE_PLATE_COBBLE_STONE, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("CC")
			.addInput('C', Blocks.COBBLE_BASALT)
			.create("cobbleBasaltPressurePlate", new ItemStack(DEEPBlocks.pressureplateCobbleBasalt, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("CC")
			.addInput('C', Blocks.COBBLE_LIMESTONE)
			.create("cobbleLimestonePressurePlate", new ItemStack(DEEPBlocks.pressureplateCobbleLimestone, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("CC")
			.addInput('C', Blocks.COBBLE_GRANITE)
			.create("cobbleGranitePressurePlate", new ItemStack(DEEPBlocks.pressureplateCobbleGranite, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("CC")
			.addInput('C', Blocks.COBBLE_PERMAFROST)
			.create("cobblePermafrostPressurePlate", new ItemStack(DEEPBlocks.pressureplateCobblePermafrost, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("CC")
			.addInput('C', Blocks.COBBLE_NETHERRACK)
			.create("cobbleNetherrackPressurePlate", new ItemStack(DEEPBlocks.pressureplateCobbleNetherrack, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("CC")
			.addInput('C', DEEPBlocks.abyssalriteCobbled)
			.create("cobbleAbyssalritePressurePlate", new ItemStack(DEEPBlocks.pressureplateCobbleAbyssalrite, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("CC")
			.addInput('C', DEEPBlocks.pearlstoneCobbled)
			.create("cobblePearlstonePressurePlate", new ItemStack(DEEPBlocks.pressureplateCobblePearlstone, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("CC")
			.addInput('C', DEEPBlocks.peridotiteCobbled)
			.create("cobblePeridotitePressurePlate", new ItemStack(DEEPBlocks.pressureplateCobblePeridotite, 1));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R","R")
			.addInput('R', Blocks.MUD_BAKED)
			.create("bakedMudPolished", new ItemStack(DEEPBlocks.packedMud, 2));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RR","RR")
			.addInput('R', DEEPBlocks.packedMud)
			.create("bakedMudBrick", new ItemStack(DEEPBlocks.packedMudBrick, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.packedMudBrick)
			.create("bakedMudBrickSlab", new ItemStack(DEEPBlocks.packedMudBrickSlab, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.packedMudBrick)
			.create("bakedMudBrickStairs", new ItemStack(DEEPBlocks.packedMudBrickStairs, 6));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("F","B")
			.addInput('F', Blocks.FURNACE_STONE_IDLE)
			.addInput('B', Items.BOAT)
			.create("boatFurnace", new ItemStack(DEEPItems.boatFurnace, 1));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RR","RR")
			.addInput('R', DEEPBlocks.scorchedSandstone)
			.create("scorchedSandstoneBrick", new ItemStack(DEEPBlocks.scorchedSandstoneBrick, 4));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.scorchedSandstoneBrick)
			.create("scorchedSandstoneBrickSlab", new ItemStack(DEEPBlocks.scorchedSandstoneBrickSlab, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.scorchedSandstoneBrick)
			.create("scorchedSandstoneBrickStairs", new ItemStack(DEEPBlocks.scorchedSandstoneBrickStairs, 6));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("RRR")
			.addInput('R', DEEPBlocks.scorchedSandstone)
			.create("scorchedSandstoneSlab", new ItemStack(DEEPBlocks.scorchedSandstoneSlab, 6));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("R  ","RR ","RRR")
			.addInput('R', DEEPBlocks.scorchedSandstone)
			.create("scorchedSandstoneStairs", new ItemStack(DEEPBlocks.scorchedSandstoneStairs, 6));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AAA","A A")
			.addInput('A', DEEPItems.ingotLead)
			.create("leadHelmet", new ItemStack(DEEPItems.leadHelmet, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("A A","AAA","AAA")
			.addInput('A', DEEPItems.ingotLead)
			.create("leadChestplate", new ItemStack(DEEPItems.leadChestplate, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AAA","A A","A A")
			.addInput('A', DEEPItems.ingotLead)
			.create("leadLeggings", new ItemStack(DEEPItems.leadLeggings, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("A A","A A")
			.addInput('A', DEEPItems.ingotLead)
			.create("leadBoots", new ItemStack(DEEPItems.leadBoots, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AAA","A A","AAA")
			.addInput('A', DEEPItems.ingotLead)
			.create("leadBoots", new ItemStack(DEEPBlocks.meshLead, 8));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AAA","RBA","BSA")
			.addInput('A', DEEPItems.adamantite)
			.addInput('S', Items.STICK)
			.addInput('R', Items.DUST_REDSTONE)
			.addInput('B', Items.INGOT_STEEL_CRUDE)
			.create("adamantiteDestroyer", new ItemStack(DEEPItems.adamantiteDestroyer, 1));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("AAA","ASA"," S ")
			.addInput('A', DEEPItems.adamantite)
			.addInput('S', Items.INGOT_STEEL_CRUDE)
			.create("adamantiteWarAxe", new ItemStack(DEEPItems.adamantiteWarAxe, 1));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("C","S")
			.addInput('C', DEEPItems.cryocoal)
			.addInput('S', Items.STICK)
			.create("cryoTorch", new ItemStack(DEEPBlocks.cryoTorch, 32));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SSS","S S","SSS")
			.addInput('S', DEEPItems.cryocoal)
			.create("cryocoalToBlock", new ItemStack(DEEPBlocks.cryocoalBlock, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("S")
			.addInput('S', DEEPBlocks.cryocoalBlock)
			.create("blockToCryocoal", new ItemStack(DEEPItems.cryocoal, 8));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("SSS","SSS","SSS")
			.addInput('S', DEEPItems.adamantite)
			.create("cryocoalToBlock", new ItemStack(DEEPBlocks.adamantiteBlock, 1));
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("S")
			.addInput('S', DEEPBlocks.adamantiteBlock)
			.create("blockToCryocoal", new ItemStack(DEEPItems.adamantite, 9));

		RecipeBuilder.ModifyWorkbench("minecraft").removeRecipe("ice_cream_bucket");
		RecipeBuilder.Shaped(MOD_ID)
			.setShape("URA","BCB"," S ")
			.addInput('S', Items.BUCKET_MILK)
			.addInput('B', Items.AMMO_SNOWBALL)
			.addInput('R', Items.FOOD_CHERRY)
			.addInput('U', Items.DUST_SUGAR)
			.addInput('C', Items.DYE, DyeColor.BROWN.itemMeta)
			.addInput('A', DEEPItems.salt)
			.create("ice_cream_bucket", new ItemStack(Items.BUCKET_ICECREAM, 1));

		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Items.AMMO_PEBBLE)
			.addInput(Items.COAL,1)
			.addInput(Items.COAL,1)
			.addInput(Items.AMMO_PEBBLE)
			.create("pebbleToCobbledBasalt", new ItemStack(Blocks.COBBLE_BASALT, 2));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("S S"," S ","S S")
			.addInput('S', Items.ROPE)
			.create("fishnet", new ItemStack(DEEPBlocks.fishnet, 1));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("I  ","WIF"," WB")
			.addInput('B', Items.TOOL_BOW)
			.addInput('W',"minecraft:planks")
			.addInput('F', Items.FLINT)
			.addInput('I', Items.INGOT_IRON)
			.create("musket", new ItemStack(DEEPItems.toolMusket, 1));

		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Items.PAPER)
			.addInput(Items.SULPHUR)
			.addInput(DEEPItems.ingotLead)
			.create("bullet", new ItemStack(DEEPItems.ammoBullet, 4));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("LLL","CSC","LLL")
			.addInput('C', Items.CLOTH)
			.addInput('L', Items.LEATHER)
			.addInput('S', DEEPItems.ingotSilver)
			.create("bandolier", new ItemStack(DEEPItems.armorBandolier, 1, 96));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("LBL","LSL","LRL")
			.addInput('L', Blocks.COBBLE_STONE_MOSSY)
			.addInput('R', Items.DUST_REDSTONE)
			.addInput('B', Items.BONE)
			.addInput('S', DEEPItems.eyeShade)
			.create("motionsensor", new ItemStack(Blocks.MOTION_SENSOR_IDLE, 1));





		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPItems.rawSilver)
			.create("rawSilverToSilverIngot", DEEPItems.ingotSilver.getDefaultStack());
		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput(DEEPItems.rawSilver)
			.create("rawSilverToSilverIngot", DEEPItems.ingotSilver.getDefaultStack());
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPItems.rawLead)
			.create("rawLeadToLeadIngot", DEEPItems.ingotLead.getDefaultStack());
		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput(DEEPItems.rawLead)
			.create("rawLeadToLeadIngot", DEEPItems.ingotLead.getDefaultStack());
		RecipeBuilder.ModifyFurnace("minecraft").removeRecipe("clay_to_brick_clay");
		RecipeBuilder.ModifyBlastFurnace("minecraft").removeRecipe("clay_to_brick_clay");
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(Items.CLAY)
			.create("blue_clay_to_blue_clay_brick", DEEPItems.clayBrickBlue.getDefaultStack());
		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput(Items.CLAY)
			.create("blue_clay_to_blue_clay_brick", DEEPItems.clayBrickBlue.getDefaultStack());
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPItems.clayRed)
			.create("red_clay_to_red_clay_brick", Items.BRICK_CLAY.getDefaultStack());
		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput(DEEPItems.clayRed)
			.create("red_clay_to_red_clay_brick", Items.BRICK_CLAY.getDefaultStack());
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(Items.QUARTZ)
			.create("quartz_to_clear_blass", DEEPBlocks.clearGlass.getDefaultStack());
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPItems.rawSardine)
			.create("cookedSardine", DEEPItems.cookedSardine.getDefaultStack());
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPItems.rawBass)
			.create("cookedSardine", DEEPItems.cookedBass.getDefaultStack());
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPItems.frozenPorkchop)
			.create("thawPorkchop", Items.FOOD_PORKCHOP_RAW.getDefaultStack());
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPItems.frozenSardine)
			.create("thawSardine", DEEPItems.cookedSardine.getDefaultStack());
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPItems.frozenTrout)
			.create("thawTrout", Items.FOOD_FISH_COOKED.getDefaultStack());
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPItems.frozenBass)
			.create("thawBass", DEEPItems.cookedBass.getDefaultStack());
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPItems.frozenCake)
			.create("thawCake", Items.FOOD_CAKE.getDefaultStack());
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPItems.frozenPumpkinPie)
			.create("thawPumpkinPie", Items.FOOD_PUMPKIN_PIE.getDefaultStack());
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPItems.frozenCookie)
			.create("thawCookie", Items.FOOD_COOKIE.getDefaultStack());
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPItems.frozenApple)
			.create("thawApple", Items.FOOD_APPLE.getDefaultStack());
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPItems.frozenCherry)
			.create("thawCherry", Items.FOOD_CHERRY.getDefaultStack());
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPItems.frozenBread)
			.create("thawBread", Items.FOOD_BREAD.getDefaultStack());
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPBlocks.abyssalriteCobbled)
			.create("cobbledAbyssalriteToAbyssalrite", DEEPBlocks.abyssalrite.getDefaultStack());
		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput(DEEPBlocks.abyssalriteCobbled)
			.create("cobbledAbyssalriteToLapis", new ItemStack(Items.DYE, 1, DyeColor.BLUE.itemMeta));
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPBlocks.pearlstoneCobbled)
			.create("cobbledPearlstoneToPearlstone", DEEPBlocks.pearlstone.getDefaultStack());
		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput(DEEPBlocks.pearlstoneCobbled)
			.create("cobbledPearlstoneToSalt", new ItemStack(Items.QUARTZ.getDefaultStack()));
		RecipeBuilder.Furnace(MOD_ID)
			.setInput(DEEPBlocks.peridotiteCobbled)
			.create("cobbledPeridotiteToPeridotite", DEEPBlocks.peridotite.getDefaultStack());
		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput(DEEPBlocks.peridotiteCobbled)
			.create("cobbledPeridotiteToOlivine", new ItemStack(Items.OLIVINE.getDefaultStack()));
		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput(Items.CLAY)
			.create("blue_clay_to_red_clay", DEEPItems.clayRed.getDefaultStack());




		RecipeBuilder.ModifyTrommel("minecraft", "clay").deleteRecipe();
		RecipeBuilder.Trommel(MOD_ID)
			.setInput(DEEPBlocks.blockClayRed)
			.addEntry(new WeightedRandomLootObject(new ItemStack(DEEPItems.clayRed, 1), 4, 8), 30)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.AMMO_PEBBLE, 1), 1, 3), 20)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.SULPHUR, 1), 1, 3), 10)
			.addEntry(new WeightedRandomLootObject(Items.ORE_RAW_GOLD.getDefaultStack(), 1), 1)
			.addEntry(new WeightedRandomLootObject(new ItemStack(DEEPItems.niter, 1), 1, 2), 5)
			.create("clay_red");
		RecipeBuilder.Trommel(MOD_ID)
			.setInput(Blocks.BLOCK_CLAY)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.CLAY, 1), 4, 8), 30)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.AMMO_PEBBLE, 1), 1, 3), 20)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.SULPHUR, 1), 1, 3), 10)
			.addEntry(new WeightedRandomLootObject(DEEPItems.rawSilver.getDefaultStack(), 1), 1)
			.addEntry(new WeightedRandomLootObject(new ItemStack(DEEPItems.niter, 1), 1, 2), 5)
			.create("clay_blue");
		RecipeBuilder.Trommel(MOD_ID)
			.setInput(Blocks.BLOCK_SNOW)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.AMMO_SNOWBALL, 1), 1, 3), 30)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.AMMO_PEBBLE, 1), 1, 3), 17)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Blocks.ICE, 1), 2, 6), 10)
			.addEntry(new WeightedRandomLootObject(new ItemStack(DEEPItems.niter, 1), 1), 5)
			.create("snow");
		RecipeBuilder.Trommel(MOD_ID)
			.setInput(DEEPBlocks.slush)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.AMMO_SNOWBALL, 1), 1, 3), 15)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.AMMO_PEBBLE, 1), 1, 3), 17)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Blocks.ICE, 1), 2, 6), 25)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.SULPHUR, 1), 2), 10)
			.addEntry(new WeightedRandomLootObject(new ItemStack(DEEPItems.niter, 1), 1), 5)
			.create("slush");
		RecipeBuilder.Trommel(MOD_ID)
			.setInput(DEEPBlocks.silt)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.QUARTZ, 1), 1, 3), 20)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.AMMO_PEBBLE, 1), 1, 3), 20)
			.addEntry(new WeightedRandomLootObject(new ItemStack(DEEPItems.clayRed, 1), 3, 8), 15)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.SULPHUR, 1), 1, 3), 10)
			.addEntry(new WeightedRandomLootObject(DEEPItems.rawSilver.getDefaultStack(), 1), 1)
			.addEntry(new WeightedRandomLootObject(new ItemStack(DEEPItems.niter, 1), 1, 2), 5)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.FLINT, 1), 1, 2), 5)
			.create("silt");
		RecipeBuilder.ModifyTrommel("minecraft", "gravel")
			.addEntry(new WeightedRandomLootObject(DEEPItems.rawLead.getDefaultStack(), 1), 3);
		RecipeBuilder.ModifyTrommel("minecraft", "gravel")
			.addEntry(new WeightedRandomLootObject(DEEPItems.niter.getDefaultStack(), 1, 2), 25);
		RecipeBuilder.ModifyTrommel("minecraft", "rich_dirt")
			.addEntry(new WeightedRandomLootObject(DEEPItems.rawSilver.getDefaultStack(), 1, 2), 11);
		RecipeBuilder.ModifyTrommel("minecraft", "rich_dirt")
			.addEntry(new WeightedRandomLootObject(DEEPItems.rawLead.getDefaultStack(), 1, 3), 11);
		RecipeBuilder.ModifyTrommel("minecraft", "rich_dirt")
			.addEntry(new WeightedRandomLootObject(DEEPItems.clayRed.getDefaultStack(), 4, 8), 11);
		RecipeBuilder.ModifyTrommel("minecraft", "sand")
			.addEntry(new WeightedRandomLootObject(DEEPItems.clayRed.getDefaultStack(), 4, 8), 30);
		RecipeBuilder.ModifyTrommel("minecraft", "dirt")
			.addEntry(new WeightedRandomLootObject(DEEPItems.niter.getDefaultStack(), 1, 3), 10);
		RecipeBuilder.ModifyTrommel("minecraft", "soul_sand")
			.addEntry(new WeightedRandomLootObject(DEEPItems.rhodonite.getDefaultStack(), 2,6), 7);
		RecipeBuilder.Trommel(MOD_ID)
			.setInput(DEEPBlocks.coarseDirt)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.AMMO_PEBBLE, 1), 1, 3), 50)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.OLIVINE, 1), 1), 30)
			.addEntry(new WeightedRandomLootObject(new ItemStack(DEEPItems.clayRed, 1), 1,5), 20)
			.addEntry(new WeightedRandomLootObject(new ItemStack(DEEPItems.niter, 1), 1,3), 10)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.FLINT, 1), 1, 3), 10)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.SULPHUR, 1), 1), 5)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.ORE_RAW_IRON, 1), 1), 5)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.DYE,1, 4), 2,6), 5)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.QUARTZ, 1), 1), 0.5)
			.create("coarseDirt");
		RecipeBuilder.Trommel(MOD_ID)
			.setInput(DEEPBlocks.soulsandRaging)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.BONE, 1), 4, 8), 10)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.ORE_RAW_GOLD, 1), 2), 4)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.ORE_RAW_IRON, 1), 2), 2)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.DUST_GLOWSTONE, 1), 4, 8), 5)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.QUARTZ, 1), 2, 6), 5)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.NETHERCOAL, 1), 1, 2), 1)
			.addEntry(new WeightedRandomLootObject(new ItemStack(DEEPItems.rhodonite, 1), 6, 9), 7)
			.create("soulsandRaging");
		RecipeBuilder.Trommel(MOD_ID)
			.setInput(DEEPBlocks.fossil)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.BONE, 1), 2, 4), 70)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.ORE_RAW_GOLD, 1), 1), 10)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.ORE_RAW_IRON, 1), 1, 2), 15)
			.addEntry(new WeightedRandomLootObject(new ItemStack(DEEPItems.rawLead, 1), 1, 2), 15)
			.addEntry(new WeightedRandomLootObject(new ItemStack(DEEPItems.rawSilver, 1), 1), 10)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.DYE,1, 4), 2,4), 20)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.QUARTZ,1), 1,4), 25)
			.addEntry(new WeightedRandomLootObject(new ItemStack(Items.OLIVINE,1), 1,4), 25)
			.addEntry(new WeightedRandomLootObject(new ItemStack(DEEPItems.clayRed,1), 4,8), 20)
			.create("fossil");



	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
		RecipeBuilder.getRecipeNamespace(MOD_ID);

	}
}
