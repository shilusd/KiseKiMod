package atusp.orbarts.item.equipment;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.item.Item;

public class HolyFabricsItem extends Item{
	public HolyFabricsItem() 
	{
		super();
		//�趨���ѵ�
		this.setMaxStackSize(64);
		//�趨��ǩ
		this.setCreativeTab(OrbArtsMain.orbartsTab);
		this.setUnlocalizedName("holyFabrics");
	}
}
