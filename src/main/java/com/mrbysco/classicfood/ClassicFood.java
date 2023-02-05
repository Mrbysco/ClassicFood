package com.mrbysco.classicfood;

import com.mrbysco.classicfood.client.ClientHandler;
import com.mrbysco.classicfood.config.ClassicFoodConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ClassicFood.MOD_ID)
public class ClassicFood {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "classicfood";

	public ClassicFood() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ClassicFoodConfig.commonSpec);
		eventBus.register(ClassicFoodConfig.class);

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
			MinecraftForge.EVENT_BUS.addListener(ClientHandler::onGameOverlayRender);
		});
	}
}
