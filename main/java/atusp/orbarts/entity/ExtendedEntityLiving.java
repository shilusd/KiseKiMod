package atusp.orbarts.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedEntityLiving implements IExtendedEntityProperties{
	/*
	Here I create a constant EXT_PROP_NAME for this class of properties. You need a unique name for every instance of IExtendedEntityProperties you make, and doing it at the top of each class as a constant makes
	it very easy to organize and avoid typos. It's easiest to keep the same constant name in every class, as it will be distinguished by the class name: ExtendedPlayer.EXT_PROP_NAME vs. ExtendedEntity.EXT_PROP_NAME

	Note that a single entity can have multiple extended properties, so each property should have a unique name. Try to come up with something more unique than the tutorial example.
	*/
	public final static String EXT_PROP_NAME = "ExtendedLiving";

	// I always include the entity to which the properties belong for easy access
	// It's final because we won't be changing which player it is
	private final EntityLivingBase entityLiving;

	// Declare other variables you want to add here

	//STR
	public int str;

	/*
	The default constructor takes no arguments, but I put in the Entity so I can initialize the above variable 'player'

	Also, it's best to initialize any other variables you may have added, just like in any constructor.
	*/
	public ExtendedEntityLiving(EntityLivingBase entityLiving)
	{
	this.entityLiving = entityLiving;
	this.str = 0;

	}

	/**
	* Used to register these extended properties for the player during EntityConstructing event
	* This method is for convenience only; it will make your code look nicer
	*/
	public static void register(EntityLivingBase entityLiving)
	{
		entityLiving.registerExtendedProperties(ExtendedEntityLiving.EXT_PROP_NAME, new ExtendedEntityLiving(entityLiving));
	}

	/**
	* Returns ExtendedPlayer properties for player
	* This method is for convenience only; it will make your code look nicer
	*/
	public static ExtendedEntityLiving get(EntityLivingBase entityLiving)
	{
		return (ExtendedEntityLiving) entityLiving.getExtendedProperties(EXT_PROP_NAME);
	}

	// Save any custom data that needs saving here
	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
	// We need to create a new tag compound that will save everything for our Extended Properties
		NBTTagCompound properties = new NBTTagCompound();
	
	//save Tag
		properties.setInteger("str", this.str);

	/*
	Now add our custom tag to the player's tag with a unique name (our property's name). This will allow you to save multiple types of properties and distinguish between them. If you only have one type, it isn't as important, but it will still avoid conflicts between your tag names and vanilla tag names. For instance, if you add some "Items" tag, that will conflict with vanilla. Not good. So just use a unique tag name.
	*/
		compound.setTag(EXT_PROP_NAME, properties);
	}

	// Load whatever data you saved
	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
	// Here we fetch the unique tag compound we set for this class of Extended Properties
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
	// Get our data from the custom tag compound
		this.str = properties.getInteger("str");
	
	// Just so you know it's working, add this line:
		System.out.println("[Player PROPS]");
	}

	/*
	I personally have yet to find a use for this method. If you know of any,
	please let me know and I'll add it in!
	*/
	@Override
	public void init(Entity entity, World world)
	{
	}

	/*
	That's it for the IExtendedEntityProperties methods, but we need to add a few of our own in order to interact with our new variables. For now, let's make one method to consume mana and one to replenish it.
	*/
	public String toString() {
		return "STR:"+this.str+"\n";
	}
}
