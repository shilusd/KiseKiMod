package atusp.orbarts.item.sepith;

import java.util.List;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class SepithBagItem extends Item{
	
	public SepithBagItem() {
		super();
		this.setUnlocalizedName("sepithBag");
		this.setMaxStackSize(1);

		//设定标签
		this.setCreativeTab(OrbArtsMain.orbartsTab);
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
	
	//添加鼠标悬停信息，色彩+内容，颜色可以使用EnumChatFormatting.xx
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
	
	//右键点击物品时的动作,各色晶片掉落1
	public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn) 
	{
		//要判断是否在服务器，否则会执行两遍
		if(!worldIn.isRemote)
		{
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt==null) {
				nbt = newNBT(stack);
			}
			
			//掉落七种晶片各1
			if (nbt.getLong("EarthSepith")>0) 
			{
				playerIn.dropItem(OrbArtsMain.sepithEarth, 1);
				nbt.setLong("EarthSepith",nbt.getLong("EarthSepith")-1);
			}
			if (nbt.getLong("FireSepith")>0) 
			{
				playerIn.dropItem(OrbArtsMain.sepithFire, 1);
				nbt.setLong("FireSepith",nbt.getLong("FireSepith")-1);
			}
			if (nbt.getLong("WaterSepith")>0) 
			{
				playerIn.dropItem(OrbArtsMain.sepithWater, 1);
				nbt.setLong("WaterSepith",nbt.getLong("WaterSepith")-1);
			}
			if (nbt.getLong("WindSepith")>0) 
			{
				playerIn.dropItem(OrbArtsMain.sepithWind, 1);
				nbt.setLong("WindSepith",nbt.getLong("WindSepith")-1);
			}
			if (nbt.getLong("TimeSepith")>0) 
			{
				playerIn.dropItem(OrbArtsMain.sepithTime, 1);
				nbt.setLong("TimeSepith",nbt.getLong("TimeSepith")-1);
			}
			if (nbt.getLong("SpaceSepith")>0) 
			{
				playerIn.dropItem(OrbArtsMain.sepithSpace, 1);
				nbt.setLong("SpaceSepith",nbt.getLong("SpaceSepith")-1);
			}
			if (nbt.getLong("MirageSepith")>0) 
			{
				playerIn.dropItem(OrbArtsMain.sepithMirage, 1);
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

