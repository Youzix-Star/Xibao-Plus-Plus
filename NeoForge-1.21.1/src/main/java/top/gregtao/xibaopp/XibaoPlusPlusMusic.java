package top.gregtao.xibaopp;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class XibaoPlusPlusMusic {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, XibaoPlusPlusMain.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> XIBAO_SOUND_EVENT = register("xibao");
    public static final Supplier<Music> XIBAO_MUSIC =
            () -> new Music(XIBAO_SOUND_EVENT, 0, 0, true);
    public static final DeferredHolder<SoundEvent, SoundEvent> BEIBAO_SOUND_EVENT = register("beibao");
    public static final Supplier<Music> BEIBAO_MUSIC =
            () -> new Music(BEIBAO_SOUND_EVENT, 0, 0, true);

    private static DeferredHolder<SoundEvent, SoundEvent> register(String path) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(XibaoPlusPlusMain.MOD_ID, path);
        return SOUND_EVENTS.register(path, () -> SoundEvent.createVariableRangeEvent(id));
    }
}
