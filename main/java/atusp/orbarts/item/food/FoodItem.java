package atusp.orbarts.item.food;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class FoodItem extends ItemFood{

	//����ֵ����ʳ��
	public FoodItem(int hpHealer, float saturation) {
		super(hpHealer, saturation, false);
		// TODO Auto-generated constructor stub
		//�趨���ѵ�
		this.setMaxStackSize(64);
		//�趨��ǩ
		this.setCreativeTab(OrbArtsMain.orbartsTab);
		//������ֵҲ��ʹ��
		this.setAlwaysEdible();
	}

}
