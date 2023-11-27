package com.mrbysco.classicfood.config;

import com.mrbysco.classicfood.ClassicFood;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

public class ClassicFoodConfig {
	public static class Common {
		public final ModConfigSpec.BooleanValue instantFood;
		public final ModConfigSpec.BooleanValue unstackable;
		public final ModConfigSpec.BooleanValue poisonousHunger;
		public final ModConfigSpec.DoubleValue foodToHealRatio;

		Common(ModConfigSpec.Builder builder) {
			//General settings
			builder.comment("General settings")
					.push("general");

			instantFood = builder
					.comment("When enabled food will be eaten instantly (Default: false)")
					.define("instantFood", false);

			unstackable = builder
					.comment("When enabled food items won't be able to stack (Default: false)")
					.define("unstackable", false);

			poisonousHunger = builder
					.comment("When enabled hunger will act similar to poison (Default: false)")
					.define("poisonousHunger", false);

			foodToHealRatio = builder
					.comment("The amount of food points that will heal 1 health point (Default: 1.0)")
					.defineInRange("foodToHealRatio", 1.0D, 0.0D, 8.0D);

			builder.pop();
		}
	}

	public static final ModConfigSpec commonSpec;
	public static final Common COMMON;

	static {
		final Pair<Common, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Common::new);
		commonSpec = specPair.getRight();
		COMMON = specPair.getLeft();
	}

	@SubscribeEvent
	public static void onLoad(final ModConfigEvent.Loading configEvent) {
		ClassicFood.LOGGER.debug("Loaded Classic Food's config file {}", configEvent.getConfig().getFileName());
	}

	@SubscribeEvent
	public static void onFileChange(final ModConfigEvent.Reloading configEvent) {
		ClassicFood.LOGGER.debug("Classic Food's config just got changed on the file system!");
	}
}
