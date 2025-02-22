package dev.alesixdev.CatMSG.commands.tabcompleter;

import dev.alesixdev.CatMSG.CatMSG;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

public class MainTab implements TabCompleter {
    private final CatMSG plugin;

    public MainTab(CatMSG plugin) {
        this.plugin = plugin;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("namsg")) {
            if (args.length == 1) {
                return Arrays.asList("reload");
            }
        }
        return null;
    }
}
