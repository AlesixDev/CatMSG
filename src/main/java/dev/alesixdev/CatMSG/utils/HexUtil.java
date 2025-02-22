package dev.alesixdev.CatMSG.utils;

import dev.alesixdev.CatMSG.CatMSG;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexUtil {

    public static void config(CatMSG plugin, CommandSender sender, String path) {
        String message = plugin.getConfig().getString("messages." + path); //Thanks hhit <3
        sender.sendMessage(TranslateColor(TranslateHexColor(message)));
    }

    public static String TranslateColor(String Text) {
        return ChatColor.translateAlternateColorCodes('&', Text);
    }

    public static final Pattern HEX_PATTERN = Pattern.compile("&#([A-Fa-f0-9]{6})");

    public static String TranslateHexColor(String message) {
        char colorChar = '§';

        Matcher matcher = HEX_PATTERN.matcher(message);
        StringBuffer buffer = new StringBuffer(message.length() + 32);

        while (matcher.find()) {
            String group = matcher.group(1);

            matcher.appendReplacement(buffer, "§x§" + group
                    .charAt(0) + "§" + group.charAt(1) + "§" + group
                    .charAt(2) + "§" + group.charAt(3) + "§" + group
                    .charAt(4) + "§" + group.charAt(5));
        }
        return matcher.appendTail(buffer).toString();
    }
}
