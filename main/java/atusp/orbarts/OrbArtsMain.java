package atusp.orbarts;

import java.util.List;
import java.util.Map;

import atusp.orbarts.block.orbment.*;
import atusp.orbarts.block.ore.*;
import atusp.orbarts.entity.*;
import atusp.orbarts.handler.*;
import atusp.orbarts.item.sepith.*;
import atusp.orbarts.item.circuit.*;
import atusp.orbarts.item.entity.effect.*;
import atusp.orbarts.item.equipment.*;
import atusp.orbarts.item.equipment.LightBallItem;
import atusp.orbarts.item.food.*;
import atusp.orbarts.packet.ExtendedPlayerPacket;
import atusp.orbarts.proxy.OrbArtsServerProxy;
import atusp.orbarts.world.OrbArtsBiome;
import atusp.orbarts.world.OrbArtsWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
//import net.minecraft.stats.Achievement;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.Height;
import net.minecraft.world.biome.BiomeGenForest;
//import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = OrbArtsMain.MODID, name = OrbArtsMain.NAME, version = OrbArtsMain.VERSION)
public class OrbArtsMain
{
    public static final String MODID = "orbarts";
    public static final String VERSION = "0.1";
    public static final String NAME = "Orbarts";
    
    @Instance(MODID)
    public static OrbArtsMain INSTANCE;
    
    @SidedProxy(clientSide="atusp.orbarts.proxy.OrbArtsClientProxy", serverSide="atusp.orbarts.proxy.OrbArtsServerProxy")
    public static OrbArtsServerProxy PROXY;
    
    //专用标签
    public static CreativeTabs orbartsTab;
    
    //世界生成器
    public static IWorldGenerator orbartsWorldGenerator;
    
    //生物群系
    //生物群系编号
    //public static int biomeId;
    //public static BiomeGenBase orbartsBiome;
    
    //燃料时间管理器
    public static IFuelHandler orbartsFuelHandler;
    //事件管理器
	public static Object orbartsEventHandler;
	//界面管理器
	public static IGuiHandler orbartsGuiHandler;
	//扩展属性管理
	public static Object orbartsExtendedHandler;
	
	//欢迎信息
    public static String greetingMsg;
    
    //网络传输
    public static SimpleNetworkWrapper network;
    public static ExtendedPlayerPacketHandler extendedPlayerPacketHandler;
    
    //成就系统
    //获取一个耀晶片
    //public static Achievement sepithAchievement;
    //合成一个导力器工具台
    //public static Achievement orbmentTableAchievement;
    
    public static ResourceLocation rl;
    public static ResourceLocation rl2;
    //GUI
    public static int mainGUIId;
    public static int orbmentTableGUIId;
    
    
    //导力器合成台，暂为一个普通方块
    public static Block orbmentTable;
   
    //七耀晶片
    public static Item sepithFire;
    public static Item sepithWater;
    public static Item sepithWind;
    public static Item sepithEarth;
    public static Item sepithTime;
    public static Item sepithSpace;
    public static Item sepithMirage;
    
    //晶片袋
    public static Item sepithBag;
    
    //七曜矿石
    public static Block oreEarth;
    public static Block oreFire;
    public static Block oreWind;
    public static Block oreWater;
    public static Block oreTime;
    public static Block oreSpace;
    public static Block oreMirage;
    
    //回路
    public static Item fireCircuits;
    public static Item waterCircuits;
    public static Item earthCircuits;
    public static Item windCircuits;
    public static Item timeCircuits;
    public static Item spaceCircuits;
    public static Item mirageCircuits;
    
    //塞姆利亚石-工具/武器
    public static Item zemuria;
    public static Block oreZemuria;
    public static ToolMaterial zemuriaMaterial;
    public static Item zemuriaAxe;
    public static Item zemuriaHoe;
    public static Item zemuriaPickaxe;
    public static Item zemuriaSword;
    public static Item zemuriaSpade;
    
    //神圣布料-装备
    public static Item holyFabrics;
    public static ArmorMaterial holyMaterial;
    public static Item holyHelmet;
    public static Item holyBoots;
    public static Item holyLeggings;
    public static Item holyChestplate;
    
    //武器
    public static Item longStick; //长棍
    public static Item epee;//重剑
    public static Item orbCannon; //导力炮
    
    
    //食材
    
    //食物
    public static Item foodSoup;
    
    //鱼类
    
    
    //渲染用
    public static Item lightBall;
    public static Item artsGround;
    public static Item artsGroundLight;
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	//处理配置文件
    	configure(event);
    	
    	//新建标签
    	orbartsTab = new CreativeTabs("orbartstab") {
			@Override
			public Item getTabIconItem() 
			{
				return Item.getItemFromBlock(Blocks.DIAMOND_BLOCK);
			}
		};
		
		//新建工具材料，参数可以参照ToolMaterial类
		//EMERALD(3, 1561, 8.0F, 3.0F, 10),钻石为此数据
		zemuriaMaterial = EnumHelper.addToolMaterial("ZEMURIATOOL", 3, 2000, 10F, 6F, 64).setRepairItem(new ItemStack(zemuria, 1));
		
		//新建护甲材料，参数可以参照ArmorMaterial类
		//DIAMOND("diamond", 33, new int[]{3, 8, 6, 3}, 10);钻石为此数据
		//33是吸收伤害因数
		//10是附魔上限，表示能付多少种附魔
		//int[]数组表示 Holds the damage reduction (each 1 points is half a shield on gui) of each piece of armor (helmet, plate, legs and boots)
		holyMaterial = EnumHelper.addArmorMaterial("HOLYARMOR", "", 100, new int[]{15,30,20,15}, 64);
		
		orbartsFuelHandler = new OrbArtsFuelHandler();
		orbartsEventHandler = new OrbArtsEventHandler();
		orbartsGuiHandler = new OrbArtsGUIHandler();
		orbartsExtendedHandler = new OrbArtsExtendedHandler();
				
		mainGUIId = 1;
		orbmentTableGUIId = 2;
		
		orbmentTable = new OrbmentTable();
		
		sepithFire = new SepithFireItem();
		sepithWater = new SepithWaterItem();
		sepithWind = new SepithWindItem();
		sepithEarth = new SepithEarthItem();
		sepithTime = new SepithTimeItem();
		sepithSpace = new SepithSpaceItem();
		sepithMirage = new SepithMirageItem();
		
		sepithBag = new SepithBagItem();
		
		oreEarth = new OreEarthBlock();
		oreFire = new OreFireBlock();
		oreWater = new OreWaterBlock();
		oreWind = new OreWindBlock();
		oreTime = new OreTimeBlock();
		oreSpace = new OreSpaceBlock();
		oreMirage = new OreMirageBlock();
		
		fireCircuits = new FireCircuitsItem();
		waterCircuits = new WaterCircuitsItem();
		earthCircuits = new EarthCircuitsItem();
		windCircuits = new WindCircuitsItem();
		timeCircuits = new TimeCircuitsItem();
		spaceCircuits = new SpaceCircuitsItem();
		mirageCircuits = new MirageCircuitsItem();
		
		zemuria = new ZemuriaItem();
		oreZemuria = new OreZemuriaBlock();
		zemuriaAxe = new ZemuriaAxeItem();
		zemuriaHoe = new ZemuriaHoeItem();
		zemuriaSword = new ZemuriaSwordItem();
		zemuriaPickaxe = new ZemuriaPickaxeItem();
		zemuriaSpade = new ZemuriaSpadeItem();
		
		holyFabrics = new HolyFabricsItem();
		holyHelmet = new HolyArmorItem(0,"holyHelmet");
		holyBoots = new HolyArmorItem(3,"holyBoots");
		holyLeggings = new HolyArmorItem(2,"holyLeggings");
		holyChestplate = new HolyArmorItem(1,"holyChestplate");
		
		longStick = new LongStickItem(zemuriaMaterial);
		epee = new EpeeItem(zemuriaMaterial);
		orbCannon = new OrbCannonItem(zemuriaMaterial);
		
		foodSoup = new FoodSoupItem();
		
		orbartsWorldGenerator = new OrbArtsWorldGenerator();
		//使用现有生物群系
		//orbartsBiome = new BiomeGenForest(biomeId, 1).setBiomeName("orbartsBiome").setHeight(new Height(2, 5));
		//使用自定义生物群戏
		//orbartsBiome = new OrbArtsBiome(biomeId);
		
		lightBall = new LightBallItem();
		artsGround = new ArtsGroundItem();
		artsGroundLight = new ArtsGroundLightItem();
		
		rl = new ResourceLocation(OrbArtsMain.MODID+":textures/entity/spell.png");
		rl2 =  new ResourceLocation(OrbArtsMain.MODID+":textures/entity/artsGround.png");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	registerItems();
    	registerBlocks();
    	registerEntitys();
    	removeCrafting();
    	crafting();
    	furnaceCrafting();
    	registerHandlers();
    	//registerAchievements();
    	registerWorldGenerator();
    	registerBiome();
    	registerNetWork();
    }

	@EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
		PROXY.registerModels();
		PROXY.registerRenderThings();
		PROXY.registerHandlers();
    }
    
    //管理配置文件
    private void configure(FMLPreInitializationEvent event)
    {
    	//加载默认配置文件
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    	config.load();
    	
    	//建立一个配置项
    	greetingMsg = config.getString("greetingMsg", "String", "Hi!", "A Greeting Message.");
    	//biomeId = config.getInt("biomeId", "Biomes", 80, 60, 110, "Biome ID");
    	
    	//保存配置文件
    	config.save();
    }
    
    //管理所有添加合成方法
    private void crafting() 
    {
	/*EXAMPLE
    	
    	//添加固定放置合成表(合成目标,合成表)
    	GameRegistry.addRecipe(new ItemStack(Blocks.diamond_block, 64), new Object[]{
    		//放置方式
    		"ggg",
    		"gbg",
    		"ggg",
    		//每个字母代表什么
    		Character.valueOf('g'),Blocks.gold_block,
    		Character.valueOf('b'),Items.diamond
    	});
    	
    	itemStack.addEnchantment可以添加附魔
    	itemStack.setStackDisplayName可以修改显示名称
    			
    	//添加非固定放置合成表(合成目标,合成材料1,合成材料2,...)
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 2), new ItemStack(Blocks.dirt), new ItemStack(Items.compass)); 	
    	
    	//添加熔炼,input可以为方块或物品，output为获取物品，xp为获得经验
    	GameRegistry.addSmelting(input, output, xp)
    	
    	*/
    	
    	//合成晶片袋
    	GameRegistry.addShapelessRecipe(new ItemStack(sepithBag, 1), new ItemStack(sepithFire));
    	GameRegistry.addShapelessRecipe(new ItemStack(sepithBag, 1), new ItemStack(sepithWind));
    	GameRegistry.addShapelessRecipe(new ItemStack(sepithBag, 1), new ItemStack(sepithWater));
    	GameRegistry.addShapelessRecipe(new ItemStack(sepithBag, 1), new ItemStack(sepithEarth));
    	GameRegistry.addShapelessRecipe(new ItemStack(sepithBag, 1), new ItemStack(sepithTime));
    	GameRegistry.addShapelessRecipe(new ItemStack(sepithBag, 1), new ItemStack(sepithSpace));
    	GameRegistry.addShapelessRecipe(new ItemStack(sepithBag, 1), new ItemStack(sepithMirage));
    	
    	//合成导力工具台
    	GameRegistry.addRecipe(new ItemStack(orbmentTable, 1), new Object[]{
    		"sis",
    		"ibi",
    		"sis",
    		Character.valueOf('s'),Blocks.stone,
    		Character.valueOf('i'),Items.iron_ingot,
    		Character.valueOf('b'),sepithBag
    	});
    	
    	//合成塞姆利亚工具/武器
    	GameRegistry.addRecipe(new ItemStack(zemuriaPickaxe, 1), new Object[]{
    		"zzz",
    		" s ",
    		" s ",
    		Character.valueOf('z'),zemuria,
    		Character.valueOf('s'),Items.stick
    	});
    	
    	GameRegistry.addRecipe(new ItemStack(zemuriaAxe, 1), new Object[]{
    		"zz ",
    		"zs ",
    		" s ",
    		Character.valueOf('z'),zemuria,
    		Character.valueOf('s'),Items.stick
    	});
    	
    	GameRegistry.addRecipe(new ItemStack(zemuriaHoe, 1), new Object[]{
    		"zz ",
    		" s ",
    		" s ",
    		Character.valueOf('z'),zemuria,
    		Character.valueOf('s'),Items.stick
    	});
    	
    	GameRegistry.addRecipe(new ItemStack(zemuriaSpade, 1), new Object[]{
    		" z ",
    		" s ",
    		" s ",
    		Character.valueOf('z'),zemuria,
    		Character.valueOf('s'),Items.stick
    	});
    	
    	GameRegistry.addRecipe(new ItemStack(zemuriaSword, 1), new Object[]{
    		" z ",
    		" z ",
    		" s ",
    		Character.valueOf('z'),zemuria,
    		Character.valueOf('s'),Items.stick
    	});
    	
    	//合成神圣布料装备
    	GameRegistry.addRecipe(new ItemStack(holyHelmet, 1), new Object[]{
    		"hhh",
    		"h h",
    		"   ",
    		Character.valueOf('h'),holyFabrics,
    	});
    	
    	GameRegistry.addRecipe(new ItemStack(holyHelmet, 1), new Object[]{
    		"   ",
    		"hhh",
    		"h h",
    		Character.valueOf('h'),holyFabrics,
    	});
    	
    	GameRegistry.addRecipe(new ItemStack(holyChestplate, 1), new Object[]{
    		"h h",
    		"hhh",
    		"hhh",
    		Character.valueOf('h'),holyFabrics,
    	});
    	
    	GameRegistry.addRecipe(new ItemStack(holyLeggings, 1), new Object[]{
    		"hhh",
    		"h h",
    		"h h",
    		Character.valueOf('h'),holyFabrics,
    	});
    	
    	GameRegistry.addRecipe(new ItemStack(holyBoots, 1), new Object[]{
    		"   ",
    		"h h",
    		"h h",
    		Character.valueOf('h'),holyFabrics,
    	});
    	
    	GameRegistry.addRecipe(new ItemStack(holyBoots, 1), new Object[]{
    		"h h",
    		"h h",
    		"   ",
    		Character.valueOf('h'),holyFabrics,
    	});
    }
    
    //管理所有熔炼合成
    private void furnaceCrafting() 
    {
    	//添加熔炼,input可以为方块或物品，output为获取物品，xp为获得经验
    	//GameRegistry.addSmelting(input, output, xp)		
    }
    
    //管理删除合成项目
    private void removeCrafting()
    {
    	//获取已有合成表
    	List<IRecipe> craftinglist = CraftingManager.getInstance().getRecipeList();
    	
    	//获取已有熔炼表
    	Map furnacelist = FurnaceRecipes.instance().getSmeltingList();
    	
    	//对这两个对象进行操作即可删除合成项目
    }
    
    //管理所有添加Item,服务器不再注册模型和贴图
    private void registerItems()
    {
    	
    	//注册七耀晶片
    	//给Item注册一个名字并添加进MC
    	GameRegistry.registerItem(sepithFire, "sepithFire");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(sepithFire, 0, new ModelResourceLocation(MODID+":sepithFire", "inventory")); //ModelResourceLocation涓殑sepithFire鐤戜技鏄寚鏂囦欢鍚嶏紝鏂逛究璧疯鍙栫粺涓�鍚嶇О
    	
    	GameRegistry.registerItem(sepithWater, "sepithWater");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(sepithWater, 0, new ModelResourceLocation(MODID+":sepithWater", "inventory"));
    	
    	GameRegistry.registerItem(sepithWind, "sepithWind");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(sepithWind, 0, new ModelResourceLocation(MODID+":sepithWind", "inventory"));
    	
    	GameRegistry.registerItem(sepithEarth, "sepithEarth");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(sepithEarth, 0, new ModelResourceLocation(MODID+":sepithEarth", "inventory"));
    	
    	GameRegistry.registerItem(sepithTime, "sepithTime");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(sepithTime, 0, new ModelResourceLocation(MODID+":sepithTime", "inventory"));
    	
    	GameRegistry.registerItem(sepithSpace, "sepithSpace");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(sepithSpace, 0, new ModelResourceLocation(MODID+":sepithSpace", "inventory"));
    	
    	GameRegistry.registerItem(sepithMirage, "sepithMirage");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(sepithMirage, 0, new ModelResourceLocation(MODID+":sepithMirage", "inventory"));
    	
    	//注册晶片袋
    	GameRegistry.registerItem(sepithBag, "sepithBag");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(sepithBag, 0, new ModelResourceLocation(MODID+":sepithBag", "inventory"));
    	
    	//注册回路
    	GameRegistry.registerItem(fireCircuits, "fireCircuits");
    	GameRegistry.registerItem(waterCircuits, "waterCircuits");
    	GameRegistry.registerItem(earthCircuits, "earthCircuits");
    	GameRegistry.registerItem(windCircuits, "windCircuits");
    	GameRegistry.registerItem(timeCircuits, "timeCircuits");
    	GameRegistry.registerItem(spaceCircuits, "spaceCircuits");
    	GameRegistry.registerItem(mirageCircuits, "mirageCircuits");
    	
    	
    	//注册塞姆利亚石
    	GameRegistry.registerItem(zemuria, "zemuria");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(zemuria, 0, new ModelResourceLocation(MODID+":zemuria", "inventory"));
    	
    	//注册塞姆利亚石物品
    	GameRegistry.registerItem(zemuriaAxe, "zemuriaAxe");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(zemuriaAxe, 0, new ModelResourceLocation(MODID+":zemuriaAxe", "inventory"));
    	
    	GameRegistry.registerItem(zemuriaHoe, "zemuriaHoe");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(zemuriaHoe, 0, new ModelResourceLocation(MODID+":zemuriaHoe", "inventory"));
    	
    	GameRegistry.registerItem(zemuriaPickaxe, "zemuriaPickaxe");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(zemuriaPickaxe, 0, new ModelResourceLocation(MODID+":zemuriaPickaxe", "inventory"));
    	
    	GameRegistry.registerItem(zemuriaSword, "zemuriaSword");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(zemuriaSword, 0, new ModelResourceLocation(MODID+":zemuriaSword", "inventory"));
    	
    	GameRegistry.registerItem(zemuriaSpade, "zemuriaSpade");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(zemuriaSpade, 0, new ModelResourceLocation(MODID+":zemuriaSpade", "inventory"));
    	
    	//注册神圣布料
    	GameRegistry.registerItem(holyFabrics, "holyFabrics");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(holyFabrics, 0, new ModelResourceLocation(MODID+":holyFabrics", "inventory"));
    	
    	//注册神圣布料装备
    	GameRegistry.registerItem(holyHelmet, "holyHelmet");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(holyHelmet, 0, new ModelResourceLocation(MODID+":holyHelmet", "inventory"));
    	
    	GameRegistry.registerItem(holyBoots, "holyBoots");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(holyBoots, 0, new ModelResourceLocation(MODID+":holyBoots", "inventory"));
    	
    	GameRegistry.registerItem(holyLeggings, "holyLeggings");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(holyLeggings, 0, new ModelResourceLocation(MODID+":holyLeggings", "inventory"));
    	
    	GameRegistry.registerItem(holyChestplate, "holyChestplate");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(holyChestplate, 0, new ModelResourceLocation(MODID+":holyChestplate", "inventory"));
    	
    	//注册自定义武器
    	GameRegistry.registerItem(longStick, "longStick");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(longStick, 0, new ModelResourceLocation(MODID+":longStick", "inventory"));
    	    	
    	GameRegistry.registerItem(epee, "epee");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(epee, 0, new ModelResourceLocation(MODID+":epee", "inventory"));
    	
    	GameRegistry.registerItem(orbCannon, "orbCannon");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(orbCannon, 0, new ModelResourceLocation(MODID+":orbCannon", "inventory"));
    	
    	//注册食物
    	GameRegistry.registerItem(foodSoup, "foodSoup");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(foodSoup, 0, new ModelResourceLocation(MODID+":foodSoup", "inventory"));
    	
    	//注册效果
    	GameRegistry.registerItem(lightBall, "lightBall");
    	GameRegistry.registerItem(artsGround, "artsGround");
    	GameRegistry.registerItem(artsGroundLight, "artsGroundLight");

    	
    }
    
    //管理所有添加Block,服务器不再注册模型和贴图
    private void registerBlocks()
    {
    	//注册合成台
    	GameRegistry.registerBlock(orbmentTable, "orbmentTable");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(orbmentTable), 0, new ModelResourceLocation(MODID+":orbmentTable", "inventory"));
    	
    	//注册七曜矿石
    	GameRegistry.registerBlock(oreEarth, "oreEarth");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(oreEarth), 0, new ModelResourceLocation(MODID+":oreEarth", "inventory"));
    	
    	GameRegistry.registerBlock(oreFire, "oreFire");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(oreFire), 0, new ModelResourceLocation(MODID+":oreFire", "inventory"));
    	
    	GameRegistry.registerBlock(oreWind, "oreWind");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(oreWind), 0, new ModelResourceLocation(MODID+":oreWind", "inventory"));
    	
    	GameRegistry.registerBlock(oreWater, "oreWater");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(oreWater), 0, new ModelResourceLocation(MODID+":oreWater", "inventory"));
    	
    	GameRegistry.registerBlock(oreTime, "oreTime");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(oreTime), 0, new ModelResourceLocation(MODID+":oreTime", "inventory"));
    	
    	GameRegistry.registerBlock(oreSpace, "oreSpace");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(oreSpace), 0, new ModelResourceLocation(MODID+":oreSpace", "inventory"));
    	
    	GameRegistry.registerBlock(oreMirage, "oreMirage");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(oreMirage), 0, new ModelResourceLocation(MODID+":oreMirage", "inventory"));
    	
    	//注册塞姆利亚矿石
    	GameRegistry.registerBlock(oreZemuria, "oreZemuria");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(oreZemuria), 0, new ModelResourceLocation(MODID+":oreZemuria", "inventory"));
    }
    
    //管理各种管理器
    private void registerHandlers() {
    	//注册燃料时间管理器
    	GameRegistry.registerFuelHandler(orbartsFuelHandler);
    	//注册事件管理器
		FMLCommonHandler.instance().bus().register(orbartsEventHandler);
		
		MinecraftForge.EVENT_BUS.register(orbartsExtendedHandler);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, orbartsGuiHandler);
    }
    
    //管理各种成就
    private void registerAchievements() {
		//注册成就
    	//Achiievement参数为StatID，StatName，相对位置关系，图标，前置成就
    	//后面加setSpecial会变成锯齿状成就
    	//180788_c必须附加，会添加进成就列表
    	sepithAchievement = (new Achievement("achievement.sepith","sepith", 0, 0, new ItemStack(sepithFire), (Achievement)null)).func_180788_c();
		orbmentTableAchievement = (new Achievement("achievement.orbmentTable","orbmentTable", 3, 0, new ItemStack(orbmentTable), sepithAchievement)).func_180788_c();
		
		//注册成就页
		AchievementPage.registerAchievementPage(new AchievementPage("OrbArts Achievements", new Achievement[]{sepithAchievement,orbmentTableAchievement}));
	}
    
    //管理世界生成器
    private void registerWorldGenerator() {
    	
    	GameRegistry.registerWorldGenerator(orbartsWorldGenerator, 0);
    }
    
    //管理生物群系
    private void registerBiome(){
    	
    	//BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(orbartsBiome, 1));
    }
    
    //管理实体
    private void registerEntitys() {
    	registerEntity(OrbCannonBulletEntity.class, "orbCannon", 128, 10, true);
    	registerEntity(ArtsGroundEntity.class, "artsGround", 64, 1, true);
    	registerEntity(ArtsGroundLightEntity.class, "artsGroundLight", 64, 1, true);
    }
    
    //管理网络
    private void registerNetWork(){
    	network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);

    }
    
    //注册单个实体
    /**
     * Register the mod entity type with FML

     * @param entityClass The entity class
     * @param entityName A unique name for the entity
     * @param id A mod specific ID for the entity
     * @param mod The mod
     * @param trackingRange The range at which MC will send tracking updates
     * @param updateFrequency The frequency of tracking updates
     * @param sendsVelocityUpdates Whether to send velocity information packets as well
     */
    private void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
    	int randomId = EntityRegistry.findGlobalUniqueEntityId();
    	
    	EntityRegistry.registerGlobalEntityID(entityClass, name, randomId);
    	EntityRegistry.registerModEntity(entityClass, name, randomId, INSTANCE, trackingRange, updateFrequency, sendsVelocityUpdates);
    }
}
