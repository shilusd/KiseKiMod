package atusp.orbarts.item.circuit;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EarthCircuitsItem extends ItemCircuits{
	public static final CircuitInfo defend_1 = new CircuitInfo("Defend 1","DEF+5%",401,1,"Earth",0,0,0,20,0,0,0,0,0,0,1,0,0,0);
	public static final CircuitInfo defend_2 = new CircuitInfo("Defend 2","DEF+10%,STR-5%",402,2,"Earth",0,0,0,200,0,0,0,0,0,0,3,0,0,0);
	public static final CircuitInfo defend_3 = new CircuitInfo("Defend 3","DEF+15%,STR-10%",403,3,"Earth",0,0,0,400,0,0,0,0,0,0,5,0,0,0);
	public static final CircuitInfo dig_1 = new CircuitInfo("Dig 1","Dig Speed Up I",404,1,"Earth",0,0,0,50,0,0,0,0,0,0,1,0,0,0);
	public static final CircuitInfo dig_2 = new CircuitInfo("Dig 2","Dig Speed Up II",405,3,"Earth",0,0,0,300,0,0,0,0,0,0,4,0,0,0);
	public static final CircuitInfo poisonBlade = new CircuitInfo("Poison Blade","STR+1,10% chance to poison target",406,2,"Earth",0,0,0,100,0,0,0,0,0,0,2,0,0,0);
	public static final CircuitInfo petrifyBlade = new CircuitInfo("Petrify Blade","STR+1,10% chance to petrify target",407,3,"Earth",0,0,0,200,0,0,0,0,0,0,3,0,0,0);
	public static final CircuitInfo xuanwuBlade = new CircuitInfo("Xuanwu Blade","STR+2,10% chance to poison/petrify target",408,5,"Earth",-1,0,0,0,0,0,0,0,0,0,6,0,0,0);
	public static final CircuitInfo richSepith = new CircuitInfo("Rich Sepith","Get Extra Sepith",409,2,"Earth",0,50,0,200,0,0,0,0,1,0,2,0,0,0);
	
	public static final ArrayList<CircuitInfo> list = new ArrayList<CircuitInfo>();
	
	public EarthCircuitsItem() {
		super();
		this.addCircuitToList(defend_1);
		this.addCircuitToList(defend_2);
		this.addCircuitToList(defend_3);
		this.addCircuitToList(dig_1);
		this.addCircuitToList(dig_2);
		this.addCircuitToList(poisonBlade);
		this.addCircuitToList(petrifyBlade);
		this.addCircuitToList(xuanwuBlade);
		this.addCircuitToList(richSepith);
		
		this.setUnlocalizedName("earthCircuits");
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
		//�����ã�δ���Ƿ������Ϳͻ���
		if (list.size()==0) {
			this.newNBTForItemStack(stack, this.NULL);
		} else {
			this.newNBTForItemStack(stack, this.list.get((int)(Math.random()*this.list.size())));
		}
		return stack;
	}
}
