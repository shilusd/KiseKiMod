package atusp.orbarts.entity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class OrbCannonBulletEntity extends EntityThrowable{

	public OrbCannonBulletEntity(World worldIn) {
		super(worldIn);
	}
	
	public OrbCannonBulletEntity(World world, EntityLivingBase entity) {
		super(world,entity);
	}

    /**
     * Gets the amount of gravity to apply to the thrown entity with each tick.
     */
    protected float getGravityVelocity()
    {
        return 0.001F;
    }

    public void onUpdate() {
    	if(this.ticksExisted>100) {
    		this.setDead();
    	}
    	super.onUpdate();
    }
    
	
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
        float f2 = 0.1F;
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
     
        entity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) player),2F);
        //System.out.println("Attack "+entity.getName()+" Successful");
    }
	
	//当接触到方块或实体时的动作
	@Override
	protected void onImpact(MovingObjectPosition position) {
		if (!this.worldObj.isRemote) {
			//Explosion explosion = new Explosion(this.worldObj,(Entity)null, this.posX, this.posY, this.posZ, 5F, false, true);
			//explosion.doExplosionA();
			//位置、效果和是否有火花
			AxisAlignedBB box = new AxisAlignedBB(position.hitVec.xCoord, position.hitVec.yCoord, position.hitVec.zCoord, position.hitVec.xCoord+1F, position.hitVec.yCoord+1F, position.hitVec.zCoord+1F).expand(2, 2, 2);
	        //返回除了某实体以外的处于碰撞盒内的物体
	        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(null, box);
	        for (Object o: list) {
	        	if (o instanceof EntityLiving) {
	        		EntityLiving entity2 = (EntityLiving)o;
	        		//System.out.println(this.getThrower()+":"+entity2);
	        		attack(this.getThrower(),entity2);
	        	}
	        }
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ, 2F, false);
		}
		this.setDead();
	}
}
