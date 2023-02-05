package com.mrbysco.classicfood;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.FoodStats;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class HungerlessFoodStats extends FoodStats {
	private float currentHealth;
	private float maxHealth;
	private final List<Consumer<PlayerEntity>> list = new ArrayList<>();

	public HungerlessFoodStats() {
	}

	@Override
	public void tick(PlayerEntity player) {
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
	public void readAdditionalSaveData(CompoundNBT compoundNBT) {
	}

	@Override
	public void addAdditionalSaveData(CompoundNBT compoundNBT) {
	}

	@Override
	public void eat(int hunger, float saturation) {
		this.heal(hunger);
	}

	@Override
	public void eat(Item item, ItemStack stack) {
		if (item.isEdible()) {
			Food food = item.getFoodProperties();
			if (food != null) {
				heal(food.getNutrition());
			}
		}
	}

	public void heal(float amount) {
		this.list.add((player -> player.heal(amount)));
	}
}
