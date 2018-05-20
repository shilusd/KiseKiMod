package atusp.orbarts.handler;

import atusp.orbarts.item.equipment.ZemuriaItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class OrbArtsFuelHandler implements IFuelHandler{

	@Override
	public int getBurnTime(ItemStack fuel) {
		//针对不同的燃料返回燃烧时间
		if (fuel.getItem() instanceof ZemuriaItem) {
			return 10000;
		}
		return 0;
	}

}
