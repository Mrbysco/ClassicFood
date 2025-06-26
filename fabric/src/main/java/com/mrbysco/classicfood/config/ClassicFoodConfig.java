package com.mrbysco.classicfood.config;

import com.mrbysco.classicfood.Constants;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.CollapsibleObject;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = Constants.MOD_ID)
public class ClassicFoodConfig implements ConfigData {
	@CollapsibleObject
	public General general = new General();

	public static class General {
		@ConfigEntry.Gui.Tooltip
		@Comment("When enabled food will be eaten instantly (Default: false)")
		public boolean instantFood = false;

		@ConfigEntry.Gui.Tooltip
		@Comment("When enabled food items won't be able to stack (Default: false)")
		public boolean unstackable = false;

		@ConfigEntry.Gui.Tooltip
		@Comment("When enabled hunger will act similar to poison (Default: false)")
		public boolean poisonousHunger = false;

		@ConfigEntry.Gui.Tooltip
		@Comment("The amount of food points that will heal 1 health point (Default: 1.0)")
		public double foodToHealRatio = 1.0D;
	}
}
