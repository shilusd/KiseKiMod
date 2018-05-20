package atusp.orbarts.item.equipment;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;

public class ZemuriaHoeItem extends ItemHoe{

	public ZemuriaHoeItem() {
		super(OrbArtsMain.zemuriaMaterial);
		this.setCreativeTab(OrbArtsMain.orbartsTab);
		this.setUnlocalizedName("zemuriaHoe");
	}
}
