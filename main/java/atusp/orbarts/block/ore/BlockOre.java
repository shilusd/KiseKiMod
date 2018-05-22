package atusp.orbarts.block.ore;

import java.util.Random;

import atusp.orbarts.OrbArtsMain;
import atusp.orbarts.block.BlockBase;
import atusp.orbarts.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class BlockOre extends BlockBase{

	public BlockOre(String name) {
		super(name,Material.ROCK);
		//�趨Ӳ�ȣ�1.5F��ʯͷ�����Block
		this.setHardness(1.5F);
		
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
    	if (this instanceof BlockOreEarth) {
    		return ItemInit.EARTH_SEPITH;
    	}
    	if (this instanceof BlockOreFire) {
    		return ItemInit.FIRE_SEPITH;
    	}
    	if (this instanceof BlockOreWind) {
    		return ItemInit.WIND_SEPITH;
    	}
    	if (this instanceof BlockOreWater) {
    		return ItemInit.WATER_SEPITH;
    	}
    	if (this instanceof BlockOreTime) {
    		return ItemInit.TIME_SEPITH;
    	}
    	if (this instanceof BlockOreSpace) {
    		return ItemInit.SPACE_SEPITH;
    	}
    	if (this instanceof BlockOreMirage) {
    		return ItemInit.MIRAGE_SEPITH;
    	}
    	return null;
    }
}
 