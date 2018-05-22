package atusp.orbarts.item.sepith;

import atusp.orbarts.OrbArtsMain;
import atusp.orbarts.item.ItemBase;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemSepith extends ItemBase
{	
	public ItemSepith(String name) 
	{
		super(name);
		//设定最大堆叠
		this.setMaxStackSize(64);
		//设定标签
		//this.setCreativeTab(OrbArtsMain.orbartsTab);
		
		//setMaxDamage:耐久度
	}
	
	//使用晶片以加入晶片袋
	/*
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{ 	
		//damageItem(int,playin)消耗耐久度
		if (!playerIn.capabilities.isCreativeMode)
	    {
	        --itemStackIn.stackSize;
	    }
		
		if(!worldIn.isRemote)
		{
			Item item = itemStackIn.getItem();
			
			//检测玩家身上是否有碎片袋
			ItemStack[] iss = playerIn.inventory.mainInventory;
			ItemStack cgis = null;
			for (ItemStack is: iss) 
			{
				if (is instanceof ItemStack && is.getItem() instanceof SepithBagItem) 
				{
					cgis = is;
					break;
				}
			}
			
			//没有
			if (cgis==null) 
			{
				Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("You don't have a Sepith Bag!\n"));
				++itemStackIn.stackSize;
				return itemStackIn;
			}
			
			//有则增加相应数字
			if (item instanceof SepithFireItem) 
			{
				cgis.getTagCompound().setLong("FireSepith",cgis.getTagCompound().getLong("FireSepith")+1);
			}
			if (item instanceof SepithWaterItem) 
			{
				cgis.getTagCompound().setLong("WaterSepith",cgis.getTagCompound().getLong("WaterSepith")+1);
			}
			if (item instanceof SepithEarthItem) 
			{
				cgis.getTagCompound().setLong("EarthSepith",cgis.getTagCompound().getLong("EarthSepith")+1);
			}
			if (item instanceof SepithWindItem) 
			{
				cgis.getTagCompound().setLong("WindSepith",cgis.getTagCompound().getLong("WindSepith")+1);
			}
			if (item instanceof SepithTimeItem) 
			{
				cgis.getTagCompound().setLong("TimeSepith",cgis.getTagCompound().getLong("TimeSepith")+1);
			}
			if (item instanceof SepithSpaceItem) 
			{
				cgis.getTagCompound().setLong("SpaceSepith",cgis.getTagCompound().getLong("SpaceSepith")+1);
			}
			if (item instanceof SepithMirageItem) 
			{
				cgis.getTagCompound().setLong("MirageSepith",cgis.getTagCompound().getLong("MirageSepith")+1);
			}

		}
		return itemStackIn;
	}*/
}
