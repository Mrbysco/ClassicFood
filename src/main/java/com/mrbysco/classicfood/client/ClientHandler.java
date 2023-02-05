package com.mrbysco.classicfood.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.GuiOverlayManager;

public class ClientHandler {
	public static void onGameOverlayRender(RenderGuiOverlayEvent.Pre event) {
		if (event.getOverlay() == GuiOverlayManager.findOverlay(new ResourceLocation("food_level"))) {
			event.setCanceled(true);
		}
	}
}
