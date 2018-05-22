package atusp.orbarts.item.circuit;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SpaceCircuitsItem extends ItemCircuits{
	public static final CircuitInfo saveEP_1 = new CircuitInfo("SaveEP 1","EP Cost -10%",601,1,"Space",0,0,0,0,10,20,10,0,0,0,0,1,2,1);
	public static final CircuitInfo saveEP_2 = new CircuitInfo("SaveEP 2","EP Cost -20%",602,2,"Space",0,0,0,0,50,100,50,0,0,0,0,2,3,2);
	public static final CircuitInfo saveEP_3 = new CircuitInfo("SaveEP 3","EP Cost -30%",603,3,"Space",0,0,0,0,100,200,100,0,0,0,0,3,4,3);
	public static final CircuitInfo hit_1 = new CircuitInfo("Hit 1","DEX+20%",604,1,"Space",0,0,0,0,0,80,0,0,0,0,0,0,2,0);
	public static final CircuitInfo hit_2 = new CircuitInfo("Hit 2","DEX+50%",605,2,"Space",0,0,0,0,0,200,0,0,0,0,0,0,4,0);
	public static final CircuitInfo criticalBlade = new CircuitInfo("Critical Blade","STR+1,10% chance to critical",606,3,"Space",0,0,0,0,0,400,0,0,0,0,0,0,4,0);
	
	public static final ArrayList<CircuitInfo> list = new ArrayList<CircuitInfo>();
	
	public SpaceCircuitsItem() {
		super();
		this.addCircuitToList(saveEP_1);
		this.addCircuitToList(saveEP_2);
		this.addCircuitToList(saveEP_3);
		this.addCircuitToList(hit_1);
		this.addCircuitToList(hit_2);
		this.addCircuitToList(criticalBlade);
		
		this.setUnlocalizedName("spaceCircuits");
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
