package atusp.orbarts.item.circuit;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TimeCircuitsItem extends ItemCircuits{
	public static final CircuitInfo action_1 = new CircuitInfo("Action 1","SPD+5%,Spell-2%,Cd-5%",501,1,"Time",0,0,0,0,20,0,0,0,0,0,0,1,0,0);
	public static final CircuitInfo action_2 = new CircuitInfo("Action 2","SPD+10%,Spell-4%,Cd-10%",502,2,"Time",0,0,0,0,200,0,0,0,0,0,0,3,0,0);
	public static final CircuitInfo action_3 = new CircuitInfo("Action 3","SPD+15%,Spell-6%,Cd-15%",503,3,"Time",0,0,0,0,400,0,0,0,0,0,0,5,0,0);
	public static final CircuitInfo drive_1 = new CircuitInfo("Drive 1","Spell-10%",504,2,"Time",0,0,0,0,100,20,0,0,0,0,0,2,1,0);
	public static final CircuitInfo drive_2 = new CircuitInfo("Drive 2","spell-20%",505,3,"Time",0,0,0,0,300,100,0,0,0,0,0,3,2,0);
	public static final CircuitInfo deathBlade = new CircuitInfo("Death Blade","5% chance to kill target",506,2,"Time",0,0,0,0,200,0,0,0,0,0,0,2,0,0);
	public static final CircuitInfo luck = new CircuitInfo("Luck","Get Extra Item",509,3,"Time",0,0,0,50,300,50,0,0,0,0,1,3,1,0);
	
	public static final ArrayList<CircuitInfo> list = new ArrayList<CircuitInfo>();
	
	public TimeCircuitsItem() {
		super();
		this.addCircuitToList(action_1);
		this.addCircuitToList(action_2);
		this.addCircuitToList(action_3);
		this.addCircuitToList(drive_1);
		this.addCircuitToList(drive_2);
		this.addCircuitToList(deathBlade);
		this.addCircuitToList(luck);
		
		this.setUnlocalizedName("timeCircuits");
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
