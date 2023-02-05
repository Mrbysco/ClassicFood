package com.mrbysco.classicfood.mixin;

import com.mrbysco.classicfood.config.ClassicFoodConfig;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {
	@Inject(at = @At("HEAD"), method = "getUseDuration", cancellable = true)
	private void classicfood_getUseDuration(ItemStack itemStack, CallbackInfoReturnable<Integer> cir) {
		if (ClassicFoodConfig.COMMON.instantFood.get() && itemStack.getItem().isEdible())
			cir.setReturnValue(1);
	}

	@Inject(at = @At("HEAD"), method = "getMaxStackSize", cancellable = true)
	private void classicfood_getMaxStackSize(CallbackInfoReturnable<Integer> cir) {
		Item item = (Item) (Object) this;
		if (ClassicFoodConfig.COMMON.unstackable.get() && item.isEdible())
			cir.setReturnValue(1);
	}
}
