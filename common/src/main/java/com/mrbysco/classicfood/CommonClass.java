package com.mrbysco.classicfood;

import com.mrbysco.classicfood.config.ClassicFoodConfig;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class CommonClass {

    public static void onPlayerTick(Player player) {
        if (player.level() instanceof ServerLevel serverLevel) {
            if (ClassicFoodConfig.COMMON.poisonousHunger.get() && player.hasEffect(MobEffects.HUNGER)) {
                MobEffectInstance instance = player.getEffect(MobEffects.HUNGER);
                if (instance != null) {
                    int duration = instance.isInfiniteDuration() ? player.tickCount : instance.getDuration();

                    if (isDurationEffectTick(duration, instance.getAmplifier()) && player.getHealth() > 1.0F) {
                        player.hurtServer(serverLevel, player.damageSources().magic(), 1.0F);
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