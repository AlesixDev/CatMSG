package dev.alesixdev.naMSG;

import dev.alesixdev.naMSG.commands.MsgCommand;
import dev.alesixdev.naMSG.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class NaMSG extends JavaPlugin {

    private ConfigManager ConfigManager;

    @Override
    public void onEnable() {
        managers();

        init();

        command();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void managers(){
        ConfigManager = new ConfigManager(this);
        ConfigManager.loadConfig();
    }

    private void init(){
        Bukkit.getConsoleSender().sendMessage("§a[naMSG] §fPlugin enabled!");
    }

    private void command(){
        getCommand("msg").setExecutor(new MsgCommand(this, ConfigManager));
    }
}
