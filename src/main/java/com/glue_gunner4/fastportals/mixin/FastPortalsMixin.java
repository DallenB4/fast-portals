package com.glue_gunner4.fastportals.mixin;

import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlayerEntity.class)
public class FastPortalsMixin {
    @Final
    private final PlayerAbilities abilities = new PlayerAbilities();

    public int getMaxNetherPortalTime() {
        return this.abilities.invulnerable ? 1 : 40;
    }
}