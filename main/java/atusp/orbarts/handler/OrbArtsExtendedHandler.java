package atusp.orbarts.handler;

import com.jcraft.jorbis.Block;

import atusp.orbarts.OrbArtsMain;
import atusp.orbarts.block.orbment.OrbmentTable;
import atusp.orbarts.entity.ExtendedEntityLiving;
import atusp.orbarts.entity.ExtendedEntityPlayer;
import atusp.orbarts.item.sepith.SepithItem;
import atusp.orbarts.packet.ExtendedPlayerPacket;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class OrbArtsExtendedHandler {
	
	//注册额外属性
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		/*
		Be sure to check if the entity being constructed is the correct type for the extended properties you're about to add! The null check may not be necessary - I only use it to make sure properties are only registered once per entity
		*/
		//System.out.println("in");
		
		//玩家
		if (event.entity instanceof EntityPlayer && ExtendedEntityPlayer.get((EntityPlayer) event.entity) == null) {
			System.out.println("[EXT PROPS] Registering extended properties.");
			// This is how extended properties are registered using our convenient method from earlier
			ExtendedEntityPlayer.register((EntityPlayer) event.entity);
		}
		
		//其他生物
		//if (event.entity instanceof EntityLivingBase && !(event.entity instanceof EntityPlayer) && ExtendedEntityLiving.get((EntityLivingBase) event.entity) == null) {
		//	System.out.println("[EXT PROPS] Registering extended properties.");
		//	ExtendedEntityLiving.register((EntityLivingBase) event.entity);
		//}
	}
	
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityPlayerMP) {
			ExtendedEntityPlayer props = ExtendedEntityPlayer.get((EntityPlayer)event.entity);
			ExtendedPlayerPacket p = new ExtendedPlayerPacket();
			p.get(props);
			System.out.println(p.toString());
			OrbArtsMain.network.sendTo(p,(EntityPlayerMP)event.entity);
		}
	}
}
