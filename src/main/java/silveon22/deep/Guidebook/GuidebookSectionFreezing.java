package silveon22.deep.Guidebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.guidebook.GuidebookPage;
import net.minecraft.client.gui.guidebook.GuidebookSection;
import net.minecraft.client.gui.guidebook.SearchableGuidebookSection;
import net.minecraft.client.gui.guidebook.smelting.RecipePageSmelting;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.SearchQuery;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.collection.Pair;
import net.minecraft.core.util.helper.MathHelper;
import silveon22.deep.DEEPRecipes;
import silveon22.deep.recipe.RecipeEntryFreezer;

@Environment(EnvType.CLIENT)
public class GuidebookSectionFreezing extends SearchableGuidebookSection {
	private final List<GuidebookPage> pages = new ArrayList();
	private Pair<String, List<GuidebookPage>> filteredPages = null;

	public GuidebookSectionFreezing(String translationKey, ItemStack tabIcon, int bgColor, int fgColor) {
		super(translationKey, tabIcon, bgColor, fgColor);
		this.reloadRecipes();
	}

	public List<GuidebookPage> searchPages(SearchQuery query) {
		if (this.filteredPages != null && Objects.equals(this.filteredPages.getLeft(), query.rawQuery)) {
			return (List)this.filteredPages.getRight();
		} else {
			ArrayList<RecipeEntryFreezer> filteredRecipes = new ArrayList();
			List<RecipeEntryFreezer> allRecipes = new ArrayList(DEEPRecipes.getAllRecipesOfType(RecipeEntryFreezer.class));
			allRecipes.removeIf(Objects::isNull);

			for(RecipeEntryFreezer recipe : allRecipes) {
				if (recipe.matchesQueryIgnoreExceptions(query)) {
					filteredRecipes.add(recipe);
				}
			}

			ArrayList<GuidebookPage> filteredPages = new ArrayList();
			int filteredRecipeSize = filteredRecipes.size();
			int filteredPageCount = MathHelper.ceilInt(filteredRecipeSize, 3);

			for(int i = 0; i < filteredPageCount; ++i) {
				int j = i * 6;
				ArrayList<RecipeEntryFreezer> recipes = new ArrayList(filteredRecipes.subList(Math.min(j, filteredRecipeSize), Math.min(j + 6, filteredRecipeSize)));
				if (recipes.size() > 0) {
					filteredPages.add(new RecipePageFreezing(this, recipes));
				}
			}

			this.filteredPages = Pair.of(query.rawQuery, filteredPages);
			return filteredPages;
		}
	}

	public void reloadRecipes() {
		this.pages.clear();
		List<RecipeEntryFreezer> allRecipes = new ArrayList(DEEPRecipes.getAllRecipesOfType(RecipeEntryFreezer.class));
		allRecipes.removeIf(Objects::isNull);
		int totalRecipes = allRecipes.size();
		int totalPages = MathHelper.ceilInt(totalRecipes, 6);

		for(int i = 0; i < totalPages; ++i) {
			int j = i * 6;
			ArrayList<RecipeEntryFreezer> recipes = new ArrayList(allRecipes.subList(Math.min(j, totalRecipes), Math.min(j + 6, totalRecipes)));
			this.pages.add(new RecipePageFreezing(this, recipes));
		}

	}

	public List<GuidebookPage> getPages() {
		return this.pages;
	}

	public List<GuidebookSection.Index> getIndices() {
		return null;
	}
}
