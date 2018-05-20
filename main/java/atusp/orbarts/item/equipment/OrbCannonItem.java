package atusp.orbarts.item.equipment;

import java.util.List;

import atusp.orbarts.OrbArtsMain;
import atusp.orbarts.entity.ArtsGroundEntity;
import atusp.orbarts.entity.OrbCannonBulletEntity;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class OrbCannonItem extends WeaponItem {
	public OrbCannonItem(ToolMaterial material) {
		super("orbCannon",material,2F,1F,1F,false,20);
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
    
    public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
    {
    	if (!player.worldObj.isRemote&&stack.getTagCompound()!=null&&stack.getTagCompound().hasKey("artsGround")) {
    		int id = stack.getTagCompound().getInteger("artsGround");
    		Entity e = player.worldObj.getEntityByID(id);
    		if (e!=null) {
    			e.posX = player.posX;
    			e.posY = player.posY;
    			e.posZ = player.posZ;
    		}
    	}
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
        if (72000-timeLeft>=30) {
        	//worldIn.playSoundAtEntity(entity, "random.fizz", 0.7F,0.8F);
        	worldIn.playSoundAtEntity(entity, OrbArtsMain.MODID+":orbCannon.shot", 1.0F, 1.0F);
        	if (!worldIn.isRemote) {
        		worldIn.spawnEntityInWorld(new OrbCannonBulletEntity(worldIn, entity));
                //worldIn.spawnEntityInWorld(new ArtsGroundEntity(worldIn, entity));

        	}
        }
        
        if (!worldIn.isRemote&&stack.getTagCompound()!=null&&stack.getTagCompound().hasKey("artsGround")) {
    		int id = stack.getTagCompound().getInteger("artsGround");
    		Entity e = worldIn.getEntityByID(id);
    		if (e!=null) {
    			e.setDead();
    		}
    	}
    }
    
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        if (!worldIn.isRemote) {
        	if (itemStackIn.getTagCompound()==null) {
        		itemStackIn.setTagCompound(new NBTTagCompound());
        	}
        	if (!itemStackIn.getTagCompound().hasKey("artsGround")||
        			itemStackIn.getTagCompound().hasKey("artsGround")&&
        			(worldIn.getEntityByID(itemStackIn.getTagCompound().getInteger("artsGround"))==null||worldIn.getEntityByID(itemStackIn.getTagCompound().getInteger("artsGround")).isDead)) {
        		ArtsGroundEntity e = new ArtsGroundEntity(worldIn, playerIn);
            	itemStackIn.getTagCompound().setInteger("artsGround", e.getEntityId());
                worldIn.spawnEntityInWorld(e);
        	}
        }
        playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        return itemStackIn;
    }
    
    public ModelResourceLocation getModel(ItemStack stack, EntityPlayer player, int useRemaining) {
    	ModelResourceLocation mrl = new ModelResourceLocation(OrbArtsMain.MODID + ":orbCannon", "inventory");
    	//已经使用的时间
    	useRemaining = 72000 - useRemaining;
    	if (player.getItemInUse() !=null) {
    		if (useRemaining > 10) {
    			mrl = new ModelResourceLocation(OrbArtsMain.MODID + ":orbCannon_pulling0", "inventory");
    		}
    		if (useRemaining > 20) {
    			mrl = new ModelResourceLocation(OrbArtsMain.MODID + ":orbCannon_pulling1", "inventory");
    		}
    		if (useRemaining > 30) {
    			mrl = new ModelResourceLocation(OrbArtsMain.MODID + ":orbCannon_pulling2", "inventory");
    		}
    	}
    	return mrl;
    }
}
