package silveon22.deep.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.dynamictexture.DynamicTexture;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.util.helper.MathHelper;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class DynamicTextureMoltenGoldStill extends DynamicTexture {
	private float[] arr1;
	private float[] arr2;
	private float[] arr3;
	private float[] arr4;

	public DynamicTextureMoltenGoldStill(@NotNull IconCoordinate targetTexture) {
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
		for(int i = 0; i < this.targetTexture.width; ++i) {
			for(int j = 0; j < this.targetTexture.height; ++j) {
				float var3 = 0.0F;
				int x2 = (int)(MathHelper.sin((float)j * (float)Math.PI * 2.0F / (float)this.targetTexture.width) * 1.2F);
				int y2 = (int)(MathHelper.sin((float)i * (float)Math.PI * 2.0F / (float)this.targetTexture.height) * 1.2F);

				for(int g = i - 1; g <= i + 1; ++g) {
					for(int b = j - 1; b <= j + 1; ++b) {
						int var8 = pmod(g + x2, this.targetTexture.width);
						int var9 = pmod(b + y2, this.targetTexture.height);
						var3 += this.arr1[var8 + var9 * this.targetTexture.width];
					}
				}

				this.arr2[i + j * this.targetTexture.width] = var3 / 10.0F + (this.arr3[pmod(i + 0, this.targetTexture.width) + pmod(j + 0, this.targetTexture.height) * this.targetTexture.width] + this.arr3[pmod(i + 1, this.targetTexture.width) + pmod(j + 0, this.targetTexture.height) * this.targetTexture.width] + this.arr3[pmod(i + 1, this.targetTexture.width) + pmod(j + 1, this.targetTexture.height) * this.targetTexture.width] + this.arr3[pmod(i + 0, this.targetTexture.width) + pmod(j + 1, this.targetTexture.height) * this.targetTexture.width]) / 4.0F * 0.8F;
				float[] var10000 = this.arr3;
				int var10001 = i + j * this.targetTexture.width;
				var10000[var10001] += this.arr4[i + j * this.targetTexture.width] * 0.01F;
				if (this.arr3[i + j * this.targetTexture.width] < 0.0F) {
					this.arr3[i + j * this.targetTexture.width] = 0.0F;
				}

				var10000 = this.arr4;
				var10001 = i + j * this.targetTexture.width;
				var10000[var10001] -= 0.06F;
				if (Math.random() < 0.005) {
					this.arr4[i + j * this.targetTexture.width] = 1.5F;
				}
			}
		}

		float[] var11 = this.arr2;
		this.arr2 = this.arr1;
		this.arr1 = var11;

		for(int i = 0; i < this.targetTexture.getArea(); ++i) {
			float var3 = this.arr1[i] * 2.0F;
			if (var3 > 1.0F) {
				var3 = 1.0F;
			}

			if (var3 < 0.0F) {
				var3 = 0.0F;
			}

			int r = (int)(var3 * 100.0F + 155.0F);
			int g = (int)(var3 * 75.0F + 155.0F);
			int b = (int)(var3 * var3 * var3 * var3 * 128.0F);
			this.imageData[i * 4 + 0] = (byte)r;
			this.imageData[i * 4 + 1] = (byte)g;
			this.imageData[i * 4 + 2] = (byte)b;
			this.imageData[i * 4 + 3] = -1;
		}

	}
}
