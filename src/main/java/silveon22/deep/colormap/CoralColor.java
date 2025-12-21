package silveon22.deep.colormap;

import net.minecraft.client.render.block.color.BlockColor;
import net.minecraft.core.world.WorldSource;

import java.awt.*;
import java.util.Random;

public class CoralColor extends BlockColor {
	Random rand = new Random();

	private static int mix(int a, int b, int c) {
		a -= b; a -= c; a ^= (c>>13);
		b -= c; b -= a; b ^= (a<<8);
		c -= a; c -= b; c ^= (b>>13);
		a -= b; a -= c; a ^= (c>>12);
		b -= c; b -= a; b ^= (a<<16);
		c -= a; c -= b; c ^= (b>>5);
		a -= b; a -= c; a ^= (c>>3);
		b -= c; b -= a; b ^= (a<<10);
		c -= a; c -= b; c ^= (b>>15);
		return c;
	}

	@Override
	public int getFallbackColor(int i) {
		return Color.HSBtoRGB(0.5f,0.1f,0.6f);
	}

	@Override
	public int getWorldColor(WorldSource worldSource, int i, int j, int k) {
		rand.setSeed(mix(i, j, k));
		return Color.HSBtoRGB(rand.nextFloat(), 1 - (rand.nextFloat()/2), 1);
	}
}
