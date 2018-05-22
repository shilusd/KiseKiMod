package atusp.orbarts.item.sepith;

import java.util.List;

import atusp.orbarts.OrbArtsMain;
import atusp.orbarts.init.ItemInit;
import atusp.orbarts.item.ItemBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemSepithBag extends ItemBase{
	
	public ItemSepithBag(String name) {
		super(name);
		this.setMaxStackSize(1);
	}

	private NBTTagCompound newNBT(ItemStack stack) {
		NBTTagCompound nbt = new NBTTagCompound();
		stack.setTagCompound(nbt);
		stack.getTagCompound().setLong("FireSepith", 0);
		stack.getTagCompound().setLong("WaterSepith", 0);
		stack.getTagCompound().setLong("EarthSepith", 0);
		stack.getTagCompound().setLong("WindSepith", 0);
		stack.getTagCompound().setLong("TimeSepith", 0);
		stack.getTagCompound().setLong("SpaceSepith", 0);
		stack.getTagCompound().setLong("MirageSepith", 0);
		return nbt;
	}
	
	//��������ͣ��Ϣ��ɫ��+���ݣ���ɫ����ʹ��EnumChatFormatting.xx
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		String message;
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt==null) {
			nbt = newNBT(stack);
		}
	    if(GuiScreen.isShiftKeyDown()){
	    	message="Fire Sepith:"+nbt.getLong("FireSepith");
			tooltip.add("\u00A7c"+message);
			message="Water Sepith:"+nbt.getLong("WaterSepith");
			tooltip.add("\u00A71"+message);
			message="Earth Sepith:"+nbt.getLong("EarthSepith");
			tooltip.add("\u00A76"+message);
			message="Wind Sepith:"+nbt.getLong("WindSepith");
			tooltip.add("\u00A7a"+message);
			message="Time Sepith:"+nbt.getLong("TimeSepith");
			tooltip.add("\u00A78"+message);
			message="Space Sepith:"+nbt.getLong("SpaceSepith");
			tooltip.add("\u00A7e"+message);
			message="Mirage Sepith:"+nbt.getLong("MirageSepith");
			tooltip.add("\u00A77"+message);
	    } else {
	    	message="Hold Shift to Open Sepith Info.";
			tooltip.add(message);
	    }
		
	}
	
	//�Ҽ������Ʒʱ�Ķ���,��ɫ��Ƭ����1
	public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn) 
	{
		//Ҫ�ж��Ƿ��ڷ������������ִ������
		if(!worldIn.isRemote)
		{
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt==null) {
				nbt = newNBT(stack);
			}
			
			//�������־�Ƭ��1
			if (nbt.getLong("EarthSepith")>0) 
			{
				playerIn.dropItem(ItemInit.EARTH_SEPITH, 1);
				nbt.setLong("EarthSepith",nbt.getLong("EarthSepith")-1);
			}
			if (nbt.getLong("FireSepith")>0) 
			{
				playerIn.dropItem(ItemInit.FIRE_SEPITH, 1);
				nbt.setLong("FireSepith",nbt.getLong("FireSepith")-1);
			}
			if (nbt.getLong("WaterSepith")>0) 
			{
				playerIn.dropItem(ItemInit.WATER_SEPITH, 1);
				nbt.setLong("WaterSepith",nbt.getLong("WaterSepith")-1);
			}
			if (nbt.getLong("WindSepith")>0) 
			{
				playerIn.dropItem(ItemInit.WIND_SEPITH, 1);
				nbt.setLong("WindSepith",nbt.getLong("WindSepith")-1);
			}
			if (nbt.getLong("TimeSepith")>0) 
			{
				playerIn.dropItem(ItemInit.TIME_SEPITH, 1);
				nbt.setLong("TimeSepith",nbt.getLong("TimeSepith")-1);
			}
			if (nbt.getLong("SpaceSepith")>0) 
			{
				playerIn.dropItem(ItemInit.SPACE_SEPITH, 1);
				nbt.setLong("SpaceSepith",nbt.getLong("SpaceSepith")-1);
			}
			if (nbt.getLong("MirageSepith")>0) 
			{
				playerIn.dropItem(ItemInit.MIRAGE_SEPITH, 1);
				nbt.setLong("MirageSepith",nbt.getLong("MirageSepith")-1);
			}
			
			//((SepithBagItem)itemStackIn.getItem()).printInfo();  
			
		}
		return stack;
	}
	
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt==null) {
			nbt = newNBT(stack);
		}
	}       
	
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
    	NBTTagCompound nbt = stack.getTagCompound();
		if (nbt==null) {
			nbt = newNBT(stack);
		}
    }

}

