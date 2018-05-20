package atusp.orbarts.item.equipment;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;

public class ZemuriaPickaxeItem extends ItemPickaxe{

	public ZemuriaPickaxeItem() {
		super(OrbArtsMain.zemuriaMaterial);
		this.setCreativeTab(OrbArtsMain.orbartsTab);
		this.setUnlocalizedName("zemuriaPickaxe");
	}
}
