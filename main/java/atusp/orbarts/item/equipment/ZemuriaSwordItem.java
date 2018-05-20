package atusp.orbarts.item.equipment;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;

public class ZemuriaSwordItem extends ItemSword{

	public ZemuriaSwordItem() {
		super(OrbArtsMain.zemuriaMaterial);
		this.setCreativeTab(OrbArtsMain.orbartsTab);
		this.setUnlocalizedName("zemuriaSword");
	}
}
