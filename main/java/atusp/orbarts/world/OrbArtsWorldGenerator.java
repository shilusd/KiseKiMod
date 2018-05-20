package atusp.orbarts.world;

import java.util.Random;

import atusp.orbarts.OrbArtsMain;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OrbArtsWorldGenerator implements IWorldGenerator {
	private static Block[] ores = new Block[7];
	
	public OrbArtsWorldGenerator() {
		this.ores[0] = OrbArtsMain.oreEarth;
		this.ores[1] = OrbArtsMain.oreFire;
		this.ores[2] = OrbArtsMain.oreWind;
		this.ores[3] = OrbArtsMain.oreWater;
		this.ores[4] = OrbArtsMain.oreTime;
		this.ores[5] = OrbArtsMain.oreSpace;
		this.ores[6] = OrbArtsMain.oreMirage;
	}
	//�������ɹ���ʵ��Ϊһ������һ����������
	//chunkX,chunkZΪ�����������꣬���ͼ��ʵ�����겻ͬ,��Ӧ�ĵ�ͼ��ΧΪchunkX*16~chunkX*16+15,chunkZ*16~chunkZ*16+15
	//worldΪ��������
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		//�������ͣ�Ĭ������£�0Ϊ�����磬-1Ϊ������1Ϊĩ��
		switch(world.provider.getDimensionId()) {
			case -1:
				gen_1(world, random, chunkX*16, chunkZ*16);
				break;
			case 0:
				gen0(world, random, chunkX*16, chunkZ*16);
				break;
			case 1:
				gen1(world, random, chunkX*16, chunkZ*16);
				break;
		}
	}
	
	//������������
	//�˴���chunkX��chunkZΪʵ�ʵ�ͼ����
	private void gen0(World world, Random random, int chunkX, int chunkZ) {
		for (int i=0; i<30; i++) {
			//�������Ŀ�λ�ã�����ͨ�����Ƹ�λ�õ������Χ����������λ�ã�����ͨ������posY���������ɸ߶�
			int posX = chunkX + random.nextInt(16);
			int posY = random.nextInt(64);
			int posZ = chunkZ + random.nextInt(16);
			//��Ϸ�Դ��Ŀ���������
			//�������������Ϊ���﷽�飬�����������������ɿ���ķ���
			//���������ɲ���Ϊ�����磬������Ϳ�������λ��
			//�Դ��������������������������ϼ��������ϵ�������ȣ������������ڵĲ�������Ϊ�����֤��������С�ڸ�����������ͬʱ�ж������Ƿ���������滻
			new WorldGenMinable(ores[random.nextInt(4)].getDefaultState(), 10).generate(world, random, new BlockPos(posX,posY,posZ));
		}
	}
	
	//�½�������
	private void gen_1(World world, Random random, int chunkX, int chunkZ) {
		for (int i=0; i<30; i++) {
			int posX = chunkX + random.nextInt(16);
			int posY = random.nextInt(128);
			int posZ = chunkZ + random.nextInt(16);
			new WorldGenMinable(ores[4+random.nextInt(3)].getDefaultState(), 10, BlockHelper.forBlock(Blocks.NETHERRACK)).generate(world, random, new BlockPos(posX,posY,posZ));
		}		
	}
	
	//ĩ��������
	private void gen1(World world, Random random, int chunkX, int chunkZ) {
		
	}

}
