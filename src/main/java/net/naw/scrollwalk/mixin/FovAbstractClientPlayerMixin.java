package net.naw.scrollwalk.mixin;

import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.naw.scrollwalk.ScrollWalk;

@Mixin(GameRenderer.class)
public class FovAbstractClientPlayerMixin {

    @Inject(method = "getFov", at = @At("RETURN"), cancellable = true)
    private void onGetFov(CallbackInfoReturnable<Double> cir) {
        // Если тумблер включен, мы можем принудительно контролировать FOV прямо на этапе рендера камеры
        if (ScrollWalk.config != null && ScrollWalk.config.disableFovChange) {
            // Здесь можно оставить стандартное значение или вернуть дефолт, но так как нам нужно просто заблокировать изменения динамического FOV,
            // давай проверим, как игра поведет себя, если мы внедримся в сам расчет FOV игрока через GameRenderer
        }
    }
}
