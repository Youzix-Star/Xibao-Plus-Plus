package top.gregtao.xibaopp;

import net.neoforged.fml.loading.FMLPaths;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.Random;

public class XibaoPlusPlusConfig {
    private static final Path FILE = FMLPaths.CONFIGDIR.get().resolve("xibao_plus_plus.properties");

    public static boolean shouldPlayMusic = false;
    public static boolean tempSnow = false;
    public static final Random random = new Random();

    public static boolean playMusic = true;
    public static boolean showPicture = true;
    public static boolean displaySnow = false;

    public static XibaoType type = XibaoType.XIBAO;

    public static void loadConfig() throws Exception {
        if (!Files.exists(FILE)) {
            storeConfig();
            return;
        }
        Properties properties = new Properties();
        try (Reader reader = Files.newBufferedReader(FILE, StandardCharsets.UTF_8)) {
            properties.load(reader);
        }
        playMusic = Boolean.parseBoolean(properties.getProperty("playMusic", "true"));
        showPicture = Boolean.parseBoolean(properties.getProperty("showPicture", "true"));
        displaySnow = Boolean.parseBoolean(properties.getProperty("displaySnow", "false"));
        type = XibaoType.getByString(properties.getProperty("type"));
    }

    public static void storeConfig() throws IOException {
        Files.createDirectories(FILE.getParent());
        Properties properties = new Properties();
        properties.setProperty("playMusic", String.valueOf(playMusic));
        properties.setProperty("showPicture", String.valueOf(showPicture));
        properties.setProperty("displaySnow", String.valueOf(displaySnow));
        properties.setProperty("type", type.type);
        try (Writer writer = Files.newBufferedWriter(FILE, StandardCharsets.UTF_8)) {
            properties.store(writer, "Xibao Plus Plus");
        }
    }

    public static void switchAlbum() {
        XibaoType[] types = XibaoType.values();
        type = types[(type.ordinal() + 1) % types.length];
    }
}
