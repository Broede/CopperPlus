package copperplus.core;

import com.mojang.logging.LogUtils;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CopperPlus.MOD_ID)
public class CopperPlus {
	public static final String MOD_ID = "copperplus";
	private static final Logger LOGGER = LogUtils.getLogger();
	
	public CopperPlus() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		CopperPlusItems.register(modEventBus);
		CopperPlusBlocks.register(modEventBus);
		
		modEventBus.addListener(this::commonSetup);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void commonSetup(final FMLCommonSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(CopperPlusBlocks.COPPER_DOOR.get(), RenderType.cutout());
    	ItemBlockRenderTypes.setRenderLayer(CopperPlusBlocks.COPPER_TRAPDOOR.get(), RenderType.cutout());
    	ItemBlockRenderTypes.setRenderLayer(CopperPlusBlocks.COPPER_BARS.get(), RenderType.cutout());
    	ItemBlockRenderTypes.setRenderLayer(CopperPlusBlocks.COPPER_CHAIN.get(), RenderType.cutout());
    	ItemBlockRenderTypes.setRenderLayer(CopperPlusBlocks.COPPER_LANTERN.get(), RenderType.cutout());
	}

	@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ClientModEvents{
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {
			
		}
	}
}
