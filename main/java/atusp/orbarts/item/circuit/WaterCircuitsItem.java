package atusp.orbarts.item.circuit;

import java.util.ArrayList;

import atusp.orbarts.OrbArtsMain;
import atusp.orbarts.entity.ExtendedEntityPlayer;
import atusp.orbarts.packet.ExtendedPlayerPacket;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WaterCircuitsItem extends CircuitItem{
	public static final CircuitInfo hp_1 = new CircuitInfo("HP 1","HP+2",201,1,"Water",0,20,0,0,0,0,0,0,1,0,0,0,0,0);
	public static final CircuitInfo hp_2 = new CircuitInfo("HP 2","HP+4",202,2,"Water",0,200,0,0,0,0,0,0,3,0,0,0,0,0);
	public static final CircuitInfo hp_3 = new CircuitInfo("HP 3","HP+8",203,3,"Water",0,400,0,0,0,0,0,0,5,0,0,0,0,0);
	public static final CircuitInfo AntiMagic_1 = new CircuitInfo("AntiMagic 1","ADF+5%",204,1,"Water",0,50,0,0,0,0,0,0,1,0,0,0,0,0);
	public static final CircuitInfo AntiMagic_2 = new CircuitInfo("AntiMagic 2","ADF+10%",205,3,"Water",0,300,0,0,0,0,0,0,4,0,0,0,0,0);
	public static final CircuitInfo banMGCBlade = new CircuitInfo("BanMGC Blade","STR+1,10% chance to Ban MGC target",206,2,"Water",0,100,0,0,0,0,0,0,2,0,0,0,0,0);
	public static final CircuitInfo frozeBlade = new CircuitInfo("Froze Blade","STR+1,10% chance to froze target",207,3,"Water",0,200,0,0,0,0,0,0,3,0,0,0,0,0);
	public static final CircuitInfo qinglongBlade = new CircuitInfo("Qinglong Blade","STR+2,10% chance to froze/Ban MGC target",208,5,"Water",-1,0,0,0,0,0,0,0,6,0,0,0,0,0);
	public static final CircuitInfo regeration = new CircuitInfo("Regeration","Heal Extra 0.1HP/s",209,2,"Water",0,200,0,0,50,0,0,0,2,0,0,1,0,0);
	
	public static final ArrayList<CircuitInfo> list = new ArrayList<CircuitInfo>();
	
	public WaterCircuitsItem() {
		super();
		this.addCircuitToList(hp_1);
		this.addCircuitToList(hp_2);
		this.addCircuitToList(hp_3);
		this.addCircuitToList(AntiMagic_1);
		this.addCircuitToList(AntiMagic_2);
		this.addCircuitToList(banMGCBlade);
		this.addCircuitToList(frozeBlade);
		this.addCircuitToList(qinglongBlade);
		this.addCircuitToList(regeration);
		
		this.setUnlocalizedName("waterCircuits");
	}
	
	public boolean addCircuitToList(CircuitInfo circuit) {
		boolean flag = super.addCircuitToList(circuit);
		if(flag) {
			this.list.add(circuit);
		}
		return flag;
	}
	
	//test
	public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn) 
	{
		if (!worldIn.isRemote) {
			ExtendedEntityPlayer props = ExtendedEntityPlayer.get(playerIn);
			ExtendedEntityPlayer.newOrb(props);
			ExtendedPlayerPacket p = new ExtendedPlayerPacket();
			p.get(props);
			System.out.println(p.toString());
			OrbArtsMain.network.sendTo(p,(EntityPlayerMP)playerIn);
		}
		
		//测试用，未考虑服务器和客户端
		if (list.size()==0) {
			this.newNBTForItemStack(stack, this.NULL);
		} else {
			this.newNBTForItemStack(stack, this.list.get((int)(Math.random()*this.list.size())));
		}
		return stack;
		
	}
}
