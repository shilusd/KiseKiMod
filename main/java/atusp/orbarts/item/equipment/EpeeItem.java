package atusp.orbarts.item.equipment;

import java.util.List;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EpeeItem extends WeaponItem{
	public EpeeItem(ToolMaterial material) {
		super("epee",material,7,1.5F,2F,false,40);
	}
	
    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BLOCK;
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
        	//造成正面aoe，并不包含当前所在行列，4.5F = 基础值4F + 范围值1.5F - 当前行列1F
        	Vec3 vec= entity.getLookVec();
        	float dx,dy,dz,cx,cy,cz,ox,oy,oz;
        	if (Math.abs(vec.xCoord)>Math.abs(vec.yCoord)) {
        		if (Math.abs(vec.xCoord)>Math.abs(vec.zCoord)) {
        			dx = 0F;
        			dy = 5.5F;
        			dz = 5.5F;
        			cx = (vec.xCoord>0)?4.5F:-4.5F;
        			cy = 0F;
        			cz = 0F;
        			ox = (vec.xCoord>0)?1F:-1F;
        			oy = 0F;
        			oz = 0F;
        			//System.out.println("X "+((vec.xCoord<0)?"NEG":"POS"));
        		} else {
        			dx = 5.5F;
        			dy = 5.5F;
        			dz = 0F;
        			cz = (vec.zCoord>0)?4.5F:-4.5F;
        			cy = 0F;
        			cx = 0F;
        			oz = (vec.zCoord>0)?1F:-1F;
        			oy = 0F;
        			ox = 0F;
        			//System.out.println("Z "+((vec.zCoord<0)?"NEG":"POS"));
        		}
        	} else if (Math.abs(vec.zCoord)>Math.abs(vec.yCoord)){
        		dx = 5.5F;
    			dy = 5.5F;
    			dz = 0F;
    			cz = (vec.zCoord>0)?4.5F:-4.5F;
    			cy = 0F;
    			cx = 0F;
    			oz = (vec.zCoord>0)?1F:-1F;
    			oy = 0F;
    			ox = 0F;
    			//System.out.println("Z "+((vec.zCoord<0)?"NEG":"POS"));
        	} else {
        		dx = 5.5F;
    			dy = 0F;
    			dz = 5.5F;
    			cy = (vec.yCoord>0)?4.5F:-4.5F;
    			cz = 0F;
    			cx = 0F;
    			oy = (vec.yCoord>0)?1F:-1F;
    			ox = 0F;
    			oz = 0F;
    			//System.out.println("Y "+((vec.yCoord<0)?"NEG":"POS"));
        	}
        	  	
        	AxisAlignedBB box = new AxisAlignedBB(entity.posX, entity.posY, entity.posZ, entity.posX+1F, entity.posY+1F, entity.posZ+1F).expand(dx, dy, dz);
        	//System.out.println(box);
        	box = box.addCoord(cx, cy, cz);
        	//System.out.println(box);
        	box = box.offset(ox, oy, oz);
        	//System.out.println(box);
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
}
