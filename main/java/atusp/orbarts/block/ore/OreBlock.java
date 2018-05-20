package atusp.orbarts.block.ore;

import java.util.Random;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class OreBlock extends Block{

	public OreBlock() {
		super(Material.rock);
		//设定硬度，1.5F是石头，详见Block
		this.setHardness(1.5F);
		
		//设定标签
		this.setCreativeTab(OrbArtsMain.orbartsTab);
		
		//axe斧hoe锄pickax稿，0-3分别为材质
		this.setHarvestLevel("pickaxe", 1);
		
		//是否发光
		this.setLightLevel(0.0F);
	}
	
	//控制掉落物数量,Random为随机类
	public int quantityDropped(Random random) {
		return random.nextInt(10)+10;
	}
	
	//控制掉落物,fortune为时运附魔
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    	if (this instanceof OreEarthBlock) {
    		return OrbArtsMain.sepithEarth;
    	}
    	if (this instanceof OreFireBlock) {
    		return OrbArtsMain.sepithFire;
    	}
    	if (this instanceof OreWindBlock) {
    		return OrbArtsMain.sepithWind;
    	}
    	if (this instanceof OreWaterBlock) {
    		return OrbArtsMain.sepithWater;
    	}
    	if (this instanceof OreTimeBlock) {
    		return OrbArtsMain.sepithTime;
    	}
    	if (this instanceof OreSpaceBlock) {
    		return OrbArtsMain.sepithSpace;
    	}
    	if (this instanceof OreMirageBlock) {
    		return OrbArtsMain.sepithMirage;
    	}
    	return null;
    }
}
 