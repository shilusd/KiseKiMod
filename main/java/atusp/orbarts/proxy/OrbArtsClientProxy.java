package atusp.orbarts.proxy;

import atusp.orbarts.OrbArtsMain;
import atusp.orbarts.entity.*;
import atusp.orbarts.handler.ExtendedPlayerPacketHandler;
import atusp.orbarts.packet.ExtendedPlayerPacket;
import atusp.orbarts.render.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class OrbArtsClientProxy extends OrbArtsServerProxy{
	private final Minecraft mc = Minecraft.getMinecraft();
	
	public void registerRenderThings() {
		RenderingRegistry.registerEntityRenderingHandler(OrbCannonBulletEntity.class, new OrbBulletRender(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(ArtsGroundEntity.class, new ArtsGroundRender(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(ArtsGroundLightEntity.class, new ArtsGroundLightRender(Minecraft.getMinecraft().getRenderManager()));

	}
	
	public void registerHandlers() {
		OrbArtsMain.network.registerMessage(new ExtendedPlayerPacketHandler(), ExtendedPlayerPacket.class, 0, Side.CLIENT);
		System.out.println("OK");
	}
	
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		// Note that if you simply return 'Minecraft.getMinecraft().thePlayer',
		// your packets will not work as expected because you will be getting a
		// client player even when you are on the server!
		// Sounds absurd, but it's true.

		// Solution is to double-check side before returning the player:
		return (ctx.side.isClient() ? mc.thePlayer : super.getPlayerEntity(ctx));
	}
	
	public void registerModels() {
		//在客户端加载模型和贴图
		//Item
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.sepithFire, 0, new ModelResourceLocation(OrbArtsMain.MODID+":sepithFire", "inventory")); //ModelResourceLocation涓殑sepithFire鐤戜技鏄寚鏂囦欢鍚嶏紝鏂逛究璧疯鍙栫粺涓�鍚嶇О
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.sepithWater, 0, new ModelResourceLocation(OrbArtsMain.MODID+":sepithWater", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.sepithWind, 0, new ModelResourceLocation(OrbArtsMain.MODID+":sepithWind", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.sepithEarth, 0, new ModelResourceLocation(OrbArtsMain.MODID+":sepithEarth", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.sepithTime, 0, new ModelResourceLocation(OrbArtsMain.MODID+":sepithTime", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.sepithSpace, 0, new ModelResourceLocation(OrbArtsMain.MODID+":sepithSpace", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.sepithMirage, 0, new ModelResourceLocation(OrbArtsMain.MODID+":sepithMirage", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.sepithBag, 0, new ModelResourceLocation(OrbArtsMain.MODID+":sepithBag", "inventory"));
    	
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.fireCircuits, 0, new ModelResourceLocation(OrbArtsMain.MODID+":fireCircuits", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.waterCircuits, 0, new ModelResourceLocation(OrbArtsMain.MODID+":waterCircuits", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.earthCircuits, 0, new ModelResourceLocation(OrbArtsMain.MODID+":earthCircuits", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.windCircuits, 0, new ModelResourceLocation(OrbArtsMain.MODID+":windCircuits", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.timeCircuits, 0, new ModelResourceLocation(OrbArtsMain.MODID+":timeCircuits", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.spaceCircuits, 0, new ModelResourceLocation(OrbArtsMain.MODID+":spaceCircuits", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.mirageCircuits, 0, new ModelResourceLocation(OrbArtsMain.MODID+":mirageCircuits", "inventory"));

    	
    	
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.zemuria, 0, new ModelResourceLocation(OrbArtsMain.MODID+":zemuria", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.zemuriaAxe, 0, new ModelResourceLocation(OrbArtsMain.MODID+":zemuriaAxe", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.zemuriaHoe, 0, new ModelResourceLocation(OrbArtsMain.MODID+":zemuriaHoe", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.zemuriaPickaxe, 0, new ModelResourceLocation(OrbArtsMain.MODID+":zemuriaPickaxe", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.zemuriaSword, 0, new ModelResourceLocation(OrbArtsMain.MODID+":zemuriaSword", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.zemuriaSpade, 0, new ModelResourceLocation(OrbArtsMain.MODID+":zemuriaSpade", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.holyFabrics, 0, new ModelResourceLocation(OrbArtsMain.MODID+":holyFabrics", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.holyHelmet, 0, new ModelResourceLocation(OrbArtsMain.MODID+":holyHelmet", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.holyBoots, 0, new ModelResourceLocation(OrbArtsMain.MODID+":holyBoots", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.holyLeggings, 0, new ModelResourceLocation(OrbArtsMain.MODID+":holyLeggings", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.holyChestplate, 0, new ModelResourceLocation(OrbArtsMain.MODID+":holyChestplate", "inventory"));
    	
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.longStick, 0, new ModelResourceLocation(OrbArtsMain.MODID+":longStick", "inventory"));
    	ModelBakery.addVariantName(OrbArtsMain.longStick, OrbArtsMain.MODID+":longStick", OrbArtsMain.MODID+":longStick_pulling0",OrbArtsMain.MODID+":longStick_pulling1",OrbArtsMain.MODID+":longStick_pulling2",
    			OrbArtsMain.MODID+":longStick_pulling3",OrbArtsMain.MODID+":longStick_pulling4",OrbArtsMain.MODID+":longStick_pulling5", OrbArtsMain.MODID+":longStick_pulling6",OrbArtsMain.MODID+":longStick_pulling7");
    	
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.epee, 0, new ModelResourceLocation(OrbArtsMain.MODID+":epee", "inventory"));
    	
    	ModelBakery.addVariantName(OrbArtsMain.orbCannon, OrbArtsMain.MODID+":orbCannon", OrbArtsMain.MODID+":orbCannon_pulling0",OrbArtsMain.MODID+":orbCannon_pulling1",OrbArtsMain.MODID+":orbCannon_pulling2");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.orbCannon, 0, new ModelResourceLocation(OrbArtsMain.MODID+":orbCannon", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.foodSoup, 0, new ModelResourceLocation(OrbArtsMain.MODID+":foodSoup", "inventory"));

    	//Effect
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.lightBall, 0, new ModelResourceLocation(OrbArtsMain.MODID+":lightBall", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.artsGround, 0, new ModelResourceLocation(OrbArtsMain.MODID+":artsGround", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(OrbArtsMain.artsGroundLight, 0, new ModelResourceLocation(OrbArtsMain.MODID+":artsGroundLight", "inventory"));

    	
    	//Block
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(OrbArtsMain.orbmentTable), 0, new ModelResourceLocation(OrbArtsMain.MODID+":orbmentTable", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(OrbArtsMain.oreEarth), 0, new ModelResourceLocation(OrbArtsMain.MODID+":oreEarth", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(OrbArtsMain.oreFire), 0, new ModelResourceLocation(OrbArtsMain.MODID+":oreFire", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(OrbArtsMain.oreWind), 0, new ModelResourceLocation(OrbArtsMain.MODID+":oreWind", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(OrbArtsMain.oreWater), 0, new ModelResourceLocation(OrbArtsMain.MODID+":oreWater", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(OrbArtsMain.oreTime), 0, new ModelResourceLocation(OrbArtsMain.MODID+":oreTime", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(OrbArtsMain.oreSpace), 0, new ModelResourceLocation(OrbArtsMain.MODID+":oreSpace", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(OrbArtsMain.oreMirage), 0, new ModelResourceLocation(OrbArtsMain.MODID+":oreMirage", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(OrbArtsMain.oreZemuria), 0, new ModelResourceLocation(OrbArtsMain.MODID+":oreZemuria", "inventory"));

        Minecraft.getMinecraft().getTextureManager().bindTexture(OrbArtsMain.rl);
        Minecraft.getMinecraft().getTextureManager().bindTexture(OrbArtsMain.rl2);

	}
}
