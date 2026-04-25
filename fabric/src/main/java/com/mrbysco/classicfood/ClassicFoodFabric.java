package com.mrbysco.classicfood;

import com.mrbysco.classicfood.config.ClassicFoodConfig;
import fuzs.forgeconfigapiport.fabric.api.v5.ConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.neoforged.fml.config.ModConfig;

public class ClassicFoodFabric implements ModInitializer {

	@Override
	public void onInitialize() {
		ConfigRegistry.INSTANCE.register(Constants.MOD_ID, ModConfig.Type.COMMON, ClassicFoodConfig.commonSpec);
	}
}
