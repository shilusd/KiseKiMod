package atusp.orbarts.item.equipment;

import atusp.orbarts.OrbArtsMain;
import atusp.orbarts.init.ItemInit;
import atusp.orbarts.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class HolyArmor extends ItemArmor implements IHasModel{

	public HolyArmor(String name, ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlot) {
		super(material, renderIndex,equipmentSlot);
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
