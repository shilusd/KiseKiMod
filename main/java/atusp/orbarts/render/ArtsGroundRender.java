package atusp.orbarts.render;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Sphere;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;

public class ArtsGroundRender extends Render{
	
	    public ArtsGroundRender(RenderManager p_i46137_1_)
	    {
	        super(p_i46137_1_);
	    }
	    
	    /**
	     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
	     * double d2, float f, float f1). But JAD is pre 1.5 so doe
	     */
	    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks)
	    {	
	    	this.bindTexture(OrbArtsMain.rl2);
	    	GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	    	Tessellator tessellator = Tessellator.getInstance();
	        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
	    	GlStateManager.pushAttrib();
	    	GlStateManager.pushMatrix();
	        GlStateManager.translate((float)x, (float)y, (float)z);
	        GlStateManager.enableRescaleNormal();
	        GlStateManager.enableTexture2D();
	        GlStateManager.enableAlpha();
	        GlStateManager.enableBlend();
	        
	        GL11.glNormal3f(0.0F, 1F, 0.0F);
			worldRenderer.startDrawingQuads();
			worldRenderer.addVertexWithUV(1.3, 0.01, 1.3, 1, 0);
			worldRenderer.addVertexWithUV(1.3, 0.01, -1.3, 1, 1);
			worldRenderer.addVertexWithUV(-1.3, 0.01, -1.3, 0, 1);
			worldRenderer.addVertexWithUV(-1.3, 0.01, 1.3, 0, 0);
			tessellator.draw();
	        
	    	
	        GlStateManager.popMatrix();
	        GlStateManager.popAttrib();
	    	/*
	    	GlStateManager.pushMatrix();
	        GlStateManager.translate((float)x, (float)y, (float)z);
	        GlStateManager.enableRescaleNormal();
	        GlStateManager.scale(2.6F, 2.6F, 2.6F);
	        GlStateManager.rotate(90, 1.0F, 0.0F, 0.0F);
	        Minecraft.getMinecraft().getRenderItem().renderItemModel(new ItemStack(OrbArtsMain.artsGround, 1, 0));
	        GlStateManager.disableRescaleNormal();
	        GlStateManager.popMatrix();
	        */
	        super.doRender(entity, x, y, z, p_76986_8_, partialTicks);
	    }

		@Override
		protected ResourceLocation getEntityTexture(Entity entity) {
			// TODO Auto-generated method stub
	        return TextureMap.locationBlocksTexture;
		}
}
