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
		//�趨Ӳ��
		this.setHardness(2F);
		
		//�趨��ǩ
		this.setCreativeTab(OrbArtsMain.orbartsTab);
		
		//axe��hoe��pickax�壬0-3�ֱ�Ϊ����
		this.setHarvestLevel("pickaxe", 3);
		
		//�Ƿ񷢹�
		this.setLightLevel(1.0F);
		
		this.setUnlocalizedName("oreZemuria");
	}
	
	//���Ƶ���������,RandomΪ�����,nextDobule����0-1
	public int quantityDropped(Random random) {
		return (int)(random.nextDouble()*2+1);
	}
	
	//���Ƶ�����,fortuneΪʱ�˸�ħ
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    	return OrbArtsMain.zemuria;
    }
}
