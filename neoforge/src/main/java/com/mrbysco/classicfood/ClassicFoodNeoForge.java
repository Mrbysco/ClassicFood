package com.mrbysco.classicfood;

import com.mrbysco.classicfood.client.ClientHandler;
import com.mrbysco.classicfood.config.ClassicFoodConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@Mod(Constants.MOD_ID)
public class ClassicFoodNeoForge {

	public ClassicFoodNeoForge(IEventBus eventBus, Dist dist, ModContainer container) {
		container.registerConfig(ModConfig.Type.COMMON, ClassicFoodConfig.commonSpec);
		eventBus.register(ClassicFoodConfig.class);

		NeoForge.EVENT_BUS.addListener(this::onPlayerTick);

		if (dist.isClient()) {
			container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
			NeoForge.EVENT_BUS.addListener(ClientHandler::onGameOverlayRender);
		}
	}

	private void onPlayerTick(PlayerTickEvent.Pre event) {
		CommonClass.onPlayerTick(event.getEntity());
	}
}