package atusp.orbarts.block;

import atusp.orbarts.OrbArtsMain;
import atusp.orbarts.init.BlockInit;
import atusp.orbarts.init.ItemInit;
import atusp.orbarts.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{
	public BlockBase(String name, Material material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}
	
	public void registerModels() 
	{
		OrbArtsMain.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
	}
}
