package net.naw.scrollwalk.mixin;

import net.minecraft.client.player.AbstractClientPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.naw.scrollwalk.ScrollWalk;

@Mixin(AbstractClientPlayer.class)
public class FovAbstractClientPlayerMixin {

    @Inject(method = "getSpeedFactor", at = @At("RETURN"), cancellable = true)
    private void onGetSpeedFactor(CallbackInfoReturnable<Float> cir) {
        // Check if the FOV change is disabled in config
        if (ScrollWalk.config != null && ScrollWalk.config.disableFovChange) {
            // Force return 1.0F to trick the game into thinking the speed is default,
            // preventing the dynamic FOV from warping or changing
            cir.setReturnValue(1.0F);
        }
    }
}