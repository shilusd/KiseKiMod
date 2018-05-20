package atusp.orbarts.item.circuit;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MirageCircuitsItem extends CircuitItem{
	public static final CircuitInfo EP_1 = new CircuitInfo("EP 1","EP+25",701,1,"Mirage",0,0,0,0,10,10,20,0,0,0,0,1,1,2);
	public static final CircuitInfo EP_2 = new CircuitInfo("EP 2","EP+50",702,2,"Mirage",0,0,0,0,50,50,100,0,0,0,0,2,2,3);
	public static final CircuitInfo EP_3 = new CircuitInfo("EP 3","EP+100",703,3,"Mirage",0,0,0,0,100,100,200,0,0,0,0,3,3,4);
	public static final CircuitInfo spirit_1 = new CircuitInfo("Spirit 1","ATS+5%",704,2,"Mirage",0,0,0,0,0,0,100,0,0,0,0,0,0,2);
	public static final CircuitInfo spirit_2 = new CircuitInfo("Spirit 2","ATS+10%",705,3,"Mirage",0,0,0,0,0,0,300,0,0,0,0,0,0,4);
	public static final CircuitInfo confuseBlade = new CircuitInfo("Confuse Blade","STR+1,5% chance to confuse target",706,3,"Mirage",0,0,0,0,0,0,400,0,0,0,0,0,0,4);
	public static final CircuitInfo information = new CircuitInfo("Information","Get Mob's Information",707,2,"Mirage",0,0,0,0,0,0,100,0,0,0,0,0,0,2);
	public static final CircuitInfo yangyan = new CircuitInfo("Yangyan","Reduce Mob attack chance",708,3,"Mirage",0,0,0,100,0,0,200,0,0,0,2,0,0,3);

	
	
	public static final ArrayList<CircuitInfo> list = new ArrayList<CircuitInfo>();
	
	public MirageCircuitsItem() {
		super();
		this.addCircuitToList(EP_1);
		this.addCircuitToList(EP_2);
		this.addCircuitToList(EP_3);
		this.addCircuitToList(spirit_1);
		this.addCircuitToList(spirit_2);
		this.addCircuitToList(confuseBlade);
		this.addCircuitToList(information);
		this.addCircuitToList(yangyan);
		
		this.setUnlocalizedName("mirageCircuits");
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
