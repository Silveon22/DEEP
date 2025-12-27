package silveon22.deep;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.color.BlockColorLeavesOak;
import net.minecraft.client.render.block.model.*;
import net.minecraft.client.render.colorizer.Colorizers;
import net.minecraft.client.render.entity.*;
import net.minecraft.client.render.item.model.ItemModelBow;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelQuiver;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.client.render.model.*;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.Side;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.block.Models.BlockModelBigRepeater;
import silveon22.deep.block.Models.BlockModelLilypad;
import silveon22.deep.colormap.CoralColor;
import silveon22.deep.item.DEEPItems;
import silveon22.deep.mob.*;
import silveon22.deep.mob.model.*;
import silveon22.deep.mob.renderer.*;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

import static silveon22.deep.Deep.MOD_ID;
import static silveon22.deep.block.DEEPBlocks.*;
import static silveon22.deep.block.DEEPBlocks.netherrackSilverOre;

public class DEEPModels implements ModelEntrypoint {
	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {

		// Creating a standard block model (full block) an "applying" to the block data.
		ModelHelper.setBlockModel(rhodoniteBlock, () -> new BlockModelStandard<>(rhodoniteBlock)
				.setTex(0, MOD_ID + ":block/block_rhodonite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(rhodoniteBrick, () -> new BlockModelStandard<>(rhodoniteBrick)
				.setTex(0, MOD_ID + ":block/brick_rhodonite", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(DEEPBlocks.slabRhodoniteBrick));
		dispatcher.addDispatch(new BlockModelStairs<>(DEEPBlocks.stairsRhodoniteBrick));
		ModelHelper.setBlockModel(netherrackRhodoniteOre, () -> new BlockModelStandard<>(netherrackRhodoniteOre)
				.setTex(0, MOD_ID + ":block/ore/rhodonite/netherrack", Side.sides)
				.setTex(1, MOD_ID + ":block/ore/rhodonite/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(amethystBlock, () -> new BlockModelStandard<>(amethystBlock)
				.setTex(0, MOD_ID + ":block/block_amethyst", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(stoneAmethystOre, () -> new BlockModelStandard<>(stoneAmethystOre)
				.setTex(0, MOD_ID + ":block/ore/amethyst/stone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(basaltAmethystOre, () -> new BlockModelStandard<>(basaltAmethystOre)
				.setTex(0, MOD_ID + ":block/ore/amethyst/basalt", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(limestoneAmethystOre, () -> new BlockModelStandard<>(limestoneAmethystOre)
				.setTex(0, MOD_ID + ":block/ore/amethyst/limestone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(graniteAmethystOre, () -> new BlockModelStandard<>(graniteAmethystOre)
				.setTex(0, MOD_ID + ":block/ore/amethyst/granite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(permafrostAmethystOre, () -> new BlockModelStandard<>(permafrostAmethystOre)
				.setTex(0, MOD_ID + ":block/ore/amethyst/permafrost", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(silverBlock, () -> new BlockModelStandard<>(silverBlock)
				.setTex(0, MOD_ID + ":block/block_silver", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(stoneSilverOre, () -> new BlockModelStandard<>(stoneSilverOre)
				.setTex(0, MOD_ID + ":block/ore/silver/stone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(basaltSilverOre, () -> new BlockModelStandard<>(basaltSilverOre)
				.setTex(0, MOD_ID + ":block/ore/silver/basalt", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(limestoneSilverOre, () -> new BlockModelStandard<>(limestoneSilverOre)
				.setTex(0, MOD_ID + ":block/ore/silver/limestone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(graniteSilverOre, () -> new BlockModelStandard<>(graniteSilverOre)
				.setTex(0, MOD_ID + ":block/ore/silver/granite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(permafrostSilverOre, () -> new BlockModelStandard<>(permafrostSilverOre)
				.setTex(0, MOD_ID + ":block/ore/silver/permafrost", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(netherrackSilverOre, () -> new BlockModelStandard<>(netherrackSilverOre)
				.setTex(0, MOD_ID + ":block/ore/silver/netherrack", Side.sides)
				.setTex(1, MOD_ID + ":block/ore/silver/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(uraniumBlock, () -> new BlockModelStandard<>(uraniumBlock)
				.setTex(0, MOD_ID + ":block/block_uranium", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(stoneUraniumOre, () -> new BlockModelStandard<>(stoneUraniumOre)
				.setTex(0, MOD_ID + ":block/ore/uranium/stone", Side.sides)
				.setTex(1, MOD_ID + ":block/ore/uranium/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(basaltUraniumOre, () -> new BlockModelStandard<>(basaltUraniumOre)
				.setTex(0, MOD_ID + ":block/ore/uranium/basalt", Side.sides)
				.setTex(1, MOD_ID + ":block/ore/uranium/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(limestoneUraniumOre, () -> new BlockModelStandard<>(limestoneUraniumOre)
				.setTex(0, MOD_ID + ":block/ore/uranium/limestone", Side.sides)
				.setTex(1, MOD_ID + ":block/ore/uranium/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(graniteUraniumOre, () -> new BlockModelStandard<>(graniteUraniumOre)
				.setTex(0, MOD_ID + ":block/ore/uranium/granite", Side.sides)
				.setTex(1, MOD_ID + ":block/ore/uranium/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(permafrostUraniumOre, () -> new BlockModelStandard<>(permafrostUraniumOre)
				.setTex(0, MOD_ID + ":block/ore/uranium/permafrost", Side.sides)
				.setTex(1, MOD_ID + ":block/ore/uranium/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(leadBlock, () -> new BlockModelStandard<>(leadBlock)
				.setTex(0, MOD_ID + ":block/block_lead", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(leadedGlass, () -> new BlockModelTransparent<>(leadedGlass,false).onRenderLayer(1)
				.setTex(0, MOD_ID + ":block/glass_leaded", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(stoneLeadOre, () -> new BlockModelStandard<>(stoneLeadOre)
				.setTex(0, MOD_ID + ":block/ore/lead/stone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(basaltLeadOre, () -> new BlockModelStandard<>(basaltLeadOre)
				.setTex(0, MOD_ID + ":block/ore/lead/basalt", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(limestoneLeadOre, () -> new BlockModelStandard<>(limestoneLeadOre)
				.setTex(0, MOD_ID + ":block/ore/lead/limestone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(graniteLeadOre, () -> new BlockModelStandard<>(graniteLeadOre)
				.setTex(0, MOD_ID + ":block/ore/lead/granite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(permafrostLeadOre, () -> new BlockModelStandard<>(permafrostLeadOre)
				.setTex(0, MOD_ID + ":block/ore/lead/permafrost", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(blockClayRed, () -> new BlockModelStandard<>(blockClayRed)
				.setTex(0, MOD_ID + ":block/block_clay_red", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(brickClayBlue, () -> new BlockModelStandard<>(brickClayBlue)
				.setTex(0, MOD_ID + ":block/brick_clay_blue", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(DEEPBlocks.slabBrickClayBlue));
		dispatcher.addDispatch(new BlockModelStairs<>(DEEPBlocks.stairsBrickClayBlue));
		ModelHelper.setBlockModel(tileCeramicBlue, () -> new BlockModelStandard<>(tileCeramicBlue)
				.setTex(0, MOD_ID + ":block/tiles_ceramic_blue", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(tileCeramicRed, () -> new BlockModelStandard<>(tileCeramicRed)
				.setTex(0, MOD_ID + ":block/tiles_ceramic_red", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(DEEPBlocks.slabTileCeramicBlue));
		dispatcher.addDispatch(new BlockModelStairs<>(DEEPBlocks.stairsTileCeramicBlue));
		dispatcher.addDispatch(new BlockModelSlab<>(DEEPBlocks.slabTileCeramicRed));
		dispatcher.addDispatch(new BlockModelStairs<>(DEEPBlocks.stairsTileCeramicRed));
		ModelHelper.setBlockModel(netherrackTopazOre, () -> new BlockModelStandard<>(netherrackTopazOre)
				.setTex(0, MOD_ID + ":block/ore/topaz/netherrack", Side.sides)
				.setTex(1, MOD_ID + ":block/ore/topaz/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(wireframeSteel, () -> new BlockModelTransparent<>(wireframeSteel,false).onRenderLayer(1)
				.setTex(0, MOD_ID + ":block/wireframe_steel", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(mosaicPig, () -> new BlockModelStandard<>(mosaicPig)
				.setTex(0, MOD_ID + ":block/mosaic_pig", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(mosaicCreeper, () -> new BlockModelStandard<>(mosaicCreeper)
				.setTex(0, MOD_ID + ":block/mosaic_creeper", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(mosaicSteve, () -> new BlockModelStandard<>(mosaicSteve)
				.setTex(0, MOD_ID + ":block/mosaic_steve", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(clearGlass, () -> new BlockModelTransparent<>(clearGlass,false)
				.setTex(0, MOD_ID + ":block/glass_clear", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(olivineBrick, () -> new BlockModelStandard<>(olivineBrick)
				.setTex(0, MOD_ID + ":block/brick_olivine", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(DEEPBlocks.slabOlivineBrick));
		dispatcher.addDispatch(new BlockModelStairs<>(stairsOlivineBrick));
		ModelHelper.setBlockModel(quartzBrick, () -> new BlockModelStandard<>(quartzBrick)
				.setTex(0, MOD_ID + ":block/brick_quartz", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(slabQuartzBrick));
		dispatcher.addDispatch(new BlockModelStairs<>(stairsQuartzBrick));
		ModelHelper.setBlockModel(diamondBrick, () -> new BlockModelStandard<>(diamondBrick)
				.setTex(0, MOD_ID + ":block/brick_diamond", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(slabDiamondBrick));
		dispatcher.addDispatch(new BlockModelStairs<>(stairsDiamondBrick));
		ModelHelper.setBlockModel(amethystBrick, () -> new BlockModelStandard<>(amethystBrick)
				.setTex(0, MOD_ID + ":block/brick_amethyst", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(slabAmethystBrick));
		dispatcher.addDispatch(new BlockModelStairs<>(stairsAmethystBrick));
		ModelHelper.setBlockModel(silverBrick, () -> new BlockModelStandard<>(silverBrick)
				.setTex(0, MOD_ID + ":block/brick_silver", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(slabSilverBrick));
		dispatcher.addDispatch(new BlockModelStairs<>(stairsSilverBrick));
		ModelHelper.setBlockModel(leadBrick, () -> new BlockModelStandard<>(leadBrick)
				.setTex(0, MOD_ID + ":block/brick_lead", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(slabLeadBrick));
		dispatcher.addDispatch(new BlockModelStairs<>(stairsLeadBrick));
		ModelHelper.setBlockModel(mushroomExplosive, () -> new BlockModelCrossedSquares<>(mushroomExplosive)
				.setTex(0, MOD_ID + ":block/mushroom_explosive", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(mushroomBlue, () -> new BlockModelCrossedSquares<>(mushroomBlue)
				.setTex(0, MOD_ID + ":block/mushroom_blue", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(coarseDirt, () -> new BlockModelStandard<>(coarseDirt)
				.setTex(0, MOD_ID + ":block/coarse_dirt", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(coral, () -> new BlockModelStandard<>(coral)
				.setTex(0, MOD_ID + ":block/coral", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(cattailBottom, () -> new BlockModelCrossedSquares<>(cattailBottom)
				.setTex(0, MOD_ID + ":block/cattail_stem", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(cattailTop, () -> new BlockModelCrossedSquares<>(cattailTop)
				.setTex(0, MOD_ID + ":block/cattail_top", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(lilypad, () -> new BlockModelLilypad<>(lilypad)
				.setTex(0, MOD_ID + ":block/lilypad", Side.TOP)
				.setTex(0, MOD_ID + ":block/waterlily", Side.NORTH)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(freezerIdle, () -> new BlockModelHorizontalRotation<>(freezerIdle)
				.setTex(0, MOD_ID + ":block/freezer/side", Side.WEST)
				.setTex(0, MOD_ID + ":block/freezer/side", Side.EAST)
				.setTex(0, MOD_ID + ":block/freezer/side", Side.SOUTH)
				.setTex(0, MOD_ID + ":block/freezer/top", Side.TOP)
				.setTex(0, MOD_ID + ":block/freezer/top", Side.BOTTOM)
				.setTex(0, MOD_ID + ":block/freezer/idle_front", Side.NORTH)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(freezerActive, () -> new BlockModelHorizontalRotation<>(freezerActive)
				.setTex(0, MOD_ID + ":block/freezer/side", Side.WEST)
				.setTex(0, MOD_ID + ":block/freezer/side", Side.EAST)
				.setTex(0, MOD_ID + ":block/freezer/side", Side.SOUTH)
				.setTex(0, MOD_ID + ":block/freezer/top", Side.TOP)
				.setTex(0, MOD_ID + ":block/freezer/top", Side.BOTTOM)
				.setTex(0, MOD_ID + ":block/freezer/active_front", Side.NORTH)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(scorchedDirtPath, () -> new BlockModelStandard<>(scorchedDirtPath)
				.setTex(0, MOD_ID + ":block/grass_scorched_path/top", Side.TOP)
				.setTex(0, MOD_ID + ":block/grass_scorched_path/bottom", Side.BOTTOM)
				.setTex(0, MOD_ID + ":block/grass_scorched_path/side", Side.NORTH)
				.setTex(0, MOD_ID + ":block/grass_scorched_path/side", Side.SOUTH)
				.setTex(0, MOD_ID + ":block/grass_scorched_path/side", Side.EAST)
				.setTex(0, MOD_ID + ":block/grass_scorched_path/side", Side.WEST)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(sandPath, () -> new BlockModelStandard<>(sandPath)
				.setTex(0, MOD_ID + ":block/sand_path/top", Side.TOP)
				.setTex(0, MOD_ID + ":block/sand_path/bottom", Side.BOTTOM)
				.setTex(0, MOD_ID + ":block/sand_path/side", Side.NORTH)
				.setTex(0, MOD_ID + ":block/sand_path/side", Side.SOUTH)
				.setTex(0, MOD_ID + ":block/sand_path/side", Side.EAST)
				.setTex(0, MOD_ID + ":block/sand_path/side", Side.WEST)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(lapisTile, () -> new BlockModelStandard<>(lapisTile)
				.setTex(0, MOD_ID + ":block/tiles_lapis", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(slabLapisTile));
		dispatcher.addDispatch(new BlockModelStairs<>(stairsLapisTile));
		ModelHelper.setBlockModel(rhodoniteTile, () -> new BlockModelStandard<>(rhodoniteTile)
				.setTex(0, MOD_ID + ":block/tiles_rhodonite", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(slabRhodoniteTile));
		dispatcher.addDispatch(new BlockModelStairs<>(stairsRhodoniteTile));
		ModelHelper.setBlockModel(lapisSol, () -> new BlockModelStandard<>(lapisSol)
				.setTex(0, MOD_ID + ":block/lapis_sol", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(lapisLuna, () -> new BlockModelStandard<>(lapisLuna)
				.setTex(0, MOD_ID + ":block/lapis_luna", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(lapisBulb, () -> new BlockModelStandard<>(lapisBulb)
				.setTex(0, MOD_ID + ":block/bulb/lapis_side", Side.sides)
				.setTex(0, MOD_ID + ":block/bulb/lapis_top", Side.TOP)
				.setTex(0, MOD_ID + ":block/bulb/lapis_top", Side.BOTTOM)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(rhodoniteBulb, () -> new BlockModelStandard<>(rhodoniteBulb)
				.setTex(0, MOD_ID + ":block/bulb/rhodonite_side", Side.sides)
				.setTex(0, MOD_ID + ":block/bulb/rhodonite_top", Side.TOP)
				.setTex(0, MOD_ID + ":block/bulb/rhodonite_top", Side.BOTTOM)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(root, () -> new BlockModelCrossedSquares<>(root)
				.setTex(0, MOD_ID + ":block/root", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(ladderSteel, () -> new BlockModelLadder<>(ladderSteel)
				.setTex(0, MOD_ID + ":block/ladder_steel", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(silt, () -> new BlockModelStandard<>(silt)
				.setTex(0, MOD_ID + ":block/silt", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(slush, () -> new BlockModelStandard<>(slush)
				.setTex(0, MOD_ID + ":block/slush", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(stucco, () -> new BlockModelStandard<>(stucco)
				.setTex(0, MOD_ID + ":block/stucco", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(stuccoCarved, () -> new BlockModelStandard<>(stuccoCarved)
				.setTex(0, MOD_ID + ":block/carved_stucco", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(meshSilver, () -> new BlockModelStandard<>(meshSilver)
				.setTex(0, MOD_ID + ":block/mesh_silver", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(fenceGold, () -> new BlockModelFenceThin<>(DEEPBlocks.fenceGold,
			TextureRegistry.getTexture(MOD_ID + ":block/fence_gold/center"),
			null, TextureRegistry.getTexture(MOD_ID + ":block/fence_gold/top"),
			TextureRegistry.getTexture(MOD_ID + ":block/fence_gold/column"))
			.setAllTextures(0, MOD_ID + ":block/fence_gold/center")
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(fenceSilver, () -> new BlockModelFenceThin<>(DEEPBlocks.fenceSilver,
				TextureRegistry.getTexture(MOD_ID + ":block/fence_silver/center"),
				null, TextureRegistry.getTexture(MOD_ID + ":block/fence_silver/top"),
				TextureRegistry.getTexture(MOD_ID + ":block/fence_silver/column"))
				.setAllTextures(0, MOD_ID + ":block/fence_silver/center")
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(fenceLead, () -> new BlockModelFenceThin<>(DEEPBlocks.fenceLead,
				TextureRegistry.getTexture(MOD_ID + ":block/fence_lead/center"),
				null, TextureRegistry.getTexture(MOD_ID + ":block/fence_lead/top"),
				TextureRegistry.getTexture(MOD_ID + ":block/fence_lead/column"))
				.setAllTextures(0, MOD_ID + ":block/fence_lead/center")
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(repeaterBigIdle, () -> new BlockModelBigRepeater(DEEPBlocks.repeaterBigIdle)
				.setTex(0, MOD_ID + ":block/big_repeater/idle_top", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(repeaterBigActive, () -> new BlockModelBigRepeater(DEEPBlocks.repeaterBigActive)
				.setTex(0, MOD_ID + ":block/big_repeater/idle_top", Side.sides)
				.setTex(0, MOD_ID + ":block/big_repeater/active_top", Side.TOP)
				.setTex(1, MOD_ID + ":block/big_repeater/active_overlay", Side.TOP)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(soulsandRaging, () -> new BlockModelStandard<>(soulsandRaging)
				.setTex(0, MOD_ID + ":block/soulsand_raging", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(abyssalrite, () -> new BlockModelStandard<>(abyssalrite)
				.setTex(0, MOD_ID + ":block/abyssalrite", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(abyssalriteCobbled, () -> new BlockModelStandard<>(abyssalriteCobbled)
				.setTex(0, MOD_ID + ":block/cobbled_abyssalrite", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(abyssalriteCobbledSlab));
		dispatcher.addDispatch(new BlockModelStairs<>(abyssalriteCobbledStairs));

		ModelHelper.setBlockModel(abyssalritePolished, () -> new BlockModelStandard<>(abyssalritePolished)
				.setTex(0, MOD_ID + ":block/polished_abyssalrite_side", Side.sides)
				.setTex(0, MOD_ID + ":block/polished_abyssalrite_top", Side.TOP)
				.setTex(0, MOD_ID + ":block/polished_abyssalrite_top", Side.BOTTOM)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(abyssalriteCarved, () -> new BlockModelStandard<>(abyssalriteCarved)
				.setTex(0, MOD_ID + ":block/carved_abyssalrite", Side.sides)
				.setTex(0, MOD_ID + ":block/polished_abyssalrite_top", Side.TOP)
				.setTex(0, MOD_ID + ":block/polished_abyssalrite_top", Side.BOTTOM)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(abyssalritePolishedSlab));

		ModelHelper.setBlockModel(abyssalriteBrick, () -> new BlockModelStandard<>(abyssalriteBrick)
				.setTex(0, MOD_ID + ":block/brick_abyssalrite", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(abyssalriteBrickSlab));
		dispatcher.addDispatch(new BlockModelStairs<>(abyssalriteBrickStairs));

		ModelHelper.setBlockModel(abyssalriteAmethystOre, () -> new BlockModelStandard<>(abyssalriteAmethystOre)
				.setTex(0, MOD_ID + ":block/ore/amethyst/abyssalrite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(abyssalriteSilverOre, () -> new BlockModelStandard<>(abyssalriteSilverOre)
				.setTex(0, MOD_ID + ":block/ore/silver/abyssalrite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(abyssalriteLeadOre, () -> new BlockModelStandard<>(abyssalriteLeadOre)
				.setTex(0, MOD_ID + ":block/ore/lead/abyssalrite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(abyssalriteUraniumOre, () -> new BlockModelStandard<>(abyssalriteUraniumOre)
				.setTex(0, MOD_ID + ":block/ore/uranium/abyssalrite", Side.sides)
				.setTex(1, MOD_ID + ":block/ore/uranium/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(abyssalriteDiamondOre, () -> new BlockModelStandard<>(abyssalriteDiamondOre)
				.setTex(0, MOD_ID + ":block/ore/diamond/abyssalrite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(abyssalriteGoldOre, () -> new BlockModelStandard<>(abyssalriteGoldOre)
				.setTex(0, MOD_ID + ":block/ore/gold/abyssalrite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(abyssalriteIronOre, () -> new BlockModelStandard<>(abyssalriteIronOre)
				.setTex(0, MOD_ID + ":block/ore/iron/abyssalrite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(abyssalriteLapisOre, () -> new BlockModelStandard<>(abyssalriteLapisOre)
				.setTex(0, MOD_ID + ":block/ore/lapis/abyssalrite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(abyssalriteCoalOre, () -> new BlockModelStandard<>(abyssalriteCoalOre)
				.setTex(0, MOD_ID + ":block/ore/coal/abyssalrite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(abyssalriteRedstoneOre, () -> new BlockModelStandard<>(abyssalriteRedstoneOre)
				.setTex(0, MOD_ID + ":block/ore/redstone/abyssalrite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(abyssalriteRedstoneGlowingOre, () -> new BlockModelStandard<>(abyssalriteRedstoneGlowingOre)
				.setTex(0, MOD_ID + ":block/ore/redstone/abyssalrite", Side.sides)
				.setTex(1, "minecraft:block/ore/redstone/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(pearlstone, () -> new BlockModelStandard<>(pearlstone)
				.setTex(0, MOD_ID + ":block/pearlstone", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(pearlstoneCobbled, () -> new BlockModelStandard<>(pearlstoneCobbled)
				.setTex(0, MOD_ID + ":block/cobbled_pearlstone", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		dispatcher.addDispatch(new BlockModelSlab<>(pearlstoneCobbledSlab));
		dispatcher.addDispatch(new BlockModelStairs<>(pearlstoneCobbledStairs));

		ModelHelper.setBlockModel(pearlstonePolished, () -> new BlockModelStandard<>(pearlstonePolished)
				.setTex(0, MOD_ID + ":block/polished_pearlstone_side", Side.sides)
				.setTex(0, MOD_ID + ":block/polished_pearlstone_top", Side.TOP)
				.setTex(0, MOD_ID + ":block/polished_pearlstone_top", Side.BOTTOM)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(pearlstoneCarved, () -> new BlockModelStandard<>(pearlstoneCarved)
				.setTex(0, MOD_ID + ":block/carved_pearlstone", Side.sides)
				.setTex(0, MOD_ID + ":block/polished_pearlstone_top", Side.TOP)
				.setTex(0, MOD_ID + ":block/polished_pearlstone_top", Side.BOTTOM)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(pearlstonePolishedSlab));

		ModelHelper.setBlockModel(pearlstoneBrick, () -> new BlockModelStandard<>(pearlstoneBrick)
				.setTex(0, MOD_ID + ":block/brick_pearlstone", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(pearlstoneBrickSlab));
		dispatcher.addDispatch(new BlockModelStairs<>(pearlstoneBrickStairs));

		ModelHelper.setBlockModel(pearlstoneAmethystOre, () -> new BlockModelStandard<>(pearlstoneAmethystOre)
				.setTex(0, MOD_ID + ":block/ore/amethyst/pearlstone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(pearlstoneSilverOre, () -> new BlockModelStandard<>(pearlstoneSilverOre)
				.setTex(0, MOD_ID + ":block/ore/silver/pearlstone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(pearlstoneLeadOre, () -> new BlockModelStandard<>(pearlstoneLeadOre)
				.setTex(0, MOD_ID + ":block/ore/lead/pearlstone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(pearlstoneUraniumOre, () -> new BlockModelStandard<>(pearlstoneUraniumOre)
				.setTex(0, MOD_ID + ":block/ore/uranium/pearlstone", Side.sides)
				.setTex(1, MOD_ID + ":block/ore/uranium/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(pearlstoneDiamondOre, () -> new BlockModelStandard<>(pearlstoneDiamondOre)
				.setTex(0, MOD_ID + ":block/ore/diamond/pearlstone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(pearlstoneGoldOre, () -> new BlockModelStandard<>(pearlstoneGoldOre)
				.setTex(0, MOD_ID + ":block/ore/gold/pearlstone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(pearlstoneIronOre, () -> new BlockModelStandard<>(pearlstoneIronOre)
				.setTex(0, MOD_ID + ":block/ore/iron/pearlstone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(pearlstoneLapisOre, () -> new BlockModelStandard<>(pearlstoneLapisOre)
				.setTex(0, MOD_ID + ":block/ore/lapis/pearlstone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(pearlstoneCoalOre, () -> new BlockModelStandard<>(pearlstoneCoalOre)
				.setTex(0, MOD_ID + ":block/ore/coal/pearlstone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(pearlstoneRedstoneOre, () -> new BlockModelStandard<>(pearlstoneRedstoneOre)
				.setTex(0, MOD_ID + ":block/ore/redstone/pearlstone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(pearlstoneRedstoneGlowingOre, () -> new BlockModelStandard<>(pearlstoneRedstoneGlowingOre)
				.setTex(0, MOD_ID + ":block/ore/redstone/pearlstone", Side.sides)
				.setTex(1, "minecraft:block/ore/redstone/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(peridotite, () -> new BlockModelStandard<>(peridotite)
				.setTex(0, MOD_ID + ":block/peridotite", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(peridotiteCobbled, () -> new BlockModelStandard<>(peridotiteCobbled)
				.setTex(0, MOD_ID + ":block/cobbled_peridotite", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		dispatcher.addDispatch(new BlockModelSlab<>(peridotiteCobbledSlab));
		dispatcher.addDispatch(new BlockModelStairs<>(peridotiteCobbledStairs));

		ModelHelper.setBlockModel(peridotitePolished, () -> new BlockModelStandard<>(peridotitePolished)
				.setTex(0, MOD_ID + ":block/polished_peridotite_side", Side.sides)
				.setTex(0, MOD_ID + ":block/polished_peridotite_top", Side.TOP)
				.setTex(0, MOD_ID + ":block/polished_peridotite_top", Side.BOTTOM)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(peridotiteCarved, () -> new BlockModelStandard<>(peridotiteCarved)
				.setTex(0, MOD_ID + ":block/carved_peridotite", Side.sides)
				.setTex(0, MOD_ID + ":block/polished_peridotite_top", Side.TOP)
				.setTex(0, MOD_ID + ":block/polished_peridotite_top", Side.BOTTOM)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(peridotitePolishedSlab));

		ModelHelper.setBlockModel(peridotiteBrick, () -> new BlockModelStandard<>(peridotiteBrick)
				.setTex(0, MOD_ID + ":block/brick_peridotite", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(peridotiteBrickSlab));
		dispatcher.addDispatch(new BlockModelStairs<>(peridotiteBrickStairs));

		ModelHelper.setBlockModel(peridotiteAmethystOre, () -> new BlockModelStandard<>(peridotiteAmethystOre)
				.setTex(0, MOD_ID + ":block/ore/amethyst/peridotite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(peridotiteSilverOre, () -> new BlockModelStandard<>(peridotiteSilverOre)
				.setTex(0, MOD_ID + ":block/ore/silver/peridotite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(peridotiteLeadOre, () -> new BlockModelStandard<>(peridotiteLeadOre)
				.setTex(0, MOD_ID + ":block/ore/lead/peridotite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(peridotiteUraniumOre, () -> new BlockModelStandard<>(peridotiteUraniumOre)
				.setTex(0, MOD_ID + ":block/ore/uranium/peridotite", Side.sides)
				.setTex(1, MOD_ID + ":block/ore/uranium/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(peridotiteDiamondOre, () -> new BlockModelStandard<>(peridotiteDiamondOre)
				.setTex(0, MOD_ID + ":block/ore/diamond/peridotite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(peridotiteGoldOre, () -> new BlockModelStandard<>(peridotiteGoldOre)
				.setTex(0, MOD_ID + ":block/ore/gold/peridotite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(peridotiteIronOre, () -> new BlockModelStandard<>(peridotiteIronOre)
				.setTex(0, MOD_ID + ":block/ore/iron/peridotite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(peridotiteLapisOre, () -> new BlockModelStandard<>(peridotiteLapisOre)
				.setTex(0, MOD_ID + ":block/ore/lapis/peridotite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(peridotiteCoalOre, () -> new BlockModelStandard<>(peridotiteCoalOre)
				.setTex(0, MOD_ID + ":block/ore/coal/peridotite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(peridotiteRedstoneOre, () -> new BlockModelStandard<>(peridotiteRedstoneOre)
				.setTex(0, MOD_ID + ":block/ore/redstone/peridotite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(peridotiteRedstoneGlowingOre, () -> new BlockModelStandard<>(peridotiteRedstoneGlowingOre)
				.setTex(0, MOD_ID + ":block/ore/redstone/peridotite", Side.sides)
				.setTex(1, "minecraft:block/ore/redstone/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(fluidMoltenGoldStill, () -> new BlockModelFluid<>(fluidMoltenGoldStill)
				.setTex(0, MOD_ID + ":block/molten_gold_still", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(fluidMoltenGoldFlowing, () -> new BlockModelFluid<>(fluidMoltenGoldFlowing)
				.setTex(0, MOD_ID + ":block/molten_gold_flowing", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(netherrackMagnetOre, () -> new BlockModelStandard<>(netherrackMagnetOre)
				.setTex(0, MOD_ID + ":block/ore/magnet/netherrack", Side.sides)
				.setTex(1, MOD_ID + ":block/ore/magnet/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(stoneBismuthOre, () -> new BlockModelStandard<>(stoneBismuthOre)
				.setTex(0, MOD_ID + ":block/ore/bismuth/stone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(basaltBismuthOre, () -> new BlockModelStandard<>(basaltBismuthOre)
				.setTex(0, MOD_ID + ":block/ore/bismuth/basalt", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(limestoneBismuthOre, () -> new BlockModelStandard<>(limestoneBismuthOre)
				.setTex(0, MOD_ID + ":block/ore/bismuth/limestone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(graniteBismuthOre, () -> new BlockModelStandard<>(graniteBismuthOre)
				.setTex(0, MOD_ID + ":block/ore/bismuth/granite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(permafrostBismuthOre, () -> new BlockModelStandard<>(permafrostBismuthOre)
				.setTex(0, MOD_ID + ":block/ore/bismuth/permafrost", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(abyssalriteBismuthOre, () -> new BlockModelStandard<>(abyssalriteBismuthOre)
				.setTex(0, MOD_ID + ":block/ore/bismuth/abyssalrite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(pearlstoneBismuthOre, () -> new BlockModelStandard<>(pearlstoneBismuthOre)
				.setTex(0, MOD_ID + ":block/ore/bismuth/pearlstone", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(peridotiteBismuthOre, () -> new BlockModelStandard<>(peridotiteBismuthOre)
				.setTex(0, MOD_ID + ":block/ore/bismuth/peridotite", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(bismuthBlock, () -> new BlockModelStandard<>(bismuthBlock)
				.setTex(0, MOD_ID + ":block/block_bismuth", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(magnetBlock, () -> new BlockModelStandard<>(magnetBlock)
				.setTex(0, MOD_ID + ":block/block_magnet", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(meshLead, () -> new BlockModelStandard<>(meshLead)
				.setTex(0, MOD_ID + ":block/mesh_lead", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(bismuthBrick, () -> new BlockModelStandard<>(bismuthBrick)
				.setTex(0, MOD_ID + ":block/brick_bismuth", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(slabBismuthBrick));
		dispatcher.addDispatch(new BlockModelStairs<>(stairsBismuthBrick));
		ModelHelper.setBlockModel(magnetBrick, () -> new BlockModelStandard<>(magnetBrick)
				.setTex(0, MOD_ID + ":block/brick_magnet", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(slabMagnetBrick));
		dispatcher.addDispatch(new BlockModelStairs<>(stairsMagnetBrick));

		ModelHelper.setBlockModel(blockSugar, () -> new BlockModelStandard<>(blockSugar)
				.setTex(0, MOD_ID + ":block/block_sugar", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(blockString, () -> new BlockModelStandard<>(blockString)
				.setTex(0, MOD_ID + ":block/block_string", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(blockCloth, () -> new BlockModelStandard<>(blockCloth)
				.setTex(0, MOD_ID + ":block/block_cloth", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(blockLeather, () -> new BlockModelStandard<>(blockLeather)
				.setTex(0, MOD_ID + ":block/block_leather", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(blockChainlink, () -> new BlockModelStandard<>(blockChainlink)
				.setTex(0, MOD_ID + ":block/block_chainlink", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(blockFeather, () -> new BlockModelStandard<>(blockFeather)
				.setTex(0, MOD_ID + ":block/block_feather", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(blockGunpowder, () -> new BlockModelStandard<>(blockGunpowder)
				.setTex(0, MOD_ID + ":block/block_gunpowder", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(packedMud, () -> new BlockModelStandard<>(packedMud)
				.setTex(0, MOD_ID + ":block/packed_mud_baked", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(packedMudBrick, () -> new BlockModelStandard<>(packedMudBrick)
				.setTex(0, MOD_ID + ":block/bricks_packed_mud_baked", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(packedMudBrickSlab));
		dispatcher.addDispatch(new BlockModelStairs<>(packedMudBrickStairs));

		ModelHelper.setBlockModel(blockSalt, () -> new BlockModelStandard<>(blockSalt)
				.setTex(0, MOD_ID + ":block/block_salt", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(brickOvenIdle, () -> new BlockModelHorizontalRotation<>(brickOvenIdle)
				.setTex(0, MOD_ID + ":block/brick_oven/side", Side.WEST)
				.setTex(0, MOD_ID + ":block/brick_oven/side", Side.EAST)
				.setTex(0, MOD_ID + ":block/brick_oven/side", Side.SOUTH)
				.setTex(0, MOD_ID + ":block/brick_oven/top", Side.TOP)
				.setTex(0, MOD_ID + ":block/brick_oven/bottom", Side.BOTTOM)
				.setTex(0, MOD_ID + ":block/brick_oven/idle_front", Side.NORTH)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(brickOvenActive, () -> new BlockModelHorizontalRotation<>(brickOvenActive)
				.setTex(0, MOD_ID + ":block/brick_oven/side", Side.WEST)
				.setTex(0, MOD_ID + ":block/brick_oven/side", Side.EAST)
				.setTex(0, MOD_ID + ":block/brick_oven/side", Side.SOUTH)
				.setTex(0, MOD_ID + ":block/brick_oven/top", Side.TOP)
				.setTex(0, MOD_ID + ":block/brick_oven/bottom", Side.BOTTOM)
				.setTex(0, MOD_ID + ":block/brick_oven/active_front", Side.NORTH)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(doorGoldBottom, () -> new BlockModelDoor<>(doorGoldBottom)
				.setTex(0, MOD_ID + ":block/door/gold/bottom", Side.sides)
				.setTex(0, MOD_ID + ":block/door/gold/frame_top", Side.TOP)
				.setTex(0, MOD_ID + ":block/door/gold/frame_top", Side.BOTTOM)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(doorGoldTop, () -> new BlockModelDoor<>(doorGoldTop)
				.setTex(0, MOD_ID + ":block/door/gold/top", Side.sides)
				.setTex(0, MOD_ID + ":block/door/gold/frame_top", Side.TOP)
				.setTex(0, MOD_ID + ":block/door/gold/frame_top", Side.BOTTOM)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(doorSilverBottom, () -> new BlockModelDoor<>(doorSilverBottom)
				.setTex(0, MOD_ID + ":block/door/silver/bottom", Side.sides)
				.setTex(0, MOD_ID + ":block/door/silver/frame_top", Side.TOP)
				.setTex(0, MOD_ID + ":block/door/silver/frame_top", Side.BOTTOM)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(doorSilverTop, () -> new BlockModelDoor<>(doorSilverTop)
				.setTex(0, MOD_ID + ":block/door/silver/top", Side.sides)
				.setTex(0, MOD_ID + ":block/door/silver/frame_top", Side.TOP)
				.setTex(0, MOD_ID + ":block/door/silver/frame_top", Side.BOTTOM)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(doorLeadBottom, () -> new BlockModelDoor<>(doorLeadBottom)
				.setTex(0, MOD_ID + ":block/door/lead/bottom", Side.sides)
				.setTex(0, MOD_ID + ":block/door/lead/frame_top", Side.TOP)
				.setTex(0, MOD_ID + ":block/door/lead/frame_top", Side.BOTTOM)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(doorLeadTop, () -> new BlockModelDoor<>(doorLeadTop)
				.setTex(0, MOD_ID + ":block/door/lead/top", Side.sides)
				.setTex(0, MOD_ID + ":block/door/lead/frame_top", Side.TOP)
				.setTex(0, MOD_ID + ":block/door/lead/frame_top", Side.BOTTOM)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(trapdoorGold, () -> new BlockModelTrapDoor<>(trapdoorGold)
				.setTex(0, MOD_ID + ":block/door/gold/frame_top", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(trapdoorSilver, () -> new BlockModelTrapDoor<>(trapdoorSilver)
				.setTex(0, MOD_ID + ":block/door/silver/frame_top", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(trapdoorLead, () -> new BlockModelTrapDoor<>(trapdoorLead)
				.setTex(0, MOD_ID + ":block/door/lead/frame_top", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(pressureplateCobbleBasalt, () -> new BlockModelStandard<>(pressureplateCobbleBasalt).withCustomItemBounds((double)0.0F, (double)0.375F, (double)0.0F, (double)1.0F, (double)0.625F, (double)1.0F)
				.setTex(0, "minecraft:block/cobbled_basalt", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(pressureplateCobbleLimestone, () -> new BlockModelStandard<>(pressureplateCobbleLimestone).withCustomItemBounds((double)0.0F, (double)0.375F, (double)0.0F, (double)1.0F, (double)0.625F, (double)1.0F)
				.setTex(0, "minecraft:block/cobbled_limestone", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(pressureplateCobbleGranite, () -> new BlockModelStandard<>(pressureplateCobbleGranite).withCustomItemBounds((double)0.0F, (double)0.375F, (double)0.0F, (double)1.0F, (double)0.625F, (double)1.0F)
				.setTex(0, "minecraft:block/cobbled_granite", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(pressureplateCobblePermafrost, () -> new BlockModelStandard<>(pressureplateCobblePermafrost).withCustomItemBounds((double)0.0F, (double)0.375F, (double)0.0F, (double)1.0F, (double)0.625F, (double)1.0F)
				.setTex(0, "minecraft:block/cobbled_permafrost", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(pressureplateCobbleNetherrack, () -> new BlockModelStandard<>(pressureplateCobbleNetherrack).withCustomItemBounds((double)0.0F, (double)0.375F, (double)0.0F, (double)1.0F, (double)0.625F, (double)1.0F)
				.setTex(0, "minecraft:block/cobbled_netherrack", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(pressureplateCobbleAbyssalrite, () -> new BlockModelStandard<>(pressureplateCobbleAbyssalrite).withCustomItemBounds((double)0.0F, (double)0.375F, (double)0.0F, (double)1.0F, (double)0.625F, (double)1.0F)
				.setTex(0, MOD_ID + ":block/cobbled_abyssalrite", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(pressureplateCobblePearlstone, () -> new BlockModelStandard<>(pressureplateCobblePearlstone).withCustomItemBounds((double)0.0F, (double)0.375F, (double)0.0F, (double)1.0F, (double)0.625F, (double)1.0F)
				.setTex(0, MOD_ID + ":block/cobbled_pearlstone", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(pressureplateCobblePeridotite, () -> new BlockModelStandard<>(pressureplateCobblePeridotite).withCustomItemBounds((double)0.0F, (double)0.375F, (double)0.0F, (double)1.0F, (double)0.625F, (double)1.0F)
				.setTex(0, MOD_ID + ":block/cobbled_peridotite", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(mushroomSilver, () -> new BlockModelCrossedSquares<>(mushroomSilver)
				.setTex(0, MOD_ID + ":block/mushroom_silver", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(mushroomGray, () -> new BlockModelCrossedSquares<>(mushroomGray)
				.setTex(0, MOD_ID + ":block/mushroom_gray", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(mushroomYellow, () -> new BlockModelCrossedSquares<>(mushroomYellow)
				.setTex(0, MOD_ID + ":block/mushroom_yellow", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(scorchedSandstone, () -> new BlockModelStandard<>(scorchedSandstone)
				.setTex(0, MOD_ID + ":block/scorched_sandstone/side", Side.sides)
				.setTex(0, MOD_ID + ":block/scorched_sandstone/top", Side.TOP)
				.setTex(0, MOD_ID + ":block/scorched_sandstone/bottom", Side.BOTTOM)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(scorchedSandstoneSlab));
		dispatcher.addDispatch(new BlockModelStairs<>(scorchedSandstoneStairs));
		ModelHelper.setBlockModel(fossil, () -> new BlockModelStandard<>(fossil)
				.setTex(0, MOD_ID + ":block/fossil", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(eggSpider, () -> new BlockModelCrossedSquares<>(eggSpider)
				.setTex(0, MOD_ID + ":block/egg_spider", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(crystalQuartz, () -> new BlockModelCrossedSquares<>(crystalQuartz)
				.setTex(0, MOD_ID + ":block/crystal_quartz", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(statueBastBottom, () -> new BlockModelCrossedSquares<>(statueBastBottom)
				.setTex(0, MOD_ID + ":block/statue_bast/bottom", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(statueBastTop, () -> new BlockModelCrossedSquares<>(statueBastTop)
				.setTex(0, MOD_ID + ":block/statue_bast/top", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(scorchedSandstoneBrick, () -> new BlockModelStandard<>(scorchedSandstoneBrick)
				.setTex(0, MOD_ID + ":block/brick_scorched_sandstone", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		dispatcher.addDispatch(new BlockModelSlab<>(scorchedSandstoneBrickSlab));
		dispatcher.addDispatch(new BlockModelStairs<>(scorchedSandstoneBrickStairs));

		ModelHelper.setBlockModel(netherrackAdamantiteOre, () -> new BlockModelStandard<>(netherrackAdamantiteOre)
				.setTex(0, MOD_ID + ":block/ore/adamantite/netherrack", Side.sides)
				.setTex(1, MOD_ID + ":block/ore/adamantite/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(netherrackCryocoalOre, () -> new BlockModelStandard<>(netherrackCryocoalOre)
				.setTex(0, MOD_ID + ":block/ore/cryocoal/netherrack", Side.sides)
				.setTex(1, MOD_ID + ":block/ore/cryocoal/overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(cryocoalBlock, () -> new BlockModelStandard<>(cryocoalBlock)
				.setTex(0, MOD_ID + ":block/block_cryocoal", Side.sides)
				.setTex(1, MOD_ID + ":block/block_cryocoal_overlay", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(adamantiteBlock, () -> new BlockModelStandard<>(adamantiteBlock)
				.setTex(0, MOD_ID + ":block/block_adamantite", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(cryoTorch, () -> new BlockModelTorch<>(cryoTorch)
				.setTex(0, MOD_ID + ":block/torch_cryo", Side.sides)// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(fishnet, () -> new BlockModelAlgae<>(fishnet)
				.setTex(0, MOD_ID + ":block/fishnet", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(blockHoneycomb, () -> new BlockModelStandard<>(blockHoneycomb)
				.setTex(0, MOD_ID + ":block/block_honeycomb", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(blockFlint, () -> new BlockModelStandard<>(blockFlint)
				.setTex(0, MOD_ID + ":block/block_flint", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(blockNiter, () -> new BlockModelStandard<>(blockNiter)
				.setTex(0, MOD_ID + ":block/block_niter", Side.sides)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);

		ModelHelper.setBlockModel(blockBone, () -> new BlockModelFullyRotatable<>(blockBone)
				.setTex(0, MOD_ID + ":block/block_bone_side", Side.sides)
				.setTex(0, MOD_ID + ":block/block_bone_top", Side.TOP)
				.setTex(0, MOD_ID + ":block/block_bone_top", Side.BOTTOM)
			// setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
		ModelHelper.setBlockModel(blockHoney, () -> new BlockModelTransparent<>(blockHoney,false).onRenderLayer(1)
				.setTex(0, MOD_ID + ":block/honey", Side.sides) // setting the texture (don't forget the ':'). 'sides' can be: TOP, BOTTOM, NORTH, SOUTH, EAST, WEST
			// In resources create a folder 'assets', inside it another folder 'yourmodname', inside it 'textures', inside it 'block'. Inside it put the textures of your blocks with names in snake_case
		);
	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {
		ModelHelper.setItemModel(DEEPItems.rhodonite,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.rhodonite, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/rhodonite"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.amethyst,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.amethyst, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/amethyst"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.amethystPickaxe,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.amethystPickaxe, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_pickaxe_amethyst"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.amethystAxe,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.amethystAxe, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_axe_amethyst"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.amethystSword,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.amethystSword, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_sword_amethyst"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.amethystShovel,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.amethystShovel, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_shovel_amethyst"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.amethystHoe,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.amethystHoe, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_hoe_amethyst"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.amethystHelmet,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.amethystHelmet, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/armor_helmet_amethyst"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.amethystChestplate,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.amethystChestplate, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/armor_chestplate_amethyst"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.amethystLeggings,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.amethystLeggings, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/armor_leggings_amethyst"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.amethystBoots,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.amethystBoots, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/armor_boots_amethyst"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.rawSilver,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.rawSilver, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/ore_raw_silver"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.ingotSilver,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.ingotSilver, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/ingot_silver"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.silverHelmet,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.silverHelmet, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/armor_helmet_silver"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.silverChestplate,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.silverChestplate, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/armor_chestplate_silver"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.silverLeggings,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.silverLeggings, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/armor_leggings_silver"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.silverBoots,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.silverBoots, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/armor_boots_silver"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.silverPickaxe,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.silverPickaxe, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_pickaxe_silver"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.silverAxe,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.silverAxe, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_axe_silver"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.silverSword,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.silverSword, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_sword_silver"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.silverShovel,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.silverShovel, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_shovel_silver"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.silverHoe,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.silverHoe, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_hoe_silver"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.uranium,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.uranium, MOD_ID).setFullBright();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/uranium"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.rawLead,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.rawLead, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/ore_raw_lead"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.ingotLead,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.ingotLead, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/ingot_lead"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.leadPickaxe,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.leadPickaxe, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_pickaxe_lead"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.leadAxe,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.leadAxe, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_axe_lead"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.leadSword,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.leadSword, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_sword_lead"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.leadShovel,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.leadShovel, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_shovel_lead"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.leadHoe,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.leadHoe, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_hoe_lead"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.clayRed,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.clayRed, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/clay_red"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.clayBrickBlue,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.clayBrickBlue, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/brick_clay_blue"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.niter,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.niter, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/niter"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.topaz,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.topaz, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/topaz"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.gel,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.gel, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/gel"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.jelly,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.jelly, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/jelly"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.silverApple,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.silverApple, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_apple_silver"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.ammoKnifeSilver,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.ammoKnifeSilver, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/ammo_knife_silver"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.toolFishingRodSteel,()->{
			ItemModelStandard model = new DEEPModelFishingrodSteel(DEEPItems.toolFishingRodSteel, MOD_ID).setFull3D().setRotateWhenRendering();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_fishingrod_steel"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.toolBowSteel,()->{
			ItemModelStandard model = new ItemModelBow(DEEPItems.toolBowSteel, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_bow_steel"));
			return model;
		});
		ModelHelper.setItemModel(DEEPBlocks.cattailBottom.asItem(),()->{
			ItemModelStandard model = new ItemModelStandard(DEEPBlocks.cattailBottom.asItem(), MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"block/cattail_top"));
			return model;
		});
		ModelHelper.setItemModel(DEEPBlocks.lilypad.asItem(),()->{
			ItemModelStandard model = new ItemModelStandard(DEEPBlocks.lilypad.asItem(), MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/lilypad"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.rawSardine,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.rawSardine, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_sardine_raw"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.cookedSardine,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.cookedSardine, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_sardine_cooked"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.rawBass,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.rawBass, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_bass_raw"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.cookedBass,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.cookedBass, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_bass_cooked"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.frozenPorkchop,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.frozenPorkchop, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_porkchop_frozen"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.frozenSardine,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.frozenSardine, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_sardine_frozen"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.frozenTrout,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.frozenTrout, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_fish_frozen"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.frozenBass,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.frozenBass, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_bass_frozen"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.frozenCake,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.frozenCake, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_cake_frozen"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.frozenPumpkinPie,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.frozenPumpkinPie, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_pumpkin_pie_frozen"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.frozenCookie,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.frozenCookie, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_cookie_frozen"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.frozenApple,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.frozenApple, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_apple_frozen"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.frozenCherry,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.frozenCherry, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_cherry_frozen"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.frozenBread,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.frozenBread, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_bread_frozen"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.toolRadar,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.toolRadar, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_radar"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.bucketDrain,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.bucketDrain, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/bucket_drain"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.bigRepeater,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.bigRepeater, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/repeater_big"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.leadDrill,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.leadDrill, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_drill_lead"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.silverDrill,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.silverDrill, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_drill_silver"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.amethystDrill,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.amethystDrill, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_drill_amethyst"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.diamondDrill,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.diamondDrill, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_drill_diamond"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.goldDrill,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.goldDrill, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_drill_gold"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.ironDrill,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.ironDrill, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_drill_iron"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.steelDrill,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.steelDrill, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_drill_steel"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.bismuth,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.bismuth, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/bismuth"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.rawMagnet,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.rawSilver, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/ore_raw_magnet"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.ingotMagnet,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.ingotMagnet, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/ingot_magnet"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.bucketCeramicEmpty,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.bucketCeramicEmpty, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/bucket_ceramic"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.bucketCeramicWater,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.bucketCeramicWater, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/bucket_ceramic_water"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.divingHelmet,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.divingHelmet, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/armor_diving_helmet_gold"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.salt,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.salt, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/dust_salt"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.taffy,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.taffy, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_taffy"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.doorGold,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.doorGold, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/door_gold"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.doorSilver,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.doorSilver, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/door_silver"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.doorLead,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.doorLead, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/door_lead"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.huskBeetle,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.huskBeetle, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/husk_beetle"));
			return model;
		});
		ModelHelper.setItemModel(statueBastBottom.asItem(),()->{
			ItemModelStandard model = new ItemModelStandard(DEEPBlocks.cattailBottom.asItem(), MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/bast_statue"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.boatFurnace,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.boatFurnace, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/boat_furnace"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.leadHelmet,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.leadHelmet, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/armor_helmet_lead"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.leadChestplate,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.leadChestplate, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/armor_chestplate_lead"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.leadLeggings,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.leadLeggings, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/armor_leggings_lead"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.leadBoots,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.leadBoots, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/armor_boots_lead"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.adamantite,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.adamantite, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/adamantite"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.adamantiteDestroyer,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.adamantiteDestroyer, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_destroyer_adamantite"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.adamantiteWarAxe,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.adamantiteWarAxe, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_waraxe_adamantite"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.cryocoal,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.cryocoal, MOD_ID).setFullBright();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/cryocoal"));
			return model;
		});
		ModelHelper.setItemModel(cryoTorch.asItem(),()->{
			ItemModelStandard model = new ItemModelStandard(DEEPBlocks.cryoTorch.asItem(), MOD_ID).setFullBright();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"block/torch_cryo"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.lime,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.lime, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/food_lime"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.ammoHail,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.ammoHail, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/ammo_hail"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.toolMusket,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.toolMusket, MOD_ID).setFull3D();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/tool_musket"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.ammoBullet,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.ammoBullet, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/ammo_bullet"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.armorBandolier,()->{
			ItemModelStandard model = new ItemModelBandolier(DEEPItems.armorBandolier, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/armor_bandolier"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.armorBandolierEndless,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.armorBandolierEndless, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/armor_bandolier_gold"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.eyeShade,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.eyeShade, MOD_ID).setFullBright();
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/eye_shade"));
			return model;
		});
		ModelHelper.setItemModel(DEEPItems.honeycomb,()->{
			ItemModelStandard model = new ItemModelStandard(DEEPItems.honeycomb, MOD_ID);
			model.icon = TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/honeycomb"));
			return model;
		});

	}

	@Override
	public void initEntityModels(EntityRenderDispatcher dispatcher) {
		ModelHelper.setEntityModel(MobJellyfish.class, () -> new EntityRendererSprite<>(TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/jellyfish"))).setFullBright());
		ModelHelper.setEntityModel(MobShade.class, () -> new EntityRendererSprite<>(TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/shade"))).setFullBright().setScale(6));
		ModelHelper.setEntityModel(MobRedSlime.class, () -> new MobRendererSlime(new ModelSlime(16), new ModelSlime(0), 0.5F));
		ModelHelper.setEntityModel(MobNoteZombie.class, () -> new MobRendererBiped<>(new ModelNoteZombie(0), 0.5F));
		ModelHelper.setEntityModel(MobPistonZombie.class, () -> new MobRendererBiped<>(new ModelNoteZombie(0), 0.5F));
		ModelHelper.setEntityModel(MobWerewolf.class, () -> new MobRendererBiped<>(new ModelWerewolf(0), 0.5F));
		ModelHelper.setEntityModel(MobWisp.class, () -> new MobRenderer<>(new ModelWisp(), 0.5F));
		ModelHelper.setEntityModel(MobMotherSpider.class, () -> new MobRenderer<>(new ModelMotherSpider(0), 1.2F));
		ModelHelper.setEntityModel(MobBeetle.class, () -> new MobRendererBeetle());
		ModelHelper.setEntityModel(MobPopper.class, () -> new MobRendererPopper());
		ModelHelper.setEntityModel(EntityFurnaceBoat.class, EntityRendererFurnaceBoat::new);
		ModelHelper.setEntityModel(MobOutbackZombie.class, () -> new MobRendererBiped<>(new ModelOutbackZombie(0), 0.5F));
		ModelHelper.setEntityModel(MobTruffle.class, () -> new MobRendererTruffle());
		ModelHelper.setEntityModel(MobSnowbomination.class, () -> new MobRendererBiped<>(new ModelSnowbomination(0), 0.5F));
		ModelHelper.setEntityModel(MobBanditZombie.class, () -> new MobRendererBiped<>(new ModelOutbackZombie(0), 0.5F));
		ModelHelper.setEntityModel(ProjectileSilverKnife.class, () -> new EntityRendererSprite<>(TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/ammo_knife_silver"))));
		ModelHelper.setEntityModel(ProjectileHail.class, () -> new EntityRendererSprite<>(TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/ammo_hail"))).setScale(2));
		ModelHelper.setEntityModel(ProjectileBullet.class, () -> new EntityRendererSprite<>(TextureRegistry.getTexture(NamespaceID.getTemp(MOD_ID,"item/ammo_bullet"))));
		ModelHelper.setEntityModel(ProjectileWeb.class, () -> new EntityRendererSprite<>(TextureRegistry.getTexture(NamespaceID.getTemp("minecraft","block/cobweb"))));
		ModelHelper.setEntityModel(MobWasp.class, () -> new MobRendererWasp());

	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher dispatcher) {
		ModelHelper.setBlockColor(DEEPBlocks.coral, CoralColor::new);
		ModelHelper.setBlockColor(DEEPBlocks.lilypad, () -> new BlockColorLeavesOak(Colorizers.oak));

	}
}
