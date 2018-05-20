package atusp.orbarts.item.circuit;

import java.util.ArrayList;

import atusp.orbarts.entity.ExtendedEntityPlayer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FireCircuitsItem extends CircuitItem{
	public static final CircuitInfo attack_1 = new CircuitInfo("STR 1","STR+5%",101,1,"Fire",20,0,0,0,0,0,0,1,0,0,0,0,0,0);
	public static final CircuitInfo attack_2 = new CircuitInfo("STR 2","STR+10%,DEF-5%",102,2,"Fire",200,0,0,0,0,0,0,3,0,0,0,0,0,0);
	public static final CircuitInfo attack_3 = new CircuitInfo("STR 3","STR+15%,DEF-10%",103,3,"Fire",400,0,0,0,0,0,0,5,0,0,0,0,0,0);
	public static final CircuitInfo energy_1 = new CircuitInfo("ENERGY 1","Reduce FP Consume I",104,1,"Fire",50,0,0,0,0,0,0,1,0,0,0,0,0,0);
	public static final CircuitInfo energy_2 = new CircuitInfo("ENERGY 2","Reduce FP Consume II",105,3,"Fire",300,0,0,0,0,0,0,4,0,0,0,0,0,0);
	public static final CircuitInfo banATKBlade = new CircuitInfo("BanATK Blade","STR+1,10% chance to Ban ATK target",106,2,"Fire",100,0,0,0,0,0,0,2,0,0,0,0,0,0);
	public static final CircuitInfo burnBlade = new CircuitInfo("Burn Blade","STR+1,10% chance to burn target",107,3,"Fire",200,0,0,0,0,0,0,3,0,0,0,0,0,0);
	public static final CircuitInfo zhuqueBlade = new CircuitInfo("ZhuQue Blade","STR+2,10% chance to burn/Ban ATK target",108,5,"Fire",-1,0,0,0,0,0,0,6,0,0,0,0,0,0);
	public static final CircuitInfo jigong = new CircuitInfo("jigong","Get Extra 1EP/s",109,3,"Fire",400,100,0,0,100,0,0,4,2,0,0,2,0,0);
	
	public static final ArrayList<CircuitInfo> list = new ArrayList<CircuitInfo>();
	
	public FireCircuitsItem() {
		super();
		this.addCircuitToList(attack_1);
		this.addCircuitToList(attack_2);
		this.addCircuitToList(attack_3);
		this.addCircuitToList(energy_1);
		this.addCircuitToList(energy_2);
		this.addCircuitToList(banATKBlade);
		this.addCircuitToList(burnBlade);
		this.addCircuitToList(zhuqueBlade);
		this.addCircuitToList(jigong);
		
		this.setUnlocalizedName("fireCircuits");
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
		//打印信息
		ExtendedEntityPlayer props = ExtendedEntityPlayer.get(playerIn);
		System.out.println(props.toString());
		
		//测试用，未考虑服务器和客户端
		if (list.size()==0) {
			this.newNBTForItemStack(stack, this.NULL);
		} else {
			this.newNBTForItemStack(stack, this.list.get((int)(Math.random()*this.list.size())));
		}
		return stack;
	}
}
