package com.mrbysco.classicfood.client;

import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

public class ClientHandler {
	public static void onGameOverlayRender(RenderGuiLayerEvent.Pre event) {
		if (event.getName().equals(VanillaGuiLayers.FOOD_LEVEL)) {
			event.setCanceled(true);
		}
	}
}
