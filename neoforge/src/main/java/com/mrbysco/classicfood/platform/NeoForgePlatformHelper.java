package com.mrbysco.classicfood.platform;

import com.mrbysco.classicfood.config.ClassicFoodConfig;
import com.mrbysco.classicfood.platform.services.IPlatformHelper;

public class NeoForgePlatformHelper implements IPlatformHelper {


	@Override
	public boolean isPoisonousHunger() {
		return ClassicFoodConfig.COMMON.poisonousHunger.getAsBoolean();
	}

	@Override
	public boolean isInstantFood() {
		return ClassicFoodConfig.COMMON.instantFood.getAsBoolean();
	}

	@Override
	public boolean isUnstackable() {
		return ClassicFoodConfig.COMMON.unstackable.getAsBoolean();
	}

	@Override
	public float getFoodToHealRatio() {
		return ClassicFoodConfig.COMMON.foodToHealRatio.get().floatValue();
	}
}
