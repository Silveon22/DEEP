package silveon22.deep;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.achievements.data.AchievementPages;
import silveon22.deep.achievement.AchievementPageDeep;
import silveon22.deep.block.DEEPBlocks;
import silveon22.deep.item.DEEPItems;
import turniplabs.halplibe.util.ClientStartEntrypoint;

import static silveon22.deep.Deep.MOD_ID;

@Environment(EnvType.CLIENT)
public class DeepClient implements ClientStartEntrypoint {
	@Override
	public void beforeClientStart() {
	}

	@Override
	public void afterClientStart() {
		initAchievementsPage();
	}

	public static void initAchievementsPage() {
		AchievementPageDeep page = new AchievementPageDeep(MOD_ID, DEEPBlocks.abyssalriteAmethystOre.getDefaultStack());
		page.addAchievement(DeepAchievements.DELVE, 0, 0);
		page.addAchievement(DeepAchievements.NEAPOLITAN_2, 4, 0);
		page.addAchievement(DeepAchievements.OBTAIN_HONEYCOMB, -4, 0);
		page.addAchievement(DeepAchievements.BIG_ONE, -5, 2);
		page.addAchievement(DeepAchievements.HUNTING_SEASON, -5, -2);
		page.addAchievement(DeepAchievements.OBTAIN_LEAD, 1, -2);
		page.addAchievement(DeepAchievements.OBTAIN_SILVER, -1, -2);
		page.addAchievement(DeepAchievements.OBTAIN_AMETHYST, 2, -1);
		page.addAchievement(DeepAchievements.OBTAIN_URANIUM, 2, 1);
		page.addAchievement(DeepAchievements.BISMUTH_REPAIR, 1, 2);
		page.addAchievement(DeepAchievements.OBTAIN_RHODONITE, -1, 2);
		page.addAchievement(DeepAchievements.OBTAIN_CRYOCOAL, -2, -1);
		page.addAchievement(DeepAchievements.OBTAIN_ADAMANTITE, -2, 1);
		page.addAchievement(DeepAchievements.CRAFT_FREEZER, -3, -3);
		page.addAchievement(DeepAchievements.ROCK_BOTTOM, 0, 4);
		AchievementPages.register(page);
	}
}
