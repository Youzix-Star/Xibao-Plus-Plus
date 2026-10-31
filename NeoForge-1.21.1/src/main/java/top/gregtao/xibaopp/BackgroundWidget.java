package top.gregtao.xibaopp;

import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import top.gregtao.xibaopp.util.RenderHelper;

public class BackgroundWidget implements Renderable, GuiEventListener, NarratableEntry {

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        Minecraft client = Minecraft.getInstance();
        Window window = client.getWindow();
        int width = window.getGuiScaledWidth();
        int height = window.getGuiScaledHeight();
        if (XibaoPlusPlusConfig.showPicture) {
            RenderHelper.renderStretchTexture(graphics, width, height, 225,
                    XibaoPlusPlusConfig.type.background);
        }
        if (XibaoPlusPlusConfig.displaySnow || XibaoPlusPlusConfig.tempSnow) {
            SnowAnimation.INSTANCE.tick(graphics, width, height, XibaoPlusPlusConfig.type.snows);
        }
    }

    @Override
    public void setFocused(boolean focused) {
    }

    @Override
    public boolean isFocused() {
        return false;
    }

    @Override
    public NarrationPriority narrationPriority() {
        return NarrationPriority.NONE;
    }

    @Override
    public void updateNarration(NarrationElementOutput output) {
    }
}
