package atusp.orbarts.init;

import java.util.ArrayList;
import java.util.List;

import atusp.orbarts.item.circuit.ItemFireCircuits;
import atusp.orbarts.item.equipment.*;
import atusp.orbarts.item.sepith.*;
import atusp.orbarts.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemInit 
{
	//所有对象
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//注册对象
	//public static final Item fireCircuits = new ItemFireCircuits("circuits_fire");
	
	//材料
	public static final ToolMaterial ZEMURIA_MATERIAL = EnumHelper.addToolMaterial("zemuria_material", 3, 1561, 8.0F, 3.0F, 10);
	public static final ArmorMaterial HOLY_MATERIAL = EnumHelper.addArmorMaterial("holy_material", Reference.MODID+":holy" ,33 , new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	
	//耀晶片
	public static final Item FIRE_SEPITH = new ItemSepithFire("sepith_fire");
	public static final Item WATER_SEPITH = new ItemSepithWater("sepith_water");
	public static final Item WIND_SEPITH = new ItemSepithWind("sepith_wind");
	public static final Item EARTH_SEPITH = new ItemSepithEarth("sepith_earth");
	public static final Item TIME_SEPITH = new ItemSepithTime("sepith_time");
	public static final Item SPACE_SEPITH = new ItemSepithSpace("sepith_space");
	public static final Item MIRAGE_SEPITH = new ItemSepithMirage("sepith_mirage");
	public static final Item SEPITH_BAG = new ItemSepithBag("sepith_bag");
	
	public static final Item ZEMURIA = new Zemuria("zemuria");
	public static final Item HOLY_FABRICS = new HolyFabrics("holy_fabrics");
	
	//工具
	public static final Item AXE_ZEMURIA = new ZemuriaAxe("zemuria_axe",ZEMURIA_MATERIAL);
	public static final Item PICKAXE_ZEMURIA = new ZemuriaPickaxe("zemuria_pickaxe",ZEMURIA_MATERIAL);
	public static final Item HOE_ZEMURIA = new ZemuriaHoe("zemuria_hoe",ZEMURIA_MATERIAL);
	public static final Item SPADE_ZEMURIA = new ZemuriaSpade("zemuria_spade",ZEMURIA_MATERIAL);
	public static final Item SWORD_ZEMURIA = new ZemuriaSword("zemuria_sword",ZEMURIA_MATERIAL);
	
	//护甲
	public static final Item HELMET_HOLY = new HolyArmor("holy_helmet",HOLY_MATERIAL, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHEST_HOLY = new HolyArmor("holy_chest",HOLY_MATERIAL, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_HOLY = new HolyArmor("holy_leggings",HOLY_MATERIAL, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_HOLY = new HolyArmor("holy_boots",HOLY_MATERIAL, 1, EntityEquipmentSlot.FEET);

}
