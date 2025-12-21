package silveon22.deep.block;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.Items;
import silveon22.deep.item.DEEPItems;

public class LookupFuelFreezer {
	public static final silveon22.deep.block.LookupFuelFreezer instance = new silveon22.deep.block.LookupFuelFreezer();
	protected final Map<Integer, Integer> fuelList = new HashMap();

	protected LookupFuelFreezer() {
		this.register();
	}

	protected void register() {
		this.addFuelEntry(DEEPBlocks.cryocoalBlock.id(), 6400*8);
		this.addFuelEntry(DEEPItems.cryocoal.id, 6400);
		this.addFuelEntry(Blocks.ICE.id(), 1600);
		this.addFuelEntry(Blocks.BLOCK_SNOW.id(), 800);
		this.addFuelEntry(DEEPItems.ammoHail.id, 400);
		this.addFuelEntry(Items.AMMO_SNOWBALL.id, 200);
	}

	public void addFuelEntry(int id, int fuelYield) {
		this.fuelList.put(id, fuelYield);
	}

	public int getFuelYield(int id) {
		return this.fuelList.get(id) == null ? 0 : (Integer)this.fuelList.get(id);
	}

	public Map<Integer, Integer> getFuelList() {
		return this.fuelList;
	}
}
