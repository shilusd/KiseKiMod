package atusp.orbarts.handler;

import atusp.orbarts.item.equipment.ZemuriaItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class OrbArtsFuelHandler implements IFuelHandler{

	@Override
	public int getBurnTime(ItemStack fuel) {
		//��Բ�ͬ��ȼ�Ϸ���ȼ��ʱ��
		if (fuel.getItem() instanceof ZemuriaItem) {
			return 10000;
		}
		return 0;
	}

}
