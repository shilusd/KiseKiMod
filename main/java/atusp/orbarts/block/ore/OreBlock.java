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
		//�趨Ӳ�ȣ�1.5F��ʯͷ�����Block
		this.setHardness(1.5F);
		
		//�趨��ǩ
		this.setCreativeTab(OrbArtsMain.orbartsTab);
		
		//axe��hoe��pickax�壬0-3�ֱ�Ϊ����
		this.setHarvestLevel("pickaxe", 1);
		
		//�Ƿ񷢹�
		this.setLightLevel(0.0F);
	}
	
	//���Ƶ���������,RandomΪ�����
	public int quantityDropped(Random random) {
		return random.nextInt(10)+10;
	}
	
	//���Ƶ�����,fortuneΪʱ�˸�ħ
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
 