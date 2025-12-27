package silveon22.deep.block;

import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.material.MaterialColor;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Items;
import net.minecraft.core.item.block.ItemBlockAlgae;
import net.minecraft.core.sound.BlockSound;
import net.minecraft.core.sound.BlockSounds;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import silveon22.deep.block.misc.*;
import silveon22.deep.block.ore.*;
import silveon22.deep.item.DEEPItems;
import silveon22.deep.item.ItemBlockLilypad;
import silveon22.deep.item.ItemBlockFishnet;
import turniplabs.halplibe.helper.BlockBuilder;
import net.minecraft.core.item.block.ItemBlockLadder;

import static net.minecraft.core.block.Blocks.GRAVEL;
import static net.minecraft.core.item.tool.ItemToolPickaxe.miningLevels;
import static silveon22.deep.Deep.MOD_ID;


public class DEEPBlocks {

	// Declaring blocks

	public static Block<?> rhodoniteBlock;
	public static Block<?> rhodoniteBrick;
	public static Block<?> netherrackRhodoniteOre;
	public static Block<BlockLogicSlab> slabRhodoniteBrick;
	public static Block<BlockLogicStairs> stairsRhodoniteBrick;
	public static Block<?> amethystBlock;
	public static Block<?> stoneAmethystOre;
	public static Block<?> basaltAmethystOre;
	public static Block<?> limestoneAmethystOre;
	public static Block<?> graniteAmethystOre;
	public static Block<?> permafrostAmethystOre;
	public static Block<?> silverBlock;
	public static Block<?> stoneSilverOre;
	public static Block<?> basaltSilverOre;
	public static Block<?> limestoneSilverOre;
	public static Block<?> graniteSilverOre;
	public static Block<?> permafrostSilverOre;
	public static Block<?> netherrackSilverOre;
	public static Block<?> uraniumBlock;
	public static Block<?> stoneUraniumOre;
	public static Block<?> basaltUraniumOre;
	public static Block<?> limestoneUraniumOre;
	public static Block<?> graniteUraniumOre;
	public static Block<?> permafrostUraniumOre;
	public static Block<?> leadBlock;
	public static Block<?> leadedGlass;
	public static Block<?> stoneLeadOre;
	public static Block<?> basaltLeadOre;
	public static Block<?> limestoneLeadOre;
	public static Block<?> graniteLeadOre;
	public static Block<?> permafrostLeadOre;
	public static Block<?> blockClayRed;
	public static Block<?> brickClayBlue;
	public static Block<BlockLogicSlab> slabBrickClayBlue;
	public static Block<BlockLogicStairs> stairsBrickClayBlue;
	public static Block<?> tileCeramicRed;
	public static Block<?> tileCeramicBlue;
	public static Block<BlockLogicSlab> slabTileCeramicRed;
	public static Block<BlockLogicStairs> stairsTileCeramicRed;
	public static Block<BlockLogicSlab> slabTileCeramicBlue;
	public static Block<BlockLogicStairs> stairsTileCeramicBlue;
	public static Block<?> netherrackTopazOre;
	public static Block<?> wireframeSteel;
	public static Block<?> mosaicPig;
	public static Block<?> mosaicCreeper;
	public static Block<?> mosaicSteve;
	public static Block<?> clearGlass;
	public static Block<?> olivineBrick;
	public static Block<BlockLogicSlab> slabOlivineBrick;
	public static Block<BlockLogicStairs> stairsOlivineBrick;
	public static Block<?> quartzBrick;
	public static Block<BlockLogicSlab> slabQuartzBrick;
	public static Block<BlockLogicStairs> stairsQuartzBrick;
	public static Block<?> diamondBrick;
	public static Block<BlockLogicSlab> slabDiamondBrick;
	public static Block<BlockLogicStairs> stairsDiamondBrick;
	public static Block<?> amethystBrick;
	public static Block<BlockLogicSlab> slabAmethystBrick;
	public static Block<BlockLogicStairs> stairsAmethystBrick;
	public static Block<?> silverBrick;
	public static Block<BlockLogicSlab> slabSilverBrick;
	public static Block<BlockLogicStairs> stairsSilverBrick;
	public static Block<?> leadBrick;
	public static Block<BlockLogicSlab> slabLeadBrick;
	public static Block<BlockLogicStairs> stairsLeadBrick;
	public static Block<?> mushroomExplosive;
	public static Block<?> mushroomBlue;
	public static Block<?> coarseDirt;
	public static Block<?> coral;
	public static Block<?> cattailBottom;
	public static Block<?> cattailTop;
	public static Block<?> lilypad;
	public static Block<?> freezerIdle;
	public static Block<?> freezerActive;
	public static Block<?> bamboo;
	public static Block<?> scorchedDirtPath;
	public static Block<?> sandPath;
	public static Block<?> lapisTile;
	public static Block<BlockLogicSlab> slabLapisTile;
	public static Block<BlockLogicStairs> stairsLapisTile;
	public static Block<?> rhodoniteTile;
	public static Block<BlockLogicSlab> slabRhodoniteTile;
	public static Block<BlockLogicStairs> stairsRhodoniteTile;
	public static Block<?> lapisSol;
	public static Block<?> lapisLuna;
	public static Block<?> lapisBulb;
	public static Block<?> rhodoniteBulb;
	public static Block<?> root;
	public static Block<BlockLogicLadder> ladderSteel;
	public static Block<?> silt;
	public static Block<?> slush;
	public static Block<?> stucco;
	public static Block<?> stuccoCarved;
	public static Block<?> meshSilver;
	public static Block<BlockLogicFenceThin> fenceGold;
	public static Block<BlockLogicFenceThin> fenceSilver;
	public static Block<BlockLogicFenceThin> fenceLead;
	public static Block<BlockLogicBigRepeater> repeaterBigIdle;
	public static Block<BlockLogicBigRepeater> repeaterBigActive;
	public static Block<BlockLogicRagingSoulSand> soulsandRaging;
	public static Block<?> abyssalrite;
	public static Block<?> abyssalriteCobbled;
	public static Block<BlockLogicSlab> abyssalriteCobbledSlab;
	public static Block<BlockLogicStairs> abyssalriteCobbledStairs;
	public static Block<?> abyssalritePolished;
	public static Block<?> abyssalriteCarved;
	public static Block<BlockLogicSlab> abyssalritePolishedSlab;
	public static Block<?> abyssalriteBrick;
	public static Block<BlockLogicSlab> abyssalriteBrickSlab;
	public static Block<BlockLogicStairs> abyssalriteBrickStairs;
	public static Block<?> abyssalriteAmethystOre;
	public static Block<?> abyssalriteSilverOre;
	public static Block<?> abyssalriteLeadOre;
	public static Block<?> abyssalriteUraniumOre;
	public static Block<?> abyssalriteDiamondOre;
	public static Block<?> abyssalriteGoldOre;
	public static Block<?> abyssalriteIronOre;
	public static Block<?> abyssalriteCoalOre;
	public static Block<?> abyssalriteLapisOre;
	public static Block<?> abyssalriteRedstoneOre;
	public static Block<?> abyssalriteRedstoneGlowingOre;
	public static Block<?> pearlstone;
	public static Block<?> pearlstoneCobbled;
	public static Block<BlockLogicSlab> pearlstoneCobbledSlab;
	public static Block<BlockLogicStairs> pearlstoneCobbledStairs;
	public static Block<?> pearlstonePolished;
	public static Block<?> pearlstoneCarved;
	public static Block<BlockLogicSlab> pearlstonePolishedSlab;
	public static Block<?> pearlstoneBrick;
	public static Block<BlockLogicSlab> pearlstoneBrickSlab;
	public static Block<BlockLogicStairs> pearlstoneBrickStairs;
	public static Block<?> pearlstoneAmethystOre;
	public static Block<?> pearlstoneSilverOre;
	public static Block<?> pearlstoneLeadOre;
	public static Block<?> pearlstoneUraniumOre;
	public static Block<?> pearlstoneDiamondOre;
	public static Block<?> pearlstoneGoldOre;
	public static Block<?> pearlstoneIronOre;
	public static Block<?> pearlstoneCoalOre;
	public static Block<?> pearlstoneLapisOre;
	public static Block<?> pearlstoneRedstoneOre;
	public static Block<?> pearlstoneRedstoneGlowingOre;
	public static Block<?> peridotite;
	public static Block<?> peridotiteCobbled;
	public static Block<BlockLogicSlab> peridotiteCobbledSlab;
	public static Block<BlockLogicStairs> peridotiteCobbledStairs;
	public static Block<?> peridotitePolished;
	public static Block<?> peridotiteCarved;
	public static Block<BlockLogicSlab> peridotitePolishedSlab;
	public static Block<?> peridotiteBrick;
	public static Block<BlockLogicSlab> peridotiteBrickSlab;
	public static Block<BlockLogicStairs> peridotiteBrickStairs;
	public static Block<?> peridotiteAmethystOre;
	public static Block<?> peridotiteSilverOre;
	public static Block<?> peridotiteLeadOre;
	public static Block<?> peridotiteUraniumOre;
	public static Block<?> peridotiteDiamondOre;
	public static Block<?> peridotiteGoldOre;
	public static Block<?> peridotiteIronOre;
	public static Block<?> peridotiteCoalOre;
	public static Block<?> peridotiteLapisOre;
	public static Block<?> peridotiteRedstoneOre;
	public static Block<?> peridotiteRedstoneGlowingOre;
	public static Block<BlockLogicFluid> fluidMoltenGoldFlowing;
	public static Block<BlockLogicFluid> fluidMoltenGoldStill;
	public static Block<?> netherrackMagnetOre;
	public static Block<?> stoneBismuthOre;
	public static Block<?> basaltBismuthOre;
	public static Block<?> limestoneBismuthOre;
	public static Block<?> graniteBismuthOre;
	public static Block<?> permafrostBismuthOre;
	public static Block<?> abyssalriteBismuthOre;
	public static Block<?> pearlstoneBismuthOre;
	public static Block<?> peridotiteBismuthOre;
	public static Block<?> bismuthBlock;
	public static Block<?> magnetBlock;
	public static Block<?> meshLead;
	public static Block<?> bismuthBrick;
	public static Block<BlockLogicSlab> slabBismuthBrick;
	public static Block<BlockLogicStairs> stairsBismuthBrick;
	public static Block<?> magnetBrick;
	public static Block<BlockLogicSlab> slabMagnetBrick;
	public static Block<BlockLogicStairs> stairsMagnetBrick;
	public static Block<?> blockSugar;
	public static Block<?> blockString;
	public static Block<?> blockCloth;
	public static Block<?> blockLeather;
	public static Block<?> blockChainlink;
	public static Block<?> blockFeather;
	public static Block<?> blockGunpowder;
	public static Block<?> packedMud;
	public static Block<?> packedMudBrick;
	public static Block<BlockLogicSlab> packedMudBrickSlab;
	public static Block<BlockLogicStairs> packedMudBrickStairs;
	public static Block<?> blockSalt;
	public static Block<?> brickOvenIdle;
	public static Block<?> brickOvenActive;
	public static Block<BlockLogicDoor> doorGoldBottom;
	public static Block<BlockLogicDoor> doorGoldTop;
	public static Block<BlockLogicDoor> doorSilverBottom;
	public static Block<BlockLogicDoor> doorSilverTop;
	public static Block<BlockLogicDoor> doorLeadBottom;
	public static Block<BlockLogicDoor> doorLeadTop;
	public static Block<?> trapdoorGold;
	public static Block<?> trapdoorSilver;
	public static Block<?> trapdoorLead;
	public static Block<?> pressureplateCobbleBasalt;
	public static Block<?> pressureplateCobbleLimestone;
	public static Block<?> pressureplateCobbleGranite;
	public static Block<?> pressureplateCobblePermafrost;
	public static Block<?> pressureplateCobbleNetherrack;
	public static Block<?> pressureplateCobbleAbyssalrite;
	public static Block<?> pressureplateCobblePearlstone;
	public static Block<?> pressureplateCobblePeridotite;
	public static Block<?> mushroomSilver;
	public static Block<?> mushroomGray;
	public static Block<?> mushroomYellow;
	public static Block<?> scorchedSandstone;
	public static Block<?> fossil;
	public static Block<?> eggSpider;
	public static Block<?> crystalQuartz;
	public static Block<?> statueBastBottom;
	public static Block<?> statueBastTop;
	public static Block<?> scorchedSandstoneBrick;
	public static Block<BlockLogicSlab> scorchedSandstoneBrickSlab;
	public static Block<BlockLogicStairs> scorchedSandstoneBrickStairs;
	public static Block<BlockLogicSlab> scorchedSandstoneSlab;
	public static Block<BlockLogicStairs> scorchedSandstoneStairs;
	public static Block<?> netherrackAdamantiteOre;
	public static Block<?> netherrackCryocoalOre;
	public static Block<?> cryocoalBlock;
	public static Block<?> adamantiteBlock;
	public static Block<?> cryoTorch;
	public static Block<?> fishnet;
	public static Block<?> blockHoneycomb;
	public static Block<?> blockFlint;
	public static Block<?> blockNiter;
	public static Block<BlockLogicFullyRotatable> blockBone;
	public static Block<?> blockHoney;



	public static void initBlocks() {

		BlockBuilder rhodonite_block_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		rhodoniteBlock = rhodonite_block_builder.build("block.rhodoniteblock", "rhodonite_block", 9807, b -> new BlockLogic(b, Material.metal));
		miningLevels.put(rhodoniteBlock,2);

		BlockBuilder rhodonite_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		rhodoniteBrick = rhodonite_brick_builder.build("block.rhodonitebrick", "rhodonite_brick", 9808, b -> new BlockLogic(b, Material.metal));
		miningLevels.put(rhodoniteBrick,2);

		BlockBuilder slab_rhodonite_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		slabRhodoniteBrick = slab_rhodonite_brick_builder.build("block.slab.rhodonitebrick", "block/rhodonite_brick_slab", 9809, b -> new BlockLogicSlab(b, rhodoniteBrick));
		miningLevels.put(slabRhodoniteBrick,2);

		BlockBuilder stairs_rhodonite_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stairsRhodoniteBrick = stairs_rhodonite_brick_builder.build("block.stairs.rhodonitebrick", "block/rhodonite_brick_stairs", 9810, b -> new BlockLogicStairs(b, rhodoniteBrick));
		miningLevels.put(stairsRhodoniteBrick,2);

		BlockBuilder netherrack_rhodonite_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setLuminance(6)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		netherrackRhodoniteOre = netherrack_rhodonite_ore_builder.build("block.ore.netherrack.rhodonite", "block/netherrack_rhodonite_ore", 9811,  b -> new BlockLogicRhodoniteOre(b)).withBlastResistance(5.0F);
		miningLevels.put(netherrackRhodoniteOre,2);

		BlockBuilder amethyst_block_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		amethystBlock = amethyst_block_builder.build("block.amethystblock", "block/amethyst_block", 9812, b -> new BlockLogic(b, Material.metal));
		miningLevels.put(amethystBlock,2);

		BlockBuilder stone_amethyst_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stoneAmethystOre = stone_amethyst_ore_builder.build("block.ore.stone.amethyst", "block/stone_amethyst_ore", 9813,  (b) -> new BlockLogicAmethystOre(b, Blocks.STONE, Material.stone));
		miningLevels.put(stoneAmethystOre,2);

		BlockBuilder basalt_amethyst_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		basaltAmethystOre = basalt_amethyst_ore_builder.build("block.ore.basalt.amethyst", "block/basalt_amethyst_ore", 9814,  (b) -> new BlockLogicAmethystOre(b, Blocks.BASALT, Material.basalt));
		miningLevels.put(basaltAmethystOre,2);

		BlockBuilder limestone_amethyst_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		limestoneAmethystOre = limestone_amethyst_ore_builder.build("block.ore.limestone.amethyst", "block/limestone_amethyst_ore", 9815,  (b) -> new BlockLogicAmethystOre(b, Blocks.LIMESTONE, Material.limestone));
		miningLevels.put(limestoneAmethystOre,2);

		BlockBuilder granite_amethyst_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		graniteAmethystOre = granite_amethyst_ore_builder.build("block.ore.granite.amethyst", "block/granite_amethyst_ore", 9816,  (b) -> new BlockLogicAmethystOre(b, Blocks.GRANITE, Material.granite));
		miningLevels.put(graniteAmethystOre,2);

		BlockBuilder permafrost_amethyst_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		permafrostAmethystOre = permafrost_amethyst_ore_builder.build("block.ore.permafrost.amethyst", "block/permafrost_amethyst_ore", 9817,  (b) -> new BlockLogicAmethystOre(b, Blocks.PERMAFROST, Material.permafrost));
		miningLevels.put(permafrostAmethystOre,2);

		BlockBuilder silver_block_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		silverBlock = silver_block_builder.build("block.silverblock", "block/silver_block", 9818, b -> new BlockLogic(b, Material.metal));
		miningLevels.put(silverBlock,2);

		BlockBuilder stone_silver_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stoneSilverOre = stone_silver_ore_builder.build("block.ore.stone.silver", "block/stone_silver_ore", 9819,  (b) -> new BlockLogicSilverOre(b, Blocks.STONE, Material.stone));
		miningLevels.put(stoneSilverOre,2);

		BlockBuilder basalt_silver_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		basaltSilverOre = basalt_silver_ore_builder.build("block.ore.basalt.silver", "block/basalt_silver_ore", 9820,  (b) -> new BlockLogicSilverOre(b, Blocks.BASALT, Material.basalt));
		miningLevels.put(basaltSilverOre,2);

		BlockBuilder limestone_silver_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		limestoneSilverOre = limestone_silver_ore_builder.build("block.ore.limestone.silver", "block/limestone_silver_ore", 9821,  (b) -> new BlockLogicSilverOre(b, Blocks.LIMESTONE, Material.limestone));
		miningLevels.put(limestoneSilverOre,2);

		BlockBuilder granite_silver_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		graniteSilverOre = granite_silver_ore_builder.build("block.ore.granite.silver", "block/granite_silver_ore", 9822,  (b) -> new BlockLogicSilverOre(b, Blocks.GRANITE, Material.granite));
		miningLevels.put(graniteSilverOre,2);

		BlockBuilder permafrost_silver_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		permafrostSilverOre = permafrost_silver_ore_builder.build("block.ore.permafrost.silver", "block/permafrost_silver_ore", 9823,  (b) -> new BlockLogicSilverOre(b, Blocks.PERMAFROST, Material.permafrost));
		miningLevels.put(permafrostSilverOre,2);

		BlockBuilder uranium_block_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(8)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		uraniumBlock = uranium_block_builder.build("block.uraniumblock", "block/uranium_block", 9824, b -> new BlockLogic(b, Material.stone));
		miningLevels.put(uraniumBlock,2);

		BlockBuilder stone_uranium_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stoneUraniumOre = stone_uranium_ore_builder.build("block.ore.stone.uranium", "block/stone_uranium_ore", 9825,  (b) -> new BlockLogicUraniumOre(b, Blocks.STONE, Material.stone));
		miningLevels.put(stoneUraniumOre,2);

		BlockBuilder basalt_uranium_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		basaltUraniumOre = basalt_uranium_ore_builder.build("block.ore.basalt.uranium", "block/basalt_uranium_ore", 9826,  (b) -> new BlockLogicUraniumOre(b, Blocks.BASALT, Material.basalt));
		miningLevels.put(basaltUraniumOre,2);

		BlockBuilder limestone_uranium_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		limestoneUraniumOre = limestone_uranium_ore_builder.build("block.ore.limestone.uranium", "block/limestone_uranium_ore", 9827,  (b) -> new BlockLogicUraniumOre(b, Blocks.LIMESTONE, Material.limestone));
		miningLevels.put(limestoneUraniumOre,2);

		BlockBuilder granite_uranium_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		graniteUraniumOre = granite_uranium_ore_builder.build("block.ore.granite.uranium", "block/granite_uranium_ore", 9828,  (b) -> new BlockLogicUraniumOre(b, Blocks.GRANITE, Material.granite));
		miningLevels.put(graniteUraniumOre,2);

		BlockBuilder permafrost_uranium_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		permafrostUraniumOre = permafrost_uranium_ore_builder.build("block.ore.permafrost.uranium", "block/permafrost_uranium_ore", 9829,  (b) -> new BlockLogicUraniumOre(b, Blocks.PERMAFROST, Material.permafrost));
		miningLevels.put(permafrostUraniumOre,2);

		BlockBuilder lead_block_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		leadBlock = lead_block_builder.build("block.leadblock", "block/lead_block", 9830, b -> new BlockLogic(b, Material.metal));
		miningLevels.put(leadBlock,0);

		BlockBuilder leaded_glass_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(0f)
			.setLuminance(0)
			.setLightOpacity(0)
			.setBlockSound(BlockSounds.GLASS)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		leadedGlass = leaded_glass_builder.build("block.leadedglass", "block/leaded_glass", 9831, b -> new BlockLogicGlass(b, Material.glass));

		BlockBuilder stone_lead_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stoneLeadOre = stone_lead_ore_builder.build("block.ore.stone.lead", "block/stone_lead_ore", 9832,  (b) -> new BlockLogicLeadOre(b, Blocks.STONE, Material.stone));
		miningLevels.put(stoneLeadOre,0);

		BlockBuilder basalt_lead_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		basaltLeadOre = basalt_lead_ore_builder.build("block.ore.basalt.lead", "block/basalt_lead_ore", 9833,  (b) -> new BlockLogicLeadOre(b, Blocks.BASALT, Material.basalt));
		miningLevels.put(basaltLeadOre,0);

		BlockBuilder limestone_lead_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		limestoneLeadOre = limestone_lead_ore_builder.build("block.ore.limestone.lead", "block/limestone_lead_ore", 9834,  (b) -> new BlockLogicLeadOre(b, Blocks.LIMESTONE, Material.limestone));
		miningLevels.put(limestoneLeadOre,0);

		BlockBuilder granite_lead_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		graniteLeadOre = granite_lead_ore_builder.build("block.ore.granite.lead", "block/granite_lead_ore", 9835,  (b) -> new BlockLogicLeadOre(b, Blocks.GRANITE, Material.granite));
		miningLevels.put(graniteLeadOre,0);

		BlockBuilder permafrost_lead_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		permafrostLeadOre = permafrost_lead_ore_builder.build("block.ore.permafrost.lead", "block/permafrost_lead_ore", 9836,  (b) -> new BlockLogicLeadOre(b, Blocks.PERMAFROST, Material.permafrost));
		miningLevels.put(permafrostLeadOre,0);

		BlockBuilder netherrack_silver_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setLuminance(6)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		netherrackSilverOre = netherrack_silver_ore_builder.build("block.ore.netherrack.silver", "block/netherrack_silver_ore", 9837,  (b) -> new BlockLogicSilverOre(b, Blocks.NETHERRACK, Material.netherrack));
		miningLevels.put(netherrackSilverOre,2);

		BlockBuilder block_clay_red_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setLuminance(0)
			.setBlockSound(BlockSounds.GRAVEL)
			.addTags(BlockTags.MINEABLE_BY_SHOVEL);
		blockClayRed = block_clay_red_builder.build("block.clay.red", "block/clay_red", 9838,  (b) -> new BlockLogicClayRed(b));

		BlockBuilder brick_clay_blue_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		brickClayBlue = brick_clay_blue_builder.build("block.brick.clay.blue", "block/brick_clay_blue", 9839,  (b) -> new BlockLogic(b, Material.stone));

		BlockBuilder slab_brick_clay_blue_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		slabBrickClayBlue = slab_brick_clay_blue_builder.build("block.slab.brick.clay.blue", "block/brick_clay_blue_slab", 9840, b -> new BlockLogicSlab(b, brickClayBlue));

		BlockBuilder stairs_brick_clay_blue_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stairsBrickClayBlue = stairs_brick_clay_blue_builder.build("block.stairs.brick.clay.blue", "block/brick_clay_blue_stairs", 9841, b -> new BlockLogicStairs(b, brickClayBlue));

		BlockBuilder tile_ceramic_blue_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		tileCeramicBlue = tile_ceramic_blue_builder.build("block.tile.ceramic.blue", "block/tile_ceramic_blue", 9842,  (b) -> new BlockLogic(b, Material.stone));

		BlockBuilder tile_ceramic_red_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		tileCeramicRed = tile_ceramic_red_builder.build("block.tile.ceramic.red", "block/tile_ceramic_red", 9843,  (b) -> new BlockLogic(b, Material.stone));

		BlockBuilder slab_tile_ceramic_blue_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		slabTileCeramicBlue = slab_tile_ceramic_blue_builder.build("block.slab.tile.ceramic.blue", "block/tile_ceramic_blue_slab", 9844, b -> new BlockLogicSlab(b, tileCeramicBlue));

		BlockBuilder stairs_tile_ceramic_blue_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stairsTileCeramicBlue = stairs_tile_ceramic_blue_builder.build("block.stairs.tile.ceramic.blue", "block/tile_ceramic_blue_stairs", 9845, b -> new BlockLogicStairs(b, tileCeramicBlue));

		BlockBuilder slab_tile_ceramic_red_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		slabTileCeramicRed = slab_tile_ceramic_red_builder.build("block.slab.tile.ceramic.red", "block/tile_ceramic_red_slab", 9846, b -> new BlockLogicSlab(b, tileCeramicRed));

		BlockBuilder stairs_tile_ceramic_red_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stairsTileCeramicRed = stairs_tile_ceramic_red_builder.build("block.stairs.tile.ceramic.red", "block/tile_ceramic_red_stairs", 9847, b -> new BlockLogicStairs(b, tileCeramicRed));

		BlockBuilder netherrack_topaz_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setLuminance(6)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		netherrackTopazOre = netherrack_topaz_ore_builder.build("block.ore.netherrack.topaz", "block/netherrack_topaz_ore", 9848,  b -> new BlockLogicTopazOre(b)).withBlastResistance(5.0F);
		miningLevels.put(netherrackTopazOre,2);

		BlockBuilder wireframe_steel_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(0f)
			.setLuminance(0)
			.setLightOpacity(0)
			.setResistance(30.0f)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		wireframeSteel = wireframe_steel_builder.build("block.wireframe.steel", "block/wireframe_steel", 9849, b -> new BlockLogicTransparent(b, Material.steel));

		BlockBuilder mosaic_pig_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		mosaicPig = mosaic_pig_builder.build("block.mosaic.pig", "block/mosaic_pig", 9850,  (b) -> new BlockLogic(b, Material.stone));

		BlockBuilder mosaic_creeper_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		mosaicCreeper = mosaic_creeper_builder.build("block.mosaic.creeper", "block/mosaic_creeper", 9851,  (b) -> new BlockLogic(b, Material.stone));

		BlockBuilder mosaic_steve_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		mosaicSteve = mosaic_steve_builder.build("block.mosaic.steve", "block/mosaic_steve", 9852,  (b) -> new BlockLogic(b, Material.stone));
		miningLevels.put(mosaicSteve,3);

		BlockBuilder clear_glass_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(0f)
			.setLuminance(0)
			.setLightOpacity(0)
			.setBlockSound(BlockSounds.GLASS)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		clearGlass = clear_glass_builder.build("block.glass.clear", "block/clear_glass", 9853, b -> new BlockLogicGlass(b, Material.glass));

		BlockBuilder olivine_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(1.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		olivineBrick = olivine_brick_builder.build("block.olivine.brick", "block/olivine_brick", 9854, b -> new BlockLogic(b, Material.metal));
		miningLevels.put(olivineBrick,0);

		BlockBuilder slab_olivine_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(1.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		slabOlivineBrick = slab_olivine_brick_builder.build("block.slab.olivine.brick", "block/olivine_brick_slab", 9855, b -> new BlockLogicSlab(b, olivineBrick));
		miningLevels.put(slabOlivineBrick,0);

		BlockBuilder stairs_olivine_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(1.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stairsOlivineBrick = stairs_olivine_brick_builder.build("block.stairs.olivine.brick", "block/olivine_brick_stairs", 9856, b -> new BlockLogicStairs(b, olivineBrick));
		miningLevels.put(stairsOlivineBrick,0);

		BlockBuilder quartz_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(1.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		quartzBrick = quartz_brick_builder.build("block.quartz.brick", "block/quartz_brick", 9857, b -> new BlockLogic(b, Material.metal));
		miningLevels.put(quartzBrick,0);

		BlockBuilder slab_quartz_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(1.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		slabQuartzBrick = slab_quartz_brick_builder.build("block.slab.quartz.brick", "block/quartz_brick_slab", 9858, b -> new BlockLogicSlab(b, quartzBrick));
		miningLevels.put(slabQuartzBrick,0);

		BlockBuilder stairs_quartz_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(1.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stairsQuartzBrick = stairs_quartz_brick_builder.build("block.stairs.quartz.brick", "block/quartz_brick_stairs", 9859, b -> new BlockLogicStairs(b, quartzBrick));
		miningLevels.put(stairsQuartzBrick,0);

		BlockBuilder diamond_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		diamondBrick = diamond_brick_builder.build("block.diamond.brick", "block/diamond_brick", 9860, b -> new BlockLogic(b, Material.metal));
		miningLevels.put(diamondBrick,2);

		BlockBuilder slab_diamond_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		slabDiamondBrick = slab_diamond_brick_builder.build("block.slab.diamond.brick", "block/diamond_brick_slab", 9861, b -> new BlockLogicSlab(b, diamondBrick));
		miningLevels.put(slabDiamondBrick,2);

		BlockBuilder stairs_diamond_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stairsDiamondBrick = stairs_diamond_brick_builder.build("block.stairs.diamond.brick", "block/diamond_brick_stairs", 9862, b -> new BlockLogicStairs(b, diamondBrick));
		miningLevels.put(stairsDiamondBrick,2);

		BlockBuilder amethyst_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		amethystBrick = amethyst_brick_builder.build("block.amethyst.brick", "block/amethyst_brick", 9863, b -> new BlockLogic(b, Material.metal));
		miningLevels.put(amethystBrick,2);

		BlockBuilder slab_amethyst_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		slabAmethystBrick = slab_amethyst_brick_builder.build("block.slab.amethyst.brick", "block/amethyst_brick_slab", 9864, b -> new BlockLogicSlab(b, amethystBrick));
		miningLevels.put(slabAmethystBrick,2);

		BlockBuilder stairs_amethyst_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stairsAmethystBrick = stairs_amethyst_brick_builder.build("block.stairs.amethyst.brick", "block/amethyst_brick_stairs", 9865, b -> new BlockLogicStairs(b, amethystBrick));
		miningLevels.put(stairsAmethystBrick,2);

		BlockBuilder silver_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		silverBrick = silver_brick_builder.build("block.silver.brick", "block/silver_brick", 9866, b -> new BlockLogic(b, Material.metal));
		miningLevels.put(silverBrick,2);

		BlockBuilder slab_silver_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		slabSilverBrick = slab_silver_brick_builder.build("block.slab.silver.brick", "block/silver_brick_slab", 9867, b -> new BlockLogicSlab(b, silverBrick));
		miningLevels.put(slabSilverBrick,2);

		BlockBuilder stairs_silver_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stairsSilverBrick = stairs_silver_brick_builder.build("block.stairs.silver.brick", "block/silver_brick_stairs", 9868, b -> new BlockLogicStairs(b, silverBrick));
		miningLevels.put(stairsSilverBrick,2);

		BlockBuilder lead_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		leadBrick = lead_brick_builder.build("block.lead.brick", "block/lead_brick", 9869, b -> new BlockLogic(b, Material.metal));
		miningLevels.put(leadBrick,1);

		BlockBuilder slab_lead_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		slabLeadBrick = slab_lead_brick_builder.build("block.slab.lead.brick", "block/lead_brick_slab", 9870, b -> new BlockLogicSlab(b, leadBrick));
		miningLevels.put(slabLeadBrick,1);

		BlockBuilder stairs_lead_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stairsLeadBrick = stairs_lead_brick_builder.build("block.stairs.lead.brick", "block/lead_brick_stairs", 9871, b -> new BlockLogicStairs(b, leadBrick));
		miningLevels.put(stairsLeadBrick,1);

		BlockBuilder mushroom_explosive_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(0f)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLANTABLE_IN_JAR, BlockTags.MINEABLE_BY_SHEARS, BlockTags.PIGS_FAVOURITE_BLOCK);
		mushroomExplosive = mushroom_explosive_builder.build("block.mushroom.explosive", "block/mushroom_explosive", 9872, b -> new BlockLogicExplosiveMushroom(b));

		BlockBuilder mushroom_blue_builder = new BlockBuilder(MOD_ID)
			.setHardness(0f)
			.setResistance(0f)
			.setLuminance(7)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLANTABLE_IN_JAR, BlockTags.MINEABLE_BY_SHEARS, BlockTags.PIGS_FAVOURITE_BLOCK);
		mushroomBlue = mushroom_blue_builder.build("block.mushroom.blue", "block/mushroom_blue", 9873, b -> new BlockLogicMushroom(b));

		BlockBuilder coarse_dirt_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(0.0f)
			.setLuminance(0)
			.setBlockSound(BlockSounds.GRAVEL)
			.addTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.GROWS_FLOWERS);
		coarseDirt = coarse_dirt_builder.build("block.dirt.coarse", "block/coarse_dirt", 9874, b -> new BlockLogic(b, Material.dirt));

		BlockBuilder coral_builder = new BlockBuilder(MOD_ID)
			.setHardness(0.5f)
			.setResistance(10.0f)
			.setLuminance(12)
			.setUseInternalLight()
			.setBlockSound(BlockSounds.STONE)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		coral = coral_builder.build("block.coral", "block/coral", 9875, b -> new BlockLogic(b, Material.stone));

		BlockBuilder cattail_top_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_SHEARS, BlockTags.NOT_IN_CREATIVE_MENU);
		cattailTop = cattail_top_builder.build("block.cattail.top", "block/cattail_top", 9876, b -> new BlockLogicCattailTop(b));

		BlockBuilder cattail_bottom_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_SHEARS);
		cattailBottom = cattail_bottom_builder.build("block.cattail.bottom", "block/cattail_bottom", 9877, b -> new BlockLogicCattailBottom(b));

		BlockBuilder lily_pad_builder = new BlockBuilder(MOD_ID)
			.setHardness(0f)
			.setResistance(0f)
			.setBlockItem(ItemBlockLilypad::new)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setTags(BlockTags.BROKEN_BY_FLUIDS);
		lilypad = lily_pad_builder.build("block.lilypad", "block/lilypad", 9878, b -> new BlockLogicLilyPad(b));

		BlockBuilder freezer_idle_builder = new BlockBuilder(MOD_ID)
			.setHardness(4.0f)
			.setResistance(10.0f)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE);
		freezerIdle = freezer_idle_builder.build("block.freezer.idle", "block/freezer_idle", 9879, b -> new BlockLogicFreezer(b, false));

		BlockBuilder freezer_active_builder = new BlockBuilder(MOD_ID)
			.setHardness(4.0f)
			.setResistance(10.0f)
			.setLuminance(8)
			.setTags(BlockTags.NOT_IN_CREATIVE_MENU,BlockTags.MINEABLE_BY_PICKAXE);
		freezerActive = freezer_active_builder.build("block.freezer.active", "block/freezer_active", 9880, b -> new BlockLogicFreezer(b, true));

		BlockBuilder scorched_dirt_path_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(0.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.GRAVEL)
			.addTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.GROWS_FLOWERS);
		scorchedDirtPath = scorched_dirt_path_builder.build("block.dirt.scorched.path", "block/scorched_dirt_path", 9882, b -> new BlockLogicPathScorchedDirt(b));

		BlockBuilder sand_path_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(0.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.SAND)
			.addTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.GROWS_FLOWERS);
		sandPath = sand_path_builder.build("block.sand.path", "block/sand_path", 9883, b -> new BlockLogicPathSand(b));

		BlockBuilder lapis_tile_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		lapisTile = lapis_tile_builder.build("block.lapis.tile", "block/lapis_tile", 9884, b -> new BlockLogic(b, Material.stone));
		miningLevels.put(lapisTile,0);

		BlockBuilder slab_lapis_tile_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		slabLapisTile = slab_lapis_tile_builder.build("block.slab.lapis.tile", "block/lapis_tile_slab", 9885, b -> new BlockLogicSlab(b, lapisTile));
		miningLevels.put(slabLapisTile,0);

		BlockBuilder stairs_lapis_tile_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stairsLapisTile = stairs_lapis_tile_builder.build("block.stairs.lapis.tile", "block/lapis_tile_stairs", 9886, b -> new BlockLogicStairs(b, lapisTile));
		miningLevels.put(stairsLapisTile,0);

		BlockBuilder rhodonite_tile_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		rhodoniteTile = rhodonite_tile_builder.build("block.rhodonite.tile", "block/rhodonite_tile", 9887, b -> new BlockLogic(b, Material.stone));
		miningLevels.put(rhodoniteTile,0);

		BlockBuilder slab_rhodonite_tile_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		slabRhodoniteTile = slab_rhodonite_tile_builder.build("block.slab.rhodonite.tile", "block/rhodonite_tile_slab", 9888, b -> new BlockLogicSlab(b, rhodoniteTile));
		miningLevels.put(slabRhodoniteTile,0);

		BlockBuilder stairs_rhodonite_tile_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stairsRhodoniteTile = stairs_rhodonite_tile_builder.build("block.stairs.rhodonite.tile", "block/rhodonite_tile_stairs", 9889, b -> new BlockLogicStairs(b, rhodoniteTile));
		miningLevels.put(stairsRhodoniteTile,0);

		BlockBuilder lapis_sol_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		lapisSol = lapis_sol_builder.build("block.lapis.sol", "block/lapis_sol", 9890, b -> new BlockLogic(b, Material.stone));
		miningLevels.put(lapisSol,0);

		BlockBuilder lapis_luna_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		lapisLuna = lapis_luna_builder.build("block.lapis.luna", "block/lapis_luna", 9891, b -> new BlockLogic(b, Material.stone));
		miningLevels.put(lapisLuna,0);

		BlockBuilder lapis_bulb_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.PREVENT_MOB_SPAWNS);
		lapisBulb = lapis_bulb_builder.build("block.lapis.bulb", "block/lapis_bulb", 9892, b -> new BlockLogicBulb(b));
		miningLevels.put(lapisBulb,0);

		BlockBuilder rhodonite_bulb_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.PREVENT_MOB_SPAWNS);
		rhodoniteBulb = rhodonite_bulb_builder.build("block.rhodonite.bulb", "block/rhodonite_bulb", 9893, b -> new BlockLogicBulb(b));
		miningLevels.put(rhodoniteBulb,0);

		BlockBuilder root_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(1f)
			.setLuminance(0)
			.setUseInternalLight()
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_SHEARS);
		root = root_builder.build("block.root", "block/root", 9894, b -> new BlockLogicRoot(b));

		BlockBuilder ladder_steel_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(30.0f)
			.setLuminance(0)
			.setBlockItem(b -> new ItemBlockLadder<>(ladderSteel))
			.setUseInternalLight()
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.MINEABLE_BY_PICKAXE, BlockTags.PREVENT_MOB_SPAWNS);
		ladderSteel = ladder_steel_builder.build("block.ladder.steel", "block/ladder_steel", 9895, b -> new BlockLogicLadder(b));

		BlockBuilder silt_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.GRAVEL)
			.addTags(BlockTags.MINEABLE_BY_SHOVEL,BlockTags.GROWS_SUGAR_CANE,BlockTags.GROWS_FLOWERS,BlockTags.GROWS_TREES);
		silt = silt_builder.build("block.silt", "block/silt", 9896, b -> new BlockLogicSilt(b));

		BlockBuilder slush_builder = new BlockBuilder(MOD_ID)
			.setHardness(0.25f)
			.setResistance(0f)
			.setLuminance(0)
			.setSlipperiness(1f)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(new BlockSound("step.permafrost", "random.glass", 1.0f, 1.0f))
			.addTags(BlockTags.MINEABLE_BY_SHOVEL,BlockTags.SKATEABLE);
		slush = slush_builder.build("block.slush", "block/slush", 9897, b -> new BlockLogicSlush(b));

		BlockBuilder stucco_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stucco = stucco_builder.build("block.stucco", "block/stucco", 9898, b -> new BlockLogic(b, Material.stone));
		miningLevels.put(stucco,0);

		BlockBuilder stucco_carved_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stuccoCarved = stucco_carved_builder.build("block.stucco.carved", "block/stucco_carved", 9899, b -> new BlockLogic(b, Material.stone));
		miningLevels.put(stuccoCarved,0);

		BlockBuilder mesh_silver_builder = new BlockBuilder(MOD_ID)
			.setHardness(4.0f)
			.setResistance(10.0f)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.PREVENT_MOB_SPAWNS);
		meshSilver = mesh_silver_builder.build("block.mesh.silver", "block/mesh_silver", 9900, b -> new BlockLogicMeshSilver(b));
		miningLevels.put(meshSilver,2);

		BlockBuilder fence_gold_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.PREVENT_MOB_SPAWNS);
		fenceGold = fence_gold_builder.build("block.fence.gold", "block/fence_gold", 9901, b -> new BlockLogicFenceSteel(b, Material.metal));
		miningLevels.put(fenceGold,2);

		BlockBuilder fence_silver_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.PREVENT_MOB_SPAWNS);
		fenceSilver = fence_silver_builder.build("block.fence.silver", "block/fence_silver", 9902, b -> new BlockLogicFenceSteel(b, Material.metal));
		miningLevels.put(fenceSilver,2);

		BlockBuilder fence_lead_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.PREVENT_MOB_SPAWNS);
		fenceLead = fence_lead_builder.build("block.fence.lead", "block/fence_lead", 9903, b -> new BlockLogicFenceSteel(b, Material.metal));
		miningLevels.put(fenceLead,1);

		BlockBuilder repeater_big_idle_builder = new BlockBuilder(MOD_ID)
			.setHardness(0.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.MINEABLE_BY_PICKAXE, BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.PREVENT_MOB_SPAWNS);
		repeaterBigIdle = repeater_big_idle_builder.build("block.repeater.big.idle", "block/repeater.idle", 9904, b -> new BlockLogicBigRepeater(b, false));

		BlockBuilder repeater_big_active_builder = new BlockBuilder(MOD_ID)
			.setHardness(0.0f)
			.setLuminance(9)
			.setUseInternalLight()
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.MINEABLE_BY_PICKAXE, BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.PREVENT_MOB_SPAWNS);
		repeaterBigActive = repeater_big_active_builder.build("block.repeater.big.active", "block/repeater.big.active", 9905, b -> new BlockLogicBigRepeater(b, true));

		BlockBuilder soulsand_raging_builder = new BlockBuilder(MOD_ID)
			.setHardness(4.0f)
			.setResistance(1.0f)
			.setLuminance(0)
			.setBlockSound(BlockSounds.SAND)
			.addTags(BlockTags.MINEABLE_BY_SHOVEL);
		soulsandRaging = soulsand_raging_builder.build("block.soulsand.raging", "block/soulsand_raging", 9906, b -> new BlockLogicRagingSoulSand(b));
		miningLevels.put(soulsandRaging,0);

		BlockBuilder abyssalrite_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE,BlockTags.CAVES_CUT_THROUGH);
		abyssalrite = abyssalrite_builder.build("block.abyssalrite", "block/abyssalrite", 9907, b -> new BlockLogicStone(b, abyssalriteCobbled, Material.basalt));
		miningLevels.put(abyssalrite,0);

		BlockBuilder abyssalrite_cobbled_builder = new BlockBuilder(MOD_ID)
			.setHardness(2.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteCobbled = abyssalrite_cobbled_builder.build("block.abyssalrite.cobbled", "block/abyssalrite_cobbled", 9908, b -> new BlockLogicCobble(b, Material.basalt, () -> GRAVEL));
		miningLevels.put(abyssalriteCobbled,0);

		BlockBuilder abyssalrite_polished_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalritePolished = abyssalrite_polished_builder.build("block.abyssalrite.polished", "block/abyssalrite_polished", 9909, b -> new BlockLogic(b, Material.basalt));
		miningLevels.put(abyssalritePolished,0);

		BlockBuilder abyssalrite_carved_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE,BlockTags.NOT_IN_CREATIVE_MENU);
		abyssalriteCarved = abyssalrite_carved_builder.build("block.abyssalrite.carved", "block/abyssalrite_carved", 9910, b -> new BlockLogic(b, Material.basalt));
		miningLevels.put(abyssalriteCarved,0);

		BlockBuilder abyssalrite_polished_slab_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalritePolishedSlab = abyssalrite_polished_slab_builder.build("block.abyssalrite.polished.slab", "block/abyssalrite_polished_slab", 9911, b -> new BlockLogicSlab(b, abyssalriteCarved));
		miningLevels.put(abyssalritePolishedSlab,0);

		BlockBuilder abyssalrite_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteBrick = abyssalrite_brick_builder.build("block.abyssalrite.brick", "block/abyssalrite_brick", 9912, b -> new BlockLogic(b, Material.basalt));
		miningLevels.put(abyssalriteBrick,0);

		BlockBuilder abyssalrite_brick_slab_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteBrickSlab = abyssalrite_brick_slab_builder.build("block.abyssalrite.brick.slab", "block/abyssalrite_brick_slab", 9913, b -> new BlockLogicSlab(b, abyssalriteBrick));
		miningLevels.put(abyssalriteBrickSlab,0);

		BlockBuilder abyssalrite_brick_stairs_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteBrickStairs = abyssalrite_brick_stairs_builder.build("block.abyssalrite.brick.stairs", "block/abyssalrite_brick_stairs", 9914, b -> new BlockLogicStairs(b, abyssalriteBrick));
		miningLevels.put(abyssalriteBrickStairs,0);

		BlockBuilder abyssalrite_cobbled_slab_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteCobbledSlab = abyssalrite_cobbled_slab_builder.build("block.abyssalrite.cobbled.slab", "block/abyssalrite_cobbled_slab", 9915, b -> new BlockLogicSlab(b, abyssalriteCobbled));
		miningLevels.put(abyssalriteCobbledSlab,0);

		BlockBuilder abyssalrite_cobbled_stairs_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteCobbledStairs = abyssalrite_cobbled_stairs_builder.build("block.abyssalrite.cobbled.stairs", "block/abyssalrite_cobbled_stairs", 9916, b -> new BlockLogicStairs(b, abyssalriteCobbled));
		miningLevels.put(abyssalriteCobbledStairs,0);

		BlockBuilder abyssalrite_lead_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteLeadOre = abyssalrite_lead_ore_builder.build("block.ore.abyssalrite.lead", "block/abyssalrite_lead_ore", 9917,  (b) -> new BlockLogicLeadOre(b, DEEPBlocks.abyssalrite, Material.basalt));
		miningLevels.put(abyssalriteLeadOre,0);

		BlockBuilder abyssalrite_silver_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteSilverOre = abyssalrite_silver_ore_builder.build("block.ore.abyssalrite.silver", "block/abyssalrite_silver_ore", 9918,  (b) -> new BlockLogicSilverOre(b, DEEPBlocks.abyssalrite, Material.basalt));
		miningLevels.put(abyssalriteSilverOre,2);

		BlockBuilder abyssalrite_uranium_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteUraniumOre = abyssalrite_uranium_ore_builder.build("block.ore.abyssalrite.uranium", "block/abyssalrite_uranium_ore", 9919,  (b) -> new BlockLogicUraniumOre(b, DEEPBlocks.abyssalrite, Material.basalt));
		miningLevels.put(abyssalriteUraniumOre,2);

		BlockBuilder abyssalrite_amethyst_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteAmethystOre = abyssalrite_amethyst_ore_builder.build("block.ore.abyssalrite.amethyst", "block/abyssalrite_amethyst_ore", 9920,  (b) -> new BlockLogicAmethystOre(b, DEEPBlocks.abyssalrite, Material.basalt));
		miningLevels.put(abyssalriteAmethystOre,2);

		BlockBuilder abyssalrite_diamond_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteDiamondOre = abyssalrite_diamond_ore_builder.build("block.ore.abyssalrite.diamond", "block/abyssalrite_diamond_ore", 9921,  (b) -> new BlockLogicOreDiamond(b, DEEPBlocks.abyssalrite, Material.basalt));
		miningLevels.put(abyssalriteDiamondOre,2);

		BlockBuilder abyssalrite_gold_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteGoldOre = abyssalrite_gold_ore_builder.build("block.ore.abyssalrite.gold", "block/abyssalrite_gold_ore", 9922,  (b) -> new BlockLogicOreGold(b, DEEPBlocks.abyssalrite, Material.basalt));
		miningLevels.put(abyssalriteGoldOre,2);

		BlockBuilder abyssalrite_iron_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteIronOre = abyssalrite_iron_ore_builder.build("block.ore.abyssalrite.iron", "block/abyssalrite_iron_ore", 9923,  (b) -> new BlockLogicOreIron(b, DEEPBlocks.abyssalrite, Material.basalt));
		miningLevels.put(abyssalriteIronOre,1);

		BlockBuilder abyssalrite_lapis_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteLapisOre = abyssalrite_lapis_ore_builder.build("block.ore.abyssalrite.lapis", "block/abyssalrite_lapis_ore", 9924,  (b) -> new BlockLogicOreLapis(b, DEEPBlocks.abyssalrite, Material.basalt));
		miningLevels.put(abyssalriteLapisOre,1);

		BlockBuilder abyssalrite_coal_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteCoalOre = abyssalrite_coal_ore_builder.build("block.ore.abyssalrite.coal", "block/abyssalrite_coal_ore", 9925,  (b) -> new BlockLogicOreCoal(b, DEEPBlocks.abyssalrite, Material.basalt));
		miningLevels.put(abyssalriteCoalOre,0);

		BlockBuilder abyssalrite_redstone_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteRedstoneOre = abyssalrite_redstone_ore_builder.build("block.ore.abyssalrite.redstone", "block/abyssalrite_redstone_ore", 9926,  (b) -> new BlockLogicOreRedstone(b, DEEPBlocks.abyssalrite, Material.basalt, false, abyssalriteRedstoneOre, abyssalriteRedstoneGlowingOre));
		miningLevels.put(abyssalriteRedstoneOre,0);

		BlockBuilder abyssalrite_redstone_glowing_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(3)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE,BlockTags.NOT_IN_CREATIVE_MENU);
		abyssalriteRedstoneGlowingOre = abyssalrite_redstone_glowing_ore_builder.build("block.ore.abyssalrite.redstone.glowing", "block/abyssalrite_redstone_glowing_ore", 9927,  (b) -> new BlockLogicOreRedstone(b, (Block)null, Material.basalt, true, abyssalriteRedstoneOre, abyssalriteRedstoneOre));
		miningLevels.put(abyssalriteRedstoneGlowingOre,0);

		BlockBuilder pearlstone_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE,BlockTags.CAVES_CUT_THROUGH);
		pearlstone = pearlstone_builder.build("block.pearlstone", "block/pearlstone", 9928, b -> new BlockLogicStone(b, pearlstoneCobbled, Material.basalt));
		miningLevels.put(pearlstone,0);
		BlockBuilder pearlstone_cobbled_builder = new BlockBuilder(MOD_ID)
			.setHardness(2.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneCobbled = pearlstone_cobbled_builder.build("block.pearlstone.cobbled", "block/pearlstone_cobbled", 9929, b -> new BlockLogicCobble(b, Material.basalt, () -> GRAVEL));
		miningLevels.put(pearlstoneCobbled,0);

		BlockBuilder pearlstone_polished_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstonePolished = pearlstone_polished_builder.build("block.pearlstone.polished", "block/pearlstone_polished", 9930, b -> new BlockLogic(b, Material.basalt));
		miningLevels.put(pearlstonePolished,0);

		BlockBuilder pearlstone_carved_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE,BlockTags.NOT_IN_CREATIVE_MENU);
		pearlstoneCarved = pearlstone_carved_builder.build("block.pearlstone.carved", "block/pearlstone_carved", 9931, b -> new BlockLogic(b, Material.basalt));
		miningLevels.put(pearlstoneCarved,0);

		BlockBuilder pearlstone_polished_slab_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstonePolishedSlab = pearlstone_polished_slab_builder.build("block.pearlstone.polished.slab", "block/pearlstone_polished_slab", 9932, b -> new BlockLogicSlab(b, pearlstoneCarved));
		miningLevels.put(pearlstonePolishedSlab,0);

		BlockBuilder pearlstone_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneBrick = pearlstone_brick_builder.build("block.pearlstone.brick", "block/pearlstone_brick", 9933, b -> new BlockLogic(b, Material.basalt));
		miningLevels.put(pearlstoneBrick,0);

		BlockBuilder pearlstone_brick_slab_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneBrickSlab = abyssalrite_brick_slab_builder.build("block.pearlstone.brick.slab", "block/pearlstone_brick_slab", 9934, b -> new BlockLogicSlab(b, pearlstoneBrick));
		miningLevels.put(pearlstoneBrickSlab,0);

		BlockBuilder pearlstone_brick_stairs_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneBrickStairs = pearlstone_brick_stairs_builder.build("block.pearlstone.brick.stairs", "block/pearlstone_brick_stairs", 9935, b -> new BlockLogicStairs(b, pearlstoneBrick));
		miningLevels.put(pearlstoneBrickStairs,0);

		BlockBuilder pearlstone_cobbled_slab_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneCobbledSlab = pearlstone_cobbled_slab_builder.build("block.pearlstone.cobbled.slab", "block/pearlstone_cobbled_slab", 9936, b -> new BlockLogicSlab(b, pearlstoneCobbled));
		miningLevels.put(pearlstoneCobbledSlab,0);

		BlockBuilder pearlstone_cobbled_stairs_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneCobbledStairs = pearlstone_cobbled_stairs_builder.build("block.pearlstone.cobbled.stairs", "block/pearlstone_cobbled_stairs", 9937, b -> new BlockLogicStairs(b, pearlstoneCobbled));
		miningLevels.put(pearlstoneCobbledStairs,0);

		BlockBuilder pearlstone_lead_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneLeadOre = pearlstone_lead_ore_builder.build("block.ore.pearlstone.lead", "block/pearlstone_lead_ore", 9938,  (b) -> new BlockLogicLeadOre(b, DEEPBlocks.pearlstone, Material.basalt));
		miningLevels.put(pearlstoneLeadOre,0);

		BlockBuilder pearlstone_silver_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneSilverOre = pearlstone_silver_ore_builder.build("block.ore.pearlstone.silver", "block/pearlstone_silver_ore", 9939,  (b) -> new BlockLogicSilverOre(b, DEEPBlocks.pearlstone, Material.basalt));
		miningLevels.put(pearlstoneSilverOre,2);

		BlockBuilder pearlstone_uranium_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneUraniumOre = pearlstone_uranium_ore_builder.build("block.ore.pearlstone.uranium", "block/pearlstone_uranium_ore", 9940,  (b) -> new BlockLogicUraniumOre(b, DEEPBlocks.pearlstone, Material.basalt));
		miningLevels.put(pearlstoneUraniumOre,2);

		BlockBuilder pearlstone_amethyst_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneAmethystOre = pearlstone_amethyst_ore_builder.build("block.ore.pearlstone.amethyst", "block/pearlstone_amethyst_ore", 9941,  (b) -> new BlockLogicAmethystOre(b, DEEPBlocks.pearlstone, Material.basalt));
		miningLevels.put(pearlstoneAmethystOre,2);

		BlockBuilder pearlstone_diamond_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneDiamondOre = pearlstone_diamond_ore_builder.build("block.ore.pearlstone.diamond", "block/pearlstone_diamond_ore", 9942,  (b) -> new BlockLogicOreDiamond(b, DEEPBlocks.pearlstone, Material.basalt));
		miningLevels.put(pearlstoneDiamondOre,2);

		BlockBuilder pearlstone_gold_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneGoldOre = pearlstone_gold_ore_builder.build("block.ore.pearlstone.gold", "block/pearlstone_gold_ore", 9943,  (b) -> new BlockLogicOreGold(b, DEEPBlocks.pearlstone, Material.basalt));
		miningLevels.put(pearlstoneGoldOre,2);

		BlockBuilder pearlstone_iron_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneIronOre = pearlstone_iron_ore_builder.build("block.ore.pearlstone.iron", "block/pearlstone_iron_ore", 9944,  (b) -> new BlockLogicOreIron(b, DEEPBlocks.pearlstone, Material.basalt));
		miningLevels.put(pearlstoneIronOre,1);

		BlockBuilder pearlstone_lapis_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneLapisOre = pearlstone_lapis_ore_builder.build("block.ore.pearlstone.lapis", "block/pearlstone_lapis_ore", 9945,  (b) -> new BlockLogicOreLapis(b, DEEPBlocks.pearlstone, Material.basalt));
		miningLevels.put(pearlstoneLapisOre,1);

		BlockBuilder pearlstone_coal_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneCoalOre = pearlstone_coal_ore_builder.build("block.ore.pearlstone.coal", "block/pearlstone_coal_ore", 9946,  (b) -> new BlockLogicOreCoal(b, DEEPBlocks.pearlstone, Material.basalt));
		miningLevels.put(pearlstoneCoalOre,0);

		BlockBuilder pearlstone_redstone_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneRedstoneOre = pearlstone_redstone_ore_builder.build("block.ore.pearlstone.redstone", "block/pearlstone_redstone_ore", 9947,  (b) -> new BlockLogicOreRedstone(b, DEEPBlocks.pearlstone, Material.basalt, false, pearlstoneRedstoneOre, pearlstoneRedstoneGlowingOre));
		miningLevels.put(pearlstoneRedstoneOre,0);

		BlockBuilder pearlstone_redstone_glowing_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(3)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE,BlockTags.NOT_IN_CREATIVE_MENU);
		pearlstoneRedstoneGlowingOre = pearlstone_redstone_glowing_ore_builder.build("block.ore.pearlstone.redstone.glowing", "block/pearlstone_redstone_glowing_ore", 9948,  (b) -> new BlockLogicOreRedstone(b, (Block)null, Material.basalt, true, pearlstoneRedstoneOre, pearlstoneRedstoneOre));
		miningLevels.put(pearlstoneRedstoneGlowingOre,0);

		BlockBuilder peridotite_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE,BlockTags.CAVES_CUT_THROUGH);
		peridotite = peridotite_builder.build("block.peridotite", "block/peridotite", 9949, b -> new BlockLogicStone(b, peridotiteCobbled, Material.basalt));
		miningLevels.put(peridotite,0);

		BlockBuilder peridotite_cobbled_builder = new BlockBuilder(MOD_ID)
			.setHardness(2.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteCobbled = peridotite_cobbled_builder.build("block.peridotite.cobbled", "block/peridotite_cobbled", 9950, b -> new BlockLogicCobble(b, Material.basalt, () -> GRAVEL));
		miningLevels.put(peridotiteCobbled,0);

		BlockBuilder peridotite_polished_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotitePolished = peridotite_polished_builder.build("block.peridotite.polished", "block/peridotite_polished", 9951, b -> new BlockLogic(b, Material.basalt));
		miningLevels.put(peridotitePolished,0);

		BlockBuilder peridotite_carved_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE,BlockTags.NOT_IN_CREATIVE_MENU);
		peridotiteCarved = peridotite_carved_builder.build("block.peridotite.carved", "block/peridotite_carved", 9952, b -> new BlockLogic(b, Material.basalt));
		miningLevels.put(peridotiteCarved,0);

		BlockBuilder peridotite_polished_slab_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotitePolishedSlab = peridotite_polished_slab_builder.build("block.peridotite.polished.slab", "block/peridotite_polished_slab", 9953, b -> new BlockLogicSlab(b, peridotiteCarved));
		miningLevels.put(peridotitePolishedSlab,0);

		BlockBuilder peridotite_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteBrick = peridotite_brick_builder.build("block.peridotite.brick", "block/peridotite_brick", 9954, b -> new BlockLogic(b, Material.basalt));
		miningLevels.put(peridotiteBrick,0);

		BlockBuilder peridotite_brick_slab_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteBrickSlab = peridotite_brick_slab_builder.build("block.peridotite.brick.slab", "block/peridotite_brick_slab", 9955, b -> new BlockLogicSlab(b, peridotiteBrick));
		miningLevels.put(peridotiteBrickSlab,0);

		BlockBuilder peridotite_brick_stairs_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteBrickStairs = peridotite_brick_stairs_builder.build("block.peridotite.brick.stairs", "block/peridotite_brick_stairs", 9956, b -> new BlockLogicStairs(b, peridotiteBrick));
		miningLevels.put(peridotiteBrickStairs,0);

		BlockBuilder peridotite_cobbled_slab_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteCobbledSlab = peridotite_cobbled_slab_builder.build("block.peridotite.cobbled.slab", "block/peridotite_cobbled_slab", 9957, b -> new BlockLogicSlab(b, peridotiteCobbled));
		miningLevels.put(peridotiteCobbledSlab,0);

		BlockBuilder peridotite_cobbled_stairs_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteCobbledStairs = peridotite_cobbled_stairs_builder.build("block.peridotite.cobbled.stairs", "block/peridotite_cobbled_stairs", 9958, b -> new BlockLogicStairs(b, peridotiteCobbled));
		miningLevels.put(peridotiteCobbledStairs,0);

		BlockBuilder peridotite_lead_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteLeadOre = peridotite_lead_ore_builder.build("block.ore.peridotite.lead", "block/peridotite_lead_ore", 9959,  (b) -> new BlockLogicLeadOre(b, DEEPBlocks.peridotite, Material.basalt));
		miningLevels.put(peridotiteLeadOre,0);

		BlockBuilder peridotite_silver_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteSilverOre = peridotite_silver_ore_builder.build("block.ore.peridotite.silver", "block/peridotite_silver_ore", 9960,  (b) -> new BlockLogicSilverOre(b, DEEPBlocks.peridotite, Material.basalt));
		miningLevels.put(peridotiteSilverOre,2);

		BlockBuilder peridotite_uranium_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteUraniumOre = peridotite_uranium_ore_builder.build("block.ore.peridotite.uranium", "block/peridotite_uranium_ore", 9961,  (b) -> new BlockLogicUraniumOre(b, DEEPBlocks.peridotite, Material.basalt));
		miningLevels.put(peridotiteUraniumOre,2);

		BlockBuilder peridotite_amethyst_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteAmethystOre = peridotite_amethyst_ore_builder.build("block.ore.peridotite.amethyst", "block/peridotite_amethyst_ore", 9962,  (b) -> new BlockLogicAmethystOre(b, DEEPBlocks.peridotite, Material.basalt));
		miningLevels.put(peridotiteAmethystOre,2);

		BlockBuilder peridotite_diamond_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteDiamondOre = peridotite_diamond_ore_builder.build("block.ore.peridotite.diamond", "block/peridotite_diamond_ore", 9963,  (b) -> new BlockLogicOreDiamond(b, DEEPBlocks.peridotite, Material.basalt));
		miningLevels.put(peridotiteDiamondOre,2);

		BlockBuilder peridotite_gold_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteGoldOre = peridotite_gold_ore_builder.build("block.ore.peridotite.gold", "block/peridotite_gold_ore", 9964,  (b) -> new BlockLogicOreGold(b, DEEPBlocks.peridotite, Material.basalt));
		miningLevels.put(peridotiteGoldOre,2);

		BlockBuilder peridotite_iron_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteIronOre = peridotite_iron_ore_builder.build("block.ore.peridotite.iron", "block/peridotite_iron_ore", 9965,  (b) -> new BlockLogicOreIron(b, DEEPBlocks.peridotite, Material.basalt));
		miningLevels.put(peridotiteIronOre,1);

		BlockBuilder peridotite_lapis_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteLapisOre = peridotite_lapis_ore_builder.build("block.ore.peridotite.lapis", "block/peridotite_lapis_ore", 9966,  (b) -> new BlockLogicOreLapis(b, DEEPBlocks.peridotite, Material.basalt));
		miningLevels.put(peridotiteLapisOre,1);

		BlockBuilder peridotite_coal_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteCoalOre = peridotite_coal_ore_builder.build("block.ore.peridotite.coal", "block/peridotite_coal_ore", 9967,  (b) -> new BlockLogicOreCoal(b, DEEPBlocks.peridotite, Material.basalt));
		miningLevels.put(peridotiteCoalOre,0);

		BlockBuilder peridotite_redstone_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteRedstoneOre = peridotite_redstone_ore_builder.build("block.ore.peridotite.redstone", "block/peridotite_redstone_ore", 9968,  (b) -> new BlockLogicOreRedstone(b, DEEPBlocks.peridotite, Material.basalt, false, peridotiteRedstoneOre, peridotiteRedstoneGlowingOre));
		miningLevels.put(peridotiteRedstoneOre,0);

		BlockBuilder peridotite_redstone_glowing_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(3)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE,BlockTags.NOT_IN_CREATIVE_MENU);
		peridotiteRedstoneGlowingOre = peridotite_redstone_glowing_ore_builder.build("block.ore.peridotite.redstone.glowing", "block/peridotite_redstone_glowing_ore", 9969,  (b) -> new BlockLogicOreRedstone(b, (Block)null, Material.basalt, true, peridotiteRedstoneOre, peridotiteRedstoneOre));
		miningLevels.put(peridotiteRedstoneGlowingOre,0);

		BlockBuilder fluid_molten_gold_flowing_builder = new BlockBuilder(MOD_ID)
			.setHardness(4.0f)
			.setResistance(0.0f)
			.setLuminance(15)
			.setLightOpacity(15)
			.addTags(BlockTags.IS_LAVA, BlockTags.PLACE_OVERWRITES,BlockTags.NOT_IN_CREATIVE_MENU);
		fluidMoltenGoldFlowing = fluid_molten_gold_flowing_builder.build("block.fluid.molten.gold.flowing", "block/fluid_molten_gold_flowing", 9970, b -> new BlockLogicFluidFlowing(b, Material.lava, fluidMoltenGoldStill));

		BlockBuilder fluid_molten_gold_still_builder = new BlockBuilder(MOD_ID)
			.setHardness(4.0f)
			.setResistance(0.0f)
			.setLuminance(15)
			.addTags(BlockTags.IS_LAVA, BlockTags.PLACE_OVERWRITES,BlockTags.NOT_IN_CREATIVE_MENU);
		fluidMoltenGoldStill = fluid_molten_gold_still_builder.build("block.fluid.molten.gold.still", "block/fluid_molten_gold_still", 9971, b -> new BlockLogicFluidStill(b, Material.lava, fluidMoltenGoldFlowing));

		BlockBuilder netherrack_magnet_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(6)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		netherrackMagnetOre = netherrack_magnet_ore_builder.build("block.ore.netherrack.magnet", "block/netherrack_magnet_ore", 9972,  b -> new BlockLogicMagnetOre(b));
		miningLevels.put(netherrackMagnetOre,2);

		BlockBuilder stone_bismuth_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stoneBismuthOre = stone_bismuth_ore_builder.build("block.ore.stone.bismuth", "block/stone_bismuth_ore", 9973,  (b) -> new BlockLogicBismuthOre(b, Blocks.STONE, Material.stone));
		miningLevels.put(stoneBismuthOre,3);

		BlockBuilder basalt_bismuth_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		basaltBismuthOre = basalt_bismuth_ore_builder.build("block.ore.basalt.bismuth", "block/basalt_bismuth_ore", 9974,  (b) -> new BlockLogicBismuthOre(b, Blocks.BASALT, Material.basalt));
		miningLevels.put(basaltBismuthOre,3);

		BlockBuilder limestone_bismuth_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		limestoneBismuthOre = limestone_bismuth_ore_builder.build("block.ore.limestone.bismuth", "block/limestone_bismuth_ore", 9975,  (b) -> new BlockLogicBismuthOre(b, Blocks.LIMESTONE, Material.limestone));
		miningLevels.put(limestoneBismuthOre,3);

		BlockBuilder granite_bismuth_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		graniteBismuthOre = granite_bismuth_ore_builder.build("block.ore.granite.bismuth", "block/granite_bismuth_ore", 9976,  (b) -> new BlockLogicBismuthOre(b, Blocks.GRANITE, Material.granite));
		miningLevels.put(graniteBismuthOre,3);

		BlockBuilder permafrost_bismuth_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		permafrostBismuthOre = permafrost_bismuth_ore_builder.build("block.ore.permafrost.bismuth", "block/permafrost_bismuth_ore", 9977,  (b) -> new BlockLogicBismuthOre(b, Blocks.PERMAFROST, Material.permafrost));
		miningLevels.put(permafrostBismuthOre,3);

		BlockBuilder abyssalrite_bismuth_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		abyssalriteBismuthOre = abyssalrite_bismuth_ore_builder.build("block.ore.abyssalrite.bismuth", "block/abyssalrite_bismuth_ore", 9978,  (b) -> new BlockLogicBismuthOre(b, DEEPBlocks.abyssalrite, Material.basalt));
		miningLevels.put(abyssalriteBismuthOre,3);

		BlockBuilder pearlstone_bismuth_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		pearlstoneBismuthOre = pearlstone_bismuth_ore_builder.build("block.ore.pearlstone.bismuth", "block/pearlstone_bismuth_ore", 9979,  (b) -> new BlockLogicBismuthOre(b, DEEPBlocks.pearlstone, Material.basalt));
		miningLevels.put(pearlstoneBismuthOre,3);

		BlockBuilder peridotite_bismuth_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		peridotiteBismuthOre = peridotite_bismuth_ore_builder.build("block.ore.peridotite.bismuth", "block/peridotite_bismuth_ore", 9980,  (b) -> new BlockLogicBismuthOre(b, DEEPBlocks.peridotite, Material.basalt));
		miningLevels.put(peridotiteBismuthOre,3);

		BlockBuilder bismuth_block_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		bismuthBlock = bismuth_block_builder.build("block.bismuth", "block/bismuth_block", 9981, b -> new BlockLogic(b, Material.metal));
		miningLevels.put(bismuthBlock,3);

		BlockBuilder magnet_block_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		magnetBlock = magnet_block_builder.build("block.magnet", "block/magnet_block", 9982, b -> new BlockLogic(b, Material.metal));
		miningLevels.put(magnetBlock,2);

		BlockBuilder mesh_lead_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
			.setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.PREVENT_MOB_SPAWNS);
		meshLead = mesh_lead_builder.build("block.mesh.lead", "block/mesh_lead", 9983, b -> new BlockLogicLeadMesh(b));
		miningLevels.put(meshLead,1);

		BlockBuilder bismuth_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		bismuthBrick = bismuth_brick_builder.build("block.bismuth.brick", "block/bismuth_brick", 9984, b -> new BlockLogic(b, Material.metal));
		miningLevels.put(bismuthBrick,3);

		BlockBuilder slab_bismuth_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		slabBismuthBrick = slab_bismuth_brick_builder.build("block.slab.bismuth.brick", "block/bismuth_brick_slab", 9985, b -> new BlockLogicSlab(b, bismuthBrick));
		miningLevels.put(slabBismuthBrick,3);

		BlockBuilder stairs_bismuth_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stairsBismuthBrick = stairs_bismuth_brick_builder.build("block.stairs.bismuth.brick", "block/bismuth_brick_stairs", 9986, b -> new BlockLogicStairs(b, bismuthBrick));
		miningLevels.put(stairsBismuthBrick,3);

		BlockBuilder magnet_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		magnetBrick = magnet_brick_builder.build("block.magnet.brick", "block/magnet_brick", 9987, b -> new BlockLogic(b, Material.metal));
		miningLevels.put(magnetBrick,2);

		BlockBuilder slab_magnet_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		slabMagnetBrick = slab_magnet_brick_builder.build("block.slab.magnet.brick", "block/magnet_brick_slab", 9988, b -> new BlockLogicSlab(b, magnetBrick));
		miningLevels.put(slabMagnetBrick,2);

		BlockBuilder stairs_magnet_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		stairsMagnetBrick = stairs_magnet_brick_builder.build("block.stairs.magnet.brick", "block/magnet_brick_stairs", 9989, b -> new BlockLogicStairs(b, magnetBrick));
		miningLevels.put(stairsMagnetBrick,2);

		BlockBuilder sugar_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.SAND)
			.addTags(BlockTags.MINEABLE_BY_SHOVEL);
		blockSugar = sugar_builder.build("block.sugar", "block/sugar", 9990, b -> new BlockLogicSand(b));

		BlockBuilder string_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.CLOTH)
			.addTags(BlockTags.MINEABLE_BY_SHEARS);
		blockString = string_builder.build("block.string", "block/string", 9991, b -> new BlockLogic(b, Material.cloth));

		BlockBuilder cloth_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.CLOTH)
			.addTags(BlockTags.MINEABLE_BY_SHEARS);
		blockCloth = cloth_builder.build("block.cloth", "block/cloth", 9992, b -> new BlockLogic(b, Material.cloth));

		BlockBuilder leather_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.CLOTH)
			.addTags(BlockTags.MINEABLE_BY_SHEARS);
		blockLeather = leather_builder.build("block.leather", "block/leather", 9993, b -> new BlockLogic(b, Material.cloth));

		BlockBuilder chainlink_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.METAL)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		blockChainlink = chainlink_builder.build("block.chainlink", "block/chainlink", 9994, b -> new BlockLogic(b, Material.metal));

		BlockBuilder feather_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.CLOTH)
			.addTags(BlockTags.MINEABLE_BY_SHEARS);
		blockFeather = feather_builder.build("block.feather", "block/feather", 9995, b -> new BlockLogic(b, Material.cloth));

		BlockBuilder gunpowder_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.SAND)
			.addTags(BlockTags.MINEABLE_BY_SHOVEL);
		blockGunpowder = gunpowder_builder.build("block.gunpowder", "block/gunpowder", 9996, b -> new BlockLogicSand(b));

		BlockBuilder packed_mud_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		packedMud = packed_mud_builder.build("block.mud.packed", "block/mud_packed", 9997, b -> new BlockLogic(b, Material.dirt));
		miningLevels.put(packedMud,0);

		BlockBuilder packed_mud_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		packedMudBrick = packed_mud_brick_builder.build("block.mud.packed.brick", "block/mud_packed_brick", 9998, b -> new BlockLogic(b, Material.basalt));
		miningLevels.put(packedMudBrick,0);

		BlockBuilder packed_mud_brick_slab_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		packedMudBrickSlab = packed_mud_brick_slab_builder.build("block.mud.packed.brick.slab", "block/mud_packed_brick_slab", 9999, b -> new BlockLogicSlab(b, packedMudBrick));
		miningLevels.put(packedMudBrickSlab,0);

		BlockBuilder packed_mud_brick_stairs_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		packedMudBrickStairs = packed_mud_brick_stairs_builder.build("block.mud.packed.brick.stairs", "block/mud_packed_brick_stairs", 10000, b -> new BlockLogicStairs(b, packedMudBrick));
		miningLevels.put(packedMudBrickStairs,0);

		BlockBuilder salt_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.SAND)
			.addTags(BlockTags.MINEABLE_BY_SHOVEL);
		blockSalt = salt_builder.build("block.salt", "block/salt", 10001, b -> new BlockLogicSalt(b));

		BlockBuilder brick_oven_idle_builder = new BlockBuilder(MOD_ID)
			.setHardness(4.0f)
			.setResistance(10.0f)
			.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
			.setTags(BlockTags.MINEABLE_BY_PICKAXE);
		brickOvenIdle = brick_oven_idle_builder.build("block.oven.brick.idle", "block/brick_oven_idle", 10002, b -> new BlockLogicBrickOven(b, false));

		BlockBuilder brick_oven_active_builder = new BlockBuilder(MOD_ID)
			.setHardness(4.0f)
			.setResistance(10.0f)
			.setLuminance(13)
			.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.0f))
			.setTags(BlockTags.NOT_IN_CREATIVE_MENU,BlockTags.MINEABLE_BY_PICKAXE);
		brickOvenActive = brick_oven_active_builder.build("block.oven.brick.active", "block/brick_oven_active", 10003, b -> new BlockLogicBrickOven(b, true));

		BlockBuilder gold_door_bottom_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.METAL)
			.addTags(BlockTags.NOT_IN_CREATIVE_MENU,BlockTags.MINEABLE_BY_PICKAXE);
		doorGoldBottom = gold_door_bottom_builder.build("block.door.gold.bottom", "block/door_gold_bottom", 10004, b -> new BlockLogicDoor(b, Material.metal, false, true, () -> DEEPItems.doorGold));

		BlockBuilder gold_door_top_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.METAL)
			.addTags(BlockTags.NOT_IN_CREATIVE_MENU,BlockTags.MINEABLE_BY_PICKAXE);
		doorGoldTop = gold_door_top_builder.build("block.door.gold.top", "block/door_gold_top", 10005, b -> new BlockLogicDoor(b, Material.metal, true, true, () -> DEEPItems.doorGold));

		BlockBuilder silver_door_bottom_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.METAL)
			.addTags(BlockTags.NOT_IN_CREATIVE_MENU,BlockTags.MINEABLE_BY_PICKAXE);
		doorSilverBottom = silver_door_bottom_builder.build("block.door.silver.bottom", "block/door_silver_bottom", 10006, b -> new BlockLogicDoor(b, Material.metal, false, true, () -> DEEPItems.doorSilver));

		BlockBuilder silver_door_top_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.METAL)
			.addTags(BlockTags.NOT_IN_CREATIVE_MENU,BlockTags.MINEABLE_BY_PICKAXE);
		doorSilverTop = silver_door_top_builder.build("block.door.silver.top", "block/door_silver_top", 10007, b -> new BlockLogicDoor(b, Material.metal, true, true, () -> DEEPItems.doorSilver));

		BlockBuilder lead_door_bottom_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.METAL)
			.addTags(BlockTags.NOT_IN_CREATIVE_MENU,BlockTags.MINEABLE_BY_PICKAXE);
		doorLeadBottom = lead_door_bottom_builder.build("block.door.lead.bottom", "block/door_lead_bottom", 10008, b -> new BlockLogicDoor(b, Material.metal, false, true, () -> DEEPItems.doorLead));

		BlockBuilder lead_door_top_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setBlockSound(BlockSounds.METAL)
			.addTags(BlockTags.NOT_IN_CREATIVE_MENU,BlockTags.MINEABLE_BY_PICKAXE);
		doorLeadTop = lead_door_top_builder.build("block.door.lead.top", "block/door_lead_top", 10009, b -> new BlockLogicDoor(b, Material.metal, true, true, () -> DEEPItems.doorLead));

		BlockBuilder gold_trapdoor_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setBlockSound(BlockSounds.METAL)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		trapdoorGold = gold_trapdoor_builder.build("block.trapdoor.gold", "block/trapdoor_gold", 10010, b -> new BlockLogicTrapDoor(b, Material.metal));

		BlockBuilder silver_trapdoor_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setBlockSound(BlockSounds.METAL)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		trapdoorSilver = silver_trapdoor_builder.build("block.trapdoor.silver", "block/trapdoor_silver", 10011, b -> new BlockLogicTrapDoor(b, Material.metal));

		BlockBuilder lead_trapdoor_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setBlockSound(BlockSounds.METAL)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		trapdoorLead = lead_trapdoor_builder.build("block.trapdoor.lead", "block/trapdoor_lead", 10012, b -> new BlockLogicTrapDoor(b, Material.metal));

		BlockBuilder pressure_plate_basalt_cobble_builder = new BlockBuilder(MOD_ID)
			.setHardness(0.5f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setBlockSound(BlockSounds.STONE)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.PREVENT_MOB_SPAWNS);
		pressureplateCobbleBasalt = pressure_plate_basalt_cobble_builder.build("block.pressureplate.cobble.basalt", "block/pressure_plate_cobble_basalt", 10013, b -> new BlockLogicPressurePlate<>(b, Player.class, Material.stone));

		BlockBuilder pressure_plate_limestone_cobble_builder = new BlockBuilder(MOD_ID)
			.setHardness(0.5f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setBlockSound(BlockSounds.STONE)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.PREVENT_MOB_SPAWNS);
		pressureplateCobbleLimestone = pressure_plate_limestone_cobble_builder.build("block.pressureplate.cobble.limestone", "block/pressure_plate_cobble_limestone", 10014, b -> new BlockLogicPressurePlate<>(b, Player.class, Material.stone));

		BlockBuilder pressure_plate_granite_cobble_builder = new BlockBuilder(MOD_ID)
			.setHardness(0.5f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setBlockSound(BlockSounds.STONE)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.PREVENT_MOB_SPAWNS);
		pressureplateCobbleGranite = pressure_plate_granite_cobble_builder.build("block.pressureplate.cobble.granite", "block/pressure_plate_cobble_granite", 10015, b -> new BlockLogicPressurePlate<>(b, Player.class, Material.stone));

		BlockBuilder pressure_plate_permafrost_cobble_builder = new BlockBuilder(MOD_ID)
			.setHardness(0.5f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setBlockSound(BlockSounds.STONE)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.PREVENT_MOB_SPAWNS);
		pressureplateCobblePermafrost = pressure_plate_permafrost_cobble_builder.build("block.pressureplate.cobble.permafrost", "block/pressure_plate_cobble_permafrost", 10016, b -> new BlockLogicPressurePlate<>(b, Player.class, Material.stone));

		BlockBuilder pressure_plate_netherrack_cobble_builder = new BlockBuilder(MOD_ID)
			.setHardness(0.5f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setBlockSound(BlockSounds.STONE)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.PREVENT_MOB_SPAWNS);
		pressureplateCobbleNetherrack = pressure_plate_netherrack_cobble_builder.build("block.pressureplate.cobble.netherrack", "block/pressure_plate_cobble_netherrack", 10017, b -> new BlockLogicPressurePlate<>(b, Player.class, Material.stone));

		BlockBuilder pressure_plate_abyssalrite_cobble_builder = new BlockBuilder(MOD_ID)
			.setHardness(0.5f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setBlockSound(BlockSounds.STONE)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.PREVENT_MOB_SPAWNS);
		pressureplateCobbleAbyssalrite = pressure_plate_abyssalrite_cobble_builder.build("block.pressureplate.cobble.abyssalrite", "block/pressure_plate_cobble_abyssalrite", 10018, b -> new BlockLogicPressurePlate<>(b, Player.class, Material.stone));

		BlockBuilder pressure_plate_pearlstone_cobble_builder = new BlockBuilder(MOD_ID)
			.setHardness(0.5f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setBlockSound(BlockSounds.STONE)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.PREVENT_MOB_SPAWNS);
		pressureplateCobblePearlstone = pressure_plate_pearlstone_cobble_builder.build("block.pressureplate.cobble.pearlstone", "block/pressure_plate_cobble_pearlstone", 10019, b -> new BlockLogicPressurePlate<>(b, Player.class, Material.stone));

		BlockBuilder pressure_plate_peridotite_cobble_builder = new BlockBuilder(MOD_ID)
			.setHardness(0.5f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setBlockSound(BlockSounds.STONE)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.PREVENT_MOB_SPAWNS);
		pressureplateCobblePeridotite = pressure_plate_peridotite_cobble_builder.build("block.pressureplate.cobble.peridotite", "block/pressure_plate_cobble_peridotite", 10020, b -> new BlockLogicPressurePlate<>(b, Player.class, Material.stone));

		BlockBuilder mushroom_silver_builder = new BlockBuilder(MOD_ID)
			.setHardness(0f)
			.setResistance(0f)
			.setLuminance(1)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLANTABLE_IN_JAR, BlockTags.MINEABLE_BY_SHEARS, BlockTags.PIGS_FAVOURITE_BLOCK);
		mushroomSilver = mushroom_silver_builder.build("block.mushroom.silver", "block/mushroom_silver", 10021, b -> new BlockLogicMushroom(b));

		BlockBuilder mushroom_gray_builder = new BlockBuilder(MOD_ID)
			.setHardness(0f)
			.setResistance(0f)
			.setLuminance(1)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLANTABLE_IN_JAR, BlockTags.MINEABLE_BY_SHEARS, BlockTags.PIGS_FAVOURITE_BLOCK);
		mushroomGray = mushroom_gray_builder.build("block.mushroom.gray", "block/mushroom_gray", 10022, b -> new BlockLogicMushroom(b));

		BlockBuilder mushroom_yellow_builder = new BlockBuilder(MOD_ID)
			.setHardness(0f)
			.setResistance(0f)
			.setLuminance(1)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLANTABLE_IN_JAR, BlockTags.MINEABLE_BY_SHEARS, BlockTags.PIGS_FAVOURITE_BLOCK);
		mushroomYellow = mushroom_yellow_builder.build("block.mushroom.yellow", "block/mushroom_yellow", 10023, b -> new BlockLogicMushroom(b));

		BlockBuilder scorched_sandstone_builder = new BlockBuilder(MOD_ID)
			.setHardness(2.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE,BlockTags.CAVES_CUT_THROUGH);
		scorchedSandstone = scorched_sandstone_builder.build("block.sandstone.scorched", "block/sandstone_scorched", 10024, b -> new BlockLogicCobble(b, Material.basalt, () -> GRAVEL));
		miningLevels.put(scorchedSandstone,0);

		BlockBuilder fossil_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(0.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		fossil = fossil_builder.build("block.fossil", "block/fossil", 10025, b -> new BlockLogic(b, Material.stone));
		miningLevels.put(fossil,2);

		BlockBuilder egg_spider_builder = new BlockBuilder(MOD_ID)
			.setHardness(0f)
			.setResistance(0f)
			.setLuminance(0)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.MINEABLE_BY_SHEARS);
		eggSpider = egg_spider_builder.build("block.egg.spider", "block/egg_spider", 10026, b -> new BlockLogicEggSpider(b));

		BlockBuilder crystal_quartz_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.5f)
			.setResistance(1f)
			.setLuminance(10)
			.setUseInternalLight()
			.setBlockSound(BlockSounds.GLASS)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE);
		crystalQuartz = crystal_quartz_builder.build("block.crystal.quartz", "block/crystal_quartz", 10027, b -> new BlockLogicCrystalQuartz(b));

		BlockBuilder statue_bast_top_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.MINEABLE_BY_PICKAXE, BlockTags.NOT_IN_CREATIVE_MENU);
		statueBastTop = statue_bast_top_builder.build("block.statue.bast.top", "block/statue_bast_top", 10028, b -> new BlockLogicStatueBastTop(b));

		BlockBuilder statue_bast_bottom_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.MINEABLE_BY_PICKAXE);
		statueBastBottom = statue_bast_bottom_builder.build("block.statue.bast.bottom", "block/statue_bast_bottom", 10029, b -> new BlockLogicStatueBastBottom(b));

		BlockBuilder scorched_sandstone_brick_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		scorchedSandstoneBrick = scorched_sandstone_brick_builder.build("block.sandstone.scorched.brick", "block/sandstone_scorched_brick", 10031, b -> new BlockLogic(b, Material.basalt));
		miningLevels.put(scorchedSandstoneBrick,0);

		BlockBuilder scorched_sandstone_slab_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		scorchedSandstoneSlab = scorched_sandstone_slab_builder.build("block.sandstone.scorched.slab", "block/sandstone_scorched_slab", 10032, b -> new BlockLogicSlab(b, scorchedSandstone));
		miningLevels.put(scorchedSandstoneSlab,0);

		BlockBuilder scorched_sandstone_stairs_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		scorchedSandstoneStairs = scorched_sandstone_stairs_builder.build("block.sandstone.scorched.stairs", "block/sandstone_scorched_stairs", 10033, b -> new BlockLogicStairs(b, scorchedSandstone));
		miningLevels.put(scorchedSandstoneStairs,0);

		BlockBuilder scorched_sandstone_brick_slab_builder = new BlockBuilder(MOD_ID)
			.setHardness(1f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		scorchedSandstoneBrickSlab = scorched_sandstone_brick_slab_builder.build("block.sandstone.scorched.brick.slab", "block/sandstone_scorched_brick_slab", 10034, b -> new BlockLogicSlab(b, scorchedSandstoneBrick));
		miningLevels.put(scorchedSandstoneBrickSlab,0);

		BlockBuilder scorched_sandstone_brick_stairs_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		scorchedSandstoneBrickStairs = scorched_sandstone_brick_stairs_builder.build("block.sandstone.scorched.brick.stairs", "block/sandstone_scorched_brick_stairs", 10035, b -> new BlockLogicStairs(b, scorchedSandstoneBrick));
		miningLevels.put(scorchedSandstoneBrickStairs,0);

		BlockBuilder netherrack_adamantite_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setLuminance(6)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		netherrackAdamantiteOre = netherrack_adamantite_ore_builder.build("block.ore.netherrack.adamantite", "block/netherrack_adamantite_ore", 10036,  b -> new BlockLogicAdamantiteOre(b)).withBlastResistance(5.0F);
		miningLevels.put(netherrackAdamantiteOre,3);

		BlockBuilder netherrack_cryocoal_ore_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setLuminance(6)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		netherrackCryocoalOre = netherrack_cryocoal_ore_builder.build("block.ore.netherrack.cryocoal", "block/netherrack_cryocoal_ore", 10037,  b -> new BlockLogicCryocoalOre(b)).withBlastResistance(5.0F);
		miningLevels.put(netherrackCryocoalOre,2);

		BlockBuilder cryocoal_block_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		cryocoalBlock = cryocoal_block_builder.build("block.cryocoal", "cryocoal_block", 10038, b -> new BlockLogic(b, Material.stone));
		miningLevels.put(cryocoalBlock,2);

		BlockBuilder adamantite_block_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		adamantiteBlock = adamantite_block_builder.build("block.adamantite", "adamantite_block", 10039, b -> new BlockLogic(b, Material.metal));
		miningLevels.put(adamantiteBlock,3);

		BlockBuilder cryo_torch_builder = new BlockBuilder(MOD_ID)
			.setHardness(0f)
			.setResistance(0.0f)
			.setLuminance(11);
		cryoTorch = cryo_torch_builder.build("block.torch.cryo", "cryo_torch", 10040, b -> new BlockLogicCryoTorch(b));

		BlockBuilder fishnet_builder = new BlockBuilder(MOD_ID)
			.setHardness(0f)
			.setResistance(0f)
			.setBlockItem(ItemBlockFishnet::new)
			.setBlockSound(new BlockSound("step.cloth", "step.cloth", 1.0f, 1.0f))
			.setTags(BlockTags.BROKEN_BY_FLUIDS);
		fishnet = fishnet_builder.build("block.fishnet", "block/fishnet", 10041, b -> new BlockLogicFishNet(b));

		BlockBuilder honeycomb_block_builder = new BlockBuilder(MOD_ID)
			.setHardness(1.0f)
			.setResistance(1.0f)
			.setBlockSound(new BlockSound("step.wood", "step.wood", 1.0f, 1.0f))
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_AXE,BlockTags.MINEABLE_BY_SHEARS);
		blockHoneycomb = honeycomb_block_builder.build("block.honeycomb", "honeycomb_block", 10042, b -> new BlockLogicHive(b, Material.stone));

		BlockBuilder flint_block_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		blockFlint = flint_block_builder.build("block.flint", "flint_block", 10043, b -> new BlockLogic(b, Material.stone));

		BlockBuilder niter_block_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		blockNiter = niter_block_builder.build("block.niter", "niter_block", 10044, b -> new BlockLogic(b, Material.stone));

		BlockBuilder bone_block_builder = new BlockBuilder(MOD_ID)
			.setHardness(3.0f)
			.setResistance(10.0f)
			.setLuminance(0)
			.addTags(BlockTags.MINEABLE_BY_PICKAXE);
		blockBone = bone_block_builder.build("block.bone", "bone_block", 10045, b -> new BlockLogicFullyRotatable(b, Material.stone) {});

		BlockBuilder honey_block_builder = new BlockBuilder(MOD_ID)
			.setHardness(0.0f)
			.setResistance(1.0f)
			.setLuminance(0)
			.setBlockSound(new BlockSound("mob.slime", "mob.slime", 1.0f, 1.0f))
			.addTags();
		blockHoney = honey_block_builder.build("block.honey", "honey_block", 10046, b -> new BlockLogicHoney(b, Material.stone) {});




	}
}
