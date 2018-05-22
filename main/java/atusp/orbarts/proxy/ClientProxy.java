package atusp.orbarts.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

//客户端代理
public class ClientProxy extends ServerProxy
{
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(),id));
	}
}