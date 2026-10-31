package top.gregtao.xibaopp.mixin;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.gregtao.xibaopp.BackgroundWidget;
import top.gregtao.xibaopp.SnowAnimation;
import top.gregtao.xibaopp.XibaoPlusPlusConfig;

@Mixin(DisconnectedScreen.class)
public class DisconnectedScreenMixin extends Screen {

    protected DisconnectedScreenMixin(Component title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void xibao$init(CallbackInfo ci) {
        XibaoPlusPlusConfig.shouldPlayMusic = true;
        XibaoPlusPlusConfig.tempSnow = false;
        this.addRenderableWidget(Button.builder(Component.translatable("gui.stopMusic"),
                button -> XibaoPlusPlusConfig.shouldPlayMusic = !XibaoPlusPlusConfig.shouldPlayMusic)
                .bounds(this.width / 2 - 100, this.height - 22, 66, 20).build());
        this.addRenderableWidget(Button.builder(Component.translatable("gui.dropSnow"),
                button -> {
                    SnowAnimation.INSTANCE = new SnowAnimation(XibaoPlusPlusConfig.random);
                    XibaoPlusPlusConfig.tempSnow = !XibaoPlusPlusConfig.tempSnow;
                }).bounds(this.width / 2 - 33, this.height - 22, 66, 20).build());
        this.addRenderableWidget(Button.builder(Component.translatable("gui.switchAlbum"),
                button -> XibaoPlusPlusConfig.switchAlbum())
                .bounds(this.width / 2 + 34, this.height - 22, 66, 20).build());
        if (XibaoPlusPlusConfig.displaySnow) {
            SnowAnimation.INSTANCE = new SnowAnimation(XibaoPlusPlusConfig.random);
        }
        this.addRenderableWidget(new BackgroundWidget());
    }
}
