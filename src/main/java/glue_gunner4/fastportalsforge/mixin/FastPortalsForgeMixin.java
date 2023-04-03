package glue_gunner4.fastportalsforge.mixin;

import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.time.LocalDate;
import java.time.Month;

@Mixin(Player.class)
public class FastPortalsForgeMixin {
    @Shadow
    @Final
    private Abilities abilities;

    @Inject(method = "getPortalWaitTime", at = @At("HEAD"), cancellable = true)
    public void getPortalWaitTime(CallbackInfoReturnable<Integer> cir) {
        LocalDate today = LocalDate.now();
        if (today.getMonth() == Month.APRIL && today.getDayOfMonth() == 1) {
            cir.setReturnValue(abilities.invulnerable ? 1 : 160);
        } else {
            cir.setReturnValue(abilities.invulnerable ? 1 : 40);
        }
    }
}
