package atusp.orbarts.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import atusp.orbarts.OrbArtsMain;

public class OrbArtsServerProxy {
	
	public void registerRenderThings() {
		
	}
	
	public void registerModels() {
		
	}
	
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.getServerHandler().playerEntity;
	}
	
	public void registerHandlers() {
		//MinecraftForge.EVENT_BUS.register(OrbArtsMain.orbartsExtendedHandler);
	}
}
