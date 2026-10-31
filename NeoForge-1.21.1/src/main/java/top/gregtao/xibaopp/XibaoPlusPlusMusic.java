package top.gregtao.xibaopp;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvent;

public class XibaoPlusPlusMusic {
    public static final Holder.Reference<SoundEvent> XIBAO_SOUND_EVENT = register("xibao");
    public static final Music XIBAO_MUSIC = new Music(XIBAO_SOUND_EVENT, 0, 0, true);
    public static final Holder.Reference<SoundEvent> BEIBAO_SOUND_EVENT = register("beibao");
    public static final Music BEIBAO_MUSIC = new Music(BEIBAO_SOUND_EVENT, 0, 0, true);

    private static Holder.Reference<SoundEvent> register(String path) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(XibaoPlusPlusMain.MOD_ID, path);
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id,
                SoundEvent.createVariableRangeEvent(id));
    }
}
