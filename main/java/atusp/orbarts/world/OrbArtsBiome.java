package atusp.orbarts.world;

import java.util.Random;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class OrbArtsBiome extends BiomeGenBase {
	private static Block[] ores = new Block[7];
	
	public OrbArtsBiome(int biomeId) {
		super(biomeId);
		this.setBiomeName("OrbArts Biome");
		//this.setHeight(new Height(0,5));
		//Ⱥϵ���ϲ㷽�飬��������,ɳ�ӵ�
		this.topBlock = OrbArtsMain.oreZemuria.getDefaultState();
		//Ⱥϵ�Ƕ������䷽��
		this.fillerBlock = Blocks.dirt.getDefaultState();
		//����֮�⻹�����ѡ������Ⱥϵ���Բ�����Щ����Ƿ����ѩ�ȵȵȣ�����鿴BiomeGenBase
		
		this.ores[0] = OrbArtsMain.oreEarth;
		this.ores[1] = OrbArtsMain.oreFire;
		this.ores[2] = OrbArtsMain.oreWind;
		this.ores[3] = OrbArtsMain.oreWater;
		this.ores[4] = OrbArtsMain.oreTime;
		this.ores[5] = OrbArtsMain.oreSpace;
		this.ores[6] = OrbArtsMain.oreMirage;
	}
	
	public void decorate(World worldIn, Random p_180624_2_, BlockPos p_180624_3_)
    {
        super.decorate(worldIn, p_180624_2_, p_180624_3_);
        int i = 1000 + p_180624_2_.nextInt(6);
        int j;
        int k;
        int l;

        for (j = 0; j < i; ++j)
        {
            k = p_180624_2_.nextInt(16);
            l = p_180624_2_.nextInt(28) + 4;
            int i1 = p_180624_2_.nextInt(16);
            BlockPos blockpos1 = p_180624_3_.add(k, l, i1);

            if (worldIn.getBlockState(blockpos1).getBlock().isReplaceableOreGen(worldIn, blockpos1, net.minecraft.block.state.pattern.BlockHelper.forBlock(Blocks.stone)))
            {
                worldIn.setBlockState(blockpos1, ores[p_180624_2_.nextInt(4)].getDefaultState(), 2);
            }
			//new WorldGenMinable(ores[p_180624_2_.nextInt(4)].getDefaultState(), 10).generate(world, random, new BlockPos(posX,posY,posZ));

        }
    }

}
