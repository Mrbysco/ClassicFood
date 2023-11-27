package com.mrbysco.classicfood.handler;

import com.mrbysco.classicfood.config.ClassicFoodConfig;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.TickEvent;

public class PoisonHandler {
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side.isServer()) {
			Player player = event.player;
			if (ClassicFoodConfig.COMMON.poisonousHunger.get() && player.hasEffect(MobEffects.HUNGER)) {
				MobEffectInstance instance = player.getEffect(MobEffects.HUNGER);
				if (instance != null) {
					int duration = instance.isInfiniteDuration() ? player.tickCount : instance.getDuration();

					if (isDurationEffectTick(duration, instance.getAmplifier()) && player.getHealth() > 1.0F) {
						player.hurt(player.damageSources().magic(), 1.0F);
					}
				}
			}
		}
	}

	private static boolean isDurationEffectTick(int duration, int amplifier) {
		int amplifiedCount = 25 >> amplifier;
		if (amplifiedCount > 0) {
			return duration % amplifiedCount == 0;
		} else {
			return true;
		}
	}
}
