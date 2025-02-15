package dev.alesixdev.naMSG.manager;

import dev.alesixdev.naMSG.NaMSG;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

    private final Config configFile;

    public ConfigManager(NaMSG plugin) {
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
