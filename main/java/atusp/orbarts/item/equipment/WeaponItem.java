package atusp.orbarts.item.equipment;

import java.util.List;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class WeaponItem extends Item{
	public float attackDamage;
	public ToolMaterial material;
	public float range;
	public float knockback;
	public int speed;
	public boolean isPassArmor;
    
    //自定义武器，参数为名称、材料、伤害、范围、击退、是否破甲
	public WeaponItem(String name, ToolMaterial material, float damage, float range, float knockback, boolean passArmor, int speed) {
		super();
		this.attackDamage = damage;
		this.material = material;
        this.maxStackSize = 1;
        this.range = range;
        this.isPassArmor = passArmor;
        this.knockback = knockback;
        this.speed = speed;
        this.setMaxDamage(material.getMaxUses());
		this.setUnlocalizedName(name);
		this.setCreativeTab(OrbArtsMain.orbartsTab);
	}
	
    //对方块效率
    public float getDamageVsEntity() {
        return this.attackDamage*this.material.getDamageVsEntity()/2.0F;
    }
	
    //攻击动作
    public float getStrVsBlock(ItemStack stack, Block block)
    {
        return 1.5F;
    }
    
    //鏀诲嚮鍔ㄤ綔
    public void attack(EntityLivingBase player, EntityLivingBase entity) {
    	//计算距离分量d0,d1，为击退做准备
		double d1 = player.posX - entity.posX ;
        double d0;

        for (d0 =  player.posZ - entity.posZ ; d1 * d1 + d0 * d0 < 1.0E-4D; d0 = (Math.random() - Math.random()) * 0.01D)
        {
            d1 = (Math.random() - Math.random()) * 0.01D;
        }

        ((EntityLiving)entity).attackedAtYaw = (float)(Math.atan2(d0, d1) * 180.0D / Math.PI - (double)((EntityLiving)entity).rotationYaw);
        
        //计算击退量
        float f1 = MathHelper.sqrt_double(d1 * d1 + d0 * d0);
        float f2 = this.knockback*0.5F;
        ((EntityLiving)entity).motionX /= 2.0D;
        ((EntityLiving)entity).motionY /= 2.0D;
        ((EntityLiving)entity).motionZ /= 2.0D;
        ((EntityLiving)entity).motionX -= d1 / (double)f1 * (double)f2;
        ((EntityLiving)entity).motionY += (double)f2;
        ((EntityLiving)entity).motionZ -= d0 / (double)f1 * (double)f2;

        if (((EntityLiving)entity).motionY > 0.4000000059604645D)
        {
        	((EntityLiving)entity).motionY = 0.4000000059604645D;
        }
        
        //造成伤害
        if (this.isPassArmor) {
        	entity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) player).setDamageBypassesArmor(),this.attackDamage);
        } else {
        	entity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) player),this.attackDamage);
        }
       // System.out.println("Attack "+entity.getName()+" Successful");
    }
    
    //方法1
    //当对一个实体发动攻击时触发，此时返回ture将取消攻击
    //然而只会在进入正常攻击范围时触发，因此此处的武器范围均低于正常范围，待处理
    //不过只影响普通攻击
    /**
     * Called when the player Left Clicks (attacks) an entity.
     * Processed before damage is done, if return value is true further processing is canceled
     * and the entity is not attacked.
     *
     * @param stack The Item being used
     * @param player The player that is attacking
     * @param entity The entity being attacked
     * @return True to cancel the rest of the interaction.
     */
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
    	/*
    	System.out.println("range: "+player.getDistanceSqToEntity(entity));
    	//是否在攻击范围内
    	if (player.getDistanceSqToEntity(entity)<=22F/4F*range) {
    		//是否为生物
    		if (entity instanceof EntityLiving) {
    			attack(player,(EntityLiving)entity);
    		}
    	} else {
    		System.out.println("out of range");
    	}
    	*/
        return true;
    }
	
    //修改空挥动作
    /**
     * Called when a entity tries to play the 'swing' animation.
     *
     * @param entityLiving The entity swinging the item.
     * @param stack The Item stack
     * @return True to cancel any further processing by EntityLiving
     */
    public boolean onEntitySwing(EntityLivingBase entity, ItemStack stack)
    {
    	NBTTagCompound nbt = stack.getTagCompound();
	
    	if (!entity.worldObj.isRemote) {
    		if(nbt==null||nbt.getInteger("lastCSwing")>entity.ticksExisted) {
    			nbt = new NBTTagCompound();
    			nbt.setInteger("lastCSwing", 0);
    			nbt.setInteger("lastSSwing", 0);
    			stack.setTagCompound(nbt);
        	}
    		//System.out.println(entity.ticksExisted+":"+nbt.getInteger("lastCSwing"));
    		if (entity.ticksExisted-nbt.getInteger("lastCSwing")<speed) {
        		return true;
        	} else {
        		nbt.setInteger("lastCSwing",entity.ticksExisted);
        	}
    	}
    	if (entity.worldObj.isRemote) {
    		if(nbt==null||nbt.getInteger("lastCSwing")>entity.ticksExisted) {
    			nbt = new NBTTagCompound();
    			nbt.setInteger("lastCSwing", 0);
    			nbt.setInteger("lastSSwing", 0);
    			stack.setTagCompound(nbt);
        	}
    		//System.out.println(entity.ticksExisted+":"+nbt.getInteger("lastSSwing"));
    		if (entity.ticksExisted-nbt.getInteger("lastSSwing")<speed) {
        		return true;
        	} else {
        		nbt.setInteger("lastSSwing", entity.ticksExisted);
        	}
    	}
    	//System.out.println(entity.getLookVec().toString());
        AxisAlignedBB box = new AxisAlignedBB(entity.posX, entity.posY, entity.posZ, entity.posX+1F, entity.posY+1F, entity.posZ+1F).expand(4+this.range, 4+this.range, 4+this.range);
        //返回除了某实体以外的处于碰撞盒内的物体
        List list = entity.worldObj.getEntitiesWithinAABBExcludingEntity(entity, box);
        Vec3 lookat = entity.getLookVec();
        for (Object o: list) {
        	if (o instanceof EntityLiving) {
        		EntityLiving entity2 = (EntityLiving)o;
        		//System.out.println(entity2.getName()+":"+entity2.getDistanceToEntity(entity));
        		//判断视线与碰撞盒是否相交且视线未被遮挡
        		if (rayBoxIntersection(lookat,entity.posX,entity.posY+entity.getEyeHeight(),entity.posZ,entity2.getEntityBoundingBox())&&entity.canEntityBeSeen(entity2)) {
        			attack(entity,entity2);
        		}
        	}
        }
        return false;
    }
    
    //smith' method
    //ray-box 相交判断，传入lookat参数，xyz位置和目标的碰撞盒
    public boolean rayBoxIntersection(Vec3 vec,double x,double y,double z, AxisAlignedBB box) {
    	//System.out.println(x+","+y+","+z);
    	//System.out.println(box.minX+","+box.minY+","+box.minZ);
    	//System.out.println(box.maxX+","+box.maxY+","+box.maxZ);
    	//System.out.println(vec);
    	double tmin, tmax, tymin, tymax, tzmin, tzmax;
    	if (-vec.xCoord >= 0) {
    		if (-vec.xCoord==0.0) {
    			tmin = (box.minX - x) / (-vec.xCoord+0.0000001);
    	    	tmax = (box.maxX - x) / (-vec.xCoord+0.0000001);
    		} else {
    			tmin = (box.minX - x) / -vec.xCoord;
    	    	tmax = (box.maxX - x) / -vec.xCoord;
    		}
    	}
    	else {
	    	tmin = (box.maxX - x) / -vec.xCoord;
	    	tmax = (box.minX - x) / -vec.xCoord;
    	}
    	if (-vec.yCoord >= 0) {
    		if (-vec.yCoord==0.0) {
    			tymin = (box.minY - y) / (-vec.yCoord+0.0000001);
    	    	tymax = (box.maxY - y) / (-vec.yCoord+0.0000001);
    		} else {
    			tymin = (box.minY - y) / -vec.yCoord;
    	    	tymax = (box.maxY - y) / -vec.yCoord;
    		}
    	}
    	else {
	    	tymin = (box.maxY - y) / -vec.yCoord;
	    	tymax = (box.minY - y) / -vec.yCoord;
    	}
    	
    	if ( (tmin > tymax) || (tymin > tmax) ) {		
    		return false;
    	}
    	if (tymin > tmin) {
    		tmin = tymin;
    	}
    	
    	if (tymax < tmax) {
    		tmax = tymax;
    	}
    	
    	if (-vec.zCoord >= 0) {
    		if (-vec.zCoord==0.0) {
    			tzmin = (box.minZ - z) / (-vec.zCoord+0.0000001);
    	    	tzmax = (box.maxZ - z) / (-vec.zCoord+0.0000001);
    		} else {
    			tzmin = (box.minZ - z) / -vec.zCoord;
    	    	tzmax = (box.maxZ - z) / -vec.zCoord;
    		}
	    	
    	}
    	else {
	    	tzmin = (box.maxZ - z) / -vec.zCoord;
	    	tzmax = (box.minZ - z) / -vec.zCoord;
    	}
    	if ( (tmin > tzmax) || (tzmin > tmax) ) {
    		return false;
    	}
    		
    	if (tzmin > tmin) {
    		tmin = tzmin;
    	}
    	
    	if (tzmax < tmax) {
    		tmax = tzmax;
    	}
    	return true;
    }
    
    
    
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt==null) {
			nbt = new NBTTagCompound();
			nbt.setInteger("lastCSwing", 0);
			nbt.setInteger("lastSSwing", 0);
			stack.setTagCompound(nbt);
		}
	}   
    
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
    	NBTTagCompound nbt = stack.getTagCompound();
		if (nbt==null) {
			nbt = new NBTTagCompound();
			nbt.setInteger("lastCSwing", 0);
			nbt.setInteger("lastSSwing", 0);
			stack.setTagCompound(nbt);
		}
    }
	
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		String message;
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt==null) {
			nbt = new NBTTagCompound();
			nbt.setInteger("lastCSwing", 0);
			nbt.setInteger("lastSSwing", 0);
			stack.setTagCompound(nbt);
		}
		if (!playerIn.worldObj.isRemote) {
    		//System.out.println(entity.ticksExisted+":"+this.lastCSwing);
    		if (playerIn.ticksExisted-nbt.getInteger("lastCSwing")<speed) {
    			tooltip.add((speed-playerIn.ticksExisted+nbt.getInteger("lastCSwing"))/20f+"s Cooling");
        	} else {
        		tooltip.add("Cool Down.");
        	}
    	}
    	if (playerIn.worldObj.isRemote) {
    		//System.out.println(entity.ticksExisted+":"+this.lastSSwing);
    		if (playerIn.ticksExisted-nbt.getInteger("lastSSwing")<speed) {
    			tooltip.add((speed-playerIn.ticksExisted+nbt.getInteger("lastSSwing"))/20f+"s Cooling");
        	} else {
        		tooltip.add("Cool Down.");
        	}
    	}
	}
}
