package atusp.orbarts.item.equipment;

import java.util.List;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class LongStickItem extends WeaponItem{
	public LongStickItem(ToolMaterial material) {
		super("longStick",material,5,2F,1F,false,20);
	}
	
    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }
    
    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     *  
     * @param timeLeft The amount of ticks left before the using would have been complete
     */
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityPlayer entity, int timeLeft)
    {
    	//System.out.println(72000-timeLeft);
    	//蓄力攻击时长
        if (72000-timeLeft>=45) {
        	//造成周围一格aoe
        	 AxisAlignedBB box = new AxisAlignedBB(entity.posX, entity.posY, entity.posZ, entity.posX+1F, entity.posY+1F, entity.posZ+1F).expand(4+1, 4+1, 4+1);
             //返回除了某实体以外的处于碰撞盒内的物体
             List list = entity.worldObj.getEntitiesWithinAABBExcludingEntity(entity, box);
             Vec3 lookat = entity.getLookVec();
             for (Object o: list) {
             	if (o instanceof EntityLiving) {
             		EntityLiving entity2 = (EntityLiving)o;
             		System.out.println(entity2.getName()+":"+entity2.getDistanceToEntity(entity));
             		//判断视线与碰撞盒是否相交且视线未被遮挡
             		//可视范围内aoe
             		if (entity.canEntityBeSeen(entity2)) {
             			attack(entity,entity2);
             		}
             	}
             }
             entity.rotationYaw = (float) (Math.random()*360f);
        }
    }
    
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        return itemStackIn;
    }
    
    public ModelResourceLocation getModel(ItemStack stack, EntityPlayer player, int useRemaining) {
    	ModelResourceLocation mrl = new ModelResourceLocation(OrbArtsMain.MODID + ":longStick", "inventory");
    	//已经使用的时间
    	if (player.getItemInUse() !=null) {
    		mrl = new ModelResourceLocation(OrbArtsMain.MODID + ":longStick_pulling"+(useRemaining%8), "inventory");
    	}
    	return mrl;
    }
}
