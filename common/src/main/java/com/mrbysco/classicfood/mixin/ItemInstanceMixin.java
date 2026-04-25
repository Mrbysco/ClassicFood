package com.mrbysco.classicfood.mixin;

import com.mrbysco.classicfood.config.ClassicFoodConfig;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemInstance.class)
public interface ItemInstanceMixin {
	@Inject(method = "getMaxStackSize", at = @At("HEAD"), cancellable = true)
	private void classicfood$getMaxStackSize(CallbackInfoReturnable<Integer> cir) {
		ItemInstance self = (ItemInstance) this;
		if (self instanceof ItemStack itemStack) {
			if (ClassicFoodConfig.COMMON.unstackable.get() && itemStack.has(DataComponents.FOOD))
				cir.setReturnValue(1);
		}
	}
}
