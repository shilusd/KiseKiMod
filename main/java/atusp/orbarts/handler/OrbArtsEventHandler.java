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

	//玩家登入事件
	@SubscribeEvent
	public void onPlayerJoining(PlayerEvent.PlayerLoggedInEvent e) {
		//发送聊天信息，可以通过在ChatComponentText里面setChatStyle来改变字体和颜色
		e.player.addChatComponentMessage(new ChatComponentText(OrbArtsMain.greetingMsg));
	}
	
	//工作台合成事件
	@SubscribeEvent
	public void onPlayerCrafting(PlayerEvent.ItemCraftedEvent e) {
		if (e.crafting.getItem().equals(Item.getItemFromBlock(OrbArtsMain.orbmentTable))) {
			//开启某成就
			e.player.addStat(OrbArtsMain.orbmentTableAchievement, 1);
		}
	}
	
	//获取物品事件
	@SubscribeEvent
	public void onPlayerPicking(PlayerEvent.ItemPickupEvent e){
		if (e.pickedUp.getEntityItem().getItem() instanceof SepithItem) {
			e.player.addStat(OrbArtsMain.sepithAchievement, 1);
		}
	}
}
