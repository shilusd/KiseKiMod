package atusp.orbarts.item.food;

import atusp.orbarts.OrbArtsMain;
import atusp.orbarts.entity.ExtendedEntityPlayer;
import atusp.orbarts.packet.ExtendedPlayerPacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class FoodSoupItem extends FoodItem{
	public FoodSoupItem() {
		//生命值，饱腹度
		super(5,1.0F);
		this.setUnlocalizedName("foodSoup");
	}
	
	public boolean hasEffect(ItemStack stack) {
		return false;
	}
	
	//进食完毕后触发
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			//增加buff,buff种类，时间，强度
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 20000, 5));		
		}
	}
}
