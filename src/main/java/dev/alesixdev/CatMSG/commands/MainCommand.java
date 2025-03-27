package dev.alesixdev.CatMSG.commands;

import dev.alesixdev.CatMSG.CatMSG;
import dev.alesixdev.CatMSG.utils.MessageUtil;
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

        Player player = (Player) sender;

        if (args.length < 1) {
            player.sendMessage("");
            player.sendMessage(MessageUtil.TranslateColor("&cCatMSG v1.0.0 by AlesixDev"));
            player.sendMessage("");
            player.sendMessage(MessageUtil.TranslateColor("&f- &6/catmsg reload &f- Reload the plugin configuration"));
            player.sendMessage(MessageUtil.TranslateColor("&f- &6/msg <player> <message> &f- Send a private message to a player"));
            player.sendMessage("");
            return true;

        } else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {

            if (sender.hasPermission("catmsg.reload")) {
                plugin.reloadConfig();
                MessageUtil.config(plugin, sender, "reload");
                return true;

            } else {
                MessageUtil.config(plugin, sender, "nopermission");
                return true;
            }
        } else {
            player.sendMessage("§cInvalid command! Use /catmsg to see the available commands.");
        }
        return false;
    }
}
