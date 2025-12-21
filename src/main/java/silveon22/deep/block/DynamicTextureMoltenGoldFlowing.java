package silveon22.deep.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.dynamictexture.DynamicTexture;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.util.helper.MathHelper;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class DynamicTextureMoltenGoldFlowing extends DynamicTexture {
	private float[] arr1;
	private float[] arr2;
	private float[] arr3;
	private float[] arr4;
	private int ticks = 0;

	public DynamicTextureMoltenGoldFlowing(@NotNull IconCoordinate targetTexture) {
		super(targetTexture);
	}

	public void postInit() {
		this.initTexture();
		this.arr1 = new float[this.targetTexture.getArea()];
		this.arr2 = new float[this.targetTexture.getArea()];
		this.arr3 = new float[this.targetTexture.getArea()];
		this.arr4 = new float[this.targetTexture.getArea()];
	}

	public void update() {
		++this.ticks;

		for(int x = 0; x < this.targetTexture.width; ++x) {
			for(int y = 0; y < this.targetTexture.height; ++y) {
				float var3 = 0.0F;
				int var4 = (int)(MathHelper.sin((float)y * (float)Math.PI * 2.0F / (float)this.targetTexture.height) * 1.2F);
				int var5 = (int)(MathHelper.sin((float)x * (float)Math.PI * 2.0F / (float)this.targetTexture.width) * 1.2F);

				for(int _x = x - 1; _x <= x + 1; ++_x) {
					for(int _y = y - 1; _y <= y + 1; ++_y) {
						int var8 = pmod(_x + var4, this.targetTexture.width);
						int var9 = pmod(_y + var5, this.targetTexture.height);
						var3 += this.arr1[var8 + var9 * this.targetTexture.width];
					}
				}

				this.arr2[x + y * this.targetTexture.width] = var3 / 10.0F + (this.arr3[pmod(x + 0, this.targetTexture.width) + pmod(y + 0, this.targetTexture.height) * this.targetTexture.width] + this.arr3[pmod(x + 1, this.targetTexture.width) + pmod(y + 0, this.targetTexture.height) * this.targetTexture.width] + this.arr3[pmod(x + 1, this.targetTexture.width) + pmod(y + 1, this.targetTexture.height) * this.targetTexture.width] + this.arr3[pmod(x + 0, this.targetTexture.width) + pmod(y + 1, this.targetTexture.height) * this.targetTexture.width]) / 4.0F * 0.8F;
				float[] var10000 = this.arr3;
				int var10001 = x + y * this.targetTexture.width;
				var10000[var10001] += this.arr4[x + y * this.targetTexture.width] * 0.01F;
				if (this.arr3[x + y * this.targetTexture.width] < 0.0F) {
					this.arr3[x + y * this.targetTexture.width] = 0.0F;
				}

				var10000 = this.arr4;
				var10001 = x + y * this.targetTexture.width;
				var10000[var10001] -= 0.06F;
				if (Math.random() < 0.005) {
					this.arr4[x + y * this.targetTexture.width] = 1.5F;
				}
			}
		}

		float[] var11 = this.arr2;
		this.arr2 = this.arr1;
		this.arr1 = var11;

		for(int i = 0; i < this.targetTexture.getArea(); ++i) {
			float var3 = this.arr1[pmod(i - this.ticks / 3 * this.targetTexture.width, this.targetTexture.getArea())] * 2.0F;
			if (var3 > 1.0F) {
				var3 = 1.0F;
			}

			if (var3 < 0.0F) {
				var3 = 0.0F;
			}

			int var5 = (int)(var3 * 100.0F + 155.0F);
			int _x = (int)(var3 * 75.0F + 155.0F);
			int _y = (int)(var3 * var3 * var3 * var3 * 128.0F);
			this.imageData[i * 4 + 0] = (byte)var5;
			this.imageData[i * 4 + 1] = (byte)_x;
			this.imageData[i * 4 + 2] = (byte)_y;
			this.imageData[i * 4 + 3] = -1;
		}

	}
}
