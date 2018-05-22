package atusp.orbarts.item.circuit;

import java.util.ArrayList;
import java.util.List;

import atusp.orbarts.OrbArtsMain;
import atusp.orbarts.item.ItemBase;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemCircuits extends ItemBase{
	public static final CircuitInfo NULL = new CircuitInfo("NULL","NO DESCRIPTION",0,1,"VOID",0,0,0,0,0,0,0,0,0,0,0,0,0,0);
	public static final CircuitInfo[] arr = new CircuitInfo[1000];
	public static final ArrayList<CircuitInfo> list = new ArrayList<CircuitInfo>();
	
	public ItemCircuits(String name) 
	{
		super(name);
		this.setMaxStackSize(1);
	}
	
	public NBTTagCompound newNBTForItemStack(ItemStack stack, CircuitInfo circuit) {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("circuitId", circuit.circuitId);
		stack.setTagCompound(nbt);
		return nbt;
	}
	
	public boolean addCircuitToList(CircuitInfo circuit) {
		if (arr[circuit.circuitId]==null) {
			list.add(circuit);
			arr[circuit.circuitId] = circuit;
			return true;
		}
		return false;
	}
	
	public void onCreate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
    	onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
    	NBTTagCompound nbt = stack.getTagCompound();
    	if (nbt==null) {
			nbt = this.newNBTForItemStack(stack, NULL);
		}
    	CircuitInfo info = arr[nbt.getInteger("circuitId")];
    	if (info==null) {
    		info = NULL;
    	}
    	
    	String pre = "";
    	if (info.type.equals("Fire")) pre="\u00A7c";
    	if (info.type.equals("Water")) pre="\u00A71";
    	if (info.type.equals("Wind")) pre="\u00A7a";
    	if (info.type.equals("Earth")) pre="\u00A76";
    	if (info.type.equals("Time")) pre="\u00A78";
    	if (info.type.equals("Space")) pre="\u00A7e";
    	if (info.type.equals("Mirage")) pre="\u00A77";

    	
    	stack.setStackDisplayName(pre+info.name);
	}
    
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
    	NBTTagCompound nbt = stack.getTagCompound();
    	if (nbt==null) {
			nbt = this.newNBTForItemStack(stack, NULL);
		}
    	CircuitInfo info = arr[nbt.getInteger("circuitId")];
    	if (info==null) {
    		info = NULL;
    	}
	    if(GuiScreen.isShiftKeyDown()){
	    	String message;
	    	message="Description:"+info.description;
			tooltip.add(message);
			message="Rank:"+info.rank;
			tooltip.add(message);
			message="Provide:";
			tooltip.add(message);
			
			if (info.giveFire>0) {
				message="Fire Sepith:"+info.giveFire;
				tooltip.add("\u00A7c"+message);
			}
			if (info.giveWater>0) {
				message="Water Sepith:"+info.giveWater;
				tooltip.add("\u00A71"+message);
			}
			if (info.giveEarth>0) {
				message="Earth Sepith:"+info.giveEarth;
				tooltip.add("\u00A76"+message);
			}
			if (info.giveWind>0) {
				message="Wind Sepith:"+info.giveWind;
				tooltip.add("\u00A7a"+message);
			}
			if (info.giveTime>0) {
				message="Time Sepith:"+info.giveTime;
				tooltip.add("\u00A78"+message);
			}
			if (info.giveSpace>0) {
				message="Space Sepith:"+info.giveSpace;
				tooltip.add("\u00A7e"+message);
			}
			if (info.giveMirage>0) {
				message="Mirage Sepith:"+info.giveMirage;
				tooltip.add("\u00A77"+message);
			}
			
	    } else {
			tooltip.add("Hold Shift to Open Circuit Info.");
	    }
		
	}
}
