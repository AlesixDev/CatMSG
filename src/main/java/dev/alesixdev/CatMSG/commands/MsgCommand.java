package dev.alesixdev.CatMSG.commands;

import dev.alesixdev.CatMSG.CatMSG;
import dev.alesixdev.CatMSG.manager.ConfigManager;
import dev.alesixdev.CatMSG.utils.HexUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MsgCommand implements CommandExecutor {
    private final CatMSG plugin;
    private final ConfigManager configManager;

    public MsgCommand (CatMSG plugin, ConfigManager configManager){
        this.plugin = plugin;
        this.configManager = configManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage();
            return true;
        }

        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

        if (args.length < 2){
            sender.sendMessage();
            return true;

        } else if (target == null){
            sender.sendMessage("Error, player not found");
            return true;
        } else {
            StringBuilder message = new StringBuilder();
            for (int i = 1; i < args.length; i++){
                message.append(args[i]).append(" ");
            }

            String msg = HexUtil.TranslateColor(HexUtil.TranslateHexColor("Hola {player}, {target} te ha enviado un mensaje: {message}"))
                    .replace("{player}", player.getName())
                    .replace("{target}", target.getName())
                    .replace("{message}", message.toString());

            player.sendMessage(msg);
            target.sendMessage(msg);
        }



        return false;
    }
}
