package dev.alesixdev.naMSG.commands;

import dev.alesixdev.naMSG.NaMSG;
import dev.alesixdev.naMSG.manager.ConfigManager;
import dev.alesixdev.naMSG.utils.HexUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MsgCommand implements CommandExecutor {
    private NaMSG plugin;
    private ConfigManager configManager;

    public MsgCommand (NaMSG plugin, ConfigManager configManager){
        this.plugin = plugin;
        this.configManager = configManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage();
            return true;
        }

        Player receiver = Bukkit.getPlayer(args[0]);
        Player send = (Player) sender;



        return false;
    }
}
