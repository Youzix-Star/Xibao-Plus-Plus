package top.gregtao.xibaopp;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

/**
 * NeoForge 1.21.1 client entry point.
 */
@Mod(value = XibaoPlusPlusMain.MOD_ID, dist = Dist.CLIENT)
public class XibaoPlusPlusMain {

    public static final String MOD_ID = "xibaopp";

    public XibaoPlusPlusMain() {
        try {
            XibaoPlusPlusConfig.loadConfig();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Xibao++ config", e);
        }
    }
}
