package com.mrbysco.classicfood;

import com.mrbysco.classicfood.config.ClassicFoodConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;

public class ClassicFoodFabric implements ModInitializer {
	public static ConfigHolder<ClassicFoodConfig> config;

	@Override
	public void onInitialize() {
		config = AutoConfig.register(ClassicFoodConfig.class, Toml4jConfigSerializer::new);
	}
}
