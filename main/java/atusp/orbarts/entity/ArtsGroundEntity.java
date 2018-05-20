package atusp.orbarts.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ArtsGroundEntity extends EntityThrowable{
	//private double radius = 1;
	
	public ArtsGroundEntity(World worldIn) {
		super(worldIn);
		this.motionX = 0;
    	this.motionY = 0;
    	this.motionZ = 0;
		this.setSize(1F, 1F);
	}
	
    /**
     * Gets the amount of gravity to apply to the thrown entity with each tick.
     */
    protected float getGravityVelocity()
    {
        return 0.000000001F;
    }
	
    
	public ArtsGroundEntity(World world, EntityLivingBase entity) {
		super(world,entity);
		this.motionX = 0;
    	this.motionY = 0;
    	this.motionZ = 0;
    	this.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, 0, 0);
    	//System.out.println(this.posX+","+this.posY+","+this.posZ);
	}

	
    public void onUpdate() {
    	//this.posX = this.getThrower().posX;
		//this.posY = this.getThrower().posY+0.1;
		//this.posZ = this.getThrower().posZ;
    	this.motionX = 0;
    	this.motionY = 0;
    	this.motionZ = 0;
    	if (this.ticksExisted%7==0) {
    		/*
    		int syb = 1;
    		double x = 0;
    		double z = 0; 
    		for (int i=0;i<10;i++) {
        		x = Math.random()*2*radius-radius+this.posX;
        		z = Math.sqrt(radius*radius-(x-this.posX)*(x-this.posX));
        		if (Math.random()*2<1) {
        			z = -z;
        		}
        		z = z+posZ;
        		Entity light = new ArtsGroundLightEntity(this.worldObj,x,this.posY,z);
        		this.worldObj.spawnEntityInWorld(light);
        	}*/
    		this.worldObj.spawnEntityInWorld(new ArtsGroundLightEntity(this.worldObj,this.posX,this.posY,this.posZ));
    	}
    	if (this.ticksExisted>4000) {
    		this.setDead();
    	}
    	
    	super.onUpdate();
    }

	@Override
	protected void onImpact(MovingObjectPosition p_70184_1_) {
		// TODO Auto-generated method stub
		
	}
}
