package silveon22.deep;

import net.minecraft.core.achievement.Achievement;
import net.minecraft.core.util.collection.NamespaceID;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.item.DEEPItems;

import static silveon22.deep.Deep.MOD_ID;

public final class DeepAchievements {

	public static NamespaceID key(String string) {
		return NamespaceID.getPermanent(MOD_ID, string);
	}

	public static final Achievement DELVE = new Achievement(key("delve"), "deep.delve", DEEPItems.amethystPickaxe, null).setType(Achievement.TYPE_NORMAL).registerAchievement();

	public static final Achievement ROCK_BOTTOM = new Achievement(key("rockbottom"), "deep.rockbottom", DEEPBlocks.abyssalrite, DELVE).setType(Achievement.TYPE_SPECIAL).registerAchievement();
	public static final Achievement NEAPOLITAN_2 = new Achievement(key("neapolitan2"), "deep.neapolitan2", DEEPBlocks.pearlstoneCobbled, DELVE).setType(Achievement.TYPE_SPECIAL).registerAchievement();
	public static final Achievement OBTAIN_HONEYCOMB = new Achievement(key("honeycomb"), "deep.honeycomb", DEEPItems.honeycomb, DELVE).setType(Achievement.TYPE_NORMAL).registerAchievement();
	public static final Achievement BIG_ONE = new Achievement(key("bigone"), "deep.bigone", DEEPItems.rawBass, null).setType(Achievement.TYPE_SPECIAL).registerAchievement();
	public static final Achievement HUNTING_SEASON = new Achievement(key("huntingseason"), "deep.huntingseason", DEEPItems.toolMusket, null).setType(Achievement.TYPE_SPECIAL).registerAchievement();

	public static final Achievement OBTAIN_SILVER = new Achievement(key("silver"), "deep.silver", DEEPItems.ingotSilver, DELVE).setType(Achievement.TYPE_NORMAL).registerAchievement();
	public static final Achievement OBTAIN_LEAD = new Achievement(key("lead"), "deep.lead", DEEPItems.ingotLead, DELVE).setType(Achievement.TYPE_NORMAL).registerAchievement();
	public static final Achievement OBTAIN_URANIUM = new Achievement(key("uranium"), "deep.uranium", DEEPItems.uranium, DELVE).setType(Achievement.TYPE_NORMAL).registerAchievement();
	public static final Achievement BISMUTH_REPAIR = new Achievement(key("bismuth"), "deep.bismuth", DEEPItems.bismuth, DELVE).setType(Achievement.TYPE_NORMAL).registerAchievement();
	public static final Achievement OBTAIN_AMETHYST = new Achievement(key("amethyst"), "deep.amethyst", DEEPItems.amethyst, DELVE).setType(Achievement.TYPE_NORMAL).registerAchievement();
	public static final Achievement OBTAIN_RHODONITE = new Achievement(key("rhodonite"), "deep.rhodonite", DEEPItems.rhodonite, DELVE).setType(Achievement.TYPE_NORMAL).registerAchievement();
	public static final Achievement OBTAIN_CRYOCOAL = new Achievement(key("cryocoal"), "deep.cryocoal", DEEPItems.cryocoal, DELVE).setType(Achievement.TYPE_NORMAL).registerAchievement();
	public static final Achievement OBTAIN_ADAMANTITE = new Achievement(key("adamantite"), "deep.adamantite", DEEPItems.adamantite, DELVE).setType(Achievement.TYPE_NORMAL).registerAchievement();

	public static final Achievement CRAFT_FREEZER = new Achievement(key("freezer"), "deep.freezer", DEEPBlocks.freezerActive, OBTAIN_CRYOCOAL).setType(Achievement.TYPE_NORMAL).registerAchievement();
}
