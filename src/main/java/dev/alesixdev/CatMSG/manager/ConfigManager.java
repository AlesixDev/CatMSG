package dev.alesixdev.CatMSG.manager;

import dev.alesixdev.CatMSG.CatMSG;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

    private final Config configFile;

    public ConfigManager(CatMSG plugin) {
        configFile = new Config("config.yml", null, plugin);
        configFile.registerConfig();
        loadConfig();
    }

    public void loadConfig(){
        FileConfiguration configuration = configFile.getConfig();
    }

    public void reloadConfig(){
        configFile.reloadConfig();
        loadConfig();
    }
}

// I know, my code is crap, but well, it is what it is :D
// Special thanks to: hhit, Nay and Redactado