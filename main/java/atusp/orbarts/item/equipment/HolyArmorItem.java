package atusp.orbarts.item.equipment;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class HolyArmorItem extends ItemArmor{

	public HolyArmorItem(int type, String name) {
		//Used on RenderPlayer to select the correspondent armor to be rendered on the player: 0 is cloth, 1 is chain, 2 is iron, 3 is diamond and 4 is gold.
		// Stores the armor type: 0 is helmet, 1 is plate, 2 is legs and 3 is boots 
		super(OrbArtsMain.holyMaterial, 3, type);
		this.setCreativeTab(OrbArtsMain.orbartsTab);
		this.setUnlocalizedName(name);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if (slot==0||slot==1||slot==3) {
        	return OrbArtsMain.MODID+ ":textures/models/armor/holyArmor_1.png";
        } else if (slot ==2) {
        	return OrbArtsMain.MODID+ ":textures/models/armor/holyArmor_2.png";
        } else {
        	return null;
        }
    }
}
