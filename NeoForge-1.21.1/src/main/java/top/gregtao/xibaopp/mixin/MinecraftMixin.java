package top.gregtao.xibaopp.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.sounds.Music;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.gregtao.xibaopp.XibaoPlusPlusConfig;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Inject(method = "getSituationalMusic", at = @At("TAIL"), cancellable = true)
    private void xibao$getSituationalMusic(CallbackInfoReturnable<Music> cir) {
        if (XibaoPlusPlusConfig.playMusic && XibaoPlusPlusConfig.shouldPlayMusic) {
            if (Minecraft.getInstance().screen instanceof DisconnectedScreen) {
                cir.setReturnValue(XibaoPlusPlusConfig.type.music);
            }
        }
    }
}
