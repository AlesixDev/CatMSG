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
        Bukkit.getConsoleSender().sendMessage("§a[CatMSG] §fPlugin enabled!");

        managers();
        command();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§a[CatMSG] §fPlugin disabled!");
    }

    private void managers() {
        ConfigManager = new ConfigManager(this);
        ConfigManager.loadConfig();
    }

    private void command() {
        getCommand("msg").setExecutor(new MsgCommand(this));
        getCommand("catmsg").setExecutor(new MainCommand(this));
        getCommand("msg").setTabCompleter(new MsgTab(this));
        getCommand("catmsg").setTabCompleter(new MainTab(this));
    }
}
