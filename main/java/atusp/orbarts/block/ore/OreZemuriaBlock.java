package atusp.orbarts.block.ore;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import atusp.orbarts.OrbArtsMain;

public class OreZemuriaBlock extends Block{
	public OreZemuriaBlock() {
		super(Material.rock);
		//设定硬度
		this.setHardness(2F);
		
		//设定标签
		this.setCreativeTab(OrbArtsMain.orbartsTab);
		
		//axe斧hoe锄pickax稿，0-3分别为材质
		this.setHarvestLevel("pickaxe", 3);
		
		//是否发光
		this.setLightLevel(1.0F);
		
		this.setUnlocalizedName("oreZemuria");
	}
	
	//控制掉落物数量,Random为随机类,nextDobule返回0-1
	public int quantityDropped(Random random) {
		return (int)(random.nextDouble()*2+1);
	}
	
	//控制掉落物,fortune为时运附魔
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    	return OrbArtsMain.zemuria;
    }
}
