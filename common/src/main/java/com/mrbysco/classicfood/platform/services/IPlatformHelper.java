package com.mrbysco.classicfood.platform.services;

public interface IPlatformHelper {

	/**
	 * Check if poisonous hunger is enabled in the config.
	 *
	 * @return True if poisonous hunger is enabled, false otherwise.
	 */
	boolean isPoisonousHunger();

	/**
	 * Check if instant food is enabled in the config.
	 *
	 * @return True if instant food is enabled, false otherwise.
	 */
	boolean isInstantFood();

	/**
	 * Check if the food item is unstackable.
	 *
	 * @return True if the food item is unstackable, false otherwise.
	 */
	boolean isUnstackable();

	/**
	 * Get the ratio of food to heal defined in the config.
	 *
	 * @return The ratio of food to heal.
	 */
	float getFoodToHealRatio();
}
