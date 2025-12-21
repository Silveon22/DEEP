package silveon22.deep.mob.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.LightmapHelper;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.model.BlockModel;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.client.render.model.ModelBoat;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.client.render.tileentity.TileEntityRendererFlag;
import net.minecraft.core.Global;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import net.minecraft.core.world.wind.WindProvider;
import org.lwjgl.opengl.GL11;
import silveon22.deep.mob.EntityFurnaceBoat;

@Environment(EnvType.CLIENT)
public class EntityRendererFurnaceBoat extends EntityRenderer<EntityFurnaceBoat> {
    private final Minecraft mc = Minecraft.getMinecraft();
    protected ModelBase modelBoat;
    private TileEntityRendererFlag flagRenderer = new TileEntityRendererFlag();

    public EntityRendererFurnaceBoat() {
        this.shadowSize = 0.5F;
        this.modelBoat = new ModelBoat();
        this.flagRenderer.setRenderDispatcher(TileEntityRenderDispatcher.instance);
    }

    public void render(Tessellator tessellator, EntityFurnaceBoat entity, double x, double y, double z, float yaw, float partialTick) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);
        GL11.glRotatef(180.0F - yaw, 0.0F, 1.0F, 0.0F);
        float hurt = (float)entity.boatTimeSinceHit - partialTick;
        float dmg = (float)entity.boatCurrentDamage - partialTick;
        if (dmg < 0.0F) {
            dmg = 0.0F;
        }

        if (hurt > 0.0F) {
            GL11.glRotatef(MathHelper.sin(hurt) * hurt * dmg / 10.0F * (float)entity.boatRockDirection, 1.0F, 0.0F, 0.0F);
        }

        if (entity.tileEntityFlag != null) {
            World theWorld = this.mc.currentWorld;
            WindProvider theWind = theWorld.getWorldType().getWindManager();
            float windAngle = theWind.getWindDirection(theWorld, (float)x, (float)y, (float)z) * 360.0F + (180.0F - yaw);
            float boatAngle = 180.0F;
            float boatSpeed = MathHelper.sqrt_float((float)(entity.xd * entity.xd + entity.zd * entity.zd));
            float angle = MathHelper.lerp(windAngle, boatAngle, (float)MathHelper.clamp((double)boatSpeed, (double)0.0F, (double)0.25F) * 4.0F);
            this.flagRenderer.doRender(entity.tileEntityFlag, -1.19, 0.187, (double)-0.5F, partialTick, false, angle, 1.0F);
        }

		float brightness = 1.0F;
		if (LightmapHelper.isLightmapEnabled()) {
			LightmapHelper.setLightmapCoord(entity.getLightmapCoord(partialTick));
		} else if (!Global.accessor.isFullbrightEnabled()) {
			brightness = entity.getBrightness(partialTick);
		}

		TextureRegistry.blockAtlas.bind();
		float scale = 0.75F;
		GL11.glScalef(1F, 1F, 1F);
		GL11.glTranslatef(-0.2F, 0.3125F, 0.0F);
		GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);

		if (entity.getFuel() > 0) {
			((BlockModel) BlockModelDispatcher.getInstance().getDispatch(Blocks.FURNACE_STONE_ACTIVE)).renderBlockOnInventory(tessellator, 0, brightness, (Integer)null);
		} else {
			((BlockModel)BlockModelDispatcher.getInstance().getDispatch(Blocks.FURNACE_STONE_IDLE)).renderBlockOnInventory(tessellator, 0, brightness, (Integer)null);
		}

		GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.2F, -0.3125F, 0.0F);
		GL11.glScalef(1.3333334F -0.25F, 1.3333334F -0.25F, 1.3333334F -0.25F);

        TextureRegistry.blockAtlas.bind();
        float f4 = 0.75F;
        GL11.glScalef(f4, f4, f4);
        GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
        this.bindTexture("/assets/minecraft/textures/entity/boat.png");
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.modelBoat.render(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }
}
