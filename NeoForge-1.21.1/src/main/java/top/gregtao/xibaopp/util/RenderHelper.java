package top.gregtao.xibaopp.util;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

public class RenderHelper {
    public static void renderStretchTexture(GuiGraphics graphics, int width, int height, int light,
                                            ResourceLocation source) {
        graphics.blit(source, 0, 0, width, height, 0.0F, 0.0F, width, height, width, height);
        if (light < 255) {
            int alpha = Math.max(0, Math.min(255, Math.round((1.0F - light / 255.0F) * 255.0F)));
            graphics.fill(0, 0, width, height, alpha << 24);
        }
    }

    public static void renderParticle(GuiGraphics graphics, int x, int y, int width, int height,
                                      ResourceLocation source) {
        graphics.blit(source, x, y, width, height, 0.0F, 0.0F, width, height, width, height);
    }
}
