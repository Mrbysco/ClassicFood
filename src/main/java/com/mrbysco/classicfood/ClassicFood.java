package com.mrbysco.classicfood;

import com.mrbysco.classicfood.client.ClientHandler;
import com.mrbysco.classicfood.config.ClassicFoodConfig;
import com.mrbysco.classicfood.handler.PoisonHandler;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ClassicFood.MOD_ID)
public class ClassicFood {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "classicfood";

	public ClassicFood(IEventBus eventBus) {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ClassicFoodConfig.commonSpec);
		eventBus.register(ClassicFoodConfig.class);

		NeoForge.EVENT_BUS.addListener(PoisonHandler::onPlayerTick);

		if (FMLEnvironment.dist.isClient()) {
			NeoForge.EVENT_BUS.addListener(ClientHandler::onGameOverlayRender);
		}
	}
}
