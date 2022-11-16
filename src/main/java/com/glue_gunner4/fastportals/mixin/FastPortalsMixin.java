package com.glue_gunner4.fastportals.mixin;

import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class FastPortalsMixin {
    @Shadow
    private PlayerAbilities abilities;
    @Inject(method = "getMaxNetherPortalTime", at = @At("HEAD"), cancellable = true)
    public void getMaxNetherPortalTime(CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue(abilities.invulnerable ? 1 : 40);
    }
}
