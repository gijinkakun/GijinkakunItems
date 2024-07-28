package com.gijinkakunitems;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.gijinkakunitems.items.*;

public class CommandHandler {

    public static boolean handleCommand(GijinkakunItems plugin, CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("gijinkakunitems") && args.length == 4 && args[0].equalsIgnoreCase("give")) {
            String itemType = args[1];
            String playerName = args[2];
            int amount;

            try {
                amount = Integer.parseInt(args[3]);
            } catch (NumberFormatException e) {
                sender.sendMessage(ChatColor.RED + "Amount must be a number.");
                return false;
            }

            Player player = Bukkit.getPlayer(playerName);
            if (player == null) {
                sender.sendMessage(ChatColor.RED + "Player not found.");
                return false;
            }

            ItemStack item = null;
            switch (itemType.toLowerCase()) {
                case "mythrilbreaker":
                    item = Mythrilbreaker.create(plugin);
                    break;
                case "earthshaper":
                    item = Earthshaper.create(plugin);
                    break;
                case "timbercleaver":
                    item = Timbercleaver.create(plugin);
                    break;
                case "shroomblade":
                    item = ShroomBlade.create(plugin);
                    break;
                case "chickenshooter":
                    item = ChickenShooter.create(plugin);
                    break;
                case "infernobow":
                    item = InfernoBow.create(plugin);
                    break;
                case "tidecallerbow":
                    item = TidecallerBow.create(plugin);
                    break;
                case "arcanedetonator":
                    item = ArcaneDetonator.create(plugin);
                    break;
                case "stormstriker":
                    item = Stormstriker.create(plugin);
                    break;
                case "stringofsacrifice":
                    item = StringOfSacrifice.create(plugin);
                    break;
                case "tempestscythe":
                    item = TempestScythe.create(plugin);
                    break;
                case "verdantpurifier":
                    item = VerdantPurifier.create(plugin);
                    break;
                case "amethyriteedge":
                    item = AmethyriteEdge.create(plugin);
                    break;
                case "bloodrender":
                    item = Bloodrender.create(plugin);
                    break;
                case "sleipnir":
                    item = Sleipnir.create(plugin);
                    break;
                default:
                    sender.sendMessage(ChatColor.RED + "Unknown item type.");
                    return false;
            }

            item.setAmount(amount);
            player.getInventory().addItem(item);
            player.sendMessage(ChatColor.GREEN + "You have been given " + amount + " " + itemType + "(s)!");
            return true;
        }

        return false;
    }
}
