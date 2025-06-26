package com.mrbysco.classicfood.platform;

import com.mrbysco.classicfood.config.ClassicFoodConfig;
import com.mrbysco.classicfood.platform.services.IPlatformHelper;
import me.shedaniel.autoconfig.AutoConfig;

public class FabricPlatformHelper implements IPlatformHelper {

	@Override
	public boolean isPoisonousHunger() {
		ClassicFoodConfig config = AutoConfig.getConfigHolder(ClassicFoodConfig.class).getConfig();
		return config.general.poisonousHunger;
	}

	@Override
	public boolean isInstantFood() {
		ClassicFoodConfig config = AutoConfig.getConfigHolder(ClassicFoodConfig.class).getConfig();
		return config.general.instantFood;
	}

	@Override
	public boolean isUnstackable() {
		ClassicFoodConfig config = AutoConfig.getConfigHolder(ClassicFoodConfig.class).getConfig();
		return config.general.unstackable;
	}

	@Override
	public float getFoodToHealRatio() {
		ClassicFoodConfig config = AutoConfig.getConfigHolder(ClassicFoodConfig.class).getConfig();
		return (float) config.general.foodToHealRatio;
	}
}
