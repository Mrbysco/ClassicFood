package com.mrbysco.classicfood.client;

import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class ClientHandler {

	public static void onGameOverlayRender(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.FOOD) {
			event.setCanceled(true);
		}
	}
}
