package atusp.orbarts.handler;

import atusp.orbarts.entity.ExtendedEntityPlayer;
import atusp.orbarts.packet.ExtendedPlayerPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ExtendedPlayerPacketHandler implements IMessageHandler<ExtendedPlayerPacket, ExtendedPlayerPacket>{
	
	@Override
	public ExtendedPlayerPacket onMessage(ExtendedPlayerPacket message,
			MessageContext ctx) {
		// TODO Auto-generated method stub
		System.out.println(message.toString());
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if (player!=null) {
			ExtendedEntityPlayer props = ExtendedEntityPlayer.get(player);
			message.set(props);
		}

		return null;
	}

}
