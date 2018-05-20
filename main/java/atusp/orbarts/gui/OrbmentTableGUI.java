package atusp.orbarts.gui;

import java.io.IOException;

import atusp.orbarts.OrbArtsMain;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

//GuiScreen里有大量的方法和事件触发
public class OrbmentTableGUI extends GuiScreen{
	private ResourceLocation orbmentTableBack = new ResourceLocation(OrbArtsMain.MODID+":textures/gui/orbmentTableBack.png");
	
	public OrbmentTableGUI(){
		
	}
	
	//初始化界面
	public void initGui() {
		super.initGui();
	}
	
	//按键绑定呼出界面
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
	   super.keyTyped(typedChar, keyCode);
	}
	
	protected void actionPerformed(GuiButton button) throws IOException {
		super.actionPerformed(button);
	}
	
	//每tick更新
	public void updateScreen() {
		super.updateScreen();
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		
		mc.getTextureManager().bindTexture(orbmentTableBack);
		
		/**
	     * Draws a textured rectangle using the texture currently bound to the TextureManager
	     */
		this.drawTexturedModalRect(this.width/2-128, this.height/2-128, 0, 0, 256 , 256);
		
		//显示文字
		//this.fontRendererObj.drawString(text, x, y, color)
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
}
