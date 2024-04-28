package com.mrbysco.classicfood.mixin;

import com.mrbysco.classicfood.config.ClassicFoodConfig;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

	@Inject(at = @At("HEAD"), method = "getUseDuration", cancellable = true)
	private void classicfood_getUseDuration(CallbackInfoReturnable<Integer> cir) {
		ItemStack stack = (ItemStack) (Object) this;
		if (ClassicFoodConfig.COMMON.instantFood.get() && stack.has(DataComponents.FOOD))
			cir.setReturnValue(1);
	}

	@Inject(at = @At("HEAD"), method = "getMaxStackSize", cancellable = true)
	private void classicfood_getMaxStackSize(CallbackInfoReturnable<Integer> cir) {
		ItemStack stack = (ItemStack) (Object) this;
		if (ClassicFoodConfig.COMMON.unstackable.get() && stack.has(DataComponents.FOOD))
			cir.setReturnValue(1);
	}
}
