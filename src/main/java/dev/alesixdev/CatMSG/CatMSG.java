package dev.alesixdev.CatMSG;

import dev.alesixdev.CatMSG.commands.MainCommand;
import dev.alesixdev.CatMSG.commands.MsgCommand;
import dev.alesixdev.CatMSG.commands.tabcompleter.MainTab;
import dev.alesixdev.CatMSG.commands.tabcompleter.MsgTab;
import dev.alesixdev.CatMSG.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CatMSG extends JavaPlugin {

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

    private void managers() {
        ConfigManager = new ConfigManager(this);
        ConfigManager.loadConfig();
    }

    private void init() {
        Bukkit.getConsoleSender().sendMessage("§a[naMSG] §fPlugin enabled!");
    }

    private void command() {
        getCommand("msg").setExecutor(new MsgCommand(this, ConfigManager));
        getCommand("namsg").setExecutor(new MainCommand(this));

        getCommand("msg").setTabCompleter(new MsgTab(this));
        getCommand("namsg").setTabCompleter(new MainTab(this));
    }
}
