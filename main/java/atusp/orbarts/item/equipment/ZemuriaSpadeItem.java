package atusp.orbarts.item.equipment;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;

public class ZemuriaSpadeItem extends ItemSpade{

	public ZemuriaSpadeItem() {
		super(OrbArtsMain.zemuriaMaterial);
		this.setCreativeTab(OrbArtsMain.orbartsTab);
		this.setUnlocalizedName("zemuriaSpade");
	}
}
