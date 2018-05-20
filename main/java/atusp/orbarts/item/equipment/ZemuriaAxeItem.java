package atusp.orbarts.item.equipment;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.item.ItemAxe;

public class ZemuriaAxeItem extends ItemAxe{

	public ZemuriaAxeItem() {
		super(OrbArtsMain.zemuriaMaterial);
		this.setCreativeTab(OrbArtsMain.orbartsTab);
		this.setUnlocalizedName("zemuriaAxe");
	}
}
