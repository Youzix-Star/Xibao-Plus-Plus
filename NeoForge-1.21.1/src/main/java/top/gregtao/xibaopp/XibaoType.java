package top.gregtao.xibaopp;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;

import java.util.function.Supplier;

public enum XibaoType {
    XIBAO(
            XibaoPlusPlusMusic::getXibaoMusic,
            ResourceLocation.fromNamespaceAndPath(XibaoPlusPlusMain.MOD_ID, "textures/xibao.png"),
            new ResourceLocation[] {
                    ResourceLocation.fromNamespaceAndPath(XibaoPlusPlusMain.MOD_ID, "textures/yellow_snow.png"),
                    ResourceLocation.fromNamespaceAndPath(XibaoPlusPlusMain.MOD_ID, "textures/red_snow.png")
            },
            "xibao"
    ),
    BEIBAO(
            XibaoPlusPlusMusic::getBeibaoMusic,
            ResourceLocation.fromNamespaceAndPath(XibaoPlusPlusMain.MOD_ID, "textures/beibao.png"),
            new ResourceLocation[] {
                    ResourceLocation.fromNamespaceAndPath(XibaoPlusPlusMain.MOD_ID, "textures/white_snow.png")
            },
            "beibao"
    );

    public final Supplier<Music> music;
    public final ResourceLocation background;
    public final ResourceLocation[] snows;
    public final String type;

    XibaoType(Supplier<Music> music, ResourceLocation background, ResourceLocation[] snows, String type) {
        this.music = music;
        this.background = background;
        this.snows = snows;
        this.type = type;
    }

    public static XibaoType getByString(String type) {
        for (XibaoType xibaoType : values()) {
            if (xibaoType.type.equals(type)) return xibaoType;
        }
        return XIBAO;
    }
}
