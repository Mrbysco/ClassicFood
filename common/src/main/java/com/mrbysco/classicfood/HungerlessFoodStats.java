package com.mrbysco.classicfood;

import com.mrbysco.classicfood.config.ClassicFoodConfig;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.NotNull;

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
	public void tick(ServerPlayer player) {
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
	public void readAdditionalSaveData(@NotNull ValueInput valueInput) {
	}

	@Override
	public void addAdditionalSaveData(@NotNull ValueOutput output) {
	}

	@Override
	public void eat(int hunger, float saturation) {
		this.heal(hunger);
	}

	@Override
	public void eat(@NotNull FoodProperties food) {
		heal(Mth.ceil(food.nutrition() * ClassicFoodConfig.COMMON.foodToHealRatio.get()));
	}

	public void heal(float amount) {
		this.list.add((player -> player.heal(amount)));
	}
}
