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
	//世界生成规则，实际为一个区块一个区块生成
	//chunkX,chunkZ为所在区块坐标，与地图的实际坐标不同,对应的地图范围为chunkX*16~chunkX*16+15,chunkZ*16~chunkZ*16+15
	//world为所在世界
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		//世界类型，默认情况下，0为主世界，-1为地狱，1为末地
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
	
	//主世界生成器
	//此处的chunkX和chunkZ为实际地图坐标
	private void gen0(World world, Random random, int chunkX, int chunkZ) {
		for (int i=0; i<30; i++) {
			//矿物中心块位置，可以通过控制该位置的随机范围来控制生成位置，例如通过控制posY来控制生成高度
			int posX = chunkX + random.nextInt(16);
			int posY = random.nextInt(64);
			int posZ = chunkZ + random.nextInt(16);
			//游戏自带的矿物生成器
			//生成器构造参数为矿物方块，生成数量，用来生成矿物的方块
			//生成器生成参数为，世界，随机器和矿物中心位置
			//自带矿物生成器大体是做类球星上几个方向上的随机长度，包裹在类球内的部分生成为矿物，保证总生成数小于给定的数量，同时判定方块是否可以用来替换
			new WorldGenMinable(ores[random.nextInt(4)].getDefaultState(), 10).generate(world, random, new BlockPos(posX,posY,posZ));
		}
	}
	
	//下界生成器
	private void gen_1(World world, Random random, int chunkX, int chunkZ) {
		for (int i=0; i<30; i++) {
			int posX = chunkX + random.nextInt(16);
			int posY = random.nextInt(128);
			int posZ = chunkZ + random.nextInt(16);
			new WorldGenMinable(ores[4+random.nextInt(3)].getDefaultState(), 10, BlockHelper.forBlock(Blocks.NETHERRACK)).generate(world, random, new BlockPos(posX,posY,posZ));
		}		
	}
	
	//末地生成器
	private void gen1(World world, Random random, int chunkX, int chunkZ) {
		
	}

}
