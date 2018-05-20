package atusp.orbarts.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ArtsGroundLightEntity extends  Entity{
	private int maxLife = 200;
	public float renderRadis = 1.2f;
	
	public ArtsGroundLightEntity(World worldIn) {
		super(worldIn);
	}

	public ArtsGroundLightEntity(World worldIn, double x, double y, double z) {
		super(worldIn);
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		this.renderRadis = 1.2f;
		// TODO Auto-generated constructor stub
	}

	
	
	public void onUpdate() {
    	//System.out.println(renderRadis);
    	if (20>this.ticksExisted) {
    		this.renderRadis-=0.03;
    	} else {
    		this.setDead();
    	}
    	super.onUpdate();
    }



	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tagCompund) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompound) {
		// TODO Auto-generated method stub
		
	}

}
