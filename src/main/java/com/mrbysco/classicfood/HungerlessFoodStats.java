package com.mrbysco.classicfood;

import com.mrbysco.classicfood.config.ClassicFoodConfig;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class HungerlessFoodStats extends FoodData {
	private float currentHealth;
	private float maxHealth;
	private final List<Consumer<Player>> list = new ArrayList<>();

	public HungerlessFoodStats() {
	}

	@Override
	public void tick(Player player) {
		this.currentHealth = player.getHealth();
		this.maxHealth = player.getMaxHealth();

		if (!list.isEmpty()) {
			list.forEach(consumer -> consumer.accept(player));
			list.clear();
		}
	}

	@Override
	public boolean needsFood() {
		return currentHealth < maxHealth;
	}

	@Override
	public void setSaturation(float saturation) {
	}

	@Override
	public float getSaturationLevel() {
		return 20F;
	}

	@Override
	public void setFoodLevel(int foodLevel) {
	}

	@Override
	public int getFoodLevel() {
		return 20;
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundNBT) {
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compoundNBT) {
	}

	@Override
	public void eat(int hunger, float saturation) {
		this.heal(hunger);
	}

	@Override
	public void eat(Item item, ItemStack stack) {
		if (item.isEdible()) {
			FoodProperties food = item.getFoodProperties();
			if (food != null) {
				heal(Mth.ceil(food.getNutrition() * ClassicFoodConfig.COMMON.foodToHealRatio.get().floatValue()));
			}
		}
	}

	public void heal(float amount) {
		this.list.add((player -> player.heal(amount)));
	}
}
