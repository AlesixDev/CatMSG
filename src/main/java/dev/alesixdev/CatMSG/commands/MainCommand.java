package dev.alesixdev.CatMSG.commands;

import dev.alesixdev.CatMSG.CatMSG;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {

    private final CatMSG plugin;

    public MainCommand(CatMSG plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage("");
            return true;

        }

        if (args.length < 1) {
            sender.sendMessage("Error, sin argumentos");
            return true;

        } else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (sender.hasPermission("namsg.reload")) {
                plugin.reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "Configuración recargada");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "No tienes permisos para ejecutar este comando");
                return true;
            }
        }
        return false;
    }
}
