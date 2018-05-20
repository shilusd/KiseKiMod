package atusp.orbarts.item.food;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class FoodItem extends ItemFood{

	//生命值，饱食度
	public FoodItem(int hpHealer, float saturation) {
		super(hpHealer, saturation, false);
		// TODO Auto-generated constructor stub
		//设定最大堆叠
		this.setMaxStackSize(64);
		//设定标签
		this.setCreativeTab(OrbArtsMain.orbartsTab);
		//生命满值也可使用
		this.setAlwaysEdible();
	}

}
