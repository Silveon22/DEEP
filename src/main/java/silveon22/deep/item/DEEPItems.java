package silveon22.deep.item;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.*;
import net.minecraft.core.item.material.ArmorMaterial;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tag.ItemTags;
import net.minecraft.core.item.tool.*;
import silveon22.deep.block.DEEPBlocks;
import turniplabs.halplibe.helper.ArmorHelper;
import turniplabs.halplibe.util.ItemInitEntrypoint;
import turniplabs.halplibe.helper.ItemBuilder;

import static silveon22.deep.Deep.MOD_ID;

public class DEEPItems implements ItemInitEntrypoint {
	private static int baseID = 182042;


	public static int getBaseID() {
		return baseID;
	}

	public static void setBaseID(int baseID) {
		DEEPItems.baseID = baseID;
	}

	public static ArmorMaterial amethyst_Armor = ArmorHelper.createArmorMaterial(MOD_ID, "amethyst", 45, 120.0F, 120.0F, 120.0F, 120.0F);
	public static ArmorMaterial silver_Armor = ArmorHelper.createArmorMaterial(MOD_ID, "silver", 160, 60.0F, 50.0F, 50.0F, 40.0F);
	public static ArmorMaterial lead_Armor = ArmorHelper.createArmorMaterial(MOD_ID, "lead", 200, 180.0F, -35.0F, -35.0F, -35.0F);
	public static ArmorMaterial diving_Armor = ArmorHelper.createArmorMaterial(MOD_ID, "diving", 0, 0f, 0f, 0f, 0f);
	public static ArmorMaterial bandolier_Armor = ArmorHelper.createArmorMaterial(MOD_ID, "bandolier", 0, 0f, 0f, 0f, 0f);
	public static ArmorMaterial gold_bandolier_Armor = ArmorHelper.createArmorMaterial(MOD_ID, "gold_bandolier", 0, 0f, 0f, 0f, 0f);
	public static ArmorMaterial beetle_Armor = ArmorHelper.createArmorMaterial(MOD_ID, "beetle", 200, 70.0F, 33.0F, 33.0F, 33.0F);

	public static Item rhodonite;
	public static Item amethyst;
	public static Item amethystPickaxe;
	public static Item amethystAxe;
	public static Item amethystSword;
	public static Item amethystShovel;
	public static Item amethystHoe;
	public static Item amethystHelmet;
	public static Item amethystChestplate;
	public static Item amethystLeggings;
	public static Item amethystBoots;
	public static Item rawSilver;
	public static Item ingotSilver;
	public static Item silverHelmet;
	public static Item silverChestplate;
	public static Item silverLeggings;
	public static Item silverBoots;
	public static Item silverPickaxe;
	public static Item silverAxe;
	public static Item silverSword;
	public static Item silverShovel;
	public static Item silverHoe;
	public static Item uranium;
	public static Item rawLead;
	public static Item ingotLead;
	public static Item leadPickaxe;
	public static Item leadAxe;
	public static Item leadSword;
	public static Item leadShovel;
	public static Item leadHoe;
	public static Item clayRed;
	public static Item clayBrickBlue;
	public static Item niter;
	public static Item topaz;
	public static Item gel;
	public static ItemJarred jelly;
	public static ItemFood silverApple;
	public static Item ammoKnifeSilver;
	public static Item toolFishingRodSteel;
	public static Item toolBowSteel;
	public static Item rawSardine;
	public static Item cookedSardine;
	public static Item rawBass;
	public static Item cookedBass;
	public static Item frozenPorkchop;
	public static Item frozenSardine;
	public static Item frozenTrout;
	public static Item frozenBass;
	public static Item frozenCake;
	public static Item frozenPumpkinPie;
	public static Item frozenCookie;
	public static Item frozenApple;
	public static Item frozenCherry;
	public static Item frozenBread;
	public static Item toolRadar;
	public static ItemBucketDrain bucketDrain;
	public static Item bigRepeater;
	public static Item leadDrill;
	public static Item silverDrill;
	public static Item amethystDrill;
	public static Item diamondDrill;
	public static Item goldDrill;
	public static Item ironDrill;
	public static Item steelDrill;
	public static Item bismuth;
	public static Item rawMagnet;
	public static Item ingotMagnet;
	public static ItemCeramicBucketEmpty bucketCeramicEmpty;
	public static ItemCeramicBucket bucketCeramicWater;
	public static ItemDivingHelmet divingHelmet;
	public static Item salt;
	public static Item taffy;
	public static Item doorGold;
	public static Item doorSilver;
	public static Item doorLead;
	public static Item huskBeetle;
	public static Item boatFurnace;
	public static Item leadHelmet;
	public static Item leadChestplate;
	public static Item leadLeggings;
	public static Item leadBoots;
	public static Item adamantite;
	public static Item adamantiteDestroyer;
	public static Item adamantiteWarAxe;
	public static Item cryocoal;
	public static ItemFoodSour lime;
	public static Item ammoHail;
	public static Item toolMusket;
	public static Item ammoBullet;
	public static Item armorBandolier;
	public static Item armorBandolierEndless;
	public static Item eyeShade;
	public static Item honeycomb;


	@Override
	public void afterItemInit() {
		rhodonite = new ItemBuilder(MOD_ID)
			.build(new Item("rhodonite", MOD_ID + ":item/rhodonite", 28043));
		amethyst = new ItemBuilder(MOD_ID)
			.build(new Item("amethyst", MOD_ID + ":item/amethyst", 28044));
		amethystPickaxe = new ItemBuilder(MOD_ID)
			.build(new ItemToolPickaxe("amethystpickaxe", MOD_ID + ":item/amethyst_pickaxe", 28045, new ToolMaterial().setDurability(96).setEfficiency(55.0F, 100.0F).setMiningLevel(3).setDamage(5).setBlockHitDelay(0)));
		amethystAxe = new ItemBuilder(MOD_ID)
			.build(new ItemToolAxe("amethystaxe", MOD_ID + ":item/amethyst_axe", 28046, new ToolMaterial().setDurability(96).setEfficiency(55.0F, 100.0F).setMiningLevel(3).setDamage(5).setBlockHitDelay(0)));
		amethystSword = new ItemBuilder(MOD_ID).setTags(ItemTags.PREVENT_CREATIVE_MINING)
			.build(new ItemToolSword("amethystsword", MOD_ID + ":item/amethyst_sword", 28047, new ToolMaterial().setDurability(96).setEfficiency(55.0F, 100.0F).setMiningLevel(3).setDamage(10).setBlockHitDelay(0)));
		amethystShovel = new ItemBuilder(MOD_ID)
			.build(new ItemToolShovel("amethystshovel", MOD_ID + ":item/amethyst_shovel", 28048, new ToolMaterial().setDurability(96).setEfficiency(55.0F, 100.0F).setMiningLevel(3).setDamage(5).setBlockHitDelay(0)));
		amethystHoe = new ItemBuilder(MOD_ID)
			.build(new ItemToolHoe("amethysthoe", MOD_ID + ":item/amethyst_hoe", 28049, new ToolMaterial().setDurability(96).setEfficiency(55.0F, 100.0F).setMiningLevel(3).setDamage(5).setBlockHitDelay(0)));
		amethystHelmet = new ItemBuilder(MOD_ID)
			.build(new ItemArmor("amethysthelmet", "deep:item/armor/amethyst_helmet", 28050, amethyst_Armor, 3));
		amethystChestplate = new ItemBuilder(MOD_ID)
			.build(new ItemArmor("amethystchestplate", "deep:item/armor/amethyst_chestplate", 28051, amethyst_Armor, 2));
		amethystLeggings = new ItemBuilder(MOD_ID)
			.build(new ItemArmor("amethystleggings", "deep:item/armor/amethyst_leggings", 28052, amethyst_Armor, 1));
		amethystBoots = new ItemBuilder(MOD_ID)
			.build(new ItemArmor("amethystboots", "deep:item/armor/amethyst_boots", 28053, amethyst_Armor, 0));
		rawSilver = new ItemBuilder(MOD_ID)
			.build(new Item("rawsilver", MOD_ID + ":item/raw_silver", 28054));
		ingotSilver = new ItemBuilder(MOD_ID)
			.build(new Item("ingotsilver", MOD_ID + ":item/ingot_silver", 28055));
		silverHelmet = new ItemBuilder(MOD_ID)
			.build(new ItemArmor("silverhelmet", "deep:item/armor/silver_helmet", 28056, silver_Armor, 3));
		silverChestplate = new ItemBuilder(MOD_ID)
			.build(new ItemArmor("silverchestplate", "deep:item/armor/silver_chestplate", 28057, silver_Armor, 2));
		silverLeggings = new ItemBuilder(MOD_ID)
			.build(new ItemArmor("silverleggings", "deep:item/armor/silver_leggings", 28058, silver_Armor, 1));
		silverBoots = new ItemBuilder(MOD_ID)
			.build(new ItemArmor("silverboots", "deep:item/armor/silver_boots", 28059, silver_Armor, 0));
		silverPickaxe = new ItemBuilder(MOD_ID)
			.build(new ItemToolPickaxe("silverpickaxe", MOD_ID + ":item/silver_pickaxe", 28060, new ToolMaterial().setDurability(512).setEfficiency(4.0F, 9.0F).setMiningLevel(2).setSilkTouch(true)));
		silverAxe = new ItemBuilder(MOD_ID)
			.build(new ItemToolAxe("silveraxe", MOD_ID + ":item/silver_axe", 28061, new ToolMaterial().setDurability(512).setEfficiency(4.0F, 9.0F).setMiningLevel(2).setSilkTouch(true)));
		silverSword = new ItemBuilder(MOD_ID).setTags(ItemTags.PREVENT_CREATIVE_MINING)
			.build(new ItemToolSword("silversword", MOD_ID + ":item/silver_sword", 28062, new ToolMaterial().setDurability(512).setEfficiency(4.0F, 9.0F).setMiningLevel(2).setSilkTouch(true).setDamage(2)));
		silverShovel = new ItemBuilder(MOD_ID)
			.build(new ItemToolShovel("silvershovel", MOD_ID + ":item/silver_shovel", 28063, new ToolMaterial().setDurability(512).setEfficiency(4.0F, 9.0F).setMiningLevel(2).setSilkTouch(true)));
		silverHoe = new ItemBuilder(MOD_ID)
			.build(new ItemToolHoe("silverhoe", MOD_ID + ":item/silver_hoe", 28064, new ToolMaterial().setDurability(512).setEfficiency(4.0F, 9.0F).setMiningLevel(2).setSilkTouch(true)));
		uranium = new ItemBuilder(MOD_ID)
			.build(new Item("uranium", MOD_ID + ":item/uranium", 28065));
		rawLead = new ItemBuilder(MOD_ID)
			.build(new Item("rawlead", MOD_ID + ":item/raw_lead", 28066));
		ingotLead = new ItemBuilder(MOD_ID)
			.build(new Item("ingotlead", MOD_ID + ":item/ingot_lead", 28067));
		leadPickaxe = new ItemBuilder(MOD_ID)
			.build(new ItemToolPickaxe("leadpickaxe", MOD_ID + ":item/lead_pickaxe", 28068, new ToolMaterial().setDurability(144).setEfficiency(8.0F, 10.0F).setMiningLevel(2)));
		leadAxe = new ItemBuilder(MOD_ID)
			.build(new ItemToolAxe("leadaxe", MOD_ID + ":item/lead_axe", 28069, new ToolMaterial().setDurability(144).setEfficiency(8.0F, 10.0F).setMiningLevel(2)));
		leadSword = new ItemBuilder(MOD_ID).setTags(ItemTags.PREVENT_CREATIVE_MINING)
			.build(new ItemToolSword("leadsword", MOD_ID + ":item/lead_sword", 28071, new ToolMaterial().setDurability(144).setEfficiency(8.0F, 10.0F).setMiningLevel(2).setDamage(3)));
		leadShovel = new ItemBuilder(MOD_ID)
			.build(new ItemToolShovel("leadshovel", MOD_ID + ":item/lead_shovel", 28072, new ToolMaterial().setDurability(144).setEfficiency(8.0F, 10.0F).setMiningLevel(2)));
		leadHoe = new ItemBuilder(MOD_ID)
			.build(new ItemToolHoe("leadhoe", MOD_ID + ":item/lead_hoe", 28073, new ToolMaterial().setDurability(144).setEfficiency(8.0F, 10.0F).setMiningLevel(2)));
		clayRed = new ItemBuilder(MOD_ID)
			.build(new Item("clayred", MOD_ID + ":item/clay_red", 28074));
		clayBrickBlue = new ItemBuilder(MOD_ID)
			.build(new Item("claybrickblue", MOD_ID + ":item/clay_brick_blue", 28075));
		niter = new ItemBuilder(MOD_ID)
			.build(new Item("niter", MOD_ID + ":item/niter", 28076));
		topaz = new ItemBuilder(MOD_ID)
			.build(new Item("topaz", MOD_ID + ":item/topaz", 28077));
		gel = new ItemBuilder(MOD_ID)
			.build(new Item("gel", MOD_ID + ":item/gel", 28078));
		jelly = new ItemBuilder(MOD_ID)
			.build(new ItemJarred("jelly",MOD_ID + ":item/jelly",28079, 6, 12));
		silverApple = new ItemBuilder(MOD_ID)
			.build(new ItemFood("silverapple",MOD_ID + ":item/silver_apple",28080, 12, 0, false, 2));
		ammoKnifeSilver = new ItemBuilder(MOD_ID)
			.build(new ItemSilverKnife("ammo.knife.silver",MOD_ID + ":item/ammo_knife_silver",28081));
		toolFishingRodSteel = new ItemBuilder(MOD_ID)
			.build(new itemFishingRodSteel("tool.fishingrod.steel",MOD_ID + ":item/tool_fishingrod_steel",28082));
		toolBowSteel = new ItemBuilder(MOD_ID)
			.build(new itemBowSteel("tool.bow.steel",MOD_ID + ":item/tool_bow_steel",28083));
		rawSardine = new ItemBuilder(MOD_ID)
			.build(new ItemFood("sardine.raw",MOD_ID + ":item/sardine_raw",28084, 1, 14, false, 8));
		cookedSardine = new ItemBuilder(MOD_ID)
			.build(new ItemFood("sardine.cooked",MOD_ID + ":item/sardine_cooked",28085, 3, 14, false, 8));
		rawBass = new ItemBuilder(MOD_ID)
			.build(new ItemFood("bass.raw",MOD_ID + ":item/bass_raw",28086, 4, 8, false, 8));
		cookedBass = new ItemBuilder(MOD_ID)
			.build(new ItemFood("bass.cooked",MOD_ID + ":item/bass_cooked",28087, 6, 8, false, 8));
		frozenPorkchop = new ItemBuilder(MOD_ID)
			.build(new Item("porkchop.frozen",MOD_ID + ":item/food_porkchop_frozen",28088).setMaxStackSize(12));
		frozenTrout = new ItemBuilder(MOD_ID)
			.build(new Item("trout.frozen",MOD_ID + ":item/food_trout_frozen",28089).setMaxStackSize(24));
		frozenSardine = new ItemBuilder(MOD_ID)
			.build(new Item("sardine.frozen",MOD_ID + ":item/food_sardine_frozen",28090).setMaxStackSize(24));
		frozenBass = new ItemBuilder(MOD_ID)
			.build(new Item("bass.frozen",MOD_ID + ":item/food_bass_frozen",28091).setMaxStackSize(24));
		frozenCake = new ItemBuilder(MOD_ID)
			.build(new Item("cake.frozen",MOD_ID + ":item/food_cake_frozen",28092).setMaxStackSize(3));
		frozenPumpkinPie = new ItemBuilder(MOD_ID)
			.build(new Item("pie.pumpkin.frozen",MOD_ID + ":item/food_pumpkin_pie_frozen",28093).setMaxStackSize(3));
		frozenCookie = new ItemBuilder(MOD_ID)
			.build(new Item("cookie.frozen",MOD_ID + ":item/food_cookie_frozen",28094).setMaxStackSize(48));
		frozenApple = new ItemBuilder(MOD_ID)
			.build(new Item("apple.frozen",MOD_ID + ":item/food_apple_frozen",28095).setMaxStackSize(24));
		frozenCherry = new ItemBuilder(MOD_ID)
			.build(new Item("cherry.frozen",MOD_ID + ":item/food_cherry_frozen",28096).setMaxStackSize(6));
		frozenBread = new ItemBuilder(MOD_ID)
			.build(new Item("bread.frozen",MOD_ID + ":item/food_bread_frozen",28097).setMaxStackSize(24));
		toolRadar = new ItemBuilder(MOD_ID)
			.build(new Item("tool.radar",MOD_ID + ":item/tool_radar",28098));
		bucketDrain = new ItemBuilder(MOD_ID)
			.build(new ItemBucketDrain("bucket.drain",MOD_ID + ":item/bucket_drain",28099));
		bigRepeater = new ItemBuilder(MOD_ID)
			.build(new ItemPlaceable("repeater.big",MOD_ID + ":item/repeater_big",28100, DEEPBlocks.repeaterBigIdle));
		leadDrill = new ItemBuilder(MOD_ID)
			.build(new ItemToolDrill("leaddrill", MOD_ID + ":item/lead_drill", 28101, new ToolMaterial().setDurability(144).setEfficiency(8.0F*1.75F, 10.0F*1.75F).setMiningLevel(2)));
		silverDrill = new ItemBuilder(MOD_ID)
			.build(new ItemToolDrill("silverdrill", MOD_ID + ":item/silver_drill", 28102, new ToolMaterial().setDurability(512).setEfficiency(4.0F*1.75F, 9.0F*1.75F).setMiningLevel(2).setSilkTouch(true)));
		amethystDrill = new ItemBuilder(MOD_ID)
			.build(new ItemToolDrill("amethystdrill", MOD_ID + ":item/amethyst_drill", 28103, new ToolMaterial().setDurability(96).setEfficiency(55.0F*1.75F, 100.0F*1.75F).setMiningLevel(3).setDamage(5).setBlockHitDelay(0)));
		diamondDrill = new ItemBuilder(MOD_ID)
			.build(new ItemToolDrill("diamonddrill", MOD_ID + ":item/diamond_drill", 28104, new ToolMaterial().setDurability(1536).setEfficiency(14.0F*1.75F, 45.0F*1.75F).setMiningLevel(3).setDamage(4).setBlockHitDelay(4)));
		goldDrill = new ItemBuilder(MOD_ID)
			.build(new ItemToolDrill("golddrill", MOD_ID + ":item/gold_drill", 28105, new ToolMaterial().setDurability(256).setEfficiency(7.0F*1.75F, 12.0F*1.75F).setMiningLevel(2).setSilkTouch(true)));
		ironDrill = new ItemBuilder(MOD_ID)
			.build(new ItemToolDrill("irondrill", MOD_ID + ":item/iron_drill", 28106, new ToolMaterial().setDurability(384).setEfficiency(6.0F*1.75F, 8.0F*1.75F).setMiningLevel(2)));
		steelDrill = new ItemBuilder(MOD_ID)
			.build(new ItemToolDrill("steeldrill", MOD_ID + ":item/steel_drill", 28107, new ToolMaterial().setDurability(4608).setEfficiency(7.0F*1.75F, 14.0F*1.75F).setMiningLevel(3)));
		bismuth = new ItemBuilder(MOD_ID)
			.build(new Item("bismuth", MOD_ID + ":item/bismuth", 28108));
		rawMagnet = new ItemBuilder(MOD_ID)
			.build(new Item("raw.magnet", MOD_ID + ":item/raw_magnet", 28109));
		ingotMagnet = new ItemBuilder(MOD_ID)
			.build(new Item("ingot.magnet", MOD_ID + ":item/ingot_magnet", 28110));
		bucketCeramicEmpty = new ItemBuilder(MOD_ID)
			.build(new ItemCeramicBucketEmpty("bucket.ceramic.empty", MOD_ID + ":item/bucket_ceramic_empty", 28111));
		bucketCeramicWater = new ItemBuilder(MOD_ID)
			.build(new ItemCeramicBucket("bucket.ceramic.water", MOD_ID + ":item/bucket_ceramic_water", 28112,Blocks.FLUID_WATER_FLOWING));
		divingHelmet = new ItemBuilder(MOD_ID)
			.build(new ItemDivingHelmet("diving.helmet", "deep:item/armor/diving_helmet", 28113));
		salt = new ItemBuilder(MOD_ID)
			.build(new Item("salt", MOD_ID + ":item/salt", 28114));
		taffy = new ItemBuilder(MOD_ID)
			.build(new ItemFood("taffy",MOD_ID + ":item/taffy",28115, 1, 6, false, 8));
		doorGold = new ItemBuilder(MOD_ID)
			.build(new ItemDoor("door.gold", MOD_ID + ":item/door_gold", 28116, DEEPBlocks.doorGoldBottom, DEEPBlocks.doorGoldTop));
		doorSilver = new ItemBuilder(MOD_ID)
			.build(new ItemDoor("door.silver", MOD_ID + ":item/door_silver", 28117, DEEPBlocks.doorSilverBottom, DEEPBlocks.doorSilverTop));
		doorLead = new ItemBuilder(MOD_ID)
			.build(new ItemDoor("door.lead", MOD_ID + ":item/door_lead", 28118, DEEPBlocks.doorLeadBottom, DEEPBlocks.doorLeadTop));
		huskBeetle = new ItemBuilder(MOD_ID)
			.build(new Item("husk.beetle", MOD_ID + ":item/husk_beetle", 28119));
		boatFurnace = new ItemBuilder(MOD_ID)
			.build(new ItemFurnaceBoat("boat.furnace", MOD_ID + ":item/boat_furnace", 28120));
		leadHelmet = new ItemBuilder(MOD_ID)
			.build(new ItemArmor("helmet.lead", "deep:item/armor/lead_helmet", 28121, lead_Armor, 3));
		leadChestplate = new ItemBuilder(MOD_ID)
			.build(new ItemArmor("chestplate.lead", "deep:item/armor/lead_chestplate", 28122, lead_Armor, 2));
		leadLeggings = new ItemBuilder(MOD_ID)
			.build(new ItemArmor("leggings.lead", "deep:item/armor/lead_leggings", 28123, lead_Armor, 1));
		leadBoots = new ItemBuilder(MOD_ID)
			.build(new ItemArmor("boots.lead", "deep:item/armor/lead_boots", 28124, lead_Armor, 0));
		adamantite = new ItemBuilder(MOD_ID)
			.build(new Item("adamantite", MOD_ID + ":item/adamantite", 28125));
		adamantiteDestroyer = new ItemBuilder(MOD_ID)
			.build(new ItemToolDestroyer("adamantite.destroyer", MOD_ID + ":item/adamantite_destroyer", 28126, new ToolMaterial().setDurability(10000).setEfficiency(16.0F*1.75F, 64.0F*1.75F).setMiningLevel(3).setDamage(3)));
		adamantiteWarAxe = new ItemBuilder(MOD_ID)
			.build(new ItemToolWarAxe("adamantite.axe.war", MOD_ID + ":item/adamantite_axe_war", 28127, new ToolMaterial().setDurability(10000).setEfficiency(16.0F*1.75F, 64.0F*1.75F).setMiningLevel(3).setDamage(6)));
		cryocoal = new ItemBuilder(MOD_ID)
			.build(new Item("cryocoal", MOD_ID + ":item/cryocoal", 28128));
		lime = new ItemBuilder(MOD_ID)
			.build(new ItemFoodSour("lime",MOD_ID + ":item/lime",28129, 10, 5, false, 8));
		ammoHail = new ItemBuilder(MOD_ID)
			.build(new ItemHail("ammo.hail",MOD_ID + ":item/ammo_hail",28130));
		toolMusket = new ItemBuilder(MOD_ID)
			.build(new ItemMusket("tool.musket",MOD_ID + ":item/tool_musket",28131));
		ammoBullet = new ItemBuilder(MOD_ID)
			.build(new Item("ammo.bullet", MOD_ID + ":item/ammo_bullet", 28132).setMaxStackSize(32));
		armorBandolier = new ItemBuilder(MOD_ID)
			.build(new ItemBandolier("armor.bandolier",MOD_ID + ":item/armor_bandolier",28133));
		armorBandolierEndless = new ItemBuilder(MOD_ID)
			.build(new ItemBandolierEndless("armor.bandolier.endless", MOD_ID + ":item/armor_bandolier_endless", 28134));
		eyeShade = new ItemBuilder(MOD_ID)
			.build(new Item("eye.shade", MOD_ID + ":item/eye_shade", 28135));
		honeycomb = new ItemBuilder(MOD_ID)
			.build(new Item("honeycomb", MOD_ID + ":item/honeycomb", 28136));


	}
}
