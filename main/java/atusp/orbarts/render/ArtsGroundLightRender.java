package atusp.orbarts.render;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;

import atusp.orbarts.OrbArtsMain;
import atusp.orbarts.entity.ArtsGroundLightEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
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

public class ArtsGroundLightRender extends Render{
		private static final int slide = 16;
	    public ArtsGroundLightRender(RenderManager p_i46137_1_)
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
	    	this.bindTexture(OrbArtsMain.rl);
	    	ArtsGroundLightEntity entity2 = (ArtsGroundLightEntity)entity;
	    	//System.out.println(entity2.renderRadis);
	    	
	    	//GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	    	Tessellator tessellator = Tessellator.getInstance();
	        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
	    	GlStateManager.pushAttrib();
	    	GlStateManager.pushMatrix();
	        GlStateManager.translate((float)x, (float)y, (float)z);
	        GlStateManager.enableRescaleNormal();
	        
	        GlStateManager.enableTexture2D();
	        GlStateManager.enableAlpha();
	        GlStateManager.enableBlend();
	        GlStateManager.disableDepth();
	        
	        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	        
	        int syb = 1;
    		double dx = 0;
    		double dz1 = 0; 
    		double dz2 = 0;
    		double lastx = 0;
    		double lastz1 = 0;
    		double lastz2 = 0;
    		//两面生成
    		for (int i=0;i<=slide;i++) {
        		dx = 2*entity2.renderRadis/slide*i-entity2.renderRadis;
        		double sqr = entity2.renderRadis*entity2.renderRadis-(dx)*(dx);
        		if (sqr<0) {
        			sqr = 0;
        		}
        		dz1 = Math.sqrt(sqr);
        		dz2 = -dz1;
        		
        		if (dz2 == -0.0) {
        			dz2 = 0.0;
        		}
        		
        		//System.out.println(entity2.getEntityId()+":"+dx+","+dz1+","+dz2);
        		
        		if (i==0) {
        			lastx = dx;
        			lastz1 = dz1;
        			lastz2 = dz1;
        		} else {
        			worldRenderer.startDrawingQuads();
        			worldRenderer.addVertexWithUV(lastx, 6f-entity2.renderRadis*4f, lastz1, 1/(slide*2)*((slide*2)-i+1), 0);
        			worldRenderer.addVertexWithUV(dx, 6f-entity2.renderRadis*4f, dz1, 1/(slide*2)*((slide*2)-i), 0);
        			worldRenderer.addVertexWithUV(dx, 0.01, dz1, 1/(slide*2)*((slide*2)-i), 1);
        			worldRenderer.addVertexWithUV(lastx, 0.01, lastz1, 1/(slide*2)*((slide*2)-i+1), 1);
        			tessellator.draw();
        			
        			worldRenderer.startDrawingQuads();
        			worldRenderer.addVertexWithUV(lastx, 6f-entity2.renderRadis*4f, lastz1, 1/(slide*2)*((slide*2)-i+1), 0);
        			worldRenderer.addVertexWithUV(lastx, 0.01, lastz1, 1/(slide*2)*((slide*2)-i+1), 1);
        			worldRenderer.addVertexWithUV(dx, 0.01, dz1, 1/(slide*2)*((slide*2)-i), 1);
        			worldRenderer.addVertexWithUV(dx, 6f-entity2.renderRadis*4f, dz1, 1/(slide*2)*((slide*2)-i), 0);
        			tessellator.draw();
        			
        			
        			
        			worldRenderer.startDrawingQuads();
        			worldRenderer.addVertexWithUV(lastx, 0.01, lastz2, 1/(slide*2)*(i-1), 1);
        			worldRenderer.addVertexWithUV(dx, 0.01, dz2,  1/(slide*2)*(i), 1);
        			worldRenderer.addVertexWithUV(dx, 6f-entity2.renderRadis*4f, dz2,  1/(slide*2)*(i), 0);
        			worldRenderer.addVertexWithUV(lastx, 6f-entity2.renderRadis*4f, lastz2,  1/(slide*2)*(i-1), 0);
        			tessellator.draw();
        			
        			worldRenderer.startDrawingQuads();
        			worldRenderer.addVertexWithUV(lastx, 0.01, lastz2, 1/(slide*2)*(i-1), 1);
        			worldRenderer.addVertexWithUV(lastx, 6f-entity2.renderRadis*4f, lastz2,  1/(slide*2)*(i-1), 0);
        			worldRenderer.addVertexWithUV(dx, 6f-entity2.renderRadis*4f, dz2,  1/(slide*2)*(i), 0);
        			worldRenderer.addVertexWithUV(dx, 0.01, dz2,  1/(slide*2)*(i), 1);
        			tessellator.draw();
        			
        			lastx = dx;
        			lastz1 = dz1;
        			lastz2 = dz2;
        		}
        		
        	}

    		GlStateManager.popMatrix();
	        GlStateManager.popAttrib();
	        
	        super.doRender(entity, x, y, z, p_76986_8_, partialTicks);
	    }

		@Override
		protected ResourceLocation getEntityTexture(Entity entity) {
			// TODO Auto-generated method stub
	        return TextureMap.locationBlocksTexture;
		}
}
