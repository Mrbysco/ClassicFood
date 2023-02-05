package com.mrbysco.classicfood.config;

import com.mrbysco.classicfood.ClassicFood;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

public class ClassicFoodConfig {
	public static class Common {
		public final ForgeConfigSpec.BooleanValue instantFood;
		public final ForgeConfigSpec.BooleanValue unstackable;

		Common(ForgeConfigSpec.Builder builder) {
			//General settings
			builder.comment("General settings")
					.push("general");

			instantFood = builder
					.comment("When enabled food will be eaten instantly (Default: false)")
					.define("instantFood", false);

			unstackable = builder
					.comment("When enabled food items won't be able to stack (Default: false)")
					.define("unstackable", false);

			builder.pop();
		}
	}

	public static final ForgeConfigSpec commonSpec;
	public static final Common COMMON;

	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		commonSpec = specPair.getRight();
		COMMON = specPair.getLeft();
	}

	@SubscribeEvent
	public static void onLoad(final ModConfig.Loading configEvent) {
		ClassicFood.LOGGER.debug("Loaded Classic Food's config file {}", configEvent.getConfig().getFileName());
	}

	@SubscribeEvent
	public static void onFileChange(final ModConfig.Reloading configEvent) {
		ClassicFood.LOGGER.debug("Classic Food's config just got changed on the file system!");
	}
}
