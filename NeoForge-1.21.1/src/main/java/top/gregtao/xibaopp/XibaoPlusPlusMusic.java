package top.gregtao.xibaopp;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class XibaoPlusPlusMusic {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, XibaoPlusPlusMain.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> XIBAO_SOUND_EVENT = register("xibao");
    public static final DeferredHolder<SoundEvent, SoundEvent> BEIBAO_SOUND_EVENT = register("beibao");

    private static Music xibaoMusic;
    private static Music beibaoMusic;

    /**
     * The Music instance is cached because {@code MusicManager} expects a stable
     * object while a track is playing.
     */
    public static Music getXibaoMusic() {
        if (xibaoMusic == null) {
            xibaoMusic = new Music(XIBAO_SOUND_EVENT, 0, 0, true);
        }
        return xibaoMusic;
    }

    public static Music getBeibaoMusic() {
        if (beibaoMusic == null) {
            beibaoMusic = new Music(BEIBAO_SOUND_EVENT, 0, 0, true);
        }
        return beibaoMusic;
    }

    private static DeferredHolder<SoundEvent, SoundEvent> register(String path) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(XibaoPlusPlusMain.MOD_ID, path);
        return SOUND_EVENTS.register(path, () -> SoundEvent.createVariableRangeEvent(id));
    }
}
