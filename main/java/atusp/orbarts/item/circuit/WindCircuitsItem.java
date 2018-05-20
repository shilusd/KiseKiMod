package atusp.orbarts.item.circuit;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WindCircuitsItem extends CircuitItem{
	public static final CircuitInfo dodge_1 = new CircuitInfo("Dodge 1","AGL+3%",301,1,"Wind",0,0,20,0,0,0,0,0,0,1,0,0,0,0);
	public static final CircuitInfo dodge_2 = new CircuitInfo("Dodge 2","AGL+5%",302,2,"Wind",0,0,200,0,0,0,0,0,0,3,0,0,0,0);
	public static final CircuitInfo dodge_3 = new CircuitInfo("Dodge 3","AGL+7%",303,3,"Wind",0,0,400,0,0,0,0,0,0,5,0,0,0,0);
	public static final CircuitInfo movment_1 = new CircuitInfo("Movment 1","MOV+10%",304,1,"Wind",0,0,40,0,0,5,0,0,0,1,0,0,1,0);
	public static final CircuitInfo movment_2 = new CircuitInfo("Movment 2","MOV+15%",305,3,"Wind",0,0,300,0,0,50,0,0,0,4,0,0,2,0);
	public static final CircuitInfo blindBlade = new CircuitInfo("Blind Blade","STR+1,10% chance to blind target",306,2,"Wind",0,0,100,0,0,0,0,0,0,2,0,0,0,0);
	public static final CircuitInfo sleepyBlade = new CircuitInfo("Sleepy Blade","STR+1,10% chance to make target sleepy",307,3,"Wind",0,0,200,0,0,0,0,0,0,3,0,0,0,0);
	public static final CircuitInfo baihuBlade = new CircuitInfo("Baihu Blade","STR+2,10% chance to blind/sleepy",308,5,"Wind",-1,0,0,0,0,0,0,0,0,6,0,0,0,0);
	public static final CircuitInfo smell = new CircuitInfo("Smell","Attract the enemy",309,3,"Wind",80,80,400,80,0,0,0,2,2,4,2,0,0,0);
	public static final CircuitInfo absorb = new CircuitInfo("Absorb","Heal 1HP/kill",310,2,"Wind",0,100,300,0,0,100,0,0,2,3,0,0,2,0);
	
	public static final ArrayList<CircuitInfo> list = new ArrayList<CircuitInfo>();
	
	public WindCircuitsItem() {
		super();
		this.addCircuitToList(dodge_1);
		this.addCircuitToList(dodge_2);
		this.addCircuitToList(dodge_3);
		this.addCircuitToList(movment_1);
		this.addCircuitToList(movment_2);
		this.addCircuitToList(blindBlade);
		this.addCircuitToList(sleepyBlade);
		this.addCircuitToList(baihuBlade);
		this.addCircuitToList(smell);
		this.addCircuitToList(absorb);
		
		this.setUnlocalizedName("windCircuits");
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
		//测试用，未考虑服务器和客户端
		if (list.size()==0) {
			this.newNBTForItemStack(stack, this.NULL);
		} else {
			this.newNBTForItemStack(stack, this.list.get((int)(Math.random()*this.list.size())));
		}
		return stack;
	}
}
