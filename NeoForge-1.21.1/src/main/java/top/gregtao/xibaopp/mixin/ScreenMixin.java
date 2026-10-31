package top.gregtao.xibaopp.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public abstract class ScreenMixin {

    @Inject(method = "renderBackground(Lnet/minecraft/client/gui/GuiGraphics;IIF)V",
            at = @At("HEAD"), cancellable = true)
    private void xibao$renderBackground(GuiGraphics graphics, int mouseX, int mouseY, float partialTick,
                                        CallbackInfo ci) {
        if (Minecraft.getInstance().screen instanceof DisconnectedScreen) {
            ci.cancel();
        }
    }
}
