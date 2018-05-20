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

public class OrbBulletRender extends Render{
		private List<MyVec3> tracker;
		private Entity oldEntity;
	
	    public OrbBulletRender(RenderManager p_i46137_1_)
	    {
	        super(p_i46137_1_);
	        tracker = new ArrayList<MyVec3>();
	    }
	    
	    /**
	     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
	     * double d2, float f, float f1). But JAD is pre 1.5 so doe
	     */
	    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks)
	    {
	    	//System.out.println(entity.posX+","+entity.posY+","+entity.posZ);
	    	
	    	if (entity!=oldEntity) {
	    		tracker = new ArrayList<MyVec3>();
	    		oldEntity = entity;
	    	}
	    	tracker.add(new MyVec3(x,y,z,tracker.size()));
	    	//System.out.print("Age "+tracker.size()+":");
	    	//GlStateManager.pushMatrix();
	    	//GlStateManager.translate(x,y,z);
	    	//Sphere ball = new Sphere();
    		//ball.draw(0.1f, 32, 32);
    		
    		//Tessellator tessellator = Tessellator.getInstance();
            //WorldRenderer worldrenderer = tessellator.getWorldRenderer();
            
            //GlStateManager.popMatrix();
	    	/*
	    	for (int i=0;i<tracker.size();i++) {
	    		GlStateManager.pushMatrix();
		    	GlStateManager.enableAlpha();
	    		GlStateManager.translate(tracker.get(i).xCoord,tracker.get(i).yCoord,tracker.get(i).zCoord);
	    		Sphere ball = new Sphere();
	    		ball.draw(0.1f, 16, 16);
	    		GlStateManager.popMatrix();
	    		//System.out.print("{"+tracker.get(i).xCoord+","+tracker.get(i).yCoord+","+tracker.get(i).zCoord+"},");
	    	}
	    	*/
	    	//System.out.println();
	    	
	        
	       // GlStateManager.translate((float)x, (float)y, (float)z);
	      //  GlStateManager.enableRescaleNormal();
	       // GlStateManager.scale(0.5F, 0.5F, 0.5F);
	       // GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
	        //GlStateManager.rotate(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
	        //this.bindTexture(new ResourceLocation("orbBulletEntity",OrbArtsMain.MODID+":orb"));
	       // GlStateManager.disableRescaleNormal();
	    	GlStateManager.pushMatrix();
	        GlStateManager.translate((float)x, (float)y, (float)z);
	        GlStateManager.enableRescaleNormal();
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
	        GlStateManager.rotate(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
	        Minecraft.getMinecraft().getRenderItem().renderItemModel(new ItemStack(OrbArtsMain.lightBall, 1, 0));
	        GlStateManager.disableRescaleNormal();
	        GlStateManager.popMatrix();
	        super.doRender(entity, x, y, z, p_76986_8_, partialTicks);
	    }

		@Override
		protected ResourceLocation getEntityTexture(Entity entity) {
			// TODO Auto-generated method stub
	        return TextureMap.locationBlocksTexture;
		}
}
