package atusp.orbarts.handler;

import com.jcraft.jorbis.Block;

import atusp.orbarts.OrbArtsMain;
import atusp.orbarts.block.orbment.OrbmentTable;
import atusp.orbarts.entity.ExtendedEntityLiving;
import atusp.orbarts.entity.ExtendedEntityPlayer;
import atusp.orbarts.item.sepith.SepithItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class OrbArtsEventHandler {

	//��ҵ����¼�
	@SubscribeEvent
	public void onPlayerJoining(PlayerEvent.PlayerLoggedInEvent e) {
		//����������Ϣ������ͨ����ChatComponentText����setChatStyle���ı��������ɫ
		e.player.addChatComponentMessage(new ChatComponentText(OrbArtsMain.greetingMsg));
	}
	
	//����̨�ϳ��¼�
	@SubscribeEvent
	public void onPlayerCrafting(PlayerEvent.ItemCraftedEvent e) {
		if (e.crafting.getItem().equals(Item.getItemFromBlock(OrbArtsMain.orbmentTable))) {
			//����ĳ�ɾ�
			e.player.addStat(OrbArtsMain.orbmentTableAchievement, 1);
		}
	}
	
	//��ȡ��Ʒ�¼�
	@SubscribeEvent
	public void onPlayerPicking(PlayerEvent.ItemPickupEvent e){
		if (e.pickedUp.getEntityItem().getItem() instanceof SepithItem) {
			e.player.addStat(OrbArtsMain.sepithAchievement, 1);
		}
	}
}
