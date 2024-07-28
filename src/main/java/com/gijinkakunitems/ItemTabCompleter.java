package com.gijinkakunitems;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemTabCompleter implements TabCompleter {

    private static final List<String> ITEM_NAMES = Arrays.asList(
            "mythrilbreaker",
            "earthshaper",
            "timbercleaver",
            "shroomblade",
            "chickenshooter",
            "infernobow",
            "tidecallerbow",
            "arcanedetonator",
            "stormstriker",
            "stringofsacrifice",
            "tempestscythe",
            "verdantpurifier",
            "amethyriteedge",
            "bloodrender",
            "sleipnir"
    );

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("give");
        } else if (args.length == 2 && args[0].equalsIgnoreCase("give")) {
            List<String> completions = new ArrayList<>();
            for (String item : ITEM_NAMES) {
                if (item.startsWith(args[1].toLowerCase())) {
                    completions.add(item);
                }
            }
            return completions;
        } else if (args.length == 3 && args[0].equalsIgnoreCase("give")) {
            return null; // Default player name completion
        } else if (args.length == 4 && args[0].equalsIgnoreCase("give")) {
            return Arrays.asList("1", "5", "10", "20", "64");
        }
        return new ArrayList<>();
    }
}
