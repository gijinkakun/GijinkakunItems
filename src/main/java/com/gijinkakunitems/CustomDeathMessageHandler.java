package com.gijinkakunitems;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;
import java.util.Map;

public class CustomDeathMessageHandler {

    private static final Map<String, String> customDeathMessages = new HashMap<>();

    static {
        customDeathMessages.put("shroomblade", ChatColor.RED + "%s was cut down by %s with the Shroom Blade.");
        customDeathMessages.put("tempestscythe", ChatColor.BLUE + "%s was swept away by %s with the Tempest Scythe.");
        customDeathMessages.put("bloodrender", ChatColor.DARK_RED + "%s was decapitated by %s with Bloodrender.");
        customDeathMessages.put("mythrilbreaker", ChatColor.DARK_PURPLE + "%s was shattered by %s with Mythrilbreaker.");
        customDeathMessages.put("earthshaper", ChatColor.GREEN + "%s was buried by %s with Earthshaper.");
        customDeathMessages.put("timbercleaver", ChatColor.GOLD + "%s was felled by %s with Timbercleaver.");
        customDeathMessages.put("chickenshooter", ChatColor.YELLOW + "%s was pecked to death by %s with Chicken Shooter.");
        customDeathMessages.put("infernobow", ChatColor.RED + "%s was burned by %s with Inferno Bow.");
        customDeathMessages.put("tidecallerbow", ChatColor.AQUA + "%s drowned by %s with Tidecaller Bow.");
        customDeathMessages.put("arcanedetonator", ChatColor.LIGHT_PURPLE + "%s was blown up by %s with Arcane Detonator.");
        customDeathMessages.put("stormstriker", ChatColor.DARK_BLUE + "%s was struck down by %s with Stormstriker.");
        customDeathMessages.put("amethyriteedge", ChatColor.LIGHT_PURPLE + "%s was sliced by %s with Amethyrite Edge.");
        customDeathMessages.put("verdantpurifier", ChatColor.GREEN + "%s was purified by %s with Verdant Purifier.");
    }

    public static void handleDeathMessage(PlayerDeathEvent event, String itemKey, Player killer) {
        String customMessage = customDeathMessages.get(itemKey);
        if (customMessage != null && killer != null) {
            String deathMessage = String.format(customMessage, event.getEntity().getName(), killer.getName());
            event.setDeathMessage(deathMessage);
        }
    }
}
