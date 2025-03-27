package dev.alesixdev.CatMSG.commands;

import dev.alesixdev.CatMSG.CatMSG;
import dev.alesixdev.CatMSG.utils.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MsgCommand implements CommandExecutor {
    private final CatMSG plugin;

    public MsgCommand (CatMSG plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "This command can only be executed by a player!");
            return true;
        }

        Player psender = (Player) sender;
        Player ptarget = Bukkit.getPlayer(args[0]);


        if (args.length < 2){
            MessageUtil.config(plugin, sender, "usage");
            return true;

        } else if (ptarget == null){
            MessageUtil.config(plugin, sender, "playernotfound");
            return true;

        } else if (psender == ptarget){
            MessageUtil.config(plugin, sender, "senderisplayer");
            return true;

        } else {

            StringBuilder message = new StringBuilder();
            for (int i = 1; i < args.length; i++){
                message.append(args[i]).append(" ");
            }

            String SenderMSG = MessageUtil.TranslateColor(MessageUtil.TranslateHexColor(plugin.getConfig().getString("msg.sender")))
                    .replace("{player}", psender.getName())
                    .replace("{target}", ptarget.getName())
                    .replace("{message}", message.toString());

            String TargetMSG = MessageUtil.TranslateColor(MessageUtil.TranslateHexColor(plugin.getConfig().getString("msg.target")))
                    .replace("{player}", psender.getName())
                    .replace("{target}", ptarget.getName())
                    .replace("{message}", message.toString());

            psender.sendMessage(SenderMSG);
            ptarget.sendMessage(TargetMSG);
        }

        return false;
    }
}
