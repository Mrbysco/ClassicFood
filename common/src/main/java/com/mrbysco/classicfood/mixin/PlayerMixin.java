package com.mrbysco.classicfood.mixin;

import com.mrbysco.classicfood.HungerlessFoodStats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerMixin {
	@Shadow
	protected FoodData foodData;

	@Inject(at = @At("RETURN"), method = "<init>")
	private void classicfood_init(CallbackInfo info) {
		foodData = new HungerlessFoodStats();
	}
}
