package atusp.orbarts.item.equipment;

import atusp.orbarts.OrbArtsMain;
import atusp.orbarts.init.ItemInit;
import atusp.orbarts.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item.ToolMaterial;

public class ZemuriaHoe extends ItemHoe implements IHasModel{

	public ZemuriaHoe(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		OrbArtsMain.proxy.registerItemRenderer(this,0,"inventory");
	}
}
