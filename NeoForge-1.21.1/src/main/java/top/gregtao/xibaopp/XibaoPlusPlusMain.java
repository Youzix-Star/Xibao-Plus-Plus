package top.gregtao.xibaopp;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

/**
 * NeoForge 1.21.1 client entry point.
 */
@Mod(value = XibaoPlusPlusMain.MOD_ID, dist = Dist.CLIENT)
public class XibaoPlusPlusMain {

    public static final String MOD_ID = "xibaopp";

    public XibaoPlusPlusMain(IEventBus modEventBus) {
        // NeoForge freezes the built-in registries before mod construction, so sound
        // events must go through a DeferredRegister instead of Registry.register.
        XibaoPlusPlusMusic.SOUND_EVENTS.register(modEventBus);
        try {
            XibaoPlusPlusConfig.loadConfig();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Xibao++ config", e);
        }
    }
}
