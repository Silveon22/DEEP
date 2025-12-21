package silveon22.deep.recipe;

import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.*;
import net.minecraft.core.data.registry.recipe.SearchQuery.QueryType;
import net.minecraft.core.data.registry.recipe.SearchQuery.SearchScope;
import net.minecraft.core.data.registry.recipe.adapter.RecipeJsonAdapter;
import net.minecraft.core.item.ItemStack;

import java.util.List;
import java.util.Objects;

public class RecipeEntryBrickOven extends RecipeEntryBase<RecipeSymbol, ItemStack, Void> implements HasJsonAdapter {
	public RecipeEntryBrickOven(RecipeSymbol input, ItemStack output) {
		super(input, output, null);
	}

	public RecipeEntryBrickOven() {
	}

	public Void getData() {
		return null;
	}

	public boolean containsData(Void data) {
		return false;
	}

	public boolean matches(ItemStack stack) {
		return ((RecipeSymbol)this.getInput()).matches(stack);
	}

	public boolean matchesQueryIgnoreExceptions(SearchQuery query) {
		try {
			return this.matchesQuery(query);
		} catch (IllegalArgumentException | NullPointerException var3) {
			return false;
		}
	}

	public boolean matchesQuery(SearchQuery query) {
		switch (query.mode) {
			case ALL:
				if ((this.matchesRecipe(query) || this.matchesUsage(query)) && this.matchesScope(query)) {
					return true;
				}
				break;
			case RECIPE:
				if (this.matchesRecipe(query) && this.matchesScope(query)) {
					return true;
				}
				break;
			case USAGE:
				if (this.matchesUsage(query) && this.matchesScope(query)) {
					return true;
				}
		}

		return false;
	}

	private boolean matchesRecipe(SearchQuery query) {
		if (query.query.getLeft() == QueryType.NAME) {
			if (query.strict && ((ItemStack)this.getOutput()).getDisplayName().equalsIgnoreCase((String)query.query.getRight())) {
				return true;
			}

			if (!query.strict && ((ItemStack)this.getOutput()).getDisplayName().toLowerCase().contains(((String)query.query.getRight()).toLowerCase())) {
				return true;
			}
		} else if (query.query.getLeft() == QueryType.GROUP && !Objects.equals(query.query.getRight(), "")) {
			List<ItemStack> groupStacks = (new RecipeSymbol((String)query.query.getRight())).resolve();
			if (groupStacks == null) {
				return false;
			}

			return groupStacks.contains(this.getOutput());
		}

		return false;
	}

	private boolean matchesUsage(SearchQuery query) {
		for(ItemStack stack : ((RecipeSymbol)this.getInput()).resolve()) {
			if (stack != null) {
				if (query.query.getLeft() == QueryType.NAME) {
					if (query.strict && stack.getDisplayName().equalsIgnoreCase((String)query.query.getRight())) {
						return true;
					}

					if (!query.strict && stack.getDisplayName().toLowerCase().contains(((String)query.query.getRight()).toLowerCase())) {
						return true;
					}
				} else if (query.query.getLeft() == QueryType.GROUP && !Objects.equals(query.query.getRight(), "")) {
					List<ItemStack> groupStacks = (new RecipeSymbol((String)query.query.getRight())).resolve();
					if (groupStacks == null) {
						return false;
					}

					return groupStacks.contains(this.getOutput());
				}
			}
		}

		return false;
	}

	private boolean matchesScope(SearchQuery query) {
		if (query.scope.getLeft() == SearchScope.NONE) {
			return true;
		} else {
			if (query.scope.getLeft() == SearchScope.NAMESPACE) {
				RecipeNamespace namespace = (RecipeNamespace)Registries.RECIPES.getItem((String)query.scope.getRight());
				if (namespace == this.parent.getParent()) {
					return true;
				}
			} else if (query.scope.getLeft() == SearchScope.NAMESPACE_GROUP) {
				RecipeGroup group;
				try {
					group = Registries.RECIPES.getGroupFromKey((String)query.scope.getRight());
				} catch (IllegalArgumentException var4) {
					group = null;
				}

				if (group == this.parent) {
					return true;
				}
			}

			return false;
		}
	}

	public RecipeJsonAdapter<?> getAdapter() {
		return new RecipeBrickOvenJsonAdapter();
	}
}
