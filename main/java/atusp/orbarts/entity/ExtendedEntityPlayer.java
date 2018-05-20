package atusp.orbarts.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedEntityPlayer extends ExtendedEntityLiving implements IExtendedEntityProperties{
	/*
	Here I create a constant EXT_PROP_NAME for this class of properties. You need a unique name for every instance of IExtendedEntityProperties you make, and doing it at the top of each class as a constant makes
	it very easy to organize and avoid typos. It's easiest to keep the same constant name in every class, as it will be distinguished by the class name: ExtendedPlayer.EXT_PROP_NAME vs. ExtendedEntity.EXT_PROP_NAME

	Note that a single entity can have multiple extended properties, so each property should have a unique name. Try to come up with something more unique than the tutorial example.
	*/
	public final static String EXT_PROP_NAME = "ExtendedPlayer";

	// I always include the entity to which the properties belong for easy access
	// It's final because we won't be changing which player it is
	private final EntityPlayer entityPlayer;

	// Declare other variables you want to add here
	
	//限定孔标识
	public final static int NONE = 0;
	public final static int FIRE = 1;
	public final static int WATER = 2;
	public final static int WIND = 3;
	public final static int EARTH = 4;
	public final static int TIME = 5;
	public final static int SPACE = 6;
	public final static int MIRAGE = 7;
	
	//是否有导力器
	public boolean hasOrb;
	
	//导力器属性
	//链路结构，保存四条链路的长度
	//按从短到长排列，少于4条以0表示，其他链路最短长度为2
	public int[] structure = new int[4];
	//限定孔情况
	public int[] limit = new int[7];
	//强化情况
	public int[] level = new int[7];
	//链路回路，保存7个孔的回路，孔按照链路顺序依次获取，每条链路共享0号孔，其他根据长度依次获得
	//数字为ciricuit中回路的id
	public int[] circuit = new int[7];

	/*
	The default constructor takes no arguments, but I put in the Entity so I can initialize the above variable 'player'

	Also, it's best to initialize any other variables you may have added, just like in any constructor.
	*/
	public ExtendedEntityPlayer(EntityPlayer entityPlayer)
	{
		super(entityPlayer);
		this.entityPlayer = entityPlayer;
	}

	/**
	* Used to register these extended properties for the player during EntityConstructing event
	* This method is for convenience only; it will make your code look nicer
	*/
	public static void register(EntityPlayer entityPlayer)
	{
		entityPlayer.registerExtendedProperties(ExtendedEntityPlayer.EXT_PROP_NAME, new ExtendedEntityPlayer(entityPlayer));
	}

	/**
	* Returns ExtendedPlayer properties for player
	* This method is for convenience only; it will make your code look nicer
	*/
	public static ExtendedEntityPlayer get(EntityPlayer entityPlayer)
	{
		return (ExtendedEntityPlayer) entityPlayer.getExtendedProperties(EXT_PROP_NAME);
	}

	// Save any custom data that needs saving here
	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
	// We need to create a new tag compound that will save everything for our Extended Properties
		NBTTagCompound properties = new NBTTagCompound();
	
	//save Tag
		super.saveNBTData(compound);
		properties.setBoolean("hasOrb", this.hasOrb);
		properties.setIntArray("structure", this.structure);
		properties.setIntArray("limit", this.limit);
		properties.setIntArray("level", this.level);
		properties.setIntArray("circuit", this.circuit);

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
		super.loadNBTData(compound);
		this.hasOrb = properties.getBoolean("hasOrb");
		this.structure = properties.getIntArray("structure");
		this.limit = properties.getIntArray("limit");
		this.level = properties.getIntArray("level");
		this.circuit = properties.getIntArray("circuit");
	
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
	
	//生成导力器
	public static void newOrb(ExtendedEntityPlayer player) {
		int lastHole = 7;
		int[] structure = new int[4];
		int[] circuit = new int[7];
		int[] limit = new int[7];
		int[] level = new int[7];
		int limitNum = 0;
		
		//判断限定孔
		int limitType = (int)(Math.random()*8);
		if (limitType==NONE) {
			limitNum = 2;
		} else {
			limit[0] = limitType;
			limitNum = 1;
		}
		
		//随机生成导力器结构和限定孔
		int i = 0;
		while (lastHole>1) {
			//随机长度
			int len = (int)(Math.random()*(lastHole-1))+1;
			if (i==3) {
				len = lastHole-1;
			}
			structure[i] = len;
			
			//生成限定
			if (limitNum==1) {
				if (Math.random()<0.5) {
					int li = (int)(Math.random()*len);
					limit[7-lastHole+li+1] = limitType;
					limitNum = 2;
				}
			}
			i++;
			lastHole-=len;
		}
		
		player.structure = structure;
		player.circuit = circuit;
		player.limit = limit;
		player.level = level;
		player.hasOrb = true;
		
		System.out.println(player.toString());
	}
	
	//输出信息
	public String toString() {
		String s = super.toString();
		s += "hasOrb:"+this.hasOrb+"\n";
		s += "structure:"+this.structure[0]+","+this.structure[1]+","+this.structure[2]+","+this.structure[3]+"\n";
		s += "circuit:"+this.circuit[0]+","+this.circuit[1]+","+this.circuit[2]+","+this.circuit[3]+","+this.circuit[4]+","+this.circuit[5]+","+this.circuit[6]+"\n";
		s += "limit:"+this.limit[0]+","+this.limit[1]+","+this.limit[2]+","+this.limit[3]+","+this.limit[4]+","+this.limit[5]+","+this.limit[6]+"\n";
		s += "level:"+this.level[0]+","+this.level[1]+","+this.level[2]+","+this.level[3]+","+this.level[4]+","+this.level[5]+","+this.level[6]+"\n";
		return s;
	}
}
