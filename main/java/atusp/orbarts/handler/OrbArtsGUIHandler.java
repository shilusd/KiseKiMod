package atusp.orbarts.handler;

import atusp.orbarts.OrbArtsMain;
import atusp.orbarts.gui.OrbmentTableGUI;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class OrbArtsGUIHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) {
		// TODO Auto-generated method stub
		if (ID==OrbArtsMain.orbmentTableGUIId) {
			return new OrbmentTableGUI();
		}
		return null;
	}

}
