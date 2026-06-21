package net.naw.scrollwalk.mixin;

import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.naw.scrollwalk.ScrollWalk;

@Mixin(LocalPlayer.class)
public class FovAbstractClientPlayerMixin {

    // В маппингах Mojang для LocalPlayer этот метод часто доступен напрямую
    @Inject(method = "getFovMultiplier", at = @At("RETURN"), cancellable = true)
    private void onGetFovMultiplier(CallbackInfoReturnable<Float> cir) {
        if (ScrollWalk.config != null && ScrollWalk.config.disableFovChange) {
            cir.setReturnValue(1.0F);
        }
    }
}
