package atusp.orbarts.init;

import java.util.ArrayList;
import java.util.List;

import atusp.orbarts.block.ore.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockInit 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block earthOre = new BlockOreEarth("ore_earth");
	public static final Block fireOre = new BlockOreFire("ore_fire");
	public static final Block mirageOre = new BlockOreMirage("ore_mirage");
	public static final Block spaceOre = new BlockOreSpace("ore_space");
	public static final Block timeOre = new BlockOreTime("ore_time");
	public static final Block waterOre = new BlockOreWater("ore_water");
	public static final Block windOre = new BlockOreWind("ore_wind");
	public static final Block zemuriaOre = new BlockOreZemuria("ore_zemuria");
}
